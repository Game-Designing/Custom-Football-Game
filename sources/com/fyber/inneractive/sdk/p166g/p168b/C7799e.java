package com.fyber.inneractive.sdk.p166g.p168b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import com.fyber.inneractive.sdk.p166g.C7792b;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.p166g.p170d.C7839a.C7853a;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.fyber.inneractive.sdk.g.b.e */
public abstract class C7799e implements C7853a {

    /* renamed from: a */
    Context f15697a = null;

    /* renamed from: b */
    List<C7805b> f15698b = new CopyOnWriteArrayList();

    /* renamed from: c */
    List<C7804a> f15699c = new CopyOnWriteArrayList();

    /* renamed from: d */
    protected C7838b f15700d = C7838b.Idle;

    /* renamed from: e */
    boolean f15701e;

    /* renamed from: f */
    Handler f15702f;

    /* renamed from: g */
    TextureView f15703g;

    /* renamed from: h */
    SurfaceTexture f15704h;

    /* renamed from: i */
    boolean f15705i = false;

    /* renamed from: j */
    protected boolean f15706j = false;

    /* renamed from: k */
    private C7792b f15707k;

    /* renamed from: com.fyber.inneractive.sdk.g.b.e$a */
    public interface C7804a {
        /* renamed from: a */
        void mo24323a(int i);
    }

    /* renamed from: com.fyber.inneractive.sdk.g.b.e$b */
    public interface C7805b {
        /* renamed from: a */
        void mo24329a(C7838b bVar);

        /* renamed from: a */
        void mo24330a(Exception exc);

        /* renamed from: q */
        void mo24467q();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo24418a(Surface surface);

    /* renamed from: a */
    public abstract void mo24419a(String str);

    /* renamed from: a */
    public abstract void mo24420a(boolean z);

    /* renamed from: b */
    public abstract void mo24421b(boolean z);

    /* renamed from: b */
    public abstract boolean mo24422b();

    /* renamed from: c */
    public abstract void mo24423c();

    /* renamed from: d */
    public abstract int mo24424d();

    /* renamed from: e */
    public abstract int mo24425e();

    /* renamed from: f */
    public abstract void mo24426f();

    /* renamed from: g */
    public abstract void mo24427g();

    /* renamed from: h */
    public abstract int mo24428h();

    /* renamed from: i */
    public abstract int mo24429i();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract void mo24430j();

    /* renamed from: k */
    public abstract Object mo24431k();

    protected C7799e(Context context) {
        this.f15697a = context.getApplicationContext();
        this.f15702f = new Handler();
        this.f15707k = new C7792b(this);
        mo24430j();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo24416a() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("destroy started");
        IAlog.m18021b(sb.toString());
        m17342o();
        this.f15707k = null;
        Handler handler = this.f15702f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<C7805b> list = this.f15698b;
        if (list != null) {
            list.clear();
        }
        this.f15698b = null;
        this.f15701e = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(IAlog.m18018a((Object) this));
        sb2.append("destroy finished");
        IAlog.m18021b(sb2.toString());
    }

