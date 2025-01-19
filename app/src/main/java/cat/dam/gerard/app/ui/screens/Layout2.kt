package cat.dam.gerard.app.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.dam.gerard.app.ui.theme.AppTheme
import cat.dam.gerard.app.ui.theme.Navy

@Composable
fun Layout2() {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(4) { columnIndex ->
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                ) {
                    val buttons = when (columnIndex) {
                        0 -> listOf("9", "4", "1", ".")
                        1 -> listOf("8", "5", "2", "0")
                        2 -> listOf("7", "6", "3", "=")
                        else -> listOf("%", "X", "X", "+")
                    }
                    buttons.forEach { text ->
                        Text(
                            text = text,
                            modifier = Modifier
                                .background(if (text in listOf("%", "X", "+")) Red else Navy)
                                .padding(8.dp)
                                .width(85.dp)
                                .height(214.dp)
                                .wrapContentSize(Alignment.Center),
                            color = Color.White
                        )
                    }
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            listOf(
                listOf("9", "8", "7", "%"),
                listOf("4", "5", "6", "X"),
                listOf("1", "2", "3", "X"),
                listOf(".", "0", "=", "+")
            ).forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp),
                ) {
                    row.forEach { text ->
                        Text(
                            text = text,
                            modifier = Modifier
                                .background(if (text in listOf("%", "X", "+",)) Red else Navy)
                                .padding(8.dp)
                                .width(85.dp)
                                .height(214.dp)
                                .wrapContentSize(Alignment.Center),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Layout2Preview() {
    AppTheme {
        Layout2()
    }
}
