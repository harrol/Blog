import org.junit.Assert;
import org.junit.Test;

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
