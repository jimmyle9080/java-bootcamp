# Lab 5 - Library Management System: Answers & Notes

**Name:** Jimmy Le-Nguyen
**Module:** 5 - Java Collections Framework
**Project:** examples/Lab5-LibraryManagement/ (package com.academy.library)

---

## 1. Collection mapping

| Field | Type | Why |
| --- | --- | --- |
| books | ArrayList<Book> | Ordered catalog, fast access by index, easy to loop for display. |
| members | ArrayList<Member> | Ordered roster, same reasons. |
| bookIds | HashSet<String> | Instant O(1) check for duplicate book IDs before adding. |
| memberIds | HashSet<String> | Instant O(1) check for duplicate member IDs. |
| borrowRecords | HashMap<String, String> | Maps bookId to memberId, so I can find who has a book instantly. |
| categories | TreeSet<String> | Unique category names, kept sorted for clean reports. |
| categoryBookCount | TreeMap<String, Integer> | Category to count, sorted by key so reports print alphabetically. |
| borrowHistory | ArrayList<BorrowRecord> | Ordered log of every borrow and return. |
| borrowFrequency | HashMap<String, Integer> | bookId to borrow count, fast to update for the Top 5 list. |

Rule I followed: ordered with duplicates allowed means List, unique items mean Set, and lookup by key means Map. If I need sorted output, I use the Tree version.

---

## 2. Reflection questions

**1. When would you choose a List over a Set?**
When order matters or duplicates are fine, and I need to grab items by position. The catalog is a List because a library can own two copies of the same title, and I want them shown in the order they were added. A Set would drop the duplicate and doesn't let me use an index.

**2. Why use a HashSet to check a book ID before inserting?**
To catch duplicate IDs instantly. A HashSet checks if an ID already exists in O(1). If I checked the ArrayList instead, it would scan every book one by one, which is O(n) and gets slower as the catalog grows.

**3. Why use a Map for currently borrowed instead of just a boolean?**
A boolean only tells me yes or no, the book is out. It doesn't tell me who has it. The HashMap stores bookId to memberId, so I can instantly see which member is holding a book. I still keep the available boolean for quick display, but the Map holds the actual relationship.

**4. HashMap vs TreeMap in this lab?**
I use HashMap for borrow records because I only look things up by key and don't care about order, so O(1) is perfect. I use TreeMap for category counts because it keeps keys sorted, so my reports print categories alphabetically without any extra work.

**5. Comparable vs Comparator for books?**
Comparable is the built-in default order. Book uses it to sort by title. Comparator is a separate rule I can swap in without touching the Book class, like BookComparator sorting by price. So Comparable gives one natural order and Comparator lets me sort however I want.

**6. Which iteration style would you use most in production, and why?**
Mostly the enhanced for loop, since it's clean and easy to read for simple loops. I'd use an Iterator when I need to remove items while looping, since that's the only safe way, and a regular for loop when I actually need the index. For-each covers most cases.

**7. CRM: which collection for a customer list, unique emails, and id to customer lookup?**
A List (ArrayList) for the customer list since it's ordered and I loop over it. A Set (HashSet) for unique emails so no two customers share one. A Map (HashMap) for id to customer lookups so I can pull a customer by id instantly. Same List, Set, Map logic as the library.

---

## 3. Performance comparison (menu 14)

Ran with n = 30000. Numbers vary by machine, the pattern is what matters.

| Operation | ArrayList | LinkedList | Winner |
| --- |-----------|------------| --- |
| Insert at front | 56.43 ms  | 1.70 ms    | LinkedList |
| Random access by index | 0.80 ms   | 377.09 ms  | ArrayList |

What I saw: ArrayList is slow inserting at the front because it shifts every element over each time. LinkedList is fast there since it just updates a couple pointers. It flips for random access. ArrayList jumps straight to an index while LinkedList has to walk through the nodes one by one. Each list is fast at what its structure is built for.

---

## 4. Compile and run commands

JDK 21, macOS Terminal.

    cd ~/java-bootcamp/examples/Lab5-LibraryManagement
    rm -rf out
    javac -d out src/com/academy/library/*.java
    java -cp out com.academy.library.Main

Package: com.academy.library. Entry point: com.academy.library.Main

---

## 5. Manual verification

| # | Check | Result |
| - | ----- | --- |
| 1 | Menu loads, bad input shows an error and reprints the menu | Pass  |
| 2 | Add book 101, register member 1, borrow, reports match | Pass |
| 3 | Duplicate book ID 101 gives "Book already exists." | Pass |
| 4 | Display books shows the title in all four iteration styles | Pass |
| 5 | Sort by title reorders when there are multiple books | Pass|
| 6 | Category insights lists Programming after the add | Pass |
| 7 | Borrowing 101 twice gives "Book is already borrowed." | Pass |
| 8 | Return 101, then Available Books shows it again | Pass |
| 9 | Exit (11) prints "Thank You" and ends | Pass |