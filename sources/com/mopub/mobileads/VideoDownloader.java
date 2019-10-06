package com.mopub.mobileads;

import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayDeque;
import java.util.Deque;

public class VideoDownloader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Deque<WeakReference<C11362b>> f35113a = new ArrayDeque();

    /* renamed from: com.mopub.mobileads.VideoDownloader$a */
    interface C11361a {
        void onComplete(boolean z);
    }

    @VisibleForTesting
    /* renamed from: com.mopub.mobileads.VideoDownloader$b */
    static class C11362b extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        private final C11361a f35114a;

        /* renamed from: b */
        private final WeakReference<C11362b> f35115b = new WeakReference<>(this);

        @VisibleForTesting
        C11362b(C11361a listener) {
            this.f35114a = listener;
            VideoDownloader.f35113a.add(this.f35115b);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(String... params) {
            String[] strArr = params;
            Boolean valueOf = Boolean.valueOf(false);
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "VideoDownloader task tried to execute null or empty url.");
                return valueOf;
            }
            String videoUrl = strArr[0];
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(videoUrl);
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                int statusCode = urlConnection.getResponseCode();
                if (statusCode >= 200) {
                    if (statusCode < 300) {
                        int contentLength = urlConnection.getContentLength();
                        if (contentLength > 26214400) {
                            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum).", new Object[]{Integer.valueOf(contentLength), Integer.valueOf(26214400)}));
                            Streams.closeStream(inputStream);
                            if (urlConnection != null) {
                                urlConnection.disconnect();
                            }
                            return valueOf;
                        }
                        Boolean valueOf2 = Boolean.valueOf(CacheService.putToDiskCache(videoUrl, inputStream));
                        Streams.closeStream(inputStream);
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                        return valueOf2;
                    }
                }
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("VideoDownloader encountered unexpected statusCode: ");
                sb.append(statusCode);
                MoPubLog.log(sdkLogEvent, sb.toString());
                Streams.closeStream(inputStream);
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                return valueOf;
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.ERROR, "VideoDownloader task threw an internal exception.", e);
                Streams.closeStream(inputStream);
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                return valueOf;
            } catch (Throwable th) {
                Streams.closeStream(inputStream);
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean success) {
            if (isCancelled()) {
                onCancelled();
                return;
            }
            VideoDownloader.f35113a.remove(this.f35115b);
            if (success == null) {
                this.f35114a.onComplete(false);
            } else {
                this.f35114a.onComplete(success.booleanValue());
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            MoPubLog.log(SdkLogEvent.CUSTOM, "VideoDownloader task was cancelled.");
            VideoDownloader.f35113a.remove(this.f35115b);
            this.f35114a.onComplete(false);
        }
    }

    private VideoDownloader() {
    }

    public static void cache(String url, C11361a listener) {
        Preconditions.checkNotNull(listener);
        if (url == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "VideoDownloader attempted to cache video with null url.");
            listener.onComplete(false);
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new C11362b(listener), url);
        } catch (Exception e) {
            listener.onComplete(false);
        }
    }

    public static void cancelAllDownloaderTasks() {
        for (WeakReference<VideoDownloaderTask> weakDownloaderTask : f35113a) {
            m37685a(weakDownloaderTask);
        }
        f35113a.clear();
    }

    public static void cancelLastDownloadTask() {
        if (!f35113a.isEmpty()) {
            m37685a((WeakReference) f35113a.peekLast());
            f35113a.removeLast();
        }
    }

    /* renamed from: a */
    private static boolean m37685a(WeakReference<C11362b> weakDownloaderTask) {
        if (weakDownloaderTask == null) {
            return false;
        }
        C11362b downloaderTask = (C11362b) weakDownloaderTask.get();
        if (downloaderTask == null) {
            return false;
        }
        return downloaderTask.cancel(true);
    }

    @Deprecated
    @VisibleForTesting
    public static Deque<WeakReference<C11362b>> getDownloaderTasks() {
        return f35113a;
    }

    @Deprecated
    @VisibleForTesting
    public static void clearDownloaderTasks() {
        f35113a.clear();
    }
}
