package com.example.expendituretracker.feature_expenditure.data.data_source

import androidx.room.*
import com.example.expendituretracker.feature_expenditure.domain.model.Expenditure
import kotlinx.coroutines.flow.Flow
import java.time.Month

@Dao
interface ExpenditureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(expenditure: Expenditure)

    @Update
    suspend fun updateData(expenditure: Expenditure)

    @Delete
    suspend fun deleteData(expenditure: Expenditure)

    @Query("SELECT * FROM Expenditure")
    fun getAllData() : Flow<List<Expenditure>>

    @Query("SELECT * FROM Expenditure WHERE Month = :month")
    suspend fun getMonthData(month : Month) : Expenditure?

}