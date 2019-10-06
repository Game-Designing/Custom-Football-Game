package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.airbnb.lottie.p089c.C5778g;
import com.airbnb.lottie.p093d.C5784d;
import com.airbnb.lottie.p094e.C5817u;
import com.airbnb.lottie.p095f.C5829f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p005cm.aptoide.p006pt.utils.MultiDexHelper;

/* renamed from: com.airbnb.lottie.n */
/* compiled from: LottieCompositionFactory */
public class C5841n {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map<String, C5667F<C5830g>> f10154a = new HashMap();

    /* renamed from: c */
    public static C5667F<C5830g> m10586c(Context context, String url) {
        return C5784d.m10408a(context, url);
    }

    /* renamed from: a */
    public static C5667F<C5830g> m10576a(Context context, String fileName) {
        return m10578a(fileName, (Callable<C5664C<C5830g>>) new C5836i<C5664C<C5830g>>(context.getApplicationContext(), fileName));
    }

    /* renamed from: b */
    public static C5664C<C5830g> m10583b(Context context, String fileName) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("asset_");
            sb.append(fileName);
            String cacheKey = sb.toString();
            if (fileName.endsWith(MultiDexHelper.EXTRACTED_SUFFIX)) {
                return m10574a(new ZipInputStream(context.getAssets().open(fileName)), cacheKey);
            }
            return m10572a(context.getAssets().open(fileName), cacheKey);
        } catch (IOException e) {
            return new C5664C<>((Throwable) e);
        }
    }

    /* renamed from: a */
    public static C5667F<C5830g> m10575a(Context context, int rawRes) {
        return m10578a(m10580a(rawRes), (Callable<C5664C<C5830g>>) new C5837j<C5664C<C5830g>>(context.getApplicationContext(), rawRes));
    }

    /* renamed from: b */
    public static C5664C<C5830g> m10582b(Context context, int rawRes) {
        try {
            return m10572a(context.getResources().openRawResource(rawRes), m10580a(rawRes));
        } catch (NotFoundException e) {
            return new C5664C<>((Throwable) e);
        }
    }

    /* renamed from: a */
    private static String m10580a(int resId) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes_");
        sb.append(resId);
        return sb.toString();
    }

    /* renamed from: a */
    public static C5664C<C5830g> m10572a(InputStream stream, String cacheKey) {
        return m10573a(stream, cacheKey, true);
    }

    /* renamed from: a */
    private static C5664C<C5830g> m10573a(InputStream stream, String cacheKey, boolean close) {
        try {
            return m10584b(new JsonReader(new InputStreamReader(stream)), cacheKey);
        } finally {
            if (close) {
                C5829f.m10540a((Closeable) stream);
            }
        }
    }

    /* renamed from: a */
    public static C5667F<C5830g> m10577a(JsonReader reader, String cacheKey) {
        return m10578a(cacheKey, (Callable<C5664C<C5830g>>) new C5838k<C5664C<C5830g>>(reader, cacheKey));
    }

    /* renamed from: b */
    public static C5664C<C5830g> m10584b(JsonReader reader, String cacheKey) {
        try {
            C5830g composition = C5817u.m10480a(reader);
            C5778g.m10395a().mo18127a(cacheKey, composition);
            return new C5664C<>(composition);
        } catch (Exception e) {
            return new C5664C<>((Throwable) e);
        }
    }

    /* renamed from: a */
    public static C5664C<C5830g> m10574a(ZipInputStream inputStream, String cacheKey) {
        try {
            return m10585b(inputStream, cacheKey);
        } finally {
            C5829f.m10540a((Closeable) inputStream);
        }
    }

    /* renamed from: b */
    private static C5664C<C5830g> m10585b(ZipInputStream inputStream, String cacheKey) {
        C5830g composition = null;
        Map<String, Bitmap> images = new HashMap<>();
        try {
            ZipEntry entry = inputStream.getNextEntry();
            while (entry != null) {
                if (entry.getName().contains("__MACOSX")) {
                    inputStream.closeEntry();
                } else if (entry.getName().contains(".json")) {
                    composition = (C5830g) m10573a(inputStream, cacheKey, false).mo17867b();
                } else if (entry.getName().contains(".png")) {
                    String[] splitName = entry.getName().split("/");
                    images.put(splitName[splitName.length - 1], BitmapFactory.decodeStream(inputStream));
                } else {
                    inputStream.closeEntry();
                }
                entry = inputStream.getNextEntry();
            }
            if (composition == null) {
                return new C5664C<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Entry<String, Bitmap> e : images.entrySet()) {
                C5853y imageAsset = m10579a(composition, (String) e.getKey());
                if (imageAsset != null) {
                    imageAsset.mo18279a((Bitmap) e.getValue());
                }
            }
            for (Entry<String, LottieImageAsset> entry2 : composition.mo18198h().entrySet()) {
                if (((C5853y) entry2.getValue()).mo18278a() == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("There is no image for ");
                    sb.append(((C5853y) entry2.getValue()).mo18280b());
                    return new C5664C<>((Throwable) new IllegalStateException(sb.toString()));
                }
            }
            C5778g.m10395a().mo18127a(cacheKey, composition);
            return new C5664C<>(composition);
        } catch (IOException e2) {
            return new C5664C<>((Throwable) e2);
        }
    }

    /* renamed from: a */
    private static C5853y m10579a(C5830g composition, String fileName) {
        for (C5853y asset : composition.mo18198h().values()) {
            if (asset.mo18280b().equals(fileName)) {
                return asset;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C5667F<C5830g> m10578a(String cacheKey, Callable<C5664C<C5830g>> callable) {
        C5830g cachedComposition = C5778g.m10395a().mo18126a(cacheKey);
        if (cachedComposition != null) {
            return new C5667F<>(new C5839l(cachedComposition));
        }
        if (f10154a.containsKey(cacheKey)) {
            return (C5667F) f10154a.get(cacheKey);
        }
        LottieTask<LottieComposition> task = new C5667F<>(callable);
        task.mo17873b((C5854z<T>) new C5840m<T>(cacheKey));
        task.mo17872a((C5854z<Throwable>) new C5835h<Throwable>(cacheKey));
        f10154a.put(cacheKey, task);
        return task;
    }
}
