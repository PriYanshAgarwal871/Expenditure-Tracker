package com.example.expendituretracker.feature_expenditure.common.Navigation

sealed class Screen(val route : String){
    object MainScreen : Screen(route = "main_screen")
    object EditExpenditureScreen : Screen(route = "edit_expenditure_screen")
    object InsertExpenditureScreen : Screen(route = "insert_expenditure_screen")
    object UpdateExpenditureScreen : Screen(route = "update_expenditure_screen")
    object AllExpenditureScreen : Screen(route = "all_expenditure_screen")
    object DeleteExpenditureScreen : Screen(route = "delete_expenditure_screen")
    object MonthExpenditureScreen : Screen(route = "month_expenditure_screen")
}

