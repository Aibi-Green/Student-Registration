package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfMiddleName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfEmail;
	private JTextField tfContactNumber;
	private JTable table;
	private JTextField tfSearch;
	
	private Font titleStyle = new Font("The Brittany Sans", Font.BOLD, 20);
	private Font headingStyle = new Font("Tahoma", Font.BOLD, 14);
	private Font plainStyle = new Font("Tahoma", Font.PLAIN, 12);
	
	JDBCPostgreSQLConnect sqlConnect = new JDBCPostgreSQLConnect();
	private JTextField tfStudentID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					
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
	public mainFrame() {
		setTitle("Student Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Student Registration");
		title.setFont(titleStyle);
		title.setBounds(52, 21, 273, 21);
		contentPane.add(title);
		
		JPanel registrationPanel = new JPanel();
		registrationPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		title.setLabelFor(registrationPanel);
		registrationPanel.setBounds(10, 53, 359, 515);
		contentPane.add(registrationPanel);
		registrationPanel.setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(10, 62, 86, 14);
		registrationPanel.add(lblFullName);
		lblFullName.setFont(headingStyle);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.setBounds(10, 87, 339, 86);
		registrationPanel.add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(plainStyle);
		lblFirstName.setBounds(10, 11, 86, 14);
		inputPanel.add(lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(106, 8, 223, 20);
		inputPanel.add(tfFirstName);
		tfFirstName.setColumns(10);
		lblFirstName.setLabelFor(tfFirstName);
		tfFirstName.setText("");
		
		tfMiddleName = new JTextField();
		tfMiddleName.setBounds(106, 33, 223, 20);
		inputPanel.add(tfMiddleName);
		tfMiddleName.setColumns(10);
		tfMiddleName.setText("");
		
		JLabel lblMiddleName = new JLabel("Middle name");
		lblMiddleName.setFont(plainStyle);
		lblMiddleName.setBounds(10, 36, 86, 14);
		inputPanel.add(lblMiddleName);
		lblMiddleName.setLabelFor(lblMiddleName);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(106, 58, 223, 20);
		inputPanel.add(tfLastName);
		tfLastName.setColumns(10);
		tfLastName.setText("");
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(plainStyle);
		lblLastName.setBounds(10, 61, 86, 14);
		inputPanel.add(lblLastName);
		lblLastName.setLabelFor(tfLastName);
		lblFullName.setLabelFor(inputPanel);
		
		JLabel lblPersonalDetails = new JLabel("Personal Details");
		lblPersonalDetails.setBounds(10, 184, 110, 14);
		registrationPanel.add(lblPersonalDetails);
		lblPersonalDetails.setFont(headingStyle);
		
		JPanel personalPanel = new JPanel();
		personalPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		personalPanel.setBounds(10, 209, 339, 141);
		registrationPanel.add(personalPanel);
		personalPanel.setLayout(null);
		
		JLabel lblBirthday = new JLabel("Date of birth");
		lblBirthday.setBounds(10, 11, 86, 14);
		personalPanel.add(lblBirthday);
		lblBirthday.setFont(plainStyle);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 115, 86, 14);
		personalPanel.add(lblGender);
		lblGender.setFont(plainStyle);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(plainStyle);
		rdbtnMale.setBounds(93, 111, 62, 23);
		personalPanel.add(rdbtnMale);
		buttonGroup.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(plainStyle);
		rdbtnFemale.setBounds(157, 111, 73, 23);
		personalPanel.add(rdbtnFemale);
		buttonGroup.add(rdbtnFemale);
		
		lblPersonalDetails.setLabelFor(personalPanel);
		
		JPanel DOApanel = new JPanel();
		lblBirthday.setLabelFor(DOApanel);
		DOApanel.setBounds(10, 36, 319, 68);
		personalPanel.add(DOApanel);
		DOApanel.setLayout(null);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(112, 11, 56, 14);
		DOApanel.add(lblMonth);
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDate = new JLabel("Day");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(246, 11, 56, 14);
		DOApanel.add(lblDate);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYear.setBounds(10, 11, 56, 14);
		DOApanel.add(lblYear);
		
		JComboBox<String> cbMonth = new JComboBox<String>();
		lblMonth.setLabelFor(cbMonth);
		cbMonth.setBounds(112, 35, 100, 22);
		dateOfBirth.setMonths(cbMonth);
		DOApanel.add(cbMonth);
		
		JComboBox<String> cbDay = new JComboBox<String>();
		lblDate.setLabelFor(cbDay);
		cbDay.setBounds(246, 35, 63, 22);
		cbDay.addItem("---");
		DOApanel.add(cbDay);
		
		JComboBox<String> cbYear = new JComboBox<String>();
		lblYear.setLabelFor(cbYear);
		cbYear.setBounds(10, 35, 70, 22);
		dateOfBirth.setYears(cbYear);
		DOApanel.add(cbYear);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setBounds(10, 361, 110, 14);
		registrationPanel.add(lblContactDetails);
		lblContactDetails.setFont(headingStyle);
		
		JPanel contactPanel = new JPanel();
		contactPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contactPanel.setBounds(10, 386, 339, 71);
		registrationPanel.add(contactPanel);
		contactPanel.setLayout(null);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(117, 12, 212, 20);
		contactPanel.add(tfEmail);
		tfEmail.setColumns(10);
		tfEmail.setText("");
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(plainStyle);
		lblEmail.setBounds(10, 14, 86, 14);
		contactPanel.add(lblEmail);
		lblEmail.setLabelFor(tfEmail);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(plainStyle);
		lblContactNumber.setBounds(10, 45, 97, 14);
		contactPanel.add(lblContactNumber);
		
		tfContactNumber = new JTextField();
		lblContactNumber.setLabelFor(tfContactNumber);
		tfContactNumber.setColumns(10);
		tfContactNumber.setBounds(117, 43, 212, 20);
		contactPanel.add(tfContactNumber);
		lblContactDetails.setLabelFor(contactPanel);
		tfContactNumber.setText("");
		
		JButton btnAddStudent = new JButton("Add");
		btnAddStudent.setBounds(68, 469, 89, 23);
		registrationPanel.add(btnAddStudent);
		
		JButton btnEditStudent = new JButton("Edit");
		btnEditStudent.setBounds(201, 469, 89, 23);
		registrationPanel.add(btnEditStudent);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 339, 40);
		registrationPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(10, 11, 86, 14);
		panel.add(lblStudentId);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tfStudentID = new JTextField();
		tfStudentID.setBounds(106, 10, 128, 20);
		panel.add(tfStudentID);
		tfStudentID.setColumns(10);
		lblStudentId.setLabelFor(tfStudentID);
		
		JButton btnDeleteStudent = new JButton();
		btnDeleteStudent.setBounds(244, 9, 85, 23);
		panel.add(btnDeleteStudent);
		btnDeleteStudent.setText("delete");
		btnDeleteStudent.setIcon(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 126, 822, 391);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"student_id", "first_name", "middle_name", "last_name", "date_of_birth", "gender", "email", "contact_number"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		controlPanel.setBounds(379, 53, 304, 62);
		contentPane.add(controlPanel);
		controlPanel.setLayout(null);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(10, 31, 186, 20);
		controlPanel.add(tfSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(206, 30, 89, 23);
		controlPanel.add(btnSearch);
		
		JLabel lblSearchStudentId = new JLabel("Student ID");
		lblSearchStudentId.setLabelFor(tfSearch);
		lblSearchStudentId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchStudentId.setBounds(10, 11, 86, 14);
		controlPanel.add(lblSearchStudentId);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.setBounds(1112, 92, 89, 23);
		contentPane.add(btnShowAll);
		table.getColumnModel().getColumn(0).setPreferredWidth(131);
		
		btnShowAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Students> getStudentRecords = sqlConnect.getStudentRecords();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				Object[] rowData = new Object[8];
				
				for(int i = 0; i < getStudentRecords.size(); i++) {
					rowData[0] = getStudentRecords.get(i).getStudent_id();
					rowData[1] = getStudentRecords.get(i).getFirstName();
					rowData[2] = getStudentRecords.get(i).getMiddleName();
					rowData[3] = getStudentRecords.get(i).getLastName();
					rowData[4] = getStudentRecords.get(i).getDateOfBirth();
					rowData[5] = getStudentRecords.get(i).getGender();
					rowData[6] = getStudentRecords.get(i).getEmail();
					rowData[7] = getStudentRecords.get(i).getContactNumber();
					
					model.addRow(rowData);
				}
				
				table.setModel(model);
				System.out.println("Displaying data from database!\n");
			}
			
		});;
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Students> getStudentRecords = sqlConnect.searchStudentRecord(tfSearch.getText());
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				Object[] rowData = new Object[8];
				
				for(int i = 0; i < getStudentRecords.size(); i++) {
					rowData[0] = getStudentRecords.get(i).getStudent_id();
					rowData[1] = getStudentRecords.get(i).getFirstName();
					rowData[2] = getStudentRecords.get(i).getMiddleName();
					rowData[3] = getStudentRecords.get(i).getLastName();
					rowData[4] = getStudentRecords.get(i).getDateOfBirth();
					rowData[5] = getStudentRecords.get(i).getGender();
					rowData[6] = getStudentRecords.get(i).getEmail();
					rowData[7] = getStudentRecords.get(i).getContactNumber();
					
					model.addRow(rowData);
				}
				
				table.setModel(model);
				
			}
			
		});;
		
		cbMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dateOfBirth.setDays(cbDay, cbMonth.getSelectedItem(), cbYear.getSelectedItem());
			}
		});
		
		cbYear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dateOfBirth.setDays(cbDay, cbMonth.getSelectedItem(), cbYear.getSelectedItem());
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				tfStudentID.setText(model.getValueAt(selectedRowIndex, 0).toString());
				tfFirstName.setText(model.getValueAt(selectedRowIndex, 1).toString());
				tfMiddleName.setText(model.getValueAt(selectedRowIndex, 2).toString());
				tfLastName.setText(model.getValueAt(selectedRowIndex, 3).toString());
				tfEmail.setText(model.getValueAt(selectedRowIndex, 6).toString());
				tfContactNumber.setText(model.getValueAt(selectedRowIndex, 7).toString());
				cbYear.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString().substring(0,4));
				cbMonth.setSelectedItem(dateOfBirth.extractMonth(model.getValueAt(selectedRowIndex, 4).toString().substring(5,7)));

				if(model.getValueAt(selectedRowIndex, 4).toString().substring(8).charAt(0) == '0')
					cbDay.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString().substring(9));
				else
					cbDay.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString().substring(8));
				
				if(model.getValueAt(selectedRowIndex, 5).toString().equals("Female"))
					rdbtnFemale.doClick();
				else
					rdbtnMale.doClick();
			}
		});
		
		btnAddStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(
						Invalids.findUnfilledTextFields(
								tfStudentID, tfFirstName,
								tfLastName, tfContactNumber) ||
						Invalids.findUncheckedRadioButtons(
								rdbtnMale,
								rdbtnFemale) ||
						Invalids.findUnselectedComboBox(
								cbYear.getSelectedItem(),
								cbMonth.getSelectedItem(), 
								cbDay.getSelectedItem())
				) {
					System.out.println("Some text fields are unfilled");
				} else {
					if(sqlConnect.checkStudentIdExists(tfStudentID.getText())) {
						JOptionPane.showMessageDialog(contentPane, "Student ID already exists in the database!");
					} else {
						sqlConnect.addStudentRecord(
								tfStudentID.getText(),
								tfFirstName.getText(),
								tfMiddleName.getText(),
								tfLastName.getText(),
								dateOfBirth.getDOA(
										cbYear.getSelectedItem(), 
										cbMonth.getSelectedItem(), 
										cbDay.getSelectedItem()
										),
								Gender.getGender(
										rdbtnMale, 
										rdbtnFemale
										),
								tfEmail.getText(),
								tfContactNumber.getText()
								);
						
						JOptionPane.showMessageDialog(contentPane, "Successfully added student to record!");
						btnShowAll.doClick();
					}
					
				}
			}
			
		});
		
		btnEditStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(
						Invalids.findUnfilledTextFields(
								tfStudentID, tfFirstName,
								tfLastName, tfContactNumber) ||
						Invalids.findUncheckedRadioButtons(
								rdbtnMale,
								rdbtnFemale) ||
						Invalids.findUnselectedComboBox(
								cbYear.getSelectedItem(),
								cbMonth.getSelectedItem(), 
								cbDay.getSelectedItem())
				) {
					System.out.println("Some text fields are unfilled");
				} else {
					sqlConnect.editStudentRecord(
							tfStudentID.getText(),
							tfFirstName.getText(),
							tfMiddleName.getText(),
							tfLastName.getText(),
							dateOfBirth.getDOA(
									cbYear.getSelectedItem(), 
									cbMonth.getSelectedItem(), 
									cbDay.getSelectedItem()
									),
							Gender.getGender(
									rdbtnMale, 
									rdbtnFemale
									),
							tfEmail.getText(),
							tfContactNumber.getText()
							);
					JOptionPane.showMessageDialog(contentPane, "Successfully edited student record("+tfStudentID.getText()+")");
					Utilities.clearTextFields(
							tfStudentID, 
							tfFirstName, 
							tfMiddleName, 
							tfLastName, 
							cbYear, cbMonth, cbDay, 
							rdbtnMale, 
							tfEmail, 
							tfContactNumber);
					btnShowAll.doClick();
				}
				
				
			}
			
		});
	}
}
