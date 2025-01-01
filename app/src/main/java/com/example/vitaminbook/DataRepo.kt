package com.example.vitaminbook

import com.example.vitaminbook.dataClass.DailyIntake
import com.example.vitaminbook.dataClass.Vitamin

object DataRepo {
    private val dataName = arrayOf(
        "Vitamin A",
        "Vitamin B1",
        "Vitamin B2",
        "Vitamin B3",
        "Vitamin B5",
        "Vitamin B6",
        "Vitamin B7",
        "Vitamin B9",
        "Vitamin B12",
        "Vitamin C",
        "Vitamin D",
        "Vitamin E",
        "Vitamin K",
    )

    private val dataSynonym = arrayOf(
        "Retinol, beta karoten",
        "Tiamin",
        "Riboflavin",
        "Niasin, asam nikotinat",
        "Asam pantotenat",
        "Piridoksin",
        "Biotin",
        "Asam folat",
        "Kobalamin",
        "Asam askorbat",
        "Antirakitis",
        "Tokoferol",
        "Antikoagulasi, antipendarahan"
    )

    private val dataThumbnailUrl = arrayOf(
        "https://st2.depositphotos.com/5366154/12154/v/600/depositphotos_121549826-stock-illustration-vitamin-a-gold-icon-retinol.jpg",
        "https://st2.depositphotos.com/5366154/12155/v/600/depositphotos_121551576-stock-illustration-vitamin-b1-gold-icon-thiamine.jpg",
        "https://st2.depositphotos.com/5366154/12154/v/600/depositphotos_121546176-stock-illustration-vitamin-b2-gold-icon-riboflavin.jpg",
        "https://st.depositphotos.com/3538103/5122/i/600/depositphotos_51229721-stock-photo-vitamin-b3-isolated.jpg",
        "https://st2.depositphotos.com/5366154/12154/v/600/depositphotos_121547336-stock-illustration-vitamin-b5-gold-icon-pantothenic.jpg",
        "https://st2.depositphotos.com/5366154/12155/v/600/depositphotos_121555556-stock-illustration-vitamin-b6-gold-icon-pyridoxine.jpg",
        "https://st.depositphotos.com/3538103/5122/i/600/depositphotos_51229627-stock-photo-vitamin-b7-isolated.jpg",
        "https://st2.depositphotos.com/5366154/12154/v/600/depositphotos_121548726-stock-illustration-vitamin-b9-gold-icon-folic.jpg",
        "https://st2.depositphotos.com/5366154/12154/v/600/depositphotos_121549108-stock-illustration-vitamin-b12-gold-icon-cobalamin.jpg",
        "https://st2.depositphotos.com/5366154/12154/v/600/depositphotos_121545994-stock-illustration-vitamin-c-gold-icon-ascorbic.jpg",
        "https://st.depositphotos.com/3538103/5118/i/600/depositphotos_51180389-stock-photo-vitamin-d.jpg",
        "https://st2.depositphotos.com/5366154/12154/v/600/depositphotos_121549936-stock-illustration-vitamin-e-gold-icon-tocopherol.jpg",
        "https://st.depositphotos.com/3538103/5122/i/600/depositphotos_51229705-stock-photo-vitamin-k-isolated.jpg"
    )

    private val dataOverall = arrayOf(
        "Menjaga kesehatan mata dan reproduksi",
        "Membantu proses metabolisme karbohidrat dan mengendalikan kadar gula darah",
        "Membantu proses metabolisme makronutrisi dan menjaga kesehatan otak",
        "Menurunkan kadar trigliserida dan kolesterol jahat",
        "Membantu proses sintesis berbagai senyawa tubuh",
        "Membantu proses metaboliseme makronutrisi dan sintesis berbagai senyawa tubuh",
        "Memecah zat makronutrisi",
        "Mencegah cacat lahir pada ibu hamil",
        "Menjaga kesehatan otak dan regenerasi sel kulit",
        "Antioksidan untuk mencegah penyakit yang disebabkan oleh radikal bebas",
        "Membantu metabolisme kalsium dan meningkatkan imunitas tubuh",
        "Antioksidan untuk mencegah penyakit yang disebabkan oleh radikal bebas",
        "Membantu proses pembekuan darah dan menjaga kesehatan tulang"
    )

