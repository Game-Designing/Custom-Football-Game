package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.inmobi.ads.au */
/* compiled from: NativeLayoutInflater */
final class C10419au implements C10326a {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String f31706e = C10419au.class.getSimpleName();

    /* renamed from: n */
    private static Handler f31707n = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public C10452bg f31708a;

    /* renamed from: b */
    int f31709b = 0;
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public final C10586n f31710c;

    /* renamed from: d */
    NativeViewFactory f31711d;

    /* renamed from: f */
    private final WeakReference<Context> f31712f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C10406ao f31713g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C10380ah f31714h;

    /* renamed from: i */
    private final C10478c f31715i;

    /* renamed from: j */
    private C10431c f31716j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C10429a f31717k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C10430b f31718l;

    /* renamed from: m */
    private C10434ax f31719m;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f31720o = false;

    /* renamed from: p */
    private RenderView f31721p;

    /* renamed from: com.inmobi.ads.au$a */
    /* compiled from: NativeLayoutInflater */
    interface C10429a {
        /* renamed from: a */
        void mo34116a(View view, C10400ak akVar);
    }

    /* renamed from: com.inmobi.ads.au$b */
    /* compiled from: NativeLayoutInflater */
    interface C10430b {
        /* renamed from: a */
        void mo34113a(C10443bb bbVar);
    }

    /* renamed from: com.inmobi.ads.au$c */
    /* compiled from: NativeLayoutInflater */
    interface C10431c {
        /* renamed from: a */
        void mo34115a(int i, C10400ak akVar);
    }

    C10419au(Context context, C10478c cVar, C10380ah ahVar, C10406ao aoVar, C10431c cVar2, C10429a aVar, C10430b bVar) {
        this.f31712f = new WeakReference<>(context);
        this.f31714h = ahVar;
        this.f31713g = aoVar;
        this.f31716j = cVar2;
        this.f31717k = aVar;
        this.f31718l = bVar;
        this.f31710c = new C10586n();
        this.f31715i = cVar;
        this.f31711d = NativeViewFactory.m33744a(context);
    }

    /* renamed from: a */
    public final Context mo34126a() {
        return (Context) this.f31712f.get();
    }

    /* renamed from: a */
    public final C10433aw mo34128a(C10433aw awVar, ViewGroup viewGroup, RenderView renderView) {
        this.f31721p = renderView;
        C10433aw a = m34135a(awVar, viewGroup);
        if (!this.f31720o) {
            mo34129b(a, this.f31713g.f31654d);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final C10433aw mo34130b(C10433aw awVar, final ViewGroup viewGroup, RenderView renderView) {
        this.f31721p = renderView;
        final C10433aw a = m34135a(awVar, viewGroup);
        f31707n.post(new Runnable() {
            public final void run() {
                if (!C10419au.this.f31720o) {
                    C10419au auVar = C10419au.this;
                    auVar.mo34129b(a, auVar.f31713g.f31654d);
                }
            }
        });
        return a;
    }

    /* renamed from: a */
    private C10433aw m34135a(C10433aw awVar, ViewGroup viewGroup) {
        C10433aw awVar2 = awVar == null ? (C10433aw) this.f31711d.mo33936a(mo34126a(), (C10400ak) this.f31713g.f31654d, this.f31715i) : awVar;
        if (!(awVar2 == null || awVar == null)) {
            ViewParent parent = awVar2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(awVar2);
            }
            NativeViewFactory nativeViewFactory = this.f31711d;
            for (int childCount = awVar2.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = awVar2.getChildAt(childCount);
                awVar2.removeViewAt(childCount);
                nativeViewFactory.mo33937a(childAt);
            }
            NativeViewFactory.m33750a((View) awVar2, this.f31713g.f31654d.f31610c);
        }
        NativeViewFactory.m33762b(this.f31713g.f31654d.f31610c.f31633a.x);
        awVar2.setLayoutParams(NativeViewFactory.m33742a((C10400ak) this.f31713g.f31654d, viewGroup));
        return awVar2;
    }

    /* renamed from: a */
    public final ViewGroup mo34127a(ViewGroup viewGroup, C10402am amVar) {
        ViewGroup viewGroup2 = (ViewGroup) this.f31711d.mo33936a(mo34126a(), (C10400ak) amVar, this.f31715i);
        if (viewGroup2 != null) {
            viewGroup2.setLayoutParams(NativeViewFactory.m33742a((C10400ak) amVar, viewGroup));
        }
        return viewGroup2;
    }

    /* renamed from: a */
    public final int mo33858a(int i) {
        this.f31709b = i;
        this.f31716j.mo34115a(i, this.f31713g.mo34103a(i));
        return m34142d();
    }

    /* renamed from: a */
    private void m34136a(View view, final C10400ak akVar) {
        boolean z;
        final List a = this.f31710c.mo34385a(view, akVar);
        if (a == null) {
            TrackerEventType trackerEventType = TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW;
            Iterator it = akVar.f31628u.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (trackerEventType == ((NativeTracker) it.next()).f31378b) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return;
            }
        }
        view.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
                C10419au.this.f31710c.mo34386a(a);
                C10419au.this.f31714h;
                C10400ak a = C10380ah.m33923a(C10419au.this.f31714h.mo34023h(), akVar);
                C10400ak akVar = akVar;
                TrackerEventType trackerEventType = TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW;
                C10380ah e = C10419au.this.f31714h;
                if (a == null) {
                    a = akVar;
                }
                akVar.mo34086a(trackerEventType, e.mo34006a(a));
            }

