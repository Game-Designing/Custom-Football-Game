package com.unity3d.services.core.cache;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.unity3d.services.core.api.Request;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.WebRequest;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;

class CacheThreadHandler extends Handler {
    private boolean _active = false;
    private boolean _canceled = false;
    private WebRequest _currentRequest = null;

    CacheThreadHandler() {
    }

    public void handleMessage(Message msg) {
        Bundle data = msg.getData();
        String str = "source";
        String source = data.getString(str);
        data.remove(str);
        String str2 = "target";
        String target = data.getString(str2);
        data.remove(str2);
        String str3 = "connectTimeout";
        int connectTimeout = data.getInt(str3);
        data.remove(str3);
        String str4 = "readTimeout";
        int readTimeout = data.getInt(str4);
        data.remove(str4);
        String str5 = "progressInterval";
        int progressInterval = data.getInt(str5);
        data.remove(str5);
        String str6 = AgentOptions.APPEND;
        boolean append = data.getBoolean(str6, false);
        data.remove(str6);
        HashMap hashMap = null;
        if (data.size() > 0) {
            DeviceLog.debug("There are headers left in data, reading them");
            hashMap = new HashMap();
            for (String k : data.keySet()) {
                hashMap.put(k, Arrays.asList(data.getStringArray(k)));
            }
        }
        File targetFile = new File(target);
        if ((!append || targetFile.exists()) && (append || !targetFile.exists())) {
            if (msg.what == 1) {
                downloadFile(source, target, connectTimeout, readTimeout, progressInterval, hashMap, append);
            }
            return;
        }
        this._active = false;
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.CACHE, CacheEvent.DOWNLOAD_ERROR, CacheError.FILE_STATE_WRONG, source, target, Boolean.valueOf(append), Boolean.valueOf(targetFile.exists()));
    }

    public void setCancelStatus(boolean canceled) {
        this._canceled = canceled;
        if (canceled) {
            WebRequest webRequest = this._currentRequest;
            if (webRequest != null) {
                this._active = false;
                webRequest.cancel();
            }
        }
    }

    public boolean isActive() {
        return this._active;
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v9, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r6v15, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r6v27 */
    /* JADX WARNING: type inference failed for: r6v28 */
    /* JADX WARNING: type inference failed for: r6v29 */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r6v31 */
    /* JADX WARNING: type inference failed for: r6v32 */
    /* JADX WARNING: type inference failed for: r6v33 */
    /* JADX WARNING: type inference failed for: r6v34 */
    /* JADX WARNING: type inference failed for: r6v35 */
    /* JADX WARNING: type inference failed for: r6v36 */
    /* JADX WARNING: type inference failed for: r6v37 */
    /* JADX WARNING: type inference failed for: r6v38 */
    /* JADX WARNING: type inference failed for: r6v39 */
    /* JADX WARNING: type inference failed for: r6v40 */
    /* JADX WARNING: type inference failed for: r6v41 */
    /* JADX WARNING: type inference failed for: r6v42 */
    /* JADX WARNING: type inference failed for: r6v43 */
    /* JADX WARNING: type inference failed for: r6v44 */
    /* JADX WARNING: type inference failed for: r6v45 */
    /* JADX WARNING: type inference failed for: r6v46 */
    /* JADX WARNING: type inference failed for: r6v47 */
    /* JADX WARNING: type inference failed for: r6v48 */
    /* JADX WARNING: type inference failed for: r6v49 */
    /* JADX WARNING: type inference failed for: r6v50 */
    /* JADX WARNING: type inference failed for: r6v51 */
    /* JADX WARNING: type inference failed for: r6v52 */
    /* JADX WARNING: type inference failed for: r6v53 */
    /* JADX WARNING: type inference failed for: r6v54 */
    /* JADX WARNING: type inference failed for: r6v55 */
    /* JADX WARNING: type inference failed for: r6v56 */
    /* JADX WARNING: type inference failed for: r6v57 */
    /* JADX WARNING: type inference failed for: r6v58 */
    /* JADX WARNING: type inference failed for: r6v59 */
    /* JADX WARNING: type inference failed for: r6v60 */
    /* JADX WARNING: type inference failed for: r6v61 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v2
      assigns: []
      uses: []
      mth insns count: 432
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0345 A[SYNTHETIC, Splitter:B:104:0x0345] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0375 A[SYNTHETIC, Splitter:B:113:0x0375] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ea A[SYNTHETIC, Splitter:B:60:0x01ea] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0242 A[SYNTHETIC, Splitter:B:71:0x0242] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0297 A[SYNTHETIC, Splitter:B:82:0x0297] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02ee A[SYNTHETIC, Splitter:B:93:0x02ee] */
    /* JADX WARNING: Unknown variable types count: 25 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadFile(java.lang.String r27, java.lang.String r28, int r29, int r30, int r31, java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r32, boolean r33) {
        /*
            r26 = this;
            r13 = r26
            r14 = r27
            r15 = r28
            r12 = r33
            java.lang.String r11 = "Error closing stream"
            boolean r0 = r13._canceled
            if (r0 != 0) goto L_0x039c
            if (r14 == 0) goto L_0x039c
            if (r15 != 0) goto L_0x0014
            goto L_0x039c
        L_0x0014:
            java.io.File r0 = new java.io.File
            r0.<init>(r15)
            r10 = r0
            java.lang.String r0 = " to "
            if (r12 == 0) goto L_0x004a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unity Ads cache: resuming download "
            r1.append(r2)
            r1.append(r14)
            r1.append(r0)
            r1.append(r15)
            java.lang.String r0 = " at "
            r1.append(r0)
            long r2 = r10.length()
            r1.append(r2)
            java.lang.String r0 = " bytes"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r0)
            goto L_0x0064
        L_0x004a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unity Ads cache: start downloading "
            r1.append(r2)
            r1.append(r14)
            r1.append(r0)
            r1.append(r15)
            java.lang.String r0 = r1.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r0)
        L_0x0064:
            boolean r0 = com.unity3d.services.core.device.Device.isActiveNetworkConnected()
            r8 = 2
            r9 = 1
            r5 = 0
            if (r0 != 0) goto L_0x0086
            java.lang.String r0 = "Unity Ads cache: download cancelled, no internet connection available"
            com.unity3d.services.core.log.DeviceLog.debug(r0)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r1 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r2 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r3 = new java.lang.Object[r8]
            com.unity3d.services.core.cache.CacheError r4 = com.unity3d.services.core.cache.CacheError.NO_INTERNET
            r3[r5] = r4
            r3[r9] = r14
            r0.sendEvent(r1, r2, r3)
            return
        L_0x0086:
            r13._active = r9
            long r16 = android.os.SystemClock.elapsedRealtime()
            r1 = 0
            r4 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0315, MalformedURLException -> 0x02be, IOException -> 0x0267, IllegalStateException -> 0x0212, NetworkIOException -> 0x01ba, all -> 0x01ab }
            r0.<init>(r10, r12)     // Catch:{ FileNotFoundException -> 0x0315, MalformedURLException -> 0x02be, IOException -> 0x0267, IllegalStateException -> 0x0212, NetworkIOException -> 0x01ba, all -> 0x01ab }
            r3 = r0
            r1 = r29
            r6 = r30
            r7 = r32
            com.unity3d.services.core.request.WebRequest r0 = r13.getWebRequest(r14, r1, r6, r7)     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            r13._currentRequest = r0     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            com.unity3d.services.core.cache.CacheThreadHandler$1 r2 = new com.unity3d.services.core.cache.CacheThreadHandler$1     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            r5 = r31
            r2.<init>(r10, r5)     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            r0.setProgressListener(r2)     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            long r20 = r0.makeStreamRequest(r3)     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            r6 = r20
            r2 = 0
            r13._active = r2     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            long r19 = r0.getContentLength()     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            boolean r0 = r0.isCanceled()     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            com.unity3d.services.core.request.WebRequest r2 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            int r22 = r2.getResponseCode()     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            com.unity3d.services.core.request.WebRequest r2 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            java.util.Map r23 = r2.getResponseHeaders()     // Catch:{ FileNotFoundException -> 0x019b, MalformedURLException -> 0x018b, IOException -> 0x017b, IllegalStateException -> 0x016b, NetworkIOException -> 0x015b, all -> 0x014c }
            r1 = r26
            r18 = r3
            r15 = 3
            r21 = 0
            r2 = r16
            r15 = r4
            r4 = r27
            r5 = r10
            r21 = 2
            r24 = 1
            r8 = r19
            r19 = r10
            r10 = r0
            r25 = r11
            r11 = r22
            r12 = r23
            r1.postProcessDownload(r2, r4, r5, r6, r8, r10, r11, r12)     // Catch:{ FileNotFoundException -> 0x0144, MalformedURLException -> 0x013c, IOException -> 0x0134, IllegalStateException -> 0x012c, NetworkIOException -> 0x0124, all -> 0x011d }
            r13._currentRequest = r15
            r18.close()     // Catch:{ Exception -> 0x00f5 }
            goto L_0x0119
        L_0x00f5:
            r0 = move-exception
            r1 = r0
            r0 = r1
            r2 = r25
            com.unity3d.services.core.log.DeviceLog.exception(r2, r0)
            com.unity3d.services.core.webview.WebViewApp r1 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r5 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r6 = 0
            r4[r6] = r5
            r4[r24] = r14
            java.lang.String r5 = r0.getMessage()
            r4[r21] = r5
            r1.sendEvent(r2, r3, r4)
        L_0x0119:
            r1 = r18
            goto L_0x036c
        L_0x011d:
            r0 = move-exception
            r2 = r25
            r6 = 0
            r1 = r0
            goto L_0x0371
        L_0x0124:
            r0 = move-exception
            r2 = r25
            r6 = 0
            r1 = r18
            goto L_0x01c4
        L_0x012c:
            r0 = move-exception
            r2 = r25
            r6 = 0
            r1 = r18
            goto L_0x021c
        L_0x0134:
            r0 = move-exception
            r2 = r25
            r6 = 0
            r1 = r18
            goto L_0x0271
        L_0x013c:
            r0 = move-exception
            r2 = r25
            r6 = 0
            r1 = r18
            goto L_0x02c8
        L_0x0144:
            r0 = move-exception
            r2 = r25
            r6 = 0
            r1 = r18
            goto L_0x031f
        L_0x014c:
            r0 = move-exception
            r18 = r3
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
            r1 = r0
            goto L_0x0371
        L_0x015b:
            r0 = move-exception
            r18 = r3
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
            r1 = r18
            goto L_0x01c4
        L_0x016b:
            r0 = move-exception
            r18 = r3
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
            r1 = r18
            goto L_0x021c
        L_0x017b:
            r0 = move-exception
            r18 = r3
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
            r1 = r18
            goto L_0x0271
        L_0x018b:
            r0 = move-exception
            r18 = r3
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
            r1 = r18
            goto L_0x02c8
        L_0x019b:
            r0 = move-exception
            r18 = r3
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
            r1 = r18
            goto L_0x031f
        L_0x01ab:
            r0 = move-exception
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
            r18 = r1
            r1 = r0
            goto L_0x0371
        L_0x01ba:
            r0 = move-exception
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
        L_0x01c4:
            java.lang.String r3 = "Network error"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x036d }
            r13._active = r6     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewApp r3 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewEventCategory r4 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheEvent r5 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x036d }
            r7 = 3
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.NETWORK_ERROR     // Catch:{ all -> 0x036d }
            r8[r6] = r7     // Catch:{ all -> 0x036d }
            r8[r24] = r14     // Catch:{ all -> 0x036d }
            java.lang.String r7 = r0.getMessage()     // Catch:{ all -> 0x036d }
            r8[r21] = r7     // Catch:{ all -> 0x036d }
            r3.sendEvent(r4, r5, r8)     // Catch:{ all -> 0x036d }
            r13._currentRequest = r15
            if (r1 == 0) goto L_0x0210
            r1.close()     // Catch:{ Exception -> 0x01ee }
            goto L_0x0210
        L_0x01ee:
            r0 = move-exception
            r3 = r0
            r0 = r3
            com.unity3d.services.core.log.DeviceLog.exception(r2, r0)
            com.unity3d.services.core.webview.WebViewApp r2 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r4 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r5[r6] = r7
            r5[r24] = r14
            java.lang.String r6 = r0.getMessage()
            r5[r21] = r6
            r2.sendEvent(r3, r4, r5)
        L_0x020e:
            goto L_0x036c
        L_0x0210:
            goto L_0x036c
        L_0x0212:
            r0 = move-exception
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
        L_0x021c:
            java.lang.String r3 = "Illegal state"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x036d }
            r13._active = r6     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewApp r3 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewEventCategory r4 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheEvent r5 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x036d }
            r7 = 3
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.ILLEGAL_STATE     // Catch:{ all -> 0x036d }
            r8[r6] = r7     // Catch:{ all -> 0x036d }
            r8[r24] = r14     // Catch:{ all -> 0x036d }
            java.lang.String r7 = r0.getMessage()     // Catch:{ all -> 0x036d }
            r8[r21] = r7     // Catch:{ all -> 0x036d }
            r3.sendEvent(r4, r5, r8)     // Catch:{ all -> 0x036d }
            r13._currentRequest = r15
            if (r1 == 0) goto L_0x0210
            r1.close()     // Catch:{ Exception -> 0x0246 }
            goto L_0x0210
        L_0x0246:
            r0 = move-exception
            r3 = r0
            r0 = r3
            com.unity3d.services.core.log.DeviceLog.exception(r2, r0)
            com.unity3d.services.core.webview.WebViewApp r2 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r4 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r5[r6] = r7
            r5[r24] = r14
            java.lang.String r6 = r0.getMessage()
            r5[r21] = r6
            r2.sendEvent(r3, r4, r5)
            goto L_0x020e
        L_0x0267:
            r0 = move-exception
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
        L_0x0271:
            java.lang.String r3 = "Couldn't request stream"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x036d }
            r13._active = r6     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewApp r3 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewEventCategory r4 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheEvent r5 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x036d }
            r7 = 3
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR     // Catch:{ all -> 0x036d }
            r8[r6] = r7     // Catch:{ all -> 0x036d }
            r8[r24] = r14     // Catch:{ all -> 0x036d }
            java.lang.String r7 = r0.getMessage()     // Catch:{ all -> 0x036d }
            r8[r21] = r7     // Catch:{ all -> 0x036d }
            r3.sendEvent(r4, r5, r8)     // Catch:{ all -> 0x036d }
            r13._currentRequest = r15
            if (r1 == 0) goto L_0x0210
            r1.close()     // Catch:{ Exception -> 0x029c }
            goto L_0x0210
        L_0x029c:
            r0 = move-exception
            r3 = r0
            r0 = r3
            com.unity3d.services.core.log.DeviceLog.exception(r2, r0)
            com.unity3d.services.core.webview.WebViewApp r2 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r4 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r5[r6] = r7
            r5[r24] = r14
            java.lang.String r6 = r0.getMessage()
            r5[r21] = r6
            r2.sendEvent(r3, r4, r5)
            goto L_0x020e
        L_0x02be:
            r0 = move-exception
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
        L_0x02c8:
            java.lang.String r3 = "Malformed URL"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x036d }
            r13._active = r6     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewApp r3 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewEventCategory r4 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheEvent r5 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x036d }
            r7 = 3
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.MALFORMED_URL     // Catch:{ all -> 0x036d }
            r8[r6] = r7     // Catch:{ all -> 0x036d }
            r8[r24] = r14     // Catch:{ all -> 0x036d }
            java.lang.String r7 = r0.getMessage()     // Catch:{ all -> 0x036d }
            r8[r21] = r7     // Catch:{ all -> 0x036d }
            r3.sendEvent(r4, r5, r8)     // Catch:{ all -> 0x036d }
            r13._currentRequest = r15
            if (r1 == 0) goto L_0x0210
            r1.close()     // Catch:{ Exception -> 0x02f3 }
            goto L_0x0210
        L_0x02f3:
            r0 = move-exception
            r3 = r0
            r0 = r3
            com.unity3d.services.core.log.DeviceLog.exception(r2, r0)
            com.unity3d.services.core.webview.WebViewApp r2 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r4 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r5[r6] = r7
            r5[r24] = r14
            java.lang.String r6 = r0.getMessage()
            r5[r21] = r6
            r2.sendEvent(r3, r4, r5)
            goto L_0x020e
        L_0x0315:
            r0 = move-exception
            r15 = r4
            r19 = r10
            r2 = r11
            r6 = 0
            r21 = 2
            r24 = 1
        L_0x031f:
            java.lang.String r3 = "Couldn't create target file"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x036d }
            r13._active = r6     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewApp r3 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.webview.WebViewEventCategory r4 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheEvent r5 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x036d }
            r7 = 3
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x036d }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR     // Catch:{ all -> 0x036d }
            r8[r6] = r7     // Catch:{ all -> 0x036d }
            r8[r24] = r14     // Catch:{ all -> 0x036d }
            java.lang.String r7 = r0.getMessage()     // Catch:{ all -> 0x036d }
            r8[r21] = r7     // Catch:{ all -> 0x036d }
            r3.sendEvent(r4, r5, r8)     // Catch:{ all -> 0x036d }
            r13._currentRequest = r15
            if (r1 == 0) goto L_0x0210
            r1.close()     // Catch:{ Exception -> 0x034a }
            goto L_0x0210
        L_0x034a:
            r0 = move-exception
            r3 = r0
            r0 = r3
            com.unity3d.services.core.log.DeviceLog.exception(r2, r0)
            com.unity3d.services.core.webview.WebViewApp r2 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r4 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r5[r6] = r7
            r5[r24] = r14
            java.lang.String r6 = r0.getMessage()
            r5[r21] = r6
            r2.sendEvent(r3, r4, r5)
            goto L_0x020e
        L_0x036c:
            return
        L_0x036d:
            r0 = move-exception
            r18 = r1
            r1 = r0
        L_0x0371:
            r13._currentRequest = r15
            if (r18 == 0) goto L_0x039a
            r18.close()     // Catch:{ Exception -> 0x0379 }
            goto L_0x039a
        L_0x0379:
            r0 = move-exception
            r3 = r0
            r0 = r3
            com.unity3d.services.core.log.DeviceLog.exception(r2, r0)
            com.unity3d.services.core.webview.WebViewApp r2 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r4 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r5[r6] = r7
            r5[r24] = r14
            java.lang.String r6 = r0.getMessage()
            r5[r21] = r6
            r2.sendEvent(r3, r4, r5)
            goto L_0x039b
        L_0x039a:
        L_0x039b:
            throw r1
        L_0x039c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.cache.CacheThreadHandler.downloadFile(java.lang.String, java.lang.String, int, int, int, java.util.HashMap, boolean):void");
    }

    private void postProcessDownload(long startTime, String source, File targetFile, long byteCount, long totalBytes, boolean canceled, int responseCode, Map<String, List<String>> responseHeaders) {
        String str = source;
        long duration = SystemClock.elapsedRealtime() - startTime;
        if (!targetFile.setReadable(true, false)) {
            DeviceLog.debug("Unity Ads cache: could not set file readable!");
        }
        if (!canceled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads cache: File ");
            sb.append(targetFile.getName());
            sb.append(" of ");
            sb.append(byteCount);
            sb.append(" bytes downloaded in ");
            sb.append(duration);
            sb.append("ms");
            DeviceLog.debug(sb.toString());
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.CACHE, CacheEvent.DOWNLOAD_END, str, Long.valueOf(byteCount), Long.valueOf(totalBytes), Long.valueOf(duration), Integer.valueOf(responseCode), Request.getResponseHeadersMap(responseHeaders));
            return;
        }
        long j = byteCount;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unity Ads cache: downloading of ");
        sb2.append(str);
        sb2.append(" stopped");
        DeviceLog.debug(sb2.toString());
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.CACHE, CacheEvent.DOWNLOAD_STOPPED, str, Long.valueOf(byteCount), Long.valueOf(totalBytes), Long.valueOf(duration), Integer.valueOf(responseCode), Request.getResponseHeadersMap(responseHeaders));
    }

    private WebRequest getWebRequest(String source, int connectTimeout, int readTimeout, HashMap<String, List<String>> headers) throws MalformedURLException {
        HashMap<String, List<String>> requestHeaders = new HashMap<>();
        if (headers != null) {
            requestHeaders.putAll(headers);
        }
        WebRequest webRequest = new WebRequest(source, "GET", requestHeaders, connectTimeout, readTimeout);
        return webRequest;
    }
}
