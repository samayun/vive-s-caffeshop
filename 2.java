class Box {
    public int length;
    public int height;
    Box(int length, int height){
        this.length = length;
        this.height = height;
    }

    void getArea(){
        System.out.println("The area is : " + this.length * this.height);
    }

}

class Box3d extends Box {
    public int length;
    public int height;
    public int breadth;
    Box3d(int length, int height, int breadth){
        super(length, height);
        this.length = length;
        this.height = height;
        this.breadth = breadth;
    }
    void getVolume(){
        System.out.println("The volume is : " + this.length * this.height * this.breadth);
    }
}


class Main {
    public static void main(String[] args) {
        Box bx = new Box(5,2);
        bx.getArea();
        Box3d bx2 = new Box3d(5,2, 15);
        bx2.getVolume();
    }
}
