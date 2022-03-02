package task5;

public class SinglyLinkedList {

	private Node head;

	private static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();

		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);

		linkedList.head.next.next.next.next = linkedList.head;
		System.out.println("Loop detected "+linkedList.detectLoop());
	}

	private void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	private boolean detectLoop() {
		
		Node slowP = head;
		Node fastP = head;
		while (slowP != null && fastP != null && fastP.next != null) {
			slowP = slowP.next;
			fastP = fastP.next.next;
			if (slowP == fastP) {
				return true;
			}
		}
		return false;
	}

}
