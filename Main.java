import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        insertStudent();
        insertTeacher();
        selectStudent();
        selectTeacher();
        updateStudent();
        updateTeacher();
        deleteStudent();
        deleteTeacher();

    }

    static void deleteTeacher(){
        int id = sc.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher where id='"+id+"'");
            if(count>0){
                System.out.println("Teacher is deleted from DB");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static void deleteStudent(){
        int rollNo = scanner.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student where rollNo='"+rollNo+"'");
            if(count>0){
                System.out.println("Student is deleted from DB");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static void updateTeacher(){
        Teacher teacher = new Teacher();
        teacher.setId(sc.nextInt());
        teacher.setName(sc.next());
        teacher.setEmail(sc.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update teacher set name='"+teacher.getName()+"',email='"+teacher.getEmail()+"' where id='"+teacher.getId()+"'");
            selectTeacher(teacher.getId());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static void updateStudent(){
        Student student = new Student();
        student.setRollNo(scanner.nextInt());
        student.setName(scanner.next());
        student.setEmail(scanner.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            st.executeUpdate("update student set name='"+student.getName()+"',email='"+student.getEmail()+"' where rollNo='"+student.getRollNo()+"'");
            selectStudent(student.getRollNo());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void selectTeacher(int id) {
        Teacher teacher = new Teacher();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from  where teacher id = '"+id+"'");
            while (rs.next()){
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
            }
            System.out.println(teacher.getId());
            System.out.println(teacher.getName());
            System.out.println(teacher.getEmail());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


    static void selectStudent(int rollNo){
        Student student = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollNo = '"+rollNo+"'");
            while (rs.next()){
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            System.out.println(student.getRollNo());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static void selectTeacher(){
        Teacher teacher = new Teacher();
        int id= sc.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher where id='"+id+"'");
            while (rs.next()){
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
            }
            System.out.println(teacher.getId());
            System.out.println(teacher.getName());
            System.out.println(teacher.getEmail());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static void selectStudent(){
        Student student = new Student();
        int rollNo= scanner.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollNo='"+rollNo+"'");
            while (rs.next()){
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            System.out.println(student.getRollNo());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static void insertTeacher(){
        Teacher teacher = new Teacher();
        teacher.setId(sc.nextInt());
        teacher.setName(sc.next());
        teacher.setEmail(sc.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            st.executeUpdate("insert into teacher values('" + teacher.getId() + "','" + teacher.getName() + "','" + teacher.getEmail() + "')");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static void insertStudent(){
        Student student = new Student();
        student.setRollNo(scanner.nextInt());
        student.setName(scanner.next());
        student.setEmail(scanner.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values('" + student.getRollNo() + "','" + student.getName() + "','" + student.getEmail() + "')");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}