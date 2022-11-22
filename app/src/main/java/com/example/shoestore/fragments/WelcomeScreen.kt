package com.example.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {
    private lateinit var binding: FragmentWelcomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome_screen,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Button that user can press on it in Welcome screen :
        welcome()
    }

    //to navigate from welcomeScreen to Instruction Screen :
    private fun welcome(){
        binding.btnWelcome.setOnClickListener {
            findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstructions())
        }
    }
}