package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps;

import android.content.SharedPreferences;
import android.content.res.Resources;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppVersions;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBodyWithApp;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppVersionsRequest */
public class ListAppVersionsRequest extends C0044V7<ListAppVersions, Body> {
    private static final Integer MAX_LIMIT = Integer.valueOf(10);

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppVersionsRequest$Body */
    public static class Body extends BaseBodyWithApp implements Endless {
        private Integer apkId;
        private String apkMd5sum;
        private Integer appId;
        private String lang;
        private Integer limit;
        private int offset;
        private Integer packageId;
        private String packageName;
        private List<Long> storeIds;
        private List<String> storeNames;
        private HashMapNotNull<String, List<String>> storesAuthMap;

        public Body(SharedPreferences sharedPreferences, String lang2) {
            super(sharedPreferences);
            this.lang = lang2;
        }

        public Body(String packageName2, SharedPreferences sharedPreferences, String lang2) {
            this(sharedPreferences, lang2);
            this.packageName = packageName2;
        }

        public Body(String packageName2, List<String> storeNames2, HashMapNotNull<String, List<String>> storesAuthMap2, SharedPreferences sharedPreferences, String lang2) {
            this(packageName2, sharedPreferences, lang2);
            this.storeNames = storeNames2;
            setStoresAuthMap(storesAuthMap2);
        }

        public HashMapNotNull<String, List<String>> getStoresAuthMap() {
            return this.storesAuthMap;
        }

