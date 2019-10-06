package com.asf.appcoins.sdk.core.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p362h.C14191g;
import p362h.C14194i;

public class LogInterceptor implements Interceptor {
    private static final String TAG = "HTTP_TRACE";
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private static String requestPath(HttpUrl url) {
        String str;
        String path = url.encodedPath();
        String query = url.encodedQuery();
        StringBuilder sb = new StringBuilder();
        sb.append(url.scheme());
        sb.append("://");
        sb.append(url.host());
        if (query != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(path);
            sb2.append('?');
            sb2.append(query);
            str = sb2.toString();
        } else {
            str = path;
        }
        sb.append(str);
        return sb.toString();
    }

    public Response intercept(Chain chain) throws IOException {
        String str;
        Charset charset;
        Request request = chain.request();
        RequestBody requestBody = request.body();
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("<---------------------------BEGIN REQUEST---------------------------------->");
        String str2 = "\n";
        logBuilder.append(str2);
        logBuilder.append("Request encoded url: ");
        logBuilder.append(request.method());
        String str3 = " ";
        logBuilder.append(str3);
        logBuilder.append(requestPath(request.url()));
        logBuilder.append(str2);
        String decodeUrl = requestDecodedPath(request.url());
        if (!TextUtils.isEmpty(decodeUrl)) {
            logBuilder.append("Request decoded url: ");
            logBuilder.append(request.method());
            logBuilder.append(str3);
            logBuilder.append(decodeUrl);
        }
        Headers headers = request.headers();
        String str4 = "\n=============== Headers ===============\n";
        logBuilder.append(str4);
        int i = headers.size();
        while (true) {
            i--;
            str = " : ";
            if (i <= -1) {
                break;
            }
            logBuilder.append(headers.name(i));
            logBuilder.append(str);
            logBuilder.append(headers.get(headers.name(i)));
            logBuilder.append(str2);
        }
        String str5 = "\n=============== END Headers ===============\n";
        logBuilder.append(str5);
        if (requestBody != null) {
            C14191g buffer = new C14191g();
            requestBody.writeTo(buffer);
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                contentType.charset(UTF8);
            }
            logBuilder.append(buffer.mo44213a(UTF8));
        }
        long startNs = System.nanoTime();
        Response response = chain.proceed(request);
        Request request2 = request;
        RequestBody requestBody2 = requestBody;
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        ResponseBody responseBody = response.body();
        logBuilder.append(str2);
        logBuilder.append("Response timeout: ");
        logBuilder.append(tookMs);
        logBuilder.append("ms");
        logBuilder.append(str2);
        logBuilder.append("Response message: ");
        logBuilder.append(response.message());
        logBuilder.append(str2);
        logBuilder.append("Response code: ");
        logBuilder.append(response.code());
        if (responseBody != null) {
            C14194i source = responseBody.source();
            long j = tookMs;
            source.request(Long.MAX_VALUE);
            C14191g buffer2 = source.mo44238k();
            Charset charset2 = null;
            MediaType contentType2 = responseBody.contentType();
            if (contentType2 != null) {
                Headers headers2 = headers;
                charset2 = contentType2.charset(UTF8);
            }
            if (charset2 == null) {
                charset = UTF8;
            } else {
                charset = charset2;
            }
            if (responseBody.contentLength() != 0) {
                logBuilder.append(str2);
                MediaType mediaType = contentType2;
                logBuilder.append("Response body: \n");
                logBuilder.append(buffer2.clone().mo44213a(charset));
            }
        } else {
            Headers headers3 = headers;
        }
        Headers headers4 = response.headers();
        logBuilder.append(str4);
        int i2 = headers4.size();
        while (true) {
            i2--;
            if (i2 > -1) {
                logBuilder.append(headers4.name(i2));
                logBuilder.append(str);
                logBuilder.append(headers4.get(headers4.name(i2)));
                logBuilder.append(str2);
            } else {
                logBuilder.append(str5);
                logBuilder.append(str2);
                logBuilder.append("<-----------------------------END REQUEST--------------------------------->");
                logBuilder.append("\n\n\n");
                Log.d(TAG, logBuilder.toString());
                return response;
            }
        }
    }

    private String requestDecodedPath(HttpUrl url) {
        String str;
        String str2 = "UTF-8";
        try {
            String path = URLDecoder.decode(url.encodedPath(), str2);
            String query = URLDecoder.decode(url.encodedQuery(), str2);
            StringBuilder sb = new StringBuilder();
            sb.append(url.scheme());
            sb.append("://");
            sb.append(url.host());
            if (query != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(path);
                sb2.append('?');
                sb2.append(query);
                str = sb2.toString();
            } else {
                str = path;
            }
            sb.append(str);
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
