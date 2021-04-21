import com.library.core.mapper.dao.AdminDao;
import com.library.core.serviceImpl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class TestMyBatis extends BaseJunit4Test{

    @Autowired
    AdminDao adminDao;
    @Resource
    LoginServiceImpl loginServiceImpl;

    @Test
    //@Transactional   //标明此方法需使用事务
    //@Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void test01 () {
        //AdminDao adminDao = new AdminDao();
        int count = adminDao.getMatchCount(123456, "123456");
        /*if ((adminDao.getMatchCount(123456, "123456")) == 0) {
           throw new Exception();
        }*/
        System.out.println(count);

    }

    @Test
    public void test02 () {
        String username = adminDao.getUsername(123456);
        System.out.println(username);
    }

    @Test
    public void test03 () {
        // boolean bool = loginService.hasMatchReader(10000, "123456");
        if (loginServiceImpl.hasMatchReader(10000, "123456")) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

    @Test
    public void test04 () {
        System.out.println(adminDao.getName("admin"));
    }
}
