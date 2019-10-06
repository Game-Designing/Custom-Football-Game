package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.lang.ref.WeakReference;

public final class AdapterHelper {

    /* renamed from: a */
    private final WeakReference<Context> f35598a;

    /* renamed from: b */
    private final Context f35599b;

    /* renamed from: c */
    private final int f35600c;

    /* renamed from: d */
    private final int f35601d;

    public AdapterHelper(Context context, int start, int interval) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        boolean z = true;
        Preconditions.checkArgument(start >= 0, "start position must be non-negative");
        if (interval < 2) {
            z = false;
        }
        Preconditions.checkArgument(z, "interval must be at least 2");
        this.f35598a = new WeakReference<>(context);
        this.f35599b = context.getApplicationContext();
        this.f35600c = start;
        this.f35601d = interval;
    }

    public View getAdView(View convertView, ViewGroup parent, NativeAd nativeAd, ViewBinder viewBinder) {
        Context context = (Context) this.f35598a.get();
        if (context != null) {
            return C11622ma.m38451a(convertView, parent, context, nativeAd);
        }
        MoPubLog.log(SdkLogEvent.CUSTOM, "Weak reference to Context in AdapterHelper became null. Returning empty view.");
        return new View(this.f35599b);
    }

    public View getAdView(View convertView, ViewGroup parent, NativeAd nativeAd) {
        return getAdView(convertView, parent, nativeAd, null);
    }

    public int shiftedCount(int originalCount) {
        return m38090b(originalCount) + originalCount;
    }

    public int shiftedPosition(int position) {
        return position - m38089a(position);
    }

    public boolean isAdPosition(int position) {
        int i = this.f35600c;
        boolean z = false;
        if (position < i) {
            return false;
        }
        if ((position - i) % this.f35601d == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private int m38089a(int position) {
        int i = this.f35600c;
        if (position <= i) {
            return 0;
        }
        double d = (double) (position - i);
        double d2 = (double) this.f35601d;
        Double.isNaN(d);
        Double.isNaN(d2);
        return ((int) Math.floor(d / d2)) + 1;
    }

    /* renamed from: b */
    private int m38090b(int contentRowCount) {
        int i = this.f35600c;
        if (contentRowCount <= i) {
            return 0;
        }
        int spacesBetweenAds = this.f35601d - 1;
        if ((contentRowCount - i) % spacesBetweenAds == 0) {
            return (contentRowCount - i) / spacesBetweenAds;
        }
        double d = (double) (contentRowCount - i);
        double d2 = (double) spacesBetweenAds;
        Double.isNaN(d);
        Double.isNaN(d2);
        return ((int) Math.floor(d / d2)) + 1;
    }
}
