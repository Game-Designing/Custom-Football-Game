package p005cm.aptoide.p006pt.home;

import android.graphics.Rect;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.Translator;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.TopBundleViewHolder */
public class TopBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final TextView bundleTitle;
    private final String marketName;
    private final Button moreButton;
    private final TopBundleAdapter topBundleAdapter;
    private final RecyclerView topList;
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1432150105540876014L, "cm/aptoide/pt/home/TopBundleViewHolder", 22);
        $jacocoData = probes;
        return probes;
    }

    public TopBundleViewHolder(View view, C14963c<HomeEvent> uiEventsListener2, DecimalFormat oneDecimalFormatter, String marketName2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.marketName = marketName2;
        this.uiEventsListener = uiEventsListener2;
        $jacocoInit[0] = true;
        this.bundleTitle = (TextView) view.findViewById(C1375R.C1376id.bundle_title);
        $jacocoInit[1] = true;
        this.moreButton = (Button) view.findViewById(C1375R.C1376id.bundle_more);
        $jacocoInit[2] = true;
        this.topList = (RecyclerView) view.findViewById(C1375R.C1376id.top_list);
        $jacocoInit[3] = true;
        this.topBundleAdapter = new TopBundleAdapter(new ArrayList(), oneDecimalFormatter, uiEventsListener2);
        $jacocoInit[4] = true;
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), 1, false);
        $jacocoInit[5] = true;
        this.topList.mo7527a((C0980h) new C0980h(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ TopBundleViewHolder this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-4161815470825552478L, "cm/aptoide/pt/home/TopBundleViewHolder$1", 4);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
                boolean[] $jacocoInit = $jacocoInit();
                int margin = ScreenU.getPixelsForDip(5, view.getResources());
                $jacocoInit[1] = true;
                int marginHorizontal = ScreenU.getPixelsForDip(4, view.getResources());
                $jacocoInit[2] = true;
                outRect.set(margin, marginHorizontal, margin, marginHorizontal);
                $jacocoInit[3] = true;
            }
        });
        $jacocoInit[6] = true;
        this.topList.setLayoutManager(layoutManager);
        $jacocoInit[7] = true;
        this.topList.setAdapter(this.topBundleAdapter);
        $jacocoInit[8] = true;
        this.topList.setNestedScrollingEnabled(false);
        $jacocoInit[9] = true;
    }

    public void setBundle(HomeBundle homeBundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (homeBundle instanceof AppBundle) {
            TextView textView = this.bundleTitle;
            $jacocoInit[13] = true;
            String translate = Translator.translate(homeBundle.getTitle(), this.itemView.getContext(), this.marketName);
            $jacocoInit[14] = true;
            textView.setText(translate);
            $jacocoInit[15] = true;
            this.topBundleAdapter.updateBundle(homeBundle, position);
            $jacocoInit[16] = true;
            this.topBundleAdapter.update(homeBundle.getContent());
            $jacocoInit[17] = true;
            this.moreButton.setOnClickListener(new C3914pe(this, homeBundle));
            $jacocoInit[18] = true;
            return;
        }
        $jacocoInit[10] = true;
        StringBuilder sb = new StringBuilder();
        Class cls = getClass();
        $jacocoInit[11] = true;
        sb.append(cls.getName());
        sb.append(" is getting non AppBundle instance!");
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[12] = true;
        throw illegalStateException;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14566a(HomeBundle homeBundle, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        $jacocoInit[19] = true;
        HomeEvent homeEvent = new HomeEvent(homeBundle, getAdapterPosition(), Type.MORE_TOP);
        $jacocoInit[20] = true;
        cVar.onNext(homeEvent);
        $jacocoInit[21] = true;
    }
}
