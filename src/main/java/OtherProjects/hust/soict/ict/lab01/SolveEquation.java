package OtherProjects.hust.soict.ict.lab01;

import javax.swing.JOptionPane;

public class SolveEquation {
    private static double getDouble(String message) {
        String sn = JOptionPane.showInputDialog(message);
        return Double.parseDouble(sn);
    }

    private static void solveLinearSystemEquation() {
        double a11 = getDouble("Enter a11: ");
        double a12 = getDouble("Enter a12: ");
        double b1 = getDouble("Enter b1: ");
        double a21 = getDouble("Enter a21: ");
        double a22 = getDouble("Enter a22: ");
        double b2 = getDouble("Enter b2: ");

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Infinitely many solutions");
            } else {
                JOptionPane.showMessageDialog(null, "No solution");
            }
        } else {
            JOptionPane.showMessageDialog(null, "x1: " + D1 / D + "\nx2: " + D2 / D);
        }
    }

    private static void solveLinearEquation() {
        double a = getDouble("Enter a: ");
        double b = getDouble("Enter b: ");
        String ans;
        if (a == 0) {
            if (b == 0) {
                ans = "Infinitely many solutions";
            } else {
                ans = "No solution";
            }
        } else {
            ans = "x = " + (-b / a);
        }
        JOptionPane.showMessageDialog(null, ans);
    }

    private static void solveQuadraticEquation() {
        double a = getDouble("Enter a: ");
        double b = getDouble("Enter b: ");
        double c = getDouble("Enter c: ");

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Infinitely many solutions");
                } else {
                    JOptionPane.showMessageDialog(null, "No solution");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Linear solution:\nx = " + (-c / b));
            }
            return;
        }

        double D = b * b - 4 * a * c;
        if (D < 0) {
            JOptionPane.showMessageDialog(null, "No solution");
        } else if (D == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "One solution\nx = " + x);
        } else {
            double sqrD = Math.sqrt(D);
            double x1 = (-b + sqrD) / (2 * a);
            double x2 = (-b - sqrD) / (2 * a);
            JOptionPane.showMessageDialog(null, "Two solutions\nx1 = " + x1 + "\nx2 = " + x2);
        }
    }

    public static void main(String[] args) {
        String inp = JOptionPane.showInputDialog("Choose type of equation:\n1: linear equation\n2: linear system\n3: quadratic equation\n");
        if (inp == null) {
            return;
        }
        if (inp.equals("1")) {
            solveLinearEquation();
        } else if (inp.equals("2")) {
            solveLinearSystemEquation();
        } else if (inp.equals("3")) {
            solveQuadraticEquation();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
    }
}
