package p005cm.aptoide.p006pt.reviews;

import android.widget.Spinner;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.reviews.LanguageFilterHelper.LanguageFilter;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.reviews.ReviewsLanguageFilterDisplayable */
public class ReviewsLanguageFilterDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private LanguageFilterSpinnerHelper languageFilterSpinnerHelper;
    private OnItemSelected onItemSelected;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6462226380182587799L, "cm/aptoide/pt/reviews/ReviewsLanguageFilterDisplayable", 11);
        $jacocoData = probes;
        return probes;
    }

    public ReviewsLanguageFilterDisplayable() {
        $jacocoInit()[0] = true;
    }

    public ReviewsLanguageFilterDisplayable(OnItemSelected onItemSelected2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.onItemSelected = onItemSelected2;
        $jacocoInit[1] = true;
    }

    public OnItemSelected getOnItemSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        OnItemSelected onItemSelected2 = this.onItemSelected;
        $jacocoInit[2] = true;
        return onItemSelected2;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[3] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[4] = true;
        return C1375R.layout.reviews_language_filter;
    }

    public void setup(Spinner spinner) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.languageFilterSpinnerHelper != null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            this.languageFilterSpinnerHelper = new LanguageFilterSpinnerHelper(spinner);
            $jacocoInit[7] = true;
            this.languageFilterSpinnerHelper.setup(new C4639n(this));
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15988a(LanguageFilter languageFilter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.onItemSelected.onItemSelected(languageFilter);
        $jacocoInit[10] = true;
    }
}
