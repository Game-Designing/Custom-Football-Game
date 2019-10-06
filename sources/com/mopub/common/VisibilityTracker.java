package com.mopub.common;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class VisibilityTracker {

    /* renamed from: a */
    private final ArrayList<View> f34371a;

    /* renamed from: b */
    private long f34372b;
    @VisibleForTesting

    /* renamed from: c */
    final OnPreDrawListener f34373c;
    @VisibleForTesting

    /* renamed from: d */
    WeakReference<ViewTreeObserver> f34374d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Map<View, C11238a> f34375e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final VisibilityChecker f34376f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public VisibilityTrackerListener f34377g;

    /* renamed from: h */
    private final C11239b f34378h;

    /* renamed from: i */
    private final Handler f34379i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f34380j;

    public static class VisibilityChecker {

        /* renamed from: a */
        private final Rect f34381a = new Rect();

        public boolean hasRequiredTimeElapsed(long startTimeMillis, int minTimeViewed) {
            return SystemClock.uptimeMillis() - startTimeMillis >= ((long) minTimeViewed);
        }

        public boolean isVisible(View rootView, View view, int minPercentageViewed, Integer minVisiblePx) {
            boolean z = false;
            if (view == null || view.getVisibility() != 0 || rootView.getParent() == null || !view.getGlobalVisibleRect(this.f34381a)) {
                return false;
            }
            long visibleViewArea = ((long) this.f34381a.height()) * ((long) this.f34381a.width());
            long totalViewArea = ((long) view.getHeight()) * ((long) view.getWidth());
            if (totalViewArea <= 0) {
                return false;
            }
            if (minVisiblePx == null || minVisiblePx.intValue() <= 0) {
                if (100 * visibleViewArea >= ((long) minPercentageViewed) * totalViewArea) {
                    z = true;
                }
                return z;
            }
            if (visibleViewArea >= ((long) minVisiblePx.intValue())) {
                z = true;
            }
            return z;
        }
    }

    public interface VisibilityTrackerListener {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    /* renamed from: com.mopub.common.VisibilityTracker$a */
    static class C11238a {

        /* renamed from: a */
        int f34382a;

        /* renamed from: b */
        int f34383b;

        /* renamed from: c */
        long f34384c;

        /* renamed from: d */
        View f34385d;

        /* renamed from: e */
        Integer f34386e;

        C11238a() {
        }
    }

    /* renamed from: com.mopub.common.VisibilityTracker$b */
    class C11239b implements Runnable {

        /* renamed from: a */
        private final ArrayList<View> f34387a = new ArrayList<>();

        /* renamed from: b */
        private final ArrayList<View> f34388b = new ArrayList<>();

        C11239b() {
        }

        public void run() {
            VisibilityTracker.this.f34380j = false;
            for (Entry<View, TrackingInfo> entry : VisibilityTracker.this.f34375e.entrySet()) {
                View view = (View) entry.getKey();
                int minPercentageViewed = ((C11238a) entry.getValue()).f34382a;
                int maxInvisiblePercent = ((C11238a) entry.getValue()).f34383b;
                Integer minVisiblePx = ((C11238a) entry.getValue()).f34386e;
                View rootView = ((C11238a) entry.getValue()).f34385d;
                if (VisibilityTracker.this.f34376f.isVisible(rootView, view, minPercentageViewed, minVisiblePx)) {
                    this.f34387a.add(view);
                } else if (!VisibilityTracker.this.f34376f.isVisible(rootView, view, maxInvisiblePercent, null)) {
                    this.f34388b.add(view);
                }
            }
            if (VisibilityTracker.this.f34377g != null) {
                VisibilityTracker.this.f34377g.onVisibilityChanged(this.f34387a, this.f34388b);
            }
            this.f34387a.clear();
            this.f34388b.clear();
        }
    }

    public VisibilityTracker(Context context) {
        this(context, new WeakHashMap(10), new VisibilityChecker(), new Handler());
    }

    @VisibleForTesting
    VisibilityTracker(Context context, Map<View, C11238a> trackedViews, VisibilityChecker visibilityChecker, Handler visibilityHandler) {
        this.f34372b = 0;
        this.f34375e = trackedViews;
        this.f34376f = visibilityChecker;
        this.f34379i = visibilityHandler;
        this.f34378h = new C11239b();
        this.f34371a = new ArrayList<>(50);
        this.f34373c = new C11236L(this);
        this.f34374d = new WeakReference<>(null);
        m37057a(context, (View) null);
    }

    /* renamed from: a */
    private void m37057a(Context context, View view) {
        ViewTreeObserver originalViewTreeObserver = (ViewTreeObserver) this.f34374d.get();
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
            this.f34374d = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.f34373c);
        }
    }

    public void setVisibilityTrackerListener(VisibilityTrackerListener visibilityTrackerListener) {
        this.f34377g = visibilityTrackerListener;
    }

    public void addView(View view, int minPercentageViewed, Integer minVisiblePx) {
        addView(view, view, minPercentageViewed, minVisiblePx);
    }

    public void addView(View rootView, View view, int minPercentageViewed, Integer minVisiblePx) {
        addView(rootView, view, minPercentageViewed, minPercentageViewed, minVisiblePx);
    }

    public void addView(View rootView, View view, int minVisiblePercentageViewed, int maxInvisiblePercentageViewed, Integer minVisiblePx) {
        View view2 = view;
        int i = minVisiblePercentageViewed;
        m37057a(view.getContext(), view2);
        C11238a trackingInfo = (C11238a) this.f34375e.get(view2);
        if (trackingInfo == null) {
            trackingInfo = new C11238a();
            this.f34375e.put(view2, trackingInfo);
            scheduleVisibilityCheck();
        }
        int maxInvisiblePercent = Math.min(maxInvisiblePercentageViewed, i);
        trackingInfo.f34385d = rootView;
        trackingInfo.f34382a = i;
        trackingInfo.f34383b = maxInvisiblePercent;
        long j = this.f34372b;
        trackingInfo.f34384c = j;
        trackingInfo.f34386e = minVisiblePx;
        this.f34372b = j + 1;
        long j2 = this.f34372b;
        if (j2 % 50 == 0) {
            m37056a(j2 - 50);
        }
    }

    /* renamed from: a */
    private void m37056a(long minAccessOrder) {
        for (Entry<View, TrackingInfo> entry : this.f34375e.entrySet()) {
            if (((C11238a) entry.getValue()).f34384c < minAccessOrder) {
                this.f34371a.add(entry.getKey());
            }
        }
        Iterator it = this.f34371a.iterator();
        while (it.hasNext()) {
            removeView((View) it.next());
        }
        this.f34371a.clear();
    }

    public void removeView(View view) {
        this.f34375e.remove(view);
    }

    public void clear() {
        this.f34375e.clear();
        this.f34379i.removeMessages(0);
        this.f34380j = false;
    }

    public void destroy() {
        clear();
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f34374d.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f34373c);
        }
        this.f34374d.clear();
        this.f34377g = null;
    }

    public void scheduleVisibilityCheck() {
        if (!this.f34380j) {
            this.f34380j = true;
            this.f34379i.postDelayed(this.f34378h, 100);
        }
    }
}
