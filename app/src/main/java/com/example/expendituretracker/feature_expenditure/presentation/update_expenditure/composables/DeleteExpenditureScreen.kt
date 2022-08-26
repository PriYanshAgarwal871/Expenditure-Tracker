package com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.composables

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen
import com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.UpdateEventType
import com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.UpdateExpenditureViewModel
import java.time.Month

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DeleteExpenditure(
    navHostController: NavHostController,
    viewModel: UpdateExpenditureViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = viewModel.state
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
                    Text(text = selectedMonth.toString())
                }
            }
        }
        val context = LocalContext.current
        Button(
            onClick = {
                viewModel.onEvent(
                    UpdateEventType.DeleteExpenditure(
                        convertToJavaMonth(month.value)
                    )
                )
                Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show()
                navHostController.navigate(Screen.MainScreen.route)
            }
        ) {
            Text(text = "Delete")
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