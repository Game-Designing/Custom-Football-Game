package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* renamed from: com.flurry.sdk.ic */
public class C7536ic<ObjectType> {

    /* renamed from: a */
    public static final String f14879a = C7536ic.class.getSimpleName();

    /* renamed from: b */
    private static final byte[] f14880b = {113, -92, -8, 125, 121, 107, -65, -61, -74, -114, -32, 0, -57, -87, -35, -56, -6, -52, 51, 126, -104, 49, 79, -52, 118, -84, 99, -52, -14, -126, -27, -64};

    /* renamed from: c */
    public String f14881c;

    /* renamed from: d */
    public C7493ad<ObjectType> f14882d;

    public C7536ic(String str, C7493ad<ObjectType> adVar) {
        this.f14881c = str;
        this.f14882d = adVar;
    }

    /* renamed from: a */
    public static int m16698a(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        C7431Ob ob = new C7431Ob();
        ob.update(bArr);
        return ob.mo23872b();
    }

    /* renamed from: b */
    public static void m16699b(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int length2 = f14880b.length;
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ f14880b[i % length2]) ^ ((i * 31) % 251));
            }
        }
    }

    /* renamed from: c */
    public final ObjectType mo23963c(byte[] bArr) throws IOException {
        String str = "Decoding: ";
        if (bArr != null) {
            m16700d(bArr);
            byte[] bArr2 = (byte[]) new C7477Xc(new C7468Vc()).mo23855a(new ByteArrayInputStream(bArr));
            String str2 = f14879a;
            StringBuilder sb = new StringBuilder(str);
            sb.append(this.f14881c);
            sb.append(": ");
            sb.append(new String(bArr2));
            C7513ec.m16639a(3, str2, sb.toString());
            return this.f14882d.mo23855a(new ByteArrayInputStream(bArr2));
        }
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(this.f14881c);
        sb2.append(": Nothing to decode");
        throw new IOException(sb2.toString());
    }

    /* renamed from: d */
    private static void m16700d(byte[] bArr) {
        m16699b(bArr);
    }
}
