# End term Project
### Individual Work:
- This end term must be completed individually. The topic of the assignment is of your own
choice.
### Task:
- The student must implement a console application using all the principles of OOP.
### Description:
- The goal of the task is to apply the basic principles of OOP, such as encapsulation,
inheritance and polymorphism, in practice, to develop an efficient and easily extensible system.
### Evaluation system:
The task should be extended and configurable using SOLID (single responsibility,
Open/Closed, lisk substitutions, interface segregation, dependency inversion) and clean code.
(70%).
- After the defense, you need to answer 2 questions (20%).
- The work must be submitted with a link to github (10%).
- No cheating, no use of the source code.
- If the template implementation option is not unique (the idea), you will lose -10%.
- Without protection, the maximum achievable score for a task is 50%.
### Note:
- Ensure that your code is well-structured, follows coding conventions, and is welldocumented with comments where necessary.
- Test your code thoroughly to ensure it works correctly.
- Plagiarism will not be tolerated, and academic integrity rules apply.
- Important: Late submissions may lead to a deduction of up to 20 points from your total
mark for this assignment.

<hr style="height: 3px; background: aquamarine"/>

## Idea

- The idea was to create a pharmacy app with database connectivity and utilize SOLID principles.

#### What does my app do?

it's how menu looks like:
```
1. Add Drug
2. Update Drug
3. Delete Drug
4. View Drug Details by ID
5. View All Drugs
0. Exit
Enter your choice:
```

### How did I use SOLID?

- Single Responsibility Principle (SRP):
DrugRepositoryImpl implements the DrugRepository interface and is responsible for interacting with the database in the context of drugs. It is responsible for performing CRUD operations on drug data.
ConsoleUserInterface implements the UserInterface interface and is responsible for interacting with the user through the console. Its responsibility is to display menus, read user selections and call appropriate methods. 
- Open/Closed Principle (OCP):
The DrugRepositoryImpl and ConsoleUserInterface classes are extensible to make changes without modifying existing code. For example, you can easily add new methods to DrugRepository or new interface options to UserInterface without affecting existing logic.
- Barbara Liskov Substitution Principle (LSP):
UserInterface and DrugRepository interfaces define contracts that implement ConsoleUserInterface and DrugRepositoryImpl. This means that objects of these classes can be used wherever the corresponding interface is expected.
- Dependency Inversion Principle (DIP):
The PharmacyApp class depends on the abstractions represented by the UserInterface and DrugRepository interfaces. This allows different implementations of these interfaces to be substituted without changing the PharmacyApp code.
Note that these SOLID principles aim to create flexible, extensible, and maintainable systems, and following them in code is important to ensure the cleanliness and stability of the program during changes and additions.

