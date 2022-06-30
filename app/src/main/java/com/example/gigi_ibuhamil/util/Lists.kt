package com.example.gigi_ibuhamil.util

import com.example.gigi_ibuhamil.R
import com.example.gigi_ibuhamil.models.*
import com.example.gigi_ibuhamil.ui.*

class lists {
    val penyakitllist: List<listpenyakit> =listOf(
        listpenyakit(
            id = "P01",
            namaPenyakit = "Karies Gigi",
            deskripsi = "Sering disebut dengan gigi berlubang merupakan Proses remineralisasi dan demineraslisasi mineral-mineral penyusun "+
                    "gigi serta ketidakseimbangan antara penyusunan dan pembuangan mineral gigi.",
            gejala = "G01 - Sakit gigi \n" +
                    "G02 - Gigi terasa ngilu \n" +
                    "G03  - Sakit gigi sampai pusing",
            penyebab = "makanan yang manis, lengket, berkarbohidrat, makanan asam  dan  mengosok "+
                    "gigi dengan metode dan frekuensi yang salah.",
            penanganan = "Berkumur dengan air garam dan meminum obat penahan nyeri (ponstan, paracetamol, dll)",
            pencegahan = "Sikat gigi teratur serta menggunakan metode dan frekuensi yang baik.",
            perawatan = "Pembersihan gigi, penambalan gigi dan perawatan saluran akar gigi."
        ),
        listpenyakit(
            id = "P02",
            namaPenyakit = "Gingivitis",
            deskripsi = "Gusi mengalami pembengkakan/peradangan yang disebabkan oleh sisa makanan "+
                    "yang mengeras/Karang gigi dan bakteri.",
            gejala = "G04 - Berdarah ketika menyikat gigi   \n" +
                    "G05 - Gusi mengalami pembekakan  \n"+
                    "G06 - Gusi terasa sakit \n" +
                    "G07 - Gusi berwarna merah sampai kebiruan",
            penyebab = "Gingivitis disebabkan oleh bakteri/ karang gigi.",
            penanganan = "Meminum obat anti radang",
            pencegahan = "Menggosokgigi dengan frekuensi dan teknik yang tepat.",
            perawatan = "Scaling dan root Planning (Pembersihan karang gigi) dab pemberian "+
                    "obat-obatan anti raadang, antibiotik, sampai operasi gusi."
        ),
        listpenyakit(
            id = "P03",
            namaPenyakit = "Periodontitis",
            deskripsi = "Peradangan pada jaringan penyokong gigi.",
            gejala = "G02 - Gigi terasa ngilu \n" +
                    "G08 - Gigi terasa ngilu yang menyebar  \n"+
                    "G09 - Gigi terasa ngilu saat mengunyah \n"+
                    "G10 - Gigi terlihat memanjang \n" +
                    "G11 - Gigi goyah",
            penyebab = "Trauma gigitan, Tambalan berlebih, usia lanjut, karang gigi, karies gigi.",
            penanganan = "Meminum obat penahan nyeri dan anti radang",
            pencegahan = "Menggosokgigi dengan frekuensi dan teknik yang tepat dan scaling teratur setidaknya 6 bulan sekali.",
            perawatan = "Scaling dan root Planning (Pembersihan karang gigi) serta pemberian obat-obatan."
        ),
    )
    val gejalalist: List<listgejala> = listOf(
        listgejala(
            id = "G01",
            namagejala = "Sakit Gigi"
        ),
        listgejala(
            id = "G02",
            namagejala = "Gigi Terasa Ngilu"
        ),
        listgejala(
            id = "G03",
            namagejala = "Sakit Gigi Sampai Pusing "
        ),
        listgejala(
            id = "G04",
            namagejala = "Berdarah ketika menyikat gigi"
        ),
        listgejala(
            id = "P05",
            namagejala = "Gusi mengalami pembekakan"
        ),
        listgejala(
            id = "G06",
            namagejala = "Gusi terasa sakit"
        ),
        listgejala(
            id = "G07",
            namagejala = "Gusi berwarna merah sampai kebiruan"
        ),
        listgejala(
            id = "G08",
            namagejala = "Gigi terasa ngilu yang menyebar"
        ),
        listgejala(
            id = "G09",
            namagejala = "Gigi terasa ngilu saat mengunyah"
        ),
        listgejala(
            id = "G10",
            namagejala = "Gigi terlihat memanjang"
        ),
        listgejala(
            id = "G11",
            namagejala = "Gigi goyah"
        ),
    )
    val petunjuklist: List<listpetunjuk> = listOf(
        listpetunjuk(
            id = "Pt01",
            namapetunjuk = "Diagnosis",
            descpetunjuk = "Menu Diagnosis pada halaman utama berfungsi untuk memulai diagnosa. Anda diminta untuk menjawab beebrapa pertanyaan yang akan ditampilkan hanya dengan tombol 'Ya' atau 'Tidak'. Kemudian sistem akan mengolah dan menampilkan hasil perkiraan diagnosis dari jawaban anda. Serta Hasil dari diagnosis anda akan direkam dan data pribadi anda akan dirahasiakan untuk tujuan penelitian",
            iconId = R.mipmap.ic_diagnosis
        ),
        listpetunjuk(
            id = "Pt02",
            namapetunjuk = "Daftar Penyakit",
            descpetunjuk = "Menu Daftar Penyakit pada halaman utama berfungsi untuk menampilkan daftar penyakit pada sistem ini, serta menampilkan informasi detail dari penyakit",
            iconId = R.mipmap.ic_gejala
        ),
        listpetunjuk(
            id = "Pt03",
            namapetunjuk = "Daftar Gejala",
            descpetunjuk = "Menu Daftar Gejala pada halaman utama berfungsi untuk menampilkan daftar gejala penyakit gigi dan mulut",
            iconId = R.mipmap.ic_penyakit
        ),
        listpetunjuk(
            id = "Pt04",
            namapetunjuk = "Tentang",
            descpetunjuk = "Menu Tentang pada halaman utama berfungsi untuk menampilkan informasi terkait aplikasi",
            iconId = R.mipmap.ic_tentang
        ),
    )
    val menulist: List<featured> = listOf(
        featured(
            id = "DP",
            title = "Daftar Penyakit",
            R.mipmap.ic_gejala,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ), featured(
            id = "DG",
            title = "Daftar Gejala",
            R.mipmap.ic_penyakit,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ), featured(
            id = "P",
            title = "Petunjuk",
            R.mipmap.ic_petunjuk,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ), featured(
            id = "T",
            title = "Tentang",
            R.mipmap.ic_tentang,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        )
    )
    val pertanyaanlist: List<listpertayaan> =listOf(
        listpertayaan(
            idpertanyaan = "Q01",
            soal = "Apakah gigi anda terasa ngilu saat mengunyah?",
            jawaban1 = "Q02",
            jawaban0 = "Q04"
        ),
        listpertayaan(
            idpertanyaan = "Q02",
            soal = "Apakah anda merasakah gigi ngilu yang menyebar saat mengunyah dan gigi tampak memanjang serta goyah",
            jawaban1 = "Penyakit Periodintitis",
            jawaban0 = "Q03"
        ),
        listpertayaan(
            idpertanyaan = "Q03",
            soal = "Apakah gigi anda terasa sakit hingga merasakan pusing?",
            jawaban1 = "Penyakit Karies Gigi",
            jawaban0 = "Penyakit Karies Gigi atau Periodontitis"
        ),
        listpertayaan(
            idpertanyaan = "Q04",
            soal = "Apakah gusi anda terlihat membengkak dan sakit serta berwarna merah hingga kebiruan?",
            jawaban1 = "Penyakit Gingivitis",
            jawaban0 = "Sehat"
        ),
    )
    val tentangList: List<listTentang> = listOf(
        listTentang(
            iconId = R.mipmap.logoapp,
            appname = "Ibu Peri Cerita",
            desc1 = "Ibu Hamil Periksa Mandiri Cegah Karies dan Stunting Anak",
            desc2 ="Aplikasi ini dibuat untuk pencerdasan kepada ibu hamil tentang bahaya penyakit karies gigi dan stunting anak",
            desc3 = "Aplikasi ini tidak 100% akurat dan hanya menjadi kemungkinan saja. Namun, terdapat usaha dalam pengembangan aplikasi ini dapat berffungsi semaksimal mungkin dalam memberikan informasi, mohon digunakan dengan bijak.\n"+
                    "\nPihak pengembang mempersilahkan pengguna untuk memberi saran dan kritikan melalui kontra email perwakilan tim pengembang. mohon maaf yang sebesar-besarnya bila terdapat tutur kata yang kurang baik dalam aplikasi ini.",
            desc4 = "Terimakasih, \n" +
                    "Tim Pengembang.\n\n\n" +
                    "CP : Riyantio84@gmail.com  ",
        )
    )
    val polamakanlist: List<listpolamakan> = listOf(
        listpolamakan(
            idpertanyaan = 0,
            soal = "Dalam 1 minggu berapa kali anda mengkonsumsi sayur?",
            jawaban1 = "   7x  ",
            jawaban2 = "5x - 6x",
            jawaban3 = "2x - 4x",
            jawaban4 = "   1x  ",
            point1 = 4,
            point2 = 3,
            point3 = 2,
            point4 = 1,
            next = 1
        ),
        listpolamakan(
            idpertanyaan = 1,
            soal = "Dalam 1 minggu berapa kali anda mengkonsumsi buah?",
            jawaban1 = "   7x  ",
            jawaban2 = "5x - 6x",
            jawaban3 = "2x - 4x",
            jawaban4 = "   1x  ",
            point1 = 4,
            point2 = 3,
            point3 = 2,
            point4 = 1,
            next = 2
        ),
        listpolamakan(
            idpertanyaan = 2,
            soal = "Dalam 1 minggu berapa kali anda mengkonsumsi olahan susu?",
            jawaban1 = "   7x  ",
            jawaban2 = "5x - 6x",
            jawaban3 = "2x - 4x",
            jawaban4 = "   1x  ",
            point1 = 4,
            point2 = 3,
            point3 = 2,
            point4 = 1,
            next = 3
        ),
        listpolamakan(
            idpertanyaan = 3,
            soal = "Dalam 1 minggu berapa kali anda mengkonsumsi snack/kue/cemilan manis?",
            jawaban1 = "   7x  ",
            jawaban2 = "5x - 6x",
            jawaban3 = "2x - 4x",
            jawaban4 = "   1x  ",
            point1 = 1,
            point2 = 2,
            point3 = 3,
            point4 = 4,
            next = 4
        ),
        listpolamakan(
            idpertanyaan = 4,
            soal = "Dalam 1 minggu berapa kali anda mengkonsumsi minuman-minuman manis?",
            jawaban1 = "   7x  ",
            jawaban2 = "5x - 6x",
            jawaban3 = "2x - 4x",
            jawaban4 = "   1x  ",
            point1 = 1,
            point2 = 2,
            point3 = 3,
            point4 = 4,
            next = 5
        ),
    )
    val perilakulist = listOf(
        listperilaku(
            idpertanyaan = 0,
            soal = "Dalam sehari berapa kali anda menggosok gigi?",
            jawaban1 = "     1x    \n      ",
            jawaban2 = "Lebih dari 1x",
            point1 = 1,
            point2 = 3,
            next = 1
        ),
        listperilaku(
            idpertanyaan = 1,
            soal = "Dalam 6 bulan berapa kali anda datang ke dokter gigi?",
            jawaban1 = "Tidak pernah",
            jawaban2 = " 1x / Lebih ",
            point1 = 4,
            point2 = 8,
            next = 2
        )
    )
    val listsetting = listOf(
        settingModel(
            id = "S01",
            setting = "Ubah Data Akun"
        ),
        settingModel(
            id = "S02",
            setting = "Histori"
        ),
        settingModel(
            id = "S03",
            setting = "Keluar"
        ),
        settingModel(
            id = "S04",
            setting = "Cetak History"
        ),
        settingModel(
            id = "S05",
            setting = "Add Admin"
        ),
    )
}