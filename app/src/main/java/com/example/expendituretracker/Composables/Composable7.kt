package com.example.expendituretracker.Composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.expendituretracker.Database.Expenditure
import com.example.expendituretracker.Navigation.Screen
import com.example.expendituretracker.ViewModel.ExpenditureViewModel
import kotlin.math.exp


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


@Composable
fun Comp7(
    navHostController: NavHostController,
    expenditureViewModel: ExpenditureViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var listOfMonths = listOf(
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
        var month = remember { mutableStateOf(listOfMonths[0]) }
        var expanded = remember { mutableStateOf(false) }
        var isClicked = remember { mutableStateOf(false) }

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
//        val monthExpenditure = expenditureViewModel.monthExpenditure.observeAsState()
//        var foodExpenditure = remember { mutableStateOf(expenditureViewModel.)}
//        var billExpenditure = remember { mutableStateOf(expenditureViewModel.getMonthData(month.value))}
//        var utilityExpenditure = remember { mutableStateOf(expenditureViewModel.getMonthData(month.value))}
        var otherExpenditure = remember { mutableStateOf(expenditureViewModel.getMonthData(month.value))}
        Button(
            onClick = {
                expenditureViewModel.getMonthData(month.value)
                isClicked.value = true
            }
        ) {
            Text(text = "Get")
        }

        if (isClicked.value) {
            Column {
                Row {
                    HeaderCell(
                        text = "Month",
                        weight = .3f,
                        fontWeight = FontWeight.Bold,
                        backgroundColor = Color.Yellow
                    )
                    HeaderCell(
                        text = month.value,
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
                        text = "foodval" ,
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
                        text = "util",
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
                        text = "billval",
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
                        text = "otherval",
                        weight = .4f
                    )
                }
            }

            Button(
                onClick = {
                    navHostController.navigate(Screen.comp1.route)
                    isClicked.value = false
                }
            ) {
                Text(text = "Back")
            }
        }
    }
}
