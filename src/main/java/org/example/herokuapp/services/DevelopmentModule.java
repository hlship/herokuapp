package org.example.herokuapp.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.security.ClientWhitelist;
import org.apache.tapestry5.services.security.WhitelistAnalyzer;

/**
 * This module is automatically included as part of the Tapestry IoC Registry if <em>tapestry.execution-mode</em>
 * includes <code>development</code>.
 */
public class DevelopmentModule {
    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration) {
        // The factory default is true but during the early stages of an application
        // overriding to false is a good idea. In addition, this is often overridden
        // on the command line as -Dtapestry.production-mode=false
        configuration.add(SymbolConstants.PRODUCTION_MODE, false);

        // The application version number is incorprated into URLs for some
        // assets. Web browsers will cache assets because of the far future expires
        // header. If existing assets are changed, the version number should also
        // change, to force the browser to download new versions.
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT-DEV");
    }

    @Contribute(ClientWhitelist.class)
    public void enableWhitelistAccessInDevelopmentMode(OrderedConfiguration<WhitelistAnalyzer> configuration) {
        configuration.add("DevAccessAlways",
                new WhitelistAnalyzer() {
                    public boolean isRequestOnWhitelist(Request request) {
                        return true;
                    }
                }
        );
    }

}
