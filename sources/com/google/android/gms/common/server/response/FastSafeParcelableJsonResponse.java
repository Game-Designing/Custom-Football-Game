package com.google.android.gms.common.server.response;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@KeepForSdk
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    @VisibleForTesting
    /* renamed from: a */
    public Object mo27886a(String str) {
        return null;
    }

    @VisibleForTesting
    /* renamed from: b */
    public boolean mo27887b(String str) {
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public int hashCode() {
        int i = 0;
        for (Field field : mo27101a().values()) {
            if (mo27102b(field)) {
                i = (i * 31) + mo27100a(field).hashCode();
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (Field field : mo27101a().values()) {
            if (mo27102b(field)) {
                if (!fastJsonResponse.mo27102b(field) || !mo27100a(field).equals(fastJsonResponse.mo27100a(field))) {
                    return false;
                }
            } else if (fastJsonResponse.mo27102b(field)) {
                return false;
            }
        }
        return true;
    }
}
