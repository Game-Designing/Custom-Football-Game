package com.bumptech.glide.load.p109a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.m */
/* compiled from: LocalUriFetcher */
public abstract class C6057m<T> implements C6042d<T> {

    /* renamed from: a */
    private final Uri f10733a;

    /* renamed from: b */
    private final ContentResolver f10734b;

    /* renamed from: c */
    private T f10735c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo18846a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18849a(T t) throws IOException;

    public C6057m(ContentResolver contentResolver, Uri uri) {
        this.f10734b = contentResolver;
        this.f10733a = uri;
    }

    /* renamed from: a */
    public final void mo18853a(C6001h priority, C6043a<? super T> callback) {
        try {
            this.f10735c = mo18846a(this.f10733a, this.f10734b);
            callback.mo18868a(this.f10735c);
        } catch (FileNotFoundException e) {
            String str = "LocalUriFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to open Uri", e);
            }
            callback.mo18867a((Exception) e);
        }
    }

    /* renamed from: b */
    public void mo18854b() {
        T t = this.f10735c;
        if (t != null) {
            try {
                mo18849a(t);
            } catch (IOException e) {
            }
        }
    }

    public void cancel() {
    }

    /* renamed from: c */
    public C6031a mo18855c() {
        return C6031a.LOCAL;
    }
}
