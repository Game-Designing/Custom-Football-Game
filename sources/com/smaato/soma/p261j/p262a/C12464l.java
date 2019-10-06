package com.smaato.soma.p261j.p262a;

import android.os.AsyncTask;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.video.utilities.VideoDownloader.VideoDownloaderTask;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayDeque;
import java.util.Deque;

/* renamed from: com.smaato.soma.j.a.l */
/* compiled from: VideoDownloader */
public class C12464l {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Deque<WeakReference<C12466b>> f38909a = new ArrayDeque();

    /* renamed from: b */
    static String f38910b = "VideoDownloader";

    /* renamed from: com.smaato.soma.j.a.l$a */
    /* compiled from: VideoDownloader */
    public interface C12465a {
        void onComplete(boolean z);
    }

    /* renamed from: com.smaato.soma.j.a.l$b */
    /* compiled from: VideoDownloader */
    static class C12466b extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        private final C12465a f38911a;

        /* renamed from: b */
        private final WeakReference<C12466b> f38912b = new WeakReference<>(this);

        C12466b(C12465a listener) {
            this.f38911a = listener;
            C12464l.f38909a.add(this.f38912b);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(String... params) {
            Boolean valueOf = Boolean.valueOf(false);
            if (params == null || params.length == 0 || params[0] == null) {
                String str = C12464l.f38910b;
                StringBuilder sb = new StringBuilder();
                sb.append(C12464l.f38910b);
                sb.append("VideoDownloader task tried to execute null or empty url.");
                C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
                return valueOf;
            }
            String videoUrl = params[0];
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = C12462j.m40990b(videoUrl);
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                int statusCode = urlConnection.getResponseCode();
                if (statusCode >= 200) {
                    if (statusCode < 300) {
                        if (urlConnection.getContentLength() > 26214400) {
                            String str2 = C12464l.f38910b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(C12464l.f38910b);
                            sb2.append("VideoDownloader encountered video larger than disk cap.");
                            C12146d.m39965a(new C12147e(str2, sb2.toString(), 1, C12143a.DEBUG));
                            C12463k.m40994a(inputStream);
                            if (urlConnection != null) {
                                urlConnection.disconnect();
                            }
                            return valueOf;
                        }
                        Boolean valueOf2 = Boolean.valueOf(C12450b.m40930a(videoUrl, inputStream));
                        C12463k.m40994a(inputStream);
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                        return valueOf2;
                    }
                }
                String str3 = C12464l.f38910b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(C12464l.f38910b);
                sb3.append("VideoDownloader encountered unexpected statusCode:");
                C12146d.m39965a(new C12147e(str3, sb3.toString(), 1, C12143a.DEBUG));
                C12463k.m40994a(inputStream);
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                return valueOf;
            } catch (Exception e) {
                String str4 = C12464l.f38910b;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(C12464l.f38910b);
                sb4.append("VideoDownloader task threw an internal exception.");
                C12146d.m39965a(new C12147e(str4, sb4.toString(), 1, C12143a.DEBUG));
                C12463k.m40994a(inputStream);
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                return valueOf;
            } catch (Throwable th) {
                C12463k.m40994a(inputStream);
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
            C12464l.f38909a.remove(this.f38912b);
            if (success == null) {
                this.f38911a.onComplete(false);
            } else {
                this.f38911a.onComplete(success.booleanValue());
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            String str = C12464l.f38910b;
            StringBuilder sb = new StringBuilder();
            sb.append(C12464l.f38910b);
            sb.append("VideoDownloader task was cancelled.");
            C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
            C12464l.f38909a.remove(this.f38912b);
            this.f38911a.onComplete(false);
        }
    }

    /* renamed from: a */
    public static void m40997a(String url, C12465a listener) {
        if (url == null || listener == null) {
            String str = f38910b;
            StringBuilder sb = new StringBuilder();
            sb.append(f38910b);
            sb.append("VideoDownloader attempted to cache video with null url.");
            C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
            listener.onComplete(false);
            return;
        }
        try {
            C12461i.m40988a(new C12466b(listener), url);
        } catch (Exception e) {
            listener.onComplete(false);
        }
    }

    /* renamed from: b */
    public static void m40999b() {
        for (WeakReference<VideoDownloaderTask> weakDownloaderTask : f38909a) {
            m40998a(weakDownloaderTask);
        }
        f38909a.clear();
    }

    /* renamed from: a */
    private static boolean m40998a(WeakReference<C12466b> weakDownloaderTask) {
        if (weakDownloaderTask == null) {
            return false;
        }
        C12466b downloaderTask = (C12466b) weakDownloaderTask.get();
        if (downloaderTask == null) {
            return false;
        }
        return downloaderTask.cancel(true);
    }
}
