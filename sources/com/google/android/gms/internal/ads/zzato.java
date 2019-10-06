package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import org.json.JSONArray;
import org.json.JSONException;

@zzard
public final class zzato extends AbstractSafeParcelable {
    public static final Creator<zzato> CREATOR = new zzatp();

    /* renamed from: a */
    public final String f24820a;

    /* renamed from: b */
    public final int f24821b;

    public zzato(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    @Constructor
    public zzato(@Param(id = 2) String str, @Param(id = 3) int i) {
        this.f24820a = str;
        this.f24821b = i;
    }

    /* renamed from: a */
    public static zzato m25809a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzato(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f24820a, false);
        SafeParcelWriter.m21957a(parcel, 3, this.f24821b);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzato)) {
            return false;
        }
        zzato zzato = (zzato) obj;
        if (!Objects.m21851a(this.f24820a, zzato.f24820a) || !Objects.m21851a(Integer.valueOf(this.f24821b), Integer.valueOf(zzato.f24821b))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.m21849a(this.f24820a, Integer.valueOf(this.f24821b));
    }
}
