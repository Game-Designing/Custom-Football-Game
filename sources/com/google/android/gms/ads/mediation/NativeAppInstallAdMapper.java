package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

@Deprecated
public class NativeAppInstallAdMapper extends NativeAdMapper {

    /* renamed from: h */
    private String f19186h;

    /* renamed from: i */
    private List<Image> f19187i;

    /* renamed from: j */
    private String f19188j;

    /* renamed from: k */
    private Image f19189k;

    /* renamed from: l */
    private String f19190l;

    /* renamed from: m */
    private double f19191m;

    /* renamed from: n */
    private String f19192n;

    /* renamed from: o */
    private String f19193o;

    public final void setHeadline(String str) {
        this.f19186h = str;
    }

    public final void setImages(List<Image> list) {
        this.f19187i = list;
    }

    public final void setBody(String str) {
        this.f19188j = str;
    }

    public final void setIcon(Image image) {
        this.f19189k = image;
    }

    public final void setCallToAction(String str) {
        this.f19190l = str;
    }

    public final void setStarRating(double d) {
        this.f19191m = d;
    }

    public final void setStore(String str) {
        this.f19192n = str;
    }

    public final void setPrice(String str) {
        this.f19193o = str;
    }

    public final String getHeadline() {
        return this.f19186h;
    }

    public final List<Image> getImages() {
        return this.f19187i;
    }

    public final String getBody() {
        return this.f19188j;
    }

    public final Image getIcon() {
        return this.f19189k;
    }

    public final String getCallToAction() {
        return this.f19190l;
    }

    public final double getStarRating() {
        return this.f19191m;
    }

    public final String getStore() {
        return this.f19192n;
    }

    public final String getPrice() {
        return this.f19193o;
    }
}
