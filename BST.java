public class BST<T> implements BinarySearch<T>
{
	private BSTNode<T> root;

	public BST()
	{
		root = null;
	}

	public boolean find(Comparable target)
	{
		return(find(target, root));
	}

	public boolean find(Comparable target, BSTNode node)
	{
		if(node == null)
			return(false);
		if(target.compareTo(node.data) == 0)
			return(true);
		else if(target.compareTo(node.data) > 0)
			return(find(target, node.right));
		else
			return(find(target, node.left));
	}

	public BSTNode insert(Comparable item, BSTNode node)
	{
		if(node == null)
		{
			node = new BSTNode(item);
			return(node);
		}
		else if(item.compareTo(node.data) > 0)
		{
			node.right = insert(item, node.right);
		}
		else if(item.compareTo(node.data) < 0)
		{
			node.left = insert(item, node.left);
		}
		return(node);
	}

	public void insert(Comparable item)
	{
		root = insert(item, root);
	}

	public void delete(Comparable item)
	{
		root = delete(root, item);
	}
	public BSTNode delete(BSTNode node, Comparable item)
	{
		if(node == null)
			return(null);
		if(item.compareTo(node.data) == 0)
		{
			if(node.left == null)
				return(node.right);
			else if(node.right == null)
				return(node.left);
			else if(node.right.left == null)
			{
				node.data = node.right.data;
				node.right = node.right.right;
				return node;
			}
			else{
				node.data = removeSmallest(node.right);
				return(node);
			}
		}
		if(item.compareTo(node.data) > 0){
			node.right = delete(node.right, item);
			return(node);
		}
		else{
			node.left = delete(node.left, item);
			return(node);
		}

	}

	public Comparable removeSmallest(BSTNode node)
	{
		if(node.left.left == null) {
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return(smallest);
		}
		return(removeSmallest(node.left));
	}

	public void print()
	{
		print(root);
	}
	public void print(BSTNode node)
	{
		//This goes throughout the whole tree, using the "In-Order" way of traversing
		if(node != null) 
		{
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}






}