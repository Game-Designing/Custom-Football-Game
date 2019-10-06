package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.network.Networking;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class NativeImageHelper {

    public interface ImageListener {
        void onImagesCached();

        void onImagesFailedToCache(NativeErrorCode nativeErrorCode);
    }

    public static void preCacheImages(Context context, List<String> imageUrls, ImageListener imageListener) {
        ImageLoader imageLoader = Networking.getImageLoader(context);
        AtomicInteger imageCounter = new AtomicInteger(imageUrls.size());
        AtomicBoolean anyFailures = new AtomicBoolean(false);
        com.mopub.volley.toolbox.ImageLoader.ImageListener volleyImageListener = new C11638ra(imageCounter, anyFailures, imageListener);
        for (String url : imageUrls) {
            if (TextUtils.isEmpty(url)) {
                anyFailures.set(true);
                imageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
                return;
            }
            imageLoader.get(url, volleyImageListener);
        }
    }

    public static void loadImageView(String url, ImageView imageView) {
        if (NoThrow.checkNotNull(imageView, "Cannot load image into null ImageView")) {
            if (!NoThrow.checkNotNull(url, "Cannot load image with null url")) {
                imageView.setImageDrawable(null);
            } else {
                Networking.getImageLoader(imageView.getContext()).get(url, new C11641sa(imageView));
            }
        }
    }
}
