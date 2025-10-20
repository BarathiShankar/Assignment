//Program to create a GUI integrated sample shopping cart for the provided list
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class shop extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9;
 JButton b;
 shop()
 {
 setSize(350, 500);
 setLayout(new GridLayout(0, 1, 3, 5)); // 1 column, auto rows, 5px spacing
 l1=new JLabel("Electronics :");
 l2=new JLabel("Utensils : ");
 l3=new JLabel("Fruits : ");
 c1=new JCheckBox("Mobile");
 c3=new JCheckBox("Laptop");
 c2=new JCheckBox("Airpods");
 c4=new JCheckBox("Pan");
 c5=new JCheckBox("Spoon");c6=new JCheckBox("Plate");
 c7=new JCheckBox("Mango");
 c8=new JCheckBox("Lichie");
 c9=new JCheckBox("Papaya");
 b=new JButton("Submit");
 add(l1);
 add(c1);
 add(c2);
 add(c3);
 add(l2);
 add(c4);
 add(c5);
 add(c6);
 add(l3);
 add(c7);
 add(c8);
 add(c9);
 add(b);
 setVisible(true);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 b.addActionListener(this);
 }
 @Override
 public void actionPerformed(ActionEvent e) {
 String ans = "Cart : ";
 int tot=0;
 if (c1.isSelected()) {
 ans+=c1.getText()+"(100rs) , ";
 tot+=100;
 }
 if (c3.isSelected()) {
 ans+=c3.getText()+"(200rs) , ";
 tot+=200;
 }
 if (c2.isSelected()) {
 ans+=c2.getText()+"(50rs) , ";
 tot+=50;
 }
 if (c4.isSelected()) {
 ans+=c4.getText()+"(200rs) , ";
 tot+=200;
 }
 if (c5.isSelected()) {
 ans+=c5.getText()+"(10rs) , ";
 tot+=10;
 }
 if (c6.isSelected()) {
 ans+=c6.getText()+"(70rs) , "; tot+=70;
 }
 if (c7.isSelected()) {
 ans+=c7.getText()+"(40rs) , ";
 tot+=40;
 }
 if (c8.isSelected()) {
 ans+=c8.getText()+"(60rs) , ";
 tot+=60;
 }
 if (c9.isSelected()) {
 ans += c9.getText() + "(50rs) , ";
 tot+=50;
 }
 ans+="Total Amount : "+tot;
 l4=new JLabel(ans);
 add(l4);
 setVisible(true);
 }
}
public class shop_cart {
 public static void main(String[] args) {
 new shop();
 }
}
