# Assignment 3: Sorting and Searching Algorithm Analysis System

## Project Overview

This project implements and compares three fundamental algorithms:

- Selection Sort as the basic sorting algorithm
- Quick Sort as the advanced sorting algorithm
- Binary Search as the searching algorithm

The goal of the project is to measure and compare algorithm performance using different input sizes and to understand how theoretical Big-O complexity matches practical execution time.

---

## Selected Algorithms

### 1. Selection Sort

Selection Sort repeatedly finds the smallest element in the unsorted part of the array and places it at the beginning.

In this project, Selection Sort is implemented recursively.

**Time Complexity:**

| Case | Complexity |
|---|---|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

Selection Sort is simple but slow for large arrays because it always compares many elements.

---

### 2. Quick Sort

Quick Sort is a divide-and-conquer sorting algorithm. It selects a pivot, partitions the array into smaller and larger elements, and then recursively sorts both parts.

**Time Complexity:**

| Case | Complexity |
|---|---|
| Best Case | O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n²) |

Quick Sort is usually much faster than Selection Sort, especially for larger arrays.

---

### 3. Binary Search

Binary Search finds a target value by repeatedly dividing the sorted array in half.

In this project, Binary Search is implemented recursively.

**Time Complexity:**

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

Binary Search requires a sorted array because it decides which half of the array to search based on ordered values.

---

## Project Structure

```text
assignment3-sorting-searching/
├── src/
│   ├── Sorter.java
│   ├── Searcher.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   └── screenshots/
├── README.md
└── .gitignore
