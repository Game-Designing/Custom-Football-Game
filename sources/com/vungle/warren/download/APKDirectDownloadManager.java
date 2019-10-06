package com.vungle.warren.download;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.C0448aa.C0451c;
import android.support.p000v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.vungle.warren.NetworkStateReceiver;
import com.vungle.warren.locale.LocaleString;
import com.vungle.warren.network.APKDirectDownloader;
import com.vungle.warren.network.Downloader.Listener;
import com.vungle.warren.p267ui.VungleWebViewActivity;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class APKDirectDownloadManager {
    private static final String APK_POSTFIX = "apk";
    public static final int DIRECT_DOWNLOAD_FLAG_DISABLED = 0;
    public static final int DIRECT_DOWNLOAD_FLAG_ENABLED = 1;
    public static final int DIRECT_DOWNLOAD_FLAG_NOT_SET = -1;
    private static final String FOLDER_APK = "apk";
    private static final String FOLDER_NAME = "apks_vungle";
    private static final String NOTIFICATION_CHANNEL_ID = "1";
    private static final String NOTIFICATION_CHANNEL_NAME = "ApkDirectDownload";
    private static final String TAG = "DirectDownloadManager";
    /* access modifiers changed from: private */
    public static APKDirectDownloadManager _instance = new APKDirectDownloadManager();
    private int apkDirectDownloadStatus = -1;
    private WeakReference<Context> context;
    /* access modifiers changed from: private */
    public APKDirectDownloader downloader;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isNetworkReceiverEnabled = false;
    /* access modifiers changed from: private */
    public boolean isWifiEnabled = false;
    private C0451c mBuilder;
    /* access modifiers changed from: private */
    public List<Integer> notificationList = new ArrayList();
    private NotificationManager notifyManager;
    private List<String> pendingDownloadUrl = new ArrayList();
    private List<Integer> pendingNotificationList = new ArrayList();

    public static void init(Context context2) {
        _instance.context = new WeakReference<>(context2);
        _instance.clearDownloadApkCache();
        APKDirectDownloadManager aPKDirectDownloadManager = _instance;
        if (aPKDirectDownloadManager.downloader == null) {
            aPKDirectDownloadManager.downloader = new APKDirectDownloader(getContext());
        }
    }

    public static boolean isDirectDownloadEnabled(boolean clientFlag, boolean requiresSideLoading) {
        if (!_instance.checkExternalStorageAvailable()) {
            return false;
        }
        int i = _instance.apkDirectDownloadStatus;
        if (i != -1) {
            if (i != 1) {
                return false;
            }
            return requiresSideLoading;
        } else if (clientFlag) {
            return requiresSideLoading;
        } else {
            return false;
        }
    }

    public static void setDirectDownloadStatus(int status) {
        _instance.apkDirectDownloadStatus = status;
    }

    public static void download(String url) {
        enableNetworkListener(true, getContext());
        if (!TextUtils.isEmpty(url) && getContext() != null) {
            APKDirectDownloadManager aPKDirectDownloadManager = _instance;
            if (isApkUrl(url)) {
                try {
                    String identifier = String.valueOf(System.currentTimeMillis());
                    final int notificationId = identifier.hashCode();
                    if (_instance.isWifiEnabled()) {
                        _instance.notificationList.add(Integer.valueOf(notificationId));
                        final File destFile = _instance.getApkDirectory(identifier);
                        if (destFile == null) {
                            Log.e(TAG, "apk file is missing!");
                            _instance.openUrl(url);
                            return;
                        }
                        Toast.makeText(getContext(), LocaleString.getLocaleText(1), 1).show();
                        _instance.downloader.download(url, destFile, new Listener() {
                            public void onComplete(File file) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("download complete :");
                                sb.append(file.getAbsolutePath());
                                Log.d(APKDirectDownloadManager.TAG, sb.toString());
                                APKDirectDownloadManager._instance.installApk(destFile);
                                if (!APKDirectDownloadManager.isDownloadTaskRunning()) {
                                    APKDirectDownloadManager.enableNetworkListener(false, APKDirectDownloadManager.getContext());
                                }
                                APKDirectDownloadManager._instance.notificationList.remove(Integer.valueOf(notificationId));
                            }

                            public void onProgress(int progress, int status) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("download progress :");
                                sb.append(progress);
                                sb.append("status:");
                                sb.append(status);
                                sb.append(" wifienabled:");
                                sb.append(APKDirectDownloadManager._instance.isWifiEnabled);
                                Log.d(APKDirectDownloadManager.TAG, sb.toString());
                                if (status != 902 || !APKDirectDownloadManager._instance.isWifiEnabled) {
                                    APKDirectDownloadManager._instance.notifyProgress(notificationId, progress);
                                } else {
                                    APKDirectDownloadManager.resumeDownload();
                                }
                            }

                            public void onError(long id, Throwable throwable) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("download onError :");
                                sb.append(throwable.getMessage());
                                sb.append(" id:");
                                sb.append(id);
                                Log.d(APKDirectDownloadManager.TAG, sb.toString());
                                APKDirectDownloadManager._instance.dismissNotification(notificationId);
                                APKDirectDownloadManager._instance.notificationList.remove(Integer.valueOf(notificationId));
                            }
                        });
                    } else {
                        _instance.notifyProgress(notificationId, -1);
                        _instance.pendingNotificationList.add(Integer.valueOf(notificationId));
                        _instance.pendingDownloadUrl.add(url);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (getContext() != null) {
                Intent intent = new Intent();
                intent.setClass(getContext(), VungleWebViewActivity.class);
                intent.putExtra(VungleWebViewActivity.INTENT_URL, url);
                intent.setFlags(268435456);
                getContext().startActivity(intent);
            }
        }
    }

    public static boolean isApkUrl(String url) {
        return MimeTypeMap.getFileExtensionFromUrl(url).toLowerCase().endsWith("apk");
    }

    private void clearDownloadApkCache() {
        new Thread(new Runnable() {
            public void run() {
                File apkCacheFile = APKDirectDownloadManager.this.getCacheDirectory();
                if (apkCacheFile != null) {
                    File[] files = apkCacheFile.listFiles();
                    if (files != null && files.length != 0) {
                        for (int i = 0; i < files.length; i++) {
                            if (files[i].isFile() && files[i].exists() && files[i].isFile()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Clear cache:");
                                sb.append(files[i].getName());
                                Log.d(APKDirectDownloadManager.TAG, sb.toString());
                                files[i].delete();
                            }
                        }
                    }
                }
            }
        }).start();
    }

    private void openUrl(String url) {
        try {
            Intent i = Intent.parseUri(url, 0);
            i.setFlags(268435456);
            getContext().startActivity(i);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to start activity ");
            sb.append(e.getLocalizedMessage());
            Log.e(TAG, sb.toString());
        }
    }

    private File getApkDirectory(String identifier) {
        if (getCacheDirectory() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCacheDirectory().getPath());
        sb.append(File.separator);
        File folderDir = new File(sb.toString());
        if (!folderDir.exists()) {
            folderDir.mkdir();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getCacheDirectory().getPath());
        sb2.append(File.separator);
        sb2.append(identifier);
        sb2.append(".");
        sb2.append("apk");
        return new File(sb2.toString());
    }

    private boolean checkExternalStorageAvailable() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && getCacheDirectory() != null) {
                return true;
            }
        } catch (Exception ex) {
            StringBuilder sb = new StringBuilder();
            sb.append("Storage state error:");
            sb.append(ex.getMessage());
            Log.e(TAG, sb.toString());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public File getCacheDirectory() {
        if (getContext() == null) {
            return null;
        }
        File extCacheDir = getContext().getExternalCacheDir();
        if (extCacheDir == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(extCacheDir.getPath());
        sb.append(File.separator);
        sb.append(FOLDER_NAME);
        File dir = new File(sb.toString());
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    /* access modifiers changed from: private */
    public void installApk(File apkFile) {
        Context context2 = getContext();
        String str = TAG;
        if (context2 == null) {
            Log.e(str, "context is null");
            return;
        }
        Intent installApkIntent = new Intent();
        installApkIntent.setAction("android.intent.action.VIEW");
        installApkIntent.addCategory("android.intent.category.DEFAULT");
        installApkIntent.setFlags(268435456);
        String str2 = "application/vnd.android.package-archive";
        if (VERSION.SDK_INT > 23) {
            installApkIntent.setDataAndType(FileProvider.m2499a(getContext(), "com.vungle.download.provider", apkFile), str2);
            installApkIntent.addFlags(3);
        } else {
            installApkIntent.setDataAndType(Uri.fromFile(apkFile), str2);
        }
        if (getContext().getPackageManager().queryIntentActivities(installApkIntent, 0).size() > 0) {
            getContext().startActivity(installApkIntent);
        }
        String name = apkFile.getName();
        String identifier = name.substring(0, name.length() - 4);
        StringBuilder sb = new StringBuilder();
        sb.append("identifier is");
        sb.append(identifier);
        Log.d(str, sb.toString());
        dismissNotification(identifier.hashCode());
    }

    /* access modifiers changed from: private */
    public void notifyProgress(int notifyId, int progress) {
        StringBuilder sb = new StringBuilder();
        sb.append("notify id is :");
        sb.append(notifyId);
        sb.append(" progress:");
        sb.append(progress);
        String sb2 = sb.toString();
        String str = TAG;
        Log.d(str, sb2);
        if (getContext() == null) {
            Log.e(str, "context is null.");
            return;
        }
        if (this.notifyManager == null) {
            Context context2 = getContext();
            getContext();
            this.notifyManager = (NotificationManager) context2.getSystemService("notification");
            this.mBuilder = new C0451c(getContext());
            this.mBuilder.mo5120c(17301634);
            if (VERSION.SDK_INT >= 26) {
                String str2 = NOTIFICATION_CHANNEL_ID;
                this.notifyManager.createNotificationChannel(new NotificationChannel(str2, NOTIFICATION_CHANNEL_NAME, 2));
                this.mBuilder.mo5114a(str2);
            }
        }
        if (progress == -1 || !this.isWifiEnabled) {
            C0451c cVar = this.mBuilder;
            cVar.mo5121c((CharSequence) LocaleString.getLocaleText(4));
            cVar.mo5118b((CharSequence) LocaleString.getLocaleText(2));
            cVar.mo5107a(0, 0, false);
        } else if (progress < 0 || progress >= 100) {
            C0451c cVar2 = this.mBuilder;
            cVar2.mo5118b((CharSequence) LocaleString.getLocaleText(5));
            cVar2.mo5107a(0, 0, false);
        } else {
            C0451c cVar3 = this.mBuilder;
            cVar3.mo5121c((CharSequence) LocaleString.getLocaleText(4));
            cVar3.mo5118b((CharSequence) LocaleString.getLocaleText(3));
            this.mBuilder.mo5107a(100, progress, false);
        }
        this.notifyManager.notify(notifyId, this.mBuilder.mo5105a());
    }

    /* access modifiers changed from: private */
    public void dismissNotification(int identifier) {
        NotificationManager notificationManager = this.notifyManager;
        if (notificationManager != null) {
            notificationManager.cancel(identifier);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r2 != 9) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isWifiEnabled() {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = getContext()
            r2 = 0
            if (r1 != 0) goto L_0x0010
            java.lang.String r1 = "DirectDownloadManager"
            java.lang.String r3 = "context is null. "
            android.util.Log.e(r1, r3)
            return r2
        L_0x0010:
            android.content.Context r1 = getContext()
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            int r1 = android.support.p000v4.content.C0527k.m2618a(r1, r3)
            if (r1 != 0) goto L_0x0049
            android.content.Context r1 = getContext()
            getContext()
            java.lang.String r3 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r3)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            android.net.NetworkInfo r3 = r1.getActiveNetworkInfo()
            if (r3 != 0) goto L_0x0032
            return r2
        L_0x0032:
            int r2 = r3.getType()
            if (r2 == 0) goto L_0x0048
            r4 = 1
            if (r2 == r4) goto L_0x0046
            r4 = 6
            if (r2 == r4) goto L_0x0046
            r4 = 7
            if (r2 == r4) goto L_0x0048
            r4 = 9
            if (r2 == r4) goto L_0x0048
            goto L_0x0049
        L_0x0046:
            r0 = 1
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            r5.isWifiEnabled = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.download.APKDirectDownloadManager.isWifiEnabled():boolean");
    }

    public static void handleDownload(Context context2) {
        if (context2 != null) {
            boolean isConnected = false;
            if (_instance == null || !isDownloadTaskRunning() || _instance.apkDirectDownloadStatus == 0) {
                enableNetworkListener(false, context2);
                return;
            }
            NetworkInfo activeNetwork = ((ConnectivityManager) context2.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetwork != null && activeNetwork.isConnectedOrConnecting() && activeNetwork.getType() == 1) {
                isConnected = true;
            }
            if (isConnected && !_instance.isWifiEnabled) {
                resumeDownload();
            } else if (_instance.isWifiEnabled) {
                pauseDownload();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void resumeDownload() {
        APKDirectDownloadManager aPKDirectDownloadManager = _instance;
        aPKDirectDownloadManager.isWifiEnabled = true;
        aPKDirectDownloadManager.handler.postDelayed(new Runnable() {
            public void run() {
                APKDirectDownloadManager._instance.downloader.resume();
            }
        }, 300);
        if (!_instance.pendingNotificationList.isEmpty()) {
            for (Integer intValue : _instance.pendingNotificationList) {
                _instance.dismissNotification(intValue.intValue());
            }
        }
        if (!_instance.pendingDownloadUrl.isEmpty()) {
            for (String tmpUrl : _instance.pendingDownloadUrl) {
                download(tmpUrl);
            }
            _instance.pendingDownloadUrl.clear();
        }
    }

    /* access modifiers changed from: private */
    public static void pauseDownload() {
        APKDirectDownloadManager aPKDirectDownloadManager = _instance;
        aPKDirectDownloadManager.isWifiEnabled = false;
        aPKDirectDownloadManager.handler.postDelayed(new Runnable() {
            public void run() {
                APKDirectDownloadManager._instance.downloader.pause();
            }
        }, 300);
        for (Integer intValue : _instance.notificationList) {
            _instance.notifyProgress(intValue.intValue(), -1);
        }
    }

    private static void retryDownload(long id) {
        _instance.downloader.retry(id);
    }

    public static void enableNetworkListener(boolean enabled, Context context2) {
        APKDirectDownloadManager aPKDirectDownloadManager = _instance;
        if (aPKDirectDownloadManager.isNetworkReceiverEnabled != enabled && context2 != null) {
            aPKDirectDownloadManager.isNetworkReceiverEnabled = enabled;
            if (VERSION.SDK_INT >= 24) {
                NetworkCallback networkCallback = new NetworkCallback() {
                    public void onAvailable(Network network) {
                        super.onAvailable(network);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onAvailable:");
                        sb.append(network);
                        Log.d(APKDirectDownloadManager.TAG, sb.toString());
                        APKDirectDownloadManager.resumeDownload();
                        APKDirectDownloadManager._instance.isWifiEnabled = true;
                    }

                    public void onLost(Network network) {
                        super.onLost(network);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onLost:");
                        sb.append(network);
                        Log.d(APKDirectDownloadManager.TAG, sb.toString());
                        APKDirectDownloadManager.pauseDownload();
                        APKDirectDownloadManager._instance.isWifiEnabled = false;
                    }
                };
                ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                if (connectivityManager != null) {
                    if (enabled) {
                        try {
                            Builder builder = new Builder();
                            builder.addTransportType(1).addCapability(12);
                            connectivityManager.registerNetworkCallback(builder.build(), networkCallback);
                        } catch (Exception ex) {
                            Log.e(TAG, ex.getMessage());
                        }
                    } else {
                        connectivityManager.unregisterNetworkCallback(networkCallback);
                    }
                }
            } else if (enabled) {
                NetworkStateReceiver.enableBroadcastReceiver(context2, true);
            } else {
                NetworkStateReceiver.enableBroadcastReceiver(context2, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public static Context getContext() {
        APKDirectDownloadManager aPKDirectDownloadManager = _instance;
        if (aPKDirectDownloadManager != null) {
            WeakReference<Context> weakReference = aPKDirectDownloadManager.context;
            if (weakReference != null) {
                return (Context) weakReference.get();
            }
        }
        return null;
    }

    public static boolean isDownloadTaskRunning() {
        return !_instance.pendingDownloadUrl.isEmpty() || _instance.downloader.isDownloadTaskRunning();
    }
}
