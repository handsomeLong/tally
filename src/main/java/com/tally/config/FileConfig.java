package com.tally.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "/config/file.properties")
@Data
public class FileConfig {

	@Value("${upload_miniqrcode_path}")
	private   String upload_miniqrcode_path;

	@Value("${upload_product_path}")
	private   String upload_product_path;

	@Value("${domain_path}")
	private   String domain_path;

	@Value("${filepath}")
	private   String filepath;



}
