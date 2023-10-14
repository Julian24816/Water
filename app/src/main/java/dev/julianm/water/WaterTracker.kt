package dev.julianm.water

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WaterTracker(viewModel: WaterViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState) {
        WaterUiState.Loading -> Text(text = "Loading")
        is WaterUiState.Success -> {
            val success = uiState as WaterUiState.Success
            WaterTracker(success.mlToday, onDrinkGlass = viewModel::drinkGlass)
        }
    }
}

@Composable
fun WaterTracker(mlToday: Int, onDrinkGlass: () -> Unit) {
    Row {
        Text(text = "Today you drank $mlToday ml of water")
        Button(onClick = onDrinkGlass) {
            Text(text = "Drink a glass")
        }
    }
}