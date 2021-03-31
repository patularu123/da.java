public class ManagerBiblioteca {
    private static String name;
    private static ManagerBiblioteca manager=new ManagerBiblioteca();
    private ManagerBiblioteca()
    {
        name = "Horatiu Niculescu";
    }
    public static ManagerBiblioteca getManager()
    {
        return manager;
    }
    public static void getNume()
    {
        System.out.println("Managerul bibliotecii este:"+name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
