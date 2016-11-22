
public class Date {

	private int month;
	private int day;
	private int year;

	private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final String[] months = { "null", "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };

	Date(int month, int day, int year) {

		if (month <= 0 || month > 12)
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");

		if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

		this.day = day;
		this.month = month;
		this.year = year;

	}

	Date(String monthName, int day, int year) {

		for (int x = 1; x <= 12; x++) {
			if (monthName.equals(months[x])) {
				setMonth(x);

			}

		}
		setDay(day);
		setYear(year);
	}

	Date(int dayOfYear, int year) {
		for (int x = 1; x <= 12; x++) {

			if (x == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
				daysPerMonth[2] = 29;

			dayOfYear = dayOfYear - daysPerMonth[x];

			if (dayOfYear <= 0) {
				setMonth(x);
				day = (daysPerMonth[x] + dayOfYear);
				setYear(year);
				break;
			}
		}

	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {

		if (month <= 0 || month > 12)
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");

		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {

		if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String monthDayYear() {

		return String.format("%s/%s/%s", getMonth(), getDay(), getYear());

	}

	public String monthNameDayYear() {

		return String.format("%s %s, %s", months[getMonth()], getDay(), getYear());

	}

	public String DayOfYearYear() {

		int Day = 0;
		for (int x = 1; x < getMonth(); x++) {

			if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
				throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

			Day += daysPerMonth[x];

		}

		Day = Day + getDay();
		return String.format("Days: %s Year: %s", Day, getYear());

	}
}
