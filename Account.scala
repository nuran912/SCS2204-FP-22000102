class Account(val id: Int, private var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
        balance += amount
    }else{
      println("deposit failed: Invalid amount")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
      println("withdraw failed: Insufficient balance or invalid amount")

  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    } else {
      println("Transfer failed: Insufficient balance or invalid amount")
    }
  }

  def getBalance: Double = balance

  override def toString: String = s"Account(id: $id, balance: $balance)"
}

class Bank(val accounts: List[Account]) {

  // 4.1 List of Accounts with negative balances
  def accountsWithNegativeBalance: List[Account] = {
    accounts.filter(_.getBalance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def totalBalance: Double = {
    accounts.map(_.getBalance).sum
  }

  // 4.3 Calculate the final balances of all accounts after applying interest
  def applyInterest: Unit = {
    accounts.foreach { account =>
      if (account.getBalance > 0) {
        account.deposit(account.getBalance * 0.05)
      } else if (account.getBalance < 0) {
        account.withdraw(-account.getBalance * 0.1)
      }
    }
  }

  override def toString: String = {
    s"Bank(accounts: ${accounts.mkString(", ")})"
  }
}


object BankApp {
  def main(args: Array[String]): Unit = {
    // Create some accounts
    val acc1 = new Account(1, 1000)
    val acc2 = new Account(2, 500)
    val acc3 = new Account(3, -200)

    // Create a bank with these accounts
    val bank = new Bank(List(acc1, acc2, acc3))

    // Perform a transfer
    acc1.transfer(300, acc2)

    // Print accounts with negative balance
    println("Accounts with negative balance:")
    bank.accountsWithNegativeBalance.foreach(println)

    // Print total balance of all accounts
    println(s"Total balance: ${bank.totalBalance}")

    // Apply interest and print final balances
    println("Balances before applying interest:")
    bank.accounts.foreach(println)
    bank.applyInterest
    println("Final balances after applying interest:")
    bank.accounts.foreach(println)
  }
}

