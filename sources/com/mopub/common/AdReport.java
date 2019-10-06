package com.mopub.common;

import android.os.Build.VERSION;
import com.mopub.common.privacy.AdvertisingId;
import com.mopub.network.AdResponse;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p005cm.aptoide.p006pt.BuildConfig;

public class AdReport implements Serializable {

    /* renamed from: a */
    private final AdResponse f34210a;

    /* renamed from: b */
    private final String f34211b;

    /* renamed from: c */
    private final String f34212c;

    /* renamed from: d */
    private final String f34213d;

    /* renamed from: e */
    private final Locale f34214e;

    /* renamed from: f */
    private final AdvertisingId f34215f;

    public AdReport(String adUnitId, ClientMetadata clientMetadata, AdResponse adResponse) {
        this.f34211b = adUnitId;
        this.f34212c = clientMetadata.getSdkVersion();
        this.f34213d = clientMetadata.getDeviceModel();
        this.f34214e = clientMetadata.getDeviceLocale();
        this.f34215f = clientMetadata.getMoPubIdentifier().getAdvertisingInfo();
        this.f34210a = adResponse;
    }

    public String toString() {
        String str;
        StringBuilder parameters = new StringBuilder();
        m36905a(parameters, "sdk_version", this.f34212c);
        m36905a(parameters, "creative_id", this.f34210a.getDspCreativeId());
        m36905a(parameters, "platform_version", Integer.toString(VERSION.SDK_INT));
        m36905a(parameters, "device_model", this.f34213d);
        m36905a(parameters, "ad_unit_id", this.f34211b);
        Locale locale = this.f34214e;
        if (locale == null) {
            str = null;
        } else {
            str = locale.toString();
        }
        m36905a(parameters, "device_locale", str);
        m36905a(parameters, "device_id", this.f34215f.getIdentifier(MoPub.canCollectPersonalInformation()));
        m36905a(parameters, "network_type", this.f34210a.getNetworkType());
        m36905a(parameters, "platform", "android");
        m36905a(parameters, "timestamp", m36904a(this.f34210a.getTimestamp()));
        m36905a(parameters, "ad_type", this.f34210a.getAdType());
        Integer width = this.f34210a.getWidth();
        Object height = this.f34210a.getHeight();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Object obj = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        sb.append(width == null ? obj : width);
        sb.append(", ");
        if (height != null) {
            obj = height;
        }
        sb.append(obj);
        sb.append("}");
        m36905a(parameters, "ad_size", sb.toString());
        return parameters.toString();
    }

    public String getResponseString() {
        return this.f34210a.getStringBody();
    }

    public String getDspCreativeId() {
        return this.f34210a.getDspCreativeId();
    }

    /* renamed from: a */
    private void m36905a(StringBuilder parameters, String key, String value) {
        parameters.append(key);
        parameters.append(" : ");
        parameters.append(value);
        parameters.append("\n");
    }

    /* renamed from: a */
    private String m36904a(long timeStamp) {
        if (timeStamp == -1) {
            return null;
        }
        return new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(new Date(timeStamp));
    }
}
