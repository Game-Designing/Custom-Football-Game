package com.crashlytics.android.p126c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.c.c */
/* compiled from: BinaryImagesConverter */
class C6478c {

    /* renamed from: a */
    private final Context f11639a;

    /* renamed from: b */
    private final C6479a f11640b;

    /* renamed from: com.crashlytics.android.c.c$a */
    /* compiled from: BinaryImagesConverter */
    interface C6479a {
        /* renamed from: a */
        String mo19467a(File file) throws IOException;
    }

    C6478c(Context context, C6479a fileIdStrategy) {
        this.f11639a = context;
        this.f11640b = fileIdStrategy;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public byte[] mo19532a(String raw) throws IOException {
        return m12650a(m12655d(raw));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public byte[] mo19531a(BufferedReader reader) throws IOException {
        return m12650a(m12653b(reader));
    }

    /* renamed from: b */
    private JSONArray m12653b(BufferedReader reader) throws IOException {
        JSONArray binaryImagesJson = new JSONArray();
        while (true) {
            String readLine = reader.readLine();
            String mapEntryString = readLine;
            if (readLine == null) {
                return binaryImagesJson;
            }
            JSONObject mapJson = m12654c(mapEntryString);
            if (mapJson != null) {
                binaryImagesJson.put(mapJson);
            }
        }
    }

    /* renamed from: d */
    private JSONArray m12655d(String rawProcMapsString) {
        JSONArray binaryImagesJson = new JSONArray();
        try {
            String[] mapsEntries = m12652b(new JSONObject(rawProcMapsString).getJSONArray("maps")).split("\\|");
            for (String mapEntryString : mapsEntries) {
                JSONObject mapJson = m12654c(mapEntryString);
                if (mapJson != null) {
                    binaryImagesJson.put(mapJson);
                }
            }
            return binaryImagesJson;
        } catch (JSONException e) {
            C13920f.m44245e().mo43322a("CrashlyticsCore", "Unable to parse proc maps string", (Throwable) e);
            return binaryImagesJson;
        }
    }

    /* renamed from: c */
    private JSONObject m12654c(String mapEntryString) {
        String str = "CrashlyticsCore";
        C6413Da mapInfo = C6415Ea.m12433a(mapEntryString);
        if (mapInfo == null || !m12649a(mapInfo)) {
            return null;
        }
        try {
            try {
                return m12648a(this.f11640b.mo19467a(m12651b(mapInfo.f11482d)), mapInfo);
            } catch (JSONException e) {
                C13920f.m44245e().mo43327c(str, "Could not create a binary image json string", e);
                return null;
            }
        } catch (IOException e2) {
            C13929o e3 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not generate ID for file ");
            sb.append(mapInfo.f11482d);
            e3.mo43327c(str, sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: b */
    private File m12651b(String path) {
        File libFile = new File(path);
        if (!libFile.exists()) {
            return m12647a(libFile);
        }
        return libFile;
    }

    /* renamed from: a */
    private File m12647a(File missingFile) {
        if (VERSION.SDK_INT < 9) {
            return missingFile;
        }
        if (missingFile.getAbsolutePath().startsWith("/data")) {
            try {
                missingFile = new File(this.f11639a.getPackageManager().getApplicationInfo(this.f11639a.getPackageName(), 0).nativeLibraryDir, missingFile.getName());
            } catch (NameNotFoundException e) {
                C13920f.m44245e().mo43325b("CrashlyticsCore", "Error getting ApplicationInfo", e);
            }
        }
        return missingFile;
    }

    /* renamed from: a */
    private static byte[] m12650a(JSONArray binaryImages) {
        JSONObject binaryImagesObject = new JSONObject();
        try {
            binaryImagesObject.put("binary_images", binaryImages);
            return binaryImagesObject.toString().getBytes();
        } catch (JSONException e) {
            C13920f.m44245e().mo43322a("CrashlyticsCore", "Binary images string is null", (Throwable) e);
            return new byte[0];
        }
    }

    /* renamed from: a */
    private static JSONObject m12648a(String uuid, C6413Da mapEntry) throws JSONException {
        JSONObject binaryImage = new JSONObject();
        binaryImage.put("base_address", mapEntry.f11479a);
        binaryImage.put("size", mapEntry.f11480b);
        binaryImage.put("name", mapEntry.f11482d);
        binaryImage.put("uuid", uuid);
        return binaryImage;
    }

    /* renamed from: b */
    private static String m12652b(JSONArray array) throws JSONException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length(); i++) {
            sb.append(array.getString(i));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m12649a(C6413Da mapEntry) {
        return (mapEntry.f11481c.indexOf(Opcodes.ISHL) == -1 || mapEntry.f11482d.indexOf(47) == -1) ? false : true;
    }
}
