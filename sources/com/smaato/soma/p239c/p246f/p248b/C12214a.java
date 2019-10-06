package com.smaato.soma.p239c.p246f.p248b;

import android.os.AsyncTask;
import com.smaato.soma.C12066Oa;
import com.smaato.soma.p236a.p237a.C12112c;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p246f.C12252w;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.f.b.a */
/* compiled from: FullReporterTask */
public class C12214a extends AsyncTask<HashMap<String, String>, String, String> {

    /* renamed from: a */
    private static final String f38280a = C12214a.class.getSimpleName();

    /* renamed from: b */
    private static final Map<String, String> f38281b = new HashMap();

    /* renamed from: c */
    private String f38282c;

    /* renamed from: d */
    private String f38283d = C12112c.f37999b;

    /* renamed from: e */
    private List<String> f38284e = new ArrayList();

    public C12214a(String sessionId) {
        this.f38282c = sessionId;
    }

    /* renamed from: a */
    public C12214a mo39544a(String url) {
        this.f38283d = url;
        return this;
    }

    /* renamed from: a */
    public C12214a mo39545a(List<String> urlTraces) {
        this.f38284e = urlTraces;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(HashMap<String, String>... postDataParams) {
        HashMap<String, String> reportData;
        String str = this.f38282c;
        if (str == null || str.equals(f38281b.get(this.f38283d))) {
            return null;
        }
        f38281b.put(this.f38283d, this.f38282c);
        if (postDataParams == null || postDataParams.length == 0) {
            reportData = new HashMap<>();
        } else {
            reportData = postDataParams[0];
        }
        reportData.put(AgentOptions.SESSIONID, this.f38282c);
        reportData.put("platform", "android");
        reportData.put("timestamp", String.valueOf(System.currentTimeMillis()));
        reportData.put("bundleid", C12066Oa.m39871a());
        reportData.put("sdkversion", "sdkandroid_9-1-5");
        reportData.put("apiversion", String.valueOf(600));
        String responseString = "";
        String type = "application/json";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(this.f38283d).openConnection();
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
            writer.write(m40188a(reportData));
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
    private String m40188a(HashMap<String, String> params) {
        JSONObject rootJsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            for (String urlTrace : this.f38284e) {
                jsonArray.put(urlTrace);
            }
            rootJsonObject.put("traces", jsonArray);
            for (Entry<String, String> entry : params.entrySet()) {
                rootJsonObject.put((String) entry.getKey(), entry.getValue());
            }
            String str = f38280a;
            StringBuilder sb = new StringBuilder();
            sb.append("json data to be reported:\n");
            sb.append(rootJsonObject.toString());
            C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rootJsonObject.toString();
    }
}
