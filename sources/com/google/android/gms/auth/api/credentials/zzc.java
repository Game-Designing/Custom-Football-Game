package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzc implements Creator<Credential> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Credential[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        String str2 = null;
        Uri uri = null;
        List list = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    str = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 2:
                    str2 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 3:
                    uri = (Uri) SafeParcelReader.m21921a(parcel, a, Uri.CREATOR);
                    break;
                case 4:
                    list = SafeParcelReader.m21929c(parcel, a, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 6:
                    str4 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 9:
                    str5 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 10:
                    str6 = SafeParcelReader.m21941o(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        Credential credential = new Credential(str, str2, uri, list, str3, str4, str5, str6);
        return credential;
    }
}
