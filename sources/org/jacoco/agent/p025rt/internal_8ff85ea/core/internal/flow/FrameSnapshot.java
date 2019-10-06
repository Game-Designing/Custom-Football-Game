package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.FrameSnapshot */
class FrameSnapshot implements IFrame {
    private static final FrameSnapshot NOP = new FrameSnapshot(null, null);
    private final Object[] locals;
    private final Object[] stack;

    private FrameSnapshot(Object[] locals2, Object[] stack2) {
        this.locals = locals2;
        this.stack = stack2;
    }

    static IFrame create(AnalyzerAdapter analyzer, int popCount) {
        if (analyzer != null) {
            List<Object> list = analyzer.locals;
            if (list != null) {
                return new FrameSnapshot(reduce(list, 0), reduce(analyzer.stack, popCount));
            }
        }
        return NOP;
    }

    private static Object[] reduce(List<Object> source, int popCount) {
        List<Object> copy = new ArrayList<>(source);
        int size = source.size() - popCount;
        copy.subList(size, source.size()).clear();
        int i = size;
        while (true) {
            i--;
            if (i < 0) {
                return copy.toArray();
            }
            Object type = source.get(i);
            if (type == Opcodes.LONG || type == Opcodes.DOUBLE) {
                copy.remove(i + 1);
            }
        }
    }

    public void accept(MethodVisitor mv) {
        Object[] objArr = this.locals;
        if (objArr != null) {
            int length = objArr.length;
            Object[] objArr2 = this.stack;
            mv.visitFrame(-1, length, objArr, objArr2.length, objArr2);
        }
    }
}
