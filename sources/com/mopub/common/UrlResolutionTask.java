package com.mopub.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@VisibleForTesting
public class UrlResolutionTask extends AsyncTask<String, Void, String> {

    /* renamed from: a */
    private final C11237a f34370a;

    /* renamed from: com.mopub.common.UrlResolutionTask$a */
    interface C11237a {
        void onFailure(String str, Throwable th);

        void onSuccess(String str);
    }

    public static void getResolvedUrl(String urlString, C11237a listener) {
        try {
            AsyncTasks.safeExecuteOnExecutor(new UrlResolutionTask(listener), urlString);
        } catch (Exception e) {
            listener.onFailure("Failed to resolve url", e);
        }
    }

    UrlResolutionTask(C11237a listener) {
        this.f34370a = listener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(String... urls) {
        if (urls == null || urls.length == 0) {
            return null;
        }
        String previousUrl = null;
        try {
            String locationUrl = urls[0];
            int redirectCount = 0;
            while (locationUrl != null && redirectCount < 10) {
                if (!UrlAction.OPEN_IN_APP_BROWSER.shouldTryHandlingUrl(Uri.parse(locationUrl)) || UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(Uri.parse(locationUrl))) {
                    return locationUrl;
                }
                previousUrl = locationUrl;
                locationUrl = m37052b(locationUrl);
                redirectCount++;
            }
            return previousUrl;
        } catch (IOException e) {
            return null;
        } catch (URISyntaxException e2) {
            return null;
        } catch (NullPointerException e3) {
            return null;
        }
    }

    /* renamed from: b */
    private String m37052b(String urlString) throws IOException, URISyntaxException {
        InputStream is;
        String str = "IOException when closing httpUrlConnection. Ignoring.";
        HttpURLConnection httpUrlConnection = null;
        try {
            httpUrlConnection = (HttpURLConnection) new URL(urlString).openConnection();
            httpUrlConnection.setInstanceFollowRedirects(false);
            String a = m37051a(urlString, httpUrlConnection);
            if (httpUrlConnection != null) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        MoPubLog.log(SdkLogEvent.CUSTOM, str);
                    }
                }
            }
            return a;
        } finally {
            if (httpUrlConnection != null) {
                is = httpUrlConnection.getInputStream();
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e2) {
                        MoPubLog.log(SdkLogEvent.CUSTOM, str);
                    }
                }
                httpUrlConnection.disconnect();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static String m37051a(String baseUrl, HttpURLConnection httpUrlConnection) throws IOException, URISyntaxException {
        String str = "\n redirectUrl=";
        String str2 = "Invalid URL redirection. baseUrl=";
        URI baseUri = new URI(baseUrl);
        int responseCode = httpUrlConnection.getResponseCode();
        String redirectUrl = httpUrlConnection.getHeaderField("location");
        if (responseCode < 300 || responseCode >= 400) {
            return null;
        }
        try {
            return baseUri.resolve(redirectUrl).toString();
        } catch (IllegalArgumentException e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(baseUrl);
            sb.append(str);
            sb.append(redirectUrl);
            MoPubLog.log(sdkLogEvent, sb.toString());
            throw new URISyntaxException(redirectUrl, "Unable to parse invalid URL");
        } catch (NullPointerException e2) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(baseUrl);
            sb2.append(str);
            sb2.append(redirectUrl);
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String resolvedUrl) {
        super.onPostExecute(resolvedUrl);
        if (isCancelled() || resolvedUrl == null) {
            onCancelled();
        } else {
            this.f34370a.onSuccess(resolvedUrl);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        this.f34370a.onFailure("Task for resolving url was cancelled", null);
    }
}
