package com.mopub.nativeads;

import com.mopub.nativeads.MediaLayout.Mode;
import com.mopub.nativeads.MediaLayout.MuteState;

/* renamed from: com.mopub.nativeads.C */
/* compiled from: MediaLayout */
/* synthetic */ class C11517C {

    /* renamed from: a */
    static final /* synthetic */ int[] f35621a = new int[MuteState.values().length];

    /* renamed from: b */
    static final /* synthetic */ int[] f35622b = new int[Mode.values().length];

    static {
        try {
            f35622b[Mode.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f35622b[Mode.LOADING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f35622b[Mode.BUFFERING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f35622b[Mode.PLAYING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f35622b[Mode.PAUSED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f35622b[Mode.FINISHED.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f35621a[MuteState.MUTED.ordinal()] = 1;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f35621a[MuteState.UNMUTED.ordinal()] = 2;
        } catch (NoSuchFieldError e8) {
        }
    }
}
