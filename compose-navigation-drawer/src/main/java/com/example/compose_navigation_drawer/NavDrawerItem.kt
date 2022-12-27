package com.example.compose_navigation_drawer

sealed class NavDrawerItem(var title: String, var icon : Int, var screenRoute:String){
    object Home : NavDrawerItem("Home",R.drawable.ic_baseline_home_24,"home")
    object Network : NavDrawerItem("My Network",R.drawable.ic_baseline_supervisor_account_24,"network")
    object AddPost : NavDrawerItem("Post",R.drawable.ic_baseline_add_24,"addPost")
    object Notification : NavDrawerItem("Notification",R.drawable.ic_baseline_notifications_24,"notification")
    object Jobs : NavDrawerItem("Jobs",R.drawable.ic_baseline_business_center_24,"jobs")
}
