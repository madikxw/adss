# Assignment 2 – Banking System (Physical & Logical Data Structures)

## Student Information
- **Name:** B.Madiyar
- **Group:** IT-2501

---

## 📌 Project Overview
This project simulates a **banking system** using both **logical** and **physical data structures** in Java.

The goal is to demonstrate how different data structures work in real-life scenarios such as:
- Managing bank accounts
- Processing transactions
- Handling queues (bill payments, account requests)
- Tracking transaction history

All tasks from the assignment are fully implemented and integrated into a working system.

---

## ⚙️ Technologies Used
- Java
- IntelliJ IDEA
- Data Structures:
  - LinkedList
  - Stack
  - Queue
  - Array

---

## 🧠 Implemented Tasks

### ✅ Task 1 – Bank Account Storage (LinkedList)
- Stores accounts using `LinkedList`
- Features:
  - Add account
  - Display accounts
  - Search by username

### ✅ Task 2 – Deposit & Withdraw
- Allows:
  - Deposit money
  - Withdraw money
  - Updates balance in LinkedList

### ✅ Task 3 – Transaction History (Stack)
- Uses `Stack` (LIFO)
- Features:
  - Add transaction
  - View last transaction (peek)
  - Undo last transaction (pop)

### ✅ Task 4 – Bill Payment Queue (Queue)
- Uses `Queue` (FIFO)
- Features:
  - Add bill
  - Process bill
  - Display queue

### ✅ Task 5 – Account Opening Queue
- Uses `Queue`
- Simulates admin workflow:
  - Users submit requests
  - Admin processes requests
  - Approved accounts move to LinkedList

### ✅ Task 6 – Physical Data Structure (Array)
- Uses `BankAccount[3]`
- Stores and prints predefined accounts

---

## 🏦 Mini Banking System (Integration)

### Main Menu
```
1 – Enter Bank
2 – Enter ATM
3 – Admin Area
4 – Exit
```

### Bank Menu
- Add account
- Deposit / Withdraw
- Submit account request
- Manage bill payments
- View transactions

### ATM Menu
- Check balance
- Withdraw money

### Admin Menu
- Process account requests
- Process bill payments
- View all accounts

---

## 💡 Why These Data Structures?

| Structure | Purpose |
|----------|--------|
| LinkedList | Dynamic storage of accounts |
| Stack | Transaction history (LIFO – last action first) |
| Queue | Bill payments & requests (FIFO – first come first serve) |
| Array | Fixed-size storage (physical memory example) |

---

## 🚀 How to Run
1. Open project in IntelliJ IDEA
2. Run `Main.java`
3. Use console menu to interact with system

---

## ⚠️ Notes
- Program handles invalid input safely
- Prevents duplicate usernames
- Ensures correct balance operations

---

## 📸 Screenshots
(Add screenshots here for each task when submitting)

---

## 🧾 Summary
During this project:
- Learned difference between **logical vs physical structures**
- Implemented real banking simulation
- Improved problem-solving and Java skills
- Understood how memory and structure affect program behavior

---

## ✅ Example Output
```
Account added successfully
Accounts List:
1. Ali – Balance: 150000
2. Sara – Balance: 220000

Deposit 50000 to Ali
New balance: 200000

Last transaction: Withdraw 20000 from Ali
Undo → Withdraw removed
```

---

✔ Project fully meets all assignment criteria 
