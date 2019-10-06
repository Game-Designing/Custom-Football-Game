package p005cm.aptoide.p006pt.view.feedback;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.app.C0424G;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.content.FileProvider;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import java.io.File;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.fragment.BaseToolbarFragment;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.feedback.SendFeedbackFragment */
public class SendFeedbackFragment extends BaseToolbarFragment implements NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String CARD_ID = "card_id";
    public static final String LOGS_FILE_NAME = "logs.txt";
    public static final String SCREENSHOT_PATH = "SCREENSHOT_PATH";
    private final String KEY_SCREENSHOT_PATH = "screenShotPath";
    private NavigationTracker aptoideNavigationTracker;
    private String cardId;
    private CrashReport crashReport;
    private InstalledRepository installedRepository;
    private CheckBox logsAndScreenshotsCb;
    private EditText messageBodyEdit;
    private String screenShotPath;
    private Button sendFeedbackBtn;
    private EditText subgectEdit;
    private C0137ja unManagedSubscription;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1197192291042971307L, "cm/aptoide/pt/view/feedback/SendFeedbackFragment", 105);
        $jacocoData = probes;
        return probes;
    }

    public SendFeedbackFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public static SendFeedbackFragment newInstance(String screenshotFilePath) {
        boolean[] $jacocoInit = $jacocoInit();
        SendFeedbackFragment sendFeedbackFragment = new SendFeedbackFragment();
        $jacocoInit[1] = true;
        Bundle bundle = new Bundle();
        $jacocoInit[2] = true;
        bundle.putString(SCREENSHOT_PATH, screenshotFilePath);
        $jacocoInit[3] = true;
        sendFeedbackFragment.setArguments(bundle);
        $jacocoInit[4] = true;
        return sendFeedbackFragment;
    }

    public static SendFeedbackFragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        SendFeedbackFragment sendFeedbackFragment = new SendFeedbackFragment();
        $jacocoInit[5] = true;
        return sendFeedbackFragment;
    }

    public static SendFeedbackFragment newInstance(String screenShotPath2, String cardId2) {
        boolean[] $jacocoInit = $jacocoInit();
        SendFeedbackFragment sendFeedbackFragment = new SendFeedbackFragment();
        $jacocoInit[6] = true;
        Bundle bundle = new Bundle();
        $jacocoInit[7] = true;
        bundle.putString(SCREENSHOT_PATH, screenShotPath2);
        $jacocoInit[8] = true;
        bundle.putString(CARD_ID, cardId2);
        $jacocoInit[9] = true;
        sendFeedbackFragment.setArguments(bundle);
        $jacocoInit[10] = true;
        return sendFeedbackFragment;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[11] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[12] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[13] = true;
        return build;
    }

    public void setArguments(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.setArguments(args);
        $jacocoInit[14] = true;
        this.screenShotPath = args.getString(SCREENSHOT_PATH);
        $jacocoInit[15] = true;
        this.cardId = args.getString(CARD_ID);
        $jacocoInit[16] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[17] = true;
        outState.putString("screenShotPath", this.screenShotPath);
        $jacocoInit[18] = true;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        $jacocoInit[19] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[20] = true;
            getActivity().onBackPressed();
            $jacocoInit[21] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[22] = true;
        return onOptionsItemSelected;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[23] = true;
        this.installedRepository = RepositoryFactory.getInstalledRepository(getContext().getApplicationContext());
        $jacocoInit[24] = true;
        this.aptoideNavigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
        $jacocoInit[25] = true;
        this.crashReport = CrashReport.getInstance();
        $jacocoInit[26] = true;
        setHasOptionsMenu(true);
        $jacocoInit[27] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            $jacocoInit[28] = true;
        } else {
            $jacocoInit[29] = true;
            this.screenShotPath = savedInstanceState.getString("screenShotPath");
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        C0137ja jaVar = this.unManagedSubscription;
        if (jaVar == null) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            jaVar.unsubscribe();
            $jacocoInit[34] = true;
        }
        $jacocoInit[35] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[36] = true;
        C0120S a = C13034a.m42490a(this.sendFeedbackBtn);
        C5339b bVar = new C5339b(this);
        C5338a aVar = new C5338a(this);
        $jacocoInit[37] = true;
        a.mo3626a((C0129b<? super T>) bVar, (C0129b<Throwable>) aVar);
        $jacocoInit[38] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17218a(Void aVoid) {
        boolean[] $jacocoInit = $jacocoInit();
        sendFeedback();
        $jacocoInit[104] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17219b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[103] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[39] = true;
        return true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[40] = true;
        this.subgectEdit = (EditText) view.findViewById(C1375R.C1376id.FeedBackSubject);
        $jacocoInit[41] = true;
        this.messageBodyEdit = (EditText) view.findViewById(C1375R.C1376id.FeedBacktext);
        $jacocoInit[42] = true;
        this.sendFeedbackBtn = (Button) view.findViewById(C1375R.C1376id.FeedBackSendButton);
        $jacocoInit[43] = true;
        this.logsAndScreenshotsCb = (CheckBox) view.findViewById(C1375R.C1376id.FeedBackCheckBox);
        $jacocoInit[44] = true;
    }

    private void sendFeedback() {
        boolean[] $jacocoInit = $jacocoInit();
        if (isContentValid()) {
            $jacocoInit[45] = true;
            Intent emailIntent = new Intent("android.intent.action.SEND_MULTIPLE");
            $jacocoInit[46] = true;
            emailIntent.setType("message/rfc822");
            $jacocoInit[47] = true;
            AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
            $jacocoInit[48] = true;
            String[] strArr = {application.getFeedbackEmail()};
            $jacocoInit[49] = true;
            emailIntent.putExtra("android.intent.extra.EMAIL", strArr);
            $jacocoInit[50] = true;
            Context applicationContext = getContext().getApplicationContext();
            $jacocoInit[51] = true;
            File cacheDir = applicationContext.getCacheDir();
            $jacocoInit[52] = true;
            String cachePath = cacheDir.getPath();
            $jacocoInit[53] = true;
            C0120S installed = this.installedRepository.getInstalled(getContext().getPackageName());
            $jacocoInit[54] = true;
            C0120S d = installed.mo3647d();
            $jacocoInit[55] = true;
            C0120S a = d.mo3616a(C14522a.m46170a());
            C5340c cVar = new C5340c(this, emailIntent, cachePath);
            C5341d dVar = new C5341d(this);
            $jacocoInit[56] = true;
            this.unManagedSubscription = a.mo3626a((C0129b<? super T>) cVar, (C0129b<Throwable>) dVar);
            $jacocoInit[57] = true;
        } else {
            ShowMessage.asSnack(getView(), (int) C1375R.string.feedback_not_valid);
            $jacocoInit[58] = true;
        }
        $jacocoInit[59] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17216a(Intent emailIntent, String cachePath, Installed installed1) {
        boolean[] $jacocoInit = $jacocoInit();
        String versionName = "";
        if (installed1 == null) {
            $jacocoInit[71] = true;
        } else {
            $jacocoInit[72] = true;
            versionName = installed1.getVersionName();
            $jacocoInit[73] = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[Feedback]-");
        sb.append(versionName);
        sb.append(": ");
        EditText editText = this.subgectEdit;
        $jacocoInit[74] = true;
        Editable text = editText.getText();
        $jacocoInit[75] = true;
        sb.append(text.toString());
        String sb2 = sb.toString();
        $jacocoInit[76] = true;
        emailIntent.putExtra("android.intent.extra.SUBJECT", sb2);
        $jacocoInit[77] = true;
        Editable text2 = this.messageBodyEdit.getText();
        $jacocoInit[78] = true;
        String obj = text2.toString();
        $jacocoInit[79] = true;
        emailIntent.putExtra("android.intent.extra.TEXT", obj);
        $jacocoInit[80] = true;
        if (!this.logsAndScreenshotsCb.isChecked()) {
            $jacocoInit[81] = true;
        } else {
            $jacocoInit[82] = true;
            ArrayList<Uri> uris = new ArrayList<>();
            String str = this.screenShotPath;
            if (str == null) {
                $jacocoInit[83] = true;
            } else {
                $jacocoInit[84] = true;
                File file = new File(str);
                $jacocoInit[85] = true;
                uris.add(getUriFromFile(file));
                $jacocoInit[86] = true;
            }
            String str2 = this.cardId;
            if (str2 != null) {
                $jacocoInit[87] = true;
            } else {
                NavigationTracker navigationTracker = this.aptoideNavigationTracker;
                $jacocoInit[88] = true;
                str2 = navigationTracker.getPrettyScreenHistory();
                $jacocoInit[89] = true;
            }
            File logs = SystemU.readLogs(cachePath, LOGS_FILE_NAME, str2);
            if (logs == null) {
                $jacocoInit[90] = true;
            } else {
                $jacocoInit[91] = true;
                uris.add(getUriFromFile(logs));
                $jacocoInit[92] = true;
            }
            emailIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", uris);
            try {
                $jacocoInit[93] = true;
            } catch (ActivityNotFoundException e) {
                $jacocoInit[100] = true;
                ShowMessage.asSnack(getView(), (int) C1375R.string.feedback_no_email);
                $jacocoInit[101] = true;
            }
        }
        C0486t supportFragmentManager = getActivity().getSupportFragmentManager();
        $jacocoInit[94] = true;
        C0424G a = supportFragmentManager.mo4909a();
        $jacocoInit[95] = true;
        a.mo5043c(this);
        $jacocoInit[96] = true;
        a.mo5032a();
        $jacocoInit[97] = true;
        startActivity(emailIntent);
        $jacocoInit[98] = true;
        getActivity().onBackPressed();
        $jacocoInit[99] = true;
        $jacocoInit[102] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17217a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[70] = true;
    }

    public boolean isContentValid() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.subgectEdit.getText();
        $jacocoInit[60] = true;
        String obj = text.toString();
        $jacocoInit[61] = true;
        if (!TextUtils.isEmpty(obj)) {
            $jacocoInit[62] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[63] = true;
        }
        $jacocoInit[64] = true;
        return z;
    }

    private Uri getUriFromFile(File file) {
        Uri photoURI;
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT > 23) {
            $jacocoInit[65] = true;
            photoURI = FileProvider.m2499a(getContext(), "cm.aptoide.pt.provider", file);
            $jacocoInit[66] = true;
        } else {
            photoURI = Uri.fromFile(file);
            $jacocoInit[67] = true;
        }
        $jacocoInit[68] = true;
        return photoURI;
    }

    public int getContentViewId() {
        $jacocoInit()[69] = true;
        return C1375R.layout.activity_feed_back;
    }
}
