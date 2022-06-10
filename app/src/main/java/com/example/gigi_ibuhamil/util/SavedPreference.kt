package com.example.gigi_ibuhamil.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


object SavedPreference {
    const val EMAIL= "DefaultEmail"
    const val DISPLAYNAME="DefaultName"
    const val FIRST="false"
    const val DIAGOSIS = "DefaultResult"
    const val BMI = "0.0"
    const val POLAMAKAN = "DefaultPola"
    const val PERILAKU = "DefaultPerilaku"

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
    fun setDisplayName(context: Context, displayname: String?){
        editor(
            context,
            DISPLAYNAME,
            displayname
        )
    }
    fun setFirst(context: Context, condition: String?){
        editor(
            context,
            FIRST,
            condition
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

    fun getEmail(context: Context)= getSharedPreference(
        context
    )?.getString(EMAIL,"")
    fun getDisplayName(context: Context) = getSharedPreference(
        context
    )?.getString(DISPLAYNAME,"")
    fun getFirst(context: Context)= getSharedPreference(
        context
    )?.getString(FIRST,"")
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
    fun setDefaultFirst(context: Context){
        editor(
            context,
            FIRST,
            "false"
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
}