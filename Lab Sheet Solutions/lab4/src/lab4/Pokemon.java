/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author ighosh
 */
public class Pokemon {
private int id;
private String name;
private String type;
Pokemon(String pokemon)
{
    if(pokemon.indexOf('|')!=-1)
    {
        this.name = pokemon.substring(0, pokemon.indexOf('|'));
        this.id = Integer.valueOf(pokemon.substring( pokemon.indexOf('|')+1,  pokemon.indexOf('|', pokemon.indexOf('|')+1)));
        this.type= pokemon.substring(pokemon.indexOf('|', pokemon.indexOf('|')+1));        
    }
    else if (pokemon.indexOf(';')!=-1)
    {
        this.id = Integer.valueOf(pokemon.substring(0, pokemon.indexOf('|')));
        this.name = (pokemon.substring( pokemon.indexOf('|')+1,  pokemon.indexOf('|', pokemon.indexOf('|')+1)));
        this.type= pokemon.substring(pokemon.indexOf('|', pokemon.indexOf('|')+1));        
    }
        
}


public int get_id()
{
    return this.id;
}
public String get_name()
{
    return this.name;
}
public String get_type()
{
return this.type;
}
public String getpokemon()
{
    return ("#" + this.id+"\n"+ this.name + "\n"+ this.type);
}
class Pokeball {
private Pokemon pokemon; 
public void set_pokemon(Pokemon x)
{
    this.pokemon = x;
}
public Pokemon get_pokemon()
{
    return this.pokemon;
}


// Pokemon object
/* Complete the Pokeball class by adding proper constructor,
accessor methods and by adding any other method which
are required as per specification */
// Write Your Code From Here
}// End of Pokeball class
}