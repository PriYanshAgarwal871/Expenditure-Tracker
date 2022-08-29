package com.example.expendituretracker.feature_expenditure.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen


// represents main screen
@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF696880))
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp,Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0492C2),
                contentColor = Color.Yellow
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = { navHostController.navigate(Screen.AllExpenditureScreen.route) }
        ){
           Text(
               text = "All Expenditures",
               fontSize = MaterialTheme.typography.h5.fontSize
           )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0492C2),
                contentColor = Color.Yellow
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = { navHostController.navigate(Screen.EditExpenditureScreen.route) }
        ){
            Text(
                text = "Update Expenditures",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0492C2),
                contentColor = Color.Yellow
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = { navHostController.navigate(Screen.MonthExpenditureScreen.route) }
        ){
            Text(
                text = "Monthly Expenditure ",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}