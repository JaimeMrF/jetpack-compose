package me.jaimevega.contador

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldScreen() {

    Scaffold { innerPadding ->

        var inputCantidadCalcular by remember { mutableStateOf("") }
        var inputPorcentaje by remember { mutableStateOf("") }

        var cantidad = inputCantidadCalcular.toDoubleOrNull() ?: 0.0
        var porcentaje = inputPorcentaje.toDoubleOrNull() ?: 0.0

        var checked by remember { mutableStateOf(false)}
        var resultado = 0.0

        if (checked) {
            resultado = kotlin.math.ceil((cantidad*porcentaje)/100)
        } else {
            resultado = (cantidad*porcentaje)/100
        }

        Column(modifier = Modifier.padding(innerPadding).
        padding(16.dp)) {
            Text(
                text = "Cálculo de impuestos",
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 50.dp, bottom = 16.dp), color = Color.Red)

            Text(text = "Cantidad: ${cantidad}",
                modifier = Modifier.padding(bottom = 16.dp))

            Text(text = "Porcentaje: ${porcentaje}",
                modifier = Modifier.padding(bottom = 16.dp))

            TextField(
                value = inputCantidadCalcular,
                label = {Text(text = "Cantidad a calcular")},
                onValueChange = { text ->
                    inputCantidadCalcular = text.filter { it.isDigit() }
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = inputPorcentaje,
                label = {Text(text = "Porcentaje")},
                onValueChange = { text ->
                    inputPorcentaje = text.filter { it.isDigit() }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))
            Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                Text("Redondear resultado", modifier = Modifier.weight(1f))
                Switch(checked = checked, onCheckedChange = {
                    checked = it
                })
            }

            Text(text = "Resultado: ${resultado}")
        }
    }
}