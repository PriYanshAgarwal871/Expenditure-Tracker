package com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.composables

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen
import com.example.expendituretracker.R
import com.example.expendituretracker.feature_expenditure.domain.model.Expenditure
import com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.UpdateEventType
import com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.UpdateExpenditureViewModel
import java.time.Month


/* fix bugs
    1. app crashes when textfield is empty
    2. align the month drop down menu with the month textfield
    3. remove focus from last text field after clicking insert
 */

//represents insert option screen

@Composable
fun InsertExpenditure(
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
        
        val foodExpenditure = remember { mutableStateOf(0)}
        val utilityExpenditure = remember { mutableStateOf(0) }
        val billExpenditure = remember { mutableStateOf(0)}
        val otherExpenditure = remember { mutableStateOf(0)}

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

        OutlinedTextField(
            value = foodExpenditure.value.toString() ,
            onValueChange = {
                foodExpenditure.value = it.toInt()
            },
            label = { Text(text = "Food Expenditure")},
            placeholder = { Text(text = "0")},
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_indian_rupee_symbol), contentDescription ="indian rupee" )
            }
        )


        OutlinedTextField(
            value = utilityExpenditure.value.toString() ,
            onValueChange = {
                utilityExpenditure.value = it.toInt()
            },
            label = { Text(text = "Utility Expenditure")},
            placeholder = { Text(text = "0")},
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_indian_rupee_symbol), contentDescription ="indian rupee" )
            }
        )
        OutlinedTextField(
            value = billExpenditure.value.toString() ,
            onValueChange = {
                billExpenditure.value = it.toInt()
            },
            label = { Text(text = "Bill Expenditure")},
            placeholder = { Text(text = "0")},
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_indian_rupee_symbol), contentDescription ="indian rupee" )
            }
        )

        OutlinedTextField(
            value = otherExpenditure.value.toString() ,
            onValueChange = {
                otherExpenditure.value = it.toInt()
            },
            label = { Text(text = "Other Expenditure")},
            placeholder = { Text(text = "0")},
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_indian_rupee_symbol), contentDescription ="indian rupee" )
            }
        )
        val context = LocalContext.current
        Button(
            onClick = {
                viewModel.onEvent(
                    UpdateEventType.InsertExpenditure(
                        Expenditure(
                            month = convertToJavaMonth(month.value.uppercase()),
                            foodExpenditure = foodExpenditure.value,
                            utilityExpenditure = utilityExpenditure.value,
                            billExpenditure = billExpenditure.value,
                            otherExpenditure = otherExpenditure.value
                        )
                    )
                )
                Toast.makeText(context,"Successfully Inserted",Toast.LENGTH_SHORT).show()
                navHostController.navigate(Screen.MainScreen.route)
            }
        ){
            Text(
                text = "Insert",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}

private fun convertToJavaMonth(month : String) : Month{
    return Month.valueOf(month)
}