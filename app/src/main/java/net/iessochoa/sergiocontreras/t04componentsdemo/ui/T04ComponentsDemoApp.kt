package net.iessochoa.sergiocontreras.t04componentsdemo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.t04componentsdemo.R
import net.iessochoa.sergiocontreras.t04componentsdemo.components.NombreTextField
import net.iessochoa.sergiocontreras.t04componentsdemo.components.RowRadioButtonCompose
import net.iessochoa.sergiocontreras.t04componentsdemo.components.SwitchConEtiqueta
import net.iessochoa.sergiocontreras.t04componentsdemo.ui.theme.T04ComponentsDemoTheme


@Composable
fun T04ComponentsDemoApp() {

    var esPremium by rememberSaveable { mutableStateOf(false) }
    var informesSemanales by rememberSaveable { mutableStateOf(false) }

    val radioOptions = stringArrayResource(R.array.ingredientes).toList()
    var selectedIngredient by rememberSaveable { mutableStateOf(radioOptions.first()) }

    var tareaNombre by rememberSaveable { mutableStateOf("") }

    T04ComponentsDemoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NombreTextField(
                    nombre = "",
                    onNombreChange = {}
                )
                Spacer(
                    modifier = Modifier.padding(24.dp)
                )

                SwitchConEtiqueta("Usuario premium", esPremium, { esPremium = it })
                SwitchConEtiqueta(
                    texto = "Recibir informes semanales",
                    checked = informesSemanales,
                    onCheckedChange = { informesSemanales = it },
                    enabled = esPremium
                )
                Spacer(
                    modifier = Modifier.padding(24.dp)
                )

                RowRadioButtonCompose(
                    radioOptions,
                    opcionSeleccionada = selectedIngredient,
                    onOptionSelected = { selectedIngredient = it }
                )

               Row(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(horizontal = 16.dp),
                   horizontalArrangement = Arrangement.SpaceEvenly,
                   verticalAlignment = Alignment.CenterVertically
               ) { // Añadidor de tareas
                   NombreTextField(
                       nombre = tareaNombre,
                       onNombreChange = {tareaNombre = it},
                       modifier = Modifier.weight(2f)
                   )
                   Spacer(modifier = Modifier.weight(0.5f))
                   Button(
                       onClick = {},
                       modifier = Modifier.weight(1f)
                   ) {
                       Text("Añadir tarea")
                   }
               }






            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun T04ComponentsDemoAppPreview() {
    T04ComponentsDemoApp()
}