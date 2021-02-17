package structures;

import java.util.Comparator;

public class BinarySearchTree<T> {
	
	private NodeBinarySearchTree<T> root;
	private Comparator<T> comparator;
	
	public BinarySearchTree(Comparator<T> comparator) {
		this.root=null;
		this.comparator=comparator;
	}
	
	public void insert(T data) {
		NodeBinarySearchTree<T> newNode=new NodeBinarySearchTree<T>(data);
		NodeBinarySearchTree<T> aux=root;
		if(isEmpty()==true) {
			root=newNode;
		}else {
			boolean added=false;
			while(added==false) {
				if(comparator.compare(data, aux.getData())>0) {
					if(aux.getNodeRight()==null) {
						aux.setNodeRight(newNode);
						added=true;
					}else {
						aux=aux.getNodeRight();
					}
				}else if(comparator.compare(data, aux.getData())<0) {
					if(aux.getNodeLeft()==null) {
						aux.setNodeLeft(newNode);
						added=true;
					}else {
						aux=aux.getNodeLeft();
					}
				}
			}	
		}
	}
	
	public boolean isEmpty() {
		if(root==null) {
			return true;
		}else {
			return false;
		}
	}

	public boolean exist(T data) {
		boolean result=false;
		NodeBinarySearchTree<T> aux=root;
		while(aux!=null) {
			if(comparator.compare(data, aux.getData())==0) {
				return true;
			}else if(comparator.compare(data, aux.getData())>0) {	
				aux=aux.getNodeRight();
			}else if(comparator.compare(data, aux.getData())<0) {
				aux=aux.getNodeLeft();
			}			
		}
		return result;
	}
	
	@SuppressWarnings("null")
	public T searchData(T data) {
		NodeBinarySearchTree<T> aux=root;
		if(this.exist(data)) {
			while(aux!=null) {
				if(comparator.compare(data, aux.getData())==0) {
					return aux.getData();
				}else if(comparator.compare(data, aux.getData())>0) {	
					aux=aux.getNodeRight();
				}else if(comparator.compare(data, aux.getData())<0) {
					aux=aux.getNodeLeft();
				}
			}
			return aux.getData();
		}else {
			return null;
		}
	}
	
	public NodeBinarySearchTree<T> getRoot() {
		return root;
	}
	
	public NodeBinarySearchTree<T> getNodeLeft(NodeBinarySearchTree<T> node) {
		return node.getNodeLeft();
	}
	
	public NodeBinarySearchTree<T> getNodeRight(NodeBinarySearchTree<T> node) {
		return node.getNodeRight();
	}
	
	public int size(NodeBinarySearchTree<T> node) {
		int count=0;
		if(isEmpty()==true) {
			count=0;
		}else {
			count=1;
		}
		if(node.getNodeLeft() != null) {
			count+=this.size(node.getNodeLeft());
		}
		if(node.getNodeRight() != null) {
			count+=this.size(node.getNodeRight());
		}
		return count;
	}
	
	public void show(NodeBinarySearchTree<T> node) {
		System.out.println(node.getData());
		if(node.getNodeLeft() != null) {
			this.show(node.getNodeLeft());
		}
		if(node.getNodeRight() != null) {
			this.show(node.getNodeRight());
		}
	}

}
