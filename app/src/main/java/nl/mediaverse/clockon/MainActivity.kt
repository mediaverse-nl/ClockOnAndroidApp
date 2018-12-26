package nl.mediaverse.clockon

import android.support.v7.app.AppCompatActivity
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View
import android.webkit.WebSettings;
import android.webkit.WebView;

class MainActivity : AppCompatActivity() {

    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.webView = findViewById(R.id.webview)

        val webSettings = webView!!.settings
        webSettings.javaScriptEnabled = true

        val webViewClient = WebViewClientImpl(this)
        webView!!.webViewClient = webViewClient

        webView!!.loadUrl("https://app.clock-on.nl/dashboard")
    }

    override fun onBackPressed() {
        if (this.webView!!.canGoBack()) {
            this.webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
