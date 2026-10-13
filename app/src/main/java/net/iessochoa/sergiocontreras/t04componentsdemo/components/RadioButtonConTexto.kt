package net.iessochoa.sergiocontreras.t04componentsdemo.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Una opción del grupo: RadioButton + texto. Se puede pulsar toda la fila.
 * @param texto texto de la opción
 * @param seleccionado si esta opción es la seleccionada
 * @param onClick función que se ejecuta al pulsar la opción
 */
@Composable
fun RadioButtonConTexto(
    texto: String,
    seleccionado: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .selectable(
                selected = seleccionado,
                onClick = onClick,
                role = Role.RadioButton
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = seleccionado,
            onClick = null // El clic se maneja en el Row
        )
        Text(
            text = texto,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonConTextoPreview() = RadioButtonConTexto(
    texto = "Opción 1",
    seleccionado = true,
    onClick = {}
)
