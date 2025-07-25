import java.util.*;

// Abstract Job Role
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract void evaluate();
}

// Subclasses
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) {
        super(name);
    }

    public void evaluate() {
        System.out.println(getCandidateName() + " is evaluated for Software Engineer role.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name) {
        super(name);
    }

    public void evaluate() {
        System.out.println(getCandidateName() + " is evaluated for Data Scientist role.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name) {
        super(name);
    }

    public void evaluate() {
        System.out.println(getCandidateName() + " is evaluated for Product Manager role.");
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private T candidate;

    public Resume(T candidate) {
        this.candidate = candidate;
    }

    public void process() {
        candidate.evaluate();
    }

    public T getCandidate() {
        return candidate;
    }
}

// Utility
class ResumeProcessor {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            role.evaluate();
        }
    }
}

// Main
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> r2 = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> r3 = new Resume<>(new ProductManager("Charlie"));

        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();
        resumeList.add(r1);
        resumeList.add(r2);
        resumeList.add(r3);

        System.out.println("=== Screening Resumes ===");
        for (Resume<? extends JobRole> resume : resumeList) {
            resume.process();
        }
    }
}
