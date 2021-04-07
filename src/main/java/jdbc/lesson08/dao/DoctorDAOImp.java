package jdbc.lesson08.dao;

import jdbc.lesson08.entity.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImp implements DoctorDAO {

    String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
    String user = "root";
    String pass = "root";

    @Override
    public void create(Doctor doctor) {
        try (Connection con = DriverManager.getConnection(url, user, pass)){
            PreparedStatement statement = con.prepareStatement("insert into doctor(id, name, surname, age) value (?, ?, ?, ?)") ;
            statement.setInt(1, doctor.getId());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSurname());
            statement.setInt(4, doctor.getAge());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor read(Integer id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)){
            PreparedStatement statement = con.prepareStatement("select * from doctor where id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            Doctor doctor = new Doctor();
            while (set.next()) {
                doctor.setId(set.getInt("id"));
                doctor.setName(set.getString("name"));
                doctor.setSurname(set.getString("surname"));
                doctor.setAge(set.getInt("age"));
            }
            statement.close();
            return doctor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Doctor doctor) {
        try (Connection con = DriverManager.getConnection(url, user, pass)){
            PreparedStatement statement = con.prepareStatement("update doctor set name = ?, surname = ?, age = ? where id = ?");
            statement.setInt(1, doctor.getAge());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSurname());
            statement.setInt(4, doctor.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Doctor doctor) {

    }

    @Override
    public List<Doctor> findAll() {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = con.prepareStatement("select * from doctor");
            ResultSet set = statement.executeQuery();
            List<Doctor> doctors = new ArrayList<>();
            while (set.next()) {
                doctors.add(
                        new Doctor(set.getInt("id"), set.getString("name"), set.getString("surname"), set.getInt("age")));
            }
            statement.close();
            return doctors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
