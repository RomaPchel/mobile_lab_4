package com.example.lab4.calculateCurrent.models

data class CalculateCurrentInputModel(
    val Ukmax: Double = 11.1,
    val Uvn: Double = 115.0,
    val Unn: Double = 11.0,
    val Snomt: Double = 6.3,
    val Xch: Double = 24.02,
    val Xcmin: Double = 65.68,
    val Rch: Double = 10.65,
    val Rcmin: Double = 34.88,
    val Ll: Double = 12.37,
    val R0: Double = 0.64,
    val X0: Double = 0.363,
)