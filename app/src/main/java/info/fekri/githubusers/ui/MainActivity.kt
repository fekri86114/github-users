package info.fekri.githubusers.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.KoinNavHost
import info.fekri.githubusers.di.myModules
import info.fekri.githubusers.ui.features.main.MainScreen
import info.fekri.githubusers.ui.theme.GithubUsersTheme
import info.fekri.githubusers.ui.theme.GrayDark
import info.fekri.githubusers.ui.theme.GrayLight
import info.fekri.githubusers.util.KEY_DETAIL_SCREEN
import info.fekri.githubusers.util.MyScreens
import org.koin.android.ext.koin.androidContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            Koin(appDeclaration = {
                androidContext(this@MainActivity)
                modules(myModules)
            }) {
                GithubUsersTheme {
                    Surface(color = GrayDark, modifier = Modifier.fillMaxSize()) {
                        MainGithubUsersUI()
                    }
                }
            }
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    GithubUsersTheme {
        Surface(color = GrayLight, modifier = Modifier.fillMaxSize()) {
            MainGithubUsersUI()
        }
    }
}

@Composable
fun MainGithubUsersUI() {
    val navController = rememberNavController()
    val context = LocalContext.current

    KoinNavHost(navController = navController, startDestination = MyScreens.MainScreen.route) {

        composable(route = MyScreens.StartScreen.route) {
            StartScreen()
        }

        composable(route = MyScreens.MainScreen.route) {
            MainScreen()
        }
        composable(
            route = MyScreens.DetailScreen.route + "/{$KEY_DETAIL_SCREEN}",
            arguments = listOf(navArgument(KEY_DETAIL_SCREEN){
                type = NavType.StringType
            })
        ) {
            DetailScreen(it.arguments!!.getString(KEY_DETAIL_SCREEN, "null"))
        }
        composable(route = MyScreens.SearchScreen.route) {
            SearchScreen()
        }
    }

}

@Composable
fun SearchScreen() {

}

@Composable
fun DetailScreen(id: String?) {
}

@Composable
fun StartScreen() {

}
