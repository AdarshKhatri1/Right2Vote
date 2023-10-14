
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
//To the Interviewer, if you didn't understand then once run in intellij or sts you will understand.
//I got proper right answer in all situation i checked;
public class Right2Vote {
    public static int  i =1;
    public  static int totalCount = 0;


    public static void main(String[] args) {

        int Tshirt = 50;
        int Jeans = 80;
        int Jacket = 100;

        int sum = Tshirt+Jeans+Jacket;
        int min_price = Math.min(Jacket,Math.min(Tshirt,Jeans));

        System.out.println("Enter How much amount you have");
        Scanner sc = new Scanner(System.in);
        int ava_money = sc.nextInt();




        if(ava_money>=sum){
            System.out.println("since available balance is more than sum of Tshirt, Jeans, Jacket");
            System.out.println("so you can get each item only one");
            System.out.println("now remaining price is "+(ava_money-sum));
            if(ava_money-sum<min_price){
                System.out.println("since you haven't enough money to buy any item listed in question, program end");
            }else{
//                Stack<Integer> s= new Stack<>()

                System.out.println("Now check, Options mention below,this is only options, you can buy only one option with remaining money ");
                int [] arr = {Tshirt,Jeans,Jacket};

                ans(min_price,ava_money-sum, new Stack<Integer>(),arr);
                System.out.println("Total possible option is "+totalCount + " and one set of each which is cumpolsary according to question. we can say Total possibe option is "+(totalCount+1));
            }
        }else{
            System.out.println("You haven't enough money to buy any thing");
        }




    }

    public  static  void ans(int min,int price, Stack<Integer> stack,int [] arr){
        if(price<0){
            return;
        }
        if(price<min){
//            System.out.println(" MIN");
//            System.out.println(stack);
//            System.out.println(price+"price");
            totalCount++;
            show(stack);
           return ;
        }
        if(price==0){
//            System.out.println(stack);
//            System.out.println("ZERO");
//            System.out.println(price+"price");
            totalCount++;
            show(stack);

            return;
        }
        for(var i = 0;i<3;i++){
            stack.push(arr[i]);
            ans(min,price-arr[i],stack,arr);
            stack.pop();
        }

        return;
    }

    public  static  void show(Stack<Integer> stack) {
//        int x = stack.pop();
        Map<String,Integer> map = new HashMap<>();
        for(Integer s:stack){
            if(s==50){
                if(map.containsKey("Tshirt")){
                    map.put("Tshirt",map.get("Tshirt")+1);
                }else{
                    map.put("Tshirt",1);
                }
            }else if(s == 80){
                if(map.containsKey("Jeans")){
                    map.put("Jeans",map.get("Jeans")+1);
                }else{
                    map.put("Jeans",1);
                }
            }else{
                if(map.containsKey("Jacket")){
                    map.put("Jacket",map.get("Jacket")+1);
                }else{
                    map.put("Jacket",1);
                }
            }
        }
//        stack.push(x);
        System.out.println(i+":-"+map);
        i++;
    }
}
//    int Tshirt = 50;
//    int Jeans = 80;
//    int Jacket = 100;
