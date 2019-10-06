package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {

    public enum Feature {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        ACCEPT_CASE_INSENSITIVE_PROPERTIES,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES,
        ADJUST_DATES_TO_CONTEXT_TIME_ZONE
    }

    public enum Shape {
        ANY,
        NATURAL,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN;

        public boolean isNumeric() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }
    }

    public static class Features {
        private static final Features EMPTY = new Features(0, 0);
        private final int _disabled;
        private final int _enabled;

        private Features(int e, int d) {
            this._enabled = e;
            this._disabled = d;
        }

        public static Features empty() {
            return EMPTY;
        }

        public static Features construct(JsonFormat f) {
            return construct(f.with(), f.without());
        }

        public static Features construct(Feature[] enabled, Feature[] disabled) {
            int e = 0;
            for (Feature f : enabled) {
                e |= 1 << f.ordinal();
            }
            int d = 0;
            for (Feature f2 : disabled) {
                d |= 1 << f2.ordinal();
            }
            return new Features(e, d);
        }

        public Features withOverrides(Features overrides) {
            if (overrides == null) {
                return this;
            }
            int overrideD = overrides._disabled;
            int overrideE = overrides._enabled;
            if (overrideD == 0 && overrideE == 0) {
                return this;
            }
            if (this._enabled == 0 && this._disabled == 0) {
                return overrides;
            }
            int i = this._enabled;
            int newE = ((overrideD ^ -1) & i) | overrideE;
            int i2 = this._disabled;
            int newD = ((overrideE ^ -1) & i2) | overrideD;
            if (newE == i && newD == i2) {
                return this;
            }
            return new Features(newE, newD);
        }

        public Boolean get(Feature f) {
            int mask = 1 << f.ordinal();
            if ((this._disabled & mask) != 0) {
                return Boolean.FALSE;
            }
            if ((this._enabled & mask) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public int hashCode() {
            return this._disabled + this._enabled;
        }

        public boolean equals(Object o) {
            boolean z = true;
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != getClass()) {
                return false;
            }
            Features other = (Features) o;
            if (!(other._enabled == this._enabled && other._disabled == this._disabled)) {
                z = false;
            }
            return z;
        }
    }

    public static class Value implements JacksonAnnotationValue<JsonFormat>, Serializable {
        private static final Value EMPTY = new Value();
        private final Features _features;
        private final Boolean _lenient;
        private final Locale _locale;
        private final String _pattern;
        private final Shape _shape;
        private transient TimeZone _timezone;
        private final String _timezoneStr;

        public Value() {
            this("", Shape.ANY, "", "", Features.empty(), null);
        }

        public Value(JsonFormat ann) {
            this(ann.pattern(), ann.shape(), ann.locale(), ann.timezone(), Features.construct(ann), ann.lenient().asBoolean());
        }

        public Value(String p, Shape sh, String localeStr, String tzStr, Features f, Boolean lenient) {
            String str = localeStr;
            String str2 = tzStr;
            String str3 = "##default";
            this(p, sh, (str == null || localeStr.length() == 0 || str3.equals(str)) ? null : new Locale(str), (str2 == null || tzStr.length() == 0 || str3.equals(str2)) ? null : str2, null, f, lenient);
        }

        public Value(String p, Shape sh, Locale l, String tzStr, TimeZone tz, Features f, Boolean lenient) {
            this._pattern = p;
            this._shape = sh == null ? Shape.ANY : sh;
            this._locale = l;
            this._timezone = tz;
            this._timezoneStr = tzStr;
            this._features = f == null ? Features.empty() : f;
            this._lenient = lenient;
        }

        public static final Value empty() {
            return EMPTY;
        }

        public static Value merge(Value base, Value overrides) {
            return base == null ? overrides : base.withOverrides(overrides);
        }

        public final Value withOverrides(Value overrides) {
            Shape sh;
            Locale l;
            Features f;
            Boolean lenient;
            TimeZone tz;
            String tzStr;
            Value value = overrides;
            if (value != null) {
                Value value2 = EMPTY;
                if (!(value == value2 || value == this)) {
                    if (this == value2) {
                        return value;
                    }
                    String p = value._pattern;
                    if (p == null || p.isEmpty()) {
                        p = this._pattern;
                    }
                    Shape sh2 = value._shape;
                    if (sh2 == Shape.ANY) {
                        sh = this._shape;
                    } else {
                        sh = sh2;
                    }
                    Locale l2 = value._locale;
                    if (l2 == null) {
                        l = this._locale;
                    } else {
                        l = l2;
                    }
                    Features f2 = this._features;
                    if (f2 == null) {
                        f = value._features;
                    } else {
                        f = f2.withOverrides(value._features);
                    }
                    Boolean lenient2 = value._lenient;
                    if (lenient2 == null) {
                        lenient = this._lenient;
                    } else {
                        lenient = lenient2;
                    }
                    String tzStr2 = value._timezoneStr;
                    if (tzStr2 == null || tzStr2.isEmpty()) {
                        tzStr = this._timezoneStr;
                        tz = this._timezone;
                    } else {
                        tzStr = tzStr2;
                        tz = value._timezone;
                    }
                    Value value3 = new Value(p, sh, l, tzStr, tz, f, lenient);
                    return value3;
                }
            }
            return this;
        }

        public String getPattern() {
            return this._pattern;
        }

        public Shape getShape() {
            return this._shape;
        }

        public Locale getLocale() {
            return this._locale;
        }

        public Boolean getLenient() {
            return this._lenient;
        }

        public TimeZone getTimeZone() {
            TimeZone tz = this._timezone;
            if (tz == null) {
                String str = this._timezoneStr;
                if (str == null) {
                    return null;
                }
                tz = TimeZone.getTimeZone(str);
                this._timezone = tz;
            }
            return tz;
        }

        public boolean hasShape() {
            return this._shape != Shape.ANY;
        }

        public boolean hasPattern() {
            String str = this._pattern;
            return str != null && str.length() > 0;
        }

        public boolean hasLocale() {
            return this._locale != null;
        }

        public boolean hasTimeZone() {
            if (this._timezone == null) {
                String str = this._timezoneStr;
                if (str == null || str.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public Boolean getFeature(Feature f) {
            return this._features.get(f);
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s)", new Object[]{this._pattern, this._shape, this._lenient, this._locale, this._timezoneStr});
        }

        public int hashCode() {
            String str = this._timezoneStr;
            int hash = str == null ? 1 : str.hashCode();
            String str2 = this._pattern;
            if (str2 != null) {
                hash ^= str2.hashCode();
            }
            int hash2 = hash + this._shape.hashCode();
            Boolean bool = this._lenient;
            if (bool != null) {
                hash2 ^= bool.hashCode();
            }
            Locale locale = this._locale;
            if (locale != null) {
                hash2 += locale.hashCode();
            }
            return hash2 ^ this._features.hashCode();
        }

        public boolean equals(Object o) {
            boolean z = true;
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != getClass()) {
                return false;
            }
            Value other = (Value) o;
            if (this._shape != other._shape || !this._features.equals(other._features)) {
                return false;
            }
            if (!_equal(this._lenient, other._lenient) || !_equal(this._timezoneStr, other._timezoneStr) || !_equal(this._pattern, other._pattern) || !_equal(this._timezone, other._timezone) || !_equal(this._locale, other._locale)) {
                z = false;
            }
            return z;
        }

        private static <T> boolean _equal(T value1, T value2) {
            boolean z = false;
            if (value1 == null) {
                if (value2 == null) {
                    z = true;
                }
                return z;
            } else if (value2 == null) {
                return false;
            } else {
                return value1.equals(value2);
            }
        }
    }

    OptBoolean lenient() default OptBoolean.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    Shape shape() default Shape.ANY;

    String timezone() default "##default";

    Feature[] with() default {};

    Feature[] without() default {};
}
