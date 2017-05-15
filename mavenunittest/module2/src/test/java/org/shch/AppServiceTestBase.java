package org.shch;

import com.microsoft.azure.management.Azure;
import com.microsoft.rest.LogLevel;
import org.junit.Before;

import java.io.File;

/**
 * Created by shch on 5/14/2017.
 */
public class AppServiceTestBase {

    Azure azure = null;

    @Before
    public void initAzure() {
        try {
            String loc = System.getenv("AZURE_AUTH_LOCATION");
            final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));
            azure = Azure
                    .configure()
//                    .withLogLevel(LogLevel.BODY_AND_HEADERS)
                    .withLogLevel(LogLevel.NONE)
                    .authenticate(credFile)
                    .withDefaultSubscription();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Print selected subscription
        System.out.println("Selected subscription: " + azure.subscriptionId());
    }

}
