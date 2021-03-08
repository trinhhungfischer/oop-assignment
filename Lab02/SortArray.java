import java.util.*;

public class SortArray {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap so phan tu cua day");
        int n = keyboard.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        System.out.println("Day ban vua nhap la");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Day sau khi sap xep la");
        System.out.println(Arrays.toString(a));

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        System.out.println("Tong day ban vua nhap la: " + sum);

        System.out.println("Trung binh cong day ban vua nhap la: " + (double) (sum) / n);
    }
}
