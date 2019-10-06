package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class zzdll implements zzdby {

    /* renamed from: a */
    private Mac f27959a;

    /* renamed from: b */
    private final int f27960b;

    /* renamed from: c */
    private final String f27961c;

    /* renamed from: d */
    private final Key f27962d;

    public zzdll(String str, Key key, int i) throws GeneralSecurityException {
        if (i >= 10) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c = 0;
            }
            String str2 = "tag size too big";
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        String str3 = "unknown Hmac algorithm: ";
                        String valueOf = String.valueOf(str);
                        throw new NoSuchAlgorithmException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    } else if (i > 64) {
                        throw new InvalidAlgorithmParameterException(str2);
                    }
                } else if (i > 32) {
                    throw new InvalidAlgorithmParameterException(str2);
                }
            } else if (i > 20) {
                throw new InvalidAlgorithmParameterException(str2);
            }
            this.f27961c = str;
            this.f27960b = i;
            this.f27962d = key;
            this.f27959a = (Mac) zzdkx.f27943d.mo31525a(str);
            this.f27959a.init(key);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    /* renamed from: a */
    public final byte[] mo31381a(byte[] bArr) throws GeneralSecurityException {
        Mac mac;
        try {
            mac = (Mac) this.f27959a.clone();
        } catch (CloneNotSupportedException e) {
            mac = (Mac) zzdkx.f27943d.mo31525a(this.f27961c);
            mac.init(this.f27962d);
        }
        mac.update(bArr);
        byte[] bArr2 = new byte[this.f27960b];
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, this.f27960b);
        return bArr2;
    }
}
