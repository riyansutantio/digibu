package com.example.gigi_ibuhamil.util

import com.example.gigi_ibuhamil.R
import com.example.gigi_ibuhamil.models.*
import com.example.gigi_ibuhamil.ui.*

class lists {
    val penyakitllist: List<listpenyakit> =listOf(
        listpenyakit(
            id = "P01",
            namaPenyakit = "Karies Gigi",
            deskripsi = "Lubang pada gigi karena proses demineralisasi struktur gigi oleh asam yang dihasilkan oleh mikroorganisme yang ditandai adanya kavitas (lubang) pada gigi. \n\n" +
                    "Karies gigi pada ibu hamil dipengaruhi oleh peningkatan hormon progesterone selama kehamilan yang menyebabkan penurunan plasma bikarbonat dan memicu pH saliva (air liur) menjadi asam. pH saliva (air liur) berperan untuk menjaga stabilitas email gigi, jika mengalami penurunan pH akan berisiko meningkatkan pertumbuhan bakteri kariogenik. Hal tersebut membuat ibu hamil lebih rentan mengalami karies. \n\n" +
                    "*pH\uF0E0 tingkat keasaman \n" +
                    "*email \uF0E0 bagian terluar dan terkuat dari gigi yang dapat dilihat \n",
            gejala = "a. Sakit gigi dan nyeri \n" +
                    "b. Sensitivitas gigi \n" +
                    "c. Terlihat adanya lubang di gigi\n" +
                    "d. Ada noda coklat, hitam, atau putih pada permukaan gigi\n" +
                    "e. Sakit apabila untuk menggigit",
            //pengobatan
            penyebab = "Pengobatan yang dapat dilakukan untuk menangani gigi yang mengalami karies, diantaranya:\n" +
                    "a. Penambalan pada area yang berlubang \n" +
                    "b. Pembuatan mahkota gigi buatan jika lubang pada gigi cukup besar \n" +
                    "c. Perawatan saluran akar apabila kerusakan gigi telah mencapai syaraf \n" +
                    "d. Pencabutan, merupakan pilihan terakhir apabila gigi sudah dalam kondisi yang parah dan pasien menghendaki untuk dicabut.\n",
            //komplikasi
            penanganan = "Apabila karies gigi tidak segera ditangani, dikahawatirkan akan menimbulkan komplikasi lain, diantaranya:\n" +
                    "a. Nyeri berkepanjangan \n" +
                    "b. Abses gigi dan pembengkakan \n" +
                    "c. Kesulitan saat makan \n" +
                    "d. Kehilangan gigi yang dapat memicu pergeseran gigi lan serta mempengaruhi penampilan\n",
            pencegahan = "Perawatan mendasar pencegahan karies adalah dengan menggosok gigi secara teratur 2x sehari (setelah sarapan dan sebelum tidur). Flossing atau menggunakan benang gigi juga direkomendasikan untuk menghilangkan sisa makanan diantara sela-sela gigi yang sulit diraih sikat gigi. \n\n" +
                    "Pilihlah sikat gigi yang kecil dan lembut agar dapat menjangkau area gigi paling belakang, tetap lakukan kontrol rutin setiap 6 bulan sekali untuk langkah pencegahan yang paling optimal \n\n" +
                    "Untuk ibu hamil, disarankan untuk mengkonsumsi makanan yang bergizi dan menyikat gigi dengan pasta gigi berfluoride untuk menjaga kebersihan gigi dan memperkuat email gigi. \n",
            perawatan = "",
            gambar1 = R.drawable.penyakit1
        ),
        listpenyakit(
            id = "P02",
            namaPenyakit = "Gingivitis",
            deskripsi = "Gingivitis (radang gusi) adalah peradangan yang ditandai dengan pembengkakan dan kemerahan pada gusi sekitar pangkal gigi. Gingivitis saat kehamilan (gingivitis gradiraum) terjadi akibat perubahan hormonal berupa peningkatan konsentrasi hormon estrogen dan progesteron yang meningkat pada usia 8-9 bulan kehamilan dan kembali normal setelah melahirkan. ",
            gejala = "Gingivitis selama kehamilan ditandai dengan:\n" +
                    "a. Pembengkakan pada ujung gusi yang melekat pada pangkal gigi \n" +
                    "b. Gusi mudah berdarah \n" +
                    "c. Terdapat pembengkan dan warna kemerahan \n",
            //pengobatan
            penyebab = "a. Scaling -> tindakan penghilangan karang gigi pada permukaan gigi, sebagai upaya menjaga keberishan rongga mulut. Perawatan pada ibu hamil direkomendasikan pada usia kehamilan trisemester ke-2 ",
            //komplikasi
            penanganan = "Apabila gingivitis tidak ditangani, maka dapat berpotensi peradangan yang semakin parah dan menyebar ke jaringan pendukung gigi. ",
            pencegahan = "Perawatan mendasar pencegahan gingivitis adalah dengan menggosok gigi secara teratur 2x sehari (setelah sarapan dan sebelum tidur). Flossing atau menggunakan benang gigi juga direkomendasikan untuk menghilangkan sisa makanan diantara sela-sela gigi yang sulit diraih sikat gigi. \n\n" +
                    "Pilihlah sikat gigi yang kecil dan lembut agar dapat menjangkau area gigi paling belakang, tetap lakukan kontrol rutin setiap 6 bulan sekali ke dokter gigi untuk langkah pencegahan yang paling optimal.\n\n" +
                    "Untuk ibu hamil, disarankan untuk mengkonsumsi makanan yang bergizi dan menyikat gigi dengan pasta gigi berfluoride untuk menjaga kebersihan gigi dan memperkuat email gigi.\n",
            perawatan = "",
            gambar1 = R.drawable.penyakit2
        ),
        listpenyakit(
            id = "P03",
            namaPenyakit = "Periodontitis",
            deskripsi = "Merupakan penyakit periodontal (penyokong gigi) yang diakibatkan oleh peningkatan hormon estrogen selama kehamilan. Kondisi ini ditandai dengan peradangan pada gusi sebagai respon tubuh terhadap bakteri yang terkumpul di gigi dan sekitarnya. \n\n" +
                    "Periodontitis terjadi akibat kumpulan plak di gigi, plak tersebut dapat berasal dari sisa makanan yang tidak dibersihkan dan higenitas rongga mulut yang buruk. Plak yang mengeras akan menjadi kalkulus (karang gigi), semakin banyak plak dan kalkulus di gigi, maka resiko kerusakan pada penyokong gigi semakin tinggi. \n\n" +
                    "Faktor yang memeprburuk penyakit periodontal dimasa kehamilan adalah plak, usia kehamilan, karies, usia ibu hamil, tingkat pendidikan dan pengetahuan, frekuensi waktu menyikat gigi, dan kebersihan rongga mulut. \n",
            gejala = "Gejala periodontitis secara umum ditandai dengan:\n" +
                    "a. Pembengkakan gusi \n" +
                    "b. Gusi memerah, gelap, atau keunguan\n" +
                    "c. Gusi mudah berdaraj \n" +
                    "d. Bau mulut \n" +
                    "e. Gigi yang goyang \n" +
                    "f. Terbentung rongga natara gusi dan gigi \n",
            //Pengobatan
            penyebab = "Pengobatan yang dilakukan untuk kondisi periodontitis:\n" +
                    "a. Scaling \n" +
                    "   Tindakan penghilangan karang gigi pada permukaan gigi, sebagai upaya perawatan kesehatan rongga mulut. \n" +
                    "b. Root planning \n" +
                    "   Upaya penghalusan permukaan akar gigi untuk mengurangi bakteri dan hal lain yang memicu peradanagn pada gusi. \n" +
                    "c. Pemberian antibiotik \n" +
                    "   Pemberian antibiotik ditujukan untuk mengendalika infeksi yang terjadi. \n",
            //komplikasi
            penanganan = "Jika terus dibiarkan, periodontitis menimbulkan komplikasi lain, diantaranya:\n" +
                    "a. Abses gigi (kumpulan nanah)\n" +
                    "b. Kerusakan jaringan pendukung gigi \n" +
                    "c. Gigi goyang yang memicu gigi tanggal \n",
            pencegahan = "Perawatan mendasar pencegahan periodontitis adalah dengan menggosok gigi secara teratur 2x sehari (setelah sarapan dan sebelum tidur). Flossing atau menggunakan benang gigi juga direkomendasikan untuk menghilangkan sisa makanan diantara sela-sela gigi yang sulit diraih sikat gigi. \n\n" +
                    "Pilihlah sikat gigi yang kecil dan lembut agar dapat menjangkau area gigi paling belakang, tetap lakukan kontrol rutin setiap 6 bulan sekali ke dokter gigi untuk langkah pencegahan yang paling optimal.\n\n" +
                    "Untuk ibu hamil, disarankan untuk mengkonsumsi makanan yang bergizi dan menyikat gigi dengan pasta gigi berfluoride untuk menjaga kebersihan gigi dan memperkuat email gigi.\n",
            perawatan = "",
            gambar1 = R.drawable.penyakit3
        ),
    )
    val gejalalist: List<listgejala> = listOf(
        listgejala(
            id = "Kurang Tepat",
            namagejala = "Perilaku menjaga kesehatan gigi dan mulut anda masih buruk, cobalah untuk melakukan perawatan kesehatan gigi dan mulut secara mandiri untuk merawatan kondisi rongga mulut selama kehamilan. \n" +
                    "a.\tLakukan sikat gigi 2x sehari setelah sarapan dan sebelum tidur dan menggunakan dental floss untuk membersihkan sela-sela gigi. Pilihlah sikat gigi yang kecil dan lembut agar dapat menggapai bagian belakang gigi. \n" +
                    "b.\tGunakan pasta gigi berfloride untuk memperkuat email gigi. \n" +
                    "c.\tLakukan kontrol rutin ke dokter gigi setiap 6 bulan sekali. Perawatan gigi selama kehamilan direkomendasikan saat usia kehamilan di trimester ke-2 \n" +
                    "d.\tUsahakan berkumur setiap setelah muntah, untuk menghilangkan sisa zat asam dan sisa makanan di rongga mulut yang dapat memicu masalah gigi dan mulut\n" +
                    "e.\tPerbanyak minum air putih dan kurangi makanan manis \n" +
                    "•\tMenjaga kesehatan gigi dan mulut selama kehamilan sangatlah penting, penyakit rongga mulut dapat mengakibatkan konsumsi makanan yang berkurang dan berisiko pada perkembangan janin. \n" +
                    "•\tBagaimana cara menyikat gigi dengan benar? Silakan untuk cek di fitur video ya! "
        ),
        listgejala(
            id = "Baik",
            namagejala = "Perilaku menjaga kesehatan gigi anda telah benar! Tetap pertahankan. Untuk edukasi lebih lanjut silakan membuka fitur video dan modul yaa!"
        ),
        listgejala(
            id = "Kurang Tepat",
            namagejala = "Perilaku menjaga kesehatan gigi dan mulut anda masih buruk, cobalah untuk melakukan perawatan kesehatan gigi dan mulut secara mandiri untuk merawatan kondisi rongga mulut selama kehamilan. \n" +
                    "f.\tLakukan sikat gigi 2x sehari setelah sarapan dan sebelum tidur dan menggunakan dental floss untuk membersihkan sela-sela gigi. Pilihlah sikat gigi yang kecil dan lembut agar dapat menggapai bagian belakang gigi. \n" +
                    "g.\tGunakan pasta gigi berfloride untuk memperkuat email gigi. \n" +
                    "h.\tLakukan kontrol rutin ke dokter gigi setiap 6 bulan sekali. Perawatan gigi selama kehamilan direkomendasikan saat usia kehamilan di trimester ke-2 \n" +
                    "i.\tUsahakan berkumur setiap setelah muntah, untuk menghilangkan sisa zat asam dan sisa makanan di rongga mulut yang dapat memicu masalah gigi dan mulut\n" +
                    "j.\tPerbanyak minum air putih dan kurangi makanan manis \n" +
                    "•\tMenjaga kesehatan gigi dan mulut selama kehamilan sangatlah penting, penyakit rongga mulut dapat mengakibatkan konsumsi makanan yang berkurang dan berisiko pada perkembangan janin. \n" +
                    "•\tBagaimana cara menyikat gigi dengan benar? Silakan untuk cek di fitur video ya!\n"
        ),
        listgejala(
            id = "Baik",
            namagejala = "Perilaku menjaga kesehatan gigi anda telah benar! Tetap pertahankan. Untuk edukasi lebih lanjut silakan membuka fitur video dan modul yaa!"
        ),
        listgejala(
            id = "Kekurangan berat badan",
            namagejala = "•\tBMI (body mass index) memiliki rentan ideal di angka 18,5-25. Jika BMI anda kurang <18,5 terdapat kemungkinan jika asupan makan yang kurang yang bisa jadi diakibatkan karena kehilangan nafsu makan selama kehamilan. \n" +
                    "•\tSelama kehamilan, disarankan untuk menjaga BMI dalan range normal untuk mencegah risiko bayi lahir prematur, bayi berat lahir rendah, dan keguguran. \n" +
                    "•\tSegera konsultasikan dengan bidan terdekat untuk memantau tumbuh kembang bayi dalam kandungan dan diskusikan terkait pola makan agar BMI kembali normal. \n"
        ),
        listgejala(
            id = "Normal",
            namagejala = "•\tBMI anda sudah berada dalam kondisi yang normal, tetap pertahankan dan tetap mengkonsumi makanan yang bergizi. "
        ),
        listgejala(
            id = "Kelebihan berat badan",
            namagejala = "•\tJika BMI anda >25 maka anda dikategorikan kelebihan berat badan. Hal ini dapat dipicu karena pertumbuhan janin dalam kandungan, namun tetap disarankan tetap dalam batasan yang normal (18,5-25). \n" +
                    "•\tPemicu terjadinya kelebihan berat badan diantaranya adalah konsumsi makanan berkalori tinggi, dan kurangnya aktivitas fisik. \n" +
                    "•\tIbu hamil yang mengalami kelebihan berat badan lebih berisiko mengalamai keguguran, preeklamsia, persalinaan yang diinduksi, dan permasalahan saat menyusui. \n"
        )
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