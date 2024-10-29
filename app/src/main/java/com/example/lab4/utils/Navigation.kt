package com.example.lab4.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab4.Home
import com.example.lab4.calculateCurrent.CalculateCurrentView
import com.example.lab4.chooseCabel.ChooseCableView
import com.example.lab4.calculateCurrentOn10.CalculateCurrentOnTenView

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { Home(navController) }
        composable("chooseCable") { ChooseCableView() }
        composable("calculateCurrentOn10") { CalculateCurrentOnTenView() }
        composable("calculateCurrent") { CalculateCurrentView() }
    }
}