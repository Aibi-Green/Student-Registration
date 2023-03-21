package main;
import java.time.LocalDate;
import java.util.Arrays;

import javax.swing.JComboBox;

public class dateOfBirth {
	
	private static final String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
	
	public static void setMonths(JComboBox<String> comboBox) {
		comboBox.addItem("---");
		for (String i : months) {
			comboBox.addItem(i);
		}
	}
	
	public static boolean isLeapYear(Object selectedYear) {
		return (selectedYear != "---" && Integer.parseInt((String) selectedYear) % 4 == 0) ? true : false;
	}
	
	public static void setYears(JComboBox<String> comboBox) {
		int current_year = LocalDate.now().getYear();
		
		comboBox.addItem("---");
		
		for (int i = 1970; i <= current_year; i++) {
			comboBox.addItem(i+"");
		}
	}
	
	public static void setDays(JComboBox<String> comboBox, Object selectedMonth, Object selectedYear) {
		comboBox.removeAllItems();

		switch (selectedMonth.toString()) {
			case "February":
				int daysInFebruary = isLeapYear(selectedYear) ? 29 : 28;
				for (int i = 1; i <= daysInFebruary; i++) {
		            comboBox.addItem(Integer.toString(i));
		        }
		        break;
			case "January":
			case "March":
			case "May":
			case "July":
			case "August":
			case "October":
			case "December":
				for (int i = 0; i < 31; i++) {
					comboBox.addItem(Integer.toString(i+1));
				}
				break;
			case "April":
			case "June":
			case "September":
			case "November":
				for (int i = 0; i < 30; i++) {
					comboBox.addItem(""+(i+1));
				}
				break;
			default:
				comboBox.addItem("---");
		}
	}
	
	public static String extractMonth(String monthNum) {
	    int index = Integer.parseInt(monthNum)-1;
	    if (index >= 0 && index <= 11) {
	        return months[index];
	    } else {
	        return "None";
	    }
	}
	
	public static String getDOA(Object year, Object month, Object day) {
		String formatMonth = String.valueOf(Arrays.asList(months).indexOf((String)month));
		String formatDay = (String) day; 
		
		if(Integer.parseInt(formatDay) < 10)
			formatDay = String.format("%02d", Integer.parseInt(formatDay));
		
		if (Arrays.asList(months).indexOf((String)month) < 10)
			formatMonth = String.format("%02d", Integer.parseInt(formatMonth)+1);
		
		return ""+(String)year+"-"+formatMonth+"-"+formatDay;
	}
}
