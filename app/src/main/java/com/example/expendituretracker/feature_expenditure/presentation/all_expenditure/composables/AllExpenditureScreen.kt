package com.example.expendituretracker.feature_expenditure.presentation.all_expenditure.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen
import com.example.expendituretracker.feature_expenditure.presentation.all_expenditure.AllExpendituresViewModel
import java.time.Month

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
fun AllExpenditure(
    navHostController: NavHostController,
    viewModel: AllExpendituresViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            items(state.expenditures){ expenditure ->
                Row {
                    HeaderCell(text = toTitleCase(expenditure.month), weight =.4f )
                    HeaderCell(text = expenditure.foodExpenditure.toString(), weight =.3f )
                    HeaderCell(text = expenditure.utilityExpenditure.toString(), weight =.3f )
                    HeaderCell(text = expenditure.billExpenditure.toString(), weight = .3f)
                    HeaderCell(text = expenditure.otherExpenditure.toString(), weight = .3f)
                }
            }
        }

        Button(onClick = { navHostController.navigate(Screen.MainScreen.route) }) {
            Text(text = "Back")
        }
    }
}

private fun toTitleCase(month : Month) : String{
    val a = month.toString().lowercase()
    val b : Char = a[0]

    return a.replace(
        oldChar = b,
        newChar = b.uppercaseChar()
    )
}