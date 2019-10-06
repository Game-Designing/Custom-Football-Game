package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.ads.zzard;

@zzard
public final class zzc extends AbstractSafeParcelable {
    public static final Creator<zzc> CREATOR = new zzb();

    /* renamed from: a */
    private final String f19090a;

    /* renamed from: b */
    private final String f19091b;
    public final Intent intent;
    public final String mimeType;
    public final String packageName;
    public final String url;
    public final String zzdjh;
    public final String zzdji;

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public zzc(Intent intent2) {
        this(null, null, null, null, null, null, null, intent2);
    }

    @Constructor
    public zzc(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) String str5, @Param(id = 7) String str6, @Param(id = 8) String str7, @Param(id = 9) Intent intent2) {
        this.f19090a = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzdjh = str5;
        this.zzdji = str6;
        this.f19091b = str7;
        this.intent = intent2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f19090a, false);
        SafeParcelWriter.m21965a(parcel, 3, this.url, false);
        SafeParcelWriter.m21965a(parcel, 4, this.mimeType, false);
        SafeParcelWriter.m21965a(parcel, 5, this.packageName, false);
        SafeParcelWriter.m21965a(parcel, 6, this.zzdjh, false);
        SafeParcelWriter.m21965a(parcel, 7, this.zzdji, false);
        SafeParcelWriter.m21965a(parcel, 8, this.f19091b, false);
        SafeParcelWriter.m21962a(parcel, 9, (Parcelable) this.intent, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
