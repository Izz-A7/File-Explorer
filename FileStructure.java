import java.util.*;

public class FileStructure {
	// Creating instance variable
	private NLNode<FileObject> root;
	
	public FileStructure (String fileObjectName) throws FileObjectException {
		// Calling helper method to create the file structure
		root = this.createFileStructure(fileObjectName, null);
	}
	
	// Creating private helper method to create the file structure
	private NLNode<FileObject> createFileStructure (String fileObjectName, NLNode<FileObject> parent) throws FileObjectException{
		// Creating new file object and node
		FileObject fileObject =  new FileObject(fileObjectName);
		NLNode<FileObject> node = new NLNode<FileObject>(fileObject, parent);
		
		// If the file object is a file we return it right away
		if (fileObject.isFile())
			return node;
		
		// Iterate over the files in the directory
		for (Iterator<FileObject> i = fileObject.directoryFiles(); i.hasNext(); ) {
			// Getting the next file object
			FileObject f = i.next();
			
			// Creating new node to represent the child file (parent passed as second argument to the createFileStructure method)
			NLNode<FileObject> child = createFileStructure(fileObject.getLongName() + "/" + f.getName(), node);
			node.addChild(child);
		}
		
		return node; // Return node
	}
	
	// Method to get root
	public NLNode<FileObject> getRoot() {
		return root; // Return root
	}
	
	// Method to return the names of all the files of the specified type
	public Iterator<String> filesOfType (String type) {
		// Creating new array list to hold the names 
		ArrayList<String> i = new ArrayList<String>();
		
		// Calling the addToIteratorByType helper method
		addToIteratorByType(type, root, i);
		
		return i.iterator(); // Returning an iterator over the array list of the file object names
	}
	
	// Private helper method to add to the iterator by type
	private void addToIteratorByType (String type, NLNode<FileObject> node, ArrayList<String> i) {
		// Setting f equal to the current node data
		FileObject f = node.getData();
		
		// If f is a file and its name ends with the specified type we add its long name
		if (f.isFile() && f.getName().endsWith(type)) {
			i.add(f.getLongName());
		} 
		
		else { // Otherwise, iterate over the nodes children and search for a file with the specified type recursively
			for (Iterator<NLNode<FileObject>> children = node.getChildren(); children.hasNext(); ) {
				addToIteratorByType(type, children.next(), i);
			}
		}
	}
	
	// Method to look for a file with a specific name
	public String findFile(String name) {
		// Calling on the helper method
		return findFileByName(name, root);
	}
	
	// Private helper method to find a file by the name (very similar concept to the previous helper method)
	private String findFileByName (String fileName, NLNode<FileObject> node) {
		// Setting f equal to the current node data
		FileObject f = node.getData();
		
		// If f is a file and the name equals the specified name we return its long name
		if (f.isFile() && (f.getName().equals(fileName))) {
			return f.getLongName();
		} 
		
		else { // Otherwise, we iterate over the nodes children and search for a file with the specified name
			for (Iterator<NLNode<FileObject>> children = node.getChildren(); children.hasNext(); ) {
				// Calling the findFileByName method recursively on each of the child nodes
				String result = findFileByName(fileName, children.next());
				
				if (result != "") {// If the result is not an empty string we return it
					return result;
				}
			}
		}
		
		return ""; // Return empty string if we get to here
	}
}
