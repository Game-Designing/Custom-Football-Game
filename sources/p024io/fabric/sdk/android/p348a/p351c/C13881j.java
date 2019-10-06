package p024io.fabric.sdk.android.p348a.p351c;

import android.content.Context;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: io.fabric.sdk.android.a.c.j */
/* compiled from: TimeBasedFileRollOverRunnable */
public class C13881j implements Runnable {

    /* renamed from: a */
    private final Context f42108a;

    /* renamed from: b */
    private final C13877f f42109b;

    public C13881j(Context context, C13877f fileRollOverManager) {
        this.f42108a = context;
        this.f42109b = fileRollOverManager;
    }

    public void run() {
        try {
            C13852l.m44049c(this.f42108a, "Performing time based file roll over.");
            if (!this.f42109b.mo19422a()) {
                this.f42109b.mo19423b();
            }
        } catch (Exception e) {
            C13852l.m44034a(this.f42108a, "Failed to roll over file", (Throwable) e);
        }
    }
}
