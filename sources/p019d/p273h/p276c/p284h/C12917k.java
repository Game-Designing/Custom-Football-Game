package p019d.p273h.p276c.p284h;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource.AD_UNIT;
import com.mopub.common.AdType;
import com.mopub.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p019d.p273h.p276c.C12741D.C12742a;
import p019d.p273h.p276c.p278b.C12784h;
import p019d.p273h.p276c.p278b.C12787k;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12810b;
import p019d.p273h.p276c.p281e.C12811c;
import p019d.p273h.p276c.p281e.C12812d;
import p019d.p273h.p276c.p281e.C12813e;
import p019d.p273h.p276c.p281e.C12814f;
import p019d.p273h.p276c.p281e.C12815g;
import p019d.p273h.p276c.p281e.C12816h;
import p019d.p273h.p276c.p281e.C12817i;
import p019d.p273h.p276c.p281e.C12818j;
import p019d.p273h.p276c.p281e.C12819k;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p281e.C12822n;
import p019d.p273h.p276c.p281e.C12822n.C12823a;
import p019d.p273h.p276c.p281e.C12824o;
import p019d.p273h.p276c.p281e.C12825p;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p281e.C12827r;
import p019d.p273h.p276c.p281e.C12828s;
import p019d.p273h.p276c.p281e.C12829t;

/* renamed from: d.h.c.h.k */
/* compiled from: ServerResponseWrapper */
public class C12917k {

    /* renamed from: A */
    private final String f39676A = "loadRVInterval";

    /* renamed from: B */
    private final String f39677B = "server";

    /* renamed from: C */
    private final String f39678C = "publisher";

    /* renamed from: D */
    private final String f39679D = "console";

    /* renamed from: E */
    private final String f39680E = "sendUltraEvents";

    /* renamed from: F */
    private final String f39681F = "sendEventsToggle";

    /* renamed from: G */
    private final String f39682G = "serverEventsURL";

    /* renamed from: H */
    private final String f39683H = "serverEventsType";

    /* renamed from: I */
    private final String f39684I = "backupThreshold";

    /* renamed from: J */
    private final String f39685J = "maxNumberOfEvents";

    /* renamed from: K */
    private final String f39686K = "maxEventsPerBatch";

    /* renamed from: L */
    private final String f39687L = "optOut";

    /* renamed from: M */
    private final String f39688M = "allowLocation";

    /* renamed from: N */
    private final String f39689N = "placements";

    /* renamed from: O */
    private final String f39690O = "placementId";

    /* renamed from: P */
    private final String f39691P = "placementName";

    /* renamed from: Q */
    private final String f39692Q = "delivery";

    /* renamed from: R */
    private final String f39693R = "isDefault";

    /* renamed from: S */
    private final String f39694S = "capping";

    /* renamed from: T */
    private final String f39695T = "pacing";

    /* renamed from: U */
    private final String f39696U = "enabled";

    /* renamed from: V */
    private final String f39697V = "maxImpressions";

    /* renamed from: W */
    private final String f39698W = "numOfSeconds";

    /* renamed from: X */
    private final String f39699X = "unit";

    /* renamed from: Y */
    private final String f39700Y = "virtualItemName";

    /* renamed from: Z */
    private final String f39701Z = "virtualItemCount";

    /* renamed from: a */
    private final String f39702a = "error";

    /* renamed from: aa */
    private final String f39703aa = "backFill";

    /* renamed from: b */
    private final int f39704b = 3;

    /* renamed from: ba */
    private final String f39705ba = "premium";

    /* renamed from: c */
    private final int f39706c = 2;

    /* renamed from: ca */
    private final String f39707ca = "uuidEnabled";

    /* renamed from: d */
    private final int f39708d = 60;

    /* renamed from: da */
    private final String f39709da = "abt";

    /* renamed from: e */
    private final int f39710e = 10000;

    /* renamed from: ea */
    private final String f39711ea = "adSourceName";

    /* renamed from: f */
    private final int f39712f = 5000;

    /* renamed from: fa */
    private final String f39713fa = "spId";

    /* renamed from: g */
    private final int f39714g = 300;

    /* renamed from: ga */
    private final String f39715ga = "mpis";

    /* renamed from: h */
    private final String f39716h = "providerOrder";

    /* renamed from: ha */
    private final String f39717ha = "auction";

    /* renamed from: i */
    private final String f39718i = "providerSettings";

    /* renamed from: ia */
    private final String f39719ia = "auctionData";

    /* renamed from: j */
    private final String f39720j = "configurations";

    /* renamed from: ja */
    private final String f39721ja = "auctioneerURL";

    /* renamed from: k */
    private final String f39722k = "genericParams";

    /* renamed from: ka */
    private final String f39723ka = "programmatic";

    /* renamed from: l */
    private final String f39724l = "adUnits";

    /* renamed from: la */
    private final String f39725la = "minTimeBeforeFirstAuction";

    /* renamed from: m */
    private final String f39726m = "providerLoadName";

    /* renamed from: ma */
    private final String f39727ma = "timeToWaitBeforeAuction";

    /* renamed from: n */
    private final String f39728n = "application";

    /* renamed from: na */
    private final String f39729na = "auctionRetryInterval";

    /* renamed from: o */
    private final String f39730o = "rewardedVideo";

    /* renamed from: oa */
    private final String f39731oa = "isAuctionOnShowStart";

