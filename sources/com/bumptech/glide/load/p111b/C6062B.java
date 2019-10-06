package com.bumptech.glide.load.p111b;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.B */
/* compiled from: StringLoader */
public class C6062B<Data> implements C6128u<String, Data> {

    /* renamed from: a */
    private final C6128u<Uri, Data> f10743a;

    /* renamed from: com.bumptech.glide.load.b.B$a */
    /* compiled from: StringLoader */
    public static final class C6063a implements C6130v<String, AssetFileDescriptor> {
        /* renamed from: a */
        public C6128u<String, AssetFileDescriptor> mo18893a(C6136y multiFactory) {
            return new C6062B(multiFactory.mo18959a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.b.B$b */
    /* compiled from: StringLoader */
    public static class C6064b implements C6130v<String, ParcelFileDescriptor> {
        /* renamed from: a */
        public C6128u<String, ParcelFileDescriptor> mo18893a(C6136y multiFactory) {
            return new C6062B(multiFactory.mo18959a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.b.B$c */
    /* compiled from: StringLoader */
    public static class C6065c implements C6130v<String, InputStream> {
        /* renamed from: a */
        public C6128u<String, InputStream> mo18893a(C6136y multiFactory) {
            return new C6062B(multiFactory.mo18959a(Uri.class, InputStream.class));
        }
    }

    public C6062B(C6128u<Uri, Data> uriLoader) {
        this.f10743a = uriLoader;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(String model, int width, int height, C6349k options) {
        Uri uri = m11406b(model);
        if (uri == null) {
            return null;
        }
        return this.f10743a.mo18889a(uri, width, height, options);
    }

    /* renamed from: a */
    public boolean mo18891a(String model) {
        return true;
    }

    /* renamed from: b */
    private static Uri m11406b(String model) {
        Uri uri;
        if (TextUtils.isEmpty(model)) {
            return null;
        }
        if (model.charAt(0) == '/') {
            uri = m11407c(model);
        } else {
            uri = Uri.parse(model);
            if (uri.getScheme() == null) {
                uri = m11407c(model);
            }
        }
        return uri;
    }

    /* renamed from: c */
    private static Uri m11407c(String path) {
        return Uri.fromFile(new File(path));
    }
}
