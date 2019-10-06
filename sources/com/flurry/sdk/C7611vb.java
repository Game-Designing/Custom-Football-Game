package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.vb */
public final class C7611vb {

    /* renamed from: a */
    boolean f15112a;

    /* renamed from: b */
    byte[] f15113b;

    /* renamed from: c */
    byte[] f15114c;

    /* renamed from: d */
    int f15115d;

    /* renamed from: com.flurry.sdk.vb$a */
    static class C7612a implements C7493ad<C7611vb> {
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C7605ub ubVar = new C7605ub(this, inputStream);
            C7611vb vbVar = new C7611vb(0);
            vbVar.f15112a = ubVar.readBoolean();
            int readInt = ubVar.readInt();
            if (readInt > 0) {
                vbVar.f15113b = new byte[readInt];
                ubVar.read(vbVar.f15113b, 0, readInt);
            } else {
                vbVar.f15113b = null;
            }
            int readInt2 = ubVar.readInt();
            if (readInt2 > 0) {
                vbVar.f15114c = new byte[readInt2];
                ubVar.read(vbVar.f15114c, 0, readInt2);
            } else {
                vbVar.f15114c = null;
            }
            vbVar.f15115d = ubVar.readInt();
            return vbVar;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7611vb vbVar = (C7611vb) obj;
            if (outputStream != null && vbVar != null) {
                C7600tb tbVar = new C7600tb(this, outputStream);
                tbVar.writeBoolean(vbVar.f15112a);
                byte[] bArr = vbVar.f15113b;
                if (bArr == null) {
                    tbVar.writeInt(0);
                } else {
                    tbVar.writeInt(bArr.length);
                    tbVar.write(vbVar.f15113b);
                }
                byte[] bArr2 = vbVar.f15114c;
                if (bArr2 == null) {
                    tbVar.writeInt(0);
                } else {
                    tbVar.writeInt(bArr2.length);
                    tbVar.write(vbVar.f15114c);
                }
                tbVar.writeInt(vbVar.f15115d);
                tbVar.flush();
            }
        }

        C7612a() {
        }
    }

    /* synthetic */ C7611vb(byte b) {
        this();
    }

    public C7611vb(byte[] bArr, byte[] bArr2, boolean z, int i) {
        this.f15113b = bArr2;
        this.f15114c = bArr;
        this.f15112a = z;
        this.f15115d = i;
    }

    private C7611vb() {
    }
}
