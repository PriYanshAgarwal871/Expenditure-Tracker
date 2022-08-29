package com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen


// represents update options screen
@Composable
fun EditExpenditure(
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
                backgroundColor = Color(0xFF0492C2) ,
                contentColor = Color.Yellow
            ),
            onClick = { navHostController.navigate(Screen.InsertExpenditureScreen.route) }
        ){
            Text(
                text = "Insert",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0492C2) ,
                contentColor = Color.Yellow
            ),
            onClick = { navHostController.navigate(Screen.UpdateExpenditureScreen.route) }
        ){
            Text(
                text = "Update",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0492C2) ,
                contentColor = Color.Yellow
            ),
            onClick = { navHostController.navigate(Screen.DeleteExpenditureScreen.route) }
        ){
            Text(
                text = "Delete",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}
