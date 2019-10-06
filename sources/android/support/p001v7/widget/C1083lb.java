package android.support.p001v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.widget.C0721s;
import android.support.p001v7.appcompat.C0793R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: android.support.v7.widget.lb */
/* compiled from: SuggestionsAdapter */
class C1083lb extends C0721s implements OnClickListener {

    /* renamed from: d */
    private final SearchManager f3597d = ((SearchManager) this.mContext.getSystemService("search"));

    /* renamed from: e */
    private final SearchView f3598e;

    /* renamed from: f */
    private final SearchableInfo f3599f;

    /* renamed from: g */
    private final Context f3600g;

    /* renamed from: h */
    private final WeakHashMap<String, ConstantState> f3601h;

    /* renamed from: i */
    private final int f3602i;

    /* renamed from: j */
    private boolean f3603j = false;

    /* renamed from: k */
    private int f3604k = 1;

    /* renamed from: l */
    private ColorStateList f3605l;

    /* renamed from: m */
    private int f3606m = -1;

    /* renamed from: n */
    private int f3607n = -1;

    /* renamed from: o */
    private int f3608o = -1;

    /* renamed from: p */
    private int f3609p = -1;

    /* renamed from: q */
    private int f3610q = -1;

    /* renamed from: r */
    private int f3611r = -1;

    /* renamed from: android.support.v7.widget.lb$a */
    /* compiled from: SuggestionsAdapter */
    private static final class C1084a {

        /* renamed from: a */
        public final TextView f3612a;

        /* renamed from: b */
        public final TextView f3613b;

        /* renamed from: c */
        public final ImageView f3614c;

        /* renamed from: d */
        public final ImageView f3615d;

        /* renamed from: e */
        public final ImageView f3616e;

        public C1084a(View v) {
            this.f3612a = (TextView) v.findViewById(16908308);
            this.f3613b = (TextView) v.findViewById(16908309);
            this.f3614c = (ImageView) v.findViewById(16908295);
            this.f3615d = (ImageView) v.findViewById(16908296);
            this.f3616e = (ImageView) v.findViewById(C0793R.C0794id.edit_query);
        }
    }

