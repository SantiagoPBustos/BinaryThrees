package structures;

import java.util.Comparator;

public class BinarySearchTree<T> {
	
	private NodeBinarySearchTree<T> root;
	private Comparator<T> comparator;
	
	public BinarySearchTree(Comparator<T> comparator) {
		this.root=null;
		this.comparator=comparator;
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
	
	public void delete(T data)throws Exception{
		root=deleteNode(root,data);
	}
	
	private NodeBinarySearchTree<T> deleteNode(NodeBinarySearchTree<T> node, T data) throws Exception {
		if(node==null) {
		    throw new Exception("Nodo no encontrado");
		}else {
			if(comparator.compare(data, node.getData())>0) {
				NodeBinarySearchTree<T> right=deleteNode(node.getNodeRight(), data);
				node.setNodeRight(right);
			}else {
				if(comparator.compare(data, node.getData())<0) {
					NodeBinarySearchTree<T> left=deleteNode(node.getNodeLeft(), data);
					node.setNodeLeft(left);
				}else {
					NodeBinarySearchTree<T> aux=node;
					if(aux.getNodeLeft()==null) {
						node=aux.getNodeRight();
					}else {
						if(aux.getNodeRight()==null) {
							node=aux.getNodeLeft();
						}else {
							aux=replace(aux);
						}
					}
					return null;
				}
			}
		}
		return node;
	}

	private NodeBinarySearchTree<T> replace(NodeBinarySearchTree<T> actual) {
		NodeBinarySearchTree<T> a,p;
		p=actual;
		a=actual.getNodeLeft();
		while (a.getNodeRight()!=null){
		    p=a;
		    a=a.getNodeRight();
		}
		actual.setData(a.getData());
		if (p==actual) {
		    p.setNodeLeft(a.getNodeLeft());
		}else {
		    p.setNodeRight(a.getNodeLeft());
		}
		return null;
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
	
	public String show(NodeBinarySearchTree<T> node) {
		String result="";
		result+=node.getData().toString();
		if(node.getNodeLeft() != null) {
			result+="\n"+this.show(node.getNodeLeft());
		}
		if(node.getNodeRight() != null) {
			result+="\n"+this.show(node.getNodeRight());
		}
		return result; 
	}
}
