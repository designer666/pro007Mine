package jdbc.lesson08.dao;

import jdbc.lesson08.entity.Doctor;

import java.util.List;

public interface DoctorDAO {

    /*DAO (Data Access Object) - шаблон проектирования, предназначен для обработки записей в БД
    *
    * В состав DAO входит 4 основных методов (CRUD)
    *
    * - CREATE
    * - READ by ID
    * - UPDATE
    * - DELETE
    *
    * - findAll() - проверяет наличие записей в таблице БД, и если они есть, возвращает их, иначе ничего не делается
    * - getAll()  - проверяет наличие записей в таблице БД, и если их нет, кидает throw new IllegalStateException*/

    void create(Doctor doctor);

    Doctor read(Integer id);

    void update(Doctor doctor);

    void delete(Doctor doctor);

    List<Doctor> findAll();
}
