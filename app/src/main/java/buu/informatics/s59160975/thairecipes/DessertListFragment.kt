package buu.informatics.s59160975.thairecipes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160975.thairecipes.databinding.FragmentDessertListBinding

/**
 * A simple [Fragment] subclass.
 */
class DessertListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentDessertListBinding>(inflater,R.layout.fragment_dessert_list, container, false)
        binding.buttonMaincourses.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_dessertList_Fragment_to_maincoursesList_Fragment)
        }
        return binding.root
    }



}
