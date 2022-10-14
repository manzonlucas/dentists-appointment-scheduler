### dentists-appointment-scheduler
Final backend project developed for Certified Tech Developer carreer (created by Digital House, Globant, MercadoLibre).
Appointment scheduler for dental clinics, developed in Java, with Maven, H2 database and frontend interaction.

HTTP request methods includes: GET, POST, PUT and DELETE. All of them can be tested with an API platform (e.g. Postman).
Due to requirementes, not all request methods are implemented in the frontend, only POST, GET and DELETE.

## Pre-requisites
- [Maven](https://maven.apache.org/download.cgi)
- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)

##API DOCUMENTATION:
#OdontologoController
- __POST__ /odontologos => without "id" property within .json, CREATES a new professional (dentist in this case).
- __PUT__ /odontologos => with "id" property within .json, MODIFIES an existing professional.
- __GET__ /odontologos => lists all professionals in database.
- __GET__ /odontologos/{id} => gets the professional whose id is requested.
- __DELETE__ /odontologos/{id} => deletes the professional whose id is requested.

#PacienteController
- __POST__ /pacientes => without "id" property within .json, CREATES a new patient.
- __PUT__ /pacientes => with "id" property within .json, MODIFIES an existing patient.
- __GET__ /pacientes => lists all patients in database.
- __GET__ /pacientes/{id} => gets the patient whose id is requested.
- __DELETE__ /pacientes/{id} => deletes the patient whose id is requested.

#TurnoController
- __POST__ /turnos => creates an appointment and returns:
{ 
paciente: {id: x}, 
odontologo: {id: x}
}
- __PUT__ /turnos => same request but "id" property added within .json, modifies an appointment.
- __GET__ /turnos => lists all appointments in database.
- __GET__ /turnos/{id} => gets the appointment which id is requested.
- __DELETE__ /turnos/{id} => gets the appointment which id is requested.


MANZÓN LUCAS MATIAS
DIGITAL HOUSE
BACKEND 1 - TP FINAL INTEGRADOR
11.07.2022
