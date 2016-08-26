package by.expertsoft.butko;

import by.expertsoft.butko.dao.GenericDao;
import by.expertsoft.butko.phone.Phone;
import by.expertsoft.butko.phone.Manufacturer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wladek on 09.08.16.
 */
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GenericDao mobileDao = (GenericDao) context.getBean("MobileDAO");
        Phone phone1 = new Phone(4, "iphone SE", 40, new Manufacturer(4, "Apple"));
        mobileDao.insert(phone1);
        /*mobileDao.remove(phone1);
        List<Phone> mobiles = mobileDao.getList();
        for(Phone mob: mobiles) {
            System.out.println(mob.getId() + " "+mob.getName());
        }*/
        System.out.println(phone1.getId());
        context.close();
    }
}
