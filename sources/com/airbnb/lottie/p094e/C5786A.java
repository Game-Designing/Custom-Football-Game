package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5732m;
import com.airbnb.lottie.p089c.p091b.C5745i;
import com.airbnb.lottie.p089c.p091b.C5745i.C5746a;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.A */
/* compiled from: PolystarShapeParser */
class C5786A {
    /* renamed from: a */
    static C5745i m10416a(JsonReader reader, C5830g composition) throws IOException {
        JsonReader jsonReader = reader;
        C5830g gVar = composition;
        String name = null;
        C5746a type = null;
        C5721b points = null;
        C5732m mVar = null;
        C5721b rotation = null;
        C5721b outerRadius = null;
        C5721b outerRoundedness = null;
        C5721b innerRadius = null;
        C5721b innerRoundedness = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 114) {
                    if (hashCode != 3519) {
                        if (hashCode != 3588) {
                            if (hashCode != 3686) {
                                if (hashCode != 3369) {
                                    if (hashCode != 3370) {
                                        if (hashCode != 3555) {
                                            if (hashCode == 3556 && nextName.equals("os")) {
                                                c = 6;
                                            }
                                        } else if (nextName.equals("or")) {
                                            c = 5;
                                        }
                                    } else if (nextName.equals("is")) {
                                        c = 8;
                                    }
                                } else if (nextName.equals("ir")) {
                                    c = 7;
                                }
                            } else if (nextName.equals("sy")) {
                                c = 1;
                            }
                        } else if (nextName.equals("pt")) {
                            c = 2;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("r")) {
                    c = 4;
                }
            } else if (nextName.equals("p")) {
                c = 3;
            }
            switch (c) {
                case 0:
                    name = reader.nextString();
                    break;
                case 1:
                    type = C5746a.m10255a(reader.nextInt());
                    break;
                case 2:
                    points = C5800d.m10435a(jsonReader, gVar, false);
                    break;
                case 3:
                    mVar = C5797a.m10430b(reader, composition);
                    break;
                case 4:
                    rotation = C5800d.m10435a(jsonReader, gVar, false);
                    break;
                case 5:
                    outerRadius = C5800d.m10440c(reader, composition);
                    break;
                case 6:
                    outerRoundedness = C5800d.m10435a(jsonReader, gVar, false);
                    break;
                case 7:
                    innerRadius = C5800d.m10440c(reader, composition);
                    break;
                case 8:
                    innerRoundedness = C5800d.m10435a(jsonReader, gVar, false);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        C5745i iVar = new C5745i(name, type, points, mVar, rotation, innerRadius, outerRadius, innerRoundedness, outerRoundedness);
        return iVar;
    }
}
