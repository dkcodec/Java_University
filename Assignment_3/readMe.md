<h1>Assignment 3</h1>
<p>This assignment will help you to dive into the concepts of polymorphism and inheritance.</p>
<p>Create classes Person, Employee and Student.</p>
<h3>Class Person</h3>
<ul>
<li> id (int) – field (should be automatically set. Hint: use helper static variable)
<li> name (string) – field
<li> surname (string) - field 
<li> toString() – method (e.g. “1. John Lennon”)
<li> getters and setters (the field id needs only getter)
<li> 2 constructors (default and parametrized which takes both name and surname)
<li> string getPosition() – method (should return either the appropriate position or text “Student”)
</ul>

<h3>Class Employee</h3>
<ul>
<li> id (int) – field (should be automatically set. Hint: use helper static variable)
<li> name (string) – field
<li> surname (string) – field
<li> position (string) – field
<li> salary (double) – field
<li> toString() – method (e.g. “Employee: 1. John Lennon”)
<li> getters and setters (the field id needs only getter)
<li> 2 constructors (default and parametrized which takes 4 arguments name, surname, position,
and salary)
</ul>
<h3>Class Student</h3>
<ul>
<li> id (int) – field (should be automatically set. Hint: use helper static variable)
<li> name (string) – field
<li> surname (string) – field
<li> gpa (double) – field
<li> toString() – method (e.g. “Student: 1. John Lennon”)
<li> getters and setters (the field id needs only getter)
<li> 2 constructors (default and parametrized which takes 3 arguments name, surname, and gpa)
</ul>
<h3>Interface Payable</h3>
<ul>
<li> double getPaymentAmount() – will return the amount of money one could get in form of either
salary or stipend (Hint: The stipend is given in case student is having gpa > 2.67 and it is
constant: 36660.00 tenge)
Make your person to be Payable (Person should implement Payable interface)
Create Main class with <strong>main()</strong>> and <strong>printData(Iterable<Person>>)</strong></strong> methods.
    <li><ul><strong>main() method should include:</strong>
        <li>Several employees and students (including those who are not taking stipend because of gpa)
        <li> ArrayList<Person> and with all employees and students inserted to current List.
        <li> A call to printData method.
    </ul>

<li><ul><strong>printData(Iterable<Person>) method:</strong>
<li>Should iterate through every Payable object using foreach structure and print the data as following example output:
<p>Student: 3. Ringo Starr earns 0.00 tenge
Employee: 1. John Lennon earns 27045.78 tenge
Student: 4. Paul McCartney earns 36660.00 tenge
Employee 2: George Harrison earns 50000.00 tenge
</ul>
</ul>
<hr>
<h3>Last point:</h3> <strong>Try to make your Person to implement Comparable interface.
<p>(HINT: class Person implements Comparable<Person>)</strong></p>
Implement compareTo() method for both Employee and Student classes. That comparison should be
based on the amount of money they make.
In the main method call the Collections.sort() method and send your ArrayList there before the call to
the printData method.
<p><strong>Hint: one of the Collections.sort()</strong></p> methods accepts List<T> where T is generic Comparable type.
Since your Person is comparable, that should work. 