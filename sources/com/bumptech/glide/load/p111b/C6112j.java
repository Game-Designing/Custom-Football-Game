package com.bumptech.glide.load.p111b;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.p111b.C6106i.C6110d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.b.j */
/* compiled from: FileLoader */
class C6112j implements C6110d<ParcelFileDescriptor> {
    C6112j() {
    }

    /* renamed from: a */
    public ParcelFileDescriptor m11530a(File file) throws FileNotFoundException {
        return ParcelFileDescriptor.open(file, 268435456);
    }

    /* renamed from: a */
    public void mo18927a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    /* renamed from: a */
    public Class<ParcelFileDescriptor> mo18925a() {
        return ParcelFileDescriptor.class;
    }
}
