package com.inmobi.rendering;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.ads.AdContainer;
import com.inmobi.ads.AdContainer.RenderingProperties;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10380ah;
import com.inmobi.ads.C10406ao;
import com.inmobi.ads.C10445bd;
import com.inmobi.ads.C10449be;
import com.inmobi.ads.C10478c;
import com.inmobi.ads.C10478c.C10490l;
import com.inmobi.ads.C10503ca;
import com.inmobi.ads.NativeVideoView;
import com.inmobi.ads.NativeVideoWrapper;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10681a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.rendering.RenderView.C10734a;
import com.mopub.common.AdType;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(15)
public class InMobiAdActivity extends Activity {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: b */
    public static Map<Integer, C10719a> f32686b = new HashMap();
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: c */
    public static Map<Integer, Intent> f32687c = new HashMap();

    /* renamed from: d */
    public static Integer f32688d;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: e */
    public static Map<Integer, C10720b> f32689e = new HashMap();

    /* renamed from: f */
    public static Integer f32690f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final String f32691g = InMobiAdActivity.class.getSimpleName();

    /* renamed from: h */
    private static SparseArray<AdContainer> f32692h = new SparseArray<>();

    /* renamed from: i */
    private static RenderView f32693i;

    /* renamed from: j */
    private static C10734a f32694j;

    /* renamed from: a */
    public boolean f32695a = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AdContainer f32696k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public RenderView f32697l;

    /* renamed from: m */
    private CustomView f32698m;

    /* renamed from: n */
    private CustomView f32699n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public NativeVideoView f32700o;

    /* renamed from: p */
    private int f32701p;

    /* renamed from: q */
    private int f32702q;

    /* renamed from: r */
    private boolean f32703r = false;

    /* renamed from: s */
    private boolean f32704s = false;

    /* renamed from: com.inmobi.rendering.InMobiAdActivity$a */
    public interface C10719a {
        /* renamed from: a */
        void mo34552a();
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity$b */
    public interface C10720b {
        /* renamed from: a */
        void mo34553a(int[] iArr);
    }

    static {
        Integer valueOf = Integer.valueOf(0);
        f32688d = valueOf;
        f32690f = valueOf;
    }

    /* renamed from: a */
    public static int m35177a(AdContainer adContainer) {
        int hashCode = adContainer.hashCode();
        f32692h.put(hashCode, adContainer);
        return hashCode;
    }

    /* renamed from: a */
    public static void m35182a(Object obj) {
        f32692h.remove(obj.hashCode());
    }

    /* renamed from: a */
    public static void m35181a(RenderView renderView) {
        f32693i = renderView;
    }

    /* renamed from: a */
    public static void m35180a(C10734a aVar) {
        f32694j = aVar;
    }

    /* renamed from: a */
    public static int m35176a(Intent intent, C10719a aVar) {
        f32688d = Integer.valueOf(f32688d.intValue() + 1);
        f32686b.put(f32688d, aVar);
        f32687c.put(f32688d, intent);
        return f32688d.intValue();
    }

