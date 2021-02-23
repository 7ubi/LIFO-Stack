package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while(true) {
            Kellerautomat('(', ')');
        }
    }

    static void Kellerautomat(char first, char second){                                 //Kellerautomat {a^nb^n}
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input:");
        String Input = scanner.nextLine();
        Stack<Character> s = new Stack<Character>();
        s.push('#');

        int state = 0;
        for(int i = 0; i < Input.length(); i++){
            char in = Input.charAt(i);

            if(in != first && in != second){
                continue;
            }

            char kellerzeichen;
            try{
                kellerzeichen = s.pop();
            }catch(Exception e){
                state = -1;
                break;
            }
            if (state == 0) {
                if(in == first && kellerzeichen == '#'){
                    s.push('#');
                    s.push(in);
                }else if(in == first && kellerzeichen == first){
                    s.push(in);
                    s.push(in);
                }else if(in == second){
                    s.pop();
                    state = 1;
                }

            }else if (state == 1){
                if(in == second && kellerzeichen == first){
                    s.pop();
                }else if(in == second && kellerzeichen == '#'){
                    state = 2;
                }
            }
        }

        if(state == 2 || s.pop() == null && state != -1){
            System.out.println("Passt");
        }else {
            System.out.println("Fehler");
        }
    }
}
