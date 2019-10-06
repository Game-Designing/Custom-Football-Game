package com.inmobi.rendering.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import com.google.android.gms.plus.PlusShare;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.rendering.RenderView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.i */
/* compiled from: SystemTasksProcessor */
public class C10787i {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f32964b = C10787i.class.getSimpleName();

    /* renamed from: a */
    public RenderView f32965a;

    /* renamed from: c */
    private C10789a f32966c;

    /* renamed from: com.inmobi.rendering.mraid.i$a */
    /* compiled from: SystemTasksProcessor */
    static final class C10789a extends Handler {

        /* renamed from: a */
        private static final String f32974a = C10789a.class.getSimpleName();

        /* renamed from: b */
        private WeakReference<RenderView> f32975b;

        public C10789a(Looper looper, RenderView renderView) {
            super(looper);
            this.f32975b = new WeakReference<>(renderView);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                String str = (String) message.obj;
                RenderView renderView = (RenderView) this.f32975b.get();
                if (renderView != null) {
                    renderView.mo34556a(str, "broadcastEvent('vibrateComplete');");
                }
            }
        }
    }

    public C10787i(RenderView renderView) {
        this.f32965a = renderView;
        HandlerThread handlerThread = new HandlerThread("SystemTasksHandlerThread");
        handlerThread.start();
        this.f32966c = new C10789a(handlerThread.getLooper(), renderView);
    }

    /* renamed from: a */
    public static boolean m35364a() {
        try {
            PlusShare.class.getName();
            return true;
        } catch (NoClassDefFoundError e) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m35363a(Context context, int i, String str, String str2, String str3) {
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str5 = " ";
        sb.append(str5);
        sb.append(str2);
        sb.append(str5);
        sb.append(str3);
        String sb2 = sb.toString();
        String str6 = "UTF-8";
        if (i == 1) {
            StringBuilder sb3 = new StringBuilder("https://www.facebook.com/dialog/feed?app_id=181821551957328&link=");
            sb3.append(URLEncoder.encode(str2, str6));
            sb3.append("&picture=");
            sb3.append(URLEncoder.encode(str3, str6));
            sb3.append("&name=&description=");
            sb3.append(URLEncoder.encode(str, str6));
            sb3.append("&redirect_uri=");
            sb3.append(URLEncoder.encode(str2, str6));
            str4 = sb3.toString();
        } else if (i == 2) {
            StringBuilder sb4 = new StringBuilder("https://m.google.com/app/plus/x/?v=compose&content=");
            sb4.append(URLEncoder.encode(sb2, str6));
            str4 = sb4.toString();
        } else if (i != 3) {
            str4 = null;
        } else {
            try {
                StringBuilder sb5 = new StringBuilder("http://twitter.com/home?status=");
                sb5.append(URLEncoder.encode(sb2, str6));
                str4 = sb5.toString();
            } catch (UnsupportedEncodingException e) {
                return;
            }
        }
        if (str4 != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str4));
            try {
                C10619a.m34834a(context, intent);
            } catch (ActivityNotFoundException e2) {
                e2.getMessage();
            }
        } else {
            Intent intent2 = new Intent();
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.TEXT", sb2);
            try {
                C10619a.m34834a(context, intent2);
            } catch (ActivityNotFoundException e3) {
                e3.getMessage();
            }
        }
    }

    /* renamed from: a */
    public final void mo34789a(Context context) {
        C10789a aVar = this.f32966c;
        if (aVar != null && aVar.hasMessages(1)) {
            this.f32966c.removeMessages(1);
            ((Vibrator) context.getSystemService("vibrator")).cancel();
        }
    }

    /* renamed from: a */
    public static String m35362a(String str) {
        String str2 = ";";
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        if (str.length() == 0) {
            return str3;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("frequency");
            if (optString == null || str3.equals(optString)) {
                return str3;
            }
            String str4 = "weekly";
            String str5 = "yearly";
            String str6 = "monthly";
            if (!"daily".equals(optString)) {
                if (!str4.equals(optString) && !str6.equals(optString)) {
                    if (!str5.equals(optString)) {
                        return str3;
                    }
                }
            }
            sb.append("freq=");
            sb.append(optString);
            sb.append(str2);
            String optString2 = jSONObject.optString("interval");
            if (optString2 != null && !str3.equals(optString2)) {
                sb.append("interval=");
                sb.append(Integer.parseInt(optString2));
                sb.append(str2);
            }
            String a = C10777a.m35345a(jSONObject.optString("expires"));
            if (a != null) {
                sb.append("until=");
                sb.append(a.replace("+", "Z+").replace("-", "Z-"));
                sb.append(str2);
            }
            if (optString.equals(str4)) {
                String a2 = C10777a.m35346a(jSONObject.optJSONArray("daysInWeek"));
                if (a2 != null) {
                    sb.append("byday=");
                    sb.append(a2);
                    sb.append(str2);
                }
            }
            if (optString.equals(str6)) {
                String a3 = C10777a.m35347a(jSONObject.optJSONArray("daysInMonth"), -31, 31);
                if (a3 != null) {
                    sb.append("bymonthday=");
                    sb.append(a3);
                    sb.append(str2);
                }
            }
            if (optString.equals(str5)) {
                String a4 = C10777a.m35347a(jSONObject.optJSONArray("daysInYear"), -366, 366);
                if (a4 != null) {
                    sb.append("byyearday=");
                    sb.append(a4);
                    sb.append(str2);
                }
            }
            if (optString.equals(str6)) {
                String a5 = C10777a.m35347a(jSONObject.optJSONArray("weeksInMonth"), -4, 4);
                if (a5 != null) {
                    sb.append("byweekno=");
                    sb.append(a5);
                    sb.append(str2);
                }
            }
            if (optString.equals(str5)) {
                String a6 = C10777a.m35347a(jSONObject.optJSONArray("monthsInYear"), 1, 12);
                if (a6 != null) {
                    sb.append("bymonth=");
                    sb.append(a6);
                    sb.append(str2);
                }
            }
            return sb.toString();
        } catch (JSONException e) {
            new StringBuilder("Error Parsing recurrence string").append(e.toString());
            return str3;
        }
    }
}
