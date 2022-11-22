package com.example.shoestore


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this activity
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        // setup toolbar :
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.fragment_host)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.login,R.id.shoeList))
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)

        // To change text in Toolbar by Id in any destination i want :
        navController.addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.login -> loginToolbarText()
                R.id.welcomeScreen -> welcomeTextToolbar()
                R.id.instructions -> instructionsToolbarText()
                R.id.shoeList -> shoeListToolbarText()
                R.id.shoeDetail -> shoeDetailToolbarText()
            }
        }
    }

    // Functions To Change Text in Toolbar at five screens:
    private fun loginToolbarText(){
        binding.toolbar.title = "Login"
    }

    private fun welcomeTextToolbar(){
        binding.toolbar.title = "Welcome Screen"
    }

    private fun instructionsToolbarText(){
        binding.toolbar.title = "Instructions"
    }

    private fun shoeListToolbarText(){
        binding.toolbar.title = "Shoe List"
    }

    private fun shoeDetailToolbarText(){
        binding.toolbar.title = "Shoe Details"
    }

}