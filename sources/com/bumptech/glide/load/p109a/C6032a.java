package com.bumptech.glide.load.p109a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.a */
/* compiled from: AssetFileDescriptorLocalUriFetcher */
public final class C6032a extends C6057m<AssetFileDescriptor> {
    public C6032a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AssetFileDescriptor m11311a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor result = contentResolver.openAssetFileDescriptor(uri, "r");
        if (result != null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("FileDescriptor is null for: ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18849a(AssetFileDescriptor data) throws IOException {
        data.close();
    }

    /* renamed from: a */
    public Class<AssetFileDescriptor> mo18847a() {
        return AssetFileDescriptor.class;
    }
}
