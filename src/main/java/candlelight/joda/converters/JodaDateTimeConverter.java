package candlelight.joda.converters;

import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Converter;
import org.joda.time.DateTime;
import org.joda.time.contrib.hibernate.*;
import org.hibernate.annotations.Type;


/**
 * Joda DateTime <-> JPA 2.1 converter
 */
@Converter(autoApply = true)
public class JodaDateTimeConverter implements AttributeConverter<DateTime, Date> {


    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public Date convertToDatabaseColumn(DateTime dateTime) {
        return dateTime.toDate();
    }

    public DateTime convertToEntityAttribute(Date date) {
        return new DateTime(date);
    }
}
