package net.iessochoa.sergiocontreras.t04componentsdemo.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    OutlinedTextField(
        value = nombre,
        onValueChange = { if (it.length <= maxCaracteres) onNombreChange(it) },
        label = { Text("Nombre") },
        singleLine = true,
        isError = isError,
        supportingText = { Text("${nombre.length} / $maxCaracteres") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done ),
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