package velog.reachtherecord.codingjava.search;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class BFS {

    /**
     * Breadth First Search - 너비 우선 탐색
     * Queue로 구현
     * DFS와 마찬가지로 시작 노드를 Queue에 담고 시작한다.
     * 노드를 하나 Queue에서 꺼내고 ChildNode를 Queue에 담는다.
     * Queue에 한번 담았던 노드는 다시 담지 않는다.
     * 꺼낸 노드는 출력
     * Queue가 비었을 때, 순회가 완료된다.
     */
    class Graph {
        class Node {
            int data;
            LinkedList<Node> adjacent;
            boolean marked;
            Node(int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<Node>();
            }
        }

        Node[] nodes;
        Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];

            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        void dfs() {
            dfs(0);
        }

        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            root.marked = true;
            while (!stack.isEmpty()) {
                Node r = stack.pop();
                for (Node n : r.adjacent) {
                    if (n.marked == false) {
                        n.marked = true;
                        stack.push(n);
                    }
                }
                visit(r);
            }
        }

        void visit(Node n) {
            System.out.print(n + " ");
        }
    }

    class Stack<T> {
        class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }
        private Node<T> top;

        public T pop() {
            if (top == null) {
                throw new EmptyStackException();
            }
            T item = top.data;
            top = top.next;

            return item;
        }

        public void push(T item) {
            Node<T> t = new Node<T>(item);
            t.next = top;
            top = t;
        }

        public T peek() {
            if (top == null) {
                throw new EmptyStackException();
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }
}
