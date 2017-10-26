// CHECKSTYLE:OFF

package org.jenkinsci.plugins.vstest_runner;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * VSTest
     * 
     */
    public static String VsTestInstallation_DisplayName() {
        return holder.format("VsTestInstallation.DisplayName");
    }

    /**
     * VSTest
     * 
     */
    public static Localizable _VsTestInstallation_DisplayName() {
        return new Localizable(holder, "VsTestInstallation.DisplayName");
    }

    /**
     * Run unit tests with VSTest.console
     * 
     */
    public static String VsTestBuilder_DisplayName() {
        return holder.format("VsTestBuilder.DisplayName");
    }

    /**
     * Run unit tests with VSTest.console
     * 
     */
    public static Localizable _VsTestBuilder_DisplayName() {
        return new Localizable(holder, "VsTestBuilder.DisplayName");
    }

}
