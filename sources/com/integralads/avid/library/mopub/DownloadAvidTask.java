package com.integralads.avid.library.mopub;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.integralads.avid.library.mopub.utils.AvidLogs;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadAvidTask extends AsyncTask<String, Void, String> {
    private static final int BSIZE = 1024;
    private DownloadAvidTaskListener listener;

    public interface DownloadAvidTaskListener {
        void failedToLoadAvid();

        void onLoadAvid(String str);
    }

    public DownloadAvidTaskListener getListener() {
        return this.listener;
    }

    public void setListener(DownloadAvidTaskListener listener2) {
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(String... params) {
        String str = "AvidLoader: can not close Stream";
        String urlString = params[0];
        if (TextUtils.isEmpty(urlString)) {
            AvidLogs.m35378e("AvidLoader: URL is empty");
            return null;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            URLConnection urlConnection = new URL(urlString).openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(urlConnection.getInputStream());
            StringWriter stringWriter = new StringWriter();
            byte[] buf = new byte[1024];
            while (true) {
                int read = bufferedInputStream2.read(buf);
                int data = read;
                if (read != -1) {
                    stringWriter.write(new String(buf, 0, data));
                } else {
                    String stringWriter2 = stringWriter.toString();
                    try {
                        bufferedInputStream2.close();
                        return stringWriter2;
                    } catch (IOException e) {
                        AvidLogs.m35379e(str, e);
                        return null;
                    }
                }
            }
        } catch (MalformedURLException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("AvidLoader: something is wrong with the URL '");
            sb.append(urlString);
            sb.append("'");
            AvidLogs.m35378e(sb.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    AvidLogs.m35379e(str, e3);
                    return null;
                }
            }
            return null;
        } catch (IOException e4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AvidLoader: IO error ");
            sb2.append(e4.getLocalizedMessage());
            AvidLogs.m35378e(sb2.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    AvidLogs.m35379e(str, e5);
                    return null;
                }
            }
            return null;
        } catch (Throwable e6) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e7) {
                    AvidLogs.m35379e(str, e7);
                    return null;
                }
            }
            throw e6;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String result) {
        if (this.listener == null) {
            return;
        }
        if (!TextUtils.isEmpty(result)) {
            this.listener.onLoadAvid(result);
        } else {
            this.listener.failedToLoadAvid();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        DownloadAvidTaskListener downloadAvidTaskListener = this.listener;
        if (downloadAvidTaskListener != null) {
            downloadAvidTaskListener.failedToLoadAvid();
        }
    }

    /* access modifiers changed from: 0000 */
    public void invokeOnPostExecute(String result) {
        onPostExecute(result);
    }

    /* access modifiers changed from: 0000 */
    public void invokeOnCancelled() {
        onCancelled();
    }
}
