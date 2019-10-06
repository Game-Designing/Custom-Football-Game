package android.support.p000v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v4.content.FileProvider */
public class FileProvider extends ContentProvider {

    /* renamed from: a */
    private static final String[] f1633a = {"_display_name", "_size"};

    /* renamed from: b */
    private static final File f1634b = new File("/");

    /* renamed from: c */
    private static HashMap<String, C0496a> f1635c = new HashMap<>();

    /* renamed from: d */
    private C0496a f1636d;

    /* renamed from: android.support.v4.content.FileProvider$a */
    interface C0496a {
        /* renamed from: a */
        Uri mo5258a(File file);

        /* renamed from: a */
        File mo5259a(Uri uri);
    }

    /* renamed from: android.support.v4.content.FileProvider$b */
    static class C0497b implements C0496a {

        /* renamed from: a */
        private final String f1637a;

        /* renamed from: b */
        private final HashMap<String, File> f1638b = new HashMap<>();

        C0497b(String authority) {
            this.f1637a = authority;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5260a(String name, File root) {
            if (!TextUtils.isEmpty(name)) {
                try {
                    this.f1638b.put(name, root.getCanonicalFile());
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to resolve canonical path for ");
                    sb.append(root);
                    throw new IllegalArgumentException(sb.toString(), e);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }

        /* renamed from: a */
        public Uri mo5258a(File file) {
            String path;
            try {
                String path2 = file.getCanonicalPath();
                Entry<String, File> mostSpecific = null;
                for (Entry<String, File> root : this.f1638b.entrySet()) {
                    String rootPath = ((File) root.getValue()).getPath();
                    if (path2.startsWith(rootPath) && (mostSpecific == null || rootPath.length() > ((File) mostSpecific.getValue()).getPath().length())) {
                        mostSpecific = root;
                    }
                }
                if (mostSpecific != null) {
                    String rootPath2 = ((File) mostSpecific.getValue()).getPath();
                    String str = "/";
                    if (rootPath2.endsWith(str)) {
                        path = path2.substring(rootPath2.length());
                    } else {
                        path = path2.substring(rootPath2.length() + 1);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(Uri.encode((String) mostSpecific.getKey()));
                    sb.append('/');
                    sb.append(Uri.encode(path, str));
                    return new Builder().scheme("content").authority(this.f1637a).encodedPath(sb.toString()).build();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to find configured root that contains ");
                sb2.append(path2);
                throw new IllegalArgumentException(sb2.toString());
            } catch (IOException e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to resolve canonical path for ");
                sb3.append(file);
                throw new IllegalArgumentException(sb3.toString());
            }
        }

        /* renamed from: a */
        public File mo5259a(Uri uri) {
            String path = uri.getEncodedPath();
            int splitIndex = path.indexOf(47, 1);
            String tag = Uri.decode(path.substring(1, splitIndex));
            String path2 = Uri.decode(path.substring(splitIndex + 1));
            File root = (File) this.f1638b.get(tag);
            if (root != null) {
                File file = new File(root, path2);
                try {
                    File file2 = file.getCanonicalFile();
                    if (file2.getPath().startsWith(root.getPath())) {
                        return file2;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to resolve canonical path for ");
                    sb.append(file);
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to find configured root for ");
                sb2.append(uri);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo info) {
        super.attachInfo(context, info);
        if (info.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (info.grantUriPermissions) {
            this.f1636d = m2500a(context, info.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    /* renamed from: a */
    public static Uri m2499a(Context context, String authority, File file) {
        return m2500a(context, authority).mo5258a(file);
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        File file = this.f1636d.mo5259a(uri);
        if (projection == null) {
            projection = f1633a;
        }
        String[] cols = new String[projection.length];
        Object[] values = new Object[projection.length];
        int i = 0;
        for (String col : projection) {
            String str = "_display_name";
            if (str.equals(col)) {
                cols[i] = str;
                int i2 = i + 1;
                values[i] = file.getName();
                i = i2;
            } else {
                String str2 = "_size";
                if (str2.equals(col)) {
                    cols[i] = str2;
                    int i3 = i + 1;
                    values[i] = Long.valueOf(file.length());
                    i = i3;
                }
            }
        }
        String[] cols2 = m2503a(cols, i);
        Object[] values2 = m2502a(values, i);
        MatrixCursor cursor = new MatrixCursor(cols2, 1);
        cursor.addRow(values2);
        return cursor;
    }

    public String getType(Uri uri) {
        File file = this.f1636d.mo5259a(uri);
        int lastDot = file.getName().lastIndexOf(46);
        if (lastDot >= 0) {
            String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(file.getName().substring(lastDot + 1));
            if (mime != null) {
                return mime;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return this.f1636d.mo5259a(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f1636d.mo5259a(uri), m2498a(mode));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.support.p000v4.content.FileProvider.C0496a m2500a(android.content.Context r5, java.lang.String r6) {
        /*
            java.util.HashMap<java.lang.String, android.support.v4.content.FileProvider$a> r0 = f1635c
            monitor-enter(r0)
            r1 = 0
            java.util.HashMap<java.lang.String, android.support.v4.content.FileProvider$a> r2 = f1635c     // Catch:{ all -> 0x002f }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x002f }
            android.support.v4.content.FileProvider$a r2 = (android.support.p000v4.content.FileProvider.C0496a) r2     // Catch:{ all -> 0x002f }
            r1 = r2
            if (r1 != 0) goto L_0x002d
            android.support.v4.content.FileProvider$a r2 = m2504b(r5, r6)     // Catch:{ IOException -> 0x0024, XmlPullParserException -> 0x001b }
            r1 = r2
            java.util.HashMap<java.lang.String, android.support.v4.content.FileProvider$a> r2 = f1635c     // Catch:{ all -> 0x0032 }
            r2.put(r6, r1)     // Catch:{ all -> 0x0032 }
            goto L_0x002d
        L_0x001b:
            r2 = move-exception
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
            r3.<init>(r4, r2)     // Catch:{ all -> 0x0032 }
            throw r3     // Catch:{ all -> 0x0032 }
        L_0x0024:
            r2 = move-exception
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
            r3.<init>(r4, r2)     // Catch:{ all -> 0x0032 }
            throw r3     // Catch:{ all -> 0x0032 }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r1
        L_0x002f:
            r2 = move-exception
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r2
        L_0x0032:
            r2 = move-exception
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.FileProvider.m2500a(android.content.Context, java.lang.String):android.support.v4.content.FileProvider$a");
    }

    /* renamed from: b */
    private static C0496a m2504b(Context context, String authority) throws IOException, XmlPullParserException {
        C0497b strat = new C0497b(authority);
        XmlResourceParser in = context.getPackageManager().resolveContentProvider(authority, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (in != null) {
            while (true) {
                int next = in.next();
                int type = next;
                if (next == 1) {
                    return strat;
                }
                if (type == 2) {
                    String tag = in.getName();
                    String name = in.getAttributeValue(null, "name");
                    String path = in.getAttributeValue(null, "path");
                    File target = null;
                    if ("root-path".equals(tag)) {
                        target = f1634b;
                    } else if ("files-path".equals(tag)) {
                        target = context.getFilesDir();
                    } else if ("cache-path".equals(tag)) {
                        target = context.getCacheDir();
                    } else if ("external-path".equals(tag)) {
                        target = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(tag)) {
                        File[] externalFilesDirs = C0510b.m2571b(context, (String) null);
                        if (externalFilesDirs.length > 0) {
                            target = externalFilesDirs[0];
                        }
                    } else if ("external-cache-path".equals(tag)) {
                        File[] externalCacheDirs = C0510b.m2570b(context);
                        if (externalCacheDirs.length > 0) {
                            target = externalCacheDirs[0];
                        }
                    } else if (VERSION.SDK_INT >= 21 && "external-media-path".equals(tag)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            target = externalMediaDirs[0];
                        }
                    }
                    if (target != null) {
                        strat.mo5260a(name, m2501a(target, path));
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    }

    /* renamed from: a */
    private static int m2498a(String mode) {
        if ("r".equals(mode)) {
            return 268435456;
        }
        if ("w".equals(mode) || "wt".equals(mode)) {
            return 738197504;
        }
        if ("wa".equals(mode)) {
            return 704643072;
        }
        if ("rw".equals(mode)) {
            return 939524096;
        }
        if ("rwt".equals(mode)) {
            return 1006632960;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid mode: ");
        sb.append(mode);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private static File m2501a(File base, String... segments) {
        File cur = base;
        for (String segment : segments) {
            if (segment != null) {
                cur = new File(cur, segment);
            }
        }
        return cur;
    }

    /* renamed from: a */
    private static String[] m2503a(String[] original, int newLength) {
        String[] result = new String[newLength];
        System.arraycopy(original, 0, result, 0, newLength);
        return result;
    }

    /* renamed from: a */
    private static Object[] m2502a(Object[] original, int newLength) {
        Object[] result = new Object[newLength];
        System.arraycopy(original, 0, result, 0, newLength);
        return result;
    }
}
