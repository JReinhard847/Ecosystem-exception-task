import java.util.*;

public class StudentRepo {

    private final Map<String, Student> students = new HashMap<>();

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student save(Student student) {
        students.put(student.id(), student);
        return student;
    }

    public Optional<Student> findStudentById(String id) {
        return Optional.ofNullable(students.get(id));
    }

    public Student findById(String id){
        Student student = students.get(id);
        if(student!=null){
            return student;
        }
        throw new NoSuchStudentException("No student with id "+id+" found.");
    }
}
