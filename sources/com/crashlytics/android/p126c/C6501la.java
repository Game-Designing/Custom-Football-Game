package com.crashlytics.android.p126c;

import java.io.File;
import java.util.Map.Entry;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13836D;
import p024io.fabric.sdk.android.p348a.p350b.C13839a;
import p024io.fabric.sdk.android.services.network.C13968d;
import p024io.fabric.sdk.android.services.network.C13971g;
import p024io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: com.crashlytics.android.c.la */
/* compiled from: DefaultCreateReportSpiCall */
class C6501la extends C13839a implements C6495ia {
    public C6501la(C0102l kit, String protocolAndHostOverride, String url, C13971g requestFactory) {
        super(kit, protocolAndHostOverride, url, requestFactory, C13968d.POST);
    }

    /* renamed from: a */
    public boolean mo19575a(C6493ha requestData) {
        HttpRequest httpRequest = m12738a(m12739a(mo43219a(), requestData), requestData.f11663b);
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Sending report to: ");
        sb.append(mo43221b());
        String str = "CrashlyticsCore";
        e.mo43326c(str, sb.toString());
        int statusCode = httpRequest.mo43452g();
        C13929o e2 = C13920f.m44245e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Create report request ID: ");
        sb2.append(httpRequest.mo43444d("X-REQUEST-ID"));
        e2.mo43326c(str, sb2.toString());
        C13929o e3 = C13920f.m44245e();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Result was: ");
        sb3.append(statusCode);
        e3.mo43326c(str, sb3.toString());
        return C13836D.m43981a(statusCode) == 0;
    }

    /* renamed from: a */
    private HttpRequest m12739a(HttpRequest request, C6493ha requestData) {
        request.mo43441c("X-CRASHLYTICS-API-KEY", requestData.f11662a);
        request.mo43441c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        HttpRequest request2 = request.mo43441c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f42015f.mo2536w());
        for (Entry<String, String> entry : requestData.f11663b.mo19432a().entrySet()) {
            request2 = request2.mo43433a(entry);
        }
        return request2;
    }

    /* renamed from: a */
    private HttpRequest m12738a(HttpRequest request, C6424Ia report) {
        File[] files;
        request.mo43448e("report[identifier]", report.mo19433b());
        String str = "application/octet-stream";
        String str2 = " to report ";
        String str3 = "CrashlyticsCore";
        if (report.getFiles().length == 1) {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Adding single file ");
            sb.append(report.getFileName());
            sb.append(str2);
            sb.append(report.mo19433b());
            e.mo43326c(str3, sb.toString());
            request.mo43430a("report[file]", report.getFileName(), str, report.getFile());
            return request;
        }
        int i = 0;
        for (File file : report.getFiles()) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Adding file ");
            sb2.append(file.getName());
            sb2.append(str2);
            sb2.append(report.mo19433b());
            e2.mo43326c(str3, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("report[file");
            sb3.append(i);
            sb3.append("]");
            request.mo43430a(sb3.toString(), file.getName(), str, file);
            i++;
        }
        return request;
    }
}
