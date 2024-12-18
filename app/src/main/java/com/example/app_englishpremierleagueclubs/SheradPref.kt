package com.example.app_englishpremierleagueclubs

import android.content.Context
import android.content.SharedPreferences

object SheradPref {
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {

        sharedPreferences = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)

    }
    fun setSoccerTileFavorite(id: String, value: Boolean) {

        setBoolean(id, value)
    }

    fun getSoccerTileFavorite(id: String): Boolean {
        return getBoolean(id)
    }

    private fun setBoolean(name: String, value: Boolean) {

        sharedPreferences.edit().putBoolean(name, value).apply()

    }

    private fun getBoolean(name: String, defaultValue: Boolean = false): Boolean {

        return sharedPreferences.getBoolean(name, defaultValue)

    }

    fun clear(){
        sharedPreferences.edit().clear().apply()

    }

}