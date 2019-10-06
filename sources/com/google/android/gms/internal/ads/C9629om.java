package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.ads.om */
final /* synthetic */ class C9629om implements Runnable {

    /* renamed from: a */
    private final InputStream f22843a;

    /* renamed from: b */
    private final ParcelFileDescriptor f22844b;

    C9629om(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.f22843a = inputStream;
        this.f22844b = parcelFileDescriptor;
    }

    public final void run() {
        zzcyc.m29002a(this.f22843a, this.f22844b);
    }
}
