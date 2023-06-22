package edu.augustohernandez.myfavouritespets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import edu.augustohernandez.myfavouritespets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the DrawerLayout and NavigationView
        val drawerLayout = binding.drawerLayout
        val navigationView = binding.navView

        /*En esta parte se obtiene una referencia de NavHostFragment
         del fragmentContainer de esta actividad. La idea es que se pueda tener acceso
         a su navController*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //Se configura el AppBar para el DrawerLayout
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_list_fragment, R.id.nav_my_pets_fragment), drawerLayout)

        // Set up the ActionBar with the NavigationDrawer
        setSupportActionBar(findViewById(R.id.toolbar))

        /*Estos eventos configuran el Home como origen de
        * navegación y la habilitación de regresar a home
        * con el evento up por defecto, respectivamente*/
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Set up the NavigationView with the NavController
        navigationView.setupWithNavController(navController)

        /*Esta configuración permite el cierre automático del
        * panel de NavigationDrawer cuando se navege hacia un
        * destino.*/
        navController.addOnDestinationChangedListener { _, _, _ ->
            binding.drawerLayout.closeDrawers()
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
