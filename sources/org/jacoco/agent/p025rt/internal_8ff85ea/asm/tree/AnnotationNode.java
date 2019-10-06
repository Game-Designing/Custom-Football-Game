package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.AnnotationVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.AnnotationNode */
public class AnnotationNode extends AnnotationVisitor {
    public String desc;
    public List<Object> values;

    public AnnotationNode(String desc2) {
        this(327680, desc2);
        if (getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationNode(int api, String desc2) {
        super(api);
        this.desc = desc2;
    }

    AnnotationNode(List<Object> values2) {
        super(327680);
        this.values = values2;
    }

    public void visit(String name, Object value) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        int i = 0;
        if (value instanceof byte[]) {
            byte[] v = (byte[]) value;
            ArrayList<Byte> l = new ArrayList<>(v.length);
            int length = v.length;
            while (i < length) {
                l.add(Byte.valueOf(v[i]));
                i++;
            }
            this.values.add(l);
        } else if (value instanceof boolean[]) {
            boolean[] v2 = (boolean[]) value;
            ArrayList<Boolean> l2 = new ArrayList<>(v2.length);
            int length2 = v2.length;
            while (i < length2) {
                l2.add(Boolean.valueOf(v2[i]));
                i++;
            }
            this.values.add(l2);
        } else if (value instanceof short[]) {
            short[] v3 = (short[]) value;
            ArrayList<Short> l3 = new ArrayList<>(v3.length);
            int length3 = v3.length;
            while (i < length3) {
                l3.add(Short.valueOf(v3[i]));
                i++;
            }
            this.values.add(l3);
        } else if (value instanceof char[]) {
            char[] v4 = (char[]) value;
            ArrayList<Character> l4 = new ArrayList<>(v4.length);
            int length4 = v4.length;
            while (i < length4) {
                l4.add(Character.valueOf(v4[i]));
                i++;
            }
            this.values.add(l4);
        } else if (value instanceof int[]) {
            int[] v5 = (int[]) value;
            ArrayList<Integer> l5 = new ArrayList<>(v5.length);
            int length5 = v5.length;
            while (i < length5) {
                l5.add(Integer.valueOf(v5[i]));
                i++;
            }
            this.values.add(l5);
        } else if (value instanceof long[]) {
            long[] v6 = (long[]) value;
            ArrayList<Long> l6 = new ArrayList<>(v6.length);
            int length6 = v6.length;
            while (i < length6) {
                l6.add(Long.valueOf(v6[i]));
                i++;
            }
            this.values.add(l6);
        } else if (value instanceof float[]) {
            float[] v7 = (float[]) value;
            ArrayList<Float> l7 = new ArrayList<>(v7.length);
            int length7 = v7.length;
            while (i < length7) {
                l7.add(Float.valueOf(v7[i]));
                i++;
            }
            this.values.add(l7);
        } else if (value instanceof double[]) {
            double[] v8 = (double[]) value;
            ArrayList<Double> l8 = new ArrayList<>(v8.length);
            int length8 = v8.length;
            while (i < length8) {
                l8.add(Double.valueOf(v8[i]));
                i++;
            }
            this.values.add(l8);
        } else {
            this.values.add(value);
        }
    }

    public void visitEnum(String name, String desc2, String value) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        this.values.add(new String[]{desc2, value});
    }

    public AnnotationVisitor visitAnnotation(String name, String desc2) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        AnnotationNode annotation = new AnnotationNode(desc2);
        this.values.add(annotation);
        return annotation;
    }

    public AnnotationVisitor visitArray(String name) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        List<Object> array = new ArrayList<>();
        this.values.add(array);
        return new AnnotationNode(array);
    }

    public void visitEnd() {
    }

    public void check(int api) {
    }

    public void accept(AnnotationVisitor av) {
        if (av != null) {
            if (this.values != null) {
                for (int i = 0; i < this.values.size(); i += 2) {
                    accept(av, (String) this.values.get(i), this.values.get(i + 1));
                }
            }
            av.visitEnd();
        }
    }

    static void accept(AnnotationVisitor av, String name, Object value) {
        if (av == null) {
            return;
        }
        if (value instanceof String[]) {
            String[] typeconst = (String[]) value;
            av.visitEnum(name, typeconst[0], typeconst[1]);
        } else if (value instanceof AnnotationNode) {
            AnnotationNode an = (AnnotationNode) value;
            an.accept(av.visitAnnotation(name, an.desc));
        } else if (value instanceof List) {
            AnnotationVisitor v = av.visitArray(name);
            if (v != null) {
                List<?> array = (List) value;
                for (int j = 0; j < array.size(); j++) {
                    accept(v, null, array.get(j));
                }
                v.visitEnd();
            }
        } else {
            av.visit(name, value);
        }
    }
}
