import java.util.Queue;
import java.util.LinkedList;

class Node
{
	public int data;
	public Node left, right;
		
	Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree
{
	int index = -1;
	public Node buildTree(int[] Nodes)
	{
		this.index++;
		
		if(Nodes[this.index] == -1)
			return null;
		
		Node newNode = new Node(Nodes[this.index]);
		
		newNode.left = buildTree(Nodes);
		newNode.right = buildTree(Nodes);
		
		return newNode;
	}
	
	public void preorderTransversal(Node root)
	{
		if(root == null)
		{
			System.out.print(" . ");
			return;
		}
		
		System.out.print(root.data + " ");
		preorderTransversal(root.left);
		preorderTransversal(root.right);
	}
	
	public void inorderTransversal(Node root)
	{
		if(root == null)
		{
			System.out.print(" . ");
			return;
		}
		
		inorderTransversal(root.left);
		System.out.print(root.data + " ");
		inorderTransversal(root.right);
	}
	
	public void postorderTransversal(Node root)
	{
		if(root == null)
		{
			System.out.print(" . ");
			return;
		}
		
		postorderTransversal(root.left);
		postorderTransversal(root.right);
		System.out.print(root.data + " ");
	}
	
	public void levelOrderTransversal(Node root)
	{
		if(root == null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node currNode = q.remove();
			
			if(currNode == null)
			{
				System.out.println();
				
				if(q.isEmpty())
					break;
				else
					q.add(null);
			}
			
			else
			{
				System.out.print(currNode.data + " ");
				
				if(currNode.left != null)
					q.add(currNode.left);
				if(currNode.right != null)
					q.add(currNode.right);
			}
		}
	}
}

public class Main
{
	public static void main(String[] args)
	{
		int[] nodes = {9, 1, 4, 7, -1, -1, -1, 3, 3, -1, 2, -1, -1, 3, -1, -1, 6, 2, -1, 2, -1, -1, 1, -1, 1, 2, -1, -1, 7, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		
		tree.preorderTransversal(root);
		System.out.println();
		tree.inorderTransversal(root);
		System.out.println();
		tree.postorderTransversal(root);
		System.out.println();
		System.out.println();
		tree.levelOrderTransversal(root);
	}
}
