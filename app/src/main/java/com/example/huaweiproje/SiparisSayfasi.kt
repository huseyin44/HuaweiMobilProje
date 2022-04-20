package com.example.huaweiproje

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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
    private val args : SiparisSayfasiArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mbinding = FragmentSiparisSayfasiBinding.inflate(layoutInflater)
        return mbinding.root
    }

    private fun ucrethesapla(){
        var ucretsifirlama =0

        mbinding.LahmacunRadiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            var Lahmacun_selectedId = mbinding.LahmacunRadiogroup.checkedRadioButtonId
            val radio: RadioButton = group.findViewById(Lahmacun_selectedId)
            Log.e("selectedtext-->Lahmacun",radio.text.toString())

            var lahmacun_ucret =0
            if(radio.text.toString()=="Küçük"){
                mbinding.lahmacunucrettutucu.text=ucretsifirlama.toString() //ucret sifirlama
                lahmacun_ucret=10
            }
            if(radio.text.toString()=="Orta"){
                mbinding.lahmacunucrettutucu.text=ucretsifirlama.toString()
                lahmacun_ucret=20
            }
            if(radio.text.toString()=="Büyük"){
                mbinding.lahmacunucrettutucu.text=ucretsifirlama.toString()
                lahmacun_ucret=30
            }
            mbinding.lahmacunucrettutucu.text=lahmacun_ucret.toString()
        })
        mbinding.PideRadiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            var Pide_selectedId = mbinding.PideRadiogroup.checkedRadioButtonId
            val radio: RadioButton = group.findViewById(Pide_selectedId)
            Log.e("selectedtext-->Pide",radio.text.toString())

            var pide_ucret =0
            if(radio.text.toString()=="Küçük"){
                mbinding.pideucretutucu.text=ucretsifirlama.toString()
                pide_ucret=10
            }
            if(radio.text.toString()=="Orta"){
                mbinding.pideucretutucu.text=ucretsifirlama.toString()
                pide_ucret=20
            }
            if(radio.text.toString()=="Büyük"){
                mbinding.pideucretutucu.text=ucretsifirlama.toString()
                pide_ucret=30
            }
            mbinding.pideucretutucu.text=pide_ucret.toString()
        })

        mbinding.ucrethesaplamabutonu.setOnClickListener {
            if (mbinding.PideRadiogroup.checkedRadioButtonId!=-1
                && mbinding.LahmacunRadiogroup.checkedRadioButtonId!=-1){

                mbinding.ucrettextview.text="Ödemeniz Gereken Ücret "+
                        (Integer.parseInt(mbinding.lahmacunucrettutucu.text as String)+
                                Integer.parseInt(mbinding.pideucretutucu.text as String)).toString()+"TL Dir."

                mbinding.ucrettextview.visibility=View.VISIBLE
            }
            else{
                Toast.makeText(activity, "Sipariş boylarını seçiniz", Toast.LENGTH_LONG).show()
            }
        }
    }

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

        ucrethesapla()
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

