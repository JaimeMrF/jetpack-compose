package me.jaimevega.composable

import android.os.Build
import android.widget.Button
import android.widget.GridLayout
import android.widget.Switch
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true
)
@Composable
fun ComponentePrincipal() {
    Column (modifier = Modifier.padding(12.dp).fillMaxWidth()) {
        Card {
            Row (modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column (modifier = Modifier.weight(1f)) {
                    Text(text = "José Alejandro Téllez Prada")
                    Text(text = "Ing. Sistemas")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.MoreVert,
                        contentDescription = null)
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value="Jaime",
            onValueChange = {},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            },
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Button(modifier = Modifier.weight(1f) ,onClick={}) {
            Icon(imageVector = Icons.Default.Send, contentDescription = null)
            Text(text = "Enviar")
        }

            FilledTonalButton (modifier = Modifier.weight(1f),onClick={}) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
                Text(text = "Enviar")
            } }
        Spacer(modifier = Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {})
            Text(text = "Seleccionar")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = true, onCheckedChange = {})
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Seleccionar")
        }
    }

}
