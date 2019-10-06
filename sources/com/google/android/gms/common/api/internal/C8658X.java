package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: com.google.android.gms.common.api.internal.X */
final class C8658X implements OnCompleteListener<Map<zai<?>, String>> {

    /* renamed from: a */
    private final /* synthetic */ zax f19736a;

    private C8658X(zax zax) {
        this.f19736a = zax;
    }

    /* renamed from: a */
    public final void mo10072a(Task<Map<zai<?>, String>> task) {
        this.f19736a.f19922f.lock();
        try {
            if (this.f19736a.f19930n) {
                if (task.mo33179d()) {
                    this.f19736a.f19931o = new C1253b(this.f19736a.f19917a.size());
                    for (zaw g : this.f19736a.f19917a.values()) {
                        this.f19736a.f19931o.put(g.mo27368g(), ConnectionResult.f19510a);
                    }
                } else if (task.mo33176a() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.mo33176a();
                    if (this.f19736a.f19928l) {
                        this.f19736a.f19931o = new C1253b(this.f19736a.f19917a.size());
                        for (zaw zaw : this.f19736a.f19917a.values()) {
                            zai g2 = zaw.mo27368g();
                            ConnectionResult a = availabilityException.mo27348a(zaw);
                            if (this.f19736a.m21650a(zaw, a)) {
                                this.f19736a.f19931o.put(g2, new ConnectionResult(16));
                            } else {
                                this.f19736a.f19931o.put(g2, a);
                            }
                        }
                    } else {
                        this.f19736a.f19931o = availabilityException.mo27347a();
                    }
                    this.f19736a.f19934r = this.f19736a.m21664h();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.mo33176a());
                    this.f19736a.f19931o = Collections.emptyMap();
                    this.f19736a.f19934r = new ConnectionResult(8);
                }
                if (this.f19736a.f19932p != null) {
                    this.f19736a.f19931o.putAll(this.f19736a.f19932p);
                    this.f19736a.f19934r = this.f19736a.m21664h();
                }
                if (this.f19736a.f19934r == null) {
                    this.f19736a.m21661f();
                    this.f19736a.m21663g();
                } else {
                    this.f19736a.f19930n = false;
                    this.f19736a.f19921e.mo27563a(this.f19736a.f19934r);
                }
                this.f19736a.f19925i.signalAll();
                this.f19736a.f19922f.unlock();
            }
        } finally {
            this.f19736a.f19922f.unlock();
        }
    }
}
