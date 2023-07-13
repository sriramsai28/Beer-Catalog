package com.sriram.beerlist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BeerEntity::class],
    version = 100,
    exportSchema = false
)
abstract class BeerDataBase : RoomDatabase() {
    abstract val dao: BeerDao
}