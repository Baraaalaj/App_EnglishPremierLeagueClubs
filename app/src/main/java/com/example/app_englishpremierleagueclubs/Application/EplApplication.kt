package com.example.app_englishpremierleagueclubs.Application

import android.app.Application
import com.example.app_englishpremierleagueclubs.Model.SoccerTile
import com.example.app_englishpremierleagueclubs.SheradPref

class EplApplication : Application() {

companion object {

    lateinit var application: EplApplication

}

    override fun onCreate() {
        super.onCreate()
        application = this

        SheradPref.init(this)
    }
}