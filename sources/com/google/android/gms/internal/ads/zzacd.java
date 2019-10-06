package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzacd extends AbstractSafeParcelable {
    public static final Creator<zzacd> CREATOR = new zzace();

    /* renamed from: a */
    public final boolean f23878a;

    /* renamed from: b */
    public final boolean f23879b;

    /* renamed from: c */
    public final boolean f23880c;

    public zzacd(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @Constructor
    public zzacd(@Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) boolean z3) {
        this.f23878a = z;
        this.f23879b = z2;
        this.f23880c = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 2, this.f23878a);
        SafeParcelWriter.m21968a(parcel, 3, this.f23879b);
        SafeParcelWriter.m21968a(parcel, 4, this.f23880c);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
