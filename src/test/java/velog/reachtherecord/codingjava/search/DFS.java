package velog.reachtherecord.codingjava.search;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DFS {

    /**
     * Depth First Search - 깊이 우선 탐색
     * Stack을 하나 만들고 시작 노드를 넣은 후 시작
     * 스택에서 하나 출력하여 해당 노드의 ChildNode를 담는다.
     * ChildNode를 스택에 담는데, 한번 담았던 노드는 다시 담지 않는다.
     * 꺼낸 노드는 출력한다.
     * Stack이 완전히 비었을 때, 순회가 완료된다.
     * 재귀함수로 코드를 간결하게 만들 수 있음
     * DFS : Recursion
     */
    class Graph {
        class Node {
            int data;
            LinkedList<Node> adjacent;
            boolean marked;

            Node(int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();
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
            Queue<Node> queue = new Queue<>();
            queue.add(root);
            root.marked = true;

            while (!queue.isEmpty()) {
                Node r = queue.remove();
                for (Node n : r.adjacent) {
                    if (n.marked == false) {
                        n.marked = true;
                        queue.add(n);
                    }
                }

                visit(r);
            }
        }

        void dfsR(Node r) {
            if (r == null) return;
            r.marked = true;
            visit(r);

            for (Node n : r.adjacent) {
                dfsR(n);
            }
        }

        void dfsR(int index) {
            Node r = nodes[index];
            dfsR(r);
        }

        void dfsR() {
            dfsR(0);
        }

        void visit(Node n) {
            System.out.print(n + " ");
        }
    }


    class Queue<T> {
        class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }

        private Node<T> first;
        private Node<T> last;

        public void add(T item) {
            Node<T> t = new Node<T>(item);

            if (last != null) {
                last.next = t;
            }
            last = t;
            if (first == null) {
                first = last;
            }
        }

        public T remove() {
            if (first == null) {
                throw new NoSuchElementException();
            }

            T data = first.data;
            first = first.next;

            if (first == null) {
                last = null;
            }
            return data;
        }

        public T peek() {
            if (first == null) {
                throw new NoSuchElementException();
            }
            return first.data;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }
}