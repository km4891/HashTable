public class Tree {
    public Node root; // first node of tree
	

    public Tree() {// constructor
		root = null; } // no nodes in tree yet

        public Node find(int key) { // find node with given key
	// (assumes non-empty tree)
		Node current = root; // start at root
		while(current.data != key) // while no match,
		{
			if(key < current.data) // go left?
				current = current.leftChild;
			else // or go right?
				current = current.rightChild;
			if(current == null) // if no child,
				return null; // didn't find it
		}
		return current; // found it
	} // end find()

    public void insert(int id) {
		Node newNode = new Node(); // make new node
		newNode.data = id; // insert data
		if(root==null) // no node in root
			root = newNode;
		else // root occupied
		{
			Node current = root; 
			Node parent;
			while(true) 
			{
				parent = current;
				if(id < current.data) // go left?
				{
					current = current.leftChild;
					if(current == null) // if end of the line,
					{ // insert on left
						parent.leftChild = newNode;
						return;
					}
				} // end if go left
				else // or go right?
				{
					current = current.rightChild;
					if(current == null) 
					{ // insert on right
						parent.rightChild = newNode;
						return;
					}
				} 
			} 
		} 
	} 

}
