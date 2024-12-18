package com.example.app_englishpremierleagueclubs.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.app_englishpremierleagueclubs.Fragments.DetilsFragment
import com.example.app_englishpremierleagueclubs.Model.SoccerTile
import com.example.app_englishpremierleagueclubs.R
import com.example.app_englishpremierleagueclubs.SheradPref
import com.example.app_englishpremierleagueclubs.databinding.ViewHolderSoccerBinding

class SoccerTileAdapter(private var soccerTile: ArrayList<SoccerTile>, private val context: Context) : RecyclerView.Adapter<SoccerTileAdapter.SoccerTileViewHolder>() {

    class SoccerTileViewHolder(val binding: ViewHolderSoccerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoccerTileViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderSoccerBinding.inflate(inflater, parent, false)
        return SoccerTileViewHolder(binding)
    }

    override fun getItemCount(): Int = soccerTile.size


    override fun onBindViewHolder(holder: SoccerTileViewHolder, position: Int) {

        holder.binding.titleTextView.text = soccerTile[position].title
        holder.binding.descriptionTextView.text = soccerTile[position].description
        holder.binding.HeaderImageView.setImageResource(soccerTile[position].headerImageResId)

//        Picasso.get().load(soccerTile[position].headerImageURL)
//            .placeholder(R.drawable.ic_launcher_foreground) // صورة مؤقتة لحتى تحمل الصورة
//            .error(R.drawable.ic_launcher_background) // error photo
//            .into(holder.binding.HeaderImageView) // تحميل الصورة هنا

        // btnFavorite
        val icon = if (soccerTile[position].isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        holder.binding.favoriteImage.setImageResource(icon)
        holder.binding.favoriteImage.setOnClickListener {

            soccerTile[position].isFavorite = !soccerTile[position].isFavorite
             SheradPref.setSoccerTileFavorite(soccerTile[position].id,soccerTile[position].isFavorite)
            notifyItemChanged(position) // حتى تحدث اول باول زر الاعجاب او المفضلة
        }

        // btnLearnMore
        holder.binding.btnLearnMore.setOnClickListener {

            val selectedClub = soccerTile[position] // استخراج الكائن الفردي
            Toast.makeText(context, "Clicked on: ${soccerTile[position].title}", Toast.LENGTH_LONG).show()
            // انشاء الـ Bundle وتمرير الكائن
            val bundle = Bundle()
            bundle.putParcelable("SOCCER_CLUB", selectedClub) // تمرير الكائن الفردي فقط

            // تنفيذ الانتقال إلى DetailsFragment
            val fragment = DetilsFragment().apply {
                arguments = bundle
            }
            // تنفيذ النقل إلى DetailsFragment
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, fragment)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()
        }
    }

    //jnbkjnrb
/*
;kfbldnb;fdsnb;fdb
f;bnsdflkbndfk;b
dfbnljdfnbkldfnb
dfbljdfnblfkdnbd
fdnlbndflkbndflkb
lkfndbkldnlb
bkdfnblkdnfbld
bdfjlbndflkbndfbndflbndflkbn
lkfnbkdfnbldfnblndflbndflkbndlfbk
 */
}