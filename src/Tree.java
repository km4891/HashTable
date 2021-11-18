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

    public boolean delete(int key) // delete node with given key
	{ // (assumes non-empty list)
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while(current.data != key) // search for node
		{
			parent = current;
			if(key < current.data) // go left?
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else // or go right?
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) // end of the line,
				return false; // didn't find it
		} // end while
		// found node to delete
		// if no children, simply delete it
		if(current.leftChild==null &&
				current.rightChild==null) {
			if(current == root) // if root,
				root = null; // tree is empty
			else if(isLeftChild)
				parent.leftChild = null; // disconnect
			else // from parent
				parent.rightChild = null;
		}
		// if no right child, replace with left subtree
		else if(current.rightChild==null)
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		// if no left child, replace with right subtree
		else if(current.leftChild==null)
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		else // two children, so replace with inorder successor
		{
			// get successor of node to delete (current)
			Node successor = getSuccessor(current);
			// connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			// connect successor to current's left child
			successor.leftChild = current.leftChild;
		} // end else two children
		// (successor cannot have a left child)
		return true; // success
	} // end delete()

    private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while(current != null) // until no more
		{ // left children,
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		// if successor not
		if(successor != delNode.rightChild) // right child,
		{ // make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

    private void inOrder(Node localRoot) {
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.rightChild);
		}
	}
}
