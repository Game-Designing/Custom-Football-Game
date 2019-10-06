package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public final class zzctp implements zzcva<zzcto> {

    /* renamed from: a */
    private final zzbbl f27366a;

    /* renamed from: b */
    private final zzcxv f27367b;

    /* renamed from: c */
    private final PackageInfo f27368c;

    /* renamed from: d */
    private final zzaxb f27369d;

    public zzctp(zzbbl zzbbl, zzcxv zzcxv, PackageInfo packageInfo, zzaxb zzaxb) {
        this.f27366a = zzbbl;
        this.f27367b = zzcxv;
        this.f27368c = packageInfo;
        this.f27369d = zzaxb;
    }

    /* renamed from: a */
    public final zzbbh<zzcto> mo28586a() {
        return this.f27366a.mo30326a((Callable<T>) new C8751Al<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo31259a(java.util.ArrayList r8, android.os.Bundle r9) {
        /*
            r7 = this;
            r0 = 3
            java.lang.String r1 = "native_version"
            r9.putInt(r1, r0)
            java.lang.String r1 = "native_templates"
            r9.putStringArrayList(r1, r8)
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            java.util.ArrayList<java.lang.String> r8 = r8.f27604h
            java.lang.String r1 = "native_custom_templates"
            r9.putStringArrayList(r1, r8)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r8 = com.google.android.gms.internal.ads.zzacu.f23965Lc
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r8 = r1.mo29599a(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.String r1 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            r4 = 2
            java.lang.String r5 = "unknown"
            r6 = 1
            if (r8 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            com.google.android.gms.internal.ads.zzady r8 = r8.f27605i
            int r8 = r8.f24265a
            if (r8 <= r0) goto L_0x0062
            java.lang.String r8 = "enable_native_media_orientation"
            r9.putBoolean(r8, r6)
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            com.google.android.gms.internal.ads.zzady r8 = r8.f27605i
            int r8 = r8.f24272h
            if (r8 == r6) goto L_0x0055
            if (r8 == r4) goto L_0x0053
            if (r8 == r0) goto L_0x0051
            r0 = 4
            if (r8 == r0) goto L_0x004e
            r8 = r5
            goto L_0x0056
        L_0x004e:
            java.lang.String r8 = "square"
            goto L_0x0056
        L_0x0051:
            r8 = r2
            goto L_0x0056
        L_0x0053:
            r8 = r1
            goto L_0x0056
        L_0x0055:
            r8 = r3
        L_0x0056:
            boolean r0 = r5.equals(r8)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = "native_media_orientation"
            r9.putString(r0, r8)
        L_0x0062:
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            com.google.android.gms.internal.ads.zzady r8 = r8.f27605i
            int r8 = r8.f24267c
            if (r8 == 0) goto L_0x0073
            if (r8 == r6) goto L_0x0071
            if (r8 == r4) goto L_0x0070
            r1 = r5
            goto L_0x0074
        L_0x0070:
            goto L_0x0074
        L_0x0071:
            r1 = r2
            goto L_0x0074
        L_0x0073:
            r1 = r3
        L_0x0074:
            boolean r8 = r5.equals(r1)
            if (r8 != 0) goto L_0x0080
            java.lang.String r8 = "native_image_orientation"
            r9.putString(r8, r1)
        L_0x0080:
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            com.google.android.gms.internal.ads.zzady r8 = r8.f27605i
            boolean r8 = r8.f24268d
            java.lang.String r0 = "native_multiple_images"
            r9.putBoolean(r0, r8)
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            com.google.android.gms.internal.ads.zzady r8 = r8.f27605i
            boolean r8 = r8.f24271g
            java.lang.String r0 = "use_custom_mute"
            r9.putBoolean(r0, r8)
            android.content.pm.PackageInfo r8 = r7.f27368c
            if (r8 != 0) goto L_0x009d
            r8 = 0
            goto L_0x009f
        L_0x009d:
            int r8 = r8.versionCode
        L_0x009f:
            com.google.android.gms.internal.ads.zzaxb r0 = r7.f27369d
            int r0 = r0.mo30223l()
            if (r8 <= r0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzaxb r0 = r7.f27369d
            r0.mo30218g()
            com.google.android.gms.internal.ads.zzaxb r0 = r7.f27369d
            r0.mo30200a(r8)
        L_0x00b2:
            com.google.android.gms.internal.ads.zzaxb r8 = r7.f27369d
            org.json.JSONObject r8 = r8.mo30211c()
            if (r8 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzcxv r0 = r7.f27367b
            java.lang.String r0 = r0.f27602f
            org.json.JSONArray r8 = r8.optJSONArray(r0)
            if (r8 == 0) goto L_0x00c9
            java.lang.String r8 = r8.toString()
            goto L_0x00ca
        L_0x00c9:
            r8 = 0
        L_0x00ca:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x00d6
            java.lang.String r0 = "native_advanced_settings"
            r9.putString(r0, r8)
        L_0x00d6:
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            int r8 = r8.f27608l
            if (r8 <= r6) goto L_0x00e1
            java.lang.String r0 = "max_num_ads"
            r9.putInt(r0, r8)
        L_0x00e1:
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            com.google.android.gms.internal.ads.zzaiy r8 = r8.f27599c
            if (r8 == 0) goto L_0x011b
            int r8 = r8.f24371a
            java.lang.String r0 = "l"
            if (r8 == r6) goto L_0x0110
            if (r8 == r4) goto L_0x010d
            r1 = 52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Instream ad video aspect ratio "
            r2.append(r1)
            r2.append(r8)
            java.lang.String r8 = " is wrong."
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.google.android.gms.internal.ads.zzbad.m26355b(r8)
            goto L_0x0111
        L_0x010d:
            java.lang.String r0 = "p"
            goto L_0x0111
        L_0x0110:
        L_0x0111:
            java.lang.String r8 = "ia_var"
            r9.putString(r8, r0)
            java.lang.String r8 = "instr"
            r9.putBoolean(r8, r6)
        L_0x011b:
            com.google.android.gms.internal.ads.zzcxv r8 = r7.f27367b
            com.google.android.gms.internal.ads.zzaga r8 = r8.mo31285a()
            if (r8 == 0) goto L_0x0128
            java.lang.String r8 = "has_delayed_banner_listener"
            r9.putBoolean(r8, r6)
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzctp.mo31259a(java.util.ArrayList, android.os.Bundle):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcto mo31260b() throws Exception {
        ArrayList<String> arrayList = this.f27367b.f27603g;
        if (arrayList == null) {
            return C8772Bl.f20519a;
        }
        if (arrayList.isEmpty()) {
            return C8793Cl.f20559a;
        }
        return new C8814Dl(this, arrayList);
    }
}
