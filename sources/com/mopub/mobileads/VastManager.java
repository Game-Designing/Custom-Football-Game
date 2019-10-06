package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;

public class VastManager implements C11360b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public VastManagerListener f34992a;

    /* renamed from: b */
    private VastXmlManagerAggregator f34993b;

    /* renamed from: c */
    private String f34994c;

    /* renamed from: d */
    private double f34995d;

    /* renamed from: e */
    private int f34996e;

    /* renamed from: f */
    private final boolean f34997f;

    public interface VastManagerListener {
        void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig);
    }

    public VastManager(Context context, boolean shouldPreCacheVideo) {
        m37573a(context);
        this.f34997f = shouldPreCacheVideo;
    }

    public void prepareVastVideoConfiguration(String vastXml, VastManagerListener vastManagerListener, String dspCreativeId, Context context) {
        Preconditions.checkNotNull(vastManagerListener, "vastManagerListener cannot be null");
        Preconditions.checkNotNull(context, "context cannot be null");
        if (this.f34993b == null) {
            this.f34992a = vastManagerListener;
            VastXmlManagerAggregator vastXmlManagerAggregator = new VastXmlManagerAggregator(this, this.f34995d, this.f34996e, context.getApplicationContext());
            this.f34993b = vastXmlManagerAggregator;
            this.f34994c = dspCreativeId;
            try {
                AsyncTasks.safeExecuteOnExecutor(this.f34993b, vastXml);
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.ERROR, "Failed to aggregate vast xml", e);
                this.f34992a.onVastVideoConfigurationPrepared(null);
            }
        }
    }

    public void cancel() {
        VastXmlManagerAggregator vastXmlManagerAggregator = this.f34993b;
        if (vastXmlManagerAggregator != null) {
            vastXmlManagerAggregator.cancel(true);
            this.f34993b = null;
        }
    }

    public void onAggregationComplete(VastVideoConfig vastVideoConfig) {
        VastManagerListener vastManagerListener = this.f34992a;
        if (vastManagerListener == null) {
            throw new IllegalStateException("mVastManagerListener cannot be null here. Did you call prepareVastVideoConfiguration()?");
        } else if (vastVideoConfig == null) {
            vastManagerListener.onVastVideoConfigurationPrepared(null);
        } else {
            if (!TextUtils.isEmpty(this.f34994c)) {
                vastVideoConfig.setDspCreativeId(this.f34994c);
            }
            if (!this.f34997f || m37575a(vastVideoConfig)) {
                this.f34992a.onVastVideoConfigurationPrepared(vastVideoConfig);
                return;
            }
            VideoDownloader.cache(vastVideoConfig.getNetworkMediaFileUrl(), new C11311Ga(this, vastVideoConfig));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m37575a(VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        String networkMediaFileUrl = vastVideoConfig.getNetworkMediaFileUrl();
        if (!CacheService.containsKeyDiskCache(networkMediaFileUrl)) {
            return false;
        }
        vastVideoConfig.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(networkMediaFileUrl));
        return true;
    }

    /* renamed from: a */
    private void m37573a(Context context) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int xPx = display.getWidth();
        int yPx = display.getHeight();
        float density = context.getResources().getDisplayMetrics().density;
        if (density <= 0.0f) {
            density = 1.0f;
        }
        int screenWidth = Math.max(xPx, yPx);
        int screenHeight = Math.min(xPx, yPx);
        double d = (double) screenWidth;
        double d2 = (double) screenHeight;
        Double.isNaN(d);
        Double.isNaN(d2);
        this.f34995d = d / d2;
        this.f34996e = (int) ((((float) screenWidth) / density) * (((float) screenHeight) / density));
    }
}
