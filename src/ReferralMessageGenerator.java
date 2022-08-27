import java.util.Scanner;

public class ReferralMessageGenerator {
    public static void main(String[] args) {
        String gender, position, skills, jobId, jobLink,company;

        Scanner sc = new Scanner(System.in);
        System.out.println("Gender(Sir/Ma'am): ");
        gender = sc.nextLine();
        System.out.println("Company(Eg: Amazon): ");
        company = sc.nextLine();
        System.out.println("Position(Eg: SDE): ");
        position = sc.nextLine();
        System.out.println("Job ID: ");
        jobId = sc.nextLine();
        System.out.println("Job Link: ");
        jobLink = sc.nextLine();
        System.out.println("Skills for particular job: ");
//        skills = sc.nextLine();


        System.out.println("Hi "+gender+", I'm Suvro Bose from Jadavpur University, pursuing BE in Production Engineering. I have solved more than 400+ problems across various platforms like LeetCode and GeeksForGeeks. I have interned at PwC as a Technology Consultant for the last 2 months. I would like to apply for "+position+" position in "+company+" as I think my respective skills align with the job description, also I think my strengths integrate with job role and would contribute towards enhanced growth of the organization. It'll be of immense help if you can provide me a referral for the same in your firm. Here's is the job ID: "+jobId+" and the link corresponding to the same "+jobLink);

    }
}
