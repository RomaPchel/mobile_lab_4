package com.example.lab4.calculateCurrentOn10

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab4.calculateCurrentOn10.models.CalculateCurrentOnTenInputModel
import com.example.lab4.calculateCurrentOn10.models.CalculateCurrentOnTenResultModel
import kotlin.math.pow
import kotlin.math.sqrt

class CalculateCurrentOnTenViewModel : ViewModel() {
    private val calculateCurrentInputData = MutableLiveData(CalculateCurrentOnTenInputModel())
    val inputData: MutableLiveData<CalculateCurrentOnTenInputModel> = calculateCurrentInputData

    private val calculateCurrentResultData = MutableLiveData(CalculateCurrentOnTenResultModel())
    val resultData: MutableLiveData<CalculateCurrentOnTenResultModel> = calculateCurrentResultData

    fun calculateResult() {
        val Xc: Double =
            calculateXc(calculateCurrentInputData.value!!.Uch, calculateCurrentInputData.value!!.Sk)
        val Xt: Double = calculateXt(
            calculateCurrentInputData.value!!.Uk,
            calculateCurrentInputData.value!!.Uch,
            calculateCurrentInputData.value!!.Snomt
        )
        val X: Double = calculateX(Xc, Xt)
        val Ip0: Double = calculateIp0(calculateCurrentInputData.value!!.Uch, X)
        resultData.value = CalculateCurrentOnTenResultModel(Xc, Xt, X, Ip0)
    }

    fun updateSk(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Sk = value)
    }

    fun updateUch(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Uch = value)
    }

    fun updateSnomt(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Snomt = value)
    }

    fun updateUk(value: Double) {
        calculateCurrentInputData.value = calculateCurrentInputData.value?.copy(Uk = value)
    }

    private fun calculateXc(Uch: Double, Sk: Double): Double {
        return Uch.pow(2.0) / Sk
    }

    private fun calculateXt(Uk: Double, Uch: Double, Snomt: Double): Double {
        return (Uk / 100) * (Uch.pow(2.0) / Snomt)
    }

    private fun calculateX(Xc: Double, Xt: Double): Double {
        return Xc + Xt
    }

    private fun calculateIp0(Uch: Double, X: Double): Double {
        return Uch / (sqrt(3.0) * X)
    }
}