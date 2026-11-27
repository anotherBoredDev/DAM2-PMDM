package com.example.contador

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contador.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("CONTADOR", "onCreate")
        setContent {
            PantallaContador()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("CONTADOR", "onResume")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CONTADOR", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CONTADOR", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CONTADOR", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("CONTADOR", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CONTADOR", "onDestroy")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaContadorPreview() {
    PantallaContador()
}

@Composable
fun PantallaContador() {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                var contador by rememberSaveable { mutableIntStateOf(0) }
                var pulsaciones by rememberSaveable { mutableIntStateOf(0) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Contador de Alejandro G.",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text(
                        text = contador.toString(),
                        style = MaterialTheme.typography.displayLarge,
                        color = if (contador < 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onBackground
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = {
                                pulsaciones++
                                contador--
                            }
                        ) {
                            Text("Restar")
                        }

                        Button(
                            onClick = {
                                pulsaciones++
                                contador++
                            }
                        ) {
                            Text("Sumar")
                        }
                    }

                    OutlinedButton(
                        onClick = {
                            pulsaciones++
                            contador = 0
                        }
                    ) {
                        Text("Reiniciar")
                    }

                    Text("Pulsaciones de Alejandro G.: $pulsaciones")
                }
            }
        }
    }
}