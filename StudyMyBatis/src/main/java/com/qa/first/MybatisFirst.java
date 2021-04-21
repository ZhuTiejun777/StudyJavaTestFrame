package com.qa.first;


import com.qa.po.EtcCard;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * dao：数据库mapper接口存放目录
 * po：所有的实体类放到目录
 * mpaaer：所有的xml放在这个目录
 * */

public class MybatisFirst {

    //因为接下来的测试代码中，获取sqlSession这部分都相同，所以抽取成一个方法
    public SqlSession getSession() throws IOException {

        String resource = "SqlMapConfig.xml"; //mybatis配置文件

        //得到配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        // SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSessionFactory.openSession();
    }

    //根据id查询用户的信息，得到一条记录的结果
    @Test
    public void findUserById() throws IOException {

        SqlSession sqlSession = getSession(); //调用上面的方法获取sqlSession

        //通过SqlSession操作数据库
        //第一个参数：映射文件中statement的id，= namespace + statement的id
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        //selectOne表示查询出一条记录进行映射
        EtcCard etcCard = sqlSession.selectOne("com.qa.po.EtcCard.findUserById", 1);

        System.out.println(etcCard.toString());

        //释放资源，最好放在finally中，
        sqlSession.close();
    }

    //省略不相关代码

    //根据用户名称模糊查询用户列表
    @Test
    public void findUserByName() throws IOException, ParseException {

        SqlSession sqlSession = getSession();

        //selectList表示查询出一个列表（多条记录）进行映射
        List<EtcCard> list = sqlSession.selectList("com.qa.po.EtcCard.findUserByList", "浙A");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beginTime = "2020-07-28 14:42:32";
        Date date = format.parse(beginTime);
        // System.out.println(list);
        int number = 0;
        for (EtcCard etcCard : list) {
            /*if (etcCard.getCard_code() == null || etcCard.getCard_code().equals("")) {
                System.out.println(etcCard.toString());
                number +=1;
            }*/
            if (date.before(etcCard.getCreate_time())) {
                System.out.println(etcCard.toString());
                number +=1;
            }
        }
        System.out.println(number);
        //释放资源，最好放在finally中
        sqlSession.close();
    }
}