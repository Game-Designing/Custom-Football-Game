package p005cm.aptoide.p006pt.home;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.BundlesAdapter */
public class BundlesAdapter extends C0970a<AppBundleViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int ADS = 4;
    private static final int APPS = 2;
    private static final int EDITORIAL = 6;
    private static final int EDITORS = 1;
    private static final int INFO = 7;
    private static final int LOADING = 5;
    private static final int SMALL_BANNER = 8;
    private static final int STORE = 3;
    private static final int TOP = 10;
    private static final int WALLET_ADS_OFFER = 9;
    private final AdsBundlesViewHolderFactory adsBundlesViewHolderFactory;
    private List<HomeBundle> bundles;
    private final CaptionBackgroundPainter captionBackgroundPainter;
    private final String marketName;
    private final DecimalFormat oneDecimalFormatter;
    private final ProgressBundle progressBundle;
    private final C14963c<HomeEvent> uiEventsListener;

    /* renamed from: cm.aptoide.pt.home.BundlesAdapter$1 */
    static /* synthetic */ class C33521 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType = new int[BundleType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8322941506625557610L, "cm/aptoide/pt/home/BundlesAdapter$1", 24);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.APPS.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    try {
                                        $jacocoInit[12] = true;
                                    } catch (NoSuchFieldError e7) {
                                        try {
                                            $jacocoInit[14] = true;
                                        } catch (NoSuchFieldError e8) {
                                            try {
                                                $jacocoInit[16] = true;
                                            } catch (NoSuchFieldError e9) {
                                                try {
                                                    $jacocoInit[18] = true;
                                                } catch (NoSuchFieldError e10) {
                                                    try {
                                                        $jacocoInit[20] = true;
                                                    } catch (NoSuchFieldError e11) {
                                                        $jacocoInit[22] = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.APPCOINS_ADS.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.EDITORS.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.STORE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.ADS.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.INFO_BUNDLE.ordinal()] = 6;
            $jacocoInit[11] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.LOADING.ordinal()] = 7;
            $jacocoInit[13] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.EDITORIAL.ordinal()] = 8;
            $jacocoInit[15] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.SMALL_BANNER.ordinal()] = 9;
            $jacocoInit[17] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.WALLET_ADS_OFFER.ordinal()] = 10;
            $jacocoInit[19] = true;
            $SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType[BundleType.TOP.ordinal()] = 11;
            $jacocoInit[21] = true;
            $jacocoInit[23] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8672038425232310874L, "cm/aptoide/pt/home/BundlesAdapter", 90);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((AppBundleViewHolder) wVar, i);
        $jacocoInit[88] = true;
    }

    public BundlesAdapter(List<HomeBundle> bundles2, ProgressBundle homeBundle, C14963c<HomeEvent> uiEventsListener2, DecimalFormat oneDecimalFormatter2, String marketName2, AdsBundlesViewHolderFactory adsBundlesViewHolderFactory2, CaptionBackgroundPainter captionBackgroundPainter2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundles = bundles2;
        this.progressBundle = homeBundle;
        this.uiEventsListener = uiEventsListener2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.marketName = marketName2;
        this.adsBundlesViewHolderFactory = adsBundlesViewHolderFactory2;
        this.captionBackgroundPainter = captionBackgroundPainter2;
        $jacocoInit[0] = true;
    }

    public AppBundleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (viewType) {
            case 1:
                LayoutInflater from = LayoutInflater.from(parent.getContext());
                $jacocoInit[1] = true;
                EditorsBundleViewHolder editorsBundleViewHolder = new EditorsBundleViewHolder(from.inflate(C1375R.layout.editors_choice_bundle_item, parent, false), this.uiEventsListener, this.oneDecimalFormatter, this.marketName);
                $jacocoInit[2] = true;
                return editorsBundleViewHolder;
            case 2:
                LayoutInflater from2 = LayoutInflater.from(parent.getContext());
                $jacocoInit[3] = true;
                AppsBundleViewHolder appsBundleViewHolder = new AppsBundleViewHolder(from2.inflate(C1375R.layout.apps_bundle_item, parent, false), this.uiEventsListener, this.oneDecimalFormatter, this.marketName);
                $jacocoInit[4] = true;
                return appsBundleViewHolder;
            case 3:
                LayoutInflater from3 = LayoutInflater.from(parent.getContext());
                $jacocoInit[5] = true;
                StoreBundleViewHolder storeBundleViewHolder = new StoreBundleViewHolder(from3.inflate(C1375R.layout.store_bundle_item, parent, false));
                $jacocoInit[6] = true;
                return storeBundleViewHolder;
            case 4:
                AppBundleViewHolder createViewHolder = this.adsBundlesViewHolderFactory.createViewHolder(parent);
                $jacocoInit[7] = true;
                return createViewHolder;
            case 5:
                LayoutInflater from4 = LayoutInflater.from(parent.getContext());
                $jacocoInit[12] = true;
                LoadingBundleViewHolder loadingBundleViewHolder = new LoadingBundleViewHolder(from4.inflate(C1375R.layout.progress_item, parent, false));
                $jacocoInit[13] = true;
                return loadingBundleViewHolder;
            case 6:
                LayoutInflater from5 = LayoutInflater.from(parent.getContext());
                $jacocoInit[10] = true;
                EditorialBundleViewHolder editorialBundleViewHolder = new EditorialBundleViewHolder(from5.inflate(C1375R.layout.editorial_action_item, parent, false), this.uiEventsListener, this.captionBackgroundPainter);
                $jacocoInit[11] = true;
                return editorialBundleViewHolder;
            case 7:
                LayoutInflater from6 = LayoutInflater.from(parent.getContext());
                $jacocoInit[8] = true;
                InfoBundleViewHolder infoBundleViewHolder = new InfoBundleViewHolder(from6.inflate(C1375R.layout.info_action_item, parent, false), this.uiEventsListener);
                $jacocoInit[9] = true;
                return infoBundleViewHolder;
            case 8:
                LayoutInflater from7 = LayoutInflater.from(parent.getContext());
                $jacocoInit[14] = true;
                SmallBannerAdBundleViewHolder smallBannerAdBundleViewHolder = new SmallBannerAdBundleViewHolder(from7.inflate(C1375R.layout.ads_small_banner, parent, false));
                $jacocoInit[15] = true;
                return smallBannerAdBundleViewHolder;
            case 9:
                LayoutInflater from8 = LayoutInflater.from(parent.getContext());
                $jacocoInit[16] = true;
                WalletAdsOfferViewHolder walletAdsOfferViewHolder = new WalletAdsOfferViewHolder(from8.inflate(C1375R.layout.info_action_item, parent, false), this.uiEventsListener);
                $jacocoInit[17] = true;
                return walletAdsOfferViewHolder;
            case 10:
                LayoutInflater from9 = LayoutInflater.from(parent.getContext());
                $jacocoInit[18] = true;
                TopBundleViewHolder topBundleViewHolder = new TopBundleViewHolder(from9.inflate(C1375R.layout.top_bundle_item, parent, false), this.uiEventsListener, this.oneDecimalFormatter, this.marketName);
                $jacocoInit[19] = true;
                return topBundleViewHolder;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid bundle view type");
                $jacocoInit[20] = true;
                throw illegalStateException;
        }
    }

    public void onBindViewHolder(AppBundleViewHolder appBundleViewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        appBundleViewHolder.setBundle((HomeBundle) this.bundles.get(position), position);
        $jacocoInit[21] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        int[] iArr = C33521.$SwitchMap$cm$aptoide$pt$home$HomeBundle$BundleType;
        HomeBundle homeBundle = (HomeBundle) this.bundles.get(position);
        $jacocoInit[22] = true;
        BundleType type = homeBundle.getType();
        $jacocoInit[23] = true;
        switch (iArr[type.ordinal()]) {
            case 1:
            case 2:
                $jacocoInit[24] = true;
                return 2;
            case 3:
                $jacocoInit[25] = true;
                return 1;
            case 4:
                $jacocoInit[26] = true;
                return 3;
            case 5:
                $jacocoInit[27] = true;
                return 4;
            case 6:
                $jacocoInit[28] = true;
                return 7;
            case 7:
                $jacocoInit[29] = true;
                return 5;
            case 8:
                $jacocoInit[30] = true;
                return 6;
            case 9:
                $jacocoInit[31] = true;
                return 8;
            case 10:
                $jacocoInit[32] = true;
                return 9;
            case 11:
                $jacocoInit[33] = true;
                return 10;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Bundle type not supported by the adapter: ");
                List<HomeBundle> list = this.bundles;
                $jacocoInit[34] = true;
                HomeBundle homeBundle2 = (HomeBundle) list.get(position);
                $jacocoInit[35] = true;
                BundleType type2 = homeBundle2.getType();
                $jacocoInit[36] = true;
                sb.append(type2.name());
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                $jacocoInit[37] = true;
                throw illegalStateException;
        }
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.bundles.size();
        $jacocoInit[38] = true;
        return size;
    }

    public void addHighlightedAd(AdClick adClick) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[39] = true;
        for (HomeBundle bundle : this.bundles) {
            $jacocoInit[40] = true;
            if (bundle.getType() != BundleType.ADS) {
                $jacocoInit[41] = true;
            } else {
                $jacocoInit[42] = true;
                List<AdClick> content = bundle.getContent();
                if (content == null) {
                    $jacocoInit[43] = true;
                    return;
                }
                int i = 0;
                $jacocoInit[44] = true;
                while (true) {
                    if (i >= content.size()) {
                        $jacocoInit[45] = true;
                        break;
                    }
                    $jacocoInit[46] = true;
                    AdClick adClick2 = (AdClick) content.get(i);
                    $jacocoInit[47] = true;
                    ApplicationAd ad = adClick2.getAd();
                    $jacocoInit[48] = true;
                    String packageName = ad.getPackageName();
                    $jacocoInit[49] = true;
                    ApplicationAd ad2 = adClick.getAd();
                    $jacocoInit[50] = true;
                    String packageName2 = ad2.getPackageName();
                    $jacocoInit[51] = true;
                    if (packageName.equals(packageName2)) {
                        $jacocoInit[52] = true;
                        content.remove(i);
                        $jacocoInit[53] = true;
                        break;
                    }
                    i++;
                    $jacocoInit[54] = true;
                }
                content.add(0, adClick);
                $jacocoInit[55] = true;
            }
            $jacocoInit[56] = true;
        }
        notifyDataSetChanged();
        $jacocoInit[57] = true;
    }

    public void update(List<HomeBundle> bundles2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundles = bundles2;
        $jacocoInit[58] = true;
        notifyDataSetChanged();
        $jacocoInit[59] = true;
    }

    public void add(List<HomeBundle> bundles2) {
        boolean[] $jacocoInit = $jacocoInit();
        int initialPosition = this.bundles.size();
        $jacocoInit[60] = true;
        this.bundles.addAll(bundles2);
        $jacocoInit[61] = true;
        notifyItemRangeInserted(initialPosition, bundles2.size());
        $jacocoInit[62] = true;
    }

    public void addLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getLoadingPosition() >= 0) {
            $jacocoInit[63] = true;
        } else {
            $jacocoInit[64] = true;
            this.bundles.add(this.progressBundle);
            $jacocoInit[65] = true;
            notifyItemInserted(this.bundles.size() - 1);
            $jacocoInit[66] = true;
        }
        $jacocoInit[67] = true;
    }

    public void removeLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        int loadingPosition = getLoadingPosition();
        if (loadingPosition < 0) {
            $jacocoInit[68] = true;
        } else {
            $jacocoInit[69] = true;
            this.bundles.remove(loadingPosition);
            $jacocoInit[70] = true;
            notifyItemRemoved(loadingPosition);
            $jacocoInit[71] = true;
        }
        $jacocoInit[72] = true;
    }

    public synchronized int getLoadingPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.bundles.size() - 1;
        $jacocoInit[73] = true;
        while (i >= 0) {
            $jacocoInit[74] = true;
            if (((HomeBundle) this.bundles.get(i)) instanceof ProgressBundle) {
                $jacocoInit[75] = true;
                return i;
            }
            i--;
            $jacocoInit[76] = true;
        }
        $jacocoInit[77] = true;
        return -1;
    }

    public void remove(int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundles.remove(bundlePosition);
        $jacocoInit[78] = true;
        notifyItemRemoved(bundlePosition);
        $jacocoInit[79] = true;
    }

    public HomeBundle getBundle(int visibleItem) {
        HomeBundle homeBundle = (HomeBundle) this.bundles.get(visibleItem);
        $jacocoInit()[80] = true;
        return homeBundle;
    }

    public synchronized void updateEditorials() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[81] = true;
        while (i < this.bundles.size()) {
            $jacocoInit[82] = true;
            if (!(this.bundles.get(i) instanceof ActionBundle)) {
                $jacocoInit[83] = true;
            } else {
                $jacocoInit[84] = true;
                notifyItemChanged(i);
                $jacocoInit[85] = true;
            }
            i++;
            $jacocoInit[86] = true;
        }
        $jacocoInit[87] = true;
    }
}
