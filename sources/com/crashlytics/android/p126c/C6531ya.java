package com.crashlytics.android.p126c;

import java.io.File;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13836D;
import p024io.fabric.sdk.android.p348a.p350b.C13839a;
import p024io.fabric.sdk.android.services.network.C13968d;
import p024io.fabric.sdk.android.services.network.C13971g;
import p024io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: com.crashlytics.android.c.ya */
/* compiled from: NativeCreateReportSpiCall */
class C6531ya extends C13839a implements C6495ia {
    public C6531ya(C0102l kit, String protocolAndHostOverride, String url, C13971g requestFactory) {
        super(kit, protocolAndHostOverride, url, requestFactory, C13968d.POST);
    }

    /* renamed from: a */
    public boolean mo19575a(C6493ha requestData) {
        HttpRequest httpRequest = m12799a(m12800a(mo43219a(), requestData.f11662a), requestData.f11663b);
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Sending report to: ");
        sb.append(mo43221b());
        String str = "CrashlyticsCore";
        e.mo43326c(str, sb.toString());
        int statusCode = httpRequest.mo43452g();
        C13929o e2 = C13920f.m44245e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Result was: ");
        sb2.append(statusCode);
        e2.mo43326c(str, sb2.toString());
        return C13836D.m43981a(statusCode) == 0;
    }

    /* renamed from: a */
    private HttpRequest m12800a(HttpRequest httpRequest, String apiKey) {
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Android SDK/");
        sb.append(this.f42015f.mo2536w());
        httpRequest.mo43441c("User-Agent", sb.toString());
        httpRequest.mo43441c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.mo43441c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f42015f.mo2536w());
        httpRequest.mo43441c("X-CRASHLYTICS-API-KEY", apiKey);
        return httpRequest;
    }

    /* renamed from: a */
    private HttpRequest m12799a(HttpRequest httpRequest, C6424Ia report) {
        File[] files;
        httpRequest.mo43448e("report_id", report.mo19433b());
        for (File f : report.getFiles()) {
            String str = "application/octet-stream";
            if (f.getName().equals("minidump")) {
                httpRequest.mo43430a("minidump_file", f.getName(), str, f);
            } else if (f.getName().equals("metadata")) {
                httpRequest.mo43430a("crash_meta_file", f.getName(), str, f);
            } else if (f.getName().equals("binaryImages")) {
                httpRequest.mo43430a("binary_images_file", f.getName(), str, f);
            } else if (f.getName().equals("session")) {
                httpRequest.mo43430a("session_meta_file", f.getName(), str, f);
            } else if (f.getName().equals("app")) {
                httpRequest.mo43430a("app_meta_file", f.getName(), str, f);
            } else if (f.getName().equals("device")) {
                httpRequest.mo43430a("device_meta_file", f.getName(), str, f);
            } else if (f.getName().equals("os")) {
                httpRequest.mo43430a("os_meta_file", f.getName(), str, f);
            } else if (f.getName().equals("user")) {
                httpRequest.mo43430a("user_meta_file", f.getName(), str, f);
            } else if (f.getName().equals("logs")) {
                httpRequest.mo43430a("logs_file", f.getName(), str, f);
            } else if (f.getName().equals("keys")) {
                httpRequest.mo43430a("keys_file", f.getName(), str, f);
            }
        }
        return httpRequest;
    }
}
