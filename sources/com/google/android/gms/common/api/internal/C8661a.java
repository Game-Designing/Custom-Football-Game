package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: com.google.android.gms.common.api.internal.a */
final class C8661a implements OnCompleteListener<Map<zai<?>, String>> {

    /* renamed from: a */
    private SignInConnectionListener f19743a;

    /* renamed from: b */
    private final /* synthetic */ zax f19744b;

    C8661a(zax zax, SignInConnectionListener signInConnectionListener) {
        this.f19744b = zax;
        this.f19743a = signInConnectionListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27567a() {
        this.f19743a.onComplete();
    }

    /* renamed from: a */
    public final void mo10072a(Task<Map<zai<?>, String>> task) {
        this.f19744b.f19922f.lock();
        try {
            if (!this.f19744b.f19930n) {
                this.f19743a.onComplete();
                return;
            }
            if (task.mo33179d()) {
                this.f19744b.f19932p = new C1253b(this.f19744b.f19918b.size());
                for (zaw g : this.f19744b.f19918b.values()) {
                    this.f19744b.f19932p.put(g.mo27368g(), ConnectionResult.f19510a);
                }
            } else if (task.mo33176a() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.mo33176a();
                if (this.f19744b.f19928l) {
                    this.f19744b.f19932p = new C1253b(this.f19744b.f19918b.size());
                    for (zaw zaw : this.f19744b.f19918b.values()) {
                        zai g2 = zaw.mo27368g();
                        ConnectionResult a = availabilityException.mo27348a(zaw);
                        if (this.f19744b.m21650a(zaw, a)) {
                            this.f19744b.f19932p.put(g2, new ConnectionResult(16));
                        } else {
                            this.f19744b.f19932p.put(g2, a);
                        }
                    }
                } else {
                    this.f19744b.f19932p = availabilityException.mo27347a();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.mo33176a());
                this.f19744b.f19932p = Collections.emptyMap();
            }
            if (this.f19744b.isConnected()) {
                this.f19744b.f19931o.putAll(this.f19744b.f19932p);
                if (this.f19744b.m21664h() == null) {
                    this.f19744b.m21661f();
                    this.f19744b.m21663g();
                    this.f19744b.f19925i.signalAll();
                }
            }
            this.f19743a.onComplete();
            this.f19744b.f19922f.unlock();
        } finally {
            this.f19744b.f19922f.unlock();
        }
    }
}
