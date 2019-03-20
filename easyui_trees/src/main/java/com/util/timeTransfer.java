package com.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class timeTransfer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jgen.writeString(sdf.format(value));
	}

}
