package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonInclude {

    public enum Include {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    public static class Value implements JacksonAnnotationValue<JsonInclude>, Serializable {
        protected static final Value EMPTY;
        protected final Class<?> _contentFilter;
        protected final Include _contentInclusion;
        protected final Class<?> _valueFilter;
        protected final Include _valueInclusion;

        static {
            Include include = Include.USE_DEFAULTS;
            EMPTY = new Value(include, include, null, null);
        }

        protected Value(Include vi, Include ci, Class<?> valueFilter, Class<?> contentFilter) {
            this._valueInclusion = vi == null ? Include.USE_DEFAULTS : vi;
            this._contentInclusion = ci == null ? Include.USE_DEFAULTS : ci;
            Class<?> cls = null;
            this._valueFilter = valueFilter == Void.class ? null : valueFilter;
            if (contentFilter != Void.class) {
                cls = contentFilter;
            }
            this._contentFilter = cls;
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value merge(Value base, Value overrides) {
            return base == null ? overrides : base.withOverrides(overrides);
        }

        public static Value mergeAll(Value... values) {
            Value result = null;
            Value[] arr$ = values;
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$++) {
                Value curr = arr$[i$];
                if (curr != null) {
                    result = result == null ? curr : result.withOverrides(curr);
                }
            }
            return result;
        }

        /* access modifiers changed from: protected */
        public Object readResolve() {
            Include include = this._valueInclusion;
            Include include2 = Include.USE_DEFAULTS;
            if (include == include2 && this._contentInclusion == include2 && this._valueFilter == null && this._contentFilter == null) {
                return EMPTY;
            }
            return this;
        }

        public Value withOverrides(Value overrides) {
            if (overrides == null || overrides == EMPTY) {
                return this;
            }
            Include vi = overrides._valueInclusion;
            Include ci = overrides._contentInclusion;
            Class<?> vf = overrides._valueFilter;
            Class<?> cf = overrides._contentFilter;
            boolean filterDiff = true;
            boolean viDiff = (vi == this._valueInclusion || vi == Include.USE_DEFAULTS) ? false : true;
            boolean ciDiff = (ci == this._contentInclusion || ci == Include.USE_DEFAULTS) ? false : true;
            Class<?> cls = this._valueFilter;
            if (vf == cls && cf == cls) {
                filterDiff = false;
            }
            if (viDiff) {
                if (ciDiff) {
                    return new Value(vi, ci, vf, cf);
                }
                return new Value(vi, this._contentInclusion, vf, cf);
            } else if (ciDiff) {
                return new Value(this._valueInclusion, ci, vf, cf);
            } else {
                if (filterDiff) {
                    return new Value(this._valueInclusion, this._contentInclusion, vf, cf);
                }
                return this;
            }
        }

        public static Value construct(Include valueIncl, Include contentIncl) {
            if ((valueIncl == Include.USE_DEFAULTS || valueIncl == null) && (contentIncl == Include.USE_DEFAULTS || contentIncl == null)) {
                return EMPTY;
            }
            return new Value(valueIncl, contentIncl, null, null);
        }

        public static Value construct(Include valueIncl, Include contentIncl, Class<?> valueFilter, Class<?> contentFilter) {
            if (valueFilter == Void.class) {
                valueFilter = null;
            }
            if (contentFilter == Void.class) {
                contentFilter = null;
            }
            if ((valueIncl == Include.USE_DEFAULTS || valueIncl == null) && ((contentIncl == Include.USE_DEFAULTS || contentIncl == null) && valueFilter == null && contentFilter == null)) {
                return EMPTY;
            }
            return new Value(valueIncl, contentIncl, valueFilter, contentFilter);
        }

        public static Value from(JsonInclude src) {
            if (src == null) {
                return EMPTY;
            }
            Include vi = src.value();
            Include ci = src.content();
            Include include = Include.USE_DEFAULTS;
            if (vi == include && ci == include) {
                return EMPTY;
            }
            Class<?> vf = src.valueFilter();
            if (vf == Void.class) {
                vf = null;
            }
            Class<?> cf = src.contentFilter();
            if (cf == Void.class) {
                cf = null;
            }
            return new Value(vi, ci, vf, cf);
        }

        public Value withValueInclusion(Include incl) {
            return incl == this._valueInclusion ? this : new Value(incl, this._contentInclusion, this._valueFilter, this._contentFilter);
        }

        public Value withContentFilter(Class<?> filter) {
            Include incl;
            if (filter == null || filter == Void.class) {
                incl = Include.USE_DEFAULTS;
                filter = null;
            } else {
                incl = Include.CUSTOM;
            }
            return construct(this._valueInclusion, incl, this._valueFilter, filter);
        }

        public Value withContentInclusion(Include incl) {
            return incl == this._contentInclusion ? this : new Value(this._valueInclusion, incl, this._valueFilter, this._contentFilter);
        }

        public Include getValueInclusion() {
            return this._valueInclusion;
        }

        public Include getContentInclusion() {
            return this._contentInclusion;
        }

        public Class<?> getValueFilter() {
            return this._valueFilter;
        }

        public Class<?> getContentFilter() {
            return this._contentFilter;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(80);
            sb.append("JsonInclude.Value(value=");
            sb.append(this._valueInclusion);
            sb.append(",content=");
            sb.append(this._contentInclusion);
            String str = ".class";
            if (this._valueFilter != null) {
                sb.append(",valueFilter=");
                sb.append(this._valueFilter.getName());
                sb.append(str);
            }
            if (this._contentFilter != null) {
                sb.append(",contentFilter=");
                sb.append(this._contentFilter.getName());
                sb.append(str);
            }
            sb.append(')');
            return sb.toString();
        }

        public int hashCode() {
            return (this._valueInclusion.hashCode() << 2) + this._contentInclusion.hashCode();
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
            if (!(other._valueInclusion == this._valueInclusion && other._contentInclusion == this._contentInclusion && other._valueFilter == this._valueFilter && other._contentFilter == this._contentFilter)) {
                z = false;
            }
            return z;
        }
    }

    Include content() default Include.ALWAYS;

    Class<?> contentFilter() default Void.class;

    Include value() default Include.ALWAYS;

    Class<?> valueFilter() default Void.class;
}
