package com.fyber.inneractive.sdk.p166g.p171e;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.p180ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.util.C7985a;
import com.fyber.inneractive.sdk.util.C7994ah;
import com.fyber.inneractive.sdk.util.C7995b;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import p019d.p268f.p269a.p270a.C12716a;
import p019d.p268f.p269a.p270a.C12717b;
import p019d.p268f.p269a.p270a.C12718c;

/* renamed from: com.fyber.inneractive.sdk.g.e.i */
public abstract class C7864i extends C7854a {

    /* renamed from: A */
    C7994ah f15873A;

    /* renamed from: B */
    public int f15874B;

    /* renamed from: C */
    public int f15875C;

    /* renamed from: D */
    public Runnable f15876D;

    /* renamed from: E */
    private boolean f15877E;

    /* renamed from: F */
    private C7994ah f15878F;

    /* renamed from: g */
    protected ImageView f15879g;

    /* renamed from: h */
    protected ViewGroup f15880h;

    /* renamed from: i */
    protected TextView f15881i;

    /* renamed from: j */
    protected Button f15882j;

    /* renamed from: k */
    public TextView f15883k;

    /* renamed from: l */
    protected TextView f15884l;

    /* renamed from: m */
    protected View f15885m;

    /* renamed from: n */
    protected int f15886n;

    /* renamed from: o */
    protected int f15887o;

    /* renamed from: p */
    boolean f15888p;

    /* renamed from: q */
    public ImageView f15889q;

    /* renamed from: r */
    public ImageView f15890r;

    /* renamed from: s */
    public IAsmoothProgressBar f15891s;

    /* renamed from: t */
    protected View f15892t;

    /* renamed from: u */
    protected View f15893u;

    /* renamed from: v */
    protected ViewGroup f15894v;

    /* renamed from: w */
    protected View f15895w;

    /* renamed from: x */
    protected View f15896x;

    /* renamed from: y */
    protected Button f15897y;

    /* renamed from: z */
    C7994ah f15898z;

    @TargetApi(14)
    /* renamed from: com.fyber.inneractive.sdk.g.e.i$a */
    public static class C7868a extends TextureView {

        /* renamed from: a */
        private WeakReference<C7864i> f15904a;

        public final void setParent(C7864i iVar) {
            this.f15904a = new WeakReference<>(iVar);
        }

