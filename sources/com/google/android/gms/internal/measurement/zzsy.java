package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzsx;
import com.google.android.gms.internal.measurement.zzsy;

public abstract class zzsy<MessageType extends zzsx<MessageType, BuilderType>, BuilderType extends zzsy<MessageType, BuilderType>> implements zzvw {
    /* renamed from: a */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract BuilderType mo32841a(MessageType messagetype);

    /* renamed from: a */
    public final /* synthetic */ zzvw mo32842a(zzvv zzvv) {
        if (mo32895b().getClass().isInstance(zzvv)) {
            return mo32841a((MessageType) (zzsx) zzvv);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
