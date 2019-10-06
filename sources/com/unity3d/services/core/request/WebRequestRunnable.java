package com.unity3d.services.core.request;

import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebRequestRunnable implements Runnable {
    private final String _body;
    private boolean _canceled = false;
    private final int _connectTimeout;
    private WebRequest _currentRequest;
    private final Map<String, List<String>> _headers;
    private final IWebRequestListener _listener;
    private final int _readTimeout;
    private final String _type;
    private final String _url;

    public WebRequestRunnable(String url, String type, String body, int connectTimeout, int readTimeout, Map<String, List<String>> headers, IWebRequestListener listener) {
        this._url = url;
        this._type = type;
        this._body = body;
        this._connectTimeout = connectTimeout;
        this._readTimeout = readTimeout;
        this._headers = headers;
        this._listener = listener;
    }

    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("Handling request message: ");
        sb.append(this._url);
        sb.append(" type=");
        sb.append(this._type);
        DeviceLog.debug(sb.toString());
        try {
            makeRequest(this._url, this._type, this._headers, this._body, this._connectTimeout, this._readTimeout);
        } catch (MalformedURLException e) {
            String str = "Malformed URL";
            DeviceLog.exception(str, e);
            onFailed(str);
        }
    }

    public void setCancelStatus(boolean canceled) {
        this._canceled = canceled;
        if (this._canceled) {
            WebRequest webRequest = this._currentRequest;
            if (webRequest != null) {
                webRequest.cancel();
            }
        }
    }

    private void makeRequest(String url, String type, Map<String, List<String>> headers, String body, int connectTimeout, int readTimeout) throws MalformedURLException {
        if (!this._canceled) {
            WebRequest webRequest = new WebRequest(url, type, headers, connectTimeout, readTimeout);
            this._currentRequest = webRequest;
            if (body != null) {
                this._currentRequest.setBody(body);
            }
            try {
                String response = this._currentRequest.makeRequest();
                if (!this._currentRequest.isCanceled()) {
                    Bundle data = new Bundle();
                    for (String key : this._currentRequest.getResponseHeaders().keySet()) {
                        if (key != null && !key.contentEquals("null")) {
                            String[] values = new String[((List) this._currentRequest.getResponseHeaders().get(key)).size()];
                            for (int valueidx = 0; valueidx < ((List) this._currentRequest.getResponseHeaders().get(key)).size(); valueidx++) {
                                values[valueidx] = (String) ((List) this._currentRequest.getResponseHeaders().get(key)).get(valueidx);
                            }
                            data.putStringArray(key, values);
                        }
                    }
                    if (!this._currentRequest.isCanceled()) {
                        onSucceed(response, this._currentRequest.getResponseCode(), getResponseHeaders(data));
                    }
                }
            } catch (NetworkIOException | IOException | IllegalArgumentException | IllegalStateException e) {
                DeviceLog.exception("Error completing request", e);
                StringBuilder sb = new StringBuilder();
                sb.append(e.getClass().getName());
                sb.append(": ");
                sb.append(e.getMessage());
                onFailed(sb.toString());
            }
        }
    }

    private void onSucceed(String response, int responseCode, Map<String, List<String>> headers) {
        this._listener.onComplete(this._url, response, responseCode, headers);
    }

    private void onFailed(String error) {
        this._listener.onFailed(this._url, error);
    }

    private Map<String, List<String>> getResponseHeaders(Bundle resultData) {
        Map<String, List<String>> responseHeaders = null;
        if (resultData.size() > 0) {
            responseHeaders = new HashMap<>();
            for (String k : resultData.keySet()) {
                String[] tmpAr = resultData.getStringArray(k);
                if (tmpAr != null) {
                    responseHeaders.put(k, new ArrayList(Arrays.asList(tmpAr)));
                }
            }
        }
        return responseHeaders;
    }
}
