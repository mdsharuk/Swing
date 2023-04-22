
package model;


public class TeacherDipti {
    private int id;
 private String Name;
 private String Email;
 private String Cell;
 private String Gender;
 private String Subject;

    public TeacherDipti() {
    }

    public TeacherDipti(int id, String Name, String Email, String Cell, String Gender, String Subject) {
        this.id = id;
        this.Name = Name;
        this.Email = Email;
        this.Cell = Cell;
        this.Gender = Gender;
        this.Subject = Subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCell() {
        return Cell;
    }

    public void setCell(String Cell) {
        this.Cell = Cell;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }
 
 
}
