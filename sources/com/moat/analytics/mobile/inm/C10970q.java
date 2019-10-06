package com.moat.analytics.mobile.inm;

import com.moat.analytics.mobile.inm.p227a.p229b.C10932a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.moat.analytics.mobile.inm.q */
class C10970q {
    C10970q() {
    }

    /* renamed from: a */
    static C10932a<String> m36118a(String str) {
        InputStream inputStream = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                return C10932a.m35953a();
            }
            inputStream = httpURLConnection.getInputStream();
            C10932a<String> a = C10932a.m35954a(m36119a(inputStream));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            return a;
        } catch (IOException e2) {
            C10932a<String> a2 = C10932a.m35953a();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            return a2;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    /* renamed from: a */
    private static String m36119a(InputStream inputStream) {
        char[] cArr = new char[Opcodes.ACC_NATIVE];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        int i = 0;
        do {
            int read = inputStreamReader.read(cArr, 0, Opcodes.ACC_NATIVE);
            if (read <= 0) {
                break;
            }
            i += read;
            sb.append(cArr, 0, read);
        } while (i < 1024);
        return sb.toString();
    }

    /* renamed from: b */
    static void m36120b(final String str) {
        new Thread() {
            public final void run() {
                try {
                    C10970q.m36118a(str);
                } catch (Exception e) {
                }
            }
        }.start();
    }
}
