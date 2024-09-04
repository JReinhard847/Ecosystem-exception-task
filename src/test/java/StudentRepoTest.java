import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {

    @Test
    void findByIdTestDoesnotThrowIfStudentIsInDB() {
        Student student = Student.builder()
                .name("John")
                .id("1")
                .build();

        StudentRepo studentRepo = new StudentRepo();
        studentRepo.save(student);
        assertDoesNotThrow(() -> studentRepo.findById("1"));
    }

    @Test
    void findByIdTestThrowsIfStudentIsNotInDB() {
        Student student = Student.builder()
                .name("John")
                .id("1")
                .build();

        StudentRepo studentRepo = new StudentRepo();
        studentRepo.save(student);
        assertThrows(NoSuchStudentException.class,()-> studentRepo.findById("2"));
    }
}