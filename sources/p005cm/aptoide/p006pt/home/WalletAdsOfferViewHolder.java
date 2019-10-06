package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.WalletAdsOfferViewHolder */
class WalletAdsOfferViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Button dismissButton;
    private final ImageView icon;
    private final Button installWalletButton;
    private final TextView message;
    private final TextView title;
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3273984444143225451L, "cm/aptoide/pt/home/WalletAdsOfferViewHolder", 22);
        $jacocoData = probes;
        return probes;
    }

    public WalletAdsOfferViewHolder(View view, C14963c<HomeEvent> uiEventsListener2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.uiEventsListener = uiEventsListener2;
        $jacocoInit[0] = true;
        this.installWalletButton = (Button) view.findViewById(C1375R.C1376id.action_button);
        $jacocoInit[1] = true;
        this.dismissButton = (Button) view.findViewById(C1375R.C1376id.dismiss_button);
        $jacocoInit[2] = true;
        this.icon = (ImageView) view.findViewById(C1375R.C1376id.icon);
        $jacocoInit[3] = true;
        this.title = (TextView) view.findViewById(C1375R.C1376id.title);
        $jacocoInit[4] = true;
        this.message = (TextView) view.findViewById(C1375R.C1376id.message);
        $jacocoInit[5] = true;
    }

    public void setBundle(HomeBundle homeBundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        ActionBundle actionBundle = (ActionBundle) homeBundle;
        $jacocoInit[6] = true;
        ActionItem actionItem = actionBundle.getActionItem();
        $jacocoInit[7] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[8] = true;
        with.load(actionItem.getIcon(), this.icon);
        $jacocoInit[9] = true;
        this.installWalletButton.setText(C1375R.string.wallet_promotion_install_button);
        $jacocoInit[10] = true;
        this.dismissButton.setText(C1375R.string.wallet_promotion_no_button);
        $jacocoInit[11] = true;
        this.title.setText(actionItem.getTitle());
        $jacocoInit[12] = true;
        this.message.setText(actionItem.getSubTitle());
        $jacocoInit[13] = true;
        this.installWalletButton.setOnClickListener(new C3938te(this, homeBundle));
        $jacocoInit[14] = true;
        this.dismissButton.setOnClickListener(new C3932se(this, homeBundle));
        $jacocoInit[15] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14567a(HomeBundle homeBundle, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        $jacocoInit[19] = true;
        HomeEvent homeEvent = new HomeEvent(homeBundle, getAdapterPosition(), Type.INSTALL_WALLET);
        $jacocoInit[20] = true;
        cVar.onNext(homeEvent);
        $jacocoInit[21] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14568b(HomeBundle homeBundle, View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        $jacocoInit[16] = true;
        HomeEvent homeEvent = new HomeEvent(homeBundle, getAdapterPosition(), Type.DISMISS_BUNDLE);
        $jacocoInit[17] = true;
        cVar.onNext(homeEvent);
        $jacocoInit[18] = true;
    }
}
