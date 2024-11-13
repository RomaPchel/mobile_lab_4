package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    // стейт для індексу обраного табу
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                NavigationBarItem(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    label = { Text("Калькулятор 1") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    label = { Text("Калькулятор 2") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = selectedTabIndex == 2,
                    onClick = { selectedTabIndex = 2 },
                    label = { Text("Калькулятор 3") },
                    icon = {}
                )
            }
        }
    ) { innerPadding ->
        when (selectedTabIndex) {
            0 -> CableCalculatorApp(modifier = Modifier.padding(innerPadding))
            1 -> CurrentCalculatorApp(modifier = Modifier.padding(innerPadding))
            2 -> Calculator3App(modifier = Modifier.padding(innerPadding))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenAppPreview() {
    MainScreen()
}