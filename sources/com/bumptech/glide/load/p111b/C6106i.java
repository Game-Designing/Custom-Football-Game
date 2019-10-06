package com.bumptech.glide.load.p111b;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.i */
/* compiled from: FileLoader */
public class C6106i<Data> implements C6128u<File, Data> {

    /* renamed from: a */
    private final C6110d<Data> f10781a;

    /* renamed from: com.bumptech.glide.load.b.i$a */
    /* compiled from: FileLoader */
    public static class C6107a<Data> implements C6130v<File, Data> {

        /* renamed from: a */
        private final C6110d<Data> f10782a;

        public C6107a(C6110d<Data> opener) {
            this.f10782a = opener;
        }

        /* renamed from: a */
        public final C6128u<File, Data> mo18893a(C6136y multiFactory) {
            return new C6106i(this.f10782a);
        }
    }

    /* renamed from: com.bumptech.glide.load.b.i$b */
    /* compiled from: FileLoader */
    public static class C6108b extends C6107a<ParcelFileDescriptor> {
        public C6108b() {
            super(new C6112j());
        }
    }

    /* renamed from: com.bumptech.glide.load.b.i$c */
    /* compiled from: FileLoader */
    private static final class C6109c<Data> implements C6042d<Data> {

        /* renamed from: a */
        private final File f10783a;

        /* renamed from: b */
        private final C6110d<Data> f10784b;

        /* renamed from: c */
        private Data f10785c;

        C6109c(File file, C6110d<Data> opener) {
            this.f10783a = file;
            this.f10784b = opener;
        }

        /* renamed from: a */
        public void mo18853a(C6001h priority, C6043a<? super Data> callback) {
            try {
                this.f10785c = this.f10784b.mo18926a(this.f10783a);
                callback.mo18868a(this.f10785c);
            } catch (FileNotFoundException e) {
                String str = "FileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to open file", e);
                }
                callback.mo18867a((Exception) e);
            }
        }

        /* renamed from: b */
        public void mo18854b() {
            Data data = this.f10785c;
            if (data != null) {
                try {
                    this.f10784b.mo18927a(data);
                } catch (IOException e) {
                }
            }
        }

        public void cancel() {
        }

        /* renamed from: a */
        public Class<Data> mo18847a() {
            return this.f10784b.mo18925a();
        }

        /* renamed from: c */
        public C6031a mo18855c() {
            return C6031a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.load.b.i$d */
    /* compiled from: FileLoader */
    public interface C6110d<Data> {
        /* renamed from: a */
        Class<Data> mo18925a();

        /* renamed from: a */
        Data mo18926a(File file) throws FileNotFoundException;

        /* renamed from: a */
        void mo18927a(Data data) throws IOException;
    }

    /* renamed from: com.bumptech.glide.load.b.i$e */
    /* compiled from: FileLoader */
    public static class C6111e extends C6107a<InputStream> {
        public C6111e() {
            super(new C6113k());
        }
    }

    public C6106i(C6110d<Data> fileOpener) {
        this.f10781a = fileOpener;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(File model, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(model), new C6109c(model, this.f10781a));
    }

    /* renamed from: a */
    public boolean mo18891a(File model) {
        return true;
    }
}
