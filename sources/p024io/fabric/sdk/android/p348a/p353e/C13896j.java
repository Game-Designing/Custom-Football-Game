package p024io.fabric.sdk.android.p348a.p353e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p352d.C13883b;

/* renamed from: io.fabric.sdk.android.a.e.j */
/* compiled from: DefaultCachedSettingsIo */
class C13896j implements C13894h {

    /* renamed from: a */
    private final C0102l f42150a;

    public C13896j(C0102l kit) {
        this.f42150a = kit;
    }

    /* renamed from: a */
    public JSONObject mo43300a() {
        String str = "Error while closing settings cache file.";
        String str2 = "Fabric";
        C13920f.m44245e().mo43326c(str2, "Reading cached settings...");
        FileInputStream fis = null;
        JSONObject toReturn = null;
        try {
            File settingsFile = new File(new C13883b(this.f42150a).mo43292a(), "com.crashlytics.settings.json");
            if (settingsFile.exists()) {
                fis = new FileInputStream(settingsFile);
                toReturn = new JSONObject(C13852l.m44044b((InputStream) fis));
            } else {
                C13920f.m44245e().mo43326c(str2, "No cached settings found.");
            }
        } catch (Exception e) {
            C13920f.m44245e().mo43325b(str2, "Failed to fetch cached settings", e);
        } catch (Throwable th) {
            C13852l.m44036a((Closeable) null, str);
            throw th;
        }
        C13852l.m44036a((Closeable) fis, str);
        return toReturn;
    }

    /* renamed from: a */
    public void mo43301a(long expiresAtMillis, JSONObject settingsJson) {
        String str = "Failed to close settings writer.";
        String str2 = "Fabric";
        C13920f.m44245e().mo43326c(str2, "Writing settings to cache file...");
        if (settingsJson != null) {
            FileWriter writer = null;
            try {
                settingsJson.put("expires_at", expiresAtMillis);
                writer = new FileWriter(new File(new C13883b(this.f42150a).mo43292a(), "com.crashlytics.settings.json"));
                writer.write(settingsJson.toString());
                writer.flush();
            } catch (Exception e) {
                C13920f.m44245e().mo43325b(str2, "Failed to cache settings", e);
            } catch (Throwable th) {
                C13852l.m44036a((Closeable) writer, str);
                throw th;
            }
            C13852l.m44036a((Closeable) writer, str);
        }
    }
}
