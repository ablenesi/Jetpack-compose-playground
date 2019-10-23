import android.app.Activity
import android.os.Bundle
import androidx.compose.*
import androidx.ui.core.setContent
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.ExpandedHeight
import androidx.ui.layout.Spacing
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import com.example.myapplication.R

class AppState(val counterState: CounterState = CounterState())

@Model
class CounterState(var count: Int = 0)

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(child: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = +themeColor { surface }) {
            child()
        }
    }
}

@Composable
fun MyScreenContent(appState: AppState = AppState()) {
    val image = +vectorResource(R.drawable.ic_launcher_background)

    Column(modifier = ExpandedHeight, crossAxisAlignment = CrossAxisAlignment.Center) {
        Column(modifier = Flexible(1f), crossAxisAlignment = CrossAxisAlignment.Center) {
            Divider(color = Color.Black)
            DrawVector(vectorImage = image)
            Greeting("there")
        }
        Counter(appState.counterState)
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(text = "I've been clicked ${state.count} times",
        onClick = {
            state.count++
        }
    )
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Spacing(24.dp),
        style = +themeTextStyle { h1 }
    )
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}

/// Unit step 4
//package com.example.myapplication
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.Composable
//import androidx.compose.Model
//import androidx.core.content.ContextCompat
//import androidx.ui.core.Text
//import androidx.ui.core.dp
//import androidx.ui.core.setContent
//import androidx.ui.graphics.Color
//import androidx.ui.layout.Column
//import androidx.ui.layout.CrossAxisAlignment
//import androidx.ui.layout.Spacing
//import androidx.ui.material.Button
//import androidx.ui.material.ContainedButtonStyle
//import androidx.ui.material.Divider
//import androidx.ui.material.MaterialTheme
//import androidx.ui.material.surface.Surface
//import androidx.ui.tooling.preview.Preview
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApp {
//                MyScreenContent()
//            }
//        }
//    }
//}
//
//// TODO what does Build and refresh do?? does it need to build the whole app for the privew?
//@Composable
//fun Greeting(name: String) {
//    Surface(color = Color.Green) {
//        // TODO how can I use resources ???
//        // Text(text = "Hello $name!", modifier = Spacing(R.dimen.padding))
//        Text(text = "Hello $name!", modifier = Spacing(24.dp))
//    }
//}
//
//@Preview("MyScreen preview")
//@Composable
//fun DefaultPreview() {
//    MyApp {
//        MyScreenContent()
//    }
//}
//
//@Composable
//fun MyApp(child: @Composable() () -> Unit) {
//    MaterialTheme {
//        Surface(color = Color.Yellow) {
//            child()
//        }
//    }
//}
//val myNames = listOf("Manuel", "Nick", "Jose", "Florina", "Yacine")
//
//@Composable
//fun MyScreenContent() {
//    Column(crossAxisAlignment = CrossAxisAlignment.Center) {
//        for (name in myNames) {
//            Greeting(name)
//            Divider(color = Color.Gray)
//        }
//        EnabledButton(text = "OMG", enabled = true)
//    }
//}
//
//@Composable
//fun EnabledButton(text: String, enabled: Boolean) {
//    Button(
//        text = text,
//        style = ContainedButtonStyle(
//            color = if (enabled) Color.White else Color.Gray
//        )
//    )
//}
//
//
//// Simplified version of a typical AppState
//class AppState(val counterState: CounterState = CounterState())
//
//@Model
//class CounterState(var count: Int = 0)
