import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;
    private List<String> requiredSkills;

    public JobRole(String roleName, List<String> requiredSkills) {
        this.roleName = roleName;
        this.requiredSkills = requiredSkills;
    }

    public String getRoleName() {
        return roleName;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    @Override
    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", List.of("Java", "Python", "SQL", "Data Structures"));
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", List.of("Python", "Machine Learning", "Statistics", "SQL"));
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", List.of("Product Strategy", "Communication", "Agile", "Leadership"));
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    private List<String> skills;
    private int experience;

    public Resume(String candidateName, T jobRole, List<String> skills, int experience) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
        this.skills = skills;
        this.experience = experience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getExperience() {
        return experience;
    }

    public boolean meetsRequirements() {
        int matchedSkills = 0;
        for (String required : jobRole.getRequiredSkills()) {
            if (skills.contains(required)) {
                matchedSkills++;
            }
        }
        return matchedSkills >= (jobRole.getRequiredSkills().size() * 0.6);
    }

    @Override
    public String toString() {
        return candidateName + " - " + jobRole.getRoleName() + " (" + experience + " years)";
    }
}

class ResumeScreener {
    private List<Resume<? extends JobRole>> allResumes = new ArrayList<>();

    public <T extends JobRole> void submitResume(Resume<T> resume) {
        allResumes.add(resume);
        System.out.println("Submitted: " + resume);
    }

    public void screenResumes() {
        System.out.println("\nScreening Results:");
        for (Resume<? extends JobRole> resume : allResumes) {
            String status = resume.meetsRequirements() ? "QUALIFIED" : "NOT QUALIFIED";
            System.out.println(" - " + resume + " : " + status);
        }
    }
}

public class AIResumeScreeningSystem {
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("\nProcessing " + resumes.size() + " resumes...");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(" - " + resume);
        }
    }

    public static void main(String[] args) {
        ResumeScreener screener = new ResumeScreener();

        Resume<SoftwareEngineer> seResume1 = new Resume<>(
            "John Doe",
            new SoftwareEngineer(),
            List.of("Java", "Python", "SQL", "Data Structures", "Algorithms"),
            3
        );

        Resume<SoftwareEngineer> seResume2 = new Resume<>(
            "Jane Smith",
            new SoftwareEngineer(),
            List.of("JavaScript", "HTML", "CSS"),
            2
        );

        Resume<DataScientist> dsResume = new Resume<>(
            "Alice Johnson",
            new DataScientist(),
            List.of("Python", "Machine Learning", "Statistics", "SQL", "Deep Learning"),
            5
        );

        Resume<ProductManager> pmResume = new Resume<>(
            "Bob Williams",
            new ProductManager(),
            List.of("Product Strategy", "Communication", "Agile", "Leadership", "Analytics"),
            7
        );

        screener.submitResume(seResume1);
        screener.submitResume(seResume2);
        screener.submitResume(dsResume);
        screener.submitResume(pmResume);

        screener.screenResumes();

        List<Resume<? extends JobRole>> allResumes = List.of(seResume1, seResume2, dsResume, pmResume);
        processResumes(allResumes);
    }
}
