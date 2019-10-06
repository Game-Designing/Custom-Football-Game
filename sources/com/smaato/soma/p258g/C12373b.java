package com.smaato.soma.p258g;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.g.b */
/* compiled from: DownloadImageTask */
class C12373b extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a */
    private final WeakReference<C12389r> f38651a;

    /* renamed from: b */
    private final WeakReference<ImageView> f38652b;

    C12373b(C12389r nativeAd, ImageView imageView) {
        this.f38651a = new WeakReference<>(nativeAd);
        this.f38652b = new WeakReference<>(imageView);
        nativeAd.mo39875e().incrementAndGet();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r2 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
        if (r2 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap doInBackground(java.lang.String... r7) {
        /*
            r6 = this;
            r0 = 0
            r0 = r7[r0]
            r1 = 0
            if (r0 != 0) goto L_0x0008
            r2 = 0
            return r2
        L_0x0008:
            r2 = 0
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            r4.<init>(r0)     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            java.net.URLConnection r5 = r4.openConnection()     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            r2 = r5
            r5 = 50000(0xc350, float:7.0065E-41)
            r2.setConnectTimeout(r5)     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            r2.setReadTimeout(r5)     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            r5 = 1
            r2.setDoInput(r5)     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            r2.connect()     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            r3 = r5
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ Exception -> 0x004f, all -> 0x003f }
            r1 = r5
            if (r3 == 0) goto L_0x0038
            r3.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x0038
        L_0x0036:
            r4 = move-exception
            goto L_0x0039
        L_0x0038:
        L_0x0039:
            if (r2 == 0) goto L_0x005c
        L_0x003b:
            r2.disconnect()
            goto L_0x005c
        L_0x003f:
            r4 = move-exception
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0048
        L_0x0046:
            r5 = move-exception
            goto L_0x0049
        L_0x0048:
        L_0x0049:
            if (r2 == 0) goto L_0x004e
            r2.disconnect()
        L_0x004e:
            throw r4
        L_0x004f:
            r4 = move-exception
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0058
        L_0x0056:
            r4 = move-exception
            goto L_0x0059
        L_0x0058:
        L_0x0059:
            if (r2 == 0) goto L_0x005c
            goto L_0x003b
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p258g.C12373b.doInBackground(java.lang.String[]):android.graphics.Bitmap");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Bitmap result) {
        try {
            ImageView imageView = (ImageView) this.f38652b.get();
            if (imageView != null) {
                imageView.setImageResource(0);
                imageView.setImageBitmap(result);
            }
            C12389r ad = (C12389r) this.f38651a.get();
            if (ad != null) {
                ad.mo39875e().decrementAndGet();
                ad.mo39876f();
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            Runtime.getRuntime().gc();
            throw th;
        }
        Runtime.getRuntime().gc();
    }
}
