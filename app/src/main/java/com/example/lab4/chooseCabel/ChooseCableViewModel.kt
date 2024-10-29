package com.example.lab4.chooseCabel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab4.chooseCabel.models.ChooseCableInputModel
import com.example.lab4.chooseCabel.models.ChooseCableResultModel
import kotlin.math.sqrt

class ChooseCableViewModel : ViewModel() {
    private val chooseCableInputData = MutableLiveData(ChooseCableInputModel())
    private val chooseCableResultData = MutableLiveData(ChooseCableResultModel())

    val inputData: MutableLiveData<ChooseCableInputModel> = chooseCableInputData
    val resultData: MutableLiveData<ChooseCableResultModel> = chooseCableResultData

    fun calculateResult() {
        val Im: Double =
            calculateIm(chooseCableInputData.value!!.Sm, chooseCableInputData.value!!.Unom)
        val Impa: Double = calculateImpa(Im)
        val Sek: Double = calculateSek(Im, chooseCableInputData.value!!.jek)
        val s: Double = calculateS(
            chooseCableInputData.value!!.Ik,
            chooseCableInputData.value!!.tf,
            chooseCableInputData.value!!.ct
        )
        chooseCableResultData.value = ChooseCableResultModel(Im, Impa, Sek, s)
    }

    private fun calculateIm(Sm: Double, Unom: Double): Double {
        return (Sm / 2) / (sqrt(3.0) * Unom)
    }

    private fun calculateImpa(Im: Double): Double {
        return Im * 2
    }

    private fun calculateSek(Im: Double, jek: Double): Double {
        return Im / jek
    }

    private fun calculateS(Ik: Double, tf: Double, Ct: Double): Double {
        return (Ik * sqrt(tf)) / Ct
    }

    fun updateUnom(value: Double) {
        chooseCableInputData.value = chooseCableInputData.value?.copy(Unom = value)
    }

    fun updateIk(value: Double) {
        chooseCableInputData.value = chooseCableInputData.value?.copy(Ik = value)
    }

    fun updateTf(value: Double) {
        chooseCableInputData.value = chooseCableInputData.value?.copy(tf = value)
    }

    fun updateSm(value: Double) {
        chooseCableInputData.value = chooseCableInputData.value?.copy(Sm = value)
    }

    fun updateJek(value: Double) {
        chooseCableInputData.value = chooseCableInputData.value?.copy(jek = value)
    }

    fun updateCt(value: Double) {
        chooseCableInputData.value = chooseCableInputData.value?.copy(ct = value)
    }


}