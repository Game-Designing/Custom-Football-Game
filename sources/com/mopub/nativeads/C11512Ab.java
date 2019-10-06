package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.nativeads.Ab */
/* compiled from: StaticNativeViewHolder */
class C11512Ab {
    @VisibleForTesting

    /* renamed from: a */
    static final C11512Ab f35589a = new C11512Ab();

    /* renamed from: b */
    View f35590b;

    /* renamed from: c */
    TextView f35591c;

    /* renamed from: d */
    TextView f35592d;

    /* renamed from: e */
    TextView f35593e;

    /* renamed from: f */
    ImageView f35594f;

    /* renamed from: g */
    ImageView f35595g;

    /* renamed from: h */
    ImageView f35596h;

    private C11512Ab() {
    }

    /* renamed from: a */
    static C11512Ab m38088a(View view, ViewBinder viewBinder) {
        C11512Ab staticNativeViewHolder = new C11512Ab();
        staticNativeViewHolder.f35590b = view;
        try {
            staticNativeViewHolder.f35591c = (TextView) view.findViewById(viewBinder.f36082b);
            staticNativeViewHolder.f35592d = (TextView) view.findViewById(viewBinder.f36083c);
            staticNativeViewHolder.f35593e = (TextView) view.findViewById(viewBinder.f36084d);
            staticNativeViewHolder.f35594f = (ImageView) view.findViewById(viewBinder.f36085e);
            staticNativeViewHolder.f35595g = (ImageView) view.findViewById(viewBinder.f36086f);
            staticNativeViewHolder.f35596h = (ImageView) view.findViewById(viewBinder.f36087g);
            return staticNativeViewHolder;
        } catch (ClassCastException exception) {
            MoPubLog.log(SdkLogEvent.ERROR, "Could not cast from id in ViewBinder to expected View type", exception);
            return f35589a;
        }
    }
}
