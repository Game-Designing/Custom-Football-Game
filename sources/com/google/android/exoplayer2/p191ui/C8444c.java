package com.google.android.exoplayer2.p191ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8529q;
import java.util.Locale;

/* renamed from: com.google.android.exoplayer2.ui.c */
/* compiled from: DefaultTrackNameProvider */
public class C8444c implements C8451i {

    /* renamed from: a */
    private final Resources f18555a;

    public C8444c(Resources resources) {
        C8514e.m20486a(resources);
        this.f18555a = resources;
    }

    /* renamed from: a */
    public String mo25912a(Format format) {
        String trackName;
        int trackType = m20139f(format);
        if (trackType == 2) {
            trackName = m20134a(m20138e(format), m20136c(format));
        } else if (trackType == 1) {
            trackName = m20134a(m20137d(format), m20135b(format), m20136c(format));
        } else {
            trackName = m20137d(format);
        }
        return trackName.length() == 0 ? this.f18555a.getString(C8446e.exo_track_unknown) : trackName;
    }

    /* renamed from: e */
    private String m20138e(Format format) {
        int width = format.f16512l;
        int height = format.f16513m;
        if (width == -1 || height == -1) {
            return "";
        }
        return this.f18555a.getString(C8446e.exo_track_resolution, new Object[]{Integer.valueOf(width), Integer.valueOf(height)});
    }

    /* renamed from: c */
    private String m20136c(Format format) {
        int bitrate = format.f16503c;
        if (bitrate == -1) {
            return "";
        }
        return this.f18555a.getString(C8446e.exo_track_bitrate, new Object[]{Float.valueOf(((float) bitrate) / 1000000.0f)});
    }

    /* renamed from: b */
    private String m20135b(Format format) {
        int channelCount = format.f16520t;
        if (channelCount == -1 || channelCount < 1) {
            return "";
        }
        if (channelCount == 1) {
            return this.f18555a.getString(C8446e.exo_track_mono);
        }
        if (channelCount == 2) {
            return this.f18555a.getString(C8446e.exo_track_stereo);
        }
        if (channelCount == 6 || channelCount == 7) {
            return this.f18555a.getString(C8446e.exo_track_surround_5_point_1);
        }
        if (channelCount != 8) {
            return this.f18555a.getString(C8446e.exo_track_surround);
        }
        return this.f18555a.getString(C8446e.exo_track_surround_7_point_1);
    }

    /* renamed from: d */
    private String m20137d(Format format) {
        String str;
        if (!TextUtils.isEmpty(format.f16502b)) {
            return format.f16502b;
        }
        String language = format.f16526z;
        if (TextUtils.isEmpty(language) || "und".equals(language)) {
            str = "";
        } else {
            str = m20133a(language);
        }
        return str;
    }

    /* renamed from: a */
    private String m20133a(String language) {
        return (C8509F.f18793a >= 21 ? Locale.forLanguageTag(language) : new Locale(language)).getDisplayLanguage();
    }

    /* renamed from: a */
    private String m20134a(String... items) {
        String itemList = "";
        for (String item : items) {
            if (item.length() > 0) {
                if (TextUtils.isEmpty(itemList)) {
                    itemList = item;
                } else {
                    itemList = this.f18555a.getString(C8446e.exo_item_list, new Object[]{itemList, item});
                }
            }
        }
        return itemList;
    }

    /* renamed from: f */
    private static int m20139f(Format format) {
        int trackType = C8529q.m20545d(format.f16507g);
        if (trackType != -1) {
            return trackType;
        }
        if (C8529q.m20546e(format.f16504d) != null) {
            return 2;
        }
        if (C8529q.m20542a(format.f16504d) != null) {
            return 1;
        }
        if (format.f16512l != -1 || format.f16513m != -1) {
            return 2;
        }
        if (format.f16520t == -1 && format.f16521u == -1) {
            return -1;
        }
        return 1;
    }
}
