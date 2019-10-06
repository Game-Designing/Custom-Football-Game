package com.fyber.inneractive.sdk.activities;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.p001v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.p163d.C7719c;
import com.fyber.inneractive.sdk.p163d.C7719c.C7720a;
import com.fyber.inneractive.sdk.util.IAlog;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class InneractiveFullscreenAdActivity extends Activity implements C7720a {
    public static final String EXTRA_KEY_SPOT_ID = "spotId";

    /* renamed from: a */
    boolean f15158a = false;

    /* renamed from: b */
    private ViewGroup f15159b;

    /* renamed from: c */
    private View f15160c;

    /* renamed from: d */
    private InneractiveAdSpot f15161d;

    /* renamed from: e */
    private C7719c f15162e;

    /* renamed from: f */
    private int f15163f = 0;

    public interface FullScreenRendererProvider {
        C7719c getFullscreenRenderer();
    }

    public interface OnInneractiveFullscreenAdDismissedListener {
        void onAdDismissed(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007a, code lost:
        if (r1.getAdContent() != null) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            java.lang.String r1 = "spotId"
            java.lang.String r0 = r0.getStringExtra(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x002a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r4)
            r0.append(r1)
            java.lang.String r1 = "Spot id must be provided as an extra before calling createActivity with InneractiveInterstitialAdActivty"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18023d(r0)
            goto L_0x007d
        L_0x002a:
            com.fyber.inneractive.sdk.external.InneractiveAdSpotManager r1 = com.fyber.inneractive.sdk.external.InneractiveAdSpotManager.get()
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r1 = r1.getSpot(r0)
            if (r1 != 0) goto L_0x0054
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r4)
            r2.append(r3)
            java.lang.String r3 = "Spot id "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " cannot be found in spot manager!"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18024e(r0)
        L_0x0054:
            if (r1 == 0) goto L_0x0074
            com.fyber.inneractive.sdk.c.f r0 = r1.getAdContent()
            if (r0 != 0) goto L_0x0074
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r4)
            r0.append(r2)
            java.lang.String r2 = "Spot does not have a content. Cannot start activity"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)
        L_0x0074:
            if (r1 == 0) goto L_0x007d
            com.fyber.inneractive.sdk.c.f r0 = r1.getAdContent()
            if (r0 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r1 = 0
        L_0x007e:
            r4.f15161d = r1
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r4.f15161d
            if (r0 == 0) goto L_0x0099
            com.fyber.inneractive.sdk.c.f r0 = r0.getAdContent()
            if (r0 == 0) goto L_0x0099
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r4.f15161d
            com.fyber.inneractive.sdk.c.f r0 = r0.getAdContent()
            com.fyber.inneractive.sdk.config.j r0 = r0.getUnitConfig()
            if (r0 != 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r0 = 0
            goto L_0x009a
        L_0x0099:
            r0 = 1
        L_0x009a:
            if (r0 == 0) goto L_0x00a3
            super.onCreate(r5)
            r4.finish()
            return
        L_0x00a3:
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r4.f15161d
            com.fyber.inneractive.sdk.external.InneractiveUnitController r0 = r0.getSelectedUnitController()
            if (r0 == 0) goto L_0x012e
            boolean r1 = r0 instanceof com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.FullScreenRendererProvider
            if (r1 != 0) goto L_0x00b1
            goto L_0x012e
        L_0x00b1:
            com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity$FullScreenRendererProvider r0 = (com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.FullScreenRendererProvider) r0
            com.fyber.inneractive.sdk.d.c r0 = r0.getFullscreenRenderer()
            r4.f15162e = r0
            com.fyber.inneractive.sdk.d.c r0 = r4.f15162e
            r4.initWindowFeatures(r0)
            super.onCreate(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r4)
            r5.append(r0)
            java.lang.String r0 = "Intersitital for spot id "
            r5.append(r0)
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r4.f15161d
            java.lang.String r0 = r0.getLocalUniqueId()
            r5.append(r0)
            java.lang.String r0 = " created"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)
            android.content.res.Resources r5 = r4.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            int r5 = r5.orientation
            r4.f15163f = r5
            com.fyber.inneractive.sdk.d.c r5 = r4.f15162e
            if (r5 == 0) goto L_0x0125
            int r5 = com.fyber.inneractive.sdk.C7636R.layout.ia_fullscreen_activity
            r4.setContentView(r5)
            int r5 = com.fyber.inneractive.sdk.C7636R.C7637id.ia_ad_content
            android.view.View r5 = r4.findViewById(r5)
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r4.f15159b = r5
            int r5 = com.fyber.inneractive.sdk.C7636R.C7637id.ia_iv_close_button
            android.view.View r5 = r4.findViewById(r5)
            r4.f15160c = r5
            com.fyber.inneractive.sdk.d.c r5 = r4.f15162e
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r4.f15161d
            r5.initialize(r0)
            com.fyber.inneractive.sdk.d.c r5 = r4.f15162e
            r5.mo24233a(r4)
            android.view.View r5 = r4.f15160c
            com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity$1 r0 = new com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity$1
            r0.<init>()
            r5.setOnClickListener(r0)
            return
        L_0x0125:
            java.lang.String r5 = "Interstitial Activity: Could not find an appropriate full screen ad renderer for content!"
            com.fyber.inneractive.sdk.util.IAlog.m18023d(r5)
            r4.finish()
            return
        L_0x012e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.fyber.inneractive.sdk.util.IAlog.m18018a(r4)
            r0.append(r1)
            java.lang.String r1 = "no appropriate unit controller found for full screen ad. Aborting"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18023d(r0)
            super.onCreate(r5)
            r4.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void initWindowFeatures(C7719c cVar) {
        requestWindowFeature(1);
        getWindow().addFlags(Opcodes.ACC_ABSTRACT);
        getWindow().addFlags(128);
        if (VERSION.SDK_INT >= 28) {
            getWindow().addFlags(2);
        }
        if (cVar != null && cVar.mo24238k_()) {
            setTheme(16973831);
            if (VERSION.SDK_INT >= 19) {
                requestWindowFeature(67108864);
                requestWindowFeature(134217728);
            }
            if (VERSION.SDK_INT >= 21) {
                requestWindowFeature(LinearLayoutManager.INVALID_OFFSET);
            }
        }
        C7712j unitConfig = this.f15161d.getAdContent().getUnitConfig();
        if (unitConfig.mo24210f() != null) {
            Orientation d = unitConfig.mo24210f().mo24217d();
            if (d == Orientation.LANDSCAPE) {
                if (VERSION.SDK_INT < 9) {
                    setRequestedOrientation(0);
                } else {
                    setRequestedOrientation(6);
                }
            } else if (d == Orientation.PORTRAIT) {
                if (VERSION.SDK_INT < 9) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(7);
                }
            } else if (d == Orientation.USER) {
                if (VERSION.SDK_INT < 9) {
                    setRequestedOrientation(2);
                    return;
                }
                setRequestedOrientation(13);
            }
        }
    }

    public void destroy() {
        if (!isFinishing() && this.f15159b != null) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup = this.f15159b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f15159b = null;
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.f15162e != null && isFinishing()) {
            this.f15162e.mo24235b();
            this.f15162e.destroy();
            this.f15162e = null;
        }
    }

    public boolean wasDismissedByUser() {
        return this.f15158a;
    }

    public void onResume() {
        super.onResume();
        C7719c cVar = this.f15162e;
        if (cVar != null) {
            cVar.mo24236d();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C7719c cVar = this.f15162e;
        if (cVar != null) {
            int i = configuration.orientation;
            if (i != this.f15163f) {
                this.f15163f = i;
                cVar.mo24237e();
            }
        }
    }

    public static void show(Context context, InneractiveAdSpot inneractiveAdSpot) {
        Intent intent = new Intent(context, InneractiveFullscreenAdActivity.class);
        intent.putExtra(EXTRA_KEY_SPOT_ID, inneractiveAdSpot.getLocalUniqueId());
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) context));
            sb.append("IAInterstitialUtil: Opening interstitial for spot id: ");
            sb.append(inneractiveAdSpot.getLocalUniqueId());
            IAlog.m18021b(sb.toString());
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) context));
            sb2.append("IAInterstitialUtil: InneractiveFullscreenAdActivity.class not found. Did you declare InneractiveFullscreenAdActivity in your manifest?");
            IAlog.m18022c(sb2.toString());
        }
    }

    public void onBackPressed() {
        C7719c cVar = this.f15162e;
        if (cVar != null) {
            if (cVar.mo24234a()) {
                m16881a(true);
            } else {
                return;
            }
        }
        super.onBackPressed();
    }

    public ViewGroup getLayout() {
        return this.f15159b;
    }

    public void onClosedByAd(boolean z) {
        m16881a(z);
        finish();
    }

    public void showCloseButton(boolean z) {
        StringBuilder sb = new StringBuilder("Interstitial activity: Got showCloseButton from web view: ");
        sb.append(z);
        IAlog.m18021b(sb.toString());
        if (z) {
            displayInterstitialCloseBtn();
        } else {
            concealInterstitialCloseBtn();
        }
    }

    /* access modifiers changed from: protected */
    public void displayInterstitialCloseBtn() {
        View view = this.f15160c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void concealInterstitialCloseBtn() {
        View view = this.f15160c;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16881a(boolean z) {
        this.f15158a = z;
        finish();
        InneractiveAdSpot inneractiveAdSpot = this.f15161d;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot == null ? null : inneractiveAdSpot.getSelectedUnitController();
        if (selectedUnitController != null && (selectedUnitController instanceof OnInneractiveFullscreenAdDismissedListener)) {
            ((OnInneractiveFullscreenAdDismissedListener) selectedUnitController).onAdDismissed(this);
        }
    }
}
