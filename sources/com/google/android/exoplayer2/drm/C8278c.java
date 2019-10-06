package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;
import com.google.android.exoplayer2.drm.C8279d;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.drm.c */
/* compiled from: DrmSessionManager */
public interface C8278c<T extends C8279d> {
    /* renamed from: a */
    DrmSession<T> mo25406a(Looper looper, DrmInitData drmInitData);

    /* renamed from: a */
    void mo25407a(DrmSession<T> drmSession);

    /* renamed from: a */
    boolean mo25408a(DrmInitData drmInitData);
}
