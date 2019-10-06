package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.ads.zzaga;
import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzzs;
import com.google.android.gms.internal.ads.zzzt;

@zzard
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Creator<PublisherAdViewOptions> CREATOR = new zzc();

    /* renamed from: a */
    private final boolean f19060a;

    /* renamed from: b */
    private final zzzs f19061b;

    /* renamed from: c */
    private AppEventListener f19062c;

    /* renamed from: d */
    private final IBinder f19063d;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f19064a = false;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public AppEventListener f19065b;

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.f19064a = z;
            return this;
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.f19065b = appEventListener;
            return this;
        }

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.f19060a = builder.f19064a;
        this.f19062c = builder.f19065b;
        AppEventListener appEventListener = this.f19062c;
        this.f19061b = appEventListener != null ? new zzyf(appEventListener) : null;
        this.f19063d = null;
    }

    @Constructor
    PublisherAdViewOptions(@Param(id = 1) boolean z, @Param(id = 2) IBinder iBinder, @Param(id = 3) IBinder iBinder2) {
        this.f19060a = z;
        this.f19061b = iBinder != null ? zzzt.m31628a(iBinder) : null;
        this.f19063d = iBinder2;
    }

    public final AppEventListener getAppEventListener() {
        return this.f19062c;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.f19060a;
    }

    public final zzzs zzkt() {
        return this.f19061b;
    }

    public final zzaga zzku() {
        return zzagb.m24974a(this.f19063d);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 1, getManualImpressionsEnabled());
        zzzs zzzs = this.f19061b;
        SafeParcelWriter.m21960a(parcel, 2, zzzs == null ? null : zzzs.asBinder(), false);
        SafeParcelWriter.m21960a(parcel, 3, this.f19063d, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
