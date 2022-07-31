package ga2;


class Node
{
	int node;
	Node left, right;
	
	public Node(int node)
	{
		this.node = node;
	}
	public Node()
	{
		
	}
}
public class BinarySearchTreeToSkewedTree {


	static BinarySearchTreeToSkewedTree bsts = new BinarySearchTreeToSkewedTree();
	static Node output = null;
	static Node NewNode(int node)
	{
		Node temp = new Node();
		temp.node = node;
		temp.left =null;
		temp.right = null;
		return temp;
		
	}
	
	public Node Insert(Node root,int  key)
	{
		if(root ==null)
			return NewNode(key);
		if(key<root.node)
			root.left=Insert(root.left,key);
		else
			root.right=Insert(root.right,key);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node  root =null;
		root = bsts.Insert(root, 50);
		root = bsts.Insert(root, 30);
		root = bsts.Insert(root, 60);
		root = bsts.Insert(root, 10);
		root = bsts.Insert(root, 55);
		
		 Iterate(root);
		 boolean isFirst=true;
		while(true)
		{
			if(isFirst)
			{
				System.out.print(" ");
			}
			System.out.print(output.node);
			if(output.right==null)
			{
				break;
			}
			output = output.right;
		}
	}
	
	public static void Iterate(Node root)
	{
		if(root.left!=null)
		{
			Iterate(root.left);
		}
			output = bsts.Insert(output, root.node);
			if(root.right!=null)
			{
				Iterate(root.right);
			}
	}

}
