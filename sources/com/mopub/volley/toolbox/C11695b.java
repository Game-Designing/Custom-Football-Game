package com.mopub.volley.toolbox;

import android.widget.ImageView;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

/* renamed from: com.mopub.volley.toolbox.b */
/* compiled from: ImageLoader */
class C11695b implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ int f36549a;

    /* renamed from: b */
    final /* synthetic */ ImageView f36550b;

    /* renamed from: c */
    final /* synthetic */ int f36551c;

    C11695b(int i, ImageView imageView, int i2) {
        this.f36549a = i;
        this.f36550b = imageView;
        this.f36551c = i2;
    }

    public void onErrorResponse(VolleyError error) {
        int i = this.f36549a;
        if (i != 0) {
            this.f36550b.setImageResource(i);
        }
    }

    public void onResponse(ImageContainer response, boolean isImmediate) {
        if (response.getBitmap() != null) {
            this.f36550b.setImageBitmap(response.getBitmap());
            return;
        }
        int i = this.f36551c;
        if (i != 0) {
            this.f36550b.setImageResource(i);
        }
    }
}
