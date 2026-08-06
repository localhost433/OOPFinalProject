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
├── Main.java           # static entry points for each operation
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
- [ ] Booking
- [ ] Cancel or reschedule
- [ ] CLI in `main()`
- [ ] Persistence
- [ ] Use case diagram
- [ ] Sequence diagrams — one per use case
- [ ] Class diagram

## Docs

### Use case diagram

[`docs/use-case-diagram.puml`](docs/use-case-diagram.puml) — PlantUML.