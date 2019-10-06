package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.upstream.cache.p */
/* compiled from: SimpleCacheSpan */
final class C8480p extends C8469e {

    /* renamed from: g */
    private static final Pattern f18707g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h */
    private static final Pattern f18708h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: i */
    private static final Pattern f18709i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    /* renamed from: a */
    public static File m20312a(File cacheDir, int id, long position, long lastAccessTimestamp) {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        String str = ".";
        sb.append(str);
        sb.append(position);
        sb.append(str);
        sb.append(lastAccessTimestamp);
        sb.append(".v3.exo");
        return new File(cacheDir, sb.toString());
    }

    /* renamed from: a */
    public static C8480p m20310a(String key, long position) {
        C8480p pVar = new C8480p(key, position, -1, -9223372036854775807L, null);
        return pVar;
    }

    /* renamed from: b */
    public static C8480p m20313b(String key, long position) {
        C8480p pVar = new C8480p(key, position, -1, -9223372036854775807L, null);
        return pVar;
    }

    /* renamed from: a */
    public static C8480p m20311a(String key, long position, long length) {
        C8480p pVar = new C8480p(key, position, length, -9223372036854775807L, null);
        return pVar;
    }

    /* renamed from: a */
    public static C8480p m20309a(File file, C8472h index) {
        File file2;
        String name = file.getName();
        C8480p pVar = null;
        if (!name.endsWith(".v3.exo")) {
            file2 = m20314b(file, index);
            if (file2 == null) {
                return null;
            }
            name = file2.getName();
        } else {
            file2 = file;
        }
        Matcher matcher = f18709i.matcher(name);
        if (!matcher.matches()) {
            return null;
        }
        long length = file2.length();
        String key = index.mo25979a(Integer.parseInt(matcher.group(1)));
        if (key != null) {
            pVar = new C8480p(key, Long.parseLong(matcher.group(2)), length, Long.parseLong(matcher.group(3)), file2);
        }
        return pVar;
    }

    /* renamed from: b */
    private static File m20314b(File file, C8472h index) {
        String key;
        String filename = file.getName();
        Matcher matcher = f18708h.matcher(filename);
        if (matcher.matches()) {
            key = C8509F.m20482i(matcher.group(1));
            if (key == null) {
                return null;
            }
        } else {
            matcher = f18707g.matcher(filename);
            if (!matcher.matches()) {
                return null;
            }
            key = matcher.group(1);
        }
        File newCacheFile = m20312a(file.getParentFile(), index.mo25978a(key), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (!file.renameTo(newCacheFile)) {
            return null;
        }
        return newCacheFile;
    }

    private C8480p(String key, long position, long length, long lastAccessTimestamp, File file) {
        super(key, position, length, lastAccessTimestamp, file);
    }

    /* renamed from: a */
    public C8480p mo26003a(int id) {
        C8514e.m20490b(this.f18671d);
        long now = System.currentTimeMillis();
        C8480p pVar = new C8480p(this.f18668a, this.f18669b, this.f18670c, now, m20312a(this.f18672e.getParentFile(), id, this.f18669b, now));
        return pVar;
    }
}
