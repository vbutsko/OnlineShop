package by.expertsoft.butko;

import by.expertsoft.butko.dao.GenericDao;
import by.expertsoft.butko.phone.Phone;
import by.expertsoft.butko.phone.Manufacturer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wladek on 09.08.16.
 */
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GenericDao mobileDao = (GenericDao) context.getBean("jdbcPhoneDao");
        Phone phone1 = new Phone(4, "iphone SE", new BigDecimal(40), new Manufacturer(4, "Apple"));
        //mobileDao.insert(phone1);
        //mobileDao.remove(phone1);
        List<Phone> mobiles = mobileDao.getList();
        for(Phone mob: mobiles) {
            System.out.println(mob.getId() + " "+mob.getName());
        }
        //System.out.println(phone1.getId());
        context.close();
    }
}
