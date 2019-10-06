package p005cm.aptoide.p006pt.app.view.donations.view;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.Translator;

/* renamed from: cm.aptoide.pt.app.view.donations.view.DonationListEntryViewHolder */
public class DonationListEntryViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String DEFAULT_NO_NAME = "Mysterious Donor";
    private DecimalFormat decimalFormat;
    private TextView donatedValue;
    private TextView nickname;
    private TextView position;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2096520843552959364L, "cm/aptoide/pt/app/view/donations/view/DonationListEntryViewHolder", 12);
        $jacocoData = probes;
        return probes;
    }

    public DonationListEntryViewHolder(View itemView, DecimalFormat decimalFormat2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        this.decimalFormat = decimalFormat2;
        $jacocoInit[0] = true;
        this.position = (TextView) itemView.findViewById(C1375R.C1376id.user_placement);
        $jacocoInit[1] = true;
        this.nickname = (TextView) itemView.findViewById(C1375R.C1376id.nickname);
        $jacocoInit[2] = true;
        this.donatedValue = (TextView) itemView.findViewById(C1375R.C1376id.donated_value);
        $jacocoInit[3] = true;
    }

    public void setUp(int position2, String nickname2, float donatedValue2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.position.setText(String.valueOf(position2));
        $jacocoInit[4] = true;
        if (nickname2 == null) {
            $jacocoInit[5] = true;
        } else if (!nickname2.equals(DEFAULT_NO_NAME)) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            this.nickname.setText(Translator.translate(nickname2, this.itemView.getContext(), ""));
            $jacocoInit[8] = true;
            this.nickname.setText(nickname2);
            $jacocoInit[10] = true;
            this.donatedValue.setText(this.decimalFormat.format((double) donatedValue2));
            $jacocoInit[11] = true;
        }
        this.nickname.setText(nickname2);
        $jacocoInit[9] = true;
        this.nickname.setText(nickname2);
        $jacocoInit[10] = true;
        this.donatedValue.setText(this.decimalFormat.format((double) donatedValue2));
        $jacocoInit[11] = true;
    }
}
