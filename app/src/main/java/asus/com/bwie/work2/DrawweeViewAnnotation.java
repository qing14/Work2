package asus.com.bwie.work2;

public class DrawweeViewAnnotation {

    @MyAnno(name = "Hello word")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DraweeViewAnnotation{" + "name='" + name + '\'' + '}';
    }


}
