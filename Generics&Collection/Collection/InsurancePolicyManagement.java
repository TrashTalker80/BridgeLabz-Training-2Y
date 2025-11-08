import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, 
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + 
               " | " + coverageType + " | $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies;
    private Set<Policy> linkedHashSetPolicies;
    private Set<Policy> treeSetPolicies;

    public InsurancePolicyManagement() {
        this.hashSetPolicies = new HashSet<>();
        this.linkedHashSetPolicies = new LinkedHashSet<>();
        this.treeSetPolicies = new TreeSet<>();
    }

    public void addPolicyToHashSet(Policy policy) {
        hashSetPolicies.add(policy);
    }

    public void addPolicyToLinkedHashSet(Policy policy) {
        linkedHashSetPolicies.add(policy);
    }

    public void addPolicyToTreeSet(Policy policy) {
        treeSetPolicies.add(policy);
    }

    public void displayHashSetPolicies() {
        System.out.println("\n--- HashSet Policies (Unordered) ---");
        for (Policy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayLinkedHashSetPolicies() {
        System.out.println("\n--- LinkedHashSet Policies (Insertion Order) ---");
        for (Policy policy : linkedHashSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayTreeSetPolicies() {
        System.out.println("\n--- TreeSet Policies (Sorted by Expiry Date) ---");
        for (Policy policy : treeSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayExpiringWithin30Days() {
        System.out.println("\n--- Policies Expiring Within 30 Days ---");
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().isBefore(thirtyDaysFromNow)) {
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\n--- Policies with Coverage: " + coverageType + " ---");
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        Policy p1 = new Policy("POL001", "John Doe", LocalDate.of(2025, 12, 15), "Health", 5000);
        Policy p2 = new Policy("POL002", "Jane Smith", LocalDate.of(2025, 11, 20), "Auto", 3000);
        Policy p3 = new Policy("POL003", "Bob Johnson", LocalDate.of(2026, 1, 10), "Home", 4000);
        Policy p4 = new Policy("POL001", "Duplicate", LocalDate.of(2025, 12, 15), "Health", 5000);

        system.addPolicyToHashSet(p1);
        system.addPolicyToHashSet(p2);
        system.addPolicyToHashSet(p3);
        system.addPolicyToHashSet(p4);

        system.addPolicyToLinkedHashSet(p1);
        system.addPolicyToLinkedHashSet(p2);
        system.addPolicyToLinkedHashSet(p3);
        system.addPolicyToLinkedHashSet(p4);

        system.addPolicyToTreeSet(p1);
        system.addPolicyToTreeSet(p2);
        system.addPolicyToTreeSet(p3);
        system.addPolicyToTreeSet(p4);

        system.displayHashSetPolicies();
        system.displayLinkedHashSetPolicies();
        system.displayTreeSetPolicies();
        system.displayExpiringWithin30Days();
        system.displayPoliciesByCoverage("Health");
    }
}
