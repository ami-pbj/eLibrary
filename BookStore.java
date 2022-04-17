package eBookShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class BookStore {

	JFrame HomeStore;
	private JTextField bsn;
	private JTextField bname;
	private JTextField bauthor;
	private JTextField bpublisher;
	private JTextField bedition;
	private JTextField bprice;
	private JTextField bstock;
	private JTextField authorn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStore window = new BookStore();
					window.HomeStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookStore() {
		initialize();
		ConnectionToDB();
		table_load();
	}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JTable table;
	private JTextField bookn;
	private JTextField bid;
	
	//Create Connection To The Book Data Database
	public void ConnectionToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/eBookShop","root","PBJ/jdbc!21");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//to display book details in the JTable ==>> e Book Data
	public void table_load() {
		try {
			pstmt = con.prepareStatement("select * from BookData");
			rs = pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomeStore = new JFrame();
		HomeStore.getContentPane().setForeground(new Color(135, 206, 250));
		HomeStore.getContentPane().setBackground(new Color(135, 206, 250));
		HomeStore.setBounds(100, 100, 1000, 381);
		HomeStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomeStore.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 988, 40);
		panel.setForeground(new Color(46, 139, 87));
		panel.setBackground(new Color(46, 139, 87));
		HomeStore.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("e \nLibrary");
		lblNewLabel.setBounds(439, 5, 109, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.YELLOW);
		panel.add(lblNewLabel);
		
		JButton exit = new JButton("x");
		exit.setBounds(955, 5, 27, 29);
		panel.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//work on EXIT buttoN
				
				JOptionPane.showMessageDialog(null, "THANKS FOR VISITING E-LIBRARY!");
				System.exit(0);
			}
		});
		exit.setForeground(new Color(0, 0, 0));
		exit.setFont(new Font("Thonburi", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(6, 51, 315, 205);
		panel_1.setLayout(null);
		HomeStore.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Book Serial Number\n");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1.setBounds(6, 6, 127, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Name");
		lblNewLabel_1_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(6, 34, 127, 16);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Author Name");
		lblNewLabel_1_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_2.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(6, 62, 127, 16);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Publisher");
		lblNewLabel_1_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_3.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(6, 90, 127, 16);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Edition");
		lblNewLabel_1_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_4.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(6, 118, 127, 16);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Price");
		lblNewLabel_1_5.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_5.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(6, 146, 127, 16);
		panel_1.add(lblNewLabel_1_5);
		
		bsn = new JTextField();
		bsn.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bsn.setColumns(10);
		bsn.setBounds(145, 1, 165, 26);
		panel_1.add(bsn);
		
		bname = new JTextField();
		bname.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bname.setColumns(10);
		bname.setBounds(145, 29, 165, 26);
		panel_1.add(bname);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Stock");
		lblNewLabel_1_5_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_5_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_1_5_1.setBounds(6, 174, 127, 16);
		panel_1.add(lblNewLabel_1_5_1);
		
		bauthor = new JTextField();
		bauthor.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bauthor.setColumns(10);
		bauthor.setBounds(145, 57, 165, 26);
		panel_1.add(bauthor);
		
		bpublisher = new JTextField();
		bpublisher.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bpublisher.setColumns(10);
		bpublisher.setBounds(145, 85, 165, 26);
		panel_1.add(bpublisher);
		
		bedition = new JTextField();
		bedition.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bedition.setColumns(10);
		bedition.setBounds(145, 113, 165, 26);
		panel_1.add(bedition);
		
		bprice = new JTextField();
		bprice.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bprice.setColumns(10);
		bprice.setBounds(145, 141, 165, 26);
		panel_1.add(bprice);
		
		bstock = new JTextField();
		bstock.setFont(new Font("Tiro Bangla", Font.BOLD, 11));
		bstock.setColumns(10);
		bstock.setBounds(145, 169, 165, 26);
		panel_1.add(bstock);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "e Book Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 250, 154)));
		panel_2.setBounds(327, 51, 667, 205);
		HomeStore.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setForeground(new Color(47, 79, 79));
		panel_3.setBounds(6, 263, 988, 82);
		panel_3.setLayout(null);
		
		JButton add = new JButton("ADD");
		add.setForeground(new Color(0, 0, 0));
		add.setBounds(96, 3, 96, 29);
		panel_3.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on ADD button
				//connect with Database Table - Book Data under e Book Shop Database
				
				String bookserialnumber, bookname, authorname, publisher, edition, price, stock;
				
				
				//assigned variables
				// 
				
				
				bookserialnumber = bsn.getText();
				bookname = bname.getText();
				authorname = bauthor.getText();
				publisher = bpublisher.getText();
				edition = bedition.getText();
				price = bprice.getText();
				stock = bstock.getText();
				
				
				//connect with Database Table - Book Data under e Book Shop Database

			
					try {
						pstmt = con.prepareStatement("insert into BookData(BookSN, BookName, AuthorName, Publisher, Edition, Price, Stock)"
								+ " values(?, ?, ?, ?, ?, ?, ?)");
						
						pstmt.setString(1, bookserialnumber);
						pstmt.setString(2, bookname);
						pstmt.setString(3, authorname);
						pstmt.setString(4, publisher);
						pstmt.setString(5, edition);
						pstmt.setString(6, price);
						pstmt.setString(7, stock);
						
						pstmt.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Book Data Added Successfully!");
						
						//to display the recently added book
						table_load();
						
						bsn.setText("");
						bname.setText("");
						bauthor.setText("");
						bpublisher.setText("");
						bedition.setText("");
						bprice.setText("");
						bstock.setText("");
						
						//to clear display after a book data added
						//and focus on top of the row as Book Serial Number
						bsn.requestFocus();
					
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		
		add.setFont(new Font("Thonburi", Font.BOLD, 13));
		HomeStore.getContentPane().add(panel_3);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on UPDATE button 
				
				String bookserialnumber, bookname, authorname, publisher, edition, price, stock, bookid;
				
				//assigned variables
				
				bookserialnumber = bsn.getText();
				bookname = bname.getText();
				authorname = bauthor.getText();
				publisher = bpublisher.getText();
				edition = bedition.getText();
				price = bprice.getText();
				stock = bstock.getText();
				bookid = bid.getText();
				
				//int id = Integer.parseInt(bid.getText());
				
				
				try {
					pstmt = con.prepareStatement("update BookData set BookSN = ?, BookName = ?, AuthorName = ?, Publisher = ?, Edition = ?,"
							+ " Price = ?, Stock = ? where ID = ?");
					
					
					pstmt.setString(1, bookserialnumber);
					pstmt.setString(2, bookname);
					pstmt.setString(3, authorname);
					pstmt.setString(4, publisher);
					pstmt.setString(5, edition);
					pstmt.setString(6, price);
					pstmt.setString(7, stock);
					pstmt.setString(8, bookid);
					
					pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Book Data Updated Successfully!");
					
					//to display the recently added book
					table_load();
					
					bsn.setText("");
					bname.setText("");
					bauthor.setText("");
					bpublisher.setText("");
					bedition.setText("");
					bprice.setText("");
					bstock.setText("");
					authorn.setText("");
					bname.requestFocus();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		update.setForeground(new Color(0, 0, 0));
		update.setBounds(96, 48, 94, 29);
		panel_3.add(update);
		update.setFont(new Font("Thonburi", Font.BOLD, 13));
		
		JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on SEARCH button
				//to search for a particular book
				//String id = bid.getText();
				
				/*
				//SEARCH BY BOOK DATA ID
				int id = Integer.parseInt(bid.getText());
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				*/
				
				
				//SEARCH BY BOOK NAME AND AUTHOR NAME
		
				try {
					
									
					pstmt = con.prepareStatement("select BookSN, BookName, AuthorName, Publisher, Edition, Price, Stock from BookData"
							+ " where BookName = ? and AuthorName = ?");
					String bookname = bookn.getText();
					String authorname = authorn.getText();

					bookname = bookn.getText();
					authorname = authorn.getText();

					
					pstmt.setString(1, bookname);
					pstmt.setString(2, authorname);
					rs = pstmt.executeQuery();
					
					
					//to display
					//what will be display after search
					if(rs.next()==true) {
						String BookSN = rs.getString(1);
						String BookName = rs.getString(2);
						String AuthorName = rs.getString(3);
						String Publisher = rs.getString(4);
						String Edition = rs.getString(5);
						String Price = rs.getString(6);
						String Stock = rs.getString(7);
						
						//assigned variables
						bsn.setText(BookSN);
						bname.setText(BookName);
						bauthor.setText(AuthorName);
						bpublisher.setText(Publisher);
						bedition.setText(Edition);
						bprice.setText(Price);
						bstock.setText(Stock);
						
						
						//to search new and focus on bid
						//bookn.requestFocus();

						
					} else {
						JOptionPane.showMessageDialog(null, "Book Data Not Found!");
						bsn.setText("");
						bname.setText("");
						bauthor.setText("");
						bpublisher.setText("");
						bedition.setText("");
						bprice.setText("");
						bstock.setText("");
						
						
						//to search new and focus on bid
						//bookn.requestFocus();
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		search.setForeground(new Color(0, 0, 0));
		search.setBounds(687, 25, 96, 29);
		panel_3.add(search);
		search.setFont(new Font("Thonburi", Font.BOLD, 13));
		
		authorn = new JTextField();
		authorn.setBounds(496, 48, 179, 26);
		panel_3.add(authorn);
		authorn.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		authorn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Author Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(397, 57, 83, 16);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on DELETE button
				
				
				String bookid;
				
				//assigned variables
				
				bookid = bid.getText();
				
				//int id = Integer.parseInt(bid.getText());
				
				
				try {
					pstmt = con.prepareStatement("delete from BookData where ID = ?");
					
					
					pstmt.setString(1, bookid);
					
					pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Book Data Deleted Successfully!");
					
					//to display the recently added book
					table_load();
					
					bid.setText("");
					bname.setText("");
					bauthor.setText("");
					bpublisher.setText("");
					bedition.setText("");
					bprice.setText("");
					bstock.setText("");
					authorn.setText("");
					//bookn.setText("");

					authorn.requestFocus();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		delete.setForeground(Color.BLACK);
		delete.setFont(new Font("Thonburi", Font.BOLD, 13));
		delete.setBounds(795, 3, 96, 29);
		panel_3.add(delete);
		
		bookn = new JTextField();
		bookn.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		bookn.setColumns(10);
		bookn.setBounds(496, 7, 179, 26);
		panel_3.add(bookn);
		
		JLabel lblNewLabel_2_1 = new JLabel("Book Name");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(397, 12, 83, 16);
		panel_3.add(lblNewLabel_2_1);
		
		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on CLEAR button
				
				bsn.setText("");
				bname.setText("");
				bauthor.setText("");
				bpublisher.setText("");
				bedition.setText("");
				bprice.setText("");
				bstock.setText("");
				authorn.setText("");
				bookn.setText("");
				bsn.requestFocus();
				
			}
		});
		clear.setForeground(Color.BLACK);
		clear.setFont(new Font("Thonburi", Font.BOLD, 13));
		clear.setBounds(795, 48, 96, 29);
		panel_3.add(clear);
		
		JButton purchase = new JButton("PURCHASE");
		purchase.setBounds(242, 3, 96, 29);
		panel_3.add(purchase);
		purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//BUY page ==>> To Purchase Book
				PurchaseBook obj = new PurchaseBook();
				obj.purchaseframe.setVisible(true);
				
			}

		});
		purchase.setForeground(Color.BLACK);
		purchase.setFont(new Font("Thonburi", Font.BOLD, 13));
		
		bid = new JTextField();
		bid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//Book ID code ==>> to Update Book Data
				
				try {
					
					String bookid = bid.getText();
					
					pstmt = con.prepareStatement("select BookSN, BookName, AuthorName, Publisher, Edition, Price, Stock from BookData where ID = ?");
					pstmt.setString(1, bookid);
					rs = pstmt.executeQuery();
					
					if(rs.next()==true) {
						String BookSN = rs.getString(1);
						String BookName = rs.getString(2);
						String AuthorName = rs.getString(3);
						String Publisher = rs.getString(4);
						String Edition = rs.getString(5);
						String Price = rs.getString(6);
						String Stock = rs.getString(7);
						
						//assigned variables
						bsn.setText(BookSN);
						bname.setText(BookName);
						bauthor.setText(AuthorName);
						bpublisher.setText(Publisher);
						bedition.setText(Edition);
						bprice.setText(Price);
						bstock.setText(Stock);
						
						
						//to search new and focus on bid
						bid.requestFocus();
					} else {
						//JOptionPane.showMessageDialog(null, "Book Data Not Found!");
						bsn.setText("");
						bname.setText("");
						bauthor.setText("");
						bpublisher.setText("");
						bedition.setText("");
						bprice.setText("");
						bstock.setText("");
						
						
						//to search new and focus on bid
						bid.requestFocus();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		bid.setFont(new Font("Tiro Bangla", Font.BOLD, 12));
		bid.setColumns(10);
		bid.setBounds(206, 49, 179, 26);
		panel_3.add(bid);
	}
}
