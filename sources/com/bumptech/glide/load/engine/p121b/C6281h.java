package com.bumptech.glide.load.engine.p121b;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p121b.C6282i.C6283a;
import com.bumptech.glide.p107h.C6021f;

/* renamed from: com.bumptech.glide.load.engine.b.h */
/* compiled from: LruResourceCache */
public class C6281h extends C6021f<C6344g, C6236E<?>> implements C6282i {

    /* renamed from: e */
    private C6283a f11110e;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C6236E mo19186a(C6344g gVar) {
        return (C6236E) super.mo18819c(gVar);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C6236E mo19187a(C6344g gVar, C6236E e) {
        return (C6236E) super.mo18818b(gVar, e);
    }

    public C6281h(long size) {
        super(size);
    }

    /* renamed from: a */
    public void mo19189a(C6283a listener) {
        this.f11110e = listener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo18815a(C6344g key, C6236E<?> item) {
        C6283a aVar = this.f11110e;
        if (aVar != null && item != null) {
            aVar.mo19192a(item);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo18816b(C6236E<?> item) {
        if (item == null) {
            return super.mo18816b(null);
        }
        return item.mo18968a();
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo19188a(int level) {
        if (level >= 40) {
            mo18813a();
        } else if (level >= 20 || level == 15) {
            mo18814a(mo18817b() / 2);
        }
    }
}
