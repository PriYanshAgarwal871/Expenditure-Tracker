package com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.composables

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


// represents update options screen
@Composable
fun EditExpenditure(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp,Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button( onClick = { navHostController.navigate(Screen.InsertExpenditureScreen.route) }  ){
            Text(
                text = "Insert",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button( onClick = { navHostController.navigate(Screen.UpdateExpenditureScreen.route) }  ){
            Text(
                text = "Update",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button( onClick = { navHostController.navigate(Screen.DeleteExpenditureScreen.route) }  ){
            Text(
                text = "Delete",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Show2(){
//    Comp2(
//        navHostController = rememberNavController()
//    )
//}