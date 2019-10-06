package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api.SimpleClient;

public class SimpleClientAdapter<T extends IInterface> extends GmsClient<T> {

    /* renamed from: F */
    private final SimpleClient<T> f20136F;

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo27246h() {
        return this.f20136F.mo27345b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public String mo27243g() {
        return this.f20136F.mo27346c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T mo27242a(IBinder iBinder) {
        return this.f20136F.mo27343a(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27705a(int i, T t) {
        this.f20136F.mo27344a(i, t);
    }

    /* renamed from: k */
    public SimpleClient<T> mo27247k() {
        return this.f20136F;
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }
}
