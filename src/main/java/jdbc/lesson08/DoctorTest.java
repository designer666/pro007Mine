package jdbc.lesson08;

import jdbc.lesson08.dao.DoctorDAO;
import jdbc.lesson08.dao.DoctorDAOImp;
import jdbc.lesson08.entity.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DoctorTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        DoctorDAO doctorDAO = new DoctorDAOImp();

        /*doctorDAO.create(new Doctor(1, "Barsuk", "Enotovich", 97));
        doctorDAO.create(new Doctor(2, "Oleg", "House", 17));
        doctorDAO.create(new Doctor(3, "Lexa", "Promily", 97));*/

        Doctor doctor = doctorDAO.read(1);
        System.out.println(doctor);

        doctor.setName("NoName");

        doctorDAO.update(doctor);

        Doctor doctor2 = doctorDAO.read(1);
        System.out.println(doctor2);

        List<Doctor> doctors = doctorDAO.findAll();
        doctors.forEach(System.out::println);
    }
}
