package com.unity3d.services.core.webview;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.NativeCallback;
import com.unity3d.services.core.webview.bridge.WebViewBridge;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class WebViewApp extends WebViewClient {
    private static final int INVOKE_JS_CHARS_LENGTH = 22;
    /* access modifiers changed from: private */
    public static ConditionVariable _conditionVariable;
    private static WebViewApp _currentApp;
    private Configuration _configuration;
    private boolean _initialized;
    private HashMap<String, NativeCallback> _nativeCallbacks;
    private boolean _webAppLoaded;
    private WebView _webView;

    private class WebAppChromeClient extends WebChromeClient {
        private WebAppChromeClient() {
        }

        public void onConsoleMessage(String message, int lineNumber, String sourceID) {
            String sourceFile = sourceID;
            File tmp = null;
            try {
                tmp = new File(sourceID);
            } catch (Exception e) {
                DeviceLog.exception("Could not handle sourceId", e);
            }
            if (tmp != null) {
                sourceFile = tmp.getName();
            }
            if (VERSION.SDK_INT < 19) {
                StringBuilder sb = new StringBuilder();
                sb.append("JavaScript (sourceId=");
                sb.append(sourceFile);
                sb.append(", line=");
                sb.append(lineNumber);
                sb.append("): ");
                sb.append(message);
                DeviceLog.debug(sb.toString());
            }
        }
    }

    private class WebAppClient extends WebViewClient {
        private WebAppClient() {
        }

        public void onPageFinished(WebView webview, String url) {
            super.onPageFinished(webview, url);
            StringBuilder sb = new StringBuilder();
            sb.append("onPageFinished url: ");
            sb.append(url);
            DeviceLog.debug(sb.toString());
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to load url: ");
            sb.append(url);
            DeviceLog.debug(sb.toString());
            return false;
        }

        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            String str = "WEBVIEW_ERROR: ";
            if (view != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(view.toString());
                DeviceLog.error(sb.toString());
            }
            if (request != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(request.toString());
                DeviceLog.error(sb2.toString());
            }
            if (error != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(error.toString());
                DeviceLog.error(sb3.toString());
            }
        }
    }

    private WebViewApp(Configuration configuration) {
        this._webAppLoaded = false;
        this._initialized = false;
        setConfiguration(configuration);
        WebViewBridge.setClassTable(getConfiguration().getWebAppApiClassList());
        this._webView = new WebView(ClientProperties.getApplicationContext());
        this._webView.setWebViewClient(new WebAppClient());
        this._webView.setWebChromeClient(new WebAppChromeClient());
    }

    public WebViewApp() {
        this._webAppLoaded = false;
        this._initialized = false;
    }

    public void setWebAppLoaded(boolean loaded) {
        this._webAppLoaded = loaded;
    }

    public boolean isWebAppLoaded() {
        return this._webAppLoaded;
    }

    public void setWebAppInitialized(boolean initialized) {
        this._initialized = initialized;
        _conditionVariable.open();
    }

    public boolean isWebAppInitialized() {
        return this._initialized;
    }

    public WebView getWebView() {
        return this._webView;
    }

    public void setWebView(WebView webView) {
        this._webView = webView;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this._configuration = configuration;
    }

    private void invokeJavascriptMethod(String className, String methodName, JSONArray params) throws JSONException {
        String paramsString = params.toString();
        StringBuilder sb = new StringBuilder(className.length() + 22 + methodName.length() + paramsString.length());
        sb.append("javascript:window.");
        sb.append(className);
        sb.append(".");
        sb.append(methodName);
        sb.append("(");
        sb.append(paramsString);
        sb.append(");");
        String javaScriptString = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Invoking javascript: ");
        sb2.append(javaScriptString);
        DeviceLog.debug(sb2.toString());
        getWebView().invokeJavascript(javaScriptString);
    }

    public boolean sendEvent(Enum eventCategory, Enum eventId, Object... params) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("sendEvent ignored because web app is not loaded");
            return false;
        }
        JSONArray paramList = new JSONArray();
        paramList.put(eventCategory.name());
        paramList.put(eventId.name());
        for (Object o : params) {
            paramList.put(o);
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleEvent", paramList);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error while sending event to WebView", e);
            return false;
        }
    }

    public boolean invokeMethod(String className, String methodName, Method callback, Object... params) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeMethod ignored because web app is not loaded");
            return false;
        }
        JSONArray paramList = new JSONArray();
        paramList.put(className);
        paramList.put(methodName);
        if (callback != null) {
            NativeCallback nativeCallback = new NativeCallback(callback);
            addCallback(nativeCallback);
            paramList.put(nativeCallback.getId());
        } else {
            paramList.put(null);
        }
        if (params != null) {
            for (Object o : params) {
                paramList.put(o);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleInvocation", paramList);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error invoking javascript method", e);
            return false;
        }
    }

    public boolean invokeCallback(Invocation invocation) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeBatchCallback ignored because web app is not loaded");
            return false;
        }
        JSONArray responseList = new JSONArray();
        ArrayList<ArrayList<Object>> responses = invocation.getResponses();
        if (responses != null && !responses.isEmpty()) {
            Iterator it = responses.iterator();
            while (it.hasNext()) {
                ArrayList<Object> response = (ArrayList) it.next();
                CallbackStatus status = (CallbackStatus) response.get(0);
                Enum error = (Enum) response.get(1);
                Object[] params = (Object[]) response.get(2);
                String callbackId = (String) params[0];
                Object[] params2 = Arrays.copyOfRange(params, 1, params.length);
                ArrayList<Object> tmp = new ArrayList<>();
                tmp.add(callbackId);
                tmp.add(status.toString());
                JSONArray paramArray = new JSONArray();
                if (error != null) {
                    paramArray.put(error.name());
                }
                for (Object o : params2) {
                    paramArray.put(o);
                }
                tmp.add(paramArray);
                JSONArray paramList = new JSONArray();
                Iterator it2 = tmp.iterator();
                while (it2.hasNext()) {
                    paramList.put(it2.next());
                }
                responseList.put(paramList);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleCallback", responseList);
        } catch (Exception e) {
            DeviceLog.exception("Error while invoking batch response for WebView", e);
        }
        return true;
    }

    public void addCallback(NativeCallback callback) {
        if (this._nativeCallbacks == null) {
            this._nativeCallbacks = new HashMap<>();
        }
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.put(callback.getId(), callback);
        }
    }

    public void removeCallback(NativeCallback callback) {
        HashMap<String, NativeCallback> hashMap = this._nativeCallbacks;
        if (hashMap != null) {
            synchronized (hashMap) {
                this._nativeCallbacks.remove(callback.getId());
            }
        }
    }

    public NativeCallback getCallback(String callbackId) {
        NativeCallback nativeCallback;
        synchronized (this._nativeCallbacks) {
            nativeCallback = (NativeCallback) this._nativeCallbacks.get(callbackId);
        }
        return nativeCallback;
    }

    public static WebViewApp getCurrentApp() {
        return _currentApp;
    }

    public static void setCurrentApp(WebViewApp app) {
        _currentApp = app;
    }

    public static boolean create(final Configuration configuration) throws IllegalThreadStateException {
        DeviceLog.entered();
        if (!Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    String str = "UTF-8";
                    try {
                        WebViewApp webViewApp = new WebViewApp(configuration);
                        String queryString = "?platform=android";
                        try {
                            if (configuration.getWebViewUrl() != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(queryString);
                                sb.append("&origin=");
                                sb.append(URLEncoder.encode(configuration.getWebViewUrl(), str));
                                queryString = sb.toString();
                            }
                        } catch (UnsupportedEncodingException e) {
                            DeviceLog.exception("Unsupported charset when encoding origin url", e);
                        }
                        try {
                            if (configuration.getWebViewVersion() != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(queryString);
                                sb2.append("&version=");
                                sb2.append(URLEncoder.encode(configuration.getWebViewVersion(), str));
                                queryString = sb2.toString();
                            }
                        } catch (UnsupportedEncodingException e2) {
                            DeviceLog.exception("Unsupported charset when encoding webview version", e2);
                        }
                        WebView webView = webViewApp.getWebView();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("file://");
                        sb3.append(SdkProperties.getLocalWebViewFile());
                        sb3.append(queryString);
                        webView.loadDataWithBaseURL(sb3.toString(), configuration.getWebViewData(), "text/html", "UTF-8", null);
                        WebViewApp.setCurrentApp(webViewApp);
                    } catch (Exception e3) {
                        DeviceLog.error("Couldn't construct WebViewApp");
                        WebViewApp._conditionVariable.open();
                    }
                }
            });
            _conditionVariable = new ConditionVariable();
            return _conditionVariable.block(60000) && getCurrentApp() != null;
        }
        throw new IllegalThreadStateException("Cannot call create() from main thread!");
    }
}
