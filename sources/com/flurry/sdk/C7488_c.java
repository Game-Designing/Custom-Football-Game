package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.sdk._c */
public final class C7488_c<T> implements C7493ad<List<T>> {

    /* renamed from: a */
    C7493ad<T> f14736a;

    public C7488_c(C7493ad<T> adVar) {
        this.f14736a = adVar;
    }

    /* renamed from: a */
    public final void mo23856a(OutputStream outputStream, List<T> list) throws IOException {
        if (outputStream != null) {
            C7481Yc yc = new C7481Yc(this, outputStream);
            int size = list != null ? list.size() : 0;
            yc.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.f14736a.mo23856a(outputStream, list.get(i));
            }
            yc.flush();
        }
    }

    /* renamed from: b */
    public final List<T> mo23855a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        int readInt = new C7485Zc(this, inputStream).readInt();
        ArrayList arrayList = new ArrayList(readInt);
        int i = 0;
        while (i < readInt) {
            Object a = this.f14736a.mo23855a(inputStream);
            if (a != null) {
                arrayList.add(a);
                i++;
            } else {
                throw new IOException("Missing record.");
            }
        }
        return arrayList;
    }
}
