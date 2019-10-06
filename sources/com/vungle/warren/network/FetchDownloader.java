package com.vungle.warren.network;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.network.Downloader.Listener;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.UnzipUtility;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import p019d.p314k.p315a.C13163f;
import p019d.p314k.p315a.C13163f.C13164a;
import p019d.p314k.p315a.p316a.C13155a;
import p019d.p314k.p315a.p317b.C13158b;

public class FetchDownloader implements Downloader, C13155a {
    protected static final String DOWNLOADS_FOLDER = "downloads_vungle";
    private static final String TAG = FetchDownloader.class.getSimpleName();
    protected Context context;
    private int downloadCount = 0;
    protected C13163f fetch;
    protected HashMap<Long, Pair<Listener, File>> operations;

    public FetchDownloader(Context context2) {
        this.fetch = C13163f.m42988a(context2);
        this.fetch.mo42214a((C13155a) this);
        this.fetch.mo42220d();
        this.operations = new HashMap<>();
        this.context = context2;
        C13164a aVar = new C13164a(context2);
        aVar.mo42224a(true);
        aVar.mo42225a();
    }

    public boolean download(String url, File destination, Listener listener) throws IOException, IllegalArgumentException, IllegalStateException {
        if (destination.exists()) {
            try {
                if (!destination.delete()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to delete file at ");
                    sb.append(destination.getAbsolutePath());
                    throw new IOException(sb.toString());
                }
            } catch (SecurityException secErr) {
                throw new IOException(secErr);
            }
        }
        if (!this.fetch.mo42217b()) {
            Context context2 = this.context;
            if (context2 != null) {
                this.fetch = C13163f.m42988a(context2);
                this.fetch.mo42214a((C13155a) this);
            } else {
                throw new IllegalStateException("Context is null, application is no longer running");
            }
        }
        String path = downloadFolder().getPath();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(destination.getName());
        sb2.append(" (");
        int i = this.downloadCount;
        this.downloadCount = i + 1;
        sb2.append(i);
        sb2.append(")");
        this.operations.put(Long.valueOf(this.fetch.mo42212a(new C13158b(url, path, sb2.toString()))), new Pair(listener, destination));
        return true;
    }

    /* access modifiers changed from: protected */
    public File downloadFolder() {
        File cacheDir = this.context.getCacheDir();
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir.getPath());
        sb.append(File.separator);
        sb.append(DOWNLOADS_FOLDER);
        return new File(sb.toString());
    }

    public void onUpdate(long id, int status, int progress, long downloadedBytes, long fileSize, int error) {
        long j = id;
        int i = progress;
        int i2 = error;
        Log.d("FetchDownloader", String.format(Locale.ENGLISH, "%s: %d%% completed, %d/%d , error: %d", new Object[]{Long.valueOf(id), Integer.valueOf(progress), Long.valueOf(downloadedBytes), Long.valueOf(fileSize), Integer.valueOf(error)}));
        if (this.operations.containsKey(Long.valueOf(id))) {
            Listener processor = (Listener) ((Pair) this.operations.get(Long.valueOf(id))).first;
            File dest = (File) ((Pair) this.operations.get(Long.valueOf(id))).second;
            if (processor == null) {
                int i3 = status;
            } else if (dest == null) {
                int i4 = status;
            } else {
                processor.onProgress(i, status);
                if (i2 != -1) {
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("error: ");
                    sb.append(i2);
                    Log.e(str, sb.toString());
                    processor.onError(j, new IOException("Error downloading !!!"));
                }
                if (i == 100) {
                    File downloaded = this.fetch.mo42216b(j);
                    if (downloaded == null) {
                        processor.onError(j, new IOException("Downloaded file not found!"));
                        return;
                    }
                    File parent = dest.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdir();
                    }
                    if (downloaded.renameTo(dest)) {
                        if (dest.getName().equals(Advertisement.KEY_POSTROLL)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(dest.getParent());
                            sb2.append(File.separator);
                            sb2.append(Advertisement.POSTROLL_UNZIP);
                            try {
                                UnzipUtility.unzip(dest.getPath(), new File(sb2.toString()).getPath());
                            } catch (IOException e) {
                                Log.e(TAG, "Error on unzipping assets", e);
                            }
                            try {
                                FileUtility.delete(dest);
                            } catch (IOException e2) {
                                Log.e(TAG, "Error on deleting zip assets archive", e2);
                            }
                        }
                        processor.onComplete(dest.getParentFile());
                        this.operations.remove(Long.valueOf(id));
                    } else {
                        processor.onError(j, new IOException("Error processing file to destination directory!"));
                    }
                    if (this.operations.isEmpty()) {
                        this.fetch.mo42218c();
                    }
                }
            }
        }
    }

    public void pause() {
    }

    public void resume() {
    }

    public void retry(long id) {
    }
}
