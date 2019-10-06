package org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.IRuntime */
public interface IRuntime extends IExecutionDataAccessorGenerator {
    void shutdown();

    void startup(RuntimeData runtimeData) throws Exception;
}
