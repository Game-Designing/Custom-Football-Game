package com.integralads.avid.library.mopub.utils;

import org.json.JSONObject;

public class AvidCommand {
    public static String setNativeViewState(String viewState) {
        StringBuilder sb = new StringBuilder();
        sb.append("setNativeViewState(");
        sb.append(viewState);
        sb.append(")");
        return callAvidbridge(sb.toString());
    }

    public static String setAppState(String appState) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAppState(");
        sb.append(JSONObject.quote(appState));
        sb.append(")");
        return callAvidbridge(sb.toString());
    }

    public static String publishReadyEventForDeferredAdSession() {
        return callAvidbridge("publishReadyEventForDeferredAdSession()");
    }

    public static String publishVideoEvent(String event) {
        StringBuilder sb = new StringBuilder();
        sb.append("publishVideoEvent(");
        sb.append(JSONObject.quote(event));
        sb.append(")");
        return callAvidbridge(sb.toString());
    }

    public static String publishVideoEvent(String event, String data) {
        StringBuilder sb = new StringBuilder();
        sb.append("publishVideoEvent(");
        sb.append(JSONObject.quote(event));
        sb.append(",");
        sb.append(data);
        sb.append(")");
        return callAvidbridge(sb.toString());
    }

    public static String setAvidAdSessionContext(String avidAdSessionContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAvidAdSessionContext(");
        sb.append(avidAdSessionContext);
        sb.append(")");
        return callAvidbridge(sb.toString());
    }

    public static String callAvidbridge(String command) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript: if(window.avidbridge!==undefined){avidbridge.");
        sb.append(command);
        sb.append("}");
        return sb.toString();
    }

    public static String formatJavaScript(String javaScript) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript: ");
        sb.append(javaScript);
        return sb.toString();
    }
}
