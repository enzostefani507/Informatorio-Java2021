class EntidadNoEncontradaException extends Exception{
    private static final long serialVersionUID = 1L;

    public EntidadNoEncontradaException(String mensaje){
        super(mensaje);
    }
}