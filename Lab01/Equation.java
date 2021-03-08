import javax.swing.JOptionPane;
import static java.lang.Math.*;

public class Equation {
    public static void main(String[] args) {

        Double a, b, c;
        // First Degree Equation with one Variable
        a = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a:", "First Degree Equation ax + b= c",
                JOptionPane.INFORMATION_MESSAGE));
        b = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b:", "First Degree Equation ax + b= c",
                JOptionPane.INFORMATION_MESSAGE));
        c = Double.parseDouble(JOptionPane.showInputDialog(null, "Input c:", "First Degree Equation ax + b= c",
                JOptionPane.INFORMATION_MESSAGE));
        if (a == 0) {
            if (b == c)
                JOptionPane.showMessageDialog(null, "Infinity solution", "Result", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Solution " + (c - b) / a, "Result", JOptionPane.INFORMATION_MESSAGE);

        // First Degree Equation with two Variables
        Double a1 = Double.parseDouble(JOptionPane.showInputDialog(null, "First Equation ax + by =c => Input a:",
                "First Degree Equation with two variable", JOptionPane.INFORMATION_MESSAGE));
        Double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "First Equation ax + by =c => Input b:",
                "First Degree Equation with two variable", JOptionPane.INFORMATION_MESSAGE));
        Double c1 = Double.parseDouble(JOptionPane.showInputDialog(null, "First Equation ax + by =c => Input c:",
                "First Degree Equation with two variable", JOptionPane.INFORMATION_MESSAGE));

        Double a2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Second Equation ax + by =c => Input a:",
                "First Degree Equation with two variable", JOptionPane.INFORMATION_MESSAGE));
        Double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Second Equation ax + by =c => Input b:",
                "First Degree Equation with two variable", JOptionPane.INFORMATION_MESSAGE));
        Double c2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Second Equation ax + by =c => Input c:",
                "First Degree Equation with two variable", JOptionPane.INFORMATION_MESSAGE));

        if ((a1 == 0) && (b1 == 0)) {
            if (c1 == 0)
                JOptionPane.showMessageDialog(null, "Infinity solution", "Result", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if ((a2 / a1) == (b2 / b1)) {
                if (c2 / c1 == a2 / a1)
                    JOptionPane.showMessageDialog(null, "Infinity solution", "Result", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Result of x = " + (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1),
                        "Solution ", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Result of y =" + (c1 * a2 - c2 * a1) / (b1 * a2 - b2 * a1),
                        "Solution", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Second degree equation with one variable
        a = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a:", "Second Degree Equation ax^2 + bx + c= 0",
                JOptionPane.INFORMATION_MESSAGE));
        b = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b:", "Second Degree Equation ax^2 + bx + c= 0",
                JOptionPane.INFORMATION_MESSAGE));
        c = Double.parseDouble(JOptionPane.showInputDialog(null, "Input c:", "Second Degree Equation ax^2 + bx + c= 0",
                JOptionPane.INFORMATION_MESSAGE));

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Invalid form", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        double d = b * b - 4 * a * c;
        double sqrt_val = sqrt(abs(d));

        if (d > 0) {
            JOptionPane.showMessageDialog(null,
                    "Root 1 = " + (-b + sqrt_val) / (2 * a) + "\nRoot 2 = " + (-b - sqrt_val) / (2 * a), "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if (d == 0) {
            JOptionPane.showMessageDialog(null, "Root 1 = Root 2 = " + -b / (2 * a), "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if (d < 0) {
            JOptionPane
                    .showMessageDialog(
                            null, "Root 1 = " + -b / (2 * a) + " + i " + (sqrt_val / (2 * a)) + "\nRoot 2 = "
                                    + -b / (2 * a) + " - i " + (sqrt_val / (2 * a)),
                            "Result", JOptionPane.INFORMATION_MESSAGE);
        }

        System.exit(0);
    }
}
