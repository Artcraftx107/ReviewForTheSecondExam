package bus;

public class BusException extends RuntimeException{
    public BusException(){
        super();
    }
    public BusException(String msg){
        super(msg);
    }
}
