import com.lissenberg.blog.domain.Statistics;
import com.lissenberg.blog.services.StatsService;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;

public class BaseTest {

//    @Deployment
//    public static JavaArchive createTestArchive() {
//        return ShrinkWrap.create(JavaArchive.class, "test.jar")
//                .addClasses(StatsService.class);
//    }
//
//    @EJB
//    private StatsService statsService;

    @Test
    public void testSucess() {
        Assert.assertTrue(true);
    }
}
