package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Request;
import com.mopub.volley.Request.Priority;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyLog;

public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;

    /* renamed from: q */
    private static final Object f36524q = new Object();

    /* renamed from: r */
    private final Object f36525r;

    /* renamed from: s */
    private Listener<Bitmap> f36526s;

    /* renamed from: t */
    private final Config f36527t;

    /* renamed from: u */
    private final int f36528u;

    /* renamed from: v */
    private final int f36529v;

    /* renamed from: w */
    private final ScaleType f36530w;

    public ImageRequest(String url, Listener<Bitmap> listener, int maxWidth, int maxHeight, ScaleType scaleType, Config decodeConfig, ErrorListener errorListener) {
        super(0, url, errorListener);
        this.f36525r = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f36526s = listener;
        this.f36527t = decodeConfig;
        this.f36528u = maxWidth;
        this.f36529v = maxHeight;
        this.f36530w = scaleType;
    }

    @Deprecated
    public ImageRequest(String url, Listener<Bitmap> listener, int maxWidth, int maxHeight, Config decodeConfig, ErrorListener errorListener) {
        this(url, listener, maxWidth, maxHeight, ScaleType.CENTER_INSIDE, decodeConfig, errorListener);
    }

    public Priority getPriority() {
        return Priority.LOW;
    }

    /* renamed from: a */
    private static int m38663a(int maxPrimary, int maxSecondary, int actualPrimary, int actualSecondary, ScaleType scaleType) {
        if (maxPrimary == 0 && maxSecondary == 0) {
            return actualPrimary;
        }
        if (scaleType == ScaleType.FIT_XY) {
            if (maxPrimary == 0) {
                return actualPrimary;
            }
            return maxPrimary;
        } else if (maxPrimary == 0) {
            double d = (double) maxSecondary;
            double d2 = (double) actualSecondary;
            Double.isNaN(d);
            Double.isNaN(d2);
            double ratio = d / d2;
            double d3 = (double) actualPrimary;
            Double.isNaN(d3);
            return (int) (d3 * ratio);
        } else if (maxSecondary == 0) {
            return maxPrimary;
        } else {
            double d4 = (double) actualSecondary;
            double d5 = (double) actualPrimary;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double ratio2 = d4 / d5;
            int resized = maxPrimary;
            if (scaleType == ScaleType.CENTER_CROP) {
                double d6 = (double) resized;
                Double.isNaN(d6);
                if (d6 * ratio2 < ((double) maxSecondary)) {
                    double d7 = (double) maxSecondary;
                    Double.isNaN(d7);
                    resized = (int) (d7 / ratio2);
                }
                return resized;
            }
            double d8 = (double) resized;
            Double.isNaN(d8);
            if (d8 * ratio2 > ((double) maxSecondary)) {
                double d9 = (double) maxSecondary;
                Double.isNaN(d9);
                resized = (int) (d9 / ratio2);
            }
            return resized;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<Bitmap> mo36680a(NetworkResponse response) {
        Response<Bitmap> b;
        synchronized (f36524q) {
            try {
                b = m38664b(response);
            } catch (OutOfMemoryError e) {
                VolleyLog.m38604e("Caught OOM for %d byte image, url=%s", Integer.valueOf(response.data.length), getUrl());
                return Response.error(new ParseError((Throwable) e));
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    /* renamed from: b */
    private Response<Bitmap> m38664b(NetworkResponse response) {
        Bitmap bitmap;
        byte[] data = response.data;
        Options decodeOptions = new Options();
        if (this.f36528u == 0 && this.f36529v == 0) {
            decodeOptions.inPreferredConfig = this.f36527t;
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, decodeOptions);
        } else {
            decodeOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(data, 0, data.length, decodeOptions);
            int actualWidth = decodeOptions.outWidth;
            int actualHeight = decodeOptions.outHeight;
            int desiredWidth = m38663a(this.f36528u, this.f36529v, actualWidth, actualHeight, this.f36530w);
            int desiredHeight = m38663a(this.f36529v, this.f36528u, actualHeight, actualWidth, this.f36530w);
            decodeOptions.inJustDecodeBounds = false;
            decodeOptions.inSampleSize = m38662a(actualWidth, actualHeight, desiredWidth, desiredHeight);
            Bitmap tempBitmap = BitmapFactory.decodeByteArray(data, 0, data.length, decodeOptions);
            if (tempBitmap == null || (tempBitmap.getWidth() <= desiredWidth && tempBitmap.getHeight() <= desiredHeight)) {
                bitmap = tempBitmap;
            } else {
                bitmap = Bitmap.createScaledBitmap(tempBitmap, desiredWidth, desiredHeight, true);
                tempBitmap.recycle();
            }
        }
        if (bitmap == null) {
            return Response.error(new ParseError(response));
        }
        return Response.success(bitmap, HttpHeaderParser.parseCacheHeaders(response));
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f36525r) {
            this.f36526s = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(Bitmap response) {
        Listener<Bitmap> listener;
        synchronized (this.f36525r) {
            listener = this.f36526s;
        }
        if (listener != null) {
            listener.onResponse(response);
        }
    }

    /* renamed from: a */
    static int m38662a(int actualWidth, int actualHeight, int desiredWidth, int desiredHeight) {
        double d = (double) actualWidth;
        double d2 = (double) desiredWidth;
        Double.isNaN(d);
        Double.isNaN(d2);
        double wr = d / d2;
        double d3 = (double) actualHeight;
        double d4 = (double) desiredHeight;
        Double.isNaN(d3);
        Double.isNaN(d4);
        float n = 1.0f;
        while (((double) (n * 2.0f)) <= Math.min(wr, d3 / d4)) {
            n *= 2.0f;
        }
        return (int) n;
    }
}
