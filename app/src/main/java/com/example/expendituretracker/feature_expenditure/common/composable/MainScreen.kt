package com.example.expendituretracker.Composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen


// represents main screen
@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp,Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button( onClick = { navHostController.navigate(Screen.AllExpenditureScreen.route) }  ){
           Text(
               text = "All Expenditures",
               fontSize = MaterialTheme.typography.h5.fontSize
           )
        }

        Button( onClick = { navHostController.navigate(Screen.EditExpenditureScreen.route) }  ){
            Text(
                text = "Update Expenditures",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button( onClick = { navHostController.navigate(Screen.MonthExpenditureScreen.route) }  ){
            Text(
                text = "Monthly Expenditure ",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}