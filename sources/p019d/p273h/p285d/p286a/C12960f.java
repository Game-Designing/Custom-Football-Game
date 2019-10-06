package p019d.p273h.p285d.p286a;

import android.util.Log;
import org.json.JSONObject;

/* renamed from: d.h.d.a.f */
/* compiled from: ISNAdViewLogic */
class C12960f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39892a;

    /* renamed from: b */
    final /* synthetic */ String f39893b;

    /* renamed from: c */
    final /* synthetic */ String f39894c;

    /* renamed from: d */
    final /* synthetic */ JSONObject f39895d;

    /* renamed from: e */
    final /* synthetic */ C12963i f39896e;

    C12960f(C12963i this$0, String str, String str2, String str3, JSONObject jSONObject) {
        this.f39896e = this$0;
        this.f39892a = str;
        this.f39893b = str2;
        this.f39894c = str3;
        this.f39895d = jSONObject;
    }

    public void run() {
        try {
            if (!this.f39896e.m42242c(this.f39892a)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ISNAdViewLogic | handleMessageFromController | cannot handle command: ");
                sb.append(this.f39892a);
                String errorMessage = sb.toString();
                Log.e(this.f39896e.f39905f, errorMessage);
                this.f39896e.f39902c.mo35412a(this.f39893b, errorMessage);
                return;
            }
            if (this.f39892a.equalsIgnoreCase("isExternalAdViewInitiated")) {
                this.f39896e.m42250f(this.f39894c);
            } else if (this.f39892a.equalsIgnoreCase("handleGetViewVisibility")) {
                this.f39896e.m42247e(this.f39894c);
            } else {
                if (!this.f39892a.equalsIgnoreCase("sendMessage")) {
                    if (!this.f39892a.equalsIgnoreCase("updateAd")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("ISNAdViewLogic | handleMessageFromController | unhandled API request ");
                        sb2.append(this.f39892a);
                        sb2.append(" ");
                        sb2.append(this.f39895d.toString());
                        String errorMessage2 = sb2.toString();
                        Log.e(this.f39896e.f39905f, errorMessage2);
                        this.f39896e.f39902c.mo35412a(this.f39893b, errorMessage2);
                    }
                }
                this.f39896e.m42232a(this.f39895d.getString("params"), this.f39894c, this.f39893b);
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ISNAdViewLogic | handleMessageFromController | Error while trying handle message: ");
            sb3.append(this.f39892a);
            String errorMessage3 = sb3.toString();
            Log.e(this.f39896e.f39905f, errorMessage3);
            this.f39896e.f39902c.mo35412a(this.f39893b, errorMessage3);
        }
    }
}
