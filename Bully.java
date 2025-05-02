import java.util.*;

public class Bully {

    static boolean[] up = {true, true, true, true, true};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\n1. Bring Up a Process\n2. Bring Down a Process\n3. Start Election\n4. Exit\nChoose option: ");
            int choice = sc.nextInt();

            if (choice == 4) break;

            System.out.print("Enter Process Number (1 to 5): ");
            int p = sc.nextInt() - 1;

            switch (choice) {
                case 1:
                    up[p] = true;
                    System.out.println("Process P" + (p + 1) + " is now UP");
                    break;

                case 2:
                    up[p] = false;
                    System.out.println("Process P" + (p + 1) + " is now DOWN");
                    elect(p);
                    break;

                case 3:
                    elect(p);
                    break;

                default:
                    System.out.println("Invalid Option. Try again.");
            }
        }

        sc.close();
    }

    static void elect(int p) {
        System.out.println("Process P" + (p + 1) + " is starting an election.");
        for (int i = 4; i > p; i--) {
            if (up[i]) {
                System.out.println("Process P" + (i + 1) + " is selected as COORDINATOR");
                return;
            }
        }
        System.out.println("No higher process is UP");
        System.out.println("Process P" + (p + 1) + " becomes the COORDINATOR");
    }
}
