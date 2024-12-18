package com.example.app_englishpremierleagueclubs.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app_englishpremierleagueclubs.MainActivity
import com.example.app_englishpremierleagueclubs.Model.SoccerTile
import com.example.app_englishpremierleagueclubs.R
import com.example.app_englishpremierleagueclubs.SheradPref
import com.example.app_englishpremierleagueclubs.databinding.FragmentDetilsBinding
import com.squareup.picasso.Picasso

class DetilsFragment : Fragment() {

    private lateinit var binding: FragmentDetilsBinding
    private var soccerTile: SoccerTile? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetilsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // تفعيل Toolbar وجعله الـ ActionBar في الـ Fragment
         val toolbar = binding.toolbar
        (activity as? AppCompatActivity)?.apply {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true) // تفعيل زر العودة
            supportActionBar?.title = "Club Soccer" // اسم العنوان (اختياري)
        }

        val soccerTile = arguments?.getParcelable<SoccerTile>("SOCCER_CLUB")
        soccerTile?.let {

            binding.titleTextView.text = it.title
            binding.descriptionTextView.text = it.description
            binding.descriptionLongTextView.text = it.descriptionLong
            binding.HeaderImageView.setImageResource(it.headerImageResId)

            // Picasso
//            Picasso.get().isLoggingEnabled = true
//            // تحميل الصورة من الإنترنت باستخدام Picasso
//            Picasso.get()
//                .load(soccerTile.headerImageURL)
//                .placeholder(R.drawable.ic_launcher_foreground) // صورة مؤقتة لحتى تحمل الصورة
//                .error(R.drawable.ic_launcher_background) // error photo
//                .into(binding.HeaderImageView) // تحميل الصورة هنا
        }

    }

    // التعامل مع الأزرار في الـ Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // زر العودة (للتنقل إلى HomeFragment)
            android.R.id.home -> {

                //parentFragmentManager.popBackStack()

                // العودة إلى الـ HomeFragment
                parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFragment, HomeFragment()) // التأكد من ربط الـ ID
                    .commit()
                true
            }

            // زر فتح الرابط
            R.id.menuItemLink -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(soccerTile?.teamUrl))
                startActivity(intent)

                true
            }

            // زر الإضافة للمفضلة
            R.id.menuItemFavorite -> {
                // إذا كانت arguments لا تحتوي على قيمة (أي كانت null أو لم يتم إرسال قيمة للـ isFavorite)، سيتم استخدام القيمة الافتراضية false بفضل الـ ?:
                val isCurrentlyFavorited = soccerTile!!.isFavorite
                if (isCurrentlyFavorited) {
                    item.setIcon(R.drawable.ic_favorite_border)
                } else {
                    item.setIcon(R.drawable.ic_favorite)
                }
                soccerTile!!.isFavorite = !isCurrentlyFavorited
                SheradPref.setSoccerTileFavorite(soccerTile!!.id, soccerTile!!.isFavorite)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    // إعداد الـ Menu الخاص بالتنقل
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        // تحديث الـ icon لزر المفضلة بناءً على الحالة
        if (soccerTile!!.isFavorite) {
            menu.findItem(R.id.menuItemFavorite)?.setIcon(R.drawable.ic_favorite)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }
}