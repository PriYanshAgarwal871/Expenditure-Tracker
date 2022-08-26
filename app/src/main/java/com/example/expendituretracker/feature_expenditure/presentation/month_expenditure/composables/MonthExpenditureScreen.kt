package com.example.expendituretracker.feature_expenditure.presentation.month_expenditure.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.presentation.all_expenditure.composables.HeaderCell
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen

import com.example.expendituretracker.feature_expenditure.presentation.month_expenditure.MonthExpenditureViewModel
import java.time.Month


@Composable
fun RowScope.HeaderCell(
    text : String,
    weight: Float,
    fontWeight : FontWeight = FontWeight.Medium,
    backgroundColor : Color = Color.White
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .weight(weight)
            .background(backgroundColor)
            .padding(8.dp)
    )
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthExpenditure(
    navHostController: NavHostController,
    viewModel: MonthExpenditureViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = viewModel.state.value
        val listOfMonths = listOf(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        )
        val month = remember { mutableStateOf(listOfMonths[0]) }
        val expanded = remember { mutableStateOf(false) }
        val isClicked = remember { mutableStateOf(false) }

        OutlinedTextField(
            value = month.value,
            onValueChange = { month.value = it },
            label = { Text(text = "Month") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop down arrow",
                    Modifier.clickable { expanded.value = !expanded.value }
                )
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            listOfMonths.forEach { selectedMonth ->
                DropdownMenuItem(
                    onClick = {
                        month.value = selectedMonth
                        expanded.value = false
                    }
                ) {
                    Text(text = selectedMonth)
                }
            }
        }


        Button(
            onClick = {
                viewModel.onEvent(
                    convertToJavaMonth(month.value)
                )
                isClicked.value = true
            }
        ) {
            Text(text = "Get")
        }

        if (isClicked.value) {
            val exp = state.expenditure
            Column {
                if (exp == null) {
                    Text(
                        text = "No data Found",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h3.fontSize
                    )
                } else {
                    Row {
                        HeaderCell(
                            text = "Month",
                            weight = .3f,
                            fontWeight = FontWeight.Bold,
                            backgroundColor = Color.Yellow
                        )
                        HeaderCell(
                            text = toTitleCase(exp.month),
                            weight = .4f
                        )
                    }
                    Row {
                        HeaderCell(
                            text = "Food Expenditure",
                            weight = .3f,
                            fontWeight = FontWeight.Bold,
                            backgroundColor = Color.Yellow
                        )
                        HeaderCell(
                            text = exp.foodExpenditure.toString(),
                            weight = .4f
                        )
                    }
                    Row {
                        HeaderCell(
                            text = "Utility Expenditure",
                            weight = .3f,
                            fontWeight = FontWeight.Bold,
                            backgroundColor = Color.Yellow
                        )
                        HeaderCell(
                            text = exp.utilityExpenditure.toString(),
                            weight = .4f
                        )
                    }
                    Row {
                        HeaderCell(
                            text = "Bill Expenditure",
                            weight = .3f,
                            fontWeight = FontWeight.Bold,
                            backgroundColor = Color.Yellow
                        )
                        HeaderCell(
                            text = exp.billExpenditure.toString(),
                            weight = .4f
                        )
                    }
                    Row {
                        HeaderCell(
                            text = "OtherExpenditure",
                            weight = .3f,
                            fontWeight = FontWeight.Bold,
                            backgroundColor = Color.Yellow
                        )
                        HeaderCell(
                            text = exp.otherExpenditure.toString(),
                            weight = .4f
                        )
                    }
                }
            }

            Button(
                onClick = {
                    navHostController.navigate(Screen.MainScreen.route)
                    isClicked.value = false
                }
            ) {
                Text(text = "Back")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun convertToJavaMonth(month : String) : Month {
    return when(month){
        "January" -> Month.JANUARY
        "February" -> Month.FEBRUARY
        "March" -> Month.MARCH
        "May" -> Month.MAY
        "April" -> Month.APRIL
        "June" -> Month.JUNE
        "July" -> Month.JULY
        "August" -> Month.AUGUST
        "September" -> Month.SEPTEMBER
        "October" -> Month.OCTOBER
        "November" -> Month.NOVEMBER
        else -> Month.DECEMBER
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