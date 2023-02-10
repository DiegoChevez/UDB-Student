package calculadoras.calculadorabasica;

public class MetodosAritmeticos {

    public void suma(int numero1, int numero2, int resultado) {
        resultado=numero1+numero2;
        System.out.println("resultado de la suma es: "+resultado);
    }
    
    public void resta(int numero1, int numero2, int resultado) {
        resultado=numero1-numero2;
        System.out.println("resultado de la resta es: "+resultado);
    }

    public void multiplicacion(int numero1, int numero2, int resultado) {
        resultado=numero1*numero2;
        System.out.println("resultado de la multiplicación es: "+resultado);
    }

    public void division(int numero1, int numero2, int resultado) {
        resultado=numero1/numero2;
        System.out.println("resultado de la división es: "+resultado);
    }
	
}
