package org.cameroncreates;

import com.quiptmc.core.QuiptIntegration;
import com.quiptmc.core.config.Config;
import com.quiptmc.core.config.ConfigManager;
import org.cameroncreates.config.TestConfig;
import org.cameroncreates.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
@EnableScheduling
public class Main extends SpringBootServletInitializer {



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    public static final QuiptIntegration integration = new QuiptIntegration() {
        @Override
        public void enable() {
            if (!dataFolder().exists()) dataFolder().mkdirs();

            TestConfig config = ConfigManager.registerConfig(this, TestConfig.class);
            config.testString = "test2";
            config.save();
        }

        @Override
        public File dataFolder() {
            return new File("data");
        }

        @Override
        public String name() {
            return "Portfolio-website";
        }

        @Override
        public String version() {
            return "v1";
        }
    };
    public static final Main instance = new Main();
    public static final Utils utils = new Utils(integration);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


}
