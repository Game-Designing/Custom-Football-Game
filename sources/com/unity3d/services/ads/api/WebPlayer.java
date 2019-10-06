package com.unity3d.services.ads.api;

import android.view.View;
import com.unity3d.services.ads.adunit.IAdUnitViewHandler;
import com.unity3d.services.ads.webplayer.WebPlayerError;
import com.unity3d.services.banners.view.BannerView;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebPlayer {
    private static JSONObject _webPlayerEventSettings = null;
    private static JSONObject _webPlayerSettings = null;
    private static JSONObject _webSettings = null;

    public static JSONObject getWebPlayerSettings() {
        return _webPlayerSettings;
    }

    public static JSONObject getWebSettings() {
        return _webSettings;
    }

    public static JSONObject getWebPlayerEventSettings() {
        return _webPlayerEventSettings;
    }

    @WebViewExposed
    public static void setUrl(final String url, String viewId, WebViewCallback callback) {
        final com.unity3d.services.ads.webplayer.WebPlayer webPlayer = getWebPlayer(viewId);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    webPlayer.loadUrl(url);
                }
            });
            callback.invoke(new Object[0]);
            return;
        }
        callback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setData(final String data, final String mimeType, final String encoding, String viewId, WebViewCallback callback) {
        final com.unity3d.services.ads.webplayer.WebPlayer webPlayer = getWebPlayer(viewId);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    webPlayer.loadData(data, mimeType, encoding);
                }
            });
            callback.invoke(new Object[0]);
            return;
        }
        callback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setDataWithUrl(String baseUrl, String data, String mimeType, String encoding, String viewId, WebViewCallback callback) {
        com.unity3d.services.ads.webplayer.WebPlayer webPlayer = getWebPlayer(viewId);
        if (webPlayer != null) {
            final com.unity3d.services.ads.webplayer.WebPlayer webPlayer2 = webPlayer;
            final String str = baseUrl;
            final String str2 = data;
            final String str3 = mimeType;
            final String str4 = encoding;
            C125863 r0 = new Runnable() {
                public void run() {
                    webPlayer2.loadDataWithBaseURL(str, str2, str3, str4, null);
                }
            };
            Utilities.runOnUiThread(r0);
            callback.invoke(new Object[0]);
            return;
        }
        callback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    @com.unity3d.services.core.webview.bridge.WebViewExposed
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setSettings(final org.json.JSONObject r4, final org.json.JSONObject r5, java.lang.String r6, com.unity3d.services.core.webview.bridge.WebViewCallback r7) {
        /*
            int r0 = r6.hashCode()
            r1 = -318269643(0xffffffffed079735, float:-2.6227047E27)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 1497041165(0x593b090d, float:3.29036076E15)
            if (r0 == r1) goto L_0x0011
        L_0x0010:
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "bannerplayer"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 0
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "webplayer"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = -1
        L_0x0026:
            if (r0 == 0) goto L_0x0030
            if (r0 == r3) goto L_0x002b
            goto L_0x0039
        L_0x002b:
            _webSettings = r4
            _webPlayerSettings = r5
            goto L_0x0039
        L_0x0030:
            com.unity3d.services.ads.api.WebPlayer$4 r0 = new com.unity3d.services.ads.api.WebPlayer$4
            r0.<init>(r4, r5)
            com.unity3d.services.core.misc.Utilities.runOnUiThread(r0)
        L_0x0039:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r7.invoke(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.api.WebPlayer.setSettings(org.json.JSONObject, org.json.JSONObject, java.lang.String, com.unity3d.services.core.webview.bridge.WebViewCallback):void");
    }

    @WebViewExposed
    public static void setEventSettings(final JSONObject settings, String viewId, WebViewCallback callback) {
        if (viewId.equals("webplayer")) {
            _webPlayerEventSettings = settings;
        } else {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    com.unity3d.services.ads.webplayer.WebPlayer webPlayer = WebPlayer.getBannerWebPlayer();
                    if (webPlayer != null) {
                        webPlayer.setEventSettings(settings);
                    } else {
                        BannerView.setWebPlayerEventSettings(settings);
                    }
                }
            });
        }
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void clearSettings(WebViewCallback callback) {
        _webSettings = null;
        _webPlayerSettings = null;
        _webPlayerEventSettings = null;
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getErroredSettings(String viewId, WebViewCallback callback) {
        com.unity3d.services.ads.webplayer.WebPlayer webPlayer = getWebPlayer(viewId);
        if (webPlayer != null) {
            Map<String, String> errors = webPlayer.getErroredSettings();
            JSONObject retObj = new JSONObject();
            try {
                for (Entry pair : errors.entrySet()) {
                    retObj.put((String) pair.getKey(), pair.getValue());
                }
            } catch (Exception e) {
                DeviceLog.exception("Error forming JSON object", e);
            }
            callback.invoke(retObj);
            callback.invoke(new Object[0]);
            return;
        }
        callback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void sendEvent(JSONArray parameters, String viewId, WebViewCallback callback) {
        com.unity3d.services.ads.webplayer.WebPlayer webPlayer = getWebPlayer(viewId);
        if (webPlayer != null) {
            webPlayer.sendEvent(parameters);
            callback.invoke(new Object[0]);
            return;
        }
        callback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.unity3d.services.ads.webplayer.WebPlayer getWebPlayer(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = -318269643(0xffffffffed079735, float:-2.6227047E27)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 1497041165(0x593b090d, float:3.29036076E15)
            if (r0 == r1) goto L_0x0010
        L_0x000f:
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "bannerplayer"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "webplayer"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x000f
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = -1
        L_0x0025:
            if (r0 == 0) goto L_0x0030
            if (r0 == r2) goto L_0x002b
            r0 = 0
            return r0
        L_0x002b:
            com.unity3d.services.ads.webplayer.WebPlayer r0 = getBannerWebPlayer()
            return r0
        L_0x0030:
            com.unity3d.services.ads.webplayer.WebPlayer r0 = getAdUnitWebPlayer()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.api.WebPlayer.getWebPlayer(java.lang.String):com.unity3d.services.ads.webplayer.WebPlayer");
    }

    private static com.unity3d.services.ads.webplayer.WebPlayer getAdUnitWebPlayer() {
        if (AdUnit.getAdUnitActivity() != null) {
            IAdUnitViewHandler viewHandler = AdUnit.getAdUnitActivity().getViewHandler("webplayer");
            if (viewHandler != null) {
                View view = viewHandler.getView();
                if (view != null) {
                    return (com.unity3d.services.ads.webplayer.WebPlayer) view;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static com.unity3d.services.ads.webplayer.WebPlayer getBannerWebPlayer() {
        if (BannerView.getInstance() == null) {
            return null;
        }
        return BannerView.getInstance().getWebPlayer();
    }
}
