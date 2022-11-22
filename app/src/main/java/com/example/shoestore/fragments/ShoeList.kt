package com.example.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.viewmodel.SharedViewModel

class ShoeList : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Add logout menu only in shoe list fragment and when u press, it return to login screen:
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout_icon -> {
                        findNavController().navigate(ShoeListDirections.actionShoeListToLogin())
                        return true
                    }
                    else -> {
                        false
                    }
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        //Navigate to shoe detail screen :
        floatingActionButton()

        //To add a new show details:
        addShoe()

    }

    //Navigate to shoe detail screen :
    private fun floatingActionButton() {
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListDirections.actionShoeListToShoeDetail())
        }
    }

    //To add a new show details:
    private fun addShoe() {
        sharedViewModel.shoeDetail.observe(viewLifecycleOwner) {

            //Make a new list to receive each item in it .
            val list: ArrayList<String> = ArrayList()

            //Make (for) to take the shoe details (name-company-size-description) :
            for (shoe in it) {

                val name = shoe.shoeName
                val company = shoe.companyName
                val size = shoe.shoeSize
                val description = shoe.shoeDescription

                //I will make name in new line, company in new line also size and description, each shoe separated by line of stars , look now is better :
                val shoeDetails =
                    " Name: $name\n Company: $company\n Size: $size\n Description: $description\n ***************************************"

                //Add all data in a List :
                list.add(shoeDetails)

                // You must delete all views first when u add a new shoe in a list :
                binding.linearLayout.removeAllViews()

                //To make a text view for every item in list :
                for (i in 0 until list.size) {
                    //Make a new textView :
                    val txtName = TextView(requireContext())

                    //Set a List items in Text View as a string : (changed size also)
                    txtName.text = list[i]
                    txtName.textSize = 20F

                    //Make Text View wrap_content :
                    txtName.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                    //Now u can add TextView that contain a List of shoe in linearLayout :
                    binding.linearLayout.addView(txtName)
                }
            }
        }
    }


}