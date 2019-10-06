package com.fyber.inneractive.sdk.mraid;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.fyber.inneractive.sdk.mraid.C7954e.C7956a;
import com.fyber.inneractive.sdk.p179l.C7930d;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;

/* renamed from: com.fyber.inneractive.sdk.mraid.p */
final class C7967p extends C7950a {
    public C7967p(Map<String, String> map, C7930d dVar) {
        super(map, dVar);
    }

    /* renamed from: a */
    public final void mo24813a() {
        String b = mo24814b(DeepLinksKeys.URI);
        if (b == null || "".equals(b)) {
            this.f16231c.mo24770a(C7956a.STORE_PICTURE, "Image can't be stored with null or empty URL");
            IAlog.m18021b("Mraid Store Picture -Invalid URI ");
            return;
        }
        C7930d dVar = this.f16231c;
        Context s = dVar.mo24784s();
        if (!C8005i.m18061j()) {
            dVar.mo24770a(C7956a.STORE_PICTURE, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            IAlog.m18021b("Error downloading file. Please check if the Android permission is not granted, or maybe the device does not have an SD card mounted? ");
        } else if (s instanceof Activity) {
            new Builder(dVar.mo24784s()).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new OnClickListener(b) {

                /* renamed from: a */
                final /* synthetic */ String f16202a;

                {
                    this.f16202a = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    C7930d.this.mo24778h(this.f16202a);
                }
            }).setCancelable(true).show();
        } else {
            dVar.mo24777g("Downloading image to Picture gallery...");
            dVar.mo24778h(b);
        }
    }

    /* renamed from: b */
    public final boolean mo24815b() {
        return true;
    }
}
