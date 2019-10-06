package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest */
public class GetAppRequest extends C0044V7<GetApp, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest$Body */
    public static class Body extends BaseBodyWithApp {
        private Long appId;
        @JsonProperty("apk_md5sum")
        private String md5;
        private Node nodes;
        private String packageName;
        @JsonProperty("store_name")
        private String storeName;
        @JsonProperty("package_uname")
        private String uname;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest$Body$Node */
        private static class Node {
            private Groups groups;
            private Meta meta;
            private Versions versions;

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest$Body$Node$Groups */
            private static class Groups {
                private Groups() {
                }
            }

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest$Body$Node$Meta */
            private static class Meta {
                private Long appId;

                private Meta() {
                }

                public Long getAppId() {
                    return this.appId;
                }

                public void setAppId(Long appId2) {
                    this.appId = appId2;
                }
            }

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest$Body$Node$Versions */
            private static class Versions {
                private String packageName;

                private Versions() {
                }

                public String getPackageName() {
                    return this.packageName;
                }

                public void setPackageName(String packageName2) {
                    this.packageName = packageName2;
                }
            }

            public Node(Long appId, String packageName) {
                this.meta = new Meta();
                this.meta.setAppId(appId);
                this.versions = new Versions();
                this.versions.setPackageName(packageName);
                this.groups = new Groups();
            }

            public Node(long appId) {
                this(Long.valueOf(appId), null);
            }

            public Node(String packageName) {
                this(null, packageName);
            }

            public Node() {
                this(null, null);
            }

            public Meta getMeta() {
                return this.meta;
            }

            public void setMeta(Meta meta2) {
                this.meta = meta2;
            }

            public Versions getVersions() {
                return this.versions;
            }

            public void setVersions(Versions versions2) {
                this.versions = versions2;
            }

            public Groups getGroups() {
                return this.groups;
            }

            public void setGroups(Groups groups2) {
                this.groups = groups2;
            }
        }

        public Body(Long appId2, String packageName2, SharedPreferences sharedPreferences) {
            this(appId2.longValue(), sharedPreferences);
            this.nodes = new Node(appId2, packageName2);
        }

        public Body(Long appId2, String storeName2, String packageName2, SharedPreferences sharedPreferences) {
            this(appId2.longValue(), sharedPreferences);
            this.storeName = storeName2;
            this.nodes = new Node(appId2, packageName2);
        }

        public Body(String packageName2, String storeName2, boolean refresh, SharedPreferences sharedPreferences) {
            this(packageName2, Boolean.valueOf(refresh), sharedPreferences);
            this.storeName = storeName2;
            this.nodes = new Node(this.appId, packageName2);
        }

        public Body(String packageName2, Boolean refresh, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.packageName = packageName2;
            this.nodes = new Node(packageName2);
        }

        public Body(String uname2, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.uname = uname2;
            this.nodes = new Node();
        }

        public Body(SharedPreferences sharedPreferences, String md52) {
            super(sharedPreferences);
            this.md5 = md52;
            this.nodes = new Node();
        }

        public Body(long appId2, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.appId = Long.valueOf(appId2);
            this.nodes = new Node(appId2);
        }

        public Long getAppId() {
            return this.appId;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getUname() {
            return this.uname;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public Node getNodes() {
            return this.nodes;
        }
    }

    private GetAppRequest(String baseHost, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetAppRequest m7463of(String packageName, String storeName, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetAppRequest getAppRequest = new GetAppRequest(C0044V7.getHost(sharedPreferences), new Body(packageName, storeName, ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences), sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getAppRequest;
    }

    /* renamed from: of */
    public static GetAppRequest m7461of(String packageName, BodyInterceptor<BaseBody> bodyInterceptor, long appId, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetAppRequest getAppRequest = new GetAppRequest(C0044V7.getHost(sharedPreferences), new Body(Long.valueOf(appId), packageName, sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getAppRequest;
    }

    /* renamed from: of */
    public static GetAppRequest m7462of(String packageName, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetAppRequest getAppRequest = new GetAppRequest(C0044V7.getHost(sharedPreferences), new Body(packageName, Boolean.valueOf(ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences)), sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getAppRequest;
    }

    public static GetAppRequest ofMd5(String md5, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetAppRequest getAppRequest = new GetAppRequest(C0044V7.getHost(sharedPreferences), new Body(sharedPreferences, md5), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getAppRequest;
    }

    public static GetAppRequest ofUname(String uname, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetAppRequest getAppRequest = new GetAppRequest(C0044V7.getHost(sharedPreferences), new Body(uname, sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getAppRequest;
    }

    /* renamed from: of */
    public static GetAppRequest m7460of(long appId, String storeName, StoreCredentials storeCredentials, String packageName, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        String str = storeName;
        Body body = new Body(Long.valueOf(appId), storeName, packageName, sharedPreferences);
        body.setStoreUser(storeCredentials.getUsername());
        body.setStorePassSha1(storeCredentials.getPasswordSha1());
        GetAppRequest getAppRequest = new GetAppRequest(C0044V7.getHost(sharedPreferences), body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getAppRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetApp> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getApp((Body) this.body, bypassCache);
    }
}
