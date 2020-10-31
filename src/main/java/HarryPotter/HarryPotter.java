package HarryPotter;

import java.util.function.Predicate;

public class HarryPotter {
    static void draw(Check check){
        for (int x = 0; x< 25;x++) {
            for (int y = 0; y < 25; y++) {
                if (check.check(x, y))
                    System.out.print("# ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
    public static void main(String[] str){
        System.out.println("figure 4");
        draw((x, y) -> y<=30-x);
        System.out.println("figure 5");
        draw((x, y) -> x==y/2);
        System.out.println("figure 6");
        draw((x, y) -> !(x>=10&&y>=10));
        System.out.println("figure 7");
        draw((x, y) -> (x>15&&y>15));
        System.out.println("figure 9");
        draw((x, y) -> y>x+10||y<x-10);
        System.out.println("figure 11");
        draw((x, y) -> x==1||y==1||y==23||x==23);
        System.out.println("figure 20");
        draw((x, y) -> (x+y)%2==0);
        System.out.println("figure 21");
        draw((x, y) -> y%(x+1)==0);
        System.out.println("figure 22");
        draw((x, y) -> (x+y)%3==0);
        System.out.println("figure 23");
        draw((x, y) -> x%3==0&&y%2==0);
        System.out.println("figure 24");
        draw((x, y) -> (x-y==0)||(y==-x+24));
        System.out.println("figure 25");
        draw((x, y) -> x%6==0||y%6==0);
    }
}
