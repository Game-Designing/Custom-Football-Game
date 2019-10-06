package android.support.constraint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout.C0166a;
import android.view.View;

/* renamed from: android.support.constraint.g */
/* compiled from: Placeholder */
public class C0212g extends View {

    /* renamed from: a */
    private int f704a;

    /* renamed from: b */
    private View f705b;

    /* renamed from: c */
    private int f706c;

    public void setEmptyVisibility(int visibility) {
        this.f706c = visibility;
    }

    public int getEmptyVisibility() {
        return this.f706c;
    }

    public View getContent() {
        return this.f705b;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect r = new Rect();
            canvas.getClipBounds(r);
            paint.setTextSize((float) r.height());
            int cHeight = r.height();
            int cWidth = r.width();
            paint.setTextAlign(Align.LEFT);
            String text = "?";
            paint.getTextBounds(text, 0, text.length(), r);
            canvas.drawText(text, ((((float) cWidth) / 2.0f) - (((float) r.width()) / 2.0f)) - ((float) r.left), ((((float) cHeight) / 2.0f) + (((float) r.height()) / 2.0f)) - ((float) r.bottom), paint);
        }
    }

    /* renamed from: b */
    public void mo4064b(ConstraintLayout container) {
        if (this.f704a == -1 && !isInEditMode()) {
            setVisibility(this.f706c);
        }
        this.f705b = container.findViewById(this.f704a);
        View view = this.f705b;
        if (view != null) {
            ((C0166a) view.getLayoutParams()).f277aa = true;
            this.f705b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int id) {
        if (this.f704a != id) {
            View view = this.f705b;
            if (view != null) {
                view.setVisibility(0);
                ((C0166a) this.f705b.getLayoutParams()).f277aa = false;
                this.f705b = null;
            }
            this.f704a = id;
            if (id != -1) {
                View v = ((View) getParent()).findViewById(id);
                if (v != null) {
                    v.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4063a(ConstraintLayout container) {
        if (this.f705b != null) {
            C0166a layoutParams = (C0166a) getLayoutParams();
            C0166a layoutParamsContent = (C0166a) this.f705b.getLayoutParams();
            layoutParamsContent.f299la.mo3911n(0);
            layoutParams.f299la.mo3913o(layoutParamsContent.f299la.mo3920s());
            layoutParams.f299la.mo3897g(layoutParamsContent.f299la.mo3900i());
            layoutParamsContent.f299la.mo3911n(8);
        }
    }
}