    @TargetApi(14)
    /* renamed from: a */
    public final void mo24454a(TextureView textureView) {
        TextureView textureView2 = this.f15703g;
        if (textureView2 == null || !textureView2.equals(textureView)) {
            this.f15703g = textureView;
            if (textureView != null) {
                SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
                SurfaceTexture surfaceTexture2 = this.f15704h;
                if (surfaceTexture2 == null || !surfaceTexture2.equals(surfaceTexture)) {
                    this.f15704h = surfaceTexture;
                    Surface surface = null;
                    SurfaceTexture surfaceTexture3 = this.f15704h;
                    if (surfaceTexture3 != null) {
                        surface = new Surface(surfaceTexture3);
                    }
                    mo24418a(surface);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo24456a(C7805b bVar) {
        List<C7805b> list = this.f15698b;
        if (list != null) {
            list.add(bVar);
        }
    }

    /* renamed from: b */
    public final void mo24459b(C7805b bVar) {
        List<C7805b> list = this.f15698b;
        if (list != null) {
            list.remove(bVar);
        }
    }

    /* renamed from: a */
    public final void mo24455a(C7804a aVar) {
        this.f15699c.add(aVar);
    }

    /* renamed from: l */
    public final C7838b mo24460l() {
        return this.f15700d;
    }

    /* renamed from: m */
    public final boolean mo24461m() {
        return this.f15700d == C7838b.Playing;
    }

    /* renamed from: n */
    public final boolean mo24462n() {
        return this.f15706j;
    }

    /* renamed from: a */
    public final void mo24458a(final Exception exc) {
        mo24457a(C7838b.Error);
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("onPlayerError called with: ");
        sb.append(exc.getMessage());
        IAlog.m18021b(sb.toString());
        this.f15702f.post(new Runnable() {
            public final void run() {
                C7799e eVar = C7799e.this;
                if (!eVar.f15701e) {
                    try {
                        if (eVar.f15698b != null) {
                            for (C7805b a : eVar.f15698b) {
                                a.mo24330a(exc);
                            }
                        }
                    } catch (Exception e) {
                        if (IAlog.f16291a <= 3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(IAlog.m18018a((Object) C7799e.this));
                            sb.append("onPlayerError callback threw an exception!");
                            IAlog.m18021b(sb.toString());
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        m17342o();
    }

    /* renamed from: a */
    public void mo24417a(final int i) {
        this.f15702f.post(new Runnable() {
            public final void run() {
                try {
                    if (C7799e.this.f15699c != null) {
                        for (C7804a a : C7799e.this.f15699c) {
                            a.mo24323a(i);
                        }
                    }
                } catch (Exception e) {
                    if (IAlog.f16291a <= 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(IAlog.m18018a((Object) C7799e.this));
                        sb.append("onPlayerProgress callback threw an exception!");
                        IAlog.m18021b(sb.toString());
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @TargetApi(14)
    /* renamed from: a */
    public final void mo24457a(final C7838b bVar) {
        if (bVar != this.f15700d) {
            this.f15700d = bVar;
            if (bVar == C7838b.Playing) {
                C7792b bVar2 = this.f15707k;
                if (bVar2 != null && bVar2.f15678b == null) {
                    bVar2.f15678b = new ScheduledThreadPoolExecutor(1);
                    bVar2.f15678b.scheduleAtFixedRate(bVar2.f15679c, 100, 1000, TimeUnit.MILLISECONDS);
                }
            } else if (bVar == C7838b.Paused || bVar == C7838b.Idle || bVar == C7838b.Completed) {
                m17342o();
            }
            if (bVar == C7838b.Idle || bVar == C7838b.Error) {
                if (this.f15704h != null && this.f15703g == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18018a((Object) this));
                    sb.append("current texture view is null. Releasing surface");
                    IAlog.m18021b(sb.toString());
                    this.f15704h.release();
                }
                this.f15703g = null;
                this.f15704h = null;
            }
            this.f15702f.post(new Runnable() {
                public final void run() {
                    try {
                        if (C7799e.this.f15698b != null) {
                            for (C7805b a : C7799e.this.f15698b) {
                                a.mo24329a(bVar);
                            }
                        }
                    } catch (Exception e) {
                        if (IAlog.f16291a <= 3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(IAlog.m18018a((Object) C7799e.this));
                            sb.append("onPlayerStateChanged callback threw an exception!");
                            IAlog.m18021b(sb.toString());
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: o */
    private void m17342o() {
        C7792b bVar = this.f15707k;
        if (bVar != null) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = bVar.f15678b;
            if (scheduledThreadPoolExecutor != null) {
                scheduledThreadPoolExecutor.shutdownNow();
                bVar.f15678b = null;
            }
        }
    }
}
