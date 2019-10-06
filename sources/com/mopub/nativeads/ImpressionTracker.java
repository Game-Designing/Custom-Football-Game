package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibilityTracker.VisibilityChecker;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import com.mopub.common.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class ImpressionTracker {

    /* renamed from: a */
    private final VisibilityTracker f35682a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<View, ImpressionInterface> f35683b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<View, C11516Bb<ImpressionInterface>> f35684c;

    /* renamed from: d */
    private final Handler f35685d;

    /* renamed from: e */
    private final C11534a f35686e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final VisibilityChecker f35687f;

    /* renamed from: g */
    private VisibilityTrackerListener f35688g;

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.ImpressionTracker$a */
    class C11534a implements Runnable {

        /* renamed from: a */
        private final ArrayList<View> f35689a = new ArrayList<>();

        C11534a() {
        }

        public void run() {
            for (Entry<View, TimestampWrapper<ImpressionInterface>> entry : ImpressionTracker.this.f35684c.entrySet()) {
                View view = (View) entry.getKey();
                TimestampWrapper<ImpressionInterface> timestampWrapper = (C11516Bb) entry.getValue();
                if (ImpressionTracker.this.f35687f.hasRequiredTimeElapsed(timestampWrapper.f35620b, ((ImpressionInterface) timestampWrapper.f35619a).getImpressionMinTimeViewed())) {
                    ((ImpressionInterface) timestampWrapper.f35619a).recordImpression(view);
                    ((ImpressionInterface) timestampWrapper.f35619a).setImpressionRecorded();
                    this.f35689a.add(view);
                }
            }
            Iterator it = this.f35689a.iterator();
            while (it.hasNext()) {
                ImpressionTracker.this.removeView((View) it.next());
            }
            this.f35689a.clear();
            if (!ImpressionTracker.this.f35684c.isEmpty()) {
                ImpressionTracker.this.mo37817a();
            }
        }
    }

    public ImpressionTracker(Context context) {
        this(new WeakHashMap(), new WeakHashMap(), new VisibilityChecker(), new VisibilityTracker(context), new Handler(Looper.getMainLooper()));
    }

    @VisibleForTesting
    ImpressionTracker(Map<View, ImpressionInterface> trackedViews, Map<View, C11516Bb<ImpressionInterface>> pollingViews, VisibilityChecker visibilityChecker, VisibilityTracker visibilityTracker, Handler handler) {
        this.f35683b = trackedViews;
        this.f35684c = pollingViews;
        this.f35687f = visibilityChecker;
        this.f35682a = visibilityTracker;
        this.f35688g = new C11617l(this);
        this.f35682a.setVisibilityTrackerListener(this.f35688g);
        this.f35685d = handler;
        this.f35686e = new C11534a();
    }

    public void addView(View view, ImpressionInterface impressionInterface) {
        if (this.f35683b.get(view) != impressionInterface) {
            removeView(view);
            if (!impressionInterface.isImpressionRecorded()) {
                this.f35683b.put(view, impressionInterface);
                this.f35682a.addView(view, impressionInterface.getImpressionMinPercentageViewed(), impressionInterface.getImpressionMinVisiblePx());
            }
        }
    }

    public void removeView(View view) {
        this.f35683b.remove(view);
        m38151a(view);
        this.f35682a.removeView(view);
    }

    public void clear() {
        this.f35683b.clear();
        this.f35684c.clear();
        this.f35682a.clear();
        this.f35685d.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.f35682a.destroy();
        this.f35688g = null;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37817a() {
        if (!this.f35685d.hasMessages(0)) {
            this.f35685d.postDelayed(this.f35686e, 250);
        }
    }

    /* renamed from: a */
    private void m38151a(View view) {
        this.f35684c.remove(view);
    }
}
