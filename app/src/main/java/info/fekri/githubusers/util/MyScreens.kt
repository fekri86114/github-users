package info.fekri.githubusers.util

sealed class MyScreens(val route: String) {
    object StartScreen: MyScreens("startScreen")
    object MainScreen: MyScreens("mainScreen")
    object SearchScreen: MyScreens("searchScreen")
    object DetailScreen: MyScreens("detailScreen")
}
