public class BST <T extends Comparable<T> > implements Dict<T> {

    private class  Node<T extends Comparable<T> >{
        Node<T> left,right,parent;
        T data;

        Node(T data,Node<T> parent){
            this.parent = parent;
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<T> root = null;
    private int cnt = 0;

    @Override
    public void insert(T t) throws Exception {
        if(t==null)throw new NullPointerException();
        cnt++;
        root = add(t,root,null);
    }

    private Node<T> add(T t, Node<T> node,Node<T> parent) {
        if(node == null){
            node = new Node<>(t,parent);
            return node;
        }
        else{
            if(t.compareTo(node.data)<0){
                node.left = add(t,node.left,node);
            }
            else {
                node.right = add(t,node.right,node);
            }
        }
        return node;
    }

    @Override
    public void remove(T t) throws NoSuchFieldException {
        if(!find(t,root))throw new NoSuchFieldException("Brak wartości w BST");
        cnt--;
        root = delete(t,root);
    }

    private Node<T> delete(T t,Node<T> node){
        if(node == null)return node;
        if(t.compareTo(node.data)<0)node.left = delete(t,node.left);
        else if(t.compareTo(node.data)>0)node.right = delete(t,node.right);
        else{
            if(node.left == null)return node.right;
            else if(node.right == null)return node.left;
            else{
                T value = _min(node);
                node.data = value;
                delete(value,node.left);
            }
        }
        return node;
    }
    @Override
    public boolean search(T t) {
        return find(t,root);
    }

    private boolean find(T t,Node<T> node){
        if(node == null)return false;
        if(t.compareTo(node.data)==0)return true;
        if(t.compareTo(node.data)<0)return find(t,node.left);
        else return find(t,node.right);
    }

    @Override
    public T max() {
        return _max(root);
    }

    private T _max(Node<T> node){
        if(node==null)return null;
        if(node.right==null)return node.data;
        return _max(node.right);
    }

    @Override
    public T min() {
        return _min(root);
    }

    private T _min(Node<T> node){
        if(node==null)return null;
        if(node.left==null)return node.data;
        return _min(node.left);
    }

    public int size(){
        return cnt;
    }

    public void clear(){
        root = null;
        cnt = 0;
    }
}
