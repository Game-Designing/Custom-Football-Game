package com.bumptech.glide.load.p111b.p112a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.p110a.C6034b;
import com.bumptech.glide.load.p109a.p110a.C6035c;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.load.p111b.C6130v;
import com.bumptech.glide.load.p111b.C6136y;
import com.bumptech.glide.load.p113c.p114a.C6188z;
import com.bumptech.glide.p106g.C6000c;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a.d */
/* compiled from: MediaStoreVideoThumbLoader */
public class C6086d implements C6128u<Uri, InputStream> {

    /* renamed from: a */
    private final Context f10766a;

    /* renamed from: com.bumptech.glide.load.b.a.d$a */
    /* compiled from: MediaStoreVideoThumbLoader */
    public static class C6087a implements C6130v<Uri, InputStream> {

        /* renamed from: a */
        private final Context f10767a;

        public C6087a(Context context) {
            this.f10767a = context;
        }

        /* renamed from: a */
        public C6128u<Uri, InputStream> mo18893a(C6136y multiFactory) {
            return new C6086d(this.f10767a);
        }
    }

    public C6086d(Context context) {
        this.f10766a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C6129a<InputStream> mo18889a(Uri model, int width, int height, C6349k options) {
        if (!C6034b.m11317a(width, height) || !m11464a(options)) {
            return null;
        }
        return new C6129a<>(new C6000c(model), C6035c.m11324b(this.f10766a, model));
    }

    /* renamed from: a */
    private boolean m11464a(C6349k options) {
        Long specifiedFrame = (Long) options.mo19310a(C6188z.f10920a);
        return specifiedFrame != null && specifiedFrame.longValue() == -1;
    }

    /* renamed from: a */
    public boolean mo18891a(Uri model) {
        return C6034b.m11320c(model);
    }
}
