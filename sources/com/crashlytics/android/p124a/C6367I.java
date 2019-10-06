package com.crashlytics.android.p124a;

import java.io.File;
import java.util.List;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13836D;
import p024io.fabric.sdk.android.p348a.p350b.C13839a;
import p024io.fabric.sdk.android.p348a.p351c.C13878g;
import p024io.fabric.sdk.android.services.network.C13968d;
import p024io.fabric.sdk.android.services.network.C13971g;
import p024io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: com.crashlytics.android.a.I */
/* compiled from: SessionAnalyticsFilesSender */
class C6367I extends C13839a implements C13878g {

    /* renamed from: g */
    private final String f11352g;

    public C6367I(C0102l kit, String protocolAndHostOverride, String url, C13971g requestFactory, String apiKey) {
        super(kit, protocolAndHostOverride, url, requestFactory, C13968d.POST);
        this.f11352g = apiKey;
    }

    /* renamed from: a */
    public boolean mo19351a(List<File> files) {
        HttpRequest httpRequest = mo43219a();
        httpRequest.mo43441c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.mo43441c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f42015f.mo2536w());
        HttpRequest httpRequest2 = httpRequest.mo43441c("X-CRASHLYTICS-API-KEY", this.f11352g);
        int i = 0;
        for (File file : files) {
            StringBuilder sb = new StringBuilder();
            sb.append("session_analytics_file_");
            sb.append(i);
            httpRequest2.mo43430a(sb.toString(), file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        C13929o e = C13920f.m44245e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending ");
        sb2.append(files.size());
        sb2.append(" analytics files to ");
        sb2.append(mo43221b());
        String str = "Answers";
        e.mo43326c(str, sb2.toString());
        int statusCode = httpRequest2.mo43452g();
        C13929o e2 = C13920f.m44245e();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Response code for analytics file send is ");
        sb3.append(statusCode);
        e2.mo43326c(str, sb3.toString());
        return C13836D.m43981a(statusCode) == 0;
    }
}
