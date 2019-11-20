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
                    "6.นึ่งเสร็จแล้ว นำขนมออกมาหั่นเป็นชิ้นสี่เหลี่ยม"),
        recipes("ข้าวต้มมัด","https://food.mthai.com/app/uploads/2017/03/Khao-Tom-Mad1.jpg",
            "ส่วนผสม\n" +
                "ข้าวเหนียวเขี้ยวงูใหม่ 800 กรัม\n" +
                "กล้วยน้ำว้าสุก 10 ผล\n" +
                "ถั่วดำ 100 กรัม\n" +
                "ใบเตย\n" +
                "หัวกะทิ 3 ถ้วย\n" +
                "น้ำตาลทราย 100 กรัม\n" +
                "เกลือป่น 1 ช้อนชา\n" +
                "เตรียมใบตองชิ้นละ 2 ใบ\n" +
                "ใบตองชั้นแรก 8×9 นิ้ว\n" +
                "ใบตองชั้นสอง 6×8 นิ้ว\n" +
                "ตอกหรือเชือกสำหรับห่อ\n" +
                "\n" +
                "วิธีทำสูตรข้าวต้มมัด\n" +
                "1.แช่ถั่วดำทิ้งไว้ข้ามคืนแล้วนำมานึ่งให้พอสุก\n" +
                "2.ล้างข้าวเหนียวให้สะอาดแล้วนำไปแช่น้ำ ทิ้งไว้ 4 ชั่วโมง เสร็จแล้วตักขึ้นมาสะเด็ดน้ำพักไว้\n" +
                "3.ตั้งกะทิในกระทะ ใส่ใบเตยลงไปเปิดไฟแรงปานกลาง เมื่อกะทิเริ่มเดือด ตักใบเตยออกแล้วใส่เกลือกับน้ำตาลลงไป\n" +
                "4.ลดไฟลงใส่ข้าวเหนียวลงไปผัดกับกะทิ ผัดไปในทิศทางเดียวกัน ผัดจนข้าวเหนียวแห้ง ใช้เวลาประมาณ 15 นาที พอข้าวเหนียวเริ่มแห้งก็ปิดไฟ พักข้าวเหนียวไว้ให้เย็น\n" +
                "5.ปอกกล้วยแล้วผ่าครึ่งเตรียมไว้ วางใบตองประกบด้านสีอ่อนของใบตองเข้าหากัน ใบใหญ่ไว้ข้างนอกใบเล็กไว้ข้างใน\n" +
                "6.ใส่ข้าวเหนียวลงไปประมาณ 1 ช้อนโต๊ะ ใช้ช้อนเกลี่ยข้าวเหนียวให้แบน จากนั้นก็วางกล้วยลงไปตรงกลางและปิดด้วยข้าวเหนียวอีกที โรยหน้าด้วยถั่วดำ\n" +
                "7.ห่อใบตองให้แน่นแล้วมัดด้วยตอกหรือเชือก นำข้าวต้มไปเรียงใส่ลังนึ่ง นึ่งด้วยไฟแรงใช้เวลา 20 นาที เมื่อเสร็จแล้วก็ปิดไฟยกลงจากลังนึ่งจัดใส่จานเสิร์ฟ"),
        recipes("ลูกชุบ","https://food.mthai.com/app/uploads/2018/01/Deletable-Imitation-Fruits.jpg",
            "ส่วนผสม\n" +
                    "ถั่วเขียวเลาะเปลือก (นึ่ง) 500 กรัม\n" +
                    "น้ำตาลทราย 300 กรัม\n" +
                    "หัวกะทิ 1 ถ้วย\n" +
                    "สีผสมอาหารตามใจชอบ\n" +
                    "วุ้น\n" +
                    "\n" +
                    "วิธีทำ\n" +
                    "1.นำถั่วเขียว น้ำตาลและกะทิ ปั่นรวมกันจนเนียน\n" +
                    "2.เทส่วนผสมลงไปในกระทะแล้วเคี่ยวจนถั่วนั้นปั้นเป็นลูกได้\n" +
                    "3.เตรียมสีผสมอาหารแยกไว้เป็นสีละถ้วย และเตรียมอุปกรณ์สำหรับเพ้นท์ เช่น พู่กัน และไม้แหลมสำหรับเสียบลูกชุบ\n" +
                    "4.ปั้นขนมให้เป็นรูปผลไม้ต่างๆ จากนั้นก็เสียบด้วยไม้แหลม ปักพักไว้ก่อน\n" +
                    "5.นำขนมที่ปั้นแล้ว ตกแต่งสีได้เลย แล้วนำไปตากให้สีแห้ง\n" +
                    "6.ละลายวุ้นเตรียมไว้ เมื่อขนมพร้อมแล้วให้นำมาชุบกับวุ้น เคลือบให้ขนมเป็นขึ้นเงาสวย อาจจะจุ่มสองรอบเพื่อความหนามากยิ่งขึ้น"),
        recipes("บ้าบิ่น","https://food.mthai.com/app/uploads/2017/07/Candy-babin..jpg",
            "ส่วนผสม\n" +
                    "กะทิ 1/2 ถ้วย\n" +
                    "น้ำตาลมะพร้าว 1/2 ถ้วย\n" +
                    "แป้งข้าวเหนียว 1 ถ้วย\n" +
                    "แป้งท้าวยายม่อม 1 ช้อนโต๊ะ\n" +
                    "มะพร้าวทึนทึกขูด 2 ถ้วย\n" +
                    "\n" +
                    "วิธีทำ\n" +
                    "1.ผสมน้ำกะทิ น้ำตาลมะพร้าว คนจนน้ำตาลละลาย\n" +
                    "2.ใส่แป้งข้าวเหนียวและแป้งท้าวยายม่อม คนให้เข้ากันอีกครั้ง เสร็จแล้วก็ใส่มะพร้าวขูดลงไปแล้วคลุกให้เข้ากัน\n" +
                    "3.เตรียมกระทะเทฟล่อนเปิดไฟกลาง เมื่อกระทะร้อนดีแล้ว ตักขนมแล้วหยอดลงไปขนานชิ้นพอดีคำ\n" +
                    "4.ทำให้สุกทั้งสองด้าน เสร็จแล้วก็นำขึ้นมาใส่จานเสิร์ฟ"),
        recipes("ขนมตาล","https://img.kapook.com/u/2019/wanwanat/waffle/toddy.jpg",
            "ส่วนผสม\n" +
                    "น้ำตาลทราย 400 กรัม\n" +
                    "กะทิ 3 ถ้วย\n" +
                    "เนื้อลูกตาลสุก 400 กรัม\n" +
                    "แป้งข้าวเจ้า 500 กรัม\n" +
                    "ผงฟู 1 ช้อนโต๊ะ\n" +
                    "มะพร้าวขูดเส้นเล็ก 2 ถ้วย\n" +
                    "เกลือเล็กน้อย (สำหรับคลุกมะพร้าว)\n" +
                    " \n" +
                    "วิธีทำ\n" +
                    "1. ละลายน้ำตาลทรายในกะทิให้เข้ากันแล้วเนื้อลูกตาลลงไป คนให้เข้ากัน\n" +
                    "2. เติมแป้งและผงฟูลงไป คนให้เข้ากันจนเนียน\n" +
                    "3. กรองส่วนผสม พักไว้ ประมาณ 10 นาที จนขนมขึ้นฟู\n" +
                    "4. ใส่น้ำลงในชุดนึ่ง เรียงถ้วยตะไล เปิดไฟกลาง เตรียมไว้\n" +
                    "5. ตักส่วนผสมยอดลงในถ้วยตะไลจนเต็มถ้วย โรยด้วยมะพร้าวคลุกเกลือ นึ่งประมาณ 15-20 นาที\n" +
                    "6. ยกลงจากเตา พักให้เย็นแซะออกจากถ้วย พร้อมเสิร์ฟ")
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
