package net.iessochoa.sergiocontreras.t04componentsdemo.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NombreTextField(
    nombre: String,
    onNombreChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    maxCaracteres: Int = 20,
    isError: Boolean = false
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = nombre,
        onValueChange = { if (it.length <= maxCaracteres) onNombreChange(it) },
        label = { Text("Nombre") },
        singleLine = true,
        isError = isError,
        supportingText = { Text("${nombre.length} / $maxCaracteres") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Maneja the "Done" action
                keyboardController?.hide() // Esconde el teclado
            }
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun NombreTextFieldOKPreview() = NombreTextField(
    nombre = "Sergio",
    onNombreChange = {},
)

@Preview(showBackground = true)
@Composable
fun NombreTextFieldKOPreview() = NombreTextField(
    nombre = "NombreDemasiadoLargo!",
    onNombreChange = {},
    isError = true
)