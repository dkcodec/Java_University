# Assignment 5
<hr>

### Individual Work:
<li>This assignment must be completed individually. The topic of the assignment is of your
own choice.

### Task:
The student must implement a mini project using a database.

### Description:
Develop a console Java application that interacts with a PostgreSQL database to perform
CRUD operations (Create, Read, Update, Delete) on a specific dataset.

### Evaluation system:
<ul>
<li>The work should be done individually and contain a logical use of database and adhere to
the Clean code (70%).
<li>After the defense, you need to answer 2 questions (30%).
<li><strong>No cheating, no use of the source code.</strong>
<li>If the template implementation option is not unique (the idea), you will lose -10%.
<li>Without protection, the maximum achievable score for a task is 50%.
</ul>

### Note: 
<p>
– Ensure that your code is well-structured, follows coding conventions, and is welldocumented with comments where necessary.
</p>
<p>
– Test your code thoroughly to ensure it works correctly.
</p>
<p>
– Plagiarism will not be tolerated, and academic integrity rules apply.
</p>
<p>
– Important: Late submissions may lead to a deduction of up to 20 points from your total
mark for this assignment.</p>


# My Idea:

- Creating animal shelter
- DataBase with Available animals
- id, name, species, age, status

### Creating animal shelter: 
<p>
First of all I created Animal class
</p>

<p>
After I create Key file with url, password, user(this file isn't in repository in .gitignore file)
</p>

Creating AnimalDataAccessObject(AnimalDAO in Main file):
<hr style="width: 200px">
all functions:
<ul> 
<li>Connection func from DB to JAVA with jdbc
<li>Adding func Animals to DB
<li>Getting func (getting list of Animals)
<li>Updating animal func
<li>Delete animal func
<li>CLOSING connection func
</ul>

### Data base structure:
```postgresql
CREATE DATABASE Animals;
\c Animals;

CREATE TABLE animals (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    species VARCHAR(50),
    age INT,
    status VARCHAR(20)
);
```

