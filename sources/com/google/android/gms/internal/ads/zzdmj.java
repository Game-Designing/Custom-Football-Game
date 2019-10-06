package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmi;
import com.google.android.gms.internal.ads.zzdmj;

public abstract class zzdmj<MessageType extends zzdmi<MessageType, BuilderType>, BuilderType extends zzdmj<MessageType, BuilderType>> implements zzdpl {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract BuilderType mo31534a(MessageType messagetype);

    /* renamed from: h */
    public abstract BuilderType clone();

    /* renamed from: a */
    public final /* synthetic */ zzdpl mo31535a(zzdpk zzdpk) {
        if (mo31601a().getClass().isInstance(zzdpk)) {
            return mo31534a((MessageType) (zzdmi) zzdpk);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
