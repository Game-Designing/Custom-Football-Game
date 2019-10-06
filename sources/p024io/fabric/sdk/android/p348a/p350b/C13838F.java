package p024io.fabric.sdk.android.p348a.p350b;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: io.fabric.sdk.android.a.b.F */
/* compiled from: TimingMetric */
public class C13838F {

    /* renamed from: a */
    private final String f42005a;

    /* renamed from: b */
    private final String f42006b;

    /* renamed from: c */
    private final boolean f42007c;

    /* renamed from: d */
    private long f42008d;

    /* renamed from: e */
    private long f42009e;

    public C13838F(String eventName, String tag) {
        this.f42005a = eventName;
        this.f42006b = tag;
        this.f42007c = !Log.isLoggable(tag, 2);
    }

    /* renamed from: a */
    public synchronized void mo43217a() {
        if (!this.f42007c) {
            this.f42008d = SystemClock.elapsedRealtime();
            this.f42009e = 0;
        }
    }

    /* renamed from: b */
    public synchronized void mo43218b() {
        if (!this.f42007c) {
            if (this.f42009e == 0) {
                this.f42009e = SystemClock.elapsedRealtime() - this.f42008d;
                m43983c();
            }
        }
    }

    /* renamed from: c */
    private void m43983c() {
        String str = this.f42006b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42005a);
        sb.append(": ");
        sb.append(this.f42009e);
        sb.append("ms");
        Log.v(str, sb.toString());
    }
}
