package p005cm.aptoide.p006pt.home;

import android.graphics.Rect;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0988n;
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

/* renamed from: cm.aptoide.pt.home.AdsBundleViewHolder */
class AdsBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdsInBundleAdapter appsInBundleAdapter;
    private final RecyclerView appsList;
    private final TextView bundleTitle;
    private final String marketName;
    private final Button moreButton;
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7883403282491316177L, "cm/aptoide/pt/home/AdsBundleViewHolder", 24);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ C14963c access$000(AdsBundleViewHolder x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = x0.uiEventsListener;
        $jacocoInit[23] = true;
        return cVar;
    }

    public AdsBundleViewHolder(View view, C14963c<HomeEvent> uiEventsListener2, DecimalFormat oneDecimalFormatter, C14963c<AdHomeEvent> adClickedEvents, String marketName2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.marketName = marketName2;
        this.uiEventsListener = uiEventsListener2;
        $jacocoInit[0] = true;
        this.bundleTitle = (TextView) view.findViewById(C1375R.C1376id.bundle_title);
        $jacocoInit[1] = true;
        this.moreButton = (Button) view.findViewById(C1375R.C1376id.bundle_more);
        $jacocoInit[2] = true;
        this.appsList = (RecyclerView) view.findViewById(C1375R.C1376id.apps_list);
        $jacocoInit[3] = true;
        this.appsInBundleAdapter = new AdsInBundleAdapter(new ArrayList(), oneDecimalFormatter, adClickedEvents);
        $jacocoInit[4] = true;
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        $jacocoInit[5] = true;
        this.appsList.mo7527a((C0980h) new C0980h(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ AdsBundleViewHolder this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(5611088412978099302L, "cm/aptoide/pt/home/AdsBundleViewHolder$1", 3);
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
                outRect.set(margin, margin, 0, margin);
                $jacocoInit[2] = true;
            }
        });
        $jacocoInit[6] = true;
        this.appsList.setLayoutManager(layoutManager);
        $jacocoInit[7] = true;
        this.appsList.setAdapter(this.appsInBundleAdapter);
        $jacocoInit[8] = true;
        this.appsList.setNestedScrollingEnabled(false);
        $jacocoInit[9] = true;
    }

    public void setBundle(final HomeBundle homeBundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (homeBundle instanceof AdBundle) {
            TextView textView = this.bundleTitle;
            $jacocoInit[13] = true;
            String translate = Translator.translate(homeBundle.getTitle(), this.itemView.getContext(), this.marketName);
            $jacocoInit[14] = true;
            textView.setText(translate);
            $jacocoInit[15] = true;
            this.appsInBundleAdapter.updateBundle(homeBundle, position);
            $jacocoInit[16] = true;
            this.appsInBundleAdapter.update(homeBundle.getContent());
            $jacocoInit[17] = true;
            this.appsList.mo7530a((C0988n) new C0988n(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ AdsBundleViewHolder this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(155138959078713661L, "cm/aptoide/pt/home/AdsBundleViewHolder$2", 7);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    boolean[] $jacocoInit = $jacocoInit();
                    super.onScrolled(recyclerView, dx, dy);
                    if (dx <= 0) {
                        $jacocoInit[1] = true;
                    } else {
                        $jacocoInit[2] = true;
                        C14963c access$000 = AdsBundleViewHolder.access$000(this.this$0);
                        HomeBundle homeBundle = homeBundle;
                        AdsBundleViewHolder adsBundleViewHolder = this.this$0;
                        $jacocoInit[3] = true;
                        HomeEvent homeEvent = new HomeEvent(homeBundle, adsBundleViewHolder.getAdapterPosition(), Type.SCROLL_RIGHT);
                        $jacocoInit[4] = true;
                        access$000.onNext(homeEvent);
                        $jacocoInit[5] = true;
                    }
                    $jacocoInit[6] = true;
                }
            });
            $jacocoInit[18] = true;
            this.moreButton.setOnClickListener(new C3849f(this, homeBundle));
            $jacocoInit[19] = true;
            return;
        }
        $jacocoInit[10] = true;
        StringBuilder sb = new StringBuilder();
        Class cls = getClass();
        $jacocoInit[11] = true;
        sb.append(cls.getName());
        sb.append(" is getting non AdBundle instance!");
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[12] = true;
        throw illegalStateException;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14202a(HomeBundle homeBundle, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        $jacocoInit[20] = true;
        HomeEvent homeEvent = new HomeEvent(homeBundle, getAdapterPosition(), Type.MORE);
        $jacocoInit[21] = true;
        cVar.onNext(homeEvent);
        $jacocoInit[22] = true;
    }
}
