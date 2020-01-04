public class AplicacaoTelevisor
{
    public static void main(String args[])
    {
        Televisor tv1 = new Televisor();
        
        System.out.println("Estado atual de tv1: ");
        System.out.println("Marca: " + tv1.getMarca());
        System.out.println("Volume: " + tv1.getVolume());
        System.out.println("Canal: " + tv1.getCanal());
        
        tv1.setCanal(20);
        System.out.println("Novo Canal: " + tv1.getCanal());
        for(int i=1; i<=3; i++)
        {
            tv1.aumentarVolume();
        }
        System.out.println("Novo Volume: " + tv1.getVolume());
        tv1.setMarca("Samsung");
        System.out.println("Nova Marca: " + tv1.getMarca());
    }
}