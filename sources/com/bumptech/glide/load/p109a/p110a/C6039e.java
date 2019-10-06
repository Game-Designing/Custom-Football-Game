package com.bumptech.glide.load.p109a.p110a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.C6230e;
import com.bumptech.glide.load.C6343f;
import com.bumptech.glide.load.engine.p120a.C6245b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.bumptech.glide.load.a.a.e */
/* compiled from: ThumbnailStreamOpener */
class C6039e {

    /* renamed from: a */
    private static final C6033a f10703a = new C6033a();

    /* renamed from: b */
    private final C6033a f10704b;

    /* renamed from: c */
    private final C6038d f10705c;

    /* renamed from: d */
    private final C6245b f10706d;

    /* renamed from: e */
    private final ContentResolver f10707e;

    /* renamed from: f */
    private final List<C6230e> f10708f;

    C6039e(List<C6230e> parsers, C6038d query, C6245b byteArrayPool, ContentResolver contentResolver) {
        this(parsers, f10703a, query, byteArrayPool, contentResolver);
    }

    C6039e(List<C6230e> parsers, C6033a service, C6038d query, C6245b byteArrayPool, ContentResolver contentResolver) {
        this.f10704b = service;
        this.f10705c = query;
        this.f10706d = byteArrayPool;
        this.f10707e = contentResolver;
        this.f10708f = parsers;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo18858a(Uri uri) {
        String str = "ThumbStreamOpener";
        InputStream is = null;
        try {
            is = this.f10707e.openInputStream(uri);
            int a = C6343f.m12240a(this.f10708f, is, this.f10706d);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            return a;
        } catch (IOException | NullPointerException e2) {
            is = Log.isLoggable(str, 3);
            if (is) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to open uri: ");
                sb.append(uri);
                Log.d(str, sb.toString(), e2);
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                }
            }
            return -1;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    /* renamed from: b */
    public InputStream mo18859b(Uri uri) throws FileNotFoundException {
        String path = m11334c(uri);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = this.f10704b.mo18850a(path);
        if (!m11333a(file)) {
            return null;
        }
        Uri thumbnailUri = Uri.fromFile(file);
        try {
            return this.f10707e.openInputStream(thumbnailUri);
        } catch (NullPointerException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("NPE opening uri: ");
            sb.append(uri);
            sb.append(" -> ");
            sb.append(thumbnailUri);
            throw ((FileNotFoundException) new FileNotFoundException(sb.toString()).initCause(e));
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    private String m11334c(Uri uri) {
        Cursor cursor = this.f10705c.mo18857a(uri);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* renamed from: a */
    private boolean m11333a(File file) {
        return this.f10704b.mo18851a(file) && 0 < this.f10704b.mo18852b(file);
    }
}
