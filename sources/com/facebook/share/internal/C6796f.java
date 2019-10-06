package com.facebook.share.internal;

import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.internal.C6694S;
import com.facebook.share.internal.C6794e.C6795a;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.f */
/* compiled from: ShareInternalUtility */
class C6796f implements C6795a {
    C6796f() {
    }

    /* renamed from: a */
    public JSONObject mo20153a(SharePhoto photo) {
        Uri photoUri = photo.mo20181a();
        if (C6694S.m13445d(photoUri)) {
            JSONObject photoJSONObject = new JSONObject();
            try {
                photoJSONObject.put("url", photoUri.toString());
                return photoJSONObject;
            } catch (JSONException e) {
                throw new FacebookException("Unable to attach images", e);
            }
        } else {
            throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
        }
    }
}