    private val dataUsageDescription = arrayOf(
        "Vitamin A termasuk vitamin yang larut dalam lemak. Vitamin A berasal dari dua sumber, yaitu retinol yang berasal dari sumber hewan dan beta-karoten yang berasal dari tanaman. Tubuh mengubah beta-karoten menjadi vitamin A. Karotenoid utama, termasuk lycopene, lutein, dan zeaxantuin, memiliki sifat biologis yang penting, termasuk antioksidan dan kegiatan photoprotective.\n\nVitamin A memiliki beberapa fungsi penting dalam tubuh, seperti membantu sel bereproduksi secara normal, menjaga fungsi penglihatan, serta menunjang pertumbuhan embrio dan janin secara normal.",

        "Vitamin B1 termasuk vitamin larut air yang berfungsi untuk memfasilitasi penggunan karbohidrat di dalam tubuh. Cara kerja tiamin adalah dengan berikatan dengan adenosine triphosphate (ATP) di hati, ginjal, dan leukosit untuk memproduksi tiamine diphosphate. Tiamin berfungsi untuk mengubah karbohidrat dan lemak menjadi energi, serta mengendalikan kadar gula darah di sel.",

        "Vitamin B2 (riboflavin) adalah vitamin larut air yang digunakan dalam proses metabolisme lemak dan protein dan mengubah karbohidrat menjadi glukosa yang diperlukan sel tubuh sebagai sumber energi. Riboflavin dibutuhkan agar saraf dan otak bisa berfungsi dengan baik, serta membantu menjaga kesehatan kulit, mata, rambut, dan hati.",

        "Vitamin B3 (Niasin) dapat menurunakan esterifikasi trigliserida hati, menurunkan kadar serum apolipoprotein B-100, dan menurunkan fraksi lemak jahat (LDL dan trigliserida). Niasin bermanfaat untuk menangani kolesterol, menurunkan risiko kardiovaskular, menurunkan aterosklerosis, dan menurunkan risiko serangan jantung. Niasin disetujui FDA untuk mengobati pellagra (kondisi yang sangat jarang akibat defisiensi niasin). ",

        "Berfungsi sebagai komponen koenzim A (CoA) yang berkerja langsung dalam proses asetilasi, Vitamin B5 (asam pantotenat) membantu kerja pelepasan energi molekul makronutrien. Asam pantotenat juga berperan dalam sintesis senyawa spingolipida, fosfolipid, sterol, hormone pertumbuhan, sel saraf, dan antibodi. Asam pantotenat juga berfungsi untuk meningkatkan GSH selular yang dapat memicu migrasi sel ke daerah luka dan mempercepat penyembuhan.",

        "Vitamin B6 termasuk vitamin yang larut dalam air. Vitamin B6 bekerja sebagai koenzim biologis yang terlibat dalam berbagai reaksi kimia, seperti reaksi metabolisme protein, karbohidrat, dan lemak; sintesis asam nukleat, hemoglobin, serotonin, dopamin, noreprinefrin, dan asam aminobutirat gamma (sing. dalam bhs. Inggris: GABA). Vitamin B6 bermanfaat bagi fungsi darah, kulit, dan sistem saraf pusat.",

        "Biotin adalah komponen enzim yang berperan penting dalam tubuh dengan memecah lemak, karbohidrat, dan zat-zat lain. Biotin biasanya digunakan untuk rambut rontok, kuku rapuh, kerusakan saraf, dan berbagai kondisi lainnya.",

        "Vitamin B9 atau asam folat merupakan senyawa biokimia inaktif. Ketika dikonsumsi, vitamin B9 akan diubah menjadi asam tetrahidrofolat dan metiltetrahidrofolat melalui bantuan enzim dihidrofolat reduktase. Senyawa tersebut akan diangkut menuju sel-sel yang dibutuhkan dalam proses RME (reseptor-mediated endositosis). Senyawa tersebut penting dalam menjaga proses pembentukan sel darah merah serta sintesis purin dan pirimidin.\n\nAsam folat sangat dibutuhkan oleh ibu hamil untuk mencegah cacat lahir. Vitamin B9 dapat mengatasi efek samping methotrexate pada penyakit arthritis, psoriasis, dan penyakit Crohn yang tergolong parah.",

        "Vitamin B12 termasuk jenis vitamin yang larut dalam air. Vitamin B12 diperlukan untuk menjaga kesehatan otak dan jaringan saraf, memproduksi sel darah merah, serta membantu proses regenerasi sel kulit.",

        "Vitamin C termasuk jenis vitamin yang larut dalam air. Tubuh membutuhkan vitamin C untuk pertumbuhan dan perbaikan jaringan di seluruh bagian tubuh. Vitamin C akan membantu pembuatan kolagen (protein pembentuk kulit), membantu penyembuhan luka, memperbaiki dan menjaga tulang dan gigi, serta membantu tubuh menyerap zat besi. Vitamin C termasuk antioksidan yang berperan dalam memblokir beberapa kerusakan yang disebabkan oleh radikal bebas, seperti kanker, penyakit jantung, dan arthritis.",

        "Vitamin D termasuk jenis vitamin yang larut dalam lemak. Dua bentuk aktif dari vitamin D ini adalah vitamin D2 (erkalsitriol) dan vitamin D3 (kalsitriol). Vitamin D3 (kalsitriol) berperan dalam metabolisme absorpsi kalsium ke dalam tulang, gigi, fungsi otot, sekaligus meningkatkan sistem kekebalan tubuh.",

        "Vitamin E termasuk jenis vitamin yang larut dalam lemak. Vitamin E bekerja dengan menghasilkan efek antioksidan di dalam tubuh yang dapat memperlambat sel-sel tubuh dari kerusakan. Isomer vitamin E (tocotrienol) memiliki tiga ikatan ganda yang berdampak positif terhadap kesehatan kardiovaskular karena mampu mengontrol produksi kolesterol, sehingga dapat memperlambat perkembangan ateroksklerosis (penebalan arteri).",

        "Vitamin K (Koagulations Vitamin) termasuk jenis vitamin yang larut dalam lemak. Vitamin K bermanfaat dalam proses pembekuan darah dan kesehatan tulang.\n\nDi hati, vitamin K bekerja dengan cara mensistesis protombin dan faktor pembekuan darah lainnya melalui aktivasi protrombin dengan reaksi karboksilasu gugus gula pada residu protein prekursornya. Asam glutamate yang mengalami reaksi karboksilasi akan berubah menjadi asam karboksiglutamat gamma.\n\nDi tulang, vitamin K akan membantu senyawa osteokalsin yang berperan dalam penyerapan mineral untuk membentuk struktur tulang yang kuat."
    )

