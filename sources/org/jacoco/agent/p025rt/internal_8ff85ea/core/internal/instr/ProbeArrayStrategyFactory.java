package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassReader;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.data.CRC64;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.ClassProbesAdapter;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ProbeArrayStrategyFactory */
public final class ProbeArrayStrategyFactory {
    private ProbeArrayStrategyFactory() {
    }

    public static IProbeArrayStrategy createFor(ClassReader reader, IExecutionDataAccessorGenerator accessorGenerator) {
        String className = reader.getClassName();
        int version = getVersion(reader);
        long classId = CRC64.checksum(reader.f43240b);
        boolean withFrames = version >= 50;
        if (isInterface(reader)) {
            ProbeCounter counter = getProbeCounter(reader);
            if (counter.getCount() == 0) {
                return new NoneProbeArrayStrategy();
            }
            if (version < 52 || !counter.hasMethods()) {
                LocalProbeArrayStrategy localProbeArrayStrategy = new LocalProbeArrayStrategy(className, classId, counter.getCount(), accessorGenerator);
                return localProbeArrayStrategy;
            }
            InterfaceFieldProbeArrayStrategy interfaceFieldProbeArrayStrategy = new InterfaceFieldProbeArrayStrategy(className, classId, counter.getCount(), accessorGenerator);
            return interfaceFieldProbeArrayStrategy;
        }
        ClassFieldProbeArrayStrategy classFieldProbeArrayStrategy = new ClassFieldProbeArrayStrategy(className, classId, withFrames, accessorGenerator);
        return classFieldProbeArrayStrategy;
    }

    private static boolean isInterface(ClassReader reader) {
        return (reader.getAccess() & 512) != 0;
    }

    private static int getVersion(ClassReader reader) {
        return reader.readShort(6);
    }

    private static ProbeCounter getProbeCounter(ClassReader reader) {
        ProbeCounter counter = new ProbeCounter();
        reader.accept(new ClassProbesAdapter(counter, false), 0);
        return counter;
    }
}
