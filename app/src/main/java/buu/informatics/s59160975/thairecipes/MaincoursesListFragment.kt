package buu.informatics.s59160975.thairecipes


import android.os.Bundle
import android.view.*
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import buu.informatics.s59160975.thairecipes.Adapter.MyAdapter
import buu.informatics.s59160975.thairecipes.DataClass.recipes
import buu.informatics.s59160975.thairecipes.databinding.FragmentMaincoursesListBinding
import kotlinx.android.synthetic.main.fragment_maincourses_list.*

/**
 * A simple [Fragment] subclass.
 */
class MaincoursesListFragment : Fragment() {

    val ListRecipes = listOf(
        recipes("ต้มยำกุ้ง", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Tom_yam_kung_maphrao_on_nam_khon.jpg/800px-Tom_yam_kung_maphrao_on_nam_khon.jpg",
            "ส่วนผสม\t\n" +
                    "กุ้ง 1/2ถ้วยตวง\n" +
                    "น้ำ 2 1/2 ถ้วยตวง\n" +
                    "ตะไคร้ 2-3 ต้น\n" +
                    "ข่าซอย 3 ช้อนโต๊ะ\n" +
                    "เห็ดฟางหั่น 1/2 ถ้วยตวง\n" +
                    "พริกขี้หนู 5 เม็ด\n" +
                    "พริกเผา 1-2 ช้อนโต๊ะ\n" +
                    "น้ำปลา 4 ช้อนโต๊ะ\n" +
                    "นมข้นจืด 1/2 ถ้วยตวง\n" +
                    "ใบมะกรูด 5 ใบ\n" +
                    "น้ำมะนาว 2 ช้อนโต๊ะ\n" +
                    "ผักชีสับ 2 ช้อนโต๊ะ\n" +
                    "\n" +
                    "ขั้นตอน\t\n" +
                    "1. ตั้งหม้อใส่น้ำรอจนเดือดจัด ใส่ข่าซอย ตะไคร้บุบเล็กน้อยลงไป รอเดือดแล้วใส่เห็ดดฟาง ลดไฟเหลือไฟกลางรอจนน้ำซุปเดือด\n" +
                    "2.ตามด้วยพริกขี้หนูแดง น้ำพริกเผา น้ำปลา คนจนเข้ากัน เมื่อเดือดอีกครั้งใส่เนื้อกุ้งลงไปแล้วตามด้วยนม อุ่นจนเดือดเล็กน้อยอีกครั้ง ฉีกใบมะกรูดใส่ลงไป ปิดไฟบีบมะนาว แล้วโรยด้วยผักชี")
    )

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipesAdapter = MyAdapter(ListRecipes,{ListRecipes -> onitemclick(ListRecipes)})
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = recipesAdapter
        }
        recipesAdapter.notifyDataSetChanged()
    }
    fun onitemclick(list: recipes){
        findNavController().navigate(MaincoursesListFragmentDirections.actionMaincoursesListFragmentToMaincoursesFragment(
            list.name, list.image, list.detail
        ))
    }


}