        public C7868a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i, int i2) {
            C7864i iVar = (C7864i) C8017o.m18094a((Reference<T>) this.f15904a);
            if (iVar != null) {
                i = MeasureSpec.makeMeasureSpec(iVar.f15873A.f16318a, 1073741824);
                i2 = MeasureSpec.makeMeasureSpec(iVar.f15873A.f16319b, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: d */
    public abstract void mo24614d();

    public C7864i(Context context) {
        this(context, 0);
    }

    private C7864i(Context context, byte b) {
        this(context, 0);
    }

    private C7864i(Context context, char c) {
        super(context, 0);
        this.f15886n = -1;
        this.f15887o = -1;
        this.f15888p = false;
        this.f15877E = false;
        this.f15898z = new C7994ah(0, 0);
        this.f15878F = new C7994ah(0, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("ctor called");
        IAlog.m18021b(sb.toString());
        LayoutInflater.from(context).inflate(C12718c.ia_video_view, this, true);
        setBackgroundColor(getResources().getColor(C12716a.ia_video_background_color));
        this.f15879g = (ImageView) findViewById(C12717b.ia_iv_last_frame);
        this.f15880h = (ViewGroup) findViewById(C12717b.ia_texture_view_host);
        this.f15889q = (ImageView) findViewById(C12717b.ia_iv_mute_button);
        this.f15881i = (TextView) findViewById(C12717b.ia_tv_call_to_action);
        this.f15890r = (ImageView) findViewById(C12717b.ia_iv_expand_collapse_button);
        this.f15883k = (TextView) findViewById(C12717b.ia_tv_remaining_time);
        this.f15891s = (IAsmoothProgressBar) findViewById(C12717b.ia_video_progressbar);
        this.f15893u = findViewById(C12717b.ia_default_endcard_video_overlay);
        this.f15894v = (ViewGroup) findViewById(C12717b.ia_endcard_video_overlay);
        this.f15892t = findViewById(C12717b.ia_paused_video_overlay);
        this.f15895w = findViewById(C12717b.ia_buffering_overlay);
        this.f15896x = findViewById(C12717b.ia_error_overlay);
        this.f15884l = (TextView) findViewById(C12717b.ia_tv_skip);
        this.f15897y = (Button) findViewById(C12717b.ia_iv_end_card_play_button);
        this.f15882j = (Button) findViewById(C12717b.ia_b_end_card_call_to_action);
        m17609a((View) this.f15889q, 1);
        m17609a((View) this.f15881i, 3);
        m17609a((View) this.f15882j, 3);
        m17609a((View) this.f15897y, 2);
        m17609a((View) this.f15890r, 5);
        m17609a((View) this.f15880h, 7);
        m17609a((View) this.f15884l, 6);
        m17609a(this.f15896x, -1);
        m17609a(findViewById(C12717b.ia_default_endcard_video_overlay), -1);
        setLayoutParams(new LayoutParams(-1, -1));
    }

    public ViewGroup getTextureHost() {
        return this.f15880h;
    }

    /* renamed from: a */
    public final void mo24616a(int i, int i2, boolean z) {
        this.f15886n = i;
        this.f15887o = i2;
        this.f15888p = z;
    }

    /* renamed from: a */
    public final void mo24619a(boolean z) {
        ImageView imageView = this.f15879g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: b */
    public final void mo24621b(boolean z) {
        ImageView imageView = this.f15889q;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    public void setMuteButtonState(boolean z) {
        this.f15889q.setSelected(z);
    }

    /* renamed from: c */
    public final void mo24622c(boolean z) {
        TextView textView = this.f15881i;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    /* renamed from: d */
    public final void mo24623d(boolean z) {
        IAsmoothProgressBar iAsmoothProgressBar = this.f15891s;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setVisibility(z ? 0 : 4);
        }
    }

    /* renamed from: e */
    public final void mo24625e(boolean z) {
        TextView textView = this.f15883k;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    /* renamed from: e */
    public final void mo24624e() {
        ImageView imageView = this.f15890r;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f15890r.setSelected(true);
        }
    }

    /* renamed from: f */
    public final void mo24627f(boolean z) {
        TextView textView = this.f15884l;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public void setSkipText(String str) {
        TextView textView = this.f15884l;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: f */
    public final void mo24626f() {
        TextView textView = this.f15884l;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    /* renamed from: g */
    public final void mo24628g(boolean z) {
        View view = this.f15892t;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public final void mo24617a(View view) {
        this.f15885m = view;
        if (view != null && this.f15894v != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            this.f15894v.setVisibility(0);
            this.f15894v.addView(view, 0);
            m17609a(view, 4);
        }
    }

    /* renamed from: a */
    public final void mo24620a(boolean z, boolean z2) {
        View view = this.f15893u;
        if (view != null) {
            int i = 0;
            view.setVisibility(z ? 0 : 8);
            Button button = this.f15882j;
            if (!z2) {
                i = 8;
            }
            button.setVisibility(i);
        }
    }

    public void setLastFrameBitmap(final Bitmap bitmap) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("setLastFrameBitmap - ");
        sb.append(bitmap);
        IAlog.m18021b(sb.toString());
        ImageView imageView = this.f15879g;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        C7994ah ahVar = this.f15898z;
        if (ahVar.f16318a == 0 || ahVar.f16319b == 0) {
            mo24619a(false);
            addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (C7864i.this.getWidth() > 0 && C7864i.this.getHeight() > 0) {
                        C7864i.this.mo24619a(true);
                        C7864i.this.removeOnLayoutChangeListener(this);
                        C7864i.this.m17608a(bitmap);
                    }
                }
            });
            return;
        }
        m17608a(bitmap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17608a(Bitmap bitmap) {
        if (bitmap != null) {
            C7994ah ahVar = new C7994ah(0, 0);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            C7994ah ahVar2 = this.f15898z;
            mo24618a(ahVar, width, height, ahVar2.f16318a, ahVar2.f16319b);
            ImageView imageView = this.f15879g;
            if (imageView != null) {
                imageView.getLayoutParams().width = ahVar.f16318a;
                this.f15879g.getLayoutParams().height = ahVar.f16319b;
            }
        }
    }

    public void setLastFrameBitmapBlurred(Bitmap bitmap) {
        if (this.f15879g != null && bitmap != null) {
            C7995b bVar = new C7995b();
            bVar.f16322c = 20;
            bVar.f16323d = 1;
            bVar.f16320a = bitmap.getWidth();
            bVar.f16321b = bitmap.getHeight();
            this.f15879g.setImageBitmap(C7985a.m18027a(getContext(), bitmap, bVar));
        }
    }

    /* renamed from: h */
    public final void mo24634h(boolean z) {
        View view = this.f15895w;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: i */
    public final void mo24635i(boolean z) {
        View view = this.f15896x;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public int getVideoWidth() {
        return this.f15886n;
    }

    public int getVideoHeight() {
        return this.f15887o;
    }

    public void setRemainingTime(String str) {
        TextView textView = this.f15883k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: a */
    public final void mo24601a() {
        super.mo24601a();
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("destroyed called");
        IAlog.m18021b(sb.toString());
        Runnable runnable = this.f15876D;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f15876D = null;
        }
        ViewGroup viewGroup = this.f15880h;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    /* renamed from: a */
    private void m17609a(View view, final int i) {
        if (view != null) {
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C7863h hVar = C7864i.this.f15867f;
                    if (hVar != null) {
                        hVar.mo24500c(i);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        mo24602a(this.f15878F, size, size2);
        C7994ah ahVar = this.f15878F;
        int i3 = ahVar.f16318a;
        if (i3 <= 0 || ahVar.f16319b <= 0) {
            C7994ah ahVar2 = this.f15878F;
            ahVar2.f16318a = size;
            ahVar2.f16319b = size2;
        } else {
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i3, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(this.f15878F.f16319b, 1073741824);
            i = makeMeasureSpec;
        }
        if (!this.f15898z.equals(this.f15878F)) {
            C7994ah ahVar3 = this.f15898z;
            C7994ah ahVar4 = this.f15878F;
            ahVar3.f16318a = ahVar4.f16318a;
            ahVar3.f16319b = ahVar4.f16319b;
            mo24614d();
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24618a(C7994ah ahVar, int i, int i2, int i3, int i4) {
        if (i > 0 && i2 > 0) {
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = f / f2;
            if (this.f15864c == UnitDisplayType.SQUARE) {
                i3 = (int) (((float) i4) * f3);
            } else {
                if (Math.abs(f3 - 1.7777778f) >= 0.1f) {
                    Math.abs(f3 - 1.3333334f);
                }
                float min = Math.min(((float) i3) / f, 10.0f);
                float f4 = (float) i4;
                float f5 = min * f2;
                if (f4 > f5) {
                    i3 = (int) (min * f);
                    i4 = (int) f5;
                } else {
                    float min2 = Math.min(f4 / f2, 10.0f);
                    i4 = (int) (min2 * f2);
                    i3 = (int) (f * min2);
                }
            }
        }
        ahVar.f16318a = i3;
        ahVar.f16319b = i4;
    }

    public View getEndCardView() {
        return this.f15885m;
    }

    /* renamed from: g */
    public final boolean mo24629g() {
        return this.f15893u.getVisibility() == 0 || this.f15894v.getChildCount() > 0;
    }
}
