package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import com.google.android.exoplayer2.drm.C8279d;

@TargetApi(16)
public interface DrmSession<T extends C8279d> {

    public static class DrmSessionException extends Exception {
    }

    /* renamed from: a */
    T mo25399a();

    DrmSessionException getError();

    int getState();
}
