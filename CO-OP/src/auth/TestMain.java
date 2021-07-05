package auth;

import MiniStatement.MiniStatement;
import account_balance.AccountBalance;

public class TestMain {

	public static void main(String[] args) {
		System.out.println(new AccountBalance().getAccountBalance());
		System.out.println(new MiniStatement().getMiniStatement());

	}

}
