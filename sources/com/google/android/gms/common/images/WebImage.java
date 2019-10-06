package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Locale;

public final class WebImage extends AbstractSafeParcelable {
    public static final Creator<WebImage> CREATOR = new zae();

    /* renamed from: a */
    private final int f19992a;

    /* renamed from: b */
    private final Uri f19993b;

    /* renamed from: c */
    private final int f19994c;

    /* renamed from: d */
    private final int f19995d;

    @Constructor
    WebImage(@Param(id = 1) int i, @Param(id = 2) Uri uri, @Param(id = 3) int i2, @Param(id = 4) int i3) {
        this.f19992a = i;
        this.f19993b = uri;
        this.f19994c = i2;
        this.f19995d = i3;
    }

    /* renamed from: c */
    public final Uri mo27687c() {
        return this.f19993b;
    }

    /* renamed from: d */
    public final int mo27688d() {
        return this.f19994c;
    }

    /* renamed from: a */
    public final int mo27686a() {
        return this.f19995d;
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f19994c), Integer.valueOf(this.f19995d), this.f19993b.toString()});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        if (Objects.m21851a(this.f19993b, webImage.f19993b) && this.f19994c == webImage.f19994c && this.f19995d == webImage.f19995d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.m21849a(this.f19993b, Integer.valueOf(this.f19994c), Integer.valueOf(this.f19995d));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19992a);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) mo27687c(), i, false);
        SafeParcelWriter.m21957a(parcel, 3, mo27688d());
        SafeParcelWriter.m21957a(parcel, 4, mo27686a());
        SafeParcelWriter.m21954a(parcel, a);
    }
}
