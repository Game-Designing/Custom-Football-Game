package com.bumptech.glide.load.p109a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.i */
/* compiled from: FileDescriptorAssetPathFetcher */
public class C6050i extends C6040b<ParcelFileDescriptor> {
    public C6050i(AssetManager assetManager, String assetPath) {
        super(assetManager, assetPath);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ParcelFileDescriptor m11363a(AssetManager assetManager, String path) throws IOException {
        return assetManager.openFd(path).getParcelFileDescriptor();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18861a(ParcelFileDescriptor data) throws IOException {
        data.close();
    }

    /* renamed from: a */
    public Class<ParcelFileDescriptor> mo18847a() {
        return ParcelFileDescriptor.class;
    }
}
