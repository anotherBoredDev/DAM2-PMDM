package com.example.ejercicioaula1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicioaula1.ui.theme.EjercicioAula1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioAula1Theme {
                Pantalla()
            }
        }
    }
}

@Composable
fun Pantalla() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            CabeceraEjemplos(modifier = Modifier.padding(innerPadding))
            Ejemplos()
        }
    }
}

@Composable
fun Ejemplos(modifier: Modifier = Modifier) {
    EjemploCambiarColor()
    Spacer(modifier = Modifier.height(16.dp))
    EjemploCambiarTamano(modifier = modifier)
    Spacer(modifier = Modifier.height(16.dp))
    EjemploCambiarEstilo()
}

@Composable
fun CabeceraEjemplos(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Ejemplos",
            modifier = modifier,
            fontFamily = FontFamily(Font(R.font.ubuntu_bold)),
            fontSize = 24.sp
        )
    }
}

@Composable
fun EjemploCambiarColor(modifier: Modifier = Modifier) {
    Text(
        text = "1. Cambiar color",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_medium)),
        fontSize = 24.sp
    )

    Text(
        text = "Texto color cyan",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
        color = Color.Cyan
    )
}

@Composable
fun EjemploCambiarTamano(modifier: Modifier = Modifier) {
    Text(
        text = "2. Cambiar tamaño",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_medium)),
        fontSize = 24.sp
    )

    Text(
        text = "Tamaño de 14sp",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
        fontSize = 14.sp
    )

    Text(
        text = "Tamaño de 16sp",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
        fontSize = 16.sp
    )

    Text(
        text = "Tamaño de 20sp",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
        fontSize = 20.sp
    )

    Text(
        text = "Tamaño de 24sp",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
        fontSize = 24.sp
    )
}

@Composable
fun EjemploCambiarEstilo(modifier: Modifier = Modifier) {
    Text(
        text = "3. Cambiar estilo",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_medium)),
        fontSize = 24.sp
    )

    Text(
        text = "Estilo finito",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_light)),
    )

    Text(
        text = "Estilo normal",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
    )

    Text(
        text = "Estilo normal en cursiva",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_italic)),
    )

    Text(
        text = "Estilo en negrita",
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.ubuntu_bold)),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPreview() {
    EjercicioAula1Theme {
        Pantalla()
    }
}