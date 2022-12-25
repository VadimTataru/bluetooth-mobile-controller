package com.fox.bluetooth_mobile_controller

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fox.bluetooth_mobile_controller.screens.MainScreen
import com.fox.bluetooth_mobile_controller.ui.theme.BluetoothMobileControllerTheme

class MainActivity : ComponentActivity() {

    private var bluetoothAdapter: BluetoothAdapter? = null
    private var bluetoothLeScanner: BluetoothLeScanner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBluetoothAdapter()
        setContent {
            BluetoothMobileControllerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun initBluetoothAdapter() {
        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter
        bluetoothLeScanner = bluetoothAdapter?.bluetoothLeScanner
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