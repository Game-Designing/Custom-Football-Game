package com.smaato.soma.p239c.p246f.p248b;

import android.os.AsyncTask;
import com.smaato.soma.p236a.p237a.C12112c;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p246f.C12252w;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.f.b.b */
/* compiled from: PingPongReporterTask */
public class C12215b extends AsyncTask<HashMap<String, Object>, String, String> {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(HashMap<String, Object>... postDataParams) {
        String responseString = "";
        String type = "application/json";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(C12112c.f38000c).openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("User-Agent", C12252w.m40307b().mo39629e());
            connection.setRequestProperty("Content-Type", type);
            connection.connect();
            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(m40192a(postDataParams[0]));
            writer.flush();
            writer.close();
            os.close();
            try {
                int responseCode = connection.getResponseCode();
                if (responseCode != 200) {
                    responseString = "Error";
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error code from AVR: ");
                    sb.append(responseCode);
                    C12146d.m39965a(new C12147e("AVR", sb.toString(), 1, C12143a.DEBUG));
                }
                connection.disconnect();
            } catch (Exception e) {
            }
            return responseString;
        } catch (Exception e2) {
            return responseString;
        }
    }

    /* renamed from: a */
    private String m40192a(HashMap<String, Object> params) throws UnsupportedEncodingException {
        JSONObject rootJsonObject = new JSONObject();
        for (Entry<String, Object> entry : params.entrySet()) {
            try {
                rootJsonObject.put((String) entry.getKey(), entry.getValue().toString());
            } catch (JSONException e) {
            }
        }
        return rootJsonObject.toString();
    }
}
