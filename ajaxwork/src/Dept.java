public class Dept {
    private  int no ;
    private  String name;
    private  String loc;
    private  int num;

    public Dept() {
    }

    public Dept(int no, String name, String loc, int num) {
        this.no = no;
        this.name = name;
        this.loc = loc;
        this.num = num;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
