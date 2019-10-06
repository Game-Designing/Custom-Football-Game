package com.mopub.mraid;

import android.content.Context;
import android.widget.Toast;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.mraid.z */
/* compiled from: MraidNativeCommandHandler */
class C11509z implements C11481a {

    /* renamed from: a */
    final /* synthetic */ Context f35583a;

    /* renamed from: b */
    final /* synthetic */ C11483c f35584b;

    /* renamed from: c */
    final /* synthetic */ MraidNativeCommandHandler f35585c;

    C11509z(MraidNativeCommandHandler this$0, Context context, C11483c cVar) {
        this.f35585c = this$0;
        this.f35583a = context;
        this.f35584b = cVar;
    }

    public void onSuccess() {
        MoPubLog.log(SdkLogEvent.CUSTOM, "Image successfully saved.");
    }

    public void onFailure() {
        Toast.makeText(this.f35583a, "Image failed to download.", 0).show();
        String str = "Error downloading and saving image file.";
        MoPubLog.log(SdkLogEvent.CUSTOM, str);
        this.f35584b.onFailure(new C11493j(str));
    }
}
