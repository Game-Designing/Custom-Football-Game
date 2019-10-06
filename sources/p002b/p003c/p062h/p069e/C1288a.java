package p002b.p003c.p062h.p069e;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: b.c.h.e.a */
/* compiled from: AllCapsTransformationMethod */
public class C1288a implements TransformationMethod {

    /* renamed from: a */
    private Locale f4096a;

    public C1288a(Context context) {
        this.f4096a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence source, View view) {
        if (source != null) {
            return source.toString().toUpperCase(this.f4096a);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {
    }
}
