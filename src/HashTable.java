public class HashTable {
    
    private Tree[] treeArray;
	private int size;
	
	
	public HashTable(int sizeIn) { // constructor
		size = sizeIn;
		treeArray = new Tree[size];
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println(i+". ");
			treeArray[i].displayTree();
}
