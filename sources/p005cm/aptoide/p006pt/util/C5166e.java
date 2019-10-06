package p005cm.aptoide.p006pt.util;

import android.content.Context;
import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p026rx.p027b.C0129b;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.util.e */
/* compiled from: lambda */
public final /* synthetic */ class C5166e implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ int f8914a;

    /* renamed from: b */
    private final /* synthetic */ boolean f8915b;

    /* renamed from: c */
    private final /* synthetic */ AdsRepository f8916c;

    /* renamed from: d */
    private final /* synthetic */ OkHttpClient f8917d;

    /* renamed from: e */
    private final /* synthetic */ Factory f8918e;

    /* renamed from: f */
    private final /* synthetic */ QManager f8919f;

    /* renamed from: g */
    private final /* synthetic */ Context f8920g;

    /* renamed from: h */
    private final /* synthetic */ SharedPreferences f8921h;

    public /* synthetic */ C5166e(int i, boolean z, AdsRepository adsRepository, OkHttpClient okHttpClient, Factory factory, QManager qManager, Context context, SharedPreferences sharedPreferences) {
        this.f8914a = i;
        this.f8915b = z;
        this.f8916c = adsRepository;
        this.f8917d = okHttpClient;
        this.f8918e = factory;
        this.f8919f = qManager;
        this.f8920g = context;
        this.f8921h = sharedPreferences;
    }

    public final void call(Object obj) {
        C51581.m9446a(this.f8914a, this.f8915b, this.f8916c, this.f8917d, this.f8918e, this.f8919f, this.f8920g, this.f8921h, (MinimalAd) obj);
    }
}
