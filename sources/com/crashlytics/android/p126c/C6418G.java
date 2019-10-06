package com.crashlytics.android.p126c;

import java.io.FileOutputStream;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.c.G */
/* compiled from: CrashlyticsController */
class C6418G implements C6457e {

    /* renamed from: a */
    final /* synthetic */ boolean f11490a;

    /* renamed from: b */
    final /* synthetic */ C6452U f11491b;

    C6418G(C6452U this$0, boolean z) {
        this.f11491b = this$0;
        this.f11490a = z;
    }

    /* renamed from: a */
    public void mo19445a(FileOutputStream arg) throws Exception {
        arg.write(new JSONObject(new C6416F(this)).toString().getBytes());
    }
}
