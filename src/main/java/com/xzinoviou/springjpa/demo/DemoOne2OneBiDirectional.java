package com.xzinoviou.springjpa.demo;

import com.xzinoviou.springjpa.config.SessionFactoryConfiguration;
import com.xzinoviou.springjpa.domain.jpa.Instructor;
import com.xzinoviou.springjpa.domain.jpa.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

import static com.xzinoviou.springjpa.constants.Constants.CFG_ONE_TO_ONE_BI_DIRECTIONAL;

public class DemoOne2OneBiDirectional {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = SessionFactoryConfiguration.buildFrom(
                CFG_ONE_TO_ONE_BI_DIRECTIONAL, Instructor.class, InstructorDetail.class);

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Instructor instructor = session.find(Instructor.class, 4L);

        //InstructorDetail instructorDetail = session.find(InstructorDetail.class, 2L);
        //session.save(instructor("Pinot", "Noir"));

        //session.delete(instructor);
        session.getTransaction().commit();

        session.close();

        System.out.println(instructor.toString());
        //System.out.println(instructorDetail.toString());
    }


    private static Instructor instructor(String firstName, String lastName) {
        InstructorDetail detail = new InstructorDetail();
        detail.setAmazonUrl(String.format("https://www.amazon.com/%s-%s/info", firstName, lastName));

        Instructor instructor = new Instructor();
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setEmail(lastName);
        instructor.setDateOfAdmission(LocalDate.now());
        instructor.setInstructorDetail(detail);
        return instructor;
    }

}
