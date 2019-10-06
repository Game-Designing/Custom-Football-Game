package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.Wc */
public class C7473Wc<ObjectType> implements C7493ad<ObjectType> {

    /* renamed from: a */
    protected final C7493ad<ObjectType> f14719a;

    public C7473Wc(C7493ad<ObjectType> adVar) {
        this.f14719a = adVar;
    }

    /* renamed from: a */
    public void mo23856a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        C7493ad<ObjectType> adVar = this.f14719a;
        if (adVar != null && outputStream != null && objecttype != null) {
            adVar.mo23856a(outputStream, objecttype);
        }
    }

    /* renamed from: a */
    public ObjectType mo23855a(InputStream inputStream) throws IOException {
        C7493ad<ObjectType> adVar = this.f14719a;
        if (adVar == null || inputStream == null) {
            return null;
        }
        return adVar.mo23855a(inputStream);
    }
}
