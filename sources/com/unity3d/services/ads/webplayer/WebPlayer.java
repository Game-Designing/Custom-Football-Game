package com.unity3d.services.ads.webplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

public class WebPlayer extends WebView {
    private Map<String, String> _erroredSettings;
    /* access modifiers changed from: private */
    public Method _evaluateJavascript = null;
    private JSONObject _eventSettings;
    /* access modifiers changed from: private */
    public String viewId;

    private class JavaScriptInvocation implements Runnable {
        private String _jsString = null;
        private WebView _webView = null;

        public JavaScriptInvocation(String jsString, WebView webView) {
            this._jsString = jsString;
            this._webView = webView;
        }

        public void run() {
            String str = this._jsString;
            if (str != null) {
                try {
                    if (VERSION.SDK_INT >= 19) {
                        WebPlayer.this._evaluateJavascript.invoke(this._webView, new Object[]{this._jsString, null});
                        return;
                    }
                    WebPlayer.this.loadUrl(str);
                } catch (Exception e) {
                    DeviceLog.exception("Error while processing JavaScriptString", e);
                }
            } else {
                DeviceLog.error("Could not process JavaScript, the string is NULL");
            }
        }
    }

    @TargetApi(21)
    private class WebPlayerChromeClient extends WebChromeClient {
        private WebPlayerChromeClient() {
        }

