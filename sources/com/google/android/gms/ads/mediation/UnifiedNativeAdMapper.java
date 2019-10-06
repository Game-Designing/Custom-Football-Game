package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.internal.ads.zzard;
import java.util.List;
import java.util.Map;

@zzard
public class UnifiedNativeAdMapper {

    /* renamed from: a */
    private String f19200a;

    /* renamed from: b */
    private List<Image> f19201b;

    /* renamed from: c */
    private String f19202c;

    /* renamed from: d */
    private Image f19203d;

    /* renamed from: e */
    private String f19204e;

    /* renamed from: f */
    private String f19205f;

    /* renamed from: g */
    private Double f19206g;

    /* renamed from: h */
    private String f19207h;

    /* renamed from: i */
    private String f19208i;

    /* renamed from: j */
    private VideoController f19209j;

    /* renamed from: k */
    private boolean f19210k;

    /* renamed from: l */
    private View f19211l;

    /* renamed from: m */
    private View f19212m;

    /* renamed from: n */
    private Object f19213n;

    /* renamed from: o */
    private Bundle f19214o = new Bundle();

    /* renamed from: p */
    private boolean f19215p;

    /* renamed from: q */
    private boolean f19216q;

    public final void setHeadline(String str) {
        this.f19200a = str;
    }

    public final void setImages(List<Image> list) {
        this.f19201b = list;
    }

    public final void setBody(String str) {
        this.f19202c = str;
    }

    public final void setIcon(Image image) {
        this.f19203d = image;
    }

    public final void setCallToAction(String str) {
        this.f19204e = str;
    }

    public final void setAdvertiser(String str) {
        this.f19205f = str;
    }

    public final void setStarRating(Double d) {
        this.f19206g = d;
    }

    public final void setStore(String str) {
        this.f19207h = str;
    }

    public final void setPrice(String str) {
        this.f19208i = str;
    }

    public final void zza(VideoController videoController) {
        this.f19209j = videoController;
    }

    public void setHasVideoContent(boolean z) {
        this.f19210k = z;
    }

    public void setAdChoicesContent(View view) {
        this.f19211l = view;
    }

    public void setMediaView(View view) {
        this.f19212m = view;
    }

    public final void zzp(Object obj) {
        this.f19213n = obj;
    }

    public final void setExtras(Bundle bundle) {
        this.f19214o = bundle;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.f19215p = z;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.f19216q = z;
    }

    public final String getHeadline() {
        return this.f19200a;
    }

    public final List<Image> getImages() {
        return this.f19201b;
    }

    public final String getBody() {
        return this.f19202c;
    }

    public final Image getIcon() {
        return this.f19203d;
    }

    public final String getCallToAction() {
        return this.f19204e;
    }

    public final String getAdvertiser() {
        return this.f19205f;
    }

    public final Double getStarRating() {
        return this.f19206g;
    }

    public final String getStore() {
        return this.f19207h;
    }

    public final String getPrice() {
        return this.f19208i;
    }

    public final VideoController getVideoController() {
        return this.f19209j;
    }

    public boolean hasVideoContent() {
        return this.f19210k;
    }

    public View getAdChoicesContent() {
        return this.f19211l;
    }

    public final View zzacd() {
        return this.f19212m;
    }

    public final Object zzkv() {
        return this.f19213n;
    }

    public final Bundle getExtras() {
        return this.f19214o;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f19215p;
    }

    public final boolean getOverrideClickHandling() {
        return this.f19216q;
    }

    public void recordImpression() {
    }

    public void handleClick(View view) {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }
}
