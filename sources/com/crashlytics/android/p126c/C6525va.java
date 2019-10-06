package com.crashlytics.android.p126c;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: com.crashlytics.android.c.va */
/* compiled from: MetaDataStore */
class C6525va {

    /* renamed from: a */
    private static final Charset f11713a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final File f11714b;

    public C6525va(File filesDir) {
        this.f11714b = filesDir;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    public C6447Ra mo19618c(String sessionId) {
        String str = "Failed to close user metadata file.";
        File f = mo19617b(sessionId);
        if (!f.exists()) {
            return C6447Ra.f11552a;
        }
        try {
            InputStream is = new FileInputStream(f);
            C6447Ra d = m12791d(C13852l.m44044b(is));
            C13852l.m44036a((Closeable) is, str);
            return d;
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("CrashlyticsCore", "Error deserializing user metadata.", e);
            C13852l.m44036a((Closeable) null, str);
            return C6447Ra.f11552a;
        } catch (Throwable th) {
            C13852l.m44036a((Closeable) null, str);
            throw th;
        }
    }

    /* renamed from: a */
    public void mo19616a(String sessionId, Map<String, String> keyData) {
        String str = "Failed to close key/value metadata file.";
        File f = mo19615a(sessionId);
        BufferedWriter bufferedWriter = null;
        try {
            String keyDataString = m12789a(keyData);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), f11713a));
            bufferedWriter.write(keyDataString);
            bufferedWriter.flush();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("CrashlyticsCore", "Error serializing key/value metadata.", e);
        } catch (Throwable th) {
            C13852l.m44036a((Closeable) bufferedWriter, str);
            throw th;
        }
        C13852l.m44036a((Closeable) bufferedWriter, str);
    }

    /* renamed from: b */
    public File mo19617b(String sessionId) {
        File file = this.f11714b;
        StringBuilder sb = new StringBuilder();
        sb.append(sessionId);
        sb.append("user");
        sb.append(".meta");
        return new File(file, sb.toString());
    }

    /* renamed from: a */
    public File mo19615a(String sessionId) {
        File file = this.f11714b;
        StringBuilder sb = new StringBuilder();
        sb.append(sessionId);
        sb.append("keys");
        sb.append(".meta");
        return new File(file, sb.toString());
    }

    /* renamed from: d */
    private static C6447Ra m12791d(String json) throws JSONException {
        JSONObject dataObj = new JSONObject(json);
        return new C6447Ra(m12790a(dataObj, AndroidAccountManagerPersistence.ACCOUNT_ID), m12790a(dataObj, "userName"), m12790a(dataObj, "userEmail"));
    }

    /* renamed from: a */
    private static String m12789a(Map<String, String> keyData) throws JSONException {
        return new JSONObject(keyData).toString();
    }

    /* renamed from: a */
    private static String m12790a(JSONObject json, String key) {
        if (!json.isNull(key)) {
            return json.optString(key, null);
        }
        return null;
    }
}
