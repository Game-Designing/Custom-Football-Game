package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.x */
/* compiled from: PlayerMessage */
public final class C8569x {

    /* renamed from: a */
    private final C8571b f18995a;

    /* renamed from: b */
    private final C8570a f18996b;

    /* renamed from: c */
    private final C8098D f18997c;

    /* renamed from: d */
    private int f18998d;

    /* renamed from: e */
    private Object f18999e;

    /* renamed from: f */
    private Handler f19000f;

    /* renamed from: g */
    private int f19001g;

    /* renamed from: h */
    private long f19002h = -9223372036854775807L;

    /* renamed from: i */
    private boolean f19003i = true;

    /* renamed from: j */
    private boolean f19004j;

    /* renamed from: k */
    private boolean f19005k;

    /* renamed from: l */
    private boolean f19006l;

    /* renamed from: m */
    private boolean f19007m;

    /* renamed from: com.google.android.exoplayer2.x$a */
    /* compiled from: PlayerMessage */
    public interface C8570a {
        /* renamed from: a */
        void mo25492a(C8569x xVar);
    }

    /* renamed from: com.google.android.exoplayer2.x$b */
    /* compiled from: PlayerMessage */
    public interface C8571b {
        /* renamed from: a */
        void mo25151a(int i, Object obj) throws ExoPlaybackException;
    }

    public C8569x(C8570a sender, C8571b target, C8098D timeline, int defaultWindowIndex, Handler defaultHandler) {
        this.f18996b = sender;
        this.f18995a = target;
        this.f18997c = timeline;
        this.f19000f = defaultHandler;
        this.f19001g = defaultWindowIndex;
    }

    /* renamed from: f */
    public C8098D mo26238f() {
        return this.f18997c;
    }

    /* renamed from: e */
    public C8571b mo26237e() {
        return this.f18995a;
    }

    /* renamed from: a */
    public C8569x mo26230a(int messageType) {
        C8514e.m20490b(!this.f19004j);
        this.f18998d = messageType;
        return this;
    }

    /* renamed from: g */
    public int mo26239g() {
        return this.f18998d;
    }

    /* renamed from: a */
    public C8569x mo26231a(Object payload) {
        C8514e.m20490b(!this.f19004j);
        this.f18999e = payload;
        return this;
    }

    /* renamed from: c */
    public Object mo26235c() {
        return this.f18999e;
    }

    /* renamed from: b */
    public Handler mo26234b() {
        return this.f19000f;
    }

    /* renamed from: d */
    public long mo26236d() {
        return this.f19002h;
    }

    /* renamed from: h */
    public int mo26240h() {
        return this.f19001g;
    }

    /* renamed from: a */
    public boolean mo26233a() {
        return this.f19003i;
    }

    /* renamed from: j */
    public C8569x mo26242j() {
        C8514e.m20490b(!this.f19004j);
        if (this.f19002h == -9223372036854775807L) {
            C8514e.m20488a(this.f19003i);
        }
        this.f19004j = true;
        this.f18996b.mo25492a(this);
        return this;
    }

    /* renamed from: i */
    public synchronized boolean mo26241i() {
        return this.f19007m;
    }

    /* renamed from: a */
    public synchronized void mo26232a(boolean isDelivered) {
        this.f19005k |= isDelivered;
        this.f19006l = true;
        notifyAll();
    }
}
