package com.smaato.soma.p258g;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.moat.analytics.mobile.sma.MoatFactory;
import com.moat.analytics.mobile.sma.NativeDisplayTracker;
import com.moat.analytics.mobile.sma.NativeDisplayTracker.MoatUserInteractionType;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12066Oa;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;
import com.smaato.soma.C12371g;
import com.smaato.soma.C12394h;
import com.smaato.soma.C12408ia;
import com.smaato.soma.internal.extensions.Extension;
import com.smaato.soma.internal.nativead.assets.ImageAssetModel;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p244e.C12205a;
import com.smaato.soma.p239c.p244e.p245a.C12208c;
import com.smaato.soma.p239c.p246f.p249c.C12220d;
import com.smaato.soma.p239c.p246f.p249c.C12229k;
import com.smaato.soma.p239c.p252i.C12279e;
import com.smaato.soma.p239c.p252i.C12280f;
import com.smaato.soma.p239c.p252i.C12281g;
import com.smaato.soma.p256e.C12330E;
import com.smaato.soma.p256e.C12331a;
import com.smaato.soma.p256e.C12357u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.smaato.soma.g.r */
/* compiled from: NativeAd */
public class C12389r implements C12367f, C12371g {

    /* renamed from: A */
    private C12391b f38675A;

    /* renamed from: B */
    private NativeDisplayTracker f38676B;

    /* renamed from: C */
    private AtomicInteger f38677C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public C12392c f38678D = C12392c.ALL;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public C12367f f38679E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Context f38680F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f38681G;

    /* renamed from: a */
    private AtomicInteger f38682a = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12322e f38683b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12064Na f38684c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C12205a f38685d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12229k f38686e = new C12229k();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12394h f38687f = new C12394h();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C12322e f38688g;

    /* renamed from: h */
    private int f38689h = 70;

    /* renamed from: i */
    private int f38690i = 70;

    /* renamed from: j */
    private int f38691j = 20;

    /* renamed from: k */
    private int f38692k = 15;

    /* renamed from: l */
    private int f38693l = 15;

    /* renamed from: m */
    private HorizontalScrollView f38694m;

    /* renamed from: n */
    private RelativeLayout f38695n;

    /* renamed from: o */
    private ImageView f38696o;

    /* renamed from: p */
    private ImageView f38697p;

    /* renamed from: q */
    private Button f38698q;

    /* renamed from: r */
    private MediaView f38699r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f38700s;

    /* renamed from: t */
    private TextView f38701t;

    /* renamed from: u */
    private TextView f38702u;

    /* renamed from: v */
    private RatingBar f38703v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public TextView f38704w;

    /* renamed from: x */
    private boolean f38705x = true;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public WeakReference<C12389r> f38706y;
    @Deprecated

    /* renamed from: z */
    private WeakReference<C12357u> f38707z;

    /* renamed from: com.smaato.soma.g.r$a */
    /* compiled from: NativeAd */
    private class C12390a implements OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f38708a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Vector<String> f38709b;

        public C12390a(String clickUrl, Vector<String> clickTrackingUrls) {
            this.f38708a = clickUrl;
            this.f38709b = clickTrackingUrls;
        }

