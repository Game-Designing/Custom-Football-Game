package com.fyber.inneractive.sdk.p166g.p168b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;
import com.fyber.inneractive.sdk.p166g.C7746a;
import com.fyber.inneractive.sdk.p166g.p168b.C7799e.C7804a;
import com.fyber.inneractive.sdk.p166g.p168b.C7799e.C7805b;
import com.fyber.inneractive.sdk.p166g.p168b.C7832m;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.p166g.p171e.C7863h;
import com.fyber.inneractive.sdk.p166g.p171e.C7864i;
import com.fyber.inneractive.sdk.p166g.p171e.C7864i.C7868a;
import com.fyber.inneractive.sdk.p174i.C7910l;
import com.fyber.inneractive.sdk.p174i.C7915o.C7916a;
import com.fyber.inneractive.sdk.p179l.C7927c;
import com.fyber.inneractive.sdk.p179l.C7930d.C7946h;
import com.fyber.inneractive.sdk.util.C7985a;
import com.fyber.inneractive.sdk.util.C7995b;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.C8033v;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mopub.mobileads.VastResourceXmlManager;
import p019d.p268f.p269a.p270a.C12717b;
import p019d.p268f.p269a.p270a.C12719d;

@TargetApi(16)
/* renamed from: com.fyber.inneractive.sdk.g.b.i */
public abstract class C7814i<ListenerT extends C7832m> implements C7795b<ListenerT>, C7804a, C7805b, C7863h {

    /* renamed from: a */
    private Runnable f15731a;

    /* renamed from: b */
    private float f15732b;

    /* renamed from: c */
    private boolean f15733c;

    /* renamed from: d */
    protected C7746a f15734d;

    /* renamed from: e */
    protected C7712j f15735e;

    /* renamed from: f */
    protected C7799e f15736f;

    /* renamed from: g */
    protected C7864i f15737g;

    /* renamed from: h */
    protected TextureView f15738h;

    /* renamed from: i */
    SurfaceTextureListener f15739i;

    /* renamed from: j */
    protected int f15740j;

    /* renamed from: k */
    protected ListenerT f15741k;

    /* renamed from: l */
    protected boolean f15742l;

    /* renamed from: m */
    Runnable f15743m;

    /* renamed from: n */
    ActivityLifecycleCallbacks f15744n;

    /* renamed from: o */
    protected boolean f15745o;

    /* renamed from: p */
    Bitmap f15746p;

    /* renamed from: q */
    AsyncTask<?, ?, ?> f15747q;

    /* renamed from: r */
    protected Skip f15748r;

    /* renamed from: s */
    private boolean f15749s;

    /* renamed from: t */
    private boolean f15750t;

    /* renamed from: u */
    private boolean f15751u;

