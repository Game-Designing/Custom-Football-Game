package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public final class zzdh {

    /* renamed from: a */
    private static final String[] f27877a = {"/aclk", "/pcs/click", "/dbm/clk"};

    /* renamed from: b */
    private String f27878b = "googleads.g.doubleclick.net";

    /* renamed from: c */
    private String f27879c = "/pagead/ads";

    /* renamed from: d */
    private String f27880d = "ad.doubleclick.net";

    /* renamed from: e */
    private String[] f27881e = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: f */
    private zzdc f27882f;

    public zzdh(zzdc zzdc) {
        this.f27882f = zzdc;
    }

    /* renamed from: c */
    private final boolean m29472c(Uri uri) {
        if (uri != null) {
            try {
                return uri.getHost().equals(this.f27880d);
            } catch (NullPointerException e) {
                return false;
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* renamed from: a */
    public final boolean mo31485a(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                for (String endsWith : this.f27881e) {
                    if (host.endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            } catch (NullPointerException e) {
                return false;
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* renamed from: a */
    public final zzdc mo31483a() {
        return this.f27882f;
    }

    /* renamed from: a */
    public final void mo31484a(MotionEvent motionEvent) {
        this.f27882f.zza(motionEvent);
    }

    /* renamed from: a */
    public final Uri mo31482a(Uri uri, Context context, View view, Activity activity) throws zzdi {
        try {
            return m29471a(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException e) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: b */
    public final boolean mo31486b(Uri uri) {
        if (mo31485a(uri)) {
            for (String endsWith : f27877a) {
                if (uri.getPath().endsWith(endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private final Uri m29471a(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzdi {
        String str2;
        try {
            boolean c = m29472c(uri);
            String str3 = "ms";
            if (c) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzdi("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter(str3) != null) {
                throw new zzdi("Query parameter already exists: ms");
            }
            if (z) {
                str2 = this.f27882f.zza(context, str, view, activity);
            } else {
                str2 = this.f27882f.zza(context);
            }
            String str4 = "=";
            if (c) {
                String str5 = "dc_ms";
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                String str6 = ";";
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    StringBuilder sb = new StringBuilder(uri2.substring(0, i));
                    sb.append(str5);
                    sb.append(str4);
                    sb.append(str2);
                    sb.append(str6);
                    sb.append(uri2.substring(i));
                    return Uri.parse(sb.toString());
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                StringBuilder sb2 = new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2));
                sb2.append(str6);
                sb2.append(str5);
                sb2.append(str4);
                sb2.append(str2);
                sb2.append(str6);
                sb2.append(uri2.substring(indexOf2 + encodedPath.length()));
                return Uri.parse(sb2.toString());
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter(str3, str2).build();
            }
            int i2 = indexOf3 + 1;
            StringBuilder sb3 = new StringBuilder(uri3.substring(0, i2));
            sb3.append(str3);
            sb3.append(str4);
            sb3.append(str2);
            sb3.append("&");
            sb3.append(uri3.substring(i2));
            return Uri.parse(sb3.toString());
        } catch (UnsupportedOperationException e) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }
}
