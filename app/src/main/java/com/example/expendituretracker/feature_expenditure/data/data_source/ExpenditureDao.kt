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

    @Query("SELECT * FROM Expenditure ORDER BY " +
            " (CASE Month\n" +
            "    WHEN 'January' THEN 1\n" +
            "    WHEN 'February' THEN 2\n" +
            "    WHEN 'March' THEN 3\n" +
            "    WHEN 'April' THEN 4\n" +
            "    WHEN 'May' THEN 5\n" +
            "    WHEN 'June' THEN 6\n" +
            "    WHEN 'July' THEN 7\n" +
            "    WHEN 'August' THEN 8\n" +
            "    WHEN 'September' THEN 9\n" +
            "    WHEN 'October' THEN 10\n" +
            "    WHEN 'November' THEN 11\n" +
            "    WHEN 'December' THEN 12\n" +
            "  END)")
    fun getAllData() : Flow<List<Expenditure>>

    @Query("SELECT * FROM Expenditure WHERE Month = :month")
    suspend fun getMonthData(month : Month) : Expenditure?

}