        public void setStoresAuthMap(HashMapNotNull<String, List<String>> storesAuthMap2) {
            if (storesAuthMap2 != null) {
                this.storesAuthMap = storesAuthMap2;
                this.storeNames = new LinkedList(storesAuthMap2.keySet());
            }
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int offset2) {
            this.offset = offset2;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public void setLimit(Integer limit2) {
            this.limit = limit2;
        }

        public Integer getApkId() {
            return this.apkId;
        }

        public void setApkId(Integer apkId2) {
            this.apkId = apkId2;
        }

        public String getApkMd5sum() {
            return this.apkMd5sum;
        }

        public void setApkMd5sum(String apkMd5sum2) {
            this.apkMd5sum = apkMd5sum2;
        }

        public Integer getAppId() {
            return this.appId;
        }

        public void setAppId(Integer appId2) {
            this.appId = appId2;
        }

        public String getLang() {
            return this.lang;
        }

        public void setLang(String lang2) {
            this.lang = lang2;
        }

        public Integer getPackageId() {
            return this.packageId;
        }

        public void setPackageId(Integer packageId2) {
            this.packageId = packageId2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public List<Long> getStoreIds() {
            return this.storeIds;
        }

        public void setStoreIds(List<Long> storeIds2) {
            this.storeIds = storeIds2;
        }

        public List<String> getStoreNames() {
            return this.storeNames;
        }

        public void setStoreNames(List<String> storeNames2) {
            this.storeNames = storeNames2;
        }

        public int hashCode() {
            int result = (1 * 59) + super.hashCode();
            Integer apkId2 = getApkId();
            int i = 43;
            int result2 = (result * 59) + (apkId2 == null ? 43 : apkId2.hashCode());
            String apkMd5sum2 = getApkMd5sum();
            int result3 = (result2 * 59) + (apkMd5sum2 == null ? 43 : apkMd5sum2.hashCode());
            Integer appId2 = getAppId();
            int result4 = (result3 * 59) + (appId2 == null ? 43 : appId2.hashCode());
            String lang2 = getLang();
            int result5 = (result4 * 59) + (lang2 == null ? 43 : lang2.hashCode());
            Integer packageId2 = getPackageId();
            int result6 = (result5 * 59) + (packageId2 == null ? 43 : packageId2.hashCode());
            String packageName2 = getPackageName();
            int result7 = (result6 * 59) + (packageName2 == null ? 43 : packageName2.hashCode());
            Object $storeIds = getStoreIds();
            int result8 = (result7 * 59) + ($storeIds == null ? 43 : $storeIds.hashCode());
            Object $storeNames = getStoreNames();
            int result9 = (result8 * 59) + ($storeNames == null ? 43 : $storeNames.hashCode());
            Integer limit2 = getLimit();
            int result10 = (((result9 * 59) + (limit2 == null ? 43 : limit2.hashCode())) * 59) + getOffset();
            HashMapNotNull storesAuthMap2 = getStoresAuthMap();
            int i2 = result10 * 59;
            if (storesAuthMap2 != null) {
                i = storesAuthMap2.hashCode();
            }
            return i2 + i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:73:0x00f2 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00f3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r25) {
            /*
                r24 = this;
                r0 = r24
                r1 = r25
                r2 = 1
                if (r1 != r0) goto L_0x0008
                return r2
            L_0x0008:
                boolean r3 = r1 instanceof p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppVersionsRequest.Body
                r4 = 0
                if (r3 != 0) goto L_0x000e
                return r4
            L_0x000e:
                r3 = r1
                cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppVersionsRequest$Body r3 = (p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppVersionsRequest.Body) r3
                boolean r5 = r3.canEqual(r0)
                if (r5 != 0) goto L_0x0018
                return r4
            L_0x0018:
                boolean r5 = super.equals(r25)
                if (r5 != 0) goto L_0x001f
                return r4
            L_0x001f:
                java.lang.Integer r5 = r24.getApkId()
                java.lang.Integer r6 = r3.getApkId()
                if (r5 != 0) goto L_0x002c
                if (r6 == 0) goto L_0x0033
                goto L_0x0032
            L_0x002c:
                boolean r7 = r5.equals(r6)
                if (r7 != 0) goto L_0x0033
            L_0x0032:
                return r4
            L_0x0033:
                java.lang.String r7 = r24.getApkMd5sum()
                java.lang.String r8 = r3.getApkMd5sum()
                if (r7 != 0) goto L_0x0040
                if (r8 == 0) goto L_0x0047
                goto L_0x0046
            L_0x0040:
                boolean r9 = r7.equals(r8)
                if (r9 != 0) goto L_0x0047
            L_0x0046:
                return r4
            L_0x0047:
                java.lang.Integer r9 = r24.getAppId()
                java.lang.Integer r10 = r3.getAppId()
                if (r9 != 0) goto L_0x0054
                if (r10 == 0) goto L_0x005b
                goto L_0x005a
            L_0x0054:
                boolean r11 = r9.equals(r10)
                if (r11 != 0) goto L_0x005b
            L_0x005a:
                return r4
            L_0x005b:
                java.lang.String r11 = r24.getLang()
                java.lang.String r12 = r3.getLang()
                if (r11 != 0) goto L_0x0068
                if (r12 == 0) goto L_0x006f
                goto L_0x006e
            L_0x0068:
                boolean r13 = r11.equals(r12)
                if (r13 != 0) goto L_0x006f
            L_0x006e:
                return r4
            L_0x006f:
                java.lang.Integer r13 = r24.getPackageId()
                java.lang.Integer r14 = r3.getPackageId()
                if (r13 != 0) goto L_0x007c
                if (r14 == 0) goto L_0x0083
                goto L_0x0082
            L_0x007c:
                boolean r15 = r13.equals(r14)
                if (r15 != 0) goto L_0x0083
            L_0x0082:
                return r4
            L_0x0083:
                java.lang.String r15 = r24.getPackageName()
                java.lang.String r2 = r3.getPackageName()
                if (r15 != 0) goto L_0x0090
                if (r2 == 0) goto L_0x0097
                goto L_0x0096
            L_0x0090:
                boolean r17 = r15.equals(r2)
                if (r17 != 0) goto L_0x0097
            L_0x0096:
                return r4
            L_0x0097:
                java.util.List r4 = r24.getStoreIds()
                java.util.List r0 = r3.getStoreIds()
                if (r4 != 0) goto L_0x00a4
                if (r0 == 0) goto L_0x00ad
                goto L_0x00aa
            L_0x00a4:
                boolean r18 = r4.equals(r0)
                if (r18 != 0) goto L_0x00ad
            L_0x00aa:
                r16 = 0
                return r16
            L_0x00ad:
                r18 = r0
                java.util.List r0 = r24.getStoreNames()
                java.util.List r1 = r3.getStoreNames()
                if (r0 != 0) goto L_0x00bc
                if (r1 == 0) goto L_0x00c5
                goto L_0x00c2
            L_0x00bc:
                boolean r19 = r0.equals(r1)
                if (r19 != 0) goto L_0x00c5
            L_0x00c2:
                r16 = 0
                return r16
            L_0x00c5:
                r19 = r0
                java.lang.Integer r0 = r24.getLimit()
                r20 = r1
                java.lang.Integer r1 = r3.getLimit()
                if (r0 != 0) goto L_0x00d9
                if (r1 == 0) goto L_0x00d6
                goto L_0x00df
            L_0x00d6:
                r17 = 0
                goto L_0x00e4
            L_0x00d9:
                boolean r21 = r0.equals(r1)
                if (r21 != 0) goto L_0x00e2
            L_0x00df:
                r17 = 0
                return r17
            L_0x00e2:
                r17 = 0
            L_0x00e4:
                r21 = r0
                int r0 = r24.getOffset()
                r22 = r1
                int r1 = r3.getOffset()
                if (r0 == r1) goto L_0x00f3
                return r17
            L_0x00f3:
                cm.aptoide.pt.dataprovider.util.HashMapNotNull r0 = r24.getStoresAuthMap()
                cm.aptoide.pt.dataprovider.util.HashMapNotNull r1 = r3.getStoresAuthMap()
                if (r0 != 0) goto L_0x0100
                if (r1 == 0) goto L_0x0109
                goto L_0x0106
            L_0x0100:
                boolean r23 = r0.equals(r1)
                if (r23 != 0) goto L_0x0109
            L_0x0106:
                r16 = 0
                return r16
            L_0x0109:
                r16 = 1
                return r16
            */
            throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppVersionsRequest.Body.equals(java.lang.Object):boolean");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ListAppVersionsRequest.Body(apkId=");
            sb.append(getApkId());
            sb.append(", apkMd5sum=");
            sb.append(getApkMd5sum());
            sb.append(", appId=");
            sb.append(getAppId());
            sb.append(", lang=");
            sb.append(getLang());
            sb.append(", packageId=");
            sb.append(getPackageId());
            sb.append(", packageName=");
            sb.append(getPackageName());
            sb.append(", storeIds=");
            sb.append(getStoreIds());
            sb.append(", storeNames=");
            sb.append(getStoreNames());
            sb.append(", limit=");
            sb.append(getLimit());
            sb.append(", offset=");
            sb.append(getOffset());
            sb.append(", storesAuthMap=");
            sb.append(getStoresAuthMap());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Body;
        }
    }

    private ListAppVersionsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static ListAppVersionsRequest m7553of(String packageName, HashMapNotNull<String, List<String>> storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources) {
        String str = packageName;
        Body body = new Body(packageName, sharedPreferences, SystemU.getCountryCode(resources));
        HashMapNotNull<String, List<String>> hashMapNotNull = storeCredentials;
        body.setStoresAuthMap(storeCredentials);
        body.setLimit(MAX_LIMIT);
        ListAppVersionsRequest listAppVersionsRequest = new ListAppVersionsRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listAppVersionsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListAppVersions> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.listAppVersions((Body) this.body, bypassCache);
    }
}