    /* renamed from: p */
    private final String f39732p = AdType.INTERSTITIAL;

    /* renamed from: pa */
    private C12825p f39733pa;

    /* renamed from: q */
    private final String f39734q = "offerwall";

    /* renamed from: qa */
    private C12827r f39735qa;

    /* renamed from: r */
    private final String f39736r = "banner";

    /* renamed from: ra */
    private C12815g f39737ra;

    /* renamed from: s */
    private final String f39738s = "integration";

    /* renamed from: sa */
    private String f39739sa;

    /* renamed from: t */
    private final String f39740t = "loggers";

    /* renamed from: ta */
    private String f39741ta;

    /* renamed from: u */
    private final String f39742u = "segment";

    /* renamed from: ua */
    private JSONObject f39743ua;

    /* renamed from: v */
    private final String f39744v = Constants.VIDEO_TRACKING_EVENTS_KEY;

    /* renamed from: va */
    private Context f39745va;

    /* renamed from: w */
    private final String f39746w = "maxNumOfAdaptersToLoadOnStart";

    /* renamed from: x */
    private final String f39747x = "adapterTimeOutInSeconds";

    /* renamed from: y */
    private final String f39748y = "atim";

    /* renamed from: z */
    private final String f39749z = "bannerInterval";

    public C12917k(Context context, String appKey, String userId, String jsonData) {
        this.f39745va = context;
        try {
            if (TextUtils.isEmpty(jsonData)) {
                this.f39743ua = new JSONObject();
            } else {
                this.f39743ua = new JSONObject(jsonData);
            }
            m42003l();
            m42001j();
            m42002k();
            String str = "";
            this.f39739sa = TextUtils.isEmpty(appKey) ? str : appKey;
            if (!TextUtils.isEmpty(userId)) {
                str = userId;
            }
            this.f39741ta = str;
        } catch (JSONException e) {
            e.printStackTrace();
            m41999h();
        }
    }

    public C12917k(C12917k srw) {
        try {
            this.f39745va = srw.m42000i();
            this.f39743ua = new JSONObject(srw.f39743ua.toString());
            this.f39739sa = srw.f39739sa;
            this.f39741ta = srw.f39741ta;
            this.f39733pa = srw.mo41694c();
            this.f39735qa = srw.mo41695d();
            this.f39737ra = srw.mo41692a();
        } catch (Exception e) {
            m41999h();
        }
    }

    /* renamed from: h */
    private void m41999h() {
        this.f39743ua = new JSONObject();
        String str = "";
        this.f39739sa = str;
        this.f39741ta = str;
        this.f39733pa = new C12825p();
        this.f39735qa = C12827r.m41739b();
        this.f39737ra = new C12815g();
    }

