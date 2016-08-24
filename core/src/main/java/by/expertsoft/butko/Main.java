package by.expertsoft.butko;

import by.expertsoft.butko.dao.DAO;
import by.expertsoft.butko.model.Mobile;
import by.expertsoft.butko.model.Producer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wladek on 09.08.16.
 */
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DAO mobileDao = (DAO) context.getBean("MobileDAO");
        Mobile mobile1 = new Mobile(4, "iphone SE", 40, new Producer(4, "Apple"));
        mobileDao.insert(mobile1);
        /*mobileDao.remove(mobile1);
        List<Mobile> mobiles = mobileDao.getList();
        for(Mobile mob: mobiles) {
            System.out.println(mob.getId() + " "+mob.getName());
        }*/
        System.out.println(mobile1.getId());
        context.close();
    }
}
