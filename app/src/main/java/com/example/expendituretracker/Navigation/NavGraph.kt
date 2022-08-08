package com.example.expendituretracker.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expendituretracker.Composables.*
import com.example.expendituretracker.ViewModel.ExpenditureViewModel
import javax.inject.Inject

@Composable
fun SetNavGraph (navController: NavHostController , expenditureViewModel: ExpenditureViewModel){
    NavHost(navController = navController ,
            startDestination = Screen.comp1.route
    ){
        composable(route = Screen.comp1.route ){
            Comp1(navController)
        }
        composable(route = Screen.comp2.route){
            Comp2(navController)
        }
        composable(route = Screen.comp3.route){
            Comp3(navController , expenditureViewModel)
        }
        composable(route = Screen.comp4.route){
            Comp4(navController,expenditureViewModel)
        }
        composable(route = Screen.comp5.route){
            Comp5(navController, expenditureViewModel )
        }
        composable(route = Screen.comp6.route){
            Comp6(navController, expenditureViewModel )
        }
        composable(route = Screen.comp7.route){
            Comp7(navController, expenditureViewModel )
        }
    }
}