    private val dataPhotoCardUrl = arrayOf(
        "https://st3.depositphotos.com/1000589/32216/i/450/depositphotos_322162788-stock-photo-foods-high-in-vitamin-a.jpg",
        "https://st3.depositphotos.com/1000589/14033/i/450/depositphotos_140333952-stock-photo-foods-highest-in-vitamin-b1.jpg",
        "https://st3.depositphotos.com/1000589/14033/i/450/depositphotos_140334106-stock-photo-foods-highest-in-vitamin-b2.jpg",
        "https://st3.depositphotos.com/1000589/32216/i/450/depositphotos_322161028-stock-photo-foods-high-in-niacin-vitamin.jpg",
        "https://st2.depositphotos.com/1000589/9993/i/450/depositphotos_99930314-stock-photo-food-highest-in-vitamin-b5.jpg",
        "https://st2.depositphotos.com/1000589/10783/i/450/depositphotos_107831148-stock-photo-foods-highest-in-vitamin-b6.jpg",
        "https://st4.depositphotos.com/1000589/20045/i/450/depositphotos_200459160-stock-photo-foods-rich-vitamin-biotin-healthy.jpg",
        "https://st4.depositphotos.com/3518393/19821/i/600/depositphotos_198212696-stock-photo-inscription-folic-acid-nutritious-ingredients.jpg",
        "https://st3.depositphotos.com/1000589/32216/i/450/depositphotos_322163710-stock-photo-natural-sources-of-vitamin-b12.jpg",
        "https://st2.depositphotos.com/5363990/7923/i/600/depositphotos_79233644-stock-photo-products-containing-vitamin-c.jpg",
        "https://st2.depositphotos.com/5363990/7923/i/600/depositphotos_79233646-stock-photo-foods-containing-vitamin-d.jpg",
        "https://st2.depositphotos.com/5363990/7923/i/600/depositphotos_79233660-stock-photo-foods-containing-vitamin-e.jpg",
        "https://st2.depositphotos.com/1000589/10572/i/600/depositphotos_105728332-stock-photo-foods-highest-in-vitamin-k.jpg"
    )

