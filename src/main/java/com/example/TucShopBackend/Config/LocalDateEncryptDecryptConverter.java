package com.example.TucShopBackend.Config;

import org.springframework.stereotype.Service;

import javax.persistence.Converter;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.apache.logging.log4j.util.Strings.isEmpty;
@Service
@Converter(autoApply = false)
public class LocalDateEncryptDecryptConverter extends AbstractEncryptDecryptConverter<LocalDate> {

    public LocalDateEncryptDecryptConverter() {
        this(new CipherMaker());
    }

    public LocalDateEncryptDecryptConverter(CipherMaker cipherMaker) {
        super(cipherMaker);
    }

    @Override
    boolean isNotNullOrEmpty(LocalDate attribute) {
        return attribute != null;
    }

    @Override
    LocalDate convertStringToEntityAttribute(String dbData) {
        return isEmpty(dbData) ? null : LocalDate.parse(dbData, ISO_DATE);
    }

    @Override
    String convertEntityAttributeToString(LocalDate attribute) {
        return ((attribute == null) ? null : attribute.format(ISO_DATE));
    }

}
