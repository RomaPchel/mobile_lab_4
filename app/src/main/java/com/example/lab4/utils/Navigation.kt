package com.example.lab4.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab4.Home
import com.example.lab4.chooseCabel.ChooseCableView
import com.example.lab4.chooseCabel.ChooseCableViewModel
import com.example.lab4.calculateCurrentOn10.CalculateCurrentOnTenScreen
import com.example.lab4.calculateCurrentOn10.Screen3

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { Home(navController) }
        composable("chooseCable") { ChooseCableView(ChooseCableViewModel()) }
        composable("screen2") { CalculateCurrentOnTenScreen() }
        composable("screen3") { Screen3() }
    }
}