    /* renamed from: a */
    public static void m35183a(String[] strArr, C10720b bVar) {
        try {
            if (C10619a.m34838a()) {
                f32690f = Integer.valueOf(f32690f.intValue() + 1);
                f32689e.put(f32690f, bVar);
                int intValue = f32690f.intValue();
                Intent intent = new Intent(C10619a.m34839b(), InMobiAdActivity.class);
                intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 104);
                intent.putExtra("id", intValue);
                intent.putExtra("permissions", strArr);
                C10619a.m34834a(C10619a.m34839b(), intent);
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error while requesting permissions; ").append(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f32695a) {
            int i = this.f32701p;
            if (100 == i) {
                RenderView renderView = this.f32697l;
                if (!(renderView == null || renderView.getFullScreenEventsListener() == null)) {
                    try {
                        if (!this.f32703r) {
                            this.f32703r = true;
                            this.f32697l.getFullScreenEventsListener().mo33693a(this.f32697l);
                        }
                    } catch (Exception e) {
                    }
                }
            } else if (this.f32702q == 200 && 102 == i) {
                AdContainer adContainer = this.f32696k;
                if (!(adContainer == null || adContainer.getFullScreenEventsListener() == null)) {
                    try {
                        if (!this.f32703r) {
                            this.f32703r = true;
                            this.f32696k.getFullScreenEventsListener().mo33693a(null);
                        }
                    } catch (Exception e2) {
                    }
                }
            } else if (201 == this.f32702q) {
                if (this.f32696k instanceof C10445bd) {
                    NativeVideoView nativeVideoView = this.f32700o;
                    if (nativeVideoView != null) {
                        final C10449be beVar = (C10449be) nativeVideoView.getTag();
                        if (beVar != null && this.f32704s) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                public final void run() {
                                    if (InMobiAdActivity.this.f32696k == null) {
                                        return;
                                    }
                                    if (InMobiAdActivity.this.f32696k.getRenderingProperties().f31249a != PlacementType.PLACEMENT_TYPE_FULLSCREEN || !((Boolean) beVar.f31629v.get("didCompleteQ4")).booleanValue()) {
                                        InMobiAdActivity.this.f32700o.start();
                                    }
                                }
                            }, 50);
                        }
                        if (this.f32696k.getFullScreenEventsListener() != null) {
                            try {
                                if (!this.f32703r) {
                                    this.f32703r = true;
                                    this.f32696k.getFullScreenEventsListener().mo33693a(beVar);
                                }
                            } catch (Exception e3) {
                                C10621a.m34854a().mo34423a(new C10658a(e3));
                            }
                        }
                    }
                }
                AdContainer adContainer2 = this.f32696k;
                if (adContainer2 instanceof C10380ah) {
                    try {
                        if (!this.f32703r) {
                            this.f32703r = true;
                            adContainer2.getFullScreenEventsListener().mo33693a(null);
                        }
                    } catch (Exception e4) {
                        C10621a.m34854a().mo34423a(new C10658a(e4));
                    }
                }
            }
            this.f32704s = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        String str = "time";
        super.onStart();
        if (!this.f32695a && 102 == this.f32701p) {
            AdContainer adContainer = this.f32696k;
            if (adContainer != null) {
                C10503ca viewableAd = adContainer.getViewableAd();
                int i = this.f32702q;
                String str2 = "SDK encountered unexpected error in enabling impression tracking on this ad: ";
                if (200 == i) {
                    if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == this.f32696k.getRenderingProperties().f31249a) {
                        try {
                            viewableAd.mo33959a(this.f32698m, this.f32699n);
                        } catch (Exception e) {
                            new StringBuilder(str2).append(e.getMessage());
                            if (this.f32696k.getFullScreenEventsListener() != null) {
                                this.f32696k.getFullScreenEventsListener().mo33692a();
                            }
                        }
                    }
                } else if (201 == i) {
                    try {
                        C10478c cVar = new C10478c();
                        C10641b.m34915a().mo34452a((C10639a) cVar, (C10644c) null);
                        if (viewableAd.mo33960b() != null) {
                            if (this.f32696k instanceof C10445bd) {
                                C10449be beVar = (C10449be) this.f32700o.getTag();
                                if (beVar != null) {
                                    C10490l lVar = cVar.f31899k;
                                    int i2 = lVar.f31970g;
                                    if (beVar.f31790G.containsKey(str)) {
                                        i2 = ((Integer) beVar.f31790G.get(str)).intValue();
                                    }
                                    lVar.f31970g = i2;
                                    viewableAd.mo33959a(new View[0]);
                                }
                            } else if (this.f32696k instanceof C10380ah) {
                                try {
                                    viewableAd.mo33959a(new View[0]);
                                } catch (Exception e2) {
                                    new StringBuilder(str2).append(e2.getMessage());
                                    if (this.f32696k.getFullScreenEventsListener() != null) {
                                        this.f32696k.getFullScreenEventsListener().mo33692a();
                                    }
                                }
                            }
                        }
                    } catch (Exception e3) {
                        new StringBuilder(str2).append(e3.getMessage());
                        if (this.f32696k.getFullScreenEventsListener() != null) {
                            this.f32696k.getFullScreenEventsListener().mo33692a();
                        }
                        C10621a.m34854a().mo34423a(new C10658a(e3));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        View view;
        C10478c cVar;
        super.onCreate(bundle);
        if (!C10619a.m34838a()) {
            finish();
            Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "Session not found, AdActivity will be closed");
            return;
        }
        this.f32703r = false;
        this.f32701p = getIntent().getIntExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
        int i = this.f32701p;
        if (i == 100) {
            String stringExtra = getIntent().getStringExtra("com.inmobi.rendering.InMobiAdActivity.IN_APP_BROWSER_URL");
            long longExtra = getIntent().getLongExtra("placementId", Long.MIN_VALUE);
            boolean booleanExtra = getIntent().getBooleanExtra("allowAutoRedirection", false);
            String stringExtra2 = getIntent().getStringExtra("impressionId");
            String stringExtra3 = getIntent().getStringExtra("creativeId");
            this.f32697l = new RenderView(this, new RenderingProperties(PlacementType.PLACEMENT_TYPE_FULLSCREEN), null, stringExtra2);
            this.f32697l.setPlacementId(longExtra);
            this.f32697l.setCreativeId(stringExtra3);
            this.f32697l.setAllowAutoRedirection(booleanExtra);
            C10734a aVar = RenderView.f32713a;
            RenderView renderView = f32693i;
            if (renderView != null) {
                aVar = renderView.getListener();
                cVar = f32693i.getAdConfig();
            } else {
                cVar = new C10478c();
                C10734a aVar2 = f32694j;
                if (aVar2 != null) {
                    aVar = aVar2;
                }
            }
            this.f32697l.setIsInAppBrowser(true);
            this.f32697l.mo34554a(aVar, cVar);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(10);
            layoutParams.addRule(2, 65533);
            relativeLayout.setBackgroundColor(-1);
            relativeLayout.addView(this.f32697l, layoutParams);
            float f = C10692c.m35104a().f32629c;
            LinearLayout linearLayout = new LinearLayout(this);
            LayoutParams layoutParams2 = new LayoutParams(-1, (int) (48.0f * f));
            linearLayout.setOrientation(0);
            linearLayout.setId(65533);
            linearLayout.setWeightSum(100.0f);
            linearLayout.setBackgroundResource(17301658);
            linearLayout.setBackgroundColor(-7829368);
            layoutParams2.addRule(12);
            relativeLayout.addView(linearLayout, layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams3.weight = 25.0f;
            CustomView customView = new CustomView(this, f, 2);
            customView.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.setBackgroundColor(-7829368);
                        InMobiAdActivity.this.f32695a = true;
                        InMobiAdActivity.this.finish();
                        return true;
                    } else if (motionEvent.getAction() != 0) {
                        return true;
                    } else {
                        view.setBackgroundColor(-16711681);
                        return true;
                    }
                }
            });
            linearLayout.addView(customView, layoutParams3);
            CustomView customView2 = new CustomView(this, f, 3);
            customView2.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.setBackgroundColor(-7829368);
                        InMobiAdActivity.this.f32697l.reload();
                        return true;
                    } else if (motionEvent.getAction() != 0) {
                        return true;
                    } else {
                        view.setBackgroundColor(-16711681);
                        return true;
                    }
                }
            });
            linearLayout.addView(customView2, layoutParams3);
            CustomView customView3 = new CustomView(this, f, 4);
            customView3.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.setBackgroundColor(-7829368);
                        if (InMobiAdActivity.this.f32697l.canGoBack()) {
                            InMobiAdActivity.this.f32697l.goBack();
                        } else {
                            InMobiAdActivity.this.f32695a = true;
                            InMobiAdActivity.this.finish();
                        }
                        return true;
                    } else if (motionEvent.getAction() != 0) {
                        return true;
                    } else {
                        view.setBackgroundColor(-16711681);
                        return true;
                    }
                }
            });
            linearLayout.addView(customView3, layoutParams3);
            CustomView customView4 = new CustomView(this, f, 6);
            customView4.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.setBackgroundColor(-7829368);
                        if (InMobiAdActivity.this.f32697l.canGoForward()) {
                            InMobiAdActivity.this.f32697l.goForward();
                        }
                        return true;
                    } else if (motionEvent.getAction() != 0) {
                        return true;
                    } else {
                        view.setBackgroundColor(-16711681);
                        return true;
                    }
                }
            });
            linearLayout.addView(customView4, layoutParams3);
            setContentView(relativeLayout);
            this.f32697l.loadUrl(stringExtra);
            this.f32697l.setFullScreenActivityContext(this);
            return;
        }
        if (i == 102) {
            String str = "com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX";
            if (getIntent().hasExtra(str)) {
                this.f32696k = (AdContainer) f32692h.get(getIntent().getIntExtra(str, -1));
                if (this.f32696k == null) {
                    finish();
                    return;
                }
                this.f32702q = getIntent().getIntExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 0);
                if (this.f32702q == 0) {
                    if (this.f32696k.getFullScreenEventsListener() != null) {
                        this.f32696k.getFullScreenEventsListener().mo33692a();
                    }
                    finish();
                    return;
                }
                if (getIntent().getBooleanExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", false)) {
                    requestWindowFeature(1);
                    getWindow().setFlags(Opcodes.ACC_ABSTRACT, Opcodes.ACC_ABSTRACT);
                }
                int i2 = this.f32702q;
                String str2 = AdType.HTML;
                if (200 != i2 || str2.equals(this.f32696k.getMarkupType())) {
                    String str3 = "inmobiJson";
                    if (201 != this.f32702q || str3.equals(this.f32696k.getMarkupType())) {
                        try {
                            this.f32696k.setFullScreenActivityContext(this);
                            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
                            RelativeLayout relativeLayout2 = new RelativeLayout(getApplicationContext());
                            relativeLayout2.setId(65534);
                            float f2 = C10692c.m35104a().f32629c;
                            if (str2.equals(this.f32696k.getMarkupType())) {
                                relativeLayout2.setBackgroundColor(0);
                                LayoutParams layoutParams4 = new LayoutParams(-1, -1);
                                layoutParams4.addRule(10);
                                int i3 = (int) (50.0f * f2);
                                LayoutParams layoutParams5 = new LayoutParams(i3, i3);
                                layoutParams5.addRule(11);
                                this.f32698m = new CustomView(this, f2, 0);
                                this.f32698m.setId(65532);
                                this.f32698m.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        InMobiAdActivity.this.f32695a = true;
                                        try {
                                            InMobiAdActivity.this.f32696k.mo33680b();
                                        } catch (Exception e) {
                                            InMobiAdActivity.f32691g;
                                            new StringBuilder("Encountered unexpected error in processing close request: ").append(e.getMessage());
                                            Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "SDK encountered unexpected error in processing close request");
                                        }
                                    }
                                });
                                this.f32699n = new CustomView(this, f2, 1);
                                this.f32699n.setId(65531);
                                this.f32699n.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        InMobiAdActivity.this.f32695a = true;
                                        try {
                                            InMobiAdActivity.this.f32696k.mo33680b();
                                        } catch (Exception e) {
                                            InMobiAdActivity.f32691g;
                                            new StringBuilder("Encountered unexpected error in processing close request: ").append(e.getMessage());
                                            Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "SDK encountered unexpected error in processing close request");
                                        }
                                    }
                                });
                                View a = this.f32696k.getViewableAd().mo34004a();
                                if (a != null) {
                                    ViewGroup viewGroup = (ViewGroup) a.getParent();
                                    if (viewGroup != null) {
                                        viewGroup.removeView(a);
                                    }
                                    relativeLayout2.addView(a, layoutParams4);
                                    relativeLayout2.addView(this.f32698m, layoutParams5);
                                    relativeLayout2.addView(this.f32699n, layoutParams5);
                                    ((RenderView) this.f32696k).mo34561a(((RenderView) this.f32696k).f32761p);
                                    ((RenderView) this.f32696k).mo34564b(((RenderView) this.f32696k).f32758m);
                                }
                            } else if (str3.equals(this.f32696k.getMarkupType())) {
                                PlacementType placementType = this.f32696k.getRenderingProperties().f31249a;
                                relativeLayout2.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
                                C10406ao aoVar = (C10406ao) this.f32696k.getDataModel();
                                Point point = aoVar.f31654d.f31610c.f31633a;
                                C10641b.m34915a().mo34452a((C10639a) new C10478c(), (C10644c) null);
                                C10503ca viewableAd = this.f32696k.getViewableAd();
                                if (aoVar.f31653c) {
                                    view = viewableAd.mo33960b();
                                } else {
                                    view = null;
                                }
                                if (view == null) {
                                    view = viewableAd.mo33956a(null, relativeLayout2, false);
                                }
                                if (this.f32696k instanceof C10445bd) {
                                    NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) this.f32696k.getVideoContainerView();
                                    if (nativeVideoWrapper != null) {
                                        this.f32700o = nativeVideoWrapper.getVideoView();
                                        this.f32700o.requestFocus();
                                        C10449be beVar = (C10449be) this.f32700o.getTag();
                                        if (beVar.f31632y != null) {
                                            beVar.mo34156a((C10449be) beVar.f31632y);
                                        }
                                        String str4 = "placementType";
                                        if (PlacementType.PLACEMENT_TYPE_INLINE == placementType) {
                                            beVar.f31629v.put(str4, PlacementType.PLACEMENT_TYPE_INLINE);
                                        } else {
                                            beVar.f31629v.put(str4, PlacementType.PLACEMENT_TYPE_FULLSCREEN);
                                        }
                                    }
                                }
                                if (view != null) {
                                    relativeLayout2.addView(view, new LayoutParams(point.x, point.y));
                                }
                                this.f32696k.setRequestedScreenOrientation();
                            } else {
                                if (this.f32696k.getFullScreenEventsListener() != null) {
                                    this.f32696k.getFullScreenEventsListener().mo33692a();
                                }
                                finish();
                                return;
                            }
                            frameLayout.addView(relativeLayout2, new LayoutParams(-1, -1));
                            return;
                        } catch (Exception e) {
                            this.f32696k.setFullScreenActivityContext(null);
                            if (this.f32696k.getFullScreenEventsListener() != null) {
                                this.f32696k.getFullScreenEventsListener().mo33692a();
                            }
                            finish();
                            C10621a.m34854a().mo34423a(new C10658a(e));
                            return;
                        }
                    }
                }
                if (this.f32696k.getFullScreenEventsListener() != null) {
                    this.f32696k.getFullScreenEventsListener().mo33692a();
                }
                finish();
            }
        } else {
            String str5 = "id";
            if (i == 103) {
                int intExtra = getIntent().getIntExtra(str5, -1);
                if (intExtra != -1) {
                    startActivityForResult((Intent) f32687c.get(Integer.valueOf(intExtra)), intExtra);
                }
            } else if (i == 104) {
                int intExtra2 = getIntent().getIntExtra(str5, -1);
                if (intExtra2 != -1) {
                    String[] stringArrayExtra = getIntent().getStringArrayExtra("permissions");
                    if (stringArrayExtra != null && stringArrayExtra.length > 0 && VERSION.SDK_INT >= 23) {
                        C10681a.m35069b();
                        requestPermissions(stringArrayExtra, intExtra2);
                    }
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (!this.f32695a) {
            this.f32704s = true;
            NativeVideoView nativeVideoView = this.f32700o;
            if (nativeVideoView != null) {
                nativeVideoView.pause();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        String str = "SDK encountered unexpected error while finishing fullscreen view";
        String str2 = "Encountered unexpected error in onAdScreenDismissed handler: ";
        String str3 = "InMobi";
        if (this.f32695a) {
            int i = this.f32701p;
            if (100 == i) {
                RenderView renderView = this.f32697l;
                if (!(renderView == null || renderView.getFullScreenEventsListener() == null)) {
                    try {
                        this.f32697l.getFullScreenEventsListener().mo33694b(this.f32697l);
                        this.f32697l.destroy();
                        this.f32697l = null;
                    } catch (Exception e) {
                    }
                }
            } else if (102 == i) {
                AdContainer adContainer = this.f32696k;
                if (!(adContainer == null || adContainer.getFullScreenEventsListener() == null)) {
                    int i2 = this.f32702q;
                    if (200 == i2) {
                        try {
                            this.f32696k.getFullScreenEventsListener().mo33694b(null);
                        } catch (Exception e2) {
                            new StringBuilder(str2).append(e2.getMessage());
                            Logger.m35065a(InternalLogLevel.DEBUG, str3, str);
                        }
                    } else if (201 == i2 && VERSION.SDK_INT >= 15) {
                        AdContainer adContainer2 = this.f32696k;
                        if (adContainer2 instanceof C10445bd) {
                            NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) ((C10445bd) adContainer2).getVideoContainerView();
                            if (nativeVideoWrapper != null) {
                                try {
                                    this.f32696k.getFullScreenEventsListener().mo33694b((C10449be) nativeVideoWrapper.getVideoView().getTag());
                                } catch (Exception e3) {
                                    new StringBuilder(str2).append(e3.getMessage());
                                    Logger.m35065a(InternalLogLevel.DEBUG, str3, str);
                                    C10621a.m34854a().mo34423a(new C10658a(e3));
                                }
                            }
                        } else if (adContainer2 instanceof C10380ah) {
                            try {
                                adContainer2.getFullScreenEventsListener().mo33694b(null);
                            } catch (Exception e4) {
                                new StringBuilder(str2).append(e4.getMessage());
                                Logger.m35065a(InternalLogLevel.DEBUG, str3, str);
                                C10621a.m34854a().mo34423a(new C10658a(e4));
                            }
                        }
                    }
                }
            }
            AdContainer adContainer3 = this.f32696k;
            if (adContainer3 != null) {
                adContainer3.destroy();
                this.f32696k = null;
            }
        } else {
            int i3 = this.f32701p;
            if (100 != i3 && 102 == i3) {
                AdContainer adContainer4 = this.f32696k;
                if (adContainer4 != null) {
                    int i4 = this.f32702q;
                    if (200 == i4) {
                        RenderView renderView2 = (RenderView) adContainer4;
                        renderView2.setFullScreenActivityContext(null);
                        try {
                            renderView2.mo33680b();
                        } catch (Exception e5) {
                            new StringBuilder("Encountered unexpected error in processing close request: ").append(e5.getMessage());
                            Logger.m35065a(InternalLogLevel.DEBUG, str3, "SDK encountered unexpected error in processing close request");
                        }
                    } else if (201 == i4 && VERSION.SDK_INT >= 15) {
                        if (adContainer4 instanceof C10445bd) {
                            C10445bd bdVar = (C10445bd) adContainer4;
                            NativeVideoView nativeVideoView = this.f32700o;
                            if (nativeVideoView != null) {
                                C10449be beVar = (C10449be) nativeVideoView.getTag();
                                if (beVar != null) {
                                    if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == bdVar.f31553b.f31249a) {
                                        this.f32700o.mo33879a();
                                    }
                                    if (this.f32696k.getFullScreenEventsListener() != null) {
                                        try {
                                            this.f32696k.getFullScreenEventsListener().mo33694b(beVar);
                                        } catch (Exception e6) {
                                            new StringBuilder(str2).append(e6.getMessage());
                                            Logger.m35065a(InternalLogLevel.DEBUG, str3, str);
                                            C10621a.m34854a().mo34423a(new C10658a(e6));
                                        }
                                    }
                                }
                            }
                        } else if ((adContainer4 instanceof C10380ah) && adContainer4.getFullScreenEventsListener() != null) {
                            try {
                                this.f32696k.getFullScreenEventsListener().mo33694b(null);
                            } catch (Exception e7) {
                                new StringBuilder(str2).append(e7.getMessage());
                                Logger.m35065a(InternalLogLevel.DEBUG, str3, str);
                                C10621a.m34854a().mo34423a(new C10658a(e7));
                            }
                        }
                    }
                    m35182a((Object) this.f32696k);
                    this.f32696k.destroy();
                    this.f32696k = null;
                }
            }
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RenderView renderView = this.f32697l;
        if (renderView != null) {
            if ("Resized".equals(renderView.f32749d) && renderView.getResizeProperties() != null) {
                renderView.f32752g.mo34786a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C10719a aVar = (C10719a) f32686b.remove(Integer.valueOf(i));
        if (aVar != null) {
            f32687c.remove(Integer.valueOf(i));
            aVar.mo34552a();
            this.f32695a = true;
            finish();
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (!z) {
            RenderView renderView = this.f32697l;
            if (renderView != null) {
                renderView.setOrientationProperties(renderView.getOrientationProperties());
            }
            AdContainer adContainer = this.f32696k;
            if (adContainer != null) {
                adContainer.setRequestedScreenOrientation();
            }
        }
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        onMultiWindowModeChanged(z);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C10681a.m35070c();
        C10720b bVar = (C10720b) f32689e.remove(Integer.valueOf(i));
        if (bVar != null) {
            bVar.mo34553a(iArr);
        }
        finish();
    }

    public void onBackPressed() {
        String str = "isFullScreen";
        String str2 = "didRequestFullScreen";
        int i = this.f32701p;
        if (i == 102) {
            AdContainer adContainer = this.f32696k;
            if (adContainer != null && !adContainer.mo33681c()) {
                String str3 = "InMobi";
                boolean z = false;
                if (200 == this.f32702q) {
                    RenderView renderView = (RenderView) this.f32696k;
                    if (renderView != null) {
                        if (renderView.f32763r != null) {
                            z = true;
                        }
                        if (z) {
                            renderView.mo34556a(renderView.f32763r, "broadcastEvent('backButtonPressed')");
                        }
                        if (!renderView.f32762q) {
                            this.f32695a = true;
                            try {
                                renderView.mo33680b();
                                return;
                            } catch (Exception e) {
                                new StringBuilder("Encountered unexpected error in processing close request: ").append(e.getMessage());
                                Logger.m35065a(InternalLogLevel.DEBUG, str3, "SDK encountered unexpected error in processing close request");
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                }
                AdContainer adContainer2 = this.f32696k;
                if (adContainer2 instanceof C10445bd) {
                    C10445bd bdVar = (C10445bd) adContainer2;
                    if (bdVar != null && !bdVar.mo34023h().f31652b) {
                        this.f32695a = true;
                        NativeVideoView nativeVideoView = this.f32700o;
                        if (nativeVideoView != null) {
                            C10449be beVar = (C10449be) nativeVideoView.getTag();
                            if (beVar != null) {
                                if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == bdVar.f31553b.f31249a) {
                                    this.f32700o.mo33879a();
                                }
                                try {
                                    if (((Boolean) beVar.f31629v.get(str)).booleanValue()) {
                                        beVar.f31629v.put("seekPosition", Integer.valueOf(this.f32700o.getCurrentPosition()));
                                        if (!bdVar.f31563l && ((Boolean) beVar.f31629v.get(str2)).booleanValue()) {
                                            beVar.f31629v.put(str2, Boolean.valueOf(false));
                                            if (beVar.f31632y != null) {
                                                beVar.f31632y.f31629v.put(str2, Boolean.valueOf(false));
                                            }
                                            bdVar.mo33680b();
                                            beVar.f31629v.put(str, Boolean.valueOf(false));
                                        }
                                    }
                                    return;
                                } catch (Exception e2) {
                                    new StringBuilder("Encountered unexpected error in onVideoClosed handler: ").append(e2.getMessage());
                                    Logger.m35065a(InternalLogLevel.DEBUG, str3, "SDK encountered unexpected error in closing video");
                                    C10621a.m34854a().mo34423a(new C10658a(e2));
                                }
                            }
                            return;
                        }
                        finish();
                    }
                } else if (adContainer2 instanceof C10380ah) {
                    C10380ah ahVar = (C10380ah) adContainer2;
                    if (ahVar == null) {
                        finish();
                    } else if (!ahVar.mo34023h().f31652b) {
                        ahVar.mo33680b();
                    }
                }
            }
        } else if (i == 100) {
            this.f32695a = true;
            finish();
        }
    }
}
