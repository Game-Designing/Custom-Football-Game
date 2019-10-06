package p019d.p273h.p276c.p283g;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import p019d.p273h.p276c.C12747I.C12748a;

/* renamed from: d.h.c.g.a */
/* compiled from: HttpFunctions */
public class C12902a {
    /* renamed from: a */
    public static String m41871a(String link, C12748a listener) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            conn = (HttpURLConnection) new URL(link).openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            if (conn.getResponseCode() == 400) {
                if (listener != null) {
                    listener.mo41240a("Bad Request - 400");
                }
                if (conn != null) {
                    conn.disconnect();
                }
                if (reader != null) {
                    reader.close();
                }
                return null;
            }
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = reader2.readLine();
                String line = readLine;
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(line);
            }
            String result = stringBuilder.toString();
            if (TextUtils.isEmpty(result)) {
                if (conn != null) {
                    conn.disconnect();
                }
                reader2.close();
                return null;
            }
            if (conn != null) {
                conn.disconnect();
            }
            reader2.close();
            return result;
        } catch (Exception e) {
            if (conn != null) {
                conn.disconnect();
            }
            if (reader != null) {
                reader.close();
            }
            return null;
        } catch (Throwable th) {
            if (conn != null) {
                conn.disconnect();
            }
            if (reader != null) {
                reader.close();
            }
            throw th;
        }
    }
}
