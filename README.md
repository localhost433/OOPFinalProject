# Tutoring Center Appointment Manager

A Java command-line application that manages appointments between students and tutors at a tutoring center. Tutors publish openings for the subject they teach; students search open slots by subject, date, and time and book a session.

CSCI-UA 470 Object-Oriented Programming final project.

## Team

| Full name   | NetID  |
| ----------- | ------ |
| Robin Chen  | tc4119 |
| Robert Fang | rf2789 |

## Repository layout

Sources sit at the repository root, in the default package.

```text
.
├── README.md
├── docs/
│   └── diagrams/       # PlantUML sources
├── Main.java           # console front end: I/O
├── AppointmentService.java
├── Result.java         # the outcome an operation reports back to Main
├── SystemManager.java  # static registries of all students, tutors, and openings
├── Student.java        # a student and the openings they have booked
├── Tutor.java          # a tutor, their subject, and the openings they offer
├── Opening.java        # a time slot; booked when it holds a student
└── FileManager.java    
```

## Build and run

Requires a JDK (developed against 22).

```bash
javac *.java
java Main
```

## Status

- [x] Proposal drafted
- [x] Class design
- [x] Model classes compile
- [x] CLI in `main()`
- [x] Persistence
- [x] Use case diagram
- [x] Sequence diagrams — one per use case
- [x] Class diagram

## Docs

All diagrams are PlantUML sources in [`docs/diagrams/`](docs/diagrams).

| Diagram | Source |
| --- | --- |
| Use case | [`docs/diagrams/use-case-diagram.puml`](docs/diagrams/use-case-diagram.puml) |
| Class | [`docs/diagrams/class-diagram.puml`](docs/diagrams/class-diagram.puml) |
| UC-01 Create student | [`docs/diagrams/create-student-sequence.puml`](docs/diagrams/create-student-sequence.puml) |
| UC-02 Create tutor | [`docs/diagrams/create-tutor-sequence.puml`](docs/diagrams/create-tutor-sequence.puml) |
| UC-03 Create opening | [`docs/diagrams/create-opening-sequence.puml`](docs/diagrams/create-opening-sequence.puml) |
| UC-04 Display openings for tutor | [`docs/diagrams/display-openings-tutor-sequence.puml`](docs/diagrams/display-openings-tutor-sequence.puml) |
| UC-05 Search openings | [`docs/diagrams/search-openings-sequence.puml`](docs/diagrams/search-openings-sequence.puml) |
| UC-06 Book appointment | [`docs/diagrams/book-appointment-sequence.puml`](docs/diagrams/book-appointment-sequence.puml) |
| UC-07 Display openings for student | [`docs/diagrams/display-openings-student-sequence.puml`](docs/diagrams/display-openings-student-sequence.puml) |
| UC-08 Cancel appointment | [`docs/diagrams/cancel-appointment-sequence.puml`](docs/diagrams/cancel-appointment-sequence.puml) |
