package p005cm.aptoide.p006pt.app.view.similar.bundles;

import android.content.Context;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.view.View;
import java.text.DecimalFormat;
import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppClickEvent;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundle;
import p005cm.aptoide.p006pt.app.view.similar.SimilarBundleViewHolder;
import p005cm.aptoide.p006pt.home.SnapToStartHelper;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.custom.HorizontalHeaderItemDecoration;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.app.view.similar.bundles.SimilarAppcAppsViewHolder */
public class SimilarAppcAppsViewHolder extends SimilarBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppViewSimilarAppsAdapter adapter;
    private final DecimalFormat oneDecimalFormat;
    private final C14963c<SimilarAppClickEvent> similarAppClick;
    private final RecyclerView similarAppcApps;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2854763997909781234L, "cm/aptoide/pt/app/view/similar/bundles/SimilarAppcAppsViewHolder", 15);
        $jacocoData = probes;
        return probes;
    }

    public SimilarAppcAppsViewHolder(View view, DecimalFormat oneDecimalFormat2, C14963c<SimilarAppClickEvent> similarAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.oneDecimalFormat = oneDecimalFormat2;
        this.similarAppClick = similarAppClick2;
        $jacocoInit[0] = true;
        this.similarAppcApps = (RecyclerView) view.findViewById(C1375R.C1376id.similar_appc_list);
        $jacocoInit[1] = true;
        this.similarAppcApps.setNestedScrollingEnabled(false);
        $jacocoInit[2] = true;
        Context context = view.getContext();
        RecyclerView recyclerView = this.similarAppcApps;
        $jacocoInit[3] = true;
        int pixelsForDip = ScreenU.getPixelsForDip(112, view.getResources());
        $jacocoInit[4] = true;
        HorizontalHeaderItemDecoration horizontalHeaderItemDecoration = new HorizontalHeaderItemDecoration(context, recyclerView, C1375R.layout.appview_appc_similar_header, pixelsForDip, ScreenU.getPixelsForDip(5, view.getResources()));
        $jacocoInit[5] = true;
        this.similarAppcApps.mo7527a((C0980h) horizontalHeaderItemDecoration);
        $jacocoInit[6] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        $jacocoInit[7] = true;
        this.similarAppcApps.setLayoutManager(linearLayoutManager);
        $jacocoInit[8] = true;
        SnapToStartHelper snapToStartHelper = new SnapToStartHelper();
        $jacocoInit[9] = true;
        snapToStartHelper.attachToRecyclerView(this.similarAppcApps);
        $jacocoInit[10] = true;
        this.similarAppcApps.setAdapter(getSimilarAdapter());
        $jacocoInit[11] = true;
    }

    private C0970a getSimilarAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[12] = true;
        this.adapter = new AppViewSimilarAppsAdapter(Collections.emptyList(), this.oneDecimalFormat, this.similarAppClick, SimilarAppType.APPC_SIMILAR_APPS);
        AppViewSimilarAppsAdapter appViewSimilarAppsAdapter = this.adapter;
        $jacocoInit[13] = true;
        return appViewSimilarAppsAdapter;
    }

    public void setBundle(SimilarAppsBundle bundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.update(mapToSimilar(bundle.getContent(), false));
        $jacocoInit[14] = true;
    }
}
