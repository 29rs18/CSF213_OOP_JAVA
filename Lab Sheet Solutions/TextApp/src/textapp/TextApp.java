/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textapp;

/**
 *
 * @author ighosh
 */
public class TextApp {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args)
{
	Token first = new Token("abc def# def ghi#abc def#ABC def#");
	String[] words = first.Split();
	String[] labels = first.UniqueLabels(words);
	String[] freq;
        freq = first.Count(words, labels);
	first.display(3);
}
  
}
