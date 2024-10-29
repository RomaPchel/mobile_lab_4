package com.example.lab4.calculateCurrent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab4.calculateCurrent.models.CalculateCurrentInputModel
import com.example.lab4.calculateCurrent.models.CalculateCurrentResultModel
import kotlin.math.pow
import kotlin.math.sqrt

class CalculateCurrentViewModel : ViewModel() {
    private val calculateCurrentInputData = MutableLiveData(CalculateCurrentInputModel())
    val inputData: MutableLiveData<CalculateCurrentInputModel> = calculateCurrentInputData

    private val calculateCurrentResultData = MutableLiveData(CalculateCurrentResultModel())
    val resultData: MutableLiveData<CalculateCurrentResultModel> = calculateCurrentResultData

    fun calculateResult() {
        val Xt = calculateXt(inputData.value!!.Ukmax, inputData.value!!.Uvn, inputData.value!!.Snomt)
        val Rsh = inputData.value!!.Rch
        val Xsh = calculateXsh(inputData.value!!.Xch, Xt)
        val Zsh = calculateZsh(Rsh, Xsh)
        val Rshmin = inputData.value!!.Rcmin
        val Xshmin = inputData.value!!.Xcmin + Xt
        val Zshmin = calculateZshmin(Rshmin, Xshmin)
        val I3sh = calculateI3shn(inputData.value!!.Uvn, Zsh)
        val I2sh = calculateI2shn(I3sh)
        val I3shmin = calculateI3shn(inputData.value!!.Uvn, Zshmin)
        val I2shmin = calculateI2shn(I3shmin)
        val kpr = calculateKpr(inputData.value!!.Unn, inputData.value!!.Uvn)
        val Rshn = Rsh * kpr
        val Xshn = Xsh * kpr
        val Zshn = calculateZsh(Rshn, Xshn)
        val Rshnmin = Rshmin * kpr
        val Xshnmin = Xshmin * kpr
        val Zshnmin = calculateZsh(Rshnmin, Xshnmin)
        val I3shn = calculateI3shn(inputData.value!!.Unn, Zshn)
        val I2shn = calculateI2shn(I3shn)
        val I3shnmin = calculateI3shn(inputData.value!!.Unn, Zshnmin)
        val I2shnmin = calculateI2shn(I3shnmin)
        val Rl = inputData.value!!.Ll * inputData.value!!.R0
        val Xl = inputData.value!!.Ll * inputData.value!!.X0
        val Rcn = Rl + Rshn
        val Xcn = Xl + Xshn
        val Zcn = calculateZshnmin(Rcn, Xcn)
        val Rcnmin = Rl + Rshnmin
        val Xcnmin = Xl + Xshnmin
        val Zcnmin = calculateZshnmin(Rcnmin, Xcnmin)
        val I3ln = calculateI3shn(inputData.value!!.Unn, Zcn)
        val I2ln = calculateI2shn(I3ln)
        val I3lnmin = calculateI3shn(inputData.value!!.Unn, Zcnmin)
        val I2lnmin = calculateI2shn(I3lnmin)

        calculateCurrentResultData.value = CalculateCurrentResultModel(
            Rsh, Xsh, Zsh, Rshmin, Xshmin, Zshmin, I3sh, I2sh, I3shmin, I2shmin,
            kpr, Rshn, Xshn, Zshn, Rshnmin, Xshnmin, Zshnmin, I3shn, I2shn,
            I3shnmin, I2shnmin, Rl, Xl, Rcn, Xcn, Zcn, Rcnmin, Xcnmin, Zcnmin,
            I3ln, I2ln, I3lnmin, I2lnmin
        )
    }

    private fun calculateKpr(Unn: Double, Uvn: Double): Double {
        return (Unn.pow(2.0)) / (Uvn.pow(2.0))
    }

    private fun calculateXt(Ukmax: Double, Uvn: Double, Snomt: Double): Double {
        return (Ukmax * Uvn.pow(2.0)) / (100 * Snomt)
    }

    private fun calculateXsh(Xch: Double, Xt: Double): Double {
        return Xch + Xt
    }

    private fun calculateZsh(Rsh: Double, Xsh: Double): Double {
        return sqrt(Rsh.pow(2.0) + Xsh.pow(2.0))
    }

    private fun calculateZshmin(Rshmin: Double, Xshmin: Double): Double {
        return sqrt(Rshmin.pow(2.0) + Xshmin.pow(2.0))
    }

    private fun calculateZshnmin(Rshnmin: Double, Xshnmin: Double): Double {
        return sqrt(Rshnmin.pow(2.0) + Xshnmin.pow(2.0))
    }

    private fun calculateI3shn(Unn: Double, Zshn: Double): Double {
        return (Unn * 1000) / (sqrt(3.0) * Zshn)
    }

    private fun calculateI2shn(Ishnmin: Double): Double {
        return Ishnmin * (sqrt(3.0) / 2)
    }

    // Methods to update each field in the input model
    fun updateUkmax(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Ukmax = value)
    }

    fun updateUvn(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Uvn = value)
    }

    fun updateUnn(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Unn = value)
    }

    fun updateSnomt(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Snomt = value)
    }

    fun updateXch(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Xch = value)
    }

    fun updateXcmin(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Xcmin = value)
    }

    fun updateRch(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Rch = value)
    }

    fun updateRcmin(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Rcmin = value)
    }

    fun updateLl(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Ll = value)
    }

    fun updateR0(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(R0 = value)
    }

    fun updateX0(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(X0 = value)
    }
}
