package com.example.lab4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = { navController.navigate("chooseCable") }) {
                    Text("Обрати кабель")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("calculateCurrentOn10") }) {
                    Text("Визначити струми на шинах 10кв")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("calculateCurrent") }) {
                    Text("Визначити струми")
                }
            }
        }
    }
}