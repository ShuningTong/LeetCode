import java.util.LinkedList;

public class RedBlackBST<Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class RedBlackNode{
        public Key key;
        public Value val;
        public int N;
        public RedBlackNode left, right;
        public boolean color;
        public RedBlackNode(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    public RedBlackNode root;

    public boolean isEmpty(){
        return size(root) == 0;
    }

    public int size(RedBlackNode node){
        if (node == null){
            return 0;
        }
        return node.N;
    }

    public boolean isRed(RedBlackNode x){
        if (x == null){
            return false;
        }
        return x.color == RED;
    }

    public RedBlackNode rotateLeft(RedBlackNode h){
        assert isRed(h.right);
        assert !isRed(h.left);
        RedBlackNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    public RedBlackNode rotateRight(RedBlackNode h){
        assert isRed(h.left);
        RedBlackNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    public void flipColors(RedBlackNode h){
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public RedBlackNode put(RedBlackNode h, Key key, Value val){
        if (h == null){
            return new RedBlackNode(key, val, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp > 0){
            h.right = put(h.right, key, val);
        }else if(cmp < 0){
            h.left = put(h.left, key, val);
        }else{
            h.val = val;
        }

        // only a few lines of code provides near-perfect balance
        if (isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    //-----------------------------------------------------------------
    // these methods not even change from elementary BST
    // and runs faster because of better balance
    public Value get(Key key){
        RedBlackNode x = this.root;
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

    public Key floor(Key key){
        RedBlackNode x = floor(this.root, key);
        if (x == null){
            return null;
        }
        return x.key;
    }

    private RedBlackNode floor(RedBlackNode x, Key key){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return x;
        }else if (cmp < 0){
            return floor(x.left, key);
        }else{
            RedBlackNode y = floor(x.right, key);
            if (y != null){
                return y;
            }else{
                return x;
            }
        }
    }

    public Key ceiling(Key key){
        RedBlackNode x = ceiling(this.root, key);
        if (x == null){
            return null;
        }
        return x.key;
    }

    private RedBlackNode ceiling(RedBlackNode x, Key key){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return x;
        }else if(cmp > 0){
            return ceiling(x.right, key);
        }else{
            RedBlackNode y = ceiling(x.left, key);
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

    private int rank(RedBlackNode x, Key key){
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

    public RedBlackNode min(RedBlackNode x){
        if (x.left == null){
            return x;
        }
        return min(x.left);
    }

    public Iterable<Key> iterator(){
        LinkedList<Key> q = new LinkedList<Key>();
        // inorder(root, q);
        // preorder(root, q);
        postorder(root, q);
        return q;
    }

    private void inorder(RedBlackNode x, LinkedList<Key> q){
        if (x == null){
            return;
        }
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    private void preorder(RedBlackNode x, LinkedList<Key> q){
        if (x == null){
            return;
        }
        q.add(x.key);
        preorder(x.left, q);
        preorder(x.right, q);
    }

    private void postorder(RedBlackNode x, LinkedList<Key> q){
        if (x == null){
            return;
        }
        preorder(x.left, q);
        preorder(x.right, q);
        q.add(x.key);
    }
    //--------------------------------------------------------------------
}
