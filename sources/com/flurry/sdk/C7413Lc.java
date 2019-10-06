package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* renamed from: com.flurry.sdk.Lc */
public final class C7413Lc {

    /* renamed from: a */
    String f14534a;

    /* renamed from: b */
    byte[] f14535b;

    /* renamed from: com.flurry.sdk.Lc$a */
    public static class C7414a implements C7493ad<C7413Lc> {

        /* renamed from: a */
        private int f14536a = 1;

        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            int i;
            if (inputStream == null) {
                return null;
            }
            C7408Kc kc = new C7408Kc(this, inputStream);
            C7413Lc lc = new C7413Lc(0);
            if (this.f14536a == 1) {
                i = kc.readShort();
            } else {
                i = kc.readInt();
            }
            if (i == 0) {
                return null;
            }
            lc.f14535b = new byte[i];
            kc.readFully(lc.f14535b);
            kc.readUnsignedShort();
            return lc;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7413Lc lc = (C7413Lc) obj;
            if (outputStream != null && lc != null) {
                C7402Jc jc = new C7402Jc(this, outputStream);
                int length = lc.f14535b.length;
                if (this.f14536a == 1) {
                    jc.writeShort(length);
                } else {
                    jc.writeInt(length);
                }
                jc.write(lc.f14535b);
                jc.writeShort(0);
                jc.flush();
            }
        }

        public C7414a(int i) {
            this.f14536a = i;
        }
    }

    /* synthetic */ C7413Lc(byte b) {
        this();
    }

    private C7413Lc() {
        this.f14534a = null;
        this.f14535b = null;
    }

    public C7413Lc(byte[] bArr) {
        this.f14534a = null;
        this.f14535b = null;
        this.f14534a = UUID.randomUUID().toString();
        this.f14535b = bArr;
    }

    /* renamed from: a */
    public static String m16407a(String str) {
        return ".yflurrydatasenderblock.".concat(String.valueOf(str));
    }

    /* renamed from: b */
    public static C7443Qb<C7413Lc> m16408b(String str) {
        return new C7443Qb<>(C7379Fb.m16300a().f14432d.getFileStreamPath(m16407a(str)), ".yflurrydatasenderblock.", 2, new C7397Ic());
    }
}
