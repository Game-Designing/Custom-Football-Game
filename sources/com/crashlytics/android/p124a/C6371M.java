package com.crashlytics.android.p124a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.crashlytics.android.a.M */
/* compiled from: SessionEvent */
final class C6371M {

    /* renamed from: a */
    public final C6374N f11358a;

    /* renamed from: b */
    public final long f11359b;

    /* renamed from: c */
    public final C6373b f11360c;

    /* renamed from: d */
    public final Map<String, String> f11361d;

    /* renamed from: e */
    public final String f11362e;

    /* renamed from: f */
    public final Map<String, Object> f11363f;

    /* renamed from: g */
    public final String f11364g;

    /* renamed from: h */
    public final Map<String, Object> f11365h;

    /* renamed from: i */
    private String f11366i;

    /* renamed from: com.crashlytics.android.a.M$a */
    /* compiled from: SessionEvent */
    static class C6372a {

        /* renamed from: a */
        final C6373b f11367a;

        /* renamed from: b */
        final long f11368b = System.currentTimeMillis();

        /* renamed from: c */
        Map<String, String> f11369c = null;

        /* renamed from: d */
        String f11370d = null;

        /* renamed from: e */
        Map<String, Object> f11371e = null;

        /* renamed from: f */
        String f11372f = null;

        /* renamed from: g */
        Map<String, Object> f11373g = null;

        public C6372a(C6373b type) {
            this.f11367a = type;
        }

        /* renamed from: b */
        public C6372a mo19370b(Map<String, String> details) {
            this.f11369c = details;
            return this;
        }

        /* renamed from: a */
        public C6372a mo19367a(String customType) {
            this.f11370d = customType;
            return this;
        }

        /* renamed from: a */
        public C6372a mo19368a(Map<String, Object> customAttributes) {
            this.f11371e = customAttributes;
            return this;
        }

        /* renamed from: a */
        public C6371M mo19369a(C6374N sessionEventMetadata) {
            C6371M m = new C6371M(sessionEventMetadata, this.f11368b, this.f11367a, this.f11369c, this.f11370d, this.f11371e, this.f11372f, this.f11373g);
            return m;
        }
    }

    /* renamed from: com.crashlytics.android.a.M$b */
    /* compiled from: SessionEvent */
    enum C6373b {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    /* renamed from: a */
    public static C6372a m12321a(C6373b type, Activity activity) {
        Map<String, String> details = Collections.singletonMap("activity", activity.getClass().getName());
        C6372a aVar = new C6372a(type);
        aVar.mo19370b(details);
        return aVar;
    }

    /* renamed from: a */
    public static C6372a m12320a(long installedAt) {
        C6372a aVar = new C6372a(C6373b.INSTALL);
        aVar.mo19370b(Collections.singletonMap("installedAt", String.valueOf(installedAt)));
        return aVar;
    }

    /* renamed from: a */
    public static C6372a m12323a(String sessionId) {
        Map<String, String> details = Collections.singletonMap("sessionId", sessionId);
        C6372a aVar = new C6372a(C6373b.CRASH);
        aVar.mo19370b(details);
        return aVar;
    }

    /* renamed from: a */
    public static C6372a m12324a(String sessionId, String exceptionName) {
        C6372a a = m12323a(sessionId);
        a.mo19368a(Collections.singletonMap("exceptionName", exceptionName));
        return a;
    }

    /* renamed from: a */
    public static C6372a m12322a(C6397t event) {
        C6372a aVar = new C6372a(C6373b.CUSTOM);
        aVar.mo19367a(event.mo19420b());
        aVar.mo19368a(event.mo19384a());
        return aVar;
    }

    private C6371M(C6374N sessionEventMetadata, long timestamp, C6373b type, Map<String, String> details, String customType, Map<String, Object> customAttributes, String predefinedType, Map<String, Object> predefinedAttributes) {
        this.f11358a = sessionEventMetadata;
        this.f11359b = timestamp;
        this.f11360c = type;
        this.f11361d = details;
        this.f11362e = customType;
        this.f11363f = customAttributes;
        this.f11364g = predefinedType;
        this.f11365h = predefinedAttributes;
    }

    public String toString() {
        if (this.f11366i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(getClass().getSimpleName());
            sb.append(": ");
            sb.append("timestamp=");
            sb.append(this.f11359b);
            sb.append(", type=");
            sb.append(this.f11360c);
            sb.append(", details=");
            sb.append(this.f11361d);
            sb.append(", customType=");
            sb.append(this.f11362e);
            sb.append(", customAttributes=");
            sb.append(this.f11363f);
            sb.append(", predefinedType=");
            sb.append(this.f11364g);
            sb.append(", predefinedAttributes=");
            sb.append(this.f11365h);
            sb.append(", metadata=[");
            sb.append(this.f11358a);
            this.f11366i = sb.append("]]").toString();
        }
        return this.f11366i;
    }
}
