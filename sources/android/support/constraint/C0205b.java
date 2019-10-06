package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout.C0166a;
import android.support.constraint.p034a.p035a.C0186m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.Arrays;

/* renamed from: android.support.constraint.b */
/* compiled from: ConstraintHelper */
public abstract class C0205b extends View {

    /* renamed from: a */
    protected int[] f607a = new int[32];

    /* renamed from: b */
    protected int f608b;

    /* renamed from: c */
    protected Context f609c;

    /* renamed from: d */
    protected C0186m f610d;

    /* renamed from: e */
    protected boolean f611e = false;

    /* renamed from: f */
    private String f612f;

    public C0205b(Context context) {
        super(context);
        this.f609c = context;
        mo3808a((AttributeSet) null);
    }

    public C0205b(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f609c = context;
        mo3808a(attrs);
    }

    public C0205b(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f609c = context;
        mo3808a(attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3808a(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, C0214i.ConstraintLayout_Layout);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == C0214i.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f612f = a.getString(attr);
                    setIds(this.f612f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f607a, this.f608b);
    }

    public void setReferencedIds(int[] ids) {
        this.f608b = 0;
        for (int tag : ids) {
            setTag(tag, null);
        }
    }

    public void setTag(int tag, Object value) {
        int i = this.f608b + 1;
        int[] iArr = this.f607a;
        if (i > iArr.length) {
            this.f607a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f607a;
        int i2 = this.f608b;
        iArr2[i2] = tag;
        this.f608b = i2 + 1;
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f611e) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* renamed from: a */
    public void mo4040a() {
        if (this.f610d != null) {
            LayoutParams params = getLayoutParams();
            if (params instanceof C0166a) {
                ((C0166a) params).f299la = this.f610d;
            }
        }
    }

    /* renamed from: a */
    private void m1192a(String idString) {
        if (idString != null && this.f609c != null) {
            String idString2 = idString.trim();
            int tag = 0;
            try {
                tag = C0213h.class.getField(idString2).getInt(null);
            } catch (Exception e) {
            }
            if (tag == 0) {
                tag = this.f609c.getResources().getIdentifier(idString2, "id", this.f609c.getPackageName());
            }
            if (tag == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object value = ((ConstraintLayout) getParent()).mo3777a(0, (Object) idString2);
                if (value != null && (value instanceof Integer)) {
                    tag = ((Integer) value).intValue();
                }
            }
            if (tag != 0) {
                setTag(tag, null);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find id of \"");
                sb.append(idString2);
                sb.append("\"");
                Log.w("ConstraintHelper", sb.toString());
            }
        }
    }

    private void setIds(String idList) {
        if (idList != null) {
            int begin = 0;
            while (true) {
                int end = idList.indexOf(44, begin);
                if (end == -1) {
                    m1192a(idList.substring(begin));
                    return;
                } else {
                    m1192a(idList.substring(begin, end));
                    begin = end + 1;
                }
            }
        }
    }

    /* renamed from: c */
    public void mo3809c(ConstraintLayout container) {
        if (isInEditMode()) {
            setIds(this.f612f);
        }
        C0186m mVar = this.f610d;
        if (mVar != null) {
            mVar.mo3951J();
            for (int i = 0; i < this.f608b; i++) {
                View view = container.mo3776a(this.f607a[i]);
                if (view != null) {
                    this.f610d.mo3955b(container.mo3775a(view));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3807a(ConstraintLayout container) {
    }

    /* renamed from: b */
    public void mo4041b(ConstraintLayout container) {
    }
}
