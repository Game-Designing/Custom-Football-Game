package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageLoader {

    /* renamed from: a */
    private final RequestQueue f36508a;

    /* renamed from: b */
    private int f36509b = 100;

    /* renamed from: c */
    private final ImageCache f36510c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final HashMap<String, C11693a> f36511d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final HashMap<String, C11693a> f36512e = new HashMap<>();

    /* renamed from: f */
    private final Handler f36513f = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f36514g;

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public class ImageContainer {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Bitmap f36515a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final ImageListener f36516b;

        /* renamed from: c */
        private final String f36517c;

        /* renamed from: d */
        private final String f36518d;

        public ImageContainer(Bitmap bitmap, String requestUrl, String cacheKey, ImageListener listener) {
            this.f36515a = bitmap;
            this.f36518d = requestUrl;
            this.f36517c = cacheKey;
            this.f36516b = listener;
        }

        public void cancelRequest() {
            C11701h.m38679a();
            if (this.f36516b != null) {
                C11693a request = (C11693a) ImageLoader.this.f36511d.get(this.f36517c);
                if (request == null) {
                    C11693a request2 = (C11693a) ImageLoader.this.f36512e.get(this.f36517c);
                    if (request2 != null) {
                        request2.removeContainerAndCancelIfNecessary(this);
                        if (request2.f36523d.size() == 0) {
                            ImageLoader.this.f36512e.remove(this.f36517c);
                        }
                    }
                } else if (request.removeContainerAndCancelIfNecessary(this)) {
                    ImageLoader.this.f36511d.remove(this.f36517c);
                }
            }
        }

        public Bitmap getBitmap() {
            return this.f36515a;
        }

        public String getRequestUrl() {
            return this.f36518d;
        }
    }

    public interface ImageListener extends ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    /* renamed from: com.mopub.volley.toolbox.ImageLoader$a */
    private static class C11693a {

        /* renamed from: a */
        private final Request<?> f36520a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Bitmap f36521b;

        /* renamed from: c */
        private VolleyError f36522c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final List<ImageContainer> f36523d = new ArrayList();

        public C11693a(Request<?> request, ImageContainer container) {
            this.f36520a = request;
            this.f36523d.add(container);
        }

        public void setError(VolleyError error) {
            this.f36522c = error;
        }

        public VolleyError getError() {
            return this.f36522c;
        }

        public void addContainer(ImageContainer container) {
            this.f36523d.add(container);
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer container) {
            this.f36523d.remove(container);
            if (this.f36523d.size() != 0) {
                return false;
            }
            this.f36520a.cancel();
            return true;
        }
    }

    public ImageLoader(RequestQueue queue, ImageCache imageCache) {
        this.f36508a = queue;
        this.f36510c = imageCache;
    }

    public static ImageListener getImageListener(ImageView view, int defaultImageResId, int errorImageResId) {
        return new C11695b(errorImageResId, view, defaultImageResId);
    }

    public boolean isCached(String requestUrl, int maxWidth, int maxHeight) {
        return isCached(requestUrl, maxWidth, maxHeight, ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String requestUrl, int maxWidth, int maxHeight, ScaleType scaleType) {
        C11701h.m38679a();
        return this.f36510c.getBitmap(m38650a(requestUrl, maxWidth, maxHeight, scaleType)) != null;
    }

    public ImageContainer get(String requestUrl, ImageListener listener) {
        return get(requestUrl, listener, 0, 0);
    }

    public ImageContainer get(String requestUrl, ImageListener imageListener, int maxWidth, int maxHeight) {
        return get(requestUrl, imageListener, maxWidth, maxHeight, ScaleType.CENTER_INSIDE);
    }

    public ImageContainer get(String requestUrl, ImageListener imageListener, int maxWidth, int maxHeight, ScaleType scaleType) {
        C11693a request;
        ImageListener imageListener2 = imageListener;
        C11701h.m38679a();
        String cacheKey = m38650a(requestUrl, maxWidth, maxHeight, scaleType);
        Bitmap cachedBitmap = this.f36510c.getBitmap(cacheKey);
        if (cachedBitmap != null) {
            ImageContainer container = new ImageContainer(cachedBitmap, requestUrl, null, null);
            imageListener2.onResponse(container, true);
            return container;
        }
        ImageContainer imageContainer = new ImageContainer(null, requestUrl, cacheKey, imageListener);
        imageListener2.onResponse(imageContainer, true);
        C11693a request2 = (C11693a) this.f36511d.get(cacheKey);
        if (request2 == null) {
            request = (C11693a) this.f36512e.get(cacheKey);
        } else {
            request = request2;
        }
        if (request != null) {
            request.addContainer(imageContainer);
            return imageContainer;
        }
        Request<Bitmap> newRequest = mo38456a(requestUrl, maxWidth, maxHeight, scaleType, cacheKey);
        this.f36508a.add(newRequest);
        this.f36511d.put(cacheKey, new C11693a(newRequest, imageContainer));
        return imageContainer;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Request<Bitmap> mo38456a(String requestUrl, int maxWidth, int maxHeight, ScaleType scaleType, String cacheKey) {
        ImageRequest imageRequest = new ImageRequest(requestUrl, new C11696c(this, cacheKey), maxWidth, maxHeight, scaleType, Config.RGB_565, new C11697d(this, cacheKey));
        return imageRequest;
    }

    public void setBatchedResponseDelay(int newBatchedResponseDelayMs) {
        this.f36509b = newBatchedResponseDelayMs;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo38457a(String cacheKey, Bitmap response) {
        this.f36510c.putBitmap(cacheKey, response);
        C11693a request = (C11693a) this.f36511d.remove(cacheKey);
        if (request != null) {
            request.f36521b = response;
            m38652a(cacheKey, request);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo38458a(String cacheKey, VolleyError error) {
        C11693a request = (C11693a) this.f36511d.remove(cacheKey);
        if (request != null) {
            request.setError(error);
            m38652a(cacheKey, request);
        }
    }

    /* renamed from: a */
    private void m38652a(String cacheKey, C11693a request) {
        this.f36512e.put(cacheKey, request);
        if (this.f36514g == null) {
            this.f36514g = new C11698e(this);
            this.f36513f.postDelayed(this.f36514g, (long) this.f36509b);
        }
    }

    /* renamed from: a */
    private static String m38650a(String url, int maxWidth, int maxHeight, ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(url.length() + 12);
        sb.append("#W");
        sb.append(maxWidth);
        sb.append("#H");
        sb.append(maxHeight);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(url);
        return sb.toString();
    }
}
