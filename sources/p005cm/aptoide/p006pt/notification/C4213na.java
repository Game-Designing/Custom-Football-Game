package p005cm.aptoide.p006pt.notification;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.notification.na */
/* compiled from: lambda */
public final /* synthetic */ class C4213na implements Callable {

    /* renamed from: a */
    private final /* synthetic */ Context f7777a;

    /* renamed from: b */
    private final /* synthetic */ int f7778b;

    /* renamed from: c */
    private final /* synthetic */ String f7779c;

    /* renamed from: d */
    private final /* synthetic */ String f7780d;

    public /* synthetic */ C4213na(Context context, int i, String str, String str2) {
        this.f7777a = context;
        this.f7778b = i;
        this.f7779c = str;
        this.f7780d = str2;
    }

    public final Object call() {
        return SystemNotificationShower.m448a(this.f7777a, this.f7778b, this.f7779c, this.f7780d);
    }
}
