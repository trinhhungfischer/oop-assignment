import java.util.*;

public class SumMatrix {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Nhap so hang cua ma tran");
        int m = keyboard.nextInt();

        System.out.println("Nhap so cot cua ma tran ");
        int n = keyboard.nextInt();

        int[][] a = new int[m][n];
        int[][] b = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                System.out.print("Nhap phan tu a[" + (i + 1) + "][" + (j + 1) + "]=");
                a[i][j] = keyboard.nextInt();
            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                System.out.print("Nhap phan tu b[" + (i + 1) + "][" + (j + 1) + "]=");
                b[i][j] = keyboard.nextInt();
            }

        System.out.println("Ket qua cua phep cong 2 ma tran la");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((a[i][j] + b[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
