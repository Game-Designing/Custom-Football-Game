package p024io.fabric.sdk.android.p348a.p353e;

/* renamed from: io.fabric.sdk.android.a.e.v */
/* compiled from: SettingsData */
public class C13909v {

    /* renamed from: a */
    public final C13891e f42191a;

    /* renamed from: b */
    public final C13903q f42192b;

    /* renamed from: c */
    public final C13902p f42193c;

    /* renamed from: d */
    public final C13900n f42194d;

    /* renamed from: e */
    public final C13888b f42195e;

    /* renamed from: f */
    public final C13893g f42196f;

    /* renamed from: g */
    public final long f42197g;

    /* renamed from: h */
    public final int f42198h;

    /* renamed from: i */
    public final int f42199i;

    public C13909v(long expiresAtMillis, C13891e appData, C13903q sessionData, C13902p promptData, C13900n featuresData, C13888b analyticsSettingsData, C13893g betaSettingsData, int settingsVersion, int cacheDuration) {
        this.f42197g = expiresAtMillis;
        this.f42191a = appData;
        this.f42192b = sessionData;
        this.f42193c = promptData;
        this.f42194d = featuresData;
        this.f42198h = settingsVersion;
        this.f42199i = cacheDuration;
        this.f42195e = analyticsSettingsData;
        this.f42196f = betaSettingsData;
    }

    /* renamed from: a */
    public boolean mo43316a(long currentTimeMillis) {
        return this.f42197g < currentTimeMillis;
    }
}
