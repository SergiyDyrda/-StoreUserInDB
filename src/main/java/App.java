import com.dyrda.entity.User;
import com.dyrda.service.UserService;
import com.dyrda.utils.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Only for testing objectives
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\IdeaProjects\\maven\\StoreUserInDb\\src\\main\\webapp\\WEB-INF\\dispatcher-servlet.xml");
        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);

//        User user1 = new User("Sergiy", 21, true);
//        User user2 = new User("Sergiy", 22, false);
//        User user3 = new User("Sergiy", 23, true);
//        userServiceImpl.createUser(user1);
//        userServiceImpl.createUser(user2);
//        userServiceImpl.createUser(user3);
//
//        user1.setName("BlaBlaBla");
//        userServiceImpl.updateUser(user1);
//        User userById = userServiceImpl.getUserById(1);
//        System.out.println(userById);
//
//        userServiceImpl.deleteUser(2);
//
//        List<User> allUsers = userServiceImpl.getAllUsers();
//        allUsers.forEach(System.out::println);
//
//        System.out.println("-----------");
//
//        System.out.println(userServiceImpl.getUsersByName("BlaBlaBla"));

        HibernateUtil hibernateUtil = context.getBean(HibernateUtil.class);
        List<User> entitiesByEntityParam = hibernateUtil.getEntitiesByEntityParam(User.class, "name", "user_1");
        entitiesByEntityParam.forEach(System.out::println);
    }
}
