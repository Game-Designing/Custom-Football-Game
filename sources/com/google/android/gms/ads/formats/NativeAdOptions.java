package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.ads.zzard;

@zzard
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    /* renamed from: a */
    private final boolean f19042a;

    /* renamed from: b */
    private final int f19043b;

    /* renamed from: c */
    private final int f19044c;

    /* renamed from: d */
    private final boolean f19045d;

    /* renamed from: e */
    private final int f19046e;

    /* renamed from: f */
    private final VideoOptions f19047f;

    /* renamed from: g */
    private final boolean f19048g;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f19049a = false;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f19050b = -1;

        /* renamed from: c */
        private int f19051c = 0;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f19052d = false;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public VideoOptions f19053e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f19054f = 1;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public boolean f19055g = false;

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.f19049a = z;
            return this;
        }

        public final Builder setImageOrientation(int i) {
            this.f19050b = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.f19052d = z;
            return this;
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.f19054f = i;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.f19053e = videoOptions;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.f19055g = z;
            return this;
        }

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }
    }

    private NativeAdOptions(Builder builder) {
        this.f19042a = builder.f19049a;
        this.f19043b = builder.f19050b;
        this.f19044c = 0;
        this.f19045d = builder.f19052d;
        this.f19046e = builder.f19054f;
        this.f19047f = builder.f19053e;
        this.f19048g = builder.f19055g;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.f19042a;
    }

    public final int getImageOrientation() {
        return this.f19043b;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.f19045d;
    }

    public final int getAdChoicesPlacement() {
        return this.f19046e;
    }

    public final VideoOptions getVideoOptions() {
        return this.f19047f;
    }

    public final boolean zzkr() {
        return this.f19048g;
    }
}
