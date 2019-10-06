package com.google.android.gms.common.images;

import android.widget.ImageView;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zac extends zaa {

    /* renamed from: b */
    private WeakReference<ImageView> f19997b;

    public final int hashCode() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zac)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ImageView imageView = (ImageView) this.f19997b.get();
        ImageView imageView2 = (ImageView) ((zac) obj).f19997b.get();
        if (imageView2 == null || imageView == null || !Objects.m21851a(imageView2, imageView)) {
            return false;
        }
        return true;
    }
}
