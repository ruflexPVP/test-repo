public class Candidate extends Person {
    private String email;

    public Candidate(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void takeExam() {
        System.out.println(getName() + " is taking an online exam.");
    }

    @Override
    public String toString() {
        return "Candidate: " + getName() + " (" + email + ")";
    }
}
