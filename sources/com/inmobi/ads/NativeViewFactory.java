package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inmobi.ads.AdContainer.RenderingProperties;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10441ba.C10442a;
import com.inmobi.ads.NativeContainerLayout.C10324a;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.rendering.CustomView;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.squareup.picasso.Callback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

class NativeViewFactory {

    /* renamed from: a */
    private static final String f31443a = NativeViewFactory.class.getSimpleName();

    /* renamed from: c */
    private static final Map<Class, Integer> f31444c;

    /* renamed from: e */
    private static volatile WeakReference<NativeViewFactory> f31445e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static WeakReference<Context> f31446f;

    /* renamed from: g */
    private static int f31447g = 1;

    /* renamed from: h */
    private static int f31448h = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f31449b;

    /* renamed from: d */
    private Map<Integer, C10358c> f31450d = new HashMap();

    static class PicassoCallback implements Callback {

        /* renamed from: a */
        private WeakReference<Context> f31465a;

        /* renamed from: b */
        private WeakReference<ImageView> f31466b;

        /* renamed from: c */
        private C10400ak f31467c;

        PicassoCallback(Context context, ImageView imageView, C10400ak akVar) {
            this.f31465a = new WeakReference<>(context);
            this.f31466b = new WeakReference<>(imageView);
            this.f31467c = akVar;
        }

        public void onSuccess() {
        }

        public void onError() {
            NativeViewFactory.m33749a((Context) this.f31465a.get(), (ImageView) this.f31466b.get(), this.f31467c);
        }
    }

    /* renamed from: com.inmobi.ads.NativeViewFactory$a */
    private static final class C10356a implements Runnable {

        /* renamed from: a */
        private WeakReference<Context> f31468a;

        /* renamed from: b */
        private WeakReference<ImageView> f31469b;

        C10356a(Context context, ImageView imageView) {
            this.f31468a = new WeakReference<>(context);
            this.f31469b = new WeakReference<>(imageView);
        }

