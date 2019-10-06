package com.mopub.common;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.network.Networking;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public abstract class MoPubHttpUrlConnection extends HttpURLConnection {
    public static HttpURLConnection getHttpUrlConnection(String url) throws IOException {
        String getUrl;
        Preconditions.checkNotNull(url);
        if (!m37032b(url)) {
            try {
                getUrl = urlEncode(url);
            } catch (Exception e) {
                getUrl = url;
            }
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(getUrl).openConnection();
            urlConnection.setRequestProperty("user-agent", Networking.getCachedUserAgent());
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            return urlConnection;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("URL is improperly encoded: ");
        sb.append(url);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String urlEncode(String url) throws Exception {
        URI uri;
        Preconditions.checkNotNull(url);
        if (!m37032b(url)) {
            if (m37033c(url)) {
                uri = m37031a(url);
            } else {
                uri = new URI(url);
            }
            return uri.toURL().toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("URL is improperly encoded: ");
        sb.append(url);
        throw new UnsupportedEncodingException(sb.toString());
    }

    /* renamed from: b */
    static boolean m37032b(String url) {
        try {
            URLDecoder.decode(url, "UTF-8");
            return false;
        } catch (UnsupportedEncodingException e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Url is improperly encoded: ");
            sb.append(url);
            MoPubLog.log(sdkLogEvent, sb.toString());
            return true;
        }
    }

    /* renamed from: c */
    static boolean m37033c(String url) {
        try {
            new URI(url);
            return false;
        } catch (URISyntaxException e) {
            return true;
        }
    }

    /* renamed from: a */
    static URI m37031a(String urlString) throws Exception {
        try {
            URL url = new URL(urlString);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            return uri;
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to encode url: ");
            sb.append(urlString);
            MoPubLog.log(sdkLogEvent, sb.toString());
            throw e;
        }
    }
}
