package android.support.p001v7.preference;

import android.support.p001v7.preference.Preference.C0813c;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: android.support.v7.preference.b */
/* compiled from: CollapsiblePreferenceGroupController */
class C0818b implements C0813c {

    /* renamed from: a */
    final /* synthetic */ CollapsiblePreferenceGroupController f2492a;

    C0818b(CollapsiblePreferenceGroupController this$0) {
        this.f2492a = this$0;
    }

    public boolean onPreferenceClick(Preference preference) {
        this.f2492a.f2394b = MoPubClientPositioning.NO_REPEAT;
        this.f2492a.f2393a.mo6390d(preference);
        return true;
    }
}
