import java.util.Scanner;

public class CalenderShow {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int MonthINT = 0;
		int YearINT = 0;
		String[] strMonth = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		String[] strMonthRutGon = new String[12];
		String[] strMonthThemCham = new String[12];
		String[] strMonthInt = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		for (int i = 0; i < 12; i++) {
			strMonthRutGon[i] = strMonth[i].substring(0, 3);
			strMonthThemCham[i] = strMonthRutGon[i] + ".";
		}

		boolean pass = false;
		do {
			System.out.println("Nhap thang");
			String getStrMonth = keyboard.nextLine();

			for (int i = 0; i < 12; i++) {
				if (strMonth[i].equals(getStrMonth) || strMonthInt[i].equals(getStrMonth)
						|| strMonthRutGon[i].equals(getStrMonth) || strMonthThemCham[i].equals(getStrMonth)) {
					pass = true;
					MonthINT = i + 1;
					break;
				}
				if (i == 11) {
					System.out.println("Vui long nhap lai thang");
				}
			}
		} while (!pass);

		// Nhap nam bat dau tu day
		pass = false;
		do {
			try {
				System.out.println("Nhap nam");
				String getYear = keyboard.nextLine();
				YearINT = Integer.parseInt(getYear);
				pass = true;

			} catch (Exception e) {
				System.out.println("Vui long nhap lai nam");
				continue;
			}
		} while (!pass);

		// Xuat so ngay trong thang tu day
		boolean isLeapYear = false;
		if ((YearINT % 4 == 0 && YearINT % 100 != 0) || YearINT % 400 == 0) {
			isLeapYear = true;
		}

		if (MonthINT == 1 || MonthINT == 3 || MonthINT == 5 || MonthINT == 7 || MonthINT == 8 || MonthINT == 10
				|| MonthINT == 12) {
			System.out.println("Thang co 31 ngay");
		} else if (MonthINT != 2)
			System.out.println("Thang co 30 ngay");
		else if (isLeapYear) {
			System.out.println("Thang co 29 ngay");
		} else
			System.out.println("Thang co 28 ngay");

		keyboard.close();
	}
}
