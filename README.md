#Expenditure-Tracker

An android app that allows the user to input , edit , view his/her expenditures for each month. Languages Used - Kotlin UI developed using Jetpack Compose Library. Business Logic and Backend written in Kotlin. Room Persistence Library used in backend to store the data into a local database.

#Entity Definition For my app , I've a single entity called "expenditure_table" which has 5 attributes.

Month (Primary key)
FoodExpenditure
BillExpenditure
UtilityExpenditure
OtherExpenditure
#Features

All expenditure --> Displays all the expenditures of each month entered by the user.
Update expenditure --> This feature has 3 more sub-features a. Insert --> Insert a new expenditure b. Update --> Update an entered expenditure c. Delete --> Delete an expenditure
Month expenditure --> (HUGE BUG , hence not a working feature) Displays the expenditure for the entered month if present in the database.
#Some info Currently this app has a very basic UI and a very basic database structure consisting of just one entity.The main idea behind this project was to polish my backend skills.So i didnt focus much on the UI.

#Future modifications 1.Improve the UI to make it more user appealing. 2.Currently this app doesn't follow any standard architecture. Hence, one of the main objective would to be to implement a CLEAN architecture in this app without harming the working of the app. 3.There is a HUGE BUG in one of the feature "Get expenditure by month". UTMOST PRIORITY MUST BE GIVEN IN FIXING THIS BUG.
