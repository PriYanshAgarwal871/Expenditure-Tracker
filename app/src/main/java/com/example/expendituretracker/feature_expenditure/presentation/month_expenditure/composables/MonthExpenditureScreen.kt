package com.example.expendituretracker.feature_expenditure.presentation.month_expenditure.composables

import android.os.Build
import android.widget.Toast
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
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
    backgroundColor : Color = Color(0xFF696880),
    textcolor : Color = Color.Yellow
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .weight(weight)
            .background(backgroundColor)
            .padding(8.dp),
        color = textcolor
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
            .background(color = Color(0xFF696880))
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
        val month = remember { mutableStateOf("") }
        val expanded = remember { mutableStateOf(false) }
        val isClicked = remember { mutableStateOf(false) }
        val size = remember { mutableStateOf(Size.Zero) }

        OutlinedTextField(
            value = month.value,
            onValueChange = { month.value = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Green,
                focusedBorderColor = Color.Green,
                textColor = Color.Green,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Green,
                trailingIconColor = Color.DarkGray,
                placeholderColor = Color.Green
            ),
            modifier = Modifier
                .onGloballyPositioned { coordiantes ->
                    size.value = coordiantes.size.toSize()
                },
            label = { Text(text = "Month") },
            placeholder = { Text(text = "Month")},
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
                .width(with(LocalDensity.current) { size.value.width.toDp() })
                .background(color = Color(0xFF696880))
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


        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0492C2),
                contentColor = Color.Yellow
            ),
            onClick = {
                viewModel.onEvent(
                    convertToJavaMonth(month.value)
                )
                isClicked.value = true
            }
        ) {
            Text(text = "Get")
        }
        val context = LocalContext.current
        if (isClicked.value) {
            val exp = state.expenditure
            if(exp == null){
                Toast.makeText(context, "No data found" , Toast.LENGTH_SHORT).show()
                isClicked.value = false
                navHostController.navigate(Screen.MainScreen.route)
            }
            else {
                Column {
                    Row {
                        HeaderCell(
                            text = "Month",
                            weight = .3f,
                            fontWeight = FontWeight.Bold,
                            backgroundColor = Color.Yellow,
                            textColor = Color.Red
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
                            backgroundColor = Color.Yellow,
                            textColor = Color.Red
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
                            backgroundColor = Color.Yellow,
                            textColor = Color.Red
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
                            backgroundColor = Color.Yellow,
                            textColor = Color.Red
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
                            backgroundColor = Color.Yellow,
                            textColor = Color.Red
                        )
                        HeaderCell(
                            text = exp.otherExpenditure.toString(),
                            weight = .4f
                        )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF0492C2),
                        contentColor = Color.Yellow
                    ),onClick = {
                        navHostController.navigate(Screen.MainScreen.route)
                        isClicked.value = false
                    }
                ) {
                    Text(text = "Back")
                }
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