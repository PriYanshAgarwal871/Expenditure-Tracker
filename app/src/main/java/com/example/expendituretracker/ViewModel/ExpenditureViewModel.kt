package com.example.expendituretracker.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.*
import com.example.expendituretracker.Database.Expenditure
import com.example.expendituretracker.Database.ExpenditureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.exp

@HiltViewModel
class ExpenditureViewModel @Inject constructor(
    private val expenditureRepository: ExpenditureRepository
) : ViewModel() {
    val allExpenditures : LiveData<List<Expenditure>> = expenditureRepository.allData.asLiveData()
    val monthExpenditure = MutableLiveData<List<Expenditure>>()
    fun insertData(expenditure: Expenditure) = viewModelScope.launch {
        expenditureRepository.insertData(expenditure)
    }

    fun updateData(expenditure: Expenditure) = viewModelScope.launch {
        expenditureRepository.updateData(expenditure)
    }

    fun deleteData(month: String) = viewModelScope.launch {
        expenditureRepository.deleteData(month)
    }

    fun getMonthData(month : String) = viewModelScope.launch {
        val a = expenditureRepository.getMonthData(month)
        monthExpenditure.postValue(a)
    }

}