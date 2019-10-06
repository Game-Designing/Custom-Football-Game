package com.fyber.inneractive.sdk.p166g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.p164e.C7721a;
import com.fyber.inneractive.sdk.p164e.C7721a.C7722a;
import com.fyber.inneractive.sdk.p166g.p167a.C7756a;
import com.fyber.inneractive.sdk.p166g.p167a.C7759c.C7762a;
import com.fyber.inneractive.sdk.p166g.p167a.C7771e;
import com.fyber.inneractive.sdk.p166g.p167a.C7771e.C7779c;
import com.fyber.inneractive.sdk.p166g.p167a.C7771e.C7781e;
import com.fyber.inneractive.sdk.p166g.p167a.C7790l;
import com.fyber.inneractive.sdk.p166g.p168b.C7794a;
import com.fyber.inneractive.sdk.p166g.p168b.C7796c;
import com.fyber.inneractive.sdk.p166g.p168b.C7799e;
import com.fyber.inneractive.sdk.p166g.p168b.C7799e.C7804a;
import com.fyber.inneractive.sdk.p166g.p168b.C7799e.C7805b;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.p174i.C7899a;
import com.fyber.inneractive.sdk.p174i.C7910l;
import com.fyber.inneractive.sdk.p174i.C7915o.C7916a;
import com.fyber.inneractive.sdk.p179l.C7927c;
import com.fyber.inneractive.sdk.util.C7997d;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.C8012l;
import com.fyber.inneractive.sdk.util.C8012l.C8013a;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

/* renamed from: com.fyber.inneractive.sdk.g.a */
public abstract class C7746a implements C7804a, C7805b {

    /* renamed from: a */
    protected Context f15510a;

    /* renamed from: b */
    protected C7754b f15511b;

    /* renamed from: c */
    protected C7799e f15512c;

    /* renamed from: d */
    protected String f15513d;

    /* renamed from: e */
    public Bitmap f15514e;

    /* renamed from: f */
    C8012l f15515f;

    /* renamed from: g */
    C8013a f15516g;

    /* renamed from: h */
    protected Object f15517h;

    /* renamed from: i */
    protected Object f15518i;

    /* renamed from: j */
    protected View f15519j;

    /* renamed from: k */
    C7756a f15520k = null;

    /* renamed from: l */
    protected int f15521l = 0;

    /* renamed from: m */
    private final Set<Vendor> f15522m;

    /* renamed from: n */
    private Handler f15523n;

    /* renamed from: o */
    private Runnable f15524o;

    /* renamed from: p */
    private int f15525p;

    /* renamed from: q */
    private boolean f15526q = false;

    /* renamed from: r */
    private boolean f15527r = false;

    /* renamed from: s */
    private boolean f15528s = false;

    /* renamed from: t */
    private boolean f15529t = false;

    /* renamed from: u */
    private boolean f15530u = false;

    /* renamed from: v */
    private C7771e f15531v;

    /* renamed from: w */
    private C7755c f15532w;

    /* renamed from: x */
    private boolean f15533x = false;

