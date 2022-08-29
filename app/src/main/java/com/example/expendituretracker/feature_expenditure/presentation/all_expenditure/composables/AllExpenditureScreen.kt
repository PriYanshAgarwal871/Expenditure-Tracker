package com.example.expendituretracker.feature_expenditure.presentation.all_expenditure.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen
import com.example.expendituretracker.feature_expenditure.presentation.all_expenditure.AllExpendituresViewModel
import java.time.Month
@Composable
fun RowScope.HeaderCell(
    text : String,
    weight : Float,
    fontWeight : FontWeight = FontWeight.Medium,
    backgroundColor: Color = Color(0xFF696880),
    textColor :Color = Color.Yellow
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        modifier = Modifier
            .background(color = backgroundColor)
            .border(width = 2.dp, color = Color(0xFFFC6A03))
            .weight(weight)
            .padding(8.dp),
        color = textColor,
        textAlign = TextAlign.Center
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
            .background(color = Color(0xFF696880))
            .padding(horizontal = 15.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn{
            item { 
                Row (modifier = Modifier.fillMaxWidth()){
                     HeaderCell(text = "Month", weight = .4f, fontWeight = FontWeight.Bold , backgroundColor = Color(0xFF0492C2), textColor = Color.Green)
                     HeaderCell(text = "Food" , weight = .3f, fontWeight = FontWeight.Bold, backgroundColor = Color(0xFF0492C2), textColor = Color.Green)
                     HeaderCell(text = "Utility" , weight = .3f, fontWeight = FontWeight.Bold, backgroundColor = Color(0xFF0492C2), textColor = Color.Green)
                     HeaderCell(text = "Bill" , weight = .3f, fontWeight = FontWeight.Bold, backgroundColor = Color(0xFF0492C2), textColor = Color.Green)
                     HeaderCell(text = "Other" , weight = .3f, fontWeight = FontWeight.Bold, backgroundColor = Color(0xFF0492C2), textColor = Color.Green)
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

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = Color.Yellow
            ),
            onClick = { navHostController.navigate(Screen.MainScreen.route) }
        ) {
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

@Preview(showBackground = true)
@Composable
fun Im(){
    AllExpenditure(navHostController = rememberNavController())
}