package com.bumptech.glide;

import com.bumptech.glide.C6357o;
import com.bumptech.glide.p103f.p105b.C5981a;
import com.bumptech.glide.p103f.p105b.C5985c;

/* renamed from: com.bumptech.glide.o */
/* compiled from: TransitionOptions */
public abstract class C6357o<CHILD extends C6357o<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a */
    private C5985c<? super TranscodeType> f11342a = C5981a.m11078a();

    public final CHILD clone() {
        try {
            return (C6357o) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C5985c<? super TranscodeType> mo19330a() {
        return this.f11342a;
    }
}
