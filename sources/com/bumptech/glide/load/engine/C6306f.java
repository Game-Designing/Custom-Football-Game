package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6229d;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.engine.p121b.C6269a.C6271b;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.f */
/* compiled from: DataCacheWriter */
class C6306f<DataType> implements C6271b {

    /* renamed from: a */
    private final C6229d<DataType> f11169a;

    /* renamed from: b */
    private final DataType f11170b;

    /* renamed from: c */
    private final C6349k f11171c;

    C6306f(C6229d<DataType> encoder, DataType data, C6349k options) {
        this.f11169a = encoder;
        this.f11170b = data;
        this.f11171c = options;
    }

    /* renamed from: a */
    public boolean mo19179a(File file) {
        return this.f11169a.mo18888a(this.f11170b, file, this.f11171c);
    }
}
