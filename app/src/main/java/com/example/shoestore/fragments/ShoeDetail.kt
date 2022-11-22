package com.example.shoestore.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailBinding
import com.example.shoestore.viewmodel.SharedViewModel
import com.example.shoestore.viewmodel.Shoe

class ShoeDetail : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val sharedViewModel : SharedViewModel by activityViewModels()
    private var shoe = Shoe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initializing variable that i made in xml and lifecycleOwner :
        binding.lifecycleOwner = this
        binding.shoeVariable = shoe

        // Two button that user can press on it in shoe detail screen :
        save()
        cancel()
    }

    //Cancel button to return to detail screen:
    private fun cancel(){
        binding.btnCancel.setOnClickListener {
            //Navigate upp to destroy fragment :
            findNavController().navigateUp()
        }
    }

    //Check for null entry :
    private fun checkForNullEntry(shoe: Shoe):Boolean{
        return shoe.shoeName!="" && shoe.companyName!="" && shoe.shoeSize!=null && shoe.shoeDescription!=""
    }

    //Save button to add shoe in shoe list screen :
    private fun save(){
        binding.btnSave.setOnClickListener {
            //Store data of shoe in sharedViewModel (First check for null entry) :
            if (checkForNullEntry(shoe)){
                sharedViewModel.addShoe(shoe)
                //Navigate upp to destroy fragment :
                findNavController().navigateUp()
            }else{
                //Make a toast when no entry data is found :
                Toast.makeText(requireContext(),"Enter Empty Fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}