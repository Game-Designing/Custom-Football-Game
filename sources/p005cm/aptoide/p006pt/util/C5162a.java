package p005cm.aptoide.p006pt.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.util.a */
/* compiled from: lambda */
public final /* synthetic */ class C5162a implements Callable {

    /* renamed from: a */
    private final /* synthetic */ boolean f8899a;

    /* renamed from: b */
    private final /* synthetic */ SearchAdResult f8900b;

    /* renamed from: c */
    private final /* synthetic */ OkHttpClient f8901c;

    /* renamed from: d */
    private final /* synthetic */ Factory f8902d;

    /* renamed from: e */
    private final /* synthetic */ QManager f8903e;

    /* renamed from: f */
    private final /* synthetic */ SharedPreferences f8904f;

    /* renamed from: g */
    private final /* synthetic */ int f8905g;

    /* renamed from: h */
    private final /* synthetic */ String f8906h;

    /* renamed from: i */
    private final /* synthetic */ long f8907i;

    /* renamed from: j */
    private final /* synthetic */ AdsRepository f8908j;

    /* renamed from: k */
    private final /* synthetic */ boolean f8909k;

    /* renamed from: l */
    private final /* synthetic */ Context f8910l;

    public /* synthetic */ C5162a(boolean z, SearchAdResult searchAdResult, OkHttpClient okHttpClient, Factory factory, QManager qManager, SharedPreferences sharedPreferences, int i, String str, long j, AdsRepository adsRepository, boolean z2, Context context) {
        this.f8899a = z;
        this.f8900b = searchAdResult;
        this.f8901c = okHttpClient;
        this.f8902d = factory;
        this.f8903e = qManager;
        this.f8904f = sharedPreferences;
        this.f8905g = i;
        this.f8906h = str;
        this.f8907i = j;
        this.f8908j = adsRepository;
        this.f8909k = z2;
        this.f8910l = context;
    }

    public final Object call() {
        return C51581.m9445a(this.f8899a, this.f8900b, this.f8901c, this.f8902d, this.f8903e, this.f8904f, this.f8905g, this.f8906h, this.f8907i, this.f8908j, this.f8909k, this.f8910l);
    }
}
