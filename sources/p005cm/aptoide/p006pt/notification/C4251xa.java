package p005cm.aptoide.p006pt.notification;

import android.app.PendingIntent;
import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.notification.xa */
/* compiled from: lambda */
public final /* synthetic */ class C4251xa implements Callable {

    /* renamed from: a */
    private final /* synthetic */ Context f7829a;

    /* renamed from: b */
    private final /* synthetic */ PendingIntent f7830b;

    /* renamed from: c */
    private final /* synthetic */ String f7831c;

    /* renamed from: d */
    private final /* synthetic */ String f7832d;

    /* renamed from: e */
    private final /* synthetic */ PendingIntent f7833e;

    /* renamed from: f */
    private final /* synthetic */ String f7834f;

    public /* synthetic */ C4251xa(Context context, PendingIntent pendingIntent, String str, String str2, PendingIntent pendingIntent2, String str3) {
        this.f7829a = context;
        this.f7830b = pendingIntent;
        this.f7831c = str;
        this.f7832d = str2;
        this.f7833e = pendingIntent2;
        this.f7834f = str3;
    }

    public final Object call() {
        return SystemNotificationShower.m446a(this.f7829a, this.f7830b, this.f7831c, this.f7832d, this.f7833e, this.f7834f);
    }
}
