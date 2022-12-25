package com.fox.bluetooth_mobile_controller.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fox.bluetooth_mobile_controller.ui.theme.BluetoothMobileControllerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold{
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bluetooth test application \n version: 0.0.1:alpha",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(60.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Включить Bluetooth")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Поиск устройств")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BluetoothMobileControllerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }
    }
}