package android.support.p001v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.NestedScrollView;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.widget.C1101pa.C1102a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v7.app.AlertController */
class AlertController {

    /* renamed from: A */
    NestedScrollView f2082A;

    /* renamed from: B */
    private int f2083B = 0;

    /* renamed from: C */
    private Drawable f2084C;

    /* renamed from: D */
    private ImageView f2085D;

    /* renamed from: E */
    private TextView f2086E;

    /* renamed from: F */
    private TextView f2087F;

    /* renamed from: G */
    private View f2088G;

    /* renamed from: H */
    ListAdapter f2089H;

    /* renamed from: I */
    int f2090I = -1;

    /* renamed from: J */
    private int f2091J;

    /* renamed from: K */
    private int f2092K;

    /* renamed from: L */
    int f2093L;

    /* renamed from: M */
    int f2094M;

    /* renamed from: N */
    int f2095N;

    /* renamed from: O */
    int f2096O;

    /* renamed from: P */
    private boolean f2097P;

    /* renamed from: Q */
    private int f2098Q = 0;

    /* renamed from: R */
    Handler f2099R;

    /* renamed from: S */
    private final OnClickListener f2100S = new C0765d(this);

    /* renamed from: a */
    private final Context f2101a;

    /* renamed from: b */
    final C0744F f2102b;

    /* renamed from: c */
    private final Window f2103c;

    /* renamed from: d */
    private final int f2104d;

    /* renamed from: e */
    private CharSequence f2105e;

    /* renamed from: f */
    private CharSequence f2106f;

    /* renamed from: g */
    ListView f2107g;

    /* renamed from: h */
    private View f2108h;

    /* renamed from: i */
    private int f2109i;

    /* renamed from: j */
    private int f2110j;

    /* renamed from: k */
    private int f2111k;

    /* renamed from: l */
    private int f2112l;

    /* renamed from: m */
    private int f2113m;

    /* renamed from: n */
    private boolean f2114n = false;

    /* renamed from: o */
    Button f2115o;

    /* renamed from: p */
    private CharSequence f2116p;

    /* renamed from: q */
    Message f2117q;

    /* renamed from: r */
    private Drawable f2118r;

    /* renamed from: s */
    Button f2119s;

    /* renamed from: t */
    private CharSequence f2120t;

    /* renamed from: u */
    Message f2121u;

    /* renamed from: v */
    private Drawable f2122v;

    /* renamed from: w */
    Button f2123w;

    /* renamed from: x */
    private CharSequence f2124x;

    /* renamed from: y */
    Message f2125y;

    /* renamed from: z */
    private Drawable f2126z;

    /* renamed from: android.support.v7.app.AlertController$RecycleListView */
    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f2127a;

