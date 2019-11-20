package buu.informatics.s59160975.thairecipes


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        setHasOptionsMenu(true)
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
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getShareIntent() : Intent {
        Toast.makeText(activity, "You select share", Toast.LENGTH_SHORT).show()
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, "ฉันกำลังเล่นแอปนี้อยู่!")
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }



}
