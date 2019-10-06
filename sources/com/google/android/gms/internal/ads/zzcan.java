package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcan {

    /* renamed from: a */
    private final zzayu f26273a;

    /* renamed from: b */
    private final Clock f26274b;

    /* renamed from: c */
    private final Executor f26275c;

    public zzcan(zzayu zzayu, Clock clock, Executor executor) {
        this.f26273a = zzayu;
        this.f26274b = clock;
        this.f26275c = executor;
    }

    /* renamed from: a */
    public final zzbbh<Bitmap> mo31087a(String str, double d, boolean z) {
        return zzbar.m26380a(zzayu.m26254a(str), (zzbam<A, B>) new C8831Eh<A,B>(this, d, z), this.f26275c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Bitmap m28172a(byte[] bArr, double d, boolean z) {
        Options options = new Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Config.RGB_565;
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24003Re)).booleanValue()) {
            options.inJustDecodeBounds = true;
            m28173a(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                int i2 = i - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i2 / ((Integer) zzyt.m31536e().mo29599a(zzacu.f24009Se)).intValue())) / 2);
            }
        }
        return m28173a(bArr, options);
    }

    /* renamed from: a */
    private final Bitmap m28173a(byte[] bArr, Options options) {
        long a = this.f26274b.mo27934a();
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long a2 = this.f26274b.mo27934a();
        if (VERSION.SDK_INT >= 19 && decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j = a2 - a;
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z = true;
            }
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzawz.m26003f(sb.toString());
        }
        return decodeByteArray;
    }
}
