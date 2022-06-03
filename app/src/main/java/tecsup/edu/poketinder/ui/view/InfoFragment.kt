package tecsup.edu.poketinder.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import tecsup.edu.poketinder.R
import tecsup.edu.poketinder.databinding.FragmentInfoBinding
import tecsup.edu.poketinder.ui.viewmodel.InfoViewModel

class InfoFragment:BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private lateinit var viewModel: InfoViewModel
    private lateinit var webview: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = "https://pokemongolive.com/es/"
        webview =binding.wvMain
        webview!!.settings.javaScriptEnabled=true
        webview!!.webViewClient = PokemonWebClient()
        webview!!.loadUrl(url)

    }

    inner class PokemonWebClient: WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            webview!!.loadUrl("javascript:(function(){"+
                    "document.getElementsByClassName('navbar top')[0].style.display='none';})()");
        }
    }

}