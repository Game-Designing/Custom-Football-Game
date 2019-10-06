package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class BaseNativeAd {

    /* renamed from: a */
    private final Set<String> f35615a = new HashSet();

    /* renamed from: b */
    private final Set<String> f35616b = new HashSet();

    /* renamed from: c */
    private NativeEventListener f35617c;

    /* renamed from: d */
    private boolean f35618d = false;

    public interface NativeEventListener {
        void onAdClicked();

        void onAdImpressed();
    }

    public abstract void clear(View view);

    public abstract void destroy();

    public abstract void prepare(View view);

    protected BaseNativeAd() {
    }

    public void setNativeEventListener(NativeEventListener nativeEventListener) {
        this.f35617c = nativeEventListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo37750d() {
        NativeEventListener nativeEventListener = this.f35617c;
        if (nativeEventListener != null) {
            nativeEventListener.onAdImpressed();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo37749c() {
        NativeEventListener nativeEventListener = this.f35617c;
        if (nativeEventListener != null) {
            nativeEventListener.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo37748b(Object impressionTrackers) throws ClassCastException {
        if (impressionTrackers instanceof JSONArray) {
            JSONArray trackers = (JSONArray) impressionTrackers;
            for (int i = 0; i < trackers.length(); i++) {
                try {
                    addImpressionTracker(trackers.getString(i));
                } catch (JSONException e) {
                    MoPubLog.log(AdLogEvent.CUSTOM, "Unable to parse impression trackers.");
                }
            }
            return;
        }
        throw new ClassCastException("Expected impression trackers of type JSONArray.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo37744a(Object clickTrackers) throws ClassCastException {
        if (clickTrackers instanceof JSONArray) {
            JSONArray trackers = (JSONArray) clickTrackers;
            for (int i = 0; i < trackers.length(); i++) {
                try {
                    addClickTracker(trackers.getString(i));
                } catch (JSONException e) {
                    MoPubLog.log(AdLogEvent.CUSTOM, "Unable to parse click trackers.");
                }
            }
            return;
        }
        throw new ClassCastException("Expected click trackers of type JSONArray.");
    }

    public final void addImpressionTracker(String url) {
        if (NoThrow.checkNotNull(url, "impressionTracker url is not allowed to be null")) {
            this.f35615a.add(url);
        }
    }

    public final void addClickTracker(String url) {
        if (NoThrow.checkNotNull(url, "clickTracker url is not allowed to be null")) {
            this.f35616b.add(url);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Set<String> mo37747b() {
        return new HashSet(this.f35615a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Set<String> mo37743a() {
        return new HashSet(this.f35616b);
    }

    public void invalidate() {
        this.f35618d = true;
    }

    public boolean isInvalidated() {
        return this.f35618d;
    }
}
