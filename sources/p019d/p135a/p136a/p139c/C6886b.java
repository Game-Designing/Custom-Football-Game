package p019d.p135a.p136a.p139c;

import android.net.Uri;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.a.a.c.b */
/* compiled from: Payment */
public class C6886b {

    /* renamed from: a */
    private static final String f12625a = C6886b.class.getSimpleName();

    /* renamed from: b */
    private C6887a f12626b;

    /* renamed from: c */
    private String f12627c;

    /* renamed from: d.a.a.c.b$a */
    /* compiled from: Payment */
    public enum C6887a {
        RECEIVED("Received"),
        AUTHORISED("Authorised"),
        ERROR("Error"),
        REFUSED("Refused"),
        CANCELLED("Cancelled");
        

        /* renamed from: g */
        private String f12634g;

        private C6887a(String statusString) {
            this.f12634g = statusString;
        }

        /* renamed from: a */
        static C6887a m13991a(String string) {
            C6887a[] values;
            for (C6887a status : values()) {
                if (status.f12634g.equalsIgnoreCase(string)) {
                    return status;
                }
            }
            return null;
        }

        public String toString() {
            return this.f12634g;
        }
    }

    public C6886b(JSONObject jsonObject) {
        try {
            this.f12626b = C6887a.m13991a(jsonObject.getString("resultCode"));
            this.f12627c = jsonObject.getString("payload");
        } catch (JSONException e) {
            Log.e(f12625a, "Payment result code cannot be resolved.");
            this.f12626b = C6887a.ERROR;
        }
    }

    public C6886b(Uri uri) {
        String str = f12625a;
        StringBuilder sb = new StringBuilder();
        sb.append("URI: ");
        sb.append(uri);
        Log.d(str, sb.toString());
        this.f12626b = C6887a.m13991a(uri.getQueryParameter("resultCode"));
        this.f12627c = uri.getQueryParameter("payload");
    }

    /* renamed from: a */
    public String mo22324a() {
        return this.f12627c;
    }
}
