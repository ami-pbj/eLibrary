package eBookShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class PurchaseBook {

	JFrame purchaseframe;
	private JTextField bsn;
	private JTextField bname;
	private JTextField bprice;
	private JTextField bstock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseBook window = new PurchaseBook();
					window.purchaseframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PurchaseBook() {
		initialize();	
		ConnectionToDB();
		purchase_table();
	}
	
	
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JTable purchasetable;
	DefaultTableModel df;
	private JTextField total;
	private JTextField bauthor;
	
	
	public void ConnectionToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/eBookShop","root","PBJ/jdbc!21");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//work on JTable ==>> to load all data
	
	public void purchase_table() {
		
		
		try {
			pstmt = con.prepareStatement("select BookSN, BookName, AuthorName, Publisher, Price, Stock from BookData");
			rs = pstmt.executeQuery();
			purchasetable.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		purchaseframe = new JFrame();
		purchaseframe.getContentPane().setBackground(Color.BLACK);
		purchaseframe.setBounds(100, 100, 718, 342);
		purchaseframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		purchaseframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 706, 29);
		panel.setBackground(new Color(75, 0, 130));
		purchaseframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PURCHASE BOOK");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tiro Bangla", Font.BOLD, 15));
		lblNewLabel.setBounds(288, 6, 150, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton exit = new JButton("x");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on exit button

				JOptionPane.showMessageDialog(null, "THANKS FOR VISITING E-LIBRARY!");
				System.exit(0);
			}
		});
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Thonburi", Font.BOLD, 20));
		exit.setBounds(673, 0, 27, 29);
		panel.add(exit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 279, 706, 29);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(75, 0, 130));
		purchaseframe.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("BACK HOME");
		btnNewButton.setBounds(608, 0, 92, 29);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 40, 310, 234);
		panel_2.setBackground(new Color(102, 153, 102));
		purchaseframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Serial Number\n");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(6, 10, 127, 16);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Book Name\n");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(6, 39, 127, 16);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(6, 95, 127, 16);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		bsn = new JTextField();
		bsn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//To Search a Book to Buy ==>> work on Book Serial Number 
				
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try {
						String booksn = bsn.getText();
						pstmt = con.prepareStatement("select * from BookData where BookSN = ?");
						pstmt.setString(1, booksn);
						rs = pstmt.executeQuery();
						
						if(rs.next() == false) {
							JOptionPane.showMessageDialog(null, "Book Data Not Found!");
							
						}else {
							String bookname = rs.getString("BookName");
							bname.setText(bookname.trim());
							
							String authorname = rs.getString("AuthorName");
							bauthor.setText(authorname.trim());
							
							String bookprice = rs.getString("Price");
							bprice.setText(bookprice.trim());
							
							String bookstock = rs.getString("Stock");
							bstock.setText(bookstock.trim());
							
							//bqty.requestFocus();
							
							
						}

					} catch(SQLException e1) {
						Logger.getLogger(PurchaseBook.class.getName()).log(Level.SEVERE, null, e1);
					}
					
				}
				
			}
		});
		bsn.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bsn.setColumns(10);
		bsn.setBounds(139, 6, 165, 26);
		panel_2.add(bsn);
		
		bname = new JTextField();
		bname.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bname.setColumns(10);
		bname.setBounds(139, 35, 165, 26);
		panel_2.add(bname);
		
		bprice = new JTextField();
		bprice.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bprice.setColumns(10);
		bprice.setBounds(139, 91, 165, 26);
		panel_2.add(bprice);
		
		bstock = new JTextField();
		bstock.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bstock.setColumns(10);
		bstock.setBounds(139, 119, 165, 26);
		panel_2.add(bstock);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Stock");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(6, 123, 127, 16);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		
		JSpinner bqty = new JSpinner();
		bqty.setFont(new Font("Tiro Bangla", Font.PLAIN, 11));
		bqty.setBounds(139, 157, 71, 26);
		panel_2.add(bqty);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(6, 161, 92, 16);
		panel_2.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton bcart = new JButton("CART");
		bcart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Price = Integer.parseInt(bprice.getText());
				int Qty = Integer.parseInt(bqty.getValue().toString());
				
				int total = Price * Qty;
				
				//work on cart button
				
				try {

					if(rs.next()==false) {
					df = (DefaultTableModel)purchasetable.getModel();
					df.addRow(new Object[]{
						
							
							
							
							
							//table values
							
							bsn.getText(),
							bname.getText(),
							bauthor.getText(),
							bprice.getText(),
							bqty.getValue().toString(),
							total
							
							
						
					});
					
					JOptionPane.showMessageDialog(null, "Thank You For Purchasing!");
					}else {
						JOptionPane.showMessageDialog(null, "Out Of Stock!");

					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bcart.setForeground(Color.BLACK);
		bcart.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		bcart.setBackground(Color.WHITE);
		bcart.setBounds(222, 157, 82, 29);
		panel_2.add(bcart);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Total");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(6, 199, 92, 16);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1);
		
		total = new JTextField();
		total.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		total.setColumns(10);
		total.setBounds(139, 195, 165, 26);
		panel_2.add(total);
		
		bauthor = new JTextField();
		bauthor.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bauthor.setColumns(10);
		bauthor.setBounds(139, 63, 165, 26);
		panel_2.add(bauthor);
		
		JLabel aname = new JLabel("Author Name");
		aname.setForeground(Color.WHITE);
		aname.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		aname.setBounds(6, 67, 127, 16);
		panel_2.add(aname);
		
		purchasetable = new JTable();
		purchasetable.setBounds(321, 40, 391, 234);
		purchaseframe.getContentPane().add(purchasetable);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on BACK HOME button
				
				BookStore obj = new BookStore();
				obj.HomeStore.setVisible(true);
				
			}
		});
	}
}
