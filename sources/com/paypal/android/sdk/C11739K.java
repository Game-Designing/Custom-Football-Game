package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.paypal.android.sdk.K */
public class C11739K {

    /* renamed from: a */
    private List f36712a;

    /* renamed from: b */
    private List f36713b;

    static {
        C11739K.class.getSimpleName();
    }

    private C11739K() {
        this.f36712a = Collections.synchronizedList(new ArrayList());
        this.f36713b = Collections.synchronizedList(new ArrayList());
    }

    /* synthetic */ C11739K(byte b) {
        this();
    }

    /* renamed from: a */
    public static C11739K m38870a() {
        return C11742L.f36740a;
    }

    /* renamed from: b */
    private void m38871b() {
        if (!this.f36713b.isEmpty()) {
            synchronized (this) {
                if (!this.f36713b.isEmpty()) {
                    C11736J j = (C11736J) this.f36713b.get(0);
                    this.f36713b.remove(0);
                    this.f36712a.add(j);
                    new Thread(j).start();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo38579a(C11736J j) {
        this.f36713b.add(j);
        if (this.f36712a.size() < 3) {
            m38871b();
        }
    }

    /* renamed from: b */
    public final void mo38580b(C11736J j) {
        this.f36712a.remove(j);
        m38871b();
    }
}
