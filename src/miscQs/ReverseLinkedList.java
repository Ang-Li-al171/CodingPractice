package miscQs;

import java.util.Scanner;

public class ReverseLinkedList {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		Node h = new Node(0);
		Node curr = h;
		int n =in.nextInt();
		while(n-->0){
			curr.next = new Node(in.nextInt());
			curr = curr.next;
		}
		curr.next = null;
		curr = h.next;
		System.out.printf("%d ", curr.v);
		while(curr.next != null){
			System.out.printf("%d ", curr.next.v);
			curr = curr.next;
		}
		System.out.println();
		
		curr = h.next;
		Node newh = reverseLinkedList(curr);
		while(newh != null){
			System.out.printf("%d ", newh.v);
			newh = newh.next;
		}
	}
	
	private static Node reverseLinkedList(Node n){
		if(n==null) return null;
		
		Node prev = null;
		while(n.next!=null){
			Node temp = n.next;
			n.next = prev;
			prev = n;
			n = temp;
		}
		n.next = prev;
		return n;
	}
	
	private static class Node{
		int v;
		Node next;
		public Node(int v){
			this.v = v;
		}
	}
}
