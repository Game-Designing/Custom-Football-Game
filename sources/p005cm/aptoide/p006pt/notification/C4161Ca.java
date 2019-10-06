package p005cm.aptoide.p006pt.notification;

import android.app.PendingIntent;
import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.notification.Ca */
/* compiled from: lambda */
public final /* synthetic */ class C4161Ca implements Callable {

    /* renamed from: a */
    private final /* synthetic */ Context f7708a;

    /* renamed from: b */
    private final /* synthetic */ PendingIntent f7709b;

    /* renamed from: c */
    private final /* synthetic */ String f7710c;

    /* renamed from: d */
    private final /* synthetic */ String f7711d;

    /* renamed from: e */
    private final /* synthetic */ String f7712e;

    /* renamed from: f */
    private final /* synthetic */ PendingIntent f7713f;

    public /* synthetic */ C4161Ca(Context context, PendingIntent pendingIntent, String str, String str2, String str3, PendingIntent pendingIntent2) {
        this.f7708a = context;
        this.f7709b = pendingIntent;
        this.f7710c = str;
        this.f7711d = str2;
        this.f7712e = str3;
        this.f7713f = pendingIntent2;
    }

    public final Object call() {
        return SystemNotificationShower.m447a(this.f7708a, this.f7709b, this.f7710c, this.f7711d, this.f7712e, this.f7713f);
    }
}
