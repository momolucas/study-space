package momolucas.alura_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class AluraComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    momolucas.alura_compose.ui.theme.StudySamplesTheme {
        Surface {
            momolucas.alura_compose.ui.screens.HomeScreen()
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}


