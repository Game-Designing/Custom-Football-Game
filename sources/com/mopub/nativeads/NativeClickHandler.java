package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.VisibleForTesting;

public class NativeClickHandler {

    /* renamed from: a */
    private final Context f35927a;

    /* renamed from: b */
    private final String f35928b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f35929c;

    public NativeClickHandler(Context context) {
        this(context, null);
    }

    public NativeClickHandler(Context context, String dspCreativeId) {
        Preconditions.checkNotNull(context);
        this.f35927a = context.getApplicationContext();
        this.f35928b = dspCreativeId;
    }

    public void setOnClickListener(View view, ClickInterface clickInterface) {
        if (NoThrow.checkNotNull(view, "Cannot set click listener on a null view") && NoThrow.checkNotNull(clickInterface, "Cannot set click listener with a null ClickInterface")) {
            m38309a(view, (OnClickListener) new C11626na(this, clickInterface));
        }
    }

    /* renamed from: a */
    private void m38309a(View view, OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m38309a(viewGroup.getChildAt(i), onClickListener);
            }
        }
    }

    public void clearOnClickListener(View view) {
        if (NoThrow.checkNotNull(view, "Cannot clear click listener from a null view")) {
            m38309a(view, (OnClickListener) null);
        }
    }

    public void openClickDestinationUrl(String clickDestinationUrl, View view) {
        mo38004a(clickDestinationUrl, view, new C11663zb(this.f35927a));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo38004a(String clickDestinationUrl, View view, C11663zb spinningProgressView) {
        if (NoThrow.checkNotNull(clickDestinationUrl, "Cannot open a null click destination url")) {
            Preconditions.checkNotNull(spinningProgressView);
            if (!this.f35929c) {
                this.f35929c = true;
                if (view != null) {
                    spinningProgressView.mo38196a(view);
                }
                Builder builder = new Builder();
                if (!TextUtils.isEmpty(this.f35928b)) {
                    builder.withDspCreativeId(this.f35928b);
                }
                builder.withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new C11629oa(this, view, spinningProgressView)).build().handleUrl(this.f35927a, clickDestinationUrl);
            }
        }
    }
}
