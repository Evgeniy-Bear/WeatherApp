package com.shestakov.weatherapp.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(
    text: String,
    actionText: String,
    action: (View) -> Unit,
    length: Int = Snackbar.LENGTH_INDEFINITE
) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}

fun getHeaderPicture(cityName: String): String {
    when (cityName) {
        "Москва" -> return "https://www.m24.ru/b/d/nBkSUhL2hFEnmsqyIr6BosSyyJ2gp8T" +
                    "rlnTclb7P73OHezeOWXiSxTZt4slI-BHBsdWR_G-JLsV0=zc8_-mxcKqLEk-c_ELPdrQ.jpg"
        "Санкт-Петербург" -> return  "https://etu.ru/assets/cache/images/en/why-us/cultural-capital/1280x854-03.74d.jpg"
        "Новосибирск" -> return  "https://www.alrosa.aero/wp-content/uploads/2018/12" +
                    "/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D0%B8%D0%B8%D1%80%D1%81%D0%BA.jpg"
        "Екатеринбург" -> return "https://s0.rbk.ru/v6_top_pics/media/img/5/68/756141566421685.jpg"
        "Нижний Новгород" -> return "https://icdn.lenta.ru/images/2021/03/11/" +
                "16/20210311165110583/pic_3ae518db44df555cca5fb508ee2e04b2.jpg"
        "Казань" -> return "https://flysmartavia.com/media/images/city/20200707_kaz.jpg"
        "Челябинск" -> return "https://im.kommersant.ru/Issues.photo/REGIONS/CHELYABINSK_News/2017/11/" +
                    "28/KCB_000113_00003_1_t218_125953.jpg"
        "Омск" -> return "https://omskzdes.ru/storage/c/2019/03/12/1552379165_162689_04.jpg"
        "Ростов-на-Дону" -> return "https://34travel.me/media/posts/5e1ae4e67342b-rostov-don-pan.jpg"
        "Хабаровск" -> return "https://www.hotels.ru/content/images/essence/about_city/-2924116/poster.jpg"
        "Лондон" -> return "https://www.flytap.com/-/media/Flytap/new-tap-pages/destinations/europe/uk/london/destinations-london-banner-mobile-1024x553.jpg"
        "Токио" -> return "https://masterlang.ru/wp-content/uploads/2020/04/tokyo.jpg"
        "Париж" -> return "https://topgid.net/uploads/posts/2019-09/1568213750_parizh-francija.jpg"
        "Берлин" -> return "https://cdn.flixbus.de/city_description_images/berlin-istorija-kultura.jpg"
        "Рим" -> return "https://planetofhotels.com/guide/sites/default/files/styles/paragraph__hero_banner__hb_" +
                    "image__1880bp/public/hero_banner/Colosseum-Rome.jpg"
        "Минск" -> return "https://s0.rbk.ru/v6_top_pics/media/img/6/38/755992203559386.jpg"
        "Стамбул" -> return "https://www.sibdom.ru/images/photo_crop_1050_700/gallery/" +
                    "2a/2a70/2a705fe85d926fbabbde94382987d11b.jpg"
        "Вашингтон" -> return "https://www.pnp.ru/upload/entities/2019/12/02/article/detailPicture/c1/49/d2/4b/09de7dd9d77961cc6cdfe8c946c5aad7.jpg"
        "Киев" -> return "https://digital.ihg.com/is/image/ihg/intercontinental-kiev-59" +
                    "27192439-2x1?fit=fit,1&wid=2400&hei=1200&qlt=85,0&resMode=sharp2&op_usm=1.75,0.9,2,0"
        "Пекин" -> return "https://anashina.com/wp-content/uploads/2014/07/Qianmen-dajie-1400x600.jpg"
        else -> return "https://autogear.ru/misc/i/thumb/n/9/5/8/8/3/1/i/958831.jpg"
    }
}