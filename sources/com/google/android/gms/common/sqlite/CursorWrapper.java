package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {

    /* renamed from: a */
    private AbstractWindowedCursor f20250a;

    @KeepForSdk
    public CursorWindow getWindow() {
        return this.f20250a.getWindow();
    }

    @KeepForSdk
    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.f20250a.fillWindow(i, cursorWindow);
    }

    public boolean onMove(int i, int i2) {
        return this.f20250a.onMove(i, i2);
    }

    public /* synthetic */ Cursor getWrappedCursor() {
        return this.f20250a;
    }
}
