import java.util.*;

public class Ring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Number of processes: ");
        int n = sc.nextInt();

        int[] ids = new int[n];        
        boolean[] active = new boolean[n]; 

        // Input process IDs and mark all as active
        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
            active[i] = true;
        }

        // Select initiator (who starts the election)
        System.out.print("Enter initiator index (0 to " + (n - 1) + "): ");
        int init = sc.nextInt();

        int curr = init;          
        int max = ids[init];      

        System.out.println("Process " + ids[init] + " starts the election.");

        // Pass message around the ring
        do {
            curr = (curr + 1) % n;

            if (active[curr]) {
                System.out.println("Process " + ids[curr] + " receives the message.");
                
                if (ids[curr] > max) {
                    max = ids[curr]; 
                }
            }
        } while (curr != init);

        
        System.out.println("Process " + max + " becomes the new COORDINATOR.");
        sc.close();
    }
}

