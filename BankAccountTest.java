
public class BankAccountTest {

	public static void main(String[] args) {

		BinaryTreeInterface<BankAccount> accountsTree = new BinaryTree<BankAccount>();

		Date date;

		BankAccount account1 = new BankAccount("Prince", "Kumar", "(408) 896-7409", "696-06-9907",
				date = new Date(01, 03, 1997));

		account1.deposit(100);

		account1.setLastName("K");

		account1.setBirthDate(date = new Date(01, 04, 1996));

		account1.withdraw(25);
		
		

		System.out.println(account1.fullInfo());
		
		System.out.printf("$%.2f", account1.savings(10000, 60000));

	}

}
