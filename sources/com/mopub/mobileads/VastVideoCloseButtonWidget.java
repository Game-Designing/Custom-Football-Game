package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.network.Networking;
import com.mopub.volley.toolbox.ImageLoader;

public class VastVideoCloseButtonWidget extends RelativeLayout {

    /* renamed from: a */
    private TextView f35009a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f35010b;

    /* renamed from: c */
    private final ImageLoader f35011c;

    /* renamed from: d */
    private CloseButtonDrawable f35012d = new CloseButtonDrawable();

    /* renamed from: e */
    private final int f35013e;

    /* renamed from: f */
    private final int f35014f;

    /* renamed from: g */
    private final int f35015g;

    /* renamed from: h */
    private final int f35016h;

    public VastVideoCloseButtonWidget(Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.f35013e = Dips.dipsToIntPixels(6.0f, context);
        this.f35015g = Dips.dipsToIntPixels(15.0f, context);
        this.f35016h = Dips.dipsToIntPixels(56.0f, context);
        this.f35014f = Dips.dipsToIntPixels(0.0f, context);
        this.f35011c = Networking.getImageLoader(context);
        m37583a();
        m37584b();
        LayoutParams layoutParams = new LayoutParams(-2, this.f35016h);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m37583a() {
        this.f35010b = new ImageView(getContext());
        this.f35010b.setId((int) Utils.generateUniqueId());
        int i = this.f35016h;
        LayoutParams iconLayoutParams = new LayoutParams(i, i);
        iconLayoutParams.addRule(11);
        this.f35010b.setImageDrawable(this.f35012d);
        ImageView imageView = this.f35010b;
        int i2 = this.f35015g;
        int i3 = this.f35013e;
        imageView.setPadding(i2, i2 + i3, i3 + i2, i2);
        addView(this.f35010b, iconLayoutParams);
    }

    /* renamed from: b */
    private void m37584b() {
        this.f35009a = new TextView(getContext());
        this.f35009a.setSingleLine();
        this.f35009a.setEllipsize(TruncateAt.END);
        this.f35009a.setTextColor(-1);
        this.f35009a.setTextSize(20.0f);
        this.f35009a.setTypeface(CloseButton.TEXT_TYPEFACE);
        this.f35009a.setText("");
        LayoutParams textLayoutParams = new LayoutParams(-2, -2);
        textLayoutParams.addRule(15);
        textLayoutParams.addRule(0, this.f35010b.getId());
        this.f35009a.setPadding(0, this.f35013e, 0, 0);
        textLayoutParams.setMargins(0, 0, this.f35014f, 0);
        addView(this.f35009a, textLayoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37259b(String text) {
        TextView textView = this.f35009a;
        if (textView != null) {
            textView.setText(text);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37258a(String imageUrl) {
        this.f35011c.get(imageUrl, new C11325Ka(this, imageUrl));
    }

    /* access modifiers changed from: 0000 */
    public void setOnTouchListenerToContent(OnTouchListener onTouchListener) {
        this.f35010b.setOnTouchListener(onTouchListener);
        this.f35009a.setOnTouchListener(onTouchListener);
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public ImageView getImageView() {
        return this.f35010b;
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public void setImageView(ImageView imageView) {
        this.f35010b = imageView;
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public TextView getTextView() {
        return this.f35009a;
    }
}
