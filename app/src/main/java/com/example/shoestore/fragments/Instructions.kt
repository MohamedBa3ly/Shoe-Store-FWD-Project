package com.example.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionsBinding

class Instructions : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instructions,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Button that user can press on it in Instructions Screen screen :
        navigateToShoeList()
    }

    //to navigate from instruction screen to shoe list screen :
    private fun navigateToShoeList(){
        binding.btnInstructions.setOnClickListener {
            findNavController().navigate(InstructionsDirections.actionInstructionsToShoeList())
        }
    }

}