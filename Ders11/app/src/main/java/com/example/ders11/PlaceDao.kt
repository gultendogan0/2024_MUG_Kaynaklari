package com.example.ders11

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface PlaceDao {

    @Query("SELECT * FROM Place")
    fun getAll() : Observable<List<Place>>

    @Insert
    fun insert(place: Place) : Completable

    @Delete
    fun delete(place: Place) : Completable
}


