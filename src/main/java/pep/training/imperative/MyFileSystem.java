package pep.training.imperative;
import java.util.*;

class Entry {
    private String name;

    public boolean isFile;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }   
}

class MyDirectory extends Entry {
    private Map<String, Entry> contents;

    public void addEntry(Entry entry){
        this.contents.put(entry.getName(), entry);
        System.out.println("new Entry addede " + entry.getName());
    }

    public MyDirectory(String name) {
        this.setName(name);
        this.contents = new HashMap<String,Entry>();
        this.isFile = false;
    }

    public boolean isFileAvailable(String e) {
        return contents.containsKey(e);
    }

    public Map<String, Entry> getContents() {
        return this.contents;
    }
}

class MyFile extends Entry {
    private String content = "";

    public MyFile(String name, String content) {
        this.setName(name);
        this.setContent(content);
        this.isFile = true;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}

public class MyFileSystem {

    MyDirectory root = new MyDirectory("root");

    private void print(String root, MyDirectory dir){
        String dirName = root + dir.getName();
        System.out.println(dirName);
        Iterator itr = dir.getContents().entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, Entry> e1 = (Map.Entry)itr.next();
            Entry e =  e1.getValue();
            if(e.isFile){
                MyFile f = (MyFile) e;
                System.out.println( dirName+"/"+e.getName() + "  :: " + f.getContent());
            } else {
                MyDirectory d = (MyDirectory)e;
                print(dirName+"/", d);
            }
        }
    }
    
    public static void main(String[] args){

        try {
            MyFileSystem fs = new MyFileSystem();

            // /foo
            // /foo/bar 
            // /foo/bar/test  ->file

            fs._mkdir("/");
            fs._writeFile("/test", "test content");
            fs._readFile("/test");


            fs._mkdir("/foo");
            fs._writeFile("/foo/test", "test in foo");
            fs._readFile("/foo/test");

            fs._mkdir("/foo/bar");
            fs._writeFile("/foo/bar/test","test content in foo.bar");

            fs._writeFile("/foo/t1", "test content in foo t1");

            fs._mkdir("/foo/bar/car");

            fs._mkdir("foo/bar");
            fs._mkdir("/foo/bar/test");

            fs._readFile("/foo/bar/test");
            fs._readFile("/foo/t1");

            System.out.println("####################");
            fs.print("/",fs.root);

            

        } catch (Exception e) { 
            System.out.println(e.getMessage());
        }
    }

    public void _mkdir(String file) {
        try {
            String name = getNameFromPath(file);
            String path = getPathfromFilePath(file);
            MyDirectory newDir = new MyDirectory(name);
            MyDirectory dir = getDirFromRoot(path);
            if(!dir.getContents().containsKey(newDir.getName())) {
                dir.addEntry(newDir);
            } else {
                throw new Exception("Entry already available, cannot create folder!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void _writeFile(String file, String content) throws Exception{
        try {
            String fileName = getNameFromPath(file);
            String path = getPathfromFilePath(file);
            MyDirectory dir = getDirFromRoot(path);
            if(!dir.getContents().containsKey(file)) {
                dir.addEntry(new MyFile(fileName, content));
            } else {
                throw new Exception("Entry already available, cannot create file!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public String _readFile(String file) throws Exception {
        String output = "";
        try {
            String fileName = getNameFromPath(file);
            String path = getPathfromFilePath(file);
            MyFile f = (MyFile)getDirFromRoot(path).getContents().get(fileName);
            output = f.getContent();
        } catch (Exception e) {
            System.out.println("File cannot be read");
        }
        System.out.println(file + " content is :: " + output);
        return output;
    }

    private String getNameFromPath(String path) throws Exception {
        String name = path.substring(path.lastIndexOf("/")+1, path.length());
        if(name.isEmpty()) {
            throw new Exception("Name cannot be empty");
        }
        return name;
    }

    private String getPathfromFilePath(String path) {
        int lastIndex = path.lastIndexOf("/");
        if(lastIndex == 0){
            path = "/";
        } else {
            path = path.substring(0, path.lastIndexOf("/"));
        }
        return path;
    }

    private MyDirectory getDirFromRoot( String path) throws Exception {
        MyDirectory dir = this.root;
        if(!path.startsWith("/")) {
            throw new Exception("Not a valid path :: " + path);
        }else {
            path = path.substring(1);
        }
        return getDirFromPath(dir, path);
    }


    private MyDirectory getDirFromPath( MyDirectory dir, String path) throws Exception {
        String[] dirs = path.split("/");
        if( dirs[0] != "" && dir.getContents().containsKey(dirs[0])) {
            Entry e = dir.getContents().get(dirs[0]);
            if(e.isFile) {
                throw new Exception("Not a directory its a file");
            } else {
                dir = (MyDirectory) e;
            }
            if(dirs.length > 1){
                dir = getDirFromPath( dir, dirs[1]);
            }
        }
        return dir;
    }
}