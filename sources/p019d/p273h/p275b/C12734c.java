package p019d.p273h.p275b;

import android.os.AsyncTask;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/* renamed from: d.h.b.c */
/* compiled from: EventsSender */
public class C12734c extends AsyncTask<Object, Void, Boolean> {

    /* renamed from: a */
    private final int f39061a = 15000;

    /* renamed from: b */
    private final String f39062b = "POST";

    /* renamed from: c */
    private final String f39063c = "UTF-8";

    /* renamed from: d */
    private final String f39064d = "Content-Type";

    /* renamed from: e */
    private final String f39065e = "application/json";

    /* renamed from: f */
    private ArrayList f39066f;

    /* renamed from: g */
    private C12736e f39067g;

    public C12734c() {
    }

    public C12734c(C12736e resultListener) {
        this.f39067g = resultListener;
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground(Object... objects) {
        try {
            boolean z = true;
            URL requestURL = new URL(objects[1]);
            this.f39066f = objects[2];
            HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(objects[0]);
            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();
            conn.disconnect();
            if (responseCode != 200) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Boolean success) {
        C12736e eVar = this.f39067g;
        if (eVar != null) {
            eVar.mo41163a(this.f39066f, success.booleanValue());
        }
    }
}
