package com.vashisthg.daggertest.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.vashisthg.daggertest.R
import com.vashisthg.library.LibraryActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by gauravvashisth
 */
class MainActivity : AppCompatActivity() {
    @Inject lateinit var appLevelModule: String
    @Inject lateinit var mainRepo: MainRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        (findViewById<TextView>(R.id.from_app_level_module) as TextView).text = appLevelModule
        (findViewById<TextView>(R.id.from_activity_level_module) as TextView).text = mainRepo.getData()
        findViewById<Button>(R.id.open_library).setOnClickListener({
            startActivity(Intent(this, LibraryActivity::class.java))
        })

    }
}
