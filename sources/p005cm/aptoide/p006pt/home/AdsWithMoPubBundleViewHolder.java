package p005cm.aptoide.p006pt.home;

import android.app.Activity;
import android.graphics.Rect;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mopub.nativeads.InMobiNativeAdRenderer;
import com.mopub.nativeads.MoPubRecyclerAdapter;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.ViewBinder;
import com.mopub.nativeads.ViewBinder.Builder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.MoPubNativeAdsListener;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.Translator;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.AdsWithMoPubBundleViewHolder */
public class AdsWithMoPubBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdsInBundleAdapter appsInBundleAdapter;
    private final RecyclerView appsList;
    private final TextView bundleTitle;
    private boolean hasAdLoaded;
    private final String marketName;
    private final MoPubRecyclerAdapter moPubRecyclerAdapter;
    private final Button moreButton;
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7844261771011499592L, "cm/aptoide/pt/home/AdsWithMoPubBundleViewHolder", 39);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ C14963c access$000(AdsWithMoPubBundleViewHolder x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = x0.uiEventsListener;
        $jacocoInit[38] = true;
        return cVar;
    }

    public AdsWithMoPubBundleViewHolder(View view, C14963c<HomeEvent> uiEventsListener2, DecimalFormat oneDecimalFormatter, C14963c<AdHomeEvent> adClickedEvents, String marketName2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.uiEventsListener = uiEventsListener2;
        this.marketName = marketName2;
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
            final /* synthetic */ AdsWithMoPubBundleViewHolder this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4209013024458395509L, "cm/aptoide/pt/home/AdsWithMoPubBundleViewHolder$1", 3);
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
        this.moPubRecyclerAdapter = new MoPubRecyclerAdapter((Activity) view.getContext(), this.appsInBundleAdapter);
        $jacocoInit[9] = true;
        Builder builder = new Builder(C1375R.layout.displayable_grid_ad);
        $jacocoInit[10] = true;
        Builder titleId = builder.titleId(C1375R.C1376id.name);
        $jacocoInit[11] = true;
        Builder iconImageId = titleId.iconImageId(C1375R.C1376id.icon);
        $jacocoInit[12] = true;
        Builder mainImageId = iconImageId.mainImageId(C1375R.C1376id.native_main_image);
        $jacocoInit[13] = true;
        Builder addExtra = mainImageId.addExtra(InMobiNativeAdRenderer.VIEW_BINDER_KEY_PRIMARY_AD_VIEW_LAYOUT, C1375R.C1376id.primary_ad_view_layout);
        $jacocoInit[14] = true;
        ViewBinder moPubViewBinder = addExtra.build();
        $jacocoInit[15] = true;
        this.moPubRecyclerAdapter.registerAdRenderer(new MoPubStaticNativeAdRenderer(moPubViewBinder));
        $jacocoInit[16] = true;
        InMobiNativeAdRenderer inMobiNativeAdRenderer = new InMobiNativeAdRenderer(moPubViewBinder);
        $jacocoInit[17] = true;
        this.moPubRecyclerAdapter.registerAdRenderer(inMobiNativeAdRenderer);
        $jacocoInit[18] = true;
        this.moPubRecyclerAdapter.setAdLoadedListener(new MoPubNativeAdsListener());
        $jacocoInit[19] = true;
        this.appsList.setAdapter(this.moPubRecyclerAdapter);
        $jacocoInit[20] = true;
        this.appsList.setNestedScrollingEnabled(false);
        $jacocoInit[21] = true;
    }

    public void setBundle(final HomeBundle homeBundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (homeBundle instanceof AdBundle) {
            TextView textView = this.bundleTitle;
            $jacocoInit[25] = true;
            String translate = Translator.translate(homeBundle.getTitle(), this.itemView.getContext(), this.marketName);
            $jacocoInit[26] = true;
            textView.setText(translate);
            $jacocoInit[27] = true;
            this.appsInBundleAdapter.updateBundle(homeBundle, position);
            $jacocoInit[28] = true;
            this.appsInBundleAdapter.update(homeBundle.getContent());
            $jacocoInit[29] = true;
            this.appsList.mo7530a((C0988n) new C0988n(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ AdsWithMoPubBundleViewHolder this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(-3462372268271869331L, "cm/aptoide/pt/home/AdsWithMoPubBundleViewHolder$2", 7);
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
                        C14963c access$000 = AdsWithMoPubBundleViewHolder.access$000(this.this$0);
                        HomeBundle homeBundle = homeBundle;
                        AdsWithMoPubBundleViewHolder adsWithMoPubBundleViewHolder = this.this$0;
                        $jacocoInit[3] = true;
                        HomeEvent homeEvent = new HomeEvent(homeBundle, adsWithMoPubBundleViewHolder.getAdapterPosition(), Type.SCROLL_RIGHT);
                        $jacocoInit[4] = true;
                        access$000.onNext(homeEvent);
                        $jacocoInit[5] = true;
                    }
                    $jacocoInit[6] = true;
                }
            });
            $jacocoInit[30] = true;
            this.moreButton.setOnClickListener(new C3855g(this, homeBundle));
            if (this.hasAdLoaded) {
                $jacocoInit[31] = true;
            } else {
                this.hasAdLoaded = true;
                $jacocoInit[32] = true;
                this.moPubRecyclerAdapter.loadAds(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                $jacocoInit[33] = true;
            }
            $jacocoInit[34] = true;
            return;
        }
        $jacocoInit[22] = true;
        StringBuilder sb = new StringBuilder();
        Class cls = getClass();
        $jacocoInit[23] = true;
        sb.append(cls.getName());
        sb.append(" is getting non AdBundle instance!");
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[24] = true;
        throw illegalStateException;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14210a(HomeBundle homeBundle, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        $jacocoInit[35] = true;
        HomeEvent homeEvent = new HomeEvent(homeBundle, getAdapterPosition(), Type.MORE);
        $jacocoInit[36] = true;
        cVar.onNext(homeEvent);
        $jacocoInit[37] = true;
    }
}
