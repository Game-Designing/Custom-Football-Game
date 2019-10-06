package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.file.CacheHelper;

final class Utils {
    static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 15000;
    static final int DEFAULT_READ_TIMEOUT_MILLIS = 20000;
    static final int DEFAULT_WRITE_TIMEOUT_MILLIS = 20000;
    private static final int KEY_PADDING = 50;
    static final char KEY_SEPARATOR = '\n';
    static final StringBuilder MAIN_THREAD_KEY_BUILDER = new StringBuilder();
    private static final int MAX_DISK_CACHE_SIZE = 52428800;
    private static final int MIN_DISK_CACHE_SIZE = 5242880;
    static final String OWNER_DISPATCHER = "Dispatcher";
    static final String OWNER_HUNTER = "Hunter";
    static final String OWNER_MAIN = "Main";
    private static final String PICASSO_CACHE = "picasso-cache";
    static final String THREAD_IDLE_NAME = "Picasso-Idle";
    static final int THREAD_LEAK_CLEANING_MS = 1000;
    static final String THREAD_PREFIX = "Picasso-";
    static final String VERB_BATCHED = "batched";
    static final String VERB_CANCELED = "canceled";
    static final String VERB_CHANGED = "changed";
    static final String VERB_COMPLETED = "completed";
    static final String VERB_CREATED = "created";
    static final String VERB_DECODED = "decoded";
    static final String VERB_DELIVERED = "delivered";
    static final String VERB_ENQUEUED = "enqueued";
    static final String VERB_ERRORED = "errored";
    static final String VERB_EXECUTING = "executing";
    static final String VERB_IGNORED = "ignored";
    static final String VERB_JOINED = "joined";
    static final String VERB_PAUSED = "paused";
    static final String VERB_REMOVED = "removed";
    static final String VERB_REPLAYING = "replaying";
    static final String VERB_RESUMED = "resumed";
    static final String VERB_RETRYING = "retrying";
    static final String VERB_TRANSFORMED = "transformed";
    private static final String WEBP_FILE_HEADER_RIFF = "RIFF";
    private static final int WEBP_FILE_HEADER_SIZE = 12;
    private static final String WEBP_FILE_HEADER_WEBP = "WEBP";

    @TargetApi(11)
    private static class ActivityManagerHoneycomb {
        private ActivityManagerHoneycomb() {
        }

