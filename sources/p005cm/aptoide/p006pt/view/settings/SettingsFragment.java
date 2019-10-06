package p005cm.aptoide.p006pt.view.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.support.p001v7.preference.C0835s;
import android.support.p001v7.preference.EditTextPreference;
import android.support.p001v7.preference.Preference;
import android.support.p001v7.preference.Preference.C0813c;
import android.support.p001v7.preference.PreferenceCategory;
import android.support.p001v7.preference.SwitchPreferenceCompat;
import android.support.p001v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.SettingsManager;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.file.FileManager;
import p005cm.aptoide.p006pt.link.CustomTabsHelper;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.Authentication;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.notification.NotificationSyncScheduler;
import p005cm.aptoide.p006pt.preferences.managed.ManagedKeys;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p005cm.aptoide.p006pt.updates.view.excluded.ExcludedUpdatesFragment;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.util.SettingsConstants;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.ActivityComponent;
import p005cm.aptoide.p006pt.view.BaseActivity;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.dialog.EditableTextDialog;
import p005cm.aptoide.p006pt.view.feedback.SendFeedbackFragment;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p005cm.aptoide.p006pt.view.p080rx.RxPreference;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.settings.SettingsFragment */
public class SettingsFragment extends C0835s implements OnSharedPreferenceChangeListener, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY = "Maturepin";
    private static final String ADULT_CONTENT_PREFERENCE_VIEW_KEY = "matureChkBox";
    private static final String ADULT_CONTENT_WITH_PIN_PREFERENCE_VIEW_KEY = "matureChkBoxWithPin";
    private static final String DELETE_ACCOUNT = "deleteAccount";
    private static final String EXCLUDED_UPDATES_PREFERENCE_KEY = "excludedUpdates";
    private static final String PRIVACY_POLICY_PREFERENCE_KEY = "privacyPolicy";
    private static final String REMOVE_ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY = "removeMaturepin";
    private static final String SEND_FEEDBACK_PREFERENCE_KEY = "sendFeedback";
    private static final String TAG = SettingsFragment.class.getSimpleName();
    private static final String TERMS_AND_CONDITIONS_PREFERENCE_KEY = "termsConditions";
    private AptoideAccountManager accountManager;
    private AdultContentAnalytics adultContentAnalytics;
    private RxAlertDialog adultContentConfirmationDialog;
    private SwitchPreferenceCompat adultContentPreferenceView;
    private SwitchPreferenceCompat adultContentWithPinPreferenceView;
    private AuthenticationPersistence authenticationPersistence;
    private Context context;
    private Preference deleteAccount;
    private EditableTextDialog enableAdultContentPinDialog;
    private Preference excludedUpdates;
    private FileManager fileManager;
    private FragmentNavigator fragmentNavigator;
    @Inject
    String marketName;
    @Inject
    MarketResourceFormatter marketResourceFormatter;
    private NotificationSyncScheduler notificationSyncScheduler;
    private Preference pinPreferenceView;
    private Preference privacyPolicy;
    private EditableTextDialog removePinDialog;
    private Preference removePinPreferenceView;
    private UpdateRepository repository;
    private Preference sendFeedback;
    private EditableTextDialog setPinDialog;
    private SettingsManager settingsManager;
    private SharedPreferences sharedPreferences;
    private SwitchPreferenceCompat socialCampaignNotifications;
    private C0136c subscriptions;
    @Inject
    SupportEmailProvider supportEmailProvider;
    private Preference termsAndConditions;
    @Inject
    String theme;
    protected Toolbar toolbar;
    private boolean trackAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7408682470466990548L, "cm/aptoide/pt/view/settings/SettingsFragment", 373);
        $jacocoData = probes;
        return probes;
    }

    public SettingsFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ SharedPreferences access$000(SettingsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences sharedPreferences2 = x0.sharedPreferences;
        $jacocoInit[370] = true;
        return sharedPreferences2;
    }

    static /* synthetic */ Context access$100(SettingsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context2 = x0.context;
        $jacocoInit[371] = true;
        return context2;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[372] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        SettingsFragment settingsFragment = new SettingsFragment();
        $jacocoInit[1] = true;
        return settingsFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        ActivityComponent activityComponent = ((BaseActivity) getContext()).getActivityComponent();
        $jacocoInit[3] = true;
        activityComponent.inject(this);
        $jacocoInit[4] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        this.trackAnalytics = true;
        $jacocoInit[5] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[6] = true;
        this.fileManager = ((AptoideApplication) getContext().getApplicationContext()).getFileManager();
        $jacocoInit[7] = true;
        this.subscriptions = new C0136c();
        $jacocoInit[8] = true;
        this.fragmentNavigator = ((ActivityResultNavigator) getActivity()).getFragmentNavigator();
        $jacocoInit[9] = true;
        this.authenticationPersistence = application.getAuthenticationPersistence();
        $jacocoInit[10] = true;
        this.notificationSyncScheduler = ((AptoideApplication) getContext().getApplicationContext()).getNotificationSyncScheduler();
        $jacocoInit[11] = true;
        NavigationTracker navigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
        $jacocoInit[12] = true;
        Context context2 = getContext();
        $jacocoInit[13] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[14] = true;
        this.repository = RepositoryFactory.getUpdateRepository(context2, defaultSharedPreferences);
        $jacocoInit[15] = true;
        Class cls = getClass();
        $jacocoInit[16] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[17] = true;
        navigationTracker.registerScreen(Builder.build(simpleName));
        $jacocoInit[18] = true;
        this.adultContentAnalytics = application.getAdultContentAnalytics();
        $jacocoInit[19] = true;
        this.settingsManager = ((AptoideApplication) getContext().getApplicationContext()).getSettingsManager();
        $jacocoInit[20] = true;
        setAdultContentContent();
        $jacocoInit[21] = true;
    }

    public void onCreatePreferences(Bundle bundle, String s) {
        boolean[] $jacocoInit = $jacocoInit();
        addPreferencesFromResource(C1375R.xml.settings);
        $jacocoInit[22] = true;
        this.sharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[23] = true;
        this.sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        $jacocoInit[24] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[25] = true;
        return onCreateView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[26] = true;
        this.context = getContext();
        $jacocoInit[27] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[28] = true;
        C0019n parentActivity = (C0019n) getActivity();
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            parentActivity.setSupportActionBar(toolbar2);
            $jacocoInit[31] = true;
            this.toolbar.setTitle((int) C1375R.string.settings_title_settings);
            $jacocoInit[32] = true;
            this.toolbar.setNavigationOnClickListener(new C5520ub(this));
            $jacocoInit[33] = true;
            C0760a supportActionBar = parentActivity.getSupportActionBar();
            if (supportActionBar == null) {
                $jacocoInit[34] = true;
            } else {
                $jacocoInit[35] = true;
                supportActionBar.mo6153d(true);
                $jacocoInit[36] = true;
            }
        }
        setAdultContentViews();
        $jacocoInit[37] = true;
        this.excludedUpdates = findPreference(EXCLUDED_UPDATES_PREFERENCE_KEY);
        $jacocoInit[38] = true;
        this.sendFeedback = findPreference(SEND_FEEDBACK_PREFERENCE_KEY);
        $jacocoInit[39] = true;
        setGDPR();
        $jacocoInit[40] = true;
        this.deleteAccount = findPreference(DELETE_ACCOUNT);
        $jacocoInit[41] = true;
        this.socialCampaignNotifications = (SwitchPreferenceCompat) findPreference(ManagedKeys.CAMPAIGN_SOCIAL_NOTIFICATIONS_PREFERENCE_VIEW_KEY);
        $jacocoInit[42] = true;
        setupClickHandlers();
        $jacocoInit[43] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17498a(View v) {
        boolean[] $jacocoInit = $jacocoInit();
        getActivity().onBackPressed();
        $jacocoInit[369] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.subscriptions.mo3712a();
        this.toolbar = null;
        this.adultContentPreferenceView = null;
        this.adultContentWithPinPreferenceView = null;
        this.socialCampaignNotifications = null;
        this.pinPreferenceView = null;
        this.removePinPreferenceView = null;
        this.excludedUpdates = null;
        this.sendFeedback = null;
        this.termsAndConditions = null;
        this.privacyPolicy = null;
        this.deleteAccount = null;
        this.context = null;
        $jacocoInit[44] = true;
        super.onDestroyView();
        $jacocoInit[45] = true;
    }

    private void setGDPR() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean showGDPR = this.settingsManager.showGDPR();
        String str = PRIVACY_POLICY_PREFERENCE_KEY;
        String str2 = TERMS_AND_CONDITIONS_PREFERENCE_KEY;
        if (showGDPR) {
            $jacocoInit[46] = true;
            this.termsAndConditions = findPreference(str2);
            $jacocoInit[47] = true;
            this.privacyPolicy = findPreference(str);
            $jacocoInit[48] = true;
        } else {
            PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("about");
            $jacocoInit[49] = true;
            Preference termsAndConditionsPreference = findPreference(str2);
            $jacocoInit[50] = true;
            Preference privacyPolicyPreference = findPreference(str);
            if (termsAndConditionsPreference == null) {
                $jacocoInit[51] = true;
            } else {
                $jacocoInit[52] = true;
                preferenceCategory.mo6399e(termsAndConditionsPreference);
                $jacocoInit[53] = true;
            }
            if (privacyPolicyPreference == null) {
                $jacocoInit[54] = true;
            } else {
                $jacocoInit[55] = true;
                preferenceCategory.mo6399e(privacyPolicyPreference);
                $jacocoInit[56] = true;
            }
        }
        $jacocoInit[57] = true;
    }

    private void setAdultContentContent() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.settingsManager.showAdultContent()) {
            $jacocoInit[58] = true;
        } else {
            $jacocoInit[59] = true;
            RxAlertDialog.Builder message = new RxAlertDialog.Builder(getContext()).setMessage(C1375R.string.are_you_adult);
            $jacocoInit[60] = true;
            RxAlertDialog.Builder positiveButton = message.setPositiveButton(C1375R.string.yes);
            $jacocoInit[61] = true;
            RxAlertDialog.Builder negativeButton = positiveButton.setNegativeButton(C1375R.string.f4266no);
            $jacocoInit[62] = true;
            this.adultContentConfirmationDialog = negativeButton.build();
            $jacocoInit[63] = true;
            PinDialog.Builder message2 = new PinDialog.Builder(getContext()).setMessage(C1375R.string.request_adult_pin);
            $jacocoInit[64] = true;
            PinDialog.Builder positiveButton2 = message2.setPositiveButton(C1375R.string.all_button_ok);
            $jacocoInit[65] = true;
            PinDialog.Builder negativeButton2 = positiveButton2.setNegativeButton(C1375R.string.cancel);
            $jacocoInit[66] = true;
            PinDialog.Builder view = negativeButton2.setView(C1375R.layout.dialog_requestpin);
            $jacocoInit[67] = true;
            PinDialog.Builder editText = view.setEditText(C1375R.C1376id.pininput);
            $jacocoInit[68] = true;
            this.enableAdultContentPinDialog = editText.build();
            $jacocoInit[69] = true;
            PinDialog.Builder message3 = new PinDialog.Builder(getContext()).setMessage(C1375R.string.request_adult_pin);
            $jacocoInit[70] = true;
            PinDialog.Builder positiveButton3 = message3.setPositiveButton(C1375R.string.all_button_ok);
            $jacocoInit[71] = true;
            PinDialog.Builder negativeButton3 = positiveButton3.setNegativeButton(C1375R.string.cancel);
            $jacocoInit[72] = true;
            PinDialog.Builder view2 = negativeButton3.setView(C1375R.layout.dialog_requestpin);
            $jacocoInit[73] = true;
            PinDialog.Builder editText2 = view2.setEditText(C1375R.C1376id.pininput);
            $jacocoInit[74] = true;
            this.removePinDialog = editText2.build();
            $jacocoInit[75] = true;
            PinDialog.Builder message4 = new PinDialog.Builder(getContext()).setMessage(C1375R.string.asksetadultpinmessage);
            $jacocoInit[76] = true;
            PinDialog.Builder positiveButton4 = message4.setPositiveButton(C1375R.string.all_button_ok);
            $jacocoInit[77] = true;
            PinDialog.Builder negativeButton4 = positiveButton4.setNegativeButton(C1375R.string.cancel);
            $jacocoInit[78] = true;
            PinDialog.Builder view3 = negativeButton4.setView(C1375R.layout.dialog_requestpin);
            $jacocoInit[79] = true;
            PinDialog.Builder editText3 = view3.setEditText(C1375R.C1376id.pininput);
            $jacocoInit[80] = true;
            this.setPinDialog = editText3.build();
            $jacocoInit[81] = true;
        }
        $jacocoInit[82] = true;
    }

    private void setAdultContentViews() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.settingsManager.showAdultContent()) {
            $jacocoInit[83] = true;
            this.adultContentPreferenceView = (SwitchPreferenceCompat) findPreference(ADULT_CONTENT_PREFERENCE_VIEW_KEY);
            $jacocoInit[84] = true;
            this.adultContentWithPinPreferenceView = (SwitchPreferenceCompat) findPreference(ADULT_CONTENT_WITH_PIN_PREFERENCE_VIEW_KEY);
            $jacocoInit[85] = true;
            this.pinPreferenceView = findPreference(ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY);
            $jacocoInit[86] = true;
            this.removePinPreferenceView = findPreference(REMOVE_ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY);
            $jacocoInit[87] = true;
        } else {
            PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("adultContent");
            if (preferenceCategory == null) {
                $jacocoInit[88] = true;
            } else {
                $jacocoInit[89] = true;
                getPreferenceScreen().mo6399e(preferenceCategory);
                $jacocoInit[90] = true;
            }
        }
        $jacocoInit[91] = true;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String key) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!shouldRefreshUpdates(key)) {
            $jacocoInit[92] = true;
        } else {
            $jacocoInit[93] = true;
            C0117M sync = this.repository.sync(true, false);
            C5433Oa oa = C5433Oa.f9246a;
            C5535zb zbVar = C5535zb.f9346a;
            $jacocoInit[94] = true;
            sync.mo3588a((C0128a) oa, (C0129b<? super Throwable>) zbVar);
            $jacocoInit[95] = true;
        }
        $jacocoInit[96] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m9743j() {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[367] = true;
        instance.mo2136d(str, "updates refreshed");
        $jacocoInit[368] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m9742d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[365] = true;
        instance.log(throwable);
        $jacocoInit[366] = true;
    }

    private void handleDeleteAccountVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S accountStatus = this.accountManager.accountStatus();
        C5472eb ebVar = new C5472eb(this);
        $jacocoInit[97] = true;
        C0120S b = accountStatus.mo3636b((C0129b<? super T>) ebVar);
        $jacocoInit[98] = true;
        C0137ja j = b.mo3670j();
        $jacocoInit[99] = true;
        cVar.mo3713a(j);
        $jacocoInit[100] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17499a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.deleteAccount.mo6372e(account.isLoggedIn());
        $jacocoInit[364] = true;
    }

    private boolean shouldRefreshUpdates(String key) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (key.equals(ManagedKeys.UPDATES_FILTER_ALPHA_BETA_KEY)) {
            $jacocoInit[101] = true;
        } else if (key.equals(ManagedKeys.HWSPECS_FILTER)) {
            $jacocoInit[102] = true;
        } else {
            $jacocoInit[103] = true;
            if (key.equals(ManagedKeys.UPDATES_SYSTEM_APPS_KEY)) {
                $jacocoInit[104] = true;
            } else {
                z = false;
                $jacocoInit[106] = true;
                $jacocoInit[107] = true;
                return z;
            }
        }
        $jacocoInit[105] = true;
        z = true;
        $jacocoInit[107] = true;
        return z;
    }

    private void setupClickHandlers() {
        boolean[] $jacocoInit = $jacocoInit();
        handleDeleteAccountVisibility();
        $jacocoInit[108] = true;
        Preference autoUpdatePreference = findPreference(SettingsConstants.CHECK_AUTO_UPDATE);
        $jacocoInit[109] = true;
        autoUpdatePreference.mo6358b((CharSequence) this.marketResourceFormatter.formatString(getContext(), C1375R.string.setting_category_autoupdate_title, new String[0]));
        $jacocoInit[110] = true;
        autoUpdatePreference.mo6318a((CharSequence) this.marketResourceFormatter.formatString(getContext(), C1375R.string.setting_category_autoupdate_message, new String[0]));
        $jacocoInit[111] = true;
        C0136c cVar = this.subscriptions;
        C0120S clicks = RxPreference.clicks(this.deleteAccount);
        C5446Ua ua = new C5446Ua(this);
        $jacocoInit[112] = true;
        C0120S i = clicks.mo3668i(ua);
        C5413Fb fb = C5413Fb.f9226a;
        $jacocoInit[113] = true;
        C0120S j = i.mo3669j(fb);
        $jacocoInit[114] = true;
        C0120S a = j.mo3616a(C14522a.m46170a());
        C5481hb hbVar = new C5481hb(this);
        $jacocoInit[115] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) hbVar);
        $jacocoInit[116] = true;
        C0137ja j2 = b.mo3670j();
        $jacocoInit[117] = true;
        cVar.mo3713a(j2);
        $jacocoInit[118] = true;
        C0136c cVar2 = this.subscriptions;
        C0120S clicks2 = RxPreference.clicks(this.socialCampaignNotifications);
        C5511rb rbVar = new C5511rb(this);
        $jacocoInit[119] = true;
        C0137ja c = clicks2.mo3646c((C0129b<? super T>) rbVar);
        $jacocoInit[120] = true;
        cVar2.mo3713a(c);
        $jacocoInit[121] = true;
        C0136c cVar3 = this.subscriptions;
        C0120S clicks3 = RxPreference.clicks(this.excludedUpdates);
        C5407Db db = new C5407Db(this);
        $jacocoInit[122] = true;
        C0137ja c2 = clicks3.mo3646c((C0129b<? super T>) db);
        $jacocoInit[123] = true;
        cVar3.mo3713a(c2);
        $jacocoInit[124] = true;
        C0136c cVar4 = this.subscriptions;
        C0120S clicks4 = RxPreference.clicks(this.sendFeedback);
        C5505pb pbVar = new C5505pb(this);
        $jacocoInit[125] = true;
        C0137ja c3 = clicks4.mo3646c((C0129b<? super T>) pbVar);
        $jacocoInit[126] = true;
        cVar4.mo3713a(c3);
        $jacocoInit[127] = true;
        if (!this.settingsManager.showGDPR()) {
            $jacocoInit[128] = true;
        } else {
            $jacocoInit[129] = true;
            C0136c cVar5 = this.subscriptions;
            C0120S clicks5 = RxPreference.clicks(this.termsAndConditions);
            C5437Qa qa = new C5437Qa(this);
            $jacocoInit[130] = true;
            C0137ja c4 = clicks5.mo3646c((C0129b<? super T>) qa);
            $jacocoInit[131] = true;
            cVar5.mo3713a(c4);
            $jacocoInit[132] = true;
            C0136c cVar6 = this.subscriptions;
            C0120S clicks6 = RxPreference.clicks(this.privacyPolicy);
            C5493lb lbVar = new C5493lb(this);
            $jacocoInit[133] = true;
            C0137ja c5 = clicks6.mo3646c((C0129b<? super T>) lbVar);
            $jacocoInit[134] = true;
            cVar6.mo3713a(c5);
            $jacocoInit[135] = true;
        }
        findPreference(SettingsConstants.FILTER_APPS).mo6348a((C0813c) new C5410Eb(this));
        $jacocoInit[136] = true;
        findPreference(SettingsConstants.CLEAR_CACHE).mo6348a((C0813c) new C5469db(this));
        $jacocoInit[137] = true;
        Preference hwSpecs = findPreference(SettingsConstants.HARDWARE_SPECS);
        $jacocoInit[138] = true;
        hwSpecs.mo6348a((C0813c) new C5478gb(this));
        CharSequence charSequence = SettingsConstants.MAX_FILE_CACHE;
        $jacocoInit[139] = true;
        EditTextPreference maxFileCache = (EditTextPreference) findPreference(charSequence);
        $jacocoInit[140] = true;
        maxFileCache.mo6348a((C0813c) new C0813c(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SettingsFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(8083199205130363347L, "cm/aptoide/pt/view/settings/SettingsFragment$1", 4);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean onPreferenceClick(Preference preference) {
                boolean[] $jacocoInit = $jacocoInit();
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                SettingsFragment settingsFragment = this.this$0;
                $jacocoInit[1] = true;
                String valueOf = String.valueOf(ManagerPreferences.getCacheLimit(SettingsFragment.access$000(settingsFragment)));
                $jacocoInit[2] = true;
                editTextPreference.mo6307d(valueOf);
                $jacocoInit[3] = true;
                return false;
            }
        });
        $jacocoInit[141] = true;
        Preference about = findPreference(SettingsConstants.ABOUT_DIALOG);
        $jacocoInit[142] = true;
        about.mo6348a((C0813c) new C0813c(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SettingsFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4883343923609413984L, "cm/aptoide/pt/view/settings/SettingsFragment$2", 31);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x011b  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0127  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onPreferenceClick(android.support.p001v7.preference.Preference r13) {
                /*
                    r12 = this;
                    boolean[] r0 = $jacocoInit()
                    cm.aptoide.pt.view.settings.SettingsFragment r1 = r12.this$0
                    android.content.Context r1 = p005cm.aptoide.p006pt.view.settings.SettingsFragment.access$100(r1)
                    android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
                    r2 = 1
                    r0[r2] = r2
                    r3 = 2131427435(0x7f0b006b, float:1.8476486E38)
                    r4 = 0
                    android.view.View r1 = r1.inflate(r3, r4)
                    java.lang.String r3 = ""
                    r4 = 2
                    r5 = 4
                    r6 = 0
                    r0[r4] = r2     // Catch:{ NameNotFoundException -> 0x0044 }
                    r4 = r6
                    cm.aptoide.pt.view.settings.SettingsFragment r7 = r12.this$0     // Catch:{ NameNotFoundException -> 0x0042 }
                    android.support.v4.app.p r7 = r7.getActivity()     // Catch:{ NameNotFoundException -> 0x0042 }
                    android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0042 }
                    cm.aptoide.pt.view.settings.SettingsFragment r8 = r12.this$0     // Catch:{ NameNotFoundException -> 0x0042 }
                    r9 = 3
                    r0[r9] = r2     // Catch:{ NameNotFoundException -> 0x0042 }
                    android.support.v4.app.p r8 = r8.getActivity()     // Catch:{ NameNotFoundException -> 0x0042 }
                    java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0042 }
                    android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r6)     // Catch:{ NameNotFoundException -> 0x0042 }
                    java.lang.String r7 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0042 }
                    r3 = r7
                    r0[r5] = r2
                    goto L_0x0056
                L_0x0042:
                    r7 = move-exception
                    goto L_0x0046
                L_0x0044:
                    r7 = move-exception
                    r4 = r6
                L_0x0046:
                    r8 = 5
                    r0[r8] = r2
                    cm.aptoide.pt.crashreports.CrashReport r8 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
                    r9 = 6
                    r0[r9] = r2
                    r8.log(r7)
                    r8 = 7
                    r0[r8] = r2     // Catch:{ NameNotFoundException -> 0x007a }
                L_0x0056:
                    cm.aptoide.pt.view.settings.SettingsFragment r7 = r12.this$0     // Catch:{ NameNotFoundException -> 0x007a }
                    android.support.v4.app.p r7 = r7.getActivity()     // Catch:{ NameNotFoundException -> 0x007a }
                    android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x007a }
                    cm.aptoide.pt.view.settings.SettingsFragment r8 = r12.this$0     // Catch:{ NameNotFoundException -> 0x007a }
                    r9 = 8
                    r0[r9] = r2     // Catch:{ NameNotFoundException -> 0x007a }
                    android.support.v4.app.p r8 = r8.getActivity()     // Catch:{ NameNotFoundException -> 0x007a }
                    java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x007a }
                    android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r6)     // Catch:{ NameNotFoundException -> 0x007a }
                    int r7 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x007a }
                    r4 = r7
                    r7 = 9
                    r0[r7] = r2
                    goto L_0x008e
                L_0x007a:
                    r7 = move-exception
                    r8 = 10
                    r0[r8] = r2
                    cm.aptoide.pt.crashreports.CrashReport r8 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
                    r9 = 11
                    r0[r9] = r2
                    r8.log(r7)
                    r8 = 12
                    r0[r8] = r2
                L_0x008e:
                    r7 = 2131296444(0x7f0900bc, float:1.8210805E38)
                    android.view.View r7 = r1.findViewById(r7)
                    android.widget.TextView r7 = (android.widget.TextView) r7
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    r8.<init>()
                    cm.aptoide.pt.view.settings.SettingsFragment r9 = r12.this$0
                    r10 = 2131690517(0x7f0f0415, float:1.901008E38)
                    r11 = 13
                    r0[r11] = r2
                    java.lang.String r9 = r9.getString(r10)
                    r8.append(r9)
                    java.lang.String r9 = " "
                    r8.append(r9)
                    r8.append(r3)
                    java.lang.String r9 = " ("
                    r8.append(r9)
                    r8.append(r4)
                    java.lang.String r9 = ")"
                    r8.append(r9)
                    java.lang.String r8 = r8.toString()
                    r9 = 14
                    r0[r9] = r2
                    r7.setText(r8)
                    r7 = 15
                    r0[r7] = r2
                    r7 = 2131296592(0x7f090150, float:1.8211105E38)
                    android.view.View r7 = r1.findViewById(r7)
                    android.widget.TextView r7 = (android.widget.TextView) r7
                    r8 = 16
                    r0[r8] = r2
                    android.text.method.MovementMethod r8 = android.text.method.LinkMovementMethod.getInstance()
                    r9 = 17
                    r0[r9] = r2
                    r7.setMovementMethod(r8)
                    r7 = 18
                    r0[r7] = r2
                    r7 = 2131296565(0x7f090135, float:1.821105E38)
                    android.view.View r7 = r1.findViewById(r7)
                    android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                    r8 = 19
                    r0[r8] = r2
                    r8 = 2131296566(0x7f090136, float:1.8211052E38)
                    android.view.View r8 = r1.findViewById(r8)
                    android.widget.TextView r8 = (android.widget.TextView) r8
                    cm.aptoide.pt.view.settings.SettingsFragment r9 = r12.this$0
                    cm.aptoide.pt.view.settings.SupportEmailProvider r9 = r9.supportEmailProvider
                    java.lang.String r9 = r9.getEmail()
                    r8.setText(r9)
                    r8 = 20
                    r0[r8] = r2
                    cm.aptoide.pt.view.settings.SettingsFragment r8 = r12.this$0
                    cm.aptoide.pt.view.settings.SupportEmailProvider r8 = r8.supportEmailProvider
                    boolean r8 = r8.isAptoideSupport()
                    if (r8 == 0) goto L_0x0127
                    r5 = 21
                    r0[r5] = r2
                    r7.setVisibility(r6)
                    r5 = 22
                    r0[r5] = r2
                    goto L_0x012e
                L_0x0127:
                    r7.setVisibility(r5)
                    r5 = 23
                    r0[r5] = r2
                L_0x012e:
                    android.support.v7.app.m$a r5 = new android.support.v7.app.m$a
                    cm.aptoide.pt.view.settings.SettingsFragment r6 = r12.this$0
                    android.content.Context r6 = p005cm.aptoide.p006pt.view.settings.SettingsFragment.access$100(r6)
                    r5.<init>(r6)
                    r5.mo6235b(r1)
                    cm.aptoide.pt.view.settings.SettingsFragment r6 = r12.this$0
                    r8 = 2131690395(0x7f0f039b, float:1.9009832E38)
                    r9 = 24
                    r0[r9] = r2
                    java.lang.String r6 = r6.getString(r8)
                    r5.mo6236b(r6)
                    r6 = 17301569(0x1080041, float:2.4979437E-38)
                    r8 = 25
                    r0[r8] = r2
                    r5.mo6219a(r6)
                    r6 = 17039370(0x104000a, float:2.42446E-38)
                    cm.aptoide.pt.view.settings.Ma r8 = p005cm.aptoide.p006pt.view.settings.C5429Ma.f9242a
                    r9 = 26
                    r0[r9] = r2
                    r5.mo6239c(r6, r8)
                    r6 = 27
                    r0[r6] = r2
                    android.support.v7.app.m r5 = r5.mo6231a()
                    r6 = 28
                    r0[r6] = r2
                    r5.show()
                    r5 = 29
                    r0[r5] = r2
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.view.settings.SettingsFragment.C54422.onPreferenceClick(android.support.v7.preference.Preference):boolean");
            }

            /* renamed from: a */
            static /* synthetic */ void m9784a(DialogInterface dialogInterface, int i) {
                boolean[] $jacocoInit = $jacocoInit();
                dialogInterface.cancel();
                $jacocoInit[30] = true;
            }
        });
        $jacocoInit[143] = true;
        setupAdultContentClickHandlers();
        $jacocoInit[144] = true;
    }

    /* renamed from: j */
    public /* synthetic */ Single mo17531j(Preference __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        $jacocoInit[363] = true;
        return authentication;
    }

    /* renamed from: a */
    static /* synthetic */ String m9737a(Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        String accessToken = authentication.getAccessToken();
        $jacocoInit[362] = true;
        return accessToken;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17502a(String accessToken) {
        boolean[] $jacocoInit = $jacocoInit();
        openDeleteAccountView(accessToken);
        $jacocoInit[361] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo17532k(Preference isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) isChecked;
        $jacocoInit[358] = true;
        Boolean valueOf = Boolean.valueOf(switchPreferenceCompat.mo6295R());
        $jacocoInit[359] = true;
        handleSocialNotifications(valueOf);
        $jacocoInit[360] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo17533l(Preference clicked) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(ExcludedUpdatesFragment.newInstance(), true);
        $jacocoInit[357] = true;
    }

    /* renamed from: m */
    public /* synthetic */ void mo17534m(Preference clicked) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(SendFeedbackFragment.newInstance(), true);
        $jacocoInit[356] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo17522e(Preference clicked) {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        $jacocoInit[354] = true;
        instance.openInChromeCustomTab(getString(C1375R.string.all_url_terms_conditions), getContext(), this.theme);
        $jacocoInit[355] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo17524f(Preference clicked) {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        $jacocoInit[352] = true;
        instance.openInChromeCustomTab(getString(C1375R.string.all_url_privacy_policy), getContext(), this.theme);
        $jacocoInit[353] = true;
    }

    /* renamed from: g */
    public /* synthetic */ boolean mo17526g(Preference preference) {
        boolean[] $jacocoInit = $jacocoInit();
        SwitchPreferenceCompat cb = (SwitchPreferenceCompat) preference;
        boolean filterApps = false;
        $jacocoInit[347] = true;
        if (cb.mo6295R()) {
            $jacocoInit[348] = true;
            cb.mo6416f(true);
            filterApps = true;
            $jacocoInit[349] = true;
        } else {
            cb.mo6416f(false);
            $jacocoInit[350] = true;
        }
        ManagerPreferences.setHWSpecsFilter(filterApps, this.sharedPreferences);
        $jacocoInit[351] = true;
        return true;
    }

    /* renamed from: h */
    public /* synthetic */ boolean mo17528h(Preference preference) {
        boolean[] $jacocoInit = $jacocoInit();
        ProgressDialog dialog = GenericDialogs.createGenericPleaseWaitDialog(getContext());
        $jacocoInit[324] = true;
        C0136c cVar = this.subscriptions;
        Context context2 = getContext();
        Object[] objArr = {this.marketName};
        $jacocoInit[325] = true;
        String string = getString(C1375R.string.storage_dialog_title, objArr);
        $jacocoInit[326] = true;
        String string2 = getString(C1375R.string.clear_cache_dialog_message);
        $jacocoInit[327] = true;
        C0120S createGenericContinueCancelMessage = GenericDialogs.createGenericContinueCancelMessage(context2, string, string2);
        C5514sb sbVar = C5514sb.f9325a;
        $jacocoInit[328] = true;
        C0120S d = createGenericContinueCancelMessage.mo3653d((C0132p<? super T, Boolean>) sbVar);
        C5448Va va = new C5448Va(dialog);
        $jacocoInit[329] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) va);
        C5463bb bbVar = new C5463bb(this);
        $jacocoInit[330] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bbVar);
        $jacocoInit[331] = true;
        C0120S a = f.mo3616a(C14522a.m46170a());
        C5499nb nbVar = new C5499nb(dialog);
        $jacocoInit[332] = true;
        C0120S c = a.mo3644c((C0128a) nbVar);
        C5456Za za = new C5456Za(this);
        C5502ob obVar = new C5502ob(this);
        $jacocoInit[333] = true;
        C0137ja a2 = c.mo3626a((C0129b<? super T>) za, (C0129b<Throwable>) obVar);
        $jacocoInit[334] = true;
        cVar.mo3713a(a2);
        $jacocoInit[335] = true;
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9736a(EResponse eResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(eResponse.equals(EResponse.YES));
        $jacocoInit[346] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ void m9739a(ProgressDialog dialog, EResponse eResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        dialog.show();
        $jacocoInit[345] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo17506b(EResponse eResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S deleteCache = this.fileManager.deleteCache();
        $jacocoInit[344] = true;
        return deleteCache;
    }

    /* renamed from: a */
    static /* synthetic */ void m9738a(ProgressDialog dialog) {
        boolean[] $jacocoInit = $jacocoInit();
        dialog.dismiss();
        $jacocoInit[343] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17501a(Long deletedSize) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[338] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[339] = true;
        Object[] objArr = {StringU.formatBytes(deletedSize.longValue(), false)};
        $jacocoInit[340] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.freed_space, resources, objArr);
        $jacocoInit[341] = true;
        ShowMessage.asSnack((Fragment) this, formattedString);
        $jacocoInit[342] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17503a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        ShowMessage.asSnack((Fragment) this, (int) C1375R.string.ws_error_SYS_1);
        $jacocoInit[336] = true;
        throwable.printStackTrace();
        $jacocoInit[337] = true;
    }

    /* renamed from: i */
    public /* synthetic */ boolean mo17530i(Preference preference) {
        boolean[] $jacocoInit = $jacocoInit();
        C0775a alertDialogBuilder = new C0775a(this.context, C1375R.style.AlertDialogAptoide);
        $jacocoInit[302] = true;
        alertDialogBuilder.mo6236b((CharSequence) getString(C1375R.string.setting_hwspecstitle));
        $jacocoInit[303] = true;
        alertDialogBuilder.mo6219a(17301569);
        StringBuilder sb = new StringBuilder();
        $jacocoInit[304] = true;
        sb.append(getString(C1375R.string.setting_sdk_version));
        String str = ": ";
        sb.append(str);
        $jacocoInit[305] = true;
        sb.append(SystemU.getSdkVer());
        String str2 = "\n";
        sb.append(str2);
        $jacocoInit[306] = true;
        sb.append(getString(C1375R.string.setting_screen_size));
        sb.append(str);
        $jacocoInit[307] = true;
        sb.append(ScreenU.getScreenSize(getContext().getResources()));
        sb.append(str2);
        $jacocoInit[308] = true;
        sb.append(getString(C1375R.string.setting_esgl_version));
        sb.append(str);
        $jacocoInit[309] = true;
        ActivityManager activityManager = (ActivityManager) getContext().getSystemService("activity");
        $jacocoInit[310] = true;
        sb.append(SystemU.getGlEsVer(activityManager));
        sb.append(str2);
        $jacocoInit[311] = true;
        sb.append(getString(C1375R.string.screenCode));
        sb.append(str);
        $jacocoInit[312] = true;
        sb.append(ScreenU.getNumericScreenSize(getContext().getResources()));
        sb.append("/");
        $jacocoInit[313] = true;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        $jacocoInit[314] = true;
        sb.append(ScreenU.getDensityDpi(windowManager));
        sb.append(str2);
        $jacocoInit[315] = true;
        sb.append(getString(C1375R.string.cpuAbi));
        sb.append(str);
        $jacocoInit[316] = true;
        sb.append(SystemU.getAbis());
        String sb2 = sb.toString();
        $jacocoInit[317] = true;
        alertDialogBuilder.mo6226a((CharSequence) sb2);
        $jacocoInit[318] = true;
        alertDialogBuilder.mo6228a(false);
        $jacocoInit[319] = true;
        alertDialogBuilder.mo6237b((CharSequence) getString(17039370), (OnClickListener) C5404Cb.f9217a);
        $jacocoInit[320] = true;
        C0774m alertDialog = alertDialogBuilder.mo6231a();
        $jacocoInit[321] = true;
        alertDialog.show();
        $jacocoInit[322] = true;
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9740a(DialogInterface dialog, int id) {
        $jacocoInit()[323] = true;
    }

    private void setupAdultContentClickHandlers() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.settingsManager.showAdultContent()) {
            $jacocoInit[145] = true;
        } else {
            $jacocoInit[146] = true;
            C0136c cVar = this.subscriptions;
            C0120S positiveClicks = this.adultContentConfirmationDialog.positiveClicks();
            C5496mb mbVar = new C5496mb(this);
            $jacocoInit[147] = true;
            C0120S b = positiveClicks.mo3636b((C0129b<? super T>) mbVar);
            C5431Na na = new C5431Na(this);
            $jacocoInit[148] = true;
            C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) na);
            $jacocoInit[149] = true;
            C0120S g = f.mo3662g();
            $jacocoInit[150] = true;
            C0137ja j = g.mo3670j();
            $jacocoInit[151] = true;
            cVar.mo3713a(j);
            $jacocoInit[152] = true;
            C0136c cVar2 = this.subscriptions;
            C0120S negativeClicks = this.adultContentConfirmationDialog.negativeClicks();
            C5440Sa sa = new C5440Sa(this);
            $jacocoInit[153] = true;
            C0120S b2 = negativeClicks.mo3636b((C0129b<? super T>) sa);
            $jacocoInit[154] = true;
            C0120S g2 = b2.mo3662g();
            $jacocoInit[155] = true;
            C0137ja j2 = g2.mo3670j();
            $jacocoInit[156] = true;
            cVar2.mo3713a(j2);
            $jacocoInit[157] = true;
            C0136c cVar3 = this.subscriptions;
            C0120S negativeClicks2 = this.enableAdultContentPinDialog.negativeClicks();
            C5450Wa wa = new C5450Wa(this);
            $jacocoInit[158] = true;
            C0120S b3 = negativeClicks2.mo3636b((C0129b<? super T>) wa);
            $jacocoInit[159] = true;
            C0120S g3 = b3.mo3662g();
            $jacocoInit[160] = true;
            C0137ja j3 = g3.mo3670j();
            $jacocoInit[161] = true;
            cVar3.mo3713a(j3);
            $jacocoInit[162] = true;
            C0136c cVar4 = this.subscriptions;
            C0120S clicks = RxPreference.clicks(this.adultContentWithPinPreferenceView);
            C5435Pa pa = new C5435Pa(this);
            $jacocoInit[163] = true;
            C0120S f2 = clicks.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pa);
            $jacocoInit[164] = true;
            C0120S g4 = f2.mo3662g();
            $jacocoInit[165] = true;
            C0137ja j4 = g4.mo3670j();
            $jacocoInit[166] = true;
            cVar4.mo3713a(j4);
            $jacocoInit[167] = true;
            C0136c cVar5 = this.subscriptions;
            C0120S positiveClicks2 = this.removePinDialog.positiveClicks();
            C5484ib ibVar = new C5484ib(this);
            $jacocoInit[168] = true;
            C0120S f3 = positiveClicks2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ibVar);
            $jacocoInit[169] = true;
            C0120S g5 = f3.mo3662g();
            $jacocoInit[170] = true;
            C0137ja j5 = g5.mo3670j();
            $jacocoInit[171] = true;
            cVar5.mo3713a(j5);
            $jacocoInit[172] = true;
            C0136c cVar6 = this.subscriptions;
            C0120S positiveClicks3 = this.enableAdultContentPinDialog.positiveClicks();
            C5523vb vbVar = new C5523vb(this);
            $jacocoInit[173] = true;
            C0120S b4 = positiveClicks3.mo3636b((C0129b<? super T>) vbVar);
            C5401Bb bb = new C5401Bb(this);
            $jacocoInit[174] = true;
            C0120S f4 = b4.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bb);
            $jacocoInit[175] = true;
            C0120S g6 = f4.mo3662g();
            $jacocoInit[176] = true;
            C0137ja j6 = g6.mo3670j();
            $jacocoInit[177] = true;
            cVar6.mo3713a(j6);
            $jacocoInit[178] = true;
            C0136c cVar7 = this.subscriptions;
            C0120S enabled = this.accountManager.enabled();
            $jacocoInit[179] = true;
            C0120S a = enabled.mo3616a(C14522a.m46170a());
            C5457_a _aVar = new C5457_a(this);
            $jacocoInit[180] = true;
            C0120S b5 = a.mo3636b((C0129b<? super T>) _aVar);
            C5444Ta ta = new C5444Ta(this);
            $jacocoInit[181] = true;
            C0120S b6 = b5.mo3636b((C0129b<? super T>) ta);
            $jacocoInit[182] = true;
            C0137ja j7 = b6.mo3670j();
            $jacocoInit[183] = true;
            cVar7.mo3713a(j7);
            $jacocoInit[184] = true;
            C0136c cVar8 = this.subscriptions;
            C0120S clicks2 = RxPreference.clicks(this.adultContentPreferenceView);
            C5398Ab ab = new C5398Ab(this);
            $jacocoInit[185] = true;
            C0120S f5 = clicks2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ab);
            $jacocoInit[186] = true;
            C0120S g7 = f5.mo3662g();
            $jacocoInit[187] = true;
            C0137ja j8 = g7.mo3670j();
            $jacocoInit[188] = true;
            cVar8.mo3713a(j8);
            $jacocoInit[189] = true;
            C0136c cVar9 = this.subscriptions;
            C0120S clicks3 = RxPreference.clicks(this.pinPreferenceView);
            C5452Xa xa = new C5452Xa(this);
            $jacocoInit[190] = true;
            C0120S b7 = clicks3.mo3636b((C0129b<? super T>) xa);
            $jacocoInit[191] = true;
            C0137ja j9 = b7.mo3670j();
            $jacocoInit[192] = true;
            cVar9.mo3713a(j9);
            $jacocoInit[193] = true;
            C0136c cVar10 = this.subscriptions;
            C0120S pinRequired = this.accountManager.pinRequired();
            $jacocoInit[194] = true;
            C0120S a2 = pinRequired.mo3616a(C14522a.m46170a());
            C5475fb fbVar = new C5475fb(this);
            $jacocoInit[195] = true;
            C0120S b8 = a2.mo3636b((C0129b<? super T>) fbVar);
            $jacocoInit[196] = true;
            C0137ja j10 = b8.mo3670j();
            $jacocoInit[197] = true;
            cVar10.mo3713a(j10);
            $jacocoInit[198] = true;
            C0136c cVar11 = this.subscriptions;
            C0120S clicks4 = RxPreference.clicks(this.removePinPreferenceView);
            C5490kb kbVar = new C5490kb(this);
            $jacocoInit[199] = true;
            C0120S b9 = clicks4.mo3636b((C0129b<? super T>) kbVar);
            $jacocoInit[200] = true;
            C0137ja j11 = b9.mo3670j();
            $jacocoInit[201] = true;
            cVar11.mo3713a(j11);
            $jacocoInit[202] = true;
            C0136c cVar12 = this.subscriptions;
            C0120S positiveClicks4 = this.setPinDialog.positiveClicks();
            C5460ab abVar = C5460ab.f9271a;
            $jacocoInit[203] = true;
            C0120S d = positiveClicks4.mo3653d((C0132p<? super T, Boolean>) abVar);
            C5532yb ybVar = new C5532yb(this);
            $jacocoInit[204] = true;
            C0120S f6 = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ybVar);
            $jacocoInit[205] = true;
            C0120S g8 = f6.mo3662g();
            $jacocoInit[206] = true;
            C0137ja j12 = g8.mo3670j();
            $jacocoInit[207] = true;
            cVar12.mo3713a(j12);
            $jacocoInit[208] = true;
        }
        $jacocoInit[209] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17497a(DialogInterface click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentPreferenceView.mo6369d(false);
        $jacocoInit[301] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo17504b(DialogInterface click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M enable = this.accountManager.enable();
        C5416Gb gb = new C5416Gb(this);
        $jacocoInit[294] = true;
        C0117M a = enable.mo3582a((C0128a) gb);
        $jacocoInit[295] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5487jb jbVar = new C5487jb(this);
        $jacocoInit[296] = true;
        C0117M b = a2.mo3594b((C0128a) jbVar);
        $jacocoInit[297] = true;
        C0120S f = b.mo3604f();
        $jacocoInit[298] = true;
        return f;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17507b() {
        boolean[] $jacocoInit = $jacocoInit();
        trackUnlock();
        $jacocoInit[300] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17512c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentPreferenceView.mo6369d(true);
        $jacocoInit[299] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17513c(DialogInterface click) {
        boolean[] $jacocoInit = $jacocoInit();
        rollbackCheck(this.adultContentPreferenceView);
        $jacocoInit[293] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo17518d(DialogInterface click) {
        boolean[] $jacocoInit = $jacocoInit();
        rollbackCheck(this.adultContentWithPinPreferenceView);
        $jacocoInit[292] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo17495a(Preference checked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (((SwitchPreferenceCompat) checked).mo6295R()) {
            $jacocoInit[281] = true;
            this.enableAdultContentPinDialog.show();
            $jacocoInit[282] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[283] = true;
            return c;
        }
        this.adultContentWithPinPreferenceView.mo6369d(false);
        $jacocoInit[284] = true;
        C0117M disable = this.accountManager.disable();
        C5466cb cbVar = new C5466cb(this);
        $jacocoInit[285] = true;
        C0117M a = disable.mo3582a((C0128a) cbVar);
        $jacocoInit[286] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5508qb qbVar = new C5508qb(this);
        $jacocoInit[287] = true;
        C0117M b = a2.mo3594b((C0128a) qbVar);
        $jacocoInit[288] = true;
        C0120S f = b.mo3604f();
        $jacocoInit[289] = true;
        return f;
    }

    /* renamed from: d */
    public /* synthetic */ void mo17517d() {
        boolean[] $jacocoInit = $jacocoInit();
        trackLock();
        $jacocoInit[291] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo17521e() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentWithPinPreferenceView.mo6369d(true);
        $jacocoInit[290] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo17496a(CharSequence pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removePin = this.accountManager.removePin(Integer.valueOf(pin.toString()).intValue());
        $jacocoInit[273] = true;
        C0117M a = removePin.mo3581a(C14522a.m46170a());
        C5438Ra ra = new C5438Ra(this);
        $jacocoInit[274] = true;
        C0117M a2 = a.mo3583a((C0129b<? super Throwable>) ra);
        $jacocoInit[275] = true;
        C0120S f = a2.mo3604f();
        $jacocoInit[276] = true;
        return f;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17510b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(throwable instanceof SecurityException)) {
            $jacocoInit[277] = true;
        } else {
            $jacocoInit[278] = true;
            ShowMessage.asSnack((Activity) getActivity(), (int) C1375R.string.adult_pin_wrong);
            $jacocoInit[279] = true;
        }
        $jacocoInit[280] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17509b(CharSequence clock) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentWithPinPreferenceView.mo6369d(false);
        $jacocoInit[272] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo17511c(CharSequence pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M enable = this.accountManager.enable(Integer.valueOf(pin.toString()).intValue());
        C5517tb tbVar = new C5517tb(this);
        $jacocoInit[260] = true;
        C0117M a = enable.mo3582a((C0128a) tbVar);
        $jacocoInit[261] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5529xb xbVar = new C5529xb(this);
        $jacocoInit[262] = true;
        C0117M a3 = a2.mo3583a((C0129b<? super Throwable>) xbVar);
        C5454Ya ya = new C5454Ya(this);
        $jacocoInit[263] = true;
        C0117M b = a3.mo3594b((C0128a) ya);
        $jacocoInit[264] = true;
        C0120S f = b.mo3604f();
        $jacocoInit[265] = true;
        return f;
    }

    /* renamed from: f */
    public /* synthetic */ void mo17523f() {
        boolean[] $jacocoInit = $jacocoInit();
        trackUnlock();
        $jacocoInit[271] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17516c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(throwable instanceof SecurityException)) {
            $jacocoInit[267] = true;
        } else {
            $jacocoInit[268] = true;
            ShowMessage.asSnack((Activity) getActivity(), (int) C1375R.string.adult_pin_wrong);
            $jacocoInit[269] = true;
        }
        $jacocoInit[270] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo17525g() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentWithPinPreferenceView.mo6369d(true);
        $jacocoInit[266] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17500a(Boolean state) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentPreferenceView.mo6416f(state.booleanValue());
        $jacocoInit[259] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17508b(Boolean state) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentWithPinPreferenceView.mo6416f(state.booleanValue());
        $jacocoInit[258] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo17505b(Preference checked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (((SwitchPreferenceCompat) checked).mo6295R()) {
            $jacocoInit[247] = true;
            this.adultContentConfirmationDialog.show();
            $jacocoInit[248] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[249] = true;
            return c;
        }
        this.adultContentPreferenceView.mo6369d(false);
        $jacocoInit[250] = true;
        C0117M disable = this.accountManager.disable();
        C5419Hb hb = new C5419Hb(this);
        $jacocoInit[251] = true;
        C0117M a = disable.mo3582a((C0128a) hb);
        $jacocoInit[252] = true;
        C0117M a2 = a.mo3581a(C14522a.m46170a());
        C5526wb wbVar = new C5526wb(this);
        $jacocoInit[253] = true;
        C0117M b = a2.mo3594b((C0128a) wbVar);
        $jacocoInit[254] = true;
        C0120S f = b.mo3604f();
        $jacocoInit[255] = true;
        return f;
    }

    /* renamed from: h */
    public /* synthetic */ void mo17527h() {
        boolean[] $jacocoInit = $jacocoInit();
        trackLock();
        $jacocoInit[257] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo17529i() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adultContentPreferenceView.mo6369d(true);
        $jacocoInit[256] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17514c(Preference preference) {
        boolean[] $jacocoInit = $jacocoInit();
        this.setPinDialog.show();
        $jacocoInit[246] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17515c(Boolean pinRequired) {
        boolean[] $jacocoInit = $jacocoInit();
        if (pinRequired.booleanValue()) {
            $jacocoInit[236] = true;
            this.pinPreferenceView.mo6372e(false);
            $jacocoInit[237] = true;
            this.removePinPreferenceView.mo6372e(true);
            $jacocoInit[238] = true;
            this.adultContentWithPinPreferenceView.mo6372e(true);
            $jacocoInit[239] = true;
            this.adultContentPreferenceView.mo6372e(false);
            $jacocoInit[240] = true;
        } else {
            this.pinPreferenceView.mo6372e(true);
            $jacocoInit[241] = true;
            this.removePinPreferenceView.mo6372e(false);
            $jacocoInit[242] = true;
            this.adultContentWithPinPreferenceView.mo6372e(false);
            $jacocoInit[243] = true;
            this.adultContentPreferenceView.mo6372e(true);
            $jacocoInit[244] = true;
        }
        $jacocoInit[245] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo17519d(Preference preference) {
        boolean[] $jacocoInit = $jacocoInit();
        this.removePinDialog.show();
        $jacocoInit[235] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m9741d(CharSequence pin) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!TextUtils.isEmpty(pin)) {
            $jacocoInit[232] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[233] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[234] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ C0120S mo17520e(CharSequence pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M requirePin = this.accountManager.requirePin(Integer.valueOf(pin.toString()).intValue());
        $jacocoInit[230] = true;
        C0120S f = requirePin.mo3604f();
        $jacocoInit[231] = true;
        return f;
    }

    private void openDeleteAccountView(String accessToken) {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        Object[] objArr = {accessToken};
        $jacocoInit[210] = true;
        String string = getString(C1375R.string.settings_url_delete_account, objArr);
        $jacocoInit[211] = true;
        Context context2 = getContext();
        String str = this.theme;
        $jacocoInit[212] = true;
        instance.openInChromeCustomTab(string, context2, str);
        $jacocoInit[213] = true;
    }

    private void handleSocialNotifications(Boolean isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationSyncScheduler.setEnabled(isChecked.booleanValue());
        $jacocoInit[214] = true;
        if (isChecked.booleanValue()) {
            $jacocoInit[215] = true;
            this.notificationSyncScheduler.schedule();
            $jacocoInit[216] = true;
        } else {
            this.notificationSyncScheduler.removeSchedules();
            $jacocoInit[217] = true;
        }
        $jacocoInit[218] = true;
    }

    private void rollbackCheck(SwitchPreferenceCompat preference) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!preference.mo6295R()) {
            $jacocoInit[219] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[220] = true;
        }
        preference.mo6416f(z);
        $jacocoInit[221] = true;
    }

    private void trackLock() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.trackAnalytics) {
            $jacocoInit[222] = true;
        } else {
            this.trackAnalytics = false;
            $jacocoInit[223] = true;
            this.adultContentAnalytics.lock();
            $jacocoInit[224] = true;
        }
        $jacocoInit[225] = true;
    }

    private void trackUnlock() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.trackAnalytics) {
            $jacocoInit[226] = true;
        } else {
            this.trackAnalytics = false;
            $jacocoInit[227] = true;
            this.adultContentAnalytics.unlock();
            $jacocoInit[228] = true;
        }
        $jacocoInit[229] = true;
    }
}
