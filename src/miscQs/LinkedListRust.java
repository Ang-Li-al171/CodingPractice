package miscQs;

import java.util.*;

/**
 * from CodeRust linkedlist problems
 * @author angli
 *
 */
public class LinkedListRust {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		Node h = null;
		Node curr = h;
		while(n-->0){
			if(h==null){
				h = new Node(in.nextInt());
				curr = h;
			} else {
				curr.next = new Node(in.nextInt());
				curr = curr.next;
			}
		}
		printList(h);
		
		printList(mergeSort(h));
	}
	
	
	private static Node mergeSort(Node n){
		if(n==null || n.next==null) return n;
		Node[] first_second = splitInHalf(n);
		Node firstHalf = mergeSort(first_second[0]);
		Node secondHalf = mergeSort(first_second[1]);
		return merge(firstHalf, secondHalf);
	}
	
	private static Node[] splitInHalf(Node h){
		Node[] ret = new Node[2];
		int l = findLength(h);
		int cnt = 0;
		Node ori = h;
		while(cnt<l/2-1){
			cnt++;
			h=h.next;
		}
		ret[1]=h.next;
		h.next = null;
		ret[0]=ori;
		return ret;
	}
	
	private static Node merge(Node first, Node second){
		Node h = null;
		Node curr = h;
		while(first!=null && second!=null){
			Node chosen = null;
			if(first.v <= second.v){
				chosen=first;
				first=first.next;
			}else{
				chosen=second;
				second=second.next;
			}
			if(h==null){
				h = chosen;
				curr = h;
				curr.next = null;
			}else{
				curr.next = chosen;
				curr.next.next = null;
				curr = curr.next;
			}
		}
		if(first!=null){
			curr.next = first;
		}else if(second!=null){
			curr.next = second;
		}
		return h;
	}
	
	
	private static Node intersection(Node l1, Node l2){
		int len1=findLength(l1);
		int len2=findLength(l2);
		if(len1>len2){
			int diff = len1-len2;
			while(diff-->0){
				l1=l1.next;
			}
		} else {
			int diff = len2-len1;
			while(diff-->0){
				l2=l2.next;
			}
		}
		while(l1!=null && l2!=null){
			if(l1 == l2) return l1;
			l1=l1.next;
			l2=l2.next;
		}
		return null;
	}
	
	private static int findLength(Node h){
		int l = 0;
		while(h!=null){
			l++;
			h=h.next;
		}
		return l;
	}
	
	
	private static Node insertionSort(Node n){
		Node h = null;
		while(n!=null){
			Node next = n.next;
			if(h==null){
				h = n;
				h.next = null;
			}
			else{
				h = insertIntoList(h, n);
			}
			n=next;
		}
		return h;
	}
	
	private static Node insertIntoList(Node h, Node n){
		if(n.v <= h.v){
			n.next = h;
			return n;
		}
		Node prev = h;
		Node curr = h.next;
		while(curr!=null){
			if(n.v <= curr.v){
				prev.next = n;
				n.next = curr;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		if(curr==null){
			prev.next = n;
			prev.next.next = null;
		}
		return h;
	}
	
	
	private static NodeWith2Ptr deepCopy(NodeWith2Ptr n){
		HashMap<NodeWith2Ptr, NodeWith2Ptr> m = new HashMap<NodeWith2Ptr, NodeWith2Ptr>();
		NodeWith2Ptr h = null;
		NodeWith2Ptr curr = h;
		while(n!=null){
			if(h==null){
				h = new NodeWith2Ptr(n.v);
				h.arbitrary = n.arbitrary;
				curr = h;
			} else {
				curr.next = new NodeWith2Ptr(n.v);
				curr.next.arbitrary = n.arbitrary;
				curr = curr.next;
			}
			m.put(n, curr);
			n=n.next;
		}
		curr = h;
		while(curr!=null){
			curr.arbitrary = m.get(curr.arbitrary);
			curr = curr.next;
		}
		return h;
	}
	
	
	private static Node addInteger(Node int1, Node int2){
		int carry = 0;
		Node newh = null;
		Node curr = newh;
		while(int1!=null && int2!=null){
			if(newh==null){
				newh=new Node((int1.v+int2.v+carry)%10);
				newh.next = null;
				curr = newh;
			}else {
				curr.next = new Node((int1.v+int2.v+carry)%10);
				curr = curr.next;
				curr.next = null;
			}
			carry = (int1.v+int2.v+carry)/10;
			int1=int1.next;
			int2=int2.next;
		}
		while(int1!=null){
			curr.next = new Node((int1.v+carry)%10);
			curr = curr.next;
			curr.next = null;
			carry = (int1.v+carry)/10;
			int1=int1.next;
		}
		while(int2!=null){
			curr.next = new Node((int2.v+carry)%10);
			curr = curr.next;
			curr.next = null;
			carry = (int2.v+carry)/10;
			int2=int2.next;
		}
		return newh;
	}
	
	
	private static Node deleteNode(Node h, int value){
		if(h==null) return null;
		if(h.v==value) return h.next;
		Node curr = h.next;
		Node prev = h;
		while(curr!=null){
			if(curr.v == value){
				prev.next = curr.next;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		return h;
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

	
	private static void printList(Node h){
		while(h != null){
			System.out.printf("%d ", h.v);
			h = h.next;
		}
		System.out.println();
	}
	
	
	private static void printList(NodeWith2Ptr h){
		while(h != null){
			System.out.printf("Node.v: %d, Node.arbitrary: %d\n", h.v, h.arbitrary.v);
			h = h.next;
		}
		System.out.println();
	}
	
	
	private static class Node{
		int v;
		Node next;
		public Node(int v){
			this.v = v;
		}
	}
	
	
	private static class NodeWith2Ptr{
		int v;
		NodeWith2Ptr next;
		NodeWith2Ptr arbitrary;
		public NodeWith2Ptr(int v){
			this.v = v;
		}
	}
}
