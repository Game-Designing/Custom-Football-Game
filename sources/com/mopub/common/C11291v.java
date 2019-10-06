package com.mopub.common;

import com.mopub.common.ExternalViewabilitySession.VideoEvent;

/* renamed from: com.mopub.common.v */
/* compiled from: MoatViewabilitySession */
/* synthetic */ class C11291v {

    /* renamed from: a */
    static final /* synthetic */ int[] f34615a = new int[VideoEvent.values().length];

    static {
        try {
            f34615a[VideoEvent.AD_STARTED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f34615a[VideoEvent.AD_STOPPED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f34615a[VideoEvent.AD_PAUSED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f34615a[VideoEvent.AD_PLAYING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f34615a[VideoEvent.AD_SKIPPED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f34615a[VideoEvent.AD_VIDEO_FIRST_QUARTILE.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f34615a[VideoEvent.AD_VIDEO_MIDPOINT.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f34615a[VideoEvent.AD_VIDEO_THIRD_QUARTILE.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f34615a[VideoEvent.AD_COMPLETE.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f34615a[VideoEvent.AD_LOADED.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f34615a[VideoEvent.AD_IMPRESSED.ordinal()] = 11;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f34615a[VideoEvent.AD_CLICK_THRU.ordinal()] = 12;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f34615a[VideoEvent.RECORD_AD_ERROR.ordinal()] = 13;
        } catch (NoSuchFieldError e13) {
        }
    }
}
