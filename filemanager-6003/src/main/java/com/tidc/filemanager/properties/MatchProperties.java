package com.tidc.filemanager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassNmae MatchProperties
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@ConfigurationProperties(prefix = "com.tidc.tao")
public class MatchProperties {
	FileProperties fileProperties = new FileProperties();
}
