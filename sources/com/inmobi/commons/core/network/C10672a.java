package com.inmobi.commons.core.network;

import com.inmobi.commons.core.network.NetworkError.ErrorCode;

/* renamed from: com.inmobi.commons.core.network.a */
/* compiled from: AsyncNetworkTask */
public final class C10672a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f32561a = C10672a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C10676c f32562b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C10674a f32563c;

    /* renamed from: com.inmobi.commons.core.network.a$a */
    /* compiled from: AsyncNetworkTask */
    public interface C10674a {
        /* renamed from: a */
        void mo34261a(C10677d dVar);

        /* renamed from: b */
        void mo34262b(C10677d dVar);
    }

    public C10672a(C10676c cVar, C10674a aVar) {
        this.f32562b = cVar;
        this.f32563c = aVar;
    }

    /* renamed from: a */
    public final void mo34498a() {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    C10677d a = new C10675b(C10672a.this.f32562b).mo34500a();
                    if (a.mo34510a()) {
                        C10672a.this.f32563c.mo34262b(a);
                    } else {
                        C10672a.this.f32563c.mo34261a(a);
                    }
                } catch (Exception e) {
                    C10672a.f32561a;
                    new StringBuilder("Network request failed with unexpected error: ").append(e.getMessage());
                    NetworkError networkError = new NetworkError(ErrorCode.UNKNOWN_ERROR, "Network request failed with unknown error");
                    C10677d dVar = new C10677d();
                    dVar.f32591b = networkError;
                    C10672a.this.f32563c.mo34262b(dVar);
                }
            }
        }).start();
    }
}