        /* renamed from: b */
        private final int f2128b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray ta = context.obtainStyledAttributes(attrs, C0793R.styleable.RecycleListView);
            this.f2128b = ta.getDimensionPixelOffset(C0793R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f2127a = ta.getDimensionPixelOffset(C0793R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        /* renamed from: a */
        public void mo6052a(boolean hasTitle, boolean hasButtons) {
            if (!hasButtons || !hasTitle) {
                setPadding(getPaddingLeft(), hasTitle ? getPaddingTop() : this.f2127a, getPaddingRight(), hasButtons ? getPaddingBottom() : this.f2128b);
            }
        }
    }

    /* renamed from: android.support.v7.app.AlertController$a */
    public static class C0730a {

        /* renamed from: A */
        public int f2129A;

        /* renamed from: B */
        public int f2130B;

        /* renamed from: C */
        public int f2131C;

        /* renamed from: D */
        public int f2132D;

        /* renamed from: E */
        public boolean f2133E = false;

        /* renamed from: F */
        public boolean[] f2134F;

        /* renamed from: G */
        public boolean f2135G;

        /* renamed from: H */
        public boolean f2136H;

        /* renamed from: I */
        public int f2137I = -1;

        /* renamed from: J */
        public OnMultiChoiceClickListener f2138J;

        /* renamed from: K */
        public Cursor f2139K;

        /* renamed from: L */
        public String f2140L;

        /* renamed from: M */
        public String f2141M;

        /* renamed from: N */
        public OnItemSelectedListener f2142N;

        /* renamed from: O */
        public C0731a f2143O;

        /* renamed from: P */
        public boolean f2144P = true;

        /* renamed from: a */
        public final Context f2145a;

        /* renamed from: b */
        public final LayoutInflater f2146b;

        /* renamed from: c */
        public int f2147c = 0;

        /* renamed from: d */
        public Drawable f2148d;

        /* renamed from: e */
        public int f2149e = 0;

        /* renamed from: f */
        public CharSequence f2150f;

        /* renamed from: g */
        public View f2151g;

        /* renamed from: h */
        public CharSequence f2152h;

        /* renamed from: i */
        public CharSequence f2153i;

        /* renamed from: j */
        public Drawable f2154j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f2155k;

        /* renamed from: l */
        public CharSequence f2156l;

        /* renamed from: m */
        public Drawable f2157m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f2158n;

        /* renamed from: o */
        public CharSequence f2159o;

        /* renamed from: p */
        public Drawable f2160p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f2161q;

        /* renamed from: r */
        public boolean f2162r;

        /* renamed from: s */
        public OnCancelListener f2163s;

        /* renamed from: t */
        public OnDismissListener f2164t;

        /* renamed from: u */
        public OnKeyListener f2165u;

        /* renamed from: v */
        public CharSequence[] f2166v;

        /* renamed from: w */
        public ListAdapter f2167w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f2168x;

        /* renamed from: y */
        public int f2169y;

        /* renamed from: z */
        public View f2170z;

        /* renamed from: android.support.v7.app.AlertController$a$a */
        public interface C0731a {
            /* renamed from: a */
            void mo6054a(ListView listView);
        }

        public C0730a(Context context) {
            this.f2145a = context;
            this.f2162r = true;
            this.f2146b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: a */
        public void mo6053a(AlertController dialog) {
            View view = this.f2151g;
            if (view != null) {
                dialog.mo6047b(view);
            } else {
                CharSequence charSequence = this.f2150f;
                if (charSequence != null) {
                    dialog.mo6048b(charSequence);
                }
                Drawable drawable = this.f2148d;
                if (drawable != null) {
                    dialog.mo6042a(drawable);
                }
                int i = this.f2147c;
                if (i != 0) {
                    dialog.mo6046b(i);
                }
                int i2 = this.f2149e;
                if (i2 != 0) {
                    dialog.mo6046b(dialog.mo6039a(i2));
                }
            }
            CharSequence charSequence2 = this.f2152h;
            if (charSequence2 != null) {
                dialog.mo6044a(charSequence2);
            }
            if (!(this.f2153i == null && this.f2154j == null)) {
                dialog.mo6041a(-1, this.f2153i, this.f2155k, (Message) null, this.f2154j);
            }
            if (!(this.f2156l == null && this.f2157m == null)) {
                dialog.mo6041a(-2, this.f2156l, this.f2158n, (Message) null, this.f2157m);
            }
            if (!(this.f2159o == null && this.f2160p == null)) {
                dialog.mo6041a(-3, this.f2159o, this.f2161q, (Message) null, this.f2160p);
            }
            if (!(this.f2166v == null && this.f2139K == null && this.f2167w == null)) {
                m3391b(dialog);
            }
            View view2 = this.f2170z;
            if (view2 == null) {
                int i3 = this.f2169y;
                if (i3 != 0) {
                    dialog.mo6050c(i3);
                }
            } else if (this.f2133E) {
                dialog.mo6043a(view2, this.f2129A, this.f2130B, this.f2131C, this.f2132D);
            } else {
                dialog.mo6051c(view2);
            }
        }

        /* renamed from: b */
        private void m3391b(AlertController dialog) {
            ListAdapter adapter;
            int layout;
            RecycleListView listView = (RecycleListView) this.f2146b.inflate(dialog.f2093L, null);
            if (this.f2135G) {
                Cursor cursor = this.f2139K;
                if (cursor == null) {
                    C0770i iVar = new C0770i(this, this.f2145a, dialog.f2094M, 16908308, this.f2166v, listView);
                    adapter = iVar;
                } else {
                    C0771j jVar = new C0771j(this, this.f2145a, cursor, false, listView, dialog);
                    adapter = jVar;
                }
            } else {
                if (this.f2136H) {
                    layout = dialog.f2095N;
                } else {
                    layout = dialog.f2096O;
                }
                Cursor cursor2 = this.f2139K;
                if (cursor2 != null) {
                    SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this.f2145a, layout, cursor2, new String[]{this.f2140L}, new int[]{16908308});
                    adapter = simpleCursorAdapter;
                } else if (this.f2167w != null) {
                    adapter = this.f2167w;
                } else {
                    adapter = new C0733c(this.f2145a, layout, 16908308, this.f2166v);
                }
            }
            C0731a aVar = this.f2143O;
            if (aVar != null) {
                aVar.mo6054a(listView);
            }
            dialog.f2089H = adapter;
            dialog.f2090I = this.f2137I;
            if (this.f2168x != null) {
                listView.setOnItemClickListener(new C0772k(this, dialog));
            } else if (this.f2138J != null) {
                listView.setOnItemClickListener(new C0773l(this, listView, dialog));
            }
            OnItemSelectedListener onItemSelectedListener = this.f2142N;
            if (onItemSelectedListener != null) {
                listView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f2136H) {
                listView.setChoiceMode(1);
            } else if (this.f2135G) {
                listView.setChoiceMode(2);
            }
            dialog.f2107g = listView;
        }
    }

    /* renamed from: android.support.v7.app.AlertController$b */
    private static final class C0732b extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f2171a;

        public C0732b(DialogInterface dialog) {
            this.f2171a = new WeakReference<>(dialog);
        }

        public void handleMessage(Message msg) {
            int i = msg.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) msg.obj).onClick((DialogInterface) this.f2171a.get(), msg.what);
            } else if (i == 1) {
                ((DialogInterface) msg.obj).dismiss();
            }
        }
    }

    /* renamed from: android.support.v7.app.AlertController$c */
    private static class C0733c extends ArrayAdapter<CharSequence> {
        public C0733c(Context context, int resource, int textViewResourceId, CharSequence[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public boolean hasStableIds() {
            return true;
        }

        public long getItemId(int position) {
            return (long) position;
        }
    }

    /* renamed from: a */
    private static boolean m3370a(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(C0793R.attr.alertDialogCenterButtons, outValue, true);
        if (outValue.data != 0) {
            return true;
        }
        return false;
    }

    public AlertController(Context context, C0744F di, Window window) {
        this.f2101a = context;
        this.f2102b = di;
        this.f2103c = window;
        this.f2099R = new C0732b(di);
        TypedArray a = context.obtainStyledAttributes(null, C0793R.styleable.AlertDialog, C0793R.attr.alertDialogStyle, 0);
        this.f2091J = a.getResourceId(C0793R.styleable.AlertDialog_android_layout, 0);
        this.f2092K = a.getResourceId(C0793R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f2093L = a.getResourceId(C0793R.styleable.AlertDialog_listLayout, 0);
        this.f2094M = a.getResourceId(C0793R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f2095N = a.getResourceId(C0793R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f2096O = a.getResourceId(C0793R.styleable.AlertDialog_listItemLayout, 0);
        this.f2097P = a.getBoolean(C0793R.styleable.AlertDialog_showTitle, true);
        this.f2104d = a.getDimensionPixelSize(C0793R.styleable.AlertDialog_buttonIconDimen, 0);
        a.recycle();
        di.mo6131a(1);
    }

    /* renamed from: a */
    static boolean m3371a(View v) {
        if (v.onCheckIsTextEditor()) {
            return true;
        }
        if (!(v instanceof ViewGroup)) {
            return false;
        }
        ViewGroup vg = (ViewGroup) v;
        int i = vg.getChildCount();
        while (i > 0) {
            i--;
            if (m3371a(vg.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo6040a() {
        this.f2102b.setContentView(m3372b());
        m3374c();
    }

    /* renamed from: b */
    private int m3372b() {
        int i = this.f2092K;
        if (i == 0) {
            return this.f2091J;
        }
        if (this.f2098Q == 1) {
            return i;
        }
        return this.f2091J;
    }

    /* renamed from: b */
    public void mo6048b(CharSequence title) {
        this.f2105e = title;
        TextView textView = this.f2086E;
        if (textView != null) {
            textView.setText(title);
        }
    }

    /* renamed from: b */
    public void mo6047b(View customTitleView) {
        this.f2088G = customTitleView;
    }

    /* renamed from: a */
    public void mo6044a(CharSequence message) {
        this.f2106f = message;
        TextView textView = this.f2087F;
        if (textView != null) {
            textView.setText(message);
        }
    }

    /* renamed from: c */
    public void mo6050c(int layoutResId) {
        this.f2108h = null;
        this.f2109i = layoutResId;
        this.f2114n = false;
    }

    /* renamed from: c */
    public void mo6051c(View view) {
        this.f2108h = view;
        this.f2109i = 0;
        this.f2114n = false;
    }

    /* renamed from: a */
    public void mo6043a(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
        this.f2108h = view;
        this.f2109i = 0;
        this.f2114n = true;
        this.f2110j = viewSpacingLeft;
        this.f2111k = viewSpacingTop;
        this.f2112l = viewSpacingRight;
        this.f2113m = viewSpacingBottom;
    }

    /* renamed from: a */
    public void mo6041a(int whichButton, CharSequence text, DialogInterface.OnClickListener listener, Message msg, Drawable icon) {
        if (msg == null && listener != null) {
            msg = this.f2099R.obtainMessage(whichButton, listener);
        }
        if (whichButton == -3) {
            this.f2124x = text;
            this.f2125y = msg;
            this.f2126z = icon;
        } else if (whichButton == -2) {
            this.f2120t = text;
            this.f2121u = msg;
            this.f2122v = icon;
        } else if (whichButton == -1) {
            this.f2116p = text;
            this.f2117q = msg;
            this.f2118r = icon;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public void mo6046b(int resId) {
        this.f2084C = null;
        this.f2083B = resId;
        ImageView imageView = this.f2085D;
        if (imageView == null) {
            return;
        }
        if (resId != 0) {
            imageView.setVisibility(0);
            this.f2085D.setImageResource(this.f2083B);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: a */
    public void mo6042a(Drawable icon) {
        this.f2084C = icon;
        this.f2083B = 0;
        ImageView imageView = this.f2085D;
        if (imageView == null) {
            return;
        }
        if (icon != null) {
            imageView.setVisibility(0);
            this.f2085D.setImageDrawable(icon);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: a */
    public int mo6039a(int attrId) {
        TypedValue out = new TypedValue();
        this.f2101a.getTheme().resolveAttribute(attrId, out, true);
        return out.resourceId;
    }

    /* renamed from: a */
    public boolean mo6045a(int keyCode, KeyEvent event) {
        NestedScrollView nestedScrollView = this.f2082A;
        return nestedScrollView != null && nestedScrollView.mo5797a(event);
    }

    /* renamed from: b */
    public boolean mo6049b(int keyCode, KeyEvent event) {
        NestedScrollView nestedScrollView = this.f2082A;
        return nestedScrollView != null && nestedScrollView.mo5797a(event);
    }

    /* renamed from: a */
    private ViewGroup m3365a(View customPanel, View defaultPanel) {
        if (customPanel == null) {
            if (defaultPanel instanceof ViewStub) {
                defaultPanel = ((ViewStub) defaultPanel).inflate();
            }
            return (ViewGroup) defaultPanel;
        }
        if (defaultPanel != null) {
            ViewParent parent = defaultPanel.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(defaultPanel);
            }
        }
        if (customPanel instanceof ViewStub) {
            customPanel = ((ViewStub) customPanel).inflate();
        }
        return (ViewGroup) customPanel;
    }

    /* renamed from: c */
    private void m3374c() {
        View parentPanel = this.f2103c.findViewById(C0793R.C0794id.parentPanel);
        View defaultTopPanel = parentPanel.findViewById(C0793R.C0794id.topPanel);
        View defaultContentPanel = parentPanel.findViewById(C0793R.C0794id.contentPanel);
        View defaultButtonPanel = parentPanel.findViewById(C0793R.C0794id.buttonPanel);
        ViewGroup customPanel = (ViewGroup) parentPanel.findViewById(C0793R.C0794id.customPanel);
        m3375c(customPanel);
        View customTopPanel = customPanel.findViewById(C0793R.C0794id.topPanel);
        View customContentPanel = customPanel.findViewById(C0793R.C0794id.contentPanel);
        View customButtonPanel = customPanel.findViewById(C0793R.C0794id.buttonPanel);
        ViewGroup topPanel = m3365a(customTopPanel, defaultTopPanel);
        ViewGroup contentPanel = m3365a(customContentPanel, defaultContentPanel);
        ViewGroup buttonPanel = m3365a(customButtonPanel, defaultButtonPanel);
        m3373b(contentPanel);
        m3367a(buttonPanel);
        m3376d(topPanel);
        boolean hasCustomPanel = (customPanel == null || customPanel.getVisibility() == 8) ? false : true;
        boolean hasTopPanel = (topPanel == null || topPanel.getVisibility() == 8) ? false : true;
        boolean hasButtonPanel = (buttonPanel == null || buttonPanel.getVisibility() == 8) ? false : true;
        if (hasButtonPanel) {
        } else if (contentPanel != null) {
            View spacer = contentPanel.findViewById(C0793R.C0794id.textSpacerNoButtons);
            if (spacer != null) {
                View view = parentPanel;
                spacer.setVisibility(0);
            }
        }
        if (hasTopPanel) {
            NestedScrollView nestedScrollView = this.f2082A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View divider = null;
            if (!(this.f2106f == null && this.f2107g == null)) {
                divider = topPanel.findViewById(C0793R.C0794id.titleDividerNoCustom);
            }
            if (divider != null) {
                divider.setVisibility(0);
            }
        } else if (contentPanel != null) {
            View spacer2 = contentPanel.findViewById(C0793R.C0794id.textSpacerNoTitle);
            if (spacer2 != null) {
                spacer2.setVisibility(0);
            }
        }
        ListView listView = this.f2107g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).mo6052a(hasTopPanel, hasButtonPanel);
        }
        if (!hasCustomPanel) {
            View content = this.f2107g;
            if (content == null) {
                content = this.f2082A;
            }
            if (content != null) {
                View view2 = defaultTopPanel;
                m3368a(contentPanel, content, (hasTopPanel ? 1 : 0) | (hasButtonPanel ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f2107g;
        if (listView2 != null) {
            ListAdapter listAdapter = this.f2089H;
            if (listAdapter != null) {
                listView2.setAdapter(listAdapter);
                int checkedItem = this.f2090I;
                if (checkedItem > -1) {
                    listView2.setItemChecked(checkedItem, true);
                    listView2.setSelection(checkedItem);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3368a(ViewGroup contentPanel, View content, int indicators, int mask) {
        View indicatorUp = this.f2103c.findViewById(C0793R.C0794id.scrollIndicatorUp);
        View indicatorDown = this.f2103c.findViewById(C0793R.C0794id.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            C0646w.m2949a(content, indicators, mask);
            if (indicatorUp != null) {
                contentPanel.removeView(indicatorUp);
            }
            if (indicatorDown != null) {
                contentPanel.removeView(indicatorDown);
                return;
            }
            return;
        }
        if (indicatorUp != null && (indicators & 1) == 0) {
            contentPanel.removeView(indicatorUp);
            indicatorUp = null;
        }
        if (indicatorDown != null && (indicators & 2) == 0) {
            contentPanel.removeView(indicatorDown);
            indicatorDown = null;
        }
        if (indicatorUp != null || indicatorDown != null) {
            View top = indicatorUp;
            View bottom = indicatorDown;
            if (this.f2106f != null) {
                this.f2082A.setOnScrollChangeListener(new C0766e(this, top, bottom));
                this.f2082A.post(new C0767f(this, top, bottom));
                return;
            }
            ListView listView = this.f2107g;
            if (listView != null) {
                listView.setOnScrollListener(new C0768g(this, top, bottom));
                this.f2107g.post(new C0769h(this, top, bottom));
                return;
            }
            if (top != null) {
                contentPanel.removeView(top);
            }
            if (bottom != null) {
                contentPanel.removeView(bottom);
            }
        }
    }

    /* renamed from: c */
    private void m3375c(ViewGroup customPanel) {
        View customView;
        boolean hasCustomView = false;
        if (this.f2108h != null) {
            customView = this.f2108h;
        } else if (this.f2109i != 0) {
            customView = LayoutInflater.from(this.f2101a).inflate(this.f2109i, customPanel, false);
        } else {
            customView = null;
        }
        if (customView != null) {
            hasCustomView = true;
        }
        if (!hasCustomView || !m3371a(customView)) {
            this.f2103c.setFlags(Opcodes.ACC_DEPRECATED, Opcodes.ACC_DEPRECATED);
        }
        if (hasCustomView) {
            FrameLayout custom = (FrameLayout) this.f2103c.findViewById(C0793R.C0794id.custom);
            custom.addView(customView, new LayoutParams(-1, -1));
            if (this.f2114n) {
                custom.setPadding(this.f2110j, this.f2111k, this.f2112l, this.f2113m);
            }
            if (this.f2107g != null) {
                ((C1102a) customPanel.getLayoutParams()).f3676a = 0.0f;
                return;
            }
            return;
        }
        customPanel.setVisibility(8);
    }

    /* renamed from: d */
    private void m3376d(ViewGroup topPanel) {
        if (this.f2088G != null) {
            topPanel.addView(this.f2088G, 0, new LayoutParams(-1, -2));
            this.f2103c.findViewById(C0793R.C0794id.title_template).setVisibility(8);
            return;
        }
        this.f2085D = (ImageView) this.f2103c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f2105e)) || !this.f2097P) {
            this.f2103c.findViewById(C0793R.C0794id.title_template).setVisibility(8);
            this.f2085D.setVisibility(8);
            topPanel.setVisibility(8);
            return;
        }
        this.f2086E = (TextView) this.f2103c.findViewById(C0793R.C0794id.alertTitle);
        this.f2086E.setText(this.f2105e);
        int i = this.f2083B;
        if (i != 0) {
            this.f2085D.setImageResource(i);
            return;
        }
        Drawable drawable = this.f2084C;
        if (drawable != null) {
            this.f2085D.setImageDrawable(drawable);
            return;
        }
        this.f2086E.setPadding(this.f2085D.getPaddingLeft(), this.f2085D.getPaddingTop(), this.f2085D.getPaddingRight(), this.f2085D.getPaddingBottom());
        this.f2085D.setVisibility(8);
    }

    /* renamed from: b */
    private void m3373b(ViewGroup contentPanel) {
        this.f2082A = (NestedScrollView) this.f2103c.findViewById(C0793R.C0794id.scrollView);
        this.f2082A.setFocusable(false);
        this.f2082A.setNestedScrollingEnabled(false);
        this.f2087F = (TextView) contentPanel.findViewById(16908299);
        TextView textView = this.f2087F;
        if (textView != null) {
            CharSequence charSequence = this.f2106f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                this.f2082A.removeView(this.f2087F);
                if (this.f2107g != null) {
                    ViewGroup scrollParent = (ViewGroup) this.f2082A.getParent();
                    int childIndex = scrollParent.indexOfChild(this.f2082A);
                    scrollParent.removeViewAt(childIndex);
                    scrollParent.addView(this.f2107g, childIndex, new LayoutParams(-1, -1));
                } else {
                    contentPanel.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: a */
    static void m3366a(View v, View upIndicator, View downIndicator) {
        int i = 0;
        if (upIndicator != null) {
            upIndicator.setVisibility(v.canScrollVertically(-1) ? 0 : 4);
        }
        if (downIndicator != null) {
            if (!v.canScrollVertically(1)) {
                i = 4;
            }
            downIndicator.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m3367a(ViewGroup buttonPanel) {
        int whichButtons = 0;
        this.f2115o = (Button) buttonPanel.findViewById(16908313);
        this.f2115o.setOnClickListener(this.f2100S);
        boolean z = false;
        if (!TextUtils.isEmpty(this.f2116p) || this.f2118r != null) {
            this.f2115o.setText(this.f2116p);
            Drawable drawable = this.f2118r;
            if (drawable != null) {
                int i = this.f2104d;
                drawable.setBounds(0, 0, i, i);
                this.f2115o.setCompoundDrawables(this.f2118r, null, null, null);
            }
            this.f2115o.setVisibility(0);
            whichButtons = 0 | 1;
        } else {
            this.f2115o.setVisibility(8);
        }
        this.f2119s = (Button) buttonPanel.findViewById(16908314);
        this.f2119s.setOnClickListener(this.f2100S);
        if (!TextUtils.isEmpty(this.f2120t) || this.f2122v != null) {
            this.f2119s.setText(this.f2120t);
            Drawable drawable2 = this.f2122v;
            if (drawable2 != null) {
                int i2 = this.f2104d;
                drawable2.setBounds(0, 0, i2, i2);
                this.f2119s.setCompoundDrawables(this.f2122v, null, null, null);
            }
            this.f2119s.setVisibility(0);
            whichButtons |= 2;
        } else {
            this.f2119s.setVisibility(8);
        }
        this.f2123w = (Button) buttonPanel.findViewById(16908315);
        this.f2123w.setOnClickListener(this.f2100S);
        if (!TextUtils.isEmpty(this.f2124x) || this.f2126z != null) {
            this.f2123w.setText(this.f2124x);
            Drawable drawable3 = this.f2118r;
            if (drawable3 != null) {
                int i3 = this.f2104d;
                drawable3.setBounds(0, 0, i3, i3);
                this.f2115o.setCompoundDrawables(this.f2118r, null, null, null);
            }
            this.f2123w.setVisibility(0);
            whichButtons |= 4;
        } else {
            this.f2123w.setVisibility(8);
        }
        if (m3370a(this.f2101a)) {
            if (whichButtons == 1) {
                m3369a(this.f2115o);
            } else if (whichButtons == 2) {
                m3369a(this.f2119s);
            } else if (whichButtons == 4) {
                m3369a(this.f2123w);
            }
        }
        if (whichButtons != 0) {
            z = true;
        }
        if (!z) {
            buttonPanel.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m3369a(Button button) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = 1;
        params.weight = 0.5f;
        button.setLayoutParams(params);
    }
}
