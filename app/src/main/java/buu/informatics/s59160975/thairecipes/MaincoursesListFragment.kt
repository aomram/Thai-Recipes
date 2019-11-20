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
                    "วิธีทำ\t\n" +
                    "1. ตั้งหม้อใส่น้ำรอจนเดือดจัด ใส่ข่าซอย ตะไคร้บุบเล็กน้อยลงไป รอเดือดแล้วใส่เห็ดดฟาง ลดไฟเหลือไฟกลางรอจนน้ำซุปเดือด\n" +
                    "2. ตามด้วยพริกขี้หนูแดง น้ำพริกเผา น้ำปลา คนจนเข้ากัน เมื่อเดือดอีกครั้งใส่เนื้อกุ้งลงไปแล้วตามด้วยนม อุ่นจนเดือดเล็กน้อยอีกครั้ง ฉีกใบมะกรูดใส่ลงไป ปิดไฟบีบมะนาว แล้วโรยด้วยผักชี"),
        recipes("แกงเขียวหวาน","https://img.kapook.com/u/2015/surauch/cook3/green-curry2.jpg",
            "ส่วนผสม\t\n" +
                    "น้ำพริกแกงเขียวหวาน 4 ช้อนโต๊ะ\n" +
                    "หัวกะทิ 1 ถ้วย\n" +
                    " เนื้อหมู 300 กรัม\n" +
                    "หางกะทิ 3 ถ้วย\n" +
                    "น้ำตาลปี๊บ 1/2 ช้อนโต๊ะ\n" +
                    "เกลือเม็ด 1 ช้อนโต๊ะ\n" +
                    "มะเขือพวง 100 กรัม\n" +
                    "มะเขือเปราะ (ผ่าสี่ส่วน) 1 ถ้วย\n" +
                    "พริกชี้ฟ้าแดง (หั่นเฉียง) 2 เม็ด\n" +
                    "ใบมะกรูด (ฉีกก้านกลาง) 4 ใบ\n" +
                    "ใบโหระพา (เด็ดเป็นใบ) 1 ถ้วย\n" +
                    "น้ำปลาดี 2 ช้อนโต๊ะ\n" +
                    "น้ำมันพืช (สำหรับผัด)\n" +
                    "ขนมจีน\n" +
                    "\n" +
                    "วิธีทำ\t\n" +
                    "1. ผัดน้ำพริกแกงเขียวหวานกับน้ำมันพืชจนหอม เทหัวกะทิใส่ลงไปเล็กน้อย รอจนกะทิแตกมันจึงใส่เนื้อหมูลงไปผัดพอสุก\n" +
                    "2. เติมหางกะทิลงไปเคี่ยวด้วยไฟอ่อน ปรุงรสด้วยน้ำตาลปี๊บและเกลือเม็ด\n" +
                    "3. เมื่อเนื้อหมูเริ่มนุ่มแล้วให้เติมหัวกะทิที่เหลือลงไป รอจนเดือดอีกครั้ง\n" +
                    "4. ใส่มะเขือพวง มะเขือเปราะ พริกชี้ฟ้า และใบมะกรูดลงไปคนให้เข้ากัน ยกออกจากเตา โรยใบโหระพาลงไป ตักใส่ชาม เสิร์ฟกับขนมจีน"),
        recipes("ผัดกระเพราหมูสับ","https://food.mthai.com/app/uploads/2017/07/Fried-basil-with-pork-Chops.jpg",
            "ส่วนผสม\n" +
                    "น้ำมันรำข้าว 1 ช้อนโต๊ะ\n" +
                    "กระเทียมสับ 1 ช้อนโต๊ะ\n" +
                    "พริกแดงตำ ตามชอบ\n" +
                    "หมูบด 200 กรัม\n" +
                    "น้ำสต็อก 1/4 ถ้วย\n" +
                    "ซอสหอยนางรม 1 1/2 ช้อนโต๊ะ\n" +
                    "น้ำปลา 1 ช้อนโต๊ะ\n" +
                    "น้ำตาลทราย 1 ช้อนชา\n" +
                    "ใบกะเพราตามชอบ\n" +
                    "\n" +
                    "วิธีทำ\n" +
                    "1. เทน้ำมันลงในกระทะตามด้วยกระเทียมสับและพริกแดงตำ ผัดจนมีกลิ่นหอม\n" +
                    "2. ตามด้วยหมูบด ผัดให้หมูสุกระดับหนึ่ง เทน้ำมันสต็อกลงไปเล็กน้อย ปรุงรสด้วยซอสหอยนางรม น้ำปลา และน้ำตาลทราย ผัดให้ทุกอย่างเข้ากัน\n" +
                    "3. ปิดไฟแล้วใส่ใบกะเพรา ผัดให้ใบกะเพราสะดุ้งความร้อนเล็กน้อย เสร็จแล้วตักราดข้าวเสิร์ฟคู่กับไข่ดาว"),
        recipes("ห่อหมกปลากราย","https://food.mthai.com/app/uploads/2017/09/Hor-mok.jpg",
            "ส่วนผสม\n" +
                    "พริกแห้ง 15-20 เม็ด\n" +
                    "ข่าหั่นแว่น\n" +
                    "กระเทียม\n" +
                    "ผิวมะกรูด\n" +
                    "รากผักชี 3-4 ต้น\n" +
                    "หอมแดงซอย 4 หัว\n" +
                    "เกลือ 1/2 ช้อนโต๊ะ\n" +
                    "เนื้อปลากรายขูด 300 กรัม\n" +
                    "ไข่ไก่ 2 ฟอง\n" +
                    "กะทิ 1 ถ้วย\n" +
                    "น้ำปลา 3 ช้อนโต๊ะ\n" +
                    "น้ำตาลปี๊บ 1 ช้อนโต๊ะ\n" +
                    "ใบยอ\n" +
                    "พริกชีฟ้าหั่นเฉียง และ ใบมะกรูดซอย สำหรับแต่งหน้า\n" +
                    "หัวกะทิ สำหรับหยอดหน้าห่อหมก\n" +
                    "\n" +
                    "วิธีทำ\n" +
                    "1.ใส่พริกแห้ง ข่า กระเทียม ผิวมะกรูด รากผักชี และหอมแดงซอย เติมเกลือเล็กน้อย ใส่เครื่องปั่น ปั่นให้ละเอียด\n" +
                    "2.นำพริกแกงที่ได้เทลงชามผสม ใส่เนื้อปลากรายขูด ไข่ไก่ และกะทิ คนให้เข้ากัน จากนั้นก็ปรุงรสด้วยน้ำปลา และน้ำตาลปี๊บ คนจนเนื้อเนียน\n" +
                    "3.เตรียมใบตอง พับมุมให้เป็นกระทง รองกระทงด้วยใบยอหั่นฝอย แล้วตักส่วนผสมลงไปในกระทง\n" +
                    "4.ตั้งหม้อนึ่งจนน้ำเดือด จากนั้นก็นำกระทงลงไปนึ่งประมาณ 30 นาที\n" +
                    "5.เสร็จแล้วเปิดฝาหม้อ  ตักหัวกะทิหยอดลงไปบนห่อหมก จากนั้นก็โรยพริกชี้ฟ้าและใบมะกรูดซอยลงไป ปิดฝาแล้วนึ่งต่อที่ 2 นาที"),
        recipes("น้ำพริกกะปิ","https://img-global.cpcdn.com/recipes/416a4186d02405a0/751x532cq70/%E0%B8%A3%E0%B8%B9%E0%B8%9B-%E0%B8%AB%E0%B8%A5%E0%B8%B1%E0%B8%81-%E0%B8%82%E0%B8%AD%E0%B8%87-%E0%B8%AA%E0%B8%B9%E0%B8%95%E0%B8%A3-%E0%B8%99%E0%B9%89%E0%B8%B3%E0%B8%9E%E0%B8%A3%E0%B8%B4%E0%B8%81%E0%B8%81%E0%B8%B0%E0%B8%9B%E0%B8%B4.jpg",
            "ส่วนผสม\t\n" +
                    "กะปิอย่างดี 2 ช้อนโต๊ะ\n" +
                    "พริกขี้หนูสวนเม็ดเล็ก แดงและเขียว ประมาณ 1 ช้อนโต๊ะ\n" +
                    "กระเทียมไทย 1 ช้อนโต๊ะ\n" +
                    "หอมแดง 1 ช้อนโต๊ะ\n" +
                    "น้ำตาลปี๊บ 1 ช้อนโต๊ะ\n" +
                    "มะเขือพวง 1 ช้อนโต๊ะ\n" +
                    "น้ำปลา 1 ช้อนโต๊ะ\n" +
                    "น้ำมะนาว 3 ช้อนโต๊ะ\n" +
                    "น้ำต้มสุก\n" +
                    "\n" +
                    "วิธีทำ\t\n" +
                    "1.โขลกตำกระเทียมให้แหลก เสร็จแล้วใส่กะปิลงไปตามปริมาณที่ต้องการ ตำกระเทียม และกะปิให้เข้ากัน \n" +
                    "2.ใส่พริกขี้หนูลงไปตำให้แหลกเข้ากับเนื้อกระเทียมและกะปิ เมื่อเสร็จแล้วให้ใส่น้ำตาลปี๊บ ตำให้เข้ากัน \n" +
                    "3.ใส่กุ้งแห้งป่น โขลกคลุกให้ทุกอย่างเข้ากัน และใส่มะเขือพวง บุๆ ให้มะเขือพวงเข้าเนื้อกับน้ำพริกกะปิ  \n" +
                    "4.ปรุงรสด้วยน้ำตาลทราย น้ำมะนาว น้ำปลา (ใส่นิดเดียว) คลุกทุกอย่างให้เข้ากัน ปรุงรสตามต้องการ  \n" +
                    "5.ตักขึ้นใส่ถ้วย ใช้น้ำต้มสุกล้างครก และเทน้ำที่ได้ใส่ถ้วยน้ำพริกกะปิ สุดท้ายใช้พริกขี้หนูบุนิดหน่อย โรยหน้าน้ำพริกกระปิ และใส่มะเขือพวงลงไปแต่งหน้านิดหน่อย \n" +
                    "6.ทานกับปลาทู ไข่เจียว ผักลวก ผักสดตามชอบ")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMaincoursesListBinding>(inflater,R.layout.fragment_maincourses_list, container, false)
        binding.dessButton.setOnClickListener{ view ->
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
