package com.bumptech.glide.load.p113c.p118e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6029k;
import com.bumptech.glide.C6354n;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6326q;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.p099b.C5920a;
import com.bumptech.glide.p103f.C5991g;
import com.bumptech.glide.p103f.p104a.C5974g;
import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p103f.p105b.C5983b;
import com.bumptech.glide.p106g.C6000c;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.load.c.e.g */
/* compiled from: GifFrameLoader */
class C6213g {

    /* renamed from: a */
    private final C5920a f10954a;

    /* renamed from: b */
    private final Handler f10955b;

    /* renamed from: c */
    private final List<C6215b> f10956c;

    /* renamed from: d */
    final C6354n f10957d;

    /* renamed from: e */
    private final C6250e f10958e;

    /* renamed from: f */
    private boolean f10959f;

    /* renamed from: g */
    private boolean f10960g;

    /* renamed from: h */
    private boolean f10961h;

    /* renamed from: i */
    private C6029k<Bitmap> f10962i;

    /* renamed from: j */
    private C6214a f10963j;

    /* renamed from: k */
    private boolean f10964k;

    /* renamed from: l */
    private C6214a f10965l;

    /* renamed from: m */
    private Bitmap f10966m;

    /* renamed from: n */
    private C6352n<Bitmap> f10967n;

    /* renamed from: o */
    private C6214a f10968o;

    /* renamed from: p */
    private C6217d f10969p;

    /* renamed from: com.bumptech.glide.load.c.e.g$a */
    /* compiled from: GifFrameLoader */
    static class C6214a extends C5974g<Bitmap> {

        /* renamed from: a */
        private final Handler f10970a;

        /* renamed from: b */
        final int f10971b;

        /* renamed from: c */
        private final long f10972c;

        /* renamed from: d */
        private Bitmap f10973d;

        C6214a(Handler handler, int index, long targetTime) {
            this.f10970a = handler;
            this.f10971b = index;
            this.f10972c = targetTime;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Bitmap mo19081a() {
            return this.f10973d;
        }

        /* renamed from: a */
        public void onResourceReady(Bitmap resource, C5983b<? super Bitmap> bVar) {
            this.f10973d = resource;
            this.f10970a.sendMessageAtTime(this.f10970a.obtainMessage(1, this), this.f10972c);
        }
    }

    /* renamed from: com.bumptech.glide.load.c.e.g$b */
    /* compiled from: GifFrameLoader */
    public interface C6215b {
        /* renamed from: a */
        void mo19044a();
    }

    /* renamed from: com.bumptech.glide.load.c.e.g$c */
    /* compiled from: GifFrameLoader */
    private class C6216c implements Callback {
        C6216c() {
        }

