package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.Uc */
public final class C7463Uc {

    /* renamed from: a */
    String f14709a;

    /* renamed from: com.flurry.sdk.Uc$a */
    public static class C7464a implements C7493ad<C7463Uc> {
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C7458Tc tc = new C7458Tc(this, inputStream);
            C7463Uc uc = new C7463Uc(0);
            uc.f14709a = tc.readUTF();
            return uc;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7463Uc uc = (C7463Uc) obj;
            if (outputStream != null && uc != null) {
                C7453Sc sc = new C7453Sc(this, outputStream);
                sc.writeUTF(uc.f14709a);
                sc.flush();
            }
        }
    }

    /* synthetic */ C7463Uc(byte b) {
        this();
    }

    private C7463Uc() {
    }

    public C7463Uc(String str) {
        this.f14709a = str;
    }
}
