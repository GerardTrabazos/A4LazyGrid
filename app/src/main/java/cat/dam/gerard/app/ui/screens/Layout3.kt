package cat.dam.gerard.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.dam.gerard.app.ui.theme.AppTheme
import cat.dam.gerard.app.ui.theme.Blue

@Composable
fun Layout3() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue)
    ) {
        val tableData = listOf(
            listOf("No.", "Product", "Category", "Price"),
            listOf("1", "Apple", "Fruits", "200"),
            listOf("2", "Orange", "Fruits", "100"),
            listOf("3", "Tomato", "Fruits", "50"),
            listOf("4", "Carrot", "Vegetables", "80"),
            listOf("5", "Potato", "Vegetables", "40"),
        )

        tableData.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (rowIndex == 0) Color.Blue else Color.White)
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEachIndexed { columnIndex, cell ->
                    Text(
                        text = cell,
                        modifier = Modifier
                            .weight(
                                if (columnIndex == 0) 0.5f // La primera columna es la mes estreta
                                else 1f,
                            )
                            .padding(4.dp)
                            .wrapContentHeight(Alignment.CenterVertically),
                        color = if (rowIndex == 0) White else Color.Black,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Layout3Preview() {
    AppTheme {
        Layout3()
    }
}