    private val dataDeficiencyDescription = arrayOf(
        "Kekurangan vitamin A jarang terjadi di negara maju karena baiknya pengetahuan dan sumber makanan yang terjaga. Tanda pertama yang sering terlihat saat tubuh kekurangan vitamin A adalah burukunya penglihatan di malam hari (rabun senja). Efek lebih lanjut akan menyebabkan mata kering, buta ayam, diare, dan masalah kulit.",

        "Kekurangan tiamin paling banyak disebabkan oleh konsumsi alkohol berlebihan. Kekurangan tiamin dapat menyebabkan peradangan pada saraf (neuritis) yang berhubungan dengan pellagra atau kehamilan, pada tingkat berat dapat menyebabkan penyakit beri-beri yang dapat mempengaruhi sistem kardiovaskular. \n",

        "Tanda-tanda tubuh mengalami kekurangan riboflavin antara lain kelelahan, mata cepat lelah, tenggorokan bengkak dan nyeri, lidah bengkak dengan warna merah tua, sariawan, masalah pencernaan, pertumbuhan yang lambat pada anak-anak atau selama kehamilan, serta terlalu sensitif terhadap cahaya.",

        "Kekurangan vitamin B3 dalam tubuh dapat menyebabkan gejala, seperti demensia, diare, peradangan kulit. Niasin sebaiknya dikonsumsi sesudah makan untuk mengurangi risiko efek samping sakit perut dan dapat diminum oleh anak-anak dan dewasa.",

        "kekurangan asam pantotenat dapat menyebabkan kelelahan, depresi, mudah tersinggung, sakit kepala, insomnia, kram otot, muntah, dan gangguan pencernaan.",

        "Kekurangan vitamin B6 dapat menyebabkan rasa mual saat kehamilan (morning sickness), anemia sideroblastik, dan kejang-kejang.",

        "Kadar biotin yang rendah dapat terjadi pada ibu hamil, ibu menyusui, orang kekurangan gizi, orang yang mengalami penurunan berat badan secara cepat, orang yang memiliki kondisi bawaan tertentu, dan perokok. Kadar biotin yang rendah dapat menyebabkan penipisan rambut dan ruam di sekitar mata, hidung, dan mulut. Gejala lainnya adalah depresi, kurang minat, berhalusinasi, dan kesemutan pada lengan dan kaki. ",

        "Kekurangan vitamin B9 dapat diketahui dari gejala cepat lelah yang merupakan salah satu tanda terkena penyakit anemia. Ibu hamil yang kekurangan vitamin bisa menyebabkan cacat lahir berupa celah pada tulang belakang bayi.",

        "Kekurangan vitamin B12 dapat menyebabkan gangguan perkembangan otak, seperti demensia Alzheimer dan demensia vaskular pada orang tua. Ibu hamil yang kekurangan vitamin B12 akan melahirkan bayi yang mengidap resistensi insulin tubuh dan gangguan metabolisme, sehingga anak akan berisiko menderita obesitas.",

        "Merokok dapat menurunkan jumlah vitamin C dalam tubuh. Tanda-tanda tubuh kekurangan vitamin C antara lain rambut kering dan membelah, gingivitis (radang gusi), kulit kasar, mudah memar, mimisan, serta imunitas menurun. Suatu bentuk yang paling parah dari kekurangan vitamin C dikenal sebagai penyakit Scurvy. Rendahnya kadar vitamin C dalam tubuh telah dikaitkan dengan sejumlah kondisi, termasuk tekanan darah tinggi, penyakit kandung empedu, stroke, beberapa jenis kanker, dan aterosklerosis (penumpukan plak di dalam pembuluh darah).",

        "Tanda-tanda tubuh mengalami kekurangan vitamin D antara lain sering sakit (terutama saluran pernapasan, batuk, flu), cepat merasa lelah, tulang dan sendi sakit, luka yang lama sembuh, depresi, sulit berpikir jernih, otot lemas, dan rambut rontok. Kekurangan vitamin D juga dapat menyebabkan osteoporosis (tulang keropos).",

        "Kekurangan vitamin E dapat menyebabkan kelemahan dan kesulitan berjalan, nyeri pada otot betis, gangguan penglihatan, anemia, dan kelainan kulit. Pada bayi prematur yang kekurangan vitamin E dapat menyebabkan gangguan dalam penyerapan lemak. Kekurangan vitamin E juga disebabkan karena diet rendah lemak yang sangat tidak proporsional dalam jangka waktu yang lama",

        "Kekurangan vitamin K sangat jarang terjadi, namun dapat terjadi apabila tubuh benar-benar tidak dapat menyerap vitamin dari usus. Defisiensi vitamin K dapat memicu terjadinya pendarahan yang sulit dihentikan."
    )

