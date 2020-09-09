package com.flpereira.projetomvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.flpereira.projetomvvm.data.db.entities.Quote
import com.flpereira.projetomvvm.data.db.entities.User

@Database(
    entities = [User::class, Quote::class],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getQuoteDao(): QuoteDao

    companion object{

        @Volatile
        private var instance: AppDataBase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "MyDatabase.db"
            ).build()
    }
}