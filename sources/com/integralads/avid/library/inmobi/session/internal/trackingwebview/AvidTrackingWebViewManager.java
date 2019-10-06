package com.integralads.avid.library.inmobi.session.internal.trackingwebview;

import android.webkit.WebView;
import com.integralads.avid.library.inmobi.session.internal.trackingwebview.AvidWebViewClient.AvidWebViewClientListener;
import com.integralads.avid.library.inmobi.weakreference.AvidWebView;
import java.util.ArrayList;
import java.util.Iterator;

public class AvidTrackingWebViewManager implements AvidJavaScriptResourceInjector, AvidWebViewClientListener {
    private static final String HTML_DATA = "<html><body></body></html>";
    private static final String HTML_ENCODING = "text/html";
    private static final String JAVASCRIPT_RESOURCE = "(function () {\nvar script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);\n})();";
    private static final String SCRIPT_SRC_PLACEHOLDER = "%SCRIPT_SRC%";
    static final int STATE_IDLE = 0;
    static final int STATE_LOADING = 1;
    static final int STATE_READY = 2;
    private final AvidWebView avidWebView;
    private final ArrayList<String> pendingJavaScriptResources = new ArrayList<>();
    private int state = 0;
    private final AvidWebViewClient webViewClient;

    public AvidTrackingWebViewManager(WebView webView) {
        this.avidWebView = new AvidWebView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        this.webViewClient = new AvidWebViewClient();
        this.webViewClient.setListener(this);
        webView.setWebViewClient(this.webViewClient);
    }

    public void loadHTML() {
        WebView webView = (WebView) this.avidWebView.get();
        if (webView != null && this.state == 0) {
            this.state = 1;
            webView.loadData(HTML_DATA, HTML_ENCODING, null);
        }
    }

    public void injectJavaScriptResource(String str) {
        if (this.state == 2) {
            doInjectJavaScriptResource(str);
        } else {
            this.pendingJavaScriptResources.add(str);
        }
    }

    public void webViewDidLoadData() {
        this.state = 2;
        Iterator it = this.pendingJavaScriptResources.iterator();
        while (it.hasNext()) {
            doInjectJavaScriptResource((String) it.next());
        }
        this.pendingJavaScriptResources.clear();
    }

    private void doInjectJavaScriptResource(String str) {
        this.avidWebView.injectJavaScript(JAVASCRIPT_RESOURCE.replace(SCRIPT_SRC_PLACEHOLDER, str));
    }
}
