package info.fekri.githubusers.ui.features.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.navigation.getNavViewModel
import info.fekri.githubusers.R
import info.fekri.githubusers.ui.theme.GithubUsersTheme
import info.fekri.githubusers.ui.theme.GrayDark
import info.fekri.githubusers.ui.theme.ItemBackground
import info.fekri.githubusers.ui.theme.Shapes
import info.fekri.githubusers.ui.theme.TextColor

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    GithubUsersTheme {
        Surface(color = ItemBackground, modifier = Modifier.fillMaxSize()) {
            PopularItemSetup()
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val navigation = getNavController()
    val viewModel = getNavViewModel<MainViewModel>()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PopularItemSetup()
    }

}

@Composable
fun PopularItemSetup() {

    LazyColumn {
        items(10) {
            PopularItem()
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PopularItem() {

    Card(
        onClick = {},
        shape = Shapes.medium,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(100.dp)
            .padding(vertical = 4.dp),
        backgroundColor = GrayDark,
        elevation = 4.dp
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_person),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(Shapes.medium),
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.width(4.dp))

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(start = 6.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Developer name",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "@developer_id",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = TextColor
                    )
                )

                Text(
                    text = "Developer desc",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )

            }

        }

    }

}