    /* renamed from: com.fyber.inneractive.sdk.g.b.i$6 */
    static /* synthetic */ class C78216 {

        /* renamed from: a */
        static final /* synthetic */ int[] f15758a = new int[C7838b.values().length];

        static {
            try {
                f15758a[C7838b.Prepared.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15758a[C7838b.Buffering.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15758a[C7838b.Playing.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15758a[C7838b.Paused.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15758a[C7838b.Completed.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15758a[C7838b.Error.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15758a[C7838b.Idle.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f15758a[C7838b.Preparing.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f15758a[C7838b.Seeking.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract boolean mo24443f();

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract int mo24444g();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public abstract int mo24446i();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract void mo24447j();

    /* renamed from: a */
    static /* synthetic */ Bitmap m17422a(C7814i iVar, int i, int i2) {
        DisplayMetrics displayMetrics = iVar.mo24483A().getResources().getDisplayMetrics();
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        createBitmap.setDensity(displayMetrics.densityDpi);
        return createBitmap;
    }

    /* renamed from: c */
    public boolean mo24439c() {
        return this.f15742l || this.f15740j == 0;
    }

    public C7814i(C7746a aVar, C7864i iVar, C7712j jVar, boolean z, boolean z2) {
        this(aVar, iVar, jVar, z, z2, null);
    }

    public C7814i(C7746a aVar, C7864i iVar, C7712j jVar, boolean z, boolean z2, Skip skip) {
        this.f15740j = 0;
        this.f15742l = false;
        this.f15732b = -0.1f;
        this.f15750t = false;
        this.f15751u = false;
        this.f15746p = null;
        this.f15747q = null;
        this.f15748r = null;
        this.f15748r = skip;
        this.f15734d = aVar;
        this.f15735e = jVar;
        this.f15736f = this.f15734d.mo24337d();
        this.f15737g = iVar;
        this.f15749s = z;
        this.f15745o = z2;
        this.f15737g.setListener(this);
        C7799e eVar = this.f15736f;
        if (eVar != null) {
            eVar.mo24456a((C7805b) this);
            this.f15736f.mo24455a((C7804a) this);
        }
    }

    /* renamed from: a */
    public final void mo24434a(ListenerT listenert) {
        this.f15741k = listenert;
    }

    /* renamed from: a */
    public void mo24432a() {
        if (VERSION.SDK_INT >= 14 && this.f15744n != null) {
            Application A = mo24483A();
            if (A != null) {
                A.unregisterActivityLifecycleCallbacks(this.f15744n);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("destroy called");
        IAlog.m18021b(sb.toString());
        C7799e eVar = this.f15736f;
        if (eVar != null) {
            eVar.mo24459b((C7805b) this);
            this.f15736f.f15699c.remove(this);
        }
        mo24489u();
        mo24494z();
        AsyncTask<?, ?, ?> asyncTask = this.f15747q;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.f15741k = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo24492x() {
        return this.f15738h == null && this.f15736f.f15703g == null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo24489u() {
        if (this.f15738h != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("destroyTextureView");
            IAlog.m18021b(sb.toString());
            if (this.f15746p != null) {
                Bitmap b = mo24436b(false);
                if (b != null) {
                    this.f15737g.setLastFrameBitmap(b);
                    this.f15737g.mo24619a(true);
                }
            }
            if (this.f15738h.equals(this.f15736f.f15703g)) {
                this.f15736f.mo24454a((TextureView) null);
            }
            this.f15737g.getTextureHost().removeView(this.f15738h);
            this.f15738h.setSurfaceTextureListener(null);
            this.f15738h = null;
        }
    }

    /* renamed from: a_ */
    public void mo24435a_(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("initUI");
        IAlog.m18021b(sb.toString());
        this.f15737g.setUnitConfig(this.f15735e);
        this.f15737g.mo24616a(this.f15736f.mo24424d(), this.f15736f.mo24425e(), this.f15745o);
        if (this.f15736f.mo24424d() > 0 && this.f15736f.mo24425e() > 0) {
            m17423a(this.f15736f.mo24424d(), this.f15736f.mo24425e());
        }
        if (!z) {
            mo24323a(this.f15736f.mo24428h());
            m17424a(this.f15736f.mo24460l(), false);
        }
        mo24498D();
        if (mo24443f()) {
            this.f15740j = mo24444g();
        } else {
            this.f15737g.mo24627f(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public boolean mo24487s() {
        return this.f15749s;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public void mo24491w() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public void mo24493y() {
        C7746a aVar = this.f15734d;
        if (aVar != null) {
            aVar.mo24336c();
        }
    }

    /* renamed from: z */
    private void mo24494z() {
        Runnable runnable = this.f15743m;
        if (runnable != null) {
            this.f15737g.removeCallbacks(runnable);
            this.f15743m = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo24448k() {
        this.f15737g.mo24634h(false);
        this.f15737g.mo24635i(false);
        this.f15737g.mo24628g(false);
        this.f15737g.mo24620a(false, false);
        this.f15737g.mo24623d(true);
        this.f15737g.mo24621b(true);
        this.f15737g.mo24625e(true);
        mo24494z();
        if (mo24443f() && !this.f15742l && m17421G() && this.f15731a == null) {
            if (this.f15740j <= 0) {
                this.f15737g.mo24627f(true);
                mo24499E();
            } else {
                if (this.f15740j >= this.f15736f.mo24429i() / 1000) {
                    this.f15737g.mo24627f(false);
                } else {
                    this.f15737g.mo24627f(true);
                    m17425d(this.f15740j);
                }
            }
        }
        ListenerT listenert = this.f15741k;
        if (listenert != null && !this.f15733c) {
            this.f15733c = true;
            listenert.mo24554f();
        }
        this.f15751u = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo24488t() {
        mo24494z();
        this.f15737g.mo24634h(false);
        this.f15737g.mo24635i(false);
        mo24453p();
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public final void mo24496B() {
        if (!this.f15737g.mo24629g()) {
            this.f15737g.mo24634h(false);
            mo24494z();
            this.f15737g.mo24635i(false);
            mo24453p();
            this.f15733c = false;
            this.f15742l = true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo24449l() {
        this.f15737g.mo24635i(true);
        ListenerT listenert = this.f15741k;
        if (listenert != null) {
            listenert.mo24558j();
        }
    }

    /* renamed from: a */
    private void m17423a(int i, int i2) {
        Bitmap bitmap = this.f15746p;
        if (!(bitmap != null && bitmap.getWidth() == i && this.f15746p.getHeight() == i2) && i2 > 0 && i > 0) {
            AsyncTask<?, ?, ?> asyncTask = this.f15747q;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            this.f15746p = null;
            this.f15747q = new AsyncTask<Integer, Void, Bitmap>() {
                /* access modifiers changed from: protected */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    Integer[] numArr = (Integer[]) objArr;
                    return C7814i.m17422a(C7814i.this, numArr[0].intValue(), numArr[1].intValue());
                }

                /* access modifiers changed from: protected */
                public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
                    Bitmap bitmap = (Bitmap) obj;
                    super.onPostExecute(bitmap);
                    C7814i iVar = C7814i.this;
                    iVar.f15746p = bitmap;
                    iVar.f15747q = null;
                }
            };
            C8006j.m18070a(this.f15747q, (P[]) new Integer[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @TargetApi(14)
    /* renamed from: b */
    public final Bitmap mo24436b(boolean z) {
        if (this.f15746p == null) {
            return null;
        }
        if (this.f15751u) {
            return this.f15734d.f15514e;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("Save snapshot entered: tv = ");
        sb.append(this.f15738h);
        sb.append(" avail = ");
        TextureView textureView = this.f15738h;
        sb.append(textureView != null && textureView.isAvailable());
        IAlog.m18021b(sb.toString());
        TextureView textureView2 = this.f15738h;
        if (textureView2 != null && textureView2.isAvailable()) {
            try {
                StringBuilder sb2 = new StringBuilder("creating bitmap on object - ");
                sb2.append(this.f15746p);
                IAlog.m18019a(sb2.toString());
                Bitmap bitmap = this.f15738h.getBitmap(this.f15746p);
                if (this.f15737g.getVideoWidth() > 0 && this.f15737g.getVideoHeight() > 0) {
                    this.f15746p = null;
                    m17423a(this.f15737g.getVideoWidth(), this.f15737g.getVideoHeight());
                }
                if (z) {
                    C7995b bVar = new C7995b();
                    bVar.f16322c = 20;
                    bVar.f16323d = 1;
                    bVar.f16320a = bitmap.getWidth();
                    bVar.f16321b = bitmap.getHeight();
                    this.f15734d.mo24325a(C7985a.m18027a(this.f15737g.getContext(), bitmap, bVar));
                    this.f15751u = true;
                } else {
                    this.f15734d.mo24325a(bitmap);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(IAlog.m18018a((Object) this));
                sb3.append("save snapshot succeeded");
                IAlog.m18019a(sb3.toString());
                return this.f15734d.f15514e;
            } catch (Exception e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(IAlog.m18018a((Object) this));
                sb4.append("save snapshot failed with exception");
                IAlog.m18019a(sb4.toString());
            }
        }
        return null;
    }

    /* renamed from: b_ */
    public void mo24438b_() {
        C7799e eVar = this.f15736f;
        if (eVar != null && eVar.mo24460l() != C7838b.Paused) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("pauseVideo ");
            sb.append(this.f15737g);
            IAlog.m18021b(sb.toString());
            this.f15736f.mo24423c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public void mo24453p() {
        if (this.f15736f.mo24460l().equals(C7838b.Completed)) {
            View g = this.f15734d.mo24340g();
            C7864i iVar = this.f15737g;
            iVar.mo24627f(false);
            iVar.mo24621b(false);
            iVar.mo24623d(false);
            iVar.mo24625e(false);
            iVar.mo24622c(false);
            ImageView imageView = iVar.f15890r;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            if (g != null) {
                if (g instanceof C7927c) {
                    C7796c h = this.f15734d.mo24341h();
                    h.f15688a.setListener(new C7946h() {
                        /* renamed from: a */
                        public final boolean mo24521a(String str) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(IAlog.m18018a((Object) C7814i.this));
                            sb.append("web view callback: onClicked");
                            IAlog.m18021b(sb.toString());
                            ListenerT listenert = C7814i.this.f15741k;
                            if (listenert != null) {
                                return listenert.mo24553b(str);
                            }
                            return false;
                        }

                        /* renamed from: b */
                        public final boolean mo24523b(String str) {
                            View endCardView = C7814i.this.f15737g.getEndCardView();
                            ListenerT listenert = C7814i.this.f15741k;
                            if (listenert == null) {
                                return false;
                            }
                            listenert.mo24551a(endCardView, str);
                            return true;
                        }

                        /* renamed from: a */
                        public final void mo24519a(AdDisplayError adDisplayError) {
                            ListenerT listenert = C7814i.this.f15741k;
                            if (listenert != null) {
                                listenert.mo24558j();
                            }
                        }

                        /* renamed from: c_ */
                        public final void mo24524c_() {
                            ListenerT listenert = C7814i.this.f15741k;
                            if (listenert != null) {
                                listenert.mo24559k();
                            }
                        }

                        /* renamed from: b */
                        public final void mo24522b() {
                            ListenerT listenert = C7814i.this.f15741k;
                            if (listenert != null) {
                                listenert.mo24559k();
                            }
                        }

                        /* renamed from: d_ */
                        public final void mo24525d_() {
                            ListenerT listenert = C7814i.this.f15741k;
                            if (listenert != null) {
                                listenert.mo24556h();
                            }
                        }

                        /* renamed from: a */
                        public final void mo24520a(boolean z) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(IAlog.m18018a((Object) C7814i.this));
                            sb.append("onCustomCloseButtonAvailableenabled : ");
                            sb.append(z);
                            IAlog.m18021b(sb.toString());
                            ListenerT listenert = C7814i.this.f15741k;
                            if (listenert != null && z) {
                                listenert.mo24560l();
                            }
                        }
                    });
                    C7796c h2 = this.f15734d.mo24341h();
                    h2.f15688a.a(!C8033v.m18119a(h2.f15689b));
                    if (!this.f15734d.mo24341h().f15688a.n()) {
                        this.f15734d.mo24341h().f15688a.b(true);
                    } else {
                        return;
                    }
                }
                mo24489u();
                this.f15737g.mo24619a(false);
                this.f15737g.mo24628g(false);
                this.f15737g.mo24617a(g);
                this.f15734d.mo24342i();
                g.requestFocus();
                return;
            }
            if (this.f15738h != null) {
                Bitmap b = mo24436b(true);
                if (b != null) {
                    this.f15737g.setLastFrameBitmap(b);
                }
            } else {
                Bitmap bitmap = this.f15734d.f15514e;
                if (bitmap != null) {
                    this.f15737g.setLastFrameBitmap(bitmap);
                }
            }
            this.f15737g.mo24619a(true);
            this.f15737g.mo24620a(true, this.f15749s);
            this.f15737g.mo24628g(false);
            return;
        }
        this.f15737g.mo24628g(true);
    }

    /* renamed from: a */
    public final void mo24329a(C7838b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("onPlayerStateChanged with ");
        sb.append(bVar);
        IAlog.m18021b(sb.toString());
        m17424a(bVar, true);
    }

    /* renamed from: a */
    private void m17424a(C7838b bVar, boolean z) {
        switch (C78216.f15758a[bVar.ordinal()]) {
            case 1:
                this.f15737g.mo24619a(true);
                this.f15737g.mo24635i(false);
                mo24453p();
                mo24491w();
                return;
            case 2:
                this.f15737g.mo24634h(true);
                this.f15737g.mo24628g(false);
                Runnable runnable = this.f15743m;
                if (runnable == null) {
                    if (runnable == null) {
                        this.f15743m = new Runnable() {
                            public final void run() {
                                C7814i iVar = C7814i.this;
                                iVar.f15743m = null;
                                iVar.mo24447j();
                            }
                        };
                    }
                    int i = mo24446i();
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18018a((Object) this));
                    sb.append(" Starting bufering timeout with ");
                    sb.append(i);
                    IAlog.m18021b(sb.toString());
                    this.f15737g.postDelayed(this.f15743m, (long) i);
                }
                return;
            case 3:
                mo24448k();
                return;
            case 4:
                mo24488t();
                return;
            case 5:
                mo24496B();
                if (z) {
                    ListenerT listenert = this.f15741k;
                    if (listenert != null) {
                        listenert.mo24557i();
                        return;
                    }
                }
                break;
            case 6:
            case 7:
                mo24449l();
                break;
        }
    }

    /* renamed from: a */
    public final void mo24330a(Exception exc) {
    }

    /* renamed from: q */
    public final void mo24467q() {
        if (!this.f15750t) {
            this.f15750t = true;
            this.f15737g.mo24619a(false);
        }
    }

    /* renamed from: a */
    public final void mo24323a(int i) {
        float F = m17420F();
        if (this.f15736f.mo24461m()) {
            float f = this.f15732b;
            if (F != f) {
                if (F > 0.0f && f >= 0.0f && mo24497C()) {
                    mo24503g(true);
                } else if (F == 0.0f && !mo24497C()) {
                    mo24502f(true);
                }
            }
            mo24498D();
        }
        this.f15732b = F;
        int i2 = this.f15736f.mo24429i();
        int h = this.f15736f.mo24428h();
        int i3 = h / 1000;
        int i4 = i2 / 1000;
        int i5 = i4 - i3;
        if (i5 < 0 || (!this.f15736f.mo24461m() && h == i2)) {
            i5 = 0;
        }
        C7864i iVar = this.f15737g;
        if (iVar.f15883k != null || iVar.f15891s != null) {
            this.f15737g.setRemainingTime(Integer.toString(i5));
            if (this.f15740j >= i4) {
                this.f15737g.mo24627f(false);
            } else if (!mo24443f() || !m17421G()) {
                this.f15737g.mo24627f(false);
            } else {
                int i6 = this.f15740j;
                if (i3 < i6) {
                    m17425d(i6 - i3);
                } else {
                    this.f15740j = 0;
                    mo24499E();
                }
                this.f15737g.mo24627f(true);
            }
            if (this.f15736f.mo24460l() != C7838b.Paused) {
                C7864i iVar2 = this.f15737g;
                if (iVar2.f15891s != null) {
                    Runnable runnable = iVar2.f15876D;
                    if (runnable != null) {
                        iVar2.removeCallbacks(runnable);
                        iVar2.f15876D = null;
                    }
                    int i7 = i4 * 1000;
                    iVar2.f15891s.setMax(i7);
                    int i8 = i7 - (i5 * 1000);
                    iVar2.f15875C = i8 + 1000;
                    int i9 = i8 + 200;
                    int i10 = iVar2.f15875C;
                    if (i10 > 0 && i10 <= i7) {
                        int i11 = iVar2.f15874B;
                        if (i9 >= i11 || i11 <= 0) {
                            iVar2.f15874B = i9;
                            iVar2.f15891s.setProgress(iVar2.f15874B);
                            iVar2.f15876D = new Runnable() {
                                public final void run() {
                                    C7864i iVar = C7864i.this;
                                    iVar.f15874B = iVar.f15874B + 200;
                                    C7864i iVar2 = C7864i.this;
                                    iVar2.f15891s.setProgress(iVar2.f15874B);
                                    if (C7864i.this.f15874B == C7864i.this.f15875C) {
                                        C7864i.this.f15876D = null;
                                        C7864i.this.f15874B = 0;
                                        C7864i.this.f15875C = 0;
                                        return;
                                    }
                                    C7864i iVar3 = C7864i.this;
                                    iVar3.postDelayed(iVar3.f15876D, 200);
                                }
                            };
                            iVar2.postDelayed(iVar2.f15876D, 200);
                        } else {
                            iVar2.f15891s.setProgress(i10);
                        }
                    }
                }
            }
            ListenerT listenert = this.f15741k;
            if (listenert != null) {
                listenert.mo24550a(i2, h);
            }
        }
    }

    /* renamed from: m */
    public void mo24450m() {
    }

    /* renamed from: r */
    public void mo24486r() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("onVideoViewDetachedFromWindow");
        IAlog.m18021b(sb.toString());
        mo24489u();
    }

    /* renamed from: c */
    public void mo24441c(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("got onVisibilityChanged with: ");
        sb.append(z);
        IAlog.m18021b(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(IAlog.m18018a((Object) this));
        sb2.append("onVisibilityChanged: my video view is");
        sb2.append(this.f15737g);
        IAlog.m18021b(sb2.toString());
        if (z) {
            this.f15736f.mo24456a((C7805b) this);
            C7838b l = this.f15736f.mo24460l();
            if (l.equals(C7838b.Completed)) {
                mo24496B();
            } else if (l.equals(C7838b.Error) || (l.equals(C7838b.Idle) && !this.f15734d.mo24348o())) {
                mo24449l();
            } else {
                this.f15734d.mo24338e();
                mo24442e();
                if (this.f15744n == null && VERSION.SDK_INT >= 14) {
                    Application A = mo24483A();
                    if (A != null) {
                        this.f15744n = new ActivityLifecycleCallbacks() {
                            public final void onActivityCreated(Activity activity, Bundle bundle) {
                            }

                            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            public final void onActivityDestroyed(Activity activity) {
                            }

                            public final void onActivityResumed(Activity activity) {
                                if (activity.equals(C7814i.this.f15737g.getContext())) {
                                    C7814i.this.f15737g.mo24604c();
                                    C7814i iVar = C7814i.this;
                                    iVar.mo24441c(iVar.f15737g.mo24603b());
                                }
                            }

                            public final void onActivityStarted(Activity activity) {
                            }

                            public final void onActivityStopped(Activity activity) {
                            }

                            public final void onActivityPaused(Activity activity) {
                                if (activity.equals(C7814i.this.f15737g.getContext())) {
                                    C7814i.this.mo24441c(false);
                                }
                            }
                        };
                        A.registerActivityLifecycleCallbacks(this.f15744n);
                    }
                }
            }
        } else {
            SurfaceTexture surfaceTexture = this.f15736f.f15704h;
            if (surfaceTexture != null) {
                TextureView textureView = this.f15738h;
                if (textureView != null && surfaceTexture.equals(textureView.getSurfaceTexture())) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(IAlog.m18018a((Object) this));
                    sb3.append("onVisibilityChanged pausing video and releasing texture");
                    IAlog.m18021b(sb3.toString());
                    mo24438b_();
                }
            }
            mo24489u();
            this.f15736f.mo24459b((C7805b) this);
        }
    }

    /* renamed from: A */
    private Application mo24483A() {
        C7864i iVar = this.f15737g;
        if (iVar == null || iVar.getContext() == null) {
            return null;
        }
        return (Application) this.f15737g.getContext().getApplicationContext();
    }

    /* renamed from: c */
    public final void mo24500c(int i) {
        StringBuilder sb = new StringBuilder("onClicked called with ");
        sb.append(i);
        IAlog.m18021b(sb.toString());
        switch (i) {
            case 1:
                if (mo24497C()) {
                    mo24503g(true);
                    this.f15734d.mo24332a(C7916a.EVENT_UNMUTE);
                    mo24501e(false);
                } else {
                    mo24502f(true);
                    this.f15734d.mo24332a(C7916a.EVENT_MUTE);
                    mo24501e(true);
                }
                mo24498D();
                return;
            case 2:
                mo24445h();
                return;
            case 3:
                mo24490v();
                return;
            case 4:
                C7910l m = this.f15734d.mo24346m();
                String str = null;
                if (m != null && TextUtils.equals(m.f16054c, VastResourceXmlManager.STATIC_RESOURCE)) {
                    str = m.f16057f;
                }
                ListenerT listenert = this.f15741k;
                if (listenert != null) {
                    listenert.mo24553b(str);
                }
                return;
            case 5:
                mo24452o();
                return;
            case 6:
                if (this.f15741k != null && (this.f15740j <= 0 || this.f15736f.mo24460l().equals(C7838b.Completed))) {
                    this.f15741k.mo24556h();
                }
                return;
            case 7:
                mo24451n();
                break;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo24501e(boolean z) {
        this.f15734d.mo24331a(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo24452o() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public boolean mo24490v() {
        ListenerT listenert = this.f15741k;
        if (listenert == null || !listenert.mo24555g()) {
            return false;
        }
        C7746a aVar = this.f15734d;
        if (aVar != null) {
            aVar.mo24332a(C7916a.EVENT_CLICK);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo24451n() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo24445h() {
        this.f15737g.mo24627f(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public final boolean mo24497C() {
        C7799e eVar = this.f15736f;
        if (eVar == null) {
            return false;
        }
        if (!eVar.mo24422b() && m17420F() != 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo24502f(boolean z) {
        C7799e eVar = this.f15736f;
        if (eVar != null) {
            eVar.mo24420a(z);
        }
        this.f15737g.setMuteButtonState(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final void mo24503g(boolean z) {
        C7799e eVar = this.f15736f;
        if (eVar != null) {
            eVar.mo24421b(z);
        }
        this.f15737g.setMuteButtonState(false);
    }

    /* renamed from: d */
    private void m17425d(int i) {
        C7864i iVar = this.f15737g;
        if (iVar != null) {
            iVar.setSkipText(iVar.getContext().getString(C12719d.ia_video_before_skip_format, new Object[]{Integer.valueOf(i)}));
        }
    }

    /* renamed from: F */
    private float m17420F() {
        return (float) ((AudioManager) this.f15737g.getContext().getSystemService("audio")).getStreamVolume(3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public final void mo24498D() {
        C7864i iVar = this.f15737g;
        if (iVar.f15889q != null) {
            iVar.setMuteButtonState(mo24497C());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public final void mo24499E() {
        if (mo24443f()) {
            C7864i iVar = this.f15737g;
            iVar.setSkipText(iVar.getContext().getString(C12719d.ia_video_skip_text));
            this.f15737g.mo24626f();
            this.f15740j = 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo24442e() {
        if (!mo24492x()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("createTextureView");
        IAlog.m18021b(sb.toString());
        if (this.f15738h == null) {
            C7864i iVar = this.f15737g;
            C7868a aVar = new C7868a(iVar.getContext());
            aVar.setParent(iVar);
            this.f15738h = aVar;
            this.f15738h.setId(C12717b.inn_texture_view);
            this.f15739i = new SurfaceTextureListener() {
                public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18018a((Object) C7814i.this));
                    sb.append("onSurfaceTextureAvailable");
                    IAlog.m18021b(sb.toString());
                    C7814i iVar = C7814i.this;
                    iVar.f15736f.mo24454a(iVar.f15738h);
                }

                public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18018a((Object) C7814i.this));
                    sb.append("onSurfaceTextureDestroyed");
                    IAlog.m18021b(sb.toString());
                    C7814i.this.f15737g.post(new Runnable() {
                        public final void run() {
                            C7814i.this.mo24489u();
                        }
                    });
                    return false;
                }

                public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    C7799e eVar = C7814i.this.f15736f;
                    eVar.f15705i = true;
                    eVar.f15702f.post(new Runnable() {
                        public final void run() {
                            try {
                                if (C7799e.this.f15698b != null) {
                                    for (C7805b q : C7799e.this.f15698b) {
                                        q.mo24467q();
                                    }
                                }
                            } catch (Exception e) {
                                if (IAlog.f16291a <= 3) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(IAlog.m18018a((Object) C7799e.this));
                                    sb.append("onDrawnToSurface callback threw an exception!");
                                    IAlog.m18021b(sb.toString());
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
            };
            this.f15738h.setSurfaceTextureListener(this.f15739i);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(IAlog.m18018a((Object) this));
        sb2.append("connectToTextureView");
        IAlog.m18021b(sb2.toString());
        if (this.f15738h != null) {
            SurfaceTexture surfaceTexture = this.f15736f.f15704h;
            if (surfaceTexture != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(IAlog.m18018a((Object) this));
                sb3.append("updateView setting existing texture");
                IAlog.m18021b(sb3.toString());
                this.f15738h.setSurfaceTexture(surfaceTexture);
                this.f15736f.mo24454a(this.f15738h);
                this.f15737g.mo24619a(false);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(IAlog.m18018a((Object) this));
                sb4.append("did not find existing texture");
                IAlog.m18021b(sb4.toString());
            }
            TextureView textureView = this.f15738h;
            if (textureView != null && textureView.getParent() == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(IAlog.m18018a((Object) this));
                sb5.append("updateView adding texture to parent");
                IAlog.m18021b(sb5.toString());
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, 0, 0);
                layoutParams.gravity = 17;
                this.f15737g.getTextureHost().addView(this.f15738h, layoutParams);
            }
            this.f15750t = false;
        }
        this.f15734d.mo24326a((View) this.f15737g);
        return true;
    }

    /* renamed from: d */
    public final void mo24440d() {
        C7864i iVar = this.f15737g;
        if (iVar != null) {
            iVar.mo24614d();
        }
        TextureView textureView = this.f15738h;
        if (textureView != null) {
            textureView.invalidate();
            this.f15738h.requestLayout();
        }
        C7864i iVar2 = this.f15737g;
        if (iVar2 != null) {
            iVar2.invalidate();
            this.f15737g.requestLayout();
        }
    }

    /* renamed from: a */
    public final void mo24433a(Bitmap bitmap) {
        if (this.f15734d.mo24337d().mo24460l() != C7838b.Completed) {
            this.f15737g.mo24634h(true);
            this.f15737g.mo24619a(true);
            this.f15737g.setLastFrameBitmap(bitmap);
        }
    }

    /* renamed from: G */
    private boolean m17421G() {
        if (this.f15740j > 0) {
            boolean z = this.f15742l;
            if (!z && !z && this.f15736f.mo24429i() <= 15000) {
                return false;
            }
            return true;
        }
        return true;
    }
}
