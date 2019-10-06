package com.fyber.inneractive.sdk.p166g.p168b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;
import com.fyber.inneractive.sdk.p166g.p168b.C7832m;
import com.fyber.inneractive.sdk.p166g.p171e.C7856b;
import com.fyber.inneractive.sdk.p166g.p171e.C7863h;
import com.fyber.inneractive.sdk.p166g.p172f.C7869a;
import com.fyber.inneractive.sdk.p166g.p172f.C7870b;
import com.fyber.inneractive.sdk.p166g.p172f.C7870b.C7876a;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.g.b.l */
public abstract class C7825l<ListenerT extends C7832m> implements C7795b<ListenerT>, C7863h, C7876a {

    /* renamed from: a */
    private boolean f15766a = false;

    /* renamed from: c */
    protected C7856b f15767c;

    /* renamed from: d */
    protected C7712j f15768d;

    /* renamed from: e */
    protected C7870b f15769e;

    /* renamed from: f */
    boolean f15770f = false;

    /* renamed from: g */
    ActivityLifecycleCallbacks f15771g;

    /* renamed from: h */
    ListenerT f15772h;

    /* renamed from: i */
    Handler f15773i;

    /* renamed from: j */
    Runnable f15774j;

    /* renamed from: k */
    protected boolean f15775k = false;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo24468a(Activity activity);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo24470b(Activity activity);

    @TargetApi(11)
    public C7825l(C7856b bVar, C7870b bVar2, C7712j jVar) {
        this.f15767c = bVar;
        this.f15767c.setLayoutTransition(null);
        this.f15769e = bVar2;
        this.f15768d = jVar;
        this.f15767c.setUnitConfig(jVar);
        this.f15769e.setListener(this);
        this.f15767c.setListener(this);
    }

    /* renamed from: h */
    public final void mo24530h() {
        if (this.f15772h != null) {
            this.f15767c.post(new Runnable() {
                public final void run() {
                    ListenerT listenert = C7825l.this.f15772h;
                    if (listenert != null) {
                        listenert.mo24556h();
                    }
                }
            });
        }
    }

    /* renamed from: i */
    public final void mo24531i() {
        if (this.f15772h != null) {
            this.f15767c.post(new Runnable() {
                public final void run() {
                    ListenerT listenert = C7825l.this.f15772h;
                    if (listenert != null) {
                        listenert.mo24554f();
                    }
                }
            });
        }
    }

    /* renamed from: a_ */
    public void mo24527a_() {
    }

    /* renamed from: j */
    public final void mo24532j() {
        if (this.f15772h != null) {
            this.f15767c.post(new Runnable() {
                public final void run() {
                    ListenerT listenert = C7825l.this.f15772h;
                    if (listenert != null) {
                        listenert.mo24558j();
                    }
                }
            });
        }
    }

    /* renamed from: e */
    public void mo24471e() {
    }

    /* renamed from: k */
    public final void mo24533k() {
    }

    /* renamed from: a */
    public final boolean mo24521a(String str) {
        ListenerT listenert = this.f15772h;
        if (listenert != null) {
            return listenert.mo24552a(str);
        }
        return false;
    }

    /* renamed from: b */
    public final boolean mo24523b(String str) {
        return false;
    }

    /* renamed from: l */
    public final void mo24534l() {
    }

    /* renamed from: a */
    public final void mo24529a(int i, int i2) {
        ListenerT listenert = this.f15772h;
        if (listenert != null) {
            listenert.mo24550a(i, i2);
            if (i2 >= i) {
                this.f15772h.mo24557i();
            }
        }
    }

    /* renamed from: m */
    public void mo24450m() {
    }

    /* renamed from: r */
    public final void mo24486r() {
    }

    /* renamed from: c */
    public void mo24441c(boolean z) {
        this.f15770f = z;
    }

    /* renamed from: c */
    public final void mo24500c(int i) {
    }

    /* renamed from: a */
    public final void mo24434a(ListenerT listenert) {
        this.f15772h = listenert;
        if (this.f15772h != null && this.f15769e.f15923b == C7869a.Error) {
            this.f15767c.post(new Runnable() {
                public final void run() {
                    ListenerT listenert = C7825l.this.f15772h;
                    if (listenert != null) {
                        listenert.mo24558j();
                    }
                }
            });
        }
    }

    /* renamed from: a_ */
    public void mo24435a_(boolean z) {
    }

    /* renamed from: b */
    public Bitmap mo24436b(boolean z) {
        return null;
    }

