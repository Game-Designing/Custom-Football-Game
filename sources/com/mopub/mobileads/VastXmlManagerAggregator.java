package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Point;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Strings;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VastXmlManagerAggregator extends AsyncTask<String, Void, VastVideoConfig> {
    public static final String ADS_BY_AD_SLOT_ID = "adsBy";
    public static final String SOCIAL_ACTIONS_AD_SLOT_ID = "socialActions";

    /* renamed from: a */
    private static final List<String> f35106a = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});

    /* renamed from: b */
    private final WeakReference<C11360b> f35107b;

    /* renamed from: c */
    private final double f35108c;

    /* renamed from: d */
    private final int f35109d;

    /* renamed from: e */
    private final Context f35110e;

    /* renamed from: f */
    private int f35111f;

    /* renamed from: com.mopub.mobileads.VastXmlManagerAggregator$a */
    enum C11359a {
        LANDSCAPE,
        PORTRAIT
    }

    /* renamed from: com.mopub.mobileads.VastXmlManagerAggregator$b */
    interface C11360b {
        void onAggregationComplete(VastVideoConfig vastVideoConfig);
    }

    VastXmlManagerAggregator(C11360b vastXmlManagerAggregatorListener, double screenAspectRatio, int screenAreaDp, Context context) {
        Preconditions.checkNotNull(vastXmlManagerAggregatorListener);
        Preconditions.checkNotNull(context);
        this.f35107b = new WeakReference<>(vastXmlManagerAggregatorListener);
        this.f35108c = screenAspectRatio;
        this.f35109d = screenAreaDp;
        this.f35110e = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Networking.getUserAgent(this.f35110e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public VastVideoConfig doInBackground(String... strings) {
        if (strings == null || strings.length == 0 || strings[0] == null) {
            return null;
        }
        try {
            return mo37376a(strings[0], (List<VastTracker>) new ArrayList<VastTracker>());
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.ERROR, "Unable to generate VastVideoConfig.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(VastVideoConfig vastVideoConfig) {
        C11360b listener = (C11360b) this.f35107b.get();
        if (listener != null) {
            listener.onAggregationComplete(vastVideoConfig);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        C11360b listener = (C11360b) this.f35107b.get();
        if (listener != null) {
            listener.onAggregationComplete(null);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public VastVideoConfig mo37376a(String vastXml, List<VastTracker> errorTrackers) {
        List list;
        String str = vastXml;
        List<VastTracker> list2 = errorTrackers;
        Preconditions.checkNotNull(str, "vastXml cannot be null");
        Preconditions.checkNotNull(list2, "errorTrackers cannot be null");
        C11377_a xmlManager = new C11377_a();
        try {
            xmlManager.mo37438a(str);
            List<C11466xa> a = xmlManager.mo37437a();
            if (m37673a(a, xmlManager, this.f35110e)) {
                return null;
            }
            for (C11466xa vastAdXmlManager : a) {
                if (m37672a(vastAdXmlManager.mo37575b())) {
                    C11305Da vastInLineXmlManager = vastAdXmlManager.mo37574a();
                    if (vastInLineXmlManager != null) {
                        VastVideoConfig vastVideoConfig = m37667a(vastInLineXmlManager, list2);
                        if (vastVideoConfig != null) {
                            m37670a(xmlManager, vastVideoConfig);
                            return vastVideoConfig;
                        }
                    }
                    C11376Za vastWrapperXmlManager = vastAdXmlManager.mo37576c();
                    if (vastWrapperXmlManager != null) {
                        List<VastTracker> wrapperErrorTrackers = new ArrayList<>(list2);
                        wrapperErrorTrackers.addAll(vastWrapperXmlManager.mo37578b());
                        String vastRedirectXml = m37668a(vastWrapperXmlManager, wrapperErrorTrackers);
                        if (vastRedirectXml == null) {
                            continue;
                        } else {
                            VastVideoConfig vastVideoConfig2 = mo37376a(vastRedirectXml, wrapperErrorTrackers);
                            if (vastVideoConfig2 != null) {
                                vastVideoConfig2.addImpressionTrackers(vastWrapperXmlManager.mo37579c());
                                Iterator it = vastWrapperXmlManager.mo37580d().iterator();
                                while (it.hasNext()) {
                                    m37669a((C11307Ea) it.next(), vastVideoConfig2);
                                }
                                m37671a((C11468ya) vastWrapperXmlManager, vastVideoConfig2);
                                m37675b(vastWrapperXmlManager, vastVideoConfig2);
                                List<VastCompanionAdXmlManager> companionAdXmlManagers = vastWrapperXmlManager.mo37577a();
                                if (!vastVideoConfig2.hasCompanionAd()) {
                                    vastVideoConfig2.setVastCompanionAd(mo37375a(companionAdXmlManagers, C11359a.LANDSCAPE), mo37375a(companionAdXmlManagers, C11359a.PORTRAIT));
                                    List list3 = a;
                                } else {
                                    VastCompanionAdConfig landscapeCompanionAd = vastVideoConfig2.getVastCompanionAd(2);
                                    VastCompanionAdConfig portraitCompanionAd = vastVideoConfig2.getVastCompanionAd(1);
                                    if (landscapeCompanionAd == null || portraitCompanionAd == null) {
                                        List list4 = a;
                                    } else {
                                        Iterator it2 = companionAdXmlManagers.iterator();
                                        while (it2.hasNext()) {
                                            C11297Aa companionAdXmlManager = (C11297Aa) it2.next();
                                            if (!companionAdXmlManager.mo36846h()) {
                                                list = a;
                                                landscapeCompanionAd.addClickTrackers(companionAdXmlManager.mo36841c());
                                                landscapeCompanionAd.addCreativeViewTrackers(companionAdXmlManager.mo36842d());
                                                portraitCompanionAd.addClickTrackers(companionAdXmlManager.mo36841c());
                                                portraitCompanionAd.addCreativeViewTrackers(companionAdXmlManager.mo36842d());
                                            } else {
                                                list = a;
                                            }
                                            a = list;
                                        }
                                        List list5 = a;
                                    }
                                }
                                if (vastVideoConfig2.getSocialActionsCompanionAds().isEmpty()) {
                                    vastVideoConfig2.setSocialActionsCompanionAds(mo37380c(companionAdXmlManagers));
                                }
                                m37670a(xmlManager, vastVideoConfig2);
                                return vastVideoConfig2;
                            }
                        }
                    } else {
                        List list6 = a;
                    }
                }
            }
            List list7 = a;
            return null;
        } catch (Exception e) {
            Exception e2 = e;
            MoPubLog.log(SdkLogEvent.ERROR, "Failed to parse VAST XML", e2);
            TrackingRequest.makeVastTrackingHttpRequest(list2, VastErrorCode.XML_PARSING_ERROR, null, null, this.f35110e);
            return null;
        }
    }

    /* renamed from: a */
    private VastVideoConfig m37667a(C11305Da vastInLineXmlManager, List<VastTracker> errorTrackers) {
        Preconditions.checkNotNull(vastInLineXmlManager);
        Preconditions.checkNotNull(errorTrackers);
        Iterator it = vastInLineXmlManager.mo37580d().iterator();
        while (it.hasNext()) {
            C11307Ea linearXmlManager = (C11307Ea) it.next();
            String bestMediaFileUrl = mo37379b(linearXmlManager.mo37000f());
            if (bestMediaFileUrl != null) {
                VastVideoConfig vastVideoConfig = new VastVideoConfig();
                vastVideoConfig.addImpressionTrackers(vastInLineXmlManager.mo37579c());
                m37669a(linearXmlManager, vastVideoConfig);
                vastVideoConfig.setClickThroughUrl(linearXmlManager.mo36996b());
                vastVideoConfig.setNetworkMediaFileUrl(bestMediaFileUrl);
                List<VastCompanionAdXmlManager> companionAdXmlManagers = vastInLineXmlManager.mo37577a();
                vastVideoConfig.setVastCompanionAd(mo37375a(companionAdXmlManagers, C11359a.LANDSCAPE), mo37375a(companionAdXmlManagers, C11359a.PORTRAIT));
                vastVideoConfig.setSocialActionsCompanionAds(mo37380c(companionAdXmlManagers));
                errorTrackers.addAll(vastInLineXmlManager.mo37578b());
                vastVideoConfig.addErrorTrackers(errorTrackers);
                m37671a((C11468ya) vastInLineXmlManager, vastVideoConfig);
                m37675b(vastInLineXmlManager, vastVideoConfig);
                return vastVideoConfig;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m37671a(C11468ya vastInLineXmlManager, VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(vastInLineXmlManager);
        Preconditions.checkNotNull(vastVideoConfig);
        if (vastVideoConfig.getVideoViewabilityTracker() == null) {
            VastExtensionParentXmlManager vastExtensionParentXmlManager = vastInLineXmlManager.mo37581e();
            if (vastExtensionParentXmlManager != null) {
                Iterator it = vastExtensionParentXmlManager.mo37220a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VastExtensionXmlManager vastExtensionXmlManager = (VastExtensionXmlManager) it.next();
                    if (MoPubLog.LOGTAG.equals(vastExtensionXmlManager.mo37223c())) {
                        vastVideoConfig.setVideoViewabilityTracker(vastExtensionXmlManager.mo37224d());
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m37675b(C11468ya vastInLineXmlManager, VastVideoConfig vastVideoConfig) {
        VastExtensionParentXmlManager vastExtensionParentXmlManager = vastInLineXmlManager.mo37581e();
        if (vastExtensionParentXmlManager != null) {
            for (VastExtensionXmlManager vastExtensionXmlManager : vastExtensionParentXmlManager.mo37220a()) {
                if (vastExtensionXmlManager != null) {
                    vastVideoConfig.addAvidJavascriptResources(vastExtensionXmlManager.mo37221a());
                    vastVideoConfig.addMoatImpressionPixels(vastExtensionXmlManager.mo37222b());
                }
            }
        }
    }

    /* renamed from: a */
    private String m37668a(C11376Za vastWrapperXmlManager, List<VastTracker> wrapperErrorTrackers) {
        String vastAdTagUri = vastWrapperXmlManager.mo37436f();
        if (vastAdTagUri == null) {
            return null;
        }
        String vastRedirectXml = null;
        try {
            vastRedirectXml = m37674b(vastAdTagUri);
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.ERROR, "Failed to follow VAST redirect", e);
            if (!wrapperErrorTrackers.isEmpty()) {
                TrackingRequest.makeVastTrackingHttpRequest(wrapperErrorTrackers, VastErrorCode.WRAPPER_TIMEOUT, null, null, this.f35110e);
            }
        }
        return vastRedirectXml;
    }

    /* renamed from: a */
    private void m37669a(C11307Ea linearXmlManager, VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(linearXmlManager, "linearXmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addAbsoluteTrackers(linearXmlManager.mo36995a());
        vastVideoConfig.addFractionalTrackers(linearXmlManager.mo36998d());
        vastVideoConfig.addPauseTrackers(linearXmlManager.mo37001g());
        vastVideoConfig.addResumeTrackers(linearXmlManager.mo37002h());
        vastVideoConfig.addCompleteTrackers(linearXmlManager.mo37005k());
        vastVideoConfig.addCloseTrackers(linearXmlManager.mo37004j());
        vastVideoConfig.addSkipTrackers(linearXmlManager.mo37006l());
        vastVideoConfig.addClickTrackers(linearXmlManager.mo36997c());
        if (vastVideoConfig.getSkipOffsetString() == null) {
            vastVideoConfig.setSkipOffset(linearXmlManager.mo37003i());
        }
        if (vastVideoConfig.getVastIconConfig() == null) {
            vastVideoConfig.setVastIconConfig(mo37374a(linearXmlManager.mo36999e()));
        }
    }

    /* renamed from: a */
    private void m37670a(C11377_a xmlManager, VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(xmlManager, "xmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addImpressionTrackers(xmlManager.mo37444g());
        if (vastVideoConfig.getCustomCtaText() == null) {
            vastVideoConfig.setCustomCtaText(xmlManager.mo37440c());
        }
        if (vastVideoConfig.getCustomSkipText() == null) {
            vastVideoConfig.setCustomSkipText(xmlManager.mo37442e());
        }
        if (vastVideoConfig.getCustomCloseIconUrl() == null) {
            vastVideoConfig.setCustomCloseIconUrl(xmlManager.mo37439b());
        }
        if (!vastVideoConfig.isCustomForceOrientationSet()) {
            vastVideoConfig.setCustomForceOrientation(xmlManager.mo37441d());
        }
    }

    /* renamed from: a */
    private boolean m37673a(List<C11466xa> vastAdXmlManagers, C11377_a xmlManager, Context context) {
        if (!vastAdXmlManagers.isEmpty() || xmlManager.mo37443f() == null) {
            return false;
        }
        TrackingRequest.makeVastTrackingHttpRequest(Collections.singletonList(xmlManager.mo37443f()), this.f35111f > 0 ? VastErrorCode.NO_ADS_VAST_RESPONSE : VastErrorCode.UNDEFINED_ERROR, null, null, context);
        return true;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public String mo37379b(List<C11315Ha> managers) {
        Preconditions.checkNotNull(managers, "managers cannot be null");
        double bestMediaFitness = Double.POSITIVE_INFINITY;
        String bestMediaFileUrl = null;
        Iterator<VastMediaXmlManager> xmlManagerIterator = new ArrayList<>(managers).iterator();
        while (xmlManagerIterator.hasNext()) {
            C11315Ha mediaXmlManager = (C11315Ha) xmlManagerIterator.next();
            String mediaType = mediaXmlManager.mo37020c();
            String mediaUrl = mediaXmlManager.mo37019b();
            if (!f35106a.contains(mediaType) || mediaUrl == null) {
                xmlManagerIterator.remove();
            } else {
                Integer mediaWidth = mediaXmlManager.mo37021d();
                Integer mediaHeight = mediaXmlManager.mo37018a();
                if (mediaWidth != null && mediaWidth.intValue() > 0 && mediaHeight != null && mediaHeight.intValue() > 0) {
                    double mediaFitness = m37666a(mediaWidth.intValue(), mediaHeight.intValue());
                    if (mediaFitness < bestMediaFitness) {
                        bestMediaFitness = mediaFitness;
                        bestMediaFileUrl = mediaUrl;
                    }
                }
            }
        }
        return bestMediaFileUrl;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public VastCompanionAdConfig mo37375a(List<C11297Aa> managers, C11359a orientation) {
        Point bestVastScaledDimensions;
        C11321Ja bestVastResource;
        ArrayList<C11297Aa> arrayList;
        C11321Ja bestVastResource2;
        Point bestVastScaledDimensions2;
        Point bestVastScaledDimensions3;
        C11321Ja bestVastResource3;
        ArrayList arrayList2;
        double companionFitness;
        List<C11297Aa> list = managers;
        C11359a aVar = orientation;
        Preconditions.checkNotNull(list, "managers cannot be null");
        Preconditions.checkNotNull(aVar, "orientation cannot be null");
        List<VastCompanionAdXmlManager> arrayList3 = new ArrayList<>(list);
        double bestCompanionFitness = Double.POSITIVE_INFINITY;
        C11297Aa bestCompanionXmlManager = null;
        C11321Ja bestVastResource4 = null;
        Point bestVastScaledDimensions4 = null;
        C11323b[] values = C11323b.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                List<VastCompanionAdXmlManager> companionXmlManagers = arrayList;
                bestVastResource2 = bestVastResource;
                bestVastScaledDimensions2 = bestVastScaledDimensions;
                break;
            }
            C11323b type = values[i];
            for (C11297Aa companionXmlManager : arrayList) {
                Integer width = companionXmlManager.mo36845g();
                Integer height = companionXmlManager.mo36843e();
                if (width != null) {
                    arrayList2 = arrayList;
                    if (width.intValue() < 300 || height == null) {
                        bestVastResource3 = bestVastResource;
                        bestVastScaledDimensions3 = bestVastScaledDimensions;
                    } else if (height.intValue() < 250) {
                        bestVastResource3 = bestVastResource;
                        bestVastScaledDimensions3 = bestVastScaledDimensions;
                    } else {
                        Point vastScaledDimensions = mo37373a(width.intValue(), height.intValue(), type, aVar);
                        bestVastResource3 = bestVastResource;
                        bestVastScaledDimensions3 = bestVastScaledDimensions;
                        C11321Ja vastResource = C11321Ja.m37419a(companionXmlManager.mo36844f(), type, vastScaledDimensions.x, vastScaledDimensions.y);
                        if (vastResource != null) {
                            if (C11359a.PORTRAIT == aVar) {
                                companionFitness = m37666a(height.intValue(), width.intValue());
                            } else {
                                companionFitness = m37666a(width.intValue(), height.intValue());
                            }
                            if (companionFitness < bestCompanionFitness) {
                                bestCompanionFitness = companionFitness;
                                bestCompanionXmlManager = companionXmlManager;
                                bestVastResource3 = vastResource;
                                bestVastScaledDimensions3 = vastScaledDimensions;
                            }
                            bestVastResource = bestVastResource3;
                            bestVastScaledDimensions = bestVastScaledDimensions3;
                            List<C11297Aa> list2 = managers;
                            arrayList = arrayList2;
                        }
                    }
                } else {
                    arrayList2 = arrayList;
                    bestVastResource3 = bestVastResource;
                    bestVastScaledDimensions3 = bestVastScaledDimensions;
                }
                List<C11297Aa> list3 = managers;
                arrayList = arrayList2;
                bestVastResource = bestVastResource3;
                bestVastScaledDimensions = bestVastScaledDimensions3;
            }
            ArrayList arrayList4 = arrayList;
            bestVastResource2 = bestVastResource;
            Point bestVastScaledDimensions5 = bestVastScaledDimensions;
            if (bestCompanionXmlManager != null) {
                bestVastScaledDimensions2 = bestVastScaledDimensions5;
                break;
            }
            i++;
            List<C11297Aa> list4 = managers;
            arrayList3 = arrayList4;
            bestVastResource4 = bestVastResource2;
            bestVastScaledDimensions4 = bestVastScaledDimensions5;
        }
        if (bestCompanionXmlManager == null) {
            return null;
        }
        VastCompanionAdConfig vastCompanionAdConfig = new VastCompanionAdConfig(bestVastScaledDimensions2.x, bestVastScaledDimensions2.y, bestVastResource2, bestCompanionXmlManager.mo36840b(), bestCompanionXmlManager.mo36841c(), bestCompanionXmlManager.mo36842d());
        return vastCompanionAdConfig;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: c */
    public Map<String, VastCompanionAdConfig> mo37380c(List<C11297Aa> managers) {
        Preconditions.checkNotNull(managers, "managers cannot be null");
        Map<String, VastCompanionAdConfig> socialActionsCompanionAds = new HashMap<>();
        for (C11297Aa companionXmlManager : managers) {
            Integer width = companionXmlManager.mo36845g();
            Integer height = companionXmlManager.mo36843e();
            if (!(width == null || height == null)) {
                String adSlotId = companionXmlManager.mo36839a();
                if (!ADS_BY_AD_SLOT_ID.equals(adSlotId) ? !(!SOCIAL_ACTIONS_AD_SLOT_ID.equals(adSlotId) || width.intValue() < 50 || width.intValue() > 150 || height.intValue() < 10 || height.intValue() > 50) : !(width.intValue() < 25 || width.intValue() > 75 || height.intValue() < 10 || height.intValue() > 50)) {
                    C11321Ja vastResource = C11321Ja.m37419a(companionXmlManager.mo36844f(), C11323b.HTML_RESOURCE, width.intValue(), height.intValue());
                    if (vastResource != null) {
                        VastCompanionAdConfig vastCompanionAdConfig = new VastCompanionAdConfig(width.intValue(), height.intValue(), vastResource, companionXmlManager.mo36840b(), companionXmlManager.mo36841c(), companionXmlManager.mo36842d());
                        socialActionsCompanionAds.put(adSlotId, vastCompanionAdConfig);
                    }
                }
            }
        }
        return socialActionsCompanionAds;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public Point mo37373a(int widthDp, int heightDp, C11323b type, C11359a orientation) {
        int screenHeightPx;
        int screenWidthPx;
        int i = widthDp;
        int i2 = heightDp;
        Point defaultPoint = new Point(i, i2);
        Display display = ((WindowManager) this.f35110e.getSystemService("window")).getDefaultDisplay();
        int x = display.getWidth();
        int y = display.getHeight();
        int widthPx = Dips.dipsToIntPixels((float) i, this.f35110e);
        int heightPx = Dips.dipsToIntPixels((float) i2, this.f35110e);
        if (C11359a.LANDSCAPE == orientation) {
            screenWidthPx = Math.max(x, y);
            screenHeightPx = Math.min(x, y);
        } else {
            screenWidthPx = Math.min(x, y);
            screenHeightPx = Math.max(x, y);
        }
        if (widthPx <= screenWidthPx - 16 && heightPx <= screenHeightPx - 16) {
            return defaultPoint;
        }
        Point point = new Point();
        if (C11323b.HTML_RESOURCE == type) {
            point.x = Math.min(screenWidthPx, widthPx);
            point.y = Math.min(screenHeightPx, heightPx);
        } else {
            float widthRatio = ((float) widthPx) / ((float) screenWidthPx);
            float heightRatio = ((float) heightPx) / ((float) screenHeightPx);
            if (widthRatio >= heightRatio) {
                point.x = screenWidthPx;
                point.y = (int) (((float) heightPx) / widthRatio);
            } else {
                point.x = (int) (((float) widthPx) / heightRatio);
                point.y = screenHeightPx;
            }
        }
        point.x -= 16;
        point.y -= 16;
        int i3 = point.x;
        if (i3 < 0 || point.y < 0) {
            return defaultPoint;
        }
        point.x = Dips.pixelsToIntDips((float) i3, this.f35110e);
        point.y = Dips.pixelsToIntDips((float) point.y, this.f35110e);
        return point;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public C11302Ca mo37374a(List<VastIconXmlManager> managers) {
        C11323b[] values;
        List<VastIconXmlManager> list = managers;
        Preconditions.checkNotNull(list, "managers cannot be null");
        List<VastIconXmlManager> iconXmlManagers = new ArrayList<>(list);
        for (C11323b type : C11323b.values()) {
            for (VastIconXmlManager iconXmlManager : iconXmlManagers) {
                Integer width = iconXmlManager.mo37236h();
                Integer height = iconXmlManager.mo37232d();
                if (width != null && width.intValue() > 0 && width.intValue() <= 300 && height != null && height.intValue() > 0 && height.intValue() <= 300) {
                    C11321Ja vastResource = C11321Ja.m37419a(iconXmlManager.mo37234f(), type, width.intValue(), height.intValue());
                    if (vastResource != null) {
                        C11302Ca ca = new C11302Ca(iconXmlManager.mo37236h().intValue(), iconXmlManager.mo37232d().intValue(), iconXmlManager.mo37233e(), iconXmlManager.mo37231c(), vastResource, iconXmlManager.mo37230b(), iconXmlManager.mo37229a(), iconXmlManager.mo37235g());
                        return ca;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private double m37666a(int widthDp, int heightDp) {
        double d = (double) widthDp;
        double d2 = (double) heightDp;
        Double.isNaN(d);
        Double.isNaN(d2);
        double mediaAspectRatio = d / d2;
        double aspectRatioRatio = mediaAspectRatio / this.f35108c;
        double d3 = (double) (widthDp * heightDp);
        double d4 = (double) this.f35109d;
        Double.isNaN(d3);
        Double.isNaN(d4);
        return (Math.abs(Math.log(aspectRatioRatio)) * 70.0d) + (Math.abs(Math.log(d3 / d4)) * 30.0d);
    }

    /* renamed from: a */
    static boolean m37672a(String sequence) {
        boolean z = true;
        if (TextUtils.isEmpty(sequence)) {
            return true;
        }
        try {
            if (Integer.parseInt(sequence) >= 2) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /* renamed from: b */
    private String m37674b(String redirectUrl) throws IOException {
        Preconditions.checkNotNull(redirectUrl);
        int i = this.f35111f;
        if (i >= 10) {
            return null;
        }
        this.f35111f = i + 1;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(redirectUrl);
            inputStream = new BufferedInputStream(urlConnection.getInputStream());
            return Strings.fromStream(inputStream);
        } finally {
            Streams.closeStream(inputStream);
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