    /* renamed from: com.fyber.inneractive.sdk.g.a$6 */
    static /* synthetic */ class C77526 {

        /* renamed from: a */
        static final /* synthetic */ int[] f15542a = new int[C7838b.values().length];

        static {
            try {
                f15542a[C7838b.Prepared.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15542a[C7838b.Buffering.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15542a[C7838b.Playing.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15542a[C7838b.Paused.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15542a[C7838b.Completed.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a$a */
    public enum C7753a {
        ERROR_NO_MEDIA_FILES("ErrorNoMediaFiles", true),
        ERROR_FAILED_PLAYING_MEDIA_FILE("ErrorPlayingMediaFile", false),
        ERROR_FAILED_PLAYING_ALL_MEDIA_FILES("ErrorPlayingAllMediaFile", true),
        ERROR_PRE_BUFFER_TIMEOUT("ErrorPreBufferTimeout", false),
        ERROR_BUFFER_TIMEOUT("ErrorBufferTimeout", false);
        

        /* renamed from: f */
        public String f15549f;

        /* renamed from: g */
        public boolean f15550g;

        /* renamed from: h */
        public String f15551h;

        private C7753a(String str, boolean z) {
            this.f15549f = str;
            this.f15550g = z;
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a$b */
    public interface C7754b {
        /* renamed from: a */
        void mo24110a();

        /* renamed from: a */
        void mo24111a(C7753a aVar);

        /* renamed from: b */
        void mo24112b();

        /* renamed from: c */
        C7722a mo24113c();
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a$c */
    public interface C7755c {
        /* renamed from: a */
        void mo24356a();

        /* renamed from: a */
        void mo24357a(Bitmap bitmap);

        /* renamed from: a */
        void mo24358a(C7746a aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo24324a(int i, int i2);

    /* renamed from: a */
    public abstract void mo24332a(C7916a... aVarArr);

    /* renamed from: f */
    public abstract C7899a mo24339f();

    /* renamed from: g */
    public abstract View mo24340g();

    /* renamed from: h */
    public abstract C7796c mo24341h();

    /* renamed from: i */
    public abstract void mo24342i();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract void mo24343j();

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public abstract void mo24344k();

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public abstract C7722a mo24345l();

    protected C7746a(Context context, Set<Vendor> set) {
        this.f15522m = set;
        this.f15510a = context;
        m17178v();
        this.f15523n = new Handler(context.getMainLooper());
    }

    /* renamed from: a */
    public final boolean mo24333a(C7754b bVar) {
        this.f15511b = bVar;
        IAlog.m18021b("IAMediaPlayerFlowManager: start");
        this.f15526q = false;
        this.f15527r = false;
        if (m17176t()) {
            return true;
        }
        mo24327a(C7753a.ERROR_NO_MEDIA_FILES);
        return false;
    }

    /* renamed from: a */
    public final void mo24322a() {
        this.f15533x = true;
        if (EnumSet.of(C7838b.Idle, C7838b.Error, C7838b.Seeking).contains(this.f15512c.mo24460l())) {
            C7790l.m17292a();
            this.f15512c.mo24419a(C7790l.m17294a(this.f15520k));
            m17173b((C8005i.m18064m() ? IAConfigManager.m17001o() : IAConfigManager.m17002p()) * 1000);
        }
    }

    /* renamed from: b */
    public void mo24334b() {
        IAlog.m18021b("IAMediaPlayerFlowManager: destroy");
        View g = mo24340g();
        if (g != null && (g instanceof C7927c)) {
            ((C7927c) g).destroy();
        }
        m17179w();
        m17177u();
        C7799e eVar = this.f15512c;
        if (eVar != null) {
            eVar.mo24416a();
            this.f15512c = null;
        }
        this.f15514e = null;
        if (m17175s() && m17172a(Vendor.MOAT) && m17175s()) {
            C7721a.m17105a(this.f15518i);
            this.f15518i = null;
            this.f15517h = null;
        }
        C7771e eVar2 = this.f15531v;
        if (eVar2 != null) {
            eVar2.mo24396c();
            C7790l.m17292a().mo24412b(this.f15531v.mo24397d());
        }
        this.f15511b = null;
        this.f15523n.removeCallbacksAndMessages(null);
        this.f15511b = null;
        this.f15529t = true;
    }

    /* renamed from: a */
    public final void mo24326a(View view) {
        if (!(!m17172a(Vendor.MOAT) || this.f15517h == null || this.f15518i == null || view == null || view.equals(this.f15519j))) {
            C7721a.m17106a(this.f15518i, view);
        }
        this.f15519j = view;
    }

    /* renamed from: c */
    public final void mo24336c() {
        if (this.f15512c != null) {
            if (this.f15517h == null) {
                if (m17172a(Vendor.MOAT) && this.f15517h == null) {
                    this.f15517h = C7721a.m17100a();
                }
                if (m17172a(Vendor.MOAT) && this.f15517h != null) {
                    C7722a l = mo24345l();
                    if (l != null && m17172a(Vendor.MOAT) && this.f15518i == null) {
                        C7799e eVar = this.f15512c;
                        if (eVar != null) {
                            this.f15518i = C7721a.m17102a(this.f15517h, l, eVar.mo24431k(), this.f15519j);
                        }
                    }
                }
            }
            if (this.f15520k == null || this.f15528s) {
                C7799e eVar2 = this.f15512c;
                C7838b l2 = eVar2.mo24460l();
                if (l2 == C7838b.Completed || l2 == C7838b.Prepared) {
                    eVar2.mo24426f();
                    return;
                }
                eVar2.mo24427g();
            } else {
                C7755c cVar = this.f15532w;
                if (cVar != null) {
                    Bitmap bitmap = this.f15514e;
                    if (bitmap != null) {
                        cVar.mo24357a(bitmap);
                    }
                }
                if (!(this.f15512c.mo24460l() == C7838b.Preparing || this.f15512c.mo24460l() == C7838b.Prepared)) {
                    C7790l.m17292a();
                    this.f15512c.mo24419a(C7790l.m17294a(this.f15520k));
                    m17173b((C8005i.m18064m() ? IAConfigManager.m17001o() : IAConfigManager.m17002p()) * 1000);
                }
            }
        }
    }

    /* renamed from: d */
    public final C7799e mo24337d() {
        return this.f15512c;
    }

    /* renamed from: a */
    public final void mo24325a(Bitmap bitmap) {
        StringBuilder sb = new StringBuilder("IAMediaPlayerFlowManager: saving snapshot ");
        sb.append(bitmap);
        IAlog.m18021b(sb.toString());
        this.f15514e = null;
        this.f15514e = bitmap;
    }

    /* renamed from: e */
    public final void mo24338e() {
        if (!this.f15530u) {
            mo24344k();
            this.f15530u = true;
        }
    }

    /* renamed from: a */
    public void mo24329a(C7838b bVar) {
        StringBuilder sb = new StringBuilder("IAMediaPlayerFlowManager: onPlayerStateChanged with - ");
        sb.append(bVar);
        IAlog.m18021b(sb.toString());
        int i = C77526.f15542a[bVar.ordinal()];
        if (i == 1) {
            mo24335b(false);
            m17177u();
        } else if (i == 2) {
            if (this.f15524o == null) {
                C8005i.m18064m();
                m17173b(IAConfigManager.m17003q() * 1000);
            }
        } else if (i == 3) {
            this.f15525p = this.f15512c.mo24428h();
            m17177u();
        } else if (i != 4) {
            if (i == 5) {
                m17177u();
                if (m17174r()) {
                    this.f15519j.post(new Runnable() {
                        public final void run() {
                            C7721a.m17108b(C7746a.this.f15518i);
                        }
                    });
                }
            }
        } else {
            m17177u();
        }
    }

    /* renamed from: a */
    public final void mo24330a(Exception exc) {
        StringBuilder sb = new StringBuilder("IMediaPlayerFlowManager: onPlayerError called with: ");
        sb.append(exc != null ? exc.getMessage() : "no exception");
        IAlog.m18021b(sb.toString());
        mo24327a(C7753a.ERROR_FAILED_PLAYING_MEDIA_FILE);
        if (this.f15528s || !(this.f15520k == null || this.f15512c.mo24460l() == C7838b.Preparing || this.f15512c.mo24460l() == C7838b.Prepared)) {
            if (this.f15520k != null) {
                C7755c cVar = this.f15532w;
                if (cVar != null) {
                    cVar.mo24358a(this);
                    return;
                }
            } else {
                IAlog.m18021b("IMediaPlayerFlowManager: onPlayerError video was prepared. This is a critical error. Aborting!");
                mo24327a(C7753a.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES);
            }
            return;
        }
        mo24343j();
        if (!m17176t()) {
            IAlog.m18021b("IMediaPlayerFlowManager: onPlayerError - no more media files available. Aborting!");
            mo24327a(C7753a.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES);
        }
    }

    /* renamed from: a */
    public void mo24323a(int i) {
        if (!this.f15526q) {
            C7799e eVar = this.f15512c;
            if (eVar != null) {
                eVar.mo24429i();
                int h = this.f15512c.mo24428h();
                StringBuilder sb = new StringBuilder("IAMediaPlayerFlowManager: onPlayerProgress: 2 seconds passed? played for ");
                sb.append(h - this.f15525p);
                sb.append(" since last play started");
                IAlog.m18021b(sb.toString());
                if (h - this.f15525p >= 2000) {
                    IAlog.m18021b("IAMediaPlayerFlowManager: onPlayerProgress: setting played 2 seconds flag");
                    this.f15526q = true;
                    C7754b bVar = this.f15511b;
                    if (bVar != null) {
                        bVar.mo24112b();
                    }
                }
            }
        }
    }

    /* renamed from: r */
    private final boolean m17174r() {
        return m17172a(Vendor.MOAT) && m17175s() && this.f15519j != null;
    }

    /* renamed from: a */
    public final void mo24331a(final boolean z) {
        if (m17174r()) {
            this.f15519j.post(new Runnable() {
                public final void run() {
                    C7721a.m17107a(C7746a.this.f15518i, z);
                }
            });
        }
    }

    /* renamed from: s */
    private boolean m17175s() {
        return this.f15518i != null;
    }

    /* renamed from: m */
    public C7910l mo24346m() {
        return null;
    }

    /* renamed from: t */
    private boolean m17176t() {
        C7899a f = mo24339f();
        String str = "IAMediaPlayerFlowManager: playNextMediaFile - getNextIAMediaFile did not return a valid url";
        if (f == null) {
            IAlog.m18021b(str);
            return false;
        }
        final String str2 = f.f15980a;
        if (TextUtils.isEmpty(str2)) {
            IAlog.m18021b(str);
            return false;
        }
        this.f15528s = false;
        this.f15526q = false;
        this.f15525p = 0;
        this.f15530u = false;
        this.f15513d = str2;
        StringBuilder sb = new StringBuilder("IAMediaPlayerFlowManager: playNextMediaFile - loading video url: ");
        sb.append(str2);
        IAlog.m18021b(sb.toString());
        String str3 = f.f15988i;
        if (str3 == null || str3.compareToIgnoreCase("VPAID") != 0) {
            C8012l lVar = this.f15515f;
            if (lVar != null) {
                lVar.mo24847a();
                this.f15516g = null;
            }
            if (this.f15516g == null) {
                this.f15516g = new C8013a() {
                    /* renamed from: a */
                    public final void mo24355a(Bitmap bitmap) {
                        C7746a aVar = C7746a.this;
                        if (aVar.f15516g != null) {
                            aVar.mo24325a(bitmap);
                            C7746a aVar2 = C7746a.this;
                            aVar2.f15515f = null;
                            aVar2.f15516g = null;
                        }
                        IAlog.m18021b("MediaPlayerController: fetching video frame success!");
                    }

                    /* renamed from: a */
                    public final void mo24354a() {
                        C7746a aVar = C7746a.this;
                        if (aVar.f15516g != null) {
                            aVar.mo24325a((Bitmap) null);
                            C7746a aVar2 = C7746a.this;
                            aVar2.f15515f = null;
                            aVar2.f15516g = null;
                        }
                        IAlog.m18021b("MediaPlayerController: fetching video frame failed!");
                    }
                };
            }
            if (C7790l.m17292a().mo24413b()) {
                final C7997d dVar = new C7997d();
                C7790l a = C7790l.m17292a();
                C7771e a2 = C7771e.m17266a(a.f15671b, str2, new C7781e() {
                    /* renamed from: a */
                    public final void mo24352a(C7756a aVar, Exception exc) {
                        if (exc == null) {
                            Bitmap bitmap = dVar.f16327a;
                            if (bitmap != null) {
                                IAlog.m18021b("IAMediaPlayerFlowManager: got video first frame");
                                C7746a.this.mo24325a(bitmap);
                                C7746a aVar2 = C7746a.this;
                                aVar2.f15515f = null;
                                aVar2.f15516g = null;
                            }
                            C7746a aVar3 = C7746a.this;
                            aVar3.f15520k = aVar;
                            aVar3.mo24335b(true);
                        } else if (exc instanceof C7779c) {
                            C7746a.this.m17171a(str2);
                        } else {
                            C7746a.this.mo24330a(exc);
                        }
                    }
                });
                a.f15673d.add(a2.mo24397d());
                this.f15531v = a2;
                C7771e eVar = this.f15531v;
                eVar.f15629n = dVar;
                eVar.f15628m = true;
                eVar.f15623h.post(new Runnable() {
                    public final void run() {
                        try {
                            C7771e.this.f15618c = C7771e.this.f15617b.mo24365a(C7771e.this.mo24397d());
                            if (C7771e.this.f15618c == null) {
                                C7762a c = C7771e.this.f15617b.mo24368c(C7771e.this.mo24397d());
                                if (c == null) {
                                    C7771e.this.f15626k = true;
                                }
                                if (c != null) {
                                    IAlog.m18019a(String.format("%s | start | got an editor for %s", new Object[]{C7771e.this.f15616a, C7771e.this.mo24397d()}));
                                    c.mo24376b();
                                }
                            }
                        } catch (IOException e) {
                            C7771e eVar = C7771e.this;
                            IAlog.m18020a(String.format("%s | Exception raised starting a new caching process for %s", new Object[]{eVar.f15616a, eVar.mo24397d()}), e);
                        }
                        C7771e eVar2 = C7771e.this;
                        if (eVar2.f15618c != null || eVar2.f15626k) {
                            C7771e.m17268a(C7771e.this, true);
                        } else {
                            eVar2.f15622g.start();
                        }
                    }
                });
            } else {
                m17171a(str2);
            }
            mo24324a(f.f15983d, f.f15984e);
            m17173b((C8005i.m18064m() ? IAConfigManager.m17001o() : IAConfigManager.m17002p()) * 1000);
            return true;
        }
        IAlog.m18021b("IAMediaPlayerFlowManager: Got a VPaid ad! Oh yes! VPaid rules!");
        mo24327a(C7753a.ERROR_NO_MEDIA_FILES);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17171a(String str) {
        IAlog.m18021b("IAMediaPlayerFlowManager: start - start fetching video frame");
        this.f15515f = new C8012l(this.f15510a, this.f15516g, this.f15513d, 0);
        C8006j.m18070a((AsyncTask<P, ?, ?>) this.f15515f, (P[]) new Void[0]);
        this.f15512c.mo24419a(str);
    }

    /* renamed from: u */
    private void m17177u() {
        Runnable runnable = this.f15524o;
        if (runnable != null) {
            this.f15523n.removeCallbacks(runnable);
            this.f15524o = null;
            IAlog.m18021b("IMediaPlayerFlowManager:: cancelBufferTimeout - running timeout runnable cancelled");
        }
    }

    /* renamed from: b */
    private void m17173b(int i) {
        m17177u();
        this.f15524o = new Runnable() {
            public final void run() {
                C7746a.this.mo24347n();
            }
        };
        this.f15523n.postDelayed(this.f15524o, (long) i);
        StringBuilder sb = new StringBuilder("IMediaPlayerFlowManager:: startBufferTimeout called with ");
        sb.append(i);
        sb.append(" m/sec");
        IAlog.m18021b(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final void mo24347n() {
        StringBuilder sb = new StringBuilder("IAMediaPlayerFlowManager: onBufferTimeout reached: mBufferTimeoutRunnable = ");
        sb.append(this.f15524o);
        sb.append(" isDestroyed = ");
        sb.append(this.f15529t);
        IAlog.m18021b(sb.toString());
        if (this.f15524o != null && !this.f15529t) {
            this.f15524o = null;
            C7771e eVar = this.f15531v;
            if (eVar != null) {
                eVar.mo24396c();
                C7790l.m17292a().mo24412b(this.f15531v.mo24397d());
            }
            if (!this.f15528s) {
                C7799e eVar2 = this.f15512c;
                if (eVar2 != null) {
                    eVar2.mo24416a();
                    this.f15512c = null;
                    m17178v();
                }
                mo24327a(C7753a.ERROR_PRE_BUFFER_TIMEOUT);
            } else {
                mo24327a(C7753a.ERROR_BUFFER_TIMEOUT);
            }
            mo24330a((Exception) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24327a(C7753a aVar) {
        StringBuilder sb = new StringBuilder("IAMediaPlayerFlowManager: reporting error to listeners: ");
        sb.append(aVar.toString());
        IAlog.m18023d(sb.toString());
        C7754b bVar = this.f15511b;
        if (bVar != null) {
            try {
                bVar.mo24111a(aVar);
            } catch (Exception e) {
                if (IAlog.f16291a <= 3) {
                    e.printStackTrace();
                }
            }
        }
        m17179w();
        m17177u();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo24335b(boolean z) {
        if (z || this.f15520k == null) {
            IAlog.m18021b("IAMediaPlayerFlowManager: onPlayerPrepared called");
            if (this.f15529t) {
                IAlog.m18021b("IMediaPlayerFlowManager: onPlayerPrepared is called, but object is already destroyed?? ignore");
                return;
            }
            this.f15528s = !z;
            m17177u();
            C7754b bVar = this.f15511b;
            if (bVar != null) {
                bVar.mo24110a();
            }
            return;
        }
        this.f15528s = true;
        C7755c cVar = this.f15532w;
        if (cVar != null) {
            cVar.mo24356a();
        }
        if (!this.f15533x) {
            mo24336c();
        }
    }

    /* renamed from: v */
    private void m17178v() {
        if (!TextUtils.isEmpty(IAConfigManager.m16997k())) {
            this.f15512c = new C7794a(this.f15510a);
        } else {
            this.f15512c = new C7794a(this.f15510a);
        }
        this.f15512c.mo24456a((C7805b) this);
        this.f15512c.mo24455a((C7804a) this);
    }

    /* renamed from: w */
    private void m17179w() {
        C8012l lVar = this.f15515f;
        if (lVar != null) {
            lVar.mo24847a();
            this.f15516g = null;
        }
    }

    /* renamed from: a */
    private boolean m17172a(Vendor vendor) {
        Set<Vendor> set = this.f15522m;
        if (set == null) {
            return false;
        }
        return set.contains(vendor);
    }

    /* renamed from: a */
    public final void mo24328a(C7755c cVar) {
        if (this.f15520k == null || this.f15528s) {
            cVar.mo24356a();
        } else {
            this.f15532w = cVar;
        }
    }

    /* renamed from: o */
    public final boolean mo24348o() {
        return this.f15520k != null;
    }

    /* renamed from: p */
    public final int mo24349p() {
        return this.f15521l;
    }
}
