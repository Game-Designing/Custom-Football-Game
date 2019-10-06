package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.TimeUnit;

@zzard
public final class zzbdg {

    /* renamed from: a */
    private final Context f25157a;

    /* renamed from: b */
    private final String f25158b;

    /* renamed from: c */
    private final zzbai f25159c;

    /* renamed from: d */
    private final zzadg f25160d;

    /* renamed from: e */
    private final zzadi f25161e;

    /* renamed from: f */
    private final zzayq f25162f = new zzayt().mo30293a("min_1", Double.MIN_VALUE, 1.0d).mo30293a("1_5", 1.0d, 5.0d).mo30293a("5_10", 5.0d, 10.0d).mo30293a("10_20", 10.0d, 20.0d).mo30293a("20_30", 20.0d, 30.0d).mo30293a("30_max", 30.0d, Double.MAX_VALUE).mo30292a();

    /* renamed from: g */
    private final long[] f25163g;

    /* renamed from: h */
    private final String[] f25164h;

    /* renamed from: i */
    private boolean f25165i = false;

    /* renamed from: j */
    private boolean f25166j = false;

    /* renamed from: k */
    private boolean f25167k = false;

    /* renamed from: l */
    private boolean f25168l = false;

    /* renamed from: m */
    private boolean f25169m;

    /* renamed from: n */
    private zzbco f25170n;

    /* renamed from: o */
    private boolean f25171o;

    /* renamed from: p */
    private boolean f25172p;

    /* renamed from: q */
    private long f25173q = -1;

    public zzbdg(Context context, zzbai zzbai, String str, zzadi zzadi, zzadg zzadg) {
        this.f25157a = context;
        this.f25159c = zzbai;
        this.f25158b = str;
        this.f25161e = zzadi;
        this.f25160d = zzadg;
        String str2 = (String) zzyt.m31536e().mo29599a(zzacu.f23944I);
        if (str2 == null) {
            this.f25164h = new String[0];
            this.f25163g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.f25164h = new String[split.length];
        this.f25163g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.f25163g[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzbad.m26358c("Unable to parse frame hash target time number.", e);
                this.f25163g[i] = -1;
            }
        }
    }

    /* renamed from: a */
    public final void mo30432a(zzbco zzbco) {
        zzadb.m24799a(this.f25161e, this.f25160d, "vpc2");
        this.f25165i = true;
        zzadi zzadi = this.f25161e;
        if (zzadi != null) {
            zzadi.mo29620a("vpn", zzbco.mo30353e());
        }
        this.f25170n = zzbco;
    }

    /* renamed from: b */
    public final void mo30433b() {
        if (this.f25165i && !this.f25166j) {
            zzadb.m24799a(this.f25161e, this.f25160d, "vfr2");
            this.f25166j = true;
        }
    }

    /* renamed from: a */
    public final void mo30431a() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23938H)).booleanValue() && !this.f25171o) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.f25158b);
            bundle.putString("player", this.f25170n.mo30353e());
            for (zzays zzays : this.f25162f.mo30287a()) {
                String valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(zzays.f24998a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(zzays.f25002e));
                String valueOf3 = String.valueOf("fps_p_");
                String valueOf4 = String.valueOf(zzays.f24998a);
                bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(zzays.f25001d));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.f25163g;
                if (i < jArr.length) {
                    String str = this.f25164h[i];
                    if (str != null) {
                        String valueOf5 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf5);
                        bundle.putString(sb.toString(), str);
                    }
                    i++;
                } else {
                    zzk.zzlg().mo30232a(this.f25157a, this.f25159c.f25057a, "gmob-apps", bundle, true);
                    this.f25171o = true;
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo30434b(zzbco zzbco) {
        if (this.f25167k && !this.f25168l) {
            if (zzawz.m26001a() && !this.f25168l) {
                zzawz.m26003f("VideoMetricsMixin first frame");
            }
            zzadb.m24799a(this.f25161e, this.f25160d, "vff2");
            this.f25168l = true;
        }
        long c = zzk.zzln().mo27936c();
        if (this.f25169m && this.f25172p && this.f25173q != -1) {
            double nanos = (double) TimeUnit.SECONDS.toNanos(1);
            double d = (double) (c - this.f25173q);
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.f25162f.mo30288a(nanos / d);
        }
        this.f25172p = this.f25169m;
        this.f25173q = c;
        long longValue = ((Long) zzyt.m31536e().mo29599a(zzacu.f23950J)).longValue();
        long currentPosition = (long) zzbco.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.f25164h;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] != null || longValue <= Math.abs(currentPosition - this.f25163g[i])) {
                zzbco zzbco2 = zzbco;
                i++;
            } else {
                String[] strArr2 = this.f25164h;
                int i2 = 8;
                Bitmap bitmap = zzbco.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    /* renamed from: c */
    public final void mo30435c() {
        this.f25169m = true;
        if (this.f25166j && !this.f25167k) {
            zzadb.m24799a(this.f25161e, this.f25160d, "vfp2");
            this.f25167k = true;
        }
    }

    /* renamed from: d */
    public final void mo30436d() {
        this.f25169m = false;
    }
}
