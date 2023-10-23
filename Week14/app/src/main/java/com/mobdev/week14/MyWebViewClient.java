package com.mobdev.week14;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    @Override
   public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (Uri.parse(url).getHost().equals("www.google.com")) {

        return false;
    }
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        startActivity(intent);
        return true;
        }
}

