package com.example.app_englishpremierleagueclubs.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_englishpremierleagueclubs.Adapter.SoccerTileAdapter
import com.example.app_englishpremierleagueclubs.Model.SoccerTile
import com.example.app_englishpremierleagueclubs.R
import com.example.app_englishpremierleagueclubs.SheradPref
import com.example.app_englishpremierleagueclubs.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var soccerTileList: ArrayList<SoccerTile>
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        soccerTileList = getSoccerTitleList()

        val soccerTileAdapter = SoccerTileAdapter(soccerTileList, requireContext())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = soccerTileAdapter
            setHasFixedSize(true)
        }

//        val detailsFragment = DetilsFragment().apply {
//            arguments = Bundle().apply {
//                putParcelable("SOCCER_CLUB", soccerTileList)
//            }
//        }
//
//        // الانتقال بين الـ Fragments
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.containerFragment, detailsFragment)
//            .addToBackStack(null) // يمكن العودة إلى HomeFragment
//            .commit()


    }

    // حتى لمن اضغط على زر المفضلة من داخل صفحة detils  واطلع منها الاقي تلقائي حدث على category من برا والعكس صحيح
    override fun onResume() {
        super.onResume()
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    // دالة  getSoccerTitleList وظيفتها هي انك اضيف بيانات الاندية في داخل arrayList
    private fun getSoccerTitleList(): ArrayList<SoccerTile> {
        return arrayListOf(
            SoccerTile(
                id = "1",
                title = "مانشستر يونايتد", // الاسم باللغة العربية
                description = "أحد أشهر أندية الدوري الإنجليزي الممتاز.",
                descriptionLong = "مانشستر يونايتد، أو كما يُطلق عليه الشياطين الحمر، هو أحد أعرق الأندية في إنجلترا وأوروبا. يمتاز بتاريخ حافل بالإنجازات والبطولات من ضمنها العديد من ألقاب الدوري الإنجليزي الممتاز ودوري أبطال أوروبا.",
                buttonText = "معرفة المزيد",
                headerImageResId = R.drawable.united,
                headerImageURL = "https://example.com/manunited-image",
                teamUrl = "https://www.manutd.com/ar",
                isFavorite = SheradPref.getSoccerTileFavorite("مانشستر يونايتد")
            ),
            SoccerTile(
                id = "2",
                title = "مانشستر سيتي", // الاسم باللغة العربية
                description = "بطل الدوري الإنجليزي الممتاز لعدة مرات.",
                descriptionLong = "مانشستر سيتي، الفريق الأزرق في مدينة مانشستر، يُعتبر من أبرز أندية إنجلترا في العقد الأخير. استطاع أن يحقق العديد من البطولات المحلية والأوروبية تحت قيادة مدربين مميزين.",
                buttonText = "معرفة المزيد",
                headerImageResId = R.drawable.man_city,
                headerImageURL = "https://example.com/mancity-image",
                teamUrl = "https://ar.mancity.com/",
                isFavorite = SheradPref.getSoccerTileFavorite("مانشستر سيتي")
            ),
            SoccerTile(
                id = "3",
                title = "آرسنال", // الاسم باللغة العربية
                description = "أحد أقدم أندية إنجلترا.",
                descriptionLong = "آرسنال، المعروف باسم المدفعجية، هو نادٍ مقره في شمال لندن ويمتلك جماهيرية كبيرة. يتميز بتاريخه الطويل في الدوري الإنجليزي الممتاز وبالعديد من البطولات والكؤوس المحلية.",
                buttonText = "معرفة المزيد",
                headerImageResId = R.drawable.arcinal,
                headerImageURL = "https://example.com/arsenal-image",
                teamUrl = "https://www.arsenal.com/",
                isFavorite = SheradPref.getSoccerTileFavorite("آرسنال")
            ),
            SoccerTile(
                id = "4",
                title = "توتنهام هوتسبير", // الاسم باللغة العربية
                description = "نادٍ مقره في شمال لندن.",
                descriptionLong = "توتنهام هوتسبير، أو توتنهام، يتميز بتاريخه الطويل وجماهيره الشغوفة. رغم قلة البطولات في العقود الأخيرة، إلا أنه يظل من المنافسين الدائمين في الدوري الإنجليزي الممتاز.",
                buttonText = "معرفة المزيد",
                headerImageResId = R.drawable.tottenham,
                headerImageURL = "https://example.com/tottenham-image",
                teamUrl = "https://www.tottenhamhotspur.com/",
                isFavorite = SheradPref.getSoccerTileFavorite("توتنهام هوتسبير")
            ),
            SoccerTile(
                id = "5",
                title = "تشيلسي", // الاسم باللغة العربية
                description = "نادٍ من غرب لندن يمتلك تاريخًا حافلاً.",
                descriptionLong = "تشيلسي، الذي يُطلق عليه البلوز، يُعد واحدًا من أنجح الأندية الإنجليزية في العقدين الأخيرين. يشتهر بتاريخه الكبير وفوزه المتعدد ببطولات الدوري الإنجليزي ودوري أبطال أوروبا.",
                buttonText = "معرفة المزيد",
                headerImageResId = R.drawable.chelsea,
                headerImageURL = "https://example.com/chelsea-image",
                teamUrl = "https://www.chelseafc.com/en",
                isFavorite = SheradPref.getSoccerTileFavorite("تشيلسي")
            ),
            SoccerTile(
                id = "6",
                title = "ليستر سيتي", // الاسم باللغة العربية
                description = "الفريق الذي صنع معجزة الدوري الإنجليزي.",
                descriptionLong = "ليستر سيتي، المعروف بالثعالب، دخل التاريخ عندما فاز بلقب الدوري الإنجليزي الممتاز في موسم 2015-2016 بشكل مفاجئ ومدهش. يتميز بأداء قتالي وروح جماعية كبيرة.",
                buttonText = "معرفة المزيد",
                headerImageResId = R.drawable.leicester,
                headerImageURL = "https://example.com/leicester-image",
                teamUrl = "https://www.lcfc.com/",
                isFavorite = SheradPref.getSoccerTileFavorite("ليستر سيتي")
            )
        )
    }

}