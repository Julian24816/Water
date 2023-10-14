package dev.julianm.water

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.julianm.water.ui.theme.WaterTrackerForHealthConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterTrackerForHealthConnectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WaterTracker(WaterViewModel(WaterRepository(FallbackWaterSource())))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterTrackerPreview() {
    WaterTrackerForHealthConnectTheme {
        WaterTracker(WaterViewModel(WaterRepository(FallbackWaterSource())))
    }
}