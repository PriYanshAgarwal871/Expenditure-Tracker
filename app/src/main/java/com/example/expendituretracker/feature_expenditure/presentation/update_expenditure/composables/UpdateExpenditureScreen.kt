package com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.composables

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.expendituretracker.feature_expenditure.common.Navigation.Screen
import com.example.expendituretracker.feature_expenditure.domain.model.Expenditure
import com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.UpdateEventType
import com.example.expendituretracker.feature_expenditure.presentation.update_expenditure.UpdateExpenditureViewModel
import java.time.Month


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UpdateExpenditure(
    navHostController: NavHostController,
    viewModel: UpdateExpenditureViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF696880))
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val rupeeID = com.example.expendituretracker.R.drawable.ic_indian_rupee_symbol
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

        val month = remember { mutableStateOf("") }
        val expanded = remember { mutableStateOf(false) }

        val foodExpenditure = remember { mutableStateOf("") }
        val utilityExpenditure = remember { mutableStateOf("") }
        val billExpenditure = remember { mutableStateOf("") }
        val otherExpenditure = remember { mutableStateOf("") }
        val size = remember { mutableStateOf(Size.Zero) }

        OutlinedTextField(
            value = month.value,
            onValueChange = { month.value = it },
            label = { Text(text = "Month") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Green,
                focusedBorderColor = Color.Green,
                textColor = Color.Green,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Green,
                trailingIconColor = Color.DarkGray,
                placeholderColor = Color.Green
            ),
            modifier = Modifier.onGloballyPositioned { coordinates ->
                size.value = coordinates.size.toSize()
            },
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
            onDismissRequest = { expanded.value = false },
            modifier = Modifier
                .background(color = Color(0xFF696880))
                .width(with(LocalDensity.current) { size.value.width.toDp() })
        ) {
            listOfMonths.forEach { selectedMonth ->
                DropdownMenuItem(
                    onClick = {
                        month.value = selectedMonth
                        expanded.value = false
                    }
                ) {
                    Text(
                        text = selectedMonth,
                        color = Color.Yellow
                    )
                }
            }
        }

        OutlinedTextField(
            value = foodExpenditure.value,
            onValueChange = {
                foodExpenditure.value = it
            },
            label = { Text(text = "Food Expenditure") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Green,
                focusedBorderColor = Color.Green,
                textColor = Color.Green,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Green,
                leadingIconColor = Color.Gray,
                placeholderColor = Color.Green
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = rupeeID),
                    contentDescription = "Rupee symbol"
                )
            }
        )

        OutlinedTextField(
            value = utilityExpenditure.value,
            onValueChange = {
                utilityExpenditure.value = it
            },
            label = { Text(text = "Utility Expenditure") },
//            placeholder = { Text(text = "0")},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Green,
                focusedBorderColor = Color.Green,
                textColor = Color.Green,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Green,
                leadingIconColor = Color.Gray,
                placeholderColor = Color.Green
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = rupeeID),
                    contentDescription = "Rupee symbol"
                )
            }
        )

        OutlinedTextField(
            value = billExpenditure.value,
            onValueChange = {
                billExpenditure.value = it
            },
            label = { Text(text = "Bill Expenditure") },
//            placeholder = { Text(text = "0")},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Green,
                focusedBorderColor = Color.Green,
                textColor = Color.Green,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Green,
                leadingIconColor =  Color.Gray,
                placeholderColor = Color.Green
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = rupeeID),
                    contentDescription = "Rupee symbol"
                )
            }
        )

        OutlinedTextField(
            value = otherExpenditure.value,
            onValueChange = {
                otherExpenditure.value = it
            },
            label = { Text(text = "Other Expenditure") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Green,
                focusedBorderColor = Color.Green,
                textColor = Color.Green,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Green,
                leadingIconColor = Color.Gray,
                placeholderColor = Color.Green
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = rupeeID),
                    contentDescription = "Rupee symbol"
                )
            }
        )
        val context = LocalContext.current
        Button(
            onClick = {
                viewModel.onEvent(
                    UpdateEventType.UpdateExpenditure(
                        Expenditure(
                            month = convertToJavaMonth(month.value),
                            foodExpenditure = foodExpenditure.value.toInt(),
                            utilityExpenditure = utilityExpenditure.value.toInt(),
                            billExpenditure = billExpenditure.value.toInt(),
                            otherExpenditure = otherExpenditure.value.toInt()
                        )
                    )
                )
                Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show()
                navHostController.navigate(Screen.MainScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0492C2),
                contentColor = Color.Yellow
            )
        ) {
            Text(
                text = "Update",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
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