    public String toString() {
        JSONObject resultObject = new JSONObject();
        try {
            resultObject.put("appKey", this.f39739sa);
            resultObject.put(AndroidAccountManagerPersistence.ACCOUNT_ID, this.f39741ta);
            resultObject.put("response", this.f39743ua);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultObject.toString();
    }

    /* renamed from: g */
    public boolean mo41698g() {
        boolean z = true;
        if (!((((this.f39743ua != null) && !this.f39743ua.has("error")) && this.f39733pa != null) && this.f39735qa != null) || this.f39737ra == null) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public List<C12742a> mo41693b() {
        if (this.f39743ua == null || this.f39737ra == null) {
            return null;
        }
        List<AD_UNIT> adUnits = new ArrayList<>();
        if (this.f39737ra.mo41482e() != null) {
            C12825p pVar = this.f39733pa;
            if (pVar != null && pVar.mo41528e().size() > 0) {
                adUnits.add(C12742a.REWARDED_VIDEO);
            }
        }
        if (this.f39737ra.mo41480c() != null) {
            C12825p pVar2 = this.f39733pa;
            if (pVar2 != null && pVar2.mo41522b().size() > 0) {
                adUnits.add(C12742a.INTERSTITIAL);
            }
        }
        if (this.f39737ra.mo41481d() != null) {
            adUnits.add(C12742a.OFFERWALL);
        }
        if (this.f39737ra.mo41479b() != null) {
            adUnits.add(C12742a.BANNER);
        }
        return adUnits;
    }

    /* renamed from: k */
    private void m42002k() {
        try {
            JSONObject providerOrderSection = m41994a(this.f39743ua, "providerOrder");
            JSONArray rvOrderSection = providerOrderSection.optJSONArray("rewardedVideo");
            JSONArray isOrderSection = providerOrderSection.optJSONArray(AdType.INTERSTITIAL);
            JSONArray bnOrderSection = providerOrderSection.optJSONArray("banner");
            this.f39733pa = new C12825p();
            if (!(rvOrderSection == null || mo41692a() == null || mo41692a().mo41482e() == null)) {
                String backFillProviderName = mo41692a().mo41482e().mo41562a();
                String premiumProviderName = mo41692a().mo41482e().mo41568d();
                for (int i = 0; i < rvOrderSection.length(); i++) {
                    String providerName = rvOrderSection.optString(i);
                    if (providerName.equals(backFillProviderName)) {
                        this.f39733pa.mo41530f(backFillProviderName);
                    } else {
                        if (providerName.equals(premiumProviderName)) {
                            this.f39733pa.mo41531g(premiumProviderName);
                        }
                        this.f39733pa.mo41525c(providerName);
                        C12826q settings = C12827r.m41739b().mo41560b(providerName);
                        if (settings != null) {
                            settings.mo41544c(i);
                        }
                    }
                }
            }
            if (!(isOrderSection == null || mo41692a() == null || mo41692a().mo41480c() == null)) {
                String backFillProviderName2 = mo41692a().mo41480c().mo41484a();
                String premiumProviderName2 = mo41692a().mo41480c().mo41493g();
                for (int i2 = 0; i2 < isOrderSection.length(); i2++) {
                    String providerName2 = isOrderSection.optString(i2);
                    if (providerName2.equals(backFillProviderName2)) {
                        this.f39733pa.mo41527d(backFillProviderName2);
                    } else {
                        if (providerName2.equals(premiumProviderName2)) {
                            this.f39733pa.mo41529e(premiumProviderName2);
                        }
                        this.f39733pa.mo41523b(providerName2);
                        C12826q settings2 = C12827r.m41739b().mo41560b(providerName2);
                        if (settings2 != null) {
                            settings2.mo41539b(i2);
                        }
                    }
                }
            }
            if (bnOrderSection != null) {
                for (int i3 = 0; i3 < bnOrderSection.length(); i3++) {
                    String providerName3 = bnOrderSection.optString(i3);
                    this.f39733pa.mo41521a(providerName3);
                    C12826q settings3 = C12827r.m41739b().mo41560b(providerName3);
                    if (settings3 != null) {
                        settings3.mo41533a(i3);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private void m42003l() {
        String str;
        Iterator it;
        JSONObject providerSettingsSection;
        String str2 = "Mediation";
        try {
            this.f39735qa = C12827r.m41739b();
            JSONObject providerSettingsSection2 = m41994a(this.f39743ua, "providerSettings");
            Iterator keys = providerSettingsSection2.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                JSONObject concreteProviderSettingsSection = providerSettingsSection2.optJSONObject(key);
                if (concreteProviderSettingsSection != null) {
                    boolean isMultipleInstances = concreteProviderSettingsSection.optBoolean("mpis", false);
                    String subProviderId = concreteProviderSettingsSection.optString("spId", BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                    String adSourceName = concreteProviderSettingsSection.optString("adSourceName", null);
                    String nameForReflection = concreteProviderSettingsSection.optString("providerLoadName", key);
                    JSONObject adUnitSection = m41994a(concreteProviderSettingsSection, "adUnits");
                    JSONObject appSection = m41994a(concreteProviderSettingsSection, "application");
                    JSONObject rvSection = m41994a(adUnitSection, "rewardedVideo");
                    JSONObject isSection = m41994a(adUnitSection, AdType.INTERSTITIAL);
                    JSONObject bnSection = m41994a(adUnitSection, "banner");
                    JSONObject rewardedVideoSettings = C12916j.m41964a(rvSection, appSection);
                    JSONObject interstitialSettings = C12916j.m41964a(isSection, appSection);
                    JSONObject bannerSettings = C12916j.m41964a(bnSection, appSection);
                    providerSettingsSection = providerSettingsSection2;
                    if (this.f39735qa.mo41559a(key)) {
                        C12826q providerLocalSettings = this.f39735qa.mo41560b(key);
                        JSONObject providerLocalRVSettings = providerLocalSettings.mo41554k();
                        JSONObject providerLocalISSettings = providerLocalSettings.mo41549f();
                        JSONObject providerLocalBNSettings = providerLocalSettings.mo41547d();
                        it = keys;
                        JSONObject providerLocalRVSettings2 = providerLocalRVSettings;
                        JSONObject providerLocalRVSettings3 = rvSection;
                        providerLocalSettings.mo41546c(C12916j.m41964a(providerLocalRVSettings2, rewardedVideoSettings));
                        JSONObject interstitialSettings2 = interstitialSettings;
                        JSONObject interstitialSettings3 = providerLocalRVSettings2;
                        JSONObject providerLocalISSettings2 = providerLocalISSettings;
                        JSONObject providerLocalISSettings3 = appSection;
                        providerLocalSettings.mo41542b(C12916j.m41964a(providerLocalISSettings2, interstitialSettings2));
                        JSONObject bannerSettings2 = bannerSettings;
                        JSONObject bannerSettings3 = providerLocalISSettings2;
                        JSONObject providerLocalBNSettings2 = providerLocalBNSettings;
                        JSONObject providerLocalBNSettings3 = adUnitSection;
                        providerLocalSettings.mo41536a(C12916j.m41964a(providerLocalBNSettings2, bannerSettings2));
                        providerLocalSettings.mo41537a(isMultipleInstances);
                        providerLocalSettings.mo41540b(subProviderId);
                        providerLocalSettings.mo41534a(adSourceName);
                        str = str2;
                    } else {
                        it = keys;
                        JSONObject jSONObject = rvSection;
                        JSONObject appSection2 = appSection;
                        JSONObject jSONObject2 = adUnitSection;
                        JSONObject interstitialSettings4 = interstitialSettings;
                        JSONObject bannerSettings4 = bannerSettings;
                        if (this.f39735qa.mo41559a(str2)) {
                            if (!"SupersonicAds".toLowerCase().equals(nameForReflection.toLowerCase())) {
                                if (!"RIS".toLowerCase().equals(nameForReflection.toLowerCase())) {
                                    str = str2;
                                    JSONObject jSONObject3 = bnSection;
                                    JSONObject jSONObject4 = isSection;
                                }
                            }
                            C12826q mediationLocalSettings = this.f39735qa.mo41560b(str2);
                            JSONObject mediationLocalRVSettings = mediationLocalSettings.mo41554k();
                            JSONObject mediationLocalISSettings = mediationLocalSettings.mo41549f();
                            JSONObject mediationLocalBNSettings = mediationLocalSettings.mo41547d();
                            str = str2;
                            JSONObject mergedRVSettings = new JSONObject(mediationLocalRVSettings.toString());
                            C12826q qVar = mediationLocalSettings;
                            JSONObject mergedISSettings = new JSONObject(mediationLocalISSettings.toString());
                            JSONObject jSONObject5 = mediationLocalRVSettings;
                            JSONObject mergedBNSettings = new JSONObject(mediationLocalBNSettings.toString());
                            JSONObject jSONObject6 = bnSection;
                            JSONObject jSONObject7 = isSection;
                            C12826q qVar2 = new C12826q(key, nameForReflection, appSection2, C12916j.m41964a(mergedRVSettings, rewardedVideoSettings), C12916j.m41964a(mergedISSettings, interstitialSettings4), C12916j.m41964a(mergedBNSettings, bannerSettings4));
                            C12826q settings = qVar2;
                            settings.mo41537a(isMultipleInstances);
                            settings.mo41540b(subProviderId);
                            settings.mo41534a(adSourceName);
                            this.f39735qa.mo41558a(settings);
                        } else {
                            str = str2;
                            JSONObject jSONObject8 = bnSection;
                            JSONObject jSONObject9 = isSection;
                        }
                        JSONObject rewardedVideoSettings2 = rewardedVideoSettings;
                        String adSourceName2 = adSourceName;
                        JSONObject jSONObject10 = rewardedVideoSettings2;
                        JSONObject jSONObject11 = rewardedVideoSettings2;
                        String subProviderId2 = subProviderId;
                        String str3 = key;
                        boolean isMultipleInstances2 = isMultipleInstances;
                        C12826q qVar3 = new C12826q(key, nameForReflection, appSection2, jSONObject10, interstitialSettings4, bannerSettings4);
                        qVar3.mo41537a(isMultipleInstances2);
                        qVar3.mo41540b(subProviderId2);
                        qVar3.mo41534a(adSourceName2);
                        this.f39735qa.mo41558a(qVar3);
                    }
                } else {
                    str = str2;
                    providerSettingsSection = providerSettingsSection2;
                    it = keys;
                    String str4 = key;
                }
                providerSettingsSection2 = providerSettingsSection;
                keys = it;
                str2 = str;
            }
            Iterator it2 = keys;
            this.f39735qa.mo41557a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private void m42001j() {
        C12816h isConfig;
        C12828s rvConfig;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONObject auctionSection;
        String str6;
        JSONObject appEventsSection;
        String str7;
        JSONObject appEventsSection2;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        JSONObject loggerSection;
        String str13;
        JSONObject appEventsSection3;
        JSONObject bnSection;
        C12906a isAuctionSettings;
        C12906a rvAuctionSettings;
        String str14 = Constants.VIDEO_TRACKING_EVENTS_KEY;
        try {
            JSONObject configurationsSection = m41994a(this.f39743ua, "configurations");
            JSONObject adUnitSection = m41994a(configurationsSection, "adUnits");
            JSONObject appSection = m41994a(configurationsSection, "application");
            JSONObject rvSection = m41994a(adUnitSection, "rewardedVideo");
            JSONObject isSection = m41994a(adUnitSection, AdType.INTERSTITIAL);
            JSONObject owSection = m41994a(adUnitSection, "offerwall");
            JSONObject bnSection2 = m41994a(adUnitSection, "banner");
            JSONObject appEventsSection4 = m41994a(appSection, str14);
            JSONObject loggerSection2 = m41994a(appSection, "loggers");
            JSONObject segmentSection = m41994a(appSection, "segment");
            JSONObject auctionSection2 = m41994a(appSection, "auction");
            C12818j owConfig = null;
            C12813e bannerConfig = null;
            if (appSection != null) {
                rvConfig = null;
                isConfig = null;
                C12916j.m41978b(this.f39745va, "uuidEnabled", appSection.optBoolean("uuidEnabled", true));
            } else {
                rvConfig = null;
                isConfig = null;
            }
            if (appEventsSection4 != null) {
                String abt = appEventsSection4.optString("abt");
                if (!TextUtils.isEmpty(abt)) {
                    C12784h.m41502g().mo41353a(abt);
                    C12787k.m41517g().mo41353a(abt);
                }
            }
            String str15 = "maxNumberOfEvents";
            String str16 = "backupThreshold";
            String str17 = "serverEventsType";
            JSONObject loggerSection3 = loggerSection2;
            String str18 = "serverEventsURL";
            JSONObject segmentSection2 = segmentSection;
            String str19 = "sendEventsToggle";
            JSONObject jSONObject = configurationsSection;
            String str20 = "maxNumOfAdaptersToLoadOnStart";
            JSONObject jSONObject2 = adUnitSection;
            String str21 = "placements";
            JSONObject owSection2 = owSection;
            String str22 = "";
            JSONObject bnSection3 = bnSection2;
            if (rvSection != null) {
                JSONArray rvPlacementsSection = rvSection.optJSONArray(str21);
                JSONObject rvEventsSection = m41994a(rvSection, str14);
                int rvSmartLoadAmount = m41991a(rvSection, appSection, str20, 2);
                str7 = str20;
                int rvSmartLoadTimeout = m41991a(rvSection, appSection, "adapterTimeOutInSeconds", 60);
                int rvManualLoadInterval = m41991a(rvSection, appSection, "loadRVInterval", 300);
                JSONObject rvEventsSection2 = rvEventsSection;
                JSONObject rewardedVideoCombinedEvents = C12916j.m41964a(rvEventsSection2, appEventsSection4);
                JSONObject jSONObject3 = rvEventsSection2;
                appEventsSection = appEventsSection4;
                boolean rvUltraEvents = rewardedVideoCombinedEvents.optBoolean("sendUltraEvents", false);
                boolean rvEventsToggle = rewardedVideoCombinedEvents.optBoolean(str19, false);
                String rvEventsUrl = rewardedVideoCombinedEvents.optString(str18, str22);
                String rvEventsType = rewardedVideoCombinedEvents.optString(str17, str22);
                int rvBackupThreshold = rewardedVideoCombinedEvents.optInt(str16, -1);
                int rvMaxNumOfEvents = rewardedVideoCombinedEvents.optInt(str15, -1);
                int rvMaxEventsPerBatch = rewardedVideoCombinedEvents.optInt("maxEventsPerBatch", 5000);
                int[] optOutEvents = null;
                JSONArray optOutJsonArray = rewardedVideoCombinedEvents.optJSONArray("optOut");
                if (optOutJsonArray != null) {
                    optOutEvents = new int[optOutJsonArray.length()];
                    JSONObject jSONObject4 = rewardedVideoCombinedEvents;
                    int i = 0;
                    while (true) {
                        str6 = str15;
                        if (i >= optOutJsonArray.length()) {
                            break;
                        }
                        optOutEvents[i] = optOutJsonArray.optInt(i);
                        i++;
                        str15 = str6;
                    }
                } else {
                    str6 = str15;
                    JSONObject jSONObject5 = rewardedVideoCombinedEvents;
                }
                C12811c cVar = new C12811c(rvUltraEvents, rvEventsToggle, rvEventsUrl, rvEventsType, rvBackupThreshold, rvMaxNumOfEvents, rvMaxEventsPerBatch, optOutEvents);
                C12811c rvEvents = cVar;
                if (auctionSection2 != null) {
                    JSONObject rvAuctionSection = m41994a(auctionSection2, "rewardedVideo");
                    String auctionData = auctionSection2.optString("auctionData", str22);
                    String auctioneerURL = auctionSection2.optString("auctioneerURL", str22);
                    int[] iArr = optOutEvents;
                    boolean isRvProgrammatic = rvAuctionSection.optBoolean("programmatic", false);
                    int rvTimeToWaitBeforeFirstAuction = rvAuctionSection.optInt("minTimeBeforeFirstAuction", 0);
                    JSONArray jSONArray = optOutJsonArray;
                    int rvAuctionRetryInterval = rvAuctionSection.optInt("auctionRetryInterval", 0);
                    auctionSection = auctionSection2;
                    int rvTimeToWaitBeforeAuction = rvAuctionSection.optInt("timeToWaitBeforeAuction", 5000);
                    str5 = str16;
                    String str23 = str18;
                    str4 = str19;
                    long j = (long) rvTimeToWaitBeforeFirstAuction;
                    int i2 = rvTimeToWaitBeforeFirstAuction;
                    str3 = str23;
                    str2 = str14;
                    str = str17;
                    C12906a aVar = new C12906a(auctionData, auctioneerURL, isRvProgrammatic, j, (long) rvAuctionRetryInterval, (long) rvTimeToWaitBeforeAuction, rvAuctionSection.optBoolean("isAuctionOnShowStart", true));
                    rvAuctionSettings = aVar;
                } else {
                    str2 = str14;
                    str = str17;
                    str5 = str16;
                    auctionSection = auctionSection2;
                    str3 = str18;
                    str4 = str19;
                    int[] iArr2 = optOutEvents;
                    JSONArray jSONArray2 = optOutJsonArray;
                    rvAuctionSettings = new C12906a();
                }
                C12828s sVar = new C12828s(rvSmartLoadAmount, rvSmartLoadTimeout, rvManualLoadInterval, rvEvents, rvAuctionSettings);
                JSONArray rvPlacementsSection2 = rvPlacementsSection;
                if (rvPlacementsSection2 != null) {
                    for (int i3 = 0; i3 < rvPlacementsSection2.length(); i3++) {
                        C12820l placement = m41998e(rvPlacementsSection2.optJSONObject(i3));
                        if (placement != null) {
                            sVar.mo41563a(placement);
                        }
                    }
                }
                String backFillProviderName = rvSection.optString("backFill");
                if (!TextUtils.isEmpty(backFillProviderName)) {
                    sVar.mo41565b(backFillProviderName);
                }
                String premiumProviderName = rvSection.optString("premium");
                if (!TextUtils.isEmpty(premiumProviderName)) {
                    sVar.mo41567c(premiumProviderName);
                }
                rvConfig = sVar;
            } else {
                str2 = str14;
                str = str17;
                str5 = str16;
                str6 = str15;
                auctionSection = auctionSection2;
                str3 = str18;
                str4 = str19;
                str7 = str20;
                appEventsSection = appEventsSection4;
            }
            if (isSection != null) {
                JSONArray isPlacementsSection = isSection.optJSONArray(str21);
                str10 = str2;
                JSONObject isEventsSection = m41994a(isSection, str10);
                str11 = str7;
                int isSmartLoadAmount = m41991a(isSection, appSection, str11, 2);
                int isSmartLoadTimeout = m41991a(isSection, appSection, "adapterTimeOutInSeconds", 60);
                JSONObject appEventsSection5 = appEventsSection;
                JSONObject interstitialCombinedEvents = C12916j.m41964a(isEventsSection, appEventsSection5);
                String str24 = str4;
                boolean isEventsToggle = interstitialCombinedEvents.optBoolean(str24, false);
                str9 = str3;
                String isEventsUrl = interstitialCombinedEvents.optString(str9, str22);
                JSONObject jSONObject6 = isEventsSection;
                String str25 = str;
                String isEventsType = interstitialCombinedEvents.optString(str25, str22);
                str = str25;
                str4 = str24;
                String str26 = str5;
                int isBackupThreshold = interstitialCombinedEvents.optInt(str26, -1);
                str5 = str26;
                String str27 = str6;
                int isMaxNumOfEvents = interstitialCombinedEvents.optInt(str27, -1);
                str6 = str27;
                int isMaxEventsPerBatch = interstitialCombinedEvents.optInt("maxEventsPerBatch", 5000);
                int[] optOutEvents2 = null;
                JSONArray optOutJsonArray2 = interstitialCombinedEvents.optJSONArray("optOut");
                if (optOutJsonArray2 != null) {
                    optOutEvents2 = new int[optOutJsonArray2.length()];
                    JSONObject jSONObject7 = interstitialCombinedEvents;
                    int i4 = 0;
                    while (true) {
                        JSONObject rvSection2 = rvSection;
                        if (i4 >= optOutJsonArray2.length()) {
                            break;
                        }
                        optOutEvents2[i4] = optOutJsonArray2.optInt(i4);
                        i4++;
                        rvSection = rvSection2;
                    }
                } else {
                    JSONObject jSONObject8 = interstitialCombinedEvents;
                    JSONObject jSONObject9 = rvSection;
                }
                C12811c cVar2 = new C12811c(false, isEventsToggle, isEventsUrl, isEventsType, isBackupThreshold, isMaxNumOfEvents, isMaxEventsPerBatch, optOutEvents2);
                if (auctionSection != null) {
                    JSONArray jSONArray3 = optOutJsonArray2;
                    JSONObject auctionSection3 = auctionSection;
                    JSONObject isAuctionSection = m41994a(auctionSection3, AdType.INTERSTITIAL);
                    int[] iArr3 = optOutEvents2;
                    auctionSection = auctionSection3;
                    str8 = str22;
                    appEventsSection2 = appEventsSection5;
                    C12906a aVar2 = new C12906a(auctionSection3.optString("auctionData", str22), auctionSection3.optString("auctioneerURL", str22), isAuctionSection.optBoolean("programmatic", false), (long) isAuctionSection.optInt("minTimeBeforeFirstAuction", 0), 0, 0, true);
                    isAuctionSettings = aVar2;
                } else {
                    JSONArray jSONArray4 = optOutJsonArray2;
                    str8 = str22;
                    appEventsSection2 = appEventsSection5;
                    isAuctionSettings = new C12906a();
                }
                C12816h isConfig2 = new C12816h(isSmartLoadAmount, isSmartLoadTimeout, cVar2, isAuctionSettings);
                if (isPlacementsSection != null) {
                    for (int i5 = 0; i5 < isPlacementsSection.length(); i5++) {
                        C12817i placement2 = m41996c(isPlacementsSection.optJSONObject(i5));
                        if (placement2 != null) {
                            isConfig2.mo41485a(placement2);
                        }
                    }
                }
                String backFillProviderName2 = isSection.optString("backFill");
                if (!TextUtils.isEmpty(backFillProviderName2)) {
                    isConfig2.mo41487b(backFillProviderName2);
                }
                String premiumProviderName2 = isSection.optString("premium");
                if (!TextUtils.isEmpty(premiumProviderName2)) {
                    isConfig2.mo41489c(premiumProviderName2);
                }
                isConfig = isConfig2;
            } else {
                str11 = str7;
                appEventsSection2 = appEventsSection;
                str9 = str3;
                str10 = str2;
                str8 = str22;
            }
            if (bnSection3 != null) {
                bnSection = bnSection3;
                JSONArray bnPlacementsSection = bnSection.optJSONArray(str21);
                JSONObject bnEventsSection = m41994a(bnSection, str10);
                int bnSmartLoadAmount = m41991a(bnSection, appSection, str11, 1);
                String str28 = str;
                String str29 = str5;
                String str30 = str6;
                JSONObject jSONObject10 = auctionSection;
                str12 = str10;
                String str31 = str9;
                loggerSection = loggerSection3;
                JSONObject loggerSection4 = isSection;
                String str32 = str4;
                long bnSmartLoadTimeout = m41992a(bnSection, appSection, "atim", 10000);
                int bnIntervalTime = m41991a(bnSection, appSection, "bannerInterval", 60);
                appEventsSection3 = appEventsSection2;
                JSONObject bannerCombinedEvents = C12916j.m41964a(bnEventsSection, appEventsSection3);
                boolean bnEventsToggle = bannerCombinedEvents.optBoolean(str32, false);
                str13 = str8;
                String bnEventsUrl = bannerCombinedEvents.optString(str31, str13);
                String bnEventsType = bannerCombinedEvents.optString(str28, str13);
                int bnBackupThreshold = bannerCombinedEvents.optInt(str29, -1);
                int bnMaxNumOfEvents = bannerCombinedEvents.optInt(str30, -1);
                int bnMaxEventsPerBatch = bannerCombinedEvents.optInt("maxEventsPerBatch", 5000);
                int[] optOutEvents3 = null;
                JSONArray optOutJsonArray3 = bannerCombinedEvents.optJSONArray("optOut");
                if (optOutJsonArray3 != null) {
                    optOutEvents3 = new int[optOutJsonArray3.length()];
                    for (int i6 = 0; i6 < optOutJsonArray3.length(); i6++) {
                        optOutEvents3[i6] = optOutJsonArray3.optInt(i6);
                    }
                }
                C12811c cVar3 = new C12811c(false, bnEventsToggle, bnEventsUrl, bnEventsType, bnBackupThreshold, bnMaxNumOfEvents, bnMaxEventsPerBatch, optOutEvents3);
                C12813e eVar = new C12813e(bnSmartLoadAmount, bnSmartLoadTimeout, cVar3, bnIntervalTime);
                if (bnPlacementsSection != null) {
                    for (int i7 = 0; i7 < bnPlacementsSection.length(); i7++) {
                        C12814f placement3 = m41995b(bnPlacementsSection.optJSONObject(i7));
                        if (placement3 != null) {
                            eVar.mo41474a(placement3);
                        }
                    }
                }
                bannerConfig = eVar;
            } else {
                str12 = str10;
                loggerSection = loggerSection3;
                bnSection = bnSection3;
                str13 = str8;
                appEventsSection3 = appEventsSection2;
                JSONObject jSONObject11 = auctionSection;
                JSONObject loggerSection5 = isSection;
            }
            if (owSection2 != null) {
                JSONArray owPlacementsSection = owSection2.optJSONArray(str21);
                C12818j owConfig2 = new C12818j();
                if (owPlacementsSection != null) {
                    for (int i8 = 0; i8 < owPlacementsSection.length(); i8++) {
                        C12819k placement4 = m41997d(owPlacementsSection.optJSONObject(i8));
                        if (placement4 != null) {
                            owConfig2.mo41499a(placement4);
                        }
                    }
                }
                owConfig = owConfig2;
            }
            C12812d logger = new C12812d(loggerSection.optInt("server", 3), loggerSection.optInt("publisher", 3), loggerSection.optInt("console", 3));
            C12829t segmentData = null;
            if (segmentSection2 != null) {
                JSONObject segmentSection3 = segmentSection2;
                segmentData = new C12829t(segmentSection3.optString("name", str13), segmentSection3.optString("id", "-1"), segmentSection3.optJSONObject(AdType.CUSTOM));
            }
            C12810b appConfig = new C12810b(logger, segmentData, appSection.optBoolean("integration", false));
            C12916j.m41978b(this.f39745va, "GeneralProperties.ALLOW_LOCATION_SHARED_PREFS_KEY", appSection.optBoolean("allowLocation", false));
            C12815g gVar = new C12815g(rvConfig, isConfig, owConfig, bannerConfig, appConfig);
            this.f39737ra = gVar;
            JSONObject batchParamsSection = m41994a(appEventsSection3, "genericParams");
            JSONObject copyOfBatchParams = batchParamsSection;
            if (copyOfBatchParams != null) {
                JSONObject jSONObject12 = bnSection;
                String str33 = str12;
                JSONObject eventParamsSection = m41994a(copyOfBatchParams, str33);
                if (eventParamsSection != null) {
                    copyOfBatchParams.remove(str33);
                    Map<String, String> genericParamsEventsMap = C12916j.m41961a(eventParamsSection);
                    JSONObject jSONObject13 = appEventsSection3;
                    C12787k.m41517g().mo41361b(genericParamsEventsMap);
                    C12784h.m41502g().mo41361b(genericParamsEventsMap);
                }
            } else {
                JSONObject jSONObject14 = appEventsSection3;
            }
            if (batchParamsSection != null) {
                Map<String, String> genericParamsBatchMap = C12916j.m41961a(copyOfBatchParams);
                C12787k.m41517g().mo41355a(genericParamsBatchMap);
                C12784h.m41502g().mo41355a(genericParamsBatchMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m41991a(JSONObject mainJson, JSONObject secondaryJson, String key, int defaultValue) {
        int result = 0;
        if (mainJson.has(key)) {
            result = mainJson.optInt(key, 0);
        } else if (secondaryJson.has(key)) {
            result = secondaryJson.optInt(key, 0);
        }
        if (result == 0) {
            return defaultValue;
        }
        return result;
    }

    /* renamed from: a */
    private long m41992a(JSONObject mainJson, JSONObject secondaryJson, String key, long defaultValue) {
        long result = 0;
        if (mainJson.has(key)) {
            result = mainJson.optLong(key, 0);
        } else if (secondaryJson.has(key)) {
            result = secondaryJson.optLong(key, 0);
        }
        if (result == 0) {
            return defaultValue;
        }
        return result;
    }

    /* renamed from: e */
    private C12820l m41998e(JSONObject placementJson) {
        JSONObject jSONObject = placementJson;
        C12820l result = null;
        if (jSONObject != null) {
            int placementId = jSONObject.optInt("placementId", -1);
            String str = "";
            String placementName = jSONObject.optString("placementName", str);
            boolean isDefault = jSONObject.optBoolean("isDefault", false);
            String virtualItemName = jSONObject.optString("virtualItemName", str);
            int virtualItemCount = jSONObject.optInt("virtualItemCount", -1);
            C12822n settings = m41993a(placementJson);
            if (placementId >= 0 && !TextUtils.isEmpty(placementName)) {
                if (!TextUtils.isEmpty(virtualItemName) && virtualItemCount > 0) {
                    C12820l lVar = new C12820l(placementId, placementName, isDefault, virtualItemName, virtualItemCount, settings);
                    result = lVar;
                    if (settings != null) {
                        C12908c.m41890a(this.f39745va, result);
                    }
                }
            }
        }
        return result;
    }

    /* renamed from: c */
    private C12817i m41996c(JSONObject placementJson) {
        C12817i result = null;
        if (placementJson != null) {
            int placementId = placementJson.optInt("placementId", -1);
            String placementName = placementJson.optString("placementName", "");
            boolean isDefault = placementJson.optBoolean("isDefault", false);
            C12822n settings = m41993a(placementJson);
            if (placementId >= 0 && !TextUtils.isEmpty(placementName)) {
                result = new C12817i(placementId, placementName, isDefault, settings);
                if (settings != null) {
                    C12908c.m41889a(this.f39745va, result);
                }
            }
        }
        return result;
    }

    /* renamed from: d */
    private C12819k m41997d(JSONObject placementJson) {
        if (placementJson == null) {
            return null;
        }
        int placementId = placementJson.optInt("placementId", -1);
        String placementName = placementJson.optString("placementName", "");
        boolean isDefault = placementJson.optBoolean("isDefault", false);
        if (placementId < 0 || TextUtils.isEmpty(placementName)) {
            return null;
        }
        return new C12819k(placementId, placementName, isDefault);
    }

    /* renamed from: b */
    private C12814f m41995b(JSONObject placementJson) {
        C12814f result = null;
        if (placementJson != null) {
            int placementId = placementJson.optInt("placementId", -1);
            String placementName = placementJson.optString("placementName", "");
            boolean isDefault = placementJson.optBoolean("isDefault", false);
            C12822n settings = m41993a(placementJson);
            if (placementId >= 0 && !TextUtils.isEmpty(placementName)) {
                result = new C12814f(placementId, placementName, isDefault, settings);
                if (settings != null) {
                    C12908c.m41888a(this.f39745va, result);
                }
            }
        }
        return result;
    }

    /* renamed from: a */
    private C12822n m41993a(JSONObject placementJson) {
        if (placementJson == null) {
            return null;
        }
        C12823a settingsBuilder = new C12823a();
        boolean isPacingEnabled = true;
        settingsBuilder.mo41515a(placementJson.optBoolean("delivery", true));
        JSONObject cappingJson = placementJson.optJSONObject("capping");
        String str = "enabled";
        if (cappingJson != null) {
            C12824o cappingType = null;
            String cappingUnitString = cappingJson.optString("unit");
            if (!TextUtils.isEmpty(cappingUnitString)) {
                if (C12824o.PER_DAY.toString().equals(cappingUnitString)) {
                    cappingType = C12824o.PER_DAY;
                } else if (C12824o.PER_HOUR.toString().equals(cappingUnitString)) {
                    cappingType = C12824o.PER_HOUR;
                }
            }
            int cappingValue = cappingJson.optInt("maxImpressions", 0);
            settingsBuilder.mo41517a(cappingJson.optBoolean(str, false) && cappingValue > 0, cappingType, cappingValue);
        }
        JSONObject pacingJson = placementJson.optJSONObject("pacing");
        if (pacingJson != null) {
            int pacingValue = pacingJson.optInt("numOfSeconds", 0);
            if (!pacingJson.optBoolean(str, false) || pacingValue <= 0) {
                isPacingEnabled = false;
            }
            settingsBuilder.mo41516a(isPacingEnabled, pacingValue);
        }
        return settingsBuilder.mo41518a();
    }

    /* renamed from: a */
    private JSONObject m41994a(JSONObject json, String sectionName) {
        if (json != null) {
            return json.optJSONObject(sectionName);
        }
        return null;
    }

    /* renamed from: e */
    public String mo41696e() {
        try {
            return this.f39733pa.mo41524c();
        } catch (Exception e) {
            C12802d.m41613c().mo41426a(C12801a.INTERNAL, "getRVBackFillProvider", (Throwable) e);
            return null;
        }
    }

    /* renamed from: f */
    public String mo41697f() {
        try {
            return this.f39733pa.mo41526d();
        } catch (Exception e) {
            C12802d.m41613c().mo41426a(C12801a.INTERNAL, "getRVPremiumProvider", (Throwable) e);
            return null;
        }
    }

    /* renamed from: d */
    public C12827r mo41695d() {
        return this.f39735qa;
    }

    /* renamed from: c */
    public C12825p mo41694c() {
        return this.f39733pa;
    }

    /* renamed from: a */
    public C12815g mo41692a() {
        return this.f39737ra;
    }

    /* renamed from: i */
    private Context m42000i() {
        return this.f39745va;
    }
}
