import java.util.Comparator;
import java.util.Iterator;

public class NLNode<T> {
	// Creating instance variables parent, children, and data
	private NLNode<T> parent;
	private ListNodes<NLNode<T>> children;
	private T data;
	
	// Constructor #1
	public NLNode() {
		// Setting parent and data to null
		parent = null;
		data = null;
		// Initializing children to an empty object
		children = new ListNodes<>();
	}
	
	// Constructor #2
	public NLNode (T d, NLNode<T> p) {
		// Initializing children to an empty object
		children = new ListNodes<>();
		// Setting data to d and parent to p
		data = d;
		parent = p; 
	}
	
	// Sets parent to p
	public void setParent(NLNode<T> p) {
		parent = p;
	}
	
	// Returning parent
	public NLNode<T> getParent() {
		return parent;
	}
	
	// Adds given node to the list of children
	public void addChild(NLNode<T> newChild) {
		newChild.setParent(this);
		children.add(newChild);
	}
	
	// Returns the children
	public Iterator<NLNode<T>> getChildren() {
		return children.getList();
	}
	
	// Returns the children in the order of the specified sorter
	public Iterator<NLNode<T>> getChildren(Comparator<NLNode<T>> sorter) {
		return children.sortedList(sorter);
	}
	
	// Returns data
	public T getData() {
		return data;
	}
	
	// Sets data to d 
	public void setData(T d) {
		data = d;
	}
}
