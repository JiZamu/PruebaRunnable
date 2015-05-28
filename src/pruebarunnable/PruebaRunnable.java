package pruebarunnable;

public class PruebaRunnable implements Runnable{
    
    private String nombre;
    
    public PruebaRunnable(String nombre){
        this.nombre = nombre;
    }
    
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new PruebaRunnable("Hilo1"));
        Thread t2 = new Thread(new PruebaRunnable("Hilo2"));
        Thread t3 = new Thread(new PruebaRunnable("Hilo3"));
        
        t1.start();
        t2.start();
        t3.start();
        
        //Espera a que termine para continuar
        t1.join();
        t2.join();
        t3.join();
        
        System.out.println("Termino");
    }

    @Override
    public void run() {
        try{
            int x = (int)(Math.random()*5000);
            Thread.sleep(x);
            System.out.println("Mi nombre es: "+nombre+" con x = "+x);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
