package com.unity3d.services.core.webview.bridge;

import android.webkit.JavascriptInterface;
import com.unity3d.services.core.log.DeviceLog;
import org.json.JSONArray;
import org.json.JSONException;

public class WebViewBridgeInterface {
    @JavascriptInterface
    public void handleInvocation(String data) throws JSONException {
        StringBuilder sb = new StringBuilder();
        sb.append("handleInvocation ");
        sb.append(data);
        DeviceLog.debug(sb.toString());
        JSONArray invocationArray = new JSONArray(data);
        Invocation batch = new Invocation();
        for (int idx = 0; idx < invocationArray.length(); idx++) {
            JSONArray currentInvocation = (JSONArray) invocationArray.get(idx);
            batch.addInvocation((String) currentInvocation.get(0), (String) currentInvocation.get(1), getParameters((JSONArray) currentInvocation.get(2)), new WebViewCallback((String) currentInvocation.get(3), batch.getId()));
        }
        for (int idx2 = 0; idx2 < invocationArray.length(); idx2++) {
            batch.nextInvocation();
        }
        batch.sendInvocationCallback();
    }

    @JavascriptInterface
    public void handleCallback(String callbackId, String callbackStatus, String rawParameters) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("handleCallback ");
        sb.append(callbackId);
        String str = " ";
        sb.append(str);
        sb.append(callbackStatus);
        sb.append(str);
        sb.append(rawParameters);
        DeviceLog.debug(sb.toString());
        JSONArray parametersJsonArray = new JSONArray(rawParameters);
        Object[] parameters = null;
        if (parametersJsonArray.length() > 0) {
            parameters = new Object[parametersJsonArray.length()];
            for (int i = 0; i < parametersJsonArray.length(); i++) {
                parameters[i] = parametersJsonArray.get(i);
            }
        }
        WebViewBridge.handleCallback(callbackId, callbackStatus, parameters);
    }

    private Object[] getParameters(JSONArray parametersJson) throws JSONException {
        Object[] parameters = new Object[parametersJson.length()];
        for (int i = 0; i < parametersJson.length(); i++) {
            parameters[i] = parametersJson.get(i);
        }
        return parameters;
    }
}
