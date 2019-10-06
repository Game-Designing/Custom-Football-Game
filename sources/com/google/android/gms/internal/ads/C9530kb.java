package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.kb */
final class C9530kb implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ String f22636a;

    /* renamed from: b */
    private final /* synthetic */ String f22637b;

    /* renamed from: c */
    private final /* synthetic */ zzapu f22638c;

    C9530kb(zzapu zzapu, String str, String str2) {
        this.f22638c = zzapu;
        this.f22636a = str;
        this.f22637b = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.f22638c.f24557d.getSystemService("download");
        try {
            String str = this.f22636a;
            String str2 = this.f22637b;
            Request request = new Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzk.zzli();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException e) {
            this.f22638c.mo29991a("Could not store picture.");
        }
    }
}
