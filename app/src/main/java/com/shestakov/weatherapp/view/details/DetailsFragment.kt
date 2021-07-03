package com.shestakov.weatherapp.view.details

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shestakov.weatherapp.R
import com.shestakov.weatherapp.databinding.FragmentDetailsBinding
import com.shestakov.weatherapp.model.Weather
import com.shestakov.weatherapp.utils.showSnackBar
import com.shestakov.weatherapp.viewmodel.AppState
import com.shestakov.weatherapp.viewmodel.DetailsViewModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var weatherBundle: Weather
    private val viewModel: DetailsViewModel by lazy {
        ViewModelProvider(this).get(DetailsViewModel::class.java)
    }
    private lateinit var chosenHeaderPicture: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: Weather()
        viewModel.detailsLiveData.observe(viewLifecycleOwner, Observer {
            renderData(it)
        })
        viewModel.getWeatherFromRemoteSource(weatherBundle.city.lat, weatherBundle.city.lon)
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                binding.mainView.visibility = View.VISIBLE
                binding.loadingLayout.visibility = View.GONE
                setWeather(appState.weatherData[0])
            }
            is AppState.Loading -> {
                binding.mainView.visibility = View.GONE
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                binding.mainView.visibility = View.VISIBLE
                binding.loadingLayout.visibility = View.GONE
                binding.mainView.showSnackBar(
                    getString(R.string.error),
                    getString(R.string.reload),
                    {
                        viewModel.getWeatherFromRemoteSource(
                            weatherBundle.city.lat,
                            weatherBundle.city.lon
                        )
                    })
            }
        }
    }

    private fun setWeather(weather: Weather) {
        with(binding) {
            val city = weatherBundle.city
            cityName.text = city.cityName
            cityCoordinates.text = String.format(
                getString(R.string.city_coordinates),
                city.lat.toString(),
                city.lon.toString()
            )
            temperatureValue.text = weather.temperature.toString()
            feelsLikeValue.text = weather.feelsLike.toString()
            weatherCondition.text = weather.condition

            weather.icon?.let {
                GlideToVectorYou.justLoadImage(
                    activity,
                    Uri.parse("https://yastatic.net/weather/i/icons/blueye/color/svg/${it}.svg"),
                    weatherIcon
                )
            }

            getHeaderPicture(city.cityName)
            Picasso
                .get()
                .load(chosenHeaderPicture)
                .into(headerIcon)
        }
    }

    private fun getHeaderPicture(cityName: String) {
        when (cityName) {
//
            "Москва" -> chosenHeaderPicture =
                "https://www.m24.ru/b/d/nBkSUhL2hFEnmsqyIr6BosSyyJ2gp8T" +
                        "rlnTclb7P73OHezeOWXiSxTZt4slI-BHBsdWR_G-JLsV0=zc8_-mxcKqLEk-c_ELPdrQ.jpg"
            "Санкт-Петербург" -> chosenHeaderPicture =
                "https://etu.ru/assets/cache/images/en/why-us/cultural-capital/1280x854-03.74d.jpg"
            "Новосибирск" -> chosenHeaderPicture =
                "https://www.alrosa.aero/wp-content/uploads/2018/12" +
                        "/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D0%B8%D0%B8%D1%80%D1%81%D0%BA.jpg"
            "Екатеринбург" -> chosenHeaderPicture =
                "https://s0.rbk.ru/v6_top_pics/media/img/5/68/756141566421685.jpg"
            "Нижний Новгород" -> chosenHeaderPicture = "https://icdn.lenta.ru/images/2021/03/11/" +
                    "16/20210311165110583/pic_3ae518db44df555cca5fb508ee2e04b2.jpg"
            "Казань" -> chosenHeaderPicture =
                "https://flysmartavia.com/media/images/city/20200707_kaz.jpg"
            "Челябинск" -> chosenHeaderPicture =
                "https://im.kommersant.ru/Issues.photo/REGIONS/CHELYABINSK_News/2017/11/" +
                        "28/KCB_000113_00003_1_t218_125953.jpg"
            "Омск" -> chosenHeaderPicture =
                "https://omskzdes.ru/storage/c/2019/03/12/1552379165_162689_04.jpg"
            "Ростов-на-Дону" -> chosenHeaderPicture =
                "https://34travel.me/media/posts/5e1ae4e67342b-rostov-don-pan.jpg"
            "Хабаровск" -> chosenHeaderPicture =
                "https://www.hotels.ru/content/images/essence/about_city/-2924116/poster.jpg"
            "Лондон" -> chosenHeaderPicture =
                "https://www.flytap.com/-/media/Flytap/new-tap-pages/destinations/europe/uk/london/destinations-london-banner-mobile-1024x553.jpg"
            "Токио" -> chosenHeaderPicture =
                "https://masterlang.ru/wp-content/uploads/2020/04/tokyo.jpg"
            "Париж" -> chosenHeaderPicture =
                "https://topgid.net/uploads/posts/2019-09/1568213750_parizh-francija.jpg"
            "Берлин" -> chosenHeaderPicture =
                "https://cdn.flixbus.de/city_description_images/berlin-istorija-kultura.jpg"
            "Рим" -> chosenHeaderPicture =
                "https://planetofhotels.com/guide/sites/default/files/styles/paragraph__hero_banner__hb_" +
                        "image__1880bp/public/hero_banner/Colosseum-Rome.jpg"
            "Минск" -> chosenHeaderPicture =
                "https://s0.rbk.ru/v6_top_pics/media/img/6/38/755992203559386.jpg"
            "Стамбул" -> chosenHeaderPicture =
                "https://www.sibdom.ru/images/photo_crop_1050_700/gallery/" +
                        "2a/2a70/2a705fe85d926fbabbde94382987d11b.jpg"
            "Вашингтон" -> chosenHeaderPicture =
                "https://www.pnp.ru/upload/entities/2019/12/02/article/detailPicture/c1/49/d2/4b/09de7dd9d77961cc6cdfe8c946c5aad7.jpg"
            "Киев" -> chosenHeaderPicture =
                "https://digital.ihg.com/is/image/ihg/intercontinental-kiev-59" +
                        "27192439-2x1?fit=fit,1&wid=2400&hei=1200&qlt=85,0&resMode=sharp2&op_usm=1.75,0.9,2,0"
            "Пекин" -> chosenHeaderPicture =
                "https://anashina.com/wp-content/uploads/2014/07/Qianmen-dajie-1400x600.jpg"
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
