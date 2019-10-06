package com.bumptech.glide.load.p111b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6050i;
import com.bumptech.glide.load.p109a.C6058n;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a */
/* compiled from: AssetUriLoader */
public class C6076a<Data> implements C6128u<Uri, Data> {

    /* renamed from: a */
    private static final int f10754a = "file:///android_asset/".length();

    /* renamed from: b */
    private final AssetManager f10755b;

    /* renamed from: c */
    private final C6077a<Data> f10756c;

    /* renamed from: com.bumptech.glide.load.b.a$a */
    /* compiled from: AssetUriLoader */
    public interface C6077a<Data> {
        /* renamed from: a */
        C6042d<Data> mo18901a(AssetManager assetManager, String str);
    }

    /* renamed from: com.bumptech.glide.load.b.a$b */
    /* compiled from: AssetUriLoader */
    public static class C6078b implements C6130v<Uri, ParcelFileDescriptor>, C6077a<ParcelFileDescriptor> {

        /* renamed from: a */
        private final AssetManager f10757a;

        public C6078b(AssetManager assetManager) {
            this.f10757a = assetManager;
        }

        /* renamed from: a */
        public C6128u<Uri, ParcelFileDescriptor> mo18893a(C6136y multiFactory) {
            return new C6076a(this.f10757a, this);
        }

        /* renamed from: a */
        public C6042d<ParcelFileDescriptor> mo18901a(AssetManager assetManager, String assetPath) {
            return new C6050i(assetManager, assetPath);
        }
    }

    /* renamed from: com.bumptech.glide.load.b.a$c */
    /* compiled from: AssetUriLoader */
    public static class C6079c implements C6130v<Uri, InputStream>, C6077a<InputStream> {

        /* renamed from: a */
        private final AssetManager f10758a;

        public C6079c(AssetManager assetManager) {
            this.f10758a = assetManager;
        }

        /* renamed from: a */
        public C6128u<Uri, InputStream> mo18893a(C6136y multiFactory) {
            return new C6076a(this.f10758a, this);
        }

        /* renamed from: a */
        public C6042d<InputStream> mo18901a(AssetManager assetManager, String assetPath) {
            return new C6058n(assetManager, assetPath);
        }
    }

    public C6076a(AssetManager assetManager, C6077a<Data> factory) {
        this.f10755b = assetManager;
        this.f10756c = factory;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(Uri model, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(model), this.f10756c.mo18901a(this.f10755b, model.toString().substring(f10754a)));
    }

    /* renamed from: a */
    public boolean mo18891a(Uri model) {
        if (!"file".equals(model.getScheme()) || model.getPathSegments().isEmpty()) {
            return false;
        }
        if ("android_asset".equals(model.getPathSegments().get(0))) {
            return true;
        }
        return false;
    }
}
