/* v models se vytvareji jednotlive tridy podle kterych si muzu vytvaret objekty */
/* zde vytvorime objekt Sin */

package models;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Sin {

    private String title;
    private String author;
    private String message;
    private List<String> tags;

    /* napiseme konstruktor podle ktereho si z tridy vytvorime konkretni objekt */
    public Sin(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }
    /* getter a setter pro seznam tags*/
    public List<String> getTags() { return tags; }

    public void setTags(List<String> tags) { this.tags = tags; }


    /* vytvorime 3 gettery (prava mys na title -> generate -> getter) */
    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public String getMessage() { return message; }

    /* vytvorime 3 settery (prava mys na title -> generate -> setter) */
    public void setTitle(String title) { this.title = title; }

    public void setAuthor(String author) { this.author = author; }

    public void setMessage(String message) { this.message = message; }
}
