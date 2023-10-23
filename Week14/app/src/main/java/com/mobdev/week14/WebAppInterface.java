package com.mobdev.week14;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context context;

    public WebAppInterface(Context c) {
        this.context = c;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
