package com.example.expendituretracker.feature_expenditure.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Month

@Entity
data class Expenditure(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Month")
    var month : Month,

    @ColumnInfo(name = "Food")
    var foodExpenditure : Int ,

    @ColumnInfo(name = "Utilities")
    var utilityExpenditure : Int ,

    @ColumnInfo(name = "Bills")
    var billExpenditure : Int ,

    @ColumnInfo(name = "Others")
    var otherExpenditure : Int

)

class InvalidInputException(message:String) : Exception(message)
