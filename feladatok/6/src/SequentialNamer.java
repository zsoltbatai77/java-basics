public class SequentialNamer implements Namer{

    private int index = 1;

    @Override
    public void rename(FileSystemEntry entry) {
        //?
        index++;
    }
}
