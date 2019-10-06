package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.C8628R;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StringResourceValueReader {

    /* renamed from: a */
    private final Resources f20137a;

    /* renamed from: b */
    private final String f20138b = this.f20137a.getResourcePackageName(C8628R.string.common_google_play_services_unknown_issue);

    public StringResourceValueReader(Context context) {
        Preconditions.m21857a(context);
        this.f20137a = context.getResources();
    }

    @KeepForSdk
    /* renamed from: a */
    public String mo27829a(String str) {
        int identifier = this.f20137a.getIdentifier(str, "string", this.f20138b);
        if (identifier == 0) {
            return null;
        }
        return this.f20137a.getString(identifier);
    }
}
