package buu.informatics.s59160975.thairecipes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import buu.informatics.s59160975.thairecipes.Adapter.MyAdapter
import buu.informatics.s59160975.thairecipes.DataClass.recipes
import buu.informatics.s59160975.thairecipes.databinding.FragmentDessertListBinding
import kotlinx.android.synthetic.main.fragment_maincourses_list.*

/**
 * A simple [Fragment] subclass.
 */
class DessertListFragment : Fragment() {

    val ListRecipes = listOf(
        recipes("ขนมชั้นใบเตย", "https://sites.google.com/site/flukekaks/_/rsrc/1359988050704/xahar-laea-khxngkin-ni-meuxng-thiy/khnm-chan/images.jpg",
            "ส่วนผสม\n" +
                    "แป้งข้าวเจ้า 40 กรัม\n" +
                    "แป้งท้าวยายม่อม 40 กรัม\n" +
                    "แป้งมัน 300 กรัม\n" +
                    "กะทิ 500 มิลลิลิตร\n" +
                    "น้ำตาลทราย 500 กรัม\n" +
                    "ใบเตย 3-4 ใบ\n" +
                    "กลิ่นมะลิ 1/2 ช้อนชา\n" +
                    "น้ำใบเตย 1/4 ถ้วย\n" +
                    "\n" +
                    "วิธีทำ\n" +
                    "1.ผสมน้ำตาลทรายกับกะทิ แล้วนำไปตั้งไฟอ่อนๆ พอให้อุ่นจนน้ำตาลทรายเริ่มละลาย ไม่ต้องต้มให้เดือด เสร็จแล้ววางพักไว้\n" +
                    "2.ผสมแป้งทั้งสามอย่างเข้าด้วยกัน แล้วค่อยๆ เติมน้ำกะทิลงไป คนจนแป้งละลาย หากไม่แน่ใจว่าแป้งละลายหมด ให้นำไปกรองกับกระชอนตาถี่\n" +
                    "3.แบ่งน้ำกะทิไว้สองชาม ชามแรกผสมกลิ่นมะลิลงไป คนให้เข้ากัน อีกหนึ่งชามใส่น้ำใบเตยลงไป คนให้เข้ากัน\n" +
                    "4.เตรียมพิมพ์สำหรับขนมชั้น ใส่น้ำในลังถึง ต้มน้ำจนเดือด แล้วนำแม่พิมพ์ลงไปนึ่งวอร์มก่อน 15 นาที\n" +
                    "5.เสร็จแล้วก็เทขนมลงไปทีละชั้น ชั้นละเท่าๆ กัน ระหว่างสลับสีกันให้นึ่งชั้นละ 5 นาที จนเต็มแม่พิมพ์\n" +
                    "6.นึ่งเสร็จแล้ว นำขนมออกมาหั่นเป็นชิ้นสี่เหลี่ยม")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentDessertListBinding>(inflater,R.layout.fragment_dessert_list, container, false)
        binding.buttonMaincourses.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_dessertList_Fragment_to_maincoursesList_Fragment)
        }
        return binding.root
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
        findNavController().navigate(DessertListFragmentDirections.actionDessertListFragmentToDessertFragment(
            list.name, list.image, list.detail
        ))
    }


}
