package org.shch;

import com.microsoft.azure.management.appservice.WebApp;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shch on 5/14/2017.
 */
public class AppServiceTest1 extends AppServiceTestBase{

    @Test
    public void createAppService() throws Exception {
        WebApp wa = AppService.createAppService(azure);
        Assert.assertTrue(AppService.existAppService(azure, wa));
        AppService.deleteAppService(azure, wa);
        Assert.assertFalse(AppService.existAppService(azure, wa));
    }
}