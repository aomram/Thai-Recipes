package buu.informatics.s59160975.thairecipes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160975.thairecipes.databinding.FragmentMaincoursesListBinding

/**
 * A simple [Fragment] subclass.
 */
class MaincoursesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMaincoursesListBinding>(inflater,R.layout.fragment_maincourses_list, container, false)
        binding.dessButton.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_maincoursesList_Fragment_to_dessertList_Fragment)
        }
        binding.aboutButton.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_maincoursesList_Fragment_to_aboutFragment)
        }
        return binding.root

    }


}
