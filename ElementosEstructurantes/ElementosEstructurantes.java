package ElementosEstructurantes;
public interface ElementosEstructurantes {

    //(i,j-1),(i,j),(i-1,j)

    /*  x (x) 0
     *  0  x  0
     */
    public void uno();

    //(i,j-1),(i,j),(i+1,j)

    /*  0  x  0
     *  x (x) 0
     */
    public void dos();

    //(i,j-1),(i,j),(i,j+1)

    // *  x  (x)  x
    public void tres();

    //(i-1,j-1),(i,j),(i-1,j+1),(i+1,j-1),(i+1,j+1)
    /*  x  0  x
     *  0 (x) 0
     *  x  0  x
     */
    public void cuatro();

    
}
