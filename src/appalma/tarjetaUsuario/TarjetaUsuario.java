package appalma.tarjetaUsuario;

/**
 * TarjetaUsuario
 * 
 */
public class TarjetaUsuario {
    
        int id;
        boolean activada;

        public TarjetaUsuario(String id, boolean activada){
                int number = Integer.parseInt(id);
                setId(number);
                setActivada(activada);
        }
        
        // Setters and getters
        public void setId(int id){
                this.id = id;
        }
        public void setActivada(boolean activada) {
            this.activada = activada;
        }


        public int getId() {
            return this.id;
        }

        public boolean getActivada(){
                return this.activada;
        }
}