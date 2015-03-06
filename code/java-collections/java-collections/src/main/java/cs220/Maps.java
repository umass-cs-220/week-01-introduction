package cs220;

import java.util.*;

public class Maps {
    private static class Student implements Comparable<Student> {
	public String sid, fname, lname;

	public Student(String sid, String fname, String lname) {
	    this.sid   = sid;
	    this.fname = fname;
	    this.lname = lname;
	}

	@Override
	public boolean equals(Object o) {
	    if (!(o instanceof Student))
		return false;
	    Student other = (Student) o;
	    return other.sid == sid;
	}

	@Override
	public int hashCode() {
	    return (sid + fname + lname).hashCode();
	}

	@Override
	public int compareTo(Student other) {
	    return sid.compareTo(other.sid);
	}

	@Override
	public String toString() {
	    return fname + " " + lname + " (" + sid + ")";
	}
    }

    public static void main(String[] args) {
	// Note: that with modern versions of the Java language (Java
	// SE 7) we are not required to put the generic type
	// information with the constructor. We *are* required,
	// however, to add the <>. If you do not you will receive a
	// warning from the compiler. We can do this because the
	// compiler will "infer" the type used by looking at the
	// left-hand side of the assignment. This is called "type
	// inference" and we will much more of this in Scala!
	Map<Student, Integer> m1 = new HashMap<>();
	Map<Student, Integer> m2 = new TreeMap<>();

	Student s1 = new Student("1234", "Jane", "Doe");
	Student s2 = new Student("5678", "Jane", "Doe");
	// Note that s3 contains the same data as s1:
	Student s3 = new Student("1234", "Jane", "Doe");	

	m1.put(s1, 89);
	m1.put(s2, 24);
	m1.put(s3, 91);

	// What is the size of this map?
	System.out.println("The size of the HasMap is " + m1.size());
	// What is in it?
	for (Map.Entry<Student, Integer> e : m1.entrySet()) {
	    System.out.printf("   %s : %d\n", e.getKey(), e.getValue());
	}

	m2.put(s1, 89);
	m2.put(s2, 24);
	m2.put(s3, 91);
	
	// What is the size of this map?
	System.out.println("The size of the HasMap is " + m2.size());
	// What is in it?
	for (Map.Entry<Student, Integer> e : m2.entrySet()) {
	    System.out.printf("   %s : %d\n", e.getKey(), e.getValue());
	}

    }
	
}
