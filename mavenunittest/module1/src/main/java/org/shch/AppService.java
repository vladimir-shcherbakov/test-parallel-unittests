package org.shch;


import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.appservice.PricingTier;
import com.microsoft.azure.management.appservice.WebApp;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.utils.SdkContext;

import java.util.List;

/**
 * Created by vlashch on 5/9/2017.
 */
public class AppService {
    public static WebApp createAppService(Azure azure) {
        //============================================================
        // Create a web app with a new app service plan
        final String app1Name       = SdkContext.randomResourceName("shch-webapp-", 20);
        final String rg1Name        = SdkContext.randomResourceName("shch-rg_", 24);

        System.out.println(String.format("[%s] Creating web app %s in resource group ...", Thread.currentThread().getId(), app1Name, rg1Name ));

        WebApp app1 = azure.webApps()
                .define(app1Name)
                .withRegion(Region.US_WEST)
                .withNewResourceGroup(rg1Name)
                .withNewWindowsPlan(PricingTier.STANDARD_S1)
                .create();

        System.out.println(String.format("[%s] Created web app %s", Thread.currentThread().getId(), app1Name));
        return app1;
    }

    public static void deleteAppService(Azure azure, WebApp webApp) {
        //=============================================================
        // Delete a web app
        String app1Name = webApp.name();
        String rg1Name = webApp.resourceGroupName();
        System.out.println(String.format("[%s] Deleting web app %s...", Thread.currentThread().getId(), app1Name));
        azure.webApps().deleteByResourceGroup(rg1Name, app1Name);
        System.out.println(String.format("[%s] Deleted web app %s", Thread.currentThread().getId(), app1Name));
    }

    public static boolean existAppService(Azure azure, WebApp webApp) {
        //=============================================================
        // Delete a web app
        String rg1Name = webApp.resourceGroupName();
        // since the rg is random for a web app - it contains only our web app
        List<WebApp> wal = azure.webApps().listByResourceGroup(rg1Name);
        return (wal.size() != 0);
    }
}
