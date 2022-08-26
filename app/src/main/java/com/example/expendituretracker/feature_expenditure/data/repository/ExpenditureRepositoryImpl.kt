package com.example.expendituretracker.feature_expenditure.data.repository

import com.example.expendituretracker.feature_expenditure.data.data_source.ExpenditureDao
import com.example.expendituretracker.feature_expenditure.domain.model.Expenditure
import com.example.expendituretracker.feature_expenditure.domain.repository.ExpenditureRepository
import kotlinx.coroutines.flow.Flow
import java.time.Month

class ExpenditureRepositoryImpl (private val expenditureDao: ExpenditureDao) : ExpenditureRepository{

    override fun getAllData(): Flow<List<Expenditure>> {
        return expenditureDao.getAllData()
    }

    override suspend fun insertData(expenditure: Expenditure) {
        expenditureDao.insertData(expenditure)
    }

    override suspend fun deleteData(expenditure: Expenditure) {
       expenditureDao.deleteData(expenditure)
    }

    override suspend fun updateData(expenditure: Expenditure) {
        expenditureDao.updateData(expenditure)
    }

    override suspend fun getMonthData(month: Month): Expenditure? {
        return expenditureDao.getMonthData(month)
    }
}