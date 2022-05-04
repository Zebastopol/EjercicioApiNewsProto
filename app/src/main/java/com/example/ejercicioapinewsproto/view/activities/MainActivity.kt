package com.example.ejercicioapinewsproto.view.activities

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import com.example.ejercicioapinewsproto.R
import com.example.ejercicioapinewsproto.databinding.ActivityMainBinding
import com.example.ejercicioapinewsproto.view.fragments.BuscarNoticias
import com.example.ejercicioapinewsproto.view.fragments.PortalNoticias
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var myToogle: ActionBarDrawerToggle
    private lateinit var myToolbar:  Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myNavigationView.setNavigationItemSelectedListener(this)
        myToolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolbar)
        supportFragmentManager.beginTransaction().add(R.id.FrameLayout, PortalNoticias()).commit()
        myToogle = setDrawerToogle()
        binding.myDrawerLayout.addDrawerListener(myToogle)


    }

    private fun setDrawerToogle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(
            this,
            binding.myDrawerLayout,myToolbar,
            R.string.navegation_drawer_open,
            R.string.navegation_drawer_close
        )

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        myToogle.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        myToogle.syncState()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if ( myToogle.onOptionsItemSelected(item)){
             true
        } else super.onOptionsItemSelected(item)
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        when (item.itemId){

            R.id.nav_portal -> ft.replace(R.id.FrameLayout, PortalNoticias()).commit()
            R.id.nav_busqueda -> ft.replace(R.id.FrameLayout, BuscarNoticias()).commit()
            /*R.id.nav_Neg ->ft.replace(R.id.FrameLayout, Negocios()).commit()
            R.id.nav_Tec ->ft.replace(R.id.FrameLayout, Tecnologia()).commit()
            R.id.nav_Cien ->ft.replace(R.id.FrameLayout, Ciencia()).commit()
            R.id.nav_Dep ->ft.replace(R.id.FrameLayout, Deportes()).commit()
            R.id.nav_Entre ->ft.replace(R.id.FrameLayout, Entretenimiento()).commit()
            R.id.nav_Salud ->ft.replace(R.id.FrameLayout, Salud()).commit()*/
            R.id.nav_Exit -> {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }


        }
        //startActivity(intent)

        title = item.title
        binding.myDrawerLayout.closeDrawers()

        return true
    }
}
/*
class DrawerNavegation : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var bind: ActivityDrawerNavegationBinding
    private lateinit var myDrawer: DrawerLayout
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDrawerNavegationBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.myToolbar = toolbar.setSupportActionBar(toolbar)
        myDrawer = bind.myDrawerLayout

        myToggle = ActionBarDrawerToggle(this,myDrawer,toolbar,R.string.navegation_drawer_open,R.string.navegation_drawer_close)
        myDrawer.addDrawerListener(myToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        bind.myNavigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_portal -> Toast.makeText(this,"Ir al portal de noticias", Toast.LENGTH_SHORT).show()
            R.id.nav_busqueda -> Toast.makeText(this,"Ir a la búsqueda personalizada", Toast.LENGTH_SHORT).show()

        }
        myDrawer.closeDrawer(GravityCompat.START)
        return true
    }



*/