        public void onClick(View v) {
            new C12388q(this).execute();
        }
    }

    /* renamed from: com.smaato.soma.g.r$b */
    /* compiled from: NativeAd */
    public interface C12391b {
        /* renamed from: a */
        void mo39878a(ViewGroup viewGroup);

        void onError(C12408ia iaVar, String str);
    }

    /* renamed from: com.smaato.soma.g.r$c */
    /* compiled from: NativeAd */
    public enum C12392c {
        APP_WALL,
        CONTENT_WALL,
        NEWS_FEED,
        CHAT_LIST,
        CAROUSEL,
        CONTENT_STREAM,
        ALL
    }

    public C12389r(Context context) {
        new C12380i(this, context).execute();
    }

    public void onReceiveAd(C12322e sender, C12064Na receivedBanner) {
        new C12381j(this, receivedBanner, sender).execute();
    }

    /* renamed from: a */
    public final C12389r mo39856a(ImageView iconImageView) {
        this.f38696o = iconImageView;
        return this;
    }

    /* renamed from: a */
    public final C12389r mo39857a(RatingBar rating) {
        this.f38703v = rating;
        return this;
    }

    /* renamed from: b */
    public final C12389r mo39866b(ImageView mainImageView) {
        this.f38697p = mainImageView;
        return this;
    }

    /* renamed from: a */
    public final C12389r mo39855a(Button clickToActionButton) {
        this.f38698q = clickToActionButton;
        return this;
    }

    /* renamed from: b */
    public final C12389r mo39867b(TextView titleView) {
        this.f38701t = titleView;
        return this;
    }

    /* renamed from: c */
    public void mo39872c(View view) {
        new C12382k(this, view).execute();
    }

    /* renamed from: d */
    public void mo39874d(View view) {
    }

    /* renamed from: a */
    public void mo39860a(View view) {
        new C12383l(this, view).execute();
    }

    /* renamed from: b */
    public void mo39869b(View view) {
        new C12384m(this).execute();
    }

    /* renamed from: d */
    public RelativeLayout mo39873d() {
        return this.f38695n;
    }

    /* renamed from: a */
    public void mo39863a(C12374c mediationNativeAdListener) {
        new C12387p(this, mediationNativeAdListener).execute();
    }

    /* renamed from: c */
    public C12394h mo39871c() {
        return this.f38687f;
    }

    /* renamed from: a */
    public void mo39862a(C12367f listener) {
        this.f38679E = listener;
    }

    /* renamed from: a */
    public final C12389r mo39858a(TextView textView) {
        this.f38702u = textView;
        return this;
    }

    /* renamed from: a */
    public boolean mo39865a(C12205a bannerNativeAd) {
        try {
            if (!(this.f38697p == null || this.f38697p.getLayoutParams() == null)) {
                LayoutParams mainImageViewLayoutParams = this.f38697p.getLayoutParams();
                int wd = mainImageViewLayoutParams.width;
                int ht = mainImageViewLayoutParams.height;
                if (wd < 0) {
                    wd = C12220d.m40201i().mo39565n();
                }
                double d = (double) wd;
                Double.isNaN(d);
                RelativeLayout.LayoutParams mediaViewLayoutParams = new RelativeLayout.LayoutParams(wd, (int) (d / 1.778d));
                if (mainImageViewLayoutParams instanceof MarginLayoutParams) {
                    MarginLayoutParams marginParams = (MarginLayoutParams) mainImageViewLayoutParams;
                    mediaViewLayoutParams.setMargins(marginParams.leftMargin, marginParams.topMargin, marginParams.rightMargin, marginParams.bottomMargin);
                }
                if (mainImageViewLayoutParams instanceof RelativeLayout.LayoutParams) {
                    int[] rules = ((RelativeLayout.LayoutParams) mainImageViewLayoutParams).getRules();
                    for (int i = 0; i < rules.length; i++) {
                        mediaViewLayoutParams.addRule(i, rules[i]);
                    }
                    this.f38697p.setVisibility(4);
                } else {
                    this.f38697p.setVisibility(8);
                }
                if (this.f38699r != null) {
                    m40728h();
                }
                this.f38699r = new MediaView(this.f38680F);
                ViewGroup mainImageParent = (ViewGroup) this.f38697p.getParent();
                mainImageParent.addView(this.f38699r, mainImageParent.indexOfChild(this.f38697p) + 1, mediaViewLayoutParams);
                if (this.f38697p.getId() > 0) {
                    this.f38699r.setId(this.f38697p.getId());
                } else {
                    if (this.f38677C == null) {
                        this.f38677C = new AtomicInteger(250);
                    }
                    this.f38699r.setId(this.f38677C.incrementAndGet());
                }
                this.f38699r.setVisibility(0);
                this.f38699r.setNativeAd(bannerNativeAd.mo39531j());
                if (mo39873d() != null) {
                    bannerNativeAd.mo39531j().registerViewForInteraction(mo39873d());
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    public void mo39859a() {
        try {
            if (this.f38676B != null) {
                this.f38676B.stopTracking();
                this.f38676B = null;
            }
            if (this.f38695n != null) {
                this.f38695n.removeAllViews();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo39868b() {
        mo39859a();
        try {
            if (!(this.f38707z == null || this.f38707z.get() == null)) {
                ((C12357u) this.f38707z.get()).mo39749a();
            }
            mo39862a((C12367f) null);
            if (this.f38688g != null) {
                this.f38688g.destroy();
                this.f38688g = null;
            }
            if (this.f38706y != null) {
                this.f38706y.clear();
            }
            if (this.f38694m != null) {
                this.f38694m.removeAllViews();
            }
            if (this.f38699r != null) {
                this.f38699r.removeAllViews();
            }
            this.f38687f = null;
            this.f38686e = null;
            if (this.f38696o != null) {
                this.f38696o.setImageResource(0);
            }
            if (this.f38697p != null) {
                this.f38697p.setImageResource(0);
            }
        } catch (NoClassDefFoundError | RuntimeException e) {
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e("NativeAd:destroy()", "Exception during destroy()", 1, C12143a.DEBUG));
        }
    }

    /* renamed from: b */
    public boolean mo39870b(C12205a bannerNativeAd) {
        return (bannerNativeAd == null || bannerNativeAd.mo39531j() == null || bannerNativeAd.mo39513a() == null || bannerNativeAd.mo39513a() != C12331a.NATIVE) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo39861a(C12064Na receivedBanner) {
        if (receivedBanner != null && receivedBanner.mo39295j() != null) {
            C12205a nativeAd = receivedBanner.mo39295j();
            C12390a commonOnClickListener = null;
            if (nativeAd.mo39524c() != null) {
                commonOnClickListener = new C12390a(nativeAd.mo39524c(), nativeAd.mo39525d());
            }
            if (!(this.f38696o == null || nativeAd.mo39526e() == null)) {
                new C12373b(this, this.f38696o).execute(new String[]{nativeAd.mo39526e()});
                this.f38696o.setOnClickListener(commonOnClickListener);
            }
            if (this.f38702u != null && !C12280f.m40428a((CharSequence) nativeAd.mo39529h())) {
                this.f38702u.setText(nativeAd.mo39529h());
                this.f38702u.setOnClickListener(commonOnClickListener);
            }
            if (!(this.f38701t == null || nativeAd.mo39528g() == null)) {
                this.f38701t.setText(nativeAd.mo39528g());
                this.f38701t.setOnClickListener(commonOnClickListener);
            }
            if (!(this.f38698q == null || C12280f.m40428a((CharSequence) nativeAd.mo39521b()) || nativeAd.mo39524c() == null)) {
                this.f38698q.setText(nativeAd.mo39521b());
                this.f38698q.setOnClickListener(commonOnClickListener);
            }
            if (this.f38703v != null && nativeAd.mo39534m() > 0.0f) {
                this.f38703v.setIsIndicator(true);
                this.f38703v.setRating(nativeAd.mo39534m());
                this.f38703v.setOnClickListener(commonOnClickListener);
                this.f38703v.setOnTouchListener(new C12375d(this));
            }
            if (!receivedBanner.mo39288e() || receivedBanner.mo39298m() == null || receivedBanner.mo39298m() != C12331a.NATIVE) {
                int mainImageID = 0;
                if (!(this.f38697p == null || nativeAd.mo39527f() == null)) {
                    new C12373b(this, this.f38697p).execute(new String[]{nativeAd.mo39527f()});
                    this.f38697p.setVisibility(0);
                    this.f38697p.setOnClickListener(commonOnClickListener);
                    MediaView mediaView = this.f38699r;
                    if (mediaView != null) {
                        mediaView.setVisibility(4);
                    }
                    mainImageID = this.f38697p.getId();
                }
                if (mainImageID < 1) {
                    if (this.f38677C == null) {
                        this.f38677C = new AtomicInteger(250);
                    }
                    mainImageID = this.f38677C.incrementAndGet();
                    ImageView imageView = this.f38697p;
                    if (imageView != null) {
                        imageView.setId(mainImageID);
                    }
                }
                RelativeLayout.LayoutParams p = (RelativeLayout.LayoutParams) this.f38698q.getLayoutParams();
                p.addRule(3, mainImageID);
                this.f38698q.setLayoutParams(p);
                RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) this.f38703v.getLayoutParams();
                param.addRule(3, mainImageID);
                this.f38703v.setLayoutParams(param);
            } else {
                if (mo39865a(nativeAd) && this.f38699r != null) {
                    RelativeLayout.LayoutParams p2 = (RelativeLayout.LayoutParams) this.f38698q.getLayoutParams();
                    p2.addRule(3, this.f38699r.getId());
                    this.f38698q.setLayoutParams(p2);
                    RelativeLayout.LayoutParams param2 = (RelativeLayout.LayoutParams) this.f38703v.getLayoutParams();
                    param2.addRule(3, this.f38699r.getId());
                    this.f38703v.setLayoutParams(param2);
                }
                m40707a(nativeAd.mo39532k());
            }
            if (this.f38705x != 0) {
                m40732j();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo39876f() {
        if (this.f38682a.get() == 0 && this.f38683b != null && this.f38684c != null && this.f38679E != null) {
            new Handler(Looper.getMainLooper()).post(new C12376e(this));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public AtomicInteger mo39875e() {
        return this.f38682a;
    }

    /* renamed from: a */
    private void m40707a(Vector<String> urls) {
        new C12279e().execute(new Vector[]{urls});
    }

    @Deprecated
    /* renamed from: a */
    public void mo39864a(WeakReference<C12357u> mediationEventNativeWeakReference) {
        this.f38707z = mediationEventNativeWeakReference;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m40723e(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0) {
                    return ((view instanceof ViewGroup) || (view.getParent() instanceof View)) ? true : true;
                }
            } catch (Exception e) {
                C12146d.m39965a(new C12147e("NATIVE", "Exception in Visibility checks", 1, C12143a.DEBUG));
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m40714b(C12392c nativeType, C12205a bannerNativeAd, RelativeLayout relativeLayout) {
        String str = "NATIVE";
        try {
            switch (C12379h.f38658a[nativeType.ordinal()]) {
                case 1:
                    m40701a(nativeType, bannerNativeAd, relativeLayout);
                    return;
                case 2:
                    m40701a(nativeType, bannerNativeAd, relativeLayout);
                    return;
                case 3:
                    m40701a(nativeType, bannerNativeAd, relativeLayout);
                    return;
                case 4:
                    m40698a(bannerNativeAd, relativeLayout);
                    return;
                case 5:
                    m40701a(nativeType, bannerNativeAd, relativeLayout);
                    return;
                case 6:
                    m40701a(nativeType, bannerNativeAd, relativeLayout);
                    return;
                default:
                    C12146d.m39965a(new C12147e(str, "Sent NativeAdType is not recognized!", 1, C12143a.ERROR));
                    return;
            }
        } catch (Exception e) {
            C12146d.m39965a(new C12147e(str, "Problem in creating Dynamic createNativeLayout()", 1, C12143a.ERROR));
        }
    }

    /* renamed from: a */
    private void m40698a(C12205a bannerNativeAd, RelativeLayout relativeLayout) {
        this.f38697p = new ImageView(this.f38680F);
        if (bannerNativeAd.mo39527f() != null) {
            new C12373b(this, this.f38697p).execute(new String[]{bannerNativeAd.mo39527f()});
            this.f38697p.setOnClickListener(new C12390a(bannerNativeAd.mo39524c(), bannerNativeAd.mo39525d()));
            mo39866b(this.f38697p);
            relativeLayout.addView(this.f38697p);
        }
        if (mo39870b(bannerNativeAd) && mo39873d() != null) {
            bannerNativeAd.mo39531j().registerViewForInteraction(mo39873d());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m40701a(com.smaato.soma.p258g.C12389r.C12392c r20, com.smaato.soma.p239c.p244e.C12205a r21, android.widget.RelativeLayout r22) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = 0
            android.content.Context r0 = r7.f38680F
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r12 = r0.density
            int r0 = r7.f38689h
            float r0 = (float) r0
            float r0 = r0 * r12
            int r13 = (int) r0
            int r0 = r7.f38690i
            float r0 = (float) r0
            float r0 = r0 * r12
            int r14 = (int) r0
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.CAROUSEL
            if (r8 == r0) goto L_0x0031
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.APP_WALL
            if (r8 == r0) goto L_0x0031
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            if (r8 == r0) goto L_0x0031
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.CHAT_LIST
            if (r8 != r0) goto L_0x0034
        L_0x0031:
            r7.m40699a(r9, r10, r13, r14)
        L_0x0034:
            boolean r0 = r7.mo39870b(r9)
            if (r0 == 0) goto L_0x005b
            android.widget.RelativeLayout r0 = r19.mo39873d()
            if (r0 == 0) goto L_0x005b
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.NEWS_FEED
            if (r8 == r0) goto L_0x0048
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            if (r8 != r0) goto L_0x005b
        L_0x0048:
            r6 = 1
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r13
            r5 = r14
            r0.m40702a(r1, r2, r3, r4, r5, r6)
            boolean r11 = r7.mo39865a(r9)
            goto L_0x0071
        L_0x005b:
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.NEWS_FEED
            if (r8 == r0) goto L_0x0063
            com.smaato.soma.g.r$c r0 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            if (r8 != r0) goto L_0x0071
        L_0x0063:
            r6 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r13
            r5 = r14
            r0.m40702a(r1, r2, r3, r4, r5, r6)
        L_0x0071:
            r0 = 0
            com.smaato.soma.g.r$c r1 = com.smaato.soma.p258g.C12389r.C12392c.CAROUSEL
            r15 = -2
            r6 = -1
            r5 = 3
            if (r8 != r1) goto L_0x00e3
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout
            android.content.Context r2 = r7.f38680F
            r1.<init>(r2)
            r4 = r1
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r0.<init>(r6, r15)
            r3 = r0
            r0 = 9
            r3.addRule(r0)
            android.widget.ImageView r0 = r7.f38696o
            if (r0 == 0) goto L_0x009f
            int r0 = r0.getId()
            if (r0 <= 0) goto L_0x009f
            android.widget.ImageView r0 = r7.f38696o
            int r0 = r0.getId()
            r3.addRule(r5, r0)
        L_0x009f:
            r4.setLayoutParams(r3)
            java.util.concurrent.atomic.AtomicInteger r0 = r7.f38677C
            int r0 = r0.incrementAndGet()
            r4.setId(r0)
            boolean r0 = r7.mo39870b(r9)
            if (r0 == 0) goto L_0x00d4
            android.widget.RelativeLayout r0 = r19.mo39873d()
            if (r0 == 0) goto L_0x00d4
            r16 = 1
            r0 = r19
            r1 = r20
            r2 = r21
            r17 = r3
            r3 = r22
            r15 = r4
            r4 = r13
            r18 = r11
            r11 = 3
            r5 = r14
            r11 = -1
            r6 = r16
            r0.m40702a(r1, r2, r3, r4, r5, r6)
            boolean r0 = r7.mo39865a(r9)
            goto L_0x00df
        L_0x00d4:
            r17 = r3
            r15 = r4
            r18 = r11
            r11 = -1
            r7.m40713b(r9, r15)
            r0 = r18
        L_0x00df:
            r10.addView(r15)
            goto L_0x00e9
        L_0x00e3:
            r18 = r11
            r11 = -1
            r15 = r0
            r0 = r18
        L_0x00e9:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout
            android.content.Context r2 = r7.f38680F
            r1.<init>(r2)
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r3 = -2
            r2.<init>(r11, r3)
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CAROUSEL
            boolean r3 = r8.equals(r3)
            r4 = 1
            if (r3 != 0) goto L_0x0117
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.APP_WALL
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L_0x0117
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L_0x0117
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CHAT_LIST
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0123
        L_0x0117:
            android.widget.ImageView r3 = r7.f38696o
            if (r3 == 0) goto L_0x0123
            int r3 = r3.getId()
            r2.addRule(r4, r3)
            goto L_0x0136
        L_0x0123:
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.NEWS_FEED
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0136
            android.widget.ImageView r3 = r7.f38697p
            if (r3 == 0) goto L_0x0136
            int r3 = r3.getId()
            r2.addRule(r4, r3)
        L_0x0136:
            r1.setLayoutParams(r2)
            r7.m40722e(r9)
            android.widget.TextView r3 = r7.f38701t
            if (r3 == 0) goto L_0x0143
            r1.addView(r3)
        L_0x0143:
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CAROUSEL
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L_0x0175
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.APP_WALL
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L_0x0175
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.NEWS_FEED
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L_0x0175
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0164
            goto L_0x0175
        L_0x0164:
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CHAT_LIST
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x017f
            r19.m40700a(r20, r21)
            android.widget.TextView r3 = r7.f38702u
            r1.addView(r3)
            goto L_0x017f
        L_0x0175:
            r7.m40720d(r9)
            android.widget.RatingBar r3 = r7.f38703v
            if (r3 == 0) goto L_0x017f
            r1.addView(r3)
        L_0x017f:
            r10.addView(r1)
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.APP_WALL
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L_0x023b
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.NEWS_FEED
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0194
            goto L_0x023b
        L_0x0194:
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L_0x01a4
            com.smaato.soma.g.r$c r3 = com.smaato.soma.p258g.C12389r.C12392c.CAROUSEL
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x023f
        L_0x01a4:
            r3 = 0
            android.widget.RelativeLayout r4 = new android.widget.RelativeLayout
            android.content.Context r5 = r7.f38680F
            r4.<init>(r5)
            r3 = r4
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r4.<init>(r11, r5)
            r5 = 12
            r4.addRule(r5)
            com.smaato.soma.g.r$c r5 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d5
            android.widget.ImageView r5 = r7.f38697p
            if (r5 == 0) goto L_0x0202
            int r5 = r5.getId()
            if (r5 <= 0) goto L_0x0202
            android.widget.ImageView r5 = r7.f38697p
            int r5 = r5.getId()
            r6 = 3
            r4.addRule(r6, r5)
            goto L_0x0202
        L_0x01d5:
            com.smaato.soma.g.r$c r5 = com.smaato.soma.p258g.C12389r.C12392c.CAROUSEL
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x0202
            if (r15 == 0) goto L_0x01ee
            int r5 = r15.getId()
            if (r5 <= 0) goto L_0x01ee
            int r5 = r15.getId()
            r6 = 3
            r4.addRule(r6, r5)
            goto L_0x0202
        L_0x01ee:
            android.widget.ImageView r5 = r7.f38696o
            if (r5 == 0) goto L_0x0202
            int r5 = r5.getId()
            if (r5 <= 0) goto L_0x0202
            android.widget.ImageView r5 = r7.f38696o
            int r5 = r5.getId()
            r6 = 3
            r4.addRule(r6, r5)
        L_0x0202:
            r3.setLayoutParams(r4)
            com.smaato.soma.g.r$c r5 = com.smaato.soma.p258g.C12389r.C12392c.CONTENT_STREAM
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x0210
            r7.m40703a(r8, r9, r10, r3)
        L_0x0210:
            r19.m40700a(r20, r21)
            android.widget.TextView r5 = r7.f38702u
            r3.addView(r5)
            if (r0 == 0) goto L_0x0237
            com.facebook.ads.MediaView r5 = r7.f38699r
            if (r5 == 0) goto L_0x0237
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            if (r5 == 0) goto L_0x0237
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r5 = (android.widget.RelativeLayout.LayoutParams) r5
            com.facebook.ads.MediaView r6 = r7.f38699r
            int r6 = r6.getId()
            r11 = 3
            r5.addRule(r11, r6)
            r3.setLayoutParams(r5)
        L_0x0237:
            r10.addView(r3)
            goto L_0x023f
        L_0x023b:
            r3 = 0
            r7.m40703a(r8, r9, r10, r3)
        L_0x023f:
            com.smaato.soma.g.r$a r3 = new com.smaato.soma.g.r$a
            java.lang.String r4 = r21.mo39524c()
            java.util.Vector r5 = r21.mo39525d()
            r3.<init>(r4, r5)
            r10.setOnClickListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p258g.C12389r.m40701a(com.smaato.soma.g.r$c, com.smaato.soma.c.e.a, android.widget.RelativeLayout):void");
    }

    /* renamed from: b */
    private void m40713b(C12205a bannerNativeAd, RelativeLayout carouselContainer) {
        int viewWidth;
        RelativeLayout relativeLayout = carouselContainer;
        Point size = new Point();
        ((WindowManager) this.f38680F.getSystemService("window")).getDefaultDisplay().getSize(size);
        int width = size.x;
        this.f38694m = new HorizontalScrollView(this.f38680F);
        this.f38694m.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f38694m.setHorizontalScrollBarEnabled(false);
        this.f38694m.setVerticalScrollBarEnabled(false);
        List<ImageView> layouts = new ArrayList<>();
        C12372a carouselGestureDetector = new C12372a(this.f38680F, this.f38694m, layouts);
        if (bannerNativeAd.mo39524c() != null) {
            carouselGestureDetector.mo39844a(bannerNativeAd.mo39524c());
        }
        List<ImageAssetModel> carouselImageModels = bannerNativeAd.mo39533l();
        LinearLayout imagesContainer = new LinearLayout(this.f38680F);
        imagesContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        imagesContainer.setOrientation(0);
        if (!C12281g.m40430a(carouselImageModels)) {
            if (carouselImageModels.size() > 1) {
                double d = (double) width;
                Double.isNaN(d);
                viewWidth = (int) (d * 0.9d);
            } else {
                viewWidth = width;
            }
            LinearLayout.LayoutParams images_params = new LinearLayout.LayoutParams(viewWidth, -2);
            Iterator it = carouselImageModels.iterator();
            while (it.hasNext()) {
                String url = ((C12208c) it.next()).mo39538b();
                if (!C12280f.m40428a((CharSequence) url)) {
                    ImageView singleCarouselView = new ImageView(this.f38680F);
                    Point size2 = size;
                    int width2 = width;
                    new C12373b(this, singleCarouselView).execute(new String[]{url});
                    singleCarouselView.setLayoutParams(images_params);
                    singleCarouselView.setAdjustViewBounds(true);
                    singleCarouselView.setCropToPadding(false);
                    layouts.add(singleCarouselView);
                    imagesContainer.addView(singleCarouselView);
                    width = width2;
                    size = size2;
                }
            }
            int i = width;
        } else {
            int i2 = width;
        }
        GestureDetector gestureDetector = new GestureDetector(this.f38680F, carouselGestureDetector);
        this.f38694m.addView(imagesContainer);
        this.f38694m.setOnTouchListener(new C12377f(this, gestureDetector));
        relativeLayout.setOnClickListener(new C12390a(bannerNativeAd.mo39524c(), bannerNativeAd.mo39525d()));
        relativeLayout.addView(this.f38694m);
    }

    /* renamed from: a */
    private void m40702a(C12392c nativeType, C12205a bannerNativeAd, RelativeLayout relativeLayout, int image_width, int image_height, boolean isFB_CSM) {
        this.f38697p = new ImageView(this.f38680F);
        this.f38697p.setAdjustViewBounds(true);
        this.f38697p.setCropToPadding(false);
        if (bannerNativeAd.mo39527f() != null) {
            new C12373b(this, this.f38697p).execute(new String[]{bannerNativeAd.mo39527f()});
        }
        RelativeLayout.LayoutParams params = null;
        if (nativeType.equals(C12392c.NEWS_FEED)) {
            params = new RelativeLayout.LayoutParams(image_width, image_height);
            params.addRule(10);
            params.addRule(9);
        } else if (nativeType.equals(C12392c.CONTENT_STREAM) || (isFB_CSM && nativeType.equals(C12392c.CAROUSEL))) {
            params = new RelativeLayout.LayoutParams(-1, -2);
            params.addRule(9);
            ImageView imageView = this.f38696o;
            if (imageView != null && imageView.getId() > 0) {
                params.addRule(3, this.f38696o.getId());
            }
        }
        this.f38697p.setLayoutParams(params);
        this.f38697p.setId(this.f38677C.incrementAndGet());
        mo39866b(this.f38697p);
        relativeLayout.addView(this.f38697p);
    }

    /* renamed from: a */
    private void m40699a(C12205a bannerNativeAd, RelativeLayout relativeLayout, int wt, int ht) {
        this.f38696o = new ImageView(this.f38680F);
        this.f38696o.setAdjustViewBounds(true);
        this.f38696o.setCropToPadding(false);
        if (bannerNativeAd.mo39526e() != null) {
            new C12373b(this, this.f38696o).execute(new String[]{bannerNativeAd.mo39526e()});
        }
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(wt, ht);
        params.addRule(10);
        params.addRule(9);
        this.f38696o.setLayoutParams(params);
        this.f38696o.setId(this.f38677C.incrementAndGet());
        mo39856a(this.f38696o);
        relativeLayout.addView(this.f38696o);
    }

    /* renamed from: d */
    private void m40720d(C12205a bannerNativeAd) {
        this.f38703v = new RatingBar(this.f38680F, null, 16842877);
        RelativeLayout.LayoutParams ratingbar_params = new RelativeLayout.LayoutParams(-2, -2);
        ratingbar_params.addRule(3, this.f38701t.getId());
        this.f38703v.setLayoutParams(ratingbar_params);
        this.f38703v.setNumStars(5);
        this.f38703v.setIsIndicator(true);
        if (bannerNativeAd.mo39534m() > 0.0f) {
            this.f38703v.setRating(bannerNativeAd.mo39534m());
        }
        mo39857a(this.f38703v);
    }

    /* renamed from: e */
    private void m40722e(C12205a bannerNativeAd) {
        this.f38701t = new TextView(this.f38680F);
        if (!C12280f.m40428a((CharSequence) bannerNativeAd.mo39528g())) {
            this.f38701t.setText(bannerNativeAd.mo39528g());
        }
        RelativeLayout.LayoutParams titleview_params = new RelativeLayout.LayoutParams(-2, -2);
        titleview_params.addRule(10);
        this.f38701t.setLayoutParams(titleview_params);
        this.f38701t.setTextSize((float) this.f38691j);
        this.f38701t.setId(this.f38677C.incrementAndGet());
        mo39867b(this.f38701t);
    }

    /* renamed from: a */
    private void m40700a(C12392c nativeType, C12205a bannerNativeAd) {
        this.f38702u = new TextView(this.f38680F);
        if (!C12280f.m40428a((CharSequence) bannerNativeAd.mo39529h())) {
            this.f38702u.setText(bannerNativeAd.mo39529h());
        }
        RelativeLayout.LayoutParams textview_params = new RelativeLayout.LayoutParams(-2, -2);
        textview_params.addRule(9);
        if (nativeType.equals(C12392c.CONTENT_STREAM)) {
            textview_params.addRule(10);
            Button button = this.f38698q;
            if (button != null && button.getId() > 0) {
                textview_params.addRule(0, this.f38698q.getId());
            }
        } else if (nativeType.equals(C12392c.CHAT_LIST)) {
            TextView textView = this.f38701t;
            if (textView != null && textView.getId() > 0) {
                textview_params.addRule(3, this.f38701t.getId());
            }
        }
        this.f38702u.setLayoutParams(textview_params);
        this.f38702u.setTextSize((float) this.f38692k);
        this.f38702u.setId(this.f38677C.incrementAndGet());
        mo39858a(this.f38702u);
    }

    /* renamed from: a */
    private void m40703a(C12392c nativeType, C12205a bannerNativeAd, RelativeLayout relativeLayout, RelativeLayout bottom_Layout) {
        this.f38698q = new Button(this.f38680F);
        this.f38698q.setTextSize((float) this.f38693l);
        if (!C12280f.m40428a((CharSequence) bannerNativeAd.mo39521b())) {
            this.f38698q.setText(bannerNativeAd.mo39521b());
        } else {
            this.f38698q.setText("Click here");
        }
        this.f38698q.setOnClickListener(new C12390a(bannerNativeAd.mo39524c(), bannerNativeAd.mo39525d()));
        RelativeLayout.LayoutParams cta_params = new RelativeLayout.LayoutParams(-2, -2);
        cta_params.addRule(11);
        cta_params.addRule(12);
        if (nativeType.equals(C12392c.CONTENT_STREAM)) {
            this.f38698q.setId(this.f38677C.incrementAndGet());
            this.f38698q.setLayoutParams(cta_params);
            bottom_Layout.addView(this.f38698q);
        } else {
            this.f38698q.setLayoutParams(cta_params);
            relativeLayout.addView(this.f38698q);
        }
        mo39855a(this.f38698q);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m40718c(com.smaato.soma.p239c.p244e.C12205a r6) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = r5.f38680F     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x001f
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout     // Catch:{ Exception -> 0x0031 }
            android.content.Context r2 = r5.f38680F     // Catch:{ Exception -> 0x0031 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0031 }
            r0 = r1
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x0031 }
            r2 = -2
            r1.<init>(r2, r2)     // Catch:{ Exception -> 0x0031 }
            r0.setLayoutParams(r1)     // Catch:{ Exception -> 0x0031 }
            com.smaato.soma.g.r$c r2 = r5.f38678D     // Catch:{ Exception -> 0x0031 }
            r5.m40714b(r2, r6, r0)     // Catch:{ Exception -> 0x0031 }
            r5.m40696a(r0)     // Catch:{ Exception -> 0x0031 }
        L_0x001e:
            goto L_0x0030
        L_0x001f:
            com.smaato.soma.g.r$b r1 = r5.m40730i()     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x001e
            com.smaato.soma.g.r$b r1 = r5.m40730i()     // Catch:{ Exception -> 0x0031 }
            com.smaato.soma.ia r2 = com.smaato.soma.C12408ia.GENERAL_ERROR     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = "context is null"
            r1.onError(r2, r3)     // Catch:{ Exception -> 0x0031 }
        L_0x0030:
            goto L_0x0043
        L_0x0031:
            r1 = move-exception
            com.smaato.soma.g.r$b r2 = r5.m40730i()
            if (r2 == 0) goto L_0x0043
            com.smaato.soma.g.r$b r2 = r5.m40730i()
            com.smaato.soma.ia r3 = com.smaato.soma.C12408ia.GENERAL_ERROR
            java.lang.String r4 = "ERROR in NativeTypeLayoutBuilding"
            r2.onError(r3, r4)
        L_0x0043:
            com.smaato.soma.g.r$b r1 = r5.m40730i()
            if (r1 == 0) goto L_0x0050
            com.smaato.soma.g.r$b r1 = r5.m40730i()
            r1.mo39878a(r0)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p258g.C12389r.m40718c(com.smaato.soma.c.e.a):void");
    }

    /* renamed from: j */
    private void m40732j() {
        try {
            m40725g();
            this.f38695n.addView(this.f38704w);
        } catch (Exception e) {
        }
    }

    /* renamed from: g */
    private void m40725g() {
        if (this.f38704w.getParent() != null) {
            ((ViewGroup) this.f38704w.getParent()).removeView(this.f38704w);
        }
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
        params.addRule(10);
        params.addRule(11);
        this.f38704w.setLayoutParams(params);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40696a(RelativeLayout relativeLayout) {
        if (this.f38705x) {
            try {
                m40725g();
                relativeLayout.addView(this.f38704w);
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m40734k() {
        C12205a aVar = this.f38685d;
        if (aVar != null) {
            m40707a(aVar.mo39532k());
        }
        Map<String, String> moatData = m40712b(this.f38684c);
        if (!moatData.isEmpty()) {
            NativeDisplayTracker nativeDisplayTracker = this.f38676B;
            if (nativeDisplayTracker != null) {
                nativeDisplayTracker.stopTracking();
            }
            if (C12066Oa.m39873b()) {
                this.f38676B = MoatFactory.create().createNativeDisplayTracker(this.f38695n, moatData);
                this.f38676B.startTracking();
            }
            this.f38695n.setOnTouchListener(new C12378g(this));
        }
    }

    /* renamed from: b */
    private Map<String, String> m40712b(C12064Na banner) {
        List<Extension> extensions = banner.mo39289f();
        if (!C12281g.m40430a(extensions)) {
            Iterator it = extensions.iterator();
            while (it.hasNext()) {
                C12204a e = (C12204a) it.next();
                if ("moat".equalsIgnoreCase(e.mo39510b())) {
                    return e.mo39509a();
                }
            }
        }
        return new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40697a(MoatUserInteractionType eventType) {
        NativeDisplayTracker nativeDisplayTracker = this.f38676B;
        if (nativeDisplayTracker != null) {
            nativeDisplayTracker.reportUserInteractionEvent(eventType);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public C12391b m40730i() {
        return this.f38675A;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40716b(Vector<String> clickTrackingUrls) {
        if (!this.f38681G) {
            new C12279e().execute(new Vector[]{clickTrackingUrls});
        }
        this.f38681G = true;
    }

    /* renamed from: h */
    private void m40728h() {
        try {
            this.f38699r.removeAllViews();
            C12330E.m40539a(this.f38699r);
            this.f38699r = null;
            System.gc();
        } catch (Exception e) {
        }
    }
}
