package com.integralads.avid.library.inmobi;

import android.os.AsyncTask;
import android.text.TextUtils;

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

    public void setListener(DownloadAvidTaskListener downloadAvidTaskListener) {
        this.listener = downloadAvidTaskListener;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f A[SYNTHETIC, Splitter:B:27:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008e A[SYNTHETIC, Splitter:B:35:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096 A[Catch:{ IOException -> 0x004a }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0076=Splitter:B:32:0x0076, B:24:0x0058=Splitter:B:24:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doInBackground(java.lang.String... r9) {
        /*
            r8 = this;
            java.lang.String r0 = "AvidLoader: can not close Stream"
            r1 = 0
            r9 = r9[r1]
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            r3 = 0
            if (r2 == 0) goto L_0x0012
            java.lang.String r9 = "AvidLoader: URL is empty"
            com.integralads.avid.library.inmobi.utils.AvidLogs.m35373e(r9)
            return r3
        L_0x0012:
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0074, IOException -> 0x0056, all -> 0x0053 }
            r2.<init>(r9)     // Catch:{ MalformedURLException -> 0x0074, IOException -> 0x0056, all -> 0x0053 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ MalformedURLException -> 0x0074, IOException -> 0x0056, all -> 0x0053 }
            r2.connect()     // Catch:{ MalformedURLException -> 0x0074, IOException -> 0x0056, all -> 0x0053 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x0074, IOException -> 0x0056, all -> 0x0053 }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ MalformedURLException -> 0x0074, IOException -> 0x0056, all -> 0x0053 }
            r4.<init>(r2)     // Catch:{ MalformedURLException -> 0x0074, IOException -> 0x0056, all -> 0x0053 }
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
        L_0x0031:
            int r6 = r4.read(r5)     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
            r7 = -1
            if (r6 == r7) goto L_0x0041
            java.lang.String r7 = new java.lang.String     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
            r7.<init>(r5, r1, r6)     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
            r2.write(r7)     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
            goto L_0x0031
        L_0x0041:
            java.lang.String r9 = r2.toString()     // Catch:{ MalformedURLException -> 0x0051, IOException -> 0x004f }
            r4.close()     // Catch:{ IOException -> 0x004a }
            return r9
        L_0x004a:
            r9 = move-exception
            com.integralads.avid.library.inmobi.utils.AvidLogs.m35374e(r0, r9)
            return r3
        L_0x004f:
            r9 = move-exception
            goto L_0x0058
        L_0x0051:
            r1 = move-exception
            goto L_0x0076
        L_0x0053:
            r9 = move-exception
            r4 = r3
            goto L_0x0094
        L_0x0056:
            r9 = move-exception
            r4 = r3
        L_0x0058:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "AvidLoader: IO error "
            r1.<init>(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = r9.getLocalizedMessage()     // Catch:{ all -> 0x0093 }
            r1.append(r9)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x0093 }
            com.integralads.avid.library.inmobi.utils.AvidLogs.m35373e(r9)     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x0072
            r4.close()     // Catch:{ IOException -> 0x004a }
        L_0x0072:
            return r3
        L_0x0074:
            r1 = move-exception
            r4 = r3
        L_0x0076:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "AvidLoader: something is wrong with the URL '"
            r1.<init>(r2)     // Catch:{ all -> 0x0093 }
            r1.append(r9)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = "'"
            r1.append(r9)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x0093 }
            com.integralads.avid.library.inmobi.utils.AvidLogs.m35373e(r9)     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x0091
            r4.close()     // Catch:{ IOException -> 0x004a }
        L_0x0091:
            return r3
        L_0x0093:
            r9 = move-exception
        L_0x0094:
            if (r4 == 0) goto L_0x0099
            r4.close()     // Catch:{ IOException -> 0x004a }
        L_0x0099:
            goto L_0x009c
        L_0x009b:
            throw r9
        L_0x009c:
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.integralads.avid.library.inmobi.DownloadAvidTask.doInBackground(java.lang.String[]):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (this.listener != null) {
            if (!TextUtils.isEmpty(str)) {
                this.listener.onLoadAvid(str);
                return;
            }
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
    public void invokeOnPostExecute(String str) {
        onPostExecute(str);
    }

    /* access modifiers changed from: 0000 */
    public void invokeOnCancelled() {
        onCancelled();
    }
}
