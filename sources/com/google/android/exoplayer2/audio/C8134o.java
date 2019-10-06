package com.google.android.exoplayer2.audio;

/* renamed from: com.google.android.exoplayer2.audio.o */
/* compiled from: AuxEffectInfo */
public final class C8134o {

    /* renamed from: a */
    public final int f16717a;

    /* renamed from: b */
    public final float f16718b;

    public C8134o(int effectId, float sendLevel) {
        this.f16717a = effectId;
        this.f16718b = sendLevel;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C8134o auxEffectInfo = (C8134o) o;
        if (!(this.f16717a == auxEffectInfo.f16717a && Float.compare(auxEffectInfo.f16718b, this.f16718b) == 0)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((17 * 31) + this.f16717a) * 31) + Float.floatToIntBits(this.f16718b);
    }
}
