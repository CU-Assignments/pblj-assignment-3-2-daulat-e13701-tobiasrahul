// CRUDOperations.java
public class CRUDOperations {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create
        Student student = new Student();
        student.setName("John");
        student.setAge(22);
        session.save(student);

        // Read
        Student s = session.get(Student.class, 1);
        System.out.println(s.getName());

        // Update
        s.setAge(23);
        session.update(s);

        // Delete
        session.delete(s);

        tx.commit();
        session.close();
    }
}



