# 🏨 BookMyStayApp

A **Java-based backend system** that simulates a real-world hotel booking platform, built incrementally using core Computer Science concepts like **OOP, Data Structures, Concurrency, and Persistence**.

---

## 🚀 Features

### 🔹 Core Booking System

* Room types using **OOP (Abstraction, Inheritance, Polymorphism)**
* Centralized inventory management using **HashMap**
* Room availability tracking and updates

### 🔹 Booking Flow

* Booking request queue using **FIFO Queue**
* Fair allocation of rooms
* Unique room ID generation

### 🔹 Add-On Services

* Attach multiple services (e.g., Breakfast, Pickup)
* Cost calculation using **Map + List**
* Extensible design (easy to add new services)

### 🔹 Booking History & Reporting

* Stores confirmed bookings using **List**
* Generates booking reports and summaries

### 🔹 Validation & Error Handling

* Custom exceptions for invalid bookings
* Input validation (room type, availability, guest name)
* Fail-fast and graceful error handling

### 🔹 Cancellation & Rollback

* Cancel confirmed bookings safely
* Inventory restored using **Stack (LIFO)**
* Prevents double cancellation

### 🔹 Concurrency (Multi-threading)

* Simulates multiple users booking simultaneously
* Thread-safe operations using **synchronization**
* Prevents race conditions and double booking

### 🔹 Data Persistence

* Saves system state using **Serialization**
* Restores booking & inventory data on restart
* Handles missing/corrupt files gracefully

---

## 🧠 Concepts Used

* Object-Oriented Programming (OOP)
* Data Structures:

  * HashMap
  * Queue (FIFO)
  * Stack (LIFO)
  * List
  * Set
* Exception Handling
* Multi-threading & Synchronization
* File Handling & Serialization
* System Design Principles

---

## 🏗️ Project Structure

```
src/
│
├── Room.java
├── SingleRoom.java
├── DoubleRoom.java
├── SuiteRoom.java
│
├── RoomInventory.java
├── RoomSearchService.java
│
├── Reservation.java
├── BookingRequestQueue.java
├── BookingService.java
├── BookingWorker.java
│
├── AddOnService.java
├── AddOnServiceManager.java
│
├── BookingHistory.java
├── BookingReportService.java
│
├── BookingValidator.java
├── InvalidBookingException.java
│
├── CancellationService.java
├── PersistenceService.java
│
└── BookMyStayApp.java
```

---

## ▶️ How to Run

```bash
javac -d src src/*.java
java -cp src BookMyStayApp
```

---

## 💡 Key Highlights

* Designed with **modular architecture**
* Ensures **data consistency under concurrency**
* Implements **real-world booking workflow**
* Demonstrates **scalable and extensible system design**

---

## 📈 Future Improvements

* Convert to **Spring Boot REST API**
* Add **MySQL database integration**
* Build a **frontend UI (React/HTML/CSS)**
* Implement authentication & user roles

---

## 👨‍💻 Author

**Aditya Khuntia**
B.Tech CSE, SRM University

---

## ⭐ If you like this project, give it a star!
