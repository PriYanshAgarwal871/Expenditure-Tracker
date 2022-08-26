package com.example.expendituretracker.feature_expenditure.DI

import android.app.Application
import com.example.expendituretracker.feature_expenditure.data.data_source.ExpenditureDao
import com.example.expendituretracker.feature_expenditure.data.data_source.ExpenditureDatabase
import com.example.expendituretracker.feature_expenditure.data.repository.ExpenditureRepositoryImpl
import com.example.expendituretracker.feature_expenditure.domain.repository.ExpenditureRepository
import com.example.expendituretracker.feature_expenditure.domain.use_case.*
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
        db: ExpenditureDatabase
    ) : ExpenditureRepository = ExpenditureRepositoryImpl(db.getDao())

    @Provides
    @Singleton
    fun getExpenditureUpdateUseCases(
        expenditureRepository: ExpenditureRepository
    ):ExpenditureUseCases{
            return ExpenditureUseCases(
            InsertExpenditureUseCase(expenditureRepository),
            DeleteExpenditureUseCase(expenditureRepository),
            UpdateExpenditureUseCase(expenditureRepository),
            AllExpenditureUseCase(expenditureRepository),
            MonthExpenditureUseCase(expenditureRepository)
        )
    }

}