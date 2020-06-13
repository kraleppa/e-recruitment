# eRekrutacja

[![Maven badge](https://img.shields.io/badge/Maven-4.0.0-red)](https://maven.apache.org)
[![Lombok badge](https://img.shields.io/badge/Project_Lombok-1.18.12-green)](https://mvnrepository.com/artifact/org.projectlombok/lombok)
[![Hibernate badge](https://img.shields.io/badge/Hibernate-5.4.13-yellow)](https://mvnrepository.com/artifact/org.hibernate/hibernate-core)
[![PostgreSql badge](https://img.shields.io/badge/PostgreSQL-42.2.12-%2346A9EE)](https://mvnrepository.com/artifact/org.postgresql/postgresql)
[![Spark badge](https://img.shields.io/badge/Spark-2.5.4-blueviolet)](https://mvnrepository.com/artifact/com.sparkjava/spark-core/2.5.4)
[![Gson badge](https://img.shields.io/badge/Gson-2.8.0-yellowgreen)](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.0)

## Krótki opis
Projekt na przedmiot Bazy Danych. Backendowy komponent obsługujący bazę danych PostgreSQL do zarządzania procesem e-rekrutacji na studia I stopnia, zrealizowany w Javie przy użyciu Hibernate.
## Diagram bazy danych
![diagram](https://github.com/szarbartosz/eRecruitment/blob/master/diagram.png)

## Struktura projektu
```
  .
  ├── controller                              # Klasy odpowiadające za REST API
  │   ├── AuthenticationController.java
  │   ├── config                              # Konfiguracja zwracanych JSONów
  │   │   ├── StandardResponse.java
  │   │   └── Status.java
  │   ├── Controller.java
  │   ├── ExamController.java
  │   ├── FacultyController.java
  │   ├── FieldController.java
  │   ├── RecruitmentController.java
  │   └── StudentController.java
  ├── dao                                     # Metody odpowiedzialne za komunikację z bazą danych
  │   ├── SessionFactoryDecorator.java        
  │   ├── StudentDao.java                     # Metody po stronie aplikanta
  │   └── UniversityDao.java                  # Metody po stronie uczelni
  ├── Main.java
  └── model                                   # Model danych
      ├── Address.java
      ├── Candidate.java
      ├── Exam.java
      ├── Faculty.java
      ├── Field.java
      └── Student.java
```
## Opis funkcjonalności

Projekt realizuje jednoetapową rekrutację studentów na wybrane kierunki studiów I stopnia. Podczas rekrutacji pod uwagę brane są wyniki egzaminów maturalnych, które uprzednio student wprowadza do systemu. Zarejestrowani studenci mogą aplikować na różne kierunki. Uczelnia, jako główny zarządca systemu, manipuluje dostępnymi wydziałami i kierunkami studiów.

## Obsługiwane endpointy (../java/main)
Wykorzystany przez nas framework Spark domyślnie uruchamia serwer na porcie 4567.

### get
```java
get("/students", StudentController.getAllStudents);           //pobranie listy zarejestrowanych aplikantóœ
get("/authenticate", AuthenticationController.authenticate);  //autentykacja aplikanta
get("/faculties", FacultyController.getAllFaculties);         //pobranie listy wydziałów
get("/fields", FieldController.getAllFields);                 //pobranie listy kierunków studiów
```


### post
```java
post("/register", AuthenticationController.register);     //rejestracja aplikanta
post("/exams", ExamController.addExam);                   //przypisanie wyników egzaminu do aplikanta
post("/candidacies", StudentController.apply);            //aplikacja na dany kierunek studiów
post("/faculties", FacultyController.addFaculty);         //dodanie nowego wydziału
post("/fields", FieldController.addField);                //dodanie nowego kierunku studiów
post("/fields/:id", FieldController.addSubject);          //dodanie nowego przedmiotu branego pod uwagę podczas rekrutacji
```


### patch
```java
patch("/candidacies/:id", RecruitmentController.startRecruitment); //kwalifikacja aplkantów z najlepszymi wynikami egzaminów 
```

Wszystkie endpointy są obsługiwane przez metody zaimplementowane w folderze ocntroller  (../java/controller/)

## Uruchomienie projektu :elephant:

Aby uruchomić projekt wystarczy odpowiednio skonfigurować połączenie ze stworzoną uprzenio bazą danych w pliku hibernate.cfg.xml. Przykładowa konfiguracja połączenia z bazą danych o nazwie DB dostępną pod adresem http://localhost:5432/DB

```XML
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/DB</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">password</property>
``` 



## Kontrybutorzy :poland: :onion:
<table>
  <tr>
    <td align="center"><a href="https://github.com/szarbartosz"><img src="https://avatars3.githubusercontent.com/u/48298481?s=400&u=f61ccb0f734a51dc2a1115e6478839be62cb2216&v=4" width="100px;" alt=""/><br /><sub><b>Bartosz Szar</b></sub></a><br /></td>
    <td align="cefix fixanter"><a href="https://github.com/kraleppa"><img src="https://avatars1.githubusercontent.com/u/56135216?s=460&u=359e017d16c70a31d3bdb086172308cc6f045acf&v=4" width="100px;" alt=""/><br /><sub><b>Krzysztof Nalepa</b></sub></a><br />
    </td>
  </tr>
</table>


