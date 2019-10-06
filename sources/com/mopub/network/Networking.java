package com.mopub.network;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.Network;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;
import com.mopub.volley.toolbox.ImageLoader;
import java.io.File;

public class Networking {

    /* renamed from: a */
    private static final String f36370a;

    /* renamed from: b */
    private static volatile MoPubRequestQueue f36371b;

    /* renamed from: c */
    private static volatile String f36372c;

    /* renamed from: d */
    private static volatile MaxWidthImageLoader f36373d;

    /* renamed from: e */
    private static boolean f36374e = false;

    /* renamed from: f */
    private static UrlRewriter f36375f;

    static {
        String userAgent = "";
        try {
            userAgent = System.getProperty("http.agent", "");
        } catch (SecurityException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to get system user agent.");
        }
        f36370a = userAgent;
    }

    public static MoPubRequestQueue getRequestQueue() {
        return f36371b;
    }

    public static UrlRewriter getUrlRewriter(Context context) {
        Preconditions.checkNotNull(context);
        if (f36375f == null) {
            f36375f = new PlayServicesUrlRewriter();
        }
        return f36375f;
    }

    public static MoPubRequestQueue getRequestQueue(Context context) {
        MoPubRequestQueue requestQueue = f36371b;
        if (requestQueue == null) {
            synchronized (Networking.class) {
                requestQueue = f36371b;
                if (requestQueue == null) {
                    Network network = new BasicNetwork(new RequestQueueHttpStack(getUserAgent(context.getApplicationContext()), getUrlRewriter(context), CustomSSLSocketFactory.getDefault(10000)));
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getCacheDir().getPath());
                    sb.append(File.separator);
                    sb.append("mopub-volley-cache");
                    File volleyCacheDir = new File(sb.toString());
                    requestQueue = new MoPubRequestQueue(new DiskBasedCache(volleyCacheDir, (int) DeviceUtils.diskCacheSizeBytes(volleyCacheDir, 10485760)), network);
                    f36371b = requestQueue;
                    requestQueue.start();
                }
            }
        }
        return requestQueue;
    }

    public static ImageLoader getImageLoader(Context context) {
        MaxWidthImageLoader imageLoader = f36373d;
        if (imageLoader == null) {
            synchronized (Networking.class) {
                imageLoader = f36373d;
                if (imageLoader == null) {
                    imageLoader = new MaxWidthImageLoader(getRequestQueue(context), context, new C11679l(new C11678k<>(DeviceUtils.memoryCacheSizeBytes(context))));
                    f36373d = imageLoader;
                }
            }
        }
        return imageLoader;
    }

    public static String getUserAgent(Context context) {
        Preconditions.checkNotNull(context);
        String volatileUserAgentCopy = f36372c;
        if (!TextUtils.isEmpty(volatileUserAgentCopy)) {
            return volatileUserAgentCopy;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return f36370a;
        }
        String userAgent = f36370a;
        try {
            if (VERSION.SDK_INT >= 17) {
                userAgent = WebSettings.getDefaultUserAgent(context);
            } else {
                userAgent = new WebView(context).getSettings().getUserAgentString();
            }
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Failed to get a user agent. Defaulting to the system user agent.");
        }
        f36372c = userAgent;
        return userAgent;
    }

    public static String getCachedUserAgent() {
        String userAgent = f36372c;
        if (userAgent == null) {
            return f36370a;
        }
        return userAgent;
    }

    @VisibleForTesting
    public static synchronized void clearForTesting() {
        synchronized (Networking.class) {
            f36371b = null;
            f36373d = null;
            f36372c = null;
        }
    }

    @VisibleForTesting
    public static synchronized void setRequestQueueForTesting(MoPubRequestQueue queue) {
        synchronized (Networking.class) {
            f36371b = queue;
        }
    }

    @VisibleForTesting
    public static synchronized void setImageLoaderForTesting(MaxWidthImageLoader imageLoader) {
        synchronized (Networking.class) {
            f36373d = imageLoader;
        }
    }

    @VisibleForTesting
    public static synchronized void setUserAgentForTesting(String userAgent) {
        synchronized (Networking.class) {
            f36372c = userAgent;
        }
    }

    public static void useHttps(boolean useHttps) {
        f36374e = useHttps;
    }

    public static boolean shouldUseHttps() {
        return f36374e;
    }

    public static String getScheme() {
        return "https";
    }

    public static String getBaseUrlScheme() {
        return shouldUseHttps() ? "https" : Constants.HTTP;
    }
}
