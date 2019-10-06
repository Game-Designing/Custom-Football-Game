package com.smaato.soma;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.moat.analytics.mobile.sma.WebAdTracker;
import com.smaato.soma.p236a.C12125n;
import com.smaato.soma.p236a.C12137x;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.C12187c;
import com.smaato.soma.p239c.C12203d;
import com.smaato.soma.p239c.p246f.C12242n;
import com.smaato.soma.p239c.p246f.C12252w;
import com.smaato.soma.p239c.p246f.p249c.C12229k;
import com.smaato.soma.p239c.p251h.C12266b;
import com.smaato.soma.p239c.p251h.C12269c;
import com.smaato.soma.p239c.p251h.C12271e;
import com.smaato.soma.p239c.p251h.C12274f;
import com.smaato.soma.p255d.C12315h;
import com.smaato.soma.p256e.C12331a;
import java.lang.ref.WeakReference;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.smaato.soma.fa */
/* compiled from: BaseView */
public abstract class C12369fa extends RelativeLayout implements C12393ga, C12371g {

    /* renamed from: a */
    protected C12507r f38630a;

    /* renamed from: b */
    protected C12322e f38631b;

    /* renamed from: c */
    public boolean f38632c = false;

    /* renamed from: d */
    protected C12266b f38633d;

    /* renamed from: e */
    protected C12271e f38634e;
    /* access modifiers changed from: protected */

    /* renamed from: f */
    public C12125n f38635f;

    /* renamed from: g */
    protected C12125n f38636g;

    /* renamed from: h */
    protected Handler f38637h;

    /* renamed from: i */
    protected float f38638i = 0.0f;

    /* renamed from: j */
    protected int f38639j = -1;

    /* renamed from: k */
    private boolean f38640k = true;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f38641l = true;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f38642m;

    /* renamed from: n */
    Handler f38643n = new C12067P(this, Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f38644o = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f38645p = false;

    /* renamed from: com.smaato.soma.fa$a */
    /* compiled from: BaseView */
    private class C12370a implements C12367f {
        private C12370a() {
        }

        /* synthetic */ C12370a(C12369fa x0, C12067P x1) {
            this();
        }

        public final void onReceiveAd(C12322e sender, C12064Na receivedBanner) {
            C12146d.m39966a((Object) new C12305ca(this));
            if (receivedBanner != null) {
                C12369fa.this.f38642m = receivedBanner.getSessionId();
            }
            if (receivedBanner.getStatus() == C12111b.f37995c) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(receivedBanner.getStatus());
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("transitionErrorLoading: ");
                sb3.append(receivedBanner.mo39277a());
                C12146d.m39965a(new C12147e(sb2, sb3.toString(), 1, C12143a.ERROR));
                C12369fa.this.getLoadingState().mo39660c();
            } else if (receivedBanner.mo39288e() && receivedBanner.mo39298m() != C12331a.INTERSTITIAL) {
                C12369fa.this.f38643n.post(new C12320da(this, receivedBanner));
            } else if (!receivedBanner.mo39288e() || receivedBanner.mo39298m() != C12331a.INTERSTITIAL) {
                C12369fa.this.setNextPackage(C12187c.m40092b().mo39466a(receivedBanner.mo39284b()));
                C12369fa.this.getNextPackage().mo39349b(receivedBanner);
                C12369fa.this.getLoadingState().mo39662e();
            } else {
                C12369fa.this.f38643n.post(new C12365ea(this, receivedBanner));
            }
            if (receivedBanner.mo39288e()) {
                C12369fa.this.f38641l = true;
            } else {
                C12369fa.this.f38641l = false;
            }
            C12369fa.this.f38644o = false;
            C12369fa.this.f38645p = true;
        }
    }

    public abstract Handler getBannerAnimatorHandler();

    public void setSOMAEndPoint(String somaEndPoint) {
        if (somaEndPoint != null) {
            C12252w.m40307b().mo39624a(somaEndPoint);
        }
    }

