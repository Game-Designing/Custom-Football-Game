package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.z */
/* compiled from: FetchedAppSettings */
public final class C6738z {

    /* renamed from: a */
    private boolean f12316a;

    /* renamed from: b */
    private String f12317b;

    /* renamed from: c */
    private boolean f12318c;

    /* renamed from: d */
    private boolean f12319d;

    /* renamed from: e */
    private int f12320e;

    /* renamed from: f */
    private EnumSet<C6691O> f12321f;

    /* renamed from: g */
    private Map<String, Map<String, C6739a>> f12322g;

    /* renamed from: h */
    private boolean f12323h;

    /* renamed from: i */
    private C6732t f12324i;

    /* renamed from: j */
    private String f12325j;

    /* renamed from: k */
    private String f12326k;

    /* renamed from: l */
    private boolean f12327l;

    /* renamed from: m */
    private boolean f12328m;

    /* renamed from: n */
    private String f12329n;

    /* renamed from: o */
    private JSONArray f12330o;

    /* renamed from: p */
    private boolean f12331p;

    /* renamed from: com.facebook.internal.z$a */
    /* compiled from: FetchedAppSettings */
    public static class C6739a {

        /* renamed from: a */
        private String f12332a;

        /* renamed from: b */
        private String f12333b;

        /* renamed from: c */
        private Uri f12334c;

        /* renamed from: d */
        private int[] f12335d;

        /* renamed from: a */
        public static C6739a m13587a(JSONObject dialogConfigJSON) {
            String dialogNameWithFeature = dialogConfigJSON.optString("name");
            if (C6694S.m13436b(dialogNameWithFeature)) {
                return null;
            }
            String[] components = dialogNameWithFeature.split("\\|");
            if (components.length != 2) {
                return null;
            }
            String dialogName = components[0];
            String featureName = components[1];
            if (C6694S.m13436b(dialogName) || C6694S.m13436b(featureName)) {
                return null;
            }
            String urlString = dialogConfigJSON.optString("url");
            Uri fallbackUri = null;
            if (!C6694S.m13436b(urlString)) {
                fallbackUri = Uri.parse(urlString);
            }
            return new C6739a(dialogName, featureName, fallbackUri, m13588a(dialogConfigJSON.optJSONArray("versions")));
        }

        /* renamed from: a */
        private static int[] m13588a(JSONArray versionsJSON) {
            int[] versionSpec = null;
            if (versionsJSON != null) {
                int numVersions = versionsJSON.length();
                versionSpec = new int[numVersions];
                for (int i = 0; i < numVersions; i++) {
                    int version = versionsJSON.optInt(i, -1);
                    if (version == -1) {
                        String versionString = versionsJSON.optString(i);
                        if (!C6694S.m13436b(versionString)) {
                            try {
                                version = Integer.parseInt(versionString);
                            } catch (NumberFormatException nfe) {
                                C6694S.m13422a("FacebookSDK", (Exception) nfe);
                                version = -1;
                            }
                        }
                    }
                    versionSpec[i] = version;
                }
            }
            return versionSpec;
        }

        private C6739a(String dialogName, String featureName, Uri fallbackUrl, int[] featureVersionSpec) {
            this.f12332a = dialogName;
            this.f12333b = featureName;
            this.f12334c = fallbackUrl;
            this.f12335d = featureVersionSpec;
        }

        /* renamed from: a */
        public String mo19983a() {
            return this.f12332a;
        }

        /* renamed from: b */
        public String mo19984b() {
            return this.f12333b;
        }
    }

    public C6738z(boolean supportsImplicitLogging, String nuxContent, boolean nuxEnabled, boolean customTabsEnabled, int sessionTimeoutInSeconds, EnumSet<C6691O> smartLoginOptions, Map<String, Map<String, C6739a>> dialogConfigMap, boolean automaticLoggingEnabled, C6732t errorClassification, String smartLoginBookmarkIconURL, String smartLoginMenuIconURL, boolean IAPAutomaticLoggingEnabled, boolean codelessEventsEnabled, JSONArray eventBindings, String sdkUpdateMessage, boolean trackUninstallEnabled) {
        this.f12316a = supportsImplicitLogging;
        this.f12317b = nuxContent;
        this.f12318c = nuxEnabled;
        this.f12319d = customTabsEnabled;
        this.f12322g = dialogConfigMap;
        this.f12324i = errorClassification;
        this.f12320e = sessionTimeoutInSeconds;
        this.f12323h = automaticLoggingEnabled;
        this.f12321f = smartLoginOptions;
        this.f12325j = smartLoginBookmarkIconURL;
        this.f12326k = smartLoginMenuIconURL;
        this.f12327l = IAPAutomaticLoggingEnabled;
        this.f12328m = codelessEventsEnabled;
        this.f12330o = eventBindings;
        this.f12329n = sdkUpdateMessage;
        this.f12331p = trackUninstallEnabled;
    }

    /* renamed from: j */
    public boolean mo19982j() {
        return this.f12316a;
    }

    /* renamed from: c */
    public boolean mo19975c() {
        return this.f12319d;
    }

    /* renamed from: h */
    public int mo19980h() {
        return this.f12320e;
    }

    /* renamed from: a */
    public boolean mo19973a() {
        return this.f12323h;
    }

    /* renamed from: i */
    public EnumSet<C6691O> mo19981i() {
        return this.f12321f;
    }

    /* renamed from: d */
    public C6732t mo19976d() {
        return this.f12324i;
    }

    /* renamed from: f */
    public boolean mo19978f() {
        return this.f12327l;
    }

    /* renamed from: b */
    public boolean mo19974b() {
        return this.f12328m;
    }

    /* renamed from: e */
    public JSONArray mo19977e() {
        return this.f12330o;
    }

    /* renamed from: g */
    public String mo19979g() {
        return this.f12329n;
    }
}
