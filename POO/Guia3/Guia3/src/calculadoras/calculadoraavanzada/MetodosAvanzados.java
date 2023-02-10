package calculadoras.calculadoraavanzada;

public class MetodosAvanzados {

    public void potencia(int numero1, int resultado) {
        resultado=numero1*numero1;
        System.out.println("resultado de la potencia es: "+resultado);
    }
    
    public void opuesto(int numero1, int resultado) {
        resultado=numero1*(-1);
        System.out.println("resultado del opuesto es: "+resultado);
    }

    public void factorial(int numero1, double factorial, int resultado) {
    	for (int i=numero1;i>0;i--) {
    		factorial=factorial*i;
    	}
        resultado=(int) factorial;
        System.out.println("resultado de la multiplicación es: "+resultado);
    }
	
}
