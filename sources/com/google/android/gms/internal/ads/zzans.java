package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

@zzard
public final class zzans implements NativeMediationAdRequest {

    /* renamed from: a */
    private final Date f24502a;

    /* renamed from: b */
    private final int f24503b;

    /* renamed from: c */
    private final Set<String> f24504c;

    /* renamed from: d */
    private final boolean f24505d;

    /* renamed from: e */
    private final Location f24506e;

    /* renamed from: f */
    private final int f24507f;

    /* renamed from: g */
    private final zzady f24508g;

    /* renamed from: h */
    private final List<String> f24509h = new ArrayList();

    /* renamed from: i */
    private final boolean f24510i;

    /* renamed from: j */
    private final Map<String, Boolean> f24511j = new HashMap();

    /* renamed from: k */
    private final int f24512k;

    /* renamed from: l */
    private final String f24513l;

    public zzans(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzady zzady, List<String> list, boolean z2, int i3, String str) {
        this.f24502a = date;
        this.f24503b = i;
        this.f24504c = set;
        this.f24506e = location;
        this.f24505d = z;
        this.f24507f = i2;
        this.f24508g = zzady;
        this.f24510i = z2;
        this.f24512k = i3;
        this.f24513l = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.f24511j.put(split[1], Boolean.valueOf(true));
                        } else {
                            if (AdultContentAnalytics.UNLOCK.equals(split[2])) {
                                this.f24511j.put(split[1], Boolean.valueOf(false));
                            }
                        }
                    }
                } else {
                    this.f24509h.add(str2);
                }
            }
        }
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f24502a;
    }

    @Deprecated
    public final int getGender() {
        return this.f24503b;
    }

    public final Set<String> getKeywords() {
        return this.f24504c;
    }

    public final Location getLocation() {
        return this.f24506e;
    }

    public final boolean isTesting() {
        return this.f24505d;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f24507f;
    }

    public final NativeAdOptions getNativeAdOptions() {
        if (this.f24508g == null) {
            return null;
        }
        Builder requestMultipleImages = new Builder().setReturnUrlsForImageAssets(this.f24508g.f24266b).setImageOrientation(this.f24508g.f24267c).setRequestMultipleImages(this.f24508g.f24268d);
        zzady zzady = this.f24508g;
        if (zzady.f24265a >= 2) {
            requestMultipleImages.setAdChoicesPlacement(zzady.f24269e);
        }
        zzady zzady2 = this.f24508g;
        if (zzady2.f24265a >= 3) {
            zzacd zzacd = zzady2.f24270f;
            if (zzacd != null) {
                requestMultipleImages.setVideoOptions(new VideoOptions(zzacd));
            }
        }
        return requestMultipleImages.build();
    }

    public final boolean isAdMuted() {
        return zzabe.m24652d().mo29481c();
    }

    public final float getAdVolume() {
        return zzabe.m24652d().mo29480b();
    }

    public final boolean isAppInstallAdRequested() {
        List<String> list = this.f24509h;
        return list != null && (list.contains("2") || this.f24509h.contains("6"));
    }

    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.f24509h;
        return list != null && list.contains("6");
    }

    public final boolean isContentAdRequested() {
        List<String> list = this.f24509h;
        return list != null && (list.contains("1") || this.f24509h.contains("6"));
    }

    public final boolean zzsu() {
        List<String> list = this.f24509h;
        return list != null && list.contains("3");
    }

    public final Map<String, Boolean> zzsv() {
        return this.f24511j;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.f24510i;
    }
}
