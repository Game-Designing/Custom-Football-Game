package com.smaato.soma.p239c.p250g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.g.i */
/* compiled from: ReceivedJsonBodyParser */
public class C12262i {

    /* renamed from: a */
    private static final String f38390a = C12262i.class.getSimpleName();

    /* renamed from: b */
    private final C12259f f38391b;

    public C12262i(C12259f jsonParserCreator) {
        this.f38391b = jsonParserCreator;
    }

    /* renamed from: a */
    public C12064Na mo39636a(InputStream in, Map<String, List<String>> headerFields) throws ParserException {
        try {
            JSONObject jsonResponse = m40339a(in);
            return this.f38391b.mo39635a(headerFields, jsonResponse).mo39631a(jsonResponse);
        } catch (ParserException | RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new ParserException("Error during the JSON parsing.", e2);
        }
    }

    /* renamed from: a */
    private JSONObject m40339a(InputStream in) throws IOException, JSONException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = reader.readLine();
                String line = readLine;
                if (readLine != null) {
                    sb.append(line);
                    sb.append("\n");
                } else {
                    in.close();
                    String jsonString = sb.toString();
                    JSONObject jsonObject = new JSONObject(jsonString);
                    String str = f38390a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("JSON string: ");
                    sb2.append(jsonString);
                    C12146d.m39965a(new C12147e(str, sb2.toString(), 1, C12143a.DEBUG));
                    return jsonObject;
                }
            }
        } catch (Exception e) {
            C12146d.m39965a(new C12147e(f38390a, "Error converting result.", 1, C12143a.ERROR));
            throw e;
        }
    }
}
