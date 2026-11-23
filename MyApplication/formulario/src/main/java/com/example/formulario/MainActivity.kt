package com.example.formulario

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formulario.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaRegistro()
        }
    }
}

@Composable
private fun PantallaRegistro() {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FormularioRegistro(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PantallaRegistroPreview() {
    PantallaRegistro()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormularioRegistro(modifier: Modifier = Modifier) {
    // Datos personales
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    // Checkbox de términos
    var aceptarTerminos by remember { mutableStateOf(false) }

    // Radial de modalidad
    val opciones = listOf("Online", "Presencial", "Mixta")
    var modalidad by remember { mutableStateOf(opciones[0]) }

    // Desplegable de curso
    val cursos = listOf("1ºDAM", "2ºDAM")
    var curso by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf(false) }

    // Errores
    val nombreError = nombre.isBlank()
    val emailError = !Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()
    val passwordError = password.length < 6
    val edadNoNumeroError = edad.toIntOrNull() == null
    val edadFueraRangoError = !edadNoNumeroError && (edad.toInt() !in 16..99)
    val telefonoError = telefono.isNotBlank() && !Patterns.PHONE.matcher(telefono.trim()).matches()
    val aceptarTerminosError = !aceptarTerminos;

    // Mensaje de resultado y envío
    val formularioValido =
        !nombreError && !emailError && !passwordError && !edadNoNumeroError && !edadFueraRangoError && !telefonoError && !aceptarTerminosError
    var intentoEnvio by remember { mutableStateOf(false) }
    var registroValido by remember { mutableStateOf(false) }
    var mensaje by remember { mutableStateOf("") }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .imePadding() // Para que el teclado no tape elementos
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Registro", style = MaterialTheme.typography.headlineMedium)

            // Datos personales
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                placeholder = { Text("Escribe tu nombre...") },
                singleLine = true,
                isError = intentoEnvio && nombreError,
                supportingText = {
                    if (intentoEnvio && nombreError) Text("Nombre obligatorio.")
                    else Text("* Obligatorio.")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = apellidos,
                onValueChange = { apellidos = it },
                label = { Text("Apellidos") },
                placeholder = { Text("Escribe tus apellidos...") },
                singleLine = true,
                supportingText = { },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                placeholder = { Text("Escribe tu email...") },
                singleLine = true,
                isError = intentoEnvio && emailError,
                supportingText = {
                    if (intentoEnvio && emailError) Text("Email no válido.")
                    else Text("* Obligatorio.")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                isError = intentoEnvio && passwordError,
                supportingText = {
                    if (intentoEnvio && passwordError) Text("Contraseña demasiado corta. Mínimo 6 caracteres.")
                    else Text("* Obligatorio.")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                isError = intentoEnvio && (edadNoNumeroError || edadFueraRangoError),
                supportingText = {
                    if (intentoEnvio && edadNoNumeroError) Text("Edad debe ser un número.")
                    else if (intentoEnvio && edadFueraRangoError) Text("Edad debe estar entre 16 y 99.")
                    else Text("* Obligatorio.")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError = intentoEnvio && telefonoError,
                supportingText = {
                    if (intentoEnvio && telefonoError) Text("Teléfono inválido.")
                },
                modifier = Modifier.fillMaxWidth()
            )

            // Terminos y condiciones
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = aceptarTerminos,
                    onCheckedChange = { aceptarTerminos = it },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = if (intentoEnvio && aceptarTerminosError) {
                            MaterialTheme.colorScheme.error
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )
                )
                Text(
                    text = "Acepto los términos y condiciones *",
                    color = if (intentoEnvio && aceptarTerminosError) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.onSurface
                    },
                )
            }

            if (intentoEnvio && aceptarTerminosError) {
                Text(
                    text = "Acepta los términos y condiciones.",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // Radio Modalidad
            Text("Modalidad")

            for (opcion in opciones) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = opcion == modalidad,
                        onClick = { modalidad = opcion }
                    )
                    Text(opcion)
                }
            }

            // MenuBox / ComboBox curso
            ExposedDropdownMenuBox(
                expanded = expandido,
                onExpandedChange = { expandido = it }
            ) {
                OutlinedTextField(
                    value = curso,
                    onValueChange = { },
                    readOnly = true,
                    label = { Text("Curso") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandido) },
                    modifier = Modifier
                        .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expandido,
                    onDismissRequest = { expandido = false }
                ) {
                    for (opcion in cursos) {
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                curso = opcion
                                expandido = false
                            }
                        )
                    }
                }
            }

            // Enviar
            Button(
                onClick = {
                    intentoEnvio = true
                    if (formularioValido) {
                        registroValido = true
                        mensaje =
                            "$nombre $apellidos, con email $email, teléfono $telefono y $edad años, ha sido registrado en $curso con la modalidad $modalidad."
                    } else {
                        mensaje = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()

            ) {
                Text("Registrarse")
            }

            if (registroValido) {
                Text(mensaje)
            }
        }
    }
}