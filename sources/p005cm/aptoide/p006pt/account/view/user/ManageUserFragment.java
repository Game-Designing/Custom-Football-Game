package p005cm.aptoide.p006pt.account.view.user;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.parceler.C14377B;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.ImagePickerErrorHandler;
import p005cm.aptoide.p006pt.account.view.ImagePickerPresenter;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.presenter.CompositePresenter;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.BackButtonFragment;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.dialog.ImagePickerDialog;
import p019d.p022i.p296a.p298b.p299a.p300a.C13008a;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.view.user.ManageUserFragment */
public class ManageUserFragment extends BackButtonFragment implements ManageUserView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int DEFAULT_IMAGE_PLACEHOLDER = 2131231030;
    private static final String EXTRA_IS_EDIT = "is_edit";
    private static final String EXTRA_USER_MODEL = "user_model";
    private View birthdayLayout;
    private TextView calendarDateView;
    private View calendarLayout;
    private Button cancelUserProfile;
    private Button createUserButton;
    private ViewModel currentModel;
    private DatePickerDialog datePickerDialog;
    private ImagePickerDialog dialogFragment;
    private ImagePickerErrorHandler imagePickerErrorHandler;
    @Inject
    ImagePickerPresenter imagePickerPresenter;
    private boolean isEditProfile;
    @Inject
    ManageUserPresenter manageUserPresenter;
    private View newsLetterLayout;
    private CheckBox newsletterCheckBox;
    @Inject
    NewsletterManager newsletterManager;
    @Inject
    ScreenOrientationManager orientationManager;
    @Inject
    String theme;
    private Toolbar toolbar;
    private ProgressDialog uploadWaitDialog;
    private EditText userName;
    private ImageView userPicture;
    private RelativeLayout userPictureLayout;

    /* renamed from: cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel */
    protected static class ViewModel {
        private static transient /* synthetic */ boolean[] $jacocoData;
        String date;
        private int day;
        boolean hasDateError;
        boolean hasNewPicture;
        boolean hasNewsletterSubscribe;
        private int month;
        String name;
        String pictureUri;
        String requestDate;
        private int year;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(1748900215454843071L, "cm/aptoide/pt/account/view/user/ManageUserFragment$ViewModel", 29);
            $jacocoData = probes;
            return probes;
        }

        public ViewModel() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = "";
            this.name = str;
            this.pictureUri = str;
            this.date = str;
            this.requestDate = str;
            this.year = -1;
            this.month = -1;
            this.day = -1;
            this.hasNewPicture = false;
            this.hasNewsletterSubscribe = false;
            this.hasDateError = false;
            $jacocoInit[0] = true;
        }

        public ViewModel(String name2, String pictureUri2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.name = name2;
            this.pictureUri = pictureUri2;
            this.hasNewPicture = false;
            String str = "";
            this.date = str;
            this.requestDate = str;
            this.year = -1;
            this.month = -1;
            this.day = -1;
            this.hasNewPicture = false;
            this.hasNewsletterSubscribe = false;
            this.hasDateError = false;
            $jacocoInit[1] = true;
        }

        public static ViewModel from(ViewModel otherModel, String otherName, String date2, boolean hasNewsletterSubscribe2) {
            boolean[] $jacocoInit = $jacocoInit();
            otherModel.setName(otherName);
            $jacocoInit[2] = true;
            otherModel.setDate(date2);
            $jacocoInit[3] = true;
            otherModel.setNewsLetterSubscribe(hasNewsletterSubscribe2);
            $jacocoInit[4] = true;
            return otherModel;
        }

        public String getName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.name;
            $jacocoInit[5] = true;
            return str;
        }

        public void setName(String name2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.name = name2;
            $jacocoInit[6] = true;
        }

        public String getPictureUri() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.pictureUri;
            $jacocoInit[7] = true;
            return str;
        }

        public void setPictureUri(String pictureUri2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.pictureUri = pictureUri2;
            $jacocoInit[8] = true;
        }

        public void setNewPicture(boolean hasNewPicture2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.hasNewPicture = hasNewPicture2;
            $jacocoInit[9] = true;
        }

        public boolean hasNewPicture() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.hasNewPicture;
            $jacocoInit[10] = true;
            return z;
        }

        public String getDate() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.date;
            $jacocoInit[11] = true;
            return str;
        }

        public void setDate(String date2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.date = date2;
            $jacocoInit[12] = true;
        }

        public String getRequestDate() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.requestDate;
            $jacocoInit[13] = true;
            return str;
        }

        public boolean getNewsletterSubscribe() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.hasNewsletterSubscribe;
            $jacocoInit[14] = true;
            return z;
        }

        /* access modifiers changed from: 0000 */
        public void setNewsLetterSubscribe(boolean hasNewsLetterSubscribe) {
            boolean[] $jacocoInit = $jacocoInit();
            this.hasNewsletterSubscribe = hasNewsLetterSubscribe;
            $jacocoInit[15] = true;
        }

        /* access modifiers changed from: 0000 */
        public void setDate(int year2, int month2, int day2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.year = year2;
            this.month = month2;
            this.day = day2;
            $jacocoInit[16] = true;
        }

        public int getYear() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.year;
            $jacocoInit[17] = true;
            return i;
        }

        public int getMonth() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.month;
            $jacocoInit[18] = true;
            return i;
        }

        public int getDay() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.day;
            $jacocoInit[19] = true;
            return i;
        }

        public boolean hasDate() {
            boolean z;
            boolean[] $jacocoInit = $jacocoInit();
            if (this.year == -1) {
                $jacocoInit[20] = true;
            } else if (this.month == -1) {
                $jacocoInit[21] = true;
            } else if (this.day == -1) {
                $jacocoInit[22] = true;
            } else {
                $jacocoInit[23] = true;
                z = true;
                $jacocoInit[25] = true;
                return z;
            }
            z = false;
            $jacocoInit[24] = true;
            $jacocoInit[25] = true;
            return z;
        }

        public void setDateInRequestFormat(String requestDate2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.requestDate = requestDate2;
            $jacocoInit[26] = true;
        }

        public boolean hasDateError() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.hasDateError;
            $jacocoInit[27] = true;
            return z;
        }

        public void setDateError() {
            boolean[] $jacocoInit = $jacocoInit();
            this.hasDateError = true;
            $jacocoInit[28] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3586325076885444343L, "cm/aptoide/pt/account/view/user/ManageUserFragment", Opcodes.IF_ICMPEQ);
        $jacocoData = probes;
        return probes;
    }

    public ManageUserFragment() {
        $jacocoInit()[0] = true;
    }

    public static ManageUserFragment newInstanceToEdit() {
        boolean[] $jacocoInit = $jacocoInit();
        ManageUserFragment newInstance = newInstance(true);
        $jacocoInit[1] = true;
        return newInstance;
    }

    public static ManageUserFragment newInstanceToCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        ManageUserFragment newInstance = newInstance(false);
        $jacocoInit[2] = true;
        return newInstance;
    }

    private static ManageUserFragment newInstance(boolean editUser) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[3] = true;
        args.putBoolean(EXTRA_IS_EDIT, editUser);
        $jacocoInit[4] = true;
        ManageUserFragment manageUserFragment = new ManageUserFragment();
        $jacocoInit[5] = true;
        manageUserFragment.setArguments(args);
        $jacocoInit[6] = true;
        return manageUserFragment;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            boolean[] r0 = $jacocoInit()
            super.onCreate(r8)
            r1 = 1
            r2 = 7
            r0[r2] = r1
            cm.aptoide.pt.view.FragmentComponent r2 = r7.getFragmentComponent(r8)
            r2.inject(r7)
            r2 = 8
            r0[r2] = r1
            android.content.Context r2 = r7.getContext()
            r3 = 9
            r0[r3] = r1
            if (r8 != 0) goto L_0x0025
            r3 = 10
            r0[r3] = r1
            goto L_0x0031
        L_0x0025:
            java.lang.String r3 = "user_model"
            boolean r4 = r8.containsKey(r3)
            if (r4 != 0) goto L_0x003d
            r3 = 11
            r0[r3] = r1
        L_0x0031:
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = new cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel
            r3.<init>()
            r7.currentModel = r3
            r3 = 14
            r0[r3] = r1
            goto L_0x0051
        L_0x003d:
            r4 = 12
            r0[r4] = r1
            android.os.Parcelable r3 = r8.getParcelable(r3)
            java.lang.Object r3 = org.parceler.C14377B.m45945a(r3)
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = (p005cm.aptoide.p006pt.account.view.user.ManageUserFragment.ViewModel) r3
            r7.currentModel = r3
            r3 = 13
            r0[r3] = r1
        L_0x0051:
            android.os.Bundle r3 = r7.getArguments()
            r4 = 15
            r0[r4] = r1
            r4 = 0
            if (r3 != 0) goto L_0x0061
            r5 = 16
            r0[r5] = r1
            goto L_0x006d
        L_0x0061:
            java.lang.String r5 = "is_edit"
            boolean r5 = r3.getBoolean(r5, r4)
            if (r5 != 0) goto L_0x0072
            r5 = 17
            r0[r5] = r1
        L_0x006d:
            r5 = 19
            r0[r5] = r1
            goto L_0x0077
        L_0x0072:
            r4 = 18
            r0[r4] = r1
            r4 = 1
        L_0x0077:
            r7.isEditProfile = r4
            r4 = 20
            r0[r4] = r1
            cm.aptoide.pt.account.view.ImagePickerErrorHandler r4 = new cm.aptoide.pt.account.view.ImagePickerErrorHandler
            r4.<init>(r2)
            r7.imagePickerErrorHandler = r4
            cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder r4 = new cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder
            r5 = 21
            r0[r5] = r1
            android.content.Context r5 = r7.getContext()
            r4.<init>(r5)
            r5 = 2131427438(0x7f0b006e, float:1.8476492E38)
            cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder r4 = r4.setViewRes(r5)
            r5 = 2131690511(0x7f0f040f, float:1.9010068E38)
            r6 = 22
            r0[r6] = r1
            cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder r4 = r4.setTitle(r5)
            r5 = 2131689729(0x7f0f0101, float:1.9008482E38)
            r6 = 23
            r0[r6] = r1
            cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder r4 = r4.setNegativeButton(r5)
            r5 = 2131296492(0x7f0900ec, float:1.8210902E38)
            r6 = 24
            r0[r6] = r1
            cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder r4 = r4.setCameraButton(r5)
            r5 = 2131296496(0x7f0900f0, float:1.821091E38)
            r6 = 25
            r0[r6] = r1
            cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder r4 = r4.setGalleryButton(r5)
            r5 = 26
            r0[r5] = r1
            cm.aptoide.pt.view.dialog.ImagePickerDialog r4 = r4.build()
            r7.dialogFragment = r4
            r4 = 2131690244(0x7f0f0304, float:1.9009526E38)
            r5 = 27
            r0[r5] = r1
            java.lang.String r4 = r2.getString(r4)
            r5 = 28
            r0[r5] = r1
            android.app.ProgressDialog r4 = p005cm.aptoide.p006pt.utils.GenericDialogs.createGenericPleaseWaitDialog(r2, r4)
            r7.uploadWaitDialog = r4
            r4 = 29
            r0[r4] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.user.ManageUserFragment.onCreate(android.os.Bundle):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            boolean[] r0 = $jacocoInit()
            super.onViewCreated(r8, r9)
            r1 = 1
            r2 = 30
            r0[r2] = r1
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            r3 = 31
            r0[r3] = r1
            r7.bindViews(r8)
            r3 = 32
            r0[r3] = r1
            r7.setupToolbar()
            r3 = 33
            r0[r3] = r1
            if (r9 != 0) goto L_0x0029
            r3 = 34
            r0[r3] = r1
            goto L_0x0035
        L_0x0029:
            java.lang.String r3 = "user_model"
            boolean r4 = r9.containsKey(r3)
            if (r4 != 0) goto L_0x0042
            r3 = 35
            r0[r3] = r1
        L_0x0035:
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = new cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel
            r3.<init>()
            r7.currentModel = r3
            r3 = 47
            r0[r3] = r1
            goto L_0x00ba
        L_0x0042:
            r4 = 36
            r0[r4] = r1
            android.os.Parcelable r3 = r9.getParcelable(r3)
            java.lang.Object r3 = org.parceler.C14377B.m45945a(r3)
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = (p005cm.aptoide.p006pt.account.view.user.ManageUserFragment.ViewModel) r3
            r7.currentModel = r3
            r3 = 37
            r0[r3] = r1
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = r7.currentModel
            java.lang.String r3 = r3.getPictureUri()
            r7.loadImageStateless(r3)
            r3 = 38
            r0[r3] = r1
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = r7.currentModel
            java.lang.String r3 = r3.getName()
            r7.setUserName(r3)
            boolean r3 = r7.isEditProfile
            if (r3 == 0) goto L_0x0075
            r3 = 39
            r0[r3] = r1
            goto L_0x00ba
        L_0x0075:
            r3 = 40
            r0[r3] = r1
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = r7.currentModel
            boolean r3 = r3.hasDate()
            if (r3 != 0) goto L_0x0086
            r3 = 41
            r0[r3] = r1
            goto L_0x00ba
        L_0x0086:
            r3 = 42
            r0[r3] = r1
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r3 = r7.currentModel
            int r3 = r3.getYear()
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r4 = r7.currentModel
            int r4 = r4.getMonth()
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r5 = r7.currentModel
            r6 = 43
            r0[r6] = r1
            int r5 = r5.getDay()
            r6 = 44
            r0[r6] = r1
            r7.setupCalendar(r2, r3, r4, r5)
            r3 = 45
            r0[r3] = r1
            android.widget.TextView r3 = r7.calendarDateView
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r4 = r7.currentModel
            java.lang.String r4 = r4.getDate()
            r3.setText(r4)
            r3 = 46
            r0[r3] = r1
        L_0x00ba:
            boolean r3 = r7.isEditProfile
            r4 = 0
            if (r3 == 0) goto L_0x00dd
            r3 = 48
            r0[r3] = r1
            android.widget.Button r3 = r7.createUserButton
            r5 = 2131689868(0x7f0f018c, float:1.9008764E38)
            java.lang.String r5 = r7.getString(r5)
            r3.setText(r5)
            r3 = 49
            r0[r3] = r1
            android.widget.Button r3 = r7.cancelUserProfile
            r3.setVisibility(r4)
            r3 = 50
            r0[r3] = r1
            goto L_0x00f4
        L_0x00dd:
            android.view.View r3 = r7.birthdayLayout
            r3.setVisibility(r4)
            r3 = 51
            r0[r3] = r1
            r7.handleNewsletterVisibility()
            r3 = 52
            r0[r3] = r1
            r7.setupDatePickerDialog(r2)
            r3 = 53
            r0[r3] = r1
        L_0x00f4:
            r7.attachPresenters()
            r3 = 54
            r0[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.user.ManageUserFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[55] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[56] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[57] = true;
        return build;
    }

    private void handleNewsletterVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.newsletterManager.shouldShowNewsletter()) {
            $jacocoInit[58] = true;
            this.newsLetterLayout.setVisibility(0);
            $jacocoInit[59] = true;
        } else {
            this.newsLetterLayout.setVisibility(8);
            $jacocoInit[60] = true;
        }
        $jacocoInit[61] = true;
    }

    private void setupDatePickerDialog(Calendar calendar) {
        boolean[] $jacocoInit = $jacocoInit();
        C1581a aVar = new C1581a(this, calendar);
        $jacocoInit[62] = true;
        Context context = getContext();
        StoreTheme storeTheme = StoreTheme.get(this.theme);
        $jacocoInit[63] = true;
        int datePickerStyle = storeTheme.getDatePickerStyle();
        int i = calendar.get(1);
        $jacocoInit[64] = true;
        DatePickerDialog datePickerDialog2 = new DatePickerDialog(context, datePickerStyle, aVar, i, calendar.get(2), calendar.get(5));
        this.datePickerDialog = datePickerDialog2;
        $jacocoInit[65] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9879a(Calendar calendar, DatePicker datePicker, int year, int month, int day) {
        boolean[] $jacocoInit = $jacocoInit();
        int monthNumber = month + 1;
        $jacocoInit[156] = true;
        setupCalendar(calendar, year, monthNumber, day);
        $jacocoInit[157] = true;
        setupCalendarDateString(year, monthNumber, day);
        $jacocoInit[158] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupCalendarDateString(int r11, int r12, int r13) {
        /*
            r10 = this;
            boolean[] r0 = $jacocoInit()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r12)
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r3 = 66
            r0[r3] = r2
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy/MM/dd"
            r3.<init>(r4)
            r4 = 67
            r5 = 0
            r0[r4] = r2     // Catch:{ ParseException -> 0x003f }
            r4 = r5
            java.util.Date r5 = r3.parse(r1)     // Catch:{ ParseException -> 0x003a }
            r4 = r5
            r5 = 68
            r0[r5] = r2
            goto L_0x0067
        L_0x003a:
            r5 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
            goto L_0x0040
        L_0x003f:
            r4 = move-exception
        L_0x0040:
            r6 = 69
            r0[r6] = r2
            android.widget.Button r6 = r10.createUserButton
            r7 = 2131690504(0x7f0f0408, float:1.9010053E38)
            java.lang.String r7 = r10.getString(r7)
            r8 = -1
            android.support.design.widget.Snackbar r6 = android.support.design.widget.Snackbar.m1624a(r6, r7, r8)
            r7 = 70
            r0[r7] = r2
            r6.mo4690h()
            r6 = 71
            r0[r6] = r2
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r6 = r10.currentModel
            r6.setDateError()
            r6 = 72
            r0[r6] = r2
            r4 = r5
        L_0x0067:
            if (r4 != 0) goto L_0x006e
            r5 = 73
            r0[r5] = r2
            goto L_0x00ab
        L_0x006e:
            r5 = 74
            r0[r5] = r2
            r5 = 3
            java.text.DateFormat r5 = java.text.DateFormat.getDateInstance(r5)
            r6 = 75
            r0[r6] = r2
            java.lang.String r1 = r5.format(r4)
            r5 = 76
            r0[r5] = r2
            android.widget.TextView r5 = r10.calendarDateView
            r5.setText(r1)
            r5 = 77
            r0[r5] = r2
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r5 = r10.currentModel
            java.lang.String r6 = r3.format(r4)
            r5.setDateInRequestFormat(r6)
            r5 = 78
            r0[r5] = r2
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r5 = r10.currentModel
            r5.setDate(r1)
            r5 = 79
            r0[r5] = r2
            cm.aptoide.pt.account.view.user.ManageUserFragment$ViewModel r5 = r10.currentModel
            r5.setDate(r11, r12, r13)
            r5 = 80
            r0[r5] = r2
        L_0x00ab:
            r5 = 81
            r0[r5] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.user.ManageUserFragment.setupCalendarDateString(int, int, int):void");
    }

    private void setupCalendar(Calendar calendar, int year, int month, int day) {
        boolean[] $jacocoInit = $jacocoInit();
        calendar.set(1, year);
        $jacocoInit[82] = true;
        calendar.set(2, month);
        $jacocoInit[83] = true;
        calendar.set(5, day);
        $jacocoInit[84] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_manage_user, container, false);
        $jacocoInit[85] = true;
        return inflate;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[86] = true;
        outState.putParcelable(EXTRA_USER_MODEL, C14377B.m45944a(this.currentModel));
        $jacocoInit[87] = true;
    }

    private void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[88] = true;
        this.userPictureLayout = (RelativeLayout) view.findViewById(C1375R.C1376id.create_user_image_action);
        $jacocoInit[89] = true;
        this.userName = (EditText) view.findViewById(C1375R.C1376id.create_user_username_inserted);
        $jacocoInit[90] = true;
        this.createUserButton = (Button) view.findViewById(C1375R.C1376id.create_user_create_profile);
        $jacocoInit[91] = true;
        this.cancelUserProfile = (Button) view.findViewById(C1375R.C1376id.create_user_cancel_button);
        $jacocoInit[92] = true;
        this.userPicture = (ImageView) view.findViewById(C1375R.C1376id.create_user_image);
        $jacocoInit[93] = true;
        this.birthdayLayout = view.findViewById(C1375R.C1376id.birthday_layout);
        $jacocoInit[94] = true;
        this.newsLetterLayout = view.findViewById(C1375R.C1376id.newsletter_layout);
        $jacocoInit[95] = true;
        this.calendarLayout = view.findViewById(C1375R.C1376id.calendar_layout);
        $jacocoInit[96] = true;
        this.calendarDateView = (TextView) view.findViewById(C1375R.C1376id.calendar_date);
        $jacocoInit[97] = true;
        this.newsletterCheckBox = (CheckBox) view.findViewById(C1375R.C1376id.newsletter_checkbox);
        $jacocoInit[98] = true;
    }

    private void setupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isEditProfile) {
            $jacocoInit[99] = true;
            this.toolbar.setTitle((CharSequence) getString(C1375R.string.edit_profile_title));
            $jacocoInit[100] = true;
        } else {
            this.toolbar.setTitle((int) C1375R.string.create_user_title);
            $jacocoInit[101] = true;
        }
        ((C0019n) getActivity()).setSupportActionBar(this.toolbar);
        $jacocoInit[102] = true;
        C0760a actionBar = ((C0019n) getActivity()).getSupportActionBar();
        $jacocoInit[103] = true;
        actionBar.mo6153d(false);
        $jacocoInit[104] = true;
        actionBar.mo6147a(this.toolbar.getTitle());
        $jacocoInit[105] = true;
    }

    private void attachPresenters() {
        boolean[] $jacocoInit = $jacocoInit();
        Presenter[] presenterArr = {this.manageUserPresenter, this.imagePickerPresenter};
        $jacocoInit[106] = true;
        CompositePresenter compositePresenter = new CompositePresenter(Arrays.asList(presenterArr));
        $jacocoInit[107] = true;
        attachPresenter(compositePresenter);
        $jacocoInit[108] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        ProgressDialog progressDialog = this.uploadWaitDialog;
        if (progressDialog == null) {
            $jacocoInit[109] = true;
        } else if (!progressDialog.isShowing()) {
            $jacocoInit[110] = true;
        } else {
            $jacocoInit[111] = true;
            this.uploadWaitDialog.dismiss();
            $jacocoInit[112] = true;
        }
        this.birthdayLayout = null;
        this.newsLetterLayout = null;
        this.calendarLayout = null;
        this.calendarDateView = null;
        this.newsletterCheckBox = null;
        $jacocoInit[113] = true;
        super.onDestroyView();
        $jacocoInit[114] = true;
    }

    public void setUserName(String name) {
        boolean[] $jacocoInit = $jacocoInit();
        this.currentModel.setName(name);
        $jacocoInit[115] = true;
        this.userName.setText(name);
        $jacocoInit[116] = true;
    }

    public C0120S<ViewModel> saveUserDataButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.createUserButton);
        C1585c cVar = new C1585c(this);
        $jacocoInit[117] = true;
        C0120S<ViewModel> j = a.mo3669j(cVar);
        $jacocoInit[118] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ ViewModel mo9878a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        ViewModel updateModelAndGet = updateModelAndGet();
        $jacocoInit[155] = true;
        return updateModelAndGet;
    }

    public C0120S<Void> cancelButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.cancelUserProfile);
        $jacocoInit[119] = true;
        return a;
    }

    public void showProgressDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.lock();
        $jacocoInit[120] = true;
        hideKeyboard();
        $jacocoInit[121] = true;
        this.uploadWaitDialog.show();
        $jacocoInit[122] = true;
    }

    public void hideProgressDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.uploadWaitDialog.dismiss();
        $jacocoInit[123] = true;
        this.orientationManager.unlock();
        $jacocoInit[124] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Snackbar mo9877a(String error) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a((View) this.createUserButton, (CharSequence) error, 0);
        $jacocoInit[154] = true;
        return a;
    }

    public C0117M showErrorMessage(String error) {
        boolean[] $jacocoInit = $jacocoInit();
        Single b = Single.m742b((Callable<? extends T>) new C1589e<Object>(this, error));
        C1583b bVar = C1583b.f4525a;
        $jacocoInit[125] = true;
        C0117M b2 = b.mo3693b((C0132p<? super T, ? extends C0117M>) bVar);
        $jacocoInit[126] = true;
        return b2;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m6321a(Snackbar snackbar) {
        boolean[] $jacocoInit = $jacocoInit();
        snackbar.mo4690h();
        $jacocoInit[151] = true;
        C0120S a = C13008a.m42472a(snackbar);
        $jacocoInit[152] = true;
        C0117M l = a.mo3673l();
        $jacocoInit[153] = true;
        return l;
    }

    public void loadImageStateless(String pictureUri) {
        boolean[] $jacocoInit = $jacocoInit();
        this.currentModel.setPictureUri(pictureUri);
        $jacocoInit[127] = true;
        ImageLoader with = ImageLoader.with(getActivity());
        ImageView imageView = this.userPicture;
        $jacocoInit[128] = true;
        with.loadUsingCircleTransformAndPlaceholder(pictureUri, imageView, C1375R.drawable.create_user_avatar);
        $jacocoInit[129] = true;
    }

    public C0120S<Void> calendarLayoutClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.calendarLayout);
        $jacocoInit[130] = true;
        return a;
    }

    public void showCalendar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.datePickerDialog.show();
        $jacocoInit[131] = true;
    }

    public void showEmptyBirthdayMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a((View) this.createUserButton, (CharSequence) getString(C1375R.string.createuser_message_profile_no_dob), -1);
        $jacocoInit[132] = true;
        a.mo4690h();
        $jacocoInit[133] = true;
    }

    public void loadImage(String pictureUri) {
        boolean[] $jacocoInit = $jacocoInit();
        loadImageStateless(pictureUri);
        $jacocoInit[134] = true;
        this.currentModel.setNewPicture(true);
        $jacocoInit[135] = true;
    }

    public C0120S<DialogInterface> dialogCameraSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> cameraSelected = this.dialogFragment.cameraSelected();
        $jacocoInit[136] = true;
        return cameraSelected;
    }

    public C0120S<DialogInterface> dialogGallerySelected() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> gallerySelected = this.dialogFragment.gallerySelected();
        $jacocoInit[137] = true;
        return gallerySelected;
    }

    public void showImagePickerDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialogFragment.show();
        $jacocoInit[138] = true;
    }

    public void showIconPropertiesError(InvalidImageException exception) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showIconPropertiesError = this.imagePickerErrorHandler.showIconPropertiesError(exception);
        LifecycleEvent lifecycleEvent = LifecycleEvent.PAUSE;
        $jacocoInit[139] = true;
        C0120S a = showIconPropertiesError.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
        C1587d dVar = C1587d.f4529a;
        C1591f fVar = C1591f.f4534a;
        $jacocoInit[140] = true;
        a.mo3626a((C0129b<? super T>) dVar, (C0129b<Throwable>) fVar);
        $jacocoInit[141] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6322a(EResponse __) {
        $jacocoInit()[150] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6323a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[148] = true;
        instance.log(err);
        $jacocoInit[149] = true;
    }

    public C0120S<Void> selectStoreImageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.userPictureLayout);
        $jacocoInit[142] = true;
        return a;
    }

    public void dismissLoadImageDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialogFragment.dismiss();
        $jacocoInit[143] = true;
    }

    public ViewModel updateModelAndGet() {
        boolean[] $jacocoInit = $jacocoInit();
        ViewModel viewModel = this.currentModel;
        Editable text = this.userName.getText();
        $jacocoInit[144] = true;
        String obj = text.toString();
        CharSequence text2 = this.calendarDateView.getText();
        $jacocoInit[145] = true;
        String charSequence = text2.toString();
        boolean isChecked = this.newsletterCheckBox.isChecked();
        $jacocoInit[146] = true;
        ViewModel.from(viewModel, obj, charSequence, isChecked);
        $jacocoInit[147] = true;
        return viewModel;
    }
}
