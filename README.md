# Restaurant Table Booking System

Simple console‑based Java program to manage table reservations for a restaurant, originally built as my DSA final exam.

## 📝 Description

This is a lightweight Java application for managing up to 20 restaurant table reservations. Users can:
- Add a booking (table number, customer first & last name, seat count)
- View all reservations
- Cancel a reservation by table number
- Update reservation details
- Cancel all reservations

**Why I built it**:  
– As a data structures & algorithms final exam project, to practice objects, serialization, list iteration, and file I/O.  
– To demonstrate fundamentals of Java, console UI, and data persistence with `ArrayList` and `ObjectStream`.

## ⚙️ Getting Started

### Prerequisites

- Java Development Kit (JDK 8 or higher)
- Command‑line terminal (Windows, macOS, Linux)
- Basic understanding of compiling and running Java code

### Installation

1. Clone or download the repository.
2. Make sure `ReservationMain.java` and `Reservation.java` are in `FinalProject` package folder.
3. No external libraries—pure Java standard API.

### Running the Program

```bash
cd FinalProject
javac Reservation.java ReservationMain.java
java FinalProject.ReservationMain
