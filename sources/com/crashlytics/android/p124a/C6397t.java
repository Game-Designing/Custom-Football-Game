package com.crashlytics.android.p124a;

/* renamed from: com.crashlytics.android.a.t */
/* compiled from: CustomEvent */
public class C6397t extends C6380d<C6397t> {

    /* renamed from: c */
    private final String f11441c;

    public C6397t(String eventName) {
        if (eventName != null) {
            this.f11441c = this.f11403a.mo19385a(eventName);
            return;
        }
        throw new NullPointerException("eventName must not be null");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo19420b() {
        return this.f11441c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{eventName:\"");
        sb.append(this.f11441c);
        sb.append('\"');
        sb.append(", customAttributes:");
        sb.append(this.f11404b);
        sb.append("}");
        return sb.toString();
    }
}
