package myApp.userAction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import myApp.DTO.Workers;
import myApp.dataBase.Connect;
import net.n2oapp.criteria.api.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class UserService {

    @Autowired
    private EntityManagerFactory emf;
    @Autowired
    private SessionFactory sf;

    public boolean deletingUser(int id) {
        try {
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Workers worker = entityManager.find(Workers.class, id);
            entityManager.remove(worker);
            entityTransaction.commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean creatingUser(Workers user) {

        try {
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            int maxID = entityManager.createQuery("SELECT MAX(w.employeeId) FROM Workers w", Integer.class).getSingleResult();
            user.setEmployeeId(maxID + 1);
            entityManager.merge(user);
            entityTransaction.commit();
            entityManager.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updatingUser(int id, String name) {
        try {

            EntityManager entityManager = emf.createEntityManager();
            //Workers worker = entityManager.find(Workers.class, id);
            Workers workers1 = sf.openSession().get(Workers.class, id);
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            workers1.setFirstName(name);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean gettingUser(int id, Model model) {

        try {

            EntityManager entityManager = emf.createEntityManager();
            Workers worker = entityManager.find(Workers.class, id);


                model.addAttribute("ID", worker.getEmployeeId());
                model.addAttribute("firstName", worker.getFirstName());
                model.addAttribute("lastName", worker.getLastName());
                model.addAttribute("email", worker.geteMail());
                model.addAttribute("phoneNumber", worker.getPhoneNumber());
                model.addAttribute("hireDate", worker.getHireDate());
                model.addAttribute("salary", worker.getSalary());
                model.addAttribute("commissionPCT", worker.getCommissionPCT());
                model.addAttribute("departmentID", worker.getDepartmentID());

            return true;
        } catch (Exception e) {
            return false;
        }

    }


}