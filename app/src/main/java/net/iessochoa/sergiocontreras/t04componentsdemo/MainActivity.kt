package net.iessochoa.sergiocontreras.t04componentsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import net.iessochoa.sergiocontreras.t04componentsdemo.ui.T04ComponentsDemoApp
import net.iessochoa.sergiocontreras.t04componentsdemo.ui.theme.T04ComponentsDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T04ComponentsDemoApp()
        }
    }
}
