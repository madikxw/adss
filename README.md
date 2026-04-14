# Assignment 2 – Banking System

**Student:** B.Madiyar 
**Group:** IT-2501

## Description

This project is a simple banking system written in Java.  
The goal is to show how different data structures work in practice.

The program includes:
- Bank account storage using LinkedList
- Deposit and withdraw operations
- Transaction history using Stack
- Bill payment and account requests using Queue
- Fixed-size array of accounts
- Bank, ATM, and Admin menus

---

## Data Structures Used

**LinkedList**
- Stores all bank accounts
- Allows adding, searching, and updating accounts

**Stack**
- Stores transaction history
- Works with LIFO (last action on top)

**Queue**
- Used for bill payments and account requests
- Works with FIFO (first request processed first)

**Array**
- Stores 3 predefined accounts
- Demonstrates fixed-size structure

---

## Program Features

### Bank Menu
- Add account
- Display all accounts
- Search account
- Deposit money
- Withdraw money
- Add bill payment

### ATM Menu
- Check balance
- Withdraw money

### Admin Menu
- View account requests
- Process account requests
- View bill queue
- Process bills
- View all accounts

---

## Structure

- `Main.java` – starts the program  
- `BankAccount.java` – account model  
- `BankSystem.java` – main logic and menus  

---

## Summary

In this project, I implemented a banking system using LinkedList, Stack, Queue, and Array.  
I learned how different data structures can be used for different tasks like storing accounts, processing requests, and managing history.

The program combines all tasks into one system with Bank, ATM, and Admin menus.
