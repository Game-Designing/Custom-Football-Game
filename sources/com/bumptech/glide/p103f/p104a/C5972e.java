package com.bumptech.glide.p103f.p104a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: com.bumptech.glide.f.a.e */
/* compiled from: ImageViewTargetFactory */
public class C5972e {
    /* renamed from: a */
    public <Z> C5977j<ImageView, Z> mo18699a(ImageView view, Class<Z> clazz) {
        if (Bitmap.class.equals(clazz)) {
            return new C5969b(view);
        }
        if (Drawable.class.isAssignableFrom(clazz)) {
            return new C5970c(view);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unhandled class: ");
        sb.append(clazz);
        sb.append(", try .as*(Class).transcode(ResourceTranscoder)");
        throw new IllegalArgumentException(sb.toString());
    }
}
