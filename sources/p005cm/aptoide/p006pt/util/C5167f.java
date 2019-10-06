package p005cm.aptoide.p006pt.util;

import android.content.Context;
import p005cm.aptoide.p006pt.dataprovider.util.referrer.SimpleTimedFuture;

/* renamed from: cm.aptoide.pt.util.f */
/* compiled from: lambda */
public final /* synthetic */ class C5167f implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f8922a;

    /* renamed from: b */
    private final /* synthetic */ String[] f8923b;

    /* renamed from: c */
    private final /* synthetic */ String f8924c;

    /* renamed from: d */
    private final /* synthetic */ SimpleTimedFuture f8925d;

    public /* synthetic */ C5167f(Context context, String[] strArr, String str, SimpleTimedFuture simpleTimedFuture) {
        this.f8922a = context;
        this.f8923b = strArr;
        this.f8924c = str;
        this.f8925d = simpleTimedFuture;
    }

    public final void run() {
        ReferrerUtils.m9442a(this.f8922a, this.f8923b, this.f8924c, this.f8925d);
    }
}
