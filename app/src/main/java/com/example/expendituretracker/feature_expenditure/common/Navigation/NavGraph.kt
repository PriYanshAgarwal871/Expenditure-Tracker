package com.example.expendituretracker.feature_expenditure.common.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expendituretracker.feature_expenditure.common.composable.MainScreen
import com.example.expendituretracker.feature_expenditure.presentation.all_expenditure.composables.AllExpenditure
import com.example.expendituretracker.feature_expenditure.presentation.month_expenditure.composables.MonthExpenditure
import com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.composables.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetNavGraph (navController: NavHostController){
    NavHost(navController = navController ,
            startDestination = Screen.MainScreen.route
    ){
        composable(route = Screen.MainScreen.route ){
            MainScreen(navController)
        }
        composable(route = Screen.EditExpenditureScreen.route){
            EditExpenditure(navController)
        }
        composable(route = Screen.InsertExpenditureScreen.route){
            InsertExpenditure(navController )
        }
        composable(route = Screen.UpdateExpenditureScreen.route){
            UpdateExpenditure(navController)
        }
        composable(route = Screen.AllExpenditureScreen.route){
            AllExpenditure(navController)
        }
        composable(route = Screen.DeleteExpenditureScreen.route){
            DeleteExpenditure(navController)
        }
        composable(route = Screen.MonthExpenditureScreen.route){
            MonthExpenditure(navController)
        }
    }
}
