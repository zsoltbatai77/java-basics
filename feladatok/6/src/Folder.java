public class Folder extends FileSystemEntry{
    private FileSystemEntry[] children;

    public Folder(Folder parent, String name){
        super(parent, name);
    }

    @Override
    public long size() {
        return 0;
    }

    public void addChild(FileSystemEntry child){

    }
}
