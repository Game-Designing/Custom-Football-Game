package com.mopub.nativeads;

import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.VideoState;

/* renamed from: com.mopub.nativeads.O */
/* compiled from: MoPubCustomEventVideoNative */
/* synthetic */ class C11559O {

    /* renamed from: a */
    static final /* synthetic */ int[] f36003a = new int[C11547a.values().length];

    /* renamed from: b */
    static final /* synthetic */ int[] f36004b = new int[VideoState.values().length];

    static {
        try {
            f36004b[VideoState.FAILED_LOAD.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f36004b[VideoState.CREATED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f36004b[VideoState.LOADING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f36004b[VideoState.BUFFERING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f36004b[VideoState.PAUSED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f36004b[VideoState.PLAYING.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f36004b[VideoState.PLAYING_MUTED.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f36004b[VideoState.ENDED.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f36003a[C11547a.IMPRESSION_TRACKER.ordinal()] = 1;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f36003a[C11547a.TITLE.ordinal()] = 2;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f36003a[C11547a.TEXT.ordinal()] = 3;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f36003a[C11547a.IMAGE_URL.ordinal()] = 4;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f36003a[C11547a.ICON_URL.ordinal()] = 5;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f36003a[C11547a.CLICK_DESTINATION.ordinal()] = 6;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f36003a[C11547a.CLICK_TRACKER.ordinal()] = 7;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f36003a[C11547a.CALL_TO_ACTION.ordinal()] = 8;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f36003a[C11547a.VAST_VIDEO.ordinal()] = 9;
        } catch (NoSuchFieldError e17) {
        }
        try {
            f36003a[C11547a.PRIVACY_INFORMATION_ICON_IMAGE_URL.ordinal()] = 10;
        } catch (NoSuchFieldError e18) {
        }
        try {
            f36003a[C11547a.PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL.ordinal()] = 11;
        } catch (NoSuchFieldError e19) {
        }
    }
}
