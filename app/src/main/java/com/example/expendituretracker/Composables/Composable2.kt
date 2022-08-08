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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expendituretracker.Navigation.Screen


// represents update options screen
@Composable
fun Comp2(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp,Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button( onClick = { navHostController.navigate(Screen.comp3.route) }  ){
            Text(
                text = "Insert",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button( onClick = { navHostController.navigate(Screen.comp4.route) }  ){
            Text(
                text = "Update",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        Button( onClick = { navHostController.navigate(Screen.comp6.route) }  ){
            Text(
                text = "Delete",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Show2(){
    Comp2(
        navHostController = rememberNavController()
    )
}