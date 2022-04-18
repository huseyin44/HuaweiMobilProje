package com.example.huaweiproje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.huaweiproje.databinding.FragmentKayitOlSayfasiBinding
import com.example.huaweiproje.databinding.FragmentSiparisSayfasiBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SiparisSayfasi.newInstance] factory method to
 * create an instance of this fragment.
 */
class SiparisSayfasi : Fragment() {

    private lateinit var mbinding :FragmentSiparisSayfasiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //profil resmi yükleme
        Glide.with(this).load("https://i.picsum.photos/id/1025/367/267.jpg?hmac=xlFGYDf9CLQQCJ2NTBxS8qTTOLkD28zsznZAt9XFCJw")
            .into(mbinding.profilresmi)

        //Lahmacun Resmi
        Glide.with(this).load("https://cdn.yemek.com/mncrop/940/625/uploads/2020/04/lahmacun-yeni-one-cikan.jpg")
            .into(mbinding.yemekresmi1)

        //Pide Resmi
        Glide.with(this).load("https://im.haberturk.com/2019/10/30/ver1572512151/acik-pide_2535762_1200x627.jpg")
            .into(mbinding.yemekresmi2)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mbinding = FragmentSiparisSayfasiBinding.inflate(layoutInflater)
        return mbinding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SiparisSayfasi.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SiparisSayfasi().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}