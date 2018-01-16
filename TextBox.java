import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage img;
    private boolean border = false;
    
    private String text;
    
    private int fontSize;
    
    private Color foreground;
    private Color background;
    
    public TextBox( String message, int fs, boolean hasBorder, Color fg, Color bg )
    {
        //
        fontSize = fs;
        border = hasBorder;
        foreground = fg;
        background = bg;
        text = message;
        
        img = new GreenfootImage( message, fontSize, foreground, background );
        
        display();
    }
    
     /**
     * getText returns the text variable
     * 
     * @param there are no parameters
     * 
     * @return text is returned
     */
    public String getText()
    {
        return text;
    }
    
     /**
     * setText takes a message (string) and makes it into an image
     * 
     * @param message copies the defined text variable
     * 
     * @return message 
     */
    public void setText( String message )
    {
        text = message;
        
        img = new GreenfootImage( text, fontSize, foreground, background );
        
        display();
    }
    
     /**
     * display takes message and makes a greenfootImage, and then displays it
     * 
     * @param there are no parameters
     * 
     * @return Nothing is returned
     */
    private void display()
    {
        //
        if( border == true )
        {
            //
            img.setColor( Color.BLACK );
            
            img.drawRect(0,0, img.getWidth() -1, img.getHeight() -1);
            
        }
        
        setImage( img );
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }    
}
