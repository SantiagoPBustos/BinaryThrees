package structures;

public class NodeBinarySearchTree<T> {
	
	private T data;
	private NodeBinarySearchTree<T> nodeLeft;
	private NodeBinarySearchTree<T> nodeRight;

	public NodeBinarySearchTree(T data) {
		this.data=data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeBinarySearchTree<T> getNodeLeft() {
		return nodeLeft;
	}

	public void setNodeLeft(NodeBinarySearchTree<T> nodeLeft) {
		this.nodeLeft = nodeLeft;
	}

	public NodeBinarySearchTree<T> getNodeRight() {
		return nodeRight;
	}

	public void setNodeRight(NodeBinarySearchTree<T> nodeRight) {
		this.nodeRight = nodeRight;
	}
	
}
