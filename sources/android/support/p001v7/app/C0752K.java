package android.support.p001v7.app;

/* renamed from: android.support.v7.app.K */
/* compiled from: TwilightCalculator */
class C0752K {

    /* renamed from: a */
    private static C0752K f2257a;

    /* renamed from: b */
    public long f2258b;

    /* renamed from: c */
    public long f2259c;

    /* renamed from: d */
    public int f2260d;

    C0752K() {
    }

    /* renamed from: a */
    static C0752K m3521a() {
        if (f2257a == null) {
            f2257a = new C0752K();
        }
        return f2257a;
    }

    /* renamed from: a */
    public void mo6168a(long time, double latitude, double longitude) {
        float daysSince2000 = ((float) (time - 946728000000L)) / 8.64E7f;
        float meanAnomaly = (0.01720197f * daysSince2000) + 6.24006f;
        double d = (double) meanAnomaly;
        double sin = Math.sin((double) meanAnomaly) * 0.03341960161924362d;
        Double.isNaN(d);
        double trueAnomaly = d + sin + (Math.sin((double) (2.0f * meanAnomaly)) * 3.4906598739326E-4d) + (Math.sin((double) (3.0f * meanAnomaly)) * 5.236000106378924E-6d);
        double solarLng = 1.796593063d + trueAnomaly + 3.141592653589793d;
        double arcLongitude = (-longitude) / 360.0d;
        double d2 = (double) (daysSince2000 - 9.0E-4f);
        Double.isNaN(d2);
        float n = (float) Math.round(d2 - arcLongitude);
        double d3 = (double) (9.0E-4f + n);
        Double.isNaN(d3);
        double d4 = trueAnomaly;
        double solarTransitJ2000 = d3 + arcLongitude + (Math.sin((double) meanAnomaly) * 0.0053d) + (Math.sin(2.0d * solarLng) * -0.0069d);
        double solarDec = Math.asin(Math.sin(solarLng) * Math.sin(0.4092797040939331d));
        double latRad = 0.01745329238474369d * latitude;
        double cosHourAngle = (Math.sin(-0.10471975803375244d) - (Math.sin(latRad) * Math.sin(solarDec))) / (Math.cos(latRad) * Math.cos(solarDec));
        float f = n;
        if (cosHourAngle >= 1.0d) {
            this.f2260d = 1;
            this.f2258b = -1;
            this.f2259c = -1;
        } else if (cosHourAngle <= -1.0d) {
            this.f2260d = 0;
            this.f2258b = -1;
            this.f2259c = -1;
        } else {
            float hourAngle = (float) (Math.acos(cosHourAngle) / 6.283185307179586d);
            float f2 = daysSince2000;
            float f3 = meanAnomaly;
            double d5 = (double) hourAngle;
            Double.isNaN(d5);
            this.f2258b = Math.round((d5 + solarTransitJ2000) * 8.64E7d) + 946728000000L;
            double d6 = (double) hourAngle;
            Double.isNaN(d6);
            this.f2259c = Math.round((solarTransitJ2000 - d6) * 8.64E7d) + 946728000000L;
            if (this.f2259c >= time || this.f2258b <= time) {
                this.f2260d = 1;
            } else {
                this.f2260d = 0;
            }
        }
    }
}
