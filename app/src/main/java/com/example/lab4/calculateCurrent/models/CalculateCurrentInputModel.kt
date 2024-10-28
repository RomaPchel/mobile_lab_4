package com.example.lab4.calculateCurrent.models

data class CalculateCurrentInputModel(
    val Ukmax: Double = 0.0,
    val Uvn: Double = 0.0,
    val Snomt: Double = 0.0,
    val Xch: Double = 0.0,
    val Xcmin: Double = 0.0,
    val Rch: Double = 0.0,
    val Rcmin: Double = 0.0
)