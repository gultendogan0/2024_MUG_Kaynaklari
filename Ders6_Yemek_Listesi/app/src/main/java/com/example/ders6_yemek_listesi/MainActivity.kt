package com.example.ders6_yemek_listesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ders6_yemek_listesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var yemekListesi: ArrayList<Yemek>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        yemekListesi = ArrayList()

        //Data
        val yogurtlu_patates_yemegi = Yemek(
            "Yoğurtlu Patates Yemeği",
            "Sulu Yemek",
            "Puan: 5/5",
            "Yoğurtlu patates yemeği için kuzu etlerini nohut büyüklüğünde küpler halinde doğrayın ve düdüklü tencerede soğuk su ile birlikte yaklaşık 30 dakika haşlayın.Patatesleri iri küpler halinde kesin. Etler düdüklü tencerede piştikten sonra ağzı açık şekilde kaynatmaya devam edin. Tencereye patatesleri, nohutları ve tuzu ekleyip patatesler yumuşayana kadar orta ateşte pişmeye bırakın.Ayrı bir kasede yoğurt, yumurta ve unu pürüzsüz olana kadar çırpın. Karışıma tenceredeki sıcak et suyundan azar azar ekleyip karıştırın.Yoğurtlu karışımı ayrı bir tencereye alın, et suyundan da taneleri süzerek eklemeyi sürdürerek ve orta ateşte sürekli karıştırarak koyulaşana kadar pişirin.Sos koyulaşınca taneleri de yemeğe ekleyin.Üzeri için ufak bir tavada sade yağı kızdırın. Haspiri içine ekleyin, ocaktan alıp yemeğin üzerine dökün.Sosla da kızık ateşte 1-2 dakika piştikten sonra yoğurtlu patatesi servis edin. Afiyet olsun.",
            R.drawable.yogurtlu_patates_yemegi
        )

        val yaglama = Yemek(
            "Yağlama",
            "Hamur İşi",
            "Puan: 4/5",
            "Bir kabın içine unu alın ve ortasına bir havuz açın. Ilık süt, maya, sıvı yağ, tuz ve şekeri ilave ederek karıştırın.Ilık suyu azar azar ilave ederek hamuru yoğurun. Temiz bir kabın içine hafifçe un serpin ve hazırladığınız hamuru içine aktarın.Üzerini streç film ile kapatarak oda sıcaklığında iki katına çıkana kadar yaklaşık 40 dakika kadar mayalandırmaya bırakın. Bezeler haline getirin ve üzerini bir bezle kapatarak 10 dakika mayalanmaya bırakın.Soğanları küp küp doğrayın.Bir tavanın içine kıymaları alın hafifçe soteleyin.Ardından içine soğanları ilave edin ve kavurun. Soğanlar kavurulunca içine rendelenmiş domatesleri ilave edin.Salçasını da ilave edin ve pişmeye bırakın. Ardından azar azar su ilave edin, tuz ve karabiberini ekleyin.Bu şekilde 5-6 dakika daha pişirdikten sonra ocaktan alın.Oklava yardımıyla hafif unlayarak bezeleri tek tek açın.Yapışmaz bir tavayı ocağın üzerine alın ve iyice ısıtın. Isınan tavaya açtığınız hamurları tek tek aktarın ve arkalı önlü pişirin. Tüm hamura aynı işlemi uygulayın.Tüm yufkaları pişirdikten sonra bir pişmiş yufka ardından hazırladığınız kıymalı iç, ardından tekrar yufka sıralamasıyla kat çıkın.Tüm iç harç ve yufkalar bittiğinde üzerini ince kıyılmış maydanozla süsleyin ve dilimleyerek servis edin.",
            R.drawable.yaglama
        )

        val firinda_patatesli_tavuk = Yemek(
            "Fırında Patatesli Tevuk",
            "Tavuk",
            "Puan: 4/5",
            "Sos için gerekli tüm malzemeleri bir kabın içerisine ekleyin.Güzelce karıştırın.Tavukları bir borcama ya da ısıya dayanıklı fırın kabına dizin.Ardından üzerine sosu gezdirin.Elma şeklinde dilimlediğiniz patatesleri dizin.Ardından üzerine domates ve biberleri de dizin. Sebzelerin miktarı konusunda serbestsiniz.Tavukların kenarından suyu da ilave edin.Borcamın üzeri açık bir şekilde 190 derecelik fırında, tavukların üzeri kızarana kadar 35-40 dakika kadar pişirin.Pişince çıkarıp sıcak sıcak servis edin. Fırında patatesli tavuk tarifine herkes bayılacak. Afiyetler olsun!",
            R.drawable.firinda_patatesli_tavuk
        )

        val kori_soslu_tavuk = Yemek(
            "Kori Soslu Tavuk",
            "Tavuk",
            "Puan: 4/5",
            "Tavuk kalçalarını ufak lokmalık parçalar halinde kesin. Bir kasenin içinde tavukları, soğan rendesi, sarımsak, yoğurt, limon suyu, tuz, karabiber ve köri ile karıştırın. Kaseyi streçleyin ve buzdolabında 3 saat dinlendirin.Geniş bir tavayı ısıtın ve tavukları önlü arkalı az yağda 3-4 dakika kızartın. Kızaran tavukların üstüne krema ve köriyi de ekleyip ateşin altını en kısık konuma getirin.Sos koyulaşınca ocaktan alın ve yemeğin üstüne ince kıyılmış kişniş ya da maydanoz serperek servis edin. Afiyet olsun.",
            R.drawable.kori_soslu_tavuk
        )

        val manisa_kebabi = Yemek(
            "Manisa Kababı",
            "Köfte",
            "Puan: 5/5",
            "Köfte için tüm malzemeleri güzelce yoğurun.Kıymadan mandalina büyüklüğünde parçalar koparın ve çöp şişe dizin. 1 saat kadar buzdolabında dinlendirin.Dinlenen köfteleri döküm tavada ya da normal tava da arkalı önlü pişirin.Sos için tereyağını eritin. Salçayı kavurun.Üzerine suyu ekleyin ve kıvam alana kadar pişirin.Tırnak pideyi dişimleyin servis tabağına alın. Üzerine yoğurt sürün sosu dökün.Köfteleri yerleştirin. Üzerine kızdırılmış tereyağ ve kıyılmış maydanoz dökün. Közlenmiş biber ve domatesle servis edin. Afiyet olsun.",
            R.drawable.manisa_kebabi
        )

        val izmir_kofte = Yemek(
            "İzmir Köfte",
            "Köfte",
            "Puan: 3/5",
            "Köftenin tüm malzemelerini bir kap içerisine alın.Güzelce yoğurun.Elinizle şekil verin.Patatesleri elma dilim doğrayın, 180 derecede 10 dk pişirin.Köfteleride 180 derecede 8 dakika pişirin.Köftelerin arasına pişen patatesleri yerleştirin.Domates sosu için; tüm malzemeleri karıştırıp kaynatın. Yemeğe ekleyin.Bu şekilde 10 dakika daha pişirin. Ardından servis edin. Afiyet olsun!",
            R.drawable.izmir_kofte
        )

        val fellah_koftesi = Yemek(
            "Fellah Köftesi",
            "Bakliyat",
            "Puan: 5/5",
            "Ev yapımı fellah köftesi için 2 su bardağı ince bulguru bir kabın içerisine aktarın ve üzerine 2,5 su bardağı sıcak su ilave edin.Streç filmle üzerini kapatarak bulgur şişene kadar bekletin.Şişen bulgurun içerisine 1 adet yumurta ve 1 yemek kaşığı biber salçasını ilave edin. 1 su bardağı unu da azar azar ilave edere yoğurmaya başlayın.1 çay kaşığı tuz ve karabiberi ekleyerek bütünleşene kadar güzelce yoğurun.Elinizi hafifçe ıslatın. Hamurdan fındıktan biraz büyük parçalar kopararak iki avucunuzun içinde yuvarlayın. Yuvarladıktan sonra orta kısmına parmağınızla bastırarak bir çukur açın.Şekillendirdiğiniz köfteleri hafif unlanmış bir kabın içine aktarın ve güzelce harmanlayın.Tencerede kaynayan suyun içerisine köftelerinizi atın ve yumuşayana kadar 10-15 dakika kadar haşlayın.Haşlanan köfteleri kevgir yardımıyla süzdürerek borcamın içine alın.Bir tavanın içine 1,5 çay bardağı zeytinyağı ve 1 yemek kaşığı biber salçasını alın. Üzerine rendelenmiş ve rondodan geçirilmiş 1 su bardağı domatesi ekleyinKıvamı hafif yoğunlaşınca 2 diş rendelenmiş sarımsak, 1 çay kaşığı pulbiber, 1 çay kaşığı tane karabiber ve 1 çay kaşığı da tuz ilave ederek karıştırın.Ardından hazırladığınız sosu üzerine gezdirin ve güzelce karıştırın.Fellah köftesi hazır. Servis tabağına alın ve ince kıyılmış maydanozlar serperek servis edin. Afiyetler olsun.",
            R.drawable.fellah_kofte
        )


        yemekListesi.apply {
            add(yogurtlu_patates_yemegi)
            add(yaglama)
            add(firinda_patatesli_tavuk)
            add(kori_soslu_tavuk)
            add(manisa_kebabi)
            add(izmir_kofte)
            add(fellah_koftesi)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val yemekAdapter = YemekAdapter(yemekListesi)
        binding.recyclerView.adapter = yemekAdapter
    }
}
