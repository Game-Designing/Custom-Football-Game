package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.C6787r;

public final class FacebookInitProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f12183a = FacebookInitProvider.class.getSimpleName();

    public boolean onCreate() {
        try {
            C6787r.m13813c(getContext());
        } catch (Exception ex) {
            Log.i(f12183a, "Failed to auto initialize the Facebook SDK", ex);
        }
        return false;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}