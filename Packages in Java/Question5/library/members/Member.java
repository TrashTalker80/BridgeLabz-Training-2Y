package library.members;

public class Member {
    private String memberId;
    private String name;
    private String contactNumber;

    public Member(String memberId, String name, String contactNumber) {
        this.memberId = memberId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void displayMemberDetails() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Contact Number: " + contactNumber);
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
