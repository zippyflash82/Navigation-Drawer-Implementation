package com.example.navdrawerimplementation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.drawer_main.*

class MainDrawer : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        displayScreen(-1)

        //Accessing the header file
        val header =  nav_view.getHeaderView(0)
        val headerImageView = header.findViewById<ImageView>(R.id.header_iv)
        val headerTitle = header.findViewById<TextView>(R.id.header_title)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    fun displayScreen(id: Int) {
        when (id) {
            R.id.nav_home -> {
                //supportFragmentManager.beginTransaction().replace(R.id.relativelayout, RepoFragment()).commit()
                // val intent = Intent(this, MainActivity2::class.java)
                //startActivity
                Toast.makeText(this,"Home Button Clicked",Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onBackPressed() {
         if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
              drawer_layout.closeDrawer(GravityCompat.START)
          } else {
              super.onBackPressed()
          }
    }

}

