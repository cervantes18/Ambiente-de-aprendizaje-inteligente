package MAIN;

import Reader.Pregunta;
import java.util.ArrayList;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyLogic {
	public static void main(String[] args) {
		System.out.println("Hola");
		
		 // Load from 'FCL' file
        String fileName = ""
        		+ "C:/Users/Acer Nitro 5/Downloads/tipper/tipper.fcl";
        FIS fis = FIS.load(fileName,true);
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" 
                                   + fileName + "'");
            return;
        }
        
        //Show Ruleset
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        //imprime tabla
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("time", 3);
        fis.setVariable("help", 7);
        fis.setVariable("mistakes", 6);


        // Evaluate
        fis.evaluate();
        
        Variable tip = functionBlock.getVariable("level");
        //imprime tabla final
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(),true);
        Gpr.debug("lafsldemr]: "+ functionBlock.getVariable("level").getMembership("easy"));
        
        System.out.println("LEVEL: "+functionBlock.getVariable("level").getValue());
        // Show output variable's chart 
        
	
	}
        public ArrayList<String[]> revisarNivel(Pregunta p, int time, int help, int mistakes){
            double nivel = asd(time,help,mistakes);
            ArrayList<String[]> ruta = new ArrayList <String[]>();
            ArrayList<String[]> rut2 = null;
            if(nivel <= 10) {
                rut2 = p.preguntasFaciles();                     
            }
            else if(nivel > 10 && nivel <=18 ){
                rut2 = p.preguntasMedias();
            }
            else if(nivel > 18){
                rut2 = p.preguntasDificiles();
            }
            for(int i =0; i< rut2.size(); i++){
                ruta.add(rut2.get(i));
            }
            System.out.println("El tamano es de "+ruta.size());
            return ruta;
        } 
        
        
        
        public double asd(int time,int help,int mistakes) {
		System.out.println("Hola");
		if (time>60){
                     time=60;
                }
                if(help>3){
                    help =3;
                }
                if(mistakes>3){
                    mistakes = 3;
                }
		 // Load from 'FCL' file
        String fileName = ""
        		+ "C:/Users/Acer Nitro 5/Downloads/tipper/tipper.fcl";
        FIS fis = FIS.load(fileName,true);
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" 
                                   + fileName + "'");
            return 0.0;
        }
        
        //Show Ruleset
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        //imprime tabla
       // JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("time", time);
        fis.setVariable("help", help);
        fis.setVariable("mistakes", mistakes);


        // Evaluate
        fis.evaluate();
        
        Variable tip = functionBlock.getVariable("level");
        //imprime tabla final
        //JFuzzyChart.get().chart(tip, tip.getDefuzzifier(),true);
        Gpr.debug("lafsldemr]: "+ functionBlock.getVariable("level").getMembership("easy"));
        
        System.out.println("LEVEL: "+functionBlock.getVariable("level").getValue());
        // Show output variable's chart 
        
	return functionBlock.getVariable("level").defuzzify();
	}
        
}
