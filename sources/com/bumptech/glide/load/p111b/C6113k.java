package com.bumptech.glide.load.p111b;

import com.bumptech.glide.load.p111b.C6106i.C6110d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.k */
/* compiled from: FileLoader */
class C6113k implements C6110d<InputStream> {
    C6113k() {
    }

    /* renamed from: a */
    public InputStream m11535a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /* renamed from: a */
    public void mo18927a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* renamed from: a */
    public Class<InputStream> mo18925a() {
        return InputStream.class;
    }
}
