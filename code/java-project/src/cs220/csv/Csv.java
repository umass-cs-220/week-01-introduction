package cs220.csv;

import java.io.*;
import java.util.*;

// The Csv class provides an abstraction for viewing CSV files. It
// implements the Iterable interface so that it can be easily used by
// Java's enhanced for-loop.
public class Csv implements Iterable<List<String>> {
    // The name of the original CSV file.
    private String filename;

    // A list of lists representing the rows in the CSV file.
    private ArrayList<ArrayList<String>> rows;

    // A public constructor for creating new Csv objects.
    public Csv(String filename) throws FileNotFoundException, IOException {
	this.filename = filename;

	// Create the rows
	rows = new ArrayList<ArrayList<String>>();
	
	// Create a file reader for the file:
	FileReader fr = new FileReader(filename);

	// Create the buffered reader:
	BufferedReader br = new BufferedReader(fr);

	// Iterate over the lines creating list of list of strings:
	String line = null;
	while ((line = br.readLine()) != null) {
	    ArrayList<String> c = new ArrayList<String>(Arrays.asList(line.split(",")));
	    for (int i = 0; i < c.size(); i++) {
		c.set(i, c.get(i).trim());
	    }
	    rows.add(c);
	}
    }

    // A private constructor that allows us to create a new Csv object
    // from a filename and a list of rows.
    private Csv(String filename, ArrayList<ArrayList<String>> rows) {
	this.rows = lines;
	this.filename = filename;
    }

    // getFileName returns the name of the file:
    public String getFileName() {
	return filename;
    }

    // This implements the iterator method from the Iterable
    // interface. It returns an Iterator to be used with Java's
    // enhanced for-loop.
    public Iterator<List<String>> iterator() {
	// We want to return a new list that is not the same as the
	// one that this object holds. Why would we want to do that?
	ArrayList<List<String>> copy = new ArrayList<List<String>>();
	for (ArrayList<String> line : rows) {
	    // We use the Object.close method to copy the list.
	    copy.add((ArrayList)line.clone());
	}
	// Return the copies iterator:
	return copy.iterator();
    }

    // reverse returns a new Csv object that is the reverse of this one:
    public Csv reverse() {
	// We want to return a new list that is not the same as the
	// one that this object holds. Why would we want to do that?
	ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	for (ArrayList<String> line : rows) {
	    // We use the Object.close method to copy the list.
	    ArrayList<String> copy = (ArrayList) line.clone();
	    // Add it to the beginning of the list:
	    list.add(0, copy);
	}

	// Return a new Csv object using our private constructor:
	return new Csv(filename, list);
    }
}
