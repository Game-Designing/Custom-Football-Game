package p005cm.aptoide.p006pt.home;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferCardManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.AppCoinsCampaignInfo;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.AppCoinsCampaignInfo.ClickUrls;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Action;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Layout;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListAppCoinsCampaigns;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemData;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Appearance;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Caption;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.home.BundlesResponseMapper */
public class BundlesResponseMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BlacklistManager blacklistManager;
    private final InstallManager installManager;
    private final WalletAdsOfferCardManager walletAdsOfferCardManager;

    /* renamed from: cm.aptoide.pt.home.BundlesResponseMapper$1 */
    static /* synthetic */ class C33531 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type = new int[Type.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8889431435367466132L, "cm/aptoide/pt/home/BundlesResponseMapper$1", 10);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_GROUP.ordinal()] = 1;
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
                            $jacocoInit[8] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPCOINS_ADS.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ADS.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_TOP_GROUP.ordinal()] = 4;
            $jacocoInit[7] = true;
            $jacocoInit[9] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5197848342492147818L, "cm/aptoide/pt/home/BundlesResponseMapper", Opcodes.PUTSTATIC);
        $jacocoData = probes;
        return probes;
    }

    public BundlesResponseMapper(InstallManager installManager2, WalletAdsOfferCardManager walletAdsOfferCardManager2, BlacklistManager blacklistManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager = installManager2;
        this.walletAdsOfferCardManager = walletAdsOfferCardManager2;
        this.blacklistManager = blacklistManager2;
        $jacocoInit[0] = true;
    }

    public List<HomeBundle> fromWidgetsToBundles(List<WSWidget> widgetBundles) {
        boolean z;
        BundleType type;
        boolean z2;
        boolean[] $jacocoInit = $jacocoInit();
        List<HomeBundle> arrayList = new ArrayList<>();
        boolean z3 = true;
        $jacocoInit[1] = true;
        List<HomeBundle> appBundles = arrayList;
        $jacocoInit[2] = true;
        for (WSWidget widget : widgetBundles) {
            try {
                $jacocoInit[3] = z3;
                try {
                    Type type2 = widget.getType();
                    Type type3 = Type.ACTION_ITEM;
                    $jacocoInit[4] = z3;
                    if (type2.equals(type3)) {
                        $jacocoInit[5] = z3;
                        type = actionItemTypeMapper(widget.getViewObject());
                        $jacocoInit[6] = z3;
                    } else {
                        type = bundleTypeMapper(widget.getType(), widget.getData());
                        $jacocoInit[7] = z3;
                    }
                    if (!type.equals(BundleType.UNKNOWN)) {
                        $jacocoInit[8] = z3;
                        Event event = getEvent(widget);
                        $jacocoInit[10] = z3;
                        Event event2 = event;
                        String tag = widget.getTag();
                        $jacocoInit[11] = z3;
                        String widgetTag = tag;
                        Object viewObject = widget.getViewObject();
                        $jacocoInit[12] = z3;
                        Object viewObject2 = viewObject;
                        String title = widget.getTitle();
                        $jacocoInit[13] = z3;
                        String title2 = title;
                        if (event2 == null) {
                            $jacocoInit[14] = z3;
                        } else {
                            Name name = event2.getName();
                            Name name2 = Name.getStoreWidgets;
                            $jacocoInit[15] = z3;
                            if (!name.equals(name2)) {
                                $jacocoInit[16] = z3;
                            } else {
                                $jacocoInit[17] = z3;
                                event2.setName(Name.getMoreBundle);
                                $jacocoInit[18] = z3;
                            }
                        }
                        if (type.equals(BundleType.APPS)) {
                            $jacocoInit[19] = z3;
                        } else {
                            BundleType bundleType = BundleType.EDITORS;
                            $jacocoInit[20] = z3;
                            if (type.equals(bundleType)) {
                                $jacocoInit[21] = z3;
                            } else {
                                BundleType bundleType2 = BundleType.TOP;
                                $jacocoInit[22] = z3;
                                if (type.equals(bundleType2)) {
                                    $jacocoInit[23] = z3;
                                } else {
                                    if (type.equals(BundleType.APPCOINS_ADS)) {
                                        ListAppCoinsCampaigns listAppCoinsCampaigns = (ListAppCoinsCampaigns) viewObject2;
                                        boolean z4 = true;
                                        $jacocoInit[27] = true;
                                        List<Application> applicationList = map(listAppCoinsCampaigns.getList(), widgetTag);
                                        $jacocoInit[28] = true;
                                        if (applicationList.isEmpty()) {
                                            $jacocoInit[29] = true;
                                            String str = title2;
                                            String str2 = widgetTag;
                                        } else {
                                            $jacocoInit[30] = true;
                                            BundleType bundleType3 = BundleType.APPCOINS_ADS;
                                            Event event3 = new Event();
                                            Name name3 = Name.getAppCoinsAds;
                                            $jacocoInit[31] = true;
                                            String widgetTag2 = widgetTag;
                                            AppBundle appBundle = new AppBundle(title2, applicationList, bundleType3, event3.setName(name3), widgetTag2);
                                            z4 = true;
                                            $jacocoInit[32] = true;
                                            appBundles.add(appBundle);
                                            $jacocoInit[33] = true;
                                        }
                                        $jacocoInit[34] = z4;
                                        z = true;
                                    } else {
                                        String title3 = title2;
                                        String widgetTag3 = widgetTag;
                                        if (type.equals(BundleType.ADS)) {
                                            GetAdsResponse getAdsResponse = (GetAdsResponse) viewObject2;
                                            $jacocoInit[35] = true;
                                            AdsTagWrapper adsTagWrapper = new AdsTagWrapper(getAdsResponse.getAds(), widgetTag3);
                                            Event event4 = new Event();
                                            Name name4 = Name.getAds;
                                            $jacocoInit[36] = true;
                                            AdBundle adBundle = new AdBundle(title3, adsTagWrapper, event4.setName(name4), widgetTag3);
                                            $jacocoInit[37] = true;
                                            appBundles.add(adBundle);
                                            $jacocoInit[38] = true;
                                            z = true;
                                        } else if (type.equals(BundleType.EDITORIAL)) {
                                            ActionItemResponse actionItemResponse = (ActionItemResponse) viewObject2;
                                            $jacocoInit[39] = true;
                                            String str3 = widgetTag3;
                                            String str4 = title3;
                                            ActionBundle actionBundle = new ActionBundle(title3, type, event2, widgetTag3, map(actionItemResponse));
                                            $jacocoInit[40] = true;
                                            appBundles.add(actionBundle);
                                            $jacocoInit[41] = true;
                                            z = true;
                                        } else {
                                            String widgetTag4 = widgetTag3;
                                            String title4 = title3;
                                            if (type.equals(BundleType.INFO_BUNDLE)) {
                                                $jacocoInit[42] = true;
                                                ActionItem actionItem = map((ActionItemResponse) viewObject2);
                                                $jacocoInit[43] = true;
                                                if (this.blacklistManager.isBlacklisted(type.toString(), actionItem.getCardId())) {
                                                    z2 = true;
                                                    $jacocoInit[44] = true;
                                                } else {
                                                    $jacocoInit[45] = true;
                                                    ActionBundle actionBundle2 = new ActionBundle(title4, type, event2, widgetTag4, actionItem);
                                                    appBundles.add(actionBundle2);
                                                    z2 = true;
                                                    $jacocoInit[46] = true;
                                                }
                                                $jacocoInit[47] = z2;
                                                z = true;
                                            } else if (!type.equals(BundleType.WALLET_ADS_OFFER)) {
                                                z = true;
                                                $jacocoInit[48] = true;
                                            } else {
                                                $jacocoInit[49] = true;
                                                ActionItem actionItem2 = map((ActionItemResponse) viewObject2);
                                                $jacocoInit[50] = true;
                                                WalletAdsOfferCardManager walletAdsOfferCardManager2 = this.walletAdsOfferCardManager;
                                                String str5 = type.toString();
                                                $jacocoInit[51] = true;
                                                String cardId = actionItem2.getCardId();
                                                $jacocoInit[52] = true;
                                                if (!walletAdsOfferCardManager2.shouldShowWalletOfferCard(str5, cardId)) {
                                                    $jacocoInit[53] = true;
                                                    z = true;
                                                } else {
                                                    $jacocoInit[54] = true;
                                                    ActionBundle actionBundle3 = new ActionBundle(title4, type, event2, widgetTag4, actionItem2);
                                                    appBundles.add(actionBundle3);
                                                    z = true;
                                                    $jacocoInit[55] = true;
                                                }
                                            }
                                        }
                                    }
                                    $jacocoInit[56] = z;
                                    $jacocoInit[63] = z;
                                    z3 = true;
                                }
                            }
                        }
                        DataList dataList = ((ListApps) viewObject2).getDataList();
                        $jacocoInit[24] = z3;
                        List list = dataList.getList();
                        $jacocoInit[25] = z3;
                        AppBundle appBundle2 = r7;
                        AppBundle appBundle3 = new AppBundle(title2, map(list, type, widgetTag), type, event2, widgetTag);
                        appBundles.add(appBundle2);
                        $jacocoInit[26] = true;
                        z = true;
                        $jacocoInit[56] = z;
                        $jacocoInit[63] = z;
                        z3 = true;
                    } else {
                        $jacocoInit[9] = true;
                        z3 = true;
                    }
                } catch (Exception e) {
                    e = e;
                    z = true;
                    $jacocoInit[57] = true;
                    Logger instance = Logger.getInstance();
                    $jacocoInit[58] = true;
                    Class cls = getClass();
                    $jacocoInit[59] = true;
                    String name5 = cls.getName();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Something went wrong with widget to bundle mapping : ");
                    $jacocoInit[60] = true;
                    sb.append(e.getMessage());
                    String sb2 = sb.toString();
                    $jacocoInit[61] = true;
                    instance.mo2136d(name5, sb2);
                    $jacocoInit[62] = true;
                    $jacocoInit[63] = z;
                    z3 = true;
                }
            } catch (Exception e2) {
                e = e2;
                z = true;
                $jacocoInit[57] = true;
                Logger instance2 = Logger.getInstance();
                $jacocoInit[58] = true;
                Class cls2 = getClass();
                $jacocoInit[59] = true;
                String name52 = cls2.getName();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Something went wrong with widget to bundle mapping : ");
                $jacocoInit[60] = true;
                sb3.append(e.getMessage());
                String sb22 = sb3.toString();
                $jacocoInit[61] = true;
                instance2.mo2136d(name52, sb22);
                $jacocoInit[62] = true;
                $jacocoInit[63] = z;
                z3 = true;
            }
        }
        $jacocoInit[64] = true;
        return appBundles;
    }

    private ActionItem map(ActionItemResponse viewObject) {
        String str;
        String str2;
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = viewObject.getDataList();
        $jacocoInit[65] = true;
        List list = dataList.getList();
        $jacocoInit[66] = true;
        ActionItemData item = (ActionItemData) list.get(0);
        $jacocoInit[67] = true;
        String id = item.getId();
        String str3 = "";
        if (item.getType() != null) {
            String type = item.getType();
            $jacocoInit[68] = true;
            str = type;
        } else {
            $jacocoInit[69] = true;
            str = str3;
        }
        $jacocoInit[70] = true;
        String title = item.getTitle();
        String caption = item.getCaption();
        String icon = item.getIcon();
        String url = item.getUrl();
        String views = item.getViews();
        $jacocoInit[71] = true;
        String date = item.getDate();
        if (item.getAppearance() != null) {
            Appearance appearance = item.getAppearance();
            $jacocoInit[72] = true;
            Caption caption2 = appearance.getCaption();
            $jacocoInit[73] = true;
            String theme = caption2.getTheme();
            $jacocoInit[74] = true;
            str2 = theme;
        } else {
            $jacocoInit[75] = true;
            str2 = str3;
        }
        ActionItem actionItem = new ActionItem(id, str, title, caption, icon, url, views, date, str2);
        $jacocoInit[76] = true;
        return actionItem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p005cm.aptoide.p006pt.home.HomeBundle.BundleType actionItemTypeMapper(java.lang.Object r9) {
        /*
            r8 = this;
            boolean[] r0 = $jacocoInit()
            boolean r1 = r9 instanceof p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemResponse
            r2 = 1
            if (r1 != 0) goto L_0x000e
            r1 = 77
            r0[r1] = r2
            goto L_0x002f
        L_0x000e:
            r1 = r9
            cm.aptoide.pt.dataprovider.ws.v7.home.ActionItemResponse r1 = (p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemResponse) r1
            r3 = 78
            r0[r3] = r2
            cm.aptoide.pt.dataprovider.model.v7.DataList r1 = r1.getDataList()
            r3 = 79
            r0[r3] = r2
            java.util.List r1 = r1.getList()
            r3 = 80
            r0[r3] = r2
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0036
            r1 = 81
            r0[r1] = r2
        L_0x002f:
            cm.aptoide.pt.home.HomeBundle$BundleType r1 = p005cm.aptoide.p006pt.home.HomeBundle.BundleType.UNKNOWN
            r3 = 82
            r0[r3] = r2
            return r1
        L_0x0036:
            r1 = r9
            cm.aptoide.pt.dataprovider.ws.v7.home.ActionItemResponse r1 = (p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemResponse) r1
            cm.aptoide.pt.dataprovider.model.v7.DataList r1 = r1.getDataList()
            r3 = 83
            r0[r3] = r2
            java.util.List r1 = r1.getList()
            r3 = 84
            r0[r3] = r2
            r3 = 0
            java.lang.Object r1 = r1.get(r3)
            cm.aptoide.pt.dataprovider.ws.v7.home.ActionItemData r1 = (p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemData) r1
            r4 = 85
            r0[r4] = r2
            java.lang.String r1 = r1.getType()
            r4 = 86
            r0[r4] = r2
            r4 = -1
            int r5 = r1.hashCode()
            r6 = -174115577(0xfffffffff59f3507, float:-4.0363805E32)
            r7 = 2
            if (r5 == r6) goto L_0x009b
            r6 = 459440235(0x1b62806b, float:1.8735776E-22)
            if (r5 == r6) goto L_0x0089
            r3 = 1913111335(0x7207c327, float:2.6890497E30)
            if (r5 == r3) goto L_0x0076
            r3 = 87
            r0[r3] = r2
            goto L_0x00a7
        L_0x0076:
            java.lang.String r3 = "CURATION_1"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0083
            r3 = 90
            r0[r3] = r2
            goto L_0x00a7
        L_0x0083:
            r3 = 91
            r0[r3] = r2
            r3 = 1
            goto L_0x00ae
        L_0x0089:
            java.lang.String r5 = "APPC_INFO"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x0096
            r3 = 88
            r0[r3] = r2
            goto L_0x00a7
        L_0x0096:
            r4 = 89
            r0[r4] = r2
            goto L_0x00ae
        L_0x009b:
            java.lang.String r3 = "WALLET_ADS_OFFER"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00a9
            r3 = 92
            r0[r3] = r2
        L_0x00a7:
            r3 = -1
            goto L_0x00ae
        L_0x00a9:
            r3 = 93
            r0[r3] = r2
            r3 = 2
        L_0x00ae:
            if (r3 == 0) goto L_0x00c9
            if (r3 == r2) goto L_0x00c2
            if (r3 == r7) goto L_0x00bb
            cm.aptoide.pt.home.HomeBundle$BundleType r3 = p005cm.aptoide.p006pt.home.HomeBundle.BundleType.UNKNOWN
            r4 = 97
            r0[r4] = r2
            return r3
        L_0x00bb:
            cm.aptoide.pt.home.HomeBundle$BundleType r3 = p005cm.aptoide.p006pt.home.HomeBundle.BundleType.WALLET_ADS_OFFER
            r4 = 96
            r0[r4] = r2
            return r3
        L_0x00c2:
            cm.aptoide.pt.home.HomeBundle$BundleType r3 = p005cm.aptoide.p006pt.home.HomeBundle.BundleType.EDITORIAL
            r4 = 95
            r0[r4] = r2
            return r3
        L_0x00c9:
            cm.aptoide.pt.home.HomeBundle$BundleType r3 = p005cm.aptoide.p006pt.home.HomeBundle.BundleType.INFO_BUNDLE
            r4 = 94
            r0[r4] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.home.BundlesResponseMapper.actionItemTypeMapper(java.lang.Object):cm.aptoide.pt.home.HomeBundle$BundleType");
    }

    private Event getEvent(WSWidget widget) {
        Event event;
        boolean[] $jacocoInit = $jacocoInit();
        if (widget.getActions() == null) {
            $jacocoInit[98] = true;
        } else {
            $jacocoInit[99] = true;
            List actions = widget.getActions();
            $jacocoInit[100] = true;
            if (actions.size() <= 0) {
                $jacocoInit[101] = true;
            } else {
                List actions2 = widget.getActions();
                $jacocoInit[102] = true;
                Action action = (Action) actions2.get(0);
                $jacocoInit[103] = true;
                event = action.getEvent();
                $jacocoInit[104] = true;
                $jacocoInit[106] = true;
                return event;
            }
        }
        event = null;
        $jacocoInit[105] = true;
        $jacocoInit[106] = true;
        return event;
    }

    private BundleType bundleTypeMapper(Type type, Data data) {
        boolean[] $jacocoInit = $jacocoInit();
        if (type == null) {
            BundleType bundleType = BundleType.UNKNOWN;
            $jacocoInit[107] = true;
            return bundleType;
        }
        int i = C33531.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[type.ordinal()];
        if (i != 1) {
            if (i == 2) {
                BundleType bundleType2 = BundleType.APPCOINS_ADS;
                $jacocoInit[112] = true;
                return bundleType2;
            } else if (i == 3) {
                BundleType bundleType3 = BundleType.ADS;
                $jacocoInit[113] = true;
                return bundleType3;
            } else if (i != 4) {
                BundleType bundleType4 = BundleType.APPS;
                $jacocoInit[115] = true;
                return bundleType4;
            } else {
                BundleType bundleType5 = BundleType.TOP;
                $jacocoInit[114] = true;
                return bundleType5;
            }
        } else if (data == null) {
            BundleType bundleType6 = BundleType.UNKNOWN;
            $jacocoInit[108] = true;
            return bundleType6;
        } else {
            Layout layout = data.getLayout();
            Layout layout2 = Layout.BRICK;
            $jacocoInit[109] = true;
            if (layout.equals(layout2)) {
                BundleType bundleType7 = BundleType.EDITORS;
                $jacocoInit[110] = true;
                return bundleType7;
            }
            BundleType bundleType8 = BundleType.APPS;
            $jacocoInit[111] = true;
            return bundleType8;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bc A[Catch:{ Exception -> 0x015e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<p005cm.aptoide.p006pt.view.app.Application> map(java.util.List<p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App> r21, p005cm.aptoide.p006pt.home.HomeBundle.BundleType r22, java.lang.String r23) {
        /*
            r20 = this;
            boolean[] r1 = $jacocoInit()
            r2 = 1
            if (r21 != 0) goto L_0x000c
            r0 = 116(0x74, float:1.63E-43)
            r1[r0] = r2
            goto L_0x0016
        L_0x000c:
            boolean r0 = r21.isEmpty()
            if (r0 == 0) goto L_0x001f
            r0 = 117(0x75, float:1.64E-43)
            r1[r0] = r2
        L_0x0016:
            java.util.List r0 = java.util.Collections.emptyList()
            r3 = 118(0x76, float:1.65E-43)
            r1[r3] = r2
            return r0
        L_0x001f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3 = 119(0x77, float:1.67E-43)
            r1[r3] = r2
            r3 = r0
            java.util.Iterator r4 = r21.iterator()
            r0 = 120(0x78, float:1.68E-43)
            r1[r0] = r2
        L_0x0031:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x01a9
            java.lang.Object r0 = r4.next()
            r5 = r0
            cm.aptoide.pt.dataprovider.model.v7.listapp.App r5 = (p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App) r5
            r0 = 121(0x79, float:1.7E-43)
            r1[r0] = r2     // Catch:{ Exception -> 0x0164 }
            cm.aptoide.pt.home.HomeBundle$BundleType r0 = p005cm.aptoide.p006pt.home.HomeBundle.BundleType.EDITORS     // Catch:{ Exception -> 0x0160 }
            r6 = r22
            boolean r0 = r6.equals(r0)     // Catch:{ Exception -> 0x015e }
            r7 = 0
            if (r0 == 0) goto L_0x00ea
            r0 = 122(0x7a, float:1.71E-43)
            r1[r0] = r2     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.dataprovider.model.v7.listapp.AppCoinsInfo r0 = r5.getAppcoins()     // Catch:{ Exception -> 0x015e }
            r8 = 123(0x7b, float:1.72E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.view.app.FeatureGraphicApplication r14 = new cm.aptoide.pt.view.app.FeatureGraphicApplication     // Catch:{ Exception -> 0x015e }
            java.lang.String r9 = r5.getName()     // Catch:{ Exception -> 0x015e }
            java.lang.String r10 = r5.getIcon()     // Catch:{ Exception -> 0x015e }
            r8 = 124(0x7c, float:1.74E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats r8 = r5.getStats()     // Catch:{ Exception -> 0x015e }
            r11 = 125(0x7d, float:1.75E-43)
            r1[r11] = r2     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats$Rating r8 = r8.getRating()     // Catch:{ Exception -> 0x015e }
            r11 = 126(0x7e, float:1.77E-43)
            r1[r11] = r2     // Catch:{ Exception -> 0x015e }
            float r11 = r8.getAvg()     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats r8 = r5.getStats()     // Catch:{ Exception -> 0x015e }
            r12 = 127(0x7f, float:1.78E-43)
            r1[r12] = r2     // Catch:{ Exception -> 0x015e }
            int r12 = r8.getPdownloads()     // Catch:{ Exception -> 0x015e }
            java.lang.String r13 = r5.getPackageName()     // Catch:{ Exception -> 0x015e }
            long r15 = r5.getId()     // Catch:{ Exception -> 0x015e }
            java.lang.String r17 = r5.getGraphic()     // Catch:{ Exception -> 0x015e }
            if (r0 != 0) goto L_0x009a
            r8 = 128(0x80, float:1.794E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            goto L_0x00a8
        L_0x009a:
            r8 = 129(0x81, float:1.81E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            boolean r8 = r0.hasBilling()     // Catch:{ Exception -> 0x015e }
            if (r8 != 0) goto L_0x00af
            r8 = 130(0x82, float:1.82E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
        L_0x00a8:
            r8 = 132(0x84, float:1.85E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            r18 = 0
            goto L_0x00b5
        L_0x00af:
            r8 = 131(0x83, float:1.84E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            r18 = 1
        L_0x00b5:
            if (r0 != 0) goto L_0x00bc
            r8 = 133(0x85, float:1.86E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            goto L_0x00c6
        L_0x00bc:
            boolean r8 = r0.hasAdvertising()     // Catch:{ Exception -> 0x015e }
            if (r8 != 0) goto L_0x00cd
            r8 = 134(0x86, float:1.88E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
        L_0x00c6:
            r8 = 136(0x88, float:1.9E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            r19 = 0
            goto L_0x00d3
        L_0x00cd:
            r7 = 135(0x87, float:1.89E-43)
            r1[r7] = r2     // Catch:{ Exception -> 0x015e }
            r19 = 1
        L_0x00d3:
            r8 = r14
            r7 = r14
            r14 = r15
            r16 = r17
            r17 = r23
            r8.<init>(r9, r10, r11, r12, r13, r14, r16, r17, r18, r19)     // Catch:{ Exception -> 0x015e }
            r8 = 137(0x89, float:1.92E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            r3.add(r7)     // Catch:{ Exception -> 0x015e }
            r0 = 138(0x8a, float:1.93E-43)
            r1[r0] = r2     // Catch:{ Exception -> 0x015e }
            goto L_0x0159
        L_0x00ea:
            cm.aptoide.pt.dataprovider.model.v7.listapp.AppCoinsInfo r0 = r5.getAppcoins()     // Catch:{ Exception -> 0x015e }
            r8 = 139(0x8b, float:1.95E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.view.app.Application r14 = new cm.aptoide.pt.view.app.Application     // Catch:{ Exception -> 0x015e }
            java.lang.String r9 = r5.getName()     // Catch:{ Exception -> 0x015e }
            java.lang.String r10 = r5.getIcon()     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats r8 = r5.getStats()     // Catch:{ Exception -> 0x015e }
            r11 = 140(0x8c, float:1.96E-43)
            r1[r11] = r2     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats$Rating r8 = r8.getRating()     // Catch:{ Exception -> 0x015e }
            r11 = 141(0x8d, float:1.98E-43)
            r1[r11] = r2     // Catch:{ Exception -> 0x015e }
            float r11 = r8.getAvg()     // Catch:{ Exception -> 0x015e }
            cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats r8 = r5.getStats()     // Catch:{ Exception -> 0x015e }
            r12 = 142(0x8e, float:1.99E-43)
            r1[r12] = r2     // Catch:{ Exception -> 0x015e }
            int r12 = r8.getPdownloads()     // Catch:{ Exception -> 0x015e }
            java.lang.String r13 = r5.getPackageName()     // Catch:{ Exception -> 0x015e }
            long r15 = r5.getId()     // Catch:{ Exception -> 0x015e }
            if (r0 != 0) goto L_0x012b
            r8 = 143(0x8f, float:2.0E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            goto L_0x0139
        L_0x012b:
            r8 = 144(0x90, float:2.02E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            boolean r8 = r0.hasBilling()     // Catch:{ Exception -> 0x015e }
            if (r8 != 0) goto L_0x0140
            r8 = 145(0x91, float:2.03E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
        L_0x0139:
            r8 = 147(0x93, float:2.06E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            r17 = 0
            goto L_0x0146
        L_0x0140:
            r7 = 146(0x92, float:2.05E-43)
            r1[r7] = r2     // Catch:{ Exception -> 0x015e }
            r17 = 1
        L_0x0146:
            r8 = r14
            r7 = r14
            r14 = r15
            r16 = r23
            r8.<init>(r9, r10, r11, r12, r13, r14, r16, r17)     // Catch:{ Exception -> 0x015e }
            r8 = 148(0x94, float:2.07E-43)
            r1[r8] = r2     // Catch:{ Exception -> 0x015e }
            r3.add(r7)     // Catch:{ Exception -> 0x015e }
            r7 = 149(0x95, float:2.09E-43)
            r1[r7] = r2     // Catch:{ Exception -> 0x015e }
        L_0x0159:
            r0 = 150(0x96, float:2.1E-43)
            r1[r0] = r2
            goto L_0x01a3
        L_0x015e:
            r0 = move-exception
            goto L_0x0167
        L_0x0160:
            r0 = move-exception
            r6 = r22
            goto L_0x0167
        L_0x0164:
            r0 = move-exception
            r6 = r22
        L_0x0167:
            r7 = 151(0x97, float:2.12E-43)
            r1[r7] = r2
            cm.aptoide.pt.logger.Logger r7 = p005cm.aptoide.p006pt.logger.Logger.getInstance()
            r8 = 152(0x98, float:2.13E-43)
            r1[r8] = r2
            java.lang.Class r8 = r20.getClass()
            r9 = 153(0x99, float:2.14E-43)
            r1[r9] = r2
            java.lang.String r8 = r8.getName()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Something went wrong while parsing apps to applications: "
            r9.append(r10)
            r10 = 154(0x9a, float:2.16E-43)
            r1[r10] = r2
            java.lang.String r10 = r0.getMessage()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r10 = 155(0x9b, float:2.17E-43)
            r1[r10] = r2
            r7.mo2136d(r8, r9)
            r7 = 156(0x9c, float:2.19E-43)
            r1[r7] = r2
        L_0x01a3:
            r0 = 157(0x9d, float:2.2E-43)
            r1[r0] = r2
            goto L_0x0031
        L_0x01a9:
            r6 = r22
            r0 = 158(0x9e, float:2.21E-43)
            r1[r0] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.home.BundlesResponseMapper.map(java.util.List, cm.aptoide.pt.home.HomeBundle$BundleType, java.lang.String):java.util.List");
    }

    private List<Application> map(List<AppCoinsCampaign> appsList, String tag) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<Application> rewardAppsList = new ArrayList<>();
        $jacocoInit[159] = true;
        $jacocoInit[160] = true;
        for (AppCoinsCampaign campaign : appsList) {
            $jacocoInit[161] = true;
            CampaignApp app = campaign.getApp();
            $jacocoInit[162] = true;
            if (this.installManager.wasAppEverInstalled(app.getPackageName())) {
                $jacocoInit[163] = true;
            } else {
                $jacocoInit[164] = true;
                String name = app.getName();
                String icon = app.getIcon();
                Stats stats = app.getStats();
                $jacocoInit[165] = true;
                Rating rating = stats.getRating();
                $jacocoInit[166] = true;
                float avg = rating.getAvg();
                Stats stats2 = app.getStats();
                $jacocoInit[167] = true;
                int pdownloads = stats2.getPdownloads();
                String packageName = app.getPackageName();
                long id = app.getId();
                if (app.getAppcoins() != null) {
                    $jacocoInit[168] = true;
                    z = true;
                } else {
                    $jacocoInit[169] = true;
                    z = false;
                }
                $jacocoInit[170] = true;
                AppCoinsCampaignInfo appcoins = app.getAppcoins();
                $jacocoInit[171] = true;
                ClickUrls clicks = appcoins.getClicks();
                $jacocoInit[172] = true;
                String click = clicks.getClick();
                AppCoinsCampaignInfo appcoins2 = app.getAppcoins();
                $jacocoInit[173] = true;
                ClickUrls clicks2 = appcoins2.getClicks();
                $jacocoInit[174] = true;
                RewardApp rewardApp = new RewardApp(name, icon, avg, pdownloads, packageName, id, tag, z, click, clicks2.getDownload(), Float.parseFloat(campaign.getReward()));
                $jacocoInit[175] = true;
                rewardAppsList.add(rewardApp);
                $jacocoInit[176] = true;
            }
            $jacocoInit[177] = true;
        }
        $jacocoInit[178] = true;
        return rewardAppsList;
    }
}
