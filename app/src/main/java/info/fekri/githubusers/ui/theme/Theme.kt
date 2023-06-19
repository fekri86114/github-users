package info.fekri.githubusers.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColors = lightColors(
    primary = GrayDark,
    secondary = GrayLight,
    background = ItemBackground
)

@Composable
fun GithubUsersTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        typography = Typography,
        content = content,
        shapes = Shapes
    )

    val uiController = rememberSystemUiController()
    uiController.setStatusBarColor(GrayLight)
    uiController.setNavigationBarColor(ItemBackground)
}