package cat.dam.gerard.app.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.dam.gerard.app.ui.theme.AppTheme

@Composable
fun Layout1() {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(9) { index ->
                Text(
                    text = "${index + 1}",
                    modifier = Modifier
                        .background(Color.Magenta)
                        .padding(8.dp)
                        .width(100.dp)
                        .height(200.dp)
                        .wrapContentSize(Alignment.Center),
                    color = Color.White,
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat(3) { rowIndex ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    repeat(3) { columnIndex ->
                        val number = rowIndex * 3 + columnIndex + 1
                        Text(
                            text = "$number",
                            modifier = Modifier
                                .background(Color.Magenta)
                                .padding(8.dp)
                                .width(100.dp)
                                .height(200.dp)
                                .wrapContentSize(Alignment.Center),
                            color = Color.White,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLayout1() {
    AppTheme {
        Layout1()
    }
}