        public final void run() {
            Context context = (Context) this.f31468a.get();
            ImageView imageView = (ImageView) this.f31469b.get();
            if (context != null && imageView != null) {
                NativeViewFactory.m33763b(context, imageView);
            }
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    /* renamed from: com.inmobi.ads.NativeViewFactory$b */
    private static final class C10357b extends TextView {
        public C10357b(Context context) {
            super(context);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        public final void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            int lineHeight = getLineHeight() > 0 ? i2 / getLineHeight() : 0;
            if (lineHeight > 0) {
                setSingleLine(false);
                setLines(lineHeight);
            }
            if (lineHeight == 1) {
                setSingleLine();
            }
        }
    }

    /* renamed from: com.inmobi.ads.NativeViewFactory$c */
    private abstract class C10358c {

        /* renamed from: a */
        private int f31470a = 0;

        /* renamed from: b */
        LinkedList<View> f31471b = new LinkedList<>();

        /* renamed from: d */
        private int f31473d = 0;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract View mo33938a(Context context);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo33939a(View view, C10400ak akVar, C10478c cVar) {
            view.setVisibility(akVar.f31631x);
            view.setOnClickListener(null);
        }

        public C10358c() {
        }

        /* renamed from: a */
        public boolean mo33940a(View view) {
            NativeViewFactory.m33764b(view);
            view.setOnClickListener(null);
            this.f31471b.addLast(view);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            NativeViewFactory.this.f31449b = NativeViewFactory.this.f31449b + 1;
            return true;
        }

        /* renamed from: a */
        public final View mo33947a(Context context, C10400ak akVar, C10478c cVar) {
            View view;
            NativeViewFactory.f31446f = new WeakReference(context);
            if (this.f31471b.isEmpty()) {
                this.f31470a++;
                view = mo33938a(context);
            } else {
                this.f31473d++;
                view = (View) this.f31471b.removeFirst();
                NativeViewFactory.this.f31449b = NativeViewFactory.this.f31449b - 1;
            }
            mo33939a(view, akVar, cVar);
            return view;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Size:");
            sb.append(this.f31471b.size());
            sb.append(" Miss Count:");
            sb.append(this.f31470a);
            sb.append(" Hit Count:");
            sb.append(this.f31473d);
            return sb.toString();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m33749a(Context context, ImageView imageView, C10400ak akVar) {
        if (!(context == null || imageView == null)) {
            String str = akVar.f31625r;
            if ("cross_button".equalsIgnoreCase(akVar.f31611d) && str.trim().length() == 0) {
                m33763b(context, imageView);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("[ERRORCODE]", "603");
        akVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_ERROR, (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    static /* synthetic */ void m33752a(TextView textView) {
        textView.setTypeface(Typeface.DEFAULT, 0);
        textView.setPaintFlags(textView.getPaintFlags() & -17);
        textView.setPaintFlags(textView.getPaintFlags() & -9);
    }

    /* renamed from: a */
    static /* synthetic */ void m33755a(GifView gifView, C10400ak akVar) {
        gifView.setLayoutParams(new LayoutParams(m33765c(akVar.f31610c.f31633a.x), m33765c(akVar.f31610c.f31633a.y)));
        gifView.setContentMode(akVar.f31610c.mo34096f());
        gifView.setGif(((C10412aq) akVar).f31696z);
        m33750a((View) gifView, akVar.f31610c);
    }

    /* renamed from: a */
    static /* synthetic */ void m33756a(NativeVideoWrapper nativeVideoWrapper, C10400ak akVar) {
        if (VERSION.SDK_INT >= 15) {
            m33750a((View) nativeVideoWrapper, akVar.f31610c);
            Object obj = akVar.f31630w;
            if (obj != null) {
                nativeVideoWrapper.setPosterImage((Bitmap) obj);
            }
            nativeVideoWrapper.getProgressBar().setVisibility(0);
        }
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m33758a(com.inmobi.rendering.RenderView r3, com.inmobi.ads.C10400ak r4, com.inmobi.ads.C10478c r5) {
        /*
            r0 = r4
            com.inmobi.ads.bf r0 = (com.inmobi.ads.C10451bf) r0     // Catch:{ Exception -> 0x0053 }
            com.inmobi.rendering.RenderView$a r1 = com.inmobi.rendering.RenderView.f32713a     // Catch:{ Exception -> 0x0053 }
            r3.mo34554a(r1, r5)     // Catch:{ Exception -> 0x0053 }
            r5 = 1
            r3.f32755j = r5     // Catch:{ Exception -> 0x0053 }
            java.lang.Object r4 = r4.f31612e     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0053 }
            java.lang.String r0 = r0.f31795z     // Catch:{ Exception -> 0x0053 }
            r1 = -1
            int r2 = r0.hashCode()     // Catch:{ Exception -> 0x0053 }
            switch(r2) {
                case -1081286672: goto L_0x003c;
                case 84303: goto L_0x0032;
                case 2228139: goto L_0x0028;
                case 83774455: goto L_0x001e;
                default: goto L_0x001d;
            }     // Catch:{ Exception -> 0x0053 }
        L_0x001d:
            goto L_0x0046
        L_0x001e:
            java.lang.String r2 = "REF_HTML"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0053 }
            if (r0 == 0) goto L_0x001d
            r0 = 0
            goto L_0x0047
        L_0x0028:
            java.lang.String r2 = "HTML"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0053 }
            if (r0 == 0) goto L_0x001d
            r0 = 1
            goto L_0x0047
        L_0x0032:
            java.lang.String r2 = "URL"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0053 }
            if (r0 == 0) goto L_0x001d
            r0 = 3
            goto L_0x0047
        L_0x003c:
            java.lang.String r2 = "REF_IFRAME"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0053 }
            if (r0 == 0) goto L_0x001d
            r0 = 2
            goto L_0x0047
        L_0x0046:
            r0 = -1
        L_0x0047:
            if (r0 == 0) goto L_0x004f
            if (r0 == r5) goto L_0x004f
            r3.mo34562b(r4)     // Catch:{ Exception -> 0x0053 }
            return
        L_0x004f:
            r3.mo34555a(r4)     // Catch:{ Exception -> 0x0053 }
            return
        L_0x0053:
            r3 = move-exception
            com.inmobi.commons.core.a.a r4 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r5 = new com.inmobi.commons.core.e.a
            r5.<init>(r3)
            r4.mo34423a(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.NativeViewFactory.m33758a(com.inmobi.rendering.RenderView, com.inmobi.ads.ak, com.inmobi.ads.c):void");
    }

    static {
        HashMap hashMap = new HashMap();
        f31444c = hashMap;
        hashMap.put(C10433aw.class, Integer.valueOf(0));
        f31444c.put(C10464bp.class, Integer.valueOf(1));
        f31444c.put(C10463bo.class, Integer.valueOf(2));
        f31444c.put(NativeContainerLayout.class, Integer.valueOf(3));
        f31444c.put(ImageView.class, Integer.valueOf(6));
        f31444c.put(NativeVideoWrapper.class, Integer.valueOf(7));
        f31444c.put(C10357b.class, Integer.valueOf(4));
        f31444c.put(Button.class, Integer.valueOf(5));
        f31444c.put(NativeTimerView.class, Integer.valueOf(8));
        f31444c.put(RenderView.class, Integer.valueOf(9));
        f31444c.put(GifView.class, Integer.valueOf(10));
    }

    /* renamed from: a */
    static void m33747a(int i) {
        f31447g = i;
    }

    /* renamed from: b */
    static void m33762b(int i) {
        f31448h = i;
    }

    /* renamed from: c */
    static int m33765c(int i) {
        Context context = (Context) f31446f.get();
        if (context != null && (context instanceof InMobiAdActivity)) {
            return i;
        }
        int i2 = f31447g;
        if (i2 == 0) {
            return i;
        }
        double d = (double) i;
        double d2 = (double) i2;
        Double.isNaN(d2);
        double d3 = d2 * 1.0d;
        double d4 = (double) f31448h;
        Double.isNaN(d4);
        double d5 = d3 / d4;
        Double.isNaN(d);
        return (int) (d * d5);
    }

    @SuppressLint({"UseSparseArrays"})
    private NativeViewFactory(Context context) {
        f31446f = new WeakReference<>(context);
        this.f31450d.put(Integer.valueOf(0), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new C10433aw(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33750a(view, akVar.f31610c);
            }
        });
        this.f31450d.put(Integer.valueOf(3), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new NativeContainerLayout(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33750a(view, akVar.f31610c);
            }
        });
        this.f31450d.put(Integer.valueOf(1), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new C10464bp(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33750a(view, akVar.f31610c);
            }

            /* renamed from: a */
            public final boolean mo33940a(View view) {
                ((C10464bp) view).f31829a = null;
                return super.mo33940a(view);
            }
        });
        this.f31450d.put(Integer.valueOf(2), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new C10463bo(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33750a(view, akVar.f31610c);
            }
        });
        this.f31450d.put(Integer.valueOf(6), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new ImageView(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33751a((ImageView) view, akVar);
            }

            /* renamed from: a */
            public final boolean mo33940a(View view) {
                if (!(view instanceof ImageView)) {
                    return false;
                }
                ((ImageView) view).setImageDrawable(null);
                return super.mo33940a(view);
            }
        });
        this.f31450d.put(Integer.valueOf(10), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new GifView(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33755a((GifView) view, akVar);
            }

            /* renamed from: a */
            public final boolean mo33940a(View view) {
                if (!(view instanceof GifView)) {
                    return false;
                }
                ((GifView) view).setGif(null);
                return super.mo33940a(view);
            }
        });
        this.f31450d.put(Integer.valueOf(7), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new NativeVideoWrapper(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33756a((NativeVideoWrapper) view, akVar);
            }

            @TargetApi(15)
            /* renamed from: a */
            public final boolean mo33940a(View view) {
                if (!(view instanceof NativeVideoWrapper)) {
                    return false;
                }
                NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) view;
                nativeVideoWrapper.getProgressBar().setVisibility(8);
                nativeVideoWrapper.getPoster().setImageBitmap(null);
                nativeVideoWrapper.getVideoView().mo33879a();
                return super.mo33940a(view);
            }
        });
        this.f31450d.put(Integer.valueOf(4), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new C10357b(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33753a((TextView) view, akVar);
            }

            /* renamed from: a */
            public final boolean mo33940a(View view) {
                if (!(view instanceof TextView)) {
                    return false;
                }
                NativeViewFactory.m33752a((TextView) view);
                return super.mo33940a(view);
            }
        });
        this.f31450d.put(Integer.valueOf(5), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new Button(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33760b((Button) view, akVar);
            }

            /* renamed from: a */
            public final boolean mo33940a(View view) {
                if (!(view instanceof Button)) {
                    return false;
                }
                NativeViewFactory.m33752a((TextView) (Button) view);
                return super.mo33940a(view);
            }
        });
        this.f31450d.put(Integer.valueOf(8), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new NativeTimerView(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33757a(NativeViewFactory.this, (NativeTimerView) view, akVar);
            }

            /* renamed from: a */
            public final boolean mo33940a(View view) {
                return (view instanceof NativeTimerView) && super.mo33940a(view);
            }
        });
        this.f31450d.put(Integer.valueOf(9), new C10358c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo33938a(Context context) {
                return new RenderView(context.getApplicationContext(), new RenderingProperties(PlacementType.PLACEMENT_TYPE_INLINE), null, null);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo33939a(View view, C10400ak akVar, C10478c cVar) {
                super.mo33939a(view, akVar, cVar);
                NativeViewFactory.m33758a((RenderView) view, akVar, cVar);
            }

            /* renamed from: a */
            public final boolean mo33940a(View view) {
                return (view instanceof RenderView) && !((RenderView) view).f32767v && super.mo33940a(view);
            }
        });
    }

    /* renamed from: a */
    public static NativeViewFactory m33744a(Context context) {
        NativeViewFactory nativeViewFactory;
        NativeViewFactory nativeViewFactory2;
        NativeViewFactory nativeViewFactory3 = null;
        if (f31445e == null) {
            nativeViewFactory = null;
        } else {
            nativeViewFactory = (NativeViewFactory) f31445e.get();
        }
        if (nativeViewFactory == null) {
            synchronized (NativeViewFactory.class) {
                if (f31445e != null) {
                    nativeViewFactory3 = (NativeViewFactory) f31445e.get();
                }
                if (nativeViewFactory3 == null) {
                    nativeViewFactory2 = new NativeViewFactory(context);
                    f31445e = new WeakReference<>(nativeViewFactory2);
                } else {
                    nativeViewFactory2 = nativeViewFactory3;
                }
            }
        }
        return nativeViewFactory;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r0.equals("VIDEO") != false) goto L_0x0092;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View mo33936a(android.content.Context r12, com.inmobi.ads.C10400ak r13, com.inmobi.ads.C10478c r14) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.inmobi.ads.C10402am
            r1 = 3
            r2 = 2
            r3 = 5
            r4 = 7
            r5 = 6
            r6 = 4
            r7 = 0
            r8 = 1
            r9 = -1
            if (r0 == 0) goto L_0x0037
            r0 = r13
            com.inmobi.ads.am r0 = (com.inmobi.ads.C10402am) r0
            java.lang.String r3 = r0.f31611d
            java.lang.String r4 = "root"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x001f
            r1 = 0
            goto L_0x00a7
        L_0x001f:
            java.lang.String r3 = r0.f31611d
            java.lang.String r4 = "card_scrollable"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            int r0 = r0.f31644A
            if (r0 == r8) goto L_0x0032
            r1 = 1
            goto L_0x00a7
        L_0x0032:
            r1 = 2
            goto L_0x00a7
        L_0x0035:
            goto L_0x00a7
        L_0x0037:
            java.lang.String r0 = r13.f31609b
            int r10 = r0.hashCode()
            switch(r10) {
                case 67056: goto L_0x0087;
                case 70564: goto L_0x007d;
                case 2241657: goto L_0x0073;
                case 2571565: goto L_0x0069;
                case 69775675: goto L_0x005f;
                case 79826725: goto L_0x0055;
                case 81665115: goto L_0x004c;
                case 1942407129: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0091
        L_0x0042:
            java.lang.String r1 = "WEBVIEW"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            r1 = 6
            goto L_0x0092
        L_0x004c:
            java.lang.String r2 = "VIDEO"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0041
            goto L_0x0092
        L_0x0055:
            java.lang.String r1 = "TIMER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            r1 = 5
            goto L_0x0092
        L_0x005f:
            java.lang.String r1 = "IMAGE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            r1 = 1
            goto L_0x0092
        L_0x0069:
            java.lang.String r1 = "TEXT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            r1 = 0
            goto L_0x0092
        L_0x0073:
            java.lang.String r1 = "ICON"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            r1 = 2
            goto L_0x0092
        L_0x007d:
            java.lang.String r1 = "GIF"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            r1 = 7
            goto L_0x0092
        L_0x0087:
            java.lang.String r1 = "CTA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            r1 = 4
            goto L_0x0092
        L_0x0091:
            r1 = -1
        L_0x0092:
            switch(r1) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x00a4;
                case 2: goto L_0x00a4;
                case 3: goto L_0x00a2;
                case 4: goto L_0x00a0;
                case 5: goto L_0x009d;
                case 6: goto L_0x009a;
                case 7: goto L_0x0097;
                default: goto L_0x0095;
            }
        L_0x0095:
            r1 = -1
            goto L_0x00a7
        L_0x0097:
            r1 = 10
            goto L_0x00a7
        L_0x009a:
            r1 = 9
            goto L_0x00a7
        L_0x009d:
            r1 = 8
            goto L_0x00a7
        L_0x00a0:
            r1 = 5
            goto L_0x00a7
        L_0x00a2:
            r1 = 7
            goto L_0x00a7
        L_0x00a4:
            r1 = 6
            goto L_0x00a7
        L_0x00a6:
            r1 = 4
        L_0x00a7:
            if (r9 != r1) goto L_0x00bd
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "Unsupported AssetType:"
            r12.<init>(r14)
            java.lang.String r13 = r13.f31609b
            r12.append(r13)
            java.lang.String r13 = " failed to instantiate view "
            r12.append(r13)
            r12 = 0
            return r12
        L_0x00bd:
            java.util.Map<java.lang.Integer, com.inmobi.ads.NativeViewFactory$c> r0 = r11.f31450d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            com.inmobi.ads.NativeViewFactory$c r0 = (com.inmobi.ads.NativeViewFactory.C10358c) r0
            android.view.View r12 = r0.mo33947a(r12, r13, r14)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.NativeViewFactory.mo33936a(android.content.Context, com.inmobi.ads.ak, com.inmobi.ads.c):android.view.View");
    }

    /* renamed from: a */
    public final void mo33937a(View view) {
        if ((view instanceof C10433aw) || (view instanceof NativeContainerLayout)) {
            NativeContainerLayout nativeContainerLayout = (NativeContainerLayout) view;
            if (nativeContainerLayout.getChildCount() != 0) {
                Stack stack = new Stack();
                stack.push(nativeContainerLayout);
                while (!stack.isEmpty()) {
                    NativeContainerLayout nativeContainerLayout2 = (NativeContainerLayout) stack.pop();
                    for (int childCount = nativeContainerLayout2.getChildCount() - 1; childCount >= 0; childCount--) {
                        View childAt = nativeContainerLayout2.getChildAt(childCount);
                        nativeContainerLayout2.removeViewAt(childCount);
                        if (childAt instanceof NativeContainerLayout) {
                            stack.push((NativeContainerLayout) childAt);
                        } else {
                            m33766c(childAt);
                        }
                    }
                    m33766c((View) nativeContainerLayout2);
                }
                return;
            }
        }
        m33766c(view);
    }

    /* renamed from: c */
    private void m33766c(View view) {
        int intValue = ((Integer) f31444c.get(view.getClass())).intValue();
        if (-1 == intValue) {
            new StringBuilder("View type unknown, ignoring recycle:").append(view);
            return;
        }
        C10358c cVar = (C10358c) this.f31450d.get(Integer.valueOf(intValue));
        if (cVar == null) {
            StringBuilder sb = new StringBuilder("Unsupported AssetType:");
            sb.append(intValue);
            sb.append(" failed to recycle view");
            return;
        }
        if (this.f31449b >= 300) {
            C10358c b = m33761b();
            if (b != null && b.f31471b.size() > 0) {
                b.f31471b.removeFirst();
            }
        }
        cVar.mo33940a(view);
    }

    /* renamed from: b */
    private C10358c m33761b() {
        int i = 0;
        C10358c cVar = null;
        for (Entry entry : this.f31450d.entrySet()) {
            if (((C10358c) entry.getValue()).f31471b.size() > i) {
                C10358c cVar2 = (C10358c) entry.getValue();
                cVar = cVar2;
                i = cVar2.f31471b.size();
            }
        }
        return cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33763b(Context context, ImageView imageView) {
        Bitmap bitmap;
        if (imageView.getDrawable() == null) {
            float f = C10692c.m35104a().f32629c;
            CustomView customView = new CustomView(context, f, 0);
            if (VERSION.SDK_INT < 28) {
                customView.layout(0, 0, (int) (((float) m33765c(40)) * f), (int) (((float) m33765c(40)) * f));
                customView.setDrawingCacheEnabled(true);
                customView.buildDrawingCache();
                bitmap = customView.getDrawingCache();
            } else {
                customView.layout(0, 0, (int) (((float) m33765c(40)) * f), (int) (((float) m33765c(40)) * f));
                bitmap = Bitmap.createBitmap((int) (((float) m33765c(40)) * f), (int) (((float) m33765c(40)) * f), Config.ARGB_8888);
                customView.draw(new Canvas(bitmap));
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    /* renamed from: a */
    private static void m33754a(TextView textView, String[] strArr) {
        int paintFlags = textView.getPaintFlags();
        int i = paintFlags;
        int i2 = 0;
        for (String str : strArr) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1178781136:
                    if (str.equals("italic")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1026963764:
                    if (str.equals("underline")) {
                        c = 3;
                        break;
                    }
                    break;
                case -891985998:
                    if (str.equals("strike")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3029637:
                    if (str.equals("bold")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                i2 |= 1;
            } else if (c == 1) {
                i2 |= 2;
            } else if (c == 2) {
                i |= 16;
            } else if (c == 3) {
                i |= 8;
            }
        }
        textView.setTypeface(Typeface.DEFAULT, i2);
        textView.setPaintFlags(i);
    }

    /* access modifiers changed from: private */
    @TargetApi(17)
    /* renamed from: b */
    public static Button m33760b(Button button, C10400ak akVar) {
        C10405a aVar = (C10405a) akVar.f31610c;
        button.setLayoutParams(new LayoutParams(m33765c(aVar.f31633a.x), m33765c(aVar.f31633a.y)));
        button.setText((CharSequence) akVar.f31612e);
        button.setTextSize(1, (float) m33765c(aVar.mo34139h()));
        int parseColor = Color.parseColor("#ff000000");
        try {
            parseColor = Color.parseColor(aVar.mo34140i());
        } catch (IllegalArgumentException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        button.setTextColor(parseColor);
        int parseColor2 = Color.parseColor("#00000000");
        try {
            parseColor2 = Color.parseColor(aVar.mo34095e());
        } catch (IllegalArgumentException e2) {
            C10621a.m34854a().mo34423a(new C10658a(e2));
        }
        button.setBackgroundColor(parseColor2);
        if (VERSION.SDK_INT >= 17) {
            button.setTextAlignment(4);
        }
        button.setGravity(17);
        m33754a((TextView) button, aVar.mo34141j());
        m33750a((View) button, (C10401al) aVar);
        return button;
    }

    @TargetApi(21)
    /* renamed from: a */
    static void m33750a(View view, C10401al alVar) {
        int parseColor = Color.parseColor("#00000000");
        try {
            parseColor = Color.parseColor(alVar.mo34095e());
        } catch (IllegalArgumentException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        view.setBackgroundColor(parseColor);
        if ("line".equals(alVar.mo34091a())) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(parseColor);
            if ("curved".equals(alVar.mo34092b())) {
                gradientDrawable.setCornerRadius(alVar.mo34093c());
            }
            int parseColor2 = Color.parseColor("#ff000000");
            try {
                parseColor2 = Color.parseColor(alVar.mo34094d());
            } catch (IllegalArgumentException e2) {
                C10621a.m34854a().mo34423a(new C10658a(e2));
            }
            gradientDrawable.setStroke(1, parseColor2);
            if (VERSION.SDK_INT < 16) {
                view.setBackgroundDrawable(gradientDrawable);
                return;
            }
            view.setBackground(gradientDrawable);
        }
    }

    /* renamed from: a */
    public static LayoutParams m33742a(C10400ak akVar, ViewGroup viewGroup) {
        C10401al alVar = akVar.f31610c;
        Point point = alVar.f31633a;
        Point point2 = alVar.f31635c;
        LayoutParams layoutParams = new LayoutParams(m33765c(point.x), m33765c(point.y));
        if (viewGroup instanceof NativeContainerLayout) {
            C10324a aVar = new C10324a(m33765c(point.x), m33765c(point.y));
            int c = m33765c(point2.x);
            int c2 = m33765c(point2.y);
            aVar.f31350a = c;
            aVar.f31351b = c2;
            layoutParams = aVar;
        } else if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m33765c(point.x), m33765c(point.y));
            layoutParams2.setMargins(m33765c(point2.x), m33765c(point2.y), 0, 0);
            layoutParams = layoutParams2;
        } else if (viewGroup instanceof AbsListView) {
            return new AbsListView.LayoutParams(m33765c(point.x), m33765c(point.y));
        } else {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(m33765c(point.x), m33765c(point.y));
                layoutParams3.setMargins(m33765c(point2.x), m33765c(point2.y), 0, 0);
                layoutParams = layoutParams3;
            }
        }
        return layoutParams;
    }

    /* renamed from: b */
    static /* synthetic */ void m33764b(View view) {
        if (VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(null);
        } else {
            view.setBackground(null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0156  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m33751a(android.widget.ImageView r9, com.inmobi.ads.C10400ak r10) {
        /*
            java.lang.Object r0 = r10.f31612e
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x015f
            com.inmobi.ads.al r1 = r10.f31610c
            android.graphics.Point r1 = r1.f31633a
            int r1 = r1.x
            int r1 = m33765c(r1)
            com.inmobi.ads.al r2 = r10.f31610c
            android.graphics.Point r2 = r2.f31633a
            int r2 = r2.y
            int r2 = m33765c(r2)
            com.inmobi.ads.al r3 = r10.f31610c
            java.lang.String r3 = r3.mo34096f()
            r4 = -1
            int r5 = r3.hashCode()
            r6 = -1362001767(0xffffffffaed18099, float:-9.527063E-11)
            r7 = 0
            r8 = 1
            if (r5 == r6) goto L_0x0040
            r6 = 727618043(0x2b5e91fb, float:7.907283E-13)
            if (r5 == r6) goto L_0x0036
        L_0x0035:
            goto L_0x0049
        L_0x0036:
            java.lang.String r5 = "aspectFill"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0035
            r4 = 1
            goto L_0x0049
        L_0x0040:
            java.lang.String r5 = "aspectFit"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0035
            r4 = 0
        L_0x0049:
            if (r4 == 0) goto L_0x0059
            if (r4 == r8) goto L_0x0053
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_XY
            r9.setScaleType(r3)
            goto L_0x005f
        L_0x0053:
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP
            r9.setScaleType(r3)
            goto L_0x005f
        L_0x0059:
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER
            r9.setScaleType(r3)
        L_0x005f:
            java.lang.ref.WeakReference<android.content.Context> r3 = f31446f
            java.lang.Object r3 = r3.get()
            android.content.Context r3 = (android.content.Context) r3
            if (r3 == 0) goto L_0x00a9
            if (r1 <= 0) goto L_0x00a9
            if (r2 <= 0) goto L_0x00a9
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x00a9
            com.squareup.picasso.Picasso r1 = com.inmobi.ads.C10453bh.m34220a(r3)
            com.squareup.picasso.RequestCreator r0 = r1.load(r0)
            com.inmobi.ads.NativeViewFactory$PicassoCallback r1 = new com.inmobi.ads.NativeViewFactory$PicassoCallback
            r1.<init>(r3, r9, r10)
            r0.into(r9, r1)
            java.lang.String r0 = r10.f31611d
            java.lang.String r1 = "cross_button"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00a9
            java.lang.String r0 = r10.f31625r
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00a9
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            com.inmobi.ads.NativeViewFactory$a r1 = new com.inmobi.ads.NativeViewFactory$a
            r1.<init>(r3, r9)
            r2 = 2000(0x7d0, double:9.88E-321)
            r0.postDelayed(r1, r2)
        L_0x00a9:
            com.inmobi.ads.ak r0 = r10.f31627t
            if (r0 == 0) goto L_0x0149
            com.inmobi.ads.al r1 = r0.f31610c
            java.lang.String r1 = r1.mo34091a()
            java.lang.String r2 = "line"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0149
            com.inmobi.ads.al r1 = r0.f31610c
            android.graphics.Point r1 = r1.f31635c
            int r1 = r1.x
            com.inmobi.ads.al r2 = r10.f31610c
            android.graphics.Point r2 = r2.f31635c
            int r2 = r2.x
            if (r1 != r2) goto L_0x00d0
            r1 = 1
            goto L_0x00d1
        L_0x00d0:
            r1 = 0
        L_0x00d1:
            com.inmobi.ads.al r2 = r0.f31610c
            android.graphics.Point r2 = r2.f31633a
            int r2 = r2.x
            int r2 = m33765c(r2)
            com.inmobi.ads.al r3 = r10.f31610c
            android.graphics.Point r3 = r3.f31633a
            int r3 = r3.x
            int r3 = m33765c(r3)
            com.inmobi.ads.al r4 = r10.f31610c
            android.graphics.Point r4 = r4.f31635c
            int r4 = r4.x
            int r3 = r3 + r4
            if (r2 != r3) goto L_0x00f1
            r2 = 1
            goto L_0x00f2
        L_0x00f1:
            r2 = 0
        L_0x00f2:
            com.inmobi.ads.al r3 = r0.f31610c
            android.graphics.Point r3 = r3.f31635c
            int r3 = r3.y
            int r3 = m33765c(r3)
            com.inmobi.ads.al r4 = r10.f31610c
            android.graphics.Point r4 = r4.f31635c
            int r4 = r4.y
            int r4 = m33765c(r4)
            if (r3 != r4) goto L_0x010b
            r3 = 1
            goto L_0x010c
        L_0x010b:
            r3 = 0
        L_0x010c:
            com.inmobi.ads.al r4 = r0.f31610c
            android.graphics.Point r4 = r4.f31633a
            int r4 = r4.y
            int r4 = m33765c(r4)
            com.inmobi.ads.al r5 = r10.f31610c
            android.graphics.Point r5 = r5.f31633a
            int r5 = r5.y
            int r5 = m33765c(r5)
            com.inmobi.ads.al r6 = r10.f31610c
            android.graphics.Point r6 = r6.f31635c
            int r6 = r6.y
            int r6 = m33765c(r6)
            int r5 = r5 + r6
            if (r4 != r5) goto L_0x012f
            r7 = 1
        L_0x012f:
            com.inmobi.ads.al r0 = r0.f31610c
            android.graphics.Point r0 = r0.f31633a
            int r0 = r0.x
            int r0 = m33765c(r0)
            com.inmobi.ads.al r4 = r10.f31610c
            android.graphics.Point r4 = r4.f31633a
            int r4 = r4.x
            int r4 = m33765c(r4)
            if (r0 != r4) goto L_0x014c
            r1 = 1
            r2 = 1
            goto L_0x014c
        L_0x0149:
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x014c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 17
            if (r0 >= r4) goto L_0x0156
            r9.setPadding(r1, r3, r2, r7)
            goto L_0x0159
        L_0x0156:
            r9.setPaddingRelative(r1, r3, r2, r7)
        L_0x0159:
            com.inmobi.ads.al r10 = r10.f31610c
            m33750a(r9, r10)
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.NativeViewFactory.m33751a(android.widget.ImageView, com.inmobi.ads.ak):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m33753a(TextView textView, C10400ak akVar) {
        C10437a aVar = (C10437a) akVar.f31610c;
        textView.setLayoutParams(new LayoutParams(m33765c(aVar.f31633a.x), m33765c(aVar.f31633a.y)));
        textView.setText((CharSequence) akVar.f31612e);
        textView.setTypeface(Typeface.DEFAULT);
        int i = aVar.f31753p;
        if (i == 1) {
            textView.setGravity(8388629);
        } else if (i != 2) {
            textView.setGravity(8388627);
        } else {
            textView.setGravity(17);
        }
        textView.setTextSize(1, (float) m33765c(aVar.mo34139h()));
        int parseColor = Color.parseColor("#ff000000");
        try {
            parseColor = Color.parseColor(aVar.mo34140i());
        } catch (IllegalArgumentException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        textView.setTextColor(parseColor);
        int parseColor2 = Color.parseColor("#00000000");
        try {
            parseColor2 = Color.parseColor(aVar.mo34095e());
        } catch (IllegalArgumentException e2) {
            C10621a.m34854a().mo34423a(new C10658a(e2));
        }
        textView.setBackgroundColor(parseColor2);
        if (VERSION.SDK_INT >= 17) {
            textView.setTextAlignment(1);
        }
        m33754a(textView, aVar.mo34141j());
        textView.setEllipsize(TruncateAt.END);
        textView.setHorizontallyScrolling(true);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        m33750a((View) textView, (C10401al) aVar);
    }

    /* renamed from: a */
    static /* synthetic */ void m33757a(NativeViewFactory nativeViewFactory, final NativeTimerView nativeTimerView, C10400ak akVar) {
        long j;
        long j2;
        nativeTimerView.setVisibility(4);
        final C10443bb bbVar = (C10443bb) akVar;
        C10441ba baVar = bbVar.f31766A;
        C10442a aVar = baVar.f31760a;
        C10442a aVar2 = baVar.f31761b;
        if (aVar != null) {
            try {
                j = aVar.mo34144a();
            } catch (Exception e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
                return;
            }
        } else {
            j = 0;
        }
        if (aVar2 != null) {
            j2 = aVar2.mo34144a();
        } else {
            j2 = 0;
        }
        if (j2 >= 0) {
            nativeTimerView.setTimerValue(j2);
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    if (NativeViewFactory.f31446f.get() != null) {
                        if (bbVar.f31767z) {
                            nativeTimerView.setVisibility(0);
                        }
                        nativeTimerView.mo33859a();
                    }
                }
            }, j * 1000);
        }
    }
}
