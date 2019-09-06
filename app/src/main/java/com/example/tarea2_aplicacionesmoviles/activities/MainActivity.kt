package com.example.tarea2_aplicacionesmoviles.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.example.tarea2_aplicacionesmoviles.R
import com.example.tarea2_aplicacionesmoviles.fragments.HomeFragment
import com.example.tarea2_aplicacionesmoviles.fragments.SourceFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home
        //val setting
    }

    private fun fragmentFor(item: MenuItem) : Fragment{
        when(item.itemId){
            R.id.navigation_home -> {
                return HomeFragment()
            }
            R.id.navigation_source -> {
                return SourceFragment()
            }
        }
        return HomeFragment()
    }

    private fun navigateTo(item: MenuItem): Boolean{
        item.setChecked(true)
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragmentFor(item))
            .commit() > 0

    }

}
