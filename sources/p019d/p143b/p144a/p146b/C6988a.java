package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.C5855a;
import com.applovin.adview.C5856b;
import com.applovin.adview.C5858d;
import com.applovin.adview.C5863i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import p019d.p143b.p144a.p147c.C7040A;
import p019d.p143b.p144a.p147c.C7052D;
import p019d.p143b.p144a.p147c.C7086Lb;
import p019d.p143b.p144a.p147c.C7134a;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p144a.p147c.C7171ja;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p144a.p147c.C7234z;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7259i;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.a */
public class C6988a implements C5855a {

    /* renamed from: A */
    private volatile C7253c f12953A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public volatile C5858d f12954B;

    /* renamed from: C */
    private volatile C7252b f12955C;

    /* renamed from: D */
    private volatile boolean f12956D;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f12957a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f12958b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C7267q f12959c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C7134a f12960d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C7262l f12961e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C7257g f12962f;

    /* renamed from: g */
    private String f12963g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f12964h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C7086Lb f12965i;

    /* renamed from: j */
    private C7010l f12966j;

    /* renamed from: k */
    private C6951Da f12967k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C6957Ga f12968l;

    /* renamed from: m */
    private C7251a f12969m;

    /* renamed from: n */
    private Runnable f12970n;

    /* renamed from: o */
    private Runnable f12971o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public volatile C7251a f12972p = null;

    /* renamed from: q */
    private volatile C7251a f12973q = null;

    /* renamed from: r */
    private C5863i f12974r = null;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C7030v f12975s = null;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C7030v f12976t = null;

    /* renamed from: u */
    private final AtomicReference<C7251a> f12977u = new AtomicReference<>();

    /* renamed from: v */
    private volatile boolean f12978v = false;

    /* renamed from: w */
    private volatile boolean f12979w = true;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile boolean f12980x = false;

    /* renamed from: y */
    private volatile boolean f12981y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public volatile C7254d f12982z;

