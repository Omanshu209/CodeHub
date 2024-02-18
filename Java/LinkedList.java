class linkedList
{
	Node head = null;
	int size = 0;
	
	private class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
			this.next = null;
			size++;
		}
	}
	
	public boolean isEmpty()
	{
		return head == null; //return size == 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public void printLL()
	{
		Node currNode = head;
		
		while(currNode != null)
		{
			System.out.print(currNode.data + " -> ");
			currNode = currNode.next;
		}
		
		System.out.println("null");
	}
	
	public void addFirst(int data)
	{
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		
		if(isEmpty())
		{
			head = newNode;
			return;
		}
		
		Node currNode = head;
		
		while(currNode.next != null)
			currNode = currNode.next;
		
		currNode.next = newNode;
	}
	
	public void removeFirst()
	{
		if(isEmpty())
			return;
		
		head = head.next;
		size--;
	}
	
	public void removeLast()
	{
		if(isEmpty())
			return;
		
		size--;
		
		if(head.next == null)
		{
			head = null;
			return;
		}
		
		Node currNode = head;
		Node nextNode = head.next;
		
		while(nextNode.next != null)
		{
			currNode = currNode.next;
			nextNode = nextNode.next;
		}
		
		currNode.next = null;
	}
}

public class Main
{
	public static void main(String[] args)
	{
		/*
		linkedList ll = new linkedList();
		
		ll.addLast(45);
		ll.printLL();
		
		ll.addLast(76);
		ll.addFirst(34);
		ll.printLL();
		
		ll.removeFirst();
		ll.printLL();
		
		ll.addFirst(54);
		ll.removeLast();
		ll.printLL();
		*/
	}
}
