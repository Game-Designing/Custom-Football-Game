package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p085a.p087b.C5706h;
import com.airbnb.lottie.p095f.C5829f;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.x */
/* compiled from: PathKeyframeParser */
class C5820x {
    /* renamed from: a */
    static C5706h m10487a(JsonReader reader, C5830g composition) throws IOException {
        return new C5706h(composition, C5814r.m10472a(reader, composition, C5829f.m10534a(), C5821y.f10090a, reader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
