package com.MyBatis;

import com.kgc.mapper.empMapper;
import com.kgc.pojo.empExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    private SqlSession sqlSession;
    @Before
    public void init(){
        try {
            InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        empExample emp = new empExample();
        empExample.Criteria c = emp.createCriteria();//Criteria才是真正的条件
        c.andNameLike("%冰%");
        emp.setOrderByClause("sal desc");
        emp.limit(0,3);
        sqlSession.getMapper(empMapper.class).selectByExample(emp);

    }
    @After
    public void destory(){
        try{
            sqlSession.commit();
        }catch(Exception e){
            sqlSession.rollback();
        }finally{
            sqlSession.close();
        }

    }

}
