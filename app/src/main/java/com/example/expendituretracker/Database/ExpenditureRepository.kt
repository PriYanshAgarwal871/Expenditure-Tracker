package com.example.expendituretracker.Database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ExpenditureRepository (private val expenditureDao: ExpenditureDao) {

    val allData : Flow<List<Expenditure>>  = expenditureDao.getAllData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertData(expenditure: Expenditure) = expenditureDao.insertData(expenditure)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateData(expenditure: Expenditure) = expenditureDao.updateData(expenditure)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteData(month: String) = expenditureDao.deleteData(month)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMonthData(month : String) : List<Expenditure> = expenditureDao.getMonthData(month)

}