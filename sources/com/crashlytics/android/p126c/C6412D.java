package com.crashlytics.android.p126c;

import java.io.FileOutputStream;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.c.D */
/* compiled from: CrashlyticsController */
class C6412D implements C6457e {

    /* renamed from: a */
    final /* synthetic */ String f11473a;

    /* renamed from: b */
    final /* synthetic */ String f11474b;

    /* renamed from: c */
    final /* synthetic */ String f11475c;

    /* renamed from: d */
    final /* synthetic */ String f11476d;

    /* renamed from: e */
    final /* synthetic */ int f11477e;

    /* renamed from: f */
    final /* synthetic */ C6452U f11478f;

    C6412D(C6452U this$0, String str, String str2, String str3, String str4, int i) {
        this.f11478f = this$0;
        this.f11473a = str;
        this.f11474b = str2;
        this.f11475c = str3;
        this.f11476d = str4;
        this.f11477e = i;
    }

    /* renamed from: a */
    public void mo19445a(FileOutputStream arg) throws Exception {
        arg.write(new JSONObject(new C6410C(this)).toString().getBytes());
    }
}
