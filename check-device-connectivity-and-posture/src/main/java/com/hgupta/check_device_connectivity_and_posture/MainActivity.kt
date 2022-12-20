package com.hgupta.check_device_connectivity_and_posture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker.Companion.getOrCreate
import com.hgupta.check_device_connectivity_and_posture.ui.theme.ComposeSamplesTheme
import com.hgupta.check_device_connectivity_and_posture.utils.DevicePosture
import com.hgupta.check_device_connectivity_and_posture.utils.isBookPosture
import com.hgupta.check_device_connectivity_and_posture.utils.isSeparatingPosture
import com.hgupta.check_device_connectivity_and_posture.utils.isTableTopPosture
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        /**
         * Flow of [DevicePosture] that emits every time there's a change in the windowLayoutInfo
         */
        val devicePosture =
            getOrCreate(this).windowLayoutInfo(this).flowWithLifecycle(this.lifecycle)
                .map { layoutInfo ->
                    val foldingFeature =
                        layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
                    when {
                        isTableTopPosture(foldingFeature) -> DevicePosture.TableTopPosture(
                            foldingFeature.bounds
                        )
                        isBookPosture(foldingFeature) -> DevicePosture.BookPosture(foldingFeature.bounds)
                        isSeparatingPosture(foldingFeature) -> DevicePosture.SeparatingPosture(
                            foldingFeature.bounds, foldingFeature.orientation
                        )
                        else -> DevicePosture.NormalPosture
                    }
                }.stateIn(
                    scope = lifecycleScope,
                    started = SharingStarted.Eagerly,
                    initialValue = DevicePosture.NormalPosture
                )

        setContent {
            ComposeSamplesTheme {
                MyApp(devicePosture = devicePosture)
            }
        }
    }
}
