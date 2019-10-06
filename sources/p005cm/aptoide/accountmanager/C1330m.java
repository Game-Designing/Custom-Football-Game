package p005cm.aptoide.accountmanager;

import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.accountmanager.m */
/* compiled from: lambda */
public final /* synthetic */ class C1330m implements C0129b {

    /* renamed from: a */
    public static final /* synthetic */ C1330m f4223a = new C1330m();

    private /* synthetic */ C1330m() {
    }

    public final void call(Object obj) {
        CrashReport.getInstance().log((Throwable) obj);
    }
}
