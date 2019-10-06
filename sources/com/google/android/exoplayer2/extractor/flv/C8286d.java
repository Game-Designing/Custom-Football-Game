package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.C8535t;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.flv.d */
/* compiled from: ScriptTagPayloadReader */
final class C8286d extends TagPayloadReader {

    /* renamed from: b */
    private long f17594b = -9223372036854775807L;

    public C8286d() {
        super(null);
    }

    /* renamed from: a */
    public long mo25426a() {
        return this.f17594b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25424a(C8535t data) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25425b(C8535t data, long timeUs) throws ParserException {
        if (m19281i(data) == 2) {
            if ("onMetaData".equals(m19280h(data)) && m19281i(data) == 8) {
                Map<String, Object> metadata = m19277e(data);
                String str = VastIconXmlManager.DURATION;
                if (metadata.containsKey(str)) {
                    double durationSeconds = ((Double) metadata.get(str)).doubleValue();
                    if (durationSeconds > 0.0d) {
                        this.f17594b = (long) (1000000.0d * durationSeconds);
                    }
                }
                return;
            }
            return;
        }
        throw new ParserException();
    }

    /* renamed from: i */
    private static int m19281i(C8535t data) {
        return data.mo26131q();
    }

    /* renamed from: b */
    private static Boolean m19274b(C8535t data) {
        boolean z = true;
        if (data.mo26131q() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: d */
    private static Double m19276d(C8535t data) {
        return Double.valueOf(Double.longBitsToDouble(data.mo26127m()));
    }

    /* renamed from: h */
    private static String m19280h(C8535t data) {
        int size = data.mo26137w();
        int position = data.mo26113c();
        data.mo26120f(size);
        return new String(data.f18861a, position, size);
    }

    /* renamed from: g */
    private static ArrayList<Object> m19279g(C8535t data) {
        int count = data.mo26135u();
        ArrayList<Object> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(m19273a(data, m19281i(data)));
        }
        return list;
    }

    /* renamed from: f */
    private static HashMap<String, Object> m19278f(C8535t data) {
        HashMap<String, Object> array = new HashMap<>();
        while (true) {
            String key = m19280h(data);
            int type = m19281i(data);
            if (type == 9) {
                return array;
            }
            array.put(key, m19273a(data, type));
        }
    }

    /* renamed from: e */
    private static HashMap<String, Object> m19277e(C8535t data) {
        int count = data.mo26135u();
        HashMap<String, Object> array = new HashMap<>(count);
        for (int i = 0; i < count; i++) {
            array.put(m19280h(data), m19273a(data, m19281i(data)));
        }
        return array;
    }

    /* renamed from: c */
    private static Date m19275c(C8535t data) {
        Date date = new Date((long) m19276d(data).doubleValue());
        data.mo26120f(2);
        return date;
    }

    /* renamed from: a */
    private static Object m19273a(C8535t data, int type) {
        if (type == 0) {
            return m19276d(data);
        }
        if (type == 1) {
            return m19274b(data);
        }
        if (type == 2) {
            return m19280h(data);
        }
        if (type == 3) {
            return m19278f(data);
        }
        if (type == 8) {
            return m19277e(data);
        }
        if (type == 10) {
            return m19279g(data);
        }
        if (type != 11) {
            return null;
        }
        return m19275c(data);
    }
}
