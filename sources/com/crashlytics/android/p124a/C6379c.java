package com.crashlytics.android.p124a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: com.crashlytics.android.a.c */
/* compiled from: AnswersAttributes */
class C6379c {

    /* renamed from: a */
    final C6381e f11401a;

    /* renamed from: b */
    final Map<String, Object> f11402b = new ConcurrentHashMap();

    public C6379c(C6381e validator) {
        this.f11401a = validator;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19381a(String key, String value) {
        if (!this.f11401a.mo19386a((Object) key, Notification.KEY) && !this.f11401a.mo19386a((Object) value, DonationsAnalytics.VALUE)) {
            mo19380a(this.f11401a.mo19385a(key), (Object) this.f11401a.mo19385a(value));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19380a(String key, Object value) {
        if (!this.f11401a.mo19387a(this.f11402b, key)) {
            this.f11402b.put(key, value);
        }
    }

    public String toString() {
        return new JSONObject(this.f11402b).toString();
    }
}
