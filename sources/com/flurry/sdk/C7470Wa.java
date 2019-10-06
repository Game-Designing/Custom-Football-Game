package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.sdk.Wa */
public class C7470Wa {

    /* renamed from: a */
    private static final String f14713a = C7470Wa.class.getSimpleName();
    /* access modifiers changed from: 0000 */

    /* renamed from: b */
    public final List<C7631za> f14714b = new ArrayList();
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public boolean f14715c;
    /* access modifiers changed from: 0000 */

    /* renamed from: d */
    public long f14716d;

    /* renamed from: com.flurry.sdk.Wa$a */
    public static class C7471a implements C7493ad<C7470Wa> {
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C7466Va va = new C7466Va(this, inputStream);
            C7470Wa wa = new C7470Wa();
            va.readUTF();
            va.readUTF();
            wa.f14715c = va.readBoolean();
            wa.f14716d = va.readLong();
            while (true) {
                int readUnsignedShort = va.readUnsignedShort();
                if (readUnsignedShort == 0) {
                    return wa;
                }
                byte[] bArr = new byte[readUnsignedShort];
                va.readFully(bArr);
                wa.f14714b.add(0, new C7631za(bArr));
            }
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            throw new UnsupportedOperationException("Serialization not supported");
        }
    }
}
