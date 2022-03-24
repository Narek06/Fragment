package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(firstFragment(), "firstFragment")
        addFragment(lastFragment(), "lastFragment")
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            replaceFragment(firstFragment(), "firstFragment")
        }
        val btn2 = findViewById<Button>(R.id.button2)
        btn2.setOnClickListener {
            replaceFragment(lastFragment(), "lastFragment")
        }
    }

    fun addFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, fragment, tag)
            .commit()
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        val backStatName = fragment.javaClass.name
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment, tag)
            .addToBackStack(backStatName).commit()
    }
}