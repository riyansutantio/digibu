package com.example.gigi_ibuhamil.util

import com.example.gigi_ibuhamil.R
import com.example.gigi_ibuhamil.models.*
import com.example.gigi_ibuhamil.ui.*

class lists {
    val penyakitllist: List<listpenyakit> =listOf(
        listpenyakit(
            id = "P01",
            namaPenyakit = "Karies Gigi",
            deskripsi = "Sering disebut dengan gigi berlubang merupakan proses remineralisasi dan demineraslisasi mineral-mineral penyusun "+
                    "gigi serta ketidakseimbangan antara penyusunan dan pembuangan mineral gigi.",
            gejala = "Sakit gigi \n" +
                    "Gigi terasa ngilu \n" +
                    "Sakit gigi sampai pusing",
            penyebab = "makanan yang manis, lengket, berkarbohidrat, makanan asam  dan  mengosok "+
                    "gigi dengan metode dan frekuensi yang salah.",
            penanganan = "Berkumur dengan air garam dan meminum obat penahan nyeri (ponstan, paracetamol, dll)",
            pencegahan = "Sikat gigi teratur serta menggunakan metode dan frekuensi yang baik.",
            perawatan = "Pembersihan gigi, penambalan gigi dan perawatan saluran akar gigi.",
            gambar1 = R.drawable.ums
        ),
        listpenyakit(
            id = "P02",
            namaPenyakit = "Gingivitis",
            deskripsi = "Gusi mengalami pembengkakan/peradangan yang disebabkan oleh sisa makanan "+
                    "yang mengeras/karang gigi dan bakteri.",
            gejala = "Berdarah ketika menyikat gigi   \n" +
                    "Gusi mengalami pembekakan  \n"+
                    "Gusi terasa sakit \n" +
                    "Gusi berwarna merah sampai kebiruan",
            penyebab = "Gingivitis disebabkan oleh bakteri/ karang gigi.",
            penanganan = "Meminum obat anti radang",
            pencegahan = "Menggosokgigi dengan frekuensi dan teknik yang tepat.",
            perawatan = "Scaling dan root planning (pembersihan karang gigi) dab pemberian "+
                    "obat-obatan anti radang, antibiotik, sampai operasi gusi.",
            gambar1 = R.drawable.ums
        ),
        listpenyakit(
            id = "P03",
            namaPenyakit = "Periodontitis",
            deskripsi = "Peradangan pada jaringan penyokong gigi.",
            gejala = "Gigi terasa ngilu \n" +
                    "Gigi terasa ngilu yang menyebar  \n"+
                    "Gigi terasa ngilu saat mengunyah \n"+
                    "Gigi terlihat memanjang \n" +
                    "Gigi goyah",
            penyebab = "Trauma gigitan, tambalan berlebih, usia lanjut, karang gigi, karies gigi.",
            penanganan = "Meminum obat penahan nyeri dan anti radang",
            pencegahan = "Menggosokgigi dengan frekuensi dan teknik yang tepat dan scaling teratur setidaknya 6 bulan sekali.",
            perawatan = "Scaling dan root Planning (Pembersihan karang gigi) serta pemberian obat-obatan.",
            gambar1 = R.drawable.ums
        ),
    )
    val gejalalist: List<listgejala> = listOf(
        listgejala(
            id = "G01",
            namagejala = "Sakit gigi"
        ),
        listgejala(
            id = "G02",
            namagejala = "Gigi terasa ngilu"
        ),
        listgejala(
            id = "G03",
            namagejala = "Sakit gigi sampai pusing "
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
            namapetunjuk = "Assessment",
            descpetunjuk = "Menu 'Mulai Screening' pada halaman utama berfungsi untuk memulai beberapa proses pertanyaan. " +
                    "Anda diminta untuk menjawab beberapa pertanyaan yang akan ditampilkan hanya dengan tombol 'Ya' " +
                    "atau 'Tidak' untuk menentukan diagnosis penyakit. Kemudian anda akan diminta untuk mengisi BB dan TB untuk menentukan BMI anda." +
                    "Selanjutnya anda akan diminta untuk menjawab beberapa pertanyaan yang ditampilkan dan anda diminta untuk menjawab sesuai dengan kondisi anda. ",
            iconId = R.mipmap.ic_diagnosis
        ),
        listpetunjuk(
            id = "Pt02",
            namapetunjuk = "Gigi dan Mulut",
            descpetunjuk = "Menu Gigi dan Mulut pada halaman utama berfungsi untuk memberi informasi seputar gigi dan mulut selama kehamilan. Setelah melakukan self-screening, anda dapat mempelajari makna dan nasihat terkait gigi dan mulut di menu ini.",
            iconId = R.mipmap.ic_gejala
        ),
        listpetunjuk(
            id = "Pt03",
            namapetunjuk = "BMI dan Pola Makan",
            descpetunjuk = "Menu BMI dan Pola Makan di halaman utama berfungsi untuk memberi informasi terkait berat badan dan pola makan selama kehamilan. Setelah melakukan self-screening, anda dapat mempelajari makna dan nasihat terkait berat badan dan pola makan di sini.",
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
            title = "Gigi dan Mulut",
            R.mipmap.ic_gejala,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ), featured(
            id = "DG",
            title = "BMI dan Pola Makan",
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
            jawaban1 = "Penyakit Periodontitis",
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
            iconId = R.drawable.logoss,
            iconId2 = R.drawable.ums,
            appname = "Ibu Peri Cerita",
            desc1 = "Ibu Hamil Periksa Mandiri Cegah Karies dan Stunting Anak",
            desc2 ="Aplikasi ini dibuat untuk meningkatkan pengetahuan dan kesadaran Ibu hamil dalam menjaga kesehatan gigi dan mulut, supaya menghindari diagnosis menghindari self-diagnose dan mendeteksi dini penyakit gigi dan mulut sebelum semakin parah",
            desc3 = "Aplikasi ini tidak 100% akurat dan dan merupakan sebuah perkiraan saja, diagnosis pastinya tetap memerlukan pemeriksaan langsung secara klinis di dokter gigi. Jika keluhan tidak kunjung sembuh segera periksakan ke dokter gigi terdekat.. Namun, terdapat usaha dalam pengembangan aplikasi ini dapat berfungsi semaksimal mungkin dalam memberikan informasi, mohon digunakan dengan bijak.\n"+
                    "\nPihak pengembang mempersilahkan pengguna untuk memberi saran dan kritikan melalui kontra email perwakilan tim pengembang. mohon maaf yang sebesar-besarnya bila terdapat tutur kata yang kurang baik dalam aplikasi ini.\n\n"+
                    "Terimakasih pada pihak yang terlibat : \ndrg. Ana Riolina, \ndrg. Naviatullaily Y, MMR \ndrg. Septi Handayani\n\nTim penulis : \nSyafira Alma Raudhia\nDhiya’ Nada Putri\nAlya Aqila Majid\nAmara Syifa Tifani\n\nFakultas Kedokteran Gigi Universitas Muhammadiyah Surakarta",
            desc4 = "Terimakasih, \n" +
                    "Tim Pengembang.\n\n\n" +"CP Peneliti : syafiraraudia@gmail.com (Alma)\n"+
                    "CP : Riyantio84@gmail.com",
        )
    )
    val polamakanlist: List<listpolamakan> = listOf(
        listpolamakan(
            idpertanyaan = 0,
            soal = "Dalam 1 minggu berapa kali anda mengkonsumsi sayur?",
            jawaban1 = "   7x  ",
            jawaban2 = "5x - 6x",
            jawaban3 = "2x - 4x",
            jawaban4 = "0  - 1x",
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
            jawaban4 = "0  - 1x",
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
            jawaban4 = "0  - 1x",
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
            jawaban4 = "0  - 1x",
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
            jawaban4 = "0  - 1x",
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