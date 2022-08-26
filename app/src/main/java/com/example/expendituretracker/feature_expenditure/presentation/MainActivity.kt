package com.example.expendituretracker.feature_expenditure.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expendituretracker.feature_expenditure.common.Navigation.SetNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                navHostController = rememberNavController()
                SetNavGraph(navController = navHostController)
        }

//        val dataExpenditure = listOf(
//            Expenditure(
//                month = "January",
//                foodExpenditure = 2000,
//                utilityExpenditure = 12000,
//                billExpenditure = 4000,
//                otherExpenditure = 1870
//            ),
//            Expenditure(
//                month = "February",
//                foodExpenditure = 2000,
//                utilityExpenditure = 12000,
//                billExpenditure = 4000,
//                otherExpenditure = 1870
//            ),
//            Expenditure(
//                month = "March",
//                foodExpenditure = 2000,
//                utilityExpenditure = 12000,
//                billExpenditure = 4000,
//                otherExpenditure = 1870
//            )
//        )
//        lifecycleScope.launch {
//            dataExpenditure.forEach { expenditureDao.insertData(it) }
//        }
    }
}
