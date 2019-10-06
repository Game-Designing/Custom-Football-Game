package com.mopub.common.util;

public enum JavaScriptWebViewCallbacks {
    WEB_VIEW_DID_APPEAR("webviewDidAppear();"),
    WEB_VIEW_DID_CLOSE("webviewDidClose();");
    

    /* renamed from: b */
    private String f34592b;

    private JavaScriptWebViewCallbacks(String javascript) {
        this.f34592b = javascript;
    }

    public String getJavascript() {
        return this.f34592b;
    }

    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append(this.f34592b);
        return sb.toString();
    }
}
