package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.home.AppSecondaryInfoViewHolder */
public class AppSecondaryInfoViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final LinearLayout appcLayout;
    private final TextView appcText;
    private final DecimalFormat oneDecimalFormatter;
    private final TextView rating;
    private final LinearLayout ratingLayout;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3102410602080853554L, "cm/aptoide/pt/home/AppSecondaryInfoViewHolder", 33);
        $jacocoData = probes;
        return probes;
    }

    public AppSecondaryInfoViewHolder(View itemView, DecimalFormat oneDecimalFormatter2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.oneDecimalFormatter = oneDecimalFormatter2;
        $jacocoInit[0] = true;
        this.appcLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.appc_info_layout);
        $jacocoInit[1] = true;
        this.appcText = (TextView) itemView.findViewById(C1375R.C1376id.appc_text);
        $jacocoInit[2] = true;
        this.ratingLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.rating_info_layout);
        $jacocoInit[3] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[4] = true;
    }

    public void setInfo(boolean hasAppcBilling, float appRating, boolean showRating, boolean showBoth) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.appcText;
        if (textView == null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            textView.setText(C1375R.string.appc_card_short);
            $jacocoInit[7] = true;
        }
        setRating(appRating);
        if (showBoth) {
            if (hasAppcBilling) {
                $jacocoInit[8] = true;
                setAppcVisibility(0);
                $jacocoInit[9] = true;
            } else {
                setAppcVisibility(4);
                $jacocoInit[10] = true;
            }
            setRatingVisibility(0);
            $jacocoInit[11] = true;
        } else if (hasAppcBilling) {
            $jacocoInit[12] = true;
            setAppcVisibility(0);
            $jacocoInit[13] = true;
            setRatingVisibility(4);
            $jacocoInit[14] = true;
        } else if (showRating) {
            $jacocoInit[15] = true;
            setAppcVisibility(4);
            $jacocoInit[16] = true;
            setRatingVisibility(0);
            $jacocoInit[17] = true;
        } else {
            setAppcVisibility(4);
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }

    private void setAppcVisibility(int visibility) {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayout linearLayout = this.appcLayout;
        if (linearLayout == null) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            linearLayout.setVisibility(visibility);
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }

    private void setRatingVisibility(int visibility) {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayout linearLayout = this.ratingLayout;
        if (linearLayout == null) {
            $jacocoInit[24] = true;
        } else {
            $jacocoInit[25] = true;
            linearLayout.setVisibility(visibility);
            $jacocoInit[26] = true;
        }
        $jacocoInit[27] = true;
    }

    private void setRating(float rating2) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.rating;
        if (textView == null) {
            $jacocoInit[28] = true;
        } else if (rating2 == 0.0f) {
            $jacocoInit[29] = true;
            textView.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[30] = true;
        } else {
            textView.setText(this.oneDecimalFormatter.format((double) rating2));
            $jacocoInit[31] = true;
        }
        $jacocoInit[32] = true;
    }
}
