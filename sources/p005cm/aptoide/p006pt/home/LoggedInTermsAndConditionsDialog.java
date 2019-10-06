package p005cm.aptoide.p006pt.home;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.CrashLogger;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p026rx.C0120S;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.LoggedInTermsAndConditionsDialog */
public class LoggedInTermsAndConditionsDialog {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String GDPR_DIALOG_EVENT_LISTENER_IS_NULL = "GDPR_DIALOG_EVENT_LISTENER_IS_NULL";
    private Button continueButton;
    private CrashLogger crashReport;
    private AlertDialog dialog;
    private Button logOutButton;
    private C14963c<String> uiEvents = C14963c.m46753p();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5992360497323946023L, "cm/aptoide/pt/home/LoggedInTermsAndConditionsDialog", 57);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ CrashLogger access$000(LoggedInTermsAndConditionsDialog x0) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashLogger crashLogger = x0.crashReport;
        $jacocoInit[56] = true;
        return crashLogger;
    }

    public LoggedInTermsAndConditionsDialog(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.crashReport = CrashReport.getInstance();
        $jacocoInit[2] = true;
        LayoutInflater inflater = LayoutInflater.from(context);
        $jacocoInit[3] = true;
        this.dialog = new Builder(context).create();
        $jacocoInit[4] = true;
        View dialogView = inflater.inflate(C1375R.layout.dialog_logged_in_accept_tos, null);
        $jacocoInit[5] = true;
        this.dialog.setView(dialogView);
        $jacocoInit[6] = true;
        this.continueButton = (Button) dialogView.findViewById(C1375R.C1376id.accept_continue);
        $jacocoInit[7] = true;
        this.logOutButton = (Button) dialogView.findViewById(C1375R.C1376id.log_out);
        $jacocoInit[8] = true;
        setPrivacyPolicyLinks(dialogView, context, this.uiEvents);
        $jacocoInit[9] = true;
        this.dialog.setCancelable(false);
        $jacocoInit[10] = true;
        this.dialog.setCanceledOnTouchOutside(false);
        $jacocoInit[11] = true;
        this.continueButton.setOnClickListener(new C3489ae(this));
        $jacocoInit[12] = true;
        this.logOutButton.setOnClickListener(new C3483_d(this));
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14542a(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.uiEvents;
        if (cVar != null) {
            $jacocoInit[51] = true;
            cVar.onNext("continue");
            $jacocoInit[52] = true;
            this.dialog.dismiss();
            $jacocoInit[53] = true;
        } else {
            this.crashReport.log(GDPR_DIALOG_EVENT_LISTENER_IS_NULL, "");
            $jacocoInit[54] = true;
        }
        $jacocoInit[55] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14543b(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.uiEvents;
        if (cVar != null) {
            $jacocoInit[47] = true;
            cVar.onNext("logout");
            $jacocoInit[48] = true;
        } else {
            this.crashReport.log(GDPR_DIALOG_EVENT_LISTENER_IS_NULL, "");
            $jacocoInit[49] = true;
        }
        this.dialog.dismiss();
        $jacocoInit[50] = true;
    }

    public void showDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.show();
        $jacocoInit[14] = true;
    }

    public void destroyDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.dialog.isShowing()) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            this.dialog.dismiss();
            $jacocoInit[17] = true;
        }
        this.dialog = null;
        Button button = this.continueButton;
        if (button == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            button.setOnClickListener(null);
            $jacocoInit[20] = true;
        }
        Button button2 = this.logOutButton;
        if (button2 == null) {
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            button2.setOnClickListener(null);
            $jacocoInit[23] = true;
        }
        this.continueButton = null;
        this.logOutButton = null;
        this.uiEvents = null;
        $jacocoInit[24] = true;
    }

    public C0120S<String> dialogClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.uiEvents;
        $jacocoInit[25] = true;
        return cVar;
    }

    private void setPrivacyPolicyLinks(View dialogView, Context context, C14963c<String> uiEvents2) {
        View view = dialogView;
        Context context2 = context;
        final C14963c<String> cVar = uiEvents2;
        boolean[] $jacocoInit = $jacocoInit();
        ClickableSpan termsAndConditionsClickListener = new ClickableSpan(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ LoggedInTermsAndConditionsDialog this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-4165356032456954223L, "cm/aptoide/pt/home/LoggedInTermsAndConditionsDialog$1", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onClick(View view) {
                boolean[] $jacocoInit = $jacocoInit();
                C14963c cVar = cVar;
                if (cVar != null) {
                    $jacocoInit[1] = true;
                    cVar.onNext("terms");
                    $jacocoInit[2] = true;
                } else {
                    LoggedInTermsAndConditionsDialog.access$000(this.this$0).log(LoggedInTermsAndConditionsDialog.GDPR_DIALOG_EVENT_LISTENER_IS_NULL, "");
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[26] = true;
        ClickableSpan privacyPolicyClickListener = new ClickableSpan(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ LoggedInTermsAndConditionsDialog this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-7666271961811081692L, "cm/aptoide/pt/home/LoggedInTermsAndConditionsDialog$2", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onClick(View view) {
                boolean[] $jacocoInit = $jacocoInit();
                C14963c cVar = cVar;
                if (cVar != null) {
                    $jacocoInit[1] = true;
                    cVar.onNext("privacy");
                    $jacocoInit[2] = true;
                } else {
                    LoggedInTermsAndConditionsDialog.access$000(this.this$0).log(LoggedInTermsAndConditionsDialog.GDPR_DIALOG_EVENT_LISTENER_IS_NULL, "");
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[27] = true;
        String baseString = context2.getString(C1375R.string.accept_terms_message_loggedin);
        $jacocoInit[28] = true;
        String buttonString = context2.getString(C1375R.string.terms_and_conditions_privacy_sign_up_message);
        $jacocoInit[29] = true;
        String termsAndConditionsPlaceHolder = context2.getString(C1375R.string.settings_terms_conditions);
        $jacocoInit[30] = true;
        String privacyPolicyPlaceHolder = context2.getString(C1375R.string.settings_privacy_policy);
        Object[] objArr = {termsAndConditionsPlaceHolder, privacyPolicyPlaceHolder};
        $jacocoInit[31] = true;
        String privacyAndTerms = String.format(baseString, objArr);
        Object[] objArr2 = {termsAndConditionsPlaceHolder, privacyPolicyPlaceHolder};
        $jacocoInit[32] = true;
        String buttonAccept = String.format(buttonString, objArr2);
        $jacocoInit[33] = true;
        Button continueButton2 = (Button) view.findViewById(C1375R.C1376id.accept_continue);
        $jacocoInit[34] = true;
        continueButton2.setText(buttonAccept);
        $jacocoInit[35] = true;
        SpannableString privacyAndTermsSpan = new SpannableString(privacyAndTerms);
        $jacocoInit[36] = true;
        int indexOf = privacyAndTerms.indexOf(termsAndConditionsPlaceHolder);
        $jacocoInit[37] = true;
        int indexOf2 = privacyAndTerms.indexOf(termsAndConditionsPlaceHolder);
        $jacocoInit[38] = true;
        int length = indexOf2 + termsAndConditionsPlaceHolder.length();
        $jacocoInit[39] = true;
        privacyAndTermsSpan.setSpan(termsAndConditionsClickListener, indexOf, length, 33);
        $jacocoInit[40] = true;
        int indexOf3 = privacyAndTerms.indexOf(privacyPolicyPlaceHolder);
        $jacocoInit[41] = true;
        int indexOf4 = privacyAndTerms.indexOf(privacyPolicyPlaceHolder) + privacyPolicyPlaceHolder.length();
        $jacocoInit[42] = true;
        privacyAndTermsSpan.setSpan(privacyPolicyClickListener, indexOf3, indexOf4, 33);
        $jacocoInit[43] = true;
        TextView info = (TextView) view.findViewById(C1375R.C1376id.tos_info);
        $jacocoInit[44] = true;
        info.setText(privacyAndTermsSpan);
        $jacocoInit[45] = true;
        info.setMovementMethod(LinkMovementMethod.getInstance());
        $jacocoInit[46] = true;
    }
}
