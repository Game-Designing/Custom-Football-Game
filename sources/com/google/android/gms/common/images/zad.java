package com.google.android.gms.common.images;

import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zad extends zaa {

    /* renamed from: b */
    private WeakReference<OnImageLoadedListener> f19998b;

    public final int hashCode() {
        return Objects.m21849a(this.f19996a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zad)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zad zad = (zad) obj;
        OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.f19998b.get();
        OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) zad.f19998b.get();
        if (onImageLoadedListener2 == null || onImageLoadedListener == null || !Objects.m21851a(onImageLoadedListener2, onImageLoadedListener) || !Objects.m21851a(zad.f19996a, this.f19996a)) {
            return false;
        }
        return true;
    }
}