        public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
            String str = "onGeolocationPermissionsShowPrompt";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GEOLOCATION_PERMISSIONS_SHOW, origin, WebPlayer.this.viewId);
            }
        }

        public void onPermissionRequest(PermissionRequest request) {
            String str = "onPermissionRequest";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onPermissionRequest(request);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                String url = "";
                if (!(request == null || request.getOrigin() == null)) {
                    url = request.getOrigin().toString();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PERMISSION_REQUEST, url, WebPlayer.this.viewId);
            }
        }

        public void onProgressChanged(WebView view, int newProgress) {
            String str = "onProgressChanged";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onProgressChanged(view, newProgress);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PROGRESS_CHANGED, Integer.valueOf(newProgress), WebPlayer.this.viewId);
            }
        }

        public void onReceivedTitle(WebView view, String title) {
            String str = "onReceivedTitle";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedTitle(view, title);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TITLE, title, WebPlayer.this.viewId);
            }
        }

        public void onReceivedIcon(WebView view, Bitmap icon) {
            String str = "onReceivedIcon";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedIcon(view, icon);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_ICON, WebPlayer.this.viewId);
            }
        }

        public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
            String str = "onReceivedTouchIconUrl";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedTouchIconUrl(view, url, precomposed);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TOUCH_ICON_URL, url, Boolean.valueOf(precomposed), WebPlayer.this.viewId);
            }
        }

        public void onShowCustomView(View view, CustomViewCallback callback) {
            String str = "onShowCustomView";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onShowCustomView(view, callback);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_CUSTOM_VIEW, WebPlayer.this.viewId);
            }
        }

        public void onHideCustomView() {
            String str = "onHideCustomView";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onHideCustomView();
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HIDE_CUSTOM_VIEW, WebPlayer.this.viewId);
            }
        }

        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "onCreateWindow";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.onCreateWindow(view, isDialog, isUserGesture, resultMsg));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CREATE_WINDOW, Boolean.valueOf(isDialog), Boolean.valueOf(isUserGesture), resultMsg, WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(false));
            }
            return returnValue.booleanValue();
        }

        public void onRequestFocus(WebView view) {
            String str = "onRequestFocus";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onRequestFocus(view);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.REQUEST_FOCUS, WebPlayer.this.viewId);
            }
        }

        public void onCloseWindow(WebView window) {
            String str = "onCloseWindow";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onCloseWindow(window);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLOSE_WINDOW, WebPlayer.this.viewId);
            }
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "onJsAlert";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.onJsAlert(view, url, message, result));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_ALERT, url, message, result, WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return returnValue.booleanValue();
        }

        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "onJsConfirm";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.onJsConfirm(view, url, message, result));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_CONFIRM, url, message, WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return returnValue.booleanValue();
        }

        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "onJsPrompt";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.onJsPrompt(view, url, message, defaultValue, result));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_PROMPT, url, message, defaultValue, WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return returnValue.booleanValue();
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "onConsoleMessage";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.onConsoleMessage(consoleMessage));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                String message = "";
                if (consoleMessage != null) {
                    message = consoleMessage.message();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CONSOLE_MESSAGE, message, WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return returnValue.booleanValue();
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "onShowFileChooser";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.onShowFileChooser(webView, filePathCallback, fileChooserParams));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_FILE_CHOOSER, WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
                if (returnValue.booleanValue()) {
                    filePathCallback.onReceiveValue(null);
                }
            }
            return returnValue.booleanValue();
        }
    }

    private class WebPlayerClient extends WebViewClient {
        private WebPlayerClient() {
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            String str = "onPageStarted";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onPageStarted(view, url, favicon);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_STARTED, url, WebPlayer.this.viewId);
            }
        }

        public void onPageFinished(WebView view, String url) {
            String str = "onPageFinished";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onPageFinished(view, url);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_FINISHED, url, WebPlayer.this.viewId);
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            String str = "onReceivedError";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.ERROR, failingUrl, description, WebPlayer.this.viewId);
            }
        }

        @TargetApi(25)
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            String str = "onReceivedError";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedError(view, request, error);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                String description = "";
                if (!(error == null || error.getDescription() == null)) {
                    description = error.getDescription().toString();
                }
                String url = "";
                if (!(request == null || request.getUrl() == null)) {
                    url = request.getUrl().toString();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.ERROR, url, description, WebPlayer.this.viewId);
            }
        }

        public void onLoadResource(WebView view, String url) {
            String str = "onLoadResource";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onLoadResource(view, url);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOAD_RESOUCE, url, WebPlayer.this.viewId);
            }
        }

        @TargetApi(14)
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            String str = "onReceivedSslError";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedSslError(view, handler, error);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                String url = "";
                if (error != null) {
                    url = error.getUrl();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SSL_ERROR, url, WebPlayer.this.viewId);
            }
        }

        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
            String str = "onReceivedClientCertRequest";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedClientCertRequest(view, request);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                String host = "";
                int port = -1;
                if (request != null) {
                    host = request.getHost();
                    port = request.getPort();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLIENT_CERT_REQUEST, host, Integer.valueOf(port), WebPlayer.this.viewId);
            }
        }

        public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
            String str = "onReceivedHttpAuthRequest";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedHttpAuthRequest(view, handler, host, realm);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_AUTH_REQUEST, host, realm, WebPlayer.this.viewId);
            }
        }

        public void onScaleChanged(WebView view, float oldScale, float newScale) {
            String str = "onScaleChanged";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onScaleChanged(view, oldScale, newScale);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SCALE_CHANGED, Float.valueOf(oldScale), Float.valueOf(newScale), WebPlayer.this.viewId);
            }
        }

        public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
            String str = "onReceivedLoginRequest";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedLoginRequest(view, realm, account, args);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOGIN_REQUEST, realm, account, args, WebPlayer.this.viewId);
            }
        }

        @TargetApi(21)
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            String str = "onReceivedHttpError";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onReceivedHttpError(view, request, errorResponse);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                String url = "";
                if (!(request == null || request.getUrl() == null)) {
                    url = request.getUrl().toString();
                }
                int statusCode = -1;
                String reasonPhrase = "";
                if (errorResponse != null) {
                    statusCode = errorResponse.getStatusCode();
                    reasonPhrase = errorResponse.getReasonPhrase();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_ERROR, url, reasonPhrase, Integer.valueOf(statusCode), WebPlayer.this.viewId);
            }
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "shouldOverrideUrlLoading";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.shouldOverrideUrlLoading(view, request));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING, request.getUrl().toString(), request.getMethod(), WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return returnValue.booleanValue();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "shouldOverrideUrlLoading";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.shouldOverrideUrlLoading(view, url));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING, url, WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return returnValue.booleanValue();
        }

        public void onPageCommitVisible(WebView view, String url) {
            String str = "onPageCommitVisible";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onPageCommitVisible(view, url);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_COMMIT_VISIBLE, url, WebPlayer.this.viewId);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            WebResourceResponse returnValue = null;
            String str = "shouldInterceptRequest";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = super.shouldInterceptRequest(view, request);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_INTERCEPT_REQUEST, request.getUrl().toString(), WebPlayer.this.viewId);
            }
            return returnValue;
        }

        public void onFormResubmission(WebView view, Message dontResend, Message resend) {
            String str = "onFormResubmission";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onFormResubmission(view, dontResend, resend);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.FORM_RESUBMISSION, WebPlayer.this.viewId);
            }
        }

        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            Boolean returnValue = Boolean.valueOf(false);
            String str = "shouldOverrideKeyEvent";
            if (WebPlayer.this.shouldCallSuper(str)) {
                returnValue = Boolean.valueOf(super.shouldOverrideKeyEvent(view, event));
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_KEY_EVENT, Integer.valueOf(event.getKeyCode()), Integer.valueOf(event.getAction()), WebPlayer.this.viewId);
            }
            if (WebPlayer.this.hasReturnValue(str)) {
                returnValue = (Boolean) WebPlayer.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return returnValue.booleanValue();
        }

        public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
            String str = "onUnhandledKeyEvent";
            if (WebPlayer.this.shouldCallSuper(str)) {
                super.onUnhandledKeyEvent(view, event);
            }
            if (WebPlayer.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.UNHANDLED_KEY_EVENT, Integer.valueOf(event.getKeyCode()), Integer.valueOf(event.getAction()), WebPlayer.this.viewId);
            }
        }
    }

    private class WebPlayerDownloadListener implements DownloadListener {
        private WebPlayerDownloadListener() {
        }

        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            if (WebPlayer.this.shouldSendEvent("onDownloadStart")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.DOWNLOAD_START, url, userAgent, contentDisposition, mimetype, Long.valueOf(contentLength), WebPlayer.this.viewId);
            }
        }
    }

    public WebPlayer(Context context, String viewId2, JSONObject webSettings, JSONObject webPlayerSettings) {
        super(context);
        this.viewId = viewId2;
        WebSettings settings = getSettings();
        if (VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (VERSION.SDK_INT >= 19) {
            try {
                this._evaluateJavascript = WebView.class.getMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
            } catch (NoSuchMethodException e) {
                DeviceLog.exception("Method evaluateJavascript not found", e);
                this._evaluateJavascript = null;
            }
        }
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setPluginState(PluginState.OFF);
        settings.setRenderPriority(RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        setSettings(webSettings, webPlayerSettings);
        setWebViewClient(new WebPlayerClient());
        setWebChromeClient(new WebPlayerChromeClient());
        setDownloadListener(new WebPlayerDownloadListener());
        addJavascriptInterface(new WebPlayerBridgeInterface(viewId2), "webplayerbridge");
    }

    public void setEventSettings(JSONObject eventSettings) {
        this._eventSettings = eventSettings;
    }

    public void setSettings(JSONObject webSettings, JSONObject webPlayerSettings) {
        Map<String, String> map = this._erroredSettings;
        if (map != null) {
            map.clear();
        }
        setTargetSettings(getSettings(), webSettings);
        setTargetSettings(this, webPlayerSettings);
    }

    public Map<String, String> getErroredSettings() {
        return this._erroredSettings;
    }

    private Object setTargetSettings(Object targetObj, JSONObject settings) {
        if (settings != null) {
            Iterator<String> keysIterator = settings.keys();
            while (keysIterator.hasNext()) {
                String key = (String) keysIterator.next();
                try {
                    JSONArray parameters = settings.getJSONArray(key);
                    targetObj.getClass().getMethod(key, getTypes(parameters)).invoke(targetObj, getValues(parameters));
                } catch (Exception e) {
                    addErroredSetting(key, e.getMessage());
                    DeviceLog.exception("Setting errored", e);
                }
            }
        }
        return targetObj;
    }

    public void invokeJavascript(String data) {
        Utilities.runOnUiThread(new JavaScriptInvocation(data, this));
    }

    public void sendEvent(JSONArray params) {
        StringBuilder builder = new StringBuilder();
        builder.append("javascript:window.nativebridge.receiveEvent(");
        builder.append(params.toString());
        builder.append(")");
        invokeJavascript(builder.toString());
    }

    private Class<?>[] getTypes(JSONArray parameters) throws JSONException, ClassNotFoundException {
        if (parameters == null) {
            return null;
        }
        Class<?>[] types = new Class[parameters.length()];
        if (parameters != null) {
            for (int i = 0; i < parameters.length(); i++) {
                if (parameters.get(i) instanceof JSONObject) {
                    Class<?> theClass = Class.forName(((JSONObject) parameters.get(i)).getString("className"));
                    if (theClass != null) {
                        types[i] = theClass;
                    }
                } else {
                    types[i] = getPrimitiveClass(parameters.get(i).getClass());
                }
            }
        }
        return types;
    }

    public Class<?> getPrimitiveClass(Class<?> className) {
        String typeName = className.getName();
        if (typeName.equals("java.lang.Byte")) {
            return Byte.TYPE;
        }
        if (typeName.equals("java.lang.Short")) {
            return Short.TYPE;
        }
        if (typeName.equals("java.lang.Integer")) {
            return Integer.TYPE;
        }
        if (typeName.equals("java.lang.Long")) {
            return Long.TYPE;
        }
        if (typeName.equals("java.lang.Character")) {
            return Character.TYPE;
        }
        if (typeName.equals("java.lang.Float")) {
            return Float.TYPE;
        }
        if (typeName.equals("java.lang.Double")) {
            return Double.TYPE;
        }
        if (typeName.equals("java.lang.Boolean")) {
            return Boolean.TYPE;
        }
        if (typeName.equals("java.lang.Void")) {
            return Void.TYPE;
        }
        return className;
    }

    private Object[] getValues(JSONArray parameters) throws JSONException, ClassNotFoundException, NoSuchMethodException {
        if (parameters == null) {
            return null;
        }
        Object[] values = new Object[parameters.length()];
        Object[] params = new Object[parameters.length()];
        for (int i = 0; i < parameters.length(); i++) {
            if (parameters.get(i) instanceof JSONObject) {
                JSONObject param = (JSONObject) parameters.get(i);
                Object value = param.get(DonationsAnalytics.VALUE);
                String type = param.getString("type");
                String className = null;
                String str = "className";
                if (param.has(str)) {
                    className = param.getString(str);
                }
                if (className != null && type.equals("Enum")) {
                    Class<?> enumClass = Class.forName(className);
                    if (enumClass != null) {
                        params[i] = Enum.valueOf(enumClass, (String) value);
                    }
                }
            } else {
                params[i] = parameters.get(i);
            }
        }
        if (parameters != null) {
            System.arraycopy(params, 0, values, 0, parameters.length());
        }
        return values;
    }

    private void addErroredSetting(String key, String error) {
        if (this._erroredSettings == null) {
            this._erroredSettings = new HashMap();
        }
        this._erroredSettings.put(key, error);
    }

    /* access modifiers changed from: private */
    public boolean shouldCallSuper(String event) {
        String str = "callSuper";
        try {
            if (this._eventSettings != null && this._eventSettings.has(event) && this._eventSettings.getJSONObject(event).has(str)) {
                return this._eventSettings.getJSONObject(event).getBoolean(str);
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting super call status", e);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean shouldSendEvent(String event) {
        String str = "sendEvent";
        try {
            if (this._eventSettings != null && this._eventSettings.has(event) && this._eventSettings.getJSONObject(event).has(str)) {
                return this._eventSettings.getJSONObject(event).getBoolean(str);
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting send event status", e);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public <T> T getReturnValue(String event, Class<T> type, T defaultValue) {
        String str = "returnValue";
        try {
            if (this._eventSettings != null && this._eventSettings.has(event) && this._eventSettings.getJSONObject(event).has(str)) {
                return type.cast(this._eventSettings.getJSONObject(event).get(str));
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting default return value", e);
        }
        return defaultValue;
    }

    /* access modifiers changed from: private */
    public boolean hasReturnValue(String event) {
        try {
            if (this._eventSettings != null && this._eventSettings.has(event) && this._eventSettings.getJSONObject(event).has("returnValue")) {
                return true;
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting default return value", e);
        }
        return false;
    }
}
