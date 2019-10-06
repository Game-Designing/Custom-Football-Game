package p019d.p143b.p144a.p147c;

import java.util.HashSet;

/* renamed from: d.b.a.c.ub */
public class C7216ub<T> {

    /* renamed from: a */
    static final C7216ub<String> f13974a = new C7216ub<>("com.applovin.sdk.impl.isFirstRun", String.class);

    /* renamed from: b */
    static final C7216ub<HashSet> f13975b = new C7216ub<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);

    /* renamed from: c */
    static final C7216ub<Integer> f13976c = new C7216ub<>("com.applovin.sdk.last_version_code", Integer.class);

    /* renamed from: d */
    static final C7216ub<String> f13977d = new C7216ub<>("com.applovin.sdk.zones", String.class);

    /* renamed from: e */
    static final C7216ub<String> f13978e = new C7216ub<>("com.applovin.sdk.loaded_mediation_adapters", String.class);

    /* renamed from: f */
    static final C7216ub<Boolean> f13979f = new C7216ub<>("com.applovin.sdk.compliance.has_user_consent", Boolean.class);

    /* renamed from: g */
    static final C7216ub<Boolean> f13980g = new C7216ub<>("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);

    /* renamed from: h */
    static final C7216ub<String> f13981h = new C7216ub<>("com.applovin.sdk.stats", String.class);

    /* renamed from: i */
    static final C7216ub<HashSet> f13982i = new C7216ub<>("com.applovin.sdk.ad.stats", HashSet.class);

    /* renamed from: j */
    public static final C7216ub<Integer> f13983j = new C7216ub<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: k */
    public static final C7216ub<Boolean> f13984k = new C7216ub<>("com.applovin.sdk.should_resume_video", Boolean.class);

    /* renamed from: l */
    private final String f13985l;

    /* renamed from: m */
    private final Class<T> f13986m;

    C7216ub(String str, Class<T> cls) {
        this.f13985l = str;
        this.f13986m = cls;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo23344a() {
        return this.f13985l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Class<T> mo23345b() {
        return this.f13986m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Key{name='");
        sb.append(this.f13985l);
        sb.append('\'');
        sb.append("type='");
        sb.append(this.f13986m);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
