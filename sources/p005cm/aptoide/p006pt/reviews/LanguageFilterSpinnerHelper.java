package p005cm.aptoide.p006pt.reviews;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.reviews.LanguageFilterHelper.LanguageFilter;

/* renamed from: cm.aptoide.pt.reviews.LanguageFilterSpinnerHelper */
class LanguageFilterSpinnerHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;
    private final LanguageFilterHelper languageFilterHelper = new LanguageFilterHelper(this.resources);
    private final Resources resources;
    private final Spinner spinner;

    /* renamed from: cm.aptoide.pt.reviews.LanguageFilterSpinnerHelper$OnItemSelected */
    interface OnItemSelected {
        void onItemSelected(LanguageFilter languageFilter);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7457571119398188486L, "cm/aptoide/pt/reviews/LanguageFilterSpinnerHelper", 36);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ LanguageFilterHelper access$000(LanguageFilterSpinnerHelper x0) {
        boolean[] $jacocoInit = $jacocoInit();
        LanguageFilterHelper languageFilterHelper2 = x0.languageFilterHelper;
        $jacocoInit[34] = true;
        return languageFilterHelper2;
    }

    static /* synthetic */ Resources access$100(LanguageFilterSpinnerHelper x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources resources2 = x0.resources;
        $jacocoInit[35] = true;
        return resources2;
    }

    LanguageFilterSpinnerHelper(Spinner spinner2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.spinner = spinner2;
        $jacocoInit[0] = true;
        this.resources = spinner2.getResources();
        $jacocoInit[1] = true;
        this.context = spinner2.getContext();
        $jacocoInit[2] = true;
        $jacocoInit[3] = true;
    }

    private void setupOnItemSelectedListener(final OnItemSelected onItemSelected) {
        boolean[] $jacocoInit = $jacocoInit();
        this.spinner.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ LanguageFilterSpinnerHelper this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4822766886610789358L, "cm/aptoide/pt/reviews/LanguageFilterSpinnerHelper$1", 12);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                boolean[] $jacocoInit = $jacocoInit();
                LanguageFilter languageFilter = null;
                if (view instanceof TextView) {
                    $jacocoInit[1] = true;
                    CharSequence text = ((TextView) view).getText();
                    $jacocoInit[2] = true;
                    $jacocoInit[3] = true;
                    for (LanguageFilter filter : LanguageFilterSpinnerHelper.access$000(this.this$0).getLanguageFilterList()) {
                        $jacocoInit[4] = true;
                        if (!text.equals(LanguageFilterSpinnerHelper.access$100(this.this$0).getString(filter.getStringId()))) {
                            $jacocoInit[5] = true;
                        } else {
                            $jacocoInit[6] = true;
                            languageFilter = new LanguageFilter(filter);
                            $jacocoInit[7] = true;
                        }
                        $jacocoInit[8] = true;
                    }
                    onItemSelected.onItemSelected(languageFilter);
                    $jacocoInit[10] = true;
                    return;
                }
                $jacocoInit[9] = true;
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                $jacocoInit()[11] = true;
            }
        });
        $jacocoInit[4] = true;
    }

    private void setSelection(String string) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[5] = true;
        while (true) {
            SpinnerAdapter adapter = this.spinner.getAdapter();
            $jacocoInit[6] = true;
            if (i < adapter.getCount()) {
                $jacocoInit[7] = true;
                SpinnerAdapter adapter2 = this.spinner.getAdapter();
                $jacocoInit[8] = true;
                Object item = adapter2.getItem(i);
                $jacocoInit[9] = true;
                if (!string.equals(item)) {
                    $jacocoInit[10] = true;
                } else {
                    $jacocoInit[11] = true;
                    this.spinner.setSelection(i);
                    $jacocoInit[12] = true;
                }
                i++;
                $jacocoInit[13] = true;
            } else {
                $jacocoInit[14] = true;
                return;
            }
        }
    }

    private void setAdapter(SpinnerAdapter adapter, OnItemSelected onItemSelected) {
        boolean[] $jacocoInit = $jacocoInit();
        this.spinner.setAdapter(adapter);
        $jacocoInit[15] = true;
        setupOnItemSelectedListener(onItemSelected);
        $jacocoInit[16] = true;
        setSelection(this.resources.getString(getDefaultSelectionId()));
        $jacocoInit[17] = true;
    }

    private int getDefaultSelectionId() {
        boolean[] $jacocoInit = $jacocoInit();
        LanguageFilter currentLanguageFirst = this.languageFilterHelper.getCurrentLanguageFirst();
        $jacocoInit[18] = true;
        int stringId = currentLanguageFirst.getStringId();
        $jacocoInit[19] = true;
        return stringId;
    }

    /* access modifiers changed from: 0000 */
    public void setup(OnItemSelected onItemSelected) {
        boolean[] $jacocoInit = $jacocoInit();
        setAdapter(setupCommentsFilterLanguageSpinnerAdapter(), onItemSelected);
        $jacocoInit[20] = true;
        setupLanguageSpinnerClickListener((View) this.spinner.getParent());
        $jacocoInit[21] = true;
    }

    private SpinnerAdapter setupCommentsFilterLanguageSpinnerAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context2 = this.context;
        $jacocoInit[22] = true;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context2, C1375R.layout.simple_language_spinner_item, createSpinnerAdapterRowsList());
        $jacocoInit[23] = true;
        adapter.setDropDownViewResource(17367049);
        $jacocoInit[24] = true;
        return adapter;
    }

    private List<String> createSpinnerAdapterRowsList() {
        boolean[] $jacocoInit = $jacocoInit();
        LanguageFilterHelper languageFilterHelper2 = this.languageFilterHelper;
        $jacocoInit[25] = true;
        List<LanguageFilter> languageFilterList = languageFilterHelper2.getLanguageFilterList();
        $jacocoInit[26] = true;
        List<String> strings = new LinkedList<>();
        $jacocoInit[27] = true;
        $jacocoInit[28] = true;
        for (LanguageFilter languageFilter : languageFilterList) {
            $jacocoInit[29] = true;
            strings.add(this.resources.getString(languageFilter.getStringId()));
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
        return strings;
    }

    private void setupLanguageSpinnerClickListener(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        itemView.setOnClickListener(new C4626a(this));
        $jacocoInit[32] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15961a(View v) {
        boolean[] $jacocoInit = $jacocoInit();
        this.spinner.performClick();
        $jacocoInit[33] = true;
    }
}
