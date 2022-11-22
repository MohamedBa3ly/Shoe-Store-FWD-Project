package com.example.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding

class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Two button that user can press on it in login screen :
        signIn()
        createNewAccount()
    }

    //To navigate from login screen to welcome screen :
    private fun signIn(){
        binding.btnSignIn.setOnClickListener {
            findNavController().navigate(LoginDirections.actionLoginToWelcomeScreen())
        }
    }

    //To navigate from login screen to welcome screen :
    private fun createNewAccount(){
        binding.btnCreateNewAccount.setOnClickListener {
            findNavController().navigate(LoginDirections.actionLoginToWelcomeScreen())
        }
    }

}