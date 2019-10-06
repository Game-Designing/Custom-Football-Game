package p019d.p151c.p152a.p153a;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import p019d.p151c.p152a.C7283f;
import p019d.p151c.p152a.C7286i;

/* renamed from: d.c.a.a.f */
/* compiled from: ExpirationDateItemAdapter */
public class C7276f extends ArrayAdapter<String> {

    /* renamed from: a */
    private C7274d f14148a;

    /* renamed from: b */
    private ShapeDrawable f14149b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnItemClickListener f14150c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f14151d = -1;

    /* renamed from: e */
    private List<Integer> f14152e = new ArrayList();

    public C7276f(Context context, C7274d theme, List<String> objects) {
        super(context, C7286i.bt_expiration_date_item, objects);
        this.f14148a = theme;
        float radius = context.getResources().getDimension(C7283f.bt_expiration_date_item_selected_background_radius);
        this.f14149b = new ShapeDrawable(new RoundRectShape(new float[]{radius, radius, radius, radius, radius, radius, radius, radius}, null, null));
        this.f14149b.getPaint().setColor(this.f14148a.mo23500i());
    }

    /* renamed from: a */
    public void mo23503a(OnItemClickListener listener) {
        this.f14150c = listener;
    }

    /* renamed from: a */
    public void mo23502a(int position) {
        this.f14151d = position;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo23504a(List<Integer> disabledPositions) {
        this.f14152e = disabledPositions;
        notifyDataSetChanged();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setEnabled(true);
        if (this.f14151d == position) {
            view.setBackgroundDrawable(this.f14149b);
            view.setTextColor(this.f14148a.mo23498f());
        } else {
            view.setBackgroundResource(17170445);
            if (this.f14152e.contains(Integer.valueOf(position))) {
                view.setTextColor(this.f14148a.mo23497e());
                view.setEnabled(false);
            } else {
                view.setTextColor(this.f14148a.mo23499g());
            }
        }
        view.setOnClickListener(new C7275e(this, position));
        return view;
    }
}
