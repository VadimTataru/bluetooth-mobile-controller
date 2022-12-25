package com.fox.bluetooth_mobile_controller

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    private lateinit var bluetoothManager: BluetoothManager
    private lateinit var takePermission: ActivityResultLauncher<String>
    private lateinit var takeResultLauncher: ActivityResultLauncher<Intent>

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

    private fun initBluetoothAdapter() {
        bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter

        takePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if(it) {
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                takeResultLauncher.launch(intent)
                Toast.makeText(this, "Bluetooth Is Enabled Now", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bluetooth Is NOT Enabled", Toast.LENGTH_SHORT).show()
            }
        }

        takeResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback { result ->
                if(result.resultCode == RESULT_OK) {
                    Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Bluetooth is OFF", Toast.LENGTH_SHORT).show()
                }
            }
        )
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