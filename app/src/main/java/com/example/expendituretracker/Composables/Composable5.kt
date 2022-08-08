package com.example.expendituretracker.Composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expendituretracker.Navigation.Screen
import com.example.expendituretracker.ViewModel.ExpenditureViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun RowScope.HeaderCell(
    text : String,
    weight : Float,
    fontWeight : FontWeight = FontWeight.Medium
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}


@Composable
fun Comp5(
    navHostController: NavHostController,
    expenditureViewModel: ExpenditureViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val expenditure = expenditureViewModel.allExpenditures.observeAsState(initial = listOf())
        LazyColumn{
            item { 
                Row (modifier = Modifier.fillMaxWidth()){
                     HeaderCell(text = "Month", weight = .3f, fontWeight = FontWeight.Bold)
                     HeaderCell(text = "Food" , weight = .3f, fontWeight = FontWeight.Bold)
                     HeaderCell(text = "Utility" , weight = .3f, fontWeight = FontWeight.Bold)
                     HeaderCell(text = "Bill" , weight = .3f, fontWeight = FontWeight.Bold)
                     HeaderCell(text = "Other" , weight = .3f, fontWeight = FontWeight.Bold)
                }
            }

            items(expenditure.value.size){ index ->
                val expenditureItem = expenditure.value[index]
                Row {
                    HeaderCell(text = expenditureItem.month, weight =.3f )
                    HeaderCell(text = expenditureItem.foodExpenditure.toString(), weight =.3f )
                    HeaderCell(text = expenditureItem.utilityExpenditure.toString(), weight =.3f )
                    HeaderCell(text = expenditureItem.billExpenditure.toString(), weight = .3f)
                    HeaderCell(text = expenditureItem.otherExpenditure.toString(), weight = .3f)
                }
            }
        }

        Button(onClick = { navHostController.navigate(Screen.comp1.route) }) {
            Text(text = "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Show5(){
    Comp5(
        navHostController = rememberNavController(),
        expenditureViewModel =  viewModel()
    )
}