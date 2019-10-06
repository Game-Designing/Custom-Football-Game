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

/* renamed from: cm.aptoide.pt.home.EditorsBundleViewHolder */
class EditorsBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final TextView bundleTitle;
    private final EditorsAppsAdapter graphicAppsAdapter;
    private final RecyclerView graphicsList;
    private final String marketName;
    private final Button moreButton;
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3315078221262143707L, "cm/aptoide/pt/home/EditorsBundleViewHolder", 24);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ C14963c access$000(EditorsBundleViewHolder x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = x0.uiEventsListener;
        $jacocoInit[23] = true;
        return cVar;
    }

    public EditorsBundleViewHolder(View view, C14963c<HomeEvent> uiEventsListener2, DecimalFormat oneDecimalFormatter, String marketName2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.marketName = marketName2;
        this.uiEventsListener = uiEventsListener2;
        $jacocoInit[0] = true;
        this.bundleTitle = (TextView) view.findViewById(C1375R.C1376id.bundle_title);
        $jacocoInit[1] = true;
        this.moreButton = (Button) view.findViewById(C1375R.C1376id.bundle_more);
        $jacocoInit[2] = true;
        this.graphicsList = (RecyclerView) view.findViewById(C1375R.C1376id.featured_graphic_list);
        $jacocoInit[3] = true;
        this.graphicAppsAdapter = new EditorsAppsAdapter(new ArrayList(), oneDecimalFormatter, uiEventsListener2);
        $jacocoInit[4] = true;
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        $jacocoInit[5] = true;
        this.graphicsList.mo7527a((C0980h) new C0980h(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ EditorsBundleViewHolder this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4494480624476277221L, "cm/aptoide/pt/home/EditorsBundleViewHolder$1", 3);
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
                int margin = ScreenU.getPixelsForDip(2, view.getResources());
                $jacocoInit[1] = true;
                outRect.set(margin, margin, 0, margin);
                $jacocoInit[2] = true;
            }
        });
        $jacocoInit[6] = true;
        this.graphicsList.setLayoutManager(layoutManager);
        $jacocoInit[7] = true;
        this.graphicsList.setAdapter(this.graphicAppsAdapter);
        $jacocoInit[8] = true;
        this.graphicsList.setNestedScrollingEnabled(false);
        $jacocoInit[9] = true;
    }

    public void setBundle(final HomeBundle homeBundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (homeBundle instanceof AppBundle) {
            TextView textView = this.bundleTitle;
            $jacocoInit[13] = true;
            String translate = Translator.translate(homeBundle.getTitle(), this.itemView.getContext(), this.marketName);
            $jacocoInit[14] = true;
            textView.setText(translate);
            $jacocoInit[15] = true;
            this.graphicAppsAdapter.updateBundle(homeBundle, position);
            $jacocoInit[16] = true;
            this.graphicAppsAdapter.update(homeBundle.getContent());
            $jacocoInit[17] = true;
            this.graphicsList.mo7530a((C0988n) new C0988n(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ EditorsBundleViewHolder this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(4371568386980918217L, "cm/aptoide/pt/home/EditorsBundleViewHolder$2", 7);
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
                        C14963c access$000 = EditorsBundleViewHolder.access$000(this.this$0);
                        HomeBundle homeBundle = homeBundle;
                        EditorsBundleViewHolder editorsBundleViewHolder = this.this$0;
                        $jacocoInit[3] = true;
                        HomeEvent homeEvent = new HomeEvent(homeBundle, editorsBundleViewHolder.getAdapterPosition(), Type.SCROLL_RIGHT);
                        $jacocoInit[4] = true;
                        access$000.onNext(homeEvent);
                        $jacocoInit[5] = true;
                    }
                    $jacocoInit[6] = true;
                }
            });
            $jacocoInit[18] = true;
            this.moreButton.setOnClickListener(new C3939u(this, homeBundle));
            $jacocoInit[19] = true;
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
    public /* synthetic */ void mo14267a(HomeBundle homeBundle, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        $jacocoInit[20] = true;
        HomeEvent homeEvent = new HomeEvent(homeBundle, getAdapterPosition(), Type.MORE);
        $jacocoInit[21] = true;
        cVar.onNext(homeEvent);
        $jacocoInit[22] = true;
    }
}
