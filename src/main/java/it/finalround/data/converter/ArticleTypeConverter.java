
package it.finalround.data.converter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import it.finalround.enums.ArticleType;
@Converter(autoApply=true)
public class ArticleTypeConverter implements AttributeConverter<ArticleType,Integer>{
  @Override public Integer convertToDatabaseColumn(ArticleType attribute){
    return attribute!=null?attribute.getDb():null;
  }
  @Override public ArticleType convertToEntityAttribute(Integer db){
    return db!=null?ArticleType.of(db):null;
  }
}
