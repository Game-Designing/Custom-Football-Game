package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: a */
    private final Feature f19608a;

    @KeepForSdk
    public UnsupportedApiCallException(Feature feature) {
        this.f19608a = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.f19608a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
