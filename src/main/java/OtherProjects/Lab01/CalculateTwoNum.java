package Lab01;
import javax.swing.JOptionPane;

public class CalculateTwoNum {
    public static void main(String[] args) {
        String num1Input = JOptionPane.showInputDialog("Enter first integer");
        String num2Input = JOptionPane.showInputDialog("Enter first integer");
        double num1 = Double.parseDouble(num1Input);
        double num2 = Double.parseDouble(num2Input);

        double sum = num1 + num2;
        double diff = num1 - num2;
        double product = num1 * num2;
        double div = 0;
        String message = "Sum: "+sum+"\nDiff: "+diff+"\nProduct: "+product+"\n";
        if(num2 == 0){
            message = message + "Quotient Invalid";
            JOptionPane.showMessageDialog(null, message);
        }else{
          div = num1 / num2;
          message = message + "Division: "+div+"\n";
          JOptionPane.showMessageDialog(null, message);
        }
    }

}