    public C1083lb(Context context, SearchView searchView, SearchableInfo searchable, WeakHashMap<String, ConstantState> outsideDrawablesCache) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f3598e = searchView;
        this.f3599f = searchable;
        this.f3602i = searchView.getSuggestionCommitIconResId();
        this.f3600g = context;
        this.f3601h = outsideDrawablesCache;
    }

    /* renamed from: a */
    public void mo8523a(int refineWhat) {
        this.f3604k = refineWhat;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        String query = constraint == null ? "" : constraint.toString();
        if (this.f3598e.getVisibility() != 0 || this.f3598e.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor = mo8521a(this.f3599f, query, 50);
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m5376d(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m5376d(getCursor());
    }

    /* renamed from: d */
    private void m5376d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void changeCursor(Cursor c) {
        String str = "SuggestionsAdapter";
        if (this.f3603j) {
            Log.w(str, "Tried to change cursor after adapter was closed.");
            if (c != null) {
                c.close();
            }
            return;
        }
        try {
            super.changeCursor(c);
            if (c != null) {
                this.f3606m = c.getColumnIndex("suggest_text_1");
                this.f3607n = c.getColumnIndex("suggest_text_2");
                this.f3608o = c.getColumnIndex("suggest_text_2_url");
                this.f3609p = c.getColumnIndex("suggest_icon_1");
                this.f3610q = c.getColumnIndex("suggest_icon_2");
                this.f3611r = c.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e(str, "error changing cursor and caching columns", e);
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.newView(context, cursor, parent);
        v.setTag(new C1084a(v));
        ((ImageView) v.findViewById(C0793R.C0794id.edit_query)).setImageResource(this.f3602i);
        return v;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        CharSequence text2;
        C1084a views = (C1084a) view.getTag();
        int flags = 0;
        int i = this.f3611r;
        if (i != -1) {
            flags = cursor.getInt(i);
        }
        if (views.f3612a != null) {
            m5368a(views.f3612a, (CharSequence) m5365a(cursor, this.f3606m));
        }
        if (views.f3613b != null) {
            CharSequence text22 = m5365a(cursor, this.f3608o);
            if (text22 != null) {
                text2 = m5364a(text22);
            } else {
                text2 = m5365a(cursor, this.f3607n);
            }
            if (TextUtils.isEmpty(text2)) {
                TextView textView = views.f3612a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    views.f3612a.setMaxLines(2);
                }
            } else {
                TextView textView2 = views.f3612a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    views.f3612a.setMaxLines(1);
                }
            }
            m5368a(views.f3613b, text2);
        }
        ImageView imageView = views.f3614c;
        if (imageView != null) {
            m5367a(imageView, m5371b(cursor), 4);
        }
        ImageView imageView2 = views.f3615d;
        if (imageView2 != null) {
            m5367a(imageView2, m5374c(cursor), 8);
        }
        int i2 = this.f3604k;
        if (i2 == 2 || (i2 == 1 && (flags & 1) != 0)) {
            views.f3616e.setVisibility(0);
            views.f3616e.setTag(views.f3612a.getText());
            views.f3616e.setOnClickListener(this);
            return;
        }
        views.f3616e.setVisibility(8);
    }

    public void onClick(View v) {
        Object tag = v.getTag();
        if (tag instanceof CharSequence) {
            this.f3598e.onQueryRefine((CharSequence) tag);
        }
    }

    /* renamed from: a */
    private CharSequence m5364a(CharSequence url) {
        if (this.f3605l == null) {
            TypedValue colorValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0793R.attr.textColorSearchUrl, colorValue, true);
            this.f3605l = this.mContext.getResources().getColorStateList(colorValue.resourceId);
        }
        SpannableString text = new SpannableString(url);
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, this.f3605l, null);
        text.setSpan(textAppearanceSpan, 0, url.length(), 33);
        return text;
    }

    /* renamed from: a */
    private void m5368a(TextView v, CharSequence text) {
        v.setText(text);
        if (TextUtils.isEmpty(text)) {
            v.setVisibility(8);
        } else {
            v.setVisibility(0);
        }
    }

    /* renamed from: b */
    private Drawable m5371b(Cursor cursor) {
        int i = this.f3609p;
        if (i == -1) {
            return null;
        }
        Drawable drawable = m5375c(cursor.getString(i));
        if (drawable != null) {
            return drawable;
        }
        return m5363a(cursor);
    }

    /* renamed from: c */
    private Drawable m5374c(Cursor cursor) {
        int i = this.f3610q;
        if (i == -1) {
            return null;
        }
        return m5375c(cursor.getString(i));
    }

    /* renamed from: a */
    private void m5367a(ImageView v, Drawable drawable, int nullVisibility) {
        v.setImageDrawable(drawable);
        if (drawable == null) {
            v.setVisibility(nullVisibility);
            return;
        }
        v.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String query = m5366a(cursor, "suggest_intent_query");
        if (query != null) {
            return query;
        }
        if (this.f3599f.shouldRewriteQueryFromData()) {
            String data = m5366a(cursor, "suggest_intent_data");
            if (data != null) {
                return data;
            }
        }
        if (this.f3599f.shouldRewriteQueryFromText()) {
            String text1 = m5366a(cursor, "suggest_text_1");
            if (text1 != null) {
                return text1;
            }
        }
        return null;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View v = newView(this.mContext, this.mCursor, parent);
            if (v != null) {
                ((C1084a) v.getTag()).f3612a.setText(e.toString());
            }
            return v;
        }
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getDropDownView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View v = newDropDownView(this.mContext, this.mCursor, parent);
            if (v != null) {
                ((C1084a) v.getTag()).f3612a.setText(e.toString());
            }
            return v;
        }
    }

    /* renamed from: c */
    private Drawable m5375c(String drawableId) {
        if (drawableId == null || drawableId.isEmpty() || BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID.equals(drawableId)) {
            return null;
        }
        try {
            int resourceId = Integer.parseInt(drawableId);
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.f3600g.getPackageName());
            sb.append("/");
            sb.append(resourceId);
            String drawableUri = sb.toString();
            Drawable drawable = m5373b(drawableUri);
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable2 = C0510b.m2572c(this.f3600g, resourceId);
            m5369a(drawableUri, drawable2);
            return drawable2;
        } catch (NumberFormatException e) {
            Drawable drawable3 = m5373b(drawableId);
            if (drawable3 != null) {
                return drawable3;
            }
            Drawable drawable4 = m5372b(Uri.parse(drawableId));
            m5369a(drawableId, drawable4);
            return drawable4;
        } catch (NotFoundException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Icon resource not found: ");
            sb2.append(drawableId);
            Log.w("SuggestionsAdapter", sb2.toString());
            return null;
        }
    }

    /* renamed from: b */
    private Drawable m5372b(Uri uri) {
        InputStream stream;
        String str = "Error closing icon stream for ";
        String str2 = "SuggestionsAdapter";
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return mo8522a(uri);
            }
            stream = this.f3600g.getContentResolver().openInputStream(uri);
            if (stream != null) {
                Drawable createFromStream = Drawable.createFromStream(stream, null);
                try {
                    stream.close();
                } catch (IOException ex) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(uri);
                    Log.e(str2, sb.toString(), ex);
                }
                return createFromStream;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to open ");
            sb2.append(uri);
            throw new FileNotFoundException(sb2.toString());
        } catch (NotFoundException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Resource does not exist: ");
            sb3.append(uri);
            throw new FileNotFoundException(sb3.toString());
        } catch (FileNotFoundException fnfe) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Icon not found: ");
            sb4.append(uri);
            sb4.append(", ");
            sb4.append(fnfe.getMessage());
            Log.w(str2, sb4.toString());
            return null;
        } catch (Throwable th) {
            try {
                stream.close();
            } catch (IOException ex2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(uri);
                Log.e(str2, sb5.toString(), ex2);
            }
            throw th;
        }
    }

    /* renamed from: b */
    private Drawable m5373b(String resourceUri) {
        ConstantState cached = (ConstantState) this.f3601h.get(resourceUri);
        if (cached == null) {
            return null;
        }
        return cached.newDrawable();
    }

    /* renamed from: a */
    private void m5369a(String resourceUri, Drawable drawable) {
        if (drawable != null) {
            this.f3601h.put(resourceUri, drawable.getConstantState());
        }
    }

    /* renamed from: a */
    private Drawable m5363a(Cursor cursor) {
        Drawable drawable = m5370b(this.f3599f.getSearchActivity());
        if (drawable != null) {
            return drawable;
        }
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.graphics.drawable.Drawable$ConstantState] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.graphics.drawable.Drawable, android.graphics.drawable.Drawable$ConstantState]
      uses: [java.lang.Object, android.graphics.drawable.Drawable]
      mth insns count: 21
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m5370b(android.content.ComponentName r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.flattenToShortString()
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r1 = r4.f3601h
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0023
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r1 = r4.f3601h
            java.lang.Object r1 = r1.get(r0)
            android.graphics.drawable.Drawable$ConstantState r1 = (android.graphics.drawable.Drawable.ConstantState) r1
            if (r1 != 0) goto L_0x0018
            goto L_0x0022
        L_0x0018:
            android.content.Context r2 = r4.f3600g
            android.content.res.Resources r2 = r2.getResources()
            android.graphics.drawable.Drawable r2 = r1.newDrawable(r2)
        L_0x0022:
            return r2
        L_0x0023:
            android.graphics.drawable.Drawable r1 = r4.m5362a(r5)
            if (r1 != 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            android.graphics.drawable.Drawable$ConstantState r2 = r1.getConstantState()
        L_0x002e:
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r3 = r4.f3601h
            r3.put(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.C1083lb.m5370b(android.content.ComponentName):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    private Drawable m5362a(ComponentName component) {
        String str = "SuggestionsAdapter";
        PackageManager pm = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = pm.getActivityInfo(component, 128);
            int iconId = activityInfo.getIconResource();
            if (iconId == 0) {
                return null;
            }
            Drawable drawable = pm.getDrawable(component.getPackageName(), iconId, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid icon resource ");
            sb.append(iconId);
            sb.append(" for ");
            sb.append(component.flattenToShortString());
            Log.w(str, sb.toString());
            return null;
        } catch (NameNotFoundException ex) {
            Log.w(str, ex.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static String m5366a(Cursor cursor, String columnName) {
        return m5365a(cursor, cursor.getColumnIndex(columnName));
    }

    /* renamed from: a */
    private static String m5365a(Cursor cursor, int col) {
        if (col == -1) {
            return null;
        }
        try {
            return cursor.getString(col);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Drawable mo8522a(Uri uri) throws FileNotFoundException {
        int id;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources r = this.mContext.getPackageManager().getResourcesForApplication(authority);
                List<String> path = uri.getPathSegments();
                if (path != null) {
                    int len = path.size();
                    if (len == 1) {
                        try {
                            id = Integer.parseInt((String) path.get(0));
                        } catch (NumberFormatException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Single path segment is not a resource ID: ");
                            sb.append(uri);
                            throw new FileNotFoundException(sb.toString());
                        }
                    } else if (len == 2) {
                        id = r.getIdentifier((String) path.get(1), (String) path.get(0), authority);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("More than two path segments: ");
                        sb2.append(uri);
                        throw new FileNotFoundException(sb2.toString());
                    }
                    if (id != 0) {
                        return r.getDrawable(id);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("No resource found for: ");
                    sb3.append(uri);
                    throw new FileNotFoundException(sb3.toString());
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("No path: ");
                sb4.append(uri);
                throw new FileNotFoundException(sb4.toString());
            } catch (NameNotFoundException e2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("No package found for authority: ");
                sb5.append(uri);
                throw new FileNotFoundException(sb5.toString());
            }
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("No authority: ");
            sb6.append(uri);
            throw new FileNotFoundException(sb6.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Cursor mo8521a(SearchableInfo searchable, String query, int limit) {
        String[] selArgs;
        if (searchable == null) {
            return null;
        }
        String authority = searchable.getSuggestAuthority();
        if (authority == null) {
            return null;
        }
        String str = "";
        Builder uriBuilder = new Builder().scheme("content").authority(authority).query(str).fragment(str);
        String contentPath = searchable.getSuggestPath();
        if (contentPath != null) {
            uriBuilder.appendEncodedPath(contentPath);
        }
        uriBuilder.appendPath("search_suggest_query");
        String selection = searchable.getSuggestSelection();
        if (selection != null) {
            selArgs = new String[]{query};
        } else {
            uriBuilder.appendPath(query);
            selArgs = null;
        }
        if (limit > 0) {
            uriBuilder.appendQueryParameter("limit", String.valueOf(limit));
        }
        return this.mContext.getContentResolver().query(uriBuilder.build(), null, selection, selArgs, null);
    }
}
