package com.example.expendituretracker

import android.app.Application
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ExpenditureTrackerApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}