// Added by repocurator (feature 002) as CI test-execution tooling.
//
// This repository has no build tool (no pom.xml, no build.gradle) and the
// JUnit 5 jars vendored under libs/JUnit5/ do not include a standalone
// console-launcher jar, so there is no existing way to invoke the JUnit 5
// tests under src/ from the command line. This bootstraps the JUnit
// Platform Launcher API directly against the classes those vendored jars
// already provide (junit-platform-launcher-1.8.0.jar), discovers every
// @Test on the compiled classpath, and fails loudly (non-zero exit) if any
// test fails or if none are found at all -- a printed summary with no
// assertion behind it would be exactly the kind of check that means
// nothing (see check/ci.py's "smoke test that asserts nothing").
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.engine.discovery.DiscoverySelectors;

import java.io.File;
import java.io.PrintWriter;
import java.util.Set;

public class RunTests {
    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectClasspathRoots(Set.of(new File("out").toPath())))
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        summary.printTo(new PrintWriter(System.out, true));
        summary.printFailuresTo(new PrintWriter(System.out, true), 100);

        if (summary.getTestsFoundCount() == 0) {
            System.err.println("No tests were discovered.");
            System.exit(1);
        }
        if (summary.getTotalFailureCount() > 0) {
            System.exit(1);
        }
        System.out.println("All " + summary.getTestsSucceededCount() + " tests passed.");
    }
}
