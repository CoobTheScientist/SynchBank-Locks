/*
 * Yacob Ahmad
 * 2-24-2023
 * CPSC - 4148 Adv. Java
 * Spring 2023
 */
package SynchBankTest1;
import java.util.concurrent.locks.*;
/**
 * A bank with a number of bank accounts.
 * Using locks
 */
public class Bank
{
	
   private final double[] accounts;
   private Lock lock;
   private Condition enough;
	
   /**
    * Constructs the bank.
    * @param n the number of accounts
    * @param initialBalance the initial balance for each account
    */
   public Bank(int n, double initialBalance)
   {
      accounts = new double[n];
      for (int i = 0; i < accounts.length; i++)
         accounts[i] = initialBalance;
      lock = new ReentrantLock();
      enough = lock.newCondition();
   }

   /**
    * Transfers money from one account to another.
    * @param from the account to transfer from
    * @param to the account to transfer to
    * @param amount the amount to transfer
    */
   public void transfer(int from, int to, double amount) 
   {
	   lock.lock();
	   
	   try {
		   while (accounts[from] < amount) {
			   enough.await();
			   
		   }
			   
		   
		   System.out.print(Thread.currentThread());
		   accounts[from] -= amount;
		   System.out.printf(" %10.2f from %d to %d", amount, from, to);
		   accounts[to] += amount;
		   System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		   
	   } 
	   
	   catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   
	   finally {
		   lock.unlock();
	   }  
   }

   /**
    * Gets the sum of all account balances.
    * @return the total balance
    */
   public double getTotalBalance()
   {
	   lock.lock();
	   try {
		   double sum = 0;
		   
		   for (double a : accounts)
		        sum += a;
		   
		   return sum;
		   
	   }
	   finally {
		   lock.unlock();
	   }
       
   }

   /**
    * Gets the number of accounts in the bank.
    * @return the number of accounts
    */
   public int size()
   {
      return accounts.length;
   }
    
}
