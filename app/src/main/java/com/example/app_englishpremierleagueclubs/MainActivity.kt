package com.example.app_englishpremierleagueclubs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_englishpremierleagueclubs.Adapter.SoccerTileAdapter
import com.example.app_englishpremierleagueclubs.Fragments.HomeFragment
import com.example.app_englishpremierleagueclubs.Model.SoccerTile
import com.example.app_englishpremierleagueclubs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SheradPref.init(this)

        if (savedInstanceState == null) {
            val homeFragment = HomeFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, homeFragment)
                .commit()
        }
    }

    //  welcome to epl application
}
