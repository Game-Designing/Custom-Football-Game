package com.bumptech.glide.load.p109a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.n */
/* compiled from: StreamAssetPathFetcher */
public class C6058n extends C6040b<InputStream> {
    public C6058n(AssetManager assetManager, String assetPath) {
        super(assetManager, assetPath);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InputStream m11394a(AssetManager assetManager, String path) throws IOException {
        return assetManager.open(path);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18861a(InputStream data) throws IOException {
        data.close();
    }

    /* renamed from: a */
    public Class<InputStream> mo18847a() {
        return InputStream.class;
    }
}
