public class MyLinkedList {
  public static class Node {
    int value;
    Node next;

    Node(int val) {
      this.value = val;
    }
  }

  public static void printLinkedList(Node head) {
    if (head == null) {
      System.out.println("empty List");
    } else {
      Node tmp = head;
      while (tmp != null) {
        System.out.print(tmp.value);
        tmp = tmp.next;
        if (tmp != null)
          System.out.print("->");
        else
          System.out.println();
      }
    }
  }

  public static Node add2head(Node head, int val) {
    Node newNode = new Node(val);
    if (head != null)
      newNode.next = head;
    return newNode;
  }

  public static Node add2tail(Node head, int val) {
    Node newNode = new Node(val);
    if (head == null)
      return newNode;

    Node tmp = head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tmp.next = newNode;
    return head;
  }

  public static Node add2idx(Node head, int idx, int val) {
    if (head == null || idx < 0) return null;
    if (idx == 0) return add2head(head, val);
    Node newNode = new Node(val);
    Node prevNode = null;
    Node currNode = head;
    int i = 0;
    while (i < idx && currNode.next != null) {
      i++;
      prevNode = currNode;
      currNode = currNode.next;
    }
    if (i == idx) {
      newNode.next = currNode;
      prevNode.next = newNode;
    } else
      System.out.println("This element dont exist");
    return head;
  }

  public static Node removeHead(Node head) {
    if (head != null) {
      return head.next;
    } else
      return head;

  }

  public static Node removeTail(Node head) {
    if (head == null) return null;

    Node lastNode = head;
    Node prevNode = null;
    while (lastNode.next != null) {
      prevNode = lastNode;
      lastNode = lastNode.next;
    }
    prevNode.next = null;
    return head;
  }

  public static Node removeAtIdx(Node head, int idx) {
    if (head == null || idx < 0) return null;
    if (idx == 0) return removeHead(head);

    Node prevNode = null;
    Node currNode = head;
    int i = 0;
    while (i < idx && currNode.next != null) {
      i++;
      prevNode = currNode;
      currNode = currNode.next;
    }
    if (i == idx)
      prevNode.next = currNode.next;
    else
      System.out.println("This element dont exist");
    return head;
  }

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    Node n0 = add2head(n1, 0);
    Node n0de = add2tail(n0, 5);
    n0de = add2idx(n0, 1, 9);
    printLinkedList(n0de);
    n0de = add2idx(n0, 6, 10);
    printLinkedList(n0de);
    n0de = removeTail(n0);
    printLinkedList(n0de);
    n0de = removeAtIdx(n0, 5);
    printLinkedList(n0de);
  }
}
