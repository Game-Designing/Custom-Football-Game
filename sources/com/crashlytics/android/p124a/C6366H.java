package com.crashlytics.android.p124a;

import android.content.Context;
import java.io.IOException;
import java.util.UUID;
import p024io.fabric.sdk.android.p348a.p350b.C13857n;
import p024io.fabric.sdk.android.p348a.p351c.C13873c;
import p024io.fabric.sdk.android.p348a.p351c.C13875d;
import p024io.fabric.sdk.android.p348a.p353e.C13888b;

/* renamed from: com.crashlytics.android.a.H */
/* compiled from: SessionAnalyticsFilesManager */
class C6366H extends C13873c<C6371M> {

    /* renamed from: h */
    private C13888b f11351h;

    C6366H(Context context, C6375O transform, C13857n currentTimeProvider, C13875d eventStorage) throws IOException {
        super(context, transform, currentTimeProvider, eventStorage, 100);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo19348c() {
        UUID targetUUIDComponent = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append("sa");
        String str = "_";
        sb.append(str);
        sb.append(targetUUIDComponent.toString());
        sb.append(str);
        sb.append(this.f42095c.mo43216a());
        sb.append(".tap");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo19350f() {
        C13888b bVar = this.f11351h;
        return bVar == null ? super.mo19350f() : bVar.f42120e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo19349e() {
        C13888b bVar = this.f11351h;
        return bVar == null ? super.mo19349e() : bVar.f42118c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19347a(C13888b analyticsSettingsData) {
        this.f11351h = analyticsSettingsData;
    }
}
