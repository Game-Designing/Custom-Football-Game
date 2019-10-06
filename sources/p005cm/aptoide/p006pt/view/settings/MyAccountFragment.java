package p005cm.aptoide.p006pt.view.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.C0510b;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.CardView;
import android.support.p001v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.accountmanager.Store;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.MyAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.link.CustomTabsHelper;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.view.BackButtonFragment;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.view.settings.MyAccountFragment */
public class MyAccountFragment extends BackButtonFragment implements OnSharedPreferenceChangeListener, MyAccountView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final float STROKE_SIZE = 0.04f;
    @Inject
    AccountAnalytics accountAnalytics;
    private AptoideAccountManager accountManager;
    private View accountView;
    private CardView aptoideBackupAppsCardView;
    private CardView aptoideTvCardView;
    private CardView aptoideUploaderCardView;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Factory converterFactory;
    private Button createStoreButton;
    private TextView createStoreMessage;
    private Button editProfileButton;
    private Button editStoreButton;
    private OkHttpClient httpClient;
    private Button loginButton;
    private View loginView;
    private Button logoutButton;
    @Inject
    MarketResourceFormatter marketFormatter;
    @Inject
    String marketName;
    private ImageView myAccountAvatar;
    @Inject
    MyAccountManager myAccountManager;
    private TextView myAccountName;
    @Inject
    MyAccountNavigator myAccountNavigator;
    private TextView myAccountProductCardTitle;
    private View myProfileView;
    private ImageView myStoreAvatar;
    private TextView myStoreName;
    private View myStoreView;
    private View notificationHistory;
    private View settings;
    @Inject
    String theme;
    protected Toolbar toolbar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7187298392499336793L, "cm/aptoide/pt/view/settings/MyAccountFragment", Opcodes.IF_ACMPNE);
        $jacocoData = probes;
        return probes;
    }

    public MyAccountFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountFragment myAccountFragment = new MyAccountFragment();
        $jacocoInit[1] = true;
        return myAccountFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[4] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[5] = true;
        this.bodyInterceptor = application.getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[6] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[7] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[8] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[9] = true;
        TextView textView = (TextView) view.findViewById(C1375R.C1376id.sign_in_message);
        Object[] objArr = {this.marketName};
        $jacocoInit[10] = true;
        String string = getString(C1375R.string.newaccount_signin_message, objArr);
        $jacocoInit[11] = true;
        textView.setText(string);
        $jacocoInit[12] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[13] = true;
        this.notificationHistory = view.findViewById(C1375R.C1376id.notifications_history);
        $jacocoInit[14] = true;
        this.settings = view.findViewById(C1375R.C1376id.settings);
        $jacocoInit[15] = true;
        this.myAccountProductCardTitle = (TextView) view.findViewById(C1375R.C1376id.my_account_product_card_title);
        TextView textView2 = this.myAccountProductCardTitle;
        MarketResourceFormatter marketResourceFormatter = this.marketFormatter;
        $jacocoInit[16] = true;
        String formatString = marketResourceFormatter.formatString(getContext(), C1375R.string.my_account_product_card_section_title, new String[0]);
        $jacocoInit[17] = true;
        textView2.setText(formatString);
        $jacocoInit[18] = true;
        setAccountViews(view);
        $jacocoInit[19] = true;
        setupToolbar();
        $jacocoInit[20] = true;
        setupProductCardViews();
        $jacocoInit[21] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[22] = true;
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[23] = true;
        MyAccountPresenter myAccountPresenter = new MyAccountPresenter(this, aptoideAccountManager, instance, application.getDefaultSharedPreferences(), C14522a.m46170a(), this.myAccountNavigator, this.accountAnalytics);
        $jacocoInit[24] = true;
        attachPresenter(myAccountPresenter);
        $jacocoInit[25] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[26] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[27] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[28] = true;
        return build;
    }

    private void setupProductCardViews() {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = (TextView) this.aptoideTvCardView.findViewById(C1375R.C1376id.product_title_textview);
        $jacocoInit[29] = true;
        String string = getString(C1375R.string.product_card_aptoide_tv_title);
        $jacocoInit[30] = true;
        textView.setText(string);
        $jacocoInit[31] = true;
        TextView textView2 = (TextView) this.aptoideTvCardView.findViewById(C1375R.C1376id.product_subtitle_textview);
        $jacocoInit[32] = true;
        String string2 = getString(C1375R.string.product_card_aptoide_tv_subtitle);
        $jacocoInit[33] = true;
        textView2.setText(string2);
        $jacocoInit[34] = true;
        ImageView imageView = (ImageView) this.aptoideTvCardView.findViewById(C1375R.C1376id.product_icon_imageview);
        $jacocoInit[35] = true;
        Drawable c = C0510b.m2572c(getContext(), C1375R.drawable.ic_product_tv);
        $jacocoInit[36] = true;
        imageView.setImageDrawable(c);
        $jacocoInit[37] = true;
        TextView textView3 = (TextView) this.aptoideUploaderCardView.findViewById(C1375R.C1376id.product_title_textview);
        $jacocoInit[38] = true;
        String string3 = getString(C1375R.string.product_card_aptoide_uploader_title);
        $jacocoInit[39] = true;
        textView3.setText(string3);
        $jacocoInit[40] = true;
        TextView textView4 = (TextView) this.aptoideUploaderCardView.findViewById(C1375R.C1376id.product_subtitle_textview);
        $jacocoInit[41] = true;
        String string4 = getString(C1375R.string.product_card_aptoide_uploader_subtitle);
        $jacocoInit[42] = true;
        textView4.setText(string4);
        $jacocoInit[43] = true;
        ImageView imageView2 = (ImageView) this.aptoideUploaderCardView.findViewById(C1375R.C1376id.product_icon_imageview);
        $jacocoInit[44] = true;
        Drawable c2 = C0510b.m2572c(getContext(), C1375R.drawable.ic_product_uploader);
        $jacocoInit[45] = true;
        imageView2.setImageDrawable(c2);
        $jacocoInit[46] = true;
        TextView textView5 = (TextView) this.aptoideBackupAppsCardView.findViewById(C1375R.C1376id.product_title_textview);
        $jacocoInit[47] = true;
        String string5 = getString(C1375R.string.product_card_aptoide_backup_apps_title);
        $jacocoInit[48] = true;
        textView5.setText(string5);
        $jacocoInit[49] = true;
        TextView textView6 = (TextView) this.aptoideBackupAppsCardView.findViewById(C1375R.C1376id.product_subtitle_textview);
        $jacocoInit[50] = true;
        String string6 = getString(C1375R.string.product_card_aptoide_backup_apps_subtitle);
        $jacocoInit[51] = true;
        textView6.setText(string6);
        $jacocoInit[52] = true;
        ImageView imageView3 = (ImageView) this.aptoideBackupAppsCardView.findViewById(C1375R.C1376id.product_icon_imageview);
        $jacocoInit[53] = true;
        Drawable c3 = C0510b.m2572c(getContext(), C1375R.drawable.ic_product_backup_apps);
        $jacocoInit[54] = true;
        imageView3.setImageDrawable(c3);
        $jacocoInit[55] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.myProfileView = null;
        this.myStoreView = null;
        this.loginView = null;
        this.accountView = null;
        this.createStoreMessage = null;
        this.myAccountAvatar = null;
        this.myAccountName = null;
        this.myStoreName = null;
        this.loginButton = null;
        this.logoutButton = null;
        this.createStoreButton = null;
        this.editStoreButton = null;
        this.editProfileButton = null;
        this.aptoideBackupAppsCardView = null;
        this.aptoideTvCardView = null;
        this.aptoideUploaderCardView = null;
        $jacocoInit[56] = true;
        super.onDestroyView();
        $jacocoInit[57] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_my_account, container, false);
        $jacocoInit[58] = true;
        return inflate;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        $jacocoInit()[59] = true;
    }

    public void showAccount(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(account.getEmail())) {
            $jacocoInit[60] = true;
            showLoginAccountDisplayable();
            $jacocoInit[61] = true;
        } else {
            Store store = account.getStore();
            $jacocoInit[62] = true;
            String name = store.getName();
            $jacocoInit[63] = true;
            if (name.isEmpty()) {
                $jacocoInit[64] = true;
                showAccountNoStoreDisplayable();
                $jacocoInit[65] = true;
                setUserProfile(account);
                $jacocoInit[66] = true;
            } else {
                showAccountAndStoreDisplayable();
                $jacocoInit[67] = true;
                setUserProfile(account);
                $jacocoInit[68] = true;
                Store store2 = account.getStore();
                $jacocoInit[69] = true;
                String name2 = store2.getName();
                Store store3 = account.getStore();
                $jacocoInit[70] = true;
                String avatar = store3.getAvatar();
                $jacocoInit[71] = true;
                setUserStore(name2, avatar);
                $jacocoInit[72] = true;
            }
        }
        $jacocoInit[73] = true;
    }

    public C0120S<Void> loginClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.loginButton);
        $jacocoInit[74] = true;
        return a;
    }

    public C0120S<Void> signOutClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.logoutButton);
        $jacocoInit[75] = true;
        return a;
    }

    public C0120S<Void> storeClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.myStoreView);
        $jacocoInit[76] = true;
        return a;
    }

    public C0120S<Void> userClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.myProfileView);
        $jacocoInit[77] = true;
        return a;
    }

    public C0120S<Void> editStoreClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.editStoreButton);
        $jacocoInit[78] = true;
        return a;
    }

    public C0120S<Void> editUserProfileClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.editProfileButton);
        $jacocoInit[79] = true;
        return a;
    }

    public C0120S<Void> settingsClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.settings);
        $jacocoInit[80] = true;
        return a;
    }

    public C0120S<Void> notificationsClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.notificationHistory);
        $jacocoInit[81] = true;
        return a;
    }

    public C0120S<GetStore> getStore() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[82] = true;
        C0120S d = accountStatus.mo3647d();
        C5461b bVar = new C5461b(this);
        $jacocoInit[83] = true;
        C0120S<GetStore> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bVar);
        $jacocoInit[84] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo17389a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[157] = true;
        Store store = account.getStore();
        $jacocoInit[158] = true;
        StoreCredentials storeCredentials = new StoreCredentials(store.getName(), (String) null, (String) null);
        StoreContext storeContext = StoreContext.meta;
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        $jacocoInit[159] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[160] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[161] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[162] = true;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        $jacocoInit[163] = true;
        GetStoreRequest of = GetStoreRequest.m7583of(storeCredentials, storeContext, bodyInterceptor2, okHttpClient, factory, tokenInvalidator, defaultSharedPreferences, resources, windowManager);
        $jacocoInit[164] = true;
        C0120S observe = of.observe();
        $jacocoInit[165] = true;
        return observe;
    }

    public C0120S<Void> aptoideTvCardViewClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.aptoideTvCardView);
        $jacocoInit[85] = true;
        return a;
    }

    public C0120S<Void> aptoideUploaderCardViewClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.aptoideUploaderCardView);
        $jacocoInit[86] = true;
        return a;
    }

    public C0120S<Void> aptoideBackupCardViewClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.aptoideBackupAppsCardView);
        $jacocoInit[87] = true;
        return a;
    }

    public void startAptoideTvWebView() {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        $jacocoInit[88] = true;
        instance.openInChromeCustomTab("https://blog.aptoide.com/what-is-aptoidetv/", getContext(), this.theme);
        $jacocoInit[89] = true;
    }

    public void refreshUI(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myStoreName.setText(store.getName());
        $jacocoInit[90] = true;
        setUserStore(store.getName(), store.getAvatar());
        $jacocoInit[91] = true;
    }

    public void showLoginAccountDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginView.setVisibility(0);
        $jacocoInit[92] = true;
        this.accountView.setVisibility(8);
        $jacocoInit[93] = true;
    }

    public C0120S<Void> createStoreClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.createStoreButton);
        $jacocoInit[94] = true;
        return a;
    }

    private void showAccountNoStoreDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginView.setVisibility(8);
        $jacocoInit[95] = true;
        this.accountView.setVisibility(0);
        $jacocoInit[96] = true;
        this.myProfileView.setVisibility(0);
        $jacocoInit[97] = true;
        this.myStoreView.setVisibility(8);
        $jacocoInit[98] = true;
        if (this.myAccountManager.shouldShowCreateStore()) {
            $jacocoInit[99] = true;
            this.createStoreButton.setVisibility(0);
            $jacocoInit[100] = true;
            this.createStoreMessage.setVisibility(0);
            $jacocoInit[101] = true;
        } else {
            this.createStoreButton.setVisibility(8);
            $jacocoInit[102] = true;
            this.createStoreMessage.setVisibility(8);
            $jacocoInit[103] = true;
        }
        $jacocoInit[104] = true;
    }

    private void showAccountAndStoreDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginView.setVisibility(8);
        $jacocoInit[105] = true;
        this.accountView.setVisibility(0);
        $jacocoInit[106] = true;
        this.myProfileView.setVisibility(0);
        $jacocoInit[107] = true;
        this.myStoreView.setVisibility(0);
        $jacocoInit[108] = true;
        this.createStoreButton.setVisibility(8);
        $jacocoInit[109] = true;
        this.createStoreMessage.setVisibility(8);
        $jacocoInit[110] = true;
    }

    private void setUserProfile(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!TextUtils.isEmpty(account.getNickname())) {
            $jacocoInit[111] = true;
            this.myAccountName.setText(account.getNickname());
            $jacocoInit[112] = true;
        } else {
            this.myAccountName.setText(account.getEmail());
            $jacocoInit[113] = true;
        }
        if (TextUtils.isEmpty(account.getAvatar())) {
            $jacocoInit[114] = true;
        } else {
            $jacocoInit[115] = true;
            String userAvatarUrl = account.getAvatar();
            $jacocoInit[116] = true;
            String userAvatarUrl2 = userAvatarUrl.replace("50", "150");
            $jacocoInit[117] = true;
            ImageLoader with = ImageLoader.with(getContext());
            ImageView imageView = this.myAccountAvatar;
            $jacocoInit[118] = true;
            with.loadWithShadowCircleTransformWithPlaceholder(userAvatarUrl2, imageView, STROKE_SIZE, C1375R.drawable.my_account_placeholder);
            $jacocoInit[119] = true;
        }
        $jacocoInit[120] = true;
    }

    private void setUserStore(String storeName, String storeAvatar) {
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(storeName)) {
            $jacocoInit[121] = true;
        } else {
            $jacocoInit[122] = true;
            this.myStoreName.setText(storeName);
            $jacocoInit[123] = true;
            ImageLoader with = ImageLoader.with(getContext());
            ImageView imageView = this.myStoreAvatar;
            $jacocoInit[124] = true;
            with.loadWithShadowCircleTransformWithPlaceholder(storeAvatar, imageView, STROKE_SIZE, C1375R.drawable.my_account_placeholder);
            $jacocoInit[125] = true;
        }
        $jacocoInit[126] = true;
    }

    private void setAccountViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myProfileView = view.findViewById(C1375R.C1376id.my_profile);
        $jacocoInit[127] = true;
        this.myStoreView = view.findViewById(C1375R.C1376id.my_store);
        $jacocoInit[128] = true;
        this.accountView = view.findViewById(C1375R.C1376id.account_displayables);
        $jacocoInit[129] = true;
        this.loginView = view.findViewById(C1375R.C1376id.login_register_container);
        $jacocoInit[130] = true;
        this.myAccountAvatar = (ImageView) this.myProfileView.findViewById(C1375R.C1376id.user_icon);
        $jacocoInit[131] = true;
        this.myAccountName = (TextView) this.myProfileView.findViewById(C1375R.C1376id.description);
        $jacocoInit[132] = true;
        this.myStoreAvatar = (ImageView) this.myStoreView.findViewById(C1375R.C1376id.user_icon);
        $jacocoInit[133] = true;
        this.myStoreName = (TextView) this.myStoreView.findViewById(C1375R.C1376id.description);
        $jacocoInit[134] = true;
        TextView myStoreTitle = (TextView) this.myStoreView.findViewById(C1375R.C1376id.name);
        $jacocoInit[135] = true;
        myStoreTitle.setText(C1375R.string.newaccount_my_store);
        $jacocoInit[136] = true;
        TextView myAccountTitle = (TextView) this.myProfileView.findViewById(C1375R.C1376id.name);
        $jacocoInit[137] = true;
        myAccountTitle.setText(C1375R.string.newaccount_my_profile);
        $jacocoInit[138] = true;
        this.loginButton = (Button) view.findViewById(C1375R.C1376id.login_button);
        $jacocoInit[139] = true;
        this.logoutButton = (Button) view.findViewById(C1375R.C1376id.logout_button);
        $jacocoInit[140] = true;
        this.createStoreMessage = (TextView) view.findViewById(C1375R.C1376id.create_store_message);
        $jacocoInit[141] = true;
        this.createStoreButton = (Button) view.findViewById(C1375R.C1376id.create_store_button);
        $jacocoInit[142] = true;
        this.editStoreButton = (Button) this.myStoreView.findViewById(C1375R.C1376id.edit_button);
        $jacocoInit[143] = true;
        this.editProfileButton = (Button) this.myProfileView.findViewById(C1375R.C1376id.edit_button);
        $jacocoInit[144] = true;
        this.aptoideTvCardView = (CardView) view.findViewById(C1375R.C1376id.product_aptoideTv_cardview);
        $jacocoInit[145] = true;
        this.aptoideUploaderCardView = (CardView) view.findViewById(C1375R.C1376id.product_uploader_cardview);
        $jacocoInit[146] = true;
        this.aptoideBackupAppsCardView = (CardView) view.findViewById(C1375R.C1376id.product_backup_cardview);
        $jacocoInit[147] = true;
    }

    private void setupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar.setTitle((int) C1375R.string.my_account_title_my_account);
        $jacocoInit[148] = true;
        C0019n activity = (C0019n) getActivity();
        $jacocoInit[149] = true;
        activity.setSupportActionBar(this.toolbar);
        $jacocoInit[150] = true;
        C0760a actionBar = activity.getSupportActionBar();
        if (actionBar == null) {
            $jacocoInit[151] = true;
        } else {
            $jacocoInit[152] = true;
            actionBar.mo6153d(true);
            $jacocoInit[153] = true;
            actionBar.mo6147a(this.toolbar.getTitle());
            $jacocoInit[154] = true;
        }
        this.toolbar.setNavigationOnClickListener(new C5458a(this));
        $jacocoInit[155] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17390a(View v) {
        boolean[] $jacocoInit = $jacocoInit();
        getActivity().onBackPressed();
        $jacocoInit[156] = true;
    }
}
