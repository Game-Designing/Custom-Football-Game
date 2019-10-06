package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzpo.zza;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zznr {

    /* renamed from: a */
    private static final zzpu f28975a = new C9243Xr();

    /* renamed from: b */
    private static final Pattern f28976b = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: c */
    public int f28977c = -1;

    /* renamed from: d */
    public int f28978d = -1;

    /* renamed from: a */
    public final boolean mo32060a(zzpo zzpo) {
        for (int i = 0; i < zzpo.mo32088a(); i++) {
            zza a = zzpo.mo32089a(i);
            if (a instanceof zzps) {
                zzps zzps = (zzps) a;
                if (m30825a(zzps.f29145c, zzps.f29146d)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private final boolean m30825a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f28976b.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt <= 0) {
                    if (parseInt2 > 0) {
                    }
                }
                this.f28977c = parseInt;
                this.f28978d = parseInt2;
                return true;
            } catch (NumberFormatException e) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo32059a() {
        return (this.f28977c == -1 || this.f28978d == -1) ? false : true;
    }
}
