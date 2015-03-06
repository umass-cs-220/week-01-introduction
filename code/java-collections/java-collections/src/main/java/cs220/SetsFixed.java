package cs220;

import java.util.*;

public class SetsFixed {

    // A private static class. What is this? Yes, Java supports
    // nested classes!
    private static class Student {
	public String sid, fname, lname;

	public Student(String sid, String fname, String lname) {
	    this.sid   = sid;
	    this.fname = fname;
	    this.lname = lname;
	}

	// Always good to use the @Override annotation to let the
	// compiler know of your intentions. If you get the method
	// signature wrong and you do not provide the annotation you
	// may not realize that you are not *really* overriding the
	// method.

	// We will define equality between students as having the same
	// sid (student id).
	@Override
	public boolean equals(Object o) {
	    if (!(o instanceof Student))
		return false;
	    Student other = (Student) o;
	    return other.sid == sid;
	}

	// We will define the hashcode to be the hashcode of the
	// concatenation of the three strings contained in this class.
	@Override
	public int hashCode() {
	    return (sid + fname + lname).hashCode();
	}
    }

    public static void main(String[] args) {
	Set<Student> s = new HashSet<Student>();
	Student s1 = new Student("1234", "Jane", "Doe");
	Student s2 = new Student("5678", "Jane", "Doe");
	// Note that s3 contains the same data as s1:
	Student s3 = new Student("1234", "Jane", "Doe");	

	// Let us add s1 twice:
	s.add(s1);
	s.add(s1);
	// Let us add s2 twice:
	s.add(s2);
	s.add(s2);
	// Let us add s3 twice:
	s.add(s3);
	s.add(s3);

	// The size of the set should be two:
	System.out.println("The size of the list is " + s.size());

	if (s.contains(s1)) {
	    System.out.println(s1.fname + " is in the set");
	}
	else {
	    System.out.println(s1.fname + " is not in the set");
	}
    }
    
}