    /* renamed from: a */
    private void m14371a(C5856b bVar, C7267q qVar, C7257g gVar, String str, Context context) {
        if (bVar == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (qVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (gVar != null) {
            this.f12959c = qVar;
            this.f12960d = (C7134a) qVar.mo23037a();
            this.f12961e = qVar.mo23049b();
            this.f12962f = gVar;
            this.f12963g = str;
            this.f12957a = context;
            this.f12958b = bVar;
            this.f12969m = new C7052D();
            this.f12966j = new C7010l(this, qVar);
            this.f12971o = new C6945Aa(this, null);
            this.f12970n = new C6949Ca(this, null);
            this.f12967k = new C6951Da(this, qVar);
            if (m14376a(context)) {
                m14374a(gVar);
            } else {
                this.f12961e.mo22921e("AppLovinAdView", "Web view database is corrupt, AdView not loaded");
            }
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    /* renamed from: a */
    private void m14373a(C7234z zVar, C5856b bVar, Uri uri) {
        String str = "AppLovinAdView";
        if (this.f12974r != null) {
            this.f12961e.mo22918c(str, "Skipping click overlay rendering because it already exists");
        } else if (bVar != null) {
            this.f12961e.mo22918c(str, "Creating and rendering click overlay");
            this.f12974r = new C5863i(bVar.getContext(), this.f12959c);
            this.f12974r.setLayoutParams(new LayoutParams(-1, -1));
            bVar.addView(this.f12974r);
            bVar.bringChildToFront(this.f12974r);
            this.f12960d.mo23012b(zVar, this.f12964h, bVar, this, uri);
        } else {
            this.f12961e.mo22916b(str, "Skipping click overlay rendering because AppLovinAdView has been destroyed");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14374a(C7257g gVar) {
        C6947Ba ba;
        try {
            this.f12968l = new C6957Ga(this.f12966j, this.f12959c, this.f12957a);
            this.f12968l.setBackgroundColor(0);
            this.f12968l.setWillNotCacheDrawing(false);
            if (new C7212tb(this.f12959c).mo23312na() && VERSION.SDK_INT >= 19) {
                this.f12968l.setLayerType(2, null);
            }
            this.f12958b.setBackgroundColor(0);
            this.f12958b.addView(this.f12968l);
            m14379b((View) this.f12968l, gVar);
            C7212tb tbVar = new C7212tb(this.f12959c);
            if (((C7142c) this.f12959c).mo23033I()) {
                if (!this.f12978v && tbVar.mo23291d()) {
                    m14375a(this.f12971o);
                }
                if (tbVar.mo23293e()) {
                    ba = new C6947Ba(this, null);
                }
                this.f12978v = true;
            }
            if (!this.f12978v) {
                m14375a(this.f12971o);
            }
            if (tbVar.mo23295f()) {
                ba = new C6947Ba(this, null);
            }
            this.f12978v = true;
            m14375a((Runnable) ba);
            this.f12978v = true;
        } catch (Throwable th) {
            C7262l lVar = this.f12961e;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to create AdView: ");
            sb.append(th.getMessage());
            lVar.mo22921e("AppLovinAdView", sb.toString());
        }
    }

    /* renamed from: a */
    private void m14375a(Runnable runnable) {
        C7269s.m15816a(runnable);
    }

    /* renamed from: a */
    private static boolean m14376a(Context context) {
        String str;
        String str2 = "Error invoking getCacheTotalSize()";
        String str3 = "AppLovinAdView";
        try {
            if (VERSION.SDK_INT < 11) {
                WebViewDatabase instance = WebViewDatabase.getInstance(context);
                Method declaredMethod = WebViewDatabase.class.getDeclaredMethod("getCacheTotalSize", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(instance, new Object[0]);
            }
            return true;
        } catch (NoSuchMethodException e) {
            Log.e(str3, str2, e);
            return true;
        } catch (IllegalArgumentException e2) {
            Log.e(str3, str2, e2);
            return true;
        } catch (IllegalAccessException e3) {
            Log.e(str3, str2, e3);
            return true;
        } catch (InvocationTargetException e4) {
            th = e4;
            str = "getCacheTotalSize() reported exception";
            Log.e(str3, str, th);
            return false;
        } catch (Throwable th) {
            th = th;
            str = "Unexpected error while checking DB state";
            Log.e(str3, str, th);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m14379b(View view, C7257g gVar) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            int i = -1;
            int i2 = gVar.mo23473b().equals(C7257g.f14096c.mo23473b()) ? -1 : gVar.mo23474c() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) gVar.mo23474c(), displayMetrics);
            if (!gVar.mo23473b().equals(C7257g.f14096c.mo23473b())) {
                i = gVar.mo23472a() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) gVar.mo23472a(), displayMetrics);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-2, -2);
            }
            layoutParams.width = i2;
            layoutParams.height = i;
            if (layoutParams instanceof LayoutParams) {
                layoutParams.addRule(10);
                layoutParams.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: q */
    private void m14394q() {
        String str = "AppLovinAdView";
        this.f12961e.mo22918c(str, "Destroying...");
        C7134a aVar = this.f12960d;
        if (aVar != null) {
            aVar.mo23009a((C7259i) this.f12967k, mo18283a());
        }
        C6957Ga ga = this.f12968l;
        if (ga != null) {
            try {
                ViewParent parent = ga.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f12968l);
                }
                this.f12968l.removeAllViews();
                if (new C7212tb(this.f12959c).mo23271M()) {
                    this.f12968l.loadUrl("about:blank");
                    this.f12968l.onPause();
                    this.f12968l.destroyDrawingCache();
                }
            } catch (Throwable th) {
                this.f12961e.mo22914a(str, "Unable to destroy ad view", th);
            }
            this.f12968l.destroy();
            this.f12968l = null;
        }
        this.f12980x = true;
    }

    /* renamed from: r */
    private void m14395r() {
        m14375a((Runnable) new C6994d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m14396s() {
        m14375a((Runnable) new C7039za(this));
    }

    /* renamed from: t */
    private void m14397t() {
        C7086Lb lb = this.f12965i;
        if (lb != null) {
            lb.mo22888c();
            this.f12965i = null;
        }
    }

    /* renamed from: a */
    public C7257g mo18283a() {
        return this.f12962f;
    }

    /* renamed from: a */
    public void mo18284a(int i) {
        if (this.f12978v && this.f12979w) {
            if (i == 8 || i == 4) {
                mo22595n();
            } else if (i == 0) {
                mo22597p();
            }
        }
    }

    /* renamed from: a */
    public void mo22578a(WebView webView) {
        if (this.f12972p instanceof C7234z) {
            webView.setVisibility(0);
            try {
                if (this.f12972p != this.f12973q && this.f12953A != null) {
                    this.f12973q = this.f12972p;
                    C7171ja.m15276a(this.f12953A, this.f12972p, this.f12959c);
                }
            } catch (Throwable th) {
                this.f12961e.mo22919c("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    /* renamed from: a */
    public void mo18285a(C5856b bVar, Context context, C7257g gVar, String str, C7267q qVar, AttributeSet attributeSet) {
        if (bVar == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            Log.e("AppLovinSdk", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (gVar == null) {
                gVar = C6953Ea.m14346a(attributeSet);
                if (gVar == null) {
                    gVar = C7257g.f14094a;
                }
            }
            C7257g gVar2 = gVar;
            if (qVar == null) {
                qVar = C7267q.m15794a(context);
            }
            C7267q qVar2 = qVar;
            if (qVar2 != null && !qVar2.mo23059d()) {
                m14371a(bVar, qVar2, gVar2, str, context);
                if (C6953Ea.m14347b(attributeSet)) {
                    mo18293b();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18286a(C5858d dVar) {
        this.f12954B = dVar;
    }

    /* renamed from: a */
    public void mo22579a(C7086Lb lb) {
        this.f12968l.mo22529a(lb);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22580a(C7251a aVar) {
        String str = "AppLovinAdView";
        if (aVar != null) {
            this.f12981y = true;
            if (!this.f12980x) {
                this.f12960d.mo23013b((C7259i) this.f12967k, this.f12962f);
                mo22583b(aVar);
            } else {
                this.f12977u.set(aVar);
                this.f12961e.mo22918c(str, "Ad view has paused when an ad was received, ad saved for later");
            }
            m14375a((Runnable) new C7035xa(this, aVar));
            return;
        }
        this.f12961e.mo22916b(str, "No provided when to the view controller");
        mo22582b(-1);
    }

    /* renamed from: a */
    public void mo18287a(C7251a aVar, String str) {
        C7262l lVar;
        String str2;
        StringBuilder sb;
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (this.f12978v) {
            C7251a a = C7209sc.m15466a(aVar, this.f12959c);
            String str3 = "AppLovinAdView";
            if (a == null || a == this.f12972p) {
                if (a == null) {
                    lVar = this.f12961e;
                    sb = new StringBuilder();
                    sb.append("Unable to render ad: ");
                    sb.append(a);
                    str2 = ". Internal inconsistency error.";
                } else {
                    lVar = this.f12961e;
                    sb = new StringBuilder();
                    sb.append("Ad #");
                    sb.append(a.mo22758b());
                    str2 = " is already showing, ignoring";
                }
                sb.append(str2);
                lVar.mo22913a(str3, sb.toString());
                return;
            }
            C7262l lVar2 = this.f12961e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Rendering ad #");
            sb2.append(a.mo22758b());
            sb2.append(" (");
            sb2.append(a.mo22756a());
            sb2.append(") over placement: ");
            sb2.append(str);
            lVar2.mo22918c(str3, sb2.toString());
            if (!(this.f12972p instanceof C7052D)) {
                C7171ja.m15284b(this.f12953A, this.f12972p, this.f12959c);
                if (!(a instanceof C7052D) && a.mo22756a() != C7257g.f14096c) {
                    m14397t();
                }
            }
            this.f12977u.set(null);
            this.f12973q = null;
            this.f12972p = a;
            this.f12964h = str;
            if (a.mo22756a() == this.f12962f) {
                boolean z = a instanceof C7052D;
                if (!z && this.f12975s != null) {
                    if (new C7212tb(this.f12959c).mo23272N()) {
                        m14396s();
                        this.f12961e.mo22918c(str3, "Fade out the old ad scheduled");
                    } else {
                        m14395r();
                    }
                }
                if (!z || (this.f12975s == null && this.f12976t == null)) {
                    m14375a(this.f12970n);
                } else {
                    this.f12961e.mo22918c(str3, "ignoring empty ad render with expanded ad");
                }
            }
        } else {
            Log.i("AppLovinSdk", "Unable to render ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22581a(C7251a aVar, String str, C5856b bVar, Uri uri) {
        String str2;
        C7262l lVar;
        C7171ja.m15275a(this.f12955C, aVar, this.f12959c);
        String str3 = "AppLovinAdView";
        if (bVar != null) {
            C7212tb tbVar = new C7212tb(this.f12959c);
            if (!tbVar.mo23277S() || (aVar instanceof C7234z)) {
                C7234z zVar = (C7234z) aVar;
                if (!tbVar.mo23320ra() || uri == null) {
                    this.f12960d.mo23005a(zVar, str, bVar, this, uri);
                    return;
                } else {
                    m14373a(zVar, bVar, uri);
                    return;
                }
            } else {
                lVar = this.f12961e;
                str2 = "Unable to process ad click - EmptyAd is not supported.";
            }
        } else {
            lVar = this.f12961e;
            str2 = "Unable to process ad click - AppLovinAdView destroyed prematurely";
        }
        lVar.mo22916b(str3, str2);
    }

    /* renamed from: a */
    public void mo18288a(C7252b bVar) {
        this.f12955C = bVar;
    }

    /* renamed from: a */
    public void mo18289a(C7253c cVar) {
        this.f12953A = cVar;
    }

    /* renamed from: a */
    public void mo18290a(C7254d dVar) {
        this.f12982z = dVar;
    }

    /* renamed from: a */
    public void mo18291a(C7260j jVar) {
    }

    /* renamed from: a */
    public void mo18292a(boolean z) {
        this.f12979w = z;
    }

    /* renamed from: b */
    public void mo18293b() {
        if (this.f12959c == null || this.f12967k == null || this.f12957a == null || !this.f12978v) {
            Log.i("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else if (!TextUtils.isEmpty(this.f12963g)) {
            this.f12960d.mo23010a(this.f12963g, (C7254d) this.f12967k);
        } else {
            this.f12960d.mo23008a(this.f12962f, (C7254d) this.f12967k);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22582b(int i) {
        if (!this.f12980x) {
            this.f12960d.mo23013b((C7259i) this.f12967k, this.f12962f);
            m14375a(this.f12971o);
        }
        m14375a((Runnable) new C7037ya(this, i));
    }

    /* renamed from: b */
    public void mo22583b(C7251a aVar) {
        mo18287a(aVar, (String) null);
    }

    /* renamed from: b */
    public void mo22584b(boolean z) {
        this.f12956D = z;
    }

    /* renamed from: c */
    public String mo18294c() {
        return this.f12963g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo22585d() {
        if (this.f12975s == null && this.f12976t == null) {
            C7262l lVar = this.f12961e;
            StringBuilder sb = new StringBuilder();
            sb.append("Ad: ");
            sb.append(this.f12972p);
            sb.append(" with placement = \"");
            sb.append(this.f12964h);
            sb.append("\" closed.");
            lVar.mo22918c("AppLovinAdView", sb.toString());
            m14375a(this.f12971o);
            C7171ja.m15284b(this.f12953A, this.f12972p, this.f12959c);
            this.f12972p = null;
            this.f12964h = null;
        } else if (new C7212tb(this.f12959c).mo23275Q()) {
            mo22586e();
        }
    }

    public void destroy() {
        if (!(this.f12968l == null || this.f12975s == null)) {
            mo22586e();
        }
        m14394q();
    }

    /* renamed from: e */
    public void mo22586e() {
        m14375a((Runnable) new C7033wa(this));
    }

    /* renamed from: f */
    public void mo22587f() {
        if ((this.f12957a instanceof AppLovinInterstitialActivity) && (this.f12972p instanceof C7234z)) {
            AppLovinInterstitialActivity appLovinInterstitialActivity = (AppLovinInterstitialActivity) this.f12957a;
            if ((((C7234z) this.f12972p).mo23399E() == C7040A.f13136b) && appLovinInterstitialActivity.mo22497d()) {
                appLovinInterstitialActivity.mo22496c();
            }
        }
    }

    /* renamed from: g */
    public void mo22588g() {
        m14375a((Runnable) new C6952E(this));
    }

    /* renamed from: h */
    public C5858d mo22589h() {
        return this.f12954B;
    }

    /* renamed from: i */
    public C6957Ga mo22590i() {
        return this.f12968l;
    }

    /* renamed from: j */
    public C7251a mo22591j() {
        return this.f12972p;
    }

    /* renamed from: k */
    public C5856b mo22592k() {
        return (C5856b) this.f12958b;
    }

    /* renamed from: l */
    public C7267q mo22593l() {
        return this.f12959c;
    }

    /* renamed from: m */
    public boolean mo22594m() {
        return this.f12956D;
    }

    /* renamed from: n */
    public void mo22595n() {
        if (this.f12978v) {
            if (new C7212tb(this.f12959c).mo23274P()) {
                this.f12960d.mo23009a((C7259i) this.f12967k, mo18283a());
            }
            C7251a aVar = this.f12972p;
            mo18287a(this.f12969m, this.f12964h);
            if (aVar != null) {
                this.f12977u.set(aVar);
            }
            this.f12980x = true;
        }
    }

    /* renamed from: o */
    public void mo22596o() {
        C5863i iVar = this.f12974r;
        if (iVar != null) {
            ViewParent parent = iVar.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f12974r);
                this.f12974r = null;
                return;
            }
            return;
        }
        this.f12961e.mo22918c("AppLovinAdView", "Asked to remove an overlay when none existed. Skipping...");
    }

    public void onDetachedFromWindow() {
        if (this.f12978v) {
            if (this.f12972p != this.f12969m) {
                C7171ja.m15284b(this.f12953A, this.f12972p, this.f12959c);
            }
            String str = "AppLovinAdView";
            if (this.f12968l == null || this.f12975s == null) {
                this.f12961e.mo22918c(str, "onDetachedFromWindowCalled without an expanded ad present");
            } else {
                this.f12961e.mo22918c(str, "onDetachedFromWindowCalled with expanded ad present");
                if (new C7212tb(this.f12959c).mo23273O()) {
                    mo22586e();
                } else {
                    m14395r();
                }
            }
            if (this.f12979w) {
                m14394q();
            }
        }
    }

    /* renamed from: p */
    public void mo22597p() {
        if (this.f12978v) {
            if (this.f12981y && new C7212tb(this.f12959c).mo23274P()) {
                this.f12960d.mo23013b((C7259i) this.f12967k, this.f12962f);
            }
            C7251a aVar = (C7251a) this.f12977u.getAndSet(null);
            if (aVar != null) {
                mo18287a(aVar, this.f12964h);
            }
            this.f12980x = false;
        }
    }
}
