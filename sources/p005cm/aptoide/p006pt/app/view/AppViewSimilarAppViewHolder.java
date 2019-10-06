package p005cm.aptoide.p006pt.app.view;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.app.AppViewSimilarApp;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppClickEvent;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.app.Application;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.app.view.AppViewSimilarAppViewHolder */
public class AppViewSimilarAppViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final TextView adLabel;
    private C14963c<SimilarAppClickEvent> appClicked;
    private final LinearLayout appInfoLayout;
    private final LinearLayout appcInfoLayout;
    private final ImageView iconView;
    private final View itemView;
    private final TextView nameTextView;
    private DecimalFormat oneDecimalFormatter;
    private final TextView rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4764487868189909374L, "cm/aptoide/pt/app/view/AppViewSimilarAppViewHolder", 49);
        $jacocoData = probes;
        return probes;
    }

    public AppViewSimilarAppViewHolder(View itemView2, DecimalFormat oneDecimalFormatter2, C14963c<SimilarAppClickEvent> appClicked2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView2);
        this.itemView = itemView2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.appClicked = appClicked2;
        $jacocoInit[0] = true;
        this.appInfoLayout = (LinearLayout) itemView2.findViewById(C1375R.C1376id.app_info_layout);
        $jacocoInit[1] = true;
        this.appcInfoLayout = (LinearLayout) itemView2.findViewById(C1375R.C1376id.appc_info_layout);
        $jacocoInit[2] = true;
        this.nameTextView = (TextView) itemView2.findViewById(C1375R.C1376id.name);
        $jacocoInit[3] = true;
        this.iconView = (ImageView) itemView2.findViewById(C1375R.C1376id.icon);
        $jacocoInit[4] = true;
        this.rating = (TextView) itemView2.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[5] = true;
        this.adLabel = (TextView) itemView2.findViewById(C1375R.C1376id.ad_label);
        $jacocoInit[6] = true;
    }

    public void setSimilarApp(AppViewSimilarApp app, SimilarAppType type) {
        boolean[] $jacocoInit = $jacocoInit();
        if (app.isAd()) {
            $jacocoInit[7] = true;
            this.adLabel.setVisibility(0);
            $jacocoInit[8] = true;
            TextView textView = this.nameTextView;
            ApplicationAd ad = app.getAd();
            $jacocoInit[9] = true;
            String adTitle = ad.getAdTitle();
            $jacocoInit[10] = true;
            textView.setText(adTitle);
            $jacocoInit[11] = true;
            ImageLoader with = ImageLoader.with(this.itemView.getContext());
            $jacocoInit[12] = true;
            ApplicationAd ad2 = app.getAd();
            $jacocoInit[13] = true;
            String iconUrl = ad2.getIconUrl();
            ImageView imageView = this.iconView;
            $jacocoInit[14] = true;
            with.loadWithRoundCorners(iconUrl, 8, imageView, (int) C1375R.drawable.placeholder_square);
            $jacocoInit[15] = true;
            ApplicationAd ad3 = app.getAd();
            View view = this.itemView;
            $jacocoInit[16] = true;
            ad3.registerClickableView(view);
            $jacocoInit[17] = true;
            ApplicationAd ad4 = app.getAd();
            $jacocoInit[18] = true;
            Integer stars = ad4.getStars();
            $jacocoInit[19] = true;
            float rating2 = (float) stars.intValue();
            if (rating2 == 0.0f) {
                $jacocoInit[20] = true;
                this.rating.setText(C1375R.string.appcardview_title_no_stars);
                $jacocoInit[21] = true;
            } else {
                this.rating.setText(this.oneDecimalFormatter.format((double) rating2));
                $jacocoInit[22] = true;
            }
            this.itemView.setOnClickListener(new C1934Tg(this, app, type));
            $jacocoInit[23] = true;
            $jacocoInit[24] = true;
        } else if (app.getApp() == null) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            this.adLabel.setVisibility(8);
            $jacocoInit[27] = true;
            TextView textView2 = this.nameTextView;
            Application app2 = app.getApp();
            $jacocoInit[28] = true;
            String name = app2.getName();
            $jacocoInit[29] = true;
            textView2.setText(name);
            $jacocoInit[30] = true;
            ImageLoader with2 = ImageLoader.with(this.itemView.getContext());
            $jacocoInit[31] = true;
            Application app3 = app.getApp();
            $jacocoInit[32] = true;
            String icon = app3.getIcon();
            ImageView imageView2 = this.iconView;
            $jacocoInit[33] = true;
            with2.loadWithRoundCorners(icon, 8, imageView2, (int) C1375R.drawable.placeholder_square);
            $jacocoInit[34] = true;
            Application app4 = app.getApp();
            $jacocoInit[35] = true;
            if (app4.hasAppcBilling()) {
                $jacocoInit[36] = true;
                this.appcInfoLayout.setVisibility(0);
                $jacocoInit[37] = true;
                this.appInfoLayout.setVisibility(8);
                $jacocoInit[38] = true;
            } else {
                this.appcInfoLayout.setVisibility(8);
                $jacocoInit[39] = true;
                this.appInfoLayout.setVisibility(0);
                $jacocoInit[40] = true;
                Application app5 = app.getApp();
                $jacocoInit[41] = true;
                float rating3 = app5.getRating();
                if (rating3 == 0.0f) {
                    $jacocoInit[42] = true;
                    this.rating.setText(C1375R.string.appcardview_title_no_stars);
                    $jacocoInit[43] = true;
                } else {
                    this.rating.setText(this.oneDecimalFormatter.format((double) rating3));
                    $jacocoInit[44] = true;
                }
            }
            this.itemView.setOnClickListener(new C1943Ug(this, app, type));
            $jacocoInit[45] = true;
        }
        $jacocoInit[46] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10751a(AppViewSimilarApp app, SimilarAppType type, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appClicked.onNext(new SimilarAppClickEvent(app, type, getLayoutPosition()));
        $jacocoInit[48] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10752b(AppViewSimilarApp app, SimilarAppType type, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appClicked.onNext(new SimilarAppClickEvent(app, type, getLayoutPosition()));
        $jacocoInit[47] = true;
    }
}
