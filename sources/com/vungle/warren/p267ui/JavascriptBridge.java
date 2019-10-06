package com.vungle.warren.p267ui;

import android.util.Log;
import android.webkit.JavascriptInterface;

/* renamed from: com.vungle.warren.ui.JavascriptBridge */
public class JavascriptBridge {
    private ActionHandler handler;

    /* renamed from: com.vungle.warren.ui.JavascriptBridge$ActionHandler */
    public interface ActionHandler {
        void handleAction(String str);
    }

    public JavascriptBridge(ActionHandler actionHandler) {
        this.handler = actionHandler;
    }

    @JavascriptInterface
    public void performAction(String action) {
        StringBuilder sb = new StringBuilder();
        sb.append("actionClicked(");
        sb.append(action);
        sb.append(")");
        Log.d("JavascriptBridge", sb.toString());
        this.handler.handleAction(action);
    }
}