            public final void onViewDetachedFromWindow(View view) {
                view.removeOnAttachStateChangeListener(this);
                C10586n d = C10419au.this.f31710c;
                List<C10589a> list = a;
                if (list != null) {
                    for (C10589a aVar : list) {
                        aVar.f32261a.cancel();
                    }
                    d.f32253a.removeAll(list);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0152, code lost:
        if (0 != r4) goto L_0x0158;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.ViewGroup mo34129b(android.view.ViewGroup r20, com.inmobi.ads.C10402am r21) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r0 = r21
            r7.m34137a(r0, r8)
            java.util.Iterator r9 = r21.iterator()
        L_0x000d:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x0365
            java.lang.Object r0 = r9.next()
            r10 = r0
            com.inmobi.ads.ak r10 = (com.inmobi.ads.C10400ak) r10
            java.lang.String r0 = r10.f31609b
            java.lang.String r1 = "CONTAINER"
            if (r1 != r0) goto L_0x008f
            java.lang.String r0 = r10.f31611d
            java.lang.String r1 = "card_scrollable"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0069
            com.inmobi.ads.NativeViewFactory r0 = r7.f31711d
            android.content.Context r1 = r19.mo34126a()
            com.inmobi.ads.c r2 = r7.f31715i
            android.view.View r0 = r0.mo33936a(r1, r10, r2)
            com.inmobi.ads.NativeScrollableContainer r0 = (com.inmobi.ads.NativeScrollableContainer) r0
            if (r0 == 0) goto L_0x0068
            int r1 = r0.getType()
            com.inmobi.ads.ao r2 = r7.f31713g
            com.inmobi.ads.ax r1 = com.inmobi.ads.C10435ay.m34163a(r1, r2, r7)
            r7.f31719m = r1
            com.inmobi.ads.ax r3 = r7.f31719m
            if (r3 == 0) goto L_0x0068
            r2 = r10
            com.inmobi.ads.am r2 = (com.inmobi.ads.C10402am) r2
            int r4 = r7.f31709b
            int r5 = r19.m34142d()
            r1 = r0
            r6 = r19
            r1.mo33856a(r2, r3, r4, r5, r6)
            android.view.ViewGroup$LayoutParams r1 = com.inmobi.ads.NativeViewFactory.m33742a(r10, r8)
            r0.setLayoutParams(r1)
            r7.m34136a(r0, r10)
            r8.addView(r0)
        L_0x0068:
            goto L_0x000d
        L_0x0069:
            com.inmobi.ads.NativeViewFactory r0 = r7.f31711d
            android.content.Context r1 = r19.mo34126a()
            com.inmobi.ads.c r2 = r7.f31715i
            android.view.View r0 = r0.mo33936a(r1, r10, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 == 0) goto L_0x008d
            r1 = r10
            com.inmobi.ads.am r1 = (com.inmobi.ads.C10402am) r1
            android.view.ViewGroup r0 = r7.mo34129b(r0, r1)
            android.view.ViewGroup$LayoutParams r1 = com.inmobi.ads.NativeViewFactory.m33742a(r10, r8)
            r0.setLayoutParams(r1)
            r7.m34136a(r0, r10)
            r8.addView(r0)
        L_0x008d:
            goto L_0x000d
        L_0x008f:
            java.lang.String r1 = "WEBVIEW"
            boolean r0 = r1.equals(r0)
            r2 = 0
            if (r0 == 0) goto L_0x00c7
            r0 = r10
            com.inmobi.ads.bf r0 = (com.inmobi.ads.C10451bf) r0
            boolean r3 = r0.f31793A
            if (r3 == 0) goto L_0x00ba
            com.inmobi.rendering.RenderView r3 = r7.f31721p
            if (r3 == 0) goto L_0x00ba
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x00b6
            android.view.ViewParent r0 = r3.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r0.removeView(r3)
        L_0x00b6:
            r7.f31721p = r2
            r2 = r3
            goto L_0x00d6
        L_0x00ba:
            java.lang.String r0 = r0.f31795z
            java.lang.String r3 = "UNKNOWN"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00d6
            goto L_0x000d
        L_0x00c7:
            java.lang.String r0 = r10.f31609b
            java.lang.String r3 = "IMAGE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00d6
            java.lang.Object r0 = r10.f31612e
            if (r0 == 0) goto L_0x000d
        L_0x00d6:
            if (r2 != 0) goto L_0x00e4
            com.inmobi.ads.NativeViewFactory r0 = r7.f31711d
            android.content.Context r2 = r19.mo34126a()
            com.inmobi.ads.c r3 = r7.f31715i
            android.view.View r2 = r0.mo33936a(r2, r10, r3)
        L_0x00e4:
            if (r2 == 0) goto L_0x0363
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r2)
            int r3 = r10.f31622o
            r4 = -1
            if (r3 == r4) goto L_0x0105
            r3 = 4
            r2.setVisibility(r3)
            android.os.Handler r3 = f31707n
            com.inmobi.ads.au$4 r5 = new com.inmobi.ads.au$4
            r5.<init>(r0)
            int r0 = r10.f31622o
            int r0 = r0 * 1000
            long r11 = (long) r0
            r3.postDelayed(r5, r11)
            goto L_0x0119
        L_0x0105:
            int r3 = r10.f31623p
            if (r3 == r4) goto L_0x0119
            android.os.Handler r3 = f31707n
            com.inmobi.ads.au$5 r5 = new com.inmobi.ads.au$5
            r5.<init>(r0)
            int r0 = r10.f31623p
            int r0 = r0 * 1000
            long r11 = (long) r0
            r3.postDelayed(r5, r11)
        L_0x0119:
            android.view.ViewGroup$LayoutParams r0 = com.inmobi.ads.NativeViewFactory.m33742a(r10, r8)
            r2.setLayoutParams(r0)
            r7.m34136a(r2, r10)
            r8.addView(r2)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = "VIDEO"
            r5 = 15
            if (r0 < r5) goto L_0x021a
            java.lang.String r0 = r10.f31609b
            if (r3 != r0) goto L_0x021a
            r6 = r10
            com.inmobi.ads.be r6 = (com.inmobi.ads.C10449be) r6
            r0 = r2
            com.inmobi.ads.NativeVideoWrapper r0 = (com.inmobi.ads.NativeVideoWrapper) r0
            com.inmobi.ads.NativeVideoView r11 = r0.getVideoView()
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x021a
            com.inmobi.ads.ak r0 = r6.f31627t
            com.inmobi.ads.am r0 = (com.inmobi.ads.C10402am) r0
            long r12 = java.lang.System.currentTimeMillis()
            if (r0 == 0) goto L_0x0157
            r14 = 0
            long r4 = r0.f31647z
            int r17 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0157
            goto L_0x0158
        L_0x0157:
            r4 = r12
        L_0x0158:
            if (r0 == 0) goto L_0x015d
            r0.f31647z = r4
        L_0x015d:
            r0 = 0
            r11.setClickable(r0)
            r4 = 2147483647(0x7fffffff, float:NaN)
            r11.setId(r4)
            r11.f31407e = r0
            r11.f31408f = r0
            java.lang.Object r0 = r6.f31612e
            com.inmobi.ads.by r0 = (com.inmobi.ads.C10476by) r0
            java.lang.String r0 = r0.mo34198b()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r11.f31403a = r0
            java.util.Map<java.lang.String, java.lang.Object> r0 = r6.f31629v
            java.lang.String r4 = "placementType"
            java.lang.Object r0 = r0.get(r4)
            com.inmobi.ads.AdContainer$RenderingProperties$PlacementType r0 = (com.inmobi.ads.AdContainer.RenderingProperties.PlacementType) r0
            com.inmobi.ads.AdContainer$RenderingProperties$PlacementType r4 = com.inmobi.ads.AdContainer.RenderingProperties.PlacementType.PLACEMENT_TYPE_FULLSCREEN
            if (r4 != r0) goto L_0x0190
            com.inmobi.ads.av r0 = new com.inmobi.ads.av
            r0.<init>()
            goto L_0x0194
        L_0x0190:
            com.inmobi.ads.av r0 = com.inmobi.ads.C10432av.m34161a()
        L_0x0194:
            r11.f31405c = r0
            int r0 = r11.f31406d
            if (r0 == 0) goto L_0x01a0
            com.inmobi.ads.av r4 = r11.f31405c
            r4.setAudioSessionId(r0)
            goto L_0x01a8
        L_0x01a0:
            com.inmobi.ads.av r0 = r11.f31405c
            int r0 = r0.getAudioSessionId()
            r11.f31406d = r0
        L_0x01a8:
            com.inmobi.ads.av r0 = r11.f31405c     // Catch:{ IOException -> 0x01d4 }
            android.content.Context r4 = r11.getContext()     // Catch:{ IOException -> 0x01d4 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ IOException -> 0x01d4 }
            android.net.Uri r5 = r11.f31403a     // Catch:{ IOException -> 0x01d4 }
            java.util.Map<java.lang.String, java.lang.String> r12 = r11.f31404b     // Catch:{ IOException -> 0x01d4 }
            r0.setDataSource(r4, r5, r12)     // Catch:{ IOException -> 0x01d4 }
            r11.setTag(r6)
            com.inmobi.ads.NativeVideoView$d r0 = new com.inmobi.ads.NativeVideoView$d
            r0.<init>(r11)
            r11.f31409g = r0
            android.view.TextureView$SurfaceTextureListener r0 = r11.f31414l
            r11.setSurfaceTextureListener(r0)
            r0 = 1
            r11.setFocusable(r0)
            r11.setFocusableInTouchMode(r0)
            r11.requestFocus()
            goto L_0x01de
        L_0x01d4:
            r0 = move-exception
            com.inmobi.ads.av r0 = r11.f31405c
            r4 = -1
            r0.f31745a = r4
            r0.f31746b = r4
        L_0x01de:
            com.inmobi.ads.ak r0 = r6.f31632y
            if (r0 == 0) goto L_0x01ea
            com.inmobi.ads.be r0 = (com.inmobi.ads.C10449be) r0
            r6.mo34156a(r0)
        L_0x01ea:
            com.inmobi.ads.au$7 r0 = new com.inmobi.ads.au$7
            r0.<init>(r6)
            r11.setQuartileCompletedListener(r0)
            com.inmobi.ads.au$8 r0 = new com.inmobi.ads.au$8
            r0.<init>(r6)
            r11.setPlaybackEventListener(r0)
            com.inmobi.ads.au$9 r0 = new com.inmobi.ads.au$9
            r0.<init>(r6)
            r11.setMediaErrorListener(r0)
            com.inmobi.ads.bg r0 = r7.f31708a
            if (r0 == 0) goto L_0x021a
            r0.mo34118a(r11)     // Catch:{ Exception -> 0x020a }
            goto L_0x021a
        L_0x020a:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "SDK encountered unexpected error in handling the onVideoViewCreated event; "
            r0.<init>(r5)
            java.lang.String r4 = r4.getMessage()
            r0.append(r4)
        L_0x021a:
            r7.m34137a(r10, r2)
            java.lang.String r0 = r10.f31609b
            java.lang.String r4 = "TIMER"
            if (r4 != r0) goto L_0x0237
            java.lang.String r0 = "timerView"
            r2.setTag(r0)
            r0 = r10
            com.inmobi.ads.bb r0 = (com.inmobi.ads.C10443bb) r0
            r4 = r2
            com.inmobi.ads.NativeTimerView r4 = (com.inmobi.ads.NativeTimerView) r4
            com.inmobi.ads.au$2 r5 = new com.inmobi.ads.au$2
            r5.<init>(r0)
            r4.setTimerEventsListener(r5)
        L_0x0237:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 15
            if (r0 < r4) goto L_0x030f
            java.lang.String r0 = r10.f31609b
            if (r3 != r0) goto L_0x030f
            r3 = r2
            com.inmobi.ads.NativeVideoWrapper r3 = (com.inmobi.ads.NativeVideoWrapper) r3
            com.inmobi.ads.bg r0 = r7.f31708a
            r3.setVideoEventListener(r0)
            com.inmobi.ads.NativeVideoView r0 = r3.f31438a
            java.lang.Object r0 = r0.getTag()
            com.inmobi.ads.be r0 = (com.inmobi.ads.C10449be) r0
            if (r0 == 0) goto L_0x030f
            com.inmobi.ads.by r4 = r0.mo34158b()     // Catch:{ Exception -> 0x02f1 }
            java.lang.String r4 = r4.mo34198b()     // Catch:{ Exception -> 0x02f1 }
            android.media.MediaMetadataRetriever r5 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x02f1 }
            r5.<init>()     // Catch:{ Exception -> 0x02f1 }
            r5.setDataSource(r4)     // Catch:{ Exception -> 0x02f1 }
            r4 = 18
            java.lang.String r4 = r5.extractMetadata(r4)     // Catch:{ Exception -> 0x02f1 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02f1 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x02f1 }
            r6 = 19
            java.lang.String r6 = r5.extractMetadata(r6)     // Catch:{ Exception -> 0x02f1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02f1 }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x02f1 }
            r5.release()     // Catch:{ Exception -> 0x02f1 }
            com.inmobi.ads.al r0 = r0.f31610c     // Catch:{ Exception -> 0x02f1 }
            android.graphics.Point r0 = r0.f31633a     // Catch:{ Exception -> 0x02f1 }
            int r5 = r0.x     // Catch:{ Exception -> 0x02f1 }
            int r5 = com.inmobi.ads.NativeViewFactory.m33765c(r5)     // Catch:{ Exception -> 0x02f1 }
            double r11 = (double) r5     // Catch:{ Exception -> 0x02f1 }
            int r5 = r0.y     // Catch:{ Exception -> 0x02f1 }
            int r5 = com.inmobi.ads.NativeViewFactory.m33765c(r5)     // Catch:{ Exception -> 0x02f1 }
            double r13 = (double) r5
            java.lang.Double.isNaN(r11)
            java.lang.Double.isNaN(r13)
            double r11 = r11 / r13
            double r4 = (double) r4
            double r13 = (double) r6
            java.lang.Double.isNaN(r4)
            java.lang.Double.isNaN(r13)
            double r15 = r4 / r13
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r6 <= 0) goto L_0x02cb
            int r6 = r0.y     // Catch:{ Exception -> 0x02f1 }
            int r6 = com.inmobi.ads.NativeViewFactory.m33765c(r6)     // Catch:{ Exception -> 0x02f1 }
            double r11 = (double) r6
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r17
            java.lang.Double.isNaN(r13)
            double r11 = r11 / r13
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r11
            int r0 = r0.y     // Catch:{ Exception -> 0x02f1 }
            int r0 = com.inmobi.ads.NativeViewFactory.m33765c(r0)     // Catch:{ Exception -> 0x02f1 }
            double r11 = (double) r0     // Catch:{ Exception -> 0x02f1 }
            goto L_0x02e9
        L_0x02cb:
            int r6 = r0.x     // Catch:{ Exception -> 0x02f1 }
            int r6 = com.inmobi.ads.NativeViewFactory.m33765c(r6)     // Catch:{ Exception -> 0x02f1 }
            double r11 = (double) r6     // Catch:{ Exception -> 0x02f1 }
            int r0 = r0.x     // Catch:{ Exception -> 0x02f1 }
            int r0 = com.inmobi.ads.NativeViewFactory.m33765c(r0)     // Catch:{ Exception -> 0x02f1 }
            r15 = r11
            double r11 = (double) r0
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r17
            java.lang.Double.isNaN(r4)
            double r11 = r11 / r4
            java.lang.Double.isNaN(r13)
            double r11 = r11 * r13
            r4 = r15
        L_0x02e9:
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x02f1 }
            int r4 = (int) r4     // Catch:{ Exception -> 0x02f1 }
            int r5 = (int) r11     // Catch:{ Exception -> 0x02f1 }
            r0.<init>(r4, r5)     // Catch:{ Exception -> 0x02f1 }
            goto L_0x0305
        L_0x02f1:
            r0 = move-exception
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r5 = -1
            r4.<init>(r5, r5)
            com.inmobi.commons.core.a.a r5 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r6 = new com.inmobi.commons.core.e.a
            r6.<init>(r0)
            r5.mo34423a(r6)
            r0 = r4
        L_0x0305:
            r4 = 13
            r0.addRule(r4)
            com.inmobi.ads.NativeVideoView r3 = r3.f31438a
            r3.setLayoutParams(r0)
        L_0x030f:
            java.lang.String r0 = r10.f31609b
            if (r1 != r0) goto L_0x0363
            boolean r0 = r2 instanceof com.inmobi.rendering.RenderView
            if (r0 == 0) goto L_0x0363
            com.inmobi.rendering.RenderView r2 = (com.inmobi.rendering.RenderView) r2
            com.inmobi.ads.bf r10 = (com.inmobi.ads.C10451bf) r10
            boolean r0 = r10.f31794B
            r2.setScrollable(r0)
            com.inmobi.ads.ah r0 = r7.f31714h
            com.inmobi.ads.ah r0 = r0.f31565n
            r2.setReferenceContainer(r0)
            com.inmobi.ads.ah r0 = r7.f31714h
            com.inmobi.rendering.RenderView$a r0 = r0.mo34043u()
            r2.setRenderViewEventListener(r0)
            com.inmobi.ads.ah r0 = r7.f31714h
            long r0 = r0.f31556e
            r2.setPlacementId(r0)
            com.inmobi.ads.ah r0 = r7.f31714h
            boolean r0 = r0.f31558g
            r2.setAllowAutoRedirection(r0)
            com.inmobi.ads.ah r0 = r7.f31714h
            java.lang.String r0 = r0.f31557f
            r2.setCreativeId(r0)
            com.inmobi.ads.ah r0 = r7.f31714h
            java.lang.String r0 = r0.f31555d
            r2.setImpressionId(r0)
            boolean r0 = r10.f31793A
            if (r0 != 0) goto L_0x0363
            com.inmobi.ads.ah r0 = r7.f31714h
            int r1 = r0.f31576y
            if (r1 != 0) goto L_0x0363
            com.inmobi.rendering.RenderView r1 = r0.f31575x
            if (r1 != 0) goto L_0x0363
            com.inmobi.rendering.RenderView r1 = r0.f31574w
            if (r1 != 0) goto L_0x0363
            r0.f31575x = r2
        L_0x0363:
            goto L_0x000d
        L_0x0365:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10419au.mo34129b(android.view.ViewGroup, com.inmobi.ads.am):android.view.ViewGroup");
    }

    /* renamed from: a */
    private void m34137a(final C10400ak akVar, View view) {
        if (akVar.f31615h) {
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C10419au.this.f31717k.mo34116a(view, akVar);
                }
            });
        }
    }

    /* renamed from: d */
    private int m34142d() {
        if (this.f31709b == 0) {
            return 8388611;
        }
        if (this.f31713g.mo34105b() - 1 == this.f31709b) {
            return 8388613;
        }
        return 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo34131b() {
        this.f31720o = true;
        this.f31712f.clear();
        C10434ax axVar = this.f31719m;
        if (axVar != null) {
            axVar.destroy();
        }
    }
}
