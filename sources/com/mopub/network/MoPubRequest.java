package com.mopub.network;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public abstract class MoPubRequest<T> extends Request<T> {

    /* renamed from: q */
    private final String f36356q;

    /* renamed from: r */
    private final Context f36357r;

    public MoPubRequest(Context context, String url, ErrorListener listener) {
        super(MoPubRequestUtils.chooseMethod(url), MoPubRequestUtils.truncateQueryParamsIfPost(url), listener);
        this.f36356q = url;
        this.f36357r = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Map<String, String> mo38066e() {
        if (!MoPubRequestUtils.isMoPubRequest(getUrl())) {
            return null;
        }
        return MoPubRequestUtils.convertQueryToMap(this.f36357r, this.f36356q);
    }

    public String getBodyContentType() {
        if (MoPubRequestUtils.isMoPubRequest(getUrl())) {
            return "application/json; charset=UTF-8";
        }
        return super.getBodyContentType();
    }

    public byte[] getBody() {
        String body = MoPubRequestUtils.generateBodyFromParams(mo38066e(), getUrl());
        if (body == null) {
            return null;
        }
        return body.getBytes();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo38295b(NetworkResponse response) {
        Preconditions.checkNotNull(response);
        try {
            return new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            return new String(response.data);
        }
    }

    public String getOriginalUrl() {
        return this.f36356q;
    }

    public Map<String, String> getHeaders() {
        String country;
        String language;
        TreeMap<String, String> headers = new TreeMap<>();
        Locale userLocale = null;
        if (VERSION.SDK_INT >= 24) {
            LocaleList list = this.f36357r.getResources().getConfiguration().getLocales();
            if (list.size() > 0) {
                userLocale = list.get(0);
            }
        } else {
            userLocale = this.f36357r.getResources().getConfiguration().locale;
        }
        if (userLocale == null || TextUtils.isEmpty(userLocale.toString().trim())) {
            language = Locale.getDefault().getLanguage().trim();
            country = Locale.getDefault().getCountry().trim();
        } else {
            language = userLocale.getLanguage().trim();
            country = userLocale.getCountry().trim();
        }
        if (!TextUtils.isEmpty(language)) {
            String languageCode = language;
            if (!TextUtils.isEmpty(country)) {
                StringBuilder sb = new StringBuilder();
                sb.append(languageCode);
                sb.append("-");
                sb.append(country.toLowerCase());
                languageCode = sb.toString();
            }
            headers.put(ResponseHeader.ACCEPT_LANGUAGE.getKey(), languageCode);
        }
        return headers;
    }
}