        static int getLargeMemoryClass(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    private static class BitmapHoneycombMR1 {
        private BitmapHoneycombMR1() {
        }

        static int getByteCount(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    private static class OkHttpLoaderCreator {
        private OkHttpLoaderCreator() {
        }

        static Downloader create(Context context) {
            return new OkHttpDownloader(context);
        }
    }

    private static class PicassoThread extends Thread {
        public PicassoThread(Runnable r) {
            super(r);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class PicassoThreadFactory implements ThreadFactory {
        PicassoThreadFactory() {
        }

        public Thread newThread(Runnable r) {
            return new PicassoThread(r);
        }
    }

    private Utils() {
    }

    static int getBitmapBytes(Bitmap bitmap) {
        int result;
        if (VERSION.SDK_INT >= 12) {
            result = BitmapHoneycombMR1.getByteCount(bitmap);
        } else {
            result = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (result >= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Negative size: ");
        sb.append(bitmap);
        throw new IllegalStateException(sb.toString());
    }

    static <T> T checkNotNull(T value, String message) {
        if (value != null) {
            return value;
        }
        throw new NullPointerException(message);
    }

    static void checkNotMain() {
        if (isMain()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static void checkMain() {
        if (!isMain()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean isMain() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String getLogIdsForHunter(BitmapHunter hunter) {
        return getLogIdsForHunter(hunter, "");
    }

    static String getLogIdsForHunter(BitmapHunter hunter, String prefix) {
        StringBuilder builder = new StringBuilder(prefix);
        Action action = hunter.getAction();
        if (action != null) {
            builder.append(action.request.logId());
        }
        List<Action> actions = hunter.getActions();
        if (actions != null) {
            int count = actions.size();
            for (int i = 0; i < count; i++) {
                if (i > 0 || action != null) {
                    builder.append(", ");
                }
                builder.append(((Action) actions.get(i)).request.logId());
            }
        }
        return builder.toString();
    }

    static void log(String owner, String verb, String logId) {
        log(owner, verb, logId, "");
    }

    static void log(String owner, String verb, String logId, String extras) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{owner, verb, logId, extras}));
    }

    static String createKey(Request data) {
        String result = createKey(data, MAIN_THREAD_KEY_BUILDER);
        MAIN_THREAD_KEY_BUILDER.setLength(0);
        return result;
    }

    static String createKey(Request data, StringBuilder builder) {
        String str = data.stableKey;
        if (str != null) {
            builder.ensureCapacity(str.length() + 50);
            builder.append(data.stableKey);
        } else {
            Uri uri = data.uri;
            if (uri != null) {
                String path = uri.toString();
                builder.ensureCapacity(path.length() + 50);
                builder.append(path);
            } else {
                builder.ensureCapacity(50);
                builder.append(data.resourceId);
            }
        }
        builder.append(KEY_SEPARATOR);
        if (data.rotationDegrees != 0.0f) {
            builder.append("rotation:");
            builder.append(data.rotationDegrees);
            if (data.hasRotationPivot) {
                builder.append('@');
                builder.append(data.rotationPivotX);
                builder.append('x');
                builder.append(data.rotationPivotY);
            }
            builder.append(KEY_SEPARATOR);
        }
        if (data.hasSize()) {
            builder.append("resize:");
            builder.append(data.targetWidth);
            builder.append('x');
            builder.append(data.targetHeight);
            builder.append(KEY_SEPARATOR);
        }
        if (data.centerCrop) {
            builder.append("centerCrop");
            builder.append(KEY_SEPARATOR);
        } else if (data.centerInside) {
            builder.append("centerInside");
            builder.append(KEY_SEPARATOR);
        }
        List<Transformation> list = data.transformations;
        if (list != null) {
            int count = list.size();
            for (int i = 0; i < count; i++) {
                builder.append(((Transformation) data.transformations.get(i)).key());
                builder.append(KEY_SEPARATOR);
            }
        }
        return builder.toString();
    }

    static void closeQuietly(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    static boolean parseResponseSourceHeader(String header) {
        boolean z = false;
        if (header == null) {
            return false;
        }
        String[] parts = header.split(" ", 2);
        if ("CACHE".equals(parts[0])) {
            return true;
        }
        if (parts.length == 1) {
            return false;
        }
        try {
            if ("CONDITIONAL_CACHE".equals(parts[0]) && Integer.parseInt(parts[1]) == 304) {
                z = true;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static Downloader createDefaultDownloader(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return OkHttpLoaderCreator.create(context);
        } catch (ClassNotFoundException e) {
            return new UrlConnectionDownloader(context);
        }
    }

    static File createDefaultCacheDir(Context context) {
        File cache = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (!cache.exists()) {
            cache.mkdirs();
        }
        return cache;
    }

    static long calculateDiskCacheSize(File dir) {
        long size = 5242880;
        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            size = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException e) {
        }
        return Math.max(Math.min(size, 52428800), 5242880);
    }

    static int calculateMemoryCacheSize(Context context) {
        ActivityManager am = (ActivityManager) getService(context, "activity");
        boolean largeHeap = (context.getApplicationInfo().flags & CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES) != 0;
        int memoryClass = am.getMemoryClass();
        if (largeHeap && VERSION.SDK_INT >= 11) {
            memoryClass = ActivityManagerHoneycomb.getLargeMemoryClass(am);
        }
        return (CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES * memoryClass) / 7;
    }

    static boolean isAirplaneModeOn(Context context) {
        boolean z = false;
        try {
            if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                z = true;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        }
    }

    static <T> T getService(Context context, String service) {
        return context.getSystemService(service);
    }

    static boolean hasPermission(Context context, String permission) {
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[Opcodes.ACC_SYNTHETIC];
        while (true) {
            int read = input.read(buffer);
            int n = read;
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(buffer, 0, n);
        }
    }

    static boolean isWebPFile(InputStream stream) throws IOException {
        byte[] fileHeaderBytes = new byte[12];
        boolean z = false;
        if (stream.read(fileHeaderBytes, 0, 12) != 12) {
            return false;
        }
        String str = "US-ASCII";
        if (WEBP_FILE_HEADER_RIFF.equals(new String(fileHeaderBytes, 0, 4, str))) {
            if (WEBP_FILE_HEADER_WEBP.equals(new String(fileHeaderBytes, 8, 4, str))) {
                z = true;
            }
        }
        return z;
    }

    static int getResourceId(Resources resources, Request data) throws FileNotFoundException {
        int id;
        if (data.resourceId == 0) {
            Uri uri = data.uri;
            if (uri != null) {
                String pkg = uri.getAuthority();
                if (pkg != null) {
                    List<String> segments = data.uri.getPathSegments();
                    if (segments == null || segments.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No path segments: ");
                        sb.append(data.uri);
                        throw new FileNotFoundException(sb.toString());
                    }
                    if (segments.size() == 1) {
                        try {
                            id = Integer.parseInt((String) segments.get(0));
                        } catch (NumberFormatException e) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Last path segment is not a resource ID: ");
                            sb2.append(data.uri);
                            throw new FileNotFoundException(sb2.toString());
                        }
                    } else if (segments.size() == 2) {
                        id = resources.getIdentifier((String) segments.get(1), (String) segments.get(0), pkg);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("More than two path segments: ");
                        sb3.append(data.uri);
                        throw new FileNotFoundException(sb3.toString());
                    }
                    return id;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("No package provided: ");
                sb4.append(data.uri);
                throw new FileNotFoundException(sb4.toString());
            }
        }
        return data.resourceId;
    }

    static Resources getResources(Context context, Request data) throws FileNotFoundException {
        if (data.resourceId == 0) {
            Uri uri = data.uri;
            if (uri != null) {
                String pkg = uri.getAuthority();
                if (pkg != null) {
                    try {
                        return context.getPackageManager().getResourcesForApplication(pkg);
                    } catch (NameNotFoundException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to obtain resources for package: ");
                        sb.append(data.uri);
                        throw new FileNotFoundException(sb.toString());
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("No package provided: ");
                    sb2.append(data.uri);
                    throw new FileNotFoundException(sb2.toString());
                }
            }
        }
        return context.getResources();
    }

    static void flushStackLocalLeaks(Looper looper) {
        Handler handler = new Handler(looper) {
            public void handleMessage(Message msg) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 1000);
    }
}
