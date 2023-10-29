class Assinante {
    private long cpf;
    private String nome;
    private int numero;
    private int numChamadas;

    // Construtor

    public Assinante(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.creditos = 0;
        this.numRecargas = 0;
    }

    // Método para obter o CPF
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public int getNumRecargas() {
        return numRecargas;
    }

    public void setNumRecargas(int numRecargas) {
        this.numRecargas = numRecargas;
    }

    // Método toString para representação em String do objeto
    public String toString() {
        return "Assinante{" +"cpf=" + cpf + ", nome='" + nome + '\'' +", numero=" + numero +", creditos=" + creditos +", numRecargas=" + numRecargas +'}';
                
               
                
                
                
                
    }

}