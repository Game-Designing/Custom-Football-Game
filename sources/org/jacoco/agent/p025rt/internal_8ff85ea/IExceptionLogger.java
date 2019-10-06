package org.jacoco.agent.p025rt.internal_8ff85ea;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.IExceptionLogger */
public interface IExceptionLogger {
    public static final IExceptionLogger SYSTEM_ERR = new IExceptionLogger() {
        public void logExeption(Exception ex) {
            ex.printStackTrace();
        }
    };

    void logExeption(Exception exc);
}
