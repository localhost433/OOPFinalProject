# Appointment Manager

## Project Proposal

| Field | Details |
| --- | --- |
| Application type | Java command-line application |
| Domain | Tutoring appointment management |
| Primary users | Students, tutors, and administrators |

## Overview

Appointment Manager is a Java command-line application for managing tutoring appointments between students and tutors. The system enables tutors to provide available tutoring openings while allowing students to search for and manage their appointments.

An administrator can add student and tutor accounts. Tutors can create availability openings and view the openings they have created. Students can search for available openings, book an opening, view their booked openings, and cancel a booking.

## Scope

The application supports the creation and management of tutoring availability and appointments through role-specific actions:

- Administrators manage student and tutor accounts.
- Tutors create and review their availability openings.
- Students search for, book, review, and cancel tutoring appointments.

## Actors

| Actor | Responsibilities |
| --- | --- |
| **Student** | Search for available tutoring openings; book an available opening; view booked openings; cancel a booked opening. |
| **Tutor** | Add availability openings; view the availability openings they have created. |
| **Administrator** | Add student accounts; add tutor accounts. |

## Use Cases

| Use case | Actor | Description |
| --- | --- | --- |
| **Add Student** | Administrator | Creates a new student account. |
| **Add Tutor** | Administrator | Creates a new tutor account. |
| **Add Availability** | Tutor | Creates an available tutoring opening. |
| **Display Openings for Tutor** | Tutor | Views the availability openings they have created. |
| **Search Opening** | Student | Searches for available tutoring openings. |
| **Book Opening** | Student | Books an available tutoring opening after searching for available openings. |
| **Display Openings for Student** | Student | Views the tutoring openings they have booked. |
| **Cancel Opening** | Student | Cancels one of their booked tutoring openings after viewing their booked openings. |

## Use-Case Relationships

- **Book Opening** `<<extend>>` **Search Opening**: A student may book an opening after searching for available openings.
- **Cancel Opening** `<<extend>>` **Display Openings for Student**: A student may cancel an opening after viewing their booked openings.
