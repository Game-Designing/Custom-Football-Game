package android.support.p000v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* renamed from: android.support.v4.widget.j */
/* compiled from: CursorAdapter */
public abstract class C0700j extends BaseAdapter implements Filterable, C0704a {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected C0701a mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected C0703k mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    /* renamed from: android.support.v4.widget.j$a */
    /* compiled from: CursorAdapter */
    private class C0701a extends ContentObserver {
        C0701a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean selfChange) {
            C0700j.this.onContentChanged();
        }
    }

    /* renamed from: android.support.v4.widget.j$b */
    /* compiled from: CursorAdapter */
    private class C0702b extends DataSetObserver {
        C0702b() {
        }

        public void onChanged() {
            C0700j jVar = C0700j.this;
            jVar.mDataValid = true;
            jVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            C0700j jVar = C0700j.this;
            jVar.mDataValid = false;
            jVar.notifyDataSetInvalidated();
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    @Deprecated
    public C0700j(Context context, Cursor c) {
        init(context, c, 1);
    }

    public C0700j(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? 1 : 2);
    }

    public C0700j(Context context, Cursor c, int flags) {
        init(context, c, flags);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? 1 : 2);
    }

    /* access modifiers changed from: 0000 */
    public void init(Context context, Cursor c, int flags) {
        boolean z = false;
        if ((flags & 1) == 1) {
            flags |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        if (c != null) {
            z = true;
        }
        boolean cursorPresent = z;
        this.mCursor = c;
        this.mDataValid = cursorPresent;
        this.mContext = context;
        this.mRowIDColumn = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;
        if ((flags & 2) == 2) {
            this.mChangeObserver = new C0701a();
            this.mDataSetObserver = new C0702b();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (cursorPresent) {
            C0701a aVar = this.mChangeObserver;
            if (aVar != null) {
                c.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                c.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public int getCount() {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null) {
                return cursor.getCount();
            }
        }
        return 0;
    }

    public Object getItem(int position) {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null) {
                cursor.moveToPosition(position);
                return this.mCursor;
            }
        }
        return null;
    }

    public long getItemId(int position) {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor == null || !cursor.moveToPosition(position)) {
                return 0;
            }
            return this.mCursor.getLong(this.mRowIDColumn);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.mCursor.moveToPosition(position)) {
            if (convertView == null) {
                v = newView(this.mContext, this.mCursor, parent);
            } else {
                v = convertView;
            }
            bindView(v, this.mContext, this.mCursor);
            return v;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("couldn't move cursor to position ");
            sb.append(position);
            throw new IllegalStateException(sb.toString());
        }
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v;
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(position);
        if (convertView == null) {
            v = newDropDownView(this.mContext, this.mCursor, parent);
        } else {
            v = convertView;
        }
        bindView(v, this.mContext, this.mCursor);
        return v;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        return newView(context, cursor, parent);
    }

    public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        if (old != null) {
            old.close();
        }
    }

    public Cursor swapCursor(Cursor newCursor) {
        if (newCursor == this.mCursor) {
            return null;
        }
        Cursor oldCursor = this.mCursor;
        if (oldCursor != null) {
            C0701a aVar = this.mChangeObserver;
            if (aVar != null) {
                oldCursor.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                oldCursor.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = newCursor;
        if (newCursor != null) {
            C0701a aVar2 = this.mChangeObserver;
            if (aVar2 != null) {
                newCursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                newCursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = newCursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return oldCursor;
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(constraint);
        }
        return this.mCursor;
    }

    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new C0703k(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    /* access modifiers changed from: protected */
    public void onContentChanged() {
        if (this.mAutoRequery) {
            Cursor cursor = this.mCursor;
            if (cursor != null && !cursor.isClosed()) {
                this.mDataValid = this.mCursor.requery();
            }
        }
    }
}
