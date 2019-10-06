package p005cm.aptoide.p006pt.store.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.HomeUser;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Badge;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.BadgeType;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannel;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Stats;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeMetaRequest;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.GridStoreMetaDisplayable */
public class GridStoreMetaDisplayable extends DisplayablePojo<GetHomeMeta> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int REQUEST_CODE = 53298475;
    private BadgeDialogFactory badgeDialogFactory;
    private BodyInterceptor<BaseBody> bodyInterceptorV7;
    private OkHttpClient client;
    private Factory converter;
    private FragmentNavigator fragmentNavigator;
    private SharedPreferences sharedPreferences;
    private StoreAccessor storeAccessor;
    private StoreAnalytics storeAnalytics;
    private StoreCredentialsProvider storeCredentialsProvider;
    private TokenInvalidator tokenInvalidator;

    /* renamed from: cm.aptoide.pt.store.view.GridStoreMetaDisplayable$1 */
    static /* synthetic */ class C49511 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType */
        static final /* synthetic */ int[] f8602x6cf1c276 = new int[BadgeType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8822472030794258043L, "cm/aptoide/pt/store/view/GridStoreMetaDisplayable$1", 12);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f8602x6cf1c276[BadgeType.BRONZE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                $jacocoInit[10] = true;
                            }
                        }
                    }
                }
            }
            f8602x6cf1c276[BadgeType.SILVER.ordinal()] = 2;
            $jacocoInit[3] = true;
            f8602x6cf1c276[BadgeType.GOLD.ordinal()] = 3;
            $jacocoInit[5] = true;
            f8602x6cf1c276[BadgeType.PLATINUM.ordinal()] = 4;
            $jacocoInit[7] = true;
            f8602x6cf1c276[BadgeType.NONE.ordinal()] = 5;
            $jacocoInit[9] = true;
            $jacocoInit[11] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8720317677253703780L, "cm/aptoide/pt/store/view/GridStoreMetaDisplayable", 128);
        $jacocoData = probes;
        return probes;
    }

    public GridStoreMetaDisplayable() {
        $jacocoInit()[0] = true;
    }

    public GridStoreMetaDisplayable(GetHomeMeta pojo, StoreCredentialsProvider storeCredentialsProvider2, StoreAnalytics storeAnalytics2, BadgeDialogFactory badgeDialogFactory2, FragmentNavigator fragmentNavigator2, StoreAccessor storeAccessor2, BodyInterceptor<BaseBody> bodyInterceptorV72, OkHttpClient client2, Factory converter2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.storeAnalytics = storeAnalytics2;
        this.badgeDialogFactory = badgeDialogFactory2;
        this.fragmentNavigator = fragmentNavigator2;
        this.storeAccessor = storeAccessor2;
        this.bodyInterceptorV7 = bodyInterceptorV72;
        this.client = client2;
        this.converter = converter2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_store_meta;
    }

    public List<SocialChannel> getSocialLinks() {
        List<SocialChannel> list;
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() == null) {
            $jacocoInit[4] = true;
        } else if (getStore().getSocialChannels() == null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[7] = true;
            list = getStore().getSocialChannels();
            $jacocoInit[8] = true;
            $jacocoInit[9] = true;
            return list;
        }
        list = Collections.EMPTY_LIST;
        $jacocoInit[6] = true;
        $jacocoInit[9] = true;
        return list;
    }

    public StoreCredentialsProvider getStoreCredentialsProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[10] = true;
        return storeCredentialsProvider2;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String name = getStore().getName();
        $jacocoInit[11] = true;
        return name;
    }

    public StoreAnalytics getStoreAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAnalytics storeAnalytics2 = this.storeAnalytics;
        $jacocoInit[12] = true;
        return storeAnalytics2;
    }

    public String getMainIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() != null) {
            $jacocoInit[13] = true;
            String avatar = getStore().getAvatar();
            $jacocoInit[14] = true;
            return avatar;
        }
        String userIcon = getUserIcon();
        $jacocoInit[15] = true;
        return userIcon;
    }

    public String getSecondaryIcon() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() == null) {
            str = null;
            $jacocoInit[16] = true;
        } else {
            str = getUserIcon();
            $jacocoInit[17] = true;
        }
        $jacocoInit[18] = true;
        return str;
    }

    public String getUserIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getUser() != null) {
            $jacocoInit[19] = true;
            String avatar = getUser().getAvatar();
            $jacocoInit[20] = true;
            return avatar;
        }
        $jacocoInit[21] = true;
        return null;
    }

    private HomeUser getUser() {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = ((GetHomeMeta) getPojo()).getData();
        $jacocoInit[22] = true;
        HomeUser user = data.getUser();
        $jacocoInit[23] = true;
        return user;
    }

    private Store getStore() {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = ((GetHomeMeta) getPojo()).getData();
        $jacocoInit[24] = true;
        Store store = data.getStore();
        $jacocoInit[25] = true;
        return store;
    }

    public String getMainName() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = getStore();
        if (store != null) {
            $jacocoInit[26] = true;
            String name = store.getName();
            $jacocoInit[27] = true;
            return name;
        }
        String userName = getUserName();
        $jacocoInit[28] = true;
        return userName;
    }

    private String getUserName() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (getUser() == null) {
            str = null;
            $jacocoInit[29] = true;
        } else {
            str = getUser().getName();
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
        return str;
    }

    public String getSecondaryName() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() != null) {
            $jacocoInit[32] = true;
            String userName = getUserName();
            $jacocoInit[33] = true;
            return userName;
        }
        $jacocoInit[34] = true;
        return null;
    }

    public long getAppsCount() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = getStore();
        if (store != null) {
            $jacocoInit[35] = true;
            Stats stats = store.getStats();
            $jacocoInit[36] = true;
            long apps = (long) stats.getApps();
            $jacocoInit[37] = true;
            return apps;
        }
        $jacocoInit[38] = true;
        return 0;
    }

    public long getFollowersCount() {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = ((GetHomeMeta) getPojo()).getData();
        $jacocoInit[39] = true;
        GetHomeMeta.Stats stats = data.getStats();
        $jacocoInit[40] = true;
        long followers = stats.getFollowers();
        $jacocoInit[41] = true;
        return followers;
    }

    public long getFollowingsCount() {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = ((GetHomeMeta) getPojo()).getData();
        $jacocoInit[42] = true;
        GetHomeMeta.Stats stats = data.getStats();
        $jacocoInit[43] = true;
        long following = stats.getFollowing();
        $jacocoInit[44] = true;
        return following;
    }

    public C0120S<Boolean> isStoreOwner(AptoideAccountManager accountManager) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = accountManager.accountStatus();
        $jacocoInit[45] = true;
        C0120S d = accountStatus.mo3647d();
        C4965S s = new C4965S(this);
        $jacocoInit[46] = true;
        C0120S<Boolean> j = d.mo3669j(s);
        $jacocoInit[47] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo16502a(Account account) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() == null) {
            $jacocoInit[120] = true;
        } else if (account.getStore() == null) {
            $jacocoInit[121] = true;
        } else {
            p005cm.aptoide.accountmanager.Store store = account.getStore();
            $jacocoInit[122] = true;
            String name = store.getName();
            $jacocoInit[123] = true;
            if (!name.equals(getStore().getName())) {
                $jacocoInit[124] = true;
            } else {
                $jacocoInit[125] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[127] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[126] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[127] = true;
        return valueOf2;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = getStore();
        if (store != null) {
            $jacocoInit[48] = true;
            Appearance appearance = store.getAppearance();
            $jacocoInit[49] = true;
            String description = appearance.getDescription();
            $jacocoInit[50] = true;
            return description;
        }
        $jacocoInit[51] = true;
        return null;
    }

    public StoreTheme getStoreTheme() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Store store = getStore();
        $jacocoInit[52] = true;
        if (store == null) {
            $jacocoInit[53] = true;
        } else if (store.getAppearance() == null) {
            $jacocoInit[54] = true;
        } else {
            $jacocoInit[56] = true;
            Appearance appearance = store.getAppearance();
            $jacocoInit[57] = true;
            str = appearance.getTheme();
            $jacocoInit[58] = true;
            StoreTheme storeTheme = StoreTheme.get(str);
            $jacocoInit[59] = true;
            return storeTheme;
        }
        $jacocoInit[55] = true;
        str = BuildConfig.APTOIDE_THEME;
        StoreTheme storeTheme2 = StoreTheme.get(str);
        $jacocoInit[59] = true;
        return storeTheme2;
    }

    public long getStoreId() {
        long j;
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() == null) {
            j = 0;
            $jacocoInit[60] = true;
        } else {
            j = getStore().getId();
            $jacocoInit[61] = true;
        }
        $jacocoInit[62] = true;
        return j;
    }

    public boolean hasStore() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() != null) {
            $jacocoInit[63] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[64] = true;
        }
        $jacocoInit[65] = true;
        return z;
    }

    public Badge getBadge() {
        boolean[] $jacocoInit = $jacocoInit();
        if (hasStore()) {
            $jacocoInit[66] = true;
            int[] iArr = C49511.f8602x6cf1c276;
            Data data = ((GetHomeMeta) getPojo()).getData();
            $jacocoInit[67] = true;
            Store store = data.getStore();
            $jacocoInit[68] = true;
            Badge badge = store.getBadge();
            $jacocoInit[69] = true;
            BadgeType name = badge.getName();
            $jacocoInit[70] = true;
            int i = iArr[name.ordinal()];
            if (i == 1) {
                Badge badge2 = Badge.BRONZE;
                $jacocoInit[71] = true;
                return badge2;
            } else if (i == 2) {
                Badge badge3 = Badge.SILVER;
                $jacocoInit[72] = true;
                return badge3;
            } else if (i == 3) {
                Badge badge4 = Badge.GOLD;
                $jacocoInit[73] = true;
                return badge4;
            } else if (i == 4) {
                Badge badge5 = Badge.PLATINUM;
                $jacocoInit[74] = true;
                return badge5;
            } else if (i != 5) {
                Badge badge6 = Badge.NONE;
                $jacocoInit[76] = true;
                return badge6;
            } else {
                Badge badge7 = Badge.TIN;
                $jacocoInit[75] = true;
                return badge7;
            }
        } else {
            Badge badge8 = Badge.NONE;
            $jacocoInit[77] = true;
            return badge8;
        }
    }

    public C0120S<HomeMeta> getHomeMeta(AptoideAccountManager accountManager, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isFollowingStore = isFollowingStore(this.storeAccessor);
        $jacocoInit[78] = true;
        C0120S f = updateStoreMeta().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C4962P<Object,Object>(this));
        $jacocoInit[79] = true;
        C0120S d = f.mo3647d();
        $jacocoInit[80] = true;
        C0120S b = C0120S.m649b(isFollowingStore, d);
        C4957L l = new C4957L(this, accountManager, context);
        $jacocoInit[81] = true;
        C0120S<HomeMeta> f2 = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) l);
        $jacocoInit[82] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16505a(GetHomeMeta __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isFollowingStore = isFollowingStore(this.storeAccessor);
        $jacocoInit[119] = true;
        return isFollowingStore;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16504a(AptoideAccountManager accountManager, Context context, Boolean isFollowing) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S j = isStoreOwner(accountManager).mo3669j(new C4956K(this, isFollowing, context));
        $jacocoInit[113] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ HomeMeta mo16501a(Boolean isFollowing, Context context, Boolean isOwner) {
        boolean[] $jacocoInit = $jacocoInit();
        String mainIcon = getMainIcon();
        String secondaryIcon = getSecondaryIcon();
        $jacocoInit[114] = true;
        String mainName = getMainName();
        String secondaryName = getSecondaryName();
        boolean booleanValue = isOwner.booleanValue();
        boolean hasStore = hasStore();
        boolean booleanValue2 = isFollowing.booleanValue();
        $jacocoInit[115] = true;
        List socialLinks = getSocialLinks();
        long appsCount = getAppsCount();
        long followersCount = getFollowersCount();
        long followingsCount = getFollowingsCount();
        $jacocoInit[116] = true;
        String description = getDescription();
        StoreTheme storeTheme = getStoreTheme();
        String str = mainIcon;
        String str2 = secondaryIcon;
        int colorOrDefault = getColorOrDefault(getStoreTheme(), context);
        $jacocoInit[117] = true;
        HomeMeta homeMeta = new HomeMeta(str, str2, mainName, secondaryName, booleanValue, hasStore, booleanValue2, socialLinks, appsCount, followersCount, followingsCount, description, storeTheme, colorOrDefault, getStoreId(), hasStore(), getBadge());
        $jacocoInit[118] = true;
        return homeMeta;
    }

    private C0120S<GetHomeMeta> updateStoreMeta() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S results = this.fragmentNavigator.results(REQUEST_CODE);
        C4958M m = C4958M.f8613a;
        $jacocoInit[83] = true;
        C0120S d = results.mo3653d((C0132p<? super T, Boolean>) m);
        C4961O o = new C4961O(this);
        $jacocoInit[84] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) o);
        C4964Q q = new C4964Q(this);
        $jacocoInit[85] = true;
        C0120S<GetHomeMeta> b = f.mo3636b((C0129b<? super T>) q);
        $jacocoInit[86] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9306a(Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getResultCode() == -1) {
            $jacocoInit[110] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[111] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[112] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16506b(Result __) {
        boolean[] $jacocoInit = $jacocoInit();
        GetHomeMetaRequest of = GetHomeMetaRequest.m7578of(this.storeCredentialsProvider.get(getStoreId()), this.bodyInterceptorV7, this.client, this.converter, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[108] = true;
        C0120S observe = of.observe(true, true);
        $jacocoInit[109] = true;
        return observe;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16507b(GetHomeMeta pojo) {
        boolean[] $jacocoInit = $jacocoInit();
        setPojo(pojo);
        $jacocoInit[107] = true;
    }

    private int getColorOrDefault(StoreTheme theme, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 23) {
            $jacocoInit[87] = true;
            Resources resources = context.getResources();
            $jacocoInit[88] = true;
            int color = resources.getColor(theme.getPrimaryColor(), context.getTheme());
            $jacocoInit[89] = true;
            return color;
        }
        Resources resources2 = context.getResources();
        $jacocoInit[90] = true;
        int color2 = resources2.getColor(theme.getPrimaryColor());
        $jacocoInit[91] = true;
        return color2;
    }

    public C0120S<Boolean> isFollowingStore(StoreAccessor storeAccessor2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (getStore() != null) {
            $jacocoInit[92] = true;
            C0120S all = storeAccessor2.getAll();
            C4960N n = new C4960N(this);
            $jacocoInit[93] = true;
            C0120S j = all.mo3669j(n);
            $jacocoInit[94] = true;
            C0120S<Boolean> b = j.mo3628b();
            $jacocoInit[95] = true;
            return b;
        }
        C0120S<Boolean> c = C0120S.m652c(Boolean.valueOf(false));
        $jacocoInit[96] = true;
        return c;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.database.realm.Store>, for r7v0, types: [java.util.List, java.util.List<cm.aptoide.pt.database.realm.Store>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.lang.Boolean mo16503a(java.util.List<p005cm.aptoide.p006pt.database.realm.Store> r7) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            java.util.Iterator r1 = r7.iterator()
            r2 = 1
            r3 = 100
            r0[r3] = r2
        L_0x000d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0041
            java.lang.Object r3 = r1.next()
            cm.aptoide.pt.database.realm.Store r3 = (p005cm.aptoide.p006pt.database.realm.Store) r3
            r4 = 101(0x65, float:1.42E-43)
            r0[r4] = r2
            java.lang.String r4 = r3.getStoreName()
            r5 = 102(0x66, float:1.43E-43)
            r0[r5] = r2
            java.lang.String r5 = r6.getStoreName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x003c
            r1 = 103(0x67, float:1.44E-43)
            r0[r1] = r2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r4 = 104(0x68, float:1.46E-43)
            r0[r4] = r2
            return r1
        L_0x003c:
            r3 = 105(0x69, float:1.47E-43)
            r0[r3] = r2
            goto L_0x000d
        L_0x0041:
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r3 = 106(0x6a, float:1.49E-43)
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.store.view.GridStoreMetaDisplayable.mo16503a(java.util.List):java.lang.Boolean");
    }

    public long getUserId() {
        boolean[] $jacocoInit = $jacocoInit();
        long id = getUser().getId();
        $jacocoInit[97] = true;
        return id;
    }

    public BadgeDialogFactory getBadgeDialogFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        BadgeDialogFactory badgeDialogFactory2 = this.badgeDialogFactory;
        $jacocoInit[98] = true;
        return badgeDialogFactory2;
    }

    public int getRequestCode() {
        $jacocoInit()[99] = true;
        return REQUEST_CODE;
    }
}
