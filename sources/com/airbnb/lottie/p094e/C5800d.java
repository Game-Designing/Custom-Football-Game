package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5720a;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5722c;
import com.airbnb.lottie.p089c.p090a.C5723d;
import com.airbnb.lottie.p089c.p090a.C5725f;
import com.airbnb.lottie.p089c.p090a.C5726g;
import com.airbnb.lottie.p089c.p090a.C5727h;
import com.airbnb.lottie.p089c.p090a.C5729j;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5831a;
import java.io.IOException;
import java.util.List;

/* renamed from: com.airbnb.lottie.e.d */
/* compiled from: AnimatableValueParser */
public class C5800d {
    /* renamed from: c */
    public static C5721b m10440c(JsonReader reader, C5830g composition) throws IOException {
        return m10435a(reader, composition, true);
    }

    /* renamed from: a */
    public static C5721b m10435a(JsonReader reader, C5830g composition, boolean isDp) throws IOException {
        return new C5721b(m10437a(reader, isDp ? C5829f.m10534a() : 1.0f, composition, C5805i.f10084a));
    }

    /* renamed from: d */
    static C5723d m10441d(JsonReader reader, C5830g composition) throws IOException {
        return new C5723d(m10438a(reader, composition, (C5796K<T>) C5811o.f10086a));
    }

    /* renamed from: e */
    static C5725f m10442e(JsonReader reader, C5830g composition) throws IOException {
        return new C5725f(m10437a(reader, C5829f.m10534a(), composition, C5822z.f10091a));
    }

    /* renamed from: f */
    static C5726g m10443f(JsonReader reader, C5830g composition) throws IOException {
        return new C5726g(m10438a(reader, composition, (C5796K<T>) C5789D.f10080a));
    }

    /* renamed from: g */
    static C5727h m10444g(JsonReader reader, C5830g composition) throws IOException {
        return new C5727h(m10437a(reader, C5829f.m10534a(), composition, C5790E.f10081a));
    }

    /* renamed from: b */
    static C5729j m10439b(JsonReader reader, C5830g composition) throws IOException {
        return new C5729j(m10438a(reader, composition, (C5796K<T>) C5804h.f10083a));
    }

    /* renamed from: a */
    static C5720a m10434a(JsonReader reader, C5830g composition) throws IOException {
        return new C5720a(m10438a(reader, composition, (C5796K<T>) C5802f.f10082a));
    }

    /* renamed from: a */
    static C5722c m10436a(JsonReader reader, C5830g composition, int points) throws IOException {
        return new C5722c(m10438a(reader, composition, (C5796K<T>) new C5808l<T>(points)));
    }

    /* renamed from: a */
    private static <T> List<C5831a<T>> m10438a(JsonReader reader, C5830g composition, C5796K<T> valueParser) throws IOException {
        return C5815s.m10476a(reader, composition, 1.0f, valueParser);
    }

    /* renamed from: a */
    private static <T> List<C5831a<T>> m10437a(JsonReader reader, float scale, C5830g composition, C5796K<T> valueParser) throws IOException {
        return C5815s.m10476a(reader, composition, scale, valueParser);
    }
}
