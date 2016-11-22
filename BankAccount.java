
public class BankAccount implements BankInterface {

	private String firstName, lastName;
	private String phoneNumber, SSN;

	private Date birthDate;

	private double accountBalance = 0.0;

	public BankAccount(String firstName, String lastName, String phoneNumber, String SSN, Date birthDate) {

		this(firstName, lastName, phoneNumber, SSN, birthDate, 0.0);

	}

	public BankAccount(String firstName, String lastName, String phoneNumber, String SSN, Date birthDate,
			double accountBalance) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.SSN = SSN;
		this.birthDate = birthDate;
		this.accountBalance = accountBalance;

	}

	public String generalInfo() {

		return String.format("%s %s\nAccount Balance: $%.2f", this.getFirstName(), this.getLastName(),
				this.checkBalance());
	}

	public String fullInfo() {

		return String.format("%s %s\t%s\nAccount Balance: $%.2f\nSSN: %s\nCell: %s\n", this.getFirstName(),
				this.getLastName(), this.getBirthDate(), this.checkBalance(), this.getSSN(), this.getPhoneNumber());
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;

	}

	public String getFirstName() {

		return firstName;

	}

	public void setLastName(String lastName) {

		this.lastName = lastName;

	}

	public String getLastName() {

		return lastName;
	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;

	}

	public String getPhoneNumber() {

		return phoneNumber;

	}

	public String getSSN() {

		return SSN;

	}

	public void setBirthDate(Date birthDate) {

		this.birthDate = birthDate;

	}

	public String getBirthDate() {

		return birthDate.monthNameDayYear();

	}

	@Override
	public boolean deposit(double amount) {

		boolean isSuccess = false;

		if (amount > 0.0) {
			accountBalance += amount;
			isSuccess = true;
		}

		return isSuccess;
	}

	@Override
	public boolean withdraw(double amount) {

		boolean isSuccess = false;

		if (amount > 0) {
			accountBalance = accountBalance - amount;
			isSuccess = true;
		}

		return isSuccess;
	}

	@Override
	public double checkBalance() {

		return accountBalance;
	}

	@Override
	public boolean transferMoney(String accountName, double amount) {

		this.withdraw(amount);

		return false;
	}

	public double savings(double salaryPerMonth, double yearGoal) {

		double amountToSave;

		amountToSave = yearGoal / 12;

		return amountToSave;

	}

}
