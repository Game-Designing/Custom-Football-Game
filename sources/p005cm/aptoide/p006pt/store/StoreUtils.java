package p005cm.aptoide.p006pt.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Info;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Info.Status;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Stats;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeMetaRequest.Body;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreMetaRequest;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import p026rx.p398d.C14906b;

/* renamed from: cm.aptoide.pt.store.StoreUtils */
public class StoreUtils {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String PRIVATE_STORE_ERROR_CODE = "STORE-3";
    private static final String PRIVATE_STORE_WRONG_CREDENTIALS_ERROR_CODE = "STORE-4";
    private static final String STORE_DOESNT_EXIST_ERROR_CODE = "STORE-1";
    private static final String STORE_SUSPENDED_ERROR_CODE = "STORE-7";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4260373629672647361L, "cm/aptoide/pt/store/StoreUtils", Opcodes.D2I);
        $jacocoData = probes;
        return probes;
    }

    public StoreUtils() {
        $jacocoInit()[0] = true;
    }

    @Deprecated
    public static StoreCredentials getStoreCredentials(long storeId, StoreCredentialsProvider storeCredentialsProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentials storeCredentials = storeCredentialsProvider.get(storeId);
        $jacocoInit[1] = true;
        return storeCredentials;
    }

    @Deprecated
    public static StoreCredentials getStoreCredentialsFromUrl(String url, StoreCredentialsProvider storeCredentialsProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentials fromUrl = storeCredentialsProvider.fromUrl(url);
        $jacocoInit[2] = true;
        return fromUrl;
    }

    @Deprecated
    public static C0120S<GetStoreMeta> subscribeStore(GetStoreMetaRequest getStoreMetaRequest, AptoideAccountManager accountManager, String storeUserName, String storePassword, StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S observe = getStoreMetaRequest.observe();
        C4928a aVar = new C4928a(accountManager, storeUserName, storePassword);
        $jacocoInit[3] = true;
        C0120S f = observe.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        C4933f fVar = new C4933f(getStoreMetaRequest, storeAccessor);
        $jacocoInit[4] = true;
        C0120S<GetStoreMeta> b = f.mo3636b((C0129b<? super T>) fVar);
        $jacocoInit[5] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m9264a(AptoideAccountManager accountManager, String storeUserName, String storePassword, GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = accountManager.accountStatus();
        $jacocoInit[128] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[129] = true;
        Single n = d.mo3678n();
        C4930c cVar = new C4930c(getStoreMeta, accountManager, storeUserName, storePassword);
        $jacocoInit[130] = true;
        C0120S c = n.mo3697c(cVar);
        $jacocoInit[131] = true;
        return c;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m9265a(GetStoreMeta getStoreMeta, AptoideAccountManager accountManager, String storeUserName, String storePassword, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        Status status = Status.OK;
        Info info = getStoreMeta.getInfo();
        $jacocoInit[132] = true;
        Status status2 = info.getStatus();
        $jacocoInit[133] = true;
        if (status.equals(status2)) {
            $jacocoInit[134] = true;
            if (account.isLoggedIn()) {
                $jacocoInit[135] = true;
                Store data = getStoreMeta.getData();
                $jacocoInit[136] = true;
                String name = data.getName();
                $jacocoInit[137] = true;
                C0117M subscribeStore = accountManager.subscribeStore(name, storeUserName, storePassword);
                $jacocoInit[138] = true;
                C0120S a = subscribeStore.mo3586a(C0120S.m652c(getStoreMeta));
                $jacocoInit[139] = true;
                return a;
            }
            C0120S c = C0120S.m652c(getStoreMeta);
            $jacocoInit[140] = true;
            return c;
        }
        C0120S a2 = C0120S.m631a((Throwable) new Exception("Something went wrong while getting store meta"));
        $jacocoInit[141] = true;
        return a2;
    }

    /* renamed from: a */
    static /* synthetic */ void m9269a(GetStoreMetaRequest getStoreMetaRequest, StoreAccessor storeAccessor, GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        saveStore(getStoreMeta.getData(), getStoreMetaRequest, storeAccessor);
        $jacocoInit[127] = true;
    }

    private static void saveStore(Store storeData, GetStoreMetaRequest getStoreMetaRequest, StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        p005cm.aptoide.p006pt.database.realm.Store store = new p005cm.aptoide.p006pt.database.realm.Store();
        $jacocoInit[6] = true;
        store.setStoreId(storeData.getId());
        $jacocoInit[7] = true;
        store.setStoreName(storeData.getName());
        $jacocoInit[8] = true;
        Stats stats = storeData.getStats();
        $jacocoInit[9] = true;
        long downloads = stats.getDownloads();
        $jacocoInit[10] = true;
        store.setDownloads(downloads);
        $jacocoInit[11] = true;
        store.setIconPath(storeData.getAvatar());
        $jacocoInit[12] = true;
        Appearance appearance = storeData.getAppearance();
        $jacocoInit[13] = true;
        String theme = appearance.getTheme();
        $jacocoInit[14] = true;
        store.setTheme(theme);
        $jacocoInit[15] = true;
        if (!isPrivateCredentialsSet(getStoreMetaRequest)) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            Body body = (Body) getStoreMetaRequest.getBody();
            $jacocoInit[18] = true;
            String storeUser = body.getStoreUser();
            $jacocoInit[19] = true;
            store.setUsername(storeUser);
            $jacocoInit[20] = true;
            Body body2 = (Body) getStoreMetaRequest.getBody();
            $jacocoInit[21] = true;
            String storePassSha1 = body2.getStorePassSha1();
            $jacocoInit[22] = true;
            store.setPasswordSha1(storePassSha1);
            $jacocoInit[23] = true;
        }
        storeAccessor.save(store);
        $jacocoInit[24] = true;
    }

    @Deprecated
    public static void subscribeStore(GetStoreMetaRequest getStoreMetaRequest, SuccessRequestListener<GetStoreMeta> successRequestListener, ErrorRequestListener errorRequestListener, AptoideAccountManager accountManager, String storeUserName, String storePassword, StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S subscribeStore = subscribeStore(getStoreMetaRequest, accountManager, storeUserName, storePassword, storeAccessor);
        $jacocoInit[25] = true;
        C0120S a = subscribeStore.mo3616a(C14522a.m46170a());
        C4929b bVar = new C4929b(successRequestListener);
        C4931d dVar = new C4931d(errorRequestListener);
        $jacocoInit[26] = true;
        a.mo3626a((C0129b<? super T>) bVar, (C0129b<Throwable>) dVar);
        $jacocoInit[27] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9268a(SuccessRequestListener successRequestListener, GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        if (successRequestListener == null) {
            $jacocoInit[123] = true;
        } else {
            $jacocoInit[124] = true;
            successRequestListener.call(getStoreMeta);
            $jacocoInit[125] = true;
        }
        $jacocoInit[126] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9267a(ErrorRequestListener errorRequestListener, Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        if (errorRequestListener == null) {
            $jacocoInit[118] = true;
        } else {
            $jacocoInit[119] = true;
            errorRequestListener.onError(e);
            $jacocoInit[120] = true;
        }
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[121] = true;
        instance.log(e);
        $jacocoInit[122] = true;
    }

    @Deprecated
    public static StoreCredentials getStoreCredentials(String storeName, StoreCredentialsProvider storeCredentialsProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentials storeCredentials = storeCredentialsProvider.get(storeName);
        $jacocoInit[28] = true;
        return storeCredentials;
    }

    private static boolean isPrivateCredentialsSet(GetStoreMetaRequest getStoreMetaRequest) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Body body = (Body) getStoreMetaRequest.getBody();
        $jacocoInit[29] = true;
        if (body.getStoreUser() == null) {
            $jacocoInit[30] = true;
        } else {
            $jacocoInit[31] = true;
            Body body2 = (Body) getStoreMetaRequest.getBody();
            $jacocoInit[32] = true;
            if (body2.getStorePassSha1() == null) {
                $jacocoInit[33] = true;
            } else {
                $jacocoInit[34] = true;
                z = true;
                $jacocoInit[36] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[35] = true;
        $jacocoInit[36] = true;
        return z;
    }

    public static C0120S<Boolean> isSubscribedStore(String storeName, StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = storeAccessor.get(storeName);
        C4932e eVar = C4932e.f8578a;
        $jacocoInit[37] = true;
        C0120S<Boolean> j = s.mo3669j(eVar);
        $jacocoInit[38] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9263a(p005cm.aptoide.p006pt.database.realm.Store store) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (store != null) {
            $jacocoInit[115] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[116] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[117] = true;
        return valueOf;
    }

    public static ArrayList<String> split(List<String> repoUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<String> res = new ArrayList<>();
        if (repoUrl == null) {
            $jacocoInit[39] = true;
        } else {
            $jacocoInit[40] = true;
            $jacocoInit[41] = true;
            for (String s : repoUrl) {
                $jacocoInit[43] = true;
                res.add(split(s));
                $jacocoInit[44] = true;
            }
            $jacocoInit[42] = true;
        }
        $jacocoInit[45] = true;
        return res;
    }

    public static String split(String repoUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Splitting ");
        sb.append(repoUrl);
        String sb2 = sb.toString();
        $jacocoInit[46] = true;
        instance.mo2136d("Aptoide-RepoUtils", sb2);
        $jacocoInit[47] = true;
        String repoUrl2 = formatRepoUri(repoUrl);
        $jacocoInit[48] = true;
        String str = repoUrl2.split("http://")[1].split("\\.store")[0].split("\\.bazaarandroid.com")[0];
        $jacocoInit[49] = true;
        return str;
    }

    public static String formatRepoUri(String repoUri) {
        boolean[] $jacocoInit = $jacocoInit();
        String repoUri2 = repoUri.toLowerCase(Locale.ENGLISH);
        $jacocoInit[50] = true;
        String str = "http//";
        String str2 = "http://";
        if (!repoUri2.contains(str)) {
            $jacocoInit[51] = true;
        } else {
            $jacocoInit[52] = true;
            repoUri2 = repoUri2.replaceFirst(str, str2);
            $jacocoInit[53] = true;
        }
        String str3 = "repo uri: ";
        String str4 = "Aptoide-ManageRepo";
        if (repoUri2.length() == 0) {
            $jacocoInit[54] = true;
        } else if (repoUri2.charAt(repoUri2.length() - 1) == '/') {
            $jacocoInit[55] = true;
        } else {
            $jacocoInit[56] = true;
            StringBuilder sb = new StringBuilder();
            sb.append(repoUri2);
            sb.append('/');
            repoUri2 = sb.toString();
            $jacocoInit[57] = true;
            Logger instance = Logger.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(repoUri2);
            String sb3 = sb2.toString();
            $jacocoInit[58] = true;
            instance.mo2136d(str4, sb3);
            $jacocoInit[59] = true;
        }
        if (repoUri2.startsWith(str2)) {
            $jacocoInit[60] = true;
        } else {
            $jacocoInit[61] = true;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append(repoUri2);
            repoUri2 = sb4.toString();
            $jacocoInit[62] = true;
            Logger instance2 = Logger.getInstance();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str3);
            sb5.append(repoUri2);
            String sb6 = sb5.toString();
            $jacocoInit[63] = true;
            instance2.mo2136d(str4, sb6);
            $jacocoInit[64] = true;
        }
        $jacocoInit[65] = true;
        return repoUri2;
    }

    public static List<Long> getSubscribedStoresIds(StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Long> storesNames = new LinkedList<>();
        $jacocoInit[66] = true;
        C0120S all = storeAccessor.getAll();
        $jacocoInit[67] = true;
        C14906b k = all.mo3672k();
        $jacocoInit[68] = true;
        List<p005cm.aptoide.p006pt.database.realm.Store> stores = (List) k.mo46110a();
        $jacocoInit[69] = true;
        $jacocoInit[70] = true;
        for (p005cm.aptoide.p006pt.database.realm.Store store : stores) {
            $jacocoInit[71] = true;
            storesNames.add(Long.valueOf(store.getStoreId()));
            $jacocoInit[72] = true;
        }
        $jacocoInit[73] = true;
        return storesNames;
    }

    public static HashMapNotNull<String, List<String>> getSubscribedStoresAuthMap(StoreAccessor storeAccessor) {
        HashMapNotNull hashMapNotNull;
        boolean[] $jacocoInit = $jacocoInit();
        HashMapNotNull<String, List<String>> storesAuthMap = new HashMapNotNull<>();
        $jacocoInit[74] = true;
        C0120S all = storeAccessor.getAll();
        $jacocoInit[75] = true;
        C14906b k = all.mo3672k();
        $jacocoInit[76] = true;
        List<p005cm.aptoide.p006pt.database.realm.Store> stores = (List) k.mo46110a();
        $jacocoInit[77] = true;
        $jacocoInit[78] = true;
        for (p005cm.aptoide.p006pt.database.realm.Store store : stores) {
            $jacocoInit[79] = true;
            if (store.getPasswordSha1() == null) {
                $jacocoInit[80] = true;
            } else {
                $jacocoInit[81] = true;
                String storeName = store.getStoreName();
                $jacocoInit[82] = true;
                LinkedList linkedList = new LinkedList(Arrays.asList(new String[]{store.getUsername(), store.getPasswordSha1()}));
                $jacocoInit[83] = true;
                storesAuthMap.put(storeName, linkedList);
                $jacocoInit[84] = true;
            }
            $jacocoInit[85] = true;
        }
        if (storesAuthMap.size() > 0) {
            $jacocoInit[86] = true;
            hashMapNotNull = storesAuthMap;
        } else {
            hashMapNotNull = null;
            $jacocoInit[87] = true;
        }
        $jacocoInit[88] = true;
        return hashMapNotNull;
    }

    public static void unSubscribeStore(String name, AptoideAccountManager accountManager, StoreCredentialsProvider storeCredentialsProvider, StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = accountManager.accountStatus();
        C4938k kVar = C4938k.f8590a;
        $jacocoInit[89] = true;
        C0120S j = accountStatus.mo3669j(kVar);
        $jacocoInit[90] = true;
        C0120S d = j.mo3647d();
        C4934g gVar = new C4934g(accountManager, name, storeCredentialsProvider, storeAccessor);
        $jacocoInit[91] = true;
        d.mo3646c((C0129b<? super T>) gVar);
        $jacocoInit[92] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9266a(AptoideAccountManager accountManager, String name, StoreCredentialsProvider storeCredentialsProvider, StoreAccessor storeAccessor, Boolean isLoggedIn) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isLoggedIn.booleanValue()) {
            $jacocoInit[108] = true;
        } else {
            $jacocoInit[109] = true;
            StoreCredentials storeCredentials = storeCredentialsProvider.get(name);
            $jacocoInit[110] = true;
            String name2 = storeCredentials.getName();
            StoreCredentials storeCredentials2 = storeCredentialsProvider.get(name);
            $jacocoInit[111] = true;
            String passwordSha1 = storeCredentials2.getPasswordSha1();
            $jacocoInit[112] = true;
            accountManager.unsubscribeStore(name, name2, passwordSha1);
            $jacocoInit[113] = true;
        }
        storeAccessor.remove(name);
        $jacocoInit[114] = true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p005cm.aptoide.p006pt.store.StoreError getErrorType(java.lang.String r6) {
        /*
            boolean[] r0 = $jacocoInit()
            int r1 = r6.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1166288347: goto L_0x004c;
                case -1166288346: goto L_0x000e;
                case -1166288345: goto L_0x0039;
                case -1166288344: goto L_0x0026;
                case -1166288343: goto L_0x000e;
                case -1166288342: goto L_0x000e;
                case -1166288341: goto L_0x0013;
                default: goto L_0x000e;
            }
        L_0x000e:
            r1 = 93
            r0[r1] = r4
            goto L_0x005f
        L_0x0013:
            java.lang.String r1 = "STORE-7"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0020
            r1 = 98
            r0[r1] = r4
            goto L_0x005f
        L_0x0020:
            r1 = 99
            r0[r1] = r4
            r1 = 2
            goto L_0x0060
        L_0x0026:
            java.lang.String r1 = "STORE-4"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0033
            r1 = 94
            r0[r1] = r4
            goto L_0x005f
        L_0x0033:
            r1 = 0
            r5 = 95
            r0[r5] = r4
            goto L_0x0060
        L_0x0039:
            java.lang.String r1 = "STORE-3"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0046
            r1 = 96
            r0[r1] = r4
            goto L_0x005f
        L_0x0046:
            r1 = 97
            r0[r1] = r4
            r1 = 1
            goto L_0x0060
        L_0x004c:
            java.lang.String r1 = "STORE-1"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0059
            r1 = 100
            r0[r1] = r4
            goto L_0x005f
        L_0x0059:
            r1 = 101(0x65, float:1.42E-43)
            r0[r1] = r4
            r1 = 3
            goto L_0x0060
        L_0x005f:
            r1 = -1
        L_0x0060:
            if (r1 == 0) goto L_0x0084
            if (r1 == r4) goto L_0x007d
            if (r1 == r3) goto L_0x0076
            if (r1 == r2) goto L_0x006f
            cm.aptoide.pt.store.StoreError r1 = p005cm.aptoide.p006pt.store.StoreError.GENERIC_ERROR
            r2 = 106(0x6a, float:1.49E-43)
            r0[r2] = r4
            goto L_0x008a
        L_0x006f:
            cm.aptoide.pt.store.StoreError r1 = p005cm.aptoide.p006pt.store.StoreError.STORE_DOESNT_EXIST
            r2 = 105(0x69, float:1.47E-43)
            r0[r2] = r4
            goto L_0x008a
        L_0x0076:
            cm.aptoide.pt.store.StoreError r1 = p005cm.aptoide.p006pt.store.StoreError.STORE_SUSPENDED
            r2 = 104(0x68, float:1.46E-43)
            r0[r2] = r4
            goto L_0x008a
        L_0x007d:
            cm.aptoide.pt.store.StoreError r1 = p005cm.aptoide.p006pt.store.StoreError.PRIVATE_STORE_ERROR
            r2 = 103(0x67, float:1.44E-43)
            r0[r2] = r4
            goto L_0x008a
        L_0x0084:
            cm.aptoide.pt.store.StoreError r1 = p005cm.aptoide.p006pt.store.StoreError.PRIVATE_STORE_WRONG_CREDENTIALS
            r2 = 102(0x66, float:1.43E-43)
            r0[r2] = r4
        L_0x008a:
            r2 = 107(0x6b, float:1.5E-43)
            r0[r2] = r4
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.store.StoreUtils.getErrorType(java.lang.String):cm.aptoide.pt.store.StoreError");
    }
}
