package labelFormatters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 * @author Ella Love
 *
 *         Formatting class for date labels. Formats as dd-MM-yyyy
 */
@SuppressWarnings("serial")
public class DateLabelFormatter extends AbstractFormatter {

	/** The format for the date */
	private String datePattern = "dd-MM-yyyy";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	/**
	 * Puts the string into a formatted date. 
	 * 
	 * @param date string 
	 * @return the date formatted text
	 */
	@Override
	public Object stringToValue(String text) throws ParseException {
		return dateFormatter.parseObject(text);
	}

	/**
	 * Puts a date value into a string format
	 * 
	 * @param a date value
	 * @return the date value as a string
	 */
	@Override
	public String valueToString(Object value) throws ParseException {
		if (value != null) {
			Calendar cal = (Calendar) value;
			return dateFormatter.format(cal.getTime());
		}

		return "";
	}

	/**
	 * Sets the properties to format the date
	 * 
	 * @return the properties
	 */
	public static Properties setProperties() {
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		return p;
	}
}
