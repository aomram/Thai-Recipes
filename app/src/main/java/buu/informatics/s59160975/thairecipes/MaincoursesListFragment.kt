package buu.informatics.s59160975.thairecipes


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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
            Toast.makeText(activity, "You select menu dessert", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_maincoursesList_Fragment_to_dessertList_Fragment)
        }
        setHasOptionsMenu(true)
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
                view!!.findNavController()) || super.onOptionsItemSelected(item)
    }


}
