package com.bumptech.glide.load.p111b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p109a.p110a.C6034b;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: com.bumptech.glide.load.b.q */
/* compiled from: MediaStoreFileLoader */
public final class C6121q implements C6128u<Uri, File> {

    /* renamed from: a */
    private final Context f10803a;

    /* renamed from: com.bumptech.glide.load.b.q$a */
    /* compiled from: MediaStoreFileLoader */
    public static final class C6122a implements C6130v<Uri, File> {

        /* renamed from: a */
        private final Context f10804a;

        public C6122a(Context context) {
            this.f10804a = context;
        }

        /* renamed from: a */
        public C6128u<Uri, File> mo18893a(C6136y multiFactory) {
            return new C6121q(this.f10804a);
        }
    }

    /* renamed from: com.bumptech.glide.load.b.q$b */
    /* compiled from: MediaStoreFileLoader */
    private static class C6123b implements C6042d<File> {

        /* renamed from: a */
        private static final String[] f10805a = {"_data"};

        /* renamed from: b */
        private final Context f10806b;

        /* renamed from: c */
        private final Uri f10807c;

        C6123b(Context context, Uri uri) {
            this.f10806b = context;
            this.f10807c = uri;
        }

        /* renamed from: a */
        public void mo18853a(C6001h priority, C6043a<? super File> callback) {
            Cursor cursor = this.f10806b.getContentResolver().query(this.f10807c, f10805a, null, null, null);
            String filePath = null;
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        filePath = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    cursor.close();
                }
            }
            if (TextUtils.isEmpty(filePath)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find file path for: ");
                sb.append(this.f10807c);
                callback.mo18867a((Exception) new FileNotFoundException(sb.toString()));
                return;
            }
            callback.mo18868a(new File(filePath));
        }

        /* renamed from: b */
        public void mo18854b() {
        }

        public void cancel() {
        }

        /* renamed from: a */
        public Class<File> mo18847a() {
            return File.class;
        }

        /* renamed from: c */
        public C6031a mo18855c() {
            return C6031a.LOCAL;
        }
    }

    public C6121q(Context context) {
        this.f10803a = context;
    }

    /* renamed from: a */
    public C6129a<File> mo18889a(Uri uri, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(uri), new C6123b(this.f10803a, uri));
    }

    /* renamed from: a */
    public boolean mo18891a(Uri uri) {
        return C6034b.m11319b(uri);
    }
}
