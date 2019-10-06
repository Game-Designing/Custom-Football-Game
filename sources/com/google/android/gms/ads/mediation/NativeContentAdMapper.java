package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

@Deprecated
public class NativeContentAdMapper extends NativeAdMapper {

    /* renamed from: h */
    private String f19194h;

    /* renamed from: i */
    private List<Image> f19195i;

    /* renamed from: j */
    private String f19196j;

    /* renamed from: k */
    private Image f19197k;

    /* renamed from: l */
    private String f19198l;

    /* renamed from: m */
    private String f19199m;

    public final void setHeadline(String str) {
        this.f19194h = str;
    }

    public final void setImages(List<Image> list) {
        this.f19195i = list;
    }

    public final void setBody(String str) {
        this.f19196j = str;
    }

    public final void setLogo(Image image) {
        this.f19197k = image;
    }

    public final void setCallToAction(String str) {
        this.f19198l = str;
    }

    public final void setAdvertiser(String str) {
        this.f19199m = str;
    }

    public final String getHeadline() {
        return this.f19194h;
    }

    public final List<Image> getImages() {
        return this.f19195i;
    }

    public final String getBody() {
        return this.f19196j;
    }

    public final Image getLogo() {
        return this.f19197k;
    }

    public final String getCallToAction() {
        return this.f19198l;
    }

    public final String getAdvertiser() {
        return this.f19199m;
    }
}
