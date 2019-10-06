package com.bumptech.glide.load.p109a.p110a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p109a.C6049h;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.a.c */
/* compiled from: ThumbFetcher */
public class C6035c implements C6042d<InputStream> {

    /* renamed from: a */
    private final Uri f10696a;

    /* renamed from: b */
    private final C6039e f10697b;

    /* renamed from: c */
    private InputStream f10698c;

    /* renamed from: com.bumptech.glide.load.a.a.c$a */
    /* compiled from: ThumbFetcher */
    static class C6036a implements C6038d {

        /* renamed from: a */
        private static final String[] f10699a = {"_data"};

        /* renamed from: b */
        private final ContentResolver f10700b;

        C6036a(ContentResolver contentResolver) {
            this.f10700b = contentResolver;
        }

        /* renamed from: a */
        public Cursor mo18857a(Uri uri) {
            String imageId = uri.getLastPathSegment();
            return this.f10700b.query(Thumbnails.EXTERNAL_CONTENT_URI, f10699a, "kind = 1 AND image_id = ?", new String[]{imageId}, null);
        }
    }

    /* renamed from: com.bumptech.glide.load.a.a.c$b */
    /* compiled from: ThumbFetcher */
    static class C6037b implements C6038d {

        /* renamed from: a */
        private static final String[] f10701a = {"_data"};

        /* renamed from: b */
        private final ContentResolver f10702b;

        C6037b(ContentResolver contentResolver) {
            this.f10702b = contentResolver;
        }

        /* renamed from: a */
        public Cursor mo18857a(Uri uri) {
            String videoId = uri.getLastPathSegment();
            return this.f10702b.query(Video.Thumbnails.EXTERNAL_CONTENT_URI, f10701a, "kind = 1 AND video_id = ?", new String[]{videoId}, null);
        }
    }

    /* renamed from: a */
    public static C6035c m11322a(Context context, Uri uri) {
        return m11323a(context, uri, new C6036a(context.getContentResolver()));
    }

    /* renamed from: b */
    public static C6035c m11324b(Context context, Uri uri) {
        return m11323a(context, uri, new C6037b(context.getContentResolver()));
    }

    /* renamed from: a */
    private static C6035c m11323a(Context context, Uri uri, C6038d query) {
        return new C6035c(uri, new C6039e(C5926c.m10916a(context).mo18585g().mo18523a(), query, C5926c.m10916a(context).mo18579b(), context.getContentResolver()));
    }

    C6035c(Uri mediaStoreImageUri, C6039e opener) {
        this.f10696a = mediaStoreImageUri;
        this.f10697b = opener;
    }

    /* renamed from: a */
    public void mo18853a(C6001h priority, C6043a<? super InputStream> callback) {
        try {
            this.f10698c = m11325d();
            callback.mo18868a(this.f10698c);
        } catch (FileNotFoundException e) {
            String str = "MediaStoreThumbFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to find thumbnail file", e);
            }
            callback.mo18867a((Exception) e);
        }
    }

    /* renamed from: d */
    private InputStream m11325d() throws FileNotFoundException {
        InputStream result = this.f10697b.mo18859b(this.f10696a);
        int orientation = -1;
        if (result != null) {
            orientation = this.f10697b.mo18858a(this.f10696a);
        }
        if (orientation != -1) {
            return new C6049h(result, orientation);
        }
        return result;
    }

    /* renamed from: b */
    public void mo18854b() {
        InputStream inputStream = this.f10698c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public void cancel() {
    }

    /* renamed from: a */
    public Class<InputStream> mo18847a() {
        return InputStream.class;
    }

    /* renamed from: c */
    public C6031a mo18855c() {
        return C6031a.LOCAL;
    }
}
