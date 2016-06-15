import java.util.LinkedList;
public class BST<Key extends Comparable<Key>, Value>{

    public static void main(String[] args){
        BST<Integer, String> bst = new BST<>();
        System.out.println(bst.isEmpty());
        System.out.println(bst.get(5));
        bst.put(10, "Chowchow");
        System.out.println(bst.root.N);
        System.out.println(bst.rank(10));
        bst.put(5, "Husky");
        bst.put(15, "Alaska");
        System.out.println(bst.root.N);
        System.out.println(bst.root.left.N);
        System.out.println(bst.root.right.N);
        System.out.println(bst.rank(16));
        Iterable<Integer> bstIterator = bst.iterator();
        for (Integer i: bstIterator){
            System.out.println(i);
        }

    }

    public class TreeNodeAlgs4{
        public Key key;
        public Value val;
        public int N;
        public TreeNodeAlgs4 left, right;
        public TreeNodeAlgs4(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    public TreeNodeAlgs4 root;

    public boolean isEmpty(){
        return size(root) == 0;
    }

    public int size(TreeNodeAlgs4 node){
        if (node == null){
            return 0;
        }
        return node.N;
    }

    public Value get(Key key){
        TreeNodeAlgs4 x = this.root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else if(cmp > 0){
                x = x.right;
            }else{
                return x.val;
            }
        }
        return null;
    }


    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    private TreeNodeAlgs4 put(TreeNodeAlgs4 x, Key key, Value val){
        if (x == null){
            return new TreeNodeAlgs4(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = put(x.left, key, val);
        }else if (cmp > 0){
            x.right = put(x.right, key, val);
        }else{
            x.val = val;
        }
        x.N++;
        return x;
    }

    public Key floor(Key key){
        TreeNodeAlgs4 x = floor(this.root, key);
        if (x == null){
            return null;
        }
        return x.key;
    }

    private TreeNodeAlgs4 floor(TreeNodeAlgs4 x, Key key){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return x;
        }else if (cmp < 0){
            return floor(x.left, key);
        }else{
            TreeNodeAlgs4 y = floor(x.right, key);
            if (y != null){
                return y;
            }else{
                return x;
            }
        }
    }

    public Key ceiling(Key key){
        TreeNodeAlgs4 x = ceiling(this.root, key);
        if (x == null){
            return null;
        }
        return x.key;
    }

    private TreeNodeAlgs4 ceiling(TreeNodeAlgs4 x, Key key){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return x;
        }else if(cmp > 0){
            return ceiling(x.right, key);
        }else{
            TreeNodeAlgs4 y = ceiling(x.left, key);
            if (y != null){
                return y;
            }else{
                return x;
            }
        }
    }

    public int rank(Key key){
        return rank(this.root, key);
    }

    private int rank(TreeNodeAlgs4 x, Key key){
        if (x == null){
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return size(x.left);
        }else if (cmp < 0){
            return rank(x.left, key);
        }else{
            return 1 + size(x.left) + rank(x.right, key);
        }
    }

    public void delete(Key key){

    }

    public Iterable<Key> iterator(){
        LinkedList<Key> q = new LinkedList<Key>();
        // inorder(root, q);
        // preorder(root, q);
        postorder(root, q);
        return q;
    }

    private void inorder(TreeNodeAlgs4 x, LinkedList<Key> q){
        if (x == null){
            return;
        }
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    private void preorder(TreeNodeAlgs4 x, LinkedList<Key> q){
        if (x == null){
            return;
        }
        q.add(x.key);
        preorder(x.left, q);
        preorder(x.right, q);
    }

    private void postorder(TreeNodeAlgs4 x, LinkedList<Key> q){
        if (x == null){
            return;
        }
        preorder(x.left, q);
        preorder(x.right, q);
        q.add(x.key);
    }
}
