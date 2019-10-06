package android.support.p001v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.ViewStubCompat */
public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f3425a;

    /* renamed from: b */
    private int f3426b;

    /* renamed from: c */
    private WeakReference<View> f3427c;

    /* renamed from: d */
    private LayoutInflater f3428d;

    /* renamed from: e */
    private C1025a f3429e;

    /* renamed from: android.support.v7.widget.ViewStubCompat$a */
    public interface C1025a {
        /* renamed from: a */
        void mo8363a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3425a = 0;
        TypedArray a = context.obtainStyledAttributes(attrs, C0793R.styleable.ViewStubCompat, defStyle, 0);
        this.f3426b = a.getResourceId(C0793R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f3425a = a.getResourceId(C0793R.styleable.ViewStubCompat_android_layout, 0);
        setId(a.getResourceId(C0793R.styleable.ViewStubCompat_android_id, -1));
        a.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f3426b;
    }

    public void setInflatedId(int inflatedId) {
        this.f3426b = inflatedId;
    }

    public int getLayoutResource() {
        return this.f3425a;
    }

    public void setLayoutResource(int layoutResource) {
        this.f3425a = layoutResource;
    }

    public void setLayoutInflater(LayoutInflater inflater) {
        this.f3428d = inflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f3428d;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int visibility) {
        WeakReference<View> weakReference = this.f3427c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(visibility);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(visibility);
        if (visibility == 0 || visibility == 4) {
            mo8351a();
        }
    }

    /* renamed from: a */
    public View mo8351a() {
        LayoutInflater factory;
        ViewParent viewParent = getParent();
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f3425a != 0) {
            ViewGroup parent = (ViewGroup) viewParent;
            if (this.f3428d != null) {
                factory = this.f3428d;
            } else {
                factory = LayoutInflater.from(getContext());
            }
            View view = factory.inflate(this.f3425a, parent, false);
            int i = this.f3426b;
            if (i != -1) {
                view.setId(i);
            }
            int index = parent.indexOfChild(this);
            parent.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                parent.addView(view, index, layoutParams);
            } else {
                parent.addView(view, index);
            }
            this.f3427c = new WeakReference<>(view);
            C1025a aVar = this.f3429e;
            if (aVar != null) {
                aVar.mo8363a(this, view);
            }
            return view;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C1025a inflateListener) {
        this.f3429e = inflateListener;
    }
}
