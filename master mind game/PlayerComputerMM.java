/**
* Author: Antria Argyrou & Nikolas Vaki 
* Written: 10/03/2020
* Last updated: 17/03/2020
*
* Compilation command: javac PlayerComputerMM.java
* Execution command: java PlayerComputerMM.java
*
* 
* O User Theti ena mystiko sindiasmo 4 psyfiakwn psyfiwn 
* kai o ypologistis prospathi na ton mandepsi
* 
* 
* 
*
*/
import java.util.Scanner;
public class PlayerComputerMM{

	Scanner scan =new Scanner(System.in);
	private static int[][] ALL = new int[30][4];
	private static int GCount = 0;
	
	public static void Play (int tries){
		Scanner scan =new Scanner(System.in);
		//Scanner scan = new Scanner (System.in);
		System.out.print("\n\nA GAME BEGINS: The Computer does the");
		System.out.print(" Guessing!!\n");
		System.out.print(">>>>> User please think of a configuration and ");
		System.out.println("keep it secret!");
		GCount = 0;
		//System.out.println("*** THE REST IS UNDER CONSTRUCTION ***");
		
		//Dimiourgoume ena pinaka boolean gia na eleksoume an einai pithanos arithmos
		//gia na apoklioume periptwsis vazoume timi true or false
		//Arhika oles einai pithanes ara arhikopioume oles tis thesis me TRUE
		boolean[] couldBe=new boolean[10000];      
		
		
		for (int i=0;i<couldBe.length;i++) { 
			couldBe[i]=true;
		}
		//Dimiourgoume ena pinaka me olous tous pithanous sindiasmous
		int [][] possibilities = new int[10000][4];
		int count=0;
		for(int i=0 ; i<=9;i++) {
			for(int j=0 ; j<=9; j++){
				for(int h=0; h<=9;h++) {
					for(int r=0;r<=9;r++) {
						possibilities[count][0]=i;
						possibilities[count][1]=j;
						possibilities[count][2]=h;
						possibilities[count][3]=r;
						count++;
					}
				}
			}
		}
		int FullMatch=-1, PartialMatch=-1, i=0;
		/*enwsw oi prospathies einai ligoteres apo oses orizete
		apo tin grammi endolis kai den einai o idios arithmos me auto pou dialekse o User
		*/
		while(GCount<tries&&FullMatch<4) {
			//elenhoume an einai pithanos arithmos
			if (couldBe[i]) {          
				System.out.print("The computer guesses : ");
				for (int j=0;j<possibilities[0].length;j++) 
					System.out.print(possibilities[i][j]+" ");
				
				System.out.println("\nIndicate full and partial matches:");
				//O Christis pliktrologi posa psifia petihe o Ypologistis
				FullMatch= scan.nextInt();
				PartialMatch=scan.nextInt();
				//an isoute me kati apo ta pio katw typwse ta andistoiha minimata
				//an vrike kai tous 4 arithmous alla vriskonde se diaforetikes thesis
				if(FullMatch==2&&PartialMatch==2) {
					System.out.println("Good ! Let's get the order correct ");
				}
				//An vrei 3 arithmous typone Finish
				//Vrike 2 arithmous stin swsti thesi kai 1 pou andistihi se mia apo ti alles 2 thesis
				if(FullMatch==2&&PartialMatch==1) {
					System.out.println("FINISH ");
				}
				//An oi arithmoi FullMatch kai PartialMatch den teriazoun me proigoumenes apandisis
				//tote autoi oi arithmi den mporoun na einai ara einai false
				//Apoklioume Periptwsis
				//(Kaloume tin FullMatch kai tin PartialMatch apo tin clasi PlayerUserMM opou ekei ehoun ksanaoristi)
				for (int j=0;j<possibilities.length;j++) {  
					if (PlayerUserMM.fullMatch(possibilities[i],possibilities[j])!=FullMatch&&PlayerUserMM.partialMatch(possibilities[i],possibilities[j])!=PartialMatch)
						couldBe[j]=false;
				}
				//akolouthos elegoume an o arithmos ehei ksanadothi
				if (!yparhei(possibilities[i])) {
				  Prosthese(possibilities[i]);  
				                       
				} else {
					--GCount;
				}
				GCount++;
			}
			i++;
		}
		//Elenhoume an meta to telos ton prospathion o ypologistis vrike ton arithmo
		//Stin Periptwsi tou Koinou Pehnidiou epistrefoume analogos stin PlayMasterMind an ehei kerdisi i ohi(true or false)
		if (FullMatch==4) {
			System.out.println("Great!! I found it"); 
			PlayMasterMind.WIN=true;
			}
		else {
			PlayMasterMind.WIN=false;
			System.out.println("SAD ! I Have NO More Tries ");
			
		
		}
		//scan.close();
	}
	
	//I Sinartisi prostheto ston pinaka ALL oles tes prospathies tou ypologisti
		private static void Prosthese(int Guesses[]) {   
			for (int j=0;j<ALL[0].length;j++) 
				ALL[GCount][j]=Guesses[j];
		}
		//I Sinartisi elenhi an o sindiasmos psifiwn ehei ksanadothi(Symperilamvanete ston Pinaka ALL)
		private static boolean yparhei(int[] guess){      
			int counter=0;
			boolean symp=false;
			for (int i=0;i<ALL.length;i++){
				for (int j=0;j<ALL[0].length;j++){
					if (ALL[i][j]==guess[j]) {
						counter++;
					}
				}
				if (counter==4) symp=true;
				counter=0;
			}
			return symp;
		}
	
	
	
	public static void main(String[] args){
		GCount = 0;
		System.out.println("\n***** WELCOME TO MASTER MIND *****");
		System.out.println("\n\nThis is a standalone game where ");
		System.out.print("the Computer is guessing\n");
		System.out.println("User please think of a four digit configuration ");
		System.out.print("and keep it secret!\n");
		Play(Integer.parseInt(args[0]));
	}

 
}


