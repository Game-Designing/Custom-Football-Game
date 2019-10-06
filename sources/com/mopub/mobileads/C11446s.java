package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;

/* renamed from: com.mopub.mobileads.s */
/* compiled from: BannerVisibilityTracker */
class C11446s {
    @VisibleForTesting

    /* renamed from: a */
    final OnPreDrawListener f35402a = new C11441r(this);
    @VisibleForTesting

    /* renamed from: b */
    WeakReference<ViewTreeObserver> f35403b = new WeakReference<>(null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final View f35404c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final View f35405d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C11447a f35406e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C11449c f35407f;

    /* renamed from: g */
    private final C11448b f35408g = new C11448b();

    /* renamed from: h */
    private final Handler f35409h = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f35410i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f35411j;

    /* renamed from: com.mopub.mobileads.s$a */
    /* compiled from: BannerVisibilityTracker */
    static class C11447a {

        /* renamed from: a */
        private int f35412a;

        /* renamed from: b */
        private int f35413b;

        /* renamed from: c */
        private long f35414c = Long.MIN_VALUE;

        /* renamed from: d */
        private final Rect f35415d = new Rect();

        C11447a(int minVisibleDips, int minVisibleMillis) {
            this.f35412a = minVisibleDips;
            this.f35413b = minVisibleMillis;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo37549a() {
            return this.f35414c != Long.MIN_VALUE;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo37552c() {
            this.f35414c = SystemClock.uptimeMillis();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo37551b() {
            boolean z = false;
            if (!mo37549a()) {
                return false;
            }
            if (SystemClock.uptimeMillis() - this.f35414c >= ((long) this.f35413b)) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo37550a(View rootView, View view) {
            boolean z = false;
            if (view == null || view.getVisibility() != 0 || rootView.getParent() == null || view.getWidth() <= 0 || view.getHeight() <= 0 || !view.getGlobalVisibleRect(this.f35415d)) {
                return false;
            }
            if (((long) (Dips.pixelsToIntDips((float) this.f35415d.width(), view.getContext()) * Dips.pixelsToIntDips((float) this.f35415d.height(), view.getContext()))) >= ((long) this.f35412a)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: com.mopub.mobileads.s$b */
    /* compiled from: BannerVisibilityTracker */
    class C11448b implements Runnable {
        C11448b() {
        }

        public void run() {
            if (!C11446s.this.f35411j) {
                C11446s.this.f35410i = false;
                if (C11446s.this.f35406e.mo37550a(C11446s.this.f35405d, C11446s.this.f35404c)) {
                    if (!C11446s.this.f35406e.mo37549a()) {
                        C11446s.this.f35406e.mo37552c();
                    }
                    if (C11446s.this.f35406e.mo37551b() && C11446s.this.f35407f != null) {
                        C11446s.this.f35407f.onVisibilityChanged();
                        C11446s.this.f35411j = true;
                    }
                }
                if (!C11446s.this.f35411j) {
                    C11446s.this.mo37548b();
                }
            }
        }
    }

    /* renamed from: com.mopub.mobileads.s$c */
    /* compiled from: BannerVisibilityTracker */
    interface C11449c {
        void onVisibilityChanged();
    }

    @VisibleForTesting
    public C11446s(Context context, View rootView, View trackedView, int minVisibleDips, int minVisibleMillis) {
        Preconditions.checkNotNull(rootView);
        Preconditions.checkNotNull(trackedView);
        this.f35405d = rootView;
        this.f35404c = trackedView;
        this.f35406e = new C11447a(minVisibleDips, minVisibleMillis);
        m37887a(context, this.f35404c);
    }

    /* renamed from: a */
    private void m37887a(Context context, View view) {
        ViewTreeObserver originalViewTreeObserver = (ViewTreeObserver) this.f35403b.get();
        if (originalViewTreeObserver == null || !originalViewTreeObserver.isAlive()) {
            View rootView = Views.getTopmostView(context, view);
            if (rootView == null) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to set Visibility Tracker due to no available root view.");
                return;
            }
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (!viewTreeObserver.isAlive()) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Visibility Tracker was unable to track views because the root view tree observer was not alive");
                return;
            }
            this.f35403b = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.f35402a);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37547a(C11449c bannerVisibilityTrackerListener) {
        this.f35407f = bannerVisibilityTrackerListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37546a() {
        this.f35409h.removeMessages(0);
        this.f35410i = false;
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f35403b.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f35402a);
        }
        this.f35403b.clear();
        this.f35407f = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37548b() {
        if (!this.f35410i) {
            this.f35410i = true;
            this.f35409h.postDelayed(this.f35408g, 100);
        }
    }
}
