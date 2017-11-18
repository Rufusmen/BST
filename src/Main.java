import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String s;
        System.out.println("Commands:\ninsert:+\nremove:-\nsearch:?\nmin:<\nmax:>\nsize:s\nclear:c\nexit:e");
        System.out.println("Integer or String? (i/s): ");
        s = in.next();
        if(s.equals("i")){
            int i;
            BST<Integer> bst = new BST<Integer>();
            while (true){
                try {
                    s = in.next();
                    switch (s) {
                        case "+":
                            i = in.nextInt();
                            bst.insert(i);
                            break;
                        case "-":
                            i = in.nextInt();
                            bst.remove(i);
                            break;
                        case "?":
                            i = in.nextInt();
                            if (bst.search(i)) System.out.println(s + " is in BST");
                            else System.out.println(s + " is not in BST");
                            break;
                        case "<":
                            System.out.println(bst.min());
                            break;
                        case ">":
                            System.out.println(bst.max());
                            break;
                        case "s":
                            System.out.println(bst.size());
                            break;
                        case "c":
                            bst.clear();
                            break;
                        case "e":
                            return;
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else {
            BST<String> bst = new BST<String>();
            while (true){
                try {
                    s = in.next();
                    switch (s) {
                        case "+":
                            s = in.next();
                            bst.insert(s);
                            break;
                        case "-":
                            s = in.next();
                            bst.remove(s);
                            break;
                        case "?":
                            s = in.next();
                            if (bst.search(s)) System.out.println(s + " is in BST");
                            else System.out.println(s + " is not in BST");
                            break;
                        case "<":
                            System.out.println(bst.min());
                            break;
                        case ">":
                            System.out.println(bst.max());
                            break;
                        case "s":
                            System.out.println(bst.size());
                            break;
                        case "c":
                            bst.clear();
                            break;
                        case "e":
                            return;
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}
