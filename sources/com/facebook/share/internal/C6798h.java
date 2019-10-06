package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.C6694S;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.h */
/* compiled from: WebDialogParameters */
public class C6798h {
    /* renamed from: a */
    public static Bundle m13862a(ShareLinkContent shareLinkContent) {
        Bundle params = m13861a((ShareContent) shareLinkContent);
        C6694S.m13417a(params, "href", shareLinkContent.mo20154a());
        C6694S.m13418a(params, "quote", shareLinkContent.mo20165c());
        return params;
    }

    /* renamed from: a */
    public static Bundle m13863a(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle params = m13861a((ShareContent) shareOpenGraphContent);
        C6694S.m13418a(params, "action_type", shareOpenGraphContent.mo20172c().mo20167c());
        try {
            JSONObject ogJSON = C6797g.m13860a(C6797g.m13859a(shareOpenGraphContent), false);
            if (ogJSON != null) {
                C6694S.m13418a(params, "action_properties", ogJSON.toString());
            }
            return params;
        } catch (JSONException e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }

    /* renamed from: a */
    public static Bundle m13861a(ShareContent shareContent) {
        Bundle params = new Bundle();
        ShareHashtag shareHashtag = shareContent.mo20155b();
        if (shareHashtag != null) {
            C6694S.m13418a(params, "hashtag", shareHashtag.mo20158a());
        }
        return params;
    }
}
