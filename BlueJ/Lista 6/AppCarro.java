import java.util.Scanner;
public class AppCarro
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        String placa = "abc1234";
        double capacidadeTanque = 50;
        double mediaDeConsumo = 8;
        Carro carro1 = new Carro(placa,capacidadeTanque,mediaDeConsumo);
        carro1.abastecer(30.5);
        carro1.abastecer(14.5);
        System.out.println("O carro com a placa " + carro1.getPlaca() +
        " tem em seu tanque " + carro1.getLitros() + " litros");
        mediaDeConsumo = mediaDeConsumo + 3;
        carro1.setConsumo(mediaDeConsumo);
        int distancia = 750;
        System.out.println("O carro " + carro1 + " para percorrer " + distancia + "km precisará de " +
        carro1.preverCombustivel(distancia) + " tanque(s) de combustível");
        
        System.out.print("Informe a placa: ");
        String p = in.nextLine();
        System.out.print("Informe a capacidade do tanque: ");
        double c = in.nextDouble();
        System.out.print("Informe a média de consumo: ");
        double m = in.nextDouble();
        Carro carro2 = new Carro(p,c,m);
        
        System.out.println("Carro 2:\nPlaca: " + carro2.getPlaca() + "\nCapacidade: " + carro2.getCapacidadeTanque() +
        "\nMédia de Consumo: " + carro2.getMediaDeConsumo() + "\nLitros no tanque: " + carro2.getLitros());
    }
}