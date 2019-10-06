package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.C8581R;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzapu extends zzaqb {

    /* renamed from: c */
    private final Map<String, String> f24556c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f24557d;

    public zzapu(zzbgz zzbgz, Map<String, String> map) {
        super(zzbgz, "storePicture");
        this.f24556c = map;
        this.f24557d = zzbgz.mo28780q();
    }

    /* renamed from: a */
    public final void mo29981a() {
        if (this.f24557d == null) {
            mo29991a("Activity context is not available");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.m26134e(this.f24557d).mo29587c()) {
            mo29991a("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.f24556c.get("iurl");
        if (TextUtils.isEmpty(str)) {
            mo29991a("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String str2 = "Invalid image url: ";
            String valueOf = String.valueOf(str);
            mo29991a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzk.zzlg();
            if (!zzaxi.m26124b(lastPathSegment)) {
                String str3 = "Image type not recognized: ";
                String valueOf2 = String.valueOf(lastPathSegment);
                mo29991a(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                return;
            }
            Resources b = zzk.zzlk().mo30169b();
            zzk.zzlg();
            Builder d = zzaxi.m26131d(this.f24557d);
            d.setTitle(b != null ? b.getString(C8581R.string.f19070s1) : "Save image");
            d.setMessage(b != null ? b.getString(C8581R.string.f19071s2) : "Allow Ad to store image in Picture gallery?");
            d.setPositiveButton(b != null ? b.getString(C8581R.string.f19072s3) : "Accept", new C9530kb(this, str, lastPathSegment));
            d.setNegativeButton(b != null ? b.getString(C8581R.string.f19073s4) : "Decline", new C9552lb(this));
            d.create().show();
        }
    }
}
