package com.rc.core.config;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime o) {
		return o != null ? Timestamp.valueOf(o) : null;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp o) {
		return o != null ? o.toLocalDateTime() : null;
	}
}
