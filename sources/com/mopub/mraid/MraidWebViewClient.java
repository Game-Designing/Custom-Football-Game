package com.mopub.mraid;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.resource.MraidJavascript;
import java.io.ByteArrayInputStream;
import java.util.Locale;

public class MraidWebViewClient extends WebViewClient {

    /* renamed from: a */
    private static final String f35543a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append(MraidJavascript.JAVASCRIPT_SOURCE);
        f35543a = sb.toString();
    }

    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        if (mo37693a(url)) {
            return m38072a();
        }
        return super.shouldInterceptRequest(view, url);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo37693a(String url) {
        return "mraid.js".equals(Uri.parse(url.toLowerCase(Locale.US)).getLastPathSegment());
    }

    /* renamed from: a */
    private WebResourceResponse m38072a() {
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(f35543a.getBytes()));
    }
}
