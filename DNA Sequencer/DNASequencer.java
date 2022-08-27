/**
* Author: Nikolas Vaki & Antria Argyrou
* Written: 17/02/2020
* Last updated: 20/02/2020
*
* Compilation command: javac DNASequencer.java
* Execution command: java DNASequencer
*
* To programa lamvani apo ton christi meso tis grammis endolwn arguments diaforous elikes  
* O Prwtos elikas tha hrisimopithi san vasi gia na ktisti ena DNA morio Se kathe epomeno vima
* lamvanete enas elikas apo tin eisodo kai elenghete an yparhi epikalipsi me to ypo dimiourgia dna morio
* An yparhi tote o elikas eisodou sinenonete me to ypo dimiourgia DNA morio alliws o elikas eisodou aporiptetai
* H diadikasia sinehizete mehri na eksandlithoun oloi oi elikes eisodou
* tote o elikas pou tha ehi htisti apo tis sinenosis tha einai to DNA morio.
*
*
*
*/
public class DNASequencer {

	// i methodos mySubstring epistrefi mia simvoloseira apo tin i thesi tis mexri j 
	public static String mySubstring(String s, int i, int j) {
		//keno string
		String r = "";
		for (int k = i; k < s.length() && k < j; k++)
			r += s.charAt(k);
		return r;
	}
    //i methodos compare elengi an dio strings(simvoloseires) einai isa
	// an einai isa epistrefi true an ohi false
	public static boolean compare(String s1, String s2) {
		int i;
		for (i = 0; i < s1.length() && i < s2.length(); i++) {
			if (s1.charAt(i) < s2.charAt(i))
				return false;
			if (s1.charAt(i) > s2.charAt(i))
				return false;
		}
		if (s1.length() == s2.length())
			return true;

		return false;
	}
 //i methodos plires elenghi an to string tou DNA tis vasis kai tis ellikas tis kainourgias
	//an ehoun pliri epikalipsi metaksi tous
	public static boolean plires(String dna, String elikas) {

		for (int i = dna.length() - 1; i >= 0; i--)
			if (dna.charAt(i) == elikas.charAt(0) && !(dna.length() - i + 1 < elikas.length())) 
				// epidi an einai mikrotero tote den einai pliris epikalipsi
				//akolouthos kalw tis sinartisis pou dimiourgisa
				if (compare(mySubstring(dna, i, i + elikas.length()), elikas))
					return true;

		return false;
	}
 // i sinartisi vriski to mikos tis epikalipsis
	public static int mikosEpikalipsis(String dna, String elikas) {
		//metritis gia epikalipsi

		int cnt = 0;
		//megaliteri epikalispis
		int max = 0;
 //o eleghos arhizei apo to telos tou vasikou string pou einai to DNA
		for (int i = dna.length() - 1; i >= 0; i--)
			//an o haaktiras tou string teriazi
			if (dna.charAt(i) == elikas.charAt(0)) {
				cnt = 0;
				//kai gia tis dio simvoloseires eleghoume mehri pio simeio ehoyme epikalipsi kai to metrame me ena metriti
				for (int k = 0; k < elikas.length() && k + i < dna.length(); k++) {
					if (dna.charAt(k + i) == elikas.charAt(k))
						cnt++;
					else
						cnt = 0;
				}
			//an o counter megaliteros apo to max
				//max iso me counter
				if (cnt > max)
					max = cnt;
			}

		return max;
	}

	public static void main(String[] args) {
		
        //katofli dedomeno apo tin askisi
		int katofli = 4;
        //dimiourgw dio nees kenes simvoloseires
		String dna = new String();
		String elikas = new String();

		int mikosEpikalipsis;
       //elengw an i grammi endolwn einai keni 
		//an einai na typoni ta analoga minimata
		if (args.length == 0) {
			System.out.println("Wrong input!");
			System.out.println("Expected input : <strand1> <strand2> ...");
			System.exit(0);
		}
		//i simvoloseira dna arhikopiite me tin prwti simvoloseira pou vriskete sto args 
		dna = args[0];
        //ksekiname to for apo to ena afou gia ti thesi 0 idi pirame to DNA
		for (int i = 1; i < args.length; i++) {
			elikas = args[i];
			//an den einai plires i epikalipsi
			//kaloume tin sinartisi pou dimiourgisame gia na tin vroume
			if (!plires(dna, elikas)) {
				//kaloume tin sinartisi gia na vroume to mikos
				mikosEpikalipsis = mikosEpikalipsis(dna, elikas);
				//an i epikalipsi einai megaliteri apo 4 mono tote na ginete i prosthiki tis enapominandas alysidas
				if (mikosEpikalipsis >= katofli) {

					dna += mySubstring(elikas, mikosEpikalipsis, elikas.length());
				}
			}
		}
		//Typnoume tin teliki alisida
		System.out.print("DNA molecule : "+dna);
	}
}
