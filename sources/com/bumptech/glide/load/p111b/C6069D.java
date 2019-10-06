package com.bumptech.glide.load.p111b;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6032a;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6051j;
import com.bumptech.glide.load.p109a.C6059o;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.b.D */
/* compiled from: UriLoader */
public class C6069D<Data> implements C6128u<Uri, Data> {

    /* renamed from: a */
    private static final Set<String> f10747a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));

    /* renamed from: b */
    private final C6072c<Data> f10748b;

    /* renamed from: com.bumptech.glide.load.b.D$a */
    /* compiled from: UriLoader */
    public static final class C6070a implements C6130v<Uri, AssetFileDescriptor>, C6072c<AssetFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f10749a;

        public C6070a(ContentResolver contentResolver) {
            this.f10749a = contentResolver;
        }

        /* renamed from: a */
        public C6128u<Uri, AssetFileDescriptor> mo18893a(C6136y multiFactory) {
            return new C6069D(this);
        }

        /* renamed from: a */
        public C6042d<AssetFileDescriptor> mo18896a(Uri uri) {
            return new C6032a(this.f10749a, uri);
        }
    }

    /* renamed from: com.bumptech.glide.load.b.D$b */
    /* compiled from: UriLoader */
    public static class C6071b implements C6130v<Uri, ParcelFileDescriptor>, C6072c<ParcelFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f10750a;

        public C6071b(ContentResolver contentResolver) {
            this.f10750a = contentResolver;
        }

        /* renamed from: a */
        public C6042d<ParcelFileDescriptor> mo18896a(Uri uri) {
            return new C6051j(this.f10750a, uri);
        }

        /* renamed from: a */
        public C6128u<Uri, ParcelFileDescriptor> mo18893a(C6136y multiFactory) {
            return new C6069D(this);
        }
    }

    /* renamed from: com.bumptech.glide.load.b.D$c */
    /* compiled from: UriLoader */
    public interface C6072c<Data> {
        /* renamed from: a */
        C6042d<Data> mo18896a(Uri uri);
    }

    /* renamed from: com.bumptech.glide.load.b.D$d */
    /* compiled from: UriLoader */
    public static class C6073d implements C6130v<Uri, InputStream>, C6072c<InputStream> {

        /* renamed from: a */
        private final ContentResolver f10751a;

        public C6073d(ContentResolver contentResolver) {
            this.f10751a = contentResolver;
        }

        /* renamed from: a */
        public C6042d<InputStream> mo18896a(Uri uri) {
            return new C6059o(this.f10751a, uri);
        }

        /* renamed from: a */
        public C6128u<Uri, InputStream> mo18893a(C6136y multiFactory) {
            return new C6069D(this);
        }
    }

    public C6069D(C6072c<Data> factory) {
        this.f10748b = factory;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(Uri model, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(model), this.f10748b.mo18896a(model));
    }

    /* renamed from: a */
    public boolean mo18891a(Uri model) {
        return f10747a.contains(model.getScheme());
    }
}
