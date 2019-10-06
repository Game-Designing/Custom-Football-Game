package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.C8509F;
import com.mopub.common.AdType;

/* renamed from: com.google.android.exoplayer2.upstream.p */
/* compiled from: HttpDataSource */
public final /* synthetic */ class C8496p {
    /* renamed from: a */
    public static /* synthetic */ boolean m20373a(String contentType) {
        String contentType2 = C8509F.m20480g(contentType);
        return !TextUtils.isEmpty(contentType2) && (!contentType2.contains(CommandHandler.TEXT) || contentType2.contains("text/vtt")) && !contentType2.contains(AdType.HTML) && !contentType2.contains("xml");
    }
}
