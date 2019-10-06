package p024io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* renamed from: io.fabric.sdk.android.g */
/* compiled from: FabricContext */
class C13922g extends ContextWrapper {

    /* renamed from: a */
    private final String f42243a;

    /* renamed from: b */
    private final String f42244b;

    public C13922g(Context base, String componentName, String componentPath) {
        super(base);
        this.f42244b = componentName;
        this.f42243a = componentPath;
    }

    public File getDatabasePath(String name) {
        File dir = new File(super.getDatabasePath(name).getParentFile(), this.f42243a);
        dir.mkdirs();
        return new File(dir, name);
    }

    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
    }

    @TargetApi(11)
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name).getPath(), factory, errorHandler);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f42243a);
    }

    @TargetApi(8)
    public File getExternalFilesDir(String type) {
        return new File(super.getExternalFilesDir(type), this.f42243a);
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f42243a);
    }

    @TargetApi(8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f42243a);
    }

    public SharedPreferences getSharedPreferences(String name, int mode) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42244b);
        sb.append(":");
        sb.append(name);
        return super.getSharedPreferences(sb.toString(), mode);
    }
}
