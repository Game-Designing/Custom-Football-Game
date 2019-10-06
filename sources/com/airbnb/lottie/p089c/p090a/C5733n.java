package com.airbnb.lottie.p089c.p090a;

import com.airbnb.lottie.p096g.C5831a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.a.n */
/* compiled from: BaseAnimatableValue */
abstract class C5733n<V, O> implements C5732m<V, O> {

    /* renamed from: a */
    final List<C5831a<V>> f9843a;

    C5733n(V value) {
        this(Collections.singletonList(new C5831a(value)));
    }

    C5733n(List<C5831a<V>> keyframes) {
        this.f9843a = keyframes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f9843a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f9843a.toArray()));
        }
        return sb.toString();
    }
}
