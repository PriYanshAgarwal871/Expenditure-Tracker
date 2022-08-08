package com.example.expendituretracker.DI

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expendituretracker.Database.ExpenditureDao
import com.example.expendituretracker.Database.ExpenditureDatabase
import com.example.expendituretracker.Database.ExpenditureRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getDatabase(
        application: Application
    ) : ExpenditureDatabase = ExpenditureDatabase.getDatabase(application)


    @Provides
    @Singleton
    fun getExpenditureDao(
        db : ExpenditureDatabase
    ) : ExpenditureDao = db.getDao()

    @Provides
    @Singleton
    fun getExpenditureRepository(
        expenditureDao: ExpenditureDao
    ) : ExpenditureRepository = ExpenditureRepository(expenditureDao)



}