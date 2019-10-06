package com.inmobi.ads;

import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10700d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class NativeTracker {

    /* renamed from: e */
    private static final String f31376e = NativeTracker.class.getSimpleName();

    /* renamed from: a */
    String f31377a;

    /* renamed from: b */
    TrackerEventType f31378b;

    /* renamed from: c */
    Map<String, String> f31379c;

    /* renamed from: d */
    Map<String, Object> f31380d;

    /* renamed from: f */
    private String f31381f;

    /* renamed from: g */
    private int f31382g;

    /* renamed from: com.inmobi.ads.NativeTracker$1 */
    static /* synthetic */ class C103291 {

        /* renamed from: a */
        static final /* synthetic */ int[] f31383a = new int[TrackerEventType.values().length];

        static {
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_LOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_CLIENT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_RENDER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_VIDEO_RENDER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_PAGE_VIEW.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_CLICK.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_PLAY.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_Q1.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_Q2.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_Q3.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_Q4.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_FULLSCREEN.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_EXIT_FULLSCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_MUTE.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_UNMUTE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_PAUSE.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_RESUME.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_ERROR.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_IAS.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_MOAT.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f31383a[TrackerEventType.TRACKER_EVENT_TYPE_END_CARD_CLOSE.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
        }
    }

    enum TrackerEventType {
        TRACKER_EVENT_TYPE_UNKNOWN,
        TRACKER_EVENT_TYPE_LOAD,
        TRACKER_EVENT_TYPE_CLIENT_FILL,
        TRACKER_EVENT_TYPE_RENDER,
        TRACKER_EVENT_TYPE_PAGE_VIEW,
        TRACKER_EVENT_TYPE_CLICK,
        TRACKER_EVENT_TYPE_VIDEO_RENDER,
        TRACKER_EVENT_TYPE_FALLBACK_URL,
        TRACKER_EVENT_TYPE_PLAY,
        TRACKER_EVENT_TYPE_Q1,
        TRACKER_EVENT_TYPE_Q2,
        TRACKER_EVENT_TYPE_Q3,
        TRACKER_EVENT_TYPE_Q4,
        TRACKER_EVENT_TYPE_CREATIVE_VIEW,
        TRACKER_EVENT_TYPE_FULLSCREEN,
        TRACKER_EVENT_TYPE_EXIT_FULLSCREEN,
        TRACKER_EVENT_TYPE_MUTE,
        TRACKER_EVENT_TYPE_UNMUTE,
        TRACKER_EVENT_TYPE_PAUSE,
        TRACKER_EVENT_TYPE_RESUME,
        TRACKER_EVENT_TYPE_ERROR,
        TRACKER_EVENT_TYPE_END_CARD_CLOSE,
        TRACKER_EVENT_TYPE_CUSTOM_EVENT_VIDEO,
        TRACKER_EVENT_TYPE_IAS,
        TRACKER_EVENT_TYPE_MOAT,
        TRACKER_EVENT_TYPE_DOWNLOADER_INIT,
        TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING,
        TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED,
        TRACKER_EVENT_TYPE_DOWNLOADER_ERROR
    }

    public NativeTracker(String str, int i, TrackerEventType trackerEventType, Map<String, String> map) {
        this("url_ping", str, i, trackerEventType, map);
    }

    private NativeTracker(String str, String str2, int i, TrackerEventType trackerEventType, Map<String, String> map) {
        this.f31381f = str;
        this.f31377a = str2.trim();
        this.f31382g = i;
        this.f31378b = trackerEventType;
        this.f31379c = map;
    }

    /* renamed from: a */
    static NativeTracker m33703a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("type");
            if (string != null) {
                if (string.length() != 0) {
                    String lowerCase = string.toLowerCase(Locale.US);
                    switch (lowerCase.hashCode()) {
                        case -1918378017:
                            boolean equals = lowerCase.equals("html_script");
                            break;
                        case -970292670:
                            boolean equals2 = lowerCase.equals("url_ping");
                            break;
                        case -284840886:
                            boolean equals3 = lowerCase.equals("unknown");
                            break;
                        case 2015859192:
                            lowerCase.equals("webview_ping");
                            break;
                    }
                }
            }
            return new NativeTracker(jSONObject.getString("url"), jSONObject.optInt("eventId", -1), m33702a(jSONObject.getString("eventType")), new HashMap());
        } catch (JSONException e) {
            new StringBuilder("Error building tracker from JSONObject; ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
            return null;
        }
    }

    /* renamed from: a */
    static TrackerEventType m33702a(String str) {
        if (str == null || str.length() == 0) {
            return TrackerEventType.TRACKER_EVENT_TYPE_UNKNOWN;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1638835128:
                if (str.equals("midpoint")) {
                    c = 10;
                    break;
                }
                break;
            case -1337830390:
                if (str.equals("thirdQuartile")) {
                    c = 11;
                    break;
                }
                break;
            case -934426579:
                if (str.equals("resume")) {
                    c = 19;
                    break;
                }
                break;
            case -840405966:
                if (str.equals("unmute")) {
                    c = 17;
                    break;
                }
                break;
            case -667101923:
                if (str.equals("zMoatVASTIDs")) {
                    c = 22;
                    break;
                }
                break;
            case -599445191:
                if (str.equals("complete")) {
                    c = 12;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    c = 1;
                    break;
                }
                break;
            case -174104201:
                if (str.equals("client_fill")) {
                    c = 3;
                    break;
                }
                break;
            case -45894975:
                if (str.equals("IAS_VIEWABILITY")) {
                    c = 21;
                    break;
                }
                break;
            case 3327206:
                if (str.equals("load")) {
                    c = 2;
                    break;
                }
                break;
            case 3363353:
                if (str.equals("mute")) {
                    c = 16;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c = 7;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 20;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c = 18;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 8;
                    break;
                }
                break;
            case 110066619:
                if (str.equals("fullscreen")) {
                    c = 14;
                    break;
                }
                break;
            case 113951609:
                if (str.equals("exitFullscreen")) {
                    c = 15;
                    break;
                }
                break;
            case 354294980:
                if (str.equals("VideoImpression")) {
                    c = 5;
                    break;
                }
                break;
            case 560220243:
                if (str.equals("firstQuartile")) {
                    c = 9;
                    break;
                }
                break;
            case 883937877:
                if (str.equals("page_view")) {
                    c = 6;
                    break;
                }
                break;
            case 1342121331:
                if (str.equals("closeEndCard")) {
                    c = 23;
                    break;
                }
                break;
            case 1778167540:
                if (str.equals("creativeView")) {
                    c = 13;
                    break;
                }
                break;
            case 2114088489:
                if (str.equals("Impression")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 2:
                return TrackerEventType.TRACKER_EVENT_TYPE_LOAD;
            case 3:
                return TrackerEventType.TRACKER_EVENT_TYPE_CLIENT_FILL;
            case 4:
                return TrackerEventType.TRACKER_EVENT_TYPE_RENDER;
            case 5:
                return TrackerEventType.TRACKER_EVENT_TYPE_VIDEO_RENDER;
            case 6:
                return TrackerEventType.TRACKER_EVENT_TYPE_PAGE_VIEW;
            case 7:
                return TrackerEventType.TRACKER_EVENT_TYPE_CLICK;
            case 8:
                return TrackerEventType.TRACKER_EVENT_TYPE_PLAY;
            case 9:
                return TrackerEventType.TRACKER_EVENT_TYPE_Q1;
            case 10:
                return TrackerEventType.TRACKER_EVENT_TYPE_Q2;
            case 11:
                return TrackerEventType.TRACKER_EVENT_TYPE_Q3;
            case 12:
                return TrackerEventType.TRACKER_EVENT_TYPE_Q4;
            case 13:
                return TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW;
            case 14:
                return TrackerEventType.TRACKER_EVENT_TYPE_FULLSCREEN;
            case 15:
                return TrackerEventType.TRACKER_EVENT_TYPE_EXIT_FULLSCREEN;
            case 16:
                return TrackerEventType.TRACKER_EVENT_TYPE_MUTE;
            case 17:
                return TrackerEventType.TRACKER_EVENT_TYPE_UNMUTE;
            case 18:
                return TrackerEventType.TRACKER_EVENT_TYPE_PAUSE;
            case 19:
                return TrackerEventType.TRACKER_EVENT_TYPE_RESUME;
            case 20:
                return TrackerEventType.TRACKER_EVENT_TYPE_ERROR;
            case 21:
                return TrackerEventType.TRACKER_EVENT_TYPE_IAS;
            case 22:
                return TrackerEventType.TRACKER_EVENT_TYPE_MOAT;
            case 23:
                return TrackerEventType.TRACKER_EVENT_TYPE_END_CARD_CLOSE;
            default:
                return TrackerEventType.TRACKER_EVENT_TYPE_UNKNOWN;
        }
    }

    public final String toString() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f31381f);
            jSONObject.put("url", this.f31377a);
            String str2 = "eventType";
            switch (C103291.f31383a[this.f31378b.ordinal()]) {
                case 2:
                    str = "load";
                    break;
                case 3:
                    str = "client_fill";
                    break;
                case 4:
                    str = "Impression";
                    break;
                case 5:
                    str = "VideoImpression";
                    break;
                case 6:
                    str = "page_view";
                    break;
                case 7:
                    str = "click";
                    break;
                case 8:
                    str = "start";
                    break;
                case 9:
                    str = "firstQuartile";
                    break;
                case 10:
                    str = "midpoint";
                    break;
                case 11:
                    str = "thirdQuartile";
                    break;
                case 12:
                    str = "complete";
                    break;
                case 13:
                    str = "creativeView";
                    break;
                case 14:
                    str = "fullscreen";
                    break;
                case 15:
                    str = "exitFullscreen";
                    break;
                case 16:
                    str = "mute";
                    break;
                case 17:
                    str = "unmute";
                    break;
                case 18:
                    str = "pause";
                    break;
                case 19:
                    str = "resume";
                    break;
                case 20:
                    str = "error";
                    break;
                case 21:
                    str = "IAS_VIEWABILITY";
                    break;
                case 22:
                    str = "zMoatVASTIDs";
                    break;
                case 23:
                    str = "closeEndCard";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            jSONObject.put(str2, str);
            jSONObject.put("eventId", this.f31382g);
            jSONObject.put("extras", C10700d.m35143a(this.f31379c == null ? new HashMap<>() : this.f31379c, ","));
            return jSONObject.toString();
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("Error serializing an ");
            sb.append(f31376e);
            sb.append(" instance (");
            sb.append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
            return "";
        }
    }
}
