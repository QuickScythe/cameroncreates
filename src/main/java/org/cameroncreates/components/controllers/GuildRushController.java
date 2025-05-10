package org.cameroncreates.components.controllers;

import com.quiptmc.core.utils.NetworkUtils;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guildrush")
public class GuildRushController {

    @PostMapping("/webhook")
    public String redirectPost(@RequestBody String data) {
        return NetworkUtils.post("http://85.190.130.221:5050/tiltify", new JSONObject(data));
    }
}
