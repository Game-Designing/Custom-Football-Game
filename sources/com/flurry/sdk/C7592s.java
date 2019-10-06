package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.s */
public final class C7592s {

    /* renamed from: a */
    long f15068a;

    /* renamed from: b */
    boolean f15069b;

    /* renamed from: c */
    byte[] f15070c;

    /* renamed from: com.flurry.sdk.s$a */
    public static class C7593a implements C7493ad<C7592s> {
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C7586r rVar = new C7586r(this, inputStream);
            C7592s sVar = new C7592s();
            sVar.f15068a = rVar.readLong();
            sVar.f15069b = rVar.readBoolean();
            sVar.f15070c = new byte[rVar.readInt()];
            rVar.readFully(sVar.f15070c);
            return sVar;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7592s sVar = (C7592s) obj;
            if (outputStream != null && sVar != null) {
                C7581q qVar = new C7581q(this, outputStream);
                qVar.writeLong(sVar.f15068a);
                qVar.writeBoolean(sVar.f15069b);
                qVar.writeInt(sVar.f15070c.length);
                qVar.write(sVar.f15070c);
                qVar.flush();
            }
        }
    }
}
