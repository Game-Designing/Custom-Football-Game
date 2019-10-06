package p005cm.aptoide.p006pt.reviews;

import android.support.p001v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats.Rating;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;

/* renamed from: cm.aptoide.pt.reviews.RatingTotalsLayout */
public class RatingTotalsLayout {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppCompatRatingBar ratingBar;
    private TextView ratingValue;
    private TextView usersVoted;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4238022130631352750L, "cm/aptoide/pt/reviews/RatingTotalsLayout", 7);
        $jacocoData = probes;
        return probes;
    }

    public RatingTotalsLayout(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.usersVoted = (TextView) view.findViewById(C1375R.C1376id.users_voted);
        $jacocoInit[1] = true;
        this.ratingValue = (TextView) view.findViewById(C1375R.C1376id.rating_value);
        $jacocoInit[2] = true;
        this.ratingBar = (AppCompatRatingBar) view.findViewById(C1375R.C1376id.rating_bar);
        $jacocoInit[3] = true;
    }

    public void setup(Rating rating) {
        boolean[] $jacocoInit = $jacocoInit();
        this.usersVoted.setText(StringU.withSuffix((long) rating.getTotal()));
        $jacocoInit[4] = true;
        this.ratingValue.setText(String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(rating.getAvg())}));
        $jacocoInit[5] = true;
        this.ratingBar.setRating(rating.getAvg());
        $jacocoInit[6] = true;
    }
}
