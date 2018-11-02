package Demo;

import com.demo.dao.UserMapper;
import com.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper dao = (UserMapper) session.getMapper(UserMapper.class);

            User user = new User();
            user.setUsername("aaa");
            user.setPassword("123");

            dao.insertUser(user);

            session.commit();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
