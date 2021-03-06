package com.unity3d.services.core.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import org.json.JSONException;
import org.json.JSONObject;

public class BroadcastEventReceiver extends BroadcastReceiver {
    private String _name;

    public BroadcastEventReceiver(String name) {
        this._name = name;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            String data = "";
            if (intent.getDataString() != null) {
                data = intent.getDataString();
            }
            JSONObject extras = new JSONObject();
            try {
                if (intent.getExtras() != null) {
                    Bundle bundle = intent.getExtras();
                    for (String key : bundle.keySet()) {
                        extras.put(key, bundle.get(key));
                    }
                }
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSONException when composing extras for broadcast action ");
                sb.append(action);
                sb.append(": ");
                sb.append(e.getMessage());
                DeviceLog.debug(sb.toString());
            }
            WebViewApp webViewApp = WebViewApp.getCurrentApp();
            if (webViewApp != null && webViewApp.isWebAppLoaded()) {
                webViewApp.sendEvent(WebViewEventCategory.BROADCAST, BroadcastEvent.ACTION, this._name, action, data, extras);
            }
        }
    }
}
