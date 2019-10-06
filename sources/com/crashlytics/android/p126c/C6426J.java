package com.crashlytics.android.p126c;

import java.io.FileOutputStream;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.c.J */
/* compiled from: CrashlyticsController */
class C6426J implements C6457e {

    /* renamed from: a */
    final /* synthetic */ int f11511a;

    /* renamed from: b */
    final /* synthetic */ int f11512b;

    /* renamed from: c */
    final /* synthetic */ long f11513c;

    /* renamed from: d */
    final /* synthetic */ long f11514d;

    /* renamed from: e */
    final /* synthetic */ boolean f11515e;

    /* renamed from: f */
    final /* synthetic */ Map f11516f;

    /* renamed from: g */
    final /* synthetic */ int f11517g;

    /* renamed from: h */
    final /* synthetic */ C6452U f11518h;

    C6426J(C6452U this$0, int i, int i2, long j, long j2, boolean z, Map map, int i3) {
        this.f11518h = this$0;
        this.f11511a = i;
        this.f11512b = i2;
        this.f11513c = j;
        this.f11514d = j2;
        this.f11515e = z;
        this.f11516f = map;
        this.f11517g = i3;
    }

    /* renamed from: a */
    public void mo19445a(FileOutputStream arg) throws Exception {
        arg.write(new JSONObject(new C6423I(this)).toString().getBytes());
    }
}
