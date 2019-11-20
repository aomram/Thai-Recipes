package buu.informatics.s59160975.thairecipes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class DessertFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dessert, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DessertFragmentArgs.fromBundle(arguments!!)
        val nameMenu = view.findViewById<TextView>(R.id.nameMenu_text)
        val imageMenu = view.findViewById<ImageView>(R.id.menu_image)
        val detailMenu = view.findViewById<TextView>(R.id.detail_main)
        nameMenu.text = args.name
        Picasso.get().load(args.image).into(imageMenu)
        detailMenu.text = args.detail
    }


}
