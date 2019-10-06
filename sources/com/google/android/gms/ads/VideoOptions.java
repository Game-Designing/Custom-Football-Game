package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzard;

@zzard
public final class VideoOptions {

    /* renamed from: a */
    private final boolean f19031a;

    /* renamed from: b */
    private final boolean f19032b;

    /* renamed from: c */
    private final boolean f19033c;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f19034a = true;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f19035b = false;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f19036c = false;

        public final Builder setStartMuted(boolean z) {
            this.f19034a = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.f19035b = z;
            return this;
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.f19036c = z;
            return this;
        }

        public final VideoOptions build() {
            return new VideoOptions(this);
        }
    }

    public VideoOptions(zzacd zzacd) {
        this.f19031a = zzacd.f23878a;
        this.f19032b = zzacd.f23879b;
        this.f19033c = zzacd.f23880c;
    }

    private VideoOptions(Builder builder) {
        this.f19031a = builder.f19034a;
        this.f19032b = builder.f19035b;
        this.f19033c = builder.f19036c;
    }

    public final boolean getStartMuted() {
        return this.f19031a;
    }

    public final boolean getCustomControlsRequested() {
        return this.f19032b;
    }

    public final boolean getClickToExpandRequested() {
        return this.f19033c;
    }
}