    /* renamed from: a */
    public void mo24432a() {
        if (VERSION.SDK_INT >= 14 && this.f15771g != null) {
            Application g = mo24528g();
            if (g != null) {
                g.unregisterActivityLifecycleCallbacks(this.f15771g);
            }
        }
        mo24537p();
        this.f15772h = null;
    }

    /* renamed from: b */
    public void mo24437b(int i) {
        this.f15769e.mo24657e_();
    }

    /* renamed from: b_ */
    public void mo24438b_() {
    }

    /* renamed from: c */
    public boolean mo24439c() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final boolean mo24535n() {
        C7856b bVar = this.f15767c;
        if (bVar != null) {
            View view = bVar.f15868g;
            if (view != null && bVar.equals(view.getParent())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void mo24536o() {
        if (!mo24535n()) {
            this.f15775k = true;
            if (this.f15771g == null && VERSION.SDK_INT >= 14) {
                Application g = mo24528g();
                if (g != null) {
                    this.f15771g = new ActivityLifecycleCallbacks() {
                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityDestroyed(Activity activity) {
                        }

                        public final void onActivityResumed(Activity activity) {
                            if (activity.equals(C7825l.this.f15767c.getContext())) {
                                C7825l.this.mo24470b(activity);
                            }
                        }

                        public final void onActivityStarted(Activity activity) {
                        }

                        public final void onActivityStopped(Activity activity) {
                        }

                        public final void onActivityPaused(Activity activity) {
                            if (activity.equals(C7825l.this.f15767c.getContext())) {
                                C7825l.this.mo24468a(activity);
                            }
                        }
                    };
                    g.registerActivityLifecycleCallbacks(this.f15771g);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("attachWebView called. Web view is: ");
            sb.append(this.f15767c.f15868g);
            sb.append(" parent is: ");
            sb.append(this.f15767c.f15868g.getParent());
            sb.append(" video view is: ");
            sb.append(this.f15767c);
            IAlog.m18021b(sb.toString());
            C7856b bVar = this.f15767c;
            if (bVar != null) {
                if (bVar.f15868g.getParent() == null) {
                    this.f15769e.mo24733a((ViewGroup) this.f15767c, (LayoutParams) new RelativeLayout.LayoutParams(-1, -1), true);
                } else if (!this.f15767c.f15868g.getParent().equals(this.f15767c)) {
                    ((ViewGroup) this.f15767c.f15868g.getParent()).removeView(this.f15767c.f15868g);
                    this.f15769e.mo24733a((ViewGroup) this.f15767c, (LayoutParams) new RelativeLayout.LayoutParams(-1, -1), true);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) this));
                sb2.append("startMonitoringView");
                IAlog.m18021b(sb2.toString());
                if (this.f15773i == null) {
                    this.f15773i = new Handler(mo24528g().getMainLooper());
                    this.f15774j = new Runnable() {
                        public final void run() {
                            C7825l lVar = C7825l.this;
                            lVar.f15773i.postDelayed(lVar.f15774j, 200);
                        }
                    };
                    this.f15773i.post(this.f15774j);
                }
                if (this.f15766a) {
                    this.f15766a = false;
                    this.f15769e.mo24650a(this instanceof C7806f);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final void mo24537p() {
        if (!this.f15766a && mo24535n()) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("detachWebView(false) called. Web view is: ");
            sb.append(this.f15767c.f15868g);
            sb.append(" parent is: ");
            sb.append(this.f15767c.f15868g.getParent());
            sb.append(" video view is: ");
            sb.append(this.f15767c);
            IAlog.m18021b(sb.toString());
            this.f15766a = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("stopMonitoringView");
            IAlog.m18021b(sb2.toString());
            Handler handler = this.f15773i;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f15773i = null;
                this.f15774j = null;
            }
        }
    }

    /* renamed from: g */
    private Application mo24528g() {
        C7856b bVar = this.f15767c;
        if (bVar == null || bVar.getContext() == null) {
            return null;
        }
        return (Application) this.f15767c.getContext().getApplicationContext();
    }

    /* renamed from: c_ */
    public final void mo24524c_() {
    }

    /* renamed from: d_ */
    public final void mo24525d_() {
    }

    /* renamed from: b */
    public final void mo24522b() {
    }

    /* renamed from: a */
    public final void mo24520a(boolean z) {
    }

    /* renamed from: a */
    public final void mo24519a(AdDisplayError adDisplayError) {
    }

    /* renamed from: a */
    public final void mo24433a(Bitmap bitmap) {
    }

    /* renamed from: d */
    public final void mo24440d() {
    }
}
