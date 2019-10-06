package com.facebook.internal;

import com.facebook.C6817z;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.C6545b;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;

/* renamed from: com.facebook.internal.Z */
/* compiled from: WebDialog */
class C6707Z implements C6545b {

    /* renamed from: a */
    final /* synthetic */ String[] f12263a;

    /* renamed from: b */
    final /* synthetic */ int f12264b;

    /* renamed from: c */
    final /* synthetic */ CountDownLatch f12265c;

    /* renamed from: d */
    final /* synthetic */ C6706d f12266d;

    C6707Z(C6706d this$1, String[] strArr, int i, CountDownLatch countDownLatch) {
        this.f12266d = this$1;
        this.f12263a = strArr;
        this.f12264b = i;
        this.f12265c = countDownLatch;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        try {
            FacebookRequestError error = response.mo20227a();
            String str = "Error staging photo.";
            if (error != null) {
                String message = error.mo19662c();
                if (message == null) {
                    message = str;
                }
                throw new FacebookGraphResponseException(response, message);
            }
            JSONObject data = response.mo20228b();
            if (data != null) {
                String stagedImageUri = data.optString(DeepLinksKeys.URI);
                if (stagedImageUri != null) {
                    this.f12263a[this.f12264b] = stagedImageUri;
                    this.f12265c.countDown();
                    return;
                }
                throw new FacebookException(str);
            }
            throw new FacebookException(str);
        } catch (Exception e) {
            this.f12266d.f12261c[this.f12264b] = e;
        }
    }
}
