package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class ApiExceptionUtil {
    @KeepForSdk
    /* renamed from: a */
    public static ApiException m21721a(Status status) {
        if (status.mo27420d()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
