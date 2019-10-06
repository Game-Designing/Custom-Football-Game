package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public abstract class NameTransformer {
    public static final NameTransformer NOP = new NopTransformer();

    public static class Chained extends NameTransformer implements Serializable {
        protected final NameTransformer _t1;
        protected final NameTransformer _t2;

        public Chained(NameTransformer t1, NameTransformer t2) {
            this._t1 = t1;
            this._t2 = t2;
        }

        public String transform(String name) {
            return this._t1.transform(this._t2.transform(name));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[ChainedTransformer(");
            sb.append(this._t1);
            sb.append(", ");
            sb.append(this._t2);
            sb.append(")]");
            return sb.toString();
        }
    }

    protected static final class NopTransformer extends NameTransformer implements Serializable {
        protected NopTransformer() {
        }

        public String transform(String name) {
            return name;
        }
    }

    public abstract String transform(String str);

    protected NameTransformer() {
    }

    public static NameTransformer simpleTransformer(final String prefix, final String suffix) {
        boolean hasSuffix = true;
        boolean hasPrefix = prefix != null && prefix.length() > 0;
        if (suffix == null || suffix.length() <= 0) {
            hasSuffix = false;
        }
        if (!hasPrefix) {
            return hasSuffix ? new NameTransformer() {
                public String transform(String name) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(suffix);
                    return sb.toString();
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[SuffixTransformer('");
                    sb.append(suffix);
                    sb.append("')]");
                    return sb.toString();
                }
            } : NOP;
        }
        if (hasSuffix) {
            return new NameTransformer() {
                public String transform(String name) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(prefix);
                    sb.append(name);
                    sb.append(suffix);
                    return sb.toString();
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[PreAndSuffixTransformer('");
                    sb.append(prefix);
                    sb.append("','");
                    sb.append(suffix);
                    sb.append("')]");
                    return sb.toString();
                }
            };
        }
        return new NameTransformer() {
            public String transform(String name) {
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                sb.append(name);
                return sb.toString();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("[PrefixTransformer('");
                sb.append(prefix);
                sb.append("')]");
                return sb.toString();
            }
        };
    }

    public static NameTransformer chainedTransformer(NameTransformer t1, NameTransformer t2) {
        return new Chained(t1, t2);
    }
}
