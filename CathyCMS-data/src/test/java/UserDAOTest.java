import com.data.mapper.CmsUserMapper;
import com.data.pojo.CmsUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 陈敬 on 7/9/31.
 */
@ContextConfiguration(locations = "classpath:spring/applicationContext-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@Transactional
public class UserDAOTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CmsUserMapper mapper;

    @Test
    public void selectByPrimaryKey() {
        int id = 1;
        CmsUser user = mapper.selectByPrimaryKey(id);
        Assert.assertEquals(id, (long) user.getUserId());
    }
}