        public boolean handleMessage(Message msg) {
            int i = msg.what;
            if (i == 1) {
                C6213g.this.mo19069a((C6214a) msg.obj);
                return true;
            }
            if (i == 2) {
                C6213g.this.f10957d.mo19320a((C5976i<?>) (C6214a) msg.obj);
            }
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.e.g$d */
    /* compiled from: GifFrameLoader */
    interface C6217d {
        /* renamed from: a */
        void mo19084a();
    }

    C6213g(C5926c glide, C5920a gifDecoder, int width, int height, C6352n<Bitmap> transformation, Bitmap firstFrame) {
        this(glide.mo18581c(), C5926c.m10920b(glide.mo18583e()), gifDecoder, null, m11829a(C5926c.m10920b(glide.mo18583e()), width, height), transformation, firstFrame);
    }

    C6213g(C6250e bitmapPool, C6354n requestManager, C5920a gifDecoder, Handler handler, C6029k<Bitmap> requestBuilder, C6352n<Bitmap> transformation, Bitmap firstFrame) {
        this.f10956c = new ArrayList();
        this.f10957d = requestManager;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new C6216c());
        }
        this.f10958e = bitmapPool;
        this.f10955b = handler;
        this.f10962i = requestBuilder;
        this.f10954a = gifDecoder;
        mo19071a(transformation, firstFrame);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19071a(C6352n<Bitmap> transformation, Bitmap firstFrame) {
        C6024i.m11264a(transformation);
        this.f10967n = transformation;
        C6024i.m11264a(firstFrame);
        this.f10966m = firstFrame;
        C6029k<Bitmap> kVar = this.f10962i;
        kVar.mo18838a(new C5991g().mo18747a(transformation));
        this.f10962i = kVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Bitmap mo19076e() {
        return this.f10966m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19070a(C6215b frameCallback) {
        if (this.f10964k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f10956c.contains(frameCallback)) {
            boolean start = this.f10956c.isEmpty();
            this.f10956c.add(frameCallback);
            if (start) {
                m11834n();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19073b(C6215b frameCallback) {
        this.f10956c.remove(frameCallback);
        if (this.f10956c.isEmpty()) {
            m11835o();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public int mo19080i() {
        return mo19074c().getWidth();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo19078g() {
        return mo19074c().getHeight();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo19079h() {
        return this.f10954a.mo18558f() + m11831k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo19075d() {
        C6214a aVar = this.f10963j;
        if (aVar != null) {
            return aVar.f10971b;
        }
        return -1;
    }

    /* renamed from: k */
    private int m11831k() {
        return C6026k.m11272a(mo19074c().getWidth(), mo19074c().getHeight(), mo19074c().getConfig());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ByteBuffer mo19072b() {
        return this.f10954a.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo19077f() {
        return this.f10954a.mo18553b();
    }

    /* renamed from: n */
    private void m11834n() {
        if (!this.f10959f) {
            this.f10959f = true;
            this.f10964k = false;
            m11832l();
        }
    }

    /* renamed from: o */
    private void m11835o() {
        this.f10959f = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19068a() {
        this.f10956c.clear();
        m11833m();
        m11835o();
        C6214a aVar = this.f10963j;
        if (aVar != null) {
            this.f10957d.mo19320a((C5976i<?>) aVar);
            this.f10963j = null;
        }
        C6214a aVar2 = this.f10965l;
        if (aVar2 != null) {
            this.f10957d.mo19320a((C5976i<?>) aVar2);
            this.f10965l = null;
        }
        C6214a aVar3 = this.f10968o;
        if (aVar3 != null) {
            this.f10957d.mo19320a((C5976i<?>) aVar3);
            this.f10968o = null;
        }
        this.f10954a.clear();
        this.f10964k = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Bitmap mo19074c() {
        C6214a aVar = this.f10963j;
        return aVar != null ? aVar.mo19081a() : this.f10966m;
    }

    /* renamed from: l */
    private void m11832l() {
        if (this.f10959f && !this.f10960g) {
            if (this.f10961h) {
                C6024i.m11268a(this.f10968o == null, "Pending target must be null when starting from the first frame");
                this.f10954a.mo18556d();
                this.f10961h = false;
            }
            if (this.f10968o != null) {
                C6214a temp = this.f10968o;
                this.f10968o = null;
                mo19069a(temp);
                return;
            }
            this.f10960g = true;
            long targetTime = SystemClock.uptimeMillis() + ((long) this.f10954a.mo18554c());
            this.f10954a.advance();
            this.f10965l = new C6214a(this.f10955b, this.f10954a.mo18557e(), targetTime);
            C6029k<Bitmap> kVar = this.f10962i;
            kVar.mo18838a(C5991g.m11107b(m11830j()));
            kVar.mo18840a((Object) this.f10954a);
            kVar.mo18832a(this.f10965l);
        }
    }

    /* renamed from: m */
    private void m11833m() {
        Bitmap bitmap = this.f10966m;
        if (bitmap != null) {
            this.f10958e.mo19000a(bitmap);
            this.f10966m = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19069a(C6214a delayTarget) {
        C6217d dVar = this.f10969p;
        if (dVar != null) {
            dVar.mo19084a();
        }
        this.f10960g = false;
        if (this.f10964k) {
            this.f10955b.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.f10959f) {
            this.f10968o = delayTarget;
        } else {
            if (delayTarget.mo19081a() != null) {
                m11833m();
                C6214a previous = this.f10963j;
                this.f10963j = delayTarget;
                for (int i = this.f10956c.size() - 1; i >= 0; i--) {
                    ((C6215b) this.f10956c.get(i)).mo19044a();
                }
                if (previous != null) {
                    this.f10955b.obtainMessage(2, previous).sendToTarget();
                }
            }
            m11832l();
        }
    }

    /* renamed from: a */
    private static C6029k<Bitmap> m11829a(C6354n requestManager, int width, int height) {
        C6029k<Bitmap> a = requestManager.mo19314a();
        a.mo18838a(C5991g.m11106b(C6326q.f11249b).mo18753b(true).mo18749a(true).mo18738a(width, height));
        return a;
    }

    /* renamed from: j */
    private static C6344g m11830j() {
        return new C6000c(Double.valueOf(Math.random()));
    }
}
