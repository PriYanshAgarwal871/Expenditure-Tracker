package com.example.expendituretracker.Navigation

sealed class Screen(val route : String){
    object comp1 : Screen(route = "Screen_1")
    object comp2 : Screen(route = "Screen_2")
    object comp3 : Screen(route = "Screen_3")
    object comp4 : Screen(route = "Screen_4")
    object comp5 : Screen(route = "Screen_5")
    object comp6 : Screen(route = "Screen_6")
    object comp7 : Screen(route = "Screen_7")
}

