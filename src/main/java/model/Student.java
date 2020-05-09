package model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    @NotNull
    private String pesel;

    @NotNull
    private String email;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String zipCode;

    @OneToMany
    private Set<Exam> exams = new LinkedHashSet<>();

    public Student(String firstName, String secondName, String pesel, String email, String address,
                   String city, String zipCode) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }

    public void addExam(Exam exam){
        exam.setStudent(this);
        this.exams.add(exam);
    }
}