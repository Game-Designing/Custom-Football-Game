package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.extractor.flv.C8285c;
import com.google.android.exoplayer2.extractor.mp4.C8304h;
import com.google.android.exoplayer2.extractor.mp4.C8309k;
import com.google.android.exoplayer2.p183b.p184a.C8157b;
import com.google.android.exoplayer2.p183b.p185b.C8166g;
import com.google.android.exoplayer2.p183b.p186c.C8177e;
import com.google.android.exoplayer2.p183b.p187d.C8188e;
import com.google.android.exoplayer2.p183b.p188e.C8212F;
import com.google.android.exoplayer2.p183b.p188e.C8226e;
import com.google.android.exoplayer2.p183b.p188e.C8228g;
import com.google.android.exoplayer2.p183b.p188e.C8251y;
import com.google.android.exoplayer2.p183b.p189f.C8256b;
import java.lang.reflect.Constructor;

/* renamed from: com.google.android.exoplayer2.b.e */
/* compiled from: DefaultExtractorsFactory */
public final class C8205e implements C8263j {

    /* renamed from: a */
    private static final Constructor<? extends C8260g> f17139a;

    /* renamed from: b */
    private boolean f17140b;

    /* renamed from: c */
    private int f17141c;

    /* renamed from: d */
    private int f17142d;

    /* renamed from: e */
    private int f17143e;

    /* renamed from: f */
    private int f17144f;

    /* renamed from: g */
    private int f17145g;

    /* renamed from: h */
    private int f17146h;

    /* renamed from: i */
    private int f17147i = 1;

    /* renamed from: j */
    private int f17148j;

    static {
        Constructor<? extends C8260g> constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(C8260g.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException e) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f17139a = constructor;
    }

    public synchronized C8260g[] createExtractors() {
        C8260g[] extractors;
        extractors = new C8260g[(f17139a == null ? 12 : 13)];
        extractors[0] = new C8166g(this.f17143e);
        int i = 1;
        extractors[1] = new C8304h(this.f17145g);
        extractors[2] = new C8309k(this.f17144f);
        extractors[3] = new C8177e(this.f17146h | (this.f17140b ? 1 : 0));
        extractors[4] = new C8228g(0, this.f17141c | (this.f17140b ? 1 : 0));
        extractors[5] = new C8226e();
        extractors[6] = new C8212F(this.f17147i, this.f17148j);
        extractors[7] = new C8285c();
        extractors[8] = new C8188e();
        extractors[9] = new C8251y();
        extractors[10] = new C8256b();
        int i2 = this.f17142d;
        if (!this.f17140b) {
            i = 0;
        }
        extractors[11] = new C8157b(i | i2);
        if (f17139a != null) {
            try {
                extractors[12] = (C8260g) f17139a.newInstance(new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return extractors;
    }
}
