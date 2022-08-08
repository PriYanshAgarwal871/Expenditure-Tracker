package com.example.expendituretracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expendituretracker.Database.Expenditure
import com.example.expendituretracker.Database.ExpenditureDao
import com.example.expendituretracker.Navigation.SetNavGraph
import com.example.expendituretracker.ViewModel.ExpenditureViewModel
import com.example.expendituretracker.ui.theme.ExpenditureTrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
         lateinit var navHostController: NavHostController
         val expenditureViewModel : ExpenditureViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                navHostController = rememberNavController()
                SetNavGraph(navController = navHostController , expenditureViewModel )
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
