package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

@zzard
public final class zzvv extends AbstractSafeParcelable {
    public static final Creator<zzvv> CREATOR = new zzvw();

    /* renamed from: a */
    public final String f29551a;

    /* renamed from: b */
    private final long f29552b;

    /* renamed from: c */
    private final String f29553c;

    /* renamed from: d */
    private final String f29554d;

    /* renamed from: e */
    private final String f29555e;

    /* renamed from: f */
    private final Bundle f29556f;

    /* renamed from: g */
    public final boolean f29557g;

    /* renamed from: h */
    public long f29558h;

    /* renamed from: a */
    public static zzvv m31317a(String str) {
        return m31316a(Uri.parse(str));
    }

    /* renamed from: a */
    public static zzvv m31316a(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzbad.m26359d(sb.toString());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            zzk.zzli();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            zzvv zzvv = new zzvv(queryParameter, parseLong, host, str, str2, bundle, equals, 0);
            return zzvv;
        } catch (NullPointerException | NumberFormatException e) {
            zzbad.m26358c("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Constructor
    zzvv(@Param(id = 2) String str, @Param(id = 3) long j, @Param(id = 4) String str2, @Param(id = 5) String str3, @Param(id = 6) String str4, @Param(id = 7) Bundle bundle, @Param(id = 8) boolean z, @Param(id = 9) long j2) {
        this.f29551a = str;
        this.f29552b = j;
        String str5 = "";
        if (str2 == null) {
            str2 = str5;
        }
        this.f29553c = str2;
        if (str3 == null) {
            str3 = str5;
        }
        this.f29554d = str3;
        if (str4 != null) {
            str5 = str4;
        }
        this.f29555e = str5;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f29556f = bundle;
        this.f29557g = z;
        this.f29558h = j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f29551a, false);
        SafeParcelWriter.m21958a(parcel, 3, this.f29552b);
        SafeParcelWriter.m21965a(parcel, 4, this.f29553c, false);
        SafeParcelWriter.m21965a(parcel, 5, this.f29554d, false);
        SafeParcelWriter.m21965a(parcel, 6, this.f29555e, false);
        SafeParcelWriter.m21959a(parcel, 7, this.f29556f, false);
        SafeParcelWriter.m21968a(parcel, 8, this.f29557g);
        SafeParcelWriter.m21958a(parcel, 9, this.f29558h);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
