package dev.julianm.water

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.julianm.water.data.LocalDatabase
import dev.julianm.water.data.WaterRepository
import dev.julianm.water.ui.theme.WaterTrackerForHealthConnectTheme
import dev.julianm.water.ui.view.WaterTrackerScreen
import dev.julianm.water.ui.view.WaterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val waterDao = LocalDatabase.getDatabase(this).waterDao()
        val waterRepository = WaterRepository(waterDao)
        val viewModel = WaterViewModel(waterRepository)
        setContent {
            WaterTrackerForHealthConnectTheme {
                WaterTrackerScreen(viewModel)
            }
        }
    }
}