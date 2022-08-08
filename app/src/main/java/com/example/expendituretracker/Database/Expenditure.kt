package com.example.expendituretracker.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expenditure(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Month")
    var month : String,

    @ColumnInfo(name = "Food")
    var foodExpenditure : Int ,

    @ColumnInfo(name = "Utilities")
    var utilityExpenditure : Int ,

    @ColumnInfo(name = "Bills")
    var billExpenditure : Int ,

    @ColumnInfo(name = "Others")
    var otherExpenditure : Int

)
