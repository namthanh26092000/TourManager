package UI;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import connectDB.ConnectDB;

import entity.TaiKhoan;
import entity.NhanVien;

import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
public class UI_TaiKhoan extends JFrame  {
	private JPanel pAccount;
	private JTable table;
	private DAO_TaiKhoan dao_tk = new DAO_TaiKhoan();
	public UI_TaiKhoan() throws SQLException {
//	try {
//		ConnectDB.getInstance().connect();
//	} catch (SQLException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//setBounds(100, 100, 1133, 678);
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	setBounds(0, 0, width, height);
	pAccount = new JPanel();
	pAccount.setBackground(SystemColor.control);
	pAccount.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(pAccount);
	pAccount.setLayout(null);
	
	DAO_NhanVien dao_nv = new DAO_NhanVien();
	List<String> list_MaNV = dao_nv.getListMaNV();
	DAO_TaiKhoan dao_tk = new DAO_TaiKhoan();
//	List<TaiKhoan> list_tk = dao_tk.docTuBang();
	
	JPanel pAccountInfo = new JPanel();
	pAccountInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	pAccountInfo.setBackground(SystemColor.control);
	pAccountInfo.setBounds(5, 106, 910, 165);
	pAccount.add(pAccountInfo);
	pAccountInfo.setLayout(null);
	
	JPanel pAccountInfoDetails = new JPanel();
	pAccountInfoDetails.setBackground(SystemColor.control);
	pAccountInfoDetails.setBounds(10, 26, 890, 123);
	pAccountInfo.add(pAccountInfoDetails);
	pAccountInfoDetails.setLayout(null);
		
	JLabel lblEmployeeName_Acc = new JLabel("M?? Nh??n Vi??n");
	lblEmployeeName_Acc.setBounds(5, 10, 120, 21);
	pAccountInfoDetails.add(lblEmployeeName_Acc);
	lblEmployeeName_Acc.setHorizontalAlignment(SwingConstants.LEFT);
	lblEmployeeName_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
	
	JTextField txtEmployeeNum_Acc = new JTextField();
	txtEmployeeNum_Acc.setFont(new Font("Tahoma", Font.PLAIN, 14));
	txtEmployeeNum_Acc.setBounds(148, 10, 220, 23);
	pAccountInfoDetails.add(txtEmployeeNum_Acc);
	
	JLabel lblNewLabel = new JLabel("T??n Nh??n Vi??n");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel.setBounds(396, 10, 120, 20);
	pAccountInfoDetails.add(lblNewLabel);
	
	JTextField txtEmployeeName_Acc = new JTextField();
	txtEmployeeName_Acc.setFont(new Font("Tahoma", Font.PLAIN, 14));
	txtEmployeeName_Acc.setEditable(false);
	txtEmployeeName_Acc.setBounds(535, 10, 345, 25);
	pAccountInfoDetails.add(txtEmployeeName_Acc);
	
	JLabel lblPassword_Acc = new JLabel("M???t Kh???u");
	lblPassword_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPassword_Acc.setBounds(5, 50, 103, 21);
	pAccountInfoDetails.add(lblPassword_Acc);
	
	JTextField txtPassword_Acc = new JTextField();
	txtPassword_Acc.setBounds(148, 48, 220, 25);
	txtPassword_Acc.setFont(new Font("Tahoma", Font.PLAIN, 14));
	pAccountInfoDetails.add(txtPassword_Acc);
	
	JLabel lblPower_Acc = new JLabel("Quy???n");
	lblPower_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPower_Acc.setBounds(5, 90, 115, 21);
	pAccountInfoDetails.add(lblPower_Acc);
	
	JComboBox cbbQuyen = new JComboBox();
	cbbQuyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cbbQuyen.setBackground(Color.WHITE);
	cbbQuyen.setModel(new DefaultComboBoxModel(new String[] {"Qu???n L??", "Nh??n Vi??n"}));
	cbbQuyen.setBounds(148, 88, 220, 25);
	pAccountInfoDetails.add(cbbQuyen);
	
	JLabel lblNote_Acc = new JLabel("Ch?? Th??ch");
	lblNote_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNote_Acc.setBounds(396, 50, 107, 21);
	pAccountInfoDetails.add(lblNote_Acc);
	
	JTextArea txtChuThich = new JTextArea();
	txtChuThich.setFont(new Font("Tahoma", Font.PLAIN, 14));
	txtChuThich.setBounds(535, 48, 345, 55);
	pAccountInfoDetails.add(txtChuThich);
	
	JPanel pAccountList = new JPanel();
	pAccountList.setBounds(5, 281, 1525, 473);
	pAccount.add(pAccountList);
	pAccountList.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(0, 0, 1525, 473);
	pAccountList.add(scrollPane);
	
	String[] header = { "T??i kho???n",  "M???t Kh???u"};
	DefaultTableModel tableModel = new DefaultTableModel(header, 0);
	table = new JTable(tableModel);
	//table.setColumnSelectionAllowed(true);
	table.setForeground(Color.BLACK);
	table.setFont(new Font("Tahoma", Font.PLAIN, 13));
	scrollPane.setViewportView(table);
	//table.setModel(dao_tk.getAllAccount(header, tableModel));
	table.setRowHeight(25);
	table.setAutoCreateRowSorter(true);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	table.getTableHeader().setBackground(new Color(50,205,50));
	table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
	//table.getTableHeader().setForeground(Color.green);
	//table.setShowHorizontalLines(false);
	//table.setShowVerticalLines(false);
	//table.setShowGrid(false);
	
	JPanel pSearchAccount = new JPanel();
	pSearchAccount.setBorder(new TitledBorder(null, "T??m ki???m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	pSearchAccount.setBackground(SystemColor.control);
	pSearchAccount.setBounds(925, 106, 367, 165);
	pAccount.add(pSearchAccount);
	pSearchAccount.setLayout(null);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(SystemColor.control);
	panel_1.setBounds(10, 26, 347, 121);
	pSearchAccount.add(panel_1);
	panel_1.setLayout(null);
	
	ButtonGroup group = new ButtonGroup();
	
	JRadioButton radEmployeeNumSearch = new JRadioButton("M?? Nh??n Vi??n");
	radEmployeeNumSearch.setBounds(16, 6, 123, 25);
	group.add(radEmployeeNumSearch);
	panel_1.add(radEmployeeNumSearch);
	radEmployeeNumSearch.setSelected(true);
	radEmployeeNumSearch.setBackground(SystemColor.control);
	radEmployeeNumSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
	JRadioButton radEmpployeeNameSearch = new JRadioButton("T??n Nh??n Vi??n");
	radEmpployeeNameSearch.setBounds(183, 8, 148, 25);
	group.add(radEmpployeeNameSearch);
	panel_1.add(radEmpployeeNameSearch);
	radEmpployeeNameSearch.setBackground(SystemColor.control);
	radEmpployeeNameSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
	JLabel lblSearch_Acc = new JLabel("Nh???p n???i dung t??m ki???m");
	lblSearch_Acc.setBounds(88, 37, 175, 21);
	panel_1.add(lblSearch_Acc);
	lblSearch_Acc.setForeground(new Color(0, 128, 128));
	lblSearch_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
	JTextField txtSearch_Acc = new JTextField();
	txtSearch_Acc.setBounds(16, 75, 321, 25);
	panel_1.add(txtSearch_Acc);
	
	JPanel pAccountFunction = new JPanel();
	pAccountFunction.setBorder(new TitledBorder(null, "Ch???c n??ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	pAccountFunction.setBackground(SystemColor.control);
	pAccountFunction.setBounds(1302, 106, 228, 165);
	pAccount.add(pAccountFunction);
	pAccountFunction.setLayout(null);
	
	JButton btnAdd_Acc = new JButton("C???p T??i Kho???n");
	btnAdd_Acc.setBackground(new Color(60, 179, 113));
	btnAdd_Acc.setBounds(19, 23, 193, 40);
	pAccountFunction.add(btnAdd_Acc);
	btnAdd_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
//	btnAdd_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/add-user-icon.png")));
	
	JButton btnDelete_Acc = new JButton("X??a T??i Kho???n");
	btnDelete_Acc.setBackground(new Color(255, 0, 0));
	btnDelete_Acc.setBounds(19, 68, 193, 40);
	pAccountFunction.add(btnDelete_Acc);
	btnDelete_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
//	btnDelete_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/remove-user-icon.png")));
	
	JButton btnResetPassword_Acc = new JButton("?????t L???i M???t Kh???u");
	btnResetPassword_Acc.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();				
			if(row < 0)
				JOptionPane.showMessageDialog(null, "Vui l??ng ch???n t??i kho???n!");
			else {
				String maNhanVien = table.getValueAt(row, 1).toString();
				if(dao_tk.Update(maNhanVien)) {
					txtPassword_Acc.setText("12346");
					table.setValueAt("123456", row, 3);
					JOptionPane.showMessageDialog(null, "?????t l???i m???t kh???u th??nh c??ng");
				}
				else {
					JOptionPane.showMessageDialog(null, "?????t l???i m???t kh???u kh??ng th??nh c??ng!");
				}
			}
		}
	});
	btnResetPassword_Acc.setBackground(new Color(30, 144, 255));
	btnResetPassword_Acc.setBounds(19, 113, 193, 40);
	pAccountFunction.add(btnResetPassword_Acc);
	btnResetPassword_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
//	btnResetPassword_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/Reset-icon.png")));
	
	JLabel lblNewLabel_1 = new JLabel("Qu???n l?? t??i kho???n");
	lblNewLabel_1.setForeground(new Color(184, 134, 11));
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
	lblNewLabel_1.setBounds(5, 10, 439, 72);
	pAccount.add(lblNewLabel_1);
	
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int viTriDongVuaBam = table.getSelectedRow();
			txtEmployeeNum_Acc.setText(table.getValueAt(viTriDongVuaBam, 1).toString());
			txtEmployeeName_Acc.setText(table.getValueAt(viTriDongVuaBam, 2).toString());
			txtPassword_Acc.setText(table.getValueAt(viTriDongVuaBam, 3).toString());
			txtChuThich.setText(table.getValueAt(viTriDongVuaBam, 5).toString());
			String item = table.getValueAt(viTriDongVuaBam, 4).toString();
			int i;
			if (item.equalsIgnoreCase("Qu???n L??"))
				i = 0;
			else 
				i = 1;
			cbbQuyen.setSelectedIndex(i);
		}
	});
	
	txtEmployeeNum_Acc.addKeyListener(new KeyAdapter() {
		public boolean isNumeric(String str) {
			  return str.matches("^[N][V]_\\d+");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
			}
		@Override
		public void keyReleased(KeyEvent e) {
			//char temp =  Character.toUpperCase(e.getKeyChar());
			//String employeeNum = txtEmployeeNum_Acc.getText() + temp;
			//txtEmployeeNum_Acc.setText(employeeNum);
			//txtEmployeeNum_Acc.setText(txtEmployeeNum_Acc.getText().toUpperCase());
			if (isNumeric(txtEmployeeNum_Acc.getText())) {
				txtEmployeeNum_Acc.setForeground(Color.black);
				Connection con = ConnectDB.getConnection();
				String sql = "select * from NhanVien where maNV = ?";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, txtEmployeeNum_Acc.getText());
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						txtEmployeeName_Acc.setText(rs.getString("tenNV"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
			else {
				txtEmployeeNum_Acc.setForeground(Color.red);
			}				
		}
	});
	
	// Th??m T??i Kho???n
	
	btnAdd_Acc.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(txtEmployeeName_Acc.getText().equalsIgnoreCase(""))
				JOptionPane.showMessageDialog(null, "Nh??n vi??n kh??ng t???n t???i");
			else {
				String maNV = txtEmployeeNum_Acc.getText();
				String matKhau = txtPassword_Acc.getText();
				if (matKhau.equalsIgnoreCase(""))
					matKhau = "123456";
			//	String quyen = cbbQuyen.getSelectedItem().toString();
			//	String chuThich = txtChuThich.getText();	
			//	String tenNhanVien = txtEmployeeName_Acc.getText();
				TaiKhoan taiKhoan = new TaiKhoan(null, matKhau);
				int stt = dao_tk.docTuBang().size();
				try {
					if(dao_tk.create(taiKhoan)) {
						tableModel.addRow(new Object[] {stt+"",taiKhoan.getMaNV(), taiKhoan.getMatKhau()});
					}
					else {
						JOptionPane.showMessageDialog(null, "Nh??n vi??n n??y ???? c?? t??i kho???n");
					}
				} catch(Exception e1) {
					//JOptionPane.showMessageDialog(this, "Trung");
					System.out.println("Wrong!");
				}
			}
		}
	});
	
	
	//X??a t??i kho???n
	btnDelete_Acc.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();	
			if (row < 0)
				JOptionPane.showMessageDialog(null, "Vui l??ng ch???n T??i Kho???n c???n x??a!");
			else {
				int luaChon = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a t??i kho???n n??y?", "Ch?? ??", JOptionPane.YES_NO_OPTION);
				if(luaChon==JOptionPane.YES_OPTION) {
					String maNhanVien = table.getValueAt(row, 1).toString();
					if(maNhanVien.equalsIgnoreCase(DangNhap.txtuser.getText()))
						JOptionPane.showMessageDialog(null, "T??i kho???n n??y ??ang th???c thi kh??ng th??? x??a!");
					else {
						if(dao_tk.delete(maNhanVien)) {
							tableModel.removeRow(row);
							JOptionPane.showMessageDialog(null, "X??a th??nh c??ng!");
						}
						else {
							System.out.println("Wrong!");
						}
					}
					
				}
				
			}
		}
	});
	
	//T??m ki???m
	
//	txtSearch_Acc.addKeyListener(new KeyAdapter() {
//		@Override
//		public void keyReleased(KeyEvent e) {
//			if(txtSearch_Acc.getText().equalsIgnoreCase(""))
//				try {
//					tableModel.getDataVector().removeAllElements();
//					tableModel.fireTableDataChanged();
//					table.setModel(dao_tk.getAllAccount(header, tableModel));
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			else if (radEmployeeNumSearch.isSelected()) {
//				tableModel.getDataVector().removeAllElements();
//				tableModel.fireTableDataChanged();
//				try {
//					table.setModel(dao_tk.getAccountById(header, tableModel, txtSearch_Acc.getText()));
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//			else {
//				tableModel.getDataVector().removeAllElements();
//				tableModel.fireTableDataChanged();
//				try {
//					table.setModel(dao_tk.getAccountByName(header, tableModel, txtSearch_Acc.getText()));
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		}
//	});

}


public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				UI_TaiKhoan frame = new UI_TaiKhoan();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

}
