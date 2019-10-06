package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.ed */
public final class C7514ed<T> implements C7493ad<T> {

    /* renamed from: a */
    private final String f14819a;

    /* renamed from: b */
    private final int f14820b;

    /* renamed from: c */
    private final C7521fd<T> f14821c;

    public C7514ed(String str, int i, C7521fd<T> fdVar) {
        this.f14819a = str;
        this.f14820b = i;
        this.f14821c = fdVar;
    }

    /* renamed from: a */
    public final void mo23856a(OutputStream outputStream, T t) throws IOException {
        if (outputStream != null && this.f14821c != null) {
            C7498bd bdVar = new C7498bd(this, outputStream);
            bdVar.writeUTF(this.f14819a);
            bdVar.writeInt(this.f14820b);
            this.f14821c.mo23806a(this.f14820b).mo23856a(bdVar, t);
            bdVar.flush();
        }
    }

    /* renamed from: a */
    public final T mo23855a(InputStream inputStream) throws IOException {
        if (inputStream == null || this.f14821c == null) {
            return null;
        }
        C7503cd cdVar = new C7503cd(this, inputStream);
        String readUTF = cdVar.readUTF();
        if (this.f14819a.equals(readUTF)) {
            return this.f14821c.mo23806a(cdVar.readInt()).mo23855a(cdVar);
        }
        StringBuilder sb = new StringBuilder("Signature: ");
        sb.append(readUTF);
        sb.append(" is invalid");
        throw new IOException(sb.toString());
    }
}
