package com.bumptech.glide.load.p111b;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.z */
/* compiled from: ResourceLoader */
public class C6140z<Data> implements C6128u<Integer, Data> {

    /* renamed from: a */
    private final C6128u<Uri, Data> f10838a;

    /* renamed from: b */
    private final Resources f10839b;

    /* renamed from: com.bumptech.glide.load.b.z$a */
    /* compiled from: ResourceLoader */
    public static final class C6141a implements C6130v<Integer, AssetFileDescriptor> {

        /* renamed from: a */
        private final Resources f10840a;

        public C6141a(Resources resources) {
            this.f10840a = resources;
        }

        /* renamed from: a */
        public C6128u<Integer, AssetFileDescriptor> mo18893a(C6136y multiFactory) {
            return new C6140z(this.f10840a, multiFactory.mo18959a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.b.z$b */
    /* compiled from: ResourceLoader */
    public static class C6142b implements C6130v<Integer, ParcelFileDescriptor> {

        /* renamed from: a */
        private final Resources f10841a;

        public C6142b(Resources resources) {
            this.f10841a = resources;
        }

        /* renamed from: a */
        public C6128u<Integer, ParcelFileDescriptor> mo18893a(C6136y multiFactory) {
            return new C6140z(this.f10841a, multiFactory.mo18959a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.b.z$c */
    /* compiled from: ResourceLoader */
    public static class C6143c implements C6130v<Integer, InputStream> {

        /* renamed from: a */
        private final Resources f10842a;

        public C6143c(Resources resources) {
            this.f10842a = resources;
        }

        /* renamed from: a */
        public C6128u<Integer, InputStream> mo18893a(C6136y multiFactory) {
            return new C6140z(this.f10842a, multiFactory.mo18959a(Uri.class, InputStream.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.b.z$d */
    /* compiled from: ResourceLoader */
    public static class C6144d implements C6130v<Integer, Uri> {

        /* renamed from: a */
        private final Resources f10843a;

        public C6144d(Resources resources) {
            this.f10843a = resources;
        }

        /* renamed from: a */
        public C6128u<Integer, Uri> mo18893a(C6136y multiFactory) {
            return new C6140z(this.f10843a, C6066C.m11415a());
        }
    }

    public C6140z(Resources resources, C6128u<Uri, Data> uriLoader) {
        this.f10839b = resources;
        this.f10838a = uriLoader;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(Integer model, int width, int height, C6349k options) {
        Uri uri = m11602b(model);
        if (uri == null) {
            return null;
        }
        return this.f10838a.mo18889a(uri, width, height, options);
    }

    /* renamed from: b */
    private Uri m11602b(Integer model) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.f10839b.getResourcePackageName(model.intValue()));
            sb.append('/');
            sb.append(this.f10839b.getResourceTypeName(model.intValue()));
            sb.append('/');
            sb.append(this.f10839b.getResourceEntryName(model.intValue()));
            return Uri.parse(sb.toString());
        } catch (NotFoundException e) {
            String str = "ResourceLoader";
            if (Log.isLoggable(str, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received invalid resource id: ");
                sb2.append(model);
                Log.w(str, sb2.toString(), e);
            }
            return null;
        }
    }

    /* renamed from: a */
    public boolean mo18891a(Integer model) {
        return true;
    }
}
