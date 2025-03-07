import java.util.Scanner;

class JobScheduler{
    /**
    * Calculates completion Time for given processes . CT=BT+actual start of the process
    * @param process array with AT and BT, requires that there should be positive integers . arrival time of next process should be more then current process
    * @return array with completion time of all the processes . returns integer value
    */
    public static int[] completionTime( int[][] process ){  //CT=Burst Time + actual starting time of that process
        int numberOfProcess = process.length;
        int[] calcCT = new int[ numberOfProcess ];
        int startTime = process[0][0];      //consider starttime as the arrival time for first process
        for(int index = 0 ; index < numberOfProcess ; index++){
            if(startTime < process[index][0]){     //startTime stores the actual starting of the process execution
                startTime = process[index][0];
            }
            calcCT[index] = process[index][1] + startTime;
            startTime = calcCT[index];
        }
        return calcCT;
    }

    public static int[] turnAroundTime(int[][] process , int[] calcCT){     //TAT=CT-AT
        int numberOfProcess = process.length;
        int[] calcTAT = new int[numberOfProcess];
        for(int index = 0 ; index < numberOfProcess ; index++){
            calcTAT[index] = calcCT[index] - process[index][0];
        }
        return calcTAT;
    }

    public static int[] waitingTime(int[][] process , int[] calcTAT){       //WT=TAT-BT
        int numberOfProcess = process.length;
        int calcWT[] = new int[numberOfProcess];
        for(int index = 0 ; index < numberOfProcess ; index++){
            calcWT[index] = calcTAT[index] - process[index][1];
        }
        return calcWT;
    }

    public static double avgWaitingTime(int[] calcWT){      //Calc avg of all the waiting time
        int sum = 0;
        int numberOfProcess = calcWT.length;
        for(int index = 0 ; index < numberOfProcess ; index++){
            sum += calcWT[index];
        }
        return sum/numberOfProcess;
    }

    public static int maxWaitingTime(int[] calcWT){         //computes maximum of all the waiting times
        int maximum = 0;
        int numberOfProcess = calcWT.length;
        for(int index = 0 ; index < numberOfProcess ; index++){
            if(calcWT[index] > maximum){
                maximum = calcWT[index];
            }
        }
        return maximum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println( "Enter number of process you want to enter" );      //input the number of process you want to enter
        int numberOfProcess = sc.nextInt();
        int[][] process = new int[numberOfProcess][2];
        for(int index = 0 ; index < process.length ; index++){          //takes the arrival time and burst time of each process
            System.out.println("Enter arrival time and burst time of process " + (index+1));
            process[index][0] = sc.nextInt();
            process[index][1] = sc.nextInt();
        }

        int[] completionTime = completionTime(process);     //calculate completion time of each process
        System.out.println("Completion time = ");           //print completion time
        for(int index = 0 ; index < numberOfProcess ; index++){
            System.out.print(completionTime[index] + "\t");
        }
        System.out.println();

        int[] turnAroundTime = turnAroundTime(process,completionTime);     //calculate turn around time of each process
        System.out.println("Turn around time = ");                      //print turn around time
        for(int index = 0 ; index < numberOfProcess ; index++){ 
            System.out.print(turnAroundTime[index] + "\t");
        }
        System.out.println();

        int[] waitingTime = waitingTime(process,turnAroundTime);        //calulates waiting time for each process
        System.out.println("Waiting time = ");                          //print waiting time
        for(int index = 0 ; index < numberOfProcess ; index++){
            System.out.print(waitingTime[index] + "\t");
        }
        System.out.println();

        double avgWaitingTime = avgWaitingTime(waitingTime);        //calculates average waiting time
        System.out.println("Average Waiting time = " + avgWaitingTime);    //print the average waiting time
        
        int maximumWaitingTime = maxWaitingTime(waitingTime);       //calculates maximum waiting time
        System.out.println("Maximum Waiting time = " + maximumWaitingTime);    //print maximum waiting time
    }
}