    private val dataUnit = arrayOf(
        "RE",
        "mg",
        "mg",
        "mg",
        "mg",
        "mg",
        "mcg",
        "mcg",
        "mcg",
        "mg",
        "mcg",
        "mcg",
        "mcg"
    )

    private val dataFoodSource = arrayOf(
        "Vitamin A dalam bentuk retinyl palmitate ditemukan pada daging sapi, telur, minyak ikan, dan produk susu. Vitamin A juga bisa didapat dalam bentuk beta-karoten yang bersumber dari sayuran berwarna hijau gelap berdaun, sayuran kuning/oranye, kentang, wortel, labu, melon, aprikot, persik, dan mangga.",

        "Vitamin B1 banyak terkandung dalam ragi, biji-bijian sereal, kacang-kacangan, dan daging. Selain itu, vitamin B1 ini juga terdapat dalam bentuk suplemen yang dikombinasikan dengan vitamin B lainnya dan asam folat.",

        "Beberapa sumber riboflavin terbaik yang bisa didapatkan dari makanan adalah almond, brokoli, bayam, telur, susu, yogurt, nasi dan daging. Perlu diingat bahwa riboflavin adalah vitamin yang larut dalam air, jadi ketika makanan tersebut direbus, vitamin tersebut akan kehilangan hingga setengahnya. Dengan kata lain, nikmati makanan mentah jika memungkinkan.",

        "Vitamin B3 (niasin) dapat bersumber dari banyak makanan, seperti daging, ikan (tuna dan salmon), telur, jamur, hati, sayuran hijau, susu, dan kentang.",

        "Sumber asam pantotenat yang secara alami didapat dari daging, ikan, unggas, hati, telur, apel, alpukat, pisang, asparagus, wortel, kacang almond, gandum, kacang brazil, gandung hitam, kacang mete, kacang kenari, biji rami, brokoli, jagung, dan labu.",

        "Vitamin B6 dapat bersumber dari daging ayam atau sapi, hati ayam, ubi jalar, telur, ikan salmon dan tuna, kacang-kacangan, pisang, alpukat, wortel, bayam, susu, dan keju.",

        "Biotin dapat ditemukan dalam jumlah kecil pada berbagai makanan, seperti telur, susu, dan pisang.",

        "Vitamin B9 dapat diperoleh dari makanan, seperti brokoli, kentang, buncis, bayam, kubis, hati, sereal, kacang polong, kacang hijau, dan asparagus.",

        "Vitamin B12 secara alami berasal dari daging, tetapi orang vegetarian dapat memperoleh vitamin B12 dalam bentuk suplemen.",

        "Sumber makanan yang mengandung vitamin C tinggi antara lain jambu biji, jeruk, paprika, semangka, pepaya, lemon, melon, buah beri, kiwi, mangga, brokoli, tomat, kembang kol, kubis, sayuran berdaun hijau, dan nanas.",

        "80% dari sumber vitamin D berasal dari matahari, namun vitamin D juga dapat didapatkan dari konsumsi makanan sehari-hari, seperti jamur, kacang almond, kacang kedelai, kelapa, kuning telur, daging merah (seperti daging sapi), sarden, salmon, tuna, hati sapi, keju, dll.",

        "Vitamin E dapat didapatkan dari susu, mentega, telur, minyak kedelai, minyak biji gandum, kacang-kacangan, dan kecambah. Mengkonsumsi vitamin E dalam bentuk alami lebih disarankan dibandingkan vitamin E buatan.",

        "Vitamin ini dapat ditemukan dari asupan makanan (seperti brokoli, bayam, kol, selada, kacang kedelai, telur, daging, sereal, stroberi, minyak sayur) dan mikroflora pada saluran pencernaan (misalnya vitamin K2 yang secara normal diproduksi oleh bakteri dalam saluran pencernaan manusia)."
    )

