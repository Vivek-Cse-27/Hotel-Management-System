🏨 Hotel Management System
Java • Swing • JDBC • SQLite / MySQL Compatible

A complete desktop-based Hotel Management System built using Java Swing.
The software helps hotel staff manage rooms, customers, employees, drivers, and check-in/check-out operations.

⚙️ Recently Updated
✔ Migrated database from MySQL → SQLite (single hotel.db)
✔ New DB schema import instructions included
✔ Fixed DB creation issue (SQLite auto-created)
✔ Updated Java code to work without MySQL server
✔ WAL Mode enabled for better performance
✔ Added busy-timeout to prevent “database is locked” errors

🚀 Features
🔒 1. User Authentication

Splash screen animation on startup (5 seconds).

Login screen appears (username: test, password: test).

Valid users → Dashboard.

Admin actions require an additional Admin Login.

Reception modules do not require second login once inside Dashboard.

📟 2. Dashboard Modules
🛎 Reception Panel

Receptionists can:

✔ Add new customer (Check-In)

✔ Search available rooms

✔ View employees

✔ View customer info

✔ View manager details

✔ Update customer status

✔ Update room status

✔ Handle Check-Out

✔ Arrange pick-up service

✔ Log out / return to dashboard

🛠 Admin Panel

Admins can additionally:

✔ Add new Employees

✔ Add new Rooms

✔ Add new Drivers

✔ Return to Dashboard / Logout

🧰 Tech Stack Used
Component	Technology
GUI	Java Swing (JFrame, ActionListener)
Database	SQLite (Default) / MySQL supported
DB Utilities	rs2xml / DbUtils
Connectivity	JDBC
Packaging	Launch4j EXE (bundled JRE)
Image Loading	ClassLoader Resource System

🗂 Latest Database Update (SQLite)

The system now uses: hotel.db

Tables included:

login

admin

customer

employee

room

driver

SQLite fixes applied:

WAL mode enabled

Busy timeout added

Auto-creation of database if missing

No external DB server needed

📦 How to Run the Application
✔ Windows Users (Ready-to-Run EXE)

Download the full ZIP (JRE Included):
https://drive.google.com/file/d/1dJu95wLChnJ2FGvBzeyY2ngAYpegChbN/view?usp=sharing

Extract ZIP

Run HotelMS.exe

No Java installation required.

✔ Developers (Running From Source)

Install Java JDK 8+

Clone the project

Add these JARs to classpath:

sqlite-jdbc.jar

rs2xml.jar

Ensure hotel.db is present in the project root

Run via your IDE (IntelliJ / Eclipse / NetBeans)

🧱 Project Structure

src/
 └── Hotel/Management/System/
      ├── Login.java
      ├── Login2.java (Admin Login)
      ├── Dashboard.java
      ├── Reception.java
      ├── CheckIn.java
      ├── CheckOut.java
      ├── AddEmployee.java
      ├── AddRoom.java
      ├── AddDriver.java
      ├── PickUp.java
      ├── ManagerInfo.java
      ├── Connect.java    ← Updated SQLite DB Handler
      └── ...
icon/
 └── PNGs, GIFs (favicon, splash, etc.)
hotel.db
README.md

⚠ Known Issues

Some fields accept strings where numbers are required (phone, salary, price).

Need stronger input validation & error messages.

Passwords are stored in plain text (to be upgraded).

🌟 Future Improvements

➤ Numeric-only input validation

➤ Better exception handling

➤ Role-based access improvements

➤ Modern UI using FlatLaf or JavaFX

➤ PDF invoice generation during Check-Out

➤ Encrypted password storage

🤝 Contributing

Open to contributions!
Fork the repo → improve → submit a pull request.

Suggestions and feature requests are welcome.

📄 License

This project is released under the MIT License.