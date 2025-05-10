package org.cameroncreates.config;

import com.quiptmc.core.QuiptIntegration;
import com.quiptmc.core.config.Config;
import com.quiptmc.core.config.ConfigTemplate;
import com.quiptmc.core.config.ConfigValue;

import java.io.File;

@ConfigTemplate(name = "test")
public class TestConfig extends Config {

    @ConfigValue
    public String testString = "test";

    public TestConfig(File file, String name, ConfigTemplate.Extension extension, QuiptIntegration integration) {
        super(file, name, extension, integration);
    }
}
