package com.example.lab4.calculateCurrent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab4.calculateCurrent.models.CalculateCurrentInputModel
import java.lang.Math.pow
import kotlin.math.sqrt

class CalculateCurrentViewModel : ViewModel(){
    private val calculateCurrentInputData = MutableLiveData(CalculateCurrentInputModel())
    val inputData : MutableLiveData<CalculateCurrentInputModel> = calculateCurrentInputData

    fun calculateResult(){
        val Xt = calculateXt(inputData.value!!.Ukmax, inputData.value!!.Uvn, inputData.value!!.Snomt)
        val Rsh = inputData.value!!.Rch
        val Xsh = calculateXsh(inputData.value!!.Xch, Xt)
        val Zsh = calculateZsh(Rsh, Xsh)
        val Rshmin = inputData.value!!.Rcmin
        val Xshmin = inputData.value!!.Xcmin + Xt
        val Zshmin = calculateZshmin(Rshmin, Xshmin)
        val I3sh = calculateI3shn(inputData.value!!.Uvn, Zsh)
        val I2sh = calculateI2shn(I3sh)

    }

    private fun calculateXt(Ukmax: Double, Uvn: Double, Snomt: Double): Double{
        return (Ukmax * pow(Uvn, 2.0)) / (100 * Snomt)
    }

    private fun calculateXsh(Xch: Double, Xt: Double): Double{
        return Xch + Xt
    }

    private fun calculateZsh(Rsh: Double, Xsh: Double): Double{
        return sqrt(pow(Rsh, 2.0) + pow(Xsh, 2.0))
    }

    private fun calculateXshmin(Xcmin: Double, Xt: Double): Double{
        return Xcmin + Xt
    }

    private fun calculateZshmin(Rshmin: Double, Xshmin: Double) : Double{
        return sqrt(pow(Rshmin, 2.0) + pow(Xshmin, 2.0))
    }

    private fun calculateRshnmin(Rshmin: Double, kpr: Double): Double{
        return Rshmin * kpr
    }

    private fun calculateXshnmin(Xshmin: Double, kpr: Double): Double{
        return Xshmin * kpr
    }

    private fun calculateZshnmin(Rshnmin: Double, Xshnmin: Double): Double{
        return sqrt(pow(Rshnmin, 2.0) + pow(Xshnmin, 2.0))
    }

    private fun calculateI3shn(Unn: Double, Zshn: Double): Double{
        return (Unn * 1000) / (sqrt(3.0) * Zshn)
    }

    private fun calculateI2shn(Ishnmin: Double): Double{
        return Ishnmin * (sqrt(3.0) / 2)
    }
}