    private val dataReferenceUrl = arrayOf(
        "https://www.honestdocs.id/vitamin-a",
        "https://www.honestdocs.id/vitamin-b1",
        "https://www.honestdocs.id/vitamin-b2",
        "https://www.honestdocs.id/vitamin-b3",
        "https://www.honestdocs.id/vitamin-b5",
        "https://www.honestdocs.id/vitamin-b6",
        "https://www.honestdocs.id/zat-biotin",
        "https://www.honestdocs.id/vitamin-b9",
        "https://www.honestdocs.id/vitamin-b-12",
        "https://www.honestdocs.id/vitamin-c",
        "https://www.honestdocs.id/vitamin-d",
        "https://www.honestdocs.id/info-vitamin-e",
        "https://www.honestdocs.id/koagulations-vitamin",
    )

    private val dataPeople = arrayOf(
        "Bayi/Anak 0 - 5 bulan",
        "Bayi/Anak 6 - 11 bulan",
        "Bayi/Anak 1 - 3 tahun",
        "Bayi/Anak 4 - 6 tahun",
        "Bayi/Anak 7 - 9 tahun",
        "Laki-laki 10 - 12 tahun",
        "Laki-laki 13 - 15 tahun",
        "Laki-laki 16 - 18 tahun",
        "Laki-laki 19 - 29 tahun",
        "Laki-laki 30 - 49 tahun",
        "Laki-laki 50 - 64 tahun",
        "Laki-laki 65 - 80 tahun",
        "Laki-laki 80+ tahun",
        "Perempuan 10 - 12 tahun",
        "Perempuan 13 - 15 tahun",
        "Perempuan 16 - 18 tahun",
        "Perempuan 19 - 29 tahun",
        "Perempuan 50 - 64 tahun",
        "Perempuan 65 - 80 tahun",
        "Perempuan 80+ tahun",
        "Perempuan hamil trimester 1",
        "Perempuan hamil trimester 2",
        "Perempuan hamil trimester 3",
        "Perempuan menyusui 6 bulan pertama",
        "Perempuan menyusui 6 bulan kedua",
    )

