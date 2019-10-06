package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;

class ImageViewAction extends Action<ImageView> {
    Callback callback;

    ImageViewAction(Picasso picasso, ImageView imageView, Request data, int memoryPolicy, int networkPolicy, int errorResId, Drawable errorDrawable, String key, Object tag, Callback callback2, boolean noFade) {
        super(picasso, imageView, data, memoryPolicy, networkPolicy, errorResId, errorDrawable, key, tag, noFade);
        this.callback = callback2;
    }

    public void complete(Bitmap result, LoadedFrom from) {
        if (result != null) {
            ImageView target = (ImageView) this.target.get();
            if (target != null) {
                Picasso picasso = this.picasso;
                Context context = picasso.context;
                boolean indicatorsEnabled = picasso.indicatorsEnabled;
                PicassoDrawable.setBitmap(target, context, result, from, this.noFade, indicatorsEnabled);
                Callback callback2 = this.callback;
                if (callback2 != null) {
                    callback2.onSuccess();
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void error() {
        ImageView target = (ImageView) this.target.get();
        if (target != null) {
            int i = this.errorResId;
            if (i != 0) {
                target.setImageResource(i);
            } else {
                Drawable drawable = this.errorDrawable;
                if (drawable != null) {
                    target.setImageDrawable(drawable);
                }
            }
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onError();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void cancel() {
        super.cancel();
        if (this.callback != null) {
            this.callback = null;
        }
    }
}
