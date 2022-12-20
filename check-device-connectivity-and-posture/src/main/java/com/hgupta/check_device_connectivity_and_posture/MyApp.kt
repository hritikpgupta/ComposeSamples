package com.hgupta.check_device_connectivity_and_posture

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hgupta.check_device_connectivity_and_posture.ui.views.home.Home
import com.hgupta.check_device_connectivity_and_posture.ui.views.settings.Settings
import com.hgupta.check_device_connectivity_and_posture.utils.DevicePosture
import kotlinx.coroutines.flow.StateFlow


@Composable
fun MyApp(
    devicePosture: StateFlow<DevicePosture>, appState: MyAppState = rememberMyAppState()
) {
    if (appState.isOnline) {
        NavHost(navController = appState.navController, startDestination = Screen.Home.route ){
            composable(Screen.Home.route) {
                Home()
            }
            composable(Screen.Settings.route){
                Settings()
            }
        }

    } else {
        OfflineDialog { appState.refreshOnline() }
    }

}

@Composable
fun OfflineDialog(onRetry: () -> Unit) {

    AlertDialog(onDismissRequest = {},
        title = { Text(text = stringResource(R.string.connection_error_title)) },
        text = { Text(text = stringResource(R.string.connection_error_message)) },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(stringResource(R.string.retry_label))
            }
        })
}