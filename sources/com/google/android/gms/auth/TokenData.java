package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<TokenData> CREATOR = new zzk();

    /* renamed from: a */
    private final int f19267a;

    /* renamed from: b */
    private final String f19268b;

    /* renamed from: c */
    private final Long f19269c;

    /* renamed from: d */
    private final boolean f19270d;

    /* renamed from: e */
    private final boolean f19271e;

    /* renamed from: f */
    private final List<String> f19272f;

    /* renamed from: g */
    private final String f19273g;

    @Constructor
    TokenData(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) Long l, @Param(id = 4) boolean z, @Param(id = 5) boolean z2, @Param(id = 6) List<String> list, @Param(id = 7) String str2) {
        this.f19267a = i;
        Preconditions.m21866b(str);
        this.f19268b = str;
        this.f19269c = l;
        this.f19270d = z;
        this.f19271e = z2;
        this.f19272f = list;
        this.f19273g = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        if (!TextUtils.equals(this.f19268b, tokenData.f19268b) || !Objects.m21851a(this.f19269c, tokenData.f19269c) || this.f19270d != tokenData.f19270d || this.f19271e != tokenData.f19271e || !Objects.m21851a(this.f19272f, tokenData.f19272f) || !Objects.m21851a(this.f19273g, tokenData.f19273g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.m21849a(this.f19268b, this.f19269c, Boolean.valueOf(this.f19270d), Boolean.valueOf(this.f19271e), this.f19272f, this.f19273g);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19267a);
        SafeParcelWriter.m21965a(parcel, 2, this.f19268b, false);
        SafeParcelWriter.m21964a(parcel, 3, this.f19269c, false);
        SafeParcelWriter.m21968a(parcel, 4, this.f19270d);
        SafeParcelWriter.m21968a(parcel, 5, this.f19271e);
        SafeParcelWriter.m21975b(parcel, 6, this.f19272f, false);
        SafeParcelWriter.m21965a(parcel, 7, this.f19273g, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