    protected C12369fa(Context context) {
        super(context);
        new C12078V(this).execute();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo39226f() {
        C12146d.m39966a((Object) new C12080W(this));
        if (!(getContext() instanceof Activity)) {
            C12146d.m39965a(new C12147e("BannerView", "Please instantiate the BannerView using activity instead of context", 1, C12143a.WARNING));
        }
        if (isInEditMode()) {
            mo39229n();
            return;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(metrics);
        this.f38638i = metrics.density;
        setDescendantFocusability(Opcodes.ASM4);
        setFocusable(true);
        C12252w.m40307b().mo39626b(getContext());
        C12229k oldUserSettings = getUserSettings();
        C12394h oldAdSettings = getAdSettings();
        C12322e eVar = this.f38631b;
        if (eVar != null) {
            eVar.destroy();
            this.f38631b = null;
        }
        setUserSettings(oldUserSettings);
        setAdSettings(oldAdSettings);
        mo39816a((C12367f) new C12370a(this, null));
        mo39815a(new C12266b());
        setLoadingStateMachine(new C12271e());
    }

    /* renamed from: n */
    private void mo39229n() {
        setBackgroundColor(-7829368);
        TextView subTextView = new TextView(getContext());
        subTextView.setText("Soma banner view");
        LayoutParams params = new LayoutParams(-2, -2);
        params.addRule(13);
        subTextView.setLayoutParams(params);
        addView(subTextView);
    }

    public final C12266b getBannerState() {
        return this.f38633d;
    }

    public final void setBannerStateListener(C12507r listener) {
        this.f38630a = listener;
    }

    public final C12507r getBannerStateListener() {
        return this.f38630a;
    }

    /* renamed from: a */
    public final void mo39816a(C12367f adListener) {
        new C12082X(this, adListener).execute();
    }

    /* renamed from: a */
    public void mo39256a() {
        new C12140aa(this).execute();
    }

    public final void setLocationUpdateEnabled(boolean updateEnabled) {
        new C12148ba(this, updateEnabled).execute();
    }

    public final C12394h getAdSettings() {
        return (C12394h) new C12049G(this).execute();
    }

    public final C12229k getUserSettings() {
        return (C12229k) new C12051H(this).execute();
    }

    public final void setUserSettings(C12229k userSettings) {
        new C12053I(this, userSettings).execute();
    }

    public final void setAdSettings(C12394h adSettings) {
        new C12055J(this, adSettings).execute();
    }

    /* access modifiers changed from: protected */
    public final C12271e getLoadingState() {
        return this.f38634e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public boolean mo39835m() {
        String str = "BaseView:switchViews()";
        C12146d.m39966a((Object) new C12057K(this));
        C12125n currentPackage = getCurrentPackage();
        try {
            removeAllViews();
        } catch (Exception e) {
            C12146d.m39965a(new C12147e(str, "Exception during clearing Base views", 1, C12143a.ERROR));
        }
        if (currentPackage != null) {
            mo39834l();
            currentPackage.mo39340a();
        }
        setCurrentPackage(getNextPackage());
        setNextPackage(null);
        if (getCurrentPackage() == null || getCurrentPackage().mo39361l() == null) {
            C12146d.m39965a(new C12147e(str, "getCurrentPackage().getView() is not available or null. Switching to new format?", 0, C12143a.DEBUG));
            mo39256a();
            return false;
        }
        addView(getCurrentPackage().mo39361l());
        if ((VERSION.SDK_INT >= 19 && isAttachedToWindow()) || getParent() != null) {
            mo39832j();
        } else if (!this.f38641l) {
            mo39228i();
        }
        System.gc();
        if (!this.f38641l) {
            C12315h.m40496c().mo39733a(this);
        }
        C12137x.m39951a().mo39377a(false);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo39228i() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo39832j() {
        if (!this.f38644o) {
            mo39818b();
        }
        if (this.f38645p) {
            mo39833k();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo39833k() {
        C12125n currentPackage = getCurrentPackage();
        if (currentPackage != null) {
            WebAdTracker moatTracker = currentPackage.mo39358i();
            if (moatTracker != null) {
                moatTracker.startTracking();
                this.f38645p = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo39834l() {
        C12125n currentPackage = getCurrentPackage();
        if (currentPackage != null) {
            WebAdTracker moatTracker = currentPackage.mo39358i();
            if (moatTracker != null) {
                moatTracker.stopTracking();
                currentPackage.mo39369t();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo39818b() {
        boolean executionSuccess = false;
        C12064Na banner = null;
        if (getNextPackage() != null) {
            banner = getNextPackage().mo39354e();
        } else if (getCurrentPackage() != null) {
            banner = getCurrentPackage().mo39354e();
        }
        if (banner == null) {
            return false;
        }
        if (banner.getStatus() == C12111b.f37994b && banner.mo39293h() != null && !banner.mo39293h().isEmpty()) {
            String[] beaconArray = (String[]) banner.mo39293h().toArray(new String[0]);
            ((C12203d) banner).mo39502a(null);
            new C12242n(getAdSettings(), banner).execute(beaconArray);
            executionSuccess = true;
            this.f38644o = true;
        }
        return executionSuccess;
    }

    /* access modifiers changed from: protected */
    public void setLoadingStateMachine(C12271e loadingState) {
        C12146d.m39966a((Object) new C12059L(this));
        this.f38634e = loadingState;
        this.f38634e.mo39658a(true);
        this.f38634e.mo39657a((C12274f) new C12054Ia(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo39831h() {
        String str = "BaseView";
        try {
            C12146d.m39966a((Object) new C12061M(this));
            ExpandedBannerActivity.f37892a = new WeakReference<>(getCurrentPackage());
            Intent i = new Intent(getContext(), ExpandedBannerActivity.class);
            i.addFlags(268435456);
            getContext().startActivity(i);
        } catch (ActivityNotFoundException e) {
            C12146d.m39965a(new C12147e(str, "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml", 0, C12143a.ERROR));
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "Exception inside Internal Browser", 0, C12143a.ERROR));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo39819c() {
        try {
            C12146d.m39966a((Object) new C12063N(this));
            if (this.f38635f.mo39356g() != null) {
                this.f38635f.mo39351b(true);
                if (!((ExpandedBannerActivity) this.f38635f.mo39356g()).mo39250e()) {
                    ((ExpandedBannerActivity) this.f38635f.mo39356g()).finish();
                }
            } else if (this.f38635f.mo39360k() != null) {
                this.f38635f.mo39360k().mo39455j();
            }
        } catch (ActivityNotFoundException e) {
            C12146d.m39965a(new C12147e("BaseView", "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml", 0, C12143a.ERROR));
        } catch (Exception e2) {
        }
    }

    public final C12125n getCurrentPackage() {
        return this.f38635f;
    }

    /* access modifiers changed from: protected */
    public final void setCurrentPackage(C12125n currentPackage) {
        this.f38635f = currentPackage;
    }

    /* access modifiers changed from: protected */
    public final C12125n getNextPackage() {
        return this.f38636g;
    }

    /* access modifiers changed from: protected */
    public final void setNextPackage(C12125n bannerPackage) {
        this.f38636g = bannerPackage;
    }

    public final C12322e getAdDownloader() {
        if (this.f38631b == null) {
            this.f38631b = C12187c.m40092b().mo39469a(getContext(), this);
        }
        return this.f38631b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo39815a(C12266b bannerState) {
        C12146d.m39966a((Object) new C12065O(this));
        this.f38633d = bannerState;
        this.f38633d.mo39640a(true);
        this.f38633d.mo39639a((C12269c) new C12505q(this));
    }

    public final void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        this.f38639j = color;
    }

    public final int getBackgroundColor() {
        return this.f38639j;
    }

    /* access modifiers changed from: protected */
    public void setBannerAnimatorHandler(Handler handler) {
        this.f38637h = handler;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo39221g() {
        C12146d.m39966a((Object) new C12069Q(this));
    }

    public final void setScalingEnabled(boolean mScaleEnabled) {
        this.f38640k = mScaleEnabled;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        new C12072S(this).execute();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        new C12074T(this).execute();
        super.onAttachedToWindow();
    }

    /* renamed from: d */
    public void mo39225d() {
        C12125n nVar = this.f38635f;
        if (!(nVar == null || nVar.mo39360k() == null || !this.f38635f.mo39365p())) {
            this.f38635f.mo39360k().mo39449d();
        }
        this.f38631b.destroy();
        mo39834l();
    }

    /* renamed from: e */
    public void mo39822e() {
        this.f38643n.post(new C12076U(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo39820c(Bundle resizeProperties) {
        int width = resizeProperties.getInt("width");
        int height = resizeProperties.getInt("height");
        int offsetX = resizeProperties.getInt("offsetX");
        int offsetY = resizeProperties.getInt("offsetY");
        String customClosePosition = resizeProperties.getString("customClosePosition");
        boolean allowOffscreen = resizeProperties.getBoolean("allowOffscreen");
        C12125n nVar = this.f38635f;
        if (nVar != null && nVar.mo39360k() != null) {
            this.f38635f.mo39360k().mo39427a(width, height, offsetX, offsetY, customClosePosition, allowOffscreen);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo39821d(Bundle orientationProperties) {
        boolean allowOrientationChange = orientationProperties.getBoolean("allowOrientationChange");
        String forceOrientation = orientationProperties.getString("forceOrientation");
        C12125n nVar = this.f38635f;
        if (nVar != null && nVar.mo39360k() != null) {
            this.f38635f.mo39360k().mo39437a(allowOrientationChange, forceOrientation);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo39823e(Bundle useCustomCloseBundle) {
        boolean useCustomClose = useCustomCloseBundle.getBoolean("useCustomClose");
        C12125n nVar = this.f38635f;
        if (nVar != null && nVar.mo39360k() != null) {
            this.f38635f.mo39360k().mo39444b(useCustomClose);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo39814a(Bundle expandPropertiesBundle) {
        boolean useCustomClose = expandPropertiesBundle.getBoolean("useCustomClose");
        C12125n nVar = this.f38635f;
        if (nVar != null && nVar.mo39360k() != null) {
            this.f38635f.mo39360k().mo39436a(useCustomClose);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo39817b(Bundle bundle) {
        String message = bundle.getString("errorMessage");
        String action = bundle.getString("errorAction");
        C12125n nVar = this.f38635f;
        if (nVar != null && nVar.mo39360k() != null) {
            this.f38635f.mo39360k().mo39435a(message, action);
        }
    }
}
