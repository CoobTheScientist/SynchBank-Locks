# SynchBankTest1 README

## Overview

This Java project, named SynchBankTest1, demonstrates the synchronization of bank transactions using locks. The main components of the project include a Bank class, a SynchBankTest class for testing multiple threads, and a TransferRunnable class representing a runnable task for transferring money between accounts.

### Project Structure

The project consists of three Java files:

1. Bank.java: This class represents a bank with a set of accounts. It utilizes locks for synchronization to ensure safe concurrent transactions.

2. SynchBankTest.java: The main class initializes a bank with a specified number of accounts and initial balance. It then creates multiple threads, each running a TransferRunnable task to simulate money transfers between accounts.

3. TransferRunnable.java: This class implements the Runnable interface and represents a task that transfers money from one account to another within the bank. The run method continuously performs random transfers with a delay.

## Usage
To use this project, follow these steps:

1. Clone the repository:
    git clone <repository-url>

2. Compile:
    javac SynchBankTest1/*.java

3. Run:
    java SynchBankTest1.SynchBankTest

### Dependencies

This project does not have any external dependencies beyond the standard Java libraries.

## Author

Yacob Ahmad

Date: 2-24-2023

Course: CPSC - 4148 Adv. Java

Semester: Spring 2023

## Notes

* The project uses locks and conditions to ensure proper synchronization during money transfers.
* Threads are created to simulate concurrent transactions, showcasing the thread-safe nature of the implemented synchronization.
  
Feel free to explore the code and experiment with different parameters to observe how the bank handles concurrent transactions.
