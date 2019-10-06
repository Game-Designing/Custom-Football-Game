package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.network.Networking;
import com.mopub.network.PlayServicesUrlRewriter;
import p005cm.aptoide.p006pt.BuildConfig;

public abstract class BaseUrlGenerator {

    /* renamed from: a */
    private StringBuilder f34230a;

    /* renamed from: b */
    private boolean f34231b;

    public abstract String generateUrlString(String str);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36456b(String serverHostname, String handlerType) {
        StringBuilder sb = new StringBuilder(Networking.getScheme());
        sb.append("://");
        sb.append(serverHostname);
        sb.append(handlerType);
        this.f34230a = sb;
        this.f34231b = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo36454b() {
        return this.f34230a.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36451a(String key, String value) {
        if (!TextUtils.isEmpty(value)) {
            this.f34230a.append(mo36406c());
            this.f34230a.append(key);
            this.f34230a.append("=");
            this.f34230a.append(Uri.encode(value));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36450a(String key, Boolean value) {
        if (value != null) {
            this.f34230a.append(mo36406c());
            this.f34230a.append(key);
            this.f34230a.append("=");
            this.f34230a.append(value.booleanValue() ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        }
    }

    /* renamed from: c */
    private String mo36406c() {
        if (!this.f34231b) {
            return "&";
        }
        this.f34231b = false;
        return "?";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36449a(String apiVersion) {
        mo36451a("v", apiVersion);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36455b(String appVersion) {
        mo36451a("av", appVersion);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36452a(boolean isExternalStoragePermissionGranted) {
        mo36451a("android_perms_ext_storage", isExternalStoragePermissionGranted ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36453a(String... info) {
        StringBuilder result = new StringBuilder();
        if (info != null && info.length >= 1) {
            for (int i = 0; i < info.length - 1; i++) {
                result.append(info[i]);
                result.append(",");
            }
            result.append(info[info.length - 1]);
            mo36451a("dn", result.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36447a() {
        mo36451a("udid", PlayServicesUrlRewriter.UDID_TEMPLATE);
        mo36451a("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36448a(Point dimensions) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        sb.append(dimensions.x);
        mo36451a("w", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(dimensions.y);
        mo36451a("h", sb2.toString());
    }
}
