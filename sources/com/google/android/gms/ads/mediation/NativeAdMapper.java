package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzard;
import java.util.Map;

@Deprecated
@zzard
public class NativeAdMapper {

    /* renamed from: a */
    protected boolean f19179a;

    /* renamed from: b */
    protected boolean f19180b;

    /* renamed from: c */
    protected Bundle f19181c = new Bundle();

    /* renamed from: d */
    protected View f19182d;

    /* renamed from: e */
    private View f19183e;

    /* renamed from: f */
    private VideoController f19184f;

    /* renamed from: g */
    private boolean f19185g;

    public final void setOverrideImpressionRecording(boolean z) {
        this.f19179a = z;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.f19180b = z;
    }

    public final void setExtras(Bundle bundle) {
        this.f19181c = bundle;
    }

    public void setAdChoicesContent(View view) {
        this.f19182d = view;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f19179a;
    }

    public final boolean getOverrideClickHandling() {
        return this.f19180b;
    }

    public final Bundle getExtras() {
        return this.f19181c;
    }

    public View getAdChoicesContent() {
        return this.f19182d;
    }

    @Deprecated
    public void trackView(View view) {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public void recordImpression() {
    }

    public void handleClick(View view) {
    }

    public void setMediaView(View view) {
        this.f19183e = view;
    }

    public final View zzacd() {
        return this.f19183e;
    }

    public final void zza(VideoController videoController) {
        this.f19184f = videoController;
    }

    public final VideoController getVideoController() {
        return this.f19184f;
    }

    public void setHasVideoContent(boolean z) {
        this.f19185g = z;
    }

    public boolean hasVideoContent() {
        return this.f19185g;
    }
}
