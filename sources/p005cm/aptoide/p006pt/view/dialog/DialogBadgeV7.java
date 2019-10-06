package p005cm.aptoide.p006pt.view.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Rank;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Reason;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Reason.Manual;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Reason.Scanned;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Reason.SignatureValidated;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Reason.Status;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Reason.ThirdPartyValidated;
import p005cm.aptoide.p006pt.view.fragment.BaseDialogFragment;

/* renamed from: cm.aptoide.pt.view.dialog.DialogBadgeV7 */
public class DialogBadgeV7 extends BaseDialogFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected String appName;
    protected Malware malware;
    protected String marketName;
    protected Rank rank;

    /* renamed from: cm.aptoide.pt.view.dialog.DialogBadgeV7$1 */
    static /* synthetic */ class C53171 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank = new int[Rank.values().length];

        /* renamed from: $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Reason$Status */
        static final /* synthetic */ int[] f9092xa0d786a2 = new int[Status.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6922892751202870110L, "cm/aptoide/pt/view/dialog/DialogBadgeV7$1", 15);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f9092xa0d786a2[Status.passed.ordinal()] = 1;
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
            f9092xa0d786a2[Status.failed.ordinal()] = 2;
            $jacocoInit[3] = true;
            f9092xa0d786a2[Status.blacklisted.ordinal()] = 3;
            $jacocoInit[5] = true;
            try {
                $jacocoInit[7] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.TRUSTED.ordinal()] = 1;
                $jacocoInit[8] = true;
            } catch (NoSuchFieldError e4) {
                try {
                    $jacocoInit[9] = true;
                } catch (NoSuchFieldError e5) {
                    try {
                        $jacocoInit[11] = true;
                    } catch (NoSuchFieldError e6) {
                        $jacocoInit[13] = true;
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.WARNING.ordinal()] = 2;
            $jacocoInit[10] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.UNKNOWN.ordinal()] = 3;
            $jacocoInit[12] = true;
            $jacocoInit[14] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1055458988824691604L, "cm/aptoide/pt/view/dialog/DialogBadgeV7", 109);
        $jacocoData = probes;
        return probes;
    }

    public DialogBadgeV7() {
        $jacocoInit()[0] = true;
    }

    public static DialogBadgeV7 newInstance(String marketName2, Malware malware2, String appName2, Rank rank2) {
        boolean[] $jacocoInit = $jacocoInit();
        DialogBadgeV7 dialog = new DialogBadgeV7();
        dialog.malware = malware2;
        dialog.appName = appName2;
        dialog.rank = rank2;
        dialog.marketName = marketName2;
        $jacocoInit[1] = true;
        return dialog;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        setRetainInstance(true);
        $jacocoInit[3] = true;
    }

    public void onStart() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onStart();
        $jacocoInit[4] = true;
        Window window = getDialog().getWindow();
        if (window == null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(17170445));
            $jacocoInit[7] = true;
            window.setBackgroundDrawable(colorDrawable);
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(getActivity());
        $jacocoInit[10] = true;
        View v = from.inflate(C1375R.layout.layout_dialog_badge, null);
        $jacocoInit[11] = true;
        C0775a aVar = new C0775a(getActivity());
        aVar.mo6235b(v);
        $jacocoInit[12] = true;
        C0774m builder = aVar.mo6231a();
        $jacocoInit[13] = true;
        View findViewById = v.findViewById(C1375R.C1376id.dialog_ok_button);
        C5319a aVar2 = new C5319a(this);
        $jacocoInit[14] = true;
        findViewById.setOnClickListener(aVar2);
        $jacocoInit[15] = true;
        Malware malware2 = this.malware;
        if (malware2 == null) {
            $jacocoInit[16] = true;
        } else if (malware2.getRank() == null) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            int i = C53171.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[this.malware.getRank().ordinal()];
            if (i == 1) {
                View findViewById2 = v.findViewById(C1375R.C1376id.trusted_header_layout);
                $jacocoInit[20] = true;
                findViewById2.setVisibility(0);
                $jacocoInit[21] = true;
            } else if (i == 2) {
                View findViewById3 = v.findViewById(C1375R.C1376id.warning_header_layout);
                $jacocoInit[22] = true;
                findViewById3.setVisibility(0);
                $jacocoInit[23] = true;
            } else if (i != 3) {
                $jacocoInit[19] = true;
            } else {
                View findViewById4 = v.findViewById(C1375R.C1376id.unknown_header_layout);
                $jacocoInit[24] = true;
                findViewById4.setVisibility(0);
                $jacocoInit[25] = true;
                View findViewById5 = v.findViewById(C1375R.C1376id.tr_unknown);
                $jacocoInit[26] = true;
                findViewById5.setVisibility(0);
                $jacocoInit[27] = true;
                return builder;
            }
        }
        Malware malware3 = this.malware;
        if (malware3 == null) {
            $jacocoInit[28] = true;
        } else if (malware3.getReason() == null) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            Reason reason = this.malware.getReason();
            $jacocoInit[31] = true;
            if (reason.getScanned() == null) {
                $jacocoInit[32] = true;
            } else {
                Malware malware4 = this.malware;
                $jacocoInit[33] = true;
                Reason reason2 = malware4.getReason();
                $jacocoInit[34] = true;
                Scanned scanned = reason2.getScanned();
                $jacocoInit[35] = true;
                if (scanned.getStatus() == null) {
                    $jacocoInit[36] = true;
                } else {
                    Status status = Status.passed;
                    Malware malware5 = this.malware;
                    $jacocoInit[37] = true;
                    Reason reason3 = malware5.getReason();
                    $jacocoInit[38] = true;
                    Scanned scanned2 = reason3.getScanned();
                    $jacocoInit[39] = true;
                    Status status2 = scanned2.getStatus();
                    $jacocoInit[40] = true;
                    if (status.equals(status2)) {
                        $jacocoInit[41] = true;
                    } else {
                        Status status3 = Status.warn;
                        Malware malware6 = this.malware;
                        $jacocoInit[42] = true;
                        Reason reason4 = malware6.getReason();
                        $jacocoInit[43] = true;
                        Scanned scanned3 = reason4.getScanned();
                        $jacocoInit[44] = true;
                        Status status4 = scanned3.getStatus();
                        $jacocoInit[45] = true;
                        if (!status3.equals(status4)) {
                            $jacocoInit[46] = true;
                        } else {
                            $jacocoInit[47] = true;
                        }
                    }
                    Reason reason5 = this.malware.getReason();
                    $jacocoInit[48] = true;
                    Scanned scanned4 = reason5.getScanned();
                    $jacocoInit[49] = true;
                    if (scanned4.getAvInfo() == null) {
                        $jacocoInit[50] = true;
                    } else {
                        $jacocoInit[51] = true;
                        View findViewById6 = v.findViewById(C1375R.C1376id.tr_scanned);
                        $jacocoInit[52] = true;
                        findViewById6.setVisibility(0);
                        $jacocoInit[53] = true;
                        TextView textView = (TextView) v.findViewById(C1375R.C1376id.message_virus_no);
                        $jacocoInit[54] = true;
                        String string = getString(C1375R.string.appviewbadge_message_virus_no);
                        $jacocoInit[55] = true;
                        textView.setText(string);
                        $jacocoInit[56] = true;
                    }
                }
            }
            Reason reason6 = this.malware.getReason();
            $jacocoInit[57] = true;
            if (reason6.getThirdpartyValidated() == null) {
                $jacocoInit[58] = true;
            } else {
                Malware malware7 = this.malware;
                $jacocoInit[59] = true;
                Reason reason7 = malware7.getReason();
                $jacocoInit[60] = true;
                ThirdPartyValidated thirdpartyValidated = reason7.getThirdpartyValidated();
                $jacocoInit[61] = true;
                String store = thirdpartyValidated.getStore();
                $jacocoInit[62] = true;
                if (!Malware.GOOGLE_PLAY.equalsIgnoreCase(store)) {
                    $jacocoInit[63] = true;
                } else {
                    $jacocoInit[64] = true;
                    View findViewById7 = v.findViewById(C1375R.C1376id.tr_third_party);
                    $jacocoInit[65] = true;
                    findViewById7.setVisibility(0);
                    $jacocoInit[66] = true;
                }
            }
            Reason reason8 = this.malware.getReason();
            $jacocoInit[67] = true;
            if (reason8.getSignatureValidated() == null) {
                $jacocoInit[68] = true;
            } else {
                Malware malware8 = this.malware;
                $jacocoInit[69] = true;
                Reason reason9 = malware8.getReason();
                $jacocoInit[70] = true;
                SignatureValidated signatureValidated = reason9.getSignatureValidated();
                $jacocoInit[71] = true;
                if (signatureValidated.getStatus() == null) {
                    $jacocoInit[72] = true;
                } else {
                    $jacocoInit[73] = true;
                    int[] iArr = C53171.f9092xa0d786a2;
                    Reason reason10 = this.malware.getReason();
                    $jacocoInit[74] = true;
                    SignatureValidated signatureValidated2 = reason10.getSignatureValidated();
                    $jacocoInit[75] = true;
                    Status status5 = signatureValidated2.getStatus();
                    $jacocoInit[76] = true;
                    int i2 = iArr[status5.ordinal()];
                    if (i2 == 1) {
                        View findViewById8 = v.findViewById(C1375R.C1376id.tr_signature);
                        $jacocoInit[78] = true;
                        findViewById8.setVisibility(0);
                        $jacocoInit[79] = true;
                        TextView textView2 = (TextView) v.findViewById(C1375R.C1376id.tv_reason_signature_validation);
                        $jacocoInit[80] = true;
                        String string2 = getString(C1375R.string.appviewbadge_message_signature_matches);
                        $jacocoInit[81] = true;
                        textView2.setText(string2);
                        $jacocoInit[82] = true;
                    } else if (i2 != 2) {
                        $jacocoInit[77] = true;
                    } else {
                        View findViewById9 = v.findViewById(C1375R.C1376id.tr_signature);
                        $jacocoInit[83] = true;
                        findViewById9.setVisibility(0);
                        $jacocoInit[84] = true;
                        View findViewById10 = v.findViewById(C1375R.C1376id.iv_signature);
                        $jacocoInit[85] = true;
                        findViewById10.setVisibility(4);
                        $jacocoInit[86] = true;
                        TextView textView3 = (TextView) v.findViewById(C1375R.C1376id.tv_reason_signature_validation);
                        $jacocoInit[87] = true;
                        String string3 = getString(C1375R.string.appviewbadge_message_signature_different);
                        $jacocoInit[88] = true;
                        textView3.setText(string3);
                        $jacocoInit[89] = true;
                    }
                }
            }
            Reason reason11 = this.malware.getReason();
            $jacocoInit[90] = true;
            if (reason11.getManual() == null) {
                $jacocoInit[91] = true;
            } else {
                Malware malware9 = this.malware;
                $jacocoInit[92] = true;
                Reason reason12 = malware9.getReason();
                $jacocoInit[93] = true;
                Manual manual = reason12.getManual();
                $jacocoInit[94] = true;
                if (manual.getStatus() == null) {
                    $jacocoInit[95] = true;
                } else {
                    Status status6 = Status.passed;
                    Malware malware10 = this.malware;
                    $jacocoInit[96] = true;
                    Reason reason13 = malware10.getReason();
                    $jacocoInit[97] = true;
                    Manual manual2 = reason13.getManual();
                    $jacocoInit[98] = true;
                    Status status7 = manual2.getStatus();
                    $jacocoInit[99] = true;
                    if (!status6.equals(status7)) {
                        $jacocoInit[100] = true;
                    } else {
                        $jacocoInit[101] = true;
                        View findViewById11 = v.findViewById(C1375R.C1376id.tr_manual);
                        $jacocoInit[102] = true;
                        findViewById11.setVisibility(0);
                        $jacocoInit[103] = true;
                        TextView textView4 = (TextView) v.findViewById(C1375R.C1376id.message_virus_no_manual);
                        $jacocoInit[104] = true;
                        String string4 = getString(C1375R.string.appviewbadge_message_virus_no);
                        $jacocoInit[105] = true;
                        textView4.setText(string4);
                        $jacocoInit[106] = true;
                    }
                }
            }
        }
        $jacocoInit[107] = true;
        return builder;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17168a(View v1) {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[108] = true;
    }
}
