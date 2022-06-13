package com.example.gigi_ibuhamil.util

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object DiagnosisScreen : Screen("diagnosis_screen")
    object PenyakitScreen : Screen("penyakit_screen")
    object GejalaScreen : Screen("gejala_screen")
    object PetunjukScreen : Screen("petunjuk_screen")
    object TentangScreen : Screen("tentang_screen")
    object LoginScreen : Screen("auth_screen)")
    object EbookScreen : Screen("ebook_screen)")
    object SplashScreen : Screen("Splash_screen)")
    object VideoScreen : Screen("Video_screen)")
    object InformationScreen : Screen("information_screen")
    object BeratBadanScreen : Screen("beratbadan_screen")
    object PolaMakanScreen : Screen("polamakan_screen")
    object PerilakuScreen : Screen("perilaku_screen")
    object KesimpulanScreen : Screen("kesimpulan_screen")
    object SettingScreen : Screen("setting_screen")
    object HistoryScreen : Screen("history_screen")
    object AkunScreen : Screen("akun_screen")
}