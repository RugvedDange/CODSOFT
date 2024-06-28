import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmks=0;
        System.out.println("Enter Number Of Subjects");
        int n = sc.nextInt();
        System.out.println("Enter Marks Scored In Each Subject Out Of 100 ");
        int[] mks = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter marks scored in subject "+(i+1)+" :- ");
            if(sc.hasNextInt()){
                mks[i]=sc.nextInt();
                tmks+=mks[i];
            }
        }
        char[] grade = new char[n];
        for(int i=0;i<n;i++){
            if(mks[i]<=20)
                grade[i]='E';
                else if (mks[i]>20 && mks[i]<=40)
                    grade[i]='D';
                    else if (mks[i]>40 && mks[i]<=60)
                        grade[i]='C';
                        else if (mks[i]>60 && mks[i]<=80)
                            grade[i]='B';
                            else
                                grade[i]='A';
            }
        float avg_marks = tmks/n;

        System.out.println("\t\t\tMarks  Grade");
        for(int i=0;i<n;i++){
            System.out.println("Subject "+(i+1)+"\t"+mks[i]+"\t\t"+grade[i]);
        }
        System.out.println(" ");
        System.out.println("Average Percentage - "+avg_marks+"%");
    }
}

