package com.vungle.warren.network;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.vungle.warren.network.Downloader.Listener;
import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import p019d.p314k.p315a.C13163f.C13164a;
import p019d.p314k.p315a.p317b.C13159c;

public class APKDirectDownloader extends FetchDownloader {
    private static final String TAG = "DirectDownloadManager";

    public APKDirectDownloader(Context context) {
        super(context);
        C13164a aVar = new C13164a(context);
        aVar.mo42223a(5);
        aVar.mo42224a(true);
        aVar.mo42225a();
    }

    public void pause() {
        HashMap<Long, Pair<Listener, File>> hashMap = this.operations;
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                long id = ((Long) entry.getKey()).longValue();
                this.fetch.mo42219c(id);
                StringBuilder sb = new StringBuilder();
                sb.append("fetch pause:");
                sb.append(id);
                Log.d(TAG, sb.toString());
            }
        }
    }

    public void resume() {
        HashMap<Long, Pair<Listener, File>> hashMap = this.operations;
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                long id = ((Long) entry.getKey()).longValue();
                C13159c info = this.fetch.mo42213a(id);
                if (info != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetch check for resume Status: ");
                    sb.append(info.mo42207h());
                    String sb2 = sb.toString();
                    String str = TAG;
                    Log.d(str, sb2);
                    if (info.mo42207h() == 904) {
                        this.fetch.mo42222e(id);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("fetch retry:");
                        sb3.append(id);
                        Log.d(str, sb3.toString());
                    } else {
                        this.fetch.mo42221d(id);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("fetch resume:");
                        sb4.append(id);
                        Log.d(str, sb4.toString());
                    }
                }
            }
        }
    }

    public void retry(long id) {
        HashMap<Long, Pair<Listener, File>> hashMap = this.operations;
        if (hashMap != null && hashMap.containsKey(Long.valueOf(id))) {
            this.fetch.mo42222e(id);
        }
    }

    /* access modifiers changed from: protected */
    public File downloadFolder() {
        File cacheDir = this.context.getExternalCacheDir();
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir.getPath());
        sb.append(File.separator);
        sb.append("downloads_vungle");
        return new File(sb.toString());
    }

    public boolean isDownloadTaskRunning() {
        HashMap<Long, Pair<Listener, File>> hashMap = this.operations;
        return hashMap != null && !hashMap.isEmpty();
    }
}
