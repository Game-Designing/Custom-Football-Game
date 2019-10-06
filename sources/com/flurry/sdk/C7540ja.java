package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.ja */
public final class C7540ja {

    /* renamed from: a */
    byte[] f14895a;

    /* renamed from: com.flurry.sdk.ja$a */
    public static class C7541a implements C7493ad<C7540ja> {
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C7534ia iaVar = new C7534ia(this, inputStream);
            short readShort = iaVar.readShort();
            if (readShort == 0) {
                return null;
            }
            C7540ja jaVar = new C7540ja();
            jaVar.f14895a = new byte[readShort];
            iaVar.readFully(jaVar.f14895a);
            iaVar.readUnsignedShort();
            return jaVar;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7540ja jaVar = (C7540ja) obj;
            if (outputStream != null && jaVar != null) {
                C7528ha haVar = new C7528ha(this, outputStream);
                haVar.writeShort(jaVar.f14895a.length);
                haVar.write(jaVar.f14895a);
                haVar.writeShort(0);
                haVar.flush();
            }
        }
    }

    public C7540ja() {
    }

    public C7540ja(byte[] bArr) {
        this.f14895a = bArr;
    }
}
