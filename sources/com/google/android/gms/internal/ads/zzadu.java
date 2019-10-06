package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

@zzard
public final class zzadu extends RelativeLayout {

    /* renamed from: a */
    private static final float[] f24258a = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};

    /* renamed from: b */
    private AnimationDrawable f24259b;

    public zzadu(Context context, zzadt zzadt, LayoutParams layoutParams) {
        super(context);
        Preconditions.m21857a(zzadt);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f24258a, null, null));
        shapeDrawable.getPaint().setColor(zzadt.mo29630ib());
        setLayoutParams(layoutParams);
        zzk.zzli().mo30251a((View) this, (Drawable) shapeDrawable);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadt.getText())) {
            LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadt.getText());
            textView.setTextColor(zzadt.mo29631jb());
            textView.setTextSize((float) zzadt.mo29632kb());
            zzyt.m31532a();
            int a = zzazt.m26302a(context, 4);
            zzyt.m31532a();
            textView.setPadding(a, 0, zzazt.m26302a(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadw> lb = zzadt.mo29633lb();
        String str = "Error while getting drawable.";
        if (lb != null && lb.size() > 1) {
            this.f24259b = new AnimationDrawable();
            for (zzadw Pa : lb) {
                try {
                    this.f24259b.addFrame((Drawable) ObjectWrapper.m22187H(Pa.mo29639Pa()), zzadt.mo29634mb());
                } catch (Exception e) {
                    zzbad.m26356b(str, e);
                }
            }
            zzk.zzli().mo30251a((View) imageView, (Drawable) this.f24259b);
        } else if (lb.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.m22187H(((zzadw) lb.get(0)).mo29639Pa()));
            } catch (Exception e2) {
                zzbad.m26356b(str, e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.f24259b;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
