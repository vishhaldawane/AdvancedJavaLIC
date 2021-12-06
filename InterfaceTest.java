
public class InterfaceTest {
	public static void main(String[] args) {
	//	Instrument i = new Instrument();
	//	MusicalInstrument mi = new MusicalInstrument();
	//	StringBasedMusicalInstrument sbmi = new StringBasedMusicalInstrument();
		
		Guitar g = new Guitar();
		g.use();
		g.play();
		g.tuneStrings();
		g.pluck();
	}
}

interface Instrument
{
	void use(); //by default public and abstract | declaration of the function
}
abstract class MusicalInstrument implements Instrument {
	abstract void play();
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument {
	abstract void tuneStrings();
}
class Guitar extends StringBasedMusicalInstrument {

	void play() { System.out.println("playing guitar....."); }
	public void use() { System.out.println("using guitar....."); }
	void tuneStrings() { System.out.println("tuning guitar.....");}

	void pluck() { }
	void chat() { }
	void socialMedia() { }
	void goEarly()  { }
	void comeLate() { }
}

//visualize a game 
//visualize indoor game - TT, Chess, Carrom, BadMinton
//visualize outdoor game - FootBall, Cricket, Hockey



// pure partial contract of a class
//abstract |incomplete|partial contract of a class 
//concrete contract

/*

1  			Instrument <-- interfaces
  				| use();
  -----------------------------------------------------------------------
  |																	|
2 MusicalInstrument										MedicalInstrument
       | play();														|operate();
  --------------------------------------------					---------------------------------------------------
       |  									|					|								|
3 StringbasedMusicalInstrument	AirbasedMusicalInstrument	SurgicalMedicalInstrument		PathalogicalMedicalInstrument
  	|	tuneStrings();								|			|sterilize()							|read();
  -------------------------------	---------------------	------------------------		-------------------------
  |			|			|			|			|			|			|					|			|
  Guitar	Sitar		Violin		Flute		Saxophone	Cutter		Needle			GlucoMeter		ECGMachine
  |pluck();				|bowing();							 cut()		 poke()				readSuger()
  ElectronicGuitar		Cello
  
  
  




*/



