package com.example.contenedor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contenedor.ui.theme.MyApplicationTheme

class MainActivityContenedores : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MiComposable(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MiComposable(modifier: Modifier = Modifier) {
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
//        Text(
//            text = "Hello!",
//            modifier = modifier.background(Color.Red).fillMaxSize().weight(1f)
//        )
//        Text(
//            text = "Hello 2!",
//            modifier = modifier.background(MaterialTheme.colorScheme.secondary).fillMaxSize().weight(1f)
//        )
//        Text(
//            text = "Hello 3!",
//            modifier = modifier.background(Color.Blue).fillMaxSize().weight(1f)
//        )
//    }


//    Row(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = "Hello!",
//            modifier = modifier.background(Color.Red)
//        )
//        Text(
//            text = "Hello 2!",
//            modifier = modifier.background(MaterialTheme.colorScheme.secondary)
//        )
//        Text(
//            text = "Hello 3!",
//            modifier = modifier.background(Color.Blue)
//        )
//    }

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//        repeat(30) { i ->
//            Text(
//                text = "Elemento $i",
//                modifier = Modifier.padding(8.dp)
//            )
//        }
//    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        repeat(30) { i ->
            Text(
                text = "Elemento $i",
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MiComposablePreview() {
    MyApplicationTheme {
        MiComposable()
    }
}