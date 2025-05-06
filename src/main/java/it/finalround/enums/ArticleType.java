
package it.finalround.enums;
import com.fasterxml.jackson.annotation.JsonValue;
public enum ArticleType{
    NEWS(0), VIDEO(1), FEATURE(2), REVIEW(3);
    private final int db;
    ArticleType(int db){this.db=db;}
    public int getDb(){return db;}
    @JsonValue public String json(){return name();}
    public static ArticleType of(int db){
        for(ArticleType t: values()) if(t.db==db) return t;
        throw new IllegalArgumentException("Unknown id "+db);
    }
}
