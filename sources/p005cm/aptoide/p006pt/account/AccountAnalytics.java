package p005cm.aptoide.p006pt.account;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AccountException;
import p005cm.aptoide.accountmanager.AccountValidationException;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV3Exception;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GenericResponseV3;

/* renamed from: cm.aptoide.pt.account.AccountAnalytics */
public class AccountAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String APTOIDE_EVENT_NAME = "LOGIN";
    public static final String CREATE_USER_PROFILE = "Account_Create_A_User_Profile_Screen";
    public static final String CREATE_YOUR_STORE = "Account_Create_Your_Store_Screen";
    public static final String ENTRY = "Account_Entry";
    public static final String GENERAL_ERROR = "General Error";
    public static final String HAS_PICTURE = "has_picture";
    private static final String INVALID_GRANT_CODE = "invalid_grant";
    public static final String LOGIN_EVENT_NAME = "Account_Login_Screen";
    private static final String LOGIN_METHOD = "Method";
    public static final String LOGIN_SIGN_UP_START_SCREEN = "Account_Login_Signup_Start_Screen";
    public static final String PERMISSIONS_DENIED = "Permissions Denied";
    private static final String PREVIOUS_CONTEXT = "previous_context";
    public static final String PROFILE_SETTINGS = "Account_Profile_Settings_Screen";
    private static final String PROMOTE_APTOIDE_BACKUP_APPS_PARAM_VALUE = "Backup Apps";
    public static final String PROMOTE_APTOIDE_EVENT_NAME = "Promote_Aptoide";
    private static final String PROMOTE_APTOIDE_PARAM_KEY = "aptoide_product";
    private static final String PROMOTE_APTOIDE_TV_PARAM_VALUE = "TV";
    private static final String PROMOTE_APTOIDE_UPLOADER_PARAM_VALUE = "Uploader";
    public static final String SCREEN = "Screen";
    public static final String SDK_ERROR = "SDK Error";
    public static final String SIGN_UP_EVENT_NAME = "Account_Signup_Screen";
    public static final String SOURCE = "Source";
    private static final String STATUS = "Status";
    private static final String STATUS_CODE = "Status Code";
    private static final String STATUS_DESCRIPTION = "Status Description";
    private static final String STATUS_DETAIL = "Status Detail";
    public static final String STORE = "store";
    public static final String STORE_ACTION = "Click";
    public static final String SUCCESS = "Success";
    public static final int UNKNOWN_STATUS_CODE = 12501;
    public static final String USER_CANCELED = "User canceled";
    public static final String WEB_ERROR = "Web";
    private final AnalyticsManager analyticsManager;
    private AccountEvent aptoideSuccessLoginEvent;
    private final CrashReport crashReport;
    private AccountEvent facebookAndFlurrySuccessLoginEvent;
    private final NavigationTracker navigationTracker;
    private AccountEvent signUpEvent;

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$1 */
    static /* synthetic */ class C14031 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$account$AccountAnalytics$LoginMethod = new int[LoginMethod.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-229066564873231720L, "cm/aptoide/pt/account/AccountAnalytics$1", 8);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$account$AccountAnalytics$LoginMethod[LoginMethod.APTOIDE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        $jacocoInit[6] = true;
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$account$AccountAnalytics$LoginMethod[LoginMethod.FACEBOOK.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$account$AccountAnalytics$LoginMethod[LoginMethod.GOOGLE.ordinal()] = 3;
            $jacocoInit[5] = true;
            $jacocoInit[7] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$AccountEvent */
    private class AccountEvent {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private Action action;
        private String context;
        private String eventName;
        private Map<String, Object> map;
        final /* synthetic */ AccountAnalytics this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8461996251230824242L, "cm/aptoide/pt/account/AccountAnalytics$AccountEvent", 5);
            $jacocoData = probes;
            return probes;
        }

        public AccountEvent(AccountAnalytics accountAnalytics, Map<String, Object> map2, String eventName2, Action action2, String context2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = accountAnalytics;
            this.map = map2;
            this.eventName = eventName2;
            this.action = action2;
            this.context = context2;
            $jacocoInit[0] = true;
        }

        public Map<String, Object> getMap() {
            boolean[] $jacocoInit = $jacocoInit();
            Map<String, Object> map2 = this.map;
            $jacocoInit[1] = true;
            return map2;
        }

        public String getEventName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.eventName;
            $jacocoInit[2] = true;
            return str;
        }

        public Action getAction() {
            boolean[] $jacocoInit = $jacocoInit();
            Action action2 = this.action;
            $jacocoInit[3] = true;
            return action2;
        }

        public String getContext() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.context;
            $jacocoInit[4] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$AccountOrigins */
    public enum AccountOrigins {
        WIZARD("Wizard"),
        MY_ACCOUNT("My Account"),
        TIMELINE("Timeline"),
        STORE("Store"),
        APP_VIEW_FLAG("App View Flag"),
        APP_VIEW_SHARE("App View Share on Timeline"),
        SHARE_CARD("Share Card"),
        LIKE_CARD("Like Card"),
        COMMENT_LIST("Comment List"),
        RATE_DIALOG("Reviews FAB"),
        REPLY_REVIEW("Reply Review"),
        REVIEW_FEEDBACK("Review Feedback"),
        SOCIAL_LIKE("Like Social Card"),
        STORE_COMMENT("Store Comment"),
        LATEST_COMMENTS_STORE("Comment on Latest Store Comments"),
        POST_ON_TIMELINE("Post on Timeline"),
        EDITORIAL("React on Editorial");
        
        private final String origin;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[10] = true;
        }

        private AccountOrigins(String origin2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.origin = origin2;
            $jacocoInit[2] = true;
        }

        public String getOrigin() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.origin;
            $jacocoInit[3] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$CreateStoreAction */
    public enum CreateStoreAction {
        SKIP("Skip"),
        CREATE("Create store");
        
        private final String action;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[4] = true;
        }

        private CreateStoreAction(String action2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.action = action2;
            $jacocoInit[2] = true;
        }

        public String getAction() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.action;
            $jacocoInit[3] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$LoginMethod */
    public enum LoginMethod {
        APTOIDE(BuildConfig.MARKET_NAME),
        FACEBOOK("FB"),
        GOOGLE("Google");
        
        private final String method;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[4] = true;
        }

        private LoginMethod(String method2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.method = method2;
            $jacocoInit[2] = true;
        }

        public String getMethod() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.method;
            $jacocoInit[3] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$ProfileAction */
    public enum ProfileAction {
        MORE_INFO("More info"),
        CONTINUE("Continue"),
        PRIVATE_PROFILE("Make my profile private"),
        PUBLIC_PROFILE("Make my profile public");
        
        private final String action;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[5] = true;
        }

        private ProfileAction(String action2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.action = action2;
            $jacocoInit[2] = true;
        }

        public String getAction() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.action;
            $jacocoInit[3] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$SignUpLoginStatus */
    private enum SignUpLoginStatus {
        SUCCESS(AccountAnalytics.SUCCESS),
        FAILED("Failed"),
        INVALID("Invalid");
        
        private final String status;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[4] = true;
        }

        private SignUpLoginStatus(String result) {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = result;
            $jacocoInit[2] = true;
        }

        public String getStatus() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.status;
            $jacocoInit[3] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$StartupClick */
    public enum StartupClick {
        JOIN_APTOIDE("Join Aptoide"),
        LOGIN("Login"),
        CONNECT_FACEBOOK("Connect with FB"),
        CONNECT_GOOGLE("Connect with Google");
        
        private final String clickEvent;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[5] = true;
        }

        private StartupClick(String clickEvent2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.clickEvent = clickEvent2;
            $jacocoInit[2] = true;
        }

        public String getClickEvent() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.clickEvent;
            $jacocoInit[3] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.account.AccountAnalytics$StartupClickOrigin */
    public enum StartupClickOrigin {
        MAIN("Main"),
        JOIN_UP("Join Aptoide Slide Up"),
        LOGIN_UP("Login Slide Up"),
        NOT_LOGGED_IN_DIALOG("Not logged in Dialog");
        
        private String clickOrigin;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[5] = true;
        }

        private StartupClickOrigin(String clickOrigin2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.clickOrigin = clickOrigin2;
            $jacocoInit[2] = true;
        }

        public String getClickOrigin() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.clickOrigin;
            $jacocoInit[3] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3409776130320967602L, "cm/aptoide/pt/account/AccountAnalytics", Opcodes.GETFIELD);
        $jacocoData = probes;
        return probes;
    }

    public AccountAnalytics(NavigationTracker navigationTracker2, CrashReport crashReport2, AnalyticsManager analyticsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigationTracker = navigationTracker2;
        this.crashReport = crashReport2;
        this.analyticsManager = analyticsManager2;
        $jacocoInit[0] = true;
    }

    public void loginSuccess() {
        boolean[] $jacocoInit = $jacocoInit();
        AccountEvent accountEvent = this.aptoideSuccessLoginEvent;
        if (accountEvent == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Map map = accountEvent.getMap();
            AccountEvent accountEvent2 = this.aptoideSuccessLoginEvent;
            $jacocoInit[3] = true;
            String eventName = accountEvent2.getEventName();
            Action action = this.aptoideSuccessLoginEvent.getAction();
            AccountEvent accountEvent3 = this.aptoideSuccessLoginEvent;
            $jacocoInit[4] = true;
            String context = accountEvent3.getContext();
            $jacocoInit[5] = true;
            analyticsManager2.logEvent(map, eventName, action, context);
            this.aptoideSuccessLoginEvent = null;
            $jacocoInit[6] = true;
        }
        AccountEvent accountEvent4 = this.facebookAndFlurrySuccessLoginEvent;
        if (accountEvent4 == null) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            AnalyticsManager analyticsManager3 = this.analyticsManager;
            Map map2 = accountEvent4.getMap();
            AccountEvent accountEvent5 = this.facebookAndFlurrySuccessLoginEvent;
            $jacocoInit[9] = true;
            String eventName2 = accountEvent5.getEventName();
            AccountEvent accountEvent6 = this.facebookAndFlurrySuccessLoginEvent;
            $jacocoInit[10] = true;
            Action action2 = accountEvent6.getAction();
            AccountEvent accountEvent7 = this.facebookAndFlurrySuccessLoginEvent;
            $jacocoInit[11] = true;
            String context2 = accountEvent7.getContext();
            $jacocoInit[12] = true;
            analyticsManager3.logEvent(map2, eventName2, action2, context2);
            this.facebookAndFlurrySuccessLoginEvent = null;
            $jacocoInit[13] = true;
        }
        AccountEvent accountEvent8 = this.signUpEvent;
        if (accountEvent8 == null) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            AnalyticsManager analyticsManager4 = this.analyticsManager;
            Map map3 = accountEvent8.getMap();
            String eventName3 = this.signUpEvent.getEventName();
            AccountEvent accountEvent9 = this.signUpEvent;
            $jacocoInit[16] = true;
            Action action3 = accountEvent9.getAction();
            String context3 = this.signUpEvent.getContext();
            $jacocoInit[17] = true;
            analyticsManager4.logEvent(map3, eventName3, action3, context3);
            this.signUpEvent = null;
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }

    public void sendAptoideLoginButtonPressed() {
        boolean[] $jacocoInit = $jacocoInit();
        clearSignUpEvents();
        $jacocoInit[20] = true;
        setupLoginEvents(LoginMethod.APTOIDE);
        $jacocoInit[21] = true;
    }

    public void sendGoogleLoginButtonPressed() {
        boolean[] $jacocoInit = $jacocoInit();
        clearSignUpEvents();
        $jacocoInit[22] = true;
        setupLoginEvents(LoginMethod.GOOGLE);
        $jacocoInit[23] = true;
    }

    public void sendFacebookLoginButtonPressed() {
        boolean[] $jacocoInit = $jacocoInit();
        clearSignUpEvents();
        $jacocoInit[24] = true;
        setupLoginEvents(LoginMethod.FACEBOOK);
        $jacocoInit[25] = true;
    }

    public void sendAptoideSignUpButtonPressed() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = new HashMap();
        $jacocoInit[26] = true;
        hashMap.put(STATUS, SignUpLoginStatus.SUCCESS.getStatus());
        Action action = Action.CLICK;
        $jacocoInit[27] = true;
        HashMap hashMap2 = hashMap;
        AccountEvent accountEvent = new AccountEvent(this, hashMap2, SIGN_UP_EVENT_NAME, action, getViewName(true));
        this.signUpEvent = accountEvent;
        $jacocoInit[28] = true;
        clearLoginEvents();
        $jacocoInit[29] = true;
    }

    public void sendPromoteAptoideTVEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap params = new HashMap();
        $jacocoInit[30] = true;
        params.put(PROMOTE_APTOIDE_PARAM_KEY, PROMOTE_APTOIDE_TV_PARAM_VALUE);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[31] = true;
        String viewName = getViewName(true);
        $jacocoInit[32] = true;
        analyticsManager2.logEvent(params, PROMOTE_APTOIDE_EVENT_NAME, action, viewName);
        $jacocoInit[33] = true;
    }

    public void sendPromoteAptoideUploaderEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap params = new HashMap();
        $jacocoInit[34] = true;
        params.put(PROMOTE_APTOIDE_PARAM_KEY, PROMOTE_APTOIDE_UPLOADER_PARAM_VALUE);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[35] = true;
        String viewName = getViewName(true);
        $jacocoInit[36] = true;
        analyticsManager2.logEvent(params, PROMOTE_APTOIDE_EVENT_NAME, action, viewName);
        $jacocoInit[37] = true;
    }

    public void sendPromoteAptoideBackupAppsEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap params = new HashMap();
        $jacocoInit[38] = true;
        params.put(PROMOTE_APTOIDE_PARAM_KEY, PROMOTE_APTOIDE_BACKUP_APPS_PARAM_VALUE);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[39] = true;
        String viewName = getViewName(true);
        $jacocoInit[40] = true;
        analyticsManager2.logEvent(params, PROMOTE_APTOIDE_EVENT_NAME, action, viewName);
        $jacocoInit[41] = true;
    }

    private void clearSignUpEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        this.signUpEvent = null;
        $jacocoInit[42] = true;
    }

    private void clearLoginEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideSuccessLoginEvent = null;
        this.facebookAndFlurrySuccessLoginEvent = null;
        $jacocoInit[43] = true;
    }

    private void sendGoogleLoginFailEvent(Throwable exception) {
        boolean[] $jacocoInit = $jacocoInit();
        if (exception instanceof GoogleSignUpException) {
            GoogleSignUpException googleSignUpException = (GoogleSignUpException) exception;
            $jacocoInit[44] = true;
            if (googleSignUpException.getStatusCode() == 12501) {
                LoginMethod loginMethod = LoginMethod.GOOGLE;
                SignUpLoginStatus signUpLoginStatus = SignUpLoginStatus.INVALID;
                LoginMethod loginMethod2 = LoginMethod.GOOGLE;
                $jacocoInit[45] = true;
                String str = loginMethod2.toString();
                String error = googleSignUpException.getError();
                $jacocoInit[46] = true;
                sendEvents(LOGIN_EVENT_NAME, loginMethod, signUpLoginStatus, SDK_ERROR, str, error);
                $jacocoInit[47] = true;
            } else {
                LoginMethod loginMethod3 = LoginMethod.GOOGLE;
                SignUpLoginStatus signUpLoginStatus2 = SignUpLoginStatus.FAILED;
                LoginMethod loginMethod4 = LoginMethod.GOOGLE;
                $jacocoInit[48] = true;
                String str2 = loginMethod4.toString();
                String error2 = googleSignUpException.getError();
                $jacocoInit[49] = true;
                sendEvents(LOGIN_EVENT_NAME, loginMethod3, signUpLoginStatus2, SDK_ERROR, str2, error2);
                $jacocoInit[50] = true;
            }
            $jacocoInit[51] = true;
        } else {
            sendWebserviceErrors(LOGIN_EVENT_NAME, LoginMethod.GOOGLE, exception);
            $jacocoInit[52] = true;
        }
        $jacocoInit[53] = true;
    }

    private void setupLoginEvents(LoginMethod aptoide) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideSuccessLoginEvent = createAptoideLoginEvent();
        SignUpLoginStatus signUpLoginStatus = SignUpLoginStatus.SUCCESS;
        $jacocoInit[54] = true;
        this.facebookAndFlurrySuccessLoginEvent = createFacebookAndFlurryEvent(LOGIN_EVENT_NAME, aptoide, signUpLoginStatus, SUCCESS, null, null);
        $jacocoInit[55] = true;
    }

    private AccountEvent createFacebookAndFlurryEvent(String eventName, LoginMethod loginMethod, SignUpLoginStatus loginStatus, String statusDetail, String statusCode, String statusDescription) {
        String str = statusCode;
        String str2 = statusDescription;
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = new HashMap();
        $jacocoInit[56] = true;
        hashMap.put(LOGIN_METHOD, loginMethod.getMethod());
        $jacocoInit[57] = true;
        hashMap.put(STATUS, loginStatus.getStatus());
        $jacocoInit[58] = true;
        hashMap.put(STATUS_DETAIL, statusDetail);
        if (str == null) {
            $jacocoInit[59] = true;
        } else {
            $jacocoInit[60] = true;
            hashMap.put(STATUS_CODE, str);
            $jacocoInit[61] = true;
        }
        if (str2 == null) {
            $jacocoInit[62] = true;
        } else {
            $jacocoInit[63] = true;
            hashMap.put(STATUS_DESCRIPTION, str2);
            $jacocoInit[64] = true;
        }
        AccountEvent accountEvent = new AccountEvent(this, hashMap, eventName, Action.CLICK, getViewName(true));
        $jacocoInit[65] = true;
        return accountEvent;
    }

    private void sendEvents(String eventName, LoginMethod loginMethod, SignUpLoginStatus loginStatus, String statusDetail, String statusCode, String statusDescription) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[66] = true;
        AccountEvent event = createFacebookAndFlurryEvent(eventName, loginMethod, loginStatus, statusDetail, statusCode, statusDescription);
        $jacocoInit[67] = true;
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map map = event.getMap();
        String eventName2 = event.getEventName();
        Action action = event.getAction();
        $jacocoInit[68] = true;
        String context = event.getContext();
        $jacocoInit[69] = true;
        analyticsManager2.logEvent(map, eventName2, action, context);
        $jacocoInit[70] = true;
    }

    private AccountEvent createAptoideLoginEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = new HashMap();
        $jacocoInit[71] = true;
        String previousViewName = this.navigationTracker.getPreviousViewName();
        String str = PREVIOUS_CONTEXT;
        hashMap.put(str, previousViewName);
        $jacocoInit[72] = true;
        ScreenTagHistory previousScreen = this.navigationTracker.getPreviousScreen();
        if (previousScreen == null) {
            $jacocoInit[73] = true;
        } else {
            $jacocoInit[74] = true;
            hashMap.put("store", previousScreen.getStore());
            $jacocoInit[75] = true;
        }
        hashMap.put(str, this.navigationTracker.getPreviousViewName());
        Action action = Action.CLICK;
        $jacocoInit[76] = true;
        HashMap hashMap2 = hashMap;
        AccountEvent aptoideEvent = new AccountEvent(this, hashMap2, APTOIDE_EVENT_NAME, action, getViewName(true));
        $jacocoInit[77] = true;
        return aptoideEvent;
    }

    private void sendFacebookLoginErrorEvent(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof FacebookSignUpException) {
            FacebookSignUpException facebookSignUpException = (FacebookSignUpException) throwable;
            $jacocoInit[78] = true;
            int code = facebookSignUpException.getCode();
            if (code == 1) {
                LoginMethod loginMethod = LoginMethod.FACEBOOK;
                SignUpLoginStatus signUpLoginStatus = SignUpLoginStatus.INVALID;
                $jacocoInit[79] = true;
                String valueOf = String.valueOf(facebookSignUpException.getCode());
                $jacocoInit[80] = true;
                String facebookMessage = facebookSignUpException.getFacebookMessage();
                $jacocoInit[81] = true;
                sendEvents(LOGIN_EVENT_NAME, loginMethod, signUpLoginStatus, PERMISSIONS_DENIED, valueOf, facebookMessage);
                $jacocoInit[82] = true;
            } else if (code != 2) {
                LoginMethod loginMethod2 = LoginMethod.FACEBOOK;
                SignUpLoginStatus signUpLoginStatus2 = SignUpLoginStatus.FAILED;
                $jacocoInit[87] = true;
                String valueOf2 = String.valueOf(facebookSignUpException.getCode());
                $jacocoInit[88] = true;
                String facebookMessage2 = facebookSignUpException.getFacebookMessage();
                $jacocoInit[89] = true;
                sendEvents(LOGIN_EVENT_NAME, loginMethod2, signUpLoginStatus2, SDK_ERROR, valueOf2, facebookMessage2);
                $jacocoInit[90] = true;
            } else {
                LoginMethod loginMethod3 = LoginMethod.FACEBOOK;
                SignUpLoginStatus signUpLoginStatus3 = SignUpLoginStatus.INVALID;
                $jacocoInit[83] = true;
                String valueOf3 = String.valueOf(facebookSignUpException.getCode());
                $jacocoInit[84] = true;
                String facebookMessage3 = facebookSignUpException.getFacebookMessage();
                $jacocoInit[85] = true;
                sendEvents(LOGIN_EVENT_NAME, loginMethod3, signUpLoginStatus3, USER_CANCELED, valueOf3, facebookMessage3);
                $jacocoInit[86] = true;
            }
            $jacocoInit[91] = true;
        } else {
            sendWebserviceErrors(LOGIN_EVENT_NAME, LoginMethod.FACEBOOK, throwable);
            $jacocoInit[92] = true;
        }
        $jacocoInit[93] = true;
    }

    private void sendWebserviceErrors(String eventName, LoginMethod loginMethod, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof AptoideWsV7Exception) {
            $jacocoInit[94] = true;
            sendV7ExceptionEvent(loginMethod, (AptoideWsV7Exception) throwable);
            $jacocoInit[95] = true;
        } else if (throwable instanceof AptoideWsV3Exception) {
            $jacocoInit[96] = true;
            sendV3ExceptionEvent(loginMethod, (AptoideWsV3Exception) throwable);
            $jacocoInit[97] = true;
        } else if (throwable instanceof AccountException) {
            $jacocoInit[98] = true;
            sendV3ExceptionEvent(loginMethod, (AccountException) throwable);
            $jacocoInit[99] = true;
        } else if (throwable instanceof AccountValidationException) {
            SignUpLoginStatus signUpLoginStatus = SignUpLoginStatus.INVALID;
            $jacocoInit[100] = true;
            String th = throwable.toString();
            $jacocoInit[101] = true;
            sendEvents(eventName, loginMethod, signUpLoginStatus, GENERAL_ERROR, "no_code", th);
            $jacocoInit[102] = true;
        } else {
            SignUpLoginStatus signUpLoginStatus2 = SignUpLoginStatus.FAILED;
            $jacocoInit[103] = true;
            String th2 = throwable.toString();
            $jacocoInit[104] = true;
            sendEvents(eventName, loginMethod, signUpLoginStatus2, GENERAL_ERROR, "no_code", th2);
            $jacocoInit[105] = true;
            this.crashReport.log(throwable);
            $jacocoInit[106] = true;
        }
        $jacocoInit[107] = true;
    }

    private void sendV3ExceptionEvent(LoginMethod loginMethod, AccountException exception) {
        boolean[] $jacocoInit = $jacocoInit();
        String error = getWsError(exception);
        $jacocoInit[108] = true;
        Map errors = exception.getErrors();
        $jacocoInit[109] = true;
        String errorDescription = (String) errors.get(error);
        $jacocoInit[110] = true;
        if (error.equals(INVALID_GRANT_CODE)) {
            $jacocoInit[111] = true;
            LoginMethod loginMethod2 = loginMethod;
            sendEvents(LOGIN_EVENT_NAME, loginMethod2, SignUpLoginStatus.INVALID, WEB_ERROR, error, errorDescription);
            $jacocoInit[112] = true;
        } else {
            LoginMethod loginMethod3 = loginMethod;
            sendEvents(LOGIN_EVENT_NAME, loginMethod3, SignUpLoginStatus.FAILED, WEB_ERROR, error, errorDescription);
            $jacocoInit[113] = true;
        }
        $jacocoInit[114] = true;
    }

    private String getWsError(AccountException exception) {
        boolean[] $jacocoInit = $jacocoInit();
        Map errors = exception.getErrors();
        $jacocoInit[115] = true;
        Set keySet = errors.keySet();
        $jacocoInit[116] = true;
        String obj = keySet.toString();
        $jacocoInit[117] = true;
        String str = "";
        String replace = obj.replace("[", str);
        $jacocoInit[118] = true;
        String replace2 = replace.replace("]", str);
        $jacocoInit[119] = true;
        return replace2;
    }

    private void sendV7ExceptionEvent(LoginMethod loginMethod, AptoideWsV7Exception exception) {
        boolean[] $jacocoInit = $jacocoInit();
        SignUpLoginStatus signUpLoginStatus = SignUpLoginStatus.FAILED;
        $jacocoInit[120] = true;
        BaseV7Response baseResponse = exception.getBaseResponse();
        $jacocoInit[121] = true;
        List errors = baseResponse.getErrors();
        $jacocoInit[122] = true;
        Error error = (Error) errors.get(0);
        $jacocoInit[123] = true;
        String code = error.getCode();
        BaseV7Response baseResponse2 = exception.getBaseResponse();
        $jacocoInit[124] = true;
        List errors2 = baseResponse2.getErrors();
        $jacocoInit[125] = true;
        Error error2 = (Error) errors2.get(0);
        $jacocoInit[126] = true;
        String description = error2.getDescription();
        $jacocoInit[127] = true;
        sendEvents(LOGIN_EVENT_NAME, loginMethod, signUpLoginStatus, WEB_ERROR, code, description);
        $jacocoInit[128] = true;
    }

    private void sendV3ExceptionEvent(LoginMethod loginMethod, AptoideWsV3Exception exception) {
        boolean[] $jacocoInit = $jacocoInit();
        SignUpLoginStatus signUpLoginStatus = SignUpLoginStatus.FAILED;
        $jacocoInit[129] = true;
        GenericResponseV3 baseResponse = exception.getBaseResponse();
        $jacocoInit[130] = true;
        List errors = baseResponse.getErrors();
        $jacocoInit[131] = true;
        String str = ((ErrorResponse) errors.get(0)).code;
        GenericResponseV3 baseResponse2 = exception.getBaseResponse();
        $jacocoInit[132] = true;
        List errors2 = baseResponse2.getErrors();
        $jacocoInit[133] = true;
        String str2 = ((ErrorResponse) errors2.get(0)).msg;
        $jacocoInit[134] = true;
        sendEvents(LOGIN_EVENT_NAME, loginMethod, signUpLoginStatus, WEB_ERROR, str, str2);
        $jacocoInit[135] = true;
    }

    public void sendLoginErrorEvent(LoginMethod loginMethod, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C14031.$SwitchMap$cm$aptoide$pt$account$AccountAnalytics$LoginMethod[loginMethod.ordinal()];
        if (i == 1) {
            sendWebserviceErrors(LOGIN_EVENT_NAME, LoginMethod.APTOIDE, throwable);
            $jacocoInit[137] = true;
        } else if (i == 2) {
            sendFacebookLoginErrorEvent(throwable);
            $jacocoInit[138] = true;
        } else if (i != 3) {
            $jacocoInit[136] = true;
        } else {
            sendGoogleLoginFailEvent(throwable);
            $jacocoInit[139] = true;
        }
        $jacocoInit[140] = true;
    }

    public void sendSignUpErrorEvent(LoginMethod loginMethod, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (loginMethod.equals(LoginMethod.APTOIDE)) {
            $jacocoInit[141] = true;
            sendAptoideSignUpErrorEvent(throwable);
            $jacocoInit[143] = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown sign up method: ");
        sb.append(loginMethod.name());
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[142] = true;
        throw illegalStateException;
    }

    private void sendAptoideSignUpErrorEvent(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof AccountException) {
            LoginMethod loginMethod = LoginMethod.APTOIDE;
            SignUpLoginStatus signUpLoginStatus = SignUpLoginStatus.FAILED;
            AccountException accountException = (AccountException) throwable;
            $jacocoInit[144] = true;
            Map errors = accountException.getErrors();
            $jacocoInit[145] = true;
            Set keySet = errors.keySet();
            $jacocoInit[146] = true;
            String obj = keySet.toString();
            Map errors2 = ((AccountException) throwable).getErrors();
            $jacocoInit[147] = true;
            Collection values = errors2.values();
            $jacocoInit[148] = true;
            String obj2 = values.toString();
            $jacocoInit[149] = true;
            sendEvents(SIGN_UP_EVENT_NAME, loginMethod, signUpLoginStatus, WEB_ERROR, obj, obj2);
            $jacocoInit[150] = true;
        } else {
            sendWebserviceErrors(SIGN_UP_EVENT_NAME, LoginMethod.APTOIDE, throwable);
            $jacocoInit[151] = true;
        }
        $jacocoInit[152] = true;
    }

    public void clickIn(StartupClick connectGoogle, StartupClickOrigin startupClickOrigin) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[153] = true;
        map.put("Action", connectGoogle.getClickEvent());
        $jacocoInit[154] = true;
        map.put(SCREEN, startupClickOrigin.getClickOrigin());
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[155] = true;
        String viewName = getViewName(true);
        $jacocoInit[156] = true;
        analyticsManager2.logEvent(map, LOGIN_SIGN_UP_START_SCREEN, action, viewName);
        $jacocoInit[157] = true;
    }

    public void createdUserProfile(boolean hasPicture) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[158] = true;
        if (hasPicture) {
            $jacocoInit[159] = true;
            str = "True";
        } else {
            $jacocoInit[160] = true;
            str = "False";
        }
        map.put(HAS_PICTURE, str);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[161] = true;
        String viewName = getViewName(true);
        $jacocoInit[162] = true;
        analyticsManager2.logEvent(map, CREATE_USER_PROFILE, action, viewName);
        $jacocoInit[163] = true;
    }

    public void accountProfileAction(int screen, ProfileAction action) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> map = new HashMap<>();
        $jacocoInit[164] = true;
        map.put("Action", action.getAction());
        $jacocoInit[165] = true;
        map.put("screen", Integer.toString(screen));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action2 = Action.CLICK;
        $jacocoInit[166] = true;
        String viewName = getViewName(true);
        $jacocoInit[167] = true;
        analyticsManager2.logEvent(map, PROFILE_SETTINGS, action2, viewName);
        $jacocoInit[168] = true;
    }

    public void createStore(boolean hasPicture, CreateStoreAction action) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> map = new HashMap<>();
        $jacocoInit[169] = true;
        map.put(STORE_ACTION, action);
        $jacocoInit[170] = true;
        if (hasPicture) {
            $jacocoInit[171] = true;
            str = "True";
        } else {
            $jacocoInit[172] = true;
            str = "False";
        }
        map.put(HAS_PICTURE, str);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action2 = Action.CLICK;
        $jacocoInit[173] = true;
        String viewName = getViewName(true);
        $jacocoInit[174] = true;
        analyticsManager2.logEvent(map, CREATE_YOUR_STORE, action2, viewName);
        $jacocoInit[175] = true;
    }

    public void enterAccountScreen(AccountOrigins sourceValue) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[176] = true;
        map.put(SOURCE, sourceValue.getOrigin());
        $jacocoInit[177] = true;
        this.analyticsManager.logEvent(map, ENTRY, Action.CLICK, getViewName(true));
        $jacocoInit[178] = true;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[179] = true;
        return viewName;
    }
}
