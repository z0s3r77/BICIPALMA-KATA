package appalma.estacion;


import appalma.bicicleta.Bicicleta;
import appalma.tarjetaUsuario.TarjetaUsuario;

public class Estacion {

    private int id ;
    private String direccion ;
    private int numeroAnclajes;
    private int[] anclajes ;


    public Estacion(int id, String direccion, int numeroAnclajes){
       
        setId(id);
        setDireccion(direccion);
        setNumeroAnclajes(numeroAnclajes);
        setAclajes(numeroAnclajes);

    }

    // Setters and Getters
    public void setAclajes(int anclajes){
        this.anclajes = new int[anclajes];
    }

    public void setId(int id ){
        this.id = id;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setNumeroAnclajes(int numeroAnclajes){
        this.numeroAnclajes = numeroAnclajes;
    }


   public int getId(){
    return this.id;
   }

   public String getDireccion(){
    return this.direccion;
   }

   public int getNumeroAnclajes(){
    return this.numeroAnclajes;
   }

   public int[]  getAnclajes(){
    return this.anclajes;
   }


   

   //Metodos

   public void consultarEstacion(){
    System.out.println(toString());
    }

   @Override
   public String toString(){

    StringBuilder representacion = new StringBuilder();

    representacion.append("\n id: " + getId());
    representacion.append("\n direccion: " + getDireccion());
    representacion.append("\n numeroAnclajes: " + getNumeroAnclajes());

    return representacion.toString();
   
    }

    public int anclajesLibres(){

        // Restamos el numero de anclajes disponibles de los espacios ocupados en la lista de anclajes
        
        int anclajesLibres = 0;

        for (int i = 0; i < this.anclajes.length; i++) {
            if (this.anclajes[i] == 0) {
                anclajesLibres++;
            }
        }
        return anclajesLibres;

       }




    
    // Añadimos una bici al ArrayList<bicicleta>
    // Como se puede hacer con un array normal?
    public void anclarBicicleta(Bicicleta bicicleta){

        for (int i = 0; i < getNumeroAnclajes(); i++) {
            if(this.anclajes[i] == 0){
                this.anclajes[i] = bicicleta.getId();
                break;
            }
        }

    }



    public void consultarAnclajes(){

        for (int i = 0; i < numeroAnclajes; i++) {
          
            if (this.anclajes[i] != 0) {
                System.out.println("Anclaje "+ (i+1) + " "+  this.anclajes[i]);
            } else {
                System.out.println("Anclaje " + (i+1) + " "+ "Libre" );;
            }
          
        }
    }


    public String leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario){
        
        if (tarjetaUsuario.getActivada()) {
            return "True";
        } else{
            return "False";
        }
        
    }

    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario){

        if (tarjetaUsuario.getActivada()) {

            for (int i = 0; i < numeroAnclajes; i++) {
                if (this.anclajes[i] != 0) {
                    int bicicleta = this.anclajes[i];
                    this.anclajes[i] = 0;
                    System.out.println("bicicleta retirada: "+ bicicleta+ " del anclaje: "+ (i+1));
                    break;
                } 
            }
        } 
    }
}
