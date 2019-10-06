package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.C8628R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@Deprecated
public final class GoogleServices {

    /* renamed from: a */
    private static final Object f19683a = new Object();

    /* renamed from: b */
    private static GoogleServices f19684b;

    /* renamed from: c */
    private final String f19685c;

    /* renamed from: d */
    private final Status f19686d;

    /* renamed from: e */
    private final boolean f19687e;

    /* renamed from: f */
    private final boolean f19688f;

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C8628R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            if (resources.getInteger(identifier) == 0) {
                z = false;
            }
            this.f19688f = !z;
        } else {
            this.f19688f = false;
        }
        this.f19687e = z;
        String a = zzp.m22005a(context);
        if (a == null) {
            a = new StringResourceValueReader(context).mo27829a("google_app_id");
        }
        if (TextUtils.isEmpty(a)) {
            this.f19686d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f19685c = null;
            return;
        }
        this.f19685c = a;
        this.f19686d = Status.f19597a;
    }

    @KeepForSdk
    /* renamed from: a */
    public static Status m21307a(Context context) {
        Status status;
        Preconditions.m21858a(context, (Object) "Context must not be null.");
        synchronized (f19683a) {
            if (f19684b == null) {
                f19684b = new GoogleServices(context);
            }
            status = f19684b.f19686d;
        }
        return status;
    }

    @KeepForSdk
    /* renamed from: a */
    public static String m21309a() {
        return m21308a("getGoogleAppId").f19685c;
    }

    @KeepForSdk
    /* renamed from: a */
    private static GoogleServices m21308a(String str) {
        GoogleServices googleServices;
        synchronized (f19683a) {
            if (f19684b != null) {
                googleServices = f19684b;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }
}
