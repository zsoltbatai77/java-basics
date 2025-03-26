public class Manager {
    private Namer namer;

    private Folder imagesFolder;

    private Folder ectFolder;

    public Manager(Namer namer, Folder rootFolder){
        this.namer = namer;
        this.imagesFolder = new Folder(rootFolder, "images");
        this.ectFolder = new Folder(ectFolder, "ect");

    }

    public File upload(String fileName, long size){
        if(fileName.contains(".jpg") || fileName.contains(".png") || fileName.contains(".gif")){
            File f1 = new File(imagesFolder, fileName, size);
            return f1;

        }

        else{
            File f1 = new File(ectFolder, fileName, size);
            return f1;
        }






    }

}
