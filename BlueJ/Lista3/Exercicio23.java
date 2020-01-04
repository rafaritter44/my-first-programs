public class Exercicio23
{
    public static void main(String args[])
    {
        double ze=1.1, chico=1.5;
        int ano;
        for(ano=0; ze<=chico; ano++)
        {
            ze+=0.03;
            chico+=0.02;
        }
        System.out.println("\fZé: " + ze + "\tChico: " + chico + "\tAnos: " + ano);
    }
}