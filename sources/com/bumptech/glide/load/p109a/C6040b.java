package com.bumptech.glide.load.p109a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.b */
/* compiled from: AssetPathFetcher */
public abstract class C6040b<T> implements C6042d<T> {

    /* renamed from: a */
    private final String f10709a;

    /* renamed from: b */
    private final AssetManager f10710b;

    /* renamed from: c */
    private T f10711c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo18860a(AssetManager assetManager, String str) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18861a(T t) throws IOException;

    public C6040b(AssetManager assetManager, String assetPath) {
        this.f10710b = assetManager;
        this.f10709a = assetPath;
    }

    /* renamed from: a */
    public void mo18853a(C6001h priority, C6043a<? super T> callback) {
        try {
            this.f10711c = mo18860a(this.f10710b, this.f10709a);
            callback.mo18868a(this.f10711c);
        } catch (IOException e) {
            String str = "AssetPathFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to load data from asset manager", e);
            }
            callback.mo18867a((Exception) e);
        }
    }

    /* renamed from: b */
    public void mo18854b() {
        T t = this.f10711c;
        if (t != null) {
            try {
                mo18861a(t);
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
