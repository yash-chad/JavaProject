import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Bill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduct = new JLabel("product");
		lblProduct.setBounds(12, 22, 66, 15);
		contentPane.add(lblProduct);
		
		JLabel lblQuantity = new JLabel("quantity");
		lblQuantity.setBounds(100, 22, 66, 15);
		contentPane.add(lblQuantity);
		
		JLabel lblRate = new JLabel("rate");
		lblRate.setBounds(194, 22, 66, 15);
		contentPane.add(lblRate);
		
		JLabel lblAmount = new JLabel("amount");
		lblAmount.setBounds(272, 22, 66, 15);
		contentPane.add(lblAmount);
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		list.setBounds(22, 179, 316, -129);
		contentPane.add(list);
		
		JLabel Total = new JLabel("");
		Total.setBounds(272, 204, 66, 15);
		contentPane.add(Total);
		
		JButton btnCheckBill = new JButton("Check Bill");
		btnCheckBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					int sum=0;
					Scanner s = new Scanner(new File("D:\\orders.txt"));
					Formatter fr;
					while(s.hasNext())
					{
						String product = s.next();
						int quantity = s.nextInt();
						int rate = s.nextInt();
						int amount = rate*quantity;
						sum=sum+amount;
						String r="";
						fr = new Formatter(r);
						fr.format("%s\t%d\t%d\t%d", product,quantity,rate,amount);
						//String r= s.nextLine()+String.valueOf(amount);
						model.addElement(fr);
					}
					Total.setText(String.valueOf(sum));
				}
				catch(Exception e)
				{
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "transaction Failed");
				}
			}
		});
		btnCheckBill.setBounds(100, 218, 114, 25);
		contentPane.add(btnCheckBill);
	}
}
