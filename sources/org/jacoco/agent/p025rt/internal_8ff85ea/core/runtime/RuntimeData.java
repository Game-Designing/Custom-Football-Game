package org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionData;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataStore;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.IExecutionDataVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ISessionInfoVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.SessionInfo;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr.InstrSupport;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.RuntimeData */
public class RuntimeData {
    private String sessionId = "<none>";
    private long startTimeStamp = System.currentTimeMillis();
    protected final ExecutionDataStore store = new ExecutionDataStore();

    public void setSessionId(String id) {
        this.sessionId = id;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public final void collect(IExecutionDataVisitor executionDataVisitor, ISessionInfoVisitor sessionInfoVisitor, boolean reset) {
        synchronized (this.store) {
            SessionInfo sessionInfo = new SessionInfo(this.sessionId, this.startTimeStamp, System.currentTimeMillis());
            sessionInfoVisitor.visitSessionInfo(sessionInfo);
            this.store.accept(executionDataVisitor);
            if (reset) {
                reset();
            }
        }
    }

    public final void reset() {
        synchronized (this.store) {
            this.store.reset();
            this.startTimeStamp = System.currentTimeMillis();
        }
    }

    public ExecutionData getExecutionData(Long id, String name, int probecount) {
        ExecutionData executionData;
        synchronized (this.store) {
            executionData = this.store.get(id, name, probecount);
        }
        return executionData;
    }

    public void getProbes(Object[] args) {
        args[0] = getExecutionData(args[0], args[1], args[2].intValue()).getProbes();
    }

    public boolean equals(Object args) {
        if (args instanceof Object[]) {
            getProbes((Object[]) args);
        }
        return super.equals(args);
    }

    public static void generateArgumentArray(long classid, String classname, int probecount, MethodVisitor mv) {
        mv.visitInsn(6);
        mv.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object");
        mv.visitInsn(89);
        mv.visitInsn(3);
        mv.visitLdcInsn(Long.valueOf(classid));
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
        mv.visitInsn(83);
        mv.visitInsn(89);
        mv.visitInsn(4);
        mv.visitLdcInsn(classname);
        mv.visitInsn(83);
        mv.visitInsn(89);
        mv.visitInsn(5);
        InstrSupport.push(mv, probecount);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
        mv.visitInsn(83);
    }

    public static void generateAccessCall(long classid, String classname, int probecount, MethodVisitor mv) {
        generateArgumentArray(classid, classname, probecount, mv);
        mv.visitInsn(90);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "equals", "(Ljava/lang/Object;)Z", false);
        mv.visitInsn(87);
        mv.visitInsn(3);
        mv.visitInsn(50);
        mv.visitTypeInsn(Opcodes.CHECKCAST, InstrSupport.DATAFIELD_DESC);
    }
}
