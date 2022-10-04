package repository;


import entity.Teacher;
import entity.University;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherRepository extends Repository<Teacher> {
    @Override
    public List<Teacher> getList() {
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from teacher");

            List<Teacher> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("salary"),
                        rs.getString("surname"),
                        new University(rs.getInt("university_id"), null)));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
    public List<Teacher> getList(String name, String surname, BigDecimal salary) {
        try (Connection connection = connect()) {
            String sql = "select * from teacher where ";
            
            int index = 0;
            if(name != null && name.trim().length()>0){
            sql +="name like ? and ";
            index++;
            }
             if(surname != null && surname.trim().length()>0){
            sql +="surname like ? and ";
            index++;

            }
            if(salary != null){
            sql +="salary=? and ";
            index++;
            }
            
            sql = sql.substring(0, sql.length()-5);
            
            System.out.println(sql);
            PreparedStatement statement = connection.prepareStatement(sql);
            
            if(salary != null){
                statement.setBigDecimal(index, salary);
                index--;
            }
            if(surname != null && surname.trim().length() >0){
                statement.setString(index, "%" + surname + "%");
                index--;
            }
            if(name != null && name.trim().length()>0){
                statement.setString(index, "%" + name + "%");
                index--;
            }
            
            ResultSet rs = statement.executeQuery();
           
            List<Teacher> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("salary"),
                        rs.getString("surname"),
                        new University(rs.getInt("university_id"), null)));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Teacher getById(Integer id) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("select * from teacher where id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("salary"),
                        rs.getString("surname"),
                        new University(rs.getInt("university_id"), null));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Teacher insert(Teacher teacher) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into teacher (name, surname, salary, university_id) values(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, teacher.getName());
            statement.setString(2, teacher.getSurname());
            statement.setBigDecimal(3, teacher.getSalary());
            if(teacher.getUniversity() != null){
                 statement.setInt(4, teacher.getUniversity().getId());
            }else{
                 statement.setNull(4,Types.INTEGER);
            }
            
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                teacher.setId(rs.getInt(1));
            }
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Teacher teacher) {
        try (Connection connection = connect()) {
            int index = 1;
            String sql = "update teacher set ";
            if (teacher.getName() != null) {
                sql += "name =?,";
                index++;
            }

            if (teacher.getSurname() != null) {
                sql += "surname =?,";
                index++;
            }

            if (teacher.getSalary() != null) {
                sql += "salary =?,";
                index++;
            }

            if (teacher.getUniversity() != null) {
                sql += "university_id =?,";
                index++;
            }
            sql = sql.substring(0, sql.length() - 1);
            sql += " where id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(index, teacher.getId());
            index--;

            if (teacher.getUniversity() != null) {
                statement.setInt(index, teacher.getUniversity().getId());
                index--;
            }
            if (teacher.getSalary() != null) {
                statement.setBigDecimal(index, teacher.getSalary());
                index--;
            }
            if (teacher.getSurname() != null) {
                statement.setString(index, teacher.getSurname());
                index--;
            }
            if (teacher.getName() != null) {
                statement.setString(index, teacher.getName());
                index--;
            }

            return statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("delete from teacher where id = ?");
            statement.setInt(1, id);

            return statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
