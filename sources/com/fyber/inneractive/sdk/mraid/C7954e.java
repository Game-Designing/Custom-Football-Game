package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.p179l.C7930d;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.mraid.e */
public final class C7954e {

    /* renamed from: a */
    protected static C7954e f16232a = new C7954e();

    /* renamed from: com.fyber.inneractive.sdk.mraid.e$1 */
    static /* synthetic */ class C79551 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16233a = new int[C7956a.values().length];

        static {
            try {
                f16233a[C7956a.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16233a[C7956a.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16233a[C7956a.USECUSTOMCLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16233a[C7956a.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16233a[C7956a.RESIZE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f16233a[C7956a.GET_RESIZE_PROPERTIES.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f16233a[C7956a.SET_RESIZE_PROPERTIES.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f16233a[C7956a.SET_ORIENTATION_PROPERTIES.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f16233a[C7956a.PLAY_VIDEO.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f16233a[C7956a.STORE_PICTURE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f16233a[C7956a.GET_CURRENT_POSITION.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f16233a[C7956a.GET_DEFAULT_POSITION.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f16233a[C7956a.GET_MAX_SIZE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f16233a[C7956a.GET_SCREEN_SIZE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f16233a[C7956a.CREATE_CALENDAR_EVENT.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f16233a[C7956a.UNSPECIFIED.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.mraid.e$a */
    public enum C7956a {
        CLOSE("close"),
        EXPAND("expand"),
        USECUSTOMCLOSE("usecustomclose"),
        OPEN("open"),
        RESIZE("resize"),
        GET_RESIZE_PROPERTIES("getResizeProperties"),
        SET_RESIZE_PROPERTIES("setResizeProperties"),
        SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
        PLAY_VIDEO("playVideo"),
        STORE_PICTURE("storePicture"),
        GET_CURRENT_POSITION("getCurrentPosition"),
        GET_DEFAULT_POSITION("getDefaultPosition"),
        GET_MAX_SIZE("getMaxSize"),
        GET_SCREEN_SIZE("getScreenSize"),
        CREATE_CALENDAR_EVENT("createCalendarEvent"),
        UNSPECIFIED("");
        

        /* renamed from: q */
        public String f16251q;

        private C7956a(String str) {
            this.f16251q = str;
        }
    }

    /* renamed from: a */
    public static C7950a m17978a(String str, Map<String, String> map, C7930d dVar) {
        switch (C79551.f16233a[C7956a.m17979a(str).ordinal()]) {
            case 1:
                return new C7951b(map, dVar);
            case 2:
                return new C7953d(map, dVar);
            case 3:
                return new C7968q(map, dVar);
            case 4:
                return new C7962k(map, dVar);
            case 5:
                return new C7964m(map, dVar);
            case 6:
                return new C7960i(map, dVar);
            case 7:
                return new C7966o(map, dVar);
            case 8:
                return new C7965n(map, dVar);
            case 9:
                return new C7963l(map, dVar);
            case 10:
                return new C7967p(map, dVar);
            case 11:
                return new C7957f(map, dVar);
            case 12:
                return new C7958g(map, dVar);
            case 13:
                return new C7959h(map, dVar);
            case 14:
                return new C7961j(map, dVar);
            case 15:
                return new C7952c(map, dVar);
            case 16:
                return null;
            default:
                return null;
        }
    }
}
