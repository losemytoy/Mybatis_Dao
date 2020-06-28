
import com.shit.DAO.UserDao;
import com.shit.DBUtils;
import com.shit.entity.Users;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = DBUtils.openSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            ArrayList<Users> users = userDao.getAllUsers();
            System.out.println(users);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
