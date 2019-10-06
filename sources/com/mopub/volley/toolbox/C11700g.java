package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

/* renamed from: com.mopub.volley.toolbox.g */
/* compiled from: NetworkImageView */
class C11700g implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ boolean f36559a;

    /* renamed from: b */
    final /* synthetic */ NetworkImageView f36560b;

    C11700g(NetworkImageView this$0, boolean z) {
        this.f36560b = this$0;
        this.f36559a = z;
    }

    public void onErrorResponse(VolleyError error) {
        if (this.f36560b.f36538d != 0) {
            NetworkImageView networkImageView = this.f36560b;
            networkImageView.setImageResource(networkImageView.f36538d);
        } else if (this.f36560b.f36539e != null) {
            NetworkImageView networkImageView2 = this.f36560b;
            networkImageView2.setImageBitmap(networkImageView2.f36539e);
        }
    }

    public void onResponse(ImageContainer response, boolean isImmediate) {
        if (!isImmediate || !this.f36559a) {
            if (response.getBitmap() != null) {
                this.f36560b.setImageBitmap(response.getBitmap());
            } else if (this.f36560b.f36536b != 0) {
                NetworkImageView networkImageView = this.f36560b;
                networkImageView.setImageResource(networkImageView.f36536b);
            } else {
                NetworkImageView networkImageView2 = this.f36560b;
                Bitmap bitmap = networkImageView2.f36537c;
                if (bitmap != null) {
                    networkImageView2.setImageBitmap(bitmap);
                }
            }
            return;
        }
        this.f36560b.post(new C11699f(this, response));
    }
}
