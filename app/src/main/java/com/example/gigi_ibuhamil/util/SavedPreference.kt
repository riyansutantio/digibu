package com.example.gigi_ibuhamil.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


object SavedPreference {
    const val EMAIL= "DefaultEmail"
    const val DISPLAYNAME="DefaultName"
    const val DIAGOSIS = "DefaultResult"
    const val BMI = "0.0"
    const val POLAMAKAN = "DefaultPola"
    const val PERILAKU = "DefaultPerilaku"
    const val ALAMAT = "DefaultAlamat"
    const val DESA = "DefaultDesa"
    const val TAHUN = "DefaultTahun"
    const val USIA = "DefaultUsia"
    const val ROLE = "DefaultRole"
    const val PENYAKIT = "Penyakit"
    const val ID = "0"

    private  fun getSharedPreference(ctx: Context?): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }
    private fun  editor(context: Context, const:String, string: String?){
        getSharedPreference(
            context
        )?.edit()?.putString(const,string)?.apply()
    }
    fun setEmail(context: Context, email: String?){
        editor(
            context,
            EMAIL,
            email
        )
    }
    fun setDisplayName(context: Context, displayname: String?) {
        editor(
            context,
            DISPLAYNAME,
            displayname
        )
    }
    fun setDiagnosis(context: Context, diagnosis: String?){
        editor(
            context,
            DIAGOSIS,
            diagnosis
        )
    }
    fun setBMI(context: Context, bmi: String?){
        editor(
            context,
            BMI,
            bmi
        )
    }
    fun setPola(context: Context, pola: String?){
        editor(
            context,
            POLAMAKAN,
            pola
        )
    }
    fun setPerilaku(context: Context, perilaku: String?){
        editor(
            context,
            PERILAKU,
            perilaku
        )
    }
    fun setAlamat(context: Context, condition: String?){
        editor(
            context,
            ALAMAT,
            condition
        )
    }
    fun setDesa(context: Context, condition: String?){
        editor(
            context,
            DESA,
            condition
        )
    }
    fun setTahun(context: Context, condition: String?){
        editor(
            context,
            TAHUN,
            condition
        )
    }
    fun setUsia(context: Context, condition: String?){
        editor(
            context,
            USIA,
            condition
        )
    }
    fun setRole(context: Context, condition: String?){
        editor(
            context,
            ROLE,
            condition
        )
    }
    fun setPenyakit(context: Context, penyakit: String?){
        editor(
            context,
            PENYAKIT,
            penyakit
        )
    }
    fun setId(context: Context, id: String?){
        editor(
            context,
            ID,
            id
        )
    }

    fun getEmail(context: Context)= getSharedPreference(
        context
    )?.getString(EMAIL,"")
    fun getDisplayName(context: Context) = getSharedPreference(
        context
    )?.getString(DISPLAYNAME,"")
    fun getDiagnosis(context: Context)= getSharedPreference(
        context
    )?.getString(DIAGOSIS,"")
    fun getBMI(context: Context)= getSharedPreference(
        context
    )?.getString(BMI,"")
    fun getPola(context: Context)= getSharedPreference(
        context
    )?.getString(POLAMAKAN,"")
    fun getPerilaku(context: Context)= getSharedPreference(
        context
    )?.getString(PERILAKU,"")
    fun getAlamat(context: Context)= getSharedPreference(
        context
    )?.getString(ALAMAT,"")
    fun getDesa(context: Context)= getSharedPreference(
        context
    )?.getString(DESA,"")
    fun getTahun(context: Context)= getSharedPreference(
        context
    )?.getString(TAHUN,"")
    fun getUsia(context: Context)= getSharedPreference(
        context
    )?.getString(USIA,"")
    fun getRole(context: Context)= getSharedPreference(
        context
    )?.getString(ROLE,"")
    fun getId(context: Context)= getSharedPreference(
        context
    )?.getString(ID,"0")
    fun getPenyakit(context: Context)= getSharedPreference(
        context
    )?.getString(PENYAKIT,"")

    fun setDefaultName(context: Context){
        editor(
            context,
            DISPLAYNAME,
            "DefaultName"
        )
    }
    fun setDefaultEmail(context: Context){
        editor(
            context,
            EMAIL,
            "DefaultEmail"
        )
    }
    fun setDefaultDiagnosis(context: Context){
        editor(
            context,
            DIAGOSIS,
            "DefaultDiagnosis"
        )
    }
    fun setDefaultBMI(context: Context){
        editor(
            context,
            BMI,
            "0.0"
        )
    }
    fun setDefaultPolaMakan(context: Context){
        editor(
            context,
            POLAMAKAN,
            "DefaultPola"
        )
    }
    fun setDefaultPerilaku(context: Context){
        editor(
            context,
            PERILAKU,
            "DefaultPerilaku"
        )
    }
    fun setDefaultRole(context: Context){
        editor(
            context,
            ROLE,
            "DefaultRole"
        )
    }
    fun setDefaultPenyakit(context: Context){
        editor(
            context,
            PENYAKIT,
            "DefaultPenyakit"
        )
    }
    fun setDefaultId(context: Context){
        editor(
            context,
            ID,
            "0"
        )
    }
}