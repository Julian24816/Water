package dev.julianm.water.ui.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import dev.julianm.water.ui.theme.WaterTrackerForHealthConnectTheme

@Composable
fun WaterInfoRow(mlTotal: Int, onDrinkGlass: () -> Unit) {
    Row {
        Text(text = "You drank $mlTotal ml of water in total")
        Button(onClick = onDrinkGlass) {
            Text(text = "Drink a glass")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterTrackerPreview() {
    WaterTrackerForHealthConnectTheme {
        var ml by remember { mutableIntStateOf(0) }
        WaterInfoRow(ml, onDrinkGlass = { ml += 250})
    }
}