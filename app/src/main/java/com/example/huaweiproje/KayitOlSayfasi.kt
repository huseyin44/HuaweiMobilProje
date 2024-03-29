package com.example.huaweiproje

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.huaweiproje.databinding.FragmentKayitOlSayfasiBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KayitOlSayfasi.newInstance] factory method to
 * create an instance of this fragment.
 */
class KayitOlSayfasi : Fragment() {
    private lateinit var mBinding : FragmentKayitOlSayfasiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    //Siparis Sayfasına gitme
    private fun setListeners(){
        mBinding.KayitOlButon.setOnClickListener {
            if(isInputCorrect()){
                val isim = mBinding.adTextview.text.toString()
                val soyisim = mBinding.soyadTextview.text.toString()
                val kullanicimail = mBinding.textEmailAddress.text.toString()
                val action= KayitOlSayfasiDirections.actionKayitOlSayfasiToSiparisSayfasi(kullanicimail,isim,soyisim)
                findNavController().navigate(action)
            }
        }
    }
    //email kontrol
    private fun String.isValidEmail() = !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    private fun isInputCorrect(): Boolean {
        val username = mBinding.adTextview.text
        val usersurname = mBinding.soyadTextview.text
        val usermail =mBinding.textEmailAddress.text
        val userpassword=mBinding.sifreTextview.text

        if (username.isNullOrBlank()) {
            Toast.makeText(activity, "İsim boş olmamalı", Toast.LENGTH_LONG).show()
            return false
        }
        if (usersurname.isNullOrBlank()) {
            Toast.makeText(activity, "Soyisim boş olmamalı", Toast.LENGTH_LONG).show()
            return false
        }
        if (usermail.isNullOrBlank()) {
            Toast.makeText(activity, "Mail boş olmamalı", Toast.LENGTH_LONG).show()
            return false
        }
        if (usermail.toString().isValidEmail().not()) {
            Toast.makeText(activity, "Gecerli Email Adresi Olmalı", Toast.LENGTH_LONG).show()
            return false
        }
        if (usermail.toString().contains("@yalova.edu.tr", ignoreCase = true)==false) {
            Toast.makeText(activity, "Email xxx@yalova.edu.tr Formatında olmalıdır.", Toast.LENGTH_LONG).show()
            return false
        }
        if (userpassword.isNullOrBlank()) {
            Toast.makeText(activity, "Şifre boş olmamalı", Toast.LENGTH_LONG).show()
            return false
        }
        if (userpassword.toString().length < 8) {
            Toast.makeText(activity, "Şifre 8 karekterden az olmamalı", Toast.LENGTH_LONG).show()
            return false
        }
        if (mBinding.KvkkCheck.isChecked ==false ) {
            Toast.makeText(activity, "Checkbox işaretli olmalıdır", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentKayitOlSayfasiBinding.inflate(layoutInflater)
        return mBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KayitOlSayfasi.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KayitOlSayfasi().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}