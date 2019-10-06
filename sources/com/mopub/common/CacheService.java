package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.DiskLruCache.Editor;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CacheService {

    /* renamed from: a */
    private static DiskLruCache f34232a;

    public interface DiskLruCacheGetListener {
        void onComplete(String str, byte[] bArr);
    }

    /* renamed from: com.mopub.common.CacheService$a */
    private static class C11220a extends AsyncTask<Void, Void, byte[]> {

        /* renamed from: a */
        private final DiskLruCacheGetListener f34233a;

        /* renamed from: b */
        private final String f34234b;

        C11220a(String key, DiskLruCacheGetListener diskLruCacheGetListener) {
            this.f34233a = diskLruCacheGetListener;
            this.f34234b = key;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public byte[] doInBackground(Void... voids) {
            return CacheService.getFromDiskCache(this.f34234b);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(byte[] bytes) {
            if (isCancelled()) {
                onCancelled();
                return;
            }
            DiskLruCacheGetListener diskLruCacheGetListener = this.f34233a;
            if (diskLruCacheGetListener != null) {
                diskLruCacheGetListener.onComplete(this.f34234b, bytes);
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            DiskLruCacheGetListener diskLruCacheGetListener = this.f34233a;
            if (diskLruCacheGetListener != null) {
                diskLruCacheGetListener.onComplete(this.f34234b, null);
            }
        }
    }

    /* renamed from: com.mopub.common.CacheService$b */
    private static class C11221b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private final String f34235a;

        /* renamed from: b */
        private final byte[] f34236b;

        C11221b(String key, byte[] content) {
            this.f34235a = key;
            this.f34236b = content;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voids) {
            CacheService.putToDiskCache(this.f34235a, this.f34236b);
            return null;
        }
    }

    public static boolean initializeDiskCache(Context context) {
        if (context == null) {
            return false;
        }
        if (f34232a == null) {
            File cacheDirectory = getDiskCacheDirectory(context);
            if (cacheDirectory == null) {
                return false;
            }
            try {
                f34232a = DiskLruCache.open(cacheDirectory, 1, 1, DeviceUtils.diskCacheSizeBytes(cacheDirectory));
            } catch (IOException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to create DiskLruCache", e);
                return false;
            }
        }
        return true;
    }

    public static void initialize(Context context) {
        initializeDiskCache(context);
    }

    public static String createValidDiskCacheKey(String key) {
        return Utils.sha1(key);
    }

    public static File getDiskCacheDirectory(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String cachePath = cacheDir.getPath();
        StringBuilder sb = new StringBuilder();
        sb.append(cachePath);
        sb.append(File.separator);
        sb.append("mopub-cache");
        return new File(sb.toString());
    }

    public static boolean containsKeyDiskCache(String key) {
        DiskLruCache diskLruCache = f34232a;
        boolean z = false;
        if (diskLruCache == null) {
            return false;
        }
        try {
            if (diskLruCache.get(createValidDiskCacheKey(key)) != null) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getFilePathDiskCache(String key) {
        if (f34232a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f34232a.getDirectory());
        sb.append(File.separator);
        sb.append(createValidDiskCacheKey(key));
        sb.append(".");
        sb.append(0);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r3 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        if (r3 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getFromDiskCache(java.lang.String r7) {
        /*
            com.mopub.common.DiskLruCache r0 = f34232a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r2 = 0
            r3 = 0
            r4 = 0
            java.lang.String r5 = createValidDiskCacheKey(r7)     // Catch:{ Exception -> 0x0042 }
            com.mopub.common.DiskLruCache$Snapshot r0 = r0.get(r5)     // Catch:{ Exception -> 0x0042 }
            r3 = r0
            if (r3 != 0) goto L_0x001b
            if (r3 == 0) goto L_0x001a
            r3.close()
        L_0x001a:
            return r1
        L_0x001b:
            java.io.InputStream r0 = r3.getInputStream(r4)     // Catch:{ Exception -> 0x0042 }
            if (r0 == 0) goto L_0x003a
            long r5 = r3.getLength(r4)     // Catch:{ Exception -> 0x0042 }
            int r1 = (int) r5     // Catch:{ Exception -> 0x0042 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0042 }
            r2 = r1
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0042 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0042 }
            com.mopub.common.util.Streams.readStream(r1, r2)     // Catch:{ all -> 0x0035 }
            com.mopub.common.util.Streams.closeStream(r1)     // Catch:{ Exception -> 0x0042 }
            goto L_0x003a
        L_0x0035:
            r5 = move-exception
            com.mopub.common.util.Streams.closeStream(r1)     // Catch:{ Exception -> 0x0042 }
            throw r5     // Catch:{ Exception -> 0x0042 }
        L_0x003a:
            if (r3 == 0) goto L_0x0055
        L_0x003c:
            r3.close()
            goto L_0x0055
        L_0x0040:
            r0 = move-exception
            goto L_0x0056
        L_0x0042:
            r0 = move-exception
            com.mopub.common.logging.MoPubLog$SdkLogEvent r1 = com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM     // Catch:{ all -> 0x0040 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0040 }
            java.lang.String r6 = "Unable to get from DiskLruCache"
            r5[r4] = r6     // Catch:{ all -> 0x0040 }
            r4 = 1
            r5[r4] = r0     // Catch:{ all -> 0x0040 }
            com.mopub.common.logging.MoPubLog.log(r1, r5)     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x0055
            goto L_0x003c
        L_0x0055:
            return r2
        L_0x0056:
            if (r3 == 0) goto L_0x005b
            r3.close()
        L_0x005b:
            goto L_0x005d
        L_0x005c:
            throw r0
        L_0x005d:
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.CacheService.getFromDiskCache(java.lang.String):byte[]");
    }

    public static void getFromDiskCacheAsync(String key, DiskLruCacheGetListener diskLruCacheGetListener) {
        new C11220a(key, diskLruCacheGetListener).execute(new Void[0]);
    }

    public static boolean putToDiskCache(String key, byte[] content) {
        return putToDiskCache(key, (InputStream) new ByteArrayInputStream(content));
    }

    public static boolean putToDiskCache(String key, InputStream content) {
        DiskLruCache diskLruCache = f34232a;
        if (diskLruCache == null) {
            return false;
        }
        Editor editor = null;
        try {
            Editor editor2 = diskLruCache.edit(createValidDiskCacheKey(key));
            if (editor2 == null) {
                return false;
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(editor2.newOutputStream(0));
            Streams.copyContent(content, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            f34232a.flush();
            editor2.commit();
            return true;
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to put to DiskLruCache", e);
            if (editor != null) {
                try {
                    editor.abort();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static void putToDiskCacheAsync(String key, byte[] content) {
        new C11221b(key, content).execute(new Void[0]);
    }

    @Deprecated
    @VisibleForTesting
    public static void clearAndNullCaches() {
        DiskLruCache diskLruCache = f34232a;
        if (diskLruCache != null) {
            try {
                diskLruCache.delete();
                f34232a = null;
            } catch (IOException e) {
                f34232a = null;
            }
        }
    }

    @Deprecated
    @VisibleForTesting
    public static DiskLruCache getDiskLruCache() {
        return f34232a;
    }
}
