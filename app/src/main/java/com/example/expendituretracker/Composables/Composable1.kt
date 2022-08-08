package com.example.expendituretracker.Composables

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expendituretracker.Navigation.Screen


// represents main screen
@Composable
fun Comp1(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp,Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button( onClick = { navHostController.navigate(Screen.comp5.route) }  ){
           Text(
               text = "All Expenditures",
               fontSize = MaterialTheme.typography.h5.fontSize
           )
        }

        Button( onClick = { navHostController.navigate(Screen.comp2.route) }  ){
            Text(
                text = "Update Expenditures",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button( onClick = { navHostController.navigate(Screen.comp7.route) }  ){
            Text(
                text = "Monthly Expenditure ",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Show(){
    Comp1(
        navHostController = rememberNavController()
    )
}