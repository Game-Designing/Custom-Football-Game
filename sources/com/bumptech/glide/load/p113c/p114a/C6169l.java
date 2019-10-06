package com.bumptech.glide.load.p113c.p114a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.C6060b;
import com.bumptech.glide.load.C6230e;
import com.bumptech.glide.load.C6230e.C6231a;
import com.bumptech.glide.load.C6343f;
import com.bumptech.glide.load.C6347j;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p114a.C6160j.C6167g;
import com.bumptech.glide.p107h.C6020e;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import com.mopub.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.c.a.l */
/* compiled from: Downsampler */
public final class C6169l {

    /* renamed from: a */
    public static final C6347j<C6060b> f10877a = C6347j.m12245a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", C6060b.f10740d);
    @Deprecated

    /* renamed from: b */
    public static final C6347j<C6160j> f10878b = C6160j.f10873h;

    /* renamed from: c */
    public static final C6347j<Boolean> f10879c = C6347j.m12245a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.valueOf(false));

    /* renamed from: d */
    public static final C6347j<Boolean> f10880d = C6347j.m12244a("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");

    /* renamed from: e */
    private static final Set<String> f10881e = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: f */
    private static final C6170a f10882f = new C6168k();

    /* renamed from: g */
    private static final Set<C6231a> f10883g = Collections.unmodifiableSet(EnumSet.of(C6231a.JPEG, C6231a.PNG_A, C6231a.PNG));

    /* renamed from: h */
    private static final Queue<Options> f10884h = C6026k.m11280a(0);

    /* renamed from: i */
    private final C6250e f10885i;

    /* renamed from: j */
    private final DisplayMetrics f10886j;

    /* renamed from: k */
    private final C6245b f10887k;

    /* renamed from: l */
    private final List<C6230e> f10888l;

    /* renamed from: m */
    private final C6175q f10889m = C6175q.m11704a();

    /* renamed from: com.bumptech.glide.load.c.a.l$a */
    /* compiled from: Downsampler */
    public interface C6170a {
        /* renamed from: a */
        void mo18994a();

        /* renamed from: a */
        void mo18995a(C6250e eVar, Bitmap bitmap) throws IOException;
    }

    public C6169l(List<C6230e> parsers, DisplayMetrics displayMetrics, C6250e bitmapPool, C6245b byteArrayPool) {
        this.f10888l = parsers;
        C6024i.m11264a(displayMetrics);
        this.f10886j = displayMetrics;
        C6024i.m11264a(bitmapPool);
        this.f10885i = bitmapPool;
        C6024i.m11264a(byteArrayPool);
        this.f10887k = byteArrayPool;
    }

    /* renamed from: a */
    public boolean mo18998a(InputStream is) {
        return true;
    }

    /* renamed from: a */
    public boolean mo18999a(ByteBuffer byteBuffer) {
        return true;
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18996a(InputStream is, int outWidth, int outHeight, C6349k options) throws IOException {
        return mo18997a(is, outWidth, outHeight, options, f10882f);
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18997a(InputStream is, int requestedWidth, int requestedHeight, C6349k options, C6170a callbacks) throws IOException {
        boolean isHardwareConfigAllowed;
        C6349k kVar = options;
        C6024i.m11268a(is.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bytesForOptions = (byte[]) this.f10887k.mo19127a(65536, byte[].class);
        Options bitmapFactoryOptions = m11678a();
        bitmapFactoryOptions.inTempStorage = bytesForOptions;
        C6060b decodeFormat = (C6060b) kVar.mo19310a(f10877a);
        C6160j downsampleStrategy = (C6160j) kVar.mo19310a(C6160j.f10873h);
        boolean fixBitmapToRequestedDimensions = ((Boolean) kVar.mo19310a(f10879c)).booleanValue();
        boolean isHardwareConfigAllowed2 = kVar.mo19310a(f10880d) != null && ((Boolean) kVar.mo19310a(f10880d)).booleanValue();
        if (decodeFormat == C6060b.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
            isHardwareConfigAllowed = false;
        } else {
            isHardwareConfigAllowed = isHardwareConfigAllowed2;
        }
        try {
            return C6150d.m11623a(m11676a(is, bitmapFactoryOptions, downsampleStrategy, decodeFormat, isHardwareConfigAllowed, requestedWidth, requestedHeight, fixBitmapToRequestedDimensions, callbacks), this.f10885i);
        } finally {
            m11691c(bitmapFactoryOptions);
            this.f10887k.put(bytesForOptions);
        }
    }

    /* renamed from: a */
    private Bitmap m11676a(InputStream is, Options options, C6160j downsampleStrategy, C6060b decodeFormat, boolean isHardwareConfigAllowed, int requestedWidth, int requestedHeight, boolean fixBitmapToRequestedDimensions, C6170a callbacks) throws IOException {
        boolean isHardwareConfigAllowed2;
        C6169l lVar;
        String str;
        int expectedHeight;
        int expectedWidth;
        int expectedWidth2;
        InputStream inputStream = is;
        Options options2 = options;
        C6170a aVar = callbacks;
        long startTime = C6020e.m11250a();
        int[] sourceDimensions = m11689b(inputStream, options2, aVar, this.f10885i);
        boolean z = false;
        int sourceWidth = sourceDimensions[0];
        int sourceHeight = sourceDimensions[1];
        String sourceMimeType = options2.outMimeType;
        if (sourceWidth == -1 || sourceHeight == -1) {
            isHardwareConfigAllowed2 = false;
        } else {
            isHardwareConfigAllowed2 = isHardwareConfigAllowed;
        }
        int orientation = C6343f.m12240a(this.f10888l, inputStream, this.f10887k);
        int degreesToRotate = C6182v.m11725a(orientation);
        boolean isExifOrientationRequired = C6182v.m11735b(orientation);
        int i = requestedWidth;
        int targetWidth = i == Integer.MIN_VALUE ? sourceWidth : i;
        int i2 = requestedHeight;
        int targetHeight = i2 == Integer.MIN_VALUE ? sourceHeight : i2;
        C6231a imageType = C6343f.m12242b(this.f10888l, inputStream, this.f10887k);
        C6250e eVar = this.f10885i;
        C6231a imageType2 = imageType;
        m11684a(imageType, is, callbacks, eVar, downsampleStrategy, degreesToRotate, sourceWidth, sourceHeight, targetWidth, targetHeight, options);
        int orientation2 = orientation;
        String sourceMimeType2 = sourceMimeType;
        int sourceHeight2 = sourceHeight;
        int sourceWidth2 = sourceWidth;
        C6170a aVar2 = aVar;
        Options options3 = options2;
        m11685a(is, decodeFormat, isHardwareConfigAllowed2, isExifOrientationRequired, options, targetWidth, targetHeight);
        if (VERSION.SDK_INT >= 19) {
            z = true;
        }
        boolean isKitKatOrGreater = z;
        String str2 = "Downsampler";
        if (options3.inSampleSize == 1 || isKitKatOrGreater) {
            lVar = this;
            if (lVar.m11686a(imageType2)) {
                if (sourceWidth2 < 0 || sourceHeight2 < 0 || !fixBitmapToRequestedDimensions || !isKitKatOrGreater) {
                    float densityMultiplier = m11688b(options) != 0 ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int sampleSize = options3.inSampleSize;
                    String str3 = str2;
                    int downsampledHeight = (int) Math.ceil((double) (((float) sourceHeight2) / ((float) sampleSize)));
                    int expectedWidth3 = Math.round(((float) ((int) Math.ceil((double) (((float) sourceWidth2) / ((float) sampleSize))))) * densityMultiplier);
                    int expectedHeight2 = Math.round(((float) downsampledHeight) * densityMultiplier);
                    boolean z2 = isKitKatOrGreater;
                    str = str3;
                    if (Log.isLoggable(str, 2)) {
                        StringBuilder sb = new StringBuilder();
                        int i3 = downsampledHeight;
                        sb.append("Calculated target [");
                        sb.append(expectedWidth3);
                        String str4 = "x";
                        sb.append(str4);
                        sb.append(expectedHeight2);
                        expectedWidth2 = expectedWidth3;
                        sb.append("] for source [");
                        sb.append(sourceWidth2);
                        sb.append(str4);
                        sb.append(sourceHeight2);
                        sb.append("], sampleSize: ");
                        sb.append(sampleSize);
                        sb.append(", targetDensity: ");
                        sb.append(options3.inTargetDensity);
                        sb.append(", density: ");
                        sb.append(options3.inDensity);
                        sb.append(", density multiplier: ");
                        sb.append(densityMultiplier);
                        Log.v(str, sb.toString());
                    } else {
                        expectedWidth2 = expectedWidth3;
                    }
                    expectedHeight = expectedHeight2;
                    expectedWidth = expectedWidth2;
                } else {
                    expectedWidth = targetWidth;
                    expectedHeight = targetHeight;
                    boolean z3 = isKitKatOrGreater;
                    str = str2;
                }
                if (expectedWidth > 0 && expectedHeight > 0) {
                    m11683a(options3, lVar.f10885i, expectedWidth, expectedHeight);
                }
            } else {
                str = str2;
            }
        } else {
            lVar = this;
            boolean z4 = isKitKatOrGreater;
            str = str2;
            C6231a aVar3 = imageType2;
        }
        Bitmap downsampled = m11677a(is, options3, aVar2, lVar.f10885i);
        aVar2.mo18995a(lVar.f10885i, downsampled);
        if (Log.isLoggable(str, 2)) {
            m11682a(sourceWidth2, sourceHeight2, sourceMimeType2, options, downsampled, requestedWidth, requestedHeight, startTime);
        }
        Bitmap rotated = null;
        if (downsampled != null) {
            downsampled.setDensity(lVar.f10886j.densityDpi);
            rotated = C6182v.m11727a(lVar.f10885i, downsampled, orientation2);
            if (!downsampled.equals(rotated)) {
                lVar.f10885i.mo19000a(downsampled);
            }
        }
        return rotated;
    }

    /* renamed from: a */
    private static void m11684a(C6231a imageType, InputStream is, C6170a decodeCallbacks, C6250e bitmapPool, C6160j downsampleStrategy, int degreesToRotate, int sourceWidth, int sourceHeight, int targetWidth, int targetHeight, Options options) throws IOException {
        float exactScaleFactor;
        int scaleFactor;
        int powerOfTwoSampleSize;
        float exactScaleFactor2;
        int powerOfTwoHeight;
        int powerOfTwoWidth;
        C6231a aVar = imageType;
        C6160j jVar = downsampleStrategy;
        int i = degreesToRotate;
        int i2 = sourceWidth;
        int i3 = sourceHeight;
        int i4 = targetWidth;
        int i5 = targetHeight;
        Options options2 = options;
        String str = "]";
        String str2 = "Downsampler";
        String str3 = "x";
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable(str2, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to determine dimensions for: ");
                sb.append(imageType);
                sb.append(" with target [");
                sb.append(i4);
                sb.append(str3);
                sb.append(i5);
                sb.append(str);
                Log.d(str2, sb.toString());
            } else {
                C6231a aVar2 = imageType;
            }
            return;
        }
        if (i == 90 || i == 270) {
            exactScaleFactor = jVar.mo18993b(i3, i2, i4, i5);
        } else {
            exactScaleFactor = jVar.mo18993b(i2, i3, i4, i5);
        }
        String str4 = "], target: [";
        if (exactScaleFactor > 0.0f) {
            C6167g rounding = jVar.mo18992a(i2, i3, i4, i5);
            if (rounding != null) {
                int outWidth = m11690c((double) (((float) i2) * exactScaleFactor));
                int outHeight = m11690c((double) (((float) i3) * exactScaleFactor));
                int widthScaleFactor = i2 / outWidth;
                int heightScaleFactor = i3 / outHeight;
                int i6 = outWidth;
                if (rounding == C6167g.MEMORY) {
                    scaleFactor = Math.max(widthScaleFactor, heightScaleFactor);
                } else {
                    scaleFactor = Math.min(widthScaleFactor, heightScaleFactor);
                }
                int i7 = heightScaleFactor;
                int i8 = outHeight;
                int i9 = widthScaleFactor;
                if (VERSION.SDK_INT > 23 || !f10881e.contains(options2.outMimeType)) {
                    powerOfTwoSampleSize = Math.max(1, Integer.highestOneBit(scaleFactor));
                    if (rounding == C6167g.MEMORY && ((float) powerOfTwoSampleSize) < 1.0f / exactScaleFactor) {
                        powerOfTwoSampleSize <<= 1;
                    }
                } else {
                    powerOfTwoSampleSize = 1;
                }
                options2.inSampleSize = powerOfTwoSampleSize;
                if (aVar == C6231a.JPEG) {
                    int nativeScaling = Math.min(powerOfTwoSampleSize, 8);
                    C6167g gVar = rounding;
                    exactScaleFactor2 = exactScaleFactor;
                    int scaleFactor2 = scaleFactor;
                    powerOfTwoWidth = (int) Math.ceil((double) (((float) i2) / ((float) nativeScaling)));
                    int i10 = nativeScaling;
                    powerOfTwoHeight = (int) Math.ceil((double) (((float) i3) / ((float) nativeScaling)));
                    int secondaryScaling = powerOfTwoSampleSize / 8;
                    if (secondaryScaling > 0) {
                        powerOfTwoWidth /= secondaryScaling;
                        powerOfTwoHeight /= secondaryScaling;
                    }
                    C6250e eVar = bitmapPool;
                    int i11 = scaleFactor2;
                } else {
                    exactScaleFactor2 = exactScaleFactor;
                    int scaleFactor3 = scaleFactor;
                    if (aVar == C6231a.PNG) {
                        C6250e eVar2 = bitmapPool;
                        int i12 = scaleFactor3;
                    } else if (aVar == C6231a.PNG_A) {
                        C6250e eVar3 = bitmapPool;
                        int i13 = scaleFactor3;
                    } else {
                        if (aVar == C6231a.WEBP) {
                            InputStream inputStream = is;
                            C6170a aVar3 = decodeCallbacks;
                            C6250e eVar4 = bitmapPool;
                        } else if (aVar == C6231a.WEBP_A) {
                            InputStream inputStream2 = is;
                            C6170a aVar4 = decodeCallbacks;
                            C6250e eVar5 = bitmapPool;
                        } else if (i2 % powerOfTwoSampleSize == 0 && i3 % powerOfTwoSampleSize == 0) {
                            powerOfTwoWidth = i2 / powerOfTwoSampleSize;
                            powerOfTwoHeight = i3 / powerOfTwoSampleSize;
                            C6250e eVar6 = bitmapPool;
                            int i14 = scaleFactor3;
                        } else {
                            int[] dimensions = m11689b(is, options2, decodeCallbacks, bitmapPool);
                            int powerOfTwoWidth2 = dimensions[0];
                            powerOfTwoHeight = dimensions[1];
                            powerOfTwoWidth = powerOfTwoWidth2;
                            int powerOfTwoWidth3 = scaleFactor3;
                        }
                        int i15 = scaleFactor3;
                        if (VERSION.SDK_INT >= 24) {
                            int powerOfTwoWidth4 = Math.round(((float) i2) / ((float) powerOfTwoSampleSize));
                            powerOfTwoHeight = Math.round(((float) i3) / ((float) powerOfTwoSampleSize));
                            powerOfTwoWidth = powerOfTwoWidth4;
                        } else {
                            powerOfTwoHeight = (int) Math.floor((double) (((float) i3) / ((float) powerOfTwoSampleSize)));
                            powerOfTwoWidth = (int) Math.floor((double) (((float) i2) / ((float) powerOfTwoSampleSize)));
                        }
                    }
                    powerOfTwoHeight = (int) Math.floor((double) (((float) i3) / ((float) powerOfTwoSampleSize)));
                    powerOfTwoWidth = (int) Math.floor((double) (((float) i2) / ((float) powerOfTwoSampleSize)));
                }
                double adjustedScaleFactor = (double) jVar.mo18993b(powerOfTwoWidth, powerOfTwoHeight, i4, i5);
                if (VERSION.SDK_INT >= 19) {
                    options2.inTargetDensity = m11675a(adjustedScaleFactor);
                    options2.inDensity = m11687b(adjustedScaleFactor);
                }
                if (m11688b(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                if (Log.isLoggable(str2, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculate scaling, source: [");
                    sb2.append(i2);
                    sb2.append(str3);
                    sb2.append(i3);
                    sb2.append(str4);
                    sb2.append(i4);
                    sb2.append(str3);
                    sb2.append(i5);
                    sb2.append("], power of two scaled: [");
                    sb2.append(powerOfTwoWidth);
                    sb2.append(str3);
                    sb2.append(powerOfTwoHeight);
                    sb2.append("], exact scale factor: ");
                    sb2.append(exactScaleFactor2);
                    sb2.append(", power of 2 sample size: ");
                    sb2.append(powerOfTwoSampleSize);
                    sb2.append(", adjusted scale factor: ");
                    sb2.append(adjustedScaleFactor);
                    sb2.append(", target density: ");
                    sb2.append(options2.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options2.inDensity);
                    Log.v(str2, sb2.toString());
                }
                return;
            }
            float f = exactScaleFactor;
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Cannot scale with factor: ");
        sb3.append(exactScaleFactor);
        sb3.append(" from: ");
        sb3.append(jVar);
        sb3.append(", source: [");
        sb3.append(i2);
        sb3.append(str3);
        sb3.append(i3);
        sb3.append(str4);
        sb3.append(i4);
        sb3.append(str3);
        sb3.append(i5);
        sb3.append(str);
        throw new IllegalArgumentException(sb3.toString());
    }

    /* renamed from: a */
    private static int m11675a(double adjustedScaleFactor) {
        int densityMultiplier = m11687b(adjustedScaleFactor);
        double d = (double) densityMultiplier;
        Double.isNaN(d);
        int targetDensity = m11690c(d * adjustedScaleFactor);
        double d2 = (double) (((float) targetDensity) / ((float) densityMultiplier));
        Double.isNaN(d2);
        double difference = adjustedScaleFactor / d2;
        double d3 = (double) targetDensity;
        Double.isNaN(d3);
        return m11690c(d3 * difference);
    }

    /* renamed from: b */
    private static int m11687b(double adjustedScaleFactor) {
        return (int) Math.round((adjustedScaleFactor <= 1.0d ? adjustedScaleFactor : 1.0d / adjustedScaleFactor) * 2.147483647E9d);
    }

    /* renamed from: c */
    private static int m11690c(double value) {
        return (int) (0.5d + value);
    }

    /* renamed from: a */
    private boolean m11686a(C6231a imageType) {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return f10883g.contains(imageType);
    }

    /* renamed from: a */
    private void m11685a(InputStream is, C6060b format, boolean isHardwareConfigAllowed, boolean isExifOrientationRequired, Options optionsWithScaling, int targetWidth, int targetHeight) {
        if (!this.f10889m.mo19002a(targetWidth, targetHeight, optionsWithScaling, format, isHardwareConfigAllowed, isExifOrientationRequired)) {
            if (format == C6060b.PREFER_ARGB_8888 || format == C6060b.PREFER_ARGB_8888_DISALLOW_HARDWARE || VERSION.SDK_INT == 16) {
                optionsWithScaling.inPreferredConfig = Config.ARGB_8888;
                return;
            }
            boolean hasAlpha = false;
            try {
                hasAlpha = C6343f.m12242b(this.f10888l, is, this.f10887k).mo19094e();
            } catch (IOException e) {
                String str = "Downsampler";
                if (Log.isLoggable(str, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot determine whether the image has alpha or not from header, format ");
                    sb.append(format);
                    Log.d(str, sb.toString(), e);
                }
            }
            optionsWithScaling.inPreferredConfig = hasAlpha ? Config.ARGB_8888 : Config.RGB_565;
            if (optionsWithScaling.inPreferredConfig == Config.RGB_565) {
                optionsWithScaling.inDither = true;
            }
        }
    }

    /* renamed from: b */
    private static int[] m11689b(InputStream is, Options options, C6170a decodeCallbacks, C6250e bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        m11677a(is, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: a */
    private static Bitmap m11677a(InputStream is, Options options, C6170a callbacks, C6250e bitmapPool) throws IOException {
        IOException bitmapAssertionException;
        String str = "Downsampler";
        if (options.inJustDecodeBounds) {
            is.mark(Constants.TEN_MB);
        } else {
            callbacks.mo18994a();
        }
        int sourceWidth = options.outWidth;
        int sourceHeight = options.outHeight;
        String outMimeType = options.outMimeType;
        C6182v.m11729a().lock();
        try {
            Bitmap result = BitmapFactory.decodeStream(is, null, options);
            C6182v.m11729a().unlock();
            if (options.inJustDecodeBounds) {
                is.reset();
            }
            return result;
        } catch (IOException e) {
            throw bitmapAssertionException;
        } catch (IllegalArgumentException e2) {
            bitmapAssertionException = m11679a(e2, sourceWidth, sourceHeight, outMimeType, options);
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to decode with inBitmap, trying again without Bitmap re-use", bitmapAssertionException);
            }
            if (options.inBitmap != null) {
                is.reset();
                bitmapPool.mo19000a(options.inBitmap);
                options.inBitmap = null;
                Bitmap a = m11677a(is, options, callbacks, bitmapPool);
                C6182v.m11729a().unlock();
                return a;
            }
            throw bitmapAssertionException;
        } catch (Throwable th) {
            C6182v.m11729a().unlock();
            throw th;
        }
    }

    /* renamed from: b */
    private static boolean m11688b(Options options) {
        int i = options.inTargetDensity;
        if (i > 0) {
            int i2 = options.inDensity;
            if (i2 > 0 && i != i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m11682a(int sourceWidth, int sourceHeight, String outMimeType, Options options, Bitmap result, int requestedWidth, int requestedHeight, long startTime) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoded ");
        sb.append(m11680a(result));
        sb.append(" from [");
        sb.append(sourceWidth);
        String str = "x";
        sb.append(str);
        sb.append(sourceHeight);
        sb.append("] ");
        sb.append(outMimeType);
        sb.append(" with inBitmap ");
        sb.append(m11681a(options));
        sb.append(" for [");
        sb.append(requestedWidth);
        sb.append(str);
        sb.append(requestedHeight);
        sb.append("], sample size: ");
        sb.append(options.inSampleSize);
        sb.append(", density: ");
        sb.append(options.inDensity);
        sb.append(", target density: ");
        sb.append(options.inTargetDensity);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.append(", duration: ");
        sb.append(C6020e.m11249a(startTime));
        Log.v("Downsampler", sb.toString());
    }

    /* renamed from: a */
    private static String m11681a(Options options) {
        return m11680a(options.inBitmap);
    }

    @TargetApi(19)
    /* renamed from: a */
    private static String m11680a(Bitmap bitmap) {
        String sizeString;
        if (bitmap == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 19) {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(bitmap.getAllocationByteCount());
            sb.append(")");
            sizeString = sb.toString();
        } else {
            sizeString = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(bitmap.getWidth());
        sb2.append("x");
        sb2.append(bitmap.getHeight());
        sb2.append("] ");
        sb2.append(bitmap.getConfig());
        sb2.append(sizeString);
        return sb2.toString();
    }

    /* renamed from: a */
    private static IOException m11679a(IllegalArgumentException e, int outWidth, int outHeight, String outMimeType, Options options) {
        StringBuilder sb = new StringBuilder();
        sb.append("Exception decoding bitmap, outWidth: ");
        sb.append(outWidth);
        sb.append(", outHeight: ");
        sb.append(outHeight);
        sb.append(", outMimeType: ");
        sb.append(outMimeType);
        sb.append(", inBitmap: ");
        sb.append(m11681a(options));
        return new IOException(sb.toString(), e);
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m11683a(Options options, C6250e bitmapPool, int width, int height) {
        Config expectedConfig = null;
        if (VERSION.SDK_INT >= 26) {
            if (options.inPreferredConfig != Config.HARDWARE) {
                expectedConfig = options.outConfig;
            } else {
                return;
            }
        }
        if (expectedConfig == null) {
            expectedConfig = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.mo19151b(width, height, expectedConfig);
    }

    /* renamed from: a */
    private static synchronized Options m11678a() {
        Options decodeBitmapOptions;
        synchronized (C6169l.class) {
            synchronized (f10884h) {
                decodeBitmapOptions = (Options) f10884h.poll();
            }
            if (decodeBitmapOptions == null) {
                decodeBitmapOptions = new Options();
                m11692d(decodeBitmapOptions);
            }
        }
        return decodeBitmapOptions;
    }

    /* renamed from: c */
    private static void m11691c(Options decodeBitmapOptions) {
        m11692d(decodeBitmapOptions);
        synchronized (f10884h) {
            f10884h.offer(decodeBitmapOptions);
        }
    }

    /* renamed from: d */
    private static void m11692d(Options decodeBitmapOptions) {
        decodeBitmapOptions.inTempStorage = null;
        decodeBitmapOptions.inDither = false;
        decodeBitmapOptions.inScaled = false;
        decodeBitmapOptions.inSampleSize = 1;
        decodeBitmapOptions.inPreferredConfig = null;
        decodeBitmapOptions.inJustDecodeBounds = false;
        decodeBitmapOptions.inDensity = 0;
        decodeBitmapOptions.inTargetDensity = 0;
        decodeBitmapOptions.outWidth = 0;
        decodeBitmapOptions.outHeight = 0;
        decodeBitmapOptions.outMimeType = null;
        decodeBitmapOptions.inBitmap = null;
        decodeBitmapOptions.inMutable = true;
    }
}
