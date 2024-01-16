/*
 * Yacob Ahmad
 * 2-24-2023
 * CPSC - 4148 Adv. Java
 * Spring 2023
 */
package SynchBankTest1;

/**
 * This program shows how multiple threads can access a data structure.
 * 
 */
public class SynchBankTest
{
   public static final int NACCOUNTS = 100;
   public static final double INITIAL_BALANCE = 1000;
   
   public static void main(String[] args)
   {
      Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
      int i;
      for (i = 0; i < NACCOUNTS; i++)
      {
         TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
         Thread t = new Thread(r);		// Create new thread t using r
         t.start();				// start the thread
      }
   }
  
}

