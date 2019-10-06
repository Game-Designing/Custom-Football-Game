package p005cm.aptoide.p006pt.home;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.AdInBundleViewHolder */
class AdInBundleViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<AdHomeEvent> adClickedEvents;
    private final ImageView iconView;
    private final TextView nameTextView;
    private final DecimalFormat oneDecimalFormatter;
    private final TextView rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3018642730410071619L, "cm/aptoide/pt/home/AdInBundleViewHolder", 20);
        $jacocoData = probes;
        return probes;
    }

    public AdInBundleViewHolder(View itemView, C14963c<AdHomeEvent> adClickedEvents2, DecimalFormat oneDecimalFormatter2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.nameTextView = (TextView) itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[1] = true;
        this.iconView = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[2] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating_label);
        this.adClickedEvents = adClickedEvents2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        $jacocoInit[3] = true;
    }

    public void setApp(AdClick adClick, HomeBundle homeBundle, int bundlePosition, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.nameTextView;
        ApplicationAd ad = adClick.getAd();
        $jacocoInit[4] = true;
        String adTitle = ad.getAdTitle();
        $jacocoInit[5] = true;
        textView.setText(adTitle);
        $jacocoInit[6] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[7] = true;
        ApplicationAd ad2 = adClick.getAd();
        $jacocoInit[8] = true;
        String iconUrl = ad2.getIconUrl();
        ImageView imageView = this.iconView;
        $jacocoInit[9] = true;
        with.loadWithRoundCorners(iconUrl, 8, imageView, (int) C1375R.drawable.placeholder_square);
        $jacocoInit[10] = true;
        ApplicationAd ad3 = adClick.getAd();
        $jacocoInit[11] = true;
        Integer stars = ad3.getStars();
        $jacocoInit[12] = true;
        float rating2 = (float) stars.intValue();
        if (rating2 == 0.0f) {
            $jacocoInit[13] = true;
            this.rating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[14] = true;
        } else {
            this.rating.setText(this.oneDecimalFormatter.format((double) rating2));
            $jacocoInit[15] = true;
        }
        ApplicationAd ad4 = adClick.getAd();
        View view = this.itemView;
        $jacocoInit[16] = true;
        ad4.registerClickableView(view);
        $jacocoInit[17] = true;
        View view2 = this.itemView;
        C3837d dVar = new C3837d(this, adClick, position, homeBundle, bundlePosition);
        view2.setOnClickListener(dVar);
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14199a(AdClick adClick, int position, HomeBundle homeBundle, int bundlePosition, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AdHomeEvent> cVar = this.adClickedEvents;
        AdHomeEvent adHomeEvent = new AdHomeEvent(adClick, position, homeBundle, bundlePosition, Type.AD);
        cVar.onNext(adHomeEvent);
        $jacocoInit[19] = true;
    }
}
