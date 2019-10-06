package p005cm.aptoide.p006pt.app.view.similar.bundles;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.View;
import com.mopub.nativeads.InMobiNativeAdRenderer;
import com.mopub.nativeads.MoPubRecyclerAdapter;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.ViewBinder;
import com.mopub.nativeads.ViewBinder.Builder;
import java.text.DecimalFormat;
import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.MoPubNativeAdsListener;
import p005cm.aptoide.p006pt.app.SimilarAppsViewModel;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppClickEvent;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundle;
import p005cm.aptoide.p006pt.app.view.similar.SimilarBundleViewHolder;
import p005cm.aptoide.p006pt.home.SnapToStartHelper;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.app.view.similar.bundles.SimilarAppsViewHolder */
public class SimilarAppsViewHolder extends SimilarBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppViewSimilarAppsAdapter adapter;
    private MoPubRecyclerAdapter moPubSimilarAppsRecyclerAdapter;
    private final DecimalFormat oneDecimalFormat;
    private final C14963c<SimilarAppClickEvent> similarAppClick;
    private final RecyclerView similarApps;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-456420088026866919L, "cm/aptoide/pt/app/view/similar/bundles/SimilarAppsViewHolder", 34);
        $jacocoData = probes;
        return probes;
    }

    public SimilarAppsViewHolder(View view, DecimalFormat oneDecimalFormat2, C14963c<SimilarAppClickEvent> similarAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.oneDecimalFormat = oneDecimalFormat2;
        this.similarAppClick = similarAppClick2;
        $jacocoInit[0] = true;
        this.similarApps = (RecyclerView) view.findViewById(C1375R.C1376id.similar_list);
        $jacocoInit[1] = true;
        this.similarApps.setNestedScrollingEnabled(false);
        $jacocoInit[2] = true;
        this.similarApps.mo7527a((C0980h) new C0980h(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SimilarAppsViewHolder this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-4137640288901392403L, "cm/aptoide/pt/app/view/similar/bundles/SimilarAppsViewHolder$1", 3);
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
        $jacocoInit[3] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        $jacocoInit[4] = true;
        this.similarApps.setLayoutManager(linearLayoutManager);
        $jacocoInit[5] = true;
        SnapToStartHelper snapToStartHelper = new SnapToStartHelper();
        $jacocoInit[6] = true;
        snapToStartHelper.attachToRecyclerView(this.similarApps);
        $jacocoInit[7] = true;
    }

    private void setSimilarAdapter(boolean mopubAdapter) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[8] = true;
        this.adapter = new AppViewSimilarAppsAdapter(Collections.emptyList(), this.oneDecimalFormat, this.similarAppClick, SimilarAppType.SIMILAR_APPS);
        if (mopubAdapter) {
            RecyclerView recyclerView = this.similarApps;
            $jacocoInit[9] = true;
            this.moPubSimilarAppsRecyclerAdapter = new MoPubRecyclerAdapter((Activity) recyclerView.getContext(), this.adapter);
            $jacocoInit[10] = true;
            configureAdRenderers();
            $jacocoInit[11] = true;
            this.moPubSimilarAppsRecyclerAdapter.setAdLoadedListener(new MoPubNativeAdsListener());
            if (VERSION.SDK_INT >= 21) {
                $jacocoInit[12] = true;
                this.similarApps.setAdapter(this.moPubSimilarAppsRecyclerAdapter);
                $jacocoInit[13] = true;
                this.moPubSimilarAppsRecyclerAdapter.loadAds(BuildConfig.MOPUB_NATIVE_APPVIEW_PLACEMENT_ID);
                $jacocoInit[14] = true;
            } else {
                this.similarApps.setAdapter(this.adapter);
                $jacocoInit[15] = true;
            }
        } else {
            this.similarApps.setAdapter(this.adapter);
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
    }

    private ViewBinder getMoPubAdViewBinder() {
        boolean[] $jacocoInit = $jacocoInit();
        Builder titleId = new Builder(C1375R.layout.displayable_grid_ad).titleId(C1375R.C1376id.name);
        $jacocoInit[18] = true;
        Builder iconImageId = titleId.iconImageId(C1375R.C1376id.icon);
        $jacocoInit[19] = true;
        Builder mainImageId = iconImageId.mainImageId(C1375R.C1376id.native_main_image);
        $jacocoInit[20] = true;
        Builder addExtra = mainImageId.addExtra(InMobiNativeAdRenderer.VIEW_BINDER_KEY_PRIMARY_AD_VIEW_LAYOUT, C1375R.C1376id.primary_ad_view_layout);
        $jacocoInit[21] = true;
        ViewBinder build = addExtra.build();
        $jacocoInit[22] = true;
        return build;
    }

    private void configureAdRenderers() {
        boolean[] $jacocoInit = $jacocoInit();
        ViewBinder viewBinder = getMoPubAdViewBinder();
        $jacocoInit[23] = true;
        this.moPubSimilarAppsRecyclerAdapter.registerAdRenderer(new MoPubStaticNativeAdRenderer(viewBinder));
        $jacocoInit[24] = true;
        this.moPubSimilarAppsRecyclerAdapter.registerAdRenderer(new InMobiNativeAdRenderer(viewBinder));
        $jacocoInit[25] = true;
    }

    public void setBundle(SimilarAppsBundle bundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.adapter != null) {
            $jacocoInit[26] = true;
        } else {
            $jacocoInit[27] = true;
            SimilarAppsViewModel content = bundle.getContent();
            $jacocoInit[28] = true;
            boolean shouldLoadNativeAds = content.shouldLoadNativeAds();
            $jacocoInit[29] = true;
            setSimilarAdapter(shouldLoadNativeAds);
            $jacocoInit[30] = true;
        }
        AppViewSimilarAppsAdapter appViewSimilarAppsAdapter = this.adapter;
        SimilarAppsViewModel content2 = bundle.getContent();
        SimilarAppsViewModel content3 = bundle.getContent();
        $jacocoInit[31] = true;
        boolean hasAd = content3.hasAd();
        $jacocoInit[32] = true;
        appViewSimilarAppsAdapter.update(mapToSimilar(content2, hasAd));
        $jacocoInit[33] = true;
    }
}
