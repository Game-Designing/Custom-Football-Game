package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest.C6545b;
import com.facebook.GraphRequest.C6548e;

/* renamed from: com.facebook.M */
/* compiled from: RequestProgress */
class C6555M {

    /* renamed from: a */
    private final GraphRequest f11846a;

    /* renamed from: b */
    private final Handler f11847b;

    /* renamed from: c */
    private final long f11848c = C6787r.m13825o();

    /* renamed from: d */
    private long f11849d;

    /* renamed from: e */
    private long f11850e;

    /* renamed from: f */
    private long f11851f;

    C6555M(Handler callbackHandler, GraphRequest request) {
        this.f11846a = request;
        this.f11847b = callbackHandler;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19727a(long size) {
        this.f11849d += size;
        long j = this.f11849d;
        if (j >= this.f11850e + this.f11848c || j >= this.f11851f) {
            mo19726a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19728b(long size) {
        this.f11851f += size;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19726a() {
        if (this.f11849d > this.f11850e) {
            C6545b callback = this.f11846a.mo19684e();
            if (this.f11851f > 0 && (callback instanceof C6548e)) {
                long currentCopy = this.f11849d;
                long maxProgressCopy = this.f11851f;
                C6548e callbackCopy = (C6548e) callback;
                Handler handler = this.f11847b;
                if (handler == null) {
                    callbackCopy.mo19702a(currentCopy, maxProgressCopy);
                } else {
                    C6554L l = new C6554L(this, callbackCopy, currentCopy, maxProgressCopy);
                    handler.post(l);
                }
                this.f11850e = this.f11849d;
            }
        }
    }
}