    private val dataDailyIntakeValue = arrayOf(
        arrayOf(375.0, 400.0, 400.0, 450.0, 500.0, 600.0, 600.0, 700.0, 650.0, 650.0, 650.0, 650.0, 650.0, 600.0, 600.0, 600.0, 600.0, 600.0, 600.0, 600.0, 600.0, 300.0, 300.0, 300.0, 350.0, 350.0),
        arrayOf(0.2, 0.3, 0.5, 0.6, 0.9, 1.1, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.0, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 0.3, 0.3, 0.3, 0.4, 0.4),
        arrayOf(0.3, 0.4, 0.5, 0.6, 0.9, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.0, 1.0, 1.0, 1.1, 1.1, 1.1, 1.1, 1.1, 0.3, 0.3, 0.3, 0.5, 0.5),
        arrayOf(2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 16.0, 16.0, 16.0, 16.0, 16.0, 16.0, 16.0, 12.0, 14.0, 14.0, 14.0, 14.0, 14.0, 14.0, 14.0, 4.0, 4.0, 4.0, 3.0, 3.0),
        arrayOf(1.7, 1.8, 2.0, 3.0, 4.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 1.0, 1.0, 1.0, 2.0, 2.0),
        arrayOf(0.1, 0.3, 0.5, 0.6, 1.0, 1.3, 1.3, 1.3, 1.3, 1.3, 1.7, 1.7, 1.7, 1.2, 1.2, 1.2, 1.3, 1.3, 1.5, 1.5, 1.5, 0.6, 0.6, 0.6, 0.6, 0.6),
        arrayOf(5.0, 6.0, 8.0, 12.0, 12.0, 20.0, 25.0, 30.0, 30.0, 30.0, 30.0, 30.0, 30.0, 20.0, 25.0, 30.0, 30.0, 30.0, 30.0, 30.0, 30.0, 0.0, 0.0, 0.0, 5.0, 5.0),
        arrayOf(80.0, 80.0, 160.0, 200.0, 300.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 400.0, 200.0, 200.0, 200.0, 100.0, 100.0),
        arrayOf(0.4, 1.5, 1.5, 1.5, 2.0, 3.5, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 3.5, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 0.5, 0.5, 0.5, 1.0, 1.0),
        arrayOf(40.0, 50.0, 40.0, 45.5, 45.5, 50.0, 75.0, 90.0, 90.0, 90.0, 90.0, 90.0, 90.0, 50.0, 65.0, 75.0, 75.0, 75.0, 75.0, 75.0, 75.0, 10.0, 10.0, 10.0, 45.0, 45.0),
        arrayOf(10.0, 10.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 20.0, 20.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 20.0, 20.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        arrayOf(4.0, 5.0, 6.0, 7.0, 8.0, 11.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0, 20.0, 20.0, 0.0, 0.0, 0.0, 4.0, 4.0),
        arrayOf(5.0, 10.0, 15.0, 20.0, 25.0, 35.0, 55.0, 55.0, 65.0, 65.0, 65.0, 65.0, 65.0, 35.0, 55.0, 55.0, 55.0, 55.0, 55.0, 55.0, 55.0, 0.0, 0.0, 0.0, 0.0, 0.0),
    )

    fun getDailyIntakeList(i: Int): ArrayList<DailyIntake> {
        val list = ArrayList<DailyIntake>()
        val dailyIntakes = dataDailyIntakeValue[i]
        for (pos in dataPeople.indices) {
            list.add(DailyIntake(dataPeople[pos], dailyIntakes[pos]))
        }
        return list
    }

    fun getVitaminList(): ArrayList<Vitamin>  {
        val list = ArrayList<Vitamin>()
        for (i in dataName.indices) {
            val vitamin = Vitamin(dataName[i], dataThumbnailUrl[i], dataSynonym[i], dataOverall[i], dataUsageDescription[i], dataPhotoCardUrl[i], dataDeficiencyDescription[i], dataFoodSource[i], dataUnit[i], dataReferenceUrl[i])
            list.add(vitamin)
        }
        return list
    }

}