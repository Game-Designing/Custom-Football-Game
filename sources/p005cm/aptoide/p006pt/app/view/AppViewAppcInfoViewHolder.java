package p005cm.aptoide.p006pt.app.view;

import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.AppViewAppcInfoViewHolder */
public class AppViewAppcInfoViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private LinearLayout appcBillingSupported;
    private TextView appcRewardBilling;
    private TextView appcRewardValue;
    private View appcRewardView;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8457676573414121439L, "cm/aptoide/pt/app/view/AppViewAppcInfoViewHolder", 14);
        $jacocoData = probes;
        return probes;
    }

    public AppViewAppcInfoViewHolder(LinearLayout appcBillingSupported2, View appcRewardView2, TextView appcRewardValue2, TextView appcRewardBilling2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcBillingSupported = appcBillingSupported2;
        this.appcRewardView = appcRewardView2;
        this.appcRewardValue = appcRewardValue2;
        this.appcRewardBilling = appcRewardBilling2;
        $jacocoInit[0] = true;
    }

    public void showInfo(boolean hasAdvertising, boolean hasBilling, SpannableString formattedMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        if (hasAdvertising) {
            $jacocoInit[1] = true;
            this.appcRewardView.setVisibility(0);
            $jacocoInit[2] = true;
            this.appcRewardValue.setText(formattedMessage);
            $jacocoInit[3] = true;
            this.appcBillingSupported.setVisibility(8);
            if (hasBilling) {
                $jacocoInit[4] = true;
                this.appcRewardBilling.setVisibility(0);
                $jacocoInit[5] = true;
            } else {
                this.appcRewardBilling.setVisibility(8);
                $jacocoInit[6] = true;
            }
        } else if (!hasBilling) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            this.appcBillingSupported.setVisibility(0);
            $jacocoInit[9] = true;
            this.appcRewardView.setVisibility(8);
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
    }

    public void hideInfo() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcBillingSupported.setVisibility(8);
        $jacocoInit[12] = true;
        this.appcRewardView.setVisibility(8);
        $jacocoInit[13] = true;
    }
}
