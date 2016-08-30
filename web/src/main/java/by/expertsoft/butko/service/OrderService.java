package by.expertsoft.butko.service;

import by.expertsoft.butko.phone.PersonalInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by wladek on 28.08.16.
 */
@Service
// rename to orderservice
public class PersonalInfoService {

    public void setPersonalInfo(PersonalInfo personalInfo, HttpServletRequest request){
        request.getSession().setAttribute("personalInfo", personalInfo);
    }

    public PersonalInfo getPersonalInfo(HttpServletRequest request){
        PersonalInfo personalInfo = (PersonalInfo) request.getSession().getAttribute("personalInfo");
        if(personalInfo==null){
            personalInfo = new PersonalInfo();
            request.getSession().setAttribute("personalInfo", personalInfo);
        }
        return personalInfo;
    }

}
