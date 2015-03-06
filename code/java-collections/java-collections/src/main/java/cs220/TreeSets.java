package cs220;

import java.util.*;

public class TreeSets {
    // A private static class. What is this? Yes, Java supports
    // nested classes!

    // To make our class work with a TreeSet data structure we must
    // implement the Comparable<T> interface:
    private static class Student implements Comparable<Student> {
	public String sid, fname, lname;

	public Student(String sid, String fname, String lname) {
	    this.sid   = sid;
	    this.fname = fname;
	    this.lname = lname;
	}

	
	// The Comparable<T> interface requires us to implement the
	// single method `compareTo`.
	@Override
	public int compareTo(Student other) {
	    // Here, we leverage the compareTo method implemented by
	    // String. If not, we would need to implement a method
	    // that would return a value V such that V < 0 if this
	    // student is "less than" other, V == 0 if this student
	    // "equals" other, and V > 0 if this student is "greater
	    // than" other.
	    return sid.compareTo(other.sid);
	}
    }

    public static void main(String[] args) {
	Set<Student> s = new TreeSet<Student>();
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

	// The size of the set should be two, but is it?
	System.out.println("The size of the list is " + s.size());

	if (s.contains(s1)) {
	    System.out.println(s1.fname + " is in the set");
	}
	else {
	    System.out.println(s1.fname + " is not in the set");
	}

	//
	// Example Using TreeSet:
	//
	Set<Student> t = new TreeSet<Student>();
	// Let us add s1 twice:
	t.add(s1);
	t.add(s1);
	// Let us add s2 twice:
	t.add(s2);
	t.add(s2);
	// Let us add s3 twice:
	t.add(s3);
	t.add(s3);

	// The size of the set should be two, but is it?
	System.out.println("The size of the list is " + t.size());

	if (t.contains(s1)) {
	    System.out.println(s1.fname + " is in the set");
	}
	else {
	    System.out.println(s1.fname + " is not in the set");
	}	
    }    
}
