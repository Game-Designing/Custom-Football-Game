package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.nativeads.E */
/* compiled from: MediaViewHolder */
class C11522E {
    @VisibleForTesting

    /* renamed from: a */
    static final C11522E f35625a = new C11522E();

    /* renamed from: b */
    View f35626b;

    /* renamed from: c */
    MediaLayout f35627c;

    /* renamed from: d */
    TextView f35628d;

    /* renamed from: e */
    TextView f35629e;

    /* renamed from: f */
    ImageView f35630f;

    /* renamed from: g */
    TextView f35631g;

    /* renamed from: h */
    ImageView f35632h;

    private C11522E() {
    }

    /* renamed from: a */
    static C11522E m38110a(View view, MediaViewBinder mediaViewBinder) {
        C11522E mediaViewHolder = new C11522E();
        mediaViewHolder.f35626b = view;
        try {
            mediaViewHolder.f35628d = (TextView) view.findViewById(mediaViewBinder.f35800c);
            mediaViewHolder.f35629e = (TextView) view.findViewById(mediaViewBinder.f35801d);
            mediaViewHolder.f35631g = (TextView) view.findViewById(mediaViewBinder.f35802e);
            mediaViewHolder.f35627c = (MediaLayout) view.findViewById(mediaViewBinder.f35799b);
            mediaViewHolder.f35630f = (ImageView) view.findViewById(mediaViewBinder.f35803f);
            mediaViewHolder.f35632h = (ImageView) view.findViewById(mediaViewBinder.f35804g);
            return mediaViewHolder;
        } catch (ClassCastException exception) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Could not cast from id in MediaViewBinder to expected View type", exception);
            return f35625a;
        }
    }
}
