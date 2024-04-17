import java.util.LinkedList;
import java.util.Scanner;

class linkedlist {
    public static void main(String args[]) throws IndexOutOfBoundsException {
        LinkedList<String> l = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.ADD \n2.REMOVE \n3.REVERSE");
            System.out.println("\nEnter the choice :");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Enter Name :");
                    l.add(sc.next());
                    break;
                case 2:
                    System.out.println(" List after Deleting first element :");
                    l.remove(0);
                    for (int i = 0; i < l.size(); i++)
                        System.out.println(l.get(i));
                    break;
                case 3:
                    System.out.println("REVERSE :");
                    for (int i = l.size() - 1; i >= 0; i--)
                        System.out.println(l.get(i));
                    break;
            }
        }
    }
}
