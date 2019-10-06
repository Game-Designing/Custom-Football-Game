package com.bumptech.glide.p103f.p104a;

import android.support.p001v7.widget.LinearLayoutManager;
import com.bumptech.glide.p107h.C6026k;

/* renamed from: com.bumptech.glide.f.a.g */
/* compiled from: SimpleTarget */
public abstract class C5974g<Z> extends C5968a<Z> {
    private final int height;
    private final int width;

    public C5974g() {
        this(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);
    }

    public C5974g(int width2, int height2) {
        this.width = width2;
        this.height = height2;
    }

    public final void getSize(C5975h cb) {
        if (C6026k.m11285b(this.width, this.height)) {
            cb.mo18703a(this.width, this.height);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(this.width);
        sb.append(" and height: ");
        sb.append(this.height);
        sb.append(", either provide dimensions in the constructor or call override()");
        throw new IllegalArgumentException(sb.toString());
    }

    public void removeCallback(C5975h cb) {
    }
}
