package com.hgupta.compose_bottom_navigation

sealed class BottomNavItem(var title: String, var icon : Int, var screenRoute:String){
    object Home : BottomNavItem("Home",R.drawable.ic_baseline_home_24,"home")
    object Network : BottomNavItem("My Network",R.drawable.ic_baseline_supervisor_account_24,"network")
    object AddPost : BottomNavItem("Post",R.drawable.ic_baseline_add_24,"addPost")
    object Notification : BottomNavItem("Notification",R.drawable.ic_baseline_notifications_24,"notification")
    object Jobs : BottomNavItem("Jobs",R.drawable.ic_baseline_business_center_24,"jobs")
}
