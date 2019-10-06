package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;

public class zzax extends zzr<String> {

    /* renamed from: p */
    private final Object f24931p = new Object();

    /* renamed from: q */
    private zzaa<String> f24932q;

    public zzax(int i, String str, zzaa<String> zzaa, zzz zzz) {
        super(i, str, zzz);
        this.f24932q = zzaa;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo29242a(String str) {
        zzaa<String> zzaa;
        synchronized (this.f24931p) {
            zzaa = this.f24932q;
        }
        if (zzaa != null) {
            zzaa.mo29262a(str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final zzy<String> mo30196a(zzp zzp) {
        String str;
        try {
            byte[] bArr = zzp.f29061b;
            String str2 = "ISO-8859-1";
            String str3 = (String) zzp.f29062c.get("Content-Type");
            if (str3 != null) {
                String[] split = str3.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str2 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException e) {
            str = new String(zzp.f29061b);
        }
        return zzy.m31506a(str, zzaq.m25652a(zzp));
    }
}
