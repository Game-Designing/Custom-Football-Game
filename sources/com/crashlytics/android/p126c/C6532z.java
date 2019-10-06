package com.crashlytics.android.p126c;

import java.io.FileOutputStream;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.c.z */
/* compiled from: CrashlyticsController */
class C6532z implements C6457e {

    /* renamed from: a */
    final /* synthetic */ String f11726a;

    /* renamed from: b */
    final /* synthetic */ String f11727b;

    /* renamed from: c */
    final /* synthetic */ long f11728c;

    /* renamed from: d */
    final /* synthetic */ C6452U f11729d;

    C6532z(C6452U this$0, String str, String str2, long j) {
        this.f11729d = this$0;
        this.f11726a = str;
        this.f11727b = str2;
        this.f11728c = j;
    }

    /* renamed from: a */
    public void mo19445a(FileOutputStream arg) throws Exception {
        arg.write(new JSONObject(new C6530y(this)).toString().getBytes());
    }
}
