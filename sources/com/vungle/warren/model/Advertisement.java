package com.vungle.warren.model;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.C10185p;
import com.google.gson.C10191u;
import com.mopub.common.Constants;
import com.vungle.warren.AdConfig;
import com.vungle.warren.persistence.Memorable;
import com.vungle.warren.persistence.MemoryUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Advertisement implements Memorable, Cloneable {
    public static final int DONE = 3;
    public static final int ERROR = 4;
    public static final String KEY_POSTROLL = "postroll";
    public static final String KEY_TEMPLATE = "template";
    public static final String KEY_VIDEO = "video";
    public static final int LANDSCAPE = 1;
    public static final int NEW = 0;
    public static final int PORTRAIT = 0;
    public static final String POSTROLL_UNZIP = "postrollUnzip";
    public static final int READY = 1;
    public static final int ROTATE = 2;
    private static final String TAG = "Advertisement";
    public static final int TYPE_VUNGLE_LOCAL = 0;
    public static final int TYPE_VUNGLE_MRAID = 1;
    public static final int VIEWING = 2;
    private AdConfig adConfig;
    private final String adMarketId;
    private final String adToken;
    @AdType
    private final int adType;
    private final String appID;
    private final String bidToken;
    private final Map<String, String> cacheableReplacements;
    private final String campaign;
    private final ArrayList<Checkpoint> checkpoints;
    private final String[] clickUrls;
    private final String[] closeUrls;
    private final int countdown;
    private final int ctaClickArea;
    private final String ctaDestinationUrl;
    private final boolean ctaOverlayEnabled;
    private final boolean ctaShowOnClick;
    private final int ctaTimeEnabled;
    private final int ctaTimeShow;
    private final String ctaUrl;
    private final int delay;
    private final boolean enableMoat;
    private final long expireTime;
    private final String identifier;
    private final String md5;
    private final String moatExtraVast;
    private final String[] muteUrls;
    private final String[] postRollClickUrls;
    private final String[] postRollViewUrls;
    private final String postrollBundleUrl;
    private final boolean requiresNonMarketInstall;
    private final int retryCount;
    private final int showCloseDelay;
    private final int showCloseIncentivized;
    private int state = 0;
    private final String templateId;
    private final Map<String, String> templateSettings;
    private final String templateType;
    private final String templateUrl;
    private final String[] unmuteUrls;
    private final int videoHeight;
    private final String videoIdentifier;
    private final String videoUrl;
    private final int videoWidth;

    public @interface AdType {
    }

    public @interface CacheKey {
    }

    public @interface Orientation {
    }

    public @interface State {
    }

    public static class Checkpoint implements Comparable<Checkpoint>, Memorable {
        private final byte percentage;
        private final String[] urls;

        public Checkpoint(byte[] array) {
            ByteBuffer buffy = ByteBuffer.wrap(array);
            this.percentage = buffy.get();
            this.urls = MemoryUtils.extractStringArray(buffy);
        }

        public Checkpoint(C10191u json) throws IllegalArgumentException {
            String str = "checkpoint";
            if (json.mo33473d(str)) {
                this.percentage = (byte) ((int) (json.mo33466a(str).mo33434b() * 100.0f));
                String str2 = Constants.VIDEO_TRACKING_URLS_KEY;
                if (JsonUtil.hasNonNull(json, str2)) {
                    C10185p urlsArray = json.mo33471b(str2);
                    this.urls = new String[urlsArray.size()];
                    for (int x = 0; x < urlsArray.size(); x++) {
                        if (urlsArray.get(x) != null) {
                            if (!"null".equalsIgnoreCase(urlsArray.get(x).toString())) {
                                this.urls[x] = urlsArray.get(x).mo33439h();
                            }
                        }
                        this.urls[x] = "";
                    }
                    return;
                }
                throw new IllegalArgumentException("Checkpoint missing reporting URL!");
            }
            throw new IllegalArgumentException("Checkpoint missing percentage!");
        }

        public Checkpoint(C10185p urlsArray, byte percentage2) {
            if (urlsArray.size() != 0) {
                this.urls = new String[urlsArray.size()];
                for (int x = 0; x < urlsArray.size(); x++) {
                    this.urls[x] = urlsArray.get(x).mo33439h();
                }
                this.percentage = percentage2;
                return;
            }
            throw new IllegalArgumentException("Empty URLS!");
        }

        public String[] getUrls() {
            return this.urls;
        }

        public byte getPercentage() {
            return this.percentage;
        }

        public int compareTo(Checkpoint o) {
            return Float.compare((float) this.percentage, (float) o.percentage);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Checkpoint)) {
                return false;
            }
            Checkpoint wrap = (Checkpoint) obj;
            if (wrap.percentage != this.percentage || wrap.urls.length != this.urls.length) {
                return false;
            }
            int x = 0;
            while (true) {
                String[] strArr = this.urls;
                if (x >= strArr.length) {
                    return true;
                }
                if (!wrap.urls[x].equals(strArr[x])) {
                    return false;
                }
                x++;
            }
        }

        public int hashCode() {
            return super.hashCode();
        }

        public byte[] toByteArray() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                out.write(this.percentage);
                MemoryUtils.writeStringArray(this.urls, out);
                return out.toByteArray();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to write ");
                sb.append(this);
                sb.append(" to a byte array");
                Log.e("Advertisement.java", sb.toString());
                return new byte[0];
            }
        }

        public String getId() {
            return "checkpoint";
        }
    }

    public Advertisement(byte[] array) {
        boolean z = false;
        if (array.length != 0) {
            ByteBuffer buffy = ByteBuffer.wrap(array);
            this.adConfig = new AdConfig();
            this.adType = buffy.getInt();
            this.expireTime = buffy.getLong();
            this.delay = buffy.getInt();
            this.showCloseDelay = buffy.getInt();
            this.showCloseIncentivized = buffy.getInt();
            this.countdown = buffy.getInt();
            this.videoWidth = buffy.getInt();
            this.videoHeight = buffy.getInt();
            this.ctaOverlayEnabled = buffy.get() == 1;
            this.ctaShowOnClick = buffy.get() == 1;
            this.ctaTimeEnabled = buffy.getInt();
            this.ctaTimeShow = buffy.getInt();
            this.ctaClickArea = buffy.getInt();
            this.retryCount = buffy.getInt();
            this.enableMoat = buffy.get() == 1;
            this.requiresNonMarketInstall = buffy.get() == 1;
            int settings = buffy.getInt();
            int flexCloseSec = buffy.getInt();
            int ordinalCount = buffy.getInt();
            this.adConfig.setFlexViewCloseTime(flexCloseSec);
            this.adConfig.setOrdinal(ordinalCount);
            this.adConfig.setAutoRotate((settings & 16) == 16);
            this.adConfig.setImmersiveMode((settings & 4) == 4);
            this.adConfig.setMuted((settings & 1) == 1);
            Map<String, Object> extras = new HashMap<>();
            extras.put(AdConfig.FLAG_DIRECT_DOWNLOAD, Boolean.valueOf((settings & 32) == 32));
            this.adConfig.setExtraSettings(extras);
            AdConfig adConfig2 = this.adConfig;
            if ((settings & 8) == 8) {
                z = true;
            }
            adConfig2.setTransitionAnimationEnabled(z);
            this.identifier = MemoryUtils.extractString(buffy);
            this.appID = MemoryUtils.extractString(buffy);
            this.campaign = MemoryUtils.extractString(buffy);
            this.videoUrl = MemoryUtils.extractString(buffy);
            this.md5 = MemoryUtils.extractString(buffy);
            this.postrollBundleUrl = MemoryUtils.extractString(buffy);
            this.ctaDestinationUrl = MemoryUtils.extractString(buffy);
            this.ctaUrl = MemoryUtils.extractString(buffy);
            this.adToken = MemoryUtils.extractString(buffy);
            this.videoIdentifier = MemoryUtils.extractString(buffy);
            this.muteUrls = MemoryUtils.extractStringArray(buffy);
            this.unmuteUrls = MemoryUtils.extractStringArray(buffy);
            this.closeUrls = MemoryUtils.extractStringArray(buffy);
            this.postRollClickUrls = MemoryUtils.extractStringArray(buffy);
            this.postRollViewUrls = MemoryUtils.extractStringArray(buffy);
            this.clickUrls = MemoryUtils.extractStringArray(buffy);
            this.templateUrl = MemoryUtils.extractString(buffy);
            this.templateId = MemoryUtils.extractString(buffy);
            this.templateType = MemoryUtils.extractString(buffy);
            this.moatExtraVast = MemoryUtils.extractString(buffy);
            this.adMarketId = MemoryUtils.extractString(buffy);
            this.bidToken = MemoryUtils.extractString(buffy);
            int checkpointCount = buffy.getInt();
            this.checkpoints = new ArrayList<>(checkpointCount);
            int x = 0;
            while (x < checkpointCount) {
                try {
                    this.checkpoints.add(MemoryUtils.extractMemorable(buffy, Checkpoint.class));
                    x++;
                } catch (NoSuchMethodException noMethod) {
                    throw new RuntimeException(noMethod);
                } catch (IllegalAccessException ignored) {
                    throw new RuntimeException(ignored);
                } catch (InstantiationException ignored2) {
                    throw new RuntimeException(ignored2);
                } catch (InvocationTargetException ignored3) {
                    throw new RuntimeException(ignored3);
                }
            }
            this.templateSettings = MemoryUtils.extractStringMap(buffy);
            this.cacheableReplacements = MemoryUtils.extractStringMap(buffy);
            this.state = buffy.getInt();
            return;
        }
        throw new IllegalArgumentException("Empty array cannot be used to construct Advertisement");
    }

    public boolean isCtaOverlayEnabled() {
        return this.ctaOverlayEnabled;
    }

    public boolean isCtaShowOnClick() {
        return this.ctaShowOnClick;
    }

    public int getCtaTimeEnabled() {
        return this.ctaTimeEnabled * 1000;
    }

    public int getCtaTimeShow() {
        return this.ctaTimeShow * 1000;
    }

    public int getCtaClickArea() {
        int i = this.ctaClickArea;
        if (i >= 1) {
            return i;
        }
        return 1;
    }

    public boolean isRequiresNonMarketInstall() {
        return this.requiresNonMarketInstall;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x06fb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Advertisement(com.google.gson.C10191u r18) throws java.lang.IllegalArgumentException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r17.<init>()
            r2 = 0
            r0.state = r2
            java.lang.String r3 = "ad_markup"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r1, r3)
            if (r4 == 0) goto L_0x070b
            com.google.gson.u r3 = r1.mo33472c(r3)
            java.lang.String r4 = "adType"
            boolean r5 = r3.mo33473d(r4)
            if (r5 == 0) goto L_0x0703
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            int r5 = r4.hashCode()
            r6 = -1852456483(0xffffffff9195c1dd, float:-2.3627532E-28)
            r8 = 1
            if (r5 == r6) goto L_0x0040
            r6 = -1851445271(0xffffffff91a52fe9, float:-2.6061937E-28)
            if (r5 == r6) goto L_0x0036
        L_0x0035:
            goto L_0x004a
        L_0x0036:
            java.lang.String r5 = "vungle_mraid"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0035
            r5 = 1
            goto L_0x004b
        L_0x0040:
            java.lang.String r5 = "vungle_local"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0035
            r5 = 0
            goto L_0x004b
        L_0x004a:
            r5 = -1
        L_0x004b:
            java.lang.String r6 = "url"
            java.lang.String r9 = ""
            if (r5 == 0) goto L_0x01a0
            if (r5 != r8) goto L_0x0184
            r0.adType = r8
            r0.postrollBundleUrl = r9
            java.lang.String r5 = "templateSettings"
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r5)
            if (r10 == 0) goto L_0x017c
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r0.templateSettings = r10
            com.google.gson.u r5 = r3.mo33472c(r5)
            java.lang.String r10 = "normal_replacements"
            boolean r11 = com.vungle.warren.model.JsonUtil.hasNonNull(r5, r10)
            if (r11 == 0) goto L_0x009e
            com.google.gson.u r10 = r5.mo33472c(r10)
            java.util.Set r11 = r10.mo33476m()
            java.util.Iterator r11 = r11.iterator()
        L_0x007e:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x009e
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.util.Map<java.lang.String, java.lang.String> r13 = r0.templateSettings
            java.lang.Object r14 = r12.getKey()
            java.lang.Object r15 = r12.getValue()
            com.google.gson.s r15 = (com.google.gson.C10188s) r15
            java.lang.String r15 = r15.mo33439h()
            r13.put(r14, r15)
            goto L_0x007e
        L_0x009e:
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r0.cacheableReplacements = r10
            java.lang.String r10 = "cacheable_replacements"
            boolean r11 = com.vungle.warren.model.JsonUtil.hasNonNull(r5, r10)
            if (r11 == 0) goto L_0x0128
            com.google.gson.u r10 = r5.mo33472c(r10)
            java.util.Set r11 = r10.mo33476m()
            java.util.Iterator r11 = r11.iterator()
        L_0x00b9:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0128
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r13 = r12.getValue()
            com.google.gson.s r13 = (com.google.gson.C10188s) r13
            boolean r13 = com.vungle.warren.model.JsonUtil.hasNonNull(r13, r6)
            if (r13 == 0) goto L_0x0126
            java.lang.Object r13 = r12.getValue()
            com.google.gson.s r13 = (com.google.gson.C10188s) r13
            java.lang.String r14 = "extension"
            boolean r13 = com.vungle.warren.model.JsonUtil.hasNonNull(r13, r14)
            if (r13 == 0) goto L_0x0126
            java.lang.Object r13 = r12.getValue()
            com.google.gson.s r13 = (com.google.gson.C10188s) r13
            com.google.gson.u r13 = r13.mo33445e()
            com.google.gson.s r13 = r13.mo33466a(r6)
            java.lang.String r13 = r13.mo33439h()
            java.lang.Object r14 = r12.getValue()
            com.google.gson.s r14 = (com.google.gson.C10188s) r14
            com.google.gson.u r14 = r14.mo33445e()
            java.lang.String r15 = "extension"
            com.google.gson.s r14 = r14.mo33466a(r15)
            java.lang.String r14 = r14.mo33439h()
            java.util.Map<java.lang.String, java.lang.String> r15 = r0.cacheableReplacements
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.Object r16 = r12.getKey()
            r8 = r16
            java.lang.String r8 = (java.lang.String) r8
            r7.append(r8)
            java.lang.String r8 = "."
            r7.append(r8)
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            r15.put(r7, r13)
        L_0x0126:
            r8 = 1
            goto L_0x00b9
        L_0x0128:
            java.lang.String r5 = "templateId"
            boolean r7 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r5)
            if (r7 == 0) goto L_0x0174
            com.google.gson.s r5 = r3.mo33466a(r5)
            java.lang.String r5 = r5.mo33439h()
            r0.templateId = r5
            java.lang.String r5 = "template_type"
            boolean r5 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r5)
            if (r5 == 0) goto L_0x016c
            java.lang.String r5 = "template_type"
            com.google.gson.s r5 = r3.mo33466a(r5)
            java.lang.String r5 = r5.mo33439h()
            r0.templateType = r5
            java.lang.String r5 = "templateURL"
            boolean r5 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r5)
            if (r5 == 0) goto L_0x0164
            java.lang.String r5 = "templateURL"
            com.google.gson.s r5 = r3.mo33466a(r5)
            java.lang.String r5 = r5.mo33439h()
            r0.templateUrl = r5
            goto L_0x01cb
        L_0x0164:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Template URL missing!"
            r2.<init>(r5)
            throw r2
        L_0x016c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Template Type missing!"
            r2.<init>(r5)
            throw r2
        L_0x0174:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Missing templateID!"
            r2.<init>(r5)
            throw r2
        L_0x017c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Missing template adConfig!"
            r2.<init>(r5)
            throw r2
        L_0x0184:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unknown Ad Type "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r6 = "! Please add this ad type"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r2.<init>(r5)
            throw r2
        L_0x01a0:
            r0.adType = r2
            java.lang.String r5 = "postBundle"
            boolean r7 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r5)
            if (r7 == 0) goto L_0x01b3
            com.google.gson.s r5 = r3.mo33466a(r5)
            java.lang.String r5 = r5.mo33439h()
            goto L_0x01b4
        L_0x01b3:
            r5 = r9
        L_0x01b4:
            r0.postrollBundleUrl = r5
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.templateSettings = r5
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.cacheableReplacements = r5
            r0.templateUrl = r9
            r0.templateId = r9
            r0.templateType = r9
        L_0x01cb:
            java.lang.String r4 = "id"
            boolean r5 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r4)
            if (r5 == 0) goto L_0x06fb
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            r0.identifier = r4
            java.lang.String r4 = "campaign"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r4)
            if (r4 == 0) goto L_0x06f3
            java.lang.String r4 = "campaign"
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            r0.campaign = r4
            java.lang.String r4 = "app_id"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r4)
            if (r4 == 0) goto L_0x06eb
            java.lang.String r4 = "app_id"
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            r0.appID = r4
            java.lang.String r4 = "expiry"
            boolean r5 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r4)
            if (r5 == 0) goto L_0x0233
            com.google.gson.s r5 = r3.mo33466a(r4)
            boolean r5 = r5.mo33448j()
            if (r5 != 0) goto L_0x0233
            com.google.gson.s r4 = r3.mo33466a(r4)
            long r4 = r4.mo33437g()
            r7 = 0
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0229
            r0.expireTime = r4
            goto L_0x0232
        L_0x0229:
            long r7 = java.lang.System.currentTimeMillis()
            r10 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r10
            r0.expireTime = r7
        L_0x0232:
            goto L_0x023c
        L_0x0233:
            long r4 = java.lang.System.currentTimeMillis()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r7
            r0.expireTime = r4
        L_0x023c:
            java.lang.String r4 = "tpat"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r4)
            if (r4 == 0) goto L_0x04b1
            java.lang.String r4 = "tpat"
            com.google.gson.u r4 = r3.mo33472c(r4)
            java.util.ArrayList r5 = new java.util.ArrayList
            r7 = 5
            r5.<init>(r7)
            r0.checkpoints = r5
            int r5 = r0.adType
            if (r5 == 0) goto L_0x0294
            r7 = 1
            if (r5 != r7) goto L_0x028c
            r5 = 0
            r7 = 0
        L_0x025b:
            r8 = 5
            if (r7 >= r8) goto L_0x028b
            int r8 = r7 * 25
            java.util.Locale r10 = java.util.Locale.ENGLISH
            r11 = 1
            java.lang.Object[] r12 = new java.lang.Object[r11]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
            r12[r2] = r11
            java.lang.String r11 = "checkpoint.%d"
            java.lang.String r5 = java.lang.String.format(r10, r11, r12)
            r10 = 0
            boolean r11 = r4.mo33473d(r5)
            if (r11 == 0) goto L_0x0283
            com.vungle.warren.model.Advertisement$Checkpoint r11 = new com.vungle.warren.model.Advertisement$Checkpoint
            com.google.gson.p r12 = r4.mo33471b(r5)
            byte r13 = (byte) r8
            r11.<init>(r12, r13)
            r10 = r11
        L_0x0283:
            java.util.ArrayList<com.vungle.warren.model.Advertisement$Checkpoint> r11 = r0.checkpoints
            r11.add(r7, r10)
            int r7 = r7 + 1
            goto L_0x025b
        L_0x028b:
            goto L_0x02c3
        L_0x028c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Unknown Ad Type!"
            r2.<init>(r5)
            throw r2
        L_0x0294:
            java.lang.String r5 = "play_percentage"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x02c3
            java.lang.String r5 = "play_percentage"
            com.google.gson.p r5 = r4.mo33471b(r5)
            r7 = 0
        L_0x02a3:
            int r8 = r5.size()
            if (r7 >= r8) goto L_0x02be
            java.util.ArrayList<com.vungle.warren.model.Advertisement$Checkpoint> r8 = r0.checkpoints
            com.vungle.warren.model.Advertisement$Checkpoint r10 = new com.vungle.warren.model.Advertisement$Checkpoint
            com.google.gson.s r11 = r5.get(r7)
            com.google.gson.u r11 = r11.mo33445e()
            r10.<init>(r11)
            r8.add(r10)
            int r7 = r7 + 1
            goto L_0x02a3
        L_0x02be:
            java.util.ArrayList<com.vungle.warren.model.Advertisement$Checkpoint> r7 = r0.checkpoints
            java.util.Collections.sort(r7)
        L_0x02c3:
            java.lang.String r5 = "clickUrl"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x02f7
            java.lang.String r5 = "clickUrl"
            com.google.gson.p r5 = r4.mo33471b(r5)
            int r7 = r5.size()
            java.lang.String[] r7 = new java.lang.String[r7]
            r0.clickUrls = r7
            r7 = 0
            java.util.Iterator r8 = r5.iterator()
        L_0x02de:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x02f6
            java.lang.Object r10 = r8.next()
            com.google.gson.s r10 = (com.google.gson.C10188s) r10
            java.lang.String[] r11 = r0.clickUrls
            int r12 = r7 + 1
            java.lang.String r13 = r10.mo33439h()
            r11[r7] = r13
            r7 = r12
            goto L_0x02de
        L_0x02f6:
            goto L_0x02fb
        L_0x02f7:
            java.lang.String[] r5 = new java.lang.String[r2]
            r0.clickUrls = r5
        L_0x02fb:
            java.lang.String r5 = "moat"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x0322
            java.lang.String r5 = "moat"
            com.google.gson.u r5 = r4.mo33472c(r5)
            java.lang.String r7 = "is_enabled"
            com.google.gson.s r7 = r5.mo33466a(r7)
            boolean r7 = r7.mo33433a()
            r0.enableMoat = r7
            java.lang.String r7 = "extra_vast"
            com.google.gson.s r7 = r5.mo33466a(r7)
            java.lang.String r7 = r7.mo33439h()
            r0.moatExtraVast = r7
            goto L_0x0326
        L_0x0322:
            r0.enableMoat = r2
            r0.moatExtraVast = r9
        L_0x0326:
            int r5 = r0.adType
            if (r5 == 0) goto L_0x0340
            r7 = 1
            if (r5 != r7) goto L_0x0338
            java.lang.String r5 = "video.mute"
            java.lang.String r7 = "video.unmute"
            java.lang.String r8 = "video.close"
            java.lang.String r10 = "postroll.click"
            java.lang.String r11 = "postroll.view"
            goto L_0x034b
        L_0x0338:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Unknown AdType!"
            r2.<init>(r5)
            throw r2
        L_0x0340:
            java.lang.String r5 = "mute"
            java.lang.String r7 = "unmute"
            java.lang.String r8 = "video_close"
            java.lang.String r10 = "postroll_click"
            java.lang.String r11 = "postroll_view"
        L_0x034b:
            boolean r12 = com.vungle.warren.model.JsonUtil.hasNonNull(r4, r5)
            java.lang.String r13 = "null"
            if (r12 == 0) goto L_0x0390
            com.google.gson.p r12 = r4.mo33471b(r5)
            int r14 = r12.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            r0.muteUrls = r14
            r14 = 0
        L_0x0360:
            int r15 = r12.size()
            if (r14 >= r15) goto L_0x038f
            com.google.gson.s r15 = r12.get(r14)
            if (r15 == 0) goto L_0x0388
            com.google.gson.s r15 = r12.get(r14)
            java.lang.String r15 = r15.toString()
            boolean r15 = r13.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x037b
            goto L_0x0388
        L_0x037b:
            java.lang.String[] r15 = r0.muteUrls
            com.google.gson.s r16 = r12.get(r14)
            java.lang.String r16 = r16.mo33439h()
            r15[r14] = r16
            goto L_0x038c
        L_0x0388:
            java.lang.String[] r15 = r0.muteUrls
            r15[r14] = r9
        L_0x038c:
            int r14 = r14 + 1
            goto L_0x0360
        L_0x038f:
            goto L_0x0394
        L_0x0390:
            java.lang.String[] r12 = new java.lang.String[r2]
            r0.muteUrls = r12
        L_0x0394:
            boolean r12 = com.vungle.warren.model.JsonUtil.hasNonNull(r4, r7)
            if (r12 == 0) goto L_0x03d7
            com.google.gson.p r12 = r4.mo33471b(r7)
            int r14 = r12.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            r0.unmuteUrls = r14
            r14 = 0
        L_0x03a7:
            int r15 = r12.size()
            if (r14 >= r15) goto L_0x03d6
            com.google.gson.s r15 = r12.get(r14)
            if (r15 == 0) goto L_0x03cf
            com.google.gson.s r15 = r12.get(r14)
            java.lang.String r15 = r15.toString()
            boolean r15 = r13.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x03c2
            goto L_0x03cf
        L_0x03c2:
            java.lang.String[] r15 = r0.unmuteUrls
            com.google.gson.s r16 = r12.get(r14)
            java.lang.String r16 = r16.mo33439h()
            r15[r14] = r16
            goto L_0x03d3
        L_0x03cf:
            java.lang.String[] r15 = r0.unmuteUrls
            r15[r14] = r9
        L_0x03d3:
            int r14 = r14 + 1
            goto L_0x03a7
        L_0x03d6:
            goto L_0x03db
        L_0x03d7:
            java.lang.String[] r12 = new java.lang.String[r2]
            r0.unmuteUrls = r12
        L_0x03db:
            boolean r12 = com.vungle.warren.model.JsonUtil.hasNonNull(r4, r8)
            if (r12 == 0) goto L_0x041e
            com.google.gson.p r12 = r4.mo33471b(r8)
            int r14 = r12.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            r0.closeUrls = r14
            r14 = 0
        L_0x03ee:
            int r15 = r12.size()
            if (r14 >= r15) goto L_0x041d
            com.google.gson.s r15 = r12.get(r14)
            if (r15 == 0) goto L_0x0416
            com.google.gson.s r15 = r12.get(r14)
            java.lang.String r15 = r15.toString()
            boolean r15 = r13.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x0409
            goto L_0x0416
        L_0x0409:
            java.lang.String[] r15 = r0.closeUrls
            com.google.gson.s r16 = r12.get(r14)
            java.lang.String r16 = r16.mo33439h()
            r15[r14] = r16
            goto L_0x041a
        L_0x0416:
            java.lang.String[] r15 = r0.closeUrls
            r15[r14] = r9
        L_0x041a:
            int r14 = r14 + 1
            goto L_0x03ee
        L_0x041d:
            goto L_0x0422
        L_0x041e:
            java.lang.String[] r12 = new java.lang.String[r2]
            r0.closeUrls = r12
        L_0x0422:
            boolean r12 = com.vungle.warren.model.JsonUtil.hasNonNull(r4, r10)
            if (r12 == 0) goto L_0x0465
            com.google.gson.p r12 = r4.mo33471b(r10)
            int r14 = r12.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            r0.postRollClickUrls = r14
            r14 = 0
        L_0x0435:
            int r15 = r12.size()
            if (r14 >= r15) goto L_0x0464
            com.google.gson.s r15 = r12.get(r14)
            if (r15 == 0) goto L_0x045d
            com.google.gson.s r15 = r12.get(r14)
            java.lang.String r15 = r15.toString()
            boolean r15 = r13.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x0450
            goto L_0x045d
        L_0x0450:
            java.lang.String[] r15 = r0.postRollClickUrls
            com.google.gson.s r16 = r12.get(r14)
            java.lang.String r16 = r16.mo33439h()
            r15[r14] = r16
            goto L_0x0461
        L_0x045d:
            java.lang.String[] r15 = r0.postRollClickUrls
            r15[r14] = r9
        L_0x0461:
            int r14 = r14 + 1
            goto L_0x0435
        L_0x0464:
            goto L_0x0469
        L_0x0465:
            java.lang.String[] r12 = new java.lang.String[r2]
            r0.postRollClickUrls = r12
        L_0x0469:
            boolean r12 = com.vungle.warren.model.JsonUtil.hasNonNull(r4, r11)
            if (r12 == 0) goto L_0x04ac
            com.google.gson.p r12 = r4.mo33471b(r11)
            int r14 = r12.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            r0.postRollViewUrls = r14
            r14 = 0
        L_0x047c:
            int r15 = r12.size()
            if (r14 >= r15) goto L_0x04ab
            com.google.gson.s r15 = r12.get(r14)
            if (r15 == 0) goto L_0x04a4
            com.google.gson.s r15 = r12.get(r14)
            java.lang.String r15 = r15.toString()
            boolean r15 = r13.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x0497
            goto L_0x04a4
        L_0x0497:
            java.lang.String[] r15 = r0.postRollViewUrls
            com.google.gson.s r16 = r12.get(r14)
            java.lang.String r16 = r16.mo33439h()
            r15[r14] = r16
            goto L_0x04a8
        L_0x04a4:
            java.lang.String[] r15 = r0.postRollViewUrls
            r15[r14] = r9
        L_0x04a8:
            int r14 = r14 + 1
            goto L_0x047c
        L_0x04ab:
            goto L_0x04b0
        L_0x04ac:
            java.lang.String[] r12 = new java.lang.String[r2]
            r0.postRollViewUrls = r12
        L_0x04b0:
            goto L_0x04d4
        L_0x04b1:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0.checkpoints = r4
            java.lang.String[] r4 = new java.lang.String[r2]
            r0.muteUrls = r4
            java.lang.String[] r4 = new java.lang.String[r2]
            r0.closeUrls = r4
            java.lang.String[] r4 = new java.lang.String[r2]
            r0.unmuteUrls = r4
            java.lang.String[] r4 = new java.lang.String[r2]
            r0.postRollViewUrls = r4
            java.lang.String[] r4 = new java.lang.String[r2]
            r0.postRollClickUrls = r4
            java.lang.String[] r4 = new java.lang.String[r2]
            r0.clickUrls = r4
            r0.enableMoat = r2
            r0.moatExtraVast = r9
        L_0x04d4:
            java.lang.String r4 = "delay"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x04e9
            java.lang.String r4 = "delay"
            com.google.gson.s r4 = r3.mo33466a(r4)
            int r4 = r4.mo33435c()
            r0.delay = r4
            goto L_0x04eb
        L_0x04e9:
            r0.delay = r2
        L_0x04eb:
            java.lang.String r4 = "showClose"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x0500
            java.lang.String r4 = "showClose"
            com.google.gson.s r4 = r3.mo33466a(r4)
            int r4 = r4.mo33435c()
            r0.showCloseDelay = r4
            goto L_0x0502
        L_0x0500:
            r0.showCloseDelay = r2
        L_0x0502:
            java.lang.String r4 = "showCloseIncentivized"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x0517
            java.lang.String r4 = "showCloseIncentivized"
            com.google.gson.s r4 = r3.mo33466a(r4)
            int r4 = r4.mo33435c()
            r0.showCloseIncentivized = r4
            goto L_0x0519
        L_0x0517:
            r0.showCloseIncentivized = r2
        L_0x0519:
            java.lang.String r4 = "countdown"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x052e
            java.lang.String r4 = "countdown"
            com.google.gson.s r4 = r3.mo33466a(r4)
            int r4 = r4.mo33435c()
            r0.countdown = r4
            goto L_0x0530
        L_0x052e:
            r0.countdown = r2
        L_0x0530:
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r6)
            if (r4 == 0) goto L_0x06e3
            com.google.gson.s r4 = r3.mo33466a(r6)
            java.lang.String r4 = r4.mo33439h()
            r0.videoUrl = r4
            java.lang.String r4 = "videoWidth"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x06db
            java.lang.String r4 = "videoWidth"
            com.google.gson.s r4 = r3.mo33466a(r4)
            int r4 = r4.mo33435c()
            r0.videoWidth = r4
            java.lang.String r4 = "videoHeight"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x06d3
            java.lang.String r4 = "videoHeight"
            com.google.gson.s r4 = r3.mo33466a(r4)
            int r4 = r4.mo33435c()
            r0.videoHeight = r4
            java.lang.String r4 = "md5"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x057d
            java.lang.String r4 = "md5"
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            r0.md5 = r4
            goto L_0x057f
        L_0x057d:
            r0.md5 = r9
        L_0x057f:
            java.lang.String r4 = "cta_overlay"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x0604
            java.lang.String r4 = "cta_overlay"
            com.google.gson.u r4 = r3.mo33472c(r4)
            java.lang.String r5 = "enabled"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x05a2
            java.lang.String r5 = "enabled"
            com.google.gson.s r5 = r4.mo33466a(r5)
            boolean r5 = r5.mo33433a()
            r0.ctaOverlayEnabled = r5
            goto L_0x05a4
        L_0x05a2:
            r0.ctaOverlayEnabled = r2
        L_0x05a4:
            java.lang.String r5 = "show_onclick"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x05b9
            java.lang.String r5 = "show_onclick"
            com.google.gson.s r5 = r4.mo33466a(r5)
            boolean r5 = r5.mo33433a()
            r0.ctaShowOnClick = r5
            goto L_0x05bb
        L_0x05b9:
            r0.ctaShowOnClick = r2
        L_0x05bb:
            java.lang.String r5 = "time_enabled"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x05d0
            java.lang.String r5 = "time_enabled"
            com.google.gson.s r5 = r4.mo33466a(r5)
            int r5 = r5.mo33435c()
            r0.ctaTimeEnabled = r5
            goto L_0x05d3
        L_0x05d0:
            r5 = -1
            r0.ctaTimeEnabled = r5
        L_0x05d3:
            java.lang.String r5 = "click_area"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x05e8
            java.lang.String r5 = "click_area"
            com.google.gson.s r5 = r4.mo33466a(r5)
            int r5 = r5.mo33435c()
            r0.ctaClickArea = r5
            goto L_0x05eb
        L_0x05e8:
            r5 = -1
            r0.ctaClickArea = r5
        L_0x05eb:
            java.lang.String r5 = "time_show"
            boolean r5 = r4.mo33473d(r5)
            if (r5 == 0) goto L_0x0600
            java.lang.String r5 = "time_show"
            com.google.gson.s r5 = r4.mo33466a(r5)
            int r5 = r5.mo33435c()
            r0.ctaTimeShow = r5
            goto L_0x0603
        L_0x0600:
            r5 = -1
            r0.ctaTimeShow = r5
        L_0x0603:
            goto L_0x060f
        L_0x0604:
            r5 = -1
            r0.ctaOverlayEnabled = r2
            r0.ctaClickArea = r5
            r0.ctaTimeEnabled = r5
            r0.ctaTimeShow = r5
            r0.ctaShowOnClick = r2
        L_0x060f:
            java.lang.String r4 = "callToActionDest"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r4)
            if (r4 == 0) goto L_0x0622
            java.lang.String r4 = "callToActionDest"
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            goto L_0x0623
        L_0x0622:
            r4 = 0
        L_0x0623:
            r0.ctaDestinationUrl = r4
            java.lang.String r4 = "callToActionUrl"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r3, r4)
            if (r4 == 0) goto L_0x0638
            java.lang.String r4 = "callToActionUrl"
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            goto L_0x0639
        L_0x0638:
            r4 = 0
        L_0x0639:
            r0.ctaUrl = r4
            java.lang.String r4 = "retryCount"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x0650
            java.lang.String r4 = "retryCount"
            com.google.gson.s r4 = r3.mo33466a(r4)
            int r4 = r4.mo33435c()
            r0.retryCount = r4
            goto L_0x0653
        L_0x0650:
            r4 = 1
            r0.retryCount = r4
        L_0x0653:
            java.lang.String r4 = "ad_token"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x06cb
            java.lang.String r4 = "ad_token"
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            r0.adToken = r4
            java.lang.String r4 = "video_object_id"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x067c
            java.lang.String r4 = "video_object_id"
            com.google.gson.s r4 = r3.mo33466a(r4)
            java.lang.String r4 = r4.mo33439h()
            r0.videoIdentifier = r4
            goto L_0x067e
        L_0x067c:
            r0.videoIdentifier = r9
        L_0x067e:
            java.lang.String r4 = "requires_sideloading"
            boolean r4 = r3.mo33473d(r4)
            if (r4 == 0) goto L_0x0693
            java.lang.String r2 = "requires_sideloading"
            com.google.gson.s r2 = r3.mo33466a(r2)
            boolean r2 = r2.mo33433a()
            r0.requiresNonMarketInstall = r2
            goto L_0x0695
        L_0x0693:
            r0.requiresNonMarketInstall = r2
        L_0x0695:
            java.lang.String r2 = "ad_market_id"
            boolean r2 = r3.mo33473d(r2)
            if (r2 == 0) goto L_0x06aa
            java.lang.String r2 = "ad_market_id"
            com.google.gson.s r2 = r3.mo33466a(r2)
            java.lang.String r2 = r2.mo33439h()
            r0.adMarketId = r2
            goto L_0x06ac
        L_0x06aa:
            r0.adMarketId = r9
        L_0x06ac:
            java.lang.String r2 = "bid_token"
            boolean r2 = r3.mo33473d(r2)
            if (r2 == 0) goto L_0x06c1
            java.lang.String r2 = "bid_token"
            com.google.gson.s r2 = r3.mo33466a(r2)
            java.lang.String r2 = r2.mo33439h()
            r0.bidToken = r2
            goto L_0x06c3
        L_0x06c1:
            r0.bidToken = r9
        L_0x06c3:
            com.vungle.warren.AdConfig r2 = new com.vungle.warren.AdConfig
            r2.<init>()
            r0.adConfig = r2
            return
        L_0x06cb:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "AdToken missing!"
            r2.<init>(r4)
            throw r2
        L_0x06d3:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Missing video height!"
            r2.<init>(r4)
            throw r2
        L_0x06db:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Missing video width!"
            r2.<init>(r4)
            throw r2
        L_0x06e3:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Missing video URL!"
            r2.<init>(r4)
            throw r2
        L_0x06eb:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Missing app Id, cannot process advertisement!"
            r2.<init>(r4)
            throw r2
        L_0x06f3:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Missing campaign information, cannot process advertisement!"
            r2.<init>(r4)
            throw r2
        L_0x06fb:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Missing identifier, cannot process advertisement!"
            r2.<init>(r4)
            throw r2
        L_0x0703:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Advertisement did not contain an adType!"
            r2.<init>(r4)
            throw r2
        L_0x070b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "JSON does not contain ad markup!"
            r2.<init>(r3)
            goto L_0x0714
        L_0x0713:
            throw r2
        L_0x0714:
            goto L_0x0713
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.<init>(com.google.gson.u):void");
    }

    @AdType
    public int getAdType() {
        return this.adType;
    }

    public List<Checkpoint> getCheckpoints() {
        return this.checkpoints;
    }

    public void configure(AdConfig settings) {
        if (settings == null) {
            this.adConfig = new AdConfig();
        } else {
            this.adConfig = settings;
        }
    }

    public AdConfig getAdConfig() {
        return this.adConfig;
    }

    @Orientation
    public int getOrientation() {
        if (this.videoWidth > this.videoHeight) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Advertisement)) {
            return false;
        }
        Advertisement wrap = (Advertisement) obj;
        if (getId() == null || wrap.getId() == null || !wrap.getId().equals(getId()) || wrap.adType != this.adType || wrap.expireTime != this.expireTime || wrap.delay != this.delay || wrap.showCloseDelay != this.showCloseDelay || wrap.showCloseIncentivized != this.showCloseIncentivized || wrap.countdown != this.countdown || wrap.videoWidth != this.videoWidth || wrap.videoHeight != this.videoHeight || wrap.ctaOverlayEnabled != this.ctaOverlayEnabled || wrap.ctaShowOnClick != this.ctaShowOnClick || wrap.ctaTimeEnabled != this.ctaTimeEnabled || wrap.ctaTimeShow != this.ctaTimeShow || wrap.ctaClickArea != this.ctaClickArea || wrap.retryCount != this.retryCount || wrap.enableMoat != this.enableMoat || wrap.requiresNonMarketInstall != this.requiresNonMarketInstall || !wrap.identifier.equals(this.identifier) || !wrap.campaign.equals(this.campaign) || !wrap.videoUrl.equals(this.videoUrl) || !wrap.md5.equals(this.md5) || !wrap.postrollBundleUrl.equals(this.postrollBundleUrl) || !wrap.ctaDestinationUrl.equals(this.ctaDestinationUrl) || !wrap.ctaUrl.equals(this.ctaUrl) || !wrap.adToken.equals(this.adToken) || !wrap.videoIdentifier.equals(this.videoIdentifier) || !wrap.moatExtraVast.equals(this.moatExtraVast) || wrap.state != this.state || wrap.muteUrls.length != this.muteUrls.length) {
            return false;
        }
        int x = 0;
        while (true) {
            String[] strArr = this.muteUrls;
            if (x < strArr.length) {
                if (!wrap.muteUrls[x].equals(strArr[x])) {
                    return false;
                }
                x++;
            } else if (wrap.unmuteUrls.length != this.unmuteUrls.length) {
                return false;
            } else {
                int x2 = 0;
                while (true) {
                    String[] strArr2 = this.unmuteUrls;
                    if (x2 < strArr2.length) {
                        if (!wrap.unmuteUrls[x2].equals(strArr2[x2])) {
                            return false;
                        }
                        x2++;
                    } else if (wrap.closeUrls.length != this.closeUrls.length) {
                        return false;
                    } else {
                        int x3 = 0;
                        while (true) {
                            String[] strArr3 = this.closeUrls;
                            if (x3 < strArr3.length) {
                                if (!wrap.closeUrls[x3].equals(strArr3[x3])) {
                                    return false;
                                }
                                x3++;
                            } else if (wrap.postRollClickUrls.length != this.postRollClickUrls.length) {
                                return false;
                            } else {
                                int x4 = 0;
                                while (true) {
                                    String[] strArr4 = this.postRollClickUrls;
                                    if (x4 < strArr4.length) {
                                        if (!wrap.postRollClickUrls[x4].equals(strArr4[x4])) {
                                            return false;
                                        }
                                        x4++;
                                    } else if (wrap.postRollViewUrls.length != this.postRollViewUrls.length) {
                                        return false;
                                    } else {
                                        int x5 = 0;
                                        while (true) {
                                            String[] strArr5 = this.postRollViewUrls;
                                            if (x5 < strArr5.length) {
                                                if (!wrap.postRollViewUrls[x5].equals(strArr5[x5])) {
                                                    return false;
                                                }
                                                x5++;
                                            } else if (wrap.checkpoints.size() != this.checkpoints.size()) {
                                                return false;
                                            } else {
                                                for (int x6 = 0; x6 < this.checkpoints.size(); x6++) {
                                                    if (!((Checkpoint) wrap.checkpoints.get(x6)).equals(this.checkpoints.get(x6))) {
                                                        return false;
                                                    }
                                                }
                                                if (wrap.adMarketId.equals(this.adMarketId) && wrap.bidToken.equals(this.bidToken)) {
                                                    return true;
                                                }
                                                return false;
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

    public int hashCode() {
        return super.hashCode();
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            out.write(MemoryUtils.toBytes(this.adType));
            out.write(MemoryUtils.toBytes(this.expireTime));
            out.write(MemoryUtils.toBytes(this.delay));
            out.write(MemoryUtils.toBytes(this.showCloseDelay));
            out.write(MemoryUtils.toBytes(this.showCloseIncentivized));
            out.write(MemoryUtils.toBytes(this.countdown));
            out.write(MemoryUtils.toBytes(this.videoWidth));
            out.write(MemoryUtils.toBytes(this.videoHeight));
            int i = 1;
            out.write(this.ctaOverlayEnabled ? 1 : 0);
            out.write(this.ctaShowOnClick ? 1 : 0);
            out.write(MemoryUtils.toBytes(this.ctaTimeEnabled));
            out.write(MemoryUtils.toBytes(this.ctaTimeShow));
            out.write(MemoryUtils.toBytes(this.ctaClickArea));
            out.write(MemoryUtils.toBytes(this.retryCount));
            out.write(this.enableMoat ? 1 : 0);
            if (!this.requiresNonMarketInstall) {
                i = 0;
            }
            out.write(i);
            out.write(MemoryUtils.toBytes(this.adConfig.getSettings()));
            out.write(MemoryUtils.toBytes(this.adConfig.getFlexViewCloseTime()));
            out.write(MemoryUtils.toBytes(this.adConfig.getOrdinal()));
            MemoryUtils.writeString(this.identifier, out);
            MemoryUtils.writeString(this.appID, out);
            MemoryUtils.writeString(this.campaign, out);
            MemoryUtils.writeString(this.videoUrl, out);
            MemoryUtils.writeString(this.md5, out);
            MemoryUtils.writeString(this.postrollBundleUrl, out);
            MemoryUtils.writeString(this.ctaDestinationUrl, out);
            MemoryUtils.writeString(this.ctaUrl, out);
            MemoryUtils.writeString(this.adToken, out);
            MemoryUtils.writeString(this.videoIdentifier, out);
            MemoryUtils.writeStringArray(this.muteUrls, out);
            MemoryUtils.writeStringArray(this.unmuteUrls, out);
            MemoryUtils.writeStringArray(this.closeUrls, out);
            MemoryUtils.writeStringArray(this.postRollClickUrls, out);
            MemoryUtils.writeStringArray(this.postRollViewUrls, out);
            MemoryUtils.writeStringArray(this.clickUrls, out);
            MemoryUtils.writeString(this.templateUrl, out);
            MemoryUtils.writeString(this.templateId, out);
            MemoryUtils.writeString(this.templateType, out);
            MemoryUtils.writeString(this.moatExtraVast, out);
            MemoryUtils.writeString(this.adMarketId, out);
            MemoryUtils.writeString(this.bidToken, out);
            out.write(MemoryUtils.toBytes(this.checkpoints.size()));
            Iterator it = this.checkpoints.iterator();
            while (it.hasNext()) {
                MemoryUtils.writeMemorable((Checkpoint) it.next(), out);
            }
            MemoryUtils.writeStringMap(this.templateSettings, out);
            MemoryUtils.writeStringMap(this.cacheableReplacements, out);
            out.write(MemoryUtils.toBytes(this.state));
            return out.toByteArray();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to write ");
            sb.append(this);
            sb.append(" to a byte array");
            Log.e("Advertisement.java", sb.toString());
            return new byte[0];
        }
    }

    public String[] getTpatUrls(String event) {
        int i = this.adType;
        String str = "Unknown TPAT Event ";
        char c = 65535;
        if (i == 0) {
            switch (event.hashCode()) {
                case -1964722632:
                    if (event.equals("click_url")) {
                        c = 5;
                        break;
                    }
                    break;
                case -840405966:
                    if (event.equals("unmute")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3363353:
                    if (event.equals("mute")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109635558:
                    if (event.equals("postroll_click")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1370606900:
                    if (event.equals("video_close")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1666667655:
                    if (event.equals("postroll_view")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                return this.postRollViewUrls;
            }
            if (c == 1) {
                return this.postRollClickUrls;
            }
            if (c == 2) {
                return this.muteUrls;
            }
            if (c == 3) {
                return this.unmuteUrls;
            }
            if (c == 4) {
                return this.closeUrls;
            }
            if (c == 5) {
                return this.clickUrls;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(event);
            throw new IllegalArgumentException(sb.toString());
        } else if (i != 1) {
            throw new IllegalStateException("Unknown Advertisement Type!");
        } else if (event.startsWith("checkpoint")) {
            String[] ret = new String[0];
            Checkpoint cpoint = (Checkpoint) this.checkpoints.get(Integer.parseInt(event.split("\\.")[1]) / 25);
            if (cpoint != null) {
                ret = cpoint.getUrls();
            }
            return ret;
        } else {
            switch (event.hashCode()) {
                case -1663300692:
                    if (event.equals("video.mute")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1293192841:
                    if (event.equals("postroll.click")) {
                        c = 2;
                        break;
                    }
                    break;
                case -481751803:
                    if (event.equals("video.unmute")) {
                        c = 5;
                        break;
                    }
                    break;
                case -32221499:
                    if (event.equals("video.close")) {
                        c = 0;
                        break;
                    }
                    break;
                case 906443463:
                    if (event.equals("clickUrl")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1621415126:
                    if (event.equals("postroll.view")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                return this.closeUrls;
            }
            if (c == 1) {
                return this.postRollViewUrls;
            }
            if (c == 2) {
                return this.postRollClickUrls;
            }
            if (c == 3) {
                return this.clickUrls;
            }
            if (c == 4) {
                return this.muteUrls;
            }
            if (c == 5) {
                return this.unmuteUrls;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(event);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public String getId() {
        String str = this.identifier;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getAdToken() {
        return this.adToken;
    }

    public String getAppID() {
        return this.appID;
    }

    /* access modifiers changed from: 0000 */
    public String getUrl() {
        return this.videoUrl;
    }

    public String getCampaign() {
        return this.campaign;
    }

    /* access modifiers changed from: 0000 */
    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public int getShowCloseDelay(boolean incentivized) {
        if (incentivized) {
            return this.showCloseIncentivized * 1000;
        }
        return this.showCloseDelay * 1000;
    }

    public boolean getMoatEnabled() {
        return this.enableMoat;
    }

    public String getMoatVastExtra() {
        return this.moatExtraVast;
    }

    public long getExpireTime() {
        return this.expireTime * 1000;
    }

    public C10191u getMRAIDArgs() {
        if (this.templateSettings != null) {
            C10191u ret = new C10191u();
            for (Entry<String, String> entry : this.templateSettings.entrySet()) {
                ret.mo33470a((String) entry.getKey(), (String) entry.getValue());
            }
            for (Entry<String, String> entry2 : this.cacheableReplacements.entrySet()) {
                ret.mo33470a(((String) entry2.getKey()).substring(0, ((String) entry2.getKey()).lastIndexOf(".")), (String) entry2.getValue());
            }
            return ret;
        }
        throw new IllegalArgumentException("Advertisment does not have MRAID Arguments!");
    }

    public String getCTAURL(boolean tpat) {
        int i = this.adType;
        if (i == 0) {
            return tpat ? this.ctaUrl : this.ctaDestinationUrl;
        } else if (i == 1) {
            return this.ctaUrl;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown AdType ");
            sb.append(this.adType);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public boolean hasPostroll() {
        return !TextUtils.isEmpty(this.postrollBundleUrl);
    }

    public Map<String, String> getDownloadableUrls() {
        HashMap<String, String> ret = new HashMap<>();
        int i = this.adType;
        if (i == 0) {
            ret.put(KEY_VIDEO, this.videoUrl);
            if (!TextUtils.isEmpty(this.postrollBundleUrl)) {
                ret.put(KEY_POSTROLL, this.postrollBundleUrl);
            }
        } else if (i == 1) {
            ret.put(KEY_TEMPLATE, this.templateUrl);
            for (Entry<String, String> entry : this.cacheableReplacements.entrySet()) {
                ret.put(entry.getKey(), entry.getValue());
            }
        } else {
            throw new IllegalStateException("Advertisement created without adType!");
        }
        return ret;
    }

    public void setMraidAssetDir(File dir) {
        Map<String, String> tempMap = new HashMap<>();
        for (Entry<String, String> entry : this.cacheableReplacements.entrySet()) {
            File file = new File(dir, (String) entry.getKey());
            if (file.exists()) {
                Object key = entry.getKey();
                StringBuilder sb = new StringBuilder();
                sb.append("file://");
                sb.append(file.getPath());
                tempMap.put(key, sb.toString());
            }
        }
        this.cacheableReplacements.putAll(tempMap);
    }

    public void setState(@State int state2) {
        this.state = state2;
    }

    @State
    public int getState() {
        return this.state;
    }

    public String getAdMarketId() {
        return this.adMarketId;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public Advertisement copy() {
        try {
            return (Advertisement) clone();
        } catch (CloneNotSupportedException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Advertisement{adType=");
        sb.append(this.adType);
        sb.append(", identifier='");
        sb.append(this.identifier);
        sb.append('\'');
        sb.append(", appID='");
        sb.append(this.appID);
        sb.append('\'');
        sb.append(", expireTime=");
        sb.append(this.expireTime);
        sb.append(", checkpoints=");
        sb.append(this.checkpoints);
        sb.append(", muteUrls=");
        sb.append(Arrays.toString(this.muteUrls));
        sb.append(", unmuteUrls=");
        sb.append(Arrays.toString(this.unmuteUrls));
        sb.append(", closeUrls=");
        sb.append(Arrays.toString(this.closeUrls));
        sb.append(", postRollClickUrls=");
        sb.append(Arrays.toString(this.postRollClickUrls));
        sb.append(", postRollViewUrls=");
        sb.append(Arrays.toString(this.postRollViewUrls));
        sb.append(", clickUrls=");
        sb.append(Arrays.toString(this.clickUrls));
        sb.append(", delay=");
        sb.append(this.delay);
        sb.append(", campaign='");
        sb.append(this.campaign);
        sb.append('\'');
        sb.append(", showCloseDelay=");
        sb.append(this.showCloseDelay);
        sb.append(", showCloseIncentivized=");
        sb.append(this.showCloseIncentivized);
        sb.append(", countdown=");
        sb.append(this.countdown);
        sb.append(", videoUrl='");
        sb.append(this.videoUrl);
        sb.append('\'');
        sb.append(", videoWidth=");
        sb.append(this.videoWidth);
        sb.append(", videoHeight=");
        sb.append(this.videoHeight);
        sb.append(", md5='");
        sb.append(this.md5);
        sb.append('\'');
        sb.append(", postrollBundleUrl='");
        sb.append(this.postrollBundleUrl);
        sb.append('\'');
        sb.append(", ctaOverlayEnabled=");
        sb.append(this.ctaOverlayEnabled);
        sb.append(", ctaShowOnClick=");
        sb.append(this.ctaShowOnClick);
        sb.append(", ctaTimeEnabled=");
        sb.append(this.ctaTimeEnabled);
        sb.append(", ctaTimeShow=");
        sb.append(this.ctaTimeShow);
        sb.append(", ctaClickArea=");
        sb.append(this.ctaClickArea);
        sb.append(", ctaDestinationUrl='");
        sb.append(this.ctaDestinationUrl);
        sb.append('\'');
        sb.append(", ctaUrl='");
        sb.append(this.ctaUrl);
        sb.append('\'');
        sb.append(", adConfig=");
        sb.append(this.adConfig);
        sb.append(", retryCount=");
        sb.append(this.retryCount);
        sb.append(", adToken='");
        sb.append(this.adToken);
        sb.append('\'');
        sb.append(", videoIdentifier='");
        sb.append(this.videoIdentifier);
        sb.append('\'');
        sb.append(", templateUrl='");
        sb.append(this.templateUrl);
        sb.append('\'');
        sb.append(", templateSettings=");
        sb.append(this.templateSettings);
        sb.append(", templateId='");
        sb.append(this.templateId);
        sb.append('\'');
        sb.append(", templateType='");
        sb.append(this.templateType);
        sb.append('\'');
        sb.append(", enableMoat=");
        sb.append(this.enableMoat);
        sb.append(", moatExtraVast='");
        sb.append(this.moatExtraVast);
        sb.append('\'');
        sb.append(", requiresNonMarketInstall=");
        sb.append(this.requiresNonMarketInstall);
        sb.append(", adMarketId='");
        sb.append(this.adMarketId);
        sb.append('\'');
        sb.append(", bidToken='");
        sb.append(this.bidToken);
        sb.append('\'');
        sb.append(", state=");
        sb.append(this.state);
        sb.append('}');
        return sb.toString();
    }
}
