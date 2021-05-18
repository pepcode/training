public class StringManipulation {

    public static void main(String[] args) {

        String a = "/foo/test/t";
        System.out.println(a.substring(0, a.lastIndexOf("/")));


        String b = "/foo";
        System.out.println(b.lastIndexOf("/"));
        System.out.println(b.substring(0, b.lastIndexOf("/")));
    